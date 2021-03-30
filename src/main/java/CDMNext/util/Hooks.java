package CDMNext.util;

 import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
//import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CDMNext.StepDefinations.login;

public class Hooks {

	public static void before_run() throws Throwable {
		URL url = new URL(login.CONFIG.getProperty("testsiteURL"));
		login.driver.get(url.getProtocol() + "://" + url.getHost() + "/Untitled-insight/myseries");
		Handle_BrowserNotification_popup();
		unhandled_popup();
	}

	@SuppressWarnings("deprecation")
	public static void after_run() throws Throwable {
		if(login.driver.findElements(By.cssSelector(".visual-configuration-controls--right .button__primary")).size()>0) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".visual-configuration-controls--right .button__primary", 4)).pause(500).click().build().perform();
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

	@SuppressWarnings("deprecation")
	public static void unhandled_popup() throws Throwable {
		List<WebElement> popup = login.driver.findElements(By.xpath("//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']"));
		for (int i = 1; i <= popup.size(); i++) {
			CommonFunctionality.Hidden_Webelements(login.driver,"//div[@class='sphere-modal__close'] | //div[@class='movable-modal--close']");
			if (login.driver.findElements(By.cssSelector(".sphere-modal__content  .sphere-modal-control.button.button__primary")).size() > 0) {
				CommonFunctionality.getElementBycssSelector(login.driver,".sphere-modal__content  .sphere-modal-control.button.button__primary", 4).click();
			}
		}
		CommonFunctionality.Views_list();
		WebElement reset = CommonFunctionality.getElementByXpath(login.driver,"//*[contains(@class,'searches-manager--reset-button')]/ancestor::div[2]", 4);
		if (!reset.getAttribute("class").contains("searches-manager__empty-filters")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[contains(@class,'searches-manager--reset-button')]", 4)).pause(500).click().build().perform();
		}
		WebElement data_tab = CommonFunctionality.getElementByXpath(login.driver,"(//*[@class='search-presentation-tabs--visible']//*[contains(@class,'ui-sortable-handle')])[1]", 4);
		if (!data_tab.getAttribute("class").contains("series-tab__hidden")) {
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"(//span[contains(@class,'ui-sortable-handle')]//span[@class='series-tab--text'])[1]", 4)).pause(100).click().build().perform();
		}
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver, "(//*[contains(@class,'toggler-control__light_purple')]//*[contains(@class,'toggler-control-item')])[1]", 4)).pause(100).click().build().perform();
	}
	public static void Handle_BrowserNotification_popup() throws Throwable {
		Robot r = new Robot();
		r.delay(3000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

}