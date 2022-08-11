package CDMNext.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.*;

public class RecentDownloads {

	Actions action = new Actions(login.driver);

	// TC_01

	@And("^click on history download button$")
	public void click_on_history_download_button() throws Throwable {
		Thread.sleep(2000);

		WebElement seriesname = login.driver.findElement(By.xpath("//input[@value='Name your insight']"));
		String sname = seriesname.getText().toString();
		sname = sname.replaceAll(":", "");
		System.out.println(sname);
		login.driver.switchTo().activeElement();
		//login.driver.findElement(By.xpath(
			//	"//span[@class='download-button--text drop-down-button--label']"))
				//.click();
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button insight-download__modal-button button button__download-btn']")).click();
		click_on_history_download_button1(sname);

	}

	@Then("^click on history download button \"([^\"]*)\"$")
	public void click_on_history_download_button1(String a) throws Throwable {
		Thread.sleep(20000);

		try {

			login.driver.findElement(By.xpath(
					"//button[@class='drop-down-button--btn drop-down-button--btn__popup button button__download-btn history-download']"))
					.click();

			// login.driver.switchTo().frame(0);
			List<WebElement> series = login.driver.findElements(By.xpath(
					"//*[@class='public-js-views-insight_page-header-insight_header_download_button-downloads_history-history_item-module__container ']//span"));

			for (WebElement name : series) {
				String seriesname = name.getText().toString();
				System.out.println(seriesname);
				if (seriesname.contains(a)) {

					System.out.println("Enter into if condition");

					action.moveToElement(name).build().perform();

					login.driver.findElement(By.xpath(
							"//*[@class='public-js-views-insight_page-header-insight_header_download_button-downloads_history-history_item-module__container ']//a"))
							.click();
					
					break;
					
					
				}
			}

		} catch (org.openqa.selenium.StaleElementReferenceException ex) {

			login.driver.findElement(By.xpath(
					"//button[@class='drop-down-button--btn drop-down-button--btn__popup button button__download-btn history-download']"))
					.click();

			// login.driver.switchTo().frame(0);
			List<WebElement> series = login.driver.findElements(By.xpath(
					"//*[@class='public-js-views-insight_page-header-insight_header_download_button-downloads_history-history_item-module__container ']//span"));

			for (WebElement name : series) {
				String seriesname = name.getText().toString();
				System.out.println(seriesname);
				if (seriesname.contains(a)) {

					System.out.println("Enter into if condition");

					action.moveToElement(name).build().perform();

					login.driver.findElement(By.xpath(
							"//*[@class='public-js-views-insight_page-header-insight_header_download_button-downloads_history-history_item-module__container ']//a"))
							.click();
					
					break;
					
					
					
				}
			}

		}

	}

}
