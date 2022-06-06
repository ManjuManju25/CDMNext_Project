package CDMNext.util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
//import java.util.ArrayList;
import java.util.List;
// java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//import com.aventstack.extentreports.gherkin.model.Feature;

import CDMNext.StepDefinations.login;
import cucumber.api.Scenario;

public class Hooks {
	public static String ExecutionReports = System.getProperty("user.dir") + "\\ExecutionReports";
	public static String folderdateTime = new DateTime().toString("dd-MM-yy HH-mm-ss");// report folder name
	public static File SourceReportPath = new File(System.getProperty("user.dir") + "\\target");
	

	public static void before_run() throws Throwable {
		// CommonFunctionality.wait(1000);
		URL url = new URL(login.CONFIG.getProperty("testsiteURL"));
		login.driver.get(url.getProtocol() + "://" + url.getHost() + "/Untitled-insight/myseries");
		CloseHelpBubble();
		Handle_BrowserNotification_popup();
		CloseAnnouncementPopUp();
		unhandled_popup();
	}

	@SuppressWarnings("deprecation")
	public static void after_run() throws Throwable {
		if (login.driver.findElements(By.cssSelector(".visual-configuration-controls--right .button__primary"))
				.size() > 0) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
							".visual-configuration-controls--right .button__primary", 4))
					.pause(500).click().build().perform();
		}
		String parentWindow = login.driver.getWindowHandle();
		Set<String> childwindows = login.driver.getWindowHandles();
		for (String child_one_window : childwindows) {
			if (!child_one_window.equals(parentWindow)) {
				login.driver.switchTo().window(child_one_window).close();
				login.driver.switchTo().window(parentWindow);
			}
		}
	}

	
	public static void unhandled_popup() throws Throwable {
	
		//if Some changes have not been saved. popup appears then close the popup
		try {
			CommonFunctionality.getElementByXpath(login.driver,"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]",8).click();
		}catch(Exception e) {
			
		}
		List<WebElement> popup = login.driver
				.findElements(By.xpath("//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']"));
		for (int i = 1; i <= popup.size(); i++) {
			CommonFunctionality.Hidden_Webelements(login.driver,
					"//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']");
			
			//Close Latest changes popup if appears
			if(login.driver.findElements(By.xpath("//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']")).size() > 0) {
				CommonFunctionality.wait(300);
				CommonFunctionality.getElementByXpath(login.driver,"//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']", 4).click();
				
			}

			if (login.driver
					.findElements(
							By.cssSelector(".button.button__primary"))	
					
					.size() > 0) {
				CommonFunctionality.getElementBycssSelector(login.driver,
						".button.button__primary", 4).click();
			}
		}

		CommonFunctionality.Views_list();
		CommonFunctionality.ResetMethod();
		/*WebElement data_tab = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='search-presentation-tabs--visible']//*[contains(@class,'ui-sortable-handle')])[1]", 4);
		if (!data_tab.getAttribute("class").contains("series-tab__hidden")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//span[contains(@class,'ui-sortable-handle')]//span[@class='series-tab--text'])[1]", 4))
					.pause(100).click().build().perform();
		}
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[contains(@class,'toggler-control__light_purple')]//*[contains(@class,'toggler-control-item')])[1]",
				4)).pause(100).click().build().perform();*/
	}

	public static void Handle_BrowserNotification_popup() throws Throwable {
		Robot r = new Robot();
		r.delay(5000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	

	public static void copyingOldReports() throws IOException {
		CommonFunctionality.wait(2000);
		String srcFile = System.getProperty("user.dir") + "/target/surefire-reports/html/report.html";
		File src = new File(srcFile);
		String destFile = System.getProperty("user.dir") + "ExecutionReports" + src.getName();
		File dest = new File(destFile);
		// Copy files to specific location
		FileUtils.copyFile(src, dest);
	}

	public static String getFeatureFileNameFromScenarioId(Scenario scenario) {
	
		String featureName = "Feature ";
		String rawFeatureName = scenario.getId().split(";")[0].replace("-", " ");
		featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
		login.Log4j.info(featureName);
		return featureName;
	}
	public static void createDateBasedDirectory(String baseDirectory, String folderdateTime) {
		File f = new File(baseDirectory, folderdateTime);
		f.mkdir();

	}
	public static void CopytoCurrentdateTimeDir(File Source, String file)
			throws Exception {
		try {
			File dir = new File(file);
			File[] files = dir.listFiles();

			File lastModified = Arrays.stream(files).filter(File::isDirectory)
					.max(Comparator.comparing(File::lastModified)).orElse(null);

			FileUtils.copyDirectory(Source, lastModified);

			String targetFile = lastModified.toString();
			recursiveDelete(new File(targetFile));
			
			// FileUtils.copyDirectory(assertion, lastModified);

		} catch (FileNotFoundException e) {

		}

	}
	public static void recursiveDelete(File file) {
		// to end the recursive loop
		if (!file.exists())
			return;

		// if directory, go inside and call recursively
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				// call recursively

				if (!f.getName().contains("report.html")) {
					recursiveDelete(f);
				}
			}
		}
		file.delete();
	}
public static void CloseHelpBubble() {
	try {
		CommonFunctionality.getElementByXpath(login.driver,"//*[@class='help-bubble-buttons']//*[contains(text(),'Close')]", 8).click();
	} catch(Exception e) {
		
	}
}
public static void CloseAnnouncementPopUp() {
	try {
		CommonFunctionality.getElementByXpath(login.driver,"//*[contains(text(),'No, take me to CDMNext')]",8).click();
	}catch(Exception e1){
		
	}
}
}