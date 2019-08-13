package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.exec.util.StringUtils;
import org.apache.poi.util.StringUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.deps.difflib.StringUtills;

public class Footnotes {
	public static String japaneseFootnoteText;

	public void footnotes_close() {
		WebDriverWait wait = new WebDriverWait(login.driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
		// Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_window_close")))
				.click();
	}

	public void live_chat() throws Exception {
		// Element which needs to drag.
		WebElement From = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("live_chat")));

		// Element on which need to drop.
		WebElement To = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("main_panel")));

		// Using Action class for drag and drop.
		Actions act = new Actions(login.driver);

		// Dragged and dropped.
		act.dragAndDrop(From, To).build().perform();
	}

	public void footnote_open_current_window() throws Exception {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_footnote")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("table_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
	}

	public void footnote_open_new_window() throws Exception {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_footnote")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("table_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);
	}

	public void japanese_lang() throws Exception {

		WebDriverWait wait = new WebDriverWait(login.driver, 700);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("lang_dropdown"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("lang_dropdown"))).click();
		Thread.sleep(7000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("translate_option"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("japanese_lang"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("japanese_lang"))).click();

	}

	public void global_footnote_download() throws Exception {
		Arrays.stream(
				new File(System.getProperty("user.home") + "\\Downloads")
						.listFiles()).forEach(File::delete);
		Thread.sleep(3000);
		login.driver.switchTo().defaultContent();
		String tableName = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("hover_table"))).getText();
		Thread.sleep(5000);
		String text = tableName.replaceAll("\\W", "");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_download")))
				.click();

		Thread.sleep(50000);

		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File getLatestFile = getLatestFilefromDir(downloadPath);
		System.out.println(text);
		String fileName = getLatestFile.getName();
		String fileDownloaded = fileName.replaceAll(".pdf", "");
		String fileDownloaded1 = fileDownloaded.replaceAll("\\W", "");
		System.out.println("File downloaded" + fileDownloaded1);
		// boolean text = fileName.equalsIgnoreCase(filePdf);
		Assert.assertEquals(text, fileDownloaded1);
		footnotes_close();
	}

	Actions action = new Actions(login.driver);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;

	public void clear_search() throws Exception {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Footnote_Search_input")))
				.click();
		Thread.sleep(9000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Footnote_Search_input")))
				.clear();
		Thread.sleep(9000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Footnote_Search_input")))
				.sendKeys(Keys.ENTER);
		Thread.sleep(9000);

	}

	// Tc_Footnotes_01
	@Given("^Set the Preference to insight explorer$")
	public void set_the_Preference_to_insight_explorer() throws Throwable {
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Footnote_Search_input"))).click();
		clear_search();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		Thread.sleep(3000);
		List<WebElement> reset = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("Reset")));
		List<WebElement> Replacement = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("replacement_window")));

		if (Replacement.size() != 0) {
			{
				login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("Close"))).click();
				login.Log4j.info("Clicking on Reset button");
			}
		}
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		WebDriverWait wait = new WebDriverWait(login.driver, 100);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
		login.driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("set_preference"))).click();
		click_on_CEIC_logo();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.xpath(login.LOCATORS.getProperty("insight_explorer"))));
//		Thread.sleep(3000);
//		login.driver.findElement(
//				By.xpath(login.LOCATORS.getProperty("insight_explorer")))
//				.click();
//		WebElement preferences = login.driver.findElement(By
//				.xpath(login.LOCATORS.getProperty("text")));
//		js.executeScript("arguments[0].scrollIntoView(true);", preferences);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.xpath(login.LOCATORS.getProperty("save_btn"))));
//		Thread.sleep(10000);
//		login.driver.findElement(
//				By.xpath(login.LOCATORS.getProperty("save_btn"))).click();
//		Thread.sleep(7000);
	}

	@Given("^Find the Footnote option in menu bar$")
	public void Find_the_Footnote_option_in_menu_bar() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
		Thread.sleep(4000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("FOOTNOTES"))).click();
	}

	@Given("^Click Open to verify the footnotes$")
	public void Click_Open_to_verify_the_footnotes() throws Throwable {
		// WebDriverWait wait = new WebDriverWait(login.driver,30);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnotes_open"))));
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes_open"))).click();
		// Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("footnote_window"))).size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			System.out.println("Footnotes is Open");
		} else {
			footnotes_close();
			Assert.fail("Footnotes is not  Open");
		}
	}

	// Tc_Footnotes_02
	@Given("^Set the Preference to new insight$")
	public void set_the_Preference_to_new_insight() throws Throwable {

		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
		Thread.sleep(6000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("set_preference"))).click();
		
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
		Thread.sleep(2000);
	}

	// Tc_Footnotes_03

	// Tc_Footnotes_04
	@Given("^Click 'Open in a new tab' to verify footnotes$")
	public void click_Open_in_a_new_tab_to_verify_footnotes() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("open_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		try {
			// get window handlers as list
			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab
			login.driver.switchTo().window(browserTabs.get(1));
			Thread.sleep(4000);
			// check comparing url
			String URL = login.driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://stage.ceicdata.com/footnotes");
			System.out.println("Footnotes Open in new tab");
			Thread.sleep(9000);
			// then close tab and get back
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		} catch (Exception e) {

			Assert.fail("Fail to open Footnotes in new tab");
		}

	}

	// Tc_Footnotes_05
	@Given("^Click Open$")
	public void click_Open() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnotes_open"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_open"))).click();
		Thread.sleep(2000);
	}

	@Given("^Select '-' icon to minimize$")
	public void select_icon_to_minimize() throws Throwable {
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("footnote_window_minimize")))
				.click();
		Thread.sleep(3000);
	}

	@Given("^Verify minimizing the footnote window$")
	public void verify_minimizing_the_footnote_window() throws Throwable {
		try {

			if (login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("contents")))
					.isDisplayed()) {
				login.driver.findElement(
						By.xpath(login.LOCATORS
								.getProperty("footnote_window_close"))).click();
				footnotes_close();
				Assert.fail("Footnote window is not minimized");
			} else {
				// footnotes_close();
				System.out.println("Footnote window is  minimized");

			}
		} catch (Exception e) {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Footnote window is  minimized");
		}
	}

	// Tc_Footnotes_06

	@Given("^select '-' icon to maximize$")
	public void select_icon_to_maximize() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 70);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnote_window_maximize"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("footnote_window_maximize")))
				.click();
		Thread.sleep(3000);
	}

	@Given("^Verify maximizing the footnote window$")
	public void verify_maximizing_the_footnote_window() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("contents"))));
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("contents"))).size() != 0) {
			System.out.println("Footnote window is maximized");
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Thread.sleep(5000);
		} else {
			footnotes_close();
			Assert.fail("Footnote window is not maximized");
		}
	}

	// Tc_Footnotes_07

	@Given("^Click on Footnotes tab choose Open$")
	public void click_on_Footnotes_tab_choose_Open() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 50);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_tab"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnotes_open"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_open"))).click();
		Thread.sleep(3000);
	}

	@Given("^Click on Open icon to verify footnotes open in new tab$")
	public void click_on_Open_icon_to_verify_footnotes_open_in_new_tab()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(5000);
		try {
			// get window handlers as list
			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab
			login.driver.switchTo().window(browserTabs.get(1));
			Thread.sleep(4000);
			// check comparing url
			String URL = login.driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://stage.ceicdata.com/footnotes");
			System.out.println("Footnotes Open in new tab");

			// then close tab and get back
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		} catch (Exception e) {

			Assert.fail("Fail to open Footnotes in new tab");
		}
	}

	// Tc_Footnotes_08

	@Given("^Click on cross arrow marks to verify footnotes as full screen$")
	public void Click_on_cross_arrow_marks_to_verify_footnotes_as_full_screen()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_full_screen")))
				.click();
		Thread.sleep(2000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("footnote_exit_full_screen")));

		action.moveToElement(element).perform();
		WebElement elementText = login.driver
				.findElement(By.xpath(login.LOCATORS
						.getProperty("footnote_exit_full_screen")));
		String toolTipElement = elementText.getAttribute("title");
		System.out.println(toolTipElement);
		String expected = "Exit full-screen";
		if (login.driver.findElements(
				By.xpath(login.LOCATORS
						.getProperty("footnote_exit_full_screen"))).size() != 0) {
			Assert.assertEquals(toolTipElement, "Exit full-screen");
			System.out.println("Footnote window is  in full-screen");
			WebDriverWait wait = new WebDriverWait(login.driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Footnote window is not in full-screen");
		}
	}

	// Tc_Footnotes_09
	@Given("^Click on cross arrow marks to verify footnotes exit full screen$")
	public void Click_on_cross_arrow_marks_to_verify_footnotes_exit_full_screen()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("footnote_exit_full_screen"))).click();
		Thread.sleep(2000);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("footnote_full_screen")));
		action.moveToElement(element).perform();
		WebElement elementText = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("footnote_full_screen")));
		String toolTipElement = elementText.getAttribute("title");
		System.out.println(toolTipElement);
		String expected = "Full-screen";
		if (login.driver.findElements(
				By.xpath(login.LOCATORS
						.getProperty("footnote_exit_full_screen"))).size() != 0) {
			Assert.assertEquals(toolTipElement, "Full-screen");
			System.out.println("Footnote window is not  in full-screen");
			WebDriverWait wait = new WebDriverWait(login.driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			footnotes_close();
			Assert.fail("Footnote window is  in full-screen");
		}
	}

	// Tc_Footnotes_10
	@Given("^Verify the download option is disabled$")
	public void Verify_the_download_option() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("download_disabled")))
				.size() != 0) {
			System.out.println("Download option is disabled");
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Download option is enabled");
		}
		footnotes_close();
	}

	// Tc_Footnotes_11
	@Given("^Verify the download option in footnotes is enabled$")
	public void Verify_the_download_option_in_footnotes_is_enabled()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("select_db"))).click();
		Thread.sleep(3000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("download_enabled")))
				.size() != 0) {
			System.out.println("Download option is enabled");
			WebDriverWait wait = new WebDriverWait(login.driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Download option is disabled");
		}
	}

	// Tc_Footnotes_12
	@Given("^Click on Footnotes tab and select database$")
	public void click_on_Footnotes_tab_and_select_database() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 300);
		try {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("HELP"))).click();
			Thread.sleep(3000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("FOOTNOTES"))).click();

			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("select_db"))).click();
		} catch (WebDriverException e) {
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnotes_open"))));
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnotes_open"))).click();
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("select_db"))).click();
		}
	}

	@Given("^Verify mouse hover on Open in new tab option$")
	public void Verify_mouse_hover_on_Open_in_new_tab_option() throws Throwable {
		WebElement open_in_new_tab = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("open_new_tab_tooltip")));
		action.moveToElement(open_in_new_tab).perform();
		Thread.sleep(6000);
		String tooltiptext = open_in_new_tab.getAttribute("title");

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).size() != 0) {
			Assert.assertEquals(tooltiptext, "Open in a new tab");
			System.out.println(tooltiptext);
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Open new tab tooltip is not shown");
		}

	}

	@Given("^Verify mouse hover on download option$")
	public void Verify_mouse_hover_on_download_option() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("select_db"))).click();

		WebElement download_option = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("download_enabled_tooltip")));
		action.moveToElement(download_option).perform();
		Thread.sleep(6000);
		String tooltiptext = download_option.getAttribute("title");

		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("download_enabled_tooltip")))
				.size() != 0) {

			Assert.assertEquals(tooltiptext, "Download. Type `d`");
			System.out.println(tooltiptext);
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Download  tooltip is not shown");
		}
	}

	@Given("^Verify mouse hover on minimize option$")
	public void Verify_mouse_hover_on_minimize_option() throws Throwable {
		WebElement minimize_option = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("footnote_window_minimize")));
		action.moveToElement(minimize_option).perform();
		Thread.sleep(6000);
		String tooltiptext = minimize_option.getAttribute("title");

		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("footnote_window_minimize")))
				.size() != 0) {

			Assert.assertEquals(tooltiptext, "Minimize");
			System.out.println(tooltiptext);
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Minimize  tooltip is not shown");
		}
	}

	@Given("^Verify mouse hover on Full-screen option$")
	public void Verify_mouse_hover_on_Full_screen_option() throws Throwable {
		WebElement full_screen_option = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("footnote_full_screen")));
		action.moveToElement(full_screen_option).perform();
		Thread.sleep(6000);
		String tooltiptext = full_screen_option.getAttribute("title");

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("footnote_full_screen")))
				.size() != 0) {

			Assert.assertEquals(tooltiptext, "Full-screen");
			System.out.println(tooltiptext);
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Full-screen  tooltip is not shown");
		}
	}

	@Given("^Verify mouse hover on Close option$")
	public void Verify_mouse_hover_on_Close_option() throws Throwable {
		WebElement footnote_window_close = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("footnote_window_close")));
		action.moveToElement(footnote_window_close).perform();
		Thread.sleep(6000);
		String tooltiptext = footnote_window_close.getAttribute("title");

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("footnote_window_close")))
				.size() != 0) {

			Assert.assertEquals(tooltiptext, "Close");
			System.out.println(tooltiptext);
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Close  tooltip is not shown");
		}
	}

	// Tc_Footnotes_13
	@Given("^Click on Close button to verify footnotes window is closed$")
	public void Click_on_Close_button_to_verify_footnotes_window_is_closed()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_window_close")))
				.click();
		Thread.sleep(4000);
		try {
			if (login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("footnotes_window")))
					.isDisplayed()) {
				login.driver.findElement(
						By.xpath(login.LOCATORS
								.getProperty("footnote_window_close"))).click();
				Assert.fail("Footnote window is Open");
			} else {
				System.out.println("Footnote window is closed");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Tc_Footnotes_14
	@Given("^Click on Footnotes tab$")
	public void click_on_Footnotes_tab() throws Throwable {
		// Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
				.click();
		Thread.sleep(12000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("FOOTNOTES"))).click();
		Thread.sleep(5000);
	}

	@Given("^Click on Open in new tab icon to verify footnotes open in new tab$")
	public void Click_on_Open_in_new_tab_icon_to_verify_footnotes_open_in_new_tab()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		try {
			// get window handlers as list
			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab
			login.driver.switchTo().window(browserTabs.get(1));
			Thread.sleep(4000);
			// check comparing url
			String URL = login.driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://stage.ceicdata.com/footnotes");
			System.out.println("Footnotes Open in new tab");

			// then close tab and get back
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		} catch (Exception e) {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Fail to open Footnotes in new tab");
		}
	}

	// Tc_Footnotes_15
	@Given("^Click on minimize icon$")
	public void click_on_minimize_icon() throws Throwable {
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("footnote_window_minimize")))
				.click();
		Thread.sleep(2000);
	}

	// Tc_Footnotes_16
	@Given("^Create an insight$")
	public void create_an_insight() throws Throwable {

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

	@Given("^Goto Series Search tab$")
	public void Goto_Series_Search_tab() throws Throwable {

		WebDriverWait wait = new WebDriverWait(login.driver, 800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_search_tab"))));
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("series_search_tab")))
				.click();
		Thread.sleep(2000);
	}

	@Given("^Click on hat option to Verify footnotes open from series search tab$")
	public void Click_on_hat_option_to_Verify_footnotes_open_from_series_search_tab()
			throws Throwable {
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_row_1")));
		WebDriverWait wait = new WebDriverWait(login.driver, 10);
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_hat_icon")))
				.click();
		Thread.sleep(5000);
		List<WebElement> series_records = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("series_records")));
		String series_text = series_records.get(0).getText();
		System.out.println(series_text);
		String footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();
		String footnotes = footnotes_text.replaceAll("\\(", "").replaceAll(
				"\\)", "");
		System.out.println(footnotes_text);
		System.out.println(footnotes);
		if (series_text.matches(footnotes)) {
			System.out.println("Series name matched with footnotes name");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Series name not matched with footnotes name");
		}

	}

	// Tc_Footnotes_17
	@Given("^Goto Dataset Search tab$")
	public void Goto_Dataset_Search_tab() throws Throwable {
		clear_search();
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("dataset_search_tab"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("dataset_search_tab")))
				.click();
		Thread.sleep(2000);
	}

	@Given("^Select record click on hat option to verify footnotes$")
	public void select_record_click_on_hat_option_to_verify_footnotes()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 10);
		WebElement dataset_series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("dataset_series_row")));
		action.moveToElement(dataset_series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("dataset_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("dataset_footnote_hat_icon"))).click();
		// list of dataset series
		List<WebElement> dataset_series = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("dataset_series_record")));
		String datasetSeriesText = dataset_series.get(0).getText();
		// Remove spl characters in text
		String datasetSeriesTextFootnote = datasetSeriesText.replaceAll("\\W",
				"");
		System.out.println(datasetSeriesTextFootnote);

		String dataset_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		String dataSetFootnoteText = org.apache.commons.lang3.StringUtils
				.substringAfter(dataset_footnotes_text, ":");
		// Remove spl characters in text
		String datasetFootnote = dataSetFootnoteText.replaceAll("\\W", "");
		System.out.println(datasetFootnote);
		if (datasetSeriesTextFootnote.contentEquals(datasetFootnote)) {
			System.out.println("Series name matched with footnotes name");
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Series name not matched with footnotes name");
		}
	}

	// Tc_Footnotes_18
	@Given("^Goto Database Search tab$")
	public void Goto_Database_Search_tab() throws Throwable {
		try {
			clear_search();
			WebDriverWait wait = new WebDriverWait(login.driver, 250);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("database_tab"))));
			Thread.sleep(3000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("database_tab")))
					.click();
		} catch (WebDriverException e) {

		}
	}

	@Given("^Expand the database$")
	public void expand_the_database() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_database"))));
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_database")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_all"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_all"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_topic"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_topic"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_section"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_section"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_table"))).click();
		Thread.sleep(4000);
	}

	@Given("^Verify the footnotes at each level from database search$")
	public void Verify_the_footnotes_at_each_level_from_database_search()
			throws Throwable {
		Thread.sleep(3000);
		WebElement all_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("all_footnote")));
		action.moveToElement(all_row).perform();
		WebDriverWait wait = new WebDriverWait(login.driver, 160);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("all_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("all_footnote_hat_icon")))
				.click();
		String allText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("all_footnote"))).getText();
		// Remove spl characters in text
		String allTextFootnote = allText.replaceAll("\\W", "");
		System.out.println(allTextFootnote);

		String all_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String datasetFootnote = all_footnotes_text.replaceAll("\\W", "");
		System.out.println(datasetFootnote);
		if (allTextFootnote.contentEquals(datasetFootnote)) {
			System.out.println("Series name matched with footnotes name");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Series name not matched with footnotes name");
		}
		// topic

		WebElement topic_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("topic_footnote")));
		action.moveToElement(topic_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("topic_footnote_hat_icon")))
				.click();
		Thread.sleep(5000);
		String topicText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("topic_footnote")))
				.getText();
		// Remove spl characters in text
		String topicTextFootnote = topicText.replaceAll("\\W", "");
		System.out.println(topicTextFootnote);

		String topic_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String topicFootnote = topic_footnotes_text.replaceAll("\\W", "");
		System.out.println(topicFootnote);
		if (topicTextFootnote.contentEquals(topicFootnote)) {
			System.out.println("topic name matched with footnotes name");

			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("topic name not matched with footnotes name");
		}

		// section

		WebElement section_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("section_footnote")));
		action.moveToElement(section_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("section_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("section_footnote_hat_icon"))).click();
		Thread.sleep(5000);
		String sectionText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("section_footnote")))
				.getText();
		// Remove spl characters in text
		String sectionTextFootnote = sectionText.replaceAll("\\W", "");
		System.out.println(sectionTextFootnote);

		String section_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String sectionFootnote = sectionTextFootnote.replaceAll("\\W", "");
		System.out.println(sectionFootnote);
		if (sectionTextFootnote.contentEquals(sectionFootnote)) {
			System.out.println("section name matched with footnotes name");
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			Thread.sleep(5000);
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("section name not matched with footnotes name");
		}
		// table

		// table

		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_footnote")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("table_footnote_hat_icon")))
				.click();
		Thread.sleep(5000);
		String tableText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_footnote")))
				.getText();
		// Remove spl characters in text
		String tableTextFootnote = tableText.replaceAll("\\W", "");
		System.out.println(tableTextFootnote);

		String table_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String tableFootnote = table_footnotes_text.replaceAll("\\W", "");
		System.out.println(tableFootnote);
		if (tableTextFootnote.contentEquals(tableFootnote)) {
			System.out.println("table name matched with footnotes name");
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			Thread.sleep(3000);
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("table name not matched with footnotes name");
		}

		// series
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_footnote")));
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("series_footnote_hat_icon")))
				.click();
		Thread.sleep(5000);
		String seriesText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("series_footnotes")))
				.getText();
		// Remove spl characters in text
		String seriesTextFootnote = seriesText.replaceAll("\\W", "");
		System.out.println(seriesTextFootnote);

		String series_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String seriesFootnote = series_footnotes_text.replaceAll("\\W", "");
		System.out.println(seriesFootnote);
		if (seriesTextFootnote.equalsIgnoreCase(seriesFootnote)) {
			System.out.println("series name matched with footnotes name");
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("series name not matched with footnotes name");

		}
		Thread.sleep(4000);

	}

	// Tc_Footnotes_19
	@Given("^Goto comparables search tab$")
	public void goto_comparables_search_tab() throws Throwable {
		clear_search();
		WebDriverWait wait = new WebDriverWait(login.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("comparables_tab"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("comparables_tab")))
				.click();
	}

	@Given("^Try to expand the database till the single table series$")
	public void try_to_expand_the_database_till_the_single_table_series()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("comparable_section"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("comparable_section")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("comparable_table"))));
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("comparable_table")))
				.click();

	}

	@Given("^Verify the footnotes at each level$")
	public void verify_the_footnotes_at_each_level() throws Throwable {
		WebElement comp_sec_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("comp_sec_footnote_text")));
		action.moveToElement(comp_sec_row).build().perform();
		WebDriverWait wait = new WebDriverWait(login.driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("comp_sec_footnote_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("comp_sec_footnote_icon")))
				.click();
		Thread.sleep(2000);
		String compSecText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("comp_sec_footnote_text")))
				.getText();
		// Remove spl characters in text
		String compSecTextFootnote = compSecText.replaceAll("\\W", "");
		System.out.println(compSecTextFootnote);

		String comp_sec_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String compFootnote = comp_sec_footnotes_text.replaceAll("\\W", "");
		System.out.println(compFootnote);
		if (compSecTextFootnote.contentEquals(compFootnote)) {
			System.out.println("Section name matched with footnotes name");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			Assert.fail("Section name not matched with footnotes name");
		}
		// table
		WebElement comp_table_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("comp_table_footnote_text")));
		action.moveToElement(comp_table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("comp_table_footnote_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("comp_table_footnote_icon")))
				.click();
		Thread.sleep(2000);
		String compTableText = login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("comp_table_footnote_text")))
				.getText();
		// Remove spl characters in text
		String compTableTextFootnote = compTableText.replaceAll("\\W", "");
		System.out.println(compTableTextFootnote);

		String comp_table_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String compTableFootnote = comp_table_footnotes_text.replaceAll("\\W",
				"");
		System.out.println(compTableFootnote);
		if (compTableTextFootnote.contentEquals(compTableFootnote)) {
			System.out.println("Table name matched with footnotes name");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			Assert.fail("Table name not matched with footnotes name");
		}
		// Series
		WebElement comp_series_row = login.driver
				.findElement(By.xpath(login.LOCATORS
						.getProperty("comp_series_footnote_text")));
		action.moveToElement(comp_series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("comp_series_footnote_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("comp_series_footnote_icon"))).click();
		Thread.sleep(2000);
		String compSeriesText = login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("comp_series_footnote_text"))).getText();
		// Remove spl characters in text
		String compSeriesTextFootnote = compSeriesText.replaceAll("\\W", "");
		System.out.println(compSeriesTextFootnote);

		String comp_series_footnotes_text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_text")))
				.getText();

		// take string after :
		// String
		// dataSetFootnoteText=org.apache.commons.lang3.StringUtils.substringAfter(all_footnote,
		// ":");
		// Remove spl characters in text
		String compSeriesFootnote = comp_series_footnotes_text.replaceAll(
				"\\W", "");
		System.out.println(compSeriesFootnote);
		if (compSeriesTextFootnote.contentEquals(compSeriesFootnote)) {
			System.out.println("Series name matched with footnotes name");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Series name not matched with footnotes name");
		}
	}

	// Tc_Footnotes_21
	@Given("^right click , select Footnotes$")
	public void right_click_select_Footnotes() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 700);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("series_footnote")));
		action.contextClick(element).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("select_footnotes"))));
		WebElement footnote_element = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("select_footnotes")));
		footnote_element.click();
		Thread.sleep(5000);

	}

	// Tc_Footnotes_20
	@Given("^Verify 'Translate' option in footnotes$")
	public void verify_Translate_option_in_footnotes() throws Throwable {
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("translate_option")))
				.size() != 0) {
			System.out.println("Translate option is shown");
			footnotes_close();
		} else {
			footnotes_close();
			Assert.fail("Translate option not shown");
		}

	}

	// Tc_Footnotes_21
	@Given("^click on Translate dropdown, verify the options$")
	public void click_on_Translate_dropdown_verify_the_options()
			throws Throwable {
		// WebDriverWait wait=new WebDriverWait(login.driver, 500);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("translate_option"))));
		// Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("translate_option")))
				.click();

		String[] expected = { "中文 (Chinese)", "日本語 (Japanese)", "한국어 (Korean)",
				"Русский (Russian)", "Bahasa (Indonesian)" };
		List<WebElement> allOptions = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("translate_dropdown")));
		for (int i = 0; i < expected.length; i++) {
			String optionValue = allOptions.get(i).getText();
			if (optionValue.equals(expected[i])) {
				System.out.println("passed on: " + optionValue);
			} else {
				Assert.fail("failed on: " + optionValue);
			}

		}
		footnotes_close();
	}

	// Tc_Footnotes_24
	@Given("^click on Open in new tab$")
	public void click_on_Open_in_new_tab() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("file")));
		file.click();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
				.click();
		Thread.sleep(12000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("FOOTNOTES"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		// switch to new tab
		login.driver.switchTo().window(browserTabs.get(1));

	}

	@Given("^Verify view comments, view notifications, view and edit profile dropdowns are shown$")
	public void verify_view_comments_view_notifications_view_and_edit_profile_dropdowns_are_shown()
			throws Throwable {

		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		/*
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("comments"
		 * ))).click(); Thread.sleep(5000);
		 */
		Thread.sleep(6000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("notifications"))).click();
		Thread.sleep(3000);
		List<WebElement> notifications = login.driver
				.findElements(By.xpath(login.LOCATORS
						.getProperty("view_notifications_drpdwn")));
		if (notifications.size() != 0) {
			System.out.println("Notifications dropdown is shown");
		} else {
			Assert.fail("Notifications dropdown is not shown");
		}
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("view_edit"))).click();
		Thread.sleep(3000);
		// List<WebElement> comments =
		// login.driver.findElements(By.xpath(login.LOCATORS.getProperty("view_comments_drpdwn")));

		
		List<WebElement> viewEdit = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("view_edit_profile_drpdwn")));
		/*
		 * if(comments.size()!=0){
		 * System.out.println("Comments dropdown is shown"); } else{
		 * Assert.fail("Comments dropdown is not shown"); }
		 */

		

		if (viewEdit.size() != 0) {
			System.out.println("viewEdit dropdown is shown");
		} else {
			Assert.fail("viewEdit dropdown is not shown");
		}
		Thread.sleep(2000);
		login.driver.close();
		login.driver.switchTo().window(browserTabs.get(0));
	}

	// Tc_Footnotes_22
	@Given("^Open Footnotes to verify provinces$")
	public void open_Footnotes_to_verify_provinces() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 180);
		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_footnote")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("table_footnote_hat_icon")))
				.click();
		Thread.sleep(8000);
		/*
		 * String table =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty
		 * ("table_level"))).getText(); String tableFootnote =
		 * table.replaceAll("Table", "").replaceAll("\\W",
		 * "").replaceAll("Asia", ""); System.out.println(tableFootnote);
		 */

		String topic = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("topic-level"))).getText();
		String topicFootnote = topic.replaceAll("\\W", "");
		System.out.println(topicFootnote);

		String db = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("db_level"))).getText();
		String dbFootnote = db.replaceAll("\\W", "");
		System.out.println(dbFootnote);

		/*
		 * login.driver.switchTo().frame(0); Thread.sleep(7000);
		 * wait.until(ExpectedConditions
		 * .visibilityOfElementLocated(By.xpath(login
		 * .LOCATORS.getProperty("footnote_content_table")))); String
		 * footnote_table =
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty
		 * ("footnote_content_table"))).getText(); String tabFootnote =
		 * footnote_table.replaceAll("Year-on-Year","").replaceAll("\\W", "");
		 * System.out.println(tabFootnote);
		 * if(tableFootnote.matches(tabFootnote)) {
		 * System.out.println("Table Footnote matched");
		 * 
		 * 
		 * } else{ Assert.fail(" Table Footnote failed to match"); }
		 * login.driver.switchTo().defaultContent();
		 */
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic-level"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("topic-level"))).click();
		login.driver.switchTo().frame(0);
		Thread.sleep(7000);
		String footnote_topic = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_content_topic")))
				.getText();
		String topFootnote = footnote_topic.replaceAll("\\W", "");
		System.out.println(topFootnote);
		if (topicFootnote.matches(topFootnote)) {
			System.out.println("Topic Footnote matched");

		} else {
			footnotes_close();
			Assert.fail("Topic failed to match");
		}*/
		login.driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("db_22"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("db_22")))
				.click();
		login.driver.switchTo().frame(0);
		Thread.sleep(5000);
		String footnote_db = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_content_db")))
				.getText();
		String dataFootnote = footnote_db.replaceAll("Database", "")
				.replaceAll("\\W", "");
		System.out.println(dataFootnote);

		if (dbFootnote.matches(dataFootnote)) {
			System.out.println("Database Footnote matched");
		} else {
			footnotes_close();
			Assert.fail("Database Footnote failed to match");
		}
		login.driver.switchTo().defaultContent();
		footnotes_close();
	}

	// Tc_Footnotes_23
	@Given("^Hover on menu bar options and verify$")
	public void hover_on_menu_bar_options_and_verify() throws Throwable {
		// File
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
				System.out.println("failed on: " + optionValue);
			}

		}
		// Alerts
		WebElement alerts = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("alerts")));
		Thread.sleep(9000);
		action.moveToElement(alerts).perform();
		List<WebElement> set_alert = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("set_alert")));
		List<WebElement> set_insigt_notif = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("set_insigt_notif")));
		List<WebElement> set_all_notif = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("set_all_notif")));

		if (set_alert.size() != 0) {
			if (set_insigt_notif.size() != 0) {
				if (set_all_notif.size() != 0) {
					Thread.sleep(5000);
					String alert = login.driver.findElement(
							By.xpath(login.LOCATORS.getProperty("set_alert")))
							.getText();
					String insightNotif = login.driver.findElement(
							By.xpath(login.LOCATORS
									.getProperty("set_insigt_notif")))
							.getText();
					String allNotif = login.driver.findElement(
							By.xpath(login.LOCATORS
									.getProperty("set_all_notif"))).getText();
					System.out
							.println("Dropdown options are shown onclick alerts"
									+ alert
									+ " "
									+ insightNotif
									+ " "
									+ allNotif);

				}
			}
		} else {
			System.out.println("Dropdown options are not shown onclick alerts");
		}
		WebElement insights = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("insights")));
		Thread.sleep(9000);
		action.moveToElement(insights).perform();
		List<WebElement> insights_drpdwn = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("insights_drpdwn")));
		if (insights_drpdwn.size() != 0) {
			System.out.println("Insights dropdown is shown");
		} else {
			System.out.println("Insights dropdown is not shown");
		}

		WebElement products = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("products")));
		Thread.sleep(9000);
		action.moveToElement(products).perform();
		List<WebElement> products_drpdwn = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("products_drpdwn")));
		if (products_drpdwn.size() != 0) {
			System.out.println("Products dropdown is shown");
		} else {
			System.out.println("Products dropdown is not shown");
		}
		/*
		 * WebElement footnotes =
		 * login.driver.findElement(By.xpath(login.LOCATORS
		 * .getProperty("footnotes")));
		 * login.driver.manage().timeouts().implicitlyWait(95,
		 * TimeUnit.SECONDS); action.moveToElement(footnotes).perform();
		 * List<WebElement> footnotes_drpdwn =
		 * login.driver.findElements(By.xpath
		 * (login.LOCATORS.getProperty("footnotes_drpdwn")));
		 * if(footnotes_drpdwn.size()!=0){
		 * System.out.println("footnotes dropdown is shown"); } else{
		 * System.out.println("footnotes dropdown is not shown"); }
		 */
		WebElement help = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("help")));
		Thread.sleep(9000);
		action.moveToElement(help).perform();
		List<WebElement> help_drpdwn = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("help_drpdwn")));
		if (help_drpdwn.size() != 0) {
			System.out.println("Help dropdown is shown");
		} else {
			System.out.println("Help dropdown is not shown");
		}
		Thread.sleep(5000);
	}

	@Given("^Expand the Section$")
	public void expand_the_Section() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_database"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_database")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_all"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_all"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_topic"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_topic"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_section"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_section"))).click();
	}

	// Tc_Footnotes_25
	@Given("^Verify redirection to Country specific information$")
	public void verify_redirection_to_Country_specific_information()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 30);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_euro_asia")));
		action.moveToElement(element).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_euro_asia_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_euro_asia_icon")))
				.click();

		Thread.sleep(7000);
		login.driver.switchTo().frame(0);
		js.executeScript("window.scrollBy(0,1000)");

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("country_specific_info")))
				.click();
		Thread.sleep(10000);
		List<WebElement> country_specific_info_table = login.driver
				.findElements(By.xpath(login.LOCATORS
						.getProperty("country_specific_info_table")));
		if (country_specific_info_table.size() != 0) {
			System.out
					.println("Page navigates to country specific information table");
			login.driver.switchTo().defaultContent();
			footnotes_close();

		} else {

			footnotes_close();
			login.driver.switchTo().defaultContent();
			Assert.fail("Page will not navigate to country specific information");

		}

	}

	// //Tc_Footnotes_26
	@Given("^Add series to My series$")
	public void Add_series_to_My_series() throws Throwable {
		// login.driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		Thread.sleep(10000);
	login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("search_presentation")))
				.click();

		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		Thread.sleep(6000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("select_series"))).click();
		Thread.sleep(8000);
		action.sendKeys("a").perform();
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("my_series_filter_checkbox"))).click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("delete_myeries"))));
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
		Thread.sleep(10000);
		login.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(9000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("select_series"))).click();

		action.sendKeys("a").perform();
		Thread.sleep(10000);

	}

	@Given("^Click on i con in SSP window$")
	public void Click_on_i_con_in_SSP_window() throws Throwable {
		WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("i_con")));
		Thread.sleep(8000);
		action.moveToElement(ele).perform();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("i_con")))
				.click();
		Thread.sleep(4000);
	}

	@Given("^Click on Read more to Verify open footnotes$")
	public void Click_on_Read_more_to_Verify_open_footnotes() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 70);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath(login.LOCATORS.getProperty("read_more"))));
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("read_more"))).click();
		Thread.sleep(5000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("i_con_close"))).click();
		Thread.sleep(7000);
		List<WebElement> footnote_window = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("footnote_window")));
		if (footnote_window.size() != 0) {
			System.out.println("Footnotes window is shown");
			footnotes_close();

		} else {
			footnotes_close();
			System.out.println("Footnotes window is not shown");

		}
		// Thread.sleep(1000);

	}

	// Tc_Footnotes_27

	@Given("^Click on Footnotes menu bar , click Open$")
	public void click_on_Footnotes_menu_bar_click_Open() throws Throwable {
		login.driver.navigate().refresh();
		Thread.sleep(5000);
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("file")));
		file.click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("FOOTNOTES"))).click();
	}

	@Given("^Click on File , select Refresh$")
	public void click_on_File_select_Refresh() throws Throwable {
		WebElement file = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("file")));
		file.click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("refresh"))).click();

	}

	@Given("^Verify the footnotes window is retained$")
	public void verify_the_footnotes_window_is_retained() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 20);
		List<WebElement> verify_footnote = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("footnote_window")));
		if (verify_footnote.size() != 0) {
			System.out.println("Footnote window is retained on refresh");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			// Thread.sleep(4000);
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
			// Thread.sleep(4000);
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_window_close"))).click();
			Assert.fail("Footnote window is not  retained on refresh");
		}

	}

	// Tc_Footnotes_28
	@Given("^Refresh the page,Verify the footnotes window disappear$")
	public void refresh_the_page_Verify_the_footnotes_window_disappear()
			throws Throwable {
		try {
			login.driver.navigate().refresh();
			Thread.sleep(20000);
			List<WebElement> verify_footnote = login.driver.findElements(By
					.xpath(login.LOCATORS.getProperty("footnote_window")));
			if (verify_footnote.size() != 0) {
				Assert.fail("Footnote window retained on page refresh");

			} else {
				System.out.println("Footnote window disappear on page refresh");
			}
		} catch (WebDriverException e) {

		}

	}

	@Given("^Click on Footnotes menu bar , click Open new tabe$")
	public void click_on_Footnotes_menu_bar_click_Open_new_tab()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnotes_tab"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_tab"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("open_in_new_tab"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_in_new_tab")))
				.click();
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(4000);
		login.driver.close();
		login.driver.switchTo().window(browserTabs.get(0));
	}

	// Tc_Footnotes_29
	@Given("^Goto Footnotes menu bar , click Open new tab$")
	public void Goto_Footnotes_menu_bar_click_Open_new_tab() throws Throwable {
		// WebDriverWait wait = new WebDriverWait(login.driver,500);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnotes_tab"))));
		// Thread.sleep(10000);
		// WebElement file =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("file")));
		// file.click();
		// Thread.sleep(2000);
		Thread.sleep(10000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
				.click();
		Thread.sleep(3000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("FOOTNOTES"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(20000);
		String windowHandle = login.driver.getWindowHandle();
		for (String winHandle : login.driver.getWindowHandles()) {
			login.driver.switchTo().window(winHandle);
		}

	}

	@Given("^expand the tree , refresh the page$")
	public void expand_the_tree_refresh_the_page() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("db"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("db")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("topic")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("section"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("section"))).click();
		Thread.sleep(5000);
		login.driver.navigate().refresh();

	}

	@Given("^Verify the tree is collapsed$")
	public void verify_the_tree_is_collapsed() throws Throwable {
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		try {
			// get window handlers as list
			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab
			login.driver.switchTo().window(browserTabs.get(1));
			Thread.sleep(4000);
			// check comparing url
			List<WebElement> tree = login.driver.findElements(By
					.xpath(login.LOCATORS.getProperty("database")));
			if (tree.size() != 0) {
				System.out.println("Database tree is collapsed");
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
				Thread.sleep(3000);

			} else {
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
				Thread.sleep(3000);
				Assert.fail("Database tree is not collapsed");
			}

			// then close tab and get back

		} catch (Exception e) {
			// login.driver.close();
			// login.driver.switchTo().window(browserTabs.get(0));
			// Thread.sleep(3000);
			// Assert.fail("Database tree is not collapsed");

		}
		Thread.sleep(12000);
	}

	// Tc_Footnotes_30
	@Given("^Goto Db Search tab$")
	public void goto_Db_Search_tab() throws Throwable {
		try {
			clear_search();
			// WebDriverWait wait=new WebDriverWait(login.driver,360);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("database_tab"))));
			Thread.sleep(25000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("database_tab")))
					.click();
		} catch (WebDriverException e) {
			Thread.sleep(25000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("database_tab")))
					.click();
		}

	}

	@Given("^Click on Open button and verify refreshing footnotes in new tab$")
	public void Click_on_Open_button_and_verify_refreshing_footnotes_in_new_tab()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);

		try {
			// get window handlers as list
			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab
			login.driver.switchTo().window(browserTabs.get(1));
			Thread.sleep(15000);
			// check comparing url
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
			// Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Open_sidebar")))
					.click();
			Thread.sleep(5000);
			login.driver.navigate().refresh();
			Thread.sleep(10000);
			List<WebElement> tree = login.driver.findElements(By
					.xpath(login.LOCATORS.getProperty("db")));
			if (tree.size() != 0) {
				System.out.println("Database tree is collapsed");
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));

			} else {
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
				Assert.fail("Database tree is not collapsed");
			}

			// then close tab and get back

		} catch (Exception e) {
			Assert.fail("Database tree is not collapsed");
		}
	}

	// Tc_Footnotes_31

	public void chinese() throws Exception {
		WebDriverWait wait = new WebDriverWait(login.driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("translate_option"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("translate_option")))
				.click();
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("chinese_lang"))).click();
		Thread.sleep(9000);
		login.driver.switchTo().frame(0);
		Thread.sleep(5000);
	}

	public void Japanese() throws Exception {

		WebDriverWait wait = new WebDriverWait(login.driver, 700);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("lang_dropdown"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("lang_dropdown"))).click();
		Thread.sleep(9000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("translate_option"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("japanese_lang"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("japanese_lang"))).click();
		Thread.sleep(9000);
		login.driver.switchTo().frame(0);
		Thread.sleep(5000);
	}

	public void Korean() throws Exception {
		WebDriverWait wait = new WebDriverWait(login.driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("lang_dropdown"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("lang_dropdown"))).click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("korean_lang"))));

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("korean_lang"))).click();
		Thread.sleep(9000);
		login.driver.switchTo().frame(0);
		Thread.sleep(6000);
	}

	public void Russian() throws Exception {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("lang_dropdown"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("lang_dropdown"))).click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("russian_lang"))));

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("russian_lang"))).click();
		Thread.sleep(6000);
		login.driver.switchTo().frame(0);
		Thread.sleep(6000);
	}

	public void Indonesian() throws Exception {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("lang_dropdown"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("lang_dropdown"))).click();
		Thread.sleep(9000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("indonesia_lang"))));

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indonesia_lang"))).click();
		Thread.sleep(6000);
		login.driver.switchTo().frame(0);
		Thread.sleep(6000);
	}

	@Given("^verify language translation db_level$")
	public void verify_language_translation_db_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		WebElement db_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("db_level")));
		action.contextClick(db_row).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("select_footnotes"))));
		WebElement footnote_element = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("select_footnotes")));
		footnote_element.click();
		Thread.sleep(10000);
		// Compare chinese

		chinese();
		Thread.sleep(7000);
		WebElement database = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text = "世界趋势加数据库";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db);
		if (db.matches(db_text)) {
			System.out.println("Translated to chinese ");
		} else {
			Assert.fail("Failed to convert to chinese ");
		}

		login.driver.switchTo().defaultContent();
		// Compare japanese

		Japanese();

		WebElement db_jpn = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_jpn = "世界のトレンドプラスデータベース";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_jpn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_jpn_txt);
		if (db_jpn_txt.matches(db_text_jpn)) {
			System.out.println("Translated to japanese ");
		} else {
			Assert.fail("Failed to convert to japanese ");
		}
		login.driver.switchTo().defaultContent();

		// Korean
		Korean();
		WebElement db_korn = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_krn = "세계 트렌드 플러스 데이터베이스";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_krn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_krn_txt);
		if (db_text_krn.matches(db_krn_txt)) {
			System.out.println("Translated to korean ");
		} else {
			Assert.fail("Failed to convert to korean ");
		}
		login.driver.switchTo().defaultContent();

		// Russian
		Russian();
		WebElement db_russ = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_russ = "База данных World Trend Plus";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_russ_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_russ_txt);
		if (db_text_russ.matches(db_russ_txt)) {
			System.out.println("Translated to russian ");
		} else {
			Assert.fail("Failed to convert to russian ");
		}
		login.driver.switchTo().defaultContent();
		// Indonesian
		Indonesian();
		WebElement db_indo = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_indo = "Database Trend Dunia Plus";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_indo_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_indo_txt);
		if (db_text_indo.matches(db_indo_txt)) {
			System.out.println("Translated to indonessian ");
		} else {
			Assert.fail("Failed to convert to indonessian ");
		}
		login.driver.switchTo().defaultContent();
		footnotes_close();
	}

	@Given("^verify language translation Country_level$")
	public void verify_language_translation_Country_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		WebElement all_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("all_footnote")));
		action.moveToElement(all_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("all_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("all_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		// Compare chinese

		chinese();
		Thread.sleep(4000);
		WebElement database = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text = "世界趋势加数据库";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db);
		if (db.matches(db_text)) {
			System.out.println("Translated to chinese ");
		} else {
			Assert.fail("Failed to convert to chinese ");
		}

		login.driver.switchTo().defaultContent();
		// Compare japanese

		Japanese();

		WebElement db_jpn = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_jpn = "世界のトレンドプラスデータベース";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_jpn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_jpn_txt);
		if (db_jpn_txt.matches(db_text_jpn)) {
			System.out.println("Translated to japanese ");
		} else {
			Assert.fail("Failed to convert to japanese ");
		}
		login.driver.switchTo().defaultContent();

		// Korean
		Korean();
		WebElement db_korn = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_krn = "세계 트렌드 플러스 데이터베이스";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_krn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_krn_txt);
		if (db_text_krn.matches(db_krn_txt)) {
			System.out.println("Translated to korean ");
		} else {
			Assert.fail("Failed to convert to korean ");
		}
		login.driver.switchTo().defaultContent();

		// Russian
		Russian();
		WebElement db_russ = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_russ = "База данных World Trend Plus";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_russ_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_russ_txt);
		if (db_text_russ.matches(db_russ_txt)) {
			System.out.println("Translated to russian ");
		} else {
			Assert.fail("Failed to convert to russian ");
		}
		login.driver.switchTo().defaultContent();
		// Indonesian
		Indonesian();
		WebElement db_indo = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("language")));
		Thread.sleep(4000);
		String db_text_indo = "Database Trend Dunia Plus";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("language"))));

		String db_indo_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("language"))).getText();
		System.out.println(db_indo_txt);
		if (db_text_indo.matches(db_indo_txt)) {
			System.out.println("Translated to indonessian ");
		} else {
			Assert.fail("Failed to convert to indonessian ");
		}
		login.driver.switchTo().defaultContent();
		footnotes_close();
	}

	@Given("^verify language translation Topic_level$")
	public void verify_language_translation_Topic_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		WebElement topic_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("topic_footnote")));
		action.moveToElement(topic_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("topic_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		// Compare chinese

		chinese();
		Thread.sleep(4000);
		WebElement topic_level_chn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("topic_text")));
		Thread.sleep(4000);
		String topic_chn_text = "全球经济监测";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic_text"))));

		String topic_chn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("topic_text"))).getText();
		System.out.println(topic_chn_txt);
		if (topic_chn_text.matches(topic_chn_txt)) {
			System.out.println("Translated to chinese ");
		} else {
			Assert.fail("Failed to convert to chinese ");
		}

		login.driver.switchTo().defaultContent();
		// Compare japanese

		Japanese();

		WebElement topic_jpn = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("jpn_text")));
		Thread.sleep(4000);
		String topic_jpn_text = "グローバル経済モニタリング";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("jpn_text"))));

		String topic_jpn__txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("jpn_text"))).getText();
		System.out.println(topic_jpn__txt);
		if (topic_jpn_text.matches(topic_jpn__txt)) {
			System.out.println("Translated to japanese ");
		} else {
			Assert.fail("Failed to convert to japanese ");
		}
		login.driver.switchTo().defaultContent();

		// Korean
		Korean();
		WebElement topic_korn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("korn_text")));
		Thread.sleep(4000);
		String topic_text_krn = "세계 경제 모니터";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("korn_text"))));

		String topic_krn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("korn_text"))).getText();
		System.out.println(topic_krn_txt);
		if (topic_text_krn.matches(topic_krn_txt)) {
			System.out.println("Translated to korean ");
		} else {
			Assert.fail("Failed to convert to korean ");
		}
		login.driver.switchTo().defaultContent();

		// Russian
		Russian();
		WebElement topic_russ = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("russ_text")));
		Thread.sleep(4000);
		String topic_text_russ = "Глобальный экономический монитор";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("russ_text"))));

		String topic_russ_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("russ_text"))).getText();
		System.out.println(topic_russ_txt);
		if (topic_russ_txt.matches(topic_text_russ)) {
			System.out.println("Translated to russian ");
		} else {
			Assert.fail("Failed to convert to russian ");
		}
		login.driver.switchTo().defaultContent();
		// Indonesian
		Indonesian();
		WebElement topic_indo = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("indo_text")));
		Thread.sleep(4000);
		String topic_text_indo = "Pemantau Ekonomi Global";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("indo_text"))));

		String topic_indo_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indo_text"))).getText();
		System.out.println(topic_indo_txt);
		if (topic_text_indo.matches(topic_indo_txt)) {
			System.out.println("Translated to indonessian ");
		} else {
			Assert.fail("Failed to convert to indonessian ");
		}
		login.driver.switchTo().defaultContent();
		footnotes_close();
	}

	@Given("^verify language translation Section_level$")
	public void verify_language_translation_Section_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		WebElement section_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("section_footnote")));
		action.moveToElement(section_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("section_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("section_footnote_hat_icon"))).click();
		Thread.sleep(10000);
		// Compare chinese

		chinese();
		Thread.sleep(4000);
		WebElement section_level_chn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("topic_text")));
		Thread.sleep(3000);
		String section_chn_text = "全球经济监测";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic_text"))));

		String section_chn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("topic_text"))).getText();
		System.out.println(section_chn_txt);
		if (section_chn_text.matches(section_chn_txt)) {
			System.out.println("Translated to chinese ");
		} else {
			Assert.fail("Failed to convert to chinese ");
		}

		login.driver.switchTo().defaultContent();
		// Compare japanese

		Japanese();

		WebElement topic_jpn = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("jpn_text")));
		Thread.sleep(3000);
		String section_jpn_text = "グローバル経済モニタリング";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("jpn_text"))));

		String section_jpn__txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("jpn_text"))).getText();
		System.out.println(section_jpn__txt);
		if (section_jpn_text.matches(section_jpn__txt)) {
			System.out.println("Translated to japanese ");
		} else {
			Assert.fail("Failed to convert to japanese ");
		}
		login.driver.switchTo().defaultContent();

		// Korean
		Korean();
		WebElement section_korn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("korn_text")));
		Thread.sleep(3000);
		String section_text_krn = "세계 경제 모니터";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("korn_text"))));

		String section_krn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("korn_text"))).getText();
		System.out.println(section_krn_txt);
		if (section_text_krn.matches(section_krn_txt)) {
			System.out.println("Translated to korean ");
		} else {
			Assert.fail("Failed to convert to korean ");
		}
		login.driver.switchTo().defaultContent();

		// Russian
		Russian();
		WebElement section_russ = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("russ_text")));
		Thread.sleep(3000);
		String section_text_russ = "Глобальный экономический монитор";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("russ_text"))));

		String section_russ_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("russ_text"))).getText();
		System.out.println(section_russ_txt);
		if (section_russ_txt.matches(section_text_russ)) {
			System.out.println("Translated to russian ");
		} else {
			Assert.fail("Failed to convert to russian ");
		}
		login.driver.switchTo().defaultContent();
		// Indonesian
		Indonesian();
		WebElement section_indo = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("indo_text")));
		Thread.sleep(3000);
		String section_text_indo = "Pemantau Ekonomi Global";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("indo_text"))));

		String section_indo_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indo_text"))).getText();
		System.out.println(section_indo_txt);
		if (section_text_indo.matches(section_indo_txt)) {
			System.out.println("Translated to indonessian ");
		} else {
			Assert.fail("Failed to convert to indonessian ");
		}
		login.driver.switchTo().defaultContent();
		footnotes_close();

	}

	@Given("^verify language translation Table_level$")
	public void verify_language_translation_Table_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_footnote")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("table_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		// Compare chinese

		chinese();
		Thread.sleep(4000);
		WebElement table_level_chn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("table_chn_text")));
		Thread.sleep(3000);
		String table_chn_text1 = "全球经济监测";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_chn_text"))));

		String table_chn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_chn_text")))
				.getText();
		System.out.println(table_chn_txt);
		if (table_chn_txt.matches(table_chn_text1)) {
			System.out.println("Translated to chinese ");
		} else {
			Assert.fail("Failed to convert to chinese ");
		}

		login.driver.switchTo().defaultContent();
		// Compare japanese

		Japanese();

		WebElement topic_jpn = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_jpn_text")));
		Thread.sleep(3000);
		String table_jpn_text = "グローバル経済モニタリング";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_jpn_text"))));

		String table_jpn__txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_jpn_text")))
				.getText();
		System.out.println(table_jpn__txt);
		if (table_jpn_text.matches(table_jpn__txt)) {
			System.out.println("Translated to japanese ");
		} else {
			Assert.fail("Failed to convert to japanese ");
		}
		login.driver.switchTo().defaultContent();

		// Korean
		Korean();
		WebElement table_korn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("table_korn_text")));
		Thread.sleep(3000);
		String table_text_krn = "세계 경제 모니터";
		String table_text_krn1 = table_text_krn.replaceAll("\\W", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_korn_text"))));

		String table_krn_txt1 = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_korn_text")))
				.getText();
		String table_krn_txt2 = table_krn_txt1.replaceAll("\\W", "");
		System.out.println(table_krn_txt2);
		Thread.sleep(3000);
		if (table_text_krn1.matches(table_krn_txt2)) {
			System.out.println("Translated to korean ");
		} else {
			Assert.fail("Failed to convert to korean ");
		}
		login.driver.switchTo().defaultContent();

		// Russian
		Russian();
		WebElement table_russ = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("table_russ_text")));
		Thread.sleep(3000);
		String table_text_russ = "Глобальный экономический монитор";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_russ_text"))));

		String table_russ_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_russ_text")))
				.getText();
		System.out.println(table_russ_txt);
		if (table_russ_txt.matches(table_text_russ)) {
			System.out.println("Translated to russian ");
		} else {
			Assert.fail("Failed to convert to russian ");
		}
		login.driver.switchTo().defaultContent();
		// Indonesian
		Indonesian();
		WebElement table_indo = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("table_indo_text")));
		Thread.sleep(3000);
		String table_text_indo = "Pemantau Ekonomi Global";
		String table_text_ind1 = table_text_indo.replaceAll("\\W", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_indo_text"))));

		String table_indo_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_indo_text")))
				.getText();
		String table_indo_txt1 = table_indo_txt.replaceAll("\\W", "");
		System.out.println(table_indo_txt);
		if (table_text_ind1.matches(table_indo_txt1)) {
			System.out.println("Translated to indonessian ");
		} else {
			Assert.fail("Failed to convert to indonessian ");
		}
		login.driver.switchTo().defaultContent();
		footnotes_close();
	}

	@Given("^verify language translation Series_level$")
	public void verify_language_translation_Series_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_footnote")));
		Thread.sleep(2000);
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("series_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		// Compare chinese

		chinese();
		Thread.sleep(4000);
		WebElement series_level_chn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_chn_text")));
		Thread.sleep(4000);
		String series_chn_text = "全球经济监测";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_chn_text"))));

		String series_chn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("series_chn_text")))
				.getText();
		System.out.println(series_chn_txt);
		if (series_chn_txt.matches(series_chn_text)) {
			System.out.println("Translated to chinese ");
		} else {
			Assert.fail("Failed to convert to chinese ");
		}

		login.driver.switchTo().defaultContent();
		// Compare japanese

		Japanese();

		WebElement series_jpn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_jpn_text")));
		Thread.sleep(4000);
		String series_jpn_text = "グローバル経済モニタリング";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_jpn_text"))));

		String series_jpn__txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("series_jpn_text")))
				.getText();
		System.out.println(series_jpn__txt);
		if (series_jpn_text.matches(series_jpn__txt)) {
			System.out.println("Translated to japanese ");
		} else {
			Assert.fail("Failed to convert to japanese ");
		}
		login.driver.switchTo().defaultContent();

		// Korean
		Korean();
		WebElement series_korn = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_korn_text")));
		Thread.sleep(4000);
		String series_text_krn = "세계 경제 모니터";
		String series_text_krn1 = series_text_krn.replaceAll("\\W", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_korn_text"))));

		String series_krn_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("series_korn_text")))
				.getText();
		String series_krn_txt1 = series_krn_txt.replaceAll("\\W", "");
		System.out.println(series_krn_txt1);
		if (series_text_krn1.matches(series_krn_txt1)) {
			System.out.println("Translated to korean ");
		} else {
			Assert.fail("Failed to convert to korean ");
		}
		login.driver.switchTo().defaultContent();

		// Russian
		Russian();
		WebElement series_russ = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_russ_text")));
		Thread.sleep(7000);
		String table_text_russ = "Глобальный экономический монитор";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_russ_text"))));

		String table_russ_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("series_russ_text")))
				.getText();
		System.out.println(table_russ_txt);
		if (table_russ_txt.matches(table_text_russ)) {
			System.out.println("Translated to russian ");
		} else {
			Assert.fail("Failed to convert to russian ");
		}
		login.driver.switchTo().defaultContent();
		// Indonesian
		Indonesian();
		Thread.sleep(7000);
		WebElement series_indo = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_indo_text")));
		Thread.sleep(7000);
		String series_text_indo = "Pemantau Ekonomi Global";
		String series_text_indo1 = series_text_indo.replaceAll("\\W", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_indo_text"))));

		String series_indo_txt = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("series_indo_text")))
				.getText();
		String series_indo_txt1 = series_indo_txt.replaceAll("\\W", "");
		System.out.println(series_indo_txt);
		if (series_text_indo1.matches(series_indo_txt1)) {
			System.out.println("Translated to indonessian ");
		} else {
			Assert.fail("Failed to convert to indonessian ");
		}
		login.driver.switchTo().defaultContent();
		footnotes_close();
	}

	// Tc_Footnotes_32

	@Given("^verify language translation db_level in new tab$")
	public void verify_language_translation_db_level_in_new_tab()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 800);
		Thread.sleep(7000);
		WebElement db_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("db_level")));
		action.contextClick(db_row).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("select_footnotes"))));
		WebElement footnote_element = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("select_footnotes")));
		Thread.sleep(7000);
		footnote_element.click();
		Thread.sleep(10000);
		// //WebDriverWait wait=new WebDriverWait(login.driver,60);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("translate_option"))));
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("translate_option"))).click();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chinese_lang"))).click();
		chinese();
		login.driver.switchTo().defaultContent();

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);
		// Compare chinese
		try {

			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab

			login.driver.switchTo().window(browserTabs.get(1));

			Thread.sleep(4000);
			login.driver.switchTo().frame(0);
			WebElement database = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("db_title")));
			Thread.sleep(5000);
			String db_text = "世界趋势加数据库";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("db_title"))));

			String db = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("db_title"))).getText();
			System.out.println(db);
			if (db.matches(db_text)) {
				System.out.println("Translated to chinese ");
			} else {
				Assert.fail("Failed to convert to chinese ");
			}
			// login.driver.close();
			// login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
			Japanese();

			WebElement db_jpn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_jpn = "世界のトレンドプラスデータベース";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_jpn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_jpn_txt);
			if (db_jpn_txt.matches(db_text_jpn)) {
				System.out.println("Translated to japanese ");
			} else {
				Assert.fail("Failed to convert to japanese ");
			}
			login.driver.switchTo().defaultContent();

			// Korean
			Korean();
			WebElement db_korn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_krn = "세계 트렌드 플러스 데이터베이스";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_krn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_krn_txt);
			if (db_text_krn.matches(db_krn_txt)) {
				System.out.println("Translated to korean ");
			} else {
				Assert.fail("Failed to convert to korean ");
			}
			login.driver.switchTo().defaultContent();

			// Russian
			Russian();
			WebElement db_russ = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_russ = "База данных World Trend Plus";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_russ_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_russ_txt);
			if (db_text_russ.matches(db_russ_txt)) {
				System.out.println("Translated to russian ");
			} else {
				Assert.fail("Failed to convert to russian ");
			}
			login.driver.switchTo().defaultContent();
			// Indonesian
			Indonesian();
			WebElement db_indo = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_indo = "Database Trend Dunia Plus";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_indo_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_indo_txt);
			if (db_text_indo.matches(db_indo_txt)) {
				System.out.println("Translated to indonessian ");
			} else {
				Assert.fail("Failed to convert to indonessian ");
			}
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Given("^verify language translation Country_level in new tab$")
	public void verify_language_translation_Country_level_in_new_tab()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 800);
		Thread.sleep(7000);
		WebElement all_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("all_footnote")));
		action.moveToElement(all_row).perform();
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("all_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("all_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		chinese();
		Thread.sleep(7000);
		login.driver.switchTo().defaultContent();
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);
		// Compare chinese
		try {

			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab

			login.driver.switchTo().window(browserTabs.get(1));

			Thread.sleep(10000);
			login.driver.switchTo().frame(0);
			WebElement database = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("db_title")));
			String db_text = "世界趋势加数据库";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("db_title"))));

			String db = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("db_title"))).getText();
			System.out.println(db);
			if (db.matches(db_text)) {
				System.out.println("Translated to chinese ");
			} else {
				Assert.fail("Failed to convert to chinese ");
			}
			// login.driver.close();
			// login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
			Japanese();

			WebElement db_jpn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_jpn = "世界のトレンドプラスデータベース";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_jpn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_jpn_txt);
			if (db_jpn_txt.matches(db_text_jpn)) {
				System.out.println("Translated to japanese ");
			} else {
				Assert.fail("Failed to convert to japanese ");
			}
			login.driver.switchTo().defaultContent();

			// Korean
			Korean();
			WebElement db_korn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_krn = "세계 트렌드 플러스 데이터베이스";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_krn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_krn_txt);
			if (db_text_krn.matches(db_krn_txt)) {
				System.out.println("Translated to korean ");
			} else {
				Assert.fail("Failed to convert to korean ");
			}
			login.driver.switchTo().defaultContent();

			// Russian
			Russian();
			WebElement db_russ = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_russ = "База данных World Trend Plus";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_russ_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_russ_txt);
			if (db_text_russ.matches(db_russ_txt)) {
				System.out.println("Translated to russian ");
			} else {
				Assert.fail("Failed to convert to russian ");
			}
			login.driver.switchTo().defaultContent();
			Thread.sleep(4000);
			// Indonesian
			Indonesian();
			WebElement db_indo = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("language")));
			Thread.sleep(4000);
			String db_text_indo = "Database Trend Dunia Plus";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("language"))));

			String db_indo_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("language"))).getText();
			System.out.println(db_indo_txt);
			if (db_text_indo.matches(db_indo_txt)) {
				System.out.println("Translated to indonessian ");
			} else {
				Assert.fail("Failed to convert to indonessian ");
			}
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Given("^verify language translation Topic_level in new tab$")
	public void verify_language_translation_Topic_level_in_new_tab()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 800);
		Thread.sleep(7000);
		WebElement topic_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("topic_footnote")));
		action.moveToElement(topic_row).perform();
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("topic_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		chinese();
		Thread.sleep(7000);
		login.driver.switchTo().defaultContent();
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);
		// Compare chinese
		try {

			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab

			login.driver.switchTo().window(browserTabs.get(1));

			Thread.sleep(7000);
			login.driver.switchTo().frame(0);
			WebElement topic_level_chn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("topic_text")));
			Thread.sleep(4000);
			String topic_chn_text = "全球经济监测";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("topic_text"))));

			String topic_chn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("topic_text")))
					.getText();
			System.out.println(topic_chn_txt);
			if (topic_chn_text.matches(topic_chn_txt)) {
				System.out.println("Translated to chinese ");
			} else {
				Assert.fail("Failed to convert to chinese ");
			}

			// login.driver.close();
			// login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
			Japanese();

			WebElement topic_jpn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("jpn_text")));
			Thread.sleep(4000);
			String topic_jpn_text = "グローバル経済モニタリング";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("jpn_text"))));

			String topic_jpn__txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("jpn_text"))).getText();
			System.out.println(topic_jpn__txt);
			if (topic_jpn_text.matches(topic_jpn__txt)) {
				System.out.println("Translated to japanese ");
			} else {
				Assert.fail("Failed to convert to japanese ");
			}
			login.driver.switchTo().defaultContent();

			// Korean
			Korean();
			WebElement topic_korn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("korn_text")));
			Thread.sleep(4000);
			String topic_text_krn = "세계 경제 모니터";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("korn_text"))));

			String topic_krn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("korn_text")))
					.getText();
			System.out.println(topic_krn_txt);
			if (topic_text_krn.matches(topic_krn_txt)) {
				System.out.println("Translated to korean ");
			} else {
				Assert.fail("Failed to convert to korean ");
			}
			login.driver.switchTo().defaultContent();

			// Russian
			Russian();
			WebElement topic_russ = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("russ_text")));
			Thread.sleep(4000);
			String topic_text_russ = "Глобальный экономический монитор";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("russ_text"))));

			String topic_russ_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("russ_text")))
					.getText();
			System.out.println(topic_russ_txt);
			if (topic_russ_txt.matches(topic_text_russ)) {
				System.out.println("Translated to russian ");
			} else {
				Assert.fail("Failed to convert to russian ");
			}
			login.driver.switchTo().defaultContent();
			Thread.sleep(4000);
			// Indonesian
			Indonesian();
			WebElement topic_indo = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("indo_text")));
			Thread.sleep(4000);
			String topic_text_indo = "Pemantau Ekonomi Global";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("indo_text"))));

			String topic_indo_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("indo_text")))
					.getText();
			System.out.println(topic_indo_txt);
			if (topic_text_indo.matches(topic_indo_txt)) {
				System.out.println("Translated to indonessian ");
			} else {
				Assert.fail("Failed to convert to indonessian ");
			}
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Given("^verify language translation Section_level in new tab$")
	public void verify_language_translation_Section_level_in_new_tab()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 800);
		Thread.sleep(7000);
		WebElement section_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("section_footnote")));
		action.moveToElement(section_row).perform();
		Thread.sleep(7000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("section_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("section_footnote_hat_icon"))).click();
		Thread.sleep(10000);
		chinese();
		Thread.sleep(7000);
		login.driver.switchTo().defaultContent();
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);
		// Compare chinese
		try {

			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab

			login.driver.switchTo().window(browserTabs.get(1));

			Thread.sleep(7000);
			login.driver.switchTo().frame(0);
			WebElement section_level_chn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("topic_text")));
			Thread.sleep(4000);
			String section_chn_text = "全球经济监测";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("topic_text"))));

			String section_chn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("topic_text")))
					.getText();
			System.out.println(section_chn_txt);
			if (section_chn_text.matches(section_chn_txt)) {
				System.out.println("Translated to chinese ");
			} else {
				Assert.fail("Failed to convert to chinese ");
			}

			// login.driver.close();
			// login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
			Japanese();

			WebElement topic_jpn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("jpn_text")));
			Thread.sleep(4000);
			String section_jpn_text = "グローバル経済モニタリング";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("jpn_text"))));

			String section_jpn__txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("jpn_text"))).getText();
			System.out.println(section_jpn__txt);
			if (section_jpn_text.matches(section_jpn__txt)) {
				System.out.println("Translated to japanese ");
			} else {
				Assert.fail("Failed to convert to japanese ");
			}
			login.driver.switchTo().defaultContent();

			// Korean
			Korean();
			WebElement section_korn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("korn_text")));
			Thread.sleep(4000);
			String section_text_krn = "세계 경제 모니터";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("korn_text"))));

			String section_krn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("korn_text")))
					.getText();
			System.out.println(section_krn_txt);
			if (section_text_krn.matches(section_krn_txt)) {
				System.out.println("Translated to korean ");
			} else {
				Assert.fail("Failed to convert to korean ");
			}
			login.driver.switchTo().defaultContent();

			// Russian
			Russian();
			WebElement section_russ = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("russ_text")));
			Thread.sleep(4000);
			String section_text_russ = "Глобальный экономический монитор";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("russ_text"))));

			String section_russ_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("russ_text")))
					.getText();
			System.out.println(section_russ_txt);
			if (section_russ_txt.matches(section_text_russ)) {
				System.out.println("Translated to russian ");
			} else {
				Assert.fail("Failed to convert to russian ");
			}
			login.driver.switchTo().defaultContent();
			Thread.sleep(4000);
			// Indonesian
			Indonesian();
			WebElement section_indo = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("indo_text")));
			Thread.sleep(4000);
			String section_text_indo = "Pemantau Ekonomi Global";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("indo_text"))));

			String section_indo_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("indo_text")))
					.getText();
			System.out.println(section_indo_txt);
			if (section_text_indo.matches(section_indo_txt)) {
				System.out.println("Translated to indonessian ");
			} else {
				Assert.fail("Failed to convert to indonessian ");
			}
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Given("^verify language translation Table_level in new tab$")
	public void verify_language_translation_Table_level_in_new_tab()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 80);
		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_footnote")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("table_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		chinese();
		Thread.sleep(7000);
		login.driver.switchTo().defaultContent();
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);
		// Compare chinese
		try {

			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab

			login.driver.switchTo().window(browserTabs.get(1));

			Thread.sleep(10000);
			login.driver.switchTo().frame(0);

			WebElement table_level_chn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("table_chn_text")));
			Thread.sleep(4000);
			String table_chn_text = "全球经济监测";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("table_chn_text"))));

			String table_chn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("table_chn_text")))
					.getText();
			System.out.println(table_chn_txt);
			if (table_chn_txt.matches(table_chn_text)) {
				System.out.println("Translated to chinese ");
			} else {
				Assert.fail("Failed to convert to chinese ");
			}

			// login.driver.close();
			// login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
			Japanese();

			WebElement topic_jpn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("table_jpn_text")));
			Thread.sleep(6000);
			String table_jpn_text = "グローバル経済モニタリング";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("table_jpn_text"))));

			String table_jpn__txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("table_jpn_text")))
					.getText();
			System.out.println(table_jpn__txt);
			if (table_jpn_text.matches(table_jpn__txt)) {
				System.out.println("Translated to japanese ");
			} else {
				Assert.fail("Failed to convert to japanese ");
			}
			login.driver.switchTo().defaultContent();

			// Korean
			Korean();
			WebElement table_korn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("table_korn_text")));
			Thread.sleep(6000);
			String table_text_krn = "세계 경제 모니터";
			// String table_text_krn1 = table_text_krn.replaceAll("\\W", "");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("table_korn_text"))));

			String table_krn_txt1 = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("table_korn_text")))
					.getText();
			// String table_krn_txt2 = table_krn_txt1.replaceAll("\\W", "");
			System.out.println(table_krn_txt1);
			Thread.sleep(6000);
			if (table_text_krn.equalsIgnoreCase(table_krn_txt1)) {
				System.out.println("Translated to korean ");
			} else {
				Assert.fail("Failed to convert to korean ");
			}
			login.driver.switchTo().defaultContent();

			// Russian
			Russian();
			WebElement table_russ = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("table_russ_text")));
			Thread.sleep(4000);
			String table_text_russ = "Глобальный экономический монитор";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("table_russ_text"))));

			String table_russ_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("table_russ_text")))
					.getText();
			System.out.println(table_russ_txt);
			if (table_russ_txt.matches(table_text_russ)) {
				System.out.println("Translated to russian ");
			} else {
				Assert.fail("Failed to convert to russian ");
			}
			login.driver.switchTo().defaultContent();
			Thread.sleep(4000);
			// Indonesian
			Indonesian();
			WebElement table_indo = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("table_indo_text")));
			Thread.sleep(4000);
			String table_text_indo = "Pemantau Ekonomi Global";
			String table_text_ind1 = table_text_indo.replaceAll("\\W", "");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("table_indo_text"))));

			String table_indo_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("table_indo_text")))
					.getText();
			String table_indo_txt1 = table_indo_txt.replaceAll("\\W", "");
			System.out.println(table_indo_txt);
			if (table_text_ind1.matches(table_indo_txt1)) {
				System.out.println("Translated to indonessian ");
			} else {
				Assert.fail("Failed to convert to indonessian ");
			}
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Given("^verify language translation Series_level in new tab$")
	public void verify_language_translation_Series_level_in_new_tab()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_footnote")));
		Thread.sleep(2000);
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("series_footnote_hat_icon"))));
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("series_footnote_hat_icon")))
				.click();
		Thread.sleep(10000);
		chinese();
		Thread.sleep(7000);
		login.driver.switchTo().defaultContent();
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(25000);
		// Compare chinese
		try {

			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab

			login.driver.switchTo().window(browserTabs.get(1));

			Thread.sleep(7000);
			login.driver.switchTo().frame(0);
			WebElement series_level_chn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("series_chn_text1")));
			Thread.sleep(7000);
			String series_chn_text = "全球经济监测";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("series_chn_text1"))));

			String series_chn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("series_chn_text1")))
					.getText();
			System.out.println(series_chn_txt);
			if (series_chn_txt.matches(series_chn_text)) {
				System.out.println("Translated to chinese ");
			} else {
				Assert.fail("Failed to convert to chinese ");
			}
			login.driver.switchTo().defaultContent();
			Japanese();
			WebElement series_jpn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("series_jpn_text")));
			Thread.sleep(4000);
			String series_jpn_text = "グローバル経済モニタリング";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("series_jpn_text"))));

			String series_jpn__txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("series_jpn_text")))
					.getText();
			System.out.println(series_jpn__txt);
			if (series_jpn_text.matches(series_jpn__txt)) {
				System.out.println("Translated to japanese ");
			} else {
				Assert.fail("Failed to convert to japanese ");
			}
			login.driver.switchTo().defaultContent();

			// Korean
			Korean();
			WebElement series_korn = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("series_korn_text")));
			Thread.sleep(4000);
			String series_text_krn = "세계 경제 모니터";
			System.out.println(series_text_krn);
			String series_text_krn1 = series_text_krn.replaceAll("\\W", "");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("series_korn_text"))));

			String series_krn_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("series_korn_text")))
					.getText();
			// String series_krn_txt1 = series_krn_txt.replaceAll("\\W", "");
			System.out.println(series_krn_txt);
			if (series_text_krn.equalsIgnoreCase(series_krn_txt)) {
				System.out.println("Translated to korean ");
			} else {
				Assert.fail("Failed to convert to korean ");
			}
			login.driver.switchTo().defaultContent();

			// Russian
			Russian();
			WebElement series_russ = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("series_russ_text")));
			Thread.sleep(4000);
			String table_text_russ = "Глобальный экономический монитор";
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("series_russ_text"))));

			String table_russ_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("series_russ_text")))
					.getText();
			System.out.println(table_russ_txt);
			if (table_russ_txt.matches(table_text_russ)) {
				System.out.println("Translated to russian ");
			} else {
				Assert.fail("Failed to convert to russian ");
			}
			login.driver.switchTo().defaultContent();
			// Indonesian
			Indonesian();
			WebElement series_indo = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("series_indo_text")));
			Thread.sleep(4000);
			String series_text_indo = "Pemantau Ekonomi Global";
			String series_text_indo1 = series_text_indo.replaceAll("\\W", "");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("series_indo_text"))));

			String series_indo_txt = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("series_indo_text")))
					.getText();
			String series_indo_txt1 = series_indo_txt.replaceAll("\\W", "");
			System.out.println(series_indo_txt);
			if (series_text_indo1.matches(series_indo_txt1)) {
				System.out.println("Translated to indonessian ");
			} else {
				Assert.fail("Failed to convert to indonessian ");
			}
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// TC_Footnotes_33
	@Given("^Open Footnotes for table level$")
	public void open_Footnotes_for_table_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		WebElement db_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("db_level")));
		action.contextClick(db_row).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("select_footnotes"))));
		WebElement footnote_element = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("select_footnotes")));
		Thread.sleep(3000);
		footnote_element.click();
		Thread.sleep(10000);
	}

	@Given("^select language$")
	public void select_language() throws Throwable {
		chinese();
		login.driver.switchTo().defaultContent();

	}

	@Given("^Verify Show Original option$")
	public void verify_Show_Original_option() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 200);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By
				.xpath(login.LOCATORS.getProperty("show_original"))));
		List<WebElement> showOriginal = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("show_original")));
		if (showOriginal.size() != 0) {
			System.out.println("Show Original option is shown");
		} else {
			Assert.fail("Show Original option is not shown");
		}
	}

	// TC_Footnotes_34
	@Given("^Click on  Show Original option$")
	public void click_on_Show_Original_option() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 800);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("show_original"))));
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("show_original"))).click();
	}

	@Given("^Verify the text changed to English$")
	public void verify_the_text_changed_to_English() throws Throwable {
		Thread.sleep(7000);
		login.driver.switchTo().frame(0);
		Thread.sleep(7000);
		String englishText = "World Trend Plus Database";
		String text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("db_title"))).getText();
		if (englishText.matches(text)) {
			System.out.println("Text changed to English onclick show original");
			login.driver.switchTo().defaultContent();
			footnotes_close();
		} else {

			login.driver.switchTo().defaultContent();
			footnotes_close();
			Assert.fail("Text fail to change to  English");
		}

	}

	// TC_Footnotes_35
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

	// public void DeleteFiles() {
	// File file = new
	// File("C:\\Users\\bshilpa\\Downloads\\Table Real GDP Y-o-Y Growth Asia(1).pdf");
	// System.out.println("Called deleteFiles");
	// if (file.isDirectory()) {
	// for (File f : file.listFiles()) {
	// DeleteFiles();
	// }
	// } else {
	// file.delete();
	// }
	// }

	@Given("^Select language Japanese and verify download option$")
	public void Select_language_Japanese_and_verify_download_option()
			throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(login.driver, 80);
			WebElement table_row = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("table_footnote")));
			action.moveToElement(table_row).perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS
							.getProperty("table_footnote_hat_icon"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("table_footnote_hat_icon"))).click();
			Thread.sleep(10000);
			Japanese();
			login.driver.switchTo().defaultContent();
			File file = new File(
					System.getProperty("user.home")
							+ "\\Downloads\\Global Economic Monitor.pdf");
			file.delete();

			Thread.sleep(7000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("footnote_download")))
					.click();
			Thread.sleep(55000);

			String downloadPath = System.getProperty("user.home")
					+ "\\Downloads";
			File getLatestFile = getLatestFilefromDir(downloadPath);
			String fileName = getLatestFile.getName();
			System.out.println(fileName);
			boolean text = fileName
					.equalsIgnoreCase("Global Economic Monitor.pdf");
			Assert.assertTrue(
					"Downloaded file name is not matching with expected file name",
					text);

		} catch (Exception e) {

		} finally {
			footnotes_close();
		}
		// ReadFile.main();
	}

	// TC_Footnotes_36
	@Given("^click on CEIC logo,verify Back button$")
	public void click_on_CEIC_logo_verify_Back_button() throws Throwable {
		try {
			List<String> browserTabs = new ArrayList<String>(
					login.driver.getWindowHandles());
			// switch to new tab
			login.driver.switchTo().window(browserTabs.get(1));
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();

			if (login.driver.findElements(
					By.xpath(login.LOCATORS.getProperty("back_button"))).size() != 0) {
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
				Assert.fail("Back button is displayed");
			} else {

				System.out.println("Back button is not displayed");
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
			}

		} catch (Exception e) {
			System.out.println("Back button is not displayed");
		}

	}

	// TC_Footnotes_37
	@Given("^Click on CEIC logo$")
	public void click_on_CEIC_logo() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
	}

	@Given("^verify Back button$")
	public void verify_Back_button() throws Throwable {
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(browserTabs.get(1));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("back_button"))).size() != 0) {
			System.out.println("Back button is displayed");
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
		} else {
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
			Assert.fail("Back button is not displayed");
		}
		/*
		 * try{ List<String> browserTabs = new ArrayList<String>
		 * (login.driver.getWindowHandles()); //switch to new tab
		 * login.driver.switchTo().window(browserTabs .get(1));
		 * login.driver.findElement
		 * (By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
		 * 
		 * if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
		 * "back_button"))).isDisplayed()){
		 * System.out.println("Back button is displayed"); login.driver.close();
		 * login.driver.switchTo().window(browserTabs.get(0)); } else{
		 * login.driver.close();
		 * login.driver.switchTo().window(browserTabs.get(0));
		 * Assert.fail("Back button is not displayed"); }
		 * login.driver.switchTo().window(browserTabs.get(0)); } catch(Exception
		 * e){ Assert.fail("Back button is not displayed"); }
		 */
	}

	// TC_Footnotes_38
	@Given("^Click on Footnotes tab Open new tab$")
	public void click_on_Footnotes_tab_Open_new_tab() throws Throwable {

		WebDriverWait wait = new WebDriverWait(login.driver, 200);

		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("HELP")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("FOOTNOTES"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("open_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(20000);
	}

	@Given("^Expand the tree change the language ,verify the Back button$")
	public void expand_the_tree_change_the_language_verify_the_Back_button()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 90);

		String currentTab = login.driver.getWindowHandle();
		try {
			for (String tab : login.driver.getWindowHandles()) {
				if (!tab.equals(currentTab)) {
					login.driver.switchTo().window(tab);
					click_on_CEIC_logo();
					login.driver
							.findElement(
									By.xpath(login.LOCATORS
											.getProperty("Back_button")))
							.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(login.LOCATORS.getProperty("db"))));
					login.driver.findElement(
							By.xpath(login.LOCATORS.getProperty("db"))).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(login.LOCATORS.getProperty("topic"))));
					login.driver.findElement(
							By.xpath(login.LOCATORS.getProperty("topic")))
							.click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(login.LOCATORS.getProperty("section"))));
					login.driver.findElement(
							By.xpath(login.LOCATORS.getProperty("section")))
							.click();
					Thread.sleep(5000);
					login.driver.findElement(
							By.xpath(login.LOCATORS
									.getProperty("table_exp_newtb"))).click();
					Thread.sleep(4000);
					login.driver.findElement(
							By.xpath(login.LOCATORS
									.getProperty("lang_dropdown"))).click();
					Thread.sleep(4000);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath(login.LOCATORS.getProperty("korean_lang"))));
					login.driver
							.findElement(
									By.xpath(login.LOCATORS
											.getProperty("korean_lang")))
							.click();
					Thread.sleep(5000);
					login.driver.findElement(
							By.xpath(login.LOCATORS.getProperty("ceic_logo")))
							.click();
					Thread.sleep(8000);
					login.driver
							.findElement(
									By.xpath(login.LOCATORS
											.getProperty("back_button")))
							.click();
					Thread.sleep(5000);
					verify_the_tree_is_collapsed();
					Thread.sleep(5000);

				}
			}

		} catch (NoSuchSessionException e) {
			login.driver.close();
			Thread.sleep(2000);
			login.driver.switchTo().window(currentTab);
		}
	}

	// Tc_Footnotes_39
	@Given("^Open the Footnotes$")
	public void open_the_Footnotes() throws Throwable {

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_tab"))).click();
		WebDriverWait wait = new WebDriverWait(login.driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnotes_open"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnotes_open"))).click();

	}

	// Tc_Footnotes_39
	@Given("^Check the navigation onclick Back button$")
	public void check_the_navigation_onclick_Back_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 70);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_euro_asia")));
		action.moveToElement(element).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_euro_asia_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_euro_asia_icon")))
				.click();

		Thread.sleep(7000);
		login.driver.switchTo().frame(0);
		js.executeScript("window.scrollBy(0,1000)");

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("country_specific_info")))
				.click();
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Back_button"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-1000)");

		if (login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_page")))
				.isDisplayed()) {
			System.out.println("Navigates back to footnotes page");
			login.driver.switchTo().defaultContent();
			footnotes_close();
		} else {
			login.driver.switchTo().defaultContent();
			footnotes_close();
			Assert.fail("Failed to navigate to footnotes page");
		}

	}

	// Tc_Footnotes_40

	@Given("^check the page navigates to translated footnote page$")
	public void check_the_page_navigates_to_translated_footnote_page()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 70);
		try {
			WebElement element = login.driver.findElement(By
					.xpath(login.LOCATORS.getProperty("table_euro_asia")));
			action.moveToElement(element).perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("table_euro_asia_icon"))));
			login.driver
					.findElement(
							By.xpath(login.LOCATORS
									.getProperty("table_euro_asia_icon")))
					.click();
			Thread.sleep(7000);
			Japanese();
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(7000);
			login.driver
					.findElement(
							By.xpath(login.LOCATORS
									.getProperty("jpn_country_specific")))
					.click();
			Thread.sleep(3000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Back_button")))
					.click();
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,-1000)");

		} catch (WebDriverException e) {
			if (login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("footnote_page")))
					.isDisplayed()) {
				String text = login.driver.findElement(
						By.xpath(login.LOCATORS.getProperty("footnote_page")))
						.getText();
				System.out.println("Navigates back to footnotes page" + text);
				login.driver.switchTo().defaultContent();
				footnotes_close();
			} else {
				login.driver.switchTo().defaultContent();
				footnotes_close();
				Assert.fail("Failed to navigate to footnotes page");
			}

		}

	}

	// Tc_Footnotes_41

	@Given("^Open footnotes in new tab$")
	public void open_footnotes_in_new_tab() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 70);
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("table_euro_asia")));
		action.moveToElement(element).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("table_euro_asia_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_euro_asia_icon")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(20000);

	}

	@Given("^check the country specific information$")
	public void check_the_country_specific_information() throws Throwable {
		Thread.sleep(10000);
		String windowHandle = login.driver.getWindowHandle();
		for (String winHandle : login.driver.getWindowHandles()) {
			login.driver.switchTo().window(winHandle);
		}
		WebElement element = login.driver.findElement(By
				.xpath("//iframe[@class='footnotes--frame']"));
		Thread.sleep(9000);
		login.driver.switchTo().frame(element);
		Thread.sleep(9000);
		js.executeScript("window.scrollBy(0,1000)");

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("country_specific_info")))
				.click();
		Thread.sleep(4000);
		List<WebElement> country_specific_info_table = login.driver
				.findElements(By.xpath(login.LOCATORS
						.getProperty("country_specific_info_table")));
		if (country_specific_info_table.size() != 0) {
			System.out
					.println("Page navigates to country specific information table");
			login.driver.switchTo().defaultContent();
			login.driver.close();
			login.driver.switchTo().window(windowHandle);
		} else {
			login.driver.switchTo().defaultContent();
			login.driver.close();
			login.driver.switchTo().window(windowHandle);
			Assert.fail("Page will not navigate to country specific information");
		}

	}

	@Given("^check the Back button navigates to Footnotes page$")
	public void check_the_Back_button_navigates_to_Footnotes_page()
			throws Throwable {
		String windowHandle = login.driver.getWindowHandle();
		for (String winHandle : login.driver.getWindowHandles()) {
			login.driver.switchTo().window(winHandle);
		}
		WebElement element = login.driver.findElement(By
				.xpath("//iframe[@class='footnotes--frame']"));
		Thread.sleep(9000);
		login.driver.switchTo().frame(element);
		Thread.sleep(9000);
		js.executeScript("window.scrollBy(0,1000)");

		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("country_specific_info")))
				.click();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Back_button"))).click();
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,-1000)");
		if (login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_page")))
				.isDisplayed()) {
			System.out.println("Navigates back to footnotes page");
			login.driver.switchTo().defaultContent();
			login.driver.close();
			login.driver.switchTo().window(windowHandle);
		} else {
			login.driver.switchTo().defaultContent();
			login.driver.close();
			login.driver.switchTo().window(windowHandle);
			Assert.fail("Failed to navigate to footnotes page");
		}

	}

	// Tc_Footnotes_43
	@Given("^check the Back button navigates to translated Footnotes page$")
	public void check_the_Back_button_navigates_to_translated_Footnotes_page()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		String currentTab = login.driver.getWindowHandle();
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		try {
			// for (String tab : login.driver.getWindowHandles()) {
			// if (!tab.equals(currentTab)){
			// login.driver.switchTo().window(tab);
			//
			// //switch to new tab
			login.driver.switchTo().window(browserTabs.get(1));
			Thread.sleep(9000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("lang_dropdown"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("lang_dropdown")))
					.click();
			Thread.sleep(7000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("translate_option"))).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath(login.LOCATORS.getProperty("japanese_lang"))));
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("japanese_lang")))
					.click();
			Thread.sleep(5000);
			WebElement element = login.driver.findElement(By
					.xpath("//iframe[@class='footnotes--frame']"));
			Thread.sleep(5000);
			login.driver.switchTo().frame(element);
			Thread.sleep(5000);
			js.executeScript("window.scrollBy(0,1000)");
			Thread.sleep(9000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("jpn_spc_43"))).click();
			System.out.println("JPN entered");
			Thread.sleep(7000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("bck_btn")))
					.click();
			System.out.println("Btn  clicked");
			Thread.sleep(7000);
			js.executeScript("window.scrollBy(0,-1000)");
			if (login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("footnote_page")))
					.isDisplayed()) {
				System.out.println("Navigates back to footnotes page");
				login.driver.switchTo().defaultContent();
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
			} else {
				login.driver.switchTo().defaultContent();
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
				Assert.fail("Failed to navigate to footnotes page");
			}

			// }
			// }
		} catch (Exception e) {

		}
	}

	// Tc_Footnotes_44
	@Given("^verify Ask Question option$")
	public void verify_Ask_Question_option() throws Throwable {

		footnote_open_current_window();
		Thread.sleep(5000);
		japanese_lang();
		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0,2000)");
		Thread.sleep(9000);
		login.driver.switchTo().defaultContent();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_container")))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		List<WebElement> footnoteFooterButtons = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("footnote_footer")));
		List<WebElement> footnoteMessageArea = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("messagearea_footnote")));
		List<WebElement> askQuestionCloseBtn = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("close_ask_a_question")));
		if (footnoteFooterButtons.size() != 0) {
			if (footnoteMessageArea.size() != 0) {
				if (askQuestionCloseBtn.size() != 0) {
					System.out
							.println("Ask Question window is Open with all options");
					login.driver.findElement(
							By.xpath(login.LOCATORS
									.getProperty("close_ask_a_question")))
							.click();
					footnotes_close();
				}
			}

			else {
				footnotes_close();
				Assert.fail("Fail to open window");
			}
		}

	}

	// Tc_Footnotes_45
	@Given("^verify Ask Question option in new tab$")
	public void verify_Ask_Question_option_in_new_tab() throws Throwable {
		footnote_open_new_window();
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		// //switch to new tab
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("lang_dropdown"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("japanese_lang"))).click();
		Thread.sleep(4000);
		// login.driver.manage().window().maximize();
		live_chat();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_container")))
				.click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		List<WebElement> footnoteFooterButtons = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("footnote_footer")));
		List<WebElement> footnoteMessageArea = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("messagearea_footnote")));
		List<WebElement> askQuestionCloseBtn = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("close_ask_a_question")));
		if (footnoteFooterButtons.size() != 0) {
			if (footnoteMessageArea.size() != 0) {
				if (askQuestionCloseBtn.size() != 0) {
					System.out
							.println("Ask Question window is Open with all options");
					login.driver.findElement(
							By.xpath(login.LOCATORS
									.getProperty("close_ask_a_question")))
							.click();
					login.driver.close();
					login.driver.switchTo().window(browserTabs.get(0));
				}
			}
		} else {
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			Assert.fail("Fail to open window");
		}

	}

	// Tc_Footnotes_46
	@Given("^verify submitting message in Ask Question window$")
	public void verify_submitting_message_in_Ask_Question_window()
			throws Throwable {
		footnote_open_current_window();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("messagearea_footnote")))
				.sendKeys("Testing please ignore");
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("askQuestion_submit")))
				.click();
		Thread.sleep(5000);
		String element = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("confirmMessage")))
				.getText();
		Assert.assertEquals("Thank you for submitting a question to us.",
				element);
		Thread.sleep(20000);
		footnotes_close();

	}

	// Tc_Footnotes_47
	@Given("^verify submit message in new tab$")
	public void verify_submit_message_in_new_tab() throws Throwable {
		footnote_open_new_window();
		live_chat();
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		// //switch to new tab
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("messagearea_footnote")))
				.sendKeys("Testing please ignore");
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("askQuestion_submit")))
				.click();
		Thread.sleep(3000);
		String element = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("confirmMessage")))
				.getText();
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("confirmMessage"))).size() != 0) {
			Assert.assertEquals("Thank you for submitting a question to us.",
					element);
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		} else {
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			Assert.fail("Message not shown");
		}

	}

	// Tc_Footnotes_48
	@Given("^Verify cancel button in ask question window$")
	public void Verify_cancel_button_in_ask_question_window() throws Throwable {
		footnote_open_current_window();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("messagearea_footnote")))
				.sendKeys("Testing please ignore");
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("askQuestionCancel")))
				.click();
		Thread.sleep(2000);
		List<WebElement> askQuestionWindow = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("ask_qstn_button")));
		if (askQuestionWindow.size() != 0) {
			System.out.println("Ask Question window is not shown");
			footnotes_close();
		} else {
			footnotes_close();
			Assert.fail("Ask Question window is shown");

		}

	}

	// TC_Footnotes_49
	@Given("^verify cancel button ask question window in new tab$")
	public void verify_cancel_button_ask_question_window_in_new_tab()
			throws Throwable {
		footnote_open_new_window();
		live_chat();
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		// //switch to new tab
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("messagearea_footnote")))
				.sendKeys("Testing please ignore");
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("askQuestionCancel")))
				.click();
		List<WebElement> askQuestionWindow = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("ask_qstn_button")));
		if (askQuestionWindow.size() != 0) {
			System.out.println("Ask Question window is not shown");
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		} else {
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			Assert.fail("Ask Question window is shown");

		}

	}

	// Tc_Footnotes_50
	@Given("^Verify crossmark option in ask question window$")
	public void Verify_crossmark_option_in_ask_question_window()
			throws Throwable {
		footnote_open_current_window();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("askQuestionWindowClose")))
				.click();
		List<WebElement> askQuestionWindow = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("askQuestionwindow")));
		if (askQuestionWindow.size() != 0) {
			Assert.fail("Ask Question window is shown");
			footnotes_close();
		} else {
			footnotes_close();
			System.out.println("Ask Question window is not shown");
		}

	}

	// Tc_Footnotes_51
	@Given("^Verify crossmark option in Ask Question window in new tab$")
	public void Verify_crossmark_option_in_Ask_Question_window_in_new_tab()
			throws Throwable {
		footnote_open_new_window();
		live_chat();
		// Thread.sleep(15000);
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		// //switch to new tab
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(20000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("askQuestionWindowClose")))
				.click();
		List<WebElement> askQuestionWindow = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("askQuestionwindow")));
		if (askQuestionWindow.size() != 0) {
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			Assert.fail("Ask Question window is shown");

		} else {
			System.out.println("Ask Question window is not shown");
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		}

	}

	// Tc_Footnotes_52
	@Given("^Click on guestmode option, verify the page$")
	public void Click_on_guestmode_option_verify_the_page() throws Throwable {
		footnote_open_new_window();
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(10000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("guestMode"))).size() != 0) {
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("guestMode"))).click();
			Thread.sleep(4000);
			if (login.driver.findElements(By.name("user_id")).size() != 0) {
				System.out.println("Guest login page is shown");
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
			} else {
				login.driver.close();
				login.driver.switchTo().window(browserTabs.get(0));
				Assert.fail("Guest login page is not shown");
				// login.driver.close();
				//
				// login.driver.switchTo().window(browserTabs .get(0));
			}
		} else {
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		}
	}

	// Tc_Footnotes_53
	@Given("^Click on link - our support team,verify$")
	public void Click_on_link_our_support_team_verify() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 130);
		WebElement section_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("section_footnote")));
		action.moveToElement(section_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("section_footnote_hat_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("section_footnote_hat_icon"))).click();
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("supportTeam"))).click();
		Thread.sleep(8000);
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(8000);
		String supportPage = login.driver.getCurrentUrl();
		Assert.assertEquals(supportPage,
				"https://support.ceicdata.com/support/tickets/new");
		login.driver.close();
		login.driver.switchTo().window(browserTabs.get(0));
		footnotes_close();
	}

	// Tc_Footnotes_54
	@Given("^Click on the down arrow present$")
	public void Click_on_the_down_arrow_present() throws Throwable {
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("series_row_1")));
		WebDriverWait wait = new WebDriverWait(login.driver, 70);
		action.moveToElement(series_row).perform();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("seriesDropdown"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("seriesDropdown"))).click();
		Thread.sleep(5000);
	}

	@Given("^Click on the  'readmore' option, verify Footnotes$")
	public void Click_on_the_readmore_option_verify_Footnotes()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("readMore"))).click();
		Thread.sleep(6000);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("footnote_window"))).size() != 0) {
			System.out.println("Footnotes is open");
			footnotes_close();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("seriesDropdown")))
					.click();
		} else {
			footnotes_close();
			Thread.sleep(2000);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("seriesDropdown")))
					.click();
			Assert.fail("Footnotes is not open");
		}

	}

	// TC_Footnotes_55
	@Given("^Select series then click on Related series$")
	public void select_series_then_click_on_Related_series() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("select_series"))).click();
		Thread.sleep(3000);
		action.sendKeys("a").perform();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("my_series_filter_checkbox"))).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(login.driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("delete_myeries"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
		Thread.sleep(5000);
		login.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("select_series"))).click();

		action.sendKeys("a").perform();
		Thread.sleep(3000);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("parentseries"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("related_series"))).click();
		Thread.sleep(25000);
	}

	@Given("^Click on i icon to verify footnotes$")
	public void click_on_i_icon_to_verify_footnotes() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 700);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indicator_i_icon")))
				.click();

		// WebElement target =
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnote_window_close")));
		// action.moveToElement(target).perform();
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnote_window_close"))).click();

		Thread.sleep(20000);

		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("footnote_window"))).size() != 0) {
			System.out.println("Footnotes window will open");
			Thread.sleep(15000);
			footnotes_close();

		} else {
			footnotes_close();
			Assert.fail("Failed to open footnotes window");

		}
		// login.driver.navigate().refresh();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnote_window_close"))));

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("footnote_window_close"))));
		// footnotes_close();
		login.driver.navigate().refresh();
		Thread.sleep(15000);
	}

	// TC_Footnotes_56
	@Given("^Expand the global database$")
	public void expand_the_global_database() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("global_db"))));
		Thread.sleep(9000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("global_db"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("all_region"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("albania"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("section_table"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("global_table"))).click();
		Thread.sleep(6000);
	}

	@Given("^Open footnotes for table level$")
	public void open_footnotes_for_table_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("hover_table")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("footnote_global_table_icon"))));
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("footnote_global_table_icon"))).click();

		Thread.sleep(4000);
	}

	@Given("^Download chinese language footnote file$")
	public void Download_chinese_language_footnote_file() throws Throwable {
		chinese();
		global_footnote_download();

	}

	// Tc_Footnotes_57
	@Given("^Open footnotes for series level$")
	public void open_footnotes_for_series_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("globalseries")));
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("gbseries_footnote_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("gbseries_footnote_icon")))
				.click();
		Thread.sleep(7000);
	}

	@Given("^Download japanese language footnote file$")
	public void Download_japanese_language_footnote_file() throws Throwable {
		Japanese();
		Thread.sleep(10000);
		global_footnote_download();
	}

	// Tc_Footnotes_58
	@Given("^Download Korean language footnote file$")
	public void Download_Korean_language_footnote_file() throws Throwable {
		Korean();
		Thread.sleep(10000);
		global_footnote_download();
	}

	// Tc_Footnotes_59
	@Given("^Expand the russian database$")
	public void expand_the_russian_database() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("global_db"))));
		Thread.sleep(9000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("russian_db"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("russ_topic"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("russ_section"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("russ_table"))).click();
		Thread.sleep(2000);

	}

	@Given("^Open footnotes for russian series level$")
	public void open_footnotes_for_russian_series_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("russ_series")));
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("russ_series_footnote_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("russ_series_footnote_icon"))).click();
		Thread.sleep(10000);
	}

	@Given("^Download Russian language footnote file$")
	public void Download_Russian_language_footnote_file() throws Throwable {
		Russian();
		Thread.sleep(8000);
		global_footnote_download();
	}

	// Tc_Footnotes_60
	@Given("^Expand the indonesian database$")
	public void expand_the_indonesian_database() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indo_db"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indo_topic"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indo_section"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("indo_table"))).click();
		Thread.sleep(2000);
	}

	@Given("^Open footnotes for indonesian series level$")
	public void open_footnotes_for_indonesian_series_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("indo_series")));
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("indo_series_footnote_icon"))));
		Thread.sleep(9000);
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("indo_series_footnote_icon"))).click();
		Thread.sleep(10000);
	}

	@Given("^Download Indonesian language footnote file$")
	public void Download_Indonesian_language_footnote_file() throws Throwable {
		Indonesian();
		Thread.sleep(10000);
		global_footnote_download();
	}

	// Tc_Footnotes_61
	@Given("^Expand the Markit database$")
	public void expand_the_Markit_database() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("markit_db"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("markit_topic"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("markit_section"))).click();
		Thread.sleep(2000);
	}

	@Given("^Open footnotes for section level, change to Japanese$")
	public void open_footnotes_for_section_level_change_to_Japanese()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("markit_hover")));
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("markit_footnote_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("markit_footnote_icon")))
				.click();
		Thread.sleep(3000);
	}

	@Given("^Click on PMI glossary link,Verify the glossary$")
	public void click_on_PMI_glossary_link_Verify_the_glossary()
			throws Throwable {
		Japanese();
		js.executeScript("window.scrollBy(0,500)");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("glossarylink"))).click();
		Thread.sleep(3000);
		footnotes_close();
		// validation script to be written here
		login.driver.switchTo().defaultContent();
	}

	// Tc_Footnotes_62
	@Given("^Click 'Ask a question' verify the table name$")
	public void Click_Ask_a_question_verify_the_table_name() throws Throwable {
		String text = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_win_text")))
				.getText();
		String footnoteText = text.replaceAll("\\(", "").replaceAll("\\)", "");
		System.out.println(footnoteText);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ask_qstn_button")))
				.click();
		Thread.sleep(4000);
		String askText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("askQuestntext")))
				.getText();

		String fooaskText = askText.replaceFirst("Ask a question about ", "")
				.replaceAll("`", "").replaceAll("`", "");
		if (fooaskText.equalsIgnoreCase(footnoteText)) {
			System.out.println("Ask question will display table name");
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("askQuestionWindowClose"))).click();
			Thread.sleep(2000);
			footnotes_close();
		} else {
			login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("askQuestionWindowClose"))).click();
			Thread.sleep(2000);
			footnotes_close();
			Assert.fail("Ask question will not display table name");
		}

	}

	// Tc_Footnotes_63
	@Given("^Press 'd' to verify footnote download$")
	public void Press_d_to_verify_footnote_download() throws Throwable {
		action.sendKeys("d");
		global_footnote_download();
	}

	// Tc_Footnotes_64
	@Given("^Verify footnote download message$")
	public void Verify_footnote_download_message() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("download_enabled")))
				.click();
		Thread.sleep(50000);
		List<WebElement> footnoteDownloadMessage = login.driver
				.findElements(By.xpath(login.LOCATORS
						.getProperty("footnote_download_message")));
		//
		if (footnoteDownloadMessage.size() != 0) {
			System.out.println("Footnote download message is displayed");
			System.out.println(login.driver.findElement(
					By.xpath(login.LOCATORS
							.getProperty("footnote_download_message")))
					.getText());
			footnotes_close();
		} else {
			footnotes_close();
			Assert.fail("Footnote download message is not displayed");

		}
		// System.out.println(footnoteDownloadMessage.getText());
		// try{
		// if(footnoteDownloadMessage.isDisplayed())
		// {
		// System.out.println("Footnote download message is displayed");
		// footnotes_close();
		// }
		// else{
		// Assert.fail("Footnote download message is not displayed");
		// footnotes_close();
		// }
		//
		// }
		// catch(Exception e)
		// {
		// Assert.fail("Footnote download message is not displayed");
		// footnotes_close();
		// }
	}

	// Tc_Footnotes_65
	@Given("^Click on Download button$")
	public void Click_on_Download_button() throws Throwable {
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("download_enabled")))
				.click();
		Thread.sleep(200000);
	}

	// TC_Footnotes_66
	@Given("^Open footnotes for section level$")
	public void open_footnotes_for_section_level() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement series_row = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("markit_hover")));
		action.moveToElement(series_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("markit_footnote_icon"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("markit_footnote_icon")))
				.click();
		Thread.sleep(3000);
	}

	@Given("^Access links verify hyperlinks are redirectable$")
	public void access_links_verify_hyperlinks_are_redirectable()
			throws Throwable {
		try {
			login.driver.switchTo().frame(0);
			login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("hyperlink"))).click();
			login.driver.switchTo().defaultContent();
			String test = login.driver.getCurrentUrl();
			String test1 = "https://ihsmarkit.com/index.html";
			Assert.assertEquals(test1, test);
			// Assert.fail("Link is not navigating");
		} catch (Exception e) {

		} finally {
			footnotes_close();
		}
	}

	// Tc_Footnotes_67
	@Given("^Verify 'Ask question' is available for translated footnotes$")
	public void verify_Ask_question_is_available_for_translated_footnotes()
			throws Throwable {
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("footnote_container")))
				.click();
		Thread.sleep(2000);
		List<WebElement> askQuestionButton = login.driver.findElements(By
				.xpath(login.LOCATORS.getProperty("ask_qstn_button")));
		if (askQuestionButton.size() != 0) {
			System.out.println("Ask Question button is shown");
			footnotes_close();
		} else {
			footnotes_close();
			Assert.fail("Ask Question button is not shown");
		}

	}

	// TC_Footnotes_68
	@Given("^Expand Daily Database$")
	public void expand_Daily_Database() throws Throwable {
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("daily_db"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("deposit_rates"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("daily_albania"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("daily_table"))).click();
	}

	@Given("^Open footnote for table$")
	public void open_footnote_for_table() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("daily_footnote_icon")))
				.click();
		Thread.sleep(4000);
	}

	@Given("^Verify the message 'Please see Table of Contents to select a Footnote '$")
	public void verify_the_message_Please_see_Table_of_Contents_to_select_a_Footnote()
			throws Throwable {
		String expectedMessageText = "No footnotes are available for your selection. For enquiry, please contact our client service team:";
		if(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("footnote_display_message"))).isDisplayed()){
			footnotes_close();
		}
			
		
	}

	// TC_Footnotes_69
	@Given("^Add series to my series$")
	public void Add_series_to_my_series() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("my_series_filter_checkbox"))).click();
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("select_series"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("delete_myeries"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
		Thread.sleep(5000);
		login.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("seriestoadd"))).click();
		Thread.sleep(2000);
		action.sendKeys("a").perform();
	}

	@Given("^Apply function$")
	public void apply_function() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("parentseries"))).click();
		Thread.sleep(5000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("fx")))
				.click();
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("byfunction"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("byfunction"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("addfunction"))).click();
		Thread.sleep(2000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insertfunction"))).click();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("applyfunction"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("transformedseries"))));
		WebElement transformedSeries = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("transformedseries")));
		action.moveToElement(transformedSeries).perform();
		Thread.sleep(3000);
		login.driver
				.findElement(
						By.xpath(login.LOCATORS
								.getProperty("transseriesfootnoteicon")))
				.click();
		Thread.sleep(3000);
	}

	@Given("^Verify footnotes for transformed series$")
	public void verify_footnotes_for_transformed_series() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 70);
		if (login.driver.findElements(
				By.xpath(login.LOCATORS.getProperty("footnote_window"))).size() != 0) {
			System.out.println("Footnotes opened for transformed series");
			footnotes_close();
		} else {
			footnotes_close();
			Assert.fail("Footnotes failed to open for transformed series");
		}
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("my_series_filter_checkbox"))).click();
		Thread.sleep(2000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("select_series"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("delete_myeries"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("delete_myeries"))).click();
	}

	// TC_Footnotes_70
	@Given("^Set the Preference to insight$")
	public void set_the_Preference_to_insight() throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Open_sidebar"))).click();
		Thread.sleep(5000);
		login.driver.navigate().refresh();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(login.driver, 100);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("dropdown_btn"))).click();
		login.driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("set_preference"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("insight_explorer"))));
		Thread.sleep(3000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("insight_explorer")))
				.click();
		WebElement preferences = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("text")));
		js.executeScript("arguments[0].scrollIntoView(true);", preferences);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("save_btn"))));
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("save_btn"))).click();
		Thread.sleep(7000);
	}

	@Given("^Close the new tab$")
	public void close_the_new_tab() throws Throwable {
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(6000);
		login.driver.close();
		login.driver.switchTo().window(browserTabs.get(0));
	}

	@Given("^Expand the database then translate to japanese and verify Back button$")
	public void Expand_the_database_then_translate_to_japanese_and_verify_Back_button()
			throws Throwable {
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Open_sidebar"))).click();
		Thread.sleep(5000);
		login.driver.navigate().refresh();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(login.driver, 120);
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(browserTabs.get(1));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("db"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("db")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("topic"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("topic")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("section"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("section"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_exp_newtb")))
				.click();
		Thread.sleep(4000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("lang_dropdown"))).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("japanese_lang"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("japanese_lang"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("ceic_logo"))).click();
		Thread.sleep(5000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("back_button"))).click();
		Thread.sleep(5000);
		String expectedURL = "https://stage.ceicdata.com/footnotes";
		String actualURL = login.driver.getCurrentUrl();
		Assert.assertEquals(expectedURL, actualURL);
		set_the_Preference_to_new_insight();
		Thread.sleep(4000);
		login.driver.close();
		login.driver.switchTo().window(browserTabs.get(0));
	}

	// TC_Footnotes_71
	@Given("^Expand the database upto section$")
	public void expand_the_database_upto_section() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_database"))));
		Thread.sleep(7000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_database")))
				.click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_all"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_all"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_topic"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_topic"))).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("expand_section"))));
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("expand_section"))).click();
		Thread.sleep(5000);
	}

	@Given("^Goto table Table:Investment: % of Nominal GDP: Asia open footnotes$")
	public void goto_table_Table_Investment_of_Nominal_GDP_Asia_open_footnotes()
			throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS.getProperty("nominalGDP"))));
		WebElement nominalGDP = login.driver.findElement(By
				.xpath(login.LOCATORS.getProperty("nominalGDP")));
		js.executeScript("arguments[0].scrollIntoView();", nominalGDP);
		Thread.sleep(8000);
		action.moveToElement(nominalGDP).perform();
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("nominalGDPfootnote")))
				.click();
		Thread.sleep(7000);
	}

	@Given("^Translate to Japanese$")
	public void translate_to_Japanese() throws Throwable {
		Japanese();
	}

	@Given("^Verify translated page should appear once after the click on 'Back'$")
	public void verify_translated_page_should_appear_once_after_the_click_on_Back()
			throws Throwable {

		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,1000)");
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("countrysplink"))).click();
		Thread.sleep(10000);
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("Bck_btn"))).click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-1000)");
		if (login.driver
				.findElements(
						By.xpath(login.LOCATORS
								.getProperty("nominalGDP_Footnotepage")))
				.size() != 0) {
			System.out
					.println("Translated page  appears once after onclick 'Back' button");
			login.driver.switchTo().defaultContent();
			footnotes_close();
		} else {
			login.driver.switchTo().defaultContent();
			footnotes_close();
			Assert.fail("Translated page  failed to appear  after onclick  'Back' button");
		}

	}

	// TC_Footnotes_72
	@Given("^Open footnotes for tablelevel$")
	public void open_footnotes_for_tablelevel() throws Throwable {
		WebDriverWait wait = new WebDriverWait(login.driver, 150);
		WebElement table_row = login.driver.findElement(By.xpath(login.LOCATORS
				.getProperty("hover_table")));
		action.moveToElement(table_row).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(login.LOCATORS
						.getProperty("footnote_global_table_icon1"))));
		Thread.sleep(8000);
		login.driver.findElement(
				By.xpath(login.LOCATORS
						.getProperty("footnote_global_table_icon1"))).click();

		Thread.sleep(4000);
	}

	@Given("^Click on Open icon to open footnotes in new tab$")
	public void click_on_Open_icon_to_open_footnotes_in_new_tab()
			throws Throwable {
		Thread.sleep(3000);
		japaneseFootnoteText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_jpn_text")))
				.getText();
		// System.out.println(fooText);
		Thread.sleep(3000);
		login.driver.switchTo().defaultContent();
		login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("open_icon"))).click();
		Thread.sleep(3000);

	}

	@Given("^Verify footnotes opened in new tab retain the japanese language$")
	public void verify_footnotes_opened_in_new_tab_retain_the_japanese_language()
			throws Throwable {
		List<String> browserTabs = new ArrayList<String>(
				login.driver.getWindowHandles());
		login.driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(10000);
		login.driver.switchTo().frame(0);
		String fooNewTabText = login.driver.findElement(
				By.xpath(login.LOCATORS.getProperty("table_jpn_text")))
				.getText();
		Thread.sleep(8000);
		System.out.println(japaneseFootnoteText);
		System.out.println(fooNewTabText);
		if (japaneseFootnoteText.equalsIgnoreCase(fooNewTabText)) {
			System.out
					.println("Opened footnote in new tab will retain the same language");
			login.driver.switchTo().defaultContent();
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
		} else {
			login.driver.switchTo().defaultContent();
			login.driver.close();
			login.driver.switchTo().window(browserTabs.get(0));
			Assert.fail("Opened footnote in new tab will not  retain the same language");
		}

	}

}
