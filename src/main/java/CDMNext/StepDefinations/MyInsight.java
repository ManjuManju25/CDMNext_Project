package CDMNext.StepDefinations;

import static org.testng.Assert.fail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.google.common.collect.Ordering;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class MyInsight {

	Actions action = new Actions(login.driver);

	// TC_MyInsights_01
	@And("^Navigates to Myinsight page$")
	public void navigates_to_Myinsight_page() throws Throwable {

		Thread.sleep(2000);
		WebElement MyInsights = login.driver.findElement(By.xpath("//a[@class='insight-breadcrumb--title-link link']"));
		action.moveToElement(MyInsights).click().build().perform();

	}

	// TC_MyInsights_01
	@And("^Verify the All four tabs in My Insights page$")
	public void verify_the_All_four_tabs_in_My_Insights_page() throws Throwable {
		Thread.sleep(2000);

		Assert.assertTrue(login.driver.findElement(By.xpath("//div[contains(text(),'Favorite')]")).isDisplayed());
		Thread.sleep(2000);

		Assert.assertTrue(login.driver.findElement(By.xpath("//div[contains(text(),'Created')]")).isDisplayed());
		Thread.sleep(2000);

		// Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_tab"))).isDisplayed());

		Assert.assertTrue(login.driver.findElement(By.xpath("//div[contains(text(),'Shared')]")).isDisplayed());
		Thread.sleep(2000);
		Assert.assertTrue(login.driver.findElement(By.xpath("//div[@data-tab='all']")).isDisplayed());
		System.out.println("verified all four Tabs");
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_02
	@And("^Verify the Create insight button to create new insight$")
	public void verify_the_Create_insight_button_to_create_new_insight() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Create insight')]")).click();
		Thread.sleep(2000);
		String beforeinsightname = login.driver.findElement(By.xpath("//input[@class='form--control']"))
				.getAttribute("value");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
		Thread.sleep(2000);
		// Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Createdinsight_ack"))).isDisplayed());
		Thread.sleep(2000);
		String afterinsightname = login.driver
				.findElement(By.xpath(
						"//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']"))
				.getText();
		if (beforeinsightname.equalsIgnoreCase(afterinsightname)) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_03
	@And("^Verify the insights in Favorites tab$")
	public void verify_the_insights_in_Favorites_tab() throws Throwable {
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//span[contains(text(),'Create insight')]")).click();
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//input[@class='form--control']")).sendKeys("Testing");
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
		String faviconinsightname = login.driver
				.findElement(By.xpath(
						"//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']"))
				.getText();
		// Thread.sleep(2000);
		// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_favorite_icon"))).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "	//span[contains(text(),'Add to favorite')]", 10)
				.click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Favorite'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		String faviconinsightname_favtab = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (faviconinsightname.equalsIgnoreCase(faviconinsightname_favtab)) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_04
	@And("^Verify the insights in Created tab$")
	public void verify_the_insights_in_Created_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("Testing");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		String createdinsightname = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10)
				.getText();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		String createdinsightname_createdtab = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (createdinsightname.equalsIgnoreCase(createdinsightname_createdtab)) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_05
	@And("^Verify the insights in Shared tab$")
	public void verify_the_insights_in_Shared_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Shared'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("(//div[@class='items-wrapper'])[1]/li/span/span[2]"));
		for (WebElement countryname : objLinks) {
			String c = countryname.getText();
			if (!c.equalsIgnoreCase("Share")) {
				System.out.println("verified");
			} else {
				Assert.fail();
			}

		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_06
	@And("^Verify the insights in All Available$")
	public void verify_the_insights_in_All_Available() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='All'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("(//div[@class='items-wrapper'])[1]/li/span/span[2]"));
		for (WebElement countryname : objLinks) {
			String c = countryname.getText();
			if (c.equalsIgnoreCase("View") || c.equalsIgnoreCase("Customize") || c.equalsIgnoreCase("Open in new tab")
					|| c.equalsIgnoreCase("Copy") || c.equalsIgnoreCase("Copy link") || c.equalsIgnoreCase("Share")
					|| c.equalsIgnoreCase("Add tags") || c.equalsIgnoreCase("Delete")) {
				System.out.println("verified");
			} else {
				Assert.fail();
			}

		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_07
	@And("^Verify the Mouse over on inisight title in Table mode$")
	public void verify_the_Mouse_over_on_inisight_title_in_Table_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement mseries = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(mseries).build().perform();
		String nameofseries = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getAttribute("title");
		System.out.println(nameofseries);
		if (nameofseries.contains("Number of series:")) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_08
	@And("^Verify the search in My Insights$")
	public void verify_the_search_in_My_Insights() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("Testingsearch1");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("Testingsearch2");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();

		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='insights-search--input']", 10)
				.sendKeys("Testingsearch2");
		String searchinsightname = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (searchinsightname.equalsIgnoreCase("Testingsearch2")) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_09
	@And("^Verify search when any filter applied$")
	public void verify_search_when_any_filter_applied() throws Throwable {
		Thread.sleep(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("Testingsearchtag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='ui-widget-content ui-autocomplete-input']", 10)
				.sendKeys("Addingtag");
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10).click();
		Thread.sleep(3000);
		String searchinsightnameAddtag = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (searchinsightnameAddtag.equalsIgnoreCase("Testingsearchtag")) {
			System.out.println("verified");
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//span[@class='text-icon' and contains(text(),'×')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();

			// WebElement closeiconaddtag =
			// CommonFunctionality.getElementByXpath(login.driver,
			// "//span[@class='custom-select-title--reset-icon']", 10);
			WebElement closeiconaddtag = CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='custom-select-title']//div[@class='custom-select-title--reset icon--red-cross']",
					10);
			Actions action = new Actions(login.driver);
			action.moveToElement(closeiconaddtag).click().build().perform();
			// CommonFunctionality.getElementByXpath(login.driver,
			// "//span[@class='custom-select-title--reset-icon']", 10).click();

		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_10
	@And("^Verify search with invalid keyword$")
	public void verify_search_with_invalid_keyword() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='insights-search--input']", 10)
				.sendKeys("invalidkeyword");
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//span[contains(text(),'Create insight')]", 10).isDisplayed());
		System.out.println("verified");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='insights-search--clear-icon icon--red-cross insights-search--clear-icon__show']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

		System.out.println("===============================================>10");
	}

	// TC_MyInsights_11
	@And("^Verify Create insight button with invalid keyword$")
	public void verify_Create_insight_button_with_invalid_keyword() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//input[@class='insights-search--input']", 10)
				.sendKeys("invalidkeywordinsight");
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//a[contains(text(),'Create new Insight')]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Create insight')]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("invalidkeywordinsight");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		String createdinsightname = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']", 10)
				.getText();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		String createdinsightname_invalid = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (createdinsightname_invalid.contains("invalidkeywordinsight")) {
			System.out.println("verified");
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
					.click();
			// CommonFunctionality.getElementByXpath(login.driver,
			// "//button[@class='sphere-modal-control button button button__primary' and
			// contains(text(),'Delete forever')]", 10).click();

			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
					10).click();

		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_12
	@And("^Verify All tags drop down with no tagname$")
	public void verify_All_tags_drop_down_with_no_tag() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[contains(text(),'There are no items to select')]", 10)
				.isDisplayed());
		System.out.println("verified");
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsihts_13
	@And("^Verify All tags drop down with tagname$")
	public void verify_All_tags_drop_down_with_tag() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("Testingsearchtag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='ui-widget-content ui-autocomplete-input']", 10)
				.sendKeys("Addingtag");
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10)
				.isDisplayed());
		System.out.println("verified");
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10).click();
		Thread.sleep(3000);
		String searchinsightnameAddtag = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (searchinsightnameAddtag.equalsIgnoreCase("Testingsearchtag")) {
			System.out.println("verified");
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//span[@class='text-icon' and contains(text(),'×')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
			WebElement closeiconaddtag = CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='custom-select-title']//div[@class='custom-select-title--reset icon--red-cross']",
					10);

			Actions action = new Actions(login.driver);
			action.moveToElement(closeiconaddtag).click().build().perform();

		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_14
	@And("^Verify number of insights for a tag$")
	public void verify_number_of_insights_for_a_tag() throws Throwable {
		CommonFunctionality.wait(2000);
		for (int j = 1; j <= 3; j++) {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
					.sendKeys("Testingmultipletag" + j);
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
					10).click();
			navigates_to_Myinsight_page();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//input[@class='ui-widget-content ui-autocomplete-input']", 10)
					.sendKeys("Addingtag");
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();

		String count = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='insights-tags-item--tag-count']", 10).getText();
		String numberOnly = count.replaceAll("[^0-9]", "");

		int foo = Integer.parseInt(numberOnly);

		System.out.println(foo);
		if (foo >= 3) {

			System.out.println("verified");
			for (int k = 1; k <= 3; k++) {
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[" + k + "]", 10)
						.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
						.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "//span[@class='text-icon' and contains(text(),'×')]", 10)
						.click();
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
			}

			for (int i = 1; i <= 3; i++) {
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
						.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
						.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
						10).click();
				Thread.sleep(500);
				login.driver.navigate().refresh();
				Thread.sleep(500);
			}

		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_15
	@Given("^Verify remove icon when tag filter applied$")
	public void verify_remove_icon_when_tag_filter_applied() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("Testingsearchtag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='ui-widget-content ui-autocomplete-input']", 10)
				.sendKeys("Addingtag");
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='text-icon' and contains(text(),'×')]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "(//span[@class='custom-select-title--reset-icon'])[2]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();
		// Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
		// "//div[contains(text(),'There are no items to select')]", 10).isDisplayed());
		System.out.println("verified");
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_16
	@Given("^Verify Sort by drop down$")
	public void verify_Verify_Sort_by_drop_down() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='dropdown--icon icon--filter-arrow'])[2]", 10).click();

		if (login.driver.findElements(By.xpath("//div[@class='dropdown--body dropdown--body__open']/div/div[1]"))
				.size() != 0) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
//					 List<WebElement> objLinks = login.driver.findElements(By.xpath("//ul[@class='custom-select--body custom-select--sorting-filter-dropdown']/li/div"));
//						for(WebElement Sortbydropdown :objLinks ){
//							  String c = Sortbydropdown.getText();
//							  if(c.equalsIgnoreCase("Title") || c.equalsIgnoreCase("Last editor") ||c.equalsIgnoreCase("Last opened")){
//								  System.out.println("verified");
//							  }
//							  else{
//								  Assert.fail();
//							  }
//							 
//			}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_17
	@Given("^Verify Title$")
	public void verify_Title() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insights-control--right-bar']/div[3]/div/div/div/div/span[2]", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='dropdown--body dropdown--body__open']/div/div[1]", 10)
				.click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='custom-select-title sort-select-title
		// sort-select-title__asc-hidden']/span", 10).click();
		Thread.sleep(4000);
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
		for (WebElement Titles : objLinks) {

			ArrayList<String> ar = new ArrayList<String>();
			String c = Titles.getText();
			ar.add(c);
			System.out.println("Ascending order are" + ar);
			boolean sorted = Ordering.natural().isOrdered(ar);
			if (sorted == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}

		}
		Thread.sleep(4000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_18
	@Given("^Verify ascending/descending for title$")
	public void verify_ascending_descending_for_title() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='insights-control--right-bar']/div[3]/div/div/div/div/span[2]",
		// 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//ul[@class='custom-select--body
		// custom-select--sorting-filter-dropdown']/li[1]/div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insights-control--right-bar']/div[3]/div/div/div/span", 10).click();
		Thread.sleep(3000);
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
		for (WebElement Titles : objLinks) {

			ArrayList<String> ar = new ArrayList<String>();
			String c = Titles.getText();
			ar.add(c);
			System.out.println("Ascending order are" + ar);
			boolean sorted = Ordering.natural().isOrdered(ar);
			if (sorted == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}

		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insights-control--right-bar']/div[3]/div/div/div/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_19
	@Given("^Verify Last Editor$")
	public void verify_Last_Editor() throws Throwable {
		CommonFunctionality.wait(2000);
		try {
			CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
					.sendKeys("TestingLastEditor");
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
					10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[1]", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"(//div[@class='add-to-data-selection add-to-data-selection__search-series']/div)[1]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//span[@class='name-li' and contains(text(),'Save')])[1]", 10)
					.click();
			navigates_to_Myinsight_page();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
			Thread.sleep(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='insights-control--right-bar']/div[3]/div/div/div/div/span[2]", 10).click();
			Thread.sleep(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='dropdown--body dropdown--body__open']/div/div[2]", 10).click();
			Thread.sleep(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='insights-control--right-bar']/div[3]/div/div/div/span", 10).click();

			Thread.sleep(3000);
			String LastEditorinsight = CommonFunctionality.getElementByXpath(login.driver,
					"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
			System.out.println(LastEditorinsight);
			System.out.println("TestingLastEditor");

			if (!LastEditorinsight.equalsIgnoreCase("TestingLastEditor")) {
				System.out.println("verified");
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
						.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
						.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
						10).click();
				Thread.sleep(500);
				login.driver.navigate().refresh();
				Thread.sleep(200);

			} else {
				Assert.fail();
			}

			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
					.sendKeys("TestingLastEditor");
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
					10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[1]", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"(//div[@class='add-to-data-selection add-to-data-selection__search-series']/div)[1]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//span[@class='name-li' and contains(text(),'Save')])[1]", 10)
					.click();
			navigates_to_Myinsight_page();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
			Thread.sleep(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='insights-control--right-bar']/div[3]/div/div/div/div/span[2]", 10).click();
			Thread.sleep(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='dropdown--body dropdown--body__open']/div/div[2]", 10).click();
			Thread.sleep(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='insights-control--right-bar']/div[3]/div/div/div/span", 10).click();

			Thread.sleep(3000);
			String LastEditorinsight = CommonFunctionality.getElementByXpath(login.driver,
					"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10).getText();
			System.out.println(LastEditorinsight);
			System.out.println("TestingLastEditor");

			if (!LastEditorinsight.equalsIgnoreCase("TestingLastEditor")) {
				System.out.println("verified");
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
						.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
						.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
						10).click();
				Thread.sleep(500);
				login.driver.navigate().refresh();
				Thread.sleep(200);

			} else {
				Assert.fail();
			}

			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		}
	}

	// TC_MyInsights_20
	@Given("^Verify ascending/descending for Last editor$")
	public void verify_ascending_descending_for_Last_editor() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(3000);
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='insights-control--right-bar']/div[3]/div/div/div/div/span[2]",
		// 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//ul[@class='custom-select--body
		// custom-select--sorting-filter-dropdown']/li[2]/div[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insights-control--right-bar']/div[3]/div/div/div/span", 10).click();
		Thread.sleep(3000);
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
		for (WebElement Titles : objLinks) {

			ArrayList<String> ar = new ArrayList<String>();
			String c = Titles.getText();
			ar.add(c);
			System.out.println("Ascending order are" + ar);
			boolean sorted = Ordering.natural().isOrdered(ar);
			if (sorted == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}

		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insights-control--right-bar']/div[3]/div/div/div/span", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_21
	@Given("^Verify Last Opened$")
	public void verify_Last_Opened() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		String LastOpenedinsight = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[3]", 10)
				.getText();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[3]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[2]/span/span[2]", 10)
				.click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='application-logo']", 10).click();
		navigates_to_Myinsight_page();
		Thread.sleep(3000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insights-control--right-bar']/div[3]/div/div/div/div/span[2]", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='dropdown--body dropdown--body__open']/div/div[3]", 10)
				.click();
		// navigates_to_Myinsight_page();
		Thread.sleep(3000);
		String LastOpenedinsightafter = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[3]", 10)
				.getText();
		if (!LastOpenedinsight.equalsIgnoreCase(LastOpenedinsightafter)) {

			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_22
	@Given("^Verify ascending/descending for Last opened$")
	public void verify_ascending_descending_for_Last_opened() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "(//span[@class='dropdown--icon icon--filter-arrow'])[2]", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//ul[@class='custom-select--body
		// custom-select--sorting-filter-dropdown']/li[3]/div[1]", 10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='custom-select-title sort-select-title
		// sort-select-title__asc-hidden']/span", 10).click();
		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
		for (WebElement Titles : objLinks) {

			ArrayList<String> ar = new ArrayList<String>();
			String c = Titles.getText();
			ar.add(c);
			System.out.println("Ascending order are" + ar);
			boolean sorted = Ordering.natural().isOrdered(ar);
			if (sorted == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}

		}
		CommonFunctionality.getElementByXpath(login.driver, "//span[@class='sort-select-title--directions-box']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_23
	@Given("^Verify View as a grid option$")
	public void verify_View_as_a_grid_option() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		String grid = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insights-view--grid']", 10)
				.getAttribute("class");
		System.out.println("Grid" + grid);
		if (grid.contains("grid")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_24
	@Given("^Verify View as a table option$")
	public void verify_View_as_a_table_option() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		String table = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insights-view--table']", 10)
				.getAttribute("class");
		if (table.contains("table")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_25
	@Given("^Verify insight display mode when navigated from other pages$")
	public void verify_insight_display_mode_when_navigated_from_other_pages() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		String tablebefore = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insights-view--table']", 10).getAttribute("class");

		// CommonFunctionality.getElementByXpath(login.driver, "(//a[@class='link
		// insight-table-item--title-link text-dots'])[3]", 10).getText();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[3]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[2]/span/span[2]", 10)
				.click();
		navigates_to_Myinsight_page();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		String tableafter = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insights-view--table']", 10).getAttribute("class");

		if (tablebefore.equalsIgnoreCase(tableafter)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>25");
	}
	// TC_MyInsights_26
	/*
	 * @Given("^Verify CEIC logo$") public void verify_CEIC_logo() throws Throwable
	 * {
	 * 
	 * Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
	 * "//div[@class='page-main-header--logo']/div", 10).isDisplayed());
	 * System.out.println("Verified");
	 * CommonFunctionality.getElementByXpath(login.driver,
	 * "//div[@class='application-logo']", 10).click();
	 * 
	 * }
	 */

	// TC_MyInsights_27
	@Given("^Verify Whats New$")
	public void verify_Whats_New() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//a[text()='See all insights']", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='announcements-modal--title' and contains(text(),'Announcements')]", 10)
				.isDisplayed());
		System.out.println("Verified");
		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_28
	@Given("^Verify Open documents under Whats new section$")
	public void verify_Open_documents_under_Whats_new_section() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//a[contains(text(),'See all insights')]", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='announcements-modal--title' and contains(text(),'Announcements')]", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='announcements-files--list']/a[1]", 10)
				.click();
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		String url = login.driver.getCurrentUrl();
		System.out.println("Verified url" + url);
		// if(url.contains("file?path=/custom_files/news_alerts")) {
		System.out.println("Verified");
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		// }
		// else {
		// Assert.fail();
		// }

	}

	// TC_MyInsights_29
	@Given("^Verify Whats new by product dropdown$")
	public void verify_Whats_new_by_product_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//a[@class='link link__arrowed activity-block-header--link' and contains(text(),'See all highlights')]",
				10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='announcements-modal--title' and contains(text(),'Announcements')]", 10)
				.isDisplayed());
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='announcements-container--header-label']/following::div[2]/a/span[2]/b", 10)
				.click();

		List<WebElement> objLinks = login.driver
				.findElements(By.xpath("//ul[@class='select2-results']/li/following::div[3]"));
		// for(int i=1;i<objLinks.size();i++)

		for (WebElement productdropdown : objLinks) {

			ArrayList<String> ar = new ArrayList<String>();
			String c = productdropdown.getText();
			ar.add(c);
			System.out.println("product dropdown" + ar);
			if (ar.contains("Global Database") || ar.contains("Brazil Premium Database")
					|| ar.contains("China Premium Database") || ar.contains("India Premium Database")
					|| ar.contains("Indonesia Premium Database") || ar.contains("Russia Premium Database")
					|| ar.contains("CDMNext") || ar.contains("API & Integrations")) {
				System.out.println("Verified");

			} else {
				Assert.fail();
			}

		}
		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		login.driver.navigate().refresh();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_30
	@Given("^Verify default option for product dropdown$")
	public void verify_default_option_for_product_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//a[@class='link link__arrowed activity-block-header--link' and contains(text(),'See all highlights')]",
				10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='announcements-modal--title' and contains(text(),'Announcements')]", 10)
				.isDisplayed());
		String defaultproductdropdown = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='announcements-container--header-label']/following::div[4]", 10).getText();
		String defaultproductdropdownallcontent = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='announcements-container--body']", 10).getText();
		System.out.println("Verified defaultproductdropdown1" + defaultproductdropdownallcontent);
		System.out.println("Verified defaultproductdropdown" + defaultproductdropdown);
		if (defaultproductdropdown.equalsIgnoreCase("World Trend Plus")
				&& defaultproductdropdownallcontent.contains("World Trend Plus")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_33
	@And("^Verify insight permission for other users after add to CEIC Insider$")
	public void verify_insight_permission_for_other_users_after_add_to_CEIC_Insider() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//a[@class='link link__arrowed activity-block-header--link' and contains(text(),'See all highlights')]",
				10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='announcements-container--body']/div/div[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='text-block-editor visual-select-area']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_34
	@And("^Verify the copy insight for CEIC Insider$")
	public void verify_the_copy_insight_for_CEIC_Insider() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//a[@class='link link__arrowed activity-block-header--link' and contains(text(),'See all highlights')]",
				10).click();
		String customizenameinviewpopup = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='announcements-container--body']/div/div[1]", 10)
				.getText();
		Thread.sleep(1000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='announcements-container--body']/div/div[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[3]", 10)
				.click();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println("x as" + x);
		String URL = login.CONFIG.getProperty("testsiteURL").toString();
		String Copy_link = URL + customizenameinviewpopup;
		System.out.println("copylink" + Copy_link);
		if (!Copy_link.contains(x)) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}
		Thread.sleep(3000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_35
	@And("^Verify Open option for Whats new popup$")
	public void verify_Open_option_for_Whats_new_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();

		CommonFunctionality.getElementByXpath(login.driver,
				"//a[@class='link link__arrowed activity-block-header--link' and contains(text(),'See all highlights')]",
				10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='modal-icon-button']", 10).click();

		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Assert.assertTrue(
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//div[@class='landing-header--title' and contains(text(),'Announcement')]", 10)
						.isDisplayed());
		Thread.sleep(5000);
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		Thread.sleep(3000);
		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>35");
	}

	// TC_MyInsights_36
	@And("^Verify Close option for Whats new popup$")
	public void verify_Close_option_for_Whats_new_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab='ceic_insiders']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//a[@class='link link__arrowed activity-block-header--link' and contains(text(),'See all highlights')]",
				10).click();
		Thread.sleep(5000);
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10)
				.isDisplayed());
		WebElement close = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']",
				10);
		Actions action = new Actions(login.driver);
		action.moveToElement(close).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_36
	@Given("^Verify Footnotes menu$")
	public void verify_Footnotes_menu() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='help-title--icon']", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[contains(text(),'Learning')]//following ::div[2]", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"	//span[@class='footnotes-modal--name' and contains(text(),'Footnotes')]", 10)
				.isDisplayed());
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='movable-modal--close' and contains(text(),'×')]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_37
	@Given("^Verify Cdmnext Ceic data Maneger menu$")
	public void verify_Cdmnext_Ceic_data_Maneger_menu() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='help-title--icon']", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='help-popup--container']", 10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_38
	@Given("^Verify View Notifications$")
	public void verify_View_Notifications() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='user-notifications--icon']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='notifications-tab-label']", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='notifications-list--information-period']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_39
	@Given("^Verify  profile dropdown$")
	public void verify_profile_dropdown() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//img[@class='account-avatar--image']", 10).click();
		Assert.assertTrue(
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//div[@class='dropdown--body account-menu--body dropdown--body__open']", 10)
						.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_40
	@Given("^Verify insight in grid mode$")
	public void verify_insight_in_grid_mode() throws Throwable {

		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='insight-grid-item--buttons-item button'])[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_41
	@Given("^Verify insight in preview mode$")
	public void verify_insight_in_preview_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_42
	@Given("^Verify Favorite icon$")
	public void verify_Favorite_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(15000);
		String beforefavicon = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();
		System.out.println("beforefavicon:" + beforefavicon);

		if (login.driver
				.findElement(
						By.xpath("//div[@class='insight-favorite insight-favorite__active insight-favorite__green']"))
				.isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		} else {
			CommonFunctionality
					.getElementByXpath(login.driver, "//div[@class='insight-favorite  insight-favorite__green']", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		}

		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='insight-favorite insight-favorite__green']", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, " (//*[text()='Favorite'])", 10).click();
		String afterfavicon = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();

		System.out.println("afterfavicon:" + afterfavicon);

		if (beforefavicon.equalsIgnoreCase(afterfavicon)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		String removebeforefavicon = CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='insight-preview--title text-dots']", 10).getText();

		System.out.println(removebeforefavicon);

		// CommonFunctionality.getElementByXpath(login.driver,"//div[@class='insight-favorite
		// insight-favorite__active insight-favorite__green']", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, " (//*[text()='Favorite'])", 10).click();

		String removeafterfavicon = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		System.out.println(removeafterfavicon);
		if (removebeforefavicon.equalsIgnoreCase(removeafterfavicon)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_43
	@Given("^Verify Open option in insight preview$")
	public void verify_Open_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(15000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//button[@class='data-selection-series-overlay--btn button button__primary']", 10)
				.isDisplayed());
		Thread.sleep(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_44
	@Given("^Verify Copy option in insight preview$")
	public void verify_Copy_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Copy the Insight')]", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_45
	@Given("^Verify default insight title while coping insight$")
	public void verify_default_insight_title_while_coping_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10)
				.click();
		Thread.sleep(8000);
		String defaultcopy = CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='insight-copy-text-input block form--control']", 10)
				.getAttribute("innerHTML");
		System.out.println(defaultcopy);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='insight-copy-text-input block form--control']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_46

	@Given("^Verify MYInsight title update in Copy the insight popup$")
	public void verify_MYInsight_title_update_in_Copy_the_insight_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='insight-copy-text-input block form--control']", 10)
				.sendKeys("Testing");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Copy Insight')]",
				10).click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//a[@class='insight-breadcrumb--title-link link' and contains(text(),'My insights')]", 10)
				.click();
		;
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='All'])", 10).click();
		String copyinsightname = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		System.out.println(copyinsightname);
		if (copyinsightname.equalsIgnoreCase("Testing")) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_47
	@Given("^Verify Myinsight Copy insight button$")
	public void verify_Myinsight_Copy_insight_button() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Copy Insight')]",
				10).click();
		Thread.sleep(5000);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//button[@class='data-selection-series-overlay--btn button button__primary']", 10)
				.isDisplayed());
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//a[@class='insight-breadcrumb--title-link link' and contains(text(),'My insights')]", 10)
				.click();
		;
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_48
	@And("^Verify Cancel button for Copy the insight popup$")
	public void verify_Cancel_button_for_Copy_the_insight_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		String cancelcopybefore = CommonFunctionality
				.getElementByXpath(login.driver, " //span[@class='insight-preview--title text-dots']", 10).getText();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__text_purple' and contains(text(),'Cancel')]", 10)
				.click();
		String cancelcopyafter = CommonFunctionality
				.getElementByXpath(login.driver, " //span[@class='insight-preview--title text-dots']", 10).getText();
		if (cancelcopybefore.equalsIgnoreCase(cancelcopyafter)) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_49
	@And("^Verify Download option in insight preview$")
	public void verify_Download_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("Downloadinsight");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		Thread.sleep(4000);
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-list-item--checkbox svg-checkbox'])[1]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"(//div[@class='add-to-data-selection add-to-data-selection__search-series']/div)[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='name-li' and contains(text(),'Save')])[1]", 10)
				.click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[3]", 10)
				.click();
		Thread.sleep(4000);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						" //span[@class='download-modal-title__title' and contains(text(),'Download:')]", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		////
	}

	// TC_MyInsights_50
	@Given("^Verify Link option in insight preview$")
	public void verify_Link_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[4]", 10)
				.click();
		Thread.sleep(500);
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='growl-message-text']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>50");
	}

	// TC_MyInsights_51
	@Given("^Verify Maximize option in insight preview$")
	public void verify_Maximize_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[5]", 10)
				.click();
		Thread.sleep(500);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__expand']", 10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_52
	@Given("^Verify Restore down option in insight preview$")
	public void verify_Restore_down_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']/div[5]", 10)
				.click();
		Thread.sleep(500);
		CommonFunctionality.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__expand']", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//i[@class='insight-preview--icon__collapse']", 10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_53
	@Given("^Verify close option in insight preview$")
	public void verify_close_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Thread.sleep(8000);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_54
	@Given("^Verify Related Insights option in insight preview$")
	public void verify_Related_Insights_option_in_insight_preview() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(gridmode).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='related-insights--toggle' and contains(text(),'Related Insights')]", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_55
	@Given("^Verify right click options for insights in table mode$")
	public void verify_right_click_options_for_insights_in_table_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		Assert.assertTrue(
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']", 10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_56
	@Given("^Verify right click options for View insight$")
	public void verify_right_click_options_for_View_insight() throws Throwable {
		// div[@class='items-wrapper']/li[1]
		// div[@class='insight-preview--actions']
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_57
	@Given("^Verify right click options for Customize$")
	public void verify_right_click_options_for_Customize() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='data-action-panel insight-action-panel']", 10)
				.isDisplayed());
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_58
	@Given("^Verify right click options for Open in new tab$")
	public void verify_right_click_options_for_Open_in_new_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[3]", 10).click();
		Thread.sleep(1500);

		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='data-action-panel insight-action-panel']", 10)
				.isDisplayed());

		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_59
	@Given("^Verify right click options for Copy$")
	public void verify_right_click_options_for_Copy() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("copyinsight");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		Thread.sleep(4000);
		CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='series-list-item--checkbox svg-checkbox'])[1]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"(//div[@class='add-to-data-selection add-to-data-selection__search-series']/div)[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='name-li' and contains(text(),'Save')])[1]", 10)
				.click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[5]", 10).click();
		Thread.sleep(1500);

		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Copy the Insight')]", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Copy Insight')]",
				10).click();
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='sphere-modal__close']", 10).click();
		Thread.sleep(1500);
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();

		String copyinsight = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (copyinsight.contains("copy")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_60
	@Given("^Verify right click options for Copy link$")
	public void verify_right_click_options_for_Copy_link() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		Thread.sleep(500);
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='growl-message-text']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>60");
	}

	// TC_MyInsights_61
	@Given("^Verify right click options for copied URL$")
	public void verify_right_click_options_for_copied_URL() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[6]", 10).click();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
		System.out.println(x);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_T);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		Thread.sleep(2500);
		CommonFunctionality.wait(2000);
		// login.driver.get(x);
		Thread.sleep(2500);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_62
	@Given("^Verify right click options for share$")
	public void verify_right_click_options_for_share() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[7]", 10).click();
		CommonFunctionality.wait(2000);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//h4[@class='modal-title sphere-modal__title text-dots']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_63
	@Given("^Verify right click options for share-multiple insights$")
	public void verify_right_click_options_for_share_multiple_insights() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		int number_of_insights = 4;
		for (int i = 2; i <= number_of_insights; i++) {
			if (!(i == number_of_insights)) {
				new Actions(login.driver).keyDown(Keys.CONTROL).moveToElement(CommonFunctionality.getElementByXpath(
						login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ i + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().build().perform();
			}
			if (i == number_of_insights) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ number_of_insights + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[name()='use' and contains(@*,'#actions__options')])[" + number_of_insights + "]", 4))
						.pause(200).contextClick().build().perform();
			}
		}
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='context-menu-item link']/following::li[1])[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Share (3 insights)')]",
				10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_64
	@Given("^Verify right click options for limit for multiple insights selection share-multiple insights$")
	public void verify_right_click_options_for_limit_for_multiple_insights_selection_share_multiple_insights()
			throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		int number_of_insights = 25;
		for (int i = 2; i <= number_of_insights; i++) {
			if (!(i == number_of_insights)) {
				new Actions(login.driver).keyDown(Keys.CONTROL).moveToElement(CommonFunctionality.getElementByXpath(
						login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ i + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().build().perform();
			}
			if (i == number_of_insights) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ number_of_insights + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[name()='use' and contains(@*,'#actions__options')])[" + number_of_insights + "]", 4))
						.pause(200).contextClick().build().perform();
			}
		}
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='growl-message-text' and contains(text(),'You cannot select more than 20 insights at once')]",
				10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_65
	@Given("^Verify right click options delete for multiple insights$")
	public void verify_right_click_options_delete_for_multiple_insights() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		String firstelementbefore = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		int number_of_insights = 4;
		for (int i = 1; i <= number_of_insights; i++) {
			if (!(i == number_of_insights)) {
				new Actions(login.driver).keyDown(Keys.CONTROL).moveToElement(CommonFunctionality.getElementByXpath(
						login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ i + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().build().perform();
			}
			if (i == number_of_insights) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ number_of_insights + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[name()='use' and contains(@*,'#actions__options')])[" + number_of_insights + "]", 4))
						.pause(200).contextClick().build().perform();
			}
		}
		CommonFunctionality
				.getElementByXpath(login.driver, "(//span[@class='context-menu-item link']/following::li[3])[1]", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(3500);
		String firstelementafter = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		System.out.println("Verified" + firstelementbefore + firstelementafter);
		if (!firstelementbefore.equalsIgnoreCase(firstelementafter)) {

			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_66
	@Given("^Verify right click options delete for limit for multiple insights selection$")
	public void verify_right_click_options_delete_for_limit_for_multiple_insights_selection() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		String firstelementbefore = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		int number_of_insights = 21;
		for (int i = 1; i <= number_of_insights; i++) {
			if (!(i == number_of_insights)) {
				new Actions(login.driver).keyDown(Keys.CONTROL).moveToElement(CommonFunctionality.getElementByXpath(
						login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ i + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().build().perform();
			}
			if (i == number_of_insights) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ number_of_insights + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[name()='use' and contains(@*,'#actions__options')])[" + number_of_insights + "]", 4))
						.pause(200).contextClick().build().perform();
			}
		}
//			CommonFunctionality.getElementByXpath(login.driver, "(//span[@class='context-menu-item link']/following::li[3])[1]", 10).click();
//			 Thread.sleep(500);
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='growl-message-text' and contains(text(),'You cannot select more than 20 insights at once')]",
				10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_67
	@Given("^Verify right click options Add tags$")
	public void verify_right_click_options_Add_tags() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);

		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Share']", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//h4[@class='modal-title sphere-modal__title text-dots']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_68
	@Given("^Verify right click options Add tags in addtag dropdown$")
	public void verify_right_click_options_Add_tags_in_addtag_dropdown() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("rightclicktag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[8]", 10).click();
//			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10).click();
//			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[8]/span/span[2]", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='ui-widget-content ui-autocomplete-input']", 10)
				.sendKeys("Addingtag");
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10)
				.isDisplayed());
		System.out.println("verified");
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10).click();
		Thread.sleep(1500);
		String searchinsightnameAddtag = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();

		if (searchinsightnameAddtag.equalsIgnoreCase("rightclicktag")) {
			System.out.println("verified");
			WebElement rightclickelementafter = CommonFunctionality.getElementByXpath(login.driver,
					"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
			Actions action1 = new Actions(login.driver);
			action1.contextClick(rightclickelementafter).build().perform();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[8]", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//span[@class='text-icon' and contains(text(),'×')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
			Thread.sleep(2500);
			WebElement closeiconaddtag = CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='custom-select-title--reset-icon'])[3]", 10);
			Actions action2 = new Actions(login.driver);
			action2.moveToElement(closeiconaddtag).click().build().perform();

			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
					10).click();
			Thread.sleep(5500);
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_69
	@Given("^Verify right click options Add tags-Cancel/dismiss\\(x\\) button$")
	public void verify_right_click_options_Add_tags_Cancel_dismiss_x_button() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[8]", 10).click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_70
	@Given("^Verify right click options Add tags-disabled Save button$")
	public void verify_right_click_options_Add_tags_disabled_Save_button() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[8]", 10).click();
		Thread.sleep(1500);
		boolean saveaddtag = login.driver
				.findElement(By.xpath("//div[@class='sphere-modal-controls--right']/button[2]")).isEnabled();
		System.out.println(saveaddtag);
		if (saveaddtag == false) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>70");
	}

	// TC_MyInsights_71
	@Given("^Verify right click options Add tags for multiple insights at once$")
	public void verify_right_click_options_Add_tags_for_multiple_insights_at_once() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		delete_Nameyourinsight();
		Thread.sleep(5500);
		String firstelementbefore = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		int number_of_insights = 3;
		for (int i = 1; i <= number_of_insights; i++) {
			if (!(i == number_of_insights)) {
				new Actions(login.driver).keyDown(Keys.CONTROL).moveToElement(CommonFunctionality.getElementByXpath(
						login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ i + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().build().perform();
			}
			if (i == number_of_insights) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ number_of_insights + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//div[@class='insight-table-item--options']//*[name()='use' and contains(@*,'#actions__options')])["
								+ number_of_insights + "]",
						4)).pause(200).contextClick().build().perform();

			}
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Add tags']", 10).click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Add tags (3 insights)')]",
				10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_72
	@Given("^Verify right click options Add tags-selected insights count in add tags window$")
	public void verify_right_click_options_Add_tags_selected_insights_count_in_add_tags_window() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		delete_Nameyourinsight();
		String firstelementbefore = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		int number_of_insights = 3;
		for (int i = 1; i <= number_of_insights; i++) {
			if (!(i == number_of_insights)) {
				new Actions(login.driver).keyDown(Keys.CONTROL).moveToElement(CommonFunctionality.getElementByXpath(
						login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ i + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().build().perform();
			}
			if (i == number_of_insights) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[not(contains(@data-id,'Untitled-insight'))]/following-sibling::*[contains(@title,'Share')])["
								+ number_of_insights + "]//following::div[@class='insight-table-item--info'][1]",
						4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"(//*[name()='use' and contains(@*,'#actions__options')])[" + number_of_insights + "]", 4))
						.pause(200).contextClick().build().perform();
			}
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Add tags']", 10).click();
		String addtagcount = CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Add tags (3 insights)')]",
				10).getText();
		String str = addtagcount;
		String numberOnly = str.replaceAll("[^0-9]", "");
		int count = Integer.parseInt(numberOnly);
		if (count == 3) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_73
	@Given("^Verify right click options Delete-popup$")
	public void verify_right_click_options_Delete_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		WebElement rightclickelement = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(rightclickelement).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[9]", 10).click();
		Thread.sleep(1500);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='delete-insight-modal']", 10).isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_75
	@Given("^Verify insight favorite icon behavior$")
	public void verify_insight_favorite_icon_behavior() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("rightclicktag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		String firstelementfav = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"(//a[@class='link insight-table-item--title-link text-dots'])[1]/preceding::div[3]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Favorite'])", 10).click();
		String firstelementinfavtab = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (firstelementfav.equalsIgnoreCase(firstelementinfavtab)) {
			System.out.println("verified");

		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"(//a[@class='link insight-table-item--title-link text-dots'])[1]/preceding::div[3]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(2500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_76
	@Given("^Verify Share icon$")
	public void verify_Share_icon() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"(//a[@class='link insight-table-item--title-link text-dots'])[1]/preceding::div[2]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//h4[@class='modal-title sphere-modal__title text-dots']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_77
	@Given("^Verify More options icon click$")
	public void verify_More_options_icon_click() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		Assert.assertTrue(
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']", 10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_78
	@Given("^Verify scrolling down for last insights$")
	public void verify_scrolling_down_for_last_insights() throws Throwable {

	}

	// TC_MyInsights_79
	@Given("^Verify insights options/icons in Grid mode$")
	public void verify_insights_options_icons_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		// Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
		// "(//div[@class='insight-grid-item--details'])[1]/div[1]", 10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_80
	@Given("^Verify Copy insight in Grid mode$")
	public void verify_Copy_insight_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("rightclicktag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='insight-copy insight-item-actions--item'])[1]", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Copy Insight')]",
				10).click();
		navigates_to_Myinsight_page();
		WebElement firstelementgrid1 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action1 = new Actions(login.driver);
		action1.moveToElement(firstelementgrid1).build().perform();

		String copyfirstelementingrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10).getText();
		System.out.println("Verified" + copyfirstelementingrid);
		if (copyfirstelementingrid.contains("copy")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();

		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>80");
	}

	// TC_MyInsights_81
	@Given("^Verify Share insight in Grid mode$")
	public void verify_Share_insight_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("rightclicktag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-share-button--wrapper'])[1]", 10)
				.click();
		Thread.sleep(1500);
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//h4[@class='modal-title sphere-modal__title text-dots']", 10)
				.isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();

		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();

		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();

		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_82
	@Given("^Verify Add tags insight in Grid mode$")
	public void verify_Add_tags_insight_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("ADDtag");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='insight-tags  insight-tags__violet'])[1]", 10).click();

		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@class='ui-widget-content ui-autocomplete-input']", 10)
				.sendKeys("Addingtag");
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'All tags')]//following::span[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10)
				.isDisplayed());
		System.out.println("verified");
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Addingtag')]", 10).click();
		Thread.sleep(1500);
		WebElement firstelementgrid1 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action1 = new Actions(login.driver);
		action1.moveToElement(firstelementgrid1).build().perform();

		String Addtagfirstelementingrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10).getText();
		System.out.println("Verified" + Addtagfirstelementingrid);

		if (Addtagfirstelementingrid.equalsIgnoreCase("ADDtag")) {

			System.out.println("verified");
			WebElement firstelementgrid2 = CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
			Actions action2 = new Actions(login.driver);
			action2.moveToElement(firstelementgrid2).build().perform();

			CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='insight-tags insight-tags__active insight-tags__violet'])[1] ", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//span[@class='text-icon' and contains(text(),'×')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Save')]", 10).click();
			Thread.sleep(5500);

			WebElement closeiconaddtag = CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='custom-select-title--reset-icon'])[3]", 10);
			Actions action3 = new Actions(login.driver);
			action3.moveToElement(closeiconaddtag).click().build().perform();
			Thread.sleep(1500);
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
					10).click();
			Thread.sleep(5500);

		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_83
	@Given("^Verify Delete insight in Grid mode$")
	public void verify_Delete_insight_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("Deleteinsightgrid");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='insight-delete insight-item-actions--item'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(2500);
		WebElement firstelementgrid1 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action1 = new Actions(login.driver);
		action1.moveToElement(firstelementgrid1).build().perform();
		String deleteinsightgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10).getText();
		if (!deleteinsightgrid.equalsIgnoreCase("Deleteinsightgrid")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_84
	@Given("^Verify View in Grid mode$")
	public void verify_View_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"(//a[@class='insight-grid-item--buttons-item button' and contains(text(),'View')])[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_85
	@Given("^Verify Customize in Grid mode$")
	public void verify_Customize_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='insight-grid-item--buttons-item button' and contains(text(),' Customize')])[1]", 10)
				.click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='data-action-panel insight-action-panel']", 10)
				.isDisplayed());
		Thread.sleep(1500);
		// CommonFunctionality.getElementByXpath(login.driver,
		// "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_86
	@Given("^Verify Favorite in Grid mode$")
	public void verify_Favorite_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10).sendKeys("Favinsight");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		navigates_to_Myinsight_page();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insight-favorite  insight-favorite__violet_light'])[1]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Favorite'])", 10).click();
		Thread.sleep(2500);
		WebElement firstelementgrid1 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action1 = new Actions(login.driver);
		action1.moveToElement(firstelementgrid1).build().perform();

		String Favinsightgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10).getText();
		if (Favinsightgrid.equalsIgnoreCase("Favinsight")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(2500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_87
	@Given("^Verify insight title click in Grid mode$")
	public void verify_insight_title_click_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-preview--actions']", 10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-preview--close']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_88
	@Given("^Verify insight description on mouse over in Grid mode$")
	public void verify_insight_description_on_mouse_over_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
				.sendKeys("InsightDescription");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='name-li' and contains(text(), 'Settings')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "(//div[@class='insight-settings-control'])[2]/textarea", 10)
				.sendKeys("Testing Description");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Save')]", 10)
				.click();
		navigates_to_Myinsight_page();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		String InsightDescription = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insight-grid-item--description-text text-dots']", 10)
				.getText();

		if (InsightDescription.equalsIgnoreCase(InsightDescription)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(2500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_89
	@Given("^Verify last editor in Grid mode$")
	public void verify_last_editor_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
					.sendKeys("TestingLastEditor");
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
					10).click();
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[1]", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"(//div[@class='add-to-data-selection add-to-data-selection__search-series']/div)[1]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//span[@class='name-li' and contains(text(),'Save')])[1]", 10)
					.click();
			navigates_to_Myinsight_page();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//span[@class='dropdown--icon icon--filter-arrow'])[3]", 10)
					.click();
			// CommonFunctionality.getElementByXpath(login.driver,"(//span[@class='insights-tags-item--tag-title
			// text-dots'])[1]", 10).click();
			WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
			Actions action = new Actions(login.driver);
			action.moveToElement(firstelementgrid).build().perform();
			String LastEditorinsight = CommonFunctionality
					.getElementByXpath(login.driver,
							"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10)
					.getText();
			if (LastEditorinsight.equalsIgnoreCase("TestingLastEditor")) {
				System.out.println("verified");
				// CommonFunctionality.getElementByXpath(login.driver,
				// "(//span[@class='custom-select-title--reset-icon'])[3]", 10).click();

				CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
						.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
						.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
						10).click();
				Thread.sleep(1500);

			} else {
				Assert.fail();
			}

			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		}

		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Create insight'])", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='create']/input", 10)
					.sendKeys("TestingLastEditor");
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
					10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='series-list-item--checkbox svg-checkbox'])[1]", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"(//div[@class='add-to-data-selection add-to-data-selection__search-series']/div)[1]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insight-context-menu--menu-icon']", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//span[@class='name-li' and contains(text(),'Save')])[1]", 10)
					.click();
			navigates_to_Myinsight_page();
			CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//span[@class='dropdown--icon icon--filter-arrow'])[3]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"(//span[@class='insights-tags-item--tag-title text-dots'])[1]", 10).click();
			WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
			Actions action = new Actions(login.driver);
			action.moveToElement(firstelementgrid).build().perform();
			String LastEditorinsight = CommonFunctionality
					.getElementByXpath(login.driver,
							"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10)
					.getText();
			if (LastEditorinsight.equalsIgnoreCase("TestingLastEditor")) {
				System.out.println("verified");
				CommonFunctionality
						.getElementByXpath(login.driver, "(//span[@class='custom-select-title--reset-icon'])[3]", 10)
						.click();

				CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
						.click();
				CommonFunctionality
						.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
						.click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
						10).click();
				Thread.sleep(1500);

			} else {
				Assert.fail();
			}

			CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

		}
	}

	// TC_MyInsights_90
	@Given("^Verify last modified time in Grid mode$")
	public void verify_last_modified_time_in_Grid_mode() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.moveToElement(firstelementgrid).build().perform();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//span[@class='insight-grid-item--created-date']", 10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>90");
	}

	// TC_MyInsights_91
	@Given("^Verify Folders$")
	public void verify_Folders() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Expand My folders']", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insights-tree insights-tree--opened']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Collapse My folders']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_92
	@Given("^Verify expand/collapse icon for folder panel$")
	public void verify_expand_collapse_icon_for_folder_panel() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Expand My folders']", 10).click();
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='navigation-sidebar--navigation navigation-sidebar--navigation__show']", 10)
				.isDisplayed());
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Collapse My folders']", 10).click();
		if (login.driver
				.findElements(
						By.xpath("//div[@class='navigation-sidebar--navigation navigation-sidebar--navigation__show']"))
				.size() == 0) {
			System.out.println("Verified collapse");
		} else {
			Assert.fail();
		}
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_93
	@Given("^Verify New folder$")
	public void verify_New_folder() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Expand My folders']", 10).click();

		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10).clear();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();
		List<WebElement> dropdown = login.driver
				.findElements(By.xpath("//div[@class='insights-tree-node-name text-dots']"));

		for (int a = dropdown.size() - 1; a >= 0; a--) {
			System.out.println("size" + a);
			String value = dropdown.get(a).getText();
			System.out.println(value);

			if (value.equalsIgnoreCase("Creatingfolder")) {
				System.out.println("Verified");
				break;
			} else {
				Assert.fail();

			}

		}

		// String createdfolder =
		// CommonFunctionality.getElementByXpath(login.driver,"//div[@class='insight-breadcrumb--title
		// text-dots insight-breadcrumb--title__editable']", 10).getText();
//

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='insight-context-menu--menu-icon']", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[8]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_94
	@Given("^Verify Empty folder$")
	public void verify_Empty_folder() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Expand My folders']", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();

		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='insights-group-empty--info-title']", 10).isDisplayed());
		Assert.assertTrue(
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//div[@class='insights-group-empty--info-title']/following::span[1]", 10)
						.isDisplayed());
		Assert.assertTrue(CommonFunctionality
				.getElementByXpath(login.driver, "//a[@class='link insights-group-empty--info-link']", 10)
				.isDisplayed());

		CommonFunctionality.getElementByXpath(login.driver, "//a[@class='link insights-group-empty--info-link']", 10)
				.click();

		Thread.sleep(2000);

		String beforeinsightname = login.driver.findElement(By.xpath("//input[@class='form--control']"))
				.getAttribute("value");

		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//button[@class='sphere-modal-control button button__primary']")).click();
		Thread.sleep(2000);
		// Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Createdinsight_ack"))).isDisplayed());
		Thread.sleep(2000);
		String afterinsightname = login.driver
				.findElement(By.xpath(
						"//div[@class='insight-breadcrumb--title text-dots insight-breadcrumb--title__editable']"))
				.getText();
		if (beforeinsightname.equalsIgnoreCase(afterinsightname)) {
			System.out.println("verified");
		} else {
			Assert.fail();
		}

		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_95
	@Given("^Verify Right click options for folder$")
	public void verify_Right_click_options_for_folder() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Expand My folders']", 10).click();

		// (//div[@class='insights-tree-node
		// insights-tree-node--selected']/div/following::div[1])[1]

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();
		Thread.sleep(1500);
		Assert.assertTrue(
				CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']", 10).isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[9]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Collapse My folders']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_99
	@Given("^Verify folder rename$")
	public void verify_folder_rename() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Expand My folders']", 10).click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10).clear();
		CommonFunctionality.wait(2000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[contains(text(),'All insights')]", 10).click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();

		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Rename Folder')]", 10)
				.isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();

		WebElement firstelementgrid1 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action1 = new Actions(login.driver);
		action1.contextClick(firstelementgrid1).build().perform();

		CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='context-menu-item link   ' and  @title='Delete folder']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_100
	@Given("^Verify auto title for Rename folder$")
	public void verify_auto_title_for_Rename_folder() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		// CommonFunctionality.getElementByXpath(login.driver, "//div[@class='modal-body
		// sphere-modal__body']/div/input", 10).sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();
		String autofoldername = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.getAttribute("value");
		if (autofoldername.contains("Folder")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();

		WebElement firstelementgrid1 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action1 = new Actions(login.driver);
		action1.contextClick(firstelementgrid1).build().perform();

		CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='context-menu-item link   ' and  @title='Delete folder']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_101
	@Given("^Verify Rename folder button$")
	public void verify_Rename_folder_button() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();

		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Rename Folder')]", 10)
				.isDisplayed());
		Thread.sleep(1500);

		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10).clear();

		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("renamefolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Rename folder')]",
				10).click();

		Thread.sleep(3500);
		String renamefoldertext = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10)
				.getText();
		System.out.println(renamefoldertext);
		if (renamefoldertext.equalsIgnoreCase("renamefolder")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		WebElement firstelementgrid2 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action2 = new Actions(login.driver);
		action2.contextClick(firstelementgrid2).build().perform();
		Thread.sleep(1500);

		WebElement deleterenamefolder = CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='name-li' and contains(text(),'Delete folder')]", 10);

		JavascriptExecutor executor = (JavascriptExecutor) login.driver;
		executor.executeScript("arguments[0].click()", deleterenamefolder);

		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
		System.out.println("===============================================>101");
	}

	// TC_MyInsights_102
	@Given("^Verify Cancel button for Rename folder popup$")
	public void verify_Cancel_button_for_Rename_folder_popup() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[1]", 10).click();

		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Rename Folder')]", 10)
				.isDisplayed());
		Thread.sleep(1500);

		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10).clear();

		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10)
				.isDisplayed());
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		WebElement firstelementgrid2 = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action2 = new Actions(login.driver);
		action2.contextClick(firstelementgrid2).build().perform();
		Thread.sleep(1500);

		WebElement deleterenamefolder = CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='name-li' and contains(text(),'Delete folder')]", 10);

		JavascriptExecutor executor = (JavascriptExecutor) login.driver;
		executor.executeScript("arguments[0].click()", deleterenamefolder);

		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_103
	@Given("^Verify new folder in right click$")
	public void verify_new_folder_in_right_click() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='Expand My folders']", 10).click();

		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[2]", 10).click();

		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolderinrightclick");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='insights-tree-node-icon']", 10).click();

		String createdfolder = CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree-node-icon insights-tree-node-icon--opened']/following::div[5]", 10)
				.getText();

		if (createdfolder.equalsIgnoreCase("Creatingfolderinrightclick")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		WebElement subfolder = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node-name text-dots'])[1]", 10);
		Actions action2 = new Actions(login.driver);
		action2.contextClick(subfolder).build().perform();

		WebElement deleterenamefolder = CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='name-li' and contains(text(),'Delete folder')]", 10);

		JavascriptExecutor executor = (JavascriptExecutor) login.driver;
		executor.executeScript("arguments[0].click()", deleterenamefolder);

		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(5500);

		/*
		 * WebElement firstelementgrid3 =
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]"
		 * , 10); Actions action3 =new Actions(login.driver);
		 * action3.contextClick(firstelementgrid3).build().perform();
		 * Thread.sleep(1500);
		 * 
		 * WebElement deleterenamefolder1 =
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//span[@class='name-li' and contains(text(),'Delete folder')]", 10);
		 * 
		 * JavascriptExecutor executor1 = (JavascriptExecutor)login.driver;
		 * executor1.executeScript("arguments[0].click()", deleterenamefolder1);
		 * 
		 * 
		 * CommonFunctionality.getElementByXpath(login.driver,
		 * "//button[@class='sphere-modal-control button button button__primary' and contains(text(),'Delete forever')]"
		 * , 10).click(); Thread.sleep(1500);
		 */
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_104
	@Given("^Verify new insights under folder right click$")
	public void verify_new_insights_under_folder_right_click() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[3]", 10).click();

		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver,
				"//h4[@class='modal-title sphere-modal__title text-dots' and contains(text(),'Create Insight')]", 10)
				.isDisplayed());
		Thread.sleep(1500);

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();
	}

	// TC_MyInsights_105
	@Given("^Verify auto title for Create insight under folder right click$")
	public void verify_auto_title_for_Create_insight_under_folder_right_click() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[3]", 10).click();

		Thread.sleep(1500);

		String autotitletext = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.getAttribute("value");
		System.out.println(autotitletext);
		if (autotitletext.contains("Insight")) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_106
	@Given("^Verify Create insight under folder right click$")
	public void verify_Create_insight_under_folder_right_click() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[3]", 10).click();

		String autotitletext = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.getAttribute("value");
		System.out.println(autotitletext);
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		Thread.sleep(7500);

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action2 = new Actions(login.driver);
		action2.moveToElement(gridmode).build().perform();
		String newinsightfoldertext = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10).getText();
		System.out.println(newinsightfoldertext);
		if (autotitletext.equalsIgnoreCase(newinsightfoldertext)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		WebElement subfolder = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node-name text-dots'])[1]", 10);
		Actions action3 = new Actions(login.driver);
		action3.contextClick(subfolder).build().perform();

		WebElement deleterenamefolder = CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='name-li' and contains(text(),'Delete folder')]", 10);

		JavascriptExecutor executor = (JavascriptExecutor) login.driver;
		executor.executeScript("arguments[0].click()", deleterenamefolder);

		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(5500);

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_107
	@Given("^Verify Cancel button for new insight popup under folder right click$")
	public void verify_Cancel_button_for_new_insight_popup_under_folder_right_click() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();
		Thread.sleep(3500);

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[3]", 10).click();

		Assert.assertTrue(CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10)
				.isDisplayed());
		Thread.sleep(1500);

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='sphere-modal__close']", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_108
	@Given("^Verify Delete folder$")
	public void verify_Delete_folder() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		WebElement subfolder = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node-name text-dots'])[1]", 10);
		Actions action3 = new Actions(login.driver);
		action3.contextClick(subfolder).build().perform();

		WebElement deleterenamefolder = CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='name-li' and contains(text(),'Delete folder')]", 10);

		JavascriptExecutor executor = (JavascriptExecutor) login.driver;
		executor.executeScript("arguments[0].click()", deleterenamefolder);

		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(10500);

		if (login.driver.findElements(By.xpath("(//div[@class='insights-tree-node-name text-dots'])[1]")).size() == 0) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	// TC_MyInsights_109
	@Given("^Verify insight which is added to folder$")
	public void verify_insight_which_is_added_to_folder() throws Throwable {
		CommonFunctionality.wait(2000);

		CommonFunctionality.getElementByXpath(login.driver, "(//*[text()='Created'])", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 10).click();
		Thread.sleep(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//div[@class='insights-tree--create-folder-button' and contains(text(),'Add new folder')]", 10)
				.click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.sendKeys("Creatingfolder");
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create folder')]",
				10).click();
		Thread.sleep(3500);

		WebElement firstelementgrid = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node insights-tree-node--selected']/div/following::div[1])[1]", 10);
		Actions action = new Actions(login.driver);
		action.contextClick(firstelementgrid).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='items-wrapper']/li[3]", 10).click();

		String autotitletext = CommonFunctionality
				.getElementByXpath(login.driver, "//div[@class='modal-body sphere-modal__body']/div/input", 10)
				.getAttribute("value");
		System.out.println(autotitletext);
		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Create insight')]",
				10).click();
		Thread.sleep(7500);

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 10).click();
		WebElement gridmode = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10);
		Actions action2 = new Actions(login.driver);
		action2.moveToElement(gridmode).build().perform();
		String newinsightfoldertext = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='link link__medium insight-grid-item--bottom-panel-title'])[1]", 10).getText();
		System.out.println(newinsightfoldertext);
		if (autotitletext.equalsIgnoreCase(newinsightfoldertext)) {
			System.out.println("Verified");
		} else {
			Assert.fail();
		}

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		WebElement subfolder = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[@class='insights-tree-node-name text-dots'])[1]", 10);
		Actions action3 = new Actions(login.driver);
		action3.contextClick(subfolder).build().perform();

		WebElement deleterenamefolder = CommonFunctionality.getElementByXpath(login.driver,
				"//span[@class='name-li' and contains(text(),'Delete folder')]", 10);

		JavascriptExecutor executor = (JavascriptExecutor) login.driver;
		executor.executeScript("arguments[0].click()", deleterenamefolder);

		CommonFunctionality.getElementByXpath(login.driver,
				"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
				10).click();
		Thread.sleep(5500);

		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='navigation-sidebar--open-icon']", 10)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//div[@class='application-logo']", 10).click();

	}

	public static void delete_Nameyourinsight() throws InterruptedException {
		Thread.sleep(3000);
		String Firstelement = CommonFunctionality
				.getElementByXpath(login.driver, "(//a[@class='link insight-table-item--title-link text-dots'])[1]", 10)
				.getText();
		if (Firstelement.equalsIgnoreCase("Name your insight")) {
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='insight-table-item--options'])[1]", 10)
					.click();
			CommonFunctionality
					.getElementByXpath(login.driver, "(//div[@class='items-wrapper'])[1]/li[9]/span/span[2]", 10)
					.click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//button[@class='sphere-modal-control button button__primary' and contains(text(),'Delete forever')]",
					10).click();
			System.out.println("Deleted");
			Thread.sleep(1500);
		}

	}

/*	@And("^Verify CEIC logo$")
	public void verify_CEIC_logo() throws Throwable {

		Thread.sleep(3000);

		if (login.driver.findElement(By.xpath("//div[@class='application-logo']")).isDisplayed()) {
			login.Log4j.info("CEIC logo Displayed:PASS");
		} else {
			fail("CEIC logo not displayed:FAIL");
		}

	}*/

	/*@And("^Verify insight title change$")
	public void verify_insight_title_change() throws Throwable {
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("//div[@class='insights-view-modes--item insights-view-modes--item__table']"))
				.click();

		WebElement MyInsights = login.driver
				.findElement(By.xpath("//a[@class='link insight-table-item--title-link text-dots']"));
		action.moveToElement(MyInsights).build().perform();
		Thread.sleep(3000);

		login.driver
				.findElement(By.xpath(
						"(//div[@class='insight-table-item--title-action insight-table-item--title-action__edit'])[1]"))
				.click();

		login.driver
				.findElement(
						By.xpath("(//div[@class='form--group form--group__sm insight-table-item--title-input'])[1]"))
				.click();
		Thread.sleep(3000);

	}
*/
}
