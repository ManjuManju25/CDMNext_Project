package CDMNext.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.AssertJUnit;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Mnemonics {
	public static String mnemonic = "";

	@Given("^User enters Mnemonic \"([^\"]*)\"$")
	public void user_enters_Mnemonic(String arg1) throws Throwable {
		mnemonic = arg1;
		Thread.sleep(3000);
		List<WebElement> reset = login.driver.findElements(By.xpath("//span[contains(text(),'Reset')]"));
		if (reset.size() > 0) {
			if (login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).isDisplayed()) {
				login.driver.findElement(By.xpath("//span[contains(text(),'Reset')]")).click();
				login.Log4j.info("Clicking on Reset button");
			}
		}
		login.Log4j.info("Searching with " + mnemonic);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).clear();
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Search"))).sendKeys(mnemonic);

	}

	@Then("^User should get Mnemonic search results in SSI window$")
	public void user_should_get_Mnemonic_search_results_in_SSI_window() throws Throwable {
		WebElement element;
		WebElement checkbox;
		login.Log4j.info("Clicking on  Series tab ");
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series"))).click();
		Thread.sleep(5000);
		// create instance of JavaScriptExecutor
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		// create object of Actions class
		Actions mouseOver = new Actions(login.driver);

		WebElement ul_element = null;
		try {
			ul_element = login.driver.findElement(By.cssSelector(login.LOCATORS.getProperty("UL")));
			AssertJUnit.assertNotNull(ul_element);
			List<WebElement> li_All = ul_element.findElements(By.tagName(login.LOCATORS.getProperty("List")));
			login.Log4j.info("List size is :" + li_All.size());

			if (li_All.size() > 0) {
				for (int i = 0; i < li_All.size(); i++) {

					login.Log4j.info(i);
					login.Log4j.info(li_All.size());
					Thread.sleep(1500);
					int j = i + 1;
					checkbox = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--checkbox-wrapper']"));
					mouseOver.moveToElement(checkbox).click().build().perform();
					Thread.sleep(2000);
					element = login.driver
							.findElement(By.xpath("//li[" + j + "]//div[@class='series-list-item--info-icon-i']"));
					mouseOver.moveToElement(element).click().build().perform();
					// Until the element is not visible keep scrolling
					jse.executeScript("arguments[0].scrollIntoView(true);", element);
					Thread.sleep(3000);
					List<WebElement> seriesinfo = login.driver
							.findElements(By.xpath("//div[@class='main-series-information--series-id']"));
					for (WebElement mnemonicText : seriesinfo) {
						String ssi = mnemonicText.getText();
						// login.Log4j.info(ssi);
						if (ssi.contains(mnemonic) == true) {
							login.Log4j.info(mnemonic + " exists in " + "\n" + ssi);
							Thread.sleep(1000);
							login.driver.findElement(By.xpath("//div[@class='movable-modal movable-modal__draggable movable-modal__active']//div[@class='movable-modal--actions']//div[@title='Close']")).click();
						} else {
							Assert.fail(mnemonic + " does not exists in " + ssi);
							Thread.sleep(1000);
							login.driver.findElement(By.xpath("//div[@class='movable-modal movable-modal__draggable movable-modal__active']//div[@class='movable-modal--actions']//div[@title='Close']")).click();
						}
					}
				}
			} else {
				Assert.fail("List size is null");
			}
		} catch (NoSuchElementException e) {
			Assert.fail("WebElement is null " + e.getMessage());
		}
	}

}
