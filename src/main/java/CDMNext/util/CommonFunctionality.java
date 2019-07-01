package CDMNext.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CDMNext.StepDefinations.login;

public class CommonFunctionality {
	static Actions action = new Actions(login.driver);

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
	public static void AlldbClear() throws InterruptedException {
		List<WebElement> clearIcon = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon")));
		if (clearIcon.size() > 0) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).isDisplayed()) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Alldb_clearIcon"))).click();
			}
		}
	}
}
