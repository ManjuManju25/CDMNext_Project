package CDMNext.StepDefinations;

import static org.junit.Assert.assertNotEquals;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
//import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import CDMNext.util.CommonFunctionality;
import CDMNext.util.Hooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CollabarationSharing {

	WebDriverWait wait = new WebDriverWait(login.driver, 50);
	SoftAssert sa = new SoftAssert();
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	CDMNextSprintCases cv = new CDMNextSprintCases();
	public static String Untitled_insight = "Shravas";
	public SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy_hh-mm-ss");
	public static Date date = new Date();
	public static String new_insight_name;
	public static String first_insight;
	public static String second_insight;
	public static String third_insight;
	public static String sharing_mail;
	public static String searched_user;
	public static String invite_specific_user;
	public static String permission_type;
	public static String creator_name;
	int number_of_insights;
	int total_new_insights;
	ArrayList<String> new_insights = new ArrayList<String>();

	@SuppressWarnings("deprecation")
	@And("^Navigate to \"([^\"]*)\" -> \"([^\"]*)\"$")
	public void navigate_to(String arg1, String arg2) throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 4))
				.pause(200).click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='items-wrapper']//*[text()='" + arg2 + "']", 4))
				.pause(200).click().build().perform();
	}

	@And("^Navigate insights$")
	public void navigate_insights() throws Throwable {
		URL url = new URL(login.driver.getCurrentUrl());
		login.driver.get(url.getProtocol() + "://" + url.getHost() + "/Untitled-insight/myseries");
	}

	@SuppressWarnings("deprecation")
	@And("^Open sharing window next time$")
	public void open_sharing_window_next_time() throws Throwable {
		login_back_to_current_user();
		cv.click_on_my_insights();
		click_tab("Created");
		WebElement grid_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a grid']/parent::div", 4);
		if (grid_mode.getAttribute("class").contains("insights-view-modes__grid-mode-teal")) {
			System.out.println("Already grid mode is clicked");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 4))
					.pause(500).click().build().perform();
		}
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementByXpath(login.driver, "//div[@title='" + new_insight_name + "']", 4))
				.pause(500).build().perform();
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Customize')]", 4))
				.click().build().perform();
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4).click();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "span[title='Share']", 4))
				.click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
						".share-specific--users-list .share-user-delete-box.icon--red-cross", 4))
				.pause(500).click().build().perform();
		cv.click_on_button_to_share("Save");
		if (login.driver
				.findElements(By.xpath(
						"//*[text()='Confirmation']/following::*[@class='sphere-modal-controls']//*[text()='OK']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Confirmation']/following::*[@class='sphere-modal-controls']//*[text()='OK']", 4)
					.click();
		}
		logout_from_current_user();
	}

	@SuppressWarnings("deprecation")
	public void deleting_insights(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.className("insight-breadcrumb--separator")).size() > 0) {
			cv.click_on_my_insights();
		} else {
			System.out.println("My insights is clicked already");
		}
		WebElement table_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a table']/parent::div", 4);
		if (table_mode.getAttribute("class").contains("insights-view-modes__table-mode-teal")) {
			System.out.println("Table mode is clicked already");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 4))
					.pause(1000).click().build().perform();
		}
		List<WebElement> untitled_count = login.driver.findElements(By.xpath(arg1));
		
		for (WebElement untitled : untitled_count) {
			new Actions(login.driver).moveToElement(untitled).pause(1000).contextClick().build().perform();
			CommonFunctionality.webDriverwait_locator("//*[@class='items-wrapper']//*[@title='Delete']", "xpath");
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='items-wrapper']//*[@title='Delete']", 4))
					.pause(2000).click().build().perform();
			CommonFunctionality.webDriverwait_locator("//*[text()='Delete forever']", "xpath");
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Delete forever']", 4))
					.pause(2000).click().build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("growl-message-content")));
		}
	}

	@And("^Create a fresh insight$")
	public void create_a_fresh_insight() throws Throwable {
		new_insight_name = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'modal-window')]//*[@class='form--control']", 4)
				.getAttribute("value");
		cv.click_to_create_a_new_insight("Create insight");
	}

	@SuppressWarnings("deprecation")
	@And("^Click \"([^\"]*)\" option from the title$")
	public void click_option_from_the_title(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 4))
				.pause(1000).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Move the mouse on any one of the insights$")
	public void move_the_mouse_on_any_one_of_the_insights() throws Throwable {
		WebElement scroll = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[contains(@class,'insight-grid-item--bottom-panel-title')])[1]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", scroll);
		new Actions(login.driver).moveToElement(scroll).pause(200).build().perform();
	}

	@And("^Capture the creator user name$")
	public void capture_the_creator_user_name() throws Throwable {
		CommonFunctionality.wait(2000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				"div[title='View and edit profile information']", 4)).click().build().perform();
		creator_name = CommonFunctionality.getElementBycssSelector(login.driver, "span[js-user-fullname='']", 4)
				.getText();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
				"div[title='View and edit profile information']", 4)).click().build().perform();
	}

	@And("^Click on \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\" > \"([^\"]*)\"$")
	public void click_on(String arg1, String arg2, String arg3, String arg4, String arg5) throws Throwable {
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4))
				.click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//*[@title='" + arg2 + "']", 4)).click().build().perform();
		CommonFunctionality.wait(2000);
		if (CommonFunctionality.getElementBycssSelector(login.driver, ".modal-content.sphere-modal__content", 4)
				.isDisplayed()) {
			WebElement protect_option = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='" + arg3 + "']/following::div[2]", 4);
			if (arg4.equalsIgnoreCase("OFF")) {
				CommonFunctionality.wait(2000);
				if (protect_option.getAttribute("class").contains("bootstrap-switch-on")) {
					new Actions(login.driver)
							.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
									"//*[text()='" + arg3 + "']/following::*[@class='bootstrap-switch-label'][1]", 4))
							.click().build().perform();
				} else {
					System.out.println(arg3 + " option is already in " + arg4 + " state");
				}
			}
			boolean apply = login.driver
					.findElement(By.xpath("//*[text()='" + arg5 + "' and contains(@class,'button__secondary_purple')]"))
					.isEnabled();
			if (apply == true) {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[text()='" + arg5 + "' and contains(@class,'button__secondary_purple')]", 4)
						.click();
			} else {
				fail(arg5 + "button is not enabled");
			}
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Permission tab not displayed");
		}
	}

	@And("^Click on File > Protect > Copy > ON > Apply$")
	public void click_on_File_Protect_Copy_ON_Apply() throws Throwable {
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4))
				.click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//*[@title='Protect']", 4)).click().build().perform();
		CommonFunctionality.wait(2000);
		if (CommonFunctionality.getElementBycssSelector(login.driver, ".modal-content.sphere-modal__content", 4)
				.isDisplayed()) {
			WebElement protect_option = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Copy']/following::div[2]", 4);
			if (protect_option.getAttribute("class").contains("bootstrap-switch-on")) {
				System.out.println("Copy option is already in ON state");
			} else {
				new Actions(login.driver)
						.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
								"//*[text()='Copy']/following::*[@class='bootstrap-switch-label'][1]", 4))
						.click().build().perform();
			}
			WebElement apply = login.driver
					.findElement(By.xpath("//*[text()='Apply' and contains(@class,'button__secondary_purple')]"));
			if (apply.getAttribute("class").contains("button__disabled")) {
				System.out.println("Apply button is not enabled");
			} else {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='Apply' and contains(@class,'button__secondary_purple')]", 4).click();
			}
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Permission tab not displayed");
		}
	}

	@And("^Perform first login actions$")
	public void perform_first_login_actions() throws Throwable {
		logout_from_current_user();
		login_as_ceic_user();
		cv.click_on_my_insights();
		click_tab("Shared");
	}

	@SuppressWarnings("deprecation")
	@And("^Perform second login actions$")
	public void perform_second_login_actions() throws Throwable {
		login_back_to_current_user();
		cv.click_on_my_insights();
		click_tab("Created");
		CommonFunctionality.wait(500);
		WebElement grid_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a grid']/parent::div", 4);
		if (grid_mode.getAttribute("class").contains("insights-view-modes__grid-mode-teal")) {
			System.out.println("Already grid mode is clicked");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 4))
					.pause(500).click().build().perform();
		}
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + new_insight_name + "']", 4))
				.pause(500).build().perform();
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Customize')][1]", 4))
				.pause(500).click().build().perform();
	}

	@And("^Perform third login actions$")
	public void perform_third_login_actions() throws Throwable {
		login_back_to_current_user();
		cv.click_on_my_insights();
		click_tab("Created");
		deleting_insights("//*[text()='" + new_insight_name + "']");
	}

	@And("^Verify Share option status$")
	public void verify_Share_option_status() throws Throwable {
		cv.click("File", "New");
		create_a_fresh_insight();
		verify_the_insight_for_icon("share");
		cv.click_on_icon_to_share_insight("Insight");
		cv.select_Users_to_share();
		cv.click_on_button_to_share("Save");
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'button__text_purple') and contains(text(),'email')]", 4).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Select few insights and click on Share option$")
	public void select_few_insights_and_click_on_Share_option() throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@title,'" + new_insight_name
								+ "')]/ancestor::*[@class='insight-table-item--title'][1]",
						4))
				.keyUp(Keys.CONTROL).pause(200).click().keyDown(Keys.CONTROL).build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@title='Share Insight']/following::*[contains(@class,'insight-table-item--title-link')])[1]", 4))
				.keyUp(Keys.CONTROL).pause(200).contextClick().keyDown(Keys.CONTROL).build().perform();
	}

	@Then("^Click on dropdown to view permission list to select \"([^\"]*)\" permission$")
	public void click_on_dropdown_to_view_permission_list_to_select_permission(String arg1) throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'share-type-permissions')]//span[@class='insight-share--choose-button-arrow']", 4))
				.click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'select-permissions')]//li//span[@title='" + arg1 + "']", 4).click();
		cv.click_on_button_to_share("Save");
	}

	@Then("^Click on dropdown to select \"([^\"]*)\" permission$")
	public void click_on_dropdown_to_select_permission(String arg1) throws Throwable {
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + sharing_mail
								+ "']/following::span[@class='insight-share--choose-button-arrow'][1]",
						4))
				.click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'select-permissions')]//li//span[@title='" + arg1 + "']", 4).click();
		cv.click_on_button_to_share("Save");
		if (login.driver
				.findElements(By.xpath(
						"//*[text()='Confirmation']/following::*[@class='sphere-modal-controls']//*[text()='OK']"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Confirmation']/following::*[@class='sphere-modal-controls']//*[text()='OK']", 4)
					.click();
		}
		logout_from_current_user();
	}

	public void clicking_dropdown_to_view_permission_list_to_select_permission(String arg1) throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'share-specific--users-list')]//span[@class='insight-share--choose-button-arrow']",
				4)).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//ul[contains(@class,'select-permissions')]//li//span[@title='" + arg1 + "']", 4).click();
		cv.click_on_button_to_share("Save");
	}

	@And("^The \"([^\"]*)\" window is present$")
	public void the_window_is_present(String arg1) throws Throwable {
		String new_insight = CommonFunctionality
				.getElementBycssSelector(login.driver, ".modal-title.sphere-modal__title.text-dots", 4).getText();
		assertEquals(new_insight, arg1);
	}

	@And("^Login as next user$")
	public void login_as_next_user() throws Throwable {
		CommonFunctionality.login_as_next_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", sharing_mail);
	}

	@And("^Login as ceic user$")
	public void login_as_ceic_user() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.login_as_ceic_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", "ceicsuresh10@gmail.com");
	}

	@And("^Click Guest access$")
	public void click_Guest_access() throws Throwable {
		CDMNextSprintCases cdm = new CDMNextSprintCases();
		cdm.open_preference_dropdown();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Guest Mode']", 4))
				.click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, ".js-guest.btn.btn-guest", 4))
				.click().build().perform();
		if (login.driver.findElements(By.className("growl-message-close")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "growl-message-close", 4).click();
		}
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.className("help-bubble")).size() > 0) {
			CommonFunctionality.getElementByClassName(login.driver, "help-bubble-close-icon", 4).click();
		}
	}

	@And("^Click on \"([^\"]*)\" dropdown in share popup$")
	public void click_on_dropdown_in_share_popup(String arg1) throws Throwable {
		if (login.driver.findElements(By.xpath("//*[text()='" + arg1 + "']/preceding-sibling::input")).size() > 0) {
			boolean accounts = login.driver.findElement(By.xpath("//*[text()='" + arg1 + "']/preceding-sibling::input"))
					.isSelected();
			if (accounts == false) {
				new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + arg1 + "']/preceding-sibling::span", 4)).click().build().perform();
			}
		}
	}

	@And("^Create (\\d+) new insights$")
	public void create_new_insights(int arg1) throws Throwable {
		total_new_insights = arg1;
		for (int i = 1; i <= total_new_insights; i++) {
			cv.click("File", "New");
			String insight_name = CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'modal-window')]//*[@class='form--control']", 4).getAttribute("value");
			cv.click_to_create_a_new_insight("Create insight");
			CommonFunctionality.wait(2000);
			new_insights.add(insight_name);
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Select newly created insights in table mode$")
	public void select_newly_created_insights_in_table_mode() throws Throwable {
		first_insight = new_insights.get(0);
		second_insight = new_insights.get(1);
		third_insight = new_insights.get(2);
		WebElement table_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a table']/parent::div", 4);
		if (table_mode.getAttribute("class").contains("insights-view-modes__table-mode-teal")) {
			System.out.println("Already table mode is clicked");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 4))
					.pause(500).click().build().perform();
		}
		new Actions(login.driver).keyDown(Keys.CONTROL)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + first_insight + "']/following::*[@class='insight-table-item--info'][1]", 4))
				.pause(200).click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + second_insight + "']/following::*[@class='insight-table-item--info'][1]", 4))
				.pause(200).click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + third_insight + "']/following::*[@class='insight-table-item--info'][1]", 4))
				.pause(200).click().build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + first_insight + "']/following::*[@class='insight-table-item--options'][1]", 4))
				.pause(200).contextClick().keyUp(Keys.CONTROL).build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Select (\\d+) insights from table mode$")
	public void select_insights_from_table_mode(int arg1) throws Throwable {
		number_of_insights = arg1;
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
	}

	@SuppressWarnings("deprecation")
	@And("^The Invite specific user \"([^\"]*)\" is fetching proper results$")
	public void the_Invite_specific_user_is_fetching_proper_results(String arg1) throws Throwable {
		invite_specific_user = arg1;
		WebElement mail = null;
		if (invite_specific_user.equalsIgnoreCase("ceicsuresh10@gmail.com")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite'] | //input[@placeholder='Select people you want to invite']",
					4);
		}
		if (invite_specific_user.equalsIgnoreCase("cvision-suresh")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite']", 4);
		}
		if (invite_specific_user.equalsIgnoreCase("CEIC Development – CDMNext 2")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite']", 4);
		}
		// new
		// Actions(login.driver).moveToElement(mail).click().sendKeys(invite_specific_user).pause(2000).click().build().perform();
		if (login.driver.findElements(By.xpath("//span[contains(text(),'External users/accounts/companies')]"))
				.size() > 0) {
			new Actions(login.driver).moveToElement(mail).click().sendKeys(invite_specific_user).sendKeys(Keys.ENTER)
					.pause(1000).build().perform();
		} else {
			new Actions(login.driver).moveToElement(mail).click().sendKeys(invite_specific_user).pause(2000).build()
					.perform();
			WebElement result = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='choosable-item ' and contains(text(),'" + invite_specific_user
							+ "')] | //*[@class='choosable-item' and contains(text(),'" + invite_specific_user + "')]",
					4);
			js.executeScript("arguments[0].scrollIntoView(true);", result);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='choosable-item ' and contains(text(),'" + invite_specific_user + "')]", 4))
					.pause(3000).click().build().perform();
		}
		CommonFunctionality.wait(2000);
		/*
		 * WebElement result = CommonFunctionality.getElementByXpath(login.
		 * driver,"//*[@class='choosable-item ' and contains(text(),'"
		 * +invite_specific_user+"')]", 4);
		 * js.executeScript("arguments[0].scrollIntoView(true);", result); new
		 * Actions(login.driver).moveToElement(result).pause(1000).click().build().
		 * perform();
		 */
	}

	@SuppressWarnings("deprecation")
	@And("^The searched user \"([^\"]*)\" is fetching proper results for \"([^\"]*)\"$")
	public void the_searched_user_is_fetching_proper_results_for(String arg1, String arg2) throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='share-specific-search-user']//button//span[2] | //div[contains(@class,'share-specific-search-user')]//button//span[2]",
				4)).click().build().perform();
		List<WebElement> options = login.driver.findElements(
				By.xpath("//ul[contains(@class,'select-permissions')]//li//span[not(contains(@class,'name-li'))]"));
		for (WebElement option : options) {
			String text = option.getText();
			if (text.equals("can view") || text.equals("can edit")) {
				login.Log4j.info("The dropdown permissions are verified and the permission verified is: " + text);
			} else {
				if (text.equals("can manage")) {
					boolean users = login.driver
							.findElement(By.xpath("//*[contains(text(),'Users')]/preceding-sibling::input"))
							.isSelected();
					if (users == true) {
						login.Log4j.info("The Manage option is present for Users invite specific");
					} else {
						fail("The Manage option is present for companies and accounts too");
					}
				}
			}
			CommonFunctionality.wait(4000);
		}
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='items-wrapper']//span[@title='" + arg2 + "']", 4).click();
		permission_type = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='share-specific-search-user']//button//span[1] | //div[contains(@class,'share-specific-search-user')]//button//span[2]",
				4).getText();
		searched_user = arg1;
		CommonFunctionality.wait(2000);
		WebElement mail = null;
		if (searched_user.equalsIgnoreCase("ceicsuresh10@gmail.com")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite'] | //input[@placeholder='Select people you want to invite']",
					4);
		}
		if (searched_user.equalsIgnoreCase("cvision-suresh")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite']", 4);
		}
		if (searched_user.equalsIgnoreCase("CEIC Development – CDMNext 2")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite']", 4);
		}
		// new
		// Actions(login.driver).moveToElement(mail).click().sendKeys(searched_user).pause(3000).click().build().perform();
		if (login.driver.findElements(By.xpath("//span[contains(text(),'External users/accounts/companies')]"))
				.size() > 0) {
			new Actions(login.driver).moveToElement(mail).click().sendKeys(searched_user).sendKeys(Keys.ENTER)
					.pause(1000).build().perform();
		} else {
			new Actions(login.driver).moveToElement(mail).click().sendKeys(searched_user).pause(2000).build().perform();
			WebElement result = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='choosable-item ' and contains(text(),'" + searched_user
									+ "')] | //*[@class='choosable-item' and contains(text(),'" + searched_user + "')]",
							4);
			js.executeScript("arguments[0].scrollIntoView(true);", result);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='choosable-item ' and contains(text(),'" + searched_user + "')]", 4))
					.pause(3000).click().build().perform();
		}
		CommonFunctionality.wait(1000);
		/*
		 * WebElement result = CommonFunctionality.getElementByXpath(login.
		 * driver,"//*[@class='choosable-item ' and contains(text(),'"+searched_user+
		 * "')]", 4); js.executeScript("arguments[0].scrollIntoView(true);", result);
		 * new Actions(login.driver).moveToElement(result).pause(1000).click().build().
		 * perform();
		 */
	}

	@SuppressWarnings("deprecation")
	@And("^Entering mail to share the insight$")
	public void entering_mail_to_share_the_insight() throws Throwable {
		sharing_mail = "ceicsuresh10@gmail.com";
		WebElement mailing = CommonFunctionality.getElementByXpath(login.driver,
				"//input[@placeholder='Type people/accounts/companies you want to invite'] | //input[@placeholder='Select people you want to invite']",
				4);
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//span[contains(text(),'External users/accounts/companies')]"))
				.size() > 0) {
			new Actions(login.driver).moveToElement(mailing).click().sendKeys(sharing_mail).sendKeys(Keys.ENTER)
					.pause(1000).build().perform();
		} else {
			new Actions(login.driver).moveToElement(mailing).click().sendKeys(sharing_mail).pause(1000)
					.sendKeys(Keys.BACK_SPACE).pause(1000).build().perform();
			WebElement result = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='choosable-item ' and contains(text(),'" + sharing_mail
									+ "')] | //*[@class='choosable-item' and contains(text(),'" + sharing_mail + "')]",
							4);
			js.executeScript("arguments[0].scrollIntoView(true);", result);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='choosable-item ' and contains(text(),'" + sharing_mail + "')]", 4))
					.pause(3000).click().build().perform();
		}
	}

	@And("^Logout from current user$")
	public void logout_from_current_user() throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View and edit profile information']", 4)
				.click();
		WebElement logout = CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Sign out')]", 4);
		js.executeScript("arguments[0].scrollIntoView(true);", logout);
		js.executeScript("arguments[0].click();", logout);
		cv.the_application_should_be_logged_out();
	}

	@SuppressWarnings("deprecation")
	@And("^Login as current execution login by taking username rowcount as (\\d+) and cellcount as (\\d+) and for password rowcount as (\\d+) and cellcount as (\\d+)$")
	public void login_as_current_execution_login_by_taking_username_rowcount_as_and_cellcount_as_and_for_password_rowcount_as_and_cellcount_as(
			int arg1, int arg2, int arg3, int arg4) throws Throwable {
		CommonFunctionality.wait(3000);
		String path = "./Login_Details.xlsx";
		File src = new File(path);
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		String username = sheet.getRow(arg1).getCell(arg2).getStringCellValue();
		String password = sheet.getRow(arg3).getCell(arg4).getStringCellValue();
		fis.close();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[title='View and edit profile information']")));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("div[title='View and edit profile information']")));
		logout_from_current_user();
		URL url = new URL(login.driver.getCurrentUrl());
		login.driver.get(url.getProtocol() + "://" + url.getHost() + "/login");
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "input[name='user_id']", 4))
				.pause(500).click().sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE)).sendKeys(username).build()
				.perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "input[name='password']", 4))
				.pause(500).click().sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE)).sendKeys(password).build()
				.perform();
		WebElement submit = CommonFunctionality.getElementBycssSelector(login.driver, "button[type='submit']", 4);
		assertEquals(submit.isEnabled(), true);
		new Actions(login.driver).moveToElement(submit).pause(500).click().build().perform();
		CommonFunctionality.wait(2000);
		Hooks.before_run();
	}

	@SuppressWarnings("deprecation")
	@And("^Enter mail for \"([^\"]*)\" with action as \"([^\"]*)\" an insight$")
	public void enter_mail_for_with_action_as_an_insight(String arg1, String arg2) throws Throwable {
		String parentWindow = login.driver.getWindowHandle();
		WebDriver driver2 = new ChromeDriver();
		Set<String> handles = driver2.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver2.switchTo().window(windowHandle);
				driver2.manage().window().maximize();
				URL url1 = new URL(login.driver.getCurrentUrl());
				driver2.get(url1.getProtocol() + "://" + url1.getHost() + "/login");
				driver2.findElement(By.name("user_id")).sendKeys("ceicsuresh10@gmail.com");
				driver2.findElement(By.name("password")).sendKeys("Ceic@123");
				driver2.findElement(By.cssSelector("button[type='submit']")).click();
				CommonFunctionality.wait(20000);
				login.driver.switchTo().window(parentWindow);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector("div[title='View and edit profile information']")));
				capture_the_creator_user_name();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='application-logo']")));
				if (arg1.equalsIgnoreCase("Notification growl")) {
					cv.click("File", "New");
					create_a_fresh_insight();
					cv.click_on_icon_to_share_insight("Insight");
					entering_mail_to_share_the_insight();
					perform_Share_action();
				}
				if (arg1.equalsIgnoreCase("Multiple insights sharing")) {
					create_new_insights(3);
					cv.click_on_my_insights();
					cv.click_option_from_empty_list("View as a table");
					select_newly_created_insights_in_table_mode();
					click_option("Insight Share");
					entering_mail_to_share_the_insight();
					perform_Share_action();
				}
				if (arg1.equalsIgnoreCase("Notification for shared insight")
						|| arg1.equalsIgnoreCase("Growl message for shared insight")
						|| arg1.equalsIgnoreCase("Clicking Insight title for shared insight")
						|| arg1.equalsIgnoreCase("Closing growl popup")) {
					cv.click("File", "New");
					create_a_fresh_insight();
					cv.click_on_icon_to_share_insight("Insight");
					entering_mail_to_share_the_insight();
					perform_Share_action();
				}
				if (arg1.equalsIgnoreCase("Growl popup for stopped sharing")
						|| arg1.equalsIgnoreCase("Notification for stopped sharing")) {
					cv.click("File", "New");
					create_a_fresh_insight();
					cv.click_on_icon_to_share_insight("Insight");
					entering_mail_to_share_the_insight();
					perform_Share_action();
					Thread.sleep(8000);
					login.driver.findElement(By.cssSelector("div[title='Open File menu']")).click();
					login.driver.findElement(By.cssSelector("span[title='Share']")).click();
					Thread.sleep(1000);
					login.driver.findElement(By.cssSelector(".share-user-delete-box.icon--red-cross")).click();
					login.driver.findElement(By.cssSelector(".sphere-modal-controls .button__primary")).click();
				}
				if (arg1.equalsIgnoreCase("Notification for changes in shared insight")) {
					cv.click("File", "New");
					create_a_fresh_insight();
					cv.click_on_icon_to_share_insight("Insight");
					click_on_dropdown_in_share_popup("Users");
					the_searched_user_is_fetching_proper_results_for("ceicsuresh10@gmail.com", "can edit");
					perform_Share_action();
				}
				
				// wait.until(ExpectedConditions.numberOfwindowsToBe(1));
				CommonFunctionality.wait(2000);
				driver2.switchTo().window(windowHandle);
				CommonFunctionality.wait(2000);
				int actual = 0;
				String shared_username = null;
				String shared_insightname = null;
				String expected = null;
				String stop_growl_message = null;
				String stop_insight_name = null;
				String first_series = null;
				String insight_name_growl = null;
				String stop_insight_notifications = null;
				String insight_name_in_right_pane = null;
				WebElement right_pane_insights = null;
				List<WebElement> growl_display = null;
				List<WebElement> growl_close = null;
				String[] firstline = null;
				String[] secondline = null;
				String[] thirdline = null;
				if (arg1.equalsIgnoreCase("Multiple insights sharing")) {
					List<WebElement> growl = driver2.findElements(By.className("growl-message-text"));
					actual = growl.size();
					System.out.println("The number of insights displaying is: " + actual);
				}
				if (arg1.equalsIgnoreCase("Notification for shared insight")) {
					driver2.findElement(By.className("user-notifications--icon")).click();
					WebElement notification = driver2.findElement(By.xpath("//*[@data-tab='notifications']"));
					if (notification.getAttribute("class").contains("active")) {
						System.out.println("Notification tab is clicked already");
					} else {
						notification.click();
					}
					wait.until(ExpectedConditions.invisibilityOfElementLocated(
							By.xpath("(//div[@class='insights-notifications-item-body']//b)[1]")));
					shared_username = driver2
							.findElement(By.xpath("(//div[@class='insights-notifications-item-body']//b)[1]"))
							.getText();
					shared_insightname = driver2
							.findElement(By.xpath("(//div[@class='insights-notifications-item-body']//a)[1]"))
							.getText();
					System.out.println("The insight details are: " + shared_username + " and " + shared_insightname);
					driver2.findElement(By.cssSelector(".user-notifications.dropdown__open")).click();
				}
				if (arg1.equalsIgnoreCase("Notification for stopped sharing")) {
					Thread.sleep(1000);
					driver2.findElement(By.xpath("//*[@class='user-notifications']")).click();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(
							By.xpath("(//div[@class='insights-notifications-item-body']//b)[1]")));
					shared_username = driver2
							.findElement(By.xpath("(//div[@class='insights-notifications-item-body']//b)[1]"))
							.getText();
					shared_insightname = driver2
							.findElement(By.xpath("(//div[@class='insights-notifications-item-body']//b)[2]"))
							.getText();
					stop_insight_notifications = driver2
							.findElement(By.xpath("(//div[@class='insights-notifications-item-body'])[1]")).getText();
					driver2.findElement(By.xpath("(//*[contains(@class,'user-notifications')])[1]")).click();
				}
				if (arg1.equalsIgnoreCase("Clicking Insight title for shared insight")) {
					insight_name_growl = driver2.findElement(By.xpath("//div[@class='growl-message-text']//a"))
							.getText();
					driver2.findElement(By.xpath("//div[@class='growl-message-text']//a")).click();
					Thread.sleep(1000);
					insight_name_in_right_pane = driver2
							.findElement(By.cssSelector(".insight-breadcrumb--title.text-dots")).getText();
					right_pane_insights = driver2.findElement(By.cssSelector(".main-page--insight.right_panel"));
					if (right_pane_insights.isDisplayed()) {
						System.out.println(insight_name_growl + " is opened");
					} else {
						sa.fail("Insight opening failed");
					}
				}
				if (arg1.equalsIgnoreCase("Notification for changes in shared insight")) {
					WebDriverWait wait1 = new WebDriverWait(driver2, 100);
					wait1.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@class='growl-message-text']//a")));
					driver2.findElement(By.xpath("//div[@class='growl-message-text']//a")).click();
					Thread.sleep(2000);
					driver2.findElement(By.cssSelector("a[data-id='myseries']")).click();
					Thread.sleep(2000);
					driver2.findElement(By.cssSelector("span[title='View as List']")).click();
					Thread.sleep(2000);
					first_series = driver2.findElement(By.xpath("(//*[@class='series-item--name'])[1]")).getText();
					Thread.sleep(2000);
					WebElement source = driver2.findElement(By.xpath("(//*[@class='series-item--name'])[1]"));
					WebElement target = driver2.findElement(By.className("data-selection-series-overlay--content"));
					new Actions(driver2).moveToElement(source).pause(500).dragAndDrop(source, target).build().perform();
					Thread.sleep(1000);
					driver2.findElement(By.cssSelector("div[title='Open File menu']")).click();
					driver2.findElement(By.cssSelector("span[title='Refresh']")).click();
				}
				if (arg1.equalsIgnoreCase("Growl popup for stopped sharing")) {
					WebDriverWait wait2 = new WebDriverWait(driver2, 300);
					wait2.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@class='growl-message-text']")));
					stop_growl_message = driver2.findElement(By.xpath("//div[@class='growl-message-text']")).getText();
					System.out.println(stop_growl_message);
					stop_insight_name = driver2.findElement(By.xpath("(//div[@class='growl-message-text']//b)[2]"))
							.getText();
					System.out.println(stop_insight_name);
					shared_username = driver2.findElement(By.xpath("(//div[@class='growl-message-text']//b)[1]"))
							.getText();
					System.out.println(shared_username);
				}
				if (arg1.equalsIgnoreCase("Closing growl popup")) {
					driver2.findElement(By.className("growl-message-close")).click();
					Thread.sleep(500);
					growl_close = driver2.findElements(By.className("growl-message-content"));
				}
				if (arg1.equalsIgnoreCase("Growl message for shared insight")) {
					expected = driver2.findElement(By.className("growl-message-text")).getText();
					growl_display = driver2.findElements(By.className("growl-messages-container"));
					firstline = expected.split("\n");
					secondline = firstline[2].split("\n");
					thirdline = secondline[0].split("\n");
				}
				driver2.switchTo().window(windowHandle).close();
				login.driver.switchTo().window(parentWindow);
				if (arg1.equalsIgnoreCase("Multiple insights sharing")) {
					sa.assertEquals(actual, 3);
				}
				if (arg1.equalsIgnoreCase("Notification for changes in shared insight")) {
					Thread.sleep(1000);
					login.driver.findElement(By.xpath(
							"//*[contains(@class,'growl-message-content--btns__fill') and contains(text(),'Refresh')]"))
							.click();
					Thread.sleep(2000);
					login.driver.findElement(By.cssSelector("a[data-id='myseries']")).click();
					Thread.sleep(500);
					String myseries_text = login.driver
							.findElement(By.xpath("(//*[@class='series-name-field--series-name'])[1]")).getText();
					sa.assertEquals(myseries_text, first_series);
				}
				if (arg1.equalsIgnoreCase("Notification for shared insight")) {
					sa.assertEquals(creator_name, shared_username);
					sa.assertEquals(new_insight_name, shared_insightname);
				}
				if (arg1.equalsIgnoreCase("Notification for stopped sharing")) {
					sa.assertEquals(creator_name, shared_username);
					sa.assertEquals(new_insight_name, shared_insightname);
					if (!stop_insight_notifications.contains(arg2)) {
						sa.fail("Notification not displayed");
					}
				}
				if (arg1.equalsIgnoreCase("Growl message for shared insight")) {
					sa.assertEquals(growl_display.size(), 1);
					sa.assertEquals(creator_name, firstline[0]);
					sa.assertEquals(new_insight_name, thirdline[0]);
				}
				if (arg1.equalsIgnoreCase("Clicking Insight title for shared insight")) {
					sa.assertEquals(new_insight_name, insight_name_growl);
					sa.assertEquals(new_insight_name, insight_name_in_right_pane);
				}
				if (arg1.equalsIgnoreCase("Closing growl popup")) {
					sa.assertEquals(growl_close.size(), 0);
				}
				if (arg1.equalsIgnoreCase("Growl popup for stopped sharing")) {
					sa.assertEquals(creator_name, shared_username);
					sa.assertEquals(new_insight_name, stop_insight_name);
					if (stop_growl_message.contains(arg2)) {
						System.out.println(stop_growl_message);
					} else {
						sa.fail("No growl popup is displaying for stop sharing");
					}
				}
			}
			login.Log4j.info("The growl popup is displaying");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Perform notification off growl action$")
	public void perform_notification_off_growl_action() throws Throwable {
		logout_from_current_user();
		login_as_ceic_user();
		CommonFunctionality.wait(1000);
		CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[title='View and edit profile information']")));
		CommonFunctionality.wait(1000);
		login.driver.findElement(By.cssSelector("div[title='View and edit profile information']")).click();
		WebElement notification = login.driver
				.findElement(By.xpath("//*[contains(text(),'Notifications')]/following::div[1]"));
		if (notification.getAttribute("class").contains("bootstrap-switch-on")) {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.cssSelector(
							".user-notifications-settings .bootstrap-switch-container .bootstrap-switch-handle-on")))
					.pause(500).click().build().perform();
			login.driver.findElement(By.cssSelector("div[title='View and edit profile information']")).click();
			System.out.println("Notification is turned off");
		} else {
			System.out.println("Notification is already turned off");
			login.driver.findElement(By.cssSelector("div[title='View and edit profile information']")).click();
		}
		login_back_to_current_user();
	}

	@SuppressWarnings("deprecation")
	@And("^Perform notification on growl action$")
	public void perform_notification_on_growl_action() throws Throwable {
		logout_from_current_user();
		login_as_ceic_user();
		CommonFunctionality.wait(1000);
		CommonFunctionality.wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[title='View and edit profile information']")));
		login.driver.findElement(By.cssSelector("div[title='View and edit profile information']")).click();
		WebElement notification = login.driver
				.findElement(By.xpath("//*[contains(text(),'Notifications')]/following::div[1]"));
		if (notification.getAttribute("class").contains("bootstrap-switch-off")) {
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.cssSelector(
							".user-notifications-settings .bootstrap-switch-container .bootstrap-switch-handle-off")))
					.pause(500).click().build().perform();
			login.driver.findElement(By.cssSelector("div[title='View and edit profile information']")).click();
			System.out.println("Notification is turned on");
		} else {
			System.out.println("Notification is already turned on");
			login.driver.findElement(By.cssSelector("div[title='View and edit profile information']")).click();
		}
		login_back_to_current_user();
	}

	@And("^Enter mail for \"([^\"]*)\" with action as \"([^\"]*)\" the insight$")
	public void enter_mail_for_with_action_as_the_insight(String arg1, String arg2) throws Throwable {
		if (arg2.equalsIgnoreCase("Turn OFF notifications")) {
			perform_notification_off_growl_action();
		}
		if (arg2.equalsIgnoreCase("Turn ON notifications")) {
			perform_notification_on_growl_action();
		}
		String parentWindow = login.driver.getWindowHandle();
		WebDriver driver3 = new ChromeDriver();
		Set<String> handles = driver3.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver3.switchTo().window(windowHandle);
				driver3.manage().window().maximize();
				URL url1 = new URL(login.driver.getCurrentUrl());
				driver3.get(url1.getProtocol() + "://" + url1.getHost() + "/login");
				driver3.findElement(By.name("user_id")).sendKeys("ceicsuresh10@gmail.com");
				driver3.findElement(By.name("password")).sendKeys("Ceic@123");
				driver3.findElement(By.cssSelector("button[type='submit']")).click();
				CommonFunctionality.wait(20000);
				login.driver.switchTo().window(parentWindow);
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.cssSelector("div[title='View and edit profile information']")));
				capture_the_creator_user_name();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("application-logo")));
				if (arg1.equalsIgnoreCase("Notification growl")) {
					cv.click("File", "New");
					create_a_fresh_insight();
					cv.click_on_icon_to_share_insight("Insight");
					entering_mail_to_share_the_insight();
					perform_Share_action();
				}
				driver3.switchTo().window(windowHandle);
				int actual = 0;
				String shared_username = null;
				String insight_name_growl = null;
				if (arg2.equalsIgnoreCase("Turn OFF notifications")) {
					List<WebElement> growl = driver3.findElements(By.className("growl-message-text"));
					actual = growl.size();
				}
				if (arg2.equalsIgnoreCase("Turn ON notifications")) {
					List<WebElement> growl = driver3.findElements(By.className("growl-message-text"));
					actual = growl.size();
					WebDriverWait wa = new WebDriverWait(driver3, 120);
					wa.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//div[@class='growl-message-text']//a")));
					insight_name_growl = driver3.findElement(By.xpath("//div[@class='growl-message-text']//a"))
							.getText();
					System.out.println("The insight name is: " + insight_name_growl);
				}
				driver3.switchTo().window(windowHandle).close();
				login.driver.switchTo().window(parentWindow);
				if (arg2.equalsIgnoreCase("Turn OFF notifications")) {
					sa.assertEquals(actual, 0);
					login.Log4j.info("The growl popup is not displaying");
				}
				if (arg2.equalsIgnoreCase("Turn ON notifications")) {
					sa.assertEquals(creator_name, shared_username);
					sa.assertEquals(new_insight_name, insight_name_growl);
					sa.assertEquals(actual, 1);
					login.Log4j.info("The growl popup is displaying");
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Login back to default execution login$")
	public void login_back_to_default_execution_login() throws Throwable {
		if (login.driver.findElements(By.cssSelector("div[title='View and edit profile information']")).size() == 1) {
			logout_from_current_user();
		}
		CommonFunctionality.wait(1000);
		URL url = new URL(login.driver.getCurrentUrl());
		login.driver.get(url.getProtocol() + "://" + url.getHost() + "/login");
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "input[name='user_id']", 4))
				.pause(500).click().sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE))
				.sendKeys(login.CONFIG.getProperty("username")).build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver, "input[name='password']", 4))
				.pause(500).click().sendKeys(Keys.chord(Keys.CONTROL, Keys.BACK_SPACE))
				.sendKeys(login.CONFIG.getProperty("password")).build().perform();
		WebElement submit = CommonFunctionality.getElementBycssSelector(login.driver, "button[type='submit']", 4);
		assertEquals(submit.isEnabled(), true);
		new Actions(login.driver).moveToElement(submit).pause(500).click().build().perform();
		System.out.println(" =======>> Logged in back to the default user successfully <<===========");
		CommonFunctionality.wait(2000);
	}

	@And("^Login back to current user$")
	public void login_back_to_current_user() throws Throwable {
		logout_from_current_user();
		CommonFunctionality.login_as_next_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", "ceicsuresh12@gmail.com");
	}

	@And("^Login back to internal user with user \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void login_back_to_internal_user(String arg1, String arg2) throws Throwable {
		logout_from_current_user();
		CommonFunctionality.login_as_internal_user(login.driver, "input[name='user_id']", "input[name='password']",
				"button[type='submit']", arg1, arg2);
	}

	@And("^Delete Insight$")
	public void delete_Insight() throws Throwable {
		deleting_insights("//*[text()='" + new_insight_name + "']");
	}

	@And("^Perform Share action$")
	public void perform_Share_action() throws Throwable {
		cv.click_on_button_to_share("Save");
		cv.hover_on_button_in_insight_preview("OK");
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[text()='Confirmation']/following::*[@class='sphere-modal-controls']//*[text()='OK']", 4)
				.click();
	}

	@SuppressWarnings("deprecation")
	@And("^Select the first insight$")
	public void select_the_first_insight() throws Throwable {
		new Actions(login.driver).keyDown(Keys.CONTROL)
				.moveToElement(
						CommonFunctionality.getElementByXpath(login.driver,
								"//*[text()='" + new_insight_name
										+ "']//following::*[@class='insight-table-item--info'][1]",
								4))
				.pause(200).click().build().perform();
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@title='Share Insight']/following::a[not(contains(text(),'Name your insight'))])[1]//following::div[@class='insight-table-item--info'][1]",
				4)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + new_insight_name
								+ "']//following::*[@class='insight-table-item--options']//*[@class='icon']",
						4))
				.pause(200).contextClick().build().perform();
	}

	@SuppressWarnings("deprecation")
	@And("^Click \"([^\"]*)\" option$")
	public void click_option(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Insight Share")) {
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='items-wrapper']//*[contains(@title,'Share')]", 4))
					.pause(200).click().build().perform();
		} else {
			new Actions(login.driver).moveToElement(
					CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'" + arg1 + "')]", 4))
					.pause(200).click().build().perform();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Deleting insights as prerequesties$")
	public void deleting_insights_as_prerequesties() throws Throwable {
		ChartVisual chart = new ChartVisual();
		chart.disable_the_Chat_bubble();
		if (login.driver.findElements(By.className("insight-breadcrumb--separator")).size() > 0) {
			cv.click_on_my_insights();
		} else {
			System.out.println("My insights is clicked already");
		}
		WebElement table_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a table']/parent::div", 4);
		if (table_mode.getAttribute("class").contains("insights-view-modes__table-mode-teal")) {
			System.out.println("Table mode is clicked already");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a table']", 4))
					.pause(1000).click().build().perform();
		}
		List<WebElement> untitled_count = login.driver.findElements(By.xpath("//div[@title='Share Insight']//following::div[@class='insight-table-item--info'][1]//div[2]//following::div[1]"));
		//for (int j = 1; j <= 5; j++) {
			for (int i = 0; i <= untitled_count.size(); i++) {
				/*if (i != 1) {
					new Actions(login.driver).keyDown(Keys.CONTROL).moveToElement(CommonFunctionality.getElementByXpath(
							login.driver,
							"(//div[@title='Share Insight']//following::div[@class='insight-table-item--info'][1])[" + i
									+ "]",
							4)).pause(200).click().build().perform();
				}*/
				if (i == untitled_count.size()) {
					// Until the element is not visible keep scrolling
					CommonFunctionality.wait(500);
					js.executeScript("arguments[0].scrollIntoView(true);", untitled_count.get(i-1));
					new Actions(login.driver).moveToElement(untitled_count.get(i-1)).pause(200).click().keyUp(Keys.CONTROL).build().perform();
					int k = i-1;
					new Actions(login.driver)
							.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
									"(//*[name()='use' and contains(@*,'#actions__options')])[" + k + "]", 4))
							.pause(200).contextClick().build().perform();
				}
			}
			CommonFunctionality.webDriverwait_locator("//*[@class='items-wrapper']//*[@title='Delete']", "xpath");
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='items-wrapper']//*[@title='Delete']", 4))
					.pause(2000).click().build().perform();
			CommonFunctionality.webDriverwait_locator("//*[text()='Delete forever']", "xpath");
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//*[text()='Delete forever']", 4))
					.pause(2000).click().build().perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("growl-message-content")));
		//}
	}

	@And("^Click \"([^\"]*)\" tab$")
	public void click_tab(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + arg1 + "']", 4).click();
	}

	@Then("^The \"([^\"]*)\" window should present$")
	public void the_window_should_present(String arg1) throws Throwable {
		if (login.driver.findElements(By.xpath(
				"//*[contains(@class,'sphere-modal-dialog')]//*[contains(@class,'sphere-modal__title') and contains(text(),'Name insight')]"))
				.size() == 1) {
			CommonFunctionality.getElementByClassName(login.driver, "input-share", 4).clear();
			CommonFunctionality.getElementByClassName(login.driver, "input-share", 4)
					.sendKeys(Untitled_insight + "-" + formatter.format(date));
			CommonFunctionality.wait(3000);
			boolean save = login.driver
					.findElement(By.xpath("//*[contains(@class,'button button__primary') and text()='Save']"))
					.isEnabled();
			if (save == true) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(@class,'button button__primary') and text()='Save']", 4).click();
			} else {
				fail("Not enabled");
			}
		}
		if (login.driver.findElements(By.xpath(
				"//*[contains(@class,'sphere-modal-dialog')]//*[contains(@class,'sphere-modal__title') and contains(text(),'"
						+ arg1 + "')]"))
				.size() == 1) {
			login.Log4j.info("The Sharing insight window is opened");
		}
		String modal_title = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__title') and contains(text(),'" + arg1 + "')]", 4).getText();
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		String part[] = modal_title.split("\\s+");
		assertEquals(part[0], arg1);
		login.Log4j.info("The " + arg1 + " Window has been Opened and verified successfully");
		deleting_insights("//*[contains(text(),'Shravas-') and contains(@class,'insight-table-item--title-link')]");
	}

	@Then("^The \"([^\"]*)\" window popups$")
	public void the_window_popups(String arg1) throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "input-share", 4).clear();
		CommonFunctionality.getElementByClassName(login.driver, "input-share", 4)
				.sendKeys(Untitled_insight + "-" + formatter.format(date));
		CommonFunctionality.wait(3000);
		boolean save = login.driver
				.findElement(By.xpath("//*[contains(@class,'button button__primary') and text()='Save']")).isEnabled();
		if (save == true) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'button button__primary') and text()='Save']", 4).click();
		} else {
			fail("Not enabled");
		}
		if (login.driver.findElements(By.xpath(
				"//*[contains(@class,'sphere-modal-dialog')]//*[contains(@class,'sphere-modal__title') and contains(text(),'"
						+ arg1 + "')]"))
				.size() == 1) {
			login.Log4j.info("The Sharing insight window is opened");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Sharing window is not opened");
		}
		deleting_insights("//*[contains(text(),'Shravas-') and contains(@class,'insight-table-item--title-link')]");
	}

	@SuppressWarnings("deprecation")
	@Then("^Verify the insight for \"([^\"]*)\" icon$")
	public void verify_the_insight_for_icon(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement open_file_menu = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']",
				4);
		if (arg1.equalsIgnoreCase("share")) {
			new Actions(login.driver).moveToElement(open_file_menu).pause(500).click().build().perform();
			if (login.driver.findElements(By.xpath("//*[name()='use' and contains(@*, '#actions__" + arg1 + "')]"))
					.size() == 1) {
				login.Log4j.info(arg1 + " icon is present while creating an new insight");
			} else {
				fail("Verification Failed");
			}
			new Actions(login.driver).moveToElement(open_file_menu).pause(500).click().build().perform();
		}
		if (arg1.equalsIgnoreCase("shared")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'button__text_purple') and contains(text(),'email')]", 4).click();
			new Actions(login.driver).moveToElement(open_file_menu).pause(500).click().build().perform();
			if (login.driver.findElements(By.xpath("//*[name()='use' and contains(@*, '#actions__" + arg1 + "')]"))
					.size() == 1) {
				login.Log4j.info(arg1 + " icon is present when an insight has been shared");
			} else {
				fail("Verification Failed");
			}
			new Actions(login.driver).moveToElement(open_file_menu).pause(500).click().build().perform();
		}
	}

	@Then("^The shared mail should display in Share popup$")
	public void the_shared_mail_should_display_in_Share_popup() throws Throwable {
		CommonFunctionality.wait(3000);
		String actual_mail = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='share-specific--users-list']//*[contains(@class,'share-user-email')]", 4)
				.getText();
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertEquals(CDMNextSprintCases.mail, actual_mail);
		login.Log4j.info("The shared email is displaying in the list and has been verified successfully");
		deleting_insights("//*[@data-id='Untitled-insight' and text()='Name your insight'] | //*[text()='"
				+ new_insight_name + "']");
	}

	@Then("^The number of insights selected should match$")
	public void the_number_of_insights_selected_should_match() throws Throwable {
		CommonFunctionality.wait(3000);
		String header = CommonFunctionality.getElementBycssSelector(login.driver, ".sphere-modal__title", 4).getText();
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		String[] part = header.split("(?<=\\D)(?=\\d)");
		String part1[] = part[1].split(" ");
		int actual = Integer.parseInt(part1[0]);
		int expected = number_of_insights - 1;
		assertEquals(actual, expected);
		login.Log4j.info(
				"The number of insights selected is displaying correctly in Share popup and has been verified successfully");
	}

	@Then("^The Insight owner name and Email ID should be displayed$")
	public void the_Insight_owner_name_and_Email_ID_should_be_displayed() throws Throwable {
		String name = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='owner']/preceding::*[contains(@class,'share-user-name')]", 4).getText();
		String email = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='owner']/preceding::*[contains(@class,'share-user-email')]", 4).getText();
		if (name != null && email != null) {
			login.Log4j.info("The Insight owner name and Email ID is displayed and has been verified successfully");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		} else {
			fail("Insight Owner name/email is not displayed");
		}
	}

	@Then("^The newly created Insights should appear in next user login$")
	public void the_newly_created_Insights_should_appear_in_next_user_login() throws Throwable {
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform(); } }
		 */
		WebElement insight1 = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + first_insight + "']",
				4);
		WebElement insight2 = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + second_insight + "']", 4);
		WebElement insight3 = CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + third_insight + "']",
				4);
		if (insight1.isDisplayed() && insight2.isDisplayed() && insight3.isDisplayed()) {
			login.Log4j.info(
					"The newly created Insights are displaying in next login and it has been verified successfully");
		} else {
			fail("The newly created insights are not displayed in next user login");
		}
	}

	@Then("^The newly created Insight should appear in next user login at first place$")
	public void the_newly_created_Insight_should_appear_in_next_user_login_at_first_place() throws Throwable {
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform(); } }
		 */
		WebElement first = CommonFunctionality.getElementByXpath(login.driver,
				"(//div[contains(@class,'insight-grid-item--bottom-panel-title')])[1][@title='" + new_insight_name
						+ "']",
				4);
		List<WebElement> first_insight = login.driver
				.findElements(By.xpath("(//div[contains(@class,'insight-grid-item--bottom-panel-title')])[1][@title='"
						+ new_insight_name + "']"));
		assertEquals(first.isDisplayed(), true);
		assertEquals(first_insight.size(), 1);
		login.Log4j.info("The newly created Insight is appearing at first place and has been verified successfully");
	}

	@Then("^Click on dropdown to view permission list to check for \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" is selected by default$")
	public void click_on_dropdown_to_view_permission_list_to_check_for_and_and_is_selected_by_default(String arg1,
			String arg2, String arg3, String arg4) throws Throwable {
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'share-type-permissions')]//span[@class='insight-share--choose-button-arrow']", 4))
				.click().build().perform();
		List<WebElement> options = login.driver.findElements(
				By.xpath("//ul[contains(@class,'select-permissions')]//li//span[not(contains(@class,'name-li'))]"));
		assertEquals(3, options.size());
		for (WebElement option : options) {
			String text = option.getText();
			if (text.equals(arg1) || text.equals(arg2) || text.equals(arg3)) {
				login.Log4j.info("The dropdown permissions are verified");
			} else {
				fail("Verification Failed");
			}
		}
		String default_permission = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='scrollable']//div[contains(@class,'share-company-permissions')]//span[@class='insight-share--choose-button-text']",
				4).getText();
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertEquals(arg4, default_permission);
	}

	@SuppressWarnings("deprecation")
	@Then("^The newly created insight should appear as \"([^\"]*)\" permission in next user login$")
	public void the_newly_created_insight_should_appear_as_permission_in_next_user_login(String arg1) throws Throwable {
		WebElement grid_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a grid']/parent::div", 4);
		if (grid_mode.getAttribute("class").contains("insights-view-modes__grid-mode-teal")) {
			System.out.println("Already grid mode is clicked");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 4))
					.pause(500).click().build().perform();
		}
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform();
		 * System.out.println("Notification appeared and clicked"); } } else {
		 * System.out.println("No notification pop up displayed"); }
		 */
		WebElement permission = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + new_insight_name + "']", 4);
		new Actions(login.driver).moveToElement(permission).pause(2000).perform();
		if (arg1.equalsIgnoreCase("view")) {
			if (permission.isDisplayed()) {
				CommonFunctionality
						.getElementByXpath(login.driver,
								"//*[text()='" + new_insight_name + "']/following::*[contains(text(),'Open')][1]", 4)
						.click();
			} else {
				fail("Newly created insight is not displayed");
			}
			/*
			 * if(login.driver.findElements(By.xpath(
			 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
			 * open = CommonFunctionality.getElementByXpath(login.driver,
			 * "//*[contains(@class,'user-notifications--body')]", 4);
			 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
			 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
			 * (login.driver, "user-notifications--icon",
			 * 4)).pause(500).click().build().perform(); } }
			 */
			if (!(login.driver.findElements(By.xpath("//*[@title='Click to edit the Insight']")).size() == 0)) {
				fail("Verification Failed");
			}
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4))
					.pause(500).click().build().perform();
			List<WebElement> views = login.driver
					.findElements(By.xpath("//*[@class='items-wrapper']//*[@title='Save']/ancestor::li"));
			for (WebElement view : views) {
				if (!(view.getAttribute("class").equals("hide"))) {
					fail("Save option is present for view permission");
				} else {
					System.out.println("Save option is disabled if an insight is shared with view permission");
				}
			}
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4))
					.pause(500).click().build().perform();
		}
		if (arg1.equalsIgnoreCase("edit")) {
			if (permission.isDisplayed()) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + new_insight_name + "']/following::*[contains(text(),'Customize')][1]", 4)
						.click();
			} else {
				fail("Newly created insight is not displayed");
			}
			/*
			 * if(login.driver.findElements(By.xpath(
			 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
			 * open = CommonFunctionality.getElementByXpath(login.driver,
			 * "//*[contains(@class,'user-notifications--body')]", 4);
			 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
			 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
			 * (login.driver, "user-notifications--icon",
			 * 4)).pause(500).click().build().perform(); } }
			 */
			if (!(login.driver.findElements(By.xpath("//*[@title='Click to edit the Insight']")).size() == 1)) {
				fail("Verification Failed");
			}
		}
		if (arg1.equalsIgnoreCase("manage")) {
			if (permission.isDisplayed()) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + new_insight_name + "']/following::*[contains(text(),'Customize')][1]", 4)
						.click();
			} else {
				fail("Newly created insight is not displayed");
			}
			/*
			 * if(login.driver.findElements(By.xpath(
			 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
			 * open = CommonFunctionality.getElementByXpath(login.driver,
			 * "//*[contains(@class,'user-notifications--body')]", 4);
			 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
			 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
			 * (login.driver, "user-notifications--icon",
			 * 4)).pause(500).click().build().perform(); } }
			 */
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Click to edit the Insight']", 4)
					.click();
			String display = CommonFunctionality
					.getElementByXpath(login.driver, "//input[@class='insight-breadcrumb--title-input']", 4)
					.getAttribute("style");
			if (display.equalsIgnoreCase("display: none;")) {
				fail("Title field not editable");
			}
			CommonFunctionality.getElementByXpath(login.driver, "//input[@class='insight-breadcrumb--title-input']", 4)
					.sendKeys(Keys.ENTER);
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4))
					.click().build().perform();
			WebElement delete = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='items-wrapper']//*[@title='Delete']/parent::*", 4);
			if (delete.getAttribute("class").contains("hide")) {
				fail("Delete option is hidden for managing an insight");
			}
			WebElement share = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='items-wrapper']//*[@title='Share']/parent::*", 4);
			if (share.getAttribute("class").contains("hide")) {
				fail("Share option is hidden for managing an insight");
			}
			// new
			// Actions(login.driver).moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
			// "div[title='Open File menu']", 4)).click().build().perform();
			new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='items-wrapper']//*[@title='Share']", 4)).click().build().perform();
			if (login.driver.findElements(By.xpath(
					"//*[contains(@class,'modal-dialog')]//*[contains(@class,'sphere-modal__title') and contains(text(),'Share')]"))
					.size() > 0) {
				System.out.println("Share popup is opened");
				CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			} else {
				fail("Share popup is not displaying while clicking share option");
			}
			login.Log4j.info("The Delete and Share option is present for manage permission");
		}
		login.Log4j.info("The Insight is shared with " + arg1 + " permission and has been verified successfully");
	}

	@Then("^The list of users name with email ID should be displayed$")
	public void the_list_of_users_name_with_email_ID_should_be_displayed() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//input[@placeholder='Select people you want to invite']", 4).click();
		CommonFunctionality.wait(5000);
		List<WebElement> users = login.driver.findElements(By.xpath(
				"//div[contains(@class,'choosable-search-box')]//*[@class='choosable-item'] | //div[contains(@class,'choosable-search-box')]//*[@class='choosable-item ']"));
		CommonFunctionality.wait(2000);
		int count = users.size();
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertNotEquals(0, count);
		login.Log4j.info("The list of users name with email ID is displayed and has been verified successfully");
	}

	@Then("^The \"([^\"]*)\" popup should appears$")
	public void the_popup_should_appears(String arg1) throws Throwable {
		if (login.driver.findElements(By.cssSelector(".modal-content.sphere-modal__content")).size() > 0) {
			String header = CommonFunctionality
					.getElementBycssSelector(login.driver, ".modal-title.sphere-modal__title", 4).getText();
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
			assertEquals(arg1, header);
			login.Log4j.info("The Register popup appears as expected");
		} else {
			fail("Pop up not appears");
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The searched user \"([^\"]*)\" is fetching proper results and given \"([^\"]*)\" permission$")
	public void the_searched_user_is_fetching_proper_results_and_given_permission(String arg1, String arg2)
			throws Throwable {
		searched_user = arg1;
		WebElement mail = null;
		if (searched_user.equalsIgnoreCase("ceicsuresh10@gmail.com")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite'] | //input[@placeholder='Select people you want to invite']",
					4);
		}
		if (searched_user.equalsIgnoreCase("cvision-suresh")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite']", 4);
		}
		if (searched_user.equalsIgnoreCase("CEIC Development – CDMNext 2")) {
			mail = CommonFunctionality.getElementByXpath(login.driver,
					"//input[@placeholder='Type people/accounts/companies you want to invite']", 4);
		}
		if (login.driver.findElements(By.xpath("//span[contains(text(),'External users/accounts/companies')]"))
				.size() > 0) {
			new Actions(login.driver).moveToElement(mail).click().sendKeys(searched_user).sendKeys(Keys.ENTER)
					.pause(1000).build().perform();
		} else {
			new Actions(login.driver).moveToElement(mail).click().sendKeys(searched_user).pause(2000).build().perform();
			WebElement result = CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='choosable-item ' and contains(text(),'" + searched_user
									+ "')] | //*[@class='choosable-item' and contains(text(),'" + searched_user + "')]",
							4);
			js.executeScript("arguments[0].scrollIntoView(true);", result);
			new Actions(login.driver)
					.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='choosable-item ' and contains(text(),'" + searched_user + "')]", 4))
					.pause(3000).click().build().perform();
		}
		CommonFunctionality.wait(2000);
		/*
		 * String user = null;
		 * if(searched_user.equalsIgnoreCase("ceicsuresh10@gmail.com")) { user
		 * =result.getText(); } CommonFunctionality.wait(2000); List<WebElement> users =
		 * login.driver.findElements(By.
		 * xpath("//div[contains(@class,'choosable-search-box--below-input')]//*[@class='choosable-item ']"
		 * )); CommonFunctionality.wait(1000);
		 * if(searched_user.equalsIgnoreCase("ceicsuresh10@gmail.com")) { String
		 * email_text = CommonFunctionality.getElementBycssSelector(login.driver,
		 * ".share-specific--users-list .share-user-email.share-note-color",
		 * 4).getText(); String share_name =
		 * CommonFunctionality.getElementBycssSelector(login.driver,
		 * ".share-specific--users-list .share-user-name", 4).getText();
		 * if(user.contains(" (")) { String split1[] = user.split(Pattern.quote(" ("));
		 * assertEquals(split1[0], share_name); } else { assertEquals(user, share_name);
		 * } assertEquals(searched_user, email_text); } assertEquals(1, users.size());
		 */
		login.Log4j.info("The searched user is fetching proper results and has been verified successfully");
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='share-type-permissions']//button[@share-permission-choose='']//span[2] | //*[@class='share-specific--users-list']//*[@class=share-permission-choose='']//span[2]",
				4)).click().build().perform();
		List<WebElement> options = login.driver.findElements(
				By.xpath("//ul[contains(@class,'select-permissions')]//li//span[not(contains(@class,'name-li'))]"));
		if (searched_user.equalsIgnoreCase("ceicsuresh10@gmail.com")) {
			assertEquals(3, options.size());
		} else {
			assertEquals(2, options.size());
		}
		for (WebElement option : options) {
			String text = option.getText();
			if (text.equals("can view") || text.equals("can edit")) {
				login.Log4j.info("The dropdown permissions are verified and the permission verified is: " + text);
			} else {
				if (text.equals("can manage")) {
					if (login.CONFIG.getProperty("username").equals("ceicsuresh12@gmail.com")
							/* || login.CONFIG.getProperty("username").contains("@gmail.com") */ || login.CONFIG
									.getProperty("username").equals("ceicsuresh10@gmail.com")) {
						login.Log4j.info("The Manage option is present for only external login");
					} else {
						fail("The Manage option is present for internal login too");
					}
				}
			}
		}
		CommonFunctionality.wait(1000);
		new Actions(login.driver).moveToElement(CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'share-specific--users-list')]//span[@class='insight-share--choose-button-arrow']",
				4)).click().build().perform();
		String default_permission = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='share-type-permissions']//button[@share-permission-choose='']//span[1] |  //*[@class='share-specific--users-list']//*[@class='insight-share--actions']//*[@class='insight-share--choose-button-text']",
				4).getText();
		assertEquals("can view", default_permission);
		clicking_dropdown_to_view_permission_list_to_select_permission(arg2);
		if (login.driver
				.findElements(By.xpath("//*[contains(@class,'button__text_purple') and contains(text(),'email')]"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'button__text_purple') and contains(text(),'email')]", 4).click();
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The Verify the remove icon in shared insight$")
	public void the_Verify_the_remove_icon_in_shared_insight() throws Throwable {
		if (login.driver
				.findElements(By.xpath("//*[contains(@class,'button__text_purple') and contains(text(),'email')]"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'button__text_purple') and contains(text(),'email')]", 4).click();
		}
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4))
				.click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[text()='Shared']", 4)
				.click();
		List<WebElement> before_remove = login.driver.findElements(By.cssSelector(".share-specific--users-list"));
		assertEquals(1, before_remove.size());
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
						".share-specific--users-list .share-user-delete-box.icon--red-cross", 4))
				.pause(500).click().build().perform();
		List<WebElement> after_remove = login.driver
				.findElements(By.cssSelector(".share-specific--users-list .share-user-email"));
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertEquals(0, after_remove.size());
		login.Log4j.info("The remove icon functionality has been verified successfully");
	}

	@Then("^The same permission can prepopulate in insight share field$")
	public void the_same_permission_can_prepopulate_in_insight_share_field() throws Throwable {
		if (login.driver
				.findElements(By.xpath("//*[contains(@class,'button__text_purple') and contains(text(),'email')]"))
				.size() > 0) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'button__text_purple') and contains(text(),'email')]", 4).click();
		}
		new Actions(login.driver)
				.moveToElement(
						CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4))
				.click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[text()='Shared']", 4)
				.click();
		String permission_text = CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='share-specific--users-list']//span[@class='insight-share--choose-button-text']", 4)
				.getText();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementBycssSelector(login.driver,
						".share-specific--users-list .share-user-delete-box.icon--red-cross", 4))
				.click().build().perform();
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		assertEquals(permission_type, permission_text);
	}

	@Then("^The newly created Insight should appear in second login before stopping of sharing with shared user name$")
	public void the_newly_created_Insight_should_appear_in_second_login_before_stopping_of_sharing_with_shared_user_name()
			throws Throwable {
		cv.click_on_my_insights();
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform(); } }
		 */
		click_tab("Shared");
		CommonFunctionality.wait(2000);
		WebElement before_stop_sharing = CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'insight-grid-item--bottom-panel-title') and @title='" + new_insight_name + "']",
				4);
		assertEquals(before_stop_sharing.isDisplayed(), true);
		CommonFunctionality.wait(2000);
		String creator = CommonFunctionality.getElementByXpath(login.driver, "//div[@title='" + new_insight_name
				+ "']/ancestor::div[2]//div[contains(@class,'common-information--item-content--creator')]//span", 4)
				.getText();
		assertEquals(creator_name, creator);
	}

	@Then("^The newly created insight should vanish in second login when insight is stopped sharing$")
	public void the_newly_created_insight_should_vanish_in_second_login_when_insight_is_stopped_sharing()
			throws Throwable {
		login_as_next_user();
		cv.click_on_my_insights();
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform(); } }
		 */
		click_tab("Shared");
		CommonFunctionality.wait(2000);
		List<WebElement> after_stop = login.driver
				.findElements(By.xpath("//div[contains(@class,'insight-grid-item--bottom-panel-title') and @title='"
						+ new_insight_name + "']"));
		assertEquals(after_stop.size(), 0);
		login.Log4j.info(
				"The newly created insight is vanished in second login when insight has been stopped sharing and has been verified successfully");
		login_back_to_current_user();
		cv.click_on_my_insights();
		click_tab("Created");
		delete_Insight();
	}

	@Then("^The expected permission \"([^\"]*)\" should display$")
	public void the_expected_permission_should_display(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//div[@data-tab-id='permissions']", 4).click();
		WebElement option = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'sphere-modal__content')]//*[text()='" + arg1 + "']", 4);
		assertEquals(option.isDisplayed(), true);
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		login.Log4j.info("The " + arg1 + " permission has been verified successfully");
		delete_Insight();
	}

	@Then("^The Cancel icon in share popup should verify$")
	public void the_Cancel_icon_in_share_popup_should_verify() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "input-share", 4).click();
		CommonFunctionality.getElementByClassName(login.driver, "input-share", 4).sendKeys(Keys.BACK_SPACE);
		CommonFunctionality.wait(3000);
		boolean save = login.driver
				.findElement(By.xpath("//*[contains(@class,'button button__primary') and text()='Save']")).isEnabled();
		if (save == true) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[contains(@class,'button button__primary') and text()='Save']", 4).click();
		} else {
			fail("Not enabled");
		}
		login.Log4j.info("The Sharing insight window is opened");
		CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
		List<WebElement> share = login.driver.findElements(By.xpath(
				"//*[contains(@class,'sphere-modal-dialog')]//*[contains(@class,'sphere-modal__title') and contains(text(),'Share')]"));
		assertEquals(share.size(), 0);
		login.Log4j.info("The Cancel button in the popup has been verified successfully");
		deleting_insights("//*[text()='Name your insigh']");
	}

	@Then("^Perform some actions in Manage insight of next login$")
	public void perform_some_actions_in_Manage_insight_of_next_login() throws Throwable {
		the_newly_created_insight_should_appear_as_permission_in_next_user_login("manage");
		for (int i = 1; i <= 2; i++) {
			CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Create new View tab']", 4).click();
		}
		List<WebElement> before = login.driver.findElements(By.className("insight-page-view-tab--title"));
		int before_refresh = before.size();
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform(); } }
		 */
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='Open File menu']", 4).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[text()='Refresh']", 4)
				.click();
		CommonFunctionality.wait(2000);
		List<WebElement> after = login.driver.findElements(By.className("insight-page-view-tab--title"));
		int after_refresh = after.size();
		assertEquals(before_refresh, after_refresh);
		login.Log4j.info(
				"The Insight can be shared with Manage permission and also the refresh option has been verified successfully");
	}

	@SuppressWarnings("deprecation")
	@Then("^Perform \"([^\"]*)\" action by using \"([^\"]*)\" option in the context menu$")
	public void perform_action_by_using_option_in_the_context_menu(String arg1, String arg2) throws Throwable {
		perform_first_login_actions();
		WebElement grid_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a grid']/parent::div", 4);
		if (grid_mode.getAttribute("class").contains("insights-view-modes__grid-mode-teal")) {
			System.out.println("Already grid mode is clicked");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 4))
					.pause(500).click().build().perform();
		}
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + new_insight_name + "']", 4))
				.pause(1000).perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + new_insight_name + "']/following::*[contains(text(),'Open')]", 4))
				.pause(500).click().build().perform();
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform(); } }
		 */
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 4))
				.pause(200).click().build().perform();
		List<WebElement> save_all = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']//*[text()='" + arg2 + "']/ancestor::li"));
		for (WebElement save : save_all) {
			if (save.getAttribute("class").equals("hide")) {
				fail("Save as option is in hidden state");
			} else {
				CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[text()='" + arg2 + "']", 4)
						.click();
				if (login.driver
						.findElements(
								By.xpath("//*[contains(@class,'sphere-modal__title') and text()='Copy the Insight']"))
						.size() == 1) {
					System.out.println("The insight can possible to copy");
					CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 4).click();
				} else {
					fail("Copy model box is not displaying");
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Then("^The \"([^\"]*)\" option should be hidden in explorer and \"([^\"]*)\" option is hidden in file menu$")
	public void the_option_should_be_hidden_in_explorer_and_option_is_hidden_in_file_menu(String arg1, String arg2)
			throws Throwable {
		perform_first_login_actions();
		WebElement grid_mode = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@title='View as a grid']/parent::div", 4);
		if (grid_mode.getAttribute("class").contains("insights-view-modes__grid-mode-teal")) {
			System.out.println("Already grid mode is clicked");
		} else {
			new Actions(login.driver)
					.moveToElement(
							CommonFunctionality.getElementByXpath(login.driver, "//div[@title='View as a grid']", 4))
					.pause(500).click().build().perform();
		}
		new Actions(login.driver).moveToElement(
				CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + new_insight_name + "']", 4))
				.pause(1000).perform();
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver,
						"//*[text()='" + new_insight_name + "']/following::*[contains(text(),'Open')]", 4))
				.pause(500).click().build().perform();
		/*
		 * if(login.driver.findElements(By.xpath(
		 * "//*[contains(@class,'user-notifications--body')]")).size()>0) { WebElement
		 * open = CommonFunctionality.getElementByXpath(login.driver,
		 * "//*[contains(@class,'user-notifications--body')]", 4);
		 * if(open.getAttribute("class").contains("dropdown--body__open")) { new
		 * Actions(login.driver).moveToElement(CommonFunctionality.getElementByClassName
		 * (login.driver, "user-notifications--icon",
		 * 4)).pause(500).click().build().perform(); } }
		 */
		new Actions(login.driver)
				.moveToElement(CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 4))
				.pause(200).click().build().perform();
		List<WebElement> saving = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']//*[@title='" + arg2 + "']/parent::*"));
		for (WebElement save : saving) {
			if (save.getAttribute("class").equals("hide")) {
				login.Log4j.info("Save as option is in hidden state");
			} else {
				fail("Save as option is not hidden");
			}
		}
		cv.click_on_my_insights();
		click_tab("Shared");
		CommonFunctionality.getElementBycssSelector(login.driver, "div[title='View as a table']", 4).click();
		WebElement right_click = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + new_insight_name + "']", 4);
		CommonFunctionality.wait(2000);
		new Actions(login.driver).moveToElement(right_click).pause(500).contextClick().build().perform();
		if (login.driver.findElements(By.xpath("//*[@class='items-wrapper']//*[@title='" + arg1 + "']")).size() == 0) {
			login.Log4j.info("Copy option is not present");
		} else {
			fail("Copy option is still available when copy is off in permission");
		}
	}
}