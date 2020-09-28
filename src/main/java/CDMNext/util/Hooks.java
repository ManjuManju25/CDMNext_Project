package CDMNext.util;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CDMNext.StepDefinations.SearchTest;
import CDMNext.StepDefinations.login;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@SuppressWarnings("deprecation")
//	@Before("@Commentary,@Attachments")
	public static void before_run() throws Throwable {
		//user_has_successful_logged_in();
		/*login.driver.manage().window().maximize();
		login.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);*/
		URL url = new URL(login.CONFIG.getProperty("testsiteURL"));
		login.driver.get(url.getProtocol() + "://" + url.getHost() + "/Untitled-insight/myseries");
		unhandled_popup();
		WebElement reset = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(text(),'Reset')]/ancestor::div[2]", 4);
		if (!reset.getAttribute("class").contains("searches-manager__empty-filters")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(text(),'Reset') and not(@visibility='hidden')]", 4))
					.pause(500).click().build().perform();
		}
		WebElement data_tab = CommonFunctionality.getElementBycssSelector(login.driver, "span[data-id='DATA']", 4);
		if (!data_tab.getAttribute("class").contains("series-tab__hidden")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//span[@class='series-tab--text' and contains(text(),'Data')]", 4))
					.pause(100).click().build().perform();
		}
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementBycssSelector(login.driver, "label[title='View results as Tree']", 4))
				.pause(100).click().build().perform();
	}

	//@After("@Commentary")
	public static void after_run() throws Throwable {
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
		List<WebElement> popup = login.driver
				.findElements(By.xpath("//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']"));
		for (int i = 1; i <= popup.size(); i++) {
			CommonFunctionality.Hidden_Webelements(login.driver,
					"//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']");
			if (login.driver
					.findElements(
							By.cssSelector(".sphere-modal__content  .sphere-modal-control.button.button__primary"))
					.size() > 0) {
				CommonFunctionality.getElementBycssSelector(login.driver,
						".sphere-modal__content  .sphere-modal-control.button.button__primary", 4).click();
			}
		}
		CommonFunctionality.Views_list();
	}

	public static void user_has_successful_logged_in() throws Throwable {
		if (login.logged_in = false) {
			login.Invoke_browser();
			login.application_login();
			login.Log4j.info("It is in If block");
		} else if (login.logged_in = true && !SearchTest.logged) {
			login.application_login();
			SearchTest.logged = true;
			login.Log4j.info("It is in else If block");

		} else {
			login.Log4j.info("If User has already logged in, pelase continue....");
		}
	}
}