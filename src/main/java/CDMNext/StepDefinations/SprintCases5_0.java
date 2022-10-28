package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.File_delete;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SprintCases5_0 {
	WebDriverWait wait = new WebDriverWait(login.driver, 120);
	Actions action = new Actions(login.driver);
	WebElement source_insight;
	Boolean database = false;
	String After_set_lang;
	String source_text, visual_title_text, beforeClick_nextbutton_databriefing_title;
	static String beforeClick_previousbutton_databriefing_title, series_text_inPriviewmode;
	CDMNextSprintCases cdmnext = new CDMNextSprintCases();
	login lgn = new login();
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	String window_header_text;
	String format, Second_databriefing_title, insightName, ExpectedTimeframe;
	String databriefing_link_text_in_ssp, TooltipText;
	Commentary commentary = new Commentary();
	PieVisual pie = new PieVisual();
	SearchTest search = new SearchTest();
	DatabasesTab db = new DatabasesTab();
	Histogram hs = new Histogram();
	Comparables comp = new Comparables();
	SeriesTab st = new SeriesTab();
	ArrayList<String> tabs;
	ArrayList<String> Beforeapply_SortBy_databriefingsList = new ArrayList<>();
	ArrayList<String> Afterapply_SortBy_databriefingsList = new ArrayList<>();
	ArrayList<String> CreatedInsightList = new ArrayList<>();
	Filters filter = new Filters();
	String[] series_id;
	String databriefing_title, Applied_SortBy_filter;
	CollabarationSharing share = new CollabarationSharing();
	List<WebElement> relatedInsight_insightList = null;
	String expected_sname,group_name;

	@And("^Navigate to \"([^\"]*)\"$")
	public void navigate_to(String arg1) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + arg1 + "')]")));
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 10).click();
	}

	@And("^Open insights in table mode$")
	public void open_insights_in_table_mode() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "TableMode", 10).click();
	}

	@And("^Open Myfolders panel$")
	public void open_Myfolders_panel() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "ExpandMyFolder", 10).click();
		CommonFunctionality.wait(500);
		// create a new folder if not exists
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Insights_folder"))).size() == 0) {
			CommonFunctionality.getElementByProperty(login.driver, "Add_new_folder", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "input_text", 10).clear();
			CommonFunctionality.getElementByProperty(login.driver, "input_text", 10).sendKeys("InsightFolder");
			CommonFunctionality.getElementByProperty(login.driver, "Create_folder", 10).click();
		}
		CommonFunctionality.getElementByProperty(login.driver, "All_insights_myFolder", 10).click();
	}

	@And("^Mouse hover on any insight$")
	public void mouse_hover_on_any_insight() throws Throwable {
		CommonFunctionality.wait(500);
		source_insight = CommonFunctionality.getElementByProperty(login.driver, "first_insight", 10);
		source_text = CommonFunctionality.getElementByProperty(login.driver, "first_insight", 10).getText();
		// mousehover on first insight
		action.moveToElement(source_insight).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Drag and drop the insight to the targeted folder$")
	public void drag_and_drop_the_insight_to_the_targeted_folder() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement targeted_folder = CommonFunctionality.getElementByProperty(login.driver, "Insights_folder", 10);
		action.clickAndHold(source_insight).pause(500).dragAndDrop(source_insight, targeted_folder).build().perform();

	}

	@Then("^The insight should be moved to the targetted folder$")
	public void the_insight_should_be_moved_to_the_targetted_folder() throws Throwable {
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByProperty(login.driver, "Insights_folder", 10).click();
		CommonFunctionality.wait(500);
		String target_text = CommonFunctionality.getElementByProperty(login.driver, "Expected_insght", 10)
				.getAttribute("title");
		if (target_text.contains(source_text)) {
			login.Log4j.info("The selected insight has moved to targeted folder");
			CommonFunctionality.getElementByProperty(login.driver, "three_dots", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "delete_insight", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Delete_forever", 10).click();
		} else {
			fail("The selected insight not moved to targeted folder");
		}
	}

	@Then("^Growl popup should be displayed$")
	public void growl_popup_should_be_displayed() throws Throwable {
		String growlText = CommonFunctionality.getElementByProperty(login.driver, "Growl_message", 10).getText();
		login.Log4j.info(growlText);
		if (growlText.contains(source_text)) {
			login.Log4j.info(growlText);
		} else {
			fail("Growl popup is not displayed with successful message");
		}
	}

	@Then("^The tooltip should be \"([^\"]*)\"$")
	public void the_tooltip_should_be(String arg1) throws Throwable {
		String tooltipText = CommonFunctionality.getElementByProperty(login.driver, "Tooltip_text", 10)
				.getAttribute("title");
		if (tooltipText.equalsIgnoreCase(arg1)) {
			login.Log4j.info("Tooltip is displayed");
		} else {
			fail("Tooltip is not dispplayed");
		}
	}

	@Then("^\"([^\"]*)\", \"([^\"]*)\" ,\"([^\"]*)\", \"([^\"]*)\" options should be greyed out$")
	public void options_should_be_greyed_out(String arg1, String arg2, String arg3, String arg4) throws Throwable {
		String CopyAttachment = CommonFunctionality.getElementByProperty(login.driver, "copy_attachment", 10)
				.getAttribute("class");
		if (CopyAttachment.contains("disabled")) {
			login.Log4j.info(arg1 + " option is disabled");
		}

		String CutAttachment = CommonFunctionality.getElementByProperty(login.driver, "cut_attachment", 10)
				.getAttribute("class");
		if (CutAttachment.contains("disabled")) {
			login.Log4j.info(arg2 + " option is disabled");
		}
		if (arg3.equals("Attachments") || arg4.equals("View")) {
			CommonFunctionality.getElementByProperty(login.driver, "rightclick_download", 10).click();
			String Attachments = CommonFunctionality.getElementByProperty(login.driver, "rightclick_attachment", 10)
					.getAttribute("class");
			String View = CommonFunctionality.getElementByProperty(login.driver, "rightclick_view", 10)
					.getAttribute("class");
			if (Attachments.contains("disabled") && View.contains("disabled")) {
				login.Log4j.info(arg3 + " and " + arg4 + " options are disabled");
			}
		}

		/*
		 * List<WebElement> right_click_options = (List<WebElement>)
		 * CommonFunctionality.getElementByProperty(login.driver, "RightClickOptions",
		 * 10); for(int i = 0 ; i < right_click_options.size(); i++) {
		 * if(right_click_options.get(i).getAttribute("title").contentEquals(arg1) ||
		 * right_click_options.get(i).getAttribute("title").contentEquals(arg2)) {
		 * if(right_click_options.get(i).getAttribute("class").contains("disabled")) {
		 * login.Log4j.info(arg1 + " option is greyed out"); } } else
		 * if(right_click_options.get(i).getAttribute("title").contentEquals("Download")
		 * ) { right_click_options.get(i).click();
		 * if(right_click_options.get(i).getAttribute("class").contains("disabled")) {
		 * login.Log4j.info(arg1 + " option is greyed out"); } } }
		 */

	}

	@Then("^The keyboard shortcut info should be displayed for Chart \"([^\"]*)\", Map \"([^\"]*)\" and Table \"([^\"]*)\"$")
	public void the_keyboard_shortcut_info_should_be_displayed_for_Chart_Map_and_Table(String arg1, String arg2,
			String arg3) throws Throwable {
		List<WebElement> list_shortcuts = CommonFunctionality.getElementsByXpath(login.driver,
				"//*[@class='shortcut']");
		for (int i = 0; i < list_shortcuts.size(); i++) {
			if (list_shortcuts.get(i).getText().equals(arg1)) {
				login.Log4j.info("The keyboard shortcut is displayed for Chart as " + arg1);
			} else if (list_shortcuts.get(i).getText().equals(arg2)) {
				login.Log4j.info("The keyboard shortcut is displayed for Map as " + arg2);
			} else if (list_shortcuts.get(i).getText().equals(arg3)) {
				login.Log4j.info("The keyboard shortcut is displayed for Table as " + arg3);
			} else {
				fail(list_shortcuts.get(i).getText() + " shortcut not displayed");
			}
		}
	}

	@And("^Open insight in preview mode$")
	public void open_insight_in_preview_mode() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "file", 10).click();
		CommonFunctionality.getElementByProperty(login.driver, "preview_mode", 10).click();
		CommonFunctionality.getElementByProperty(login.driver, "view2_previewMode", 10).click();
		visual_title_text = CommonFunctionality.getElementByProperty(login.driver, "Visual_Title_Name", 10).getText();

	}

	@And("^Select visual and use Ctrl \\+ C to copy the visual$")
	public void select_visual_and_use_Ctrl_C_to_copy_the_visual() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "select_the_visual", 10).click();
		CommonFunctionality.wait(500);
		action.keyDown(Keys.CONTROL);
		action.sendKeys("c");
		action.keyUp(Keys.CONTROL);
		action.build().perform();
	}

	@Then("^The visual should be copied$")
	public void the_visual_should_be_copied() throws Throwable {
		String growl_popup_text = CommonFunctionality.getElementByProperty(login.driver, "copylink_popup", 10)
				.getText();
		String expectedResult = visual_title_text + " with series copied.";
		if (growl_popup_text.contains(expectedResult)) {
			login.Log4j.info(growl_popup_text);
		} else {
			fail("The growl popup not displayed with series copied");
		}
		CommonFunctionality.getElementByProperty(login.driver, "preivew_mode_close", 10).click();
	}

	@And("^Login to CDMNext$")
	public void login_to_CDMNext() throws Throwable {
		share.logout_from_current_user();
		CommonFunctionality.wait(500);
		CommonFunctionality.login_as_internal_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", "nmaduru@gmail.com", "Ceic@123");
		// CommonFunctionality.wait(500);
		// CommonFunctionality.login_as_internal_user(login.driver,
		// "input[name='user_id']", "input[name='password']",
		// "button[type='submit']", "nmaduru@gmail.com", "Ceic@123");
		/*
		 * URL url = new URL(login.driver.getCurrentUrl());
		 * login.driver.get(url.getProtocol() + "://" + url.getHost() + "/login");
		 * CommonFunctionality.wait(300);
		 * CommonFunctionality.getElementByProperty(login.driver,
		 * "input_username",8).clear();
		 * CommonFunctionality.getElementByProperty(login.driver,"input_username",8)
		 * .sendKeys(login.CONFIG.getProperty("username"));
		 * CommonFunctionality.getElementByProperty(login.driver,"input_password",8).
		 * clear();
		 * CommonFunctionality.getElementByProperty(login.driver,"input_password",8)
		 * .sendKeys(login.CONFIG.getProperty("password"));
		 * CommonFunctionality.getElementByProperty(login.driver,"btnLogin",8).click();
		 * login.driver.navigate().refresh();
		 */
	}

	@And("^Open Data Briefings panel$")
	public void open_Data_Briefings_panel() throws Throwable {
		CommonFunctionality.wait(500);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("collapse_databriefings"))).size() == 1) {
			login.Log4j.info("Data briefings panel displayed in expanded mode");
			CommonFunctionality.getElementByProperty(login.driver, "collapse_databriefings", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "expand_databriefings", 10).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "expand_databriefings", 10).click();
		}

	}

	@And("^Close Data briefings panel$")
	public static void close_Data_briefings_panel() throws Throwable {
		try {
			CommonFunctionality.wait(1500);
			CommonFunctionality.getElementByProperty(login.driver, "collapse_databriefings", 10).click();
		} catch (Exception e) {
			//
		}
	}

	@And("^Logout and relogin$")
	public void logout_and_relogin() throws Throwable {
		share.login_back_to_internal_user("nmaduru@gmail.com", "Ceic@123");
	}

	@Then("^The DB panel should be in closed state$")
	public void the_DB_panel_should_be_in_closed_state() throws Throwable {
		CommonFunctionality.wait(2000);
		boolean DB_panel_closed = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("expand_databriefings"))).isDisplayed();
		if (DB_panel_closed == true) {
			login.Log4j.info("The DB panel is in closed state");
		} else {
			fail("The DB panel is in not closed state");
		}

	}

	@And("^Click on any Data Briefings$")
	public void click_on_any_Data_Briefings() throws Throwable {
		open_Data_Briefings_panel();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "First_databriefings", 10).click();

	}

	@Then("^The specific Data Briefings should open in preview mode$")
	public void the_specific_Data_Briefings_should_open_in_preview_mode() throws Throwable {
		CommonFunctionality.wait(1000);
		boolean preview_mode = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("databrief_preview_mode")))
				.isDisplayed();
		if (preview_mode == true) {
			login.Log4j.info("The specific Data briefings is opened in preview mode");
		} else {
			fail("The specific Data briefings is not opened in preview mode");
		}

	}

	@Then("^The window header should be \"([^\"]*)\"$")
	public void the_window_header_should_be(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String window_header_text = CommonFunctionality.getElementByProperty(login.driver, "Header_text", 10).getText();
		if (window_header_text.equalsIgnoreCase(arg1)) {
			login.Log4j.info("The window header text is " + arg1);
		} else {
			fail("The window header text not matched with " + arg1);
		}
	}

	@And("^Open any Data Briefings$")
	public void open_any_Data_Briefings() throws Throwable {
		open_Data_Briefings_panel();
		beforeClick_previousbutton_databriefing_title = CommonFunctionality
				.getElementByProperty(login.driver, "First_databriefing_title", 10).getText();
		beforeClick_nextbutton_databriefing_title = CommonFunctionality
				.getElementByProperty(login.driver, "Third_databriefings_title", 10).getText();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "Second_databriefings", 10).click();
	}

	@Then("^Next Data Briefings should open in the same preview window$")
	public void next_Data_Briefings_should_open_in_the_same_preview_window() throws Throwable {
		CommonFunctionality.wait(500);
		String AfterClickOnNextButton_datafriefingTitle = CommonFunctionality
				.getElementByProperty(login.driver, "databriefing_title_inPreviewmode", 10).getText();
		if (AfterClickOnNextButton_datafriefingTitle.equalsIgnoreCase(beforeClick_nextbutton_databriefing_title)) {
			login.Log4j.info("Next Data Briefing is opened in the same preview window");
		} else {
			fail("Next Data Briefing is not opened in the same preview window");
		}
	}

	@Then("^The previous Data Briefings should open in the same preview window$")
	public void the_previous_Data_Briefings_should_open_in_the_same_preview_window() throws Throwable {
		CommonFunctionality.wait(500);
		String AfterClickOnPreviousButton_datafriefingTitle = CommonFunctionality
				.getElementByProperty(login.driver, "databriefing_title_inPreviewmode", 10).getText();
		if (AfterClickOnPreviousButton_datafriefingTitle
				.equalsIgnoreCase(beforeClick_previousbutton_databriefing_title)) {
			login.Log4j.info("Previous Data Briefing is opened in the same preview window");
		} else {
			fail("Previous Data Briefing is not opened in the same preview window");
		}
	}

	@And("^Click on series below the visual$")
	public void click_on_series_below_the_visual() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "series_in_previwemode", 10);
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);
		series_text_inPriviewmode = ele.getText();
		ele.click();
	}

	@Then("^The SSP window should open$")
	public void the_SSP_window_should_open() throws Throwable {
		CommonFunctionality.wait(500);
		String series_titleInSSP = CommonFunctionality.getElementByProperty(login.driver, "SSP_seriesname", 10)
				.getText();
		if (series_titleInSSP.equalsIgnoreCase(series_text_inPriviewmode)) {
			login.Log4j.info("The SSP window opened");
		} else {
			fail("The SSP window not opened");
		}
	}

	@And("^Click on download$")
	public void click_on_download() throws Throwable {
		CommonFunctionality.wait(500);
		window_header_text = CommonFunctionality.getElementByProperty(login.driver, "Header_text", 10).getText();
		CommonFunctionality.getElementByProperty(login.driver, "downloadIcon_inPriviewMode", 10).click();

	}

	@Then("^The download popup should open for available series in the DB insight$")
	public void the_download_popup_should_open_for_available_series_in_the_DB_insight() throws Throwable {
		CommonFunctionality.wait(500);
		String DownloadPopup_titletext = CommonFunctionality
				.getElementByProperty(login.driver, "Download_popup_title_text", 10).getText();
		if (DownloadPopup_titletext.equalsIgnoreCase(window_header_text)) {
			login.Log4j.info("Download popup is opened");
		} else {
			fail("Download popup is not opened");
		}
	}

	@Then("^The data should be copied to clipboard$")
	public void the_data_should_be_copied_to_clipboard() throws Throwable {
		CommonFunctionality.wait(500);
		String Clipboard_data = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
				.getData(DataFlavor.stringFlavor);
		login.Log4j.info(Clipboard_data);
		WebElement GrowlPopUp = CommonFunctionality.getElementByProperty(login.driver, "copylink_popup", 4);
		if (GrowlPopUp.isDisplayed()) {
			if (!Clipboard_data.isEmpty()) {
				login.Log4j.info("Data is copied to clipboard");
			} else {
				Assert.fail("Verification failed");
			}
		}
	}

	@And("^Click on \"([^\"]*)\" button in download window$")
	public void click_on_button_in_download_window(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='modal-body sphere-modal__body']//*[contains(text(),'" + arg1 + "')]", 10).click();
	}

	@Then("^The Data should be downloaded$")
	public void the_Data_should_be_downloaded() throws Throwable {
		CommonFunctionality.wait(15000);
		format = "xlsx";
		CommonFunctionality.getTheNewestFile(format);
		File file = CommonFunctionality.theNewestFile;
		FileInputStream fis = new FileInputStream(file);
		// XSSFWorkbook wb = new XSSFWorkbook(fis);
		if (file.exists()) {
			if (file.getName().contains("Data Briefing")) {
				login.Log4j.info(file.getName() + " is downloaded");
			} else {
				Assert.fail(file.getName() + " IS NOT downloaded");
			}

		} else {
			Assert.fail(file + " doesn't exist");
		}
		fis.close();
		File_delete.delete();

	}

	@Then("^The insight link should be copied and growl should be displayed$")
	public void the_insight_link_should_be_copied_and_growl_should_be_displayed() throws Throwable {
		cdmnext.the_message_should_be("Link is copied");

	}

	@And("^Paste link in browser$")
	public void paste_link_in_browser() throws Throwable {
		db.paste_it_in_new_tab();
	}

	@Then("^The Data Briefings should open in the preview mode$")
	public void the_Data_Briefings_should_open_in_the_preview_mode() throws Throwable {
		the_specific_Data_Briefings_should_open_in_preview_mode();
		login.driver.switchTo().window(db.tabs2.get(1)).close();
		login.driver.switchTo().window(db.tabs2.get(0));
	}

	@And("^Click on second Data Briefings$")
	public void click_on_second_Data_Briefings() throws Throwable {
		open_Data_Briefings_panel();
		Second_databriefing_title = CommonFunctionality.getElementByProperty(login.driver, "Second_databriefings", 10)
				.getText();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "Second_databriefings", 10).click();
	}

	@And("^Scroll down till end$")
	public void scroll_down_till_end() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement Related_Databriefings = CommonFunctionality.getElementByProperty(login.driver,
				"RelatedDatabriefings", 10);
		jse.executeScript("arguments[0].scrollIntoView(true);", Related_Databriefings);
	}

	@Then("^Atleast two sections should be displayed if the Data Briefings not related$")
	public void atleast_two_sections_should_be_displayed_if_the_Data_Briefings_not_related() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> list_sections = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("sections")));
		for (int i = 0; i < list_sections.size(); i++) {
			if (list_sections.get(i).getText().contains("Other indicators")) {
				login.Log4j.info(list_sections.get(i).getText() + " section is displayed");
			} else if (list_sections.get(i).getText().contains("other countries")) {
				login.Log4j.info(list_sections.get(i).getText() + " section is displayed");
			} else {
				fail(list_sections.get(i).getText() + " section is not displayed");
			}
		}
	}

	@Then("^Should display (\\d+) links in each section$")
	public void should_display_links_in_each_section(int arg1) throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> list_sections = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("sections")));
		List<WebElement> listOfLinks = null;
		for (int i = 0; i < list_sections.size(); i++) {
			if (list_sections.get(i).getText().contains("Other indicators")) {
				listOfLinks = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("first_listOfLinks")));
				if (listOfLinks.size() == arg1) {
					login.Log4j.info("The first section links size is 3");
				} else {
					fail("verification failed");
				}
			} else if (list_sections.get(i).getText().contains("other countries")) {
				listOfLinks = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("second_listOfLinks")));
				if (listOfLinks.size() == arg1) {
					login.Log4j.info("The second section links size is 3");
				} else {
					fail("verification failed");
				}
			} else {
				fail(list_sections.get(i).getText() + " section is not displayed");
			}
		}
	}

	@And("^Open SSP for series linked with Data Briefings$")
	public void open_SSP_for_series_linked_with_Data_Briefings() throws Throwable {
		click_on_series_below_the_visual();
	}

	@Then("^The related Data Briefings insight's information should available in the SSP of specific series$")
	public void the_related_Data_Briefings_insight_s_information_should_available_in_the_SSP_of_specific_series()
			throws Throwable {
		CommonFunctionality.wait(500);
		String expected_databriefing_link_text = CommonFunctionality
				.getElementByProperty(login.driver, "Databrifieng_Linktext_in_ssp", 10).getText();
		login.Log4j.info(Second_databriefing_title);
		login.Log4j.info(expected_databriefing_link_text);
		if (Second_databriefing_title.contains(expected_databriefing_link_text)) {
			login.Log4j.info(
					"The related Data Briefings insight's information is available in the SSP of specific series");
		} else {
			fail("The related Data Briefings insight's information is  not available in the SSP of specific series");
		}
	}

	@And("^Click on the Data Briefings name$")
	public void click_on_the_Data_Briefings_name() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement ele = CommonFunctionality.getElementByProperty(login.driver, "Databrifieng_Linktext_in_ssp", 10);
		databriefing_link_text_in_ssp = ele.getText();
		ele.click();

	}

	@Then("^The related Data Briefings insight should be opened$")
	public void the_related_Data_Briefings_insight_should_be_opened() throws Throwable {
		CommonFunctionality.wait(500);
		String DatafriefingTitle_in_previewMode = CommonFunctionality
				.getElementByProperty(login.driver, "databriefing_title_inPreviewmode", 10).getText();
		if (DatafriefingTitle_in_previewMode.equalsIgnoreCase(databriefing_link_text_in_ssp)) {
			login.Log4j.info("The Related Data Briefings insight is opened");
		} else {
			fail("The Related Data Briefings insight is not opened");
		}
	}

	@And("^Click on \"([^\"]*)\" below the Data Briefings name$")
	public void click_on_below_the_Data_Briefings_name(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		databriefing_link_text_in_ssp = CommonFunctionality
				.getElementByProperty(login.driver, "Databrifieng_Linktext_in_ssp", 10).getText();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 10).click();

	}

	@And("^Mouse hover on Download icon$")
	public void mouse_hover_on_Download_icon() throws Throwable {
		WebElement downloadIcon = CommonFunctionality.getElementByProperty(login.driver,
				"Databriefing_previewMode_downloadIcon", 10);
		action.pause(500).moveToElement(downloadIcon).build().perform();
		TooltipText = downloadIcon.getAttribute("title");
	}

	@Then("^The tooltip should be displayed as \"([^\"]*)\"$")
	public void the_tooltip_should_be_displayed_as(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase(TooltipText)) {
			login.Log4j.info(arg1 + " tooltip text is displayed when mouse hover");
		} else {
			fail("Tooltip text is not displayed");
		}
	}

	@Then("^Mouse hover on Copylink icon$")
	public void mouse_hover_on_Copylink_icon() throws Throwable {
		WebElement Copy_icon = CommonFunctionality.getElementByProperty(login.driver,
				"Databriefing_previewMode_copyIcon", 10);
		action.pause(500).moveToElement(Copy_icon).build().perform();
		TooltipText = Copy_icon.getAttribute("title");
	}

	@And("^Open the dropdown for sort by$")
	public void open_the_dropdown_for_sort_by() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databriefings_panel_sortBy", 10).click();
	}

	@Then("^The following three sorting options should available in the dropdown$")
	public void the_following_three_sorting_options_should_available_in_the_dropdown(List<String> sortOptions)
			throws Throwable {
		List<WebElement> Actual_sorting_options = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("sortOptions_list")));
		pie.SeriesDataConversionFunctionsList(sortOptions, Actual_sorting_options);
	}

	@And("^Add the series to my series tab and create a new insight$")
	public void add_the_series_to_my_series_tab_and_create_a_new_insight() throws Throwable {
		try {
			//close sort by option if it is selected
			CommonFunctionality.getElementByProperty(login.driver, "CrossIcon_SortBy", 10).click();
		}catch(Exception e) {
			
		}
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "Newinsight_file", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "Create_insight", 20).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
				.click();
		CommonFunctionality.wait(500);
		insightName = CommonFunctionality.getElementByProperty(login.driver, "InsightName", 20).getText();

	}

	@And("^Open Data briefings$")
	public void open_Data_briefings() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Databriefing_title", 20).click();
	}

	@Then("^Your insight should be listed under related insight section$")
	public void your_insight_should_be_listed_under_related_insight_section() throws Throwable {
		CommonFunctionality.wait(5000);
		WebElement related_insight = CommonFunctionality.getElementByProperty(login.driver, "RelatedInsights", 20);
		jse.executeScript("arguments[0].scrollIntoView(true);", related_insight);
		CommonFunctionality.wait(2000);
		List<WebElement> listOfInsights = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("insightName_underRelatedInsights")));
		ArrayList<String> ActualInsights = new ArrayList<>();
		for(int i = 0 ; i < listOfInsights.size(); i++) {
			String str = listOfInsights.get(i).getText();
			ActualInsights.add(str);
			
		}
		if (ActualInsights.contains(insightName)) {
			login.Log4j.info("Insight is listed under related insight section");
			
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The \"([^\"]*)\" panel should be displayed$")
	public void the_panel_should_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(5000);
		String Expected_databriefings_text = CommonFunctionality
				.getElementByProperty(login.driver, "databriefings_panel_text", 20).getText();
		if (Expected_databriefings_text.contains(arg1)) {
			login.Log4j.info("The " + arg1 + " panel is displayed");
		} else {
			fail("The " + arg1 + " panel is not displayed");
		}
	}

	@And("^Search for a series id$")
	public void search_for_a_series_id() throws Throwable {
		open_Data_Briefings_panel();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "First_databriefings", 10).click();
		click_on_series_below_the_visual();
		String seriesID = CommonFunctionality.getElementByProperty(login.driver, "seriesid", 10).getText();
		series_id = seriesID.split(":");
		CommonFunctionality.getElementByProperty(login.driver, "sspwindow_close", 10).click();
		CommonFunctionality.getElementByProperty(login.driver, "Databriefing_panel_close", 10).click();
		filter.user_enters(series_id[1]);

	}

	@Then("^The series id should display in Data briefings ssp window$")
	public void the_series_id_should_display_in_Data_briefings_ssp_window() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "First_databriefings", 10).click();
		click_on_series_below_the_visual();
		String Expected_seriesID = CommonFunctionality.getElementByProperty(login.driver, "seriesid", 10).getText();
		if (Expected_seriesID.contains(series_id[1])) {
			login.Log4j.info("The series id is displayed in ssp window");
		} else {
			fail("Verification failed");
		}
	}

	@And("^Search for a Data briefings title$")
	public void search_for_a_Data_briefings_title() throws Throwable {
		databriefing_title = CommonFunctionality.getElementByProperty(login.driver, "Third_databriefings_title", 10)
				.getText();
		filter.user_enters(databriefing_title);
	}

	@Then("^The Data briefings title should displayed$")
	public void the_Data_briefings_title_should_displayed() throws Throwable {
		CommonFunctionality.wait(1000);
		String Expected_databriefingTitle = CommonFunctionality
				.getElementByProperty(login.driver, "First_databriefing_title", 10).getText();
		if (Expected_databriefingTitle.equals(databriefing_title)) {
			login.Log4j.info("Verification PASS");
		} else {
			fail("Verification failed");
		}
	}

	@Then("^The filters should be matched against Data Briefings's series if there$")
	public void the_filters_should_be_matched_against_Data_Briefings_s_series_if_there() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> databriefings_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("databriefings_list")));
		for (int i = 0; i < databriefings_list.size(); i++) {
			CommonFunctionality.wait(200);
			String databriefing_title = databriefings_list.get(i).getText();
			if (databriefing_title.contains(filter.var)) {
				login.Log4j.info("Selected region name " + filter.var + " is displayed in databriefings title");
			} else {
				fail("Selected region name is not displayed");
			}
		}
	}

	@And("^Select \"([^\"]*)\" option from \"([^\"]*)\" dropdown$")
	public void select_option_from_dropdown(String arg1, String arg2) throws Throwable {
		open_Data_Briefings_panel();
		Applied_SortBy_filter = arg1;
		try {
			CommonFunctionality.getElementByProperty(login.driver, "CrossIcon_SortBy", 10).click();
		} catch(Exception e) {
			
		}
		CommonFunctionality.wait(1000);
		List<WebElement> databriefings_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("databriefings_list")));
		for (int i = 1; i <= 3; i++) {
			CommonFunctionality.wait(200);
			String databriefingsTitle = databriefings_list.get(i).getText();
			Beforeapply_SortBy_databriefingsList.add(databriefingsTitle);

		}
		CommonFunctionality.getElementByProperty(login.driver, "Databriefings_panel_sortBy", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 10).click();

	}

	@Then("^The Data Briefings should displayed in the Top releases$")
	public void the_Data_Briefings_should_displayed_in_the_Top_releases() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> After_applying_SortByTopRelease_databriefings_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("databriefings_list")));
		for (int i = 1; i <= 3; i++) {
			CommonFunctionality.wait(200);
			String databriefingsTitle = After_applying_SortByTopRelease_databriefings_list.get(i).getText();
			Afterapply_SortBy_databriefingsList.add(databriefingsTitle);

		}
		if (!Beforeapply_SortBy_databriefingsList.equals(Afterapply_SortBy_databriefingsList)) {
			login.Log4j.info("The Data Briefings displayed as per the selection");
		} else {
			fail("Verification failed");
		}
		CommonFunctionality.getElementByProperty(login.driver, "CrossIcon_SortBy", 10).click();
	}

	@Then("^The Data Briefings should displayed in the Popularity list$")
	public void the_Data_Briefings_should_displayed_in_the_Popularity_list() throws Throwable {
		the_Data_Briefings_should_displayed_in_the_Top_releases();
	}

	@Then("^The Recently updated Data Briefings should be displayed in the top$")
	public void the_Recently_updated_Data_Briefings_should_be_displayed_in_the_top() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> After_applying_SortByTopRelease_databriefings_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("databriefings_list")));
		for (int i = 1; i <= 3; i++) {
			CommonFunctionality.wait(200);
			String databriefingsTitle = After_applying_SortByTopRelease_databriefings_list.get(i).getText();
			Afterapply_SortBy_databriefingsList.add(databriefingsTitle);

		}
		if (Beforeapply_SortBy_databriefingsList.equals(Afterapply_SortBy_databriefingsList)) {
			login.Log4j.info("The Data Briefings displayed as per the selection");
			CommonFunctionality.getElementByProperty(login.driver, "CrossIcon_SortBy", 10).click();
		} else {
			CommonFunctionality.getElementByProperty(login.driver, "CrossIcon_SortBy", 10).click();
			fail("Verification failed");
		}
		
	}

	@And("^Switch from Data tab to Releases tab$")
	public void switch_from_Data_tab_to_Releases_tab() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "ReleasesTab", 10).click();
	}

	@Then("^The sort by filter should be retained$")
	public void the_sort_by_filter_should_be_retained() throws Throwable {
		CommonFunctionality.wait(2000);
		String expected_sortBy_filter = CommonFunctionality.getElementByProperty(login.driver, "sortby_filterText", 10)
				.getText();
		if (expected_sortBy_filter.equalsIgnoreCase(Applied_SortBy_filter)) {
			login.Log4j.info("The selected sort by filter is retained in Releases tab");
		} else {
			fail("Verification failed");
		}
		CommonFunctionality.getElementByProperty(login.driver, "RemoveSortBy", 10).click();
	}

	@And("^Relogin to CDMNext application$")
	public void relogin_to_CDMNext_application() throws Throwable {
		share.logout_from_current_user();
		CommonFunctionality.wait(500);
		CommonFunctionality.login_as_internal_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", "nmaduru@gmail.com", "Ceic@123");
	}

	@Then("^The last applied sorting should be saved per user$")
	public void the_last_applied_sorting_should_be_saved_per_user() throws Throwable {
		CommonFunctionality.wait(1500);
		String expected_sortBy_filter = CommonFunctionality.getElementByProperty(login.driver, "sortby_filterText", 10)
				.getText();
		if (expected_sortBy_filter.equalsIgnoreCase(Applied_SortBy_filter)) {
			login.Log4j.info("The selected sort by filter is saved");
		} else {
			fail("Verification failed");
		}
		CommonFunctionality.getElementByProperty(login.driver, "CrossIcon_SortBy", 10).click();
	}

	@Then("^The check box for 'Create a chart with serees' should be checked for each download by default$")
	public void the_check_box_for_Create_a_chart_with_serees_should_be_checked_for_each_download_by_default()
			throws Throwable {
		CommonFunctionality.wait(1500);
		boolean checkbox = login.driver
				.findElement(By.xpath(login.LOCATORS.getProperty("IndownloadPopup_CreateAChartWithSeries_checkbox")))
				.isSelected();
		if (checkbox == true) {
			login.Log4j.info("The checkbpx is selected by default");
		} else {
			fail("Verification failed");
		}
	}

	@And("^Search with invalid keyword$")
	public void search_with_invalid_keyword() throws Throwable {
		filter.user_enters("testing");
	}

	@Then("^The \"([^\"]*)\" message should displayed in the panel$")
	public void the_message_should_displayed_in_the_panel(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String ExpectedText = CommonFunctionality.getElementByProperty(login.driver, "NosearchResults", 10).getText();
		if (ExpectedText.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " is displayed");
		} else {
			fail(arg1 + " is not displayed");
		}
	}

	@Then("^The related series should be focused in the Database and the Data Briefings popup should auto closed$")
	public void the_related_series_should_be_focused_in_the_Database_and_the_Data_Briefings_popup_should_auto_closed()
			throws Throwable {
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Databriefing_popup"))).size() == 0) {
			login.Log4j.info("The data briefing popup is auto closed ");
		} else {
			fail("The data briefing popup is not auto closed ");
		}
		CommonFunctionality.wait(500);
		String highlightedText = CommonFunctionality.getElementByProperty(login.driver, "highlightedText_in_db", 10)
				.getText();
		if (highlightedText.equals(SeriesTab.series_text_inPriviewmode)) {
			login.Log4j.info("The related series is focused in the Database");
		} else {
			fail("The related series is not focused in the Database");
		}
	}

	@And("^Add this series to (\\d+) insights$")
	public void add_this_series_to_insights(int arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		CommonFunctionality.ExpandLeft();
//		login.Log4j.info("Clicking on Series tab ");
//		CommonFunctionality.getElementByProperty(login.driver, "Series", 8).click();
		// creating 1st insight
		AddSeriesToSevenInsight();
		// creating 2nd insight
		AddSeriesToSevenInsight();
		// creating 3rd insight
		AddSeriesToSevenInsight();
		// creating 4th insight
		AddSeriesToSevenInsight();
		// creating 5th insight
		AddSeriesToSevenInsight();
		// creating 6th insight
		AddSeriesToSevenInsight();
		// creating 7th insight
		AddSeriesToSevenInsight();
	}

	@And("^Open Data briefings for the series$")
	public void open_Data_briefings_for_the_series() throws Throwable {
		open_Data_briefings();
	}

	@And("^Count the insights under related insight$")
	public void count_the_insights_under_related_insight() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement related_insight = CommonFunctionality.getElementByProperty(login.driver, "RelatedInsights", 20);
		jse.executeScript("arguments[0].scrollIntoView(true);", related_insight);
		CommonFunctionality.wait(1000);
		relatedInsight_insightList = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("insightName_underRelatedInsights")));

	}

	@Then("^The related insight should limit to (\\d+) insights$")
	public void the_related_insight_should_limit_to_insights(int arg1) throws Throwable {
		if (!(CreatedInsightList.size() == relatedInsight_insightList.size())
				&& relatedInsight_insightList.size() == arg1) {
			login.Log4j.info("The Related insights size limit to " + arg1);
		} else {
			fail("The Related insights displaying more than limited size");
		}
	}

	@And("^Select \"([^\"]*)\"int the timeframe$")
	public void select_int_the_timeframe(String arg1) throws Throwable {
		ExpectedTimeframe = arg1;
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='zoom-button button button__sm']//*[contains(text(),'" + arg1 + "')]", 8).click();
		CommonFunctionality.ResetMethod();
	}

	@And("^Switch to a different tab and create a visual$")
	public void switch_to_a_different_tab_and_create_a_visual() throws Throwable {
		hs.create_histogram_visual_with_series();
	}

	@And("^Come back to the previous tab and check for the timeframe selection$")
	public void come_back_to_the_previous_tab_and_check_for_the_timeframe_selection() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View 1']", 8).click();
	}

	@Then("^The selected timeframe should be saved if user switched to some other tabs$")
	public void the_selected_timeframe_should_be_saved_if_user_switched_to_some_other_tabs() throws Throwable {
		String seclectedTimeframe = CommonFunctionality.getElementByProperty(login.driver, "HighlightedTimeframe", 8)
				.getText();
		if (seclectedTimeframe.equals(ExpectedTimeframe)) {
			login.Log4j.info("The selected timeframe is saved if user switched to some other tabs");
		} else {
			fail("Verification failed");
		}
	}

	@And("^Select a series and apply multiple functions$")
	public void select_a_series_and_apply_multiple_functions() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "select_checkbox", 20).click();
		// Applying 1st function
		CommonFunctionality.getElementByProperty(login.driver, "Type_A_Function", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "Round", 20).click();
		// Applying 2nd function
		CommonFunctionality.getElementByProperty(login.driver, "Type_A_Function", 20).click();
		WebElement log = CommonFunctionality.getElementByProperty(login.driver, "LOG", 20);
		jse.executeScript("arguments[0].scrollIntoView(true);", log);
		log.click();
		// Applying 3rd function
		CommonFunctionality.getElementByProperty(login.driver, "Type_A_Function", 20).click();
		WebElement exp = CommonFunctionality.getElementByProperty(login.driver, "EXP", 20);
		jse.executeScript("arguments[0].scrollIntoView(true);", exp);
		exp.click();
		// Applying 4th function
		CommonFunctionality.getElementByProperty(login.driver, "Type_A_Function", 20).click();
		WebElement Recip = CommonFunctionality.getElementByProperty(login.driver, "RECIP", 20);
		jse.executeScript("arguments[0].scrollIntoView(true);", Recip);
		Recip.click();
		// Applying 5th function
		CommonFunctionality.getElementByProperty(login.driver, "Type_A_Function", 20).click();
		WebElement log10 = CommonFunctionality.getElementByProperty(login.driver, "LOG10", 20);
		jse.executeScript("arguments[0].scrollIntoView(true);", log10);
		log10.click();
	}

	@Then("^FX icon will not be disappear$")
	public void fx_icon_will_not_be_disappear() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("FX_icon"))).size() == 1) {
			login.Log4j.info("FX icon is appeared ");
		} else {
			fail("FX icon is not appeared");
		}
	}

	@And("^Mouse hover on the series name$")
	public void mouse_hover_on_the_series_name() throws Throwable {
	
		CommonFunctionality.webDriverwait_keyvalue("Series");
	 CommonFunctionality.getElementByProperty(login.driver, "Series",10).click();
		Thread.sleep(500);
		expected_sname = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10)
				.getText();
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		new Actions(login.driver).moveToElement(series_cb).pause(500).build().perform();
	}

	@And("^Select any check box in that popup$")
	public void select_any_check_box_in_that_popup() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "popup_notification_checkBox", 20).click();
	}

	@Then("^Message \"([^\"]*)\" will be appears and series will be added to the watchlist$")
	public void message_will_be_appears_and_series_will_be_added_to_the_watchlist(String arg1) throws Throwable {
		WebElement element = CommonFunctionality.getElementByProperty(login.driver, "growl_message_popup", 20);
		String confirm_msg = element.getText();
		if (confirm_msg.equals(arg1)) {
			login.Log4j.info(arg1);
		} else {
			fail(arg1 + " is not displayed");
		}
		CommonFunctionality.getElementByProperty(login.driver, "watchlist_tab", 20).click();
		CommonFunctionality.wait(4000);
		String Actual_sname = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='watchlist-series-item']//*[@class='series-item--name']", 10)
				.getText();
		if (expected_sname.equals(Actual_sname)) {
			login.Log4j.info("The series added to the watchlist");
		} else {
			fail("The series not added to the watchlist");
		}

	}

	@And("^Add the series to my series tab$")
	public void add_the_series_to_my_series_tab() throws Throwable {
//		CommonFunctionality.ExpandLeft();
		CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
		CommonFunctionality.webDriverwait_keyvalue("Series");
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		for (int i = 0; i < 2; i++) {
			int j = i + 1;
			CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-list-item--checkbox svg-checkbox'])[" + j + "]", 8).click();
		}

		// click on '+' icon
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='add-to-data-selection--icon'])[1]", 10)
				.click();
	}

	@And("^Select the series from my series tab$")
	public void select_the_series_from_my_series_tab() throws Throwable {
		CommonFunctionality.wait(200);
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='check-all-series']//span[@class='input-control--indicator']", 4);
		action.moveToElement(ele).pause(1000).click().build().perform();
	}

	@And("^Select the currency conversion function$")
	public void select_the_currency_conversion_function() throws Throwable {
		CommonFunctionality.wait(200);
		expected_sname = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='webix_column list-series-name webix_first webix_last']/*[1]//*[@class='series-name-field--text']", 20)
				.getText();
		CommonFunctionality.getElementByProperty(login.driver, "Type_A_Function", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "CURRCONV", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "USD", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "in_millions", 20).click();

	}

	@And("^Apply the function$")
	public void apply_the_function() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Apply_function", 20).click();
	}

	@Then("^The function cannot be applied to series should be displayed along with series name and \"([^\"]*)\" will be  appear$")
	public void the_function_cannot_be_applied_to_series_should_be_displayed_along_with_series_name_and_will_be_appear(
			String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String ActualResult = CommonFunctionality.getElementByProperty(login.driver, "cant_apply_function_msg", 20)
				.getText();
		if (ActualResult.contains("The function cannot be applied to") && ActualResult.contains(expected_sname)
				&& ActualResult.contains("series.") && ActualResult.contains(arg1)) {
			login.Log4j.info(ActualResult + " is displayed");
		} else {
			fail("Verication failed");
		}
	}

	@Then("^Compare the results in database tab and comparables tab$")
	public void compare_the_results_in_database_tab_and_comparables_tab() throws Throwable {
		close_Data_briefings_panel();
		// verifying in databases tab
		login.Log4j.info("Clicking on  Databases tab ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))))
				.click();

		db.select_global_database();
		db.expand_till_series_level();
		Verify_Database_Comparables_tab();
		CommonFunctionality.TopMethod();
		comp.clicking_icon("Comparables");
		// verifying comparables tab
		// Expand 1st one till series level
		CommonFunctionality.getElementByProperty(login.driver, "Expand2ndLevel", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "Expand3rdLevel", 20)
				.click();
		CommonFunctionality
				.getElementByProperty(login.driver, "Expand4thLevel", 20)
				.click();
		Verify_Database_Comparables_tab();

	}

	@Then("^Should be able to display tree mode for serached particular series$")
	public void should_be_able_to_display_tree_mode_for_serached_particular_series() throws Throwable {
		// verifying in databases tab
		login.Log4j.info("Clicking on  Databases tab ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))))
				.click();
		CommonFunctionality.wait(500);
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-item--name']", 10);
		new Actions(login.driver).pause(400).moveToElement(ele).perform();
		CommonFunctionality.wait(800);
		WebElement tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
		String TooltipInfo = tooltip.getText();
		login.Log4j.info("Title information is \n" + TooltipInfo);

		if (TooltipInfo.contains(Mnemonics.mnemonictxt) == true) {
			login.Log4j.info("The database is expanded till series level");
		} else {
			fail("The db is not expanded till series level");
		}

	}

	@Then("^\"([^\"]*)\" word must be there instead see in tree$")
	public void word_must_be_there_instead_see_in_tree(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		String see_in_db = CommonFunctionality.getElementByProperty(login.driver, "see_in_database", 20).getText();
		if (see_in_db.equalsIgnoreCase(arg1)) {
			login.Log4j.info(arg1 + " is displayed in data breifings window");
		} else {
			fail(arg1 + " is not displayed");
		}
	}

	@Then("^Should yield results as \"([^\"]*)\" on table level under database tab$")
	public void should_yield_results_as_on_table_level_under_database_tab(String arg1) throws Throwable {
		close_Data_briefings_panel();
		// verifying in databases tab
		login.Log4j.info("Clicking on  Databases tab ");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Databases_Tab"))))
				.click();
		CommonFunctionality.wait(500);
		// Expand 1st one till table level
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='database-node tree-node'])[1]/*[1]", 20).click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-node-model-id='GLOBAL&&ALL']/*[1]", 20)
				.click();
		CommonFunctionality.wait(500);
		CommonFunctionality
				.getElementByProperty(login.driver, "Expand3rdLevel", 20)
				.click();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver,
				"Expand4thLevel", 20).click();
		CommonFunctionality.wait(500);
		List<WebElement> list_of_tables = login.driver.findElements(By.xpath(
				"//*[@class='tree-node open last-open-node']/following::*//*[@class='name-text']"));
		for (int i = 0; i < list_of_tables.size(); i++) {
			if (list_of_tables.get(i).getText().contains(arg1)) {
				login.Log4j.info(arg1 + " is displayed");
			} else {
				fail(arg1 + " is not displayed");
			}
		}

	}

	@Then("^\"([^\"]*)\" icon for series should not be shows for global key series$")
	public void icon_for_series_should_not_be_shows_for_global_key_series(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10);
		new Actions(login.driver).moveToElement(ele).pause(500).build().perform();
		login.Log4j.info("Clicking on show database icon");
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='series-list-item--action-icons']//span[@title='See in Database']", 4).click();
		st.user_can_selects("Global Key Series Database");
		CommonFunctionality.wait(5000);
		String highlitedEle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'series-list-item__selected series-list-item__highlighted')]//*[@class='series-item--status-icons']",
				4).getText();
		login.Log4j.info(highlitedEle);
		if (!arg1.equals(highlitedEle)) {
			login.Log4j.info(arg1 + " icon for series not shown for global key series");
		} else {
			fail(arg1 + " icon is displayed for global key series");
		}

	}

	@And("^Add some series to my series tab$")
	public void add_some_series_to_my_series_tab() throws Throwable {
		login.Log4j.info("Clicking on  Series tab ");
		WebElement SeriesTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		CommonFunctionality.wait(5000);
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']"));

		for (int i = 0; i < checkBox.size(); i++) {
			// Thread.sleep(500);
			action.moveToElement(checkBox.get(i)).click().build().perform();
			if (i == 4) {
				break;
			}
		}
		// click on '+' icon
		CommonFunctionality.wait(200);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='add-to-data-selection--icon'])[1]", 10)
				.click();
	}

	@And("^Group any of (\\d+) series from right click options$")
	public void group_any_of_series_from_right_click_options(int arg1) throws Throwable {
		//Select 1st series
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'webix_first webix_last')]/*[1]/*/*[1]", 10)
		.click();
		//select 2nd series
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'webix_first webix_last')]/*[2]/*/*[1]", 10)
		.click();
		//Right click on 2nd series
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'webix_first webix_last')]/*[2]/*//*[@class='series-name-field-title']", 10);
		action.moveToElement(ele).pause(500).contextClick().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']//span[@title='Group']/*[2]",10).click();
		CommonFunctionality.wait(200);
		login.driver.findElement(By.id("current-title")).clear();
		CommonFunctionality.wait(200);
		login.driver.findElement(By.id("current-title")).sendKeys("Group1");
		CommonFunctionality.wait(200);
		login.driver.findElement(By.xpath("//*[@class='insight-series-rename--button insight-series-rename--button__apply']")).click();
		CommonFunctionality.wait(200);
		//unselect group checkbox
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-name-wrapper']/*[1]",10).click();
	}

	@And("^Try to group another series from right click option$")
	public void try_to_group_another_series_from_right_click_option() throws Throwable {
		//Select 3rd series
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'webix_first webix_last')]/*[2]/*/*[1]", 10)
		.click();
		//select 4th series
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'webix_first webix_last')]/*[3]/*/*[1]", 10)
		.click();
		//Right click on 2nd series
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'webix_first webix_last')]/*[3]/*//*[@class='series-name-field-title']", 10);
		action.moveToElement(ele).pause(500).contextClick().build().perform();
		WebElement Group = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']//span[@title='Group']/*[2]",10);
		action.moveToElement(Group).pause(300).build().perform();
		//Add group name
		group_name = "Group2";
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-context-manage--search']", 10).sendKeys(group_name);
		// Click on Create new group
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Create new group')]", 10).click();
	}

	@Then("^Group rename popup should not displayed$")
	public void group_rename_popup_should_not_displayed() throws Throwable {
		if (login.driver
				.findElements(
						By.xpath("//*[@class ='insight-series-rename--button insight-series-rename--button__apply']"))
				.size() == 0) {
			login.Log4j.info("Group rename popup is not displayed");
		} else {
			fail("Group rename popup is displayed");
		}
	}

	@Then("^Should be able to crate group$")
	public void should_be_able_to_crate_group() throws Throwable {
		
		String expected_groupname = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='group-name'])[2]", 10).getText();
		if(expected_groupname.equals(group_name)) {
			login.Log4j.info("PASS");
		} else {
			fail("Verification failed");
		}

	}
	@And("^Change UI to chinese$")
	public void change_UI_to_chinese() throws Throwable {
		//Click on profile icon
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='dropdown--button account-menu--button']", 10).click();
		//Select chinese db
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-language='zh']", 10).click();
	}

	@And("^Click on notifications bell icon$")
	public void click_on_notifications_bell_icon() throws Throwable {
		CommonFunctionality.wait(3000);
	   //select notification bell icon
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='user-notifications--icon']", 10).click();
	}

	@And("^Click on \"([^\"]*)\" database$")
	public void click_on_database(String arg1) throws Throwable {
		//select 1st tab
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='tabs__tabs-box']/*[1]", 10).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//table//*[contains(text(),'" + arg1 + "')]", 10).click();
	}

	@Then("^Data must be matched with header shown$")
	public void data_must_be_matched_with_header_shown() throws Throwable {
		CommonFunctionality.wait(15000);
		String preview_header_text = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='insight-preview--header']/*[@class='insight-preview--title text-dots'])[1]", 10).getText();
		CommonFunctionality.wait(5000);
		String visual_template_text = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='insight-preview--views']//*[@class='visual-item-template visual-select-area text-template']//*[@data-name='title'])[1]", 10).getText();
		String EXpectedStr = preview_header_text.replace("-", " ");
		login.Log4j.info(EXpectedStr);
		login.Log4j.info(visual_template_text);
		/*if (search.search_validation(preview_header_text, visual_template_text) == true) {
			login.Log4j.info("Visual template text matched with header shown");
					
		}else {
			fail("Visual template text not matched with header shown");
		}*/
		
		if(EXpectedStr.equals(visual_template_text)) {
			login.Log4j.info("Visual template text matched with header shown");
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='insight-preview--close'])[1]", 10).click();
			//Click on profile icon
					CommonFunctionality.getElementByXpath(login.driver, "//*[@class='dropdown--button account-menu--button']", 10).click();
			//select db as english
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-language='en']", 10).click();
		} else {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='insight-preview--close'])[1]", 10).click();
			//Click on profile icon
					CommonFunctionality.getElementByXpath(login.driver, "//*[@class='dropdown--button account-menu--button']", 10).click();
			//select db as english
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-language='en']", 10).click();
			fail("Visual template text not matched with header shown");
		}
		
	}

	@And("^Select the series and create a pie visual$")
	public void select_the_series_and_create_a_pie_visual() throws Throwable {
		CommonFunctionality.ExpandLeft();
		login.Log4j.info("Clicking on  Series tab ");
		WebElement SeriesTab = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty("Series"))));
		SeriesTab.click();
		CommonFunctionality.wait(1000);
		List<WebElement> checkBox = login.driver
				.findElements(By.xpath("//div[@class='series-list-item--checkbox-wrapper']"));
		List<WebElement> sName = login.driver.findElements(By.xpath("//*[@class='series-item--name']"));
		for (int i = 0; i <= checkBox.size(); i++) {
			
			if(i == checkBox.size()) {
				int j = i - 1 ;
				action.contextClick(sName.get(j)).build().perform();
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View as ...']", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Pie']", 10).click();
			} else {
				action.moveToElement(checkBox.get(i)).click().build().perform();
			}
		}

	}

	@And("^Apply visual with \"([^\"]*)\" from function wizard$")
	public void apply_visual_with_from_function_wizard(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
	    //Right click on pie visual title
		WebElement visual_title = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 10);
		action.pause(500).contextClick(visual_title).build().perform();
		//Select calculate series
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Calculate series')]", 10).click();
		//select All functions
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All functions')]", 10).click();
		//select X13ARIMA function
		WebElement function = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-id='" + arg1 + "']", 10);
		CommonFunctionality.wait(500);
		jse.executeScript("arguments[0].scrollIntoView(true);", function);
		function.click();
		//Click on Insert function button
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Insert function')]", 10).click();
		//Click on Apply button
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='function-wizard--footer-buttons']//*[contains(text(),'Apply')]", 10).click();
	}

	@Then("^Should be able to recognize which series are unable to applied with X(\\d+) arima$")
	public void should_be_able_to_recognize_which_series_are_unable_to_applied_with_X_arima(int arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		String str = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='modal-title sphere-modal__title text-dots']", 10).getText();
		if(str.equals("The function cannot be applied to all selected series")) {
			String unable_to_applied_series = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='modal-body sphere-modal__body']", 10).getText();
			login.Log4j.info(unable_to_applied_series);
		} else {
			fail("verification failed");
		}
	}
	@And("^Create a chart visual with \"([^\"]*)\"$")
	public void create_a_chart_visual_with(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver,"Search",10).sendKeys(arg1);
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		CommonFunctionality.wait(2000);
		WebElement sname = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--name']", 10);
		action.moveToElement(sname).pause(200).perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View as Chart. Type `c`']", 10).click();
	}

	@And("^Create a pie visual with \"([^\"]*)\"$")
	public void create_a_pie_visual_with(String arg1) throws Throwable {
		CommonFunctionality.ResetMethod();
		pie.SelectSeries(arg1);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-title='Pie']", 4).click();
		CommonFunctionality.wait(2000);
		//if series harmonization popup opened
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Apply')]", 4).click();
		} catch(Exception e) {
			//
		}
		
	}

	@And("^Create a country filter in the same view$")
	public void create_a_country_filter_in_the_same_view() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-instance='filter']", 20).click();
	}

	@And("^Select the filter with \"([^\"]*)\"$")
	public void select_the_filter_with(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
	   WebElement All_countries = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All countries')]", 20);
	   jse.executeScript("arguments[0].scrollIntoView(true);", All_countries);
	   All_countries.click();
	   CommonFunctionality.getElementByXpath(login.driver, "//*[@class='custom-select--body']//*[@title='" + arg1 + "']", 20).click();
	}

	@Then("^Date picker dropdown should not be available which does not have korea country series$")
	public void date_picker_dropdown_should_not_be_available_which_does_not_have_korea_country_series() throws Throwable {
	   WebElement no_data_displayed_forSelectedPeriod = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'No data for the selected period')]",10);
	   CommonFunctionality.wait(1000);
	   jse.executeScript("arguments[0].scrollIntoView(true);", no_data_displayed_forSelectedPeriod);
	   CommonFunctionality.wait(1000);
	   no_data_displayed_forSelectedPeriod.click();
	   if(login.driver.findElements(By.xpath("//*[@class='insight-visuals-row']//*[contains(@class,'insight-visual__selected')]//*[@class='visual-item-template--row']")).size() == 0) {
		   login.Log4j.info("Date picker dropdown not available");
	   } else {
		   fail("Date picker dropdown is available");
	   }
	   
	   
	}
	@Then("^The Databases language should be changed to as per the selected language$")
	public void the_Databases_language_should_be_changed_to_as_per_the_selected_language() throws Throwable {
		//CommonFunctionality.ResetMethod();
		filter.user_enters("India");
		WebElement dbele;
		CommonFunctionality.wait(3000);
		if (DatabasesTab.dbase.equalsIgnoreCase("World Trend Plus")) {
			dbele = login.driver.findElement(By.xpath(
					"//div[@data-node-model-id='WORLD']//span[@class='name-text']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.pause(2000).contextClick(dbele).build().perform();

		} else if (DatabasesTab.dbase.equalsIgnoreCase("Russia Premium Database")) {
			dbele = login.driver.findElement(By.xpath(
					"//div[@data-node-model-id='RUSSIA']//span[@class='name-text']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.pause(1500).contextClick(dbele).build().perform();

		} else if (DatabasesTab.dbase.equalsIgnoreCase("Global Database")) {
			dbele = login.driver.findElement(By.xpath("//ul[@class='search-series-list scrollable']/*[1]//div[@class='series-item--name']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			action.pause(1500).contextClick(db.rightClickElement).build().perform();

		} else {
			login.driver.findElement(By.xpath("//div[@data-node-model-id='INDONESIA']//div[@class='toggle']")).click();
			dbele = login.driver.findElement(By.xpath(
					"//div[@data-node-model-id='INDONESIA']//span[@class='name-text']"));
			After_set_lang = dbele.getText();
			login.Log4j.info("After_set_lang is " + After_set_lang);
			database = true;
			// After validation changing set language as English
			CommonFunctionality.wait(2000);
			WebElement rightClickEle = login.driver.findElement(
					By.xpath("//div[@data-node-model-id='INDONESIA']//span[contains(text(),'Indonesia Premium Database')]"));
			action.pause(2000).contextClick(rightClickEle).build().perform();
		}
		db.SetLangugeEnglish();
		if (database == true && !DatabasesTab.Before_set_lang.equals(After_set_lang) == true) {
			login.Log4j.info(DatabasesTab.Before_set_lang + " is changed as " + After_set_lang);
		} else {
			AssertJUnit.fail("The Databases language is not changed to selected language");
		}
		//CommonFunctionality.CollapseTreeMethod();
	}

	void AddSeriesToSevenInsight() throws Exception {
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "Newinsight_file", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "Create_insight", 20).click();
		CommonFunctionality.wait(1000);
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
				.click();
		CommonFunctionality.wait(500);
		insightName = CommonFunctionality.getElementByProperty(login.driver, "InsightName", 20).getText();
		CreatedInsightList.add(insightName);
	}

	void Verify_Database_Comparables_tab() throws Exception {
		//WebElement ul_element = null;
		try {
			CommonFunctionality.wait(2000);
//			ul_element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("UL")));
			List<WebElement> li_All =  login.driver.findElements(By.xpath("//*[@class='data-representation']//div[@unselectable='on']"));
			login.Log4j.info("List size is :" + li_All.size());
			List<WebElement> sName = login.driver
					.findElements(By.xpath("//*[@unselectable='on']//*[@class='series-item--name']"));
			WebElement tooltip = null;
			if (sName.size() > 0) {
				for (int i = 0; i < sName.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(sName.size());
					try {
						action.pause(700).moveToElement(sName.get(i)).build().perform();
						CommonFunctionality.wait(700);
						tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					} catch (Exception e) {
						action.pause(1000).moveToElement(sName.get(i)).build().perform();
						CommonFunctionality.wait(700);
						tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
						CommonFunctionality.wait(300);

					}

					String TooltipInfo = tooltip.getText();
					login.Log4j.info("Title information is \n" + TooltipInfo);
					Boolean KeywordMatch = false;
					if (TooltipInfo.toLowerCase().contains("auto") || TooltipInfo.toLowerCase().contains("automobile")
							|| TooltipInfo.toLowerCase().contains("vehicle")
							|| TooltipInfo.toLowerCase().contains("car")) {
						login.Log4j.info("Auto OR Auotomobile OR Vehicle OR Car exists in tooltip");
						KeywordMatch = true;
					} else if (KeywordMatch == false) {
						sName.get(i).click();
						List<WebElement> series_Info = login.driver
								.findElements(By.xpath(login.LOCATORS.getProperty("seriesInfo")));
						for (WebElement list : series_Info) {
							String SeriesInfo = list.getText();
							if (SeriesInfo.toLowerCase().contains("auto") || SeriesInfo.toLowerCase().contains("automobile")
									|| SeriesInfo.toLowerCase().contains("car")
									|| SeriesInfo.toLowerCase().contains("vehicle")) {
								login.Log4j.info("Auotomobile OR Vehicle OR Car exists in ssp");
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();

							} else {
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
								fail("Auto OR Auotomobile OR Vehicle OR Car doesn't exists in ssp");
							}
						}
					} else {
						fail("Auto OR Auotomobile OR Vehicle OR Car doesn't exists in tooltip");
					}

					jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
				}
			} else {
				List<WebElement> listOfName = login.driver
						.findElements(By.xpath("(//*[@class='tree-node full-expanded open'])[3]/following::*[@unselectable='on']//*[@class='series-item--name']"));
				for (int i = 0; i < sName.size(); i++) {
					login.Log4j.info(i);
					login.Log4j.info(sName.size());
					try {
						action.pause(700).moveToElement(sName.get(i)).build().perform();
						CommonFunctionality.wait(700);
						tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
					} catch (Exception e) {
						action.pause(1000).moveToElement(sName.get(i)).build().perform();
						CommonFunctionality.wait(700);
						tooltip = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text")));
						CommonFunctionality.wait(300);

					}

					String TooltipInfo = tooltip.getText();
					login.Log4j.info("Title information is \n" + TooltipInfo);
					Boolean KeywordMatch = false;
					if (TooltipInfo.toLowerCase().contains("auto") || TooltipInfo.toLowerCase().contains("automobile")
							|| TooltipInfo.toLowerCase().contains("vehicle")
							|| TooltipInfo.toLowerCase().contains("car")) {
						login.Log4j.info("Auto OR Auotomobile OR Vehicle OR Car exists in tooltip");
						KeywordMatch = true;
					} else if (KeywordMatch == false) {
						sName.get(i).click();
						List<WebElement> series_Info = login.driver
								.findElements(By.xpath(login.LOCATORS.getProperty("seriesInfo")));
						for (WebElement list : series_Info) {
							String SeriesInfo = list.getText();
							if (SeriesInfo.toLowerCase().contains("auto") || SeriesInfo.toLowerCase().contains("automobile")
									|| SeriesInfo.toLowerCase().contains("car")
									|| SeriesInfo.toLowerCase().contains("vehicle")) {
								login.Log4j.info("Auotomobile OR Vehicle OR Car exists in ssp");
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();

							} else {
								CommonFunctionality.getElementByProperty(login.driver, "closeAction", 10).click();
								fail("Auto OR Auotomobile OR Vehicle OR Car doesn't exists in ssp");
							}
						}
					} else {
						fail("Auto OR Auotomobile OR Vehicle OR Car doesn't exists in tooltip");
					}

					jse.executeScript("arguments[0].scrollIntoView(true);", sName.get(i));
				}
			}

		} catch (NoSuchElementException e) {

			Assert.fail(e.getMessage());

		} catch (StaleElementReferenceException | ElementNotVisibleException e) {

			Assert.fail("The WebElement is not visisble! " + e.getMessage());
		}
	}
}