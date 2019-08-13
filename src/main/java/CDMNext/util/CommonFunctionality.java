package CDMNext.util;

import java.io.File;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import CDMNext.StepDefinations.login;

public class CommonFunctionality {
	public static WebElement footnoteDb;
	public static String sname;
	public static int SeriesCount;
	public static int m;
	// create object of Actions class
	public static Actions action = new Actions(login.driver);
	// create instance of JavaScriptExecutor
	public static JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	static WebDriverWait wait = new WebDriverWait(login.driver, 60);
	public static String manage_series_id;

	public static void ClearSelection() throws InterruptedException {
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
			login.Log4j.info("Clicking on Top button");
		}
		if (reset.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
				login.Log4j.info("Clicking on Reset button");
			}
		}
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).isDisplayed()) {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).click();
			login.Log4j.info("Clicking on Unselect button");
		}

	}

	public static void ResetMethod() throws InterruptedException {
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		try {
			if (reset.size() > 0) {
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
					Thread.sleep(2000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
					login.Log4j.info("Clicking on Reset button");
				}
			}
		} catch (Exception e) {

		}
	}

	public static void UnselectMethod() throws InterruptedException {
		Thread.sleep(5000);
		WebElement unselect = login.driver.findElement(By.xpath("//div[contains(text(),'Unselect')]"));
		if (unselect.isDisplayed()) {
			unselect.click();
		}
	}

	public static void CollapseTreeMethod() throws InterruptedException {
		Thread.sleep(2000);
		try {
			WebElement collapseTree = login.driver.findElement(By.xpath("//span[@title='Collapse tree']"));
			if (collapseTree.isDisplayed()) {
				collapseTree.click();
				login.Log4j.info("Clicking on collapseTree");
			}
		} catch (Exception e) {

		}
	}

	public static void DeleteVisual() throws InterruptedException {
		// Deleting visual
		Thread.sleep(3000);
		WebElement ele = login.driver.findElement(By.xpath(
				"//div[@class='insight-page-menu-views-container--view-tabs ui-sortable']//a[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"));
		action.contextClick(ele).build().perform();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Delete view')]")).click();
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
	}

	public static void DeleteSeries() throws InterruptedException {
		try {
			// Deleting series from My Series tab
			Thread.sleep(3000);
			WebElement ele = login.driver
					.findElement(By.xpath("//div[@class='check-all-series']//span[@class='input-control--indicator']"));
			action.moveToElement(ele).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@data-action='delete']")).click();
		} catch (Exception e) {

		}
	}

	public static void TopMethod() throws InterruptedException {
		Thread.sleep(3000);
		WebElement topButton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton")));
		if (topButton.isDisplayed()) {
			topButton.click();
			login.Log4j.info("Clicking on Top button");
		}
	}

	public static void RightClickOnAnySeries() throws InterruptedException {
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			// int j = i + 1;
			m = i + 1;
			Thread.sleep(3000);
			WebElement checkbox = login.driver
					.findElement(By.xpath("//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			WebElement ele = login.driver.findElement(By.xpath("//li[" + m + "]//div[@class='series-item--name']"));
			if (i == 4) {
				Thread.sleep(2000);
				CommonFunctionality.action.contextClick(ele).build().perform();
				break;
			}
		}
	}

	public static void SelectedSeriessCount() {
		try {
			WebElement count = login.driver.findElement(By.xpath("//span[@class='search-input--selected-count']"));
			SeriesCount = Integer.parseInt(count.getText());
			login.Log4j.info(SeriesCount);
		} catch (NumberFormatException e) {
			login.Log4j.info(e.getMessage());
		}
	}

	public static void AlldbClear() throws InterruptedException {
		List<WebElement> clearIcon = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")));
		if (clearIcon.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).click();
			}
		}
	}

	public static void AlertPopup() {
		try {
			Thread.sleep(2000);
			Alert alert = login.driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.dismiss();
		} catch (Exception e) {

		}
	}

	public static void ExpandRight() throws InterruptedException {
		Thread.sleep(5000);
		try {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_right"))).click();
		} catch (Exception e) {

		}
	}

	public static void SeriesHormonizationWindowClose() throws InterruptedException {
		try {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
					.isDisplayed()) {
				Thread.sleep(1500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close"))).click();
			}
		} catch (NoSuchElementException e) {

		}

	}

	public static void webDriverwait_keyvalue(String text) throws Exception {
		// explicit wait for property values
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty(text))));
	}

	public static void search_without_filter() throws Throwable {
		// Thread.sleep(4000);
		List<WebElement> filter = login.driver
				.findElements(By.xpath("//button[contains(text(),'Search without any filters')]"));
		if (filter.size() > 1) {
			for (WebElement search : filter) {
				search.click();
			}
		} else {
			System.out.println("===Search without filter button is not visible===");
		}
	}

	public static void modelbox() {
		// check whether the model box is displayed or not
		try {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Modal_dialog"))).size() > 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Model_dialog_cancel"))).click();
			} else {
				Reporter.log("No modal dialog appears", true);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean DownloadFileVerify() throws Exception {
		// Verify the downloaded file as excel by comparing the filename title and
		// downloaded file name
		Thread.sleep(5000);
		String series_title = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("series_title"))).getText();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close"))).click();
		String downloadPath = System.getProperty("user.dir");
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		for (int i = 0; i < dirContents.length; i++) {
			if (dirContents[i].getName().contains(series_title)) {
				// File has been found, it can now be deleted:
				dirContents[i].delete();
				login.Log4j.info("File has been download to Excel and its verified");
				return true;
			}
		}
		Assert.fail("Download to Excel verification failed");
		return false;
	}

	public static void TabSelection(String arg) throws Exception {
		/*
		 * try { wait.until(ExpectedConditions.visibilityOfElementLocated(
		 * By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg +
		 * "')]"))); login.driver.findElement(By.xpath(
		 * "//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg + "')]")) .click();
		 * Thread.sleep(2000); } catch (Exception e) {
		 * login.driver.navigate().refresh(); // CommonFunctionality.TopMethod();
		 * Thread.sleep(5000); login.driver .findElement(
		 * By.xpath("//div[@class='search-presentation-tabs--visible']//span[@title='" +
		 * arg + "']")) .click(); }
		 */
		if (arg.equals("All")) {
			login.driver.navigate().refresh();
			// CommonFunctionality.TopMethod();
			Thread.sleep(5000);
			login.driver
					.findElement(
							By.xpath("//div[@class='search-presentation-tabs--visible']//span[@title='" + arg + "']"))
					.click();
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg + "')]")));
			login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg + "')]"))
					.click();
			Thread.sleep(2000);
		}
	}

	public static void VerifyLink(String arg) throws Exception {
		/*
		 * try { wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//*[text()='" + arg + "']"))); manage_series_id =
		 * login.driver.findElement(By.xpath(
		 * "//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]"
		 * )) .getText(); login.driver.findElement(By.xpath("//*[text()='" + arg +
		 * "']")).click(); Thread.sleep(2000); } catch (Exception e) {
		 * Thread.sleep(3000); login.driver .findElement( By.
		 * xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']"
		 * )) .click(); login.Log4j.info("Clicking on " + arg); }
		 */
		if (arg.equals("View more")) {
			Thread.sleep(3000);
			login.driver
					.findElement(
							By.xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']"))
					.click();
			login.Log4j.info("Clicking on " + arg);
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + arg + "']")));
			manage_series_id = login.driver.findElement(By.xpath(
					"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]"))
					.getText();
			login.driver.findElement(By.xpath("//*[text()='" + arg + "']")).click();
			Thread.sleep(2000);
		}
	}
}
