package CDMNext.util;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import CDMNext.StepDefinations.login;

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
	public	static Actions action = new Actions(login.driver);
	// create instance of JavaScriptExecutor
	public static JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	public static WebDriverWait wait = new WebDriverWait(login.driver, 100);
	public static String manage_series_id;

	public static void ClearSelection() throws InterruptedException {
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("TopButton"))))
					.click();
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TopButton"))).click();
			login.Log4j.info("Clicking on Top button");
		}
		if (reset.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
				// Thread.sleep(2000);
				// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Reset"))))
						.click();
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
		List<WebElement> reset = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Reset")));
		try {
			if (reset.size() > 0) {
				if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).isDisplayed()) {
					// Thread.sleep(2000);
					// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Reset")))).click();
					login.Log4j.info("Clicking on Reset button");
				}
			}
		} catch (Exception e) {

		}
	}

	public static void UnselectMethod() throws InterruptedException {
		wait(5000);
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
		wait(2000);
		try {
			WebElement collapseTree = login.driver.findElement(By.xpath("//*[contains(text(),'Collapse all')]"));
			if (collapseTree.isDisplayed()) {
				collapseTree.click();
				login.Log4j.info("Clicking on collapse all");
			}
		} catch (Exception e) {

		}
	}

	@SuppressWarnings("deprecation")
	public static void DeleteVisual() throws InterruptedException {
		// Deleting visual
		WebElement ele = login.driver.findElement(By.xpath(
				"//*[@class='insight-page-menu-views-container--view-tabs ui-sortable']//*[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"));
		action.contextClick(ele).pause(2000).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Delete view')]")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Ok')]"))).click();
	}

	@SuppressWarnings("deprecation")
	public static void DeleteSeries() throws InterruptedException {
		try {
			// Deleting series from My Series tab
			WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='check-all-series']//*[@class='input-control--indicator']")));
			action.moveToElement(ele).pause(2000).click().build().perform();
			WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-action='delete']")));
			action.moveToElement(delete).pause(1000).click().build().perform();
		} catch (Exception e) {

		}
	}

	public static void TopMethod() throws InterruptedException {
		try {
			WebElement topButton = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("TopButton"))));
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
			wait(2000);
			Alert alert = login.driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.dismiss();
		} catch (Exception e) {

		}
	}

	public static void ExpandRight() throws InterruptedException {
		// Thread.sleep(5000);
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Expand_right"))))
					.click();
		} catch (Exception e) {

		}
	}

	public static void SeriesHormonizationWindowClose() throws InterruptedException {
		try {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close")))
					.isDisplayed()) {
				// Thread.sleep(1500);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("unexpected_popup_close"))))
						.click();
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

		if (arg.equals("All")) {
			login.driver.navigate().refresh();
			// CommonFunctionality.TopMethod();
			// Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='search-presentation-tabs--visible']//span[@title='" + arg + "']"))).click();
		} else if (arg.equals("Comparables")) {
			login.driver.navigate().refresh();
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//*[@class='search-presentation-tabs--visible']//*[contains(text(),'" + arg + "')]")))
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
		List<WebElement> views = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
		if (views.size() > 0) {
			for (WebElement view : views) {
				new Actions(login.driver).contextClick(view).build().perform();
				getElementByXpath(login.driver, "//span[contains(text(),'Delete view')]", 8).click();
				getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 8).click();
			}
		}
		getElementByProperty(login.driver, "Series_tab", 8).click();
		DeleteSeries();
	}

	public static WebElement getElementByProperty(WebDriver driver, String property_value, int time) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(login.driver).withTimeout(time, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(Throwable.class);
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
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(login.driver).withTimeout(time, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(Throwable.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		WebElement element = login.driver.findElement(By.xpath(locator));
		elementHighlight(login.driver, element);
		wait(500);
		return element;
	}

	public static WebElement getElementByClassName(WebDriver driver, String locator, int time)
			throws InterruptedException {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(login.driver).withTimeout(time, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS).ignoring(Throwable.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locator)));
		wait.until(ExpectedConditions.elementToBeClickable(By.className(locator)));
		WebElement element = login.driver.findElement(By.className(locator));
		elementHighlight(login.driver, element);
		wait(500);
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
			if (login.driver.findElement(By.xpath("//*[contains(text(),'Do you want to keep your insight?')]")).isDisplayed()) {
				Thread.sleep(1000);
				login.driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
				
			} 
		} catch (Exception e) {
			//
		}
	}
	public static void ChartSuggestionPopUp() {
		// check whether the Chart Suggestion pop up is displayed or not
		if (login.driver.findElements(By.className("growl-message-close")).size() > 0) {
			login.driver.findElement(By.className("growl-message-close")).click();
		}
	}

	public static void CreateNewInsight() throws InterruptedException {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Start new']"))
				.size() > 0) {
			getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='Start new']", 4).click();
			System.out.println("Start new option is selected in unsaved insight work pop-up display");
		}
	}
	public static void ContinueSameInsight() throws InterruptedException {
		if (login.driver.findElements(By.xpath("//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']"))
				.size() > 0) {
			getElementByXpath(login.driver,
					"//*[contains(@class,'sphere-modal__content')]//*[text()='Continue']", 4).click();
			System.out.println("Continue the same insight");
		}
	}
	public static List<WebElement> Hidden_Webelements_handling(WebDriver driver, String locatorType, String value) {
		List<WebElement> elements = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(value));
		} else if (locatorType.equalsIgnoreCase("className")) {
			elements = driver.findElements(By.className(value));
		}
		for(WebElement element : elements) {
			int x = element.getLocation().getX();
			if(x!=0) {
				ActualColor = element.getAttribute("title");
				login.Log4j.info(ActualColor);
			  element.click();
			  break;
			}
		}
		return elements;
	}
}

