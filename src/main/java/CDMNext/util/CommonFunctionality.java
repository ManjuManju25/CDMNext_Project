	
package	CDMNext.util;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.awt.Image;	
	
import java.awt.Robot;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import CDMNext.StepDefinations.login;

import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;

public class CommonFunctionality {
	public static String db_name;
	public static WebElement footnoteDb;
	public static String sname;
	public static int SeriesCount;
	public static int m;
	public static String seriesId;
	public String seriesName;
	public String region;
	public String unit;
	public String frequency;
	public static String ActualColor;
	// create object of Actions class
	public static Actions action = new Actions(login.driver);
	// create instance of JavaScriptExecutor
	public static JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	public static WebDriverWait wait = new WebDriverWait(login.driver, 1000);
	public static String manage_series_id;
	public static File theNewestFile = null;
	public static int width ;

	public static void ClearSelection() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
			login.Log4j.info("Clicking on Top button");
		}
		if (reset.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
				login.Log4j.info("Clicking on Reset button");
			}
		}
		/*
		 * if
		 * (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).
		 * isDisplayed()) { // Thread.sleep(2000); //
		 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unselect"))).
		 * click();
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.
		 * LOCATORS.getProperty("unselect")))) .click();
		 * login.Log4j.info("Clicking on Unselect button"); }
		 */

	}

	public static void ResetMethod() throws InterruptedException {
		wait(500);
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		try {
			if (reset.size() > 0) {
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
					getElementByProperty(login.driver, "Reset", 8).click();
					login.Log4j.info("Clicking on Reset button");
				}
			}
		} catch (Exception e) {

		}
	}

	public static void UnselectMethod() throws InterruptedException {
		wait(1000);
		WebElement unselect = login.driver.findElement(By.xpath("//div[contains(text(),'Unselect')]"));
		if (unselect.isDisplayed()) {
			unselect.click();
		}
	}

	public static void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void CollapseTreeMethod() throws InterruptedException {
		wait(1000);
		try {
			WebElement collapseTree = login.driver.findElement(By.xpath("//*[@title='Collapse tree']"));
			if (collapseTree.isDisplayed()) {
				collapseTree.click();
				login.Log4j.info("Clicking on collapse all");
			}
		} catch (Exception e) {

		}
	}

	public static void DeleteVisual() throws InterruptedException {
		try {
			wait(3000);
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {
				for (WebElement view : views) {
					wait(700);
					new Actions(login.driver).contextClick(view).build().perform();
					getElementByXpath(login.driver, "//*[contains(text(),'Delete view')]", 30).click();
					getElementByXpath(login.driver,
							"//*[@class='modal-dialog sphere-modal-dialog ']//button[contains(text(),'Ok')]", 20)
									.click();
				}
			}
		} catch (Exception e) {

		}

	}

	@SuppressWarnings("deprecation")
	public static void DeleteSeries() throws InterruptedException {
		/*
		 * try { // getElementByProperty(login.driver, "Series_tab", 8).click(); //
		 * Deleting series from My Series tab WebElement ele =
		 * getElementByXpath(login.driver,
		 * "//*[@class='check-all-series']//*[@class='input-control--indicator']", 20);
		 * action.moveToElement(ele).pause(800).click().build().perform(); WebElement
		 * delete = getElementByXpath(login.driver, "//*[@data-action='delete']", 10);
		 * action.moveToElement(delete).pause(700).click().build().perform();
		 * wait(3000); } catch (Exception e) {
		 * 
		 * }
		 */
		try {
			WebElement selected = getElementByXpath(login.driver,
					"//*[@class='input-control--indicator']//*[@class='icon']//following::*[contains(@class,'list-container')]",
					4);
			if (selected.getAttribute("class").contains("all-selected")) {
				getElementByXpath(login.driver, "//div[@data-action='delete']", 4).click();
			} else if (selected.getAttribute("class").contains("without-data")) {
				System.out.println("No Series is added in myseries list to delete");
			} else {
				WebElement ele = getElementByXpath(login.driver,
						"//div[@class='check-all-series']//span[@class='input-control--indicator']", 4);
				action.moveToElement(ele).pause(1000).click().build().perform();
				WebElement delete = getElementBycssSelector(login.driver, "div[data-action='delete']", 4);
				new Actions(login.driver).moveToElement(delete).pause(50).click().build().perform();
			}
		} catch (Exception e) {

		}
	}

	public static void TopMethod() throws InterruptedException {
		try {
			wait(1000);
			WebElement topButton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton")));
			if (topButton.isDisplayed()) {
				topButton.click();
				login.Log4j.info("Clicking on Top button");
			}
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("deprecation")
	public static void RightClickOnAnySeries() throws InterruptedException {
		wait(2000);
		WebElement ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
		List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
		login.Log4j.info("List size is :" + li_All.size());
		for (int i = 0; i < li_All.size(); i++) {
			// int j = i + 1;
			m = i + 1;
			wait(1000);
			WebElement checkbox = login.driver
					.findElement(By.xpath("//li[" + m + "]//div[@class='series-list-item--checkbox-wrapper']"));
			checkbox.click();
			WebElement ele = login.driver.findElement(By.xpath("//li[" + m + "]//div[@class='series-item--name']"));
			// sname = ele.getText();
			if (i == 4) {
				// Thread.sleep(2000);
				sname = ele.getText();
				CommonFunctionality.action.contextClick(ele).pause(2000).build().perform();
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

	public static void SelectedSeriesClear() {
		if (!login.driver
				.findElement(By.xpath("//div[@class='search-input--series-indicator search-input--series-selected']"))
				.isSelected()) {
			login.Log4j.info("The selected count got unselected");
		} else {
			Assert.fail("The selected count not get unselected");
		}
	}

	public static void AlldbClear() throws InterruptedException {
		List<WebElement> clearIcon = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")));
		if (clearIcon.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).isDisplayed()) {
				wait(2000);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")))).click();
			}
		}
	}

	public static void AlertPopup() {
		try {
			wait(5000);
			Alert alert = login.driver.switchTo().alert();
			String alertText = alert.getText();
		    System.out.println("Alert data: " + alertText);
			alert.dismiss();
		} catch (Exception e) {

		}
	}

	public static void ExpandRight() throws InterruptedException {
		// wait(1000);
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Expand_right"))))
					.click();
		} catch (Exception e) {

		}
	}

	public static void ExpandLeft() throws InterruptedException {

		try {
			getElementByProperty(login.driver, "Expand_left", 5).click();
		} catch (Exception e) {

		}
	}

	public static void SeriesHormonizationWindowClose() throws InterruptedException {
		try {
			wait(1000);
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
					.isDisplayed()) {
				getElementByProperty(login.driver, "unexpected_popup_close", 10).click();
			}
		} catch (NoSuchElementException e) {

		}
	}

	public static void webDriverwait_keyvalue(String text) throws Exception {
		// explicit wait for property values
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty(text))));
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

	public static boolean DownloadFileVerify(String property_value1, String property_value2) throws Exception {
		// Verify the downloaded file as excel by comparing the filename title and
		// downloaded file name
		wait(3000);
		String series_title = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(property_value1))).getText();
		if (property_value2.equals("Close")) {
			getElementByProperty(login.driver, property_value2, 4).click();
		}
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

		if (arg.equals("Comparables")) {
			login.driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@class='search-presentation-tabs--visible']//*[contains(text(),'" + arg + "')]")))
					.click();
		} else if (arg.equalsIgnoreCase("Related Insights")) {
			login.driver
					.findElement(By.xpath("//*[contains(@class,'operations--related') and @js-related-insights=\"\"]"))
					.click();
		} else if (arg.equalsIgnoreCase("Links")) {
			getElementByXpath(login.driver, "//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg + "')]", 6)
					.click();

		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg + "')]")));
			login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg + "')]"))
					.click();
			wait(2000);
		}
	}

	public static void VerifyLink(String arg) throws Exception {

		if (arg.equals("View more")) {
			// Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='top-insights all-item']//div[@class='all-item--view-more-title']")))
					.click();
			login.Log4j.info("Clicking on " + arg);
		} else {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + arg + "']")));
			manage_series_id = login.driver.findElement(By.xpath(
					"//*[@class='main-series-information--right']//*[@class='main-series-information--series-id']/div[1]"))
					.getText();
			login.driver.findElement(By.xpath("//*[text()='" + arg + "']")).click();
			wait(2000);
		}
	}

	public static void Views_list() throws Exception {
		try {
			wait(1000);
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {
				for (WebElement view : views) {
					wait(1000);
					new Actions(login.driver).contextClick(view).build().perform();
					getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 30).click();
					if (login.driver.findElements(By.xpath("//*[@class='modal-window modal-window__active']//button[contains(text(),'Ok')]")).size() > 0) {
						getElementByXpath(login.driver, "//*[@class='modal-window modal-window__active']//button[contains(text(),'Ok')]", 10).click();
					}
				}
			}
		} catch (Exception e) {

		}
		DeleteSeries();
	}

	public static void Delete_AllViews() throws Exception {
		try {
			wait(1000);
			List<WebElement> views = login.driver.findElements(
					By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() > 0) {

				WebElement Active_view = getElementByXpath(login.driver,
						"//*[contains(@class,'insight-page-view-tab--link__active')]", 30);
				wait(1000);
				new Actions(login.driver).contextClick(Active_view).build().perform();
				getElementByXpath(login.driver, "//*[contains(text(),'Delete all views')]", 30).click();
				getElementByXpath(login.driver, "//*[@class='sphere-modal-controls']//button[contains(text(),'Ok')]",
						20).click();
			}

		} catch (Exception e) {

		}
		DeleteSeries();
	}

	public static WebElement getElementByProperty(WebDriver driver, String property_value, int time) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(login.LOCATORS.getProperty(property_value))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty(property_value))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login.LOCATORS.getProperty(property_value))));
		WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty(property_value)));
		elementHighlight(login.driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return element;
	}

	public static void elementHighlight(WebDriver driver, WebElement Webelement) {
		String originalStyle = Webelement.getAttribute("style");
		jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid yellow;');",
				Webelement);
		jse.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", Webelement);
	}

	public static void enterTextUsingJavaScriptExecutor(WebDriver driver, By locator, String text, String locatorType) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) login.driver;
		if (locatorType.equals("xpath")) {
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			WebElement ele = driver.findElement(locator);
			js.executeScript("arguments[0].value='" + text + "'", ele);
		}
	}

	public static WebElement getElementByXpath(WebDriver driver, String locator, int time) throws InterruptedException {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		wait(500);
		WebElement element = login.driver.findElement(By.xpath(locator));
		elementHighlight(login.driver, element);
		return element;
	}
	public static List<WebElement> getElementsByXpath(WebDriver driver, String locator) throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(locator))));
		wait.until(ExpectedConditions.elementToBeClickable((By.xpath(locator))));
		return driver.findElements(By.xpath(locator));
	}

	public static WebElement getElementBycssSelector(WebDriver driver, String locator, int time)
			throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
		WebElement element = login.driver.findElement(By.cssSelector(locator));
		elementHighlight(login.driver, element);
		return element;
	}

	public static WebElement getElementByClassName(WebDriver driver, String locator, int time)
			throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		wait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
		WebElement element = login.driver.findElement(By.className(locator));
		elementHighlight(login.driver, element);
		return element;
	}

	public static void fileUpload(WebDriver driver, String upload_path) throws Exception {
		StringSelection sel = new StringSelection(upload_path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		wait(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		login.Log4j.info("Successfully Uploaded The File");
	}

	public static void checkAlert(WebDriver driver) {
		if (ExpectedConditions.alertIsPresent() != null) {
			login.driver.switchTo().alert().accept();
		}
	}

	public static void switchframe(WebDriver driver, String framenameorID) {
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(framenameorID);
	}

	public static void webDriverwait_locator(String locator, String locatorType) throws Exception {
		// explicit wait for locator values
		if (locatorType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		} else if (locatorType.equalsIgnoreCase("classname")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
			wait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
		}
	}

	public static void uploadTheFileusingAutoIT(WebDriver driver, String exeFile, String uploadFile) {
		try {
			Runtime.getRuntime().exec(exeFile + " " + uploadFile);
		} catch (Exception e) {
			Reporter.log("Failed to upload AutoIT script", true);
		}
	}

	public static void click_on_search_close() {
		// check whether the search close button is displayed or not
		try {
			if (login.driver.findElements(By.xpath("//*[contains(@class,'inner--clear-button')]")).size() > 0) {
				login.driver.findElement(By.xpath("//*[contains(@class,'inner--clear-button')]")).click();
				webDriverwait_locator("//*[text()='⇱ Hide CEIC suggestions']", "xpath");
				login.driver.findElement(By.xpath("//*[text()='⇱ Hide CEIC suggestions']")).click();
			} else {

			}
		} catch (Exception e) {
		}
	}

	public static void InsightConfirmationPopUp() {
		// check whether the Insight confirmation pop up is displayed or not
		try {
			if (login.driver.findElement(By.xpath("//*[contains(text(),'Do you want to keep your insight?')]"))
					.isDisplayed()) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();

			}
		} catch (Exception e) {
			//
		}
	}

	public static void ChartSuggestionPopUp() {
		// check whether the Chart Suggestion pop up is displayed or not
		try {
			wait(1000);
			login.driver.findElement(By.className("growl-message-close")).click();
		} catch (Exception e) {
			login.Log4j.info("Chart suggestion popup is not displayed");
		}
	}

	public static void CreateNewInsight() throws InterruptedException {
		wait(700);
		try {
			login.driver.findElement(By.xpath("//*[@class='movable-modal--body-wrapper']//*[text()='Start new']"))
					.click();
			System.out.println("Start new option is selected in unsaved insight work pop-up display");
		} catch (Exception e) {

		}
	}

	public static void ContinueSameInsight() throws InterruptedException {
		wait(5000);
		try {
			login.driver.findElement(By.xpath("//*[@class='movable-modal--body-wrapper']//*[text()='Continue']"))
					.click();
			System.out.println("Continue the same insight");

		} catch (Exception e) {
			System.out.println("Continue popup is not displayed");
		}
	}

	public static List<WebElement> Hidden_Webelements_handling(WebDriver driver, String locatorType, String value) {
		List<WebElement> elements = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(value));
		} else if (locatorType.equalsIgnoreCase("className")) {
			elements = driver.findElements(By.className(value));
		}
		for (WebElement element : elements) {
			int x = element.getLocation().getX();
			if (x != 0) {
				ActualColor = element.getAttribute("title");
				login.Log4j.info(ActualColor);
				wait(200);
				element.click();
				break;
			}
		}
		return elements;
	}
	
	public static void CompareImage(WebDriver driver, String Image1, String Image2) throws Exception {
		String file1 = Image1;
		String file2 = Image2;
		Image image1 = Toolkit.getDefaultToolkit().getImage(file1);
		Image image2 = Toolkit.getDefaultToolkit().getImage(file2);
		try {
			PixelGrabber grab1 = new PixelGrabber(image1, 0, 0, -1, -1, false);
			PixelGrabber grab2 = new PixelGrabber(image2, 0, 0, -1, -1, false);
			int[] data1 = null;
			if (grab1.grabPixels()) {
				int width = grab1.getWidth();
				int height = grab1.getHeight();
				data1 = new int[width * height];
				data1 = (int[]) grab1.getPixels();
			}
			int[] data2 = null;
			if (grab2.grabPixels()) {
				int width = grab2.getWidth();
				int height = grab2.getHeight();
				data2 = new int[width * height];
				data2 = (int[]) grab2.getPixels();
			}
			if (Arrays.equals(data1, data2)) {
				System.out.println("Image comparision is successful");
			} else {
				Assert.fail("Image comparision is not successful");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Download_to_Excel(String title, int rowno, int columnno, String public_variable)
			throws Throwable {
		CommonFunctionality.wait(1000);
		String path = System.getProperty("user.home") + "\\Downloads\\" + title + ".xlsx";
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String data = sheet1.getRow(rowno).getCell(columnno).getStringCellValue();
		System.out.println(data);
		if (!(data.equalsIgnoreCase(public_variable)) || (!(data.contains(public_variable)))) {
			fail("Verification Failed");
		}
		fis.close();
		Files.deleteIfExists(Paths.get(path));
	}

	public static void ReplacementPopUpClose() throws InterruptedException {

		Thread.sleep(3000);
		try {
			if (login.driver.findElement(By.className("movable-modal--close")).isDisplayed()) {
				Thread.sleep(1500);
				login.driver.findElement(By.xpath("//*[@class='movable-modal--close']")).click();
			}
		} catch (Exception e) {

		}

	}

	public static void GrowlPopUp() {
		WebElement ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		String growlText = ele.getText();
		login.Log4j.info(growlText);
		if (ele.isDisplayed()) {
			login.Log4j.info(growlText + " message is displayed");
		} else {
			AssertJUnit.fail(growlText + "is not displayed  ");
		}
	}

	public static void ValidateGrowlText(String ExpectedTxt) throws Exception {
		CommonFunctionality.wait(300);
		WebElement ele = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		String ActualTxt = ele.getText();
		login.Log4j.info(ActualTxt);
		if (ActualTxt.equalsIgnoreCase(ExpectedTxt)) {
			login.Log4j.info(ActualTxt + " message is displayed");
		} else {
			AssertJUnit.fail(ActualTxt + "is not displayed  ");
		}
	}

	/* Get the newest file for a specific extension */

	public static void getTheNewestFile(String ext)  {
		wait(15000);
		File dir = new File(System.getProperty("user.home") + "\\Downloads");
		
		FileFilter fileFilter = new WildcardFileFilter("*." + ext);

		File[] files = dir.listFiles(fileFilter);
		
		System.out.println(files.length);
		if (files.length > 0 || files.length == 0) {
			/** The newest file comes first **/
			// System.out.println("^^^^^^^^^^^^Entered");
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			theNewestFile = files[0];
			System.out.println("The Successfully downloaded file is " + theNewestFile);
			String E = getFileExtension(theNewestFile);
			System.out.println("The Successfully extension file is " + E);
			String fileSize = getFileSizeKiloBytes(theNewestFile);
			System.out.println("The file size is " + fileSize);
			String[] file_size = fileSize.split("kb");
			Double d = Double.parseDouble(file_size[0]);
			int Downloaded_FileSize = (int) Math.round(d);
			System.out.println("The file size is " + Downloaded_FileSize);
			// return theNewestFile;
			if (E.equalsIgnoreCase(ext) && Downloaded_FileSize > 10) {
				System.out.println("Downloaded File Format Matched Successfully." + "'" + E + "' <> '" + ext + "'");
				if (E.equalsIgnoreCase("jpeg")) {
					// Check JPG format size for Histogram
					BufferedImage bimg = null;
					try {
						bimg = ImageIO.read(files[0]);
						width = bimg.getWidth();
						login.Log4j.info(width);

					} catch (IOException e) {

					}
				} else if(E.equals("pdf")) {
					
					if(files[0].getName().contains("Image") || files[0].getName().contains("Name your insight")){
						System.out.println(theNewestFile + " visual is downloaded in "+ E + " format");
					}
				}
				
			} else {

				Assert.fail("Downloaded File Format is NOT Matched." + "'" + E + "' <> '" + ext + "'");
			}
		}
	}
	private static String getFileSizeKiloBytes(File file) {
		return (double) file.length() / 1024 + "  kb";
	}
	public static void MovingDownloadedFileToTargetLocation(String sourceFile, String E) throws IOException {
		// move file from Downloads
		// File Targetdir = new File(System.getProperty("user.home") + "\\downloads\\" +
		// theNewestFile.getName());
		String Targetdir = System.getProperty("user.home") + "\\downloads +\\destination" + "\\.\\" + E;
		Path dest = Paths.get(Targetdir);
		Path src = Paths.get(sourceFile);
		Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
		// Files.copy(src.toFile(), dest.toFile());
		/*
		 * if (theNewestFile.isFile()) { if (!Targetdir.exists()) { Targetdir.mkdir();
		 * 
		 * } String[] children = theNewestFile.list(); for (int i = 0; i <
		 * children.length; i++) { copy(new File(theNewestFile, children[i]), new
		 * File(Targetdir, children[i])); }
		 * 
		 * } else { InputStream in = new FileInputStream(theNewestFile); OutputStream
		 * out = new FileOutputStream(Targetdir);
		 * 
		 * // Copy the bits from instream to outstream byte[] buf = new byte[1024]; int
		 * len; while ((len = in.read(buf)) > 0) { out.write(buf, 0, len); } in.close();
		 * out.close();
		 * 
		 * }
		 */

	}

	public static void Create_New_Insight() throws Exception {
		getElementByXpath(login.driver, "//*[@title='Open File menu']", 20).click();
		getElementByXpath(login.driver, "//li//*[contains(text(),'New')]", 20).click();
		getElementByXpath(login.driver, "//*[@class='create']//input", 20).clear();
		getElementByXpath(login.driver, "//*[@class='create']//input", 20).sendKeys("Testing Insight");
		getElementByXpath(login.driver, "//*[contains(text(),'Create insight')]", 20).click();
	}

	public static String getFileExtension(File file) {
		String name = file.getName();
		try {
			return name.substring(name.lastIndexOf(".") + 1);

		} catch (Exception e) {
			return "";
		}
	}

	public static List<WebElement> Hidden_Webelements(WebDriver driver, String value) {
		List<WebElement> elements = driver.findElements(By.xpath(value));
		for (WebElement element : elements) {
			int x = element.getLocation().getX();
			if (x != 0) {
				element.click();
				break;
			}
		}
		return elements;
	}

	public static void login_as_next_user(WebDriver driver, String arg1, String arg2, String arg3, String arg4)
			throws Throwable {
		URL url = new URL(driver.getCurrentUrl());
		driver.get(url.getProtocol() + "://" + url.getHost() + "/login");
		driver.findElement(By.cssSelector(arg1)).clear();
		driver.findElement(By.cssSelector(arg1)).sendKeys(arg4);
		driver.findElement(By.cssSelector(arg2)).clear();
		driver.findElement(By.cssSelector(arg2)).sendKeys("Ceic@123");
		driver.findElement(By.cssSelector(arg3)).click();
	}

	@SuppressWarnings("deprecation")
	public static void login_as_internal_user(WebDriver driver, String arg1, String arg2, String arg3, String arg4,String arg5)
			throws Throwable {
		URL url = new URL(driver.getCurrentUrl());
		driver.get(url.getProtocol() + "://" + url.getHost() + "/login");
		driver.findElement(By.cssSelector(arg1)).clear();
		driver.findElement(By.cssSelector(arg1)).sendKeys(arg4);
		driver.findElement(By.cssSelector(arg2)).clear();
		driver.findElement(By.cssSelector(arg2)).sendKeys(arg5);
		driver.findElement(By.cssSelector(arg3)).click();
		if(login.driver.findElements(By.xpath("//div[@class='movable-modal--header']//div[text()='FocusEconomics Consensus Forecasts']")).size()>0) {
			boolean checkbox = login.driver.findElement(By.xpath("//*[contains(text(),'show again')]/preceding-sibling::input")).isSelected();
			if(checkbox == false) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'show again')]/preceding-sibling::span", 4)).pause(500).click().build().perform();
			}
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(@class,'button__text_purple') and text()='No, take me to CDMNext']", 4).click();
		}
	}

	public static void login_as_ceic_user(WebDriver driver, String arg1, String arg2, String arg3, String arg4)
			throws Throwable {
		URL url = new URL(driver.getCurrentUrl());
		driver.get(url.getProtocol() + "://" + url.getHost() + "/login");
		driver.findElement(By.cssSelector(arg1)).clear();
		driver.findElement(By.cssSelector(arg1)).sendKeys(arg4);
		driver.findElement(By.cssSelector(arg2)).clear();
		driver.findElement(By.cssSelector(arg2)).sendKeys("Ceic@123");
		driver.findElement(By.cssSelector(arg3)).click();
	}

	public static void closing_if_any_opened_modal_popup(WebDriver driver, String arg1, String arg2, String arg3)
			throws Throwable {

		List<WebElement> popup = driver.findElements(By.className(arg1));
		try {
			for (int i = 1; i <= popup.size(); i++) {
				getElementByClassName(driver, arg1, 10).click();
				if (driver.findElements(By.xpath(arg2)).size() > 0) {
					getElementByXpath(driver, arg3, 10).click();
				}
			}

		} catch (Exception e) {

		}
		ResetMethod();
		Views_list();
	}
	
	public static void Crosssection_Excelverify(WebDriver driver, String Excel1, String Excel2) throws Throwable {
		String path1 = System.getProperty("user.dir") + "\\Testdata\\" + Excel1 + ".xlsx";
		String path2 = System.getProperty("user.home") + "\\Downloads\\" + Excel2 + ".xlsx";
		File src1 = new File(path1);
		File src2 = new File(path2);
		FileInputStream excellFile1 = new FileInputStream(src1);
		FileInputStream excellFile2 = new FileInputStream(src2);
		XSSFWorkbook TestData = new XSSFWorkbook(excellFile1);
		XSSFWorkbook ActualData = new XSSFWorkbook(excellFile2);
		XSSFSheet Testdatasheet1 = TestData.getSheetAt(0);
		XSSFSheet ActualDatasheet1 = ActualData.getSheetAt(0);
		XSSFRow Testdatarows = Testdatasheet1.getRow(0);
		XSSFRow Actualdatarows = ActualDatasheet1.getRow(0);
		CompareComments(Testdatarows, Actualdatarows);
		if (compareTwoSheets(Testdatasheet1, ActualDatasheet1)) {
			login.Log4j.info("The two excel sheets are Equal");
		} else {
			fail("The two excel sheets are not Equal");
		}
		excellFile1.close();
		excellFile2.close();
		Files.deleteIfExists(Paths.get(path2));
	}

	// Compare Two Sheets
	public static boolean compareTwoSheets(XSSFSheet Testdatasheet1, XSSFSheet ActualDatasheet1)
			throws InterruptedException {
		int firstRow1 = Testdatasheet1.getFirstRowNum();
		int lastRow1 = ActualDatasheet1.getLastRowNum();
		boolean equalSheets = true;
		for (int i = firstRow1; i <= lastRow1; i++) {
			System.out.println("Comparing Row " + i);
			XSSFRow Testdatarows = Testdatasheet1.getRow(i);
			XSSFRow Actualdatarows = ActualDatasheet1.getRow(i);
			if (!compareTwoRows(Testdatarows, Actualdatarows)) {
				equalSheets = false;
				System.err.println("Row " + i + " - Not Equal");
				break;
			} else {
				System.out.println("Row " + i + " - Equal");
			}
		}
		return equalSheets;
	}

	// Compare Two Rows
	public static boolean compareTwoRows(XSSFRow Testdatarows, XSSFRow Actualdatarows) throws InterruptedException {
		if ((Testdatarows == null) && (Actualdatarows == null)) {
			return true;
		} else if ((Testdatarows == null) || (Actualdatarows == null)) {
			return false;
		}
		int firstCell1 = Testdatarows.getFirstCellNum();
		int lastCell1 = Testdatarows.getLastCellNum();
		boolean equalRows = true;
		// Compare all cells in a row
		for (int i = firstCell1; i < lastCell1; i++) {
			XSSFCell cell1 = Testdatarows.getCell(i);
			XSSFCell cell2 = Actualdatarows.getCell(i);
			if (!compareTwoCells(cell1, cell2)) {
				equalRows = false;
				System.err.println("Cell " + i + " - Not Equal" + "; Value of Testdata_cell is \"" + cell1
						+ "\" - Value of Actual_cell is \"" + cell2 + "\"");
			} else {
				System.out.println("Cell " + i + " - Equal" + "; Value of Testdata_cell is \"" + cell1
						+ "\" - Value of Actual_cell is \"" + cell2 + "\"");
			}
		}
		return equalRows;
	}

	// Compare Two Cells
	public static boolean compareTwoCells(XSSFCell Testdata_cell, XSSFCell Actual_cell) {
		if ((Testdata_cell == null) && (Actual_cell == null)) {
			return true;
		} else if ((Testdata_cell == null) || (Actual_cell == null)) {
			return false;
		}
		boolean equalCells = false;
		int type1 = Testdata_cell.getCellType();
		int type2 = Actual_cell.getCellType();
		if (type1 == type2) {
			if (Testdata_cell.getCellStyle().equals(Actual_cell.getCellStyle())) {
				// Compare cells based on its type
				switch (Testdata_cell.getCellType()) {
				case HSSFCell.CELL_TYPE_FORMULA:
					if (Testdata_cell.getCellFormula().equals(Actual_cell.getCellFormula())) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_NUMERIC:
					if (Testdata_cell.getNumericCellValue() == Actual_cell.getNumericCellValue()) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_STRING:
					if (Testdata_cell.getStringCellValue().equals(Actual_cell.getStringCellValue())) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_BLANK:
					if (Actual_cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN:
					if (Testdata_cell.getBooleanCellValue() == Actual_cell.getBooleanCellValue()) {
						equalCells = true;
					}
					break;
				case HSSFCell.CELL_TYPE_ERROR:
					if (Testdata_cell.getErrorCellValue() == Actual_cell.getErrorCellValue()) {
						equalCells = true;
					}
					break;
				default:
					if (Testdata_cell.getStringCellValue().equals(Actual_cell.getStringCellValue())) {
						equalCells = true;
					}
					break;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
		return equalCells;
	}

	public static boolean CompareComments(XSSFRow Testdatarows, XSSFRow Actualdatarows) {
		if ((Testdatarows == null) && (Actualdatarows == null)) {
			return true;
		} else if ((Testdatarows == null) || (Actualdatarows == null)) {
			return false;
		}
		boolean equallinks = true;
		int firstcommentCell = Testdatarows.getFirstCellNum();
		int lastcommentCell = Testdatarows.getLastCellNum();
		for (int i = firstcommentCell; i < lastcommentCell; i++) {
			XSSFCell Testdatacommentcell = Testdatarows.getCell(i);
			XSSFCell Actualdatacommentcell = Actualdatarows.getCell(i);
			XSSFComment Testdatacomment = Testdatacommentcell.getCellComment();
			XSSFComment Actualdatacomment = Actualdatacommentcell.getCellComment();
			if (Testdatacomment != null && Actualdatacomment != null) {
				assertNotEquals(Testdatacomment.getString(), Actualdatacomment.getString());
			}
		}
		return equallinks;
	}
}
