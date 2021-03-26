package CDMNext.StepDefinations;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Attachments {
	String ExpectedLink;
	String parent_window;
	Commentary commentary = new Commentary();

	@And("^Click on Insert Attachments$")
	public void click_on_Insert_Attachments() throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Insert Attachments']", 20).click();
		try {
			Boolean AttachmentTitle = login.driver.findElement(By.xpath("//*[@data-name='title']")).isDisplayed();
			if (AttachmentTitle == true) {
				login.Log4j.info("Attachments visual is created");
			}
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Insert Attachments']", 20).click();
		}
	}

	@Then("^Attachments should be inserted$")
	public void attachments_should_be_inserted() throws Throwable {
		CommonFunctionality.wait(3000);
		String AttachmentTitle = login.driver.findElement(By.xpath("//*[@data-name='title']")).getText();
		if (AttachmentTitle.contains("Attachments")) {
			login.Log4j.info("Attachments visual is created");
		} else {
			Assert.fail("Attachments visual is not created");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Drag and drop Attachments visual to the page$")
	public void drag_and_drop_Attachments_visual_to_the_page() throws Throwable {
		String Attachment = null;
		String ViewContainer = null;
		CommonFunctionality.wait(1500);
		Attachment = "//*[@title='Insert Attachments']//*[@class='insight-action-panel--btn-icon']//div";
		ViewContainer = "//*[@class='view-components-over--visuals']//*[@class='view-components-over--visual'][1]";
		commentary.DragAndDrop(Attachment, ViewContainer);
	}

	@And("^Create a Attachments visual$")
	public void create_a_Attachments_visual() throws Throwable {
		commentary.CreateViewTab();
		click_on_Insert_Attachments();
	}

	@Then("^The title name should reflect on the Attachments$")
	public void the_title_name_should_reflect_on_the_Attachments() throws Throwable {
		commentary.TitleON();
	}

	@Then("^No title name should display for the Attachments$")
	public void no_title_name_should_display_for_the_Attachments() throws Throwable {
		// commentary.no_title_name_should_display_for_the_Commentary();
		commentary.TitleOFF();
	}

	@Then("^The Attachments should update the \"([^\"]*)\" name to \"([^\"]*)\"$")
	public void the_Attachments_should_update_the_name_to(String arg1, String arg2) throws Throwable {
		commentary.TitleAndSubTitleValidation(arg1, arg2);
	}

	@Then("^The Attachments should update the \"([^\"]*)\" text color as blue$")
	public void the_Attachments_should_update_the_text_color_as_blue(String arg1) throws Throwable {
		String color = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 30)
				.getCssValue("color");
		commentary.ColorValidation(color);
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The Attachments should update the \"([^\"]*)\" highlight color as Orange$")
	public void the_Attachments_should_update_the_highlight_color_as_Orange(String arg1) throws Throwable {
		String backgroundColor = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 15).getCssValue("background-color");
		commentary.ColorValidation(backgroundColor);
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The Attachments should update the \"([^\"]*)\" font as \"([^\"]*)\"$")
	public void the_Attachments_should_update_the_font_as(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		String Txtfont = login.driver.findElement(By.xpath("//*[@data-name='" + arg1 + "']")).getCssValue("font-size");
		login.Log4j.info(Txtfont);
		commentary.FontSizeValidation(Txtfont, arg2);
		//CommonFunctionality.DeleteVisual();
	}

	@SuppressWarnings("deprecation")
	@And("^Expand subtitle$")
	public void expand_subtitle() throws Throwable {
		CommonFunctionality.wait(1500);
		WebElement expand = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand")));
		new Actions(login.driver).pause(300).moveToElement(expand).click().build().perform();
	}

	@Then("^The Subtitle should be disabled by default$")
	public void the_Subtitle_should_be_disabled_by_default() throws Throwable {
		CommonFunctionality.wait(700);
		Boolean subtitle_disabled = login.driver.findElement(By.xpath("//*[@class='col disabled']")).isDisplayed();
		if (subtitle_disabled == true) {
			login.Log4j.info("The subtitle is disabled by default");
		} else {
			Assert.fail("The subtitle is not disabled by default");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The \"([^\"]*)\" should reflect on the Attachments$")
	public void the_should_reflect_on_the_Attachments(String arg1) throws Throwable {
		commentary.SubtitleCheck(arg1);
	}

	@And("^Choose Horizontal align of visual to \"([^\"]*)\"$")
	public void choose_Horizontal_align_of_visual_to(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 10).click();
		commentary.click_on_X_icon_to_close_the_popup();
	}

	@Then("^Set \"([^\"]*)\" to (\\d+) in visual header$")
	public void set_to_in_visual_header(String arg1, int arg2) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Visual')]", 10).click();
		String Proportiovalue = Integer.toString(arg2);
		WebElement proportion = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + arg1 + "']//following::input[1]", 10);
		proportion.sendKeys(Keys.chord(Keys.CONTROL, "a"), Proportiovalue);
		proportion.sendKeys(Keys.TAB);
		//// CommonFunctionality.DeleteVisual();
	}

	@Then("^Enter \"([^\"]*)\" in the link field$")
	public void enter_in_the_link_field(String arg1) throws Throwable {
		ExpectedLink = arg1;
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='links-tab--editor']/*[1]//input[@type='text']", 5)
				.sendKeys(arg1);
		// CommonFunctionality.getElementByXpath(driver, "//*[contains(text(),'Ok')]",
		// 4).click();
	}

	@Then("^Selected color should be applied to the attachment visual background$")
	public void selected_color_should_be_applied_to_the_attachment_visual_background() throws Throwable {
		commentary.UnselectVisual();
		String Background_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='attachments-visual--container']", 15)
				.getCssValue("background-color");
		commentary.ColorValidation(Background_color);
		//CommonFunctionality.DeleteVisual();

	}

	@Then("^Selected image should be uploaded and applied to the attachment visual background$")
	public void selected_image_should_be_uploaded_and_applied_to_the_attachment_visual_background() throws Throwable {
		commentary.click_on_X_icon_to_close_the_popup();
		commentary.UnselectVisual();
		CommonFunctionality.wait(2000);
		WebElement backGroundImage = login.driver.findElement(By.xpath("//*[@class='attachments-visual--container']"));
		commentary.backgroundImage(backGroundImage);

	}

	@Then("^The attachment visual border should be changed as per the selection$")
	public void the_attachment_visual_border_should_be_changed_as_per_the_selection() throws Throwable {
		commentary.UnselectVisual();
		String border_color = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='attachments-visual--container']", 8)
				.getCssValue("border-color");
		commentary.ColorValidation(border_color);
		//CommonFunctionality.DeleteVisual();

	}

	@Then("^The attachment visual should be created in new tab on current insight$")
	public void the_attachment_visual_should_be_created_in_new_tab_on_current_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		String ActualLink = login.driver.findElement(By.xpath("(//*[@class='attachments-item-link--row']//a)[2]"))
				.getText();
		login.Log4j.info(ActualLink);
		if (ActualLink.contains(ExpectedLink)) {
			login.Log4j.info("Attachment Visual is created in new tab");
		} else {
			Assert.fail("Attachment Visual is not created for Add option");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The insight should be opened and added attachment visual should be available in My visual$")
	public void the_insight_should_be_opened_and_added_attachment_visual_should_be_available_in_My_visual()
			throws Throwable {
		CommonFunctionality.wait(2000);
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		CommonFunctionality.getElementByXpath(login.driver, "//a[@title='View 1']", 8).click();
		CommonFunctionality.wait(2000);
		String ActualLink = login.driver.findElement(By.xpath("//*[@class='attachments-item-link--row']//a")).getText();
		if (ActualLink.contains(ExpectedLink)) {
			login.Log4j.info("Attachments visual is created in new insiaght");
		} else {
			Assert.fail("Attachments visual is not created ");
		}
		CommonFunctionality.DeleteVisual();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The attachments visual should be pasted in the insight$")
	public void the_attachments_visual_should_be_pasted_in_the_insight() throws Throwable {
		String ActualLink = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='attachments-item-link--row']//a", 8).getText();
		if (ActualLink.contains(ExpectedLink)) {
			login.Log4j.info("Attachments visual is pasted ");
		} else {
			Assert.fail("Attachments visual is not pasted ");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The attachments visual should be pasted to new insight$")
	public void the_attachments_visual_should_be_pasted_to_new_insight() throws Throwable {
		the_attachments_visual_should_be_pasted_in_the_insight();
	}

	@Then("^The Attachments visual should be deleted$")
	public void the_Attachments_visual_should_be_deleted() throws Throwable {
		CommonFunctionality.wait(1500);
		if (login.driver.findElements(By.xpath("//*[contains(@class,'visual-item-template attachments-visual')]"))
				.size() == 0) {
			login.Log4j.info("The attachments visual is deleted");
		} else {
			Assert.fail("The attachments visual is not deleted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The popup should be closed and delete attachments visual process should be declined$")
	public void the_popup_should_be_closed_and_delete_attachments_visual_process_should_be_declined() throws Throwable {
		CommonFunctionality.wait(1500);
		if (login.driver.findElement(By.xpath("//*[contains(@class,'visual-item-template attachments-visual')]"))
				.isDisplayed()) {
			login.Log4j.info("The attachments visual is not deleted");
		} else {
			Assert.fail("The attachments visual is deleted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The tab should contain \"([^\"]*)\" and \"([^\"]*)\" fields$")
	public void the_tab_should_contain_and_fields(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(2000);
		Boolean link = login.driver
				.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1 + "')]"))
				.isDisplayed();
		Boolean title = login.driver
				.findElement(By.xpath("//*[@class='links-tab--editor']//*[contains(text(),'" + arg2 + "')]"))
				.isDisplayed();
		if (link == true && title == true) {
			login.Log4j.info(arg1 + " AND " + arg2 + " is displayed");
		} else {
			Assert.fail(arg1 + " AND " + arg2 + " is not displayed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The link should be created above$")
	public void the_link_should_be_created_above() throws Throwable {
		CommonFunctionality.wait(1000);
		String ActualLink = login.driver
				.findElement(By.xpath("//*[@class='links-tab']//*[@class='attachments-item-link--row']//a")).getText();
		if (ActualLink.contains(ExpectedLink)) {
			login.Log4j.info("The link is created");
		} else {
			Assert.fail("The link is not created");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Type any name in the title field$")
	public void type_any_name_in_the_title_field() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='links-tab--editor']/*[2]//input[@type='text']", 5)
				.sendKeys("Title");
	}

	@Then("^The OK button should be disabled until enter links for the tilte$")
	public void the_OK_button_should_be_disabled_until_enter_links_for_the_tilte() throws Throwable {
		Boolean button_ok = login.driver
				.findElement(By.xpath("//*[@class='links-tab--buttons']//*[contains(text(),'Ok')]")).isEnabled();
		if (!button_ok == true) {
			login.Log4j.info("The OK button is disabled by default");
		} else {
			Assert.fail("The OK button is enabled");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The OK and cancel buttons should be disabled$")
	public void the_OK_and_cancel_buttons_should_be_disabled() throws Throwable {
		Boolean button_ok = login.driver
				.findElement(By.xpath("//*[@class='links-tab--buttons']//*[contains(text(),'Ok')]")).isEnabled();
		Boolean button_cancel = login.driver
				.findElement(By.xpath("//*[@class='links-tab--buttons']//*[contains(text(),'Cancel')]")).isEnabled();
		if (!button_ok == true && !button_cancel == true) {
			login.Log4j.info("The OK and Cancel buttons disabled by default");
		} else {
			Assert.fail("The OK and Cancel buttons enabled");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on edit icon for the link$")
	public void click_on_edit_icon_for_the_link() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'attachments-item-link--icon__edit')])[2]", 5)
				.click();

	}

	@Then("^The link and title should be restored to respective fields to edit$")
	public void the_link_and_title_should_be_restored_to_respective_fields_to_edit() throws Throwable {
		CommonFunctionality.wait(1500);
		Boolean Link = login.driver.findElement(By.xpath("//*[@class='links-tab--editor']/*[1]//input[@type='text']"))
				.getText().isEmpty();
		Boolean Title = login.driver.findElement(By.xpath("//*[@class='links-tab--editor']/*[2]//input[@type='text']"))
				.getText().isEmpty();
		if (!Link == false && !Title == false) {
			login.Log4j.info("Verification is pass");
		} else {
			Assert.fail("Verification is failed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Click on Ok$")
	public void click_on_Ok() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Ok')]", 8).click();
	}

	@And("^Click on delete icon for the link$")
	public void click_on_delete_icon_for_the_link() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "(//*[contains(@class,'attachments-item-link--icon__delete')])[2]", 5)
				.click();
	}

	@Then("^The link should be deleted$")
	public void the_link_should_be_deleted() throws Throwable {
		CommonFunctionality.wait(1200);
		Boolean empty_visual = login.driver.findElement(By.xpath("//*[@class='empty-visual-overlay--content']"))
				.isDisplayed();
		if (empty_visual == true) {
			login.Log4j.info("The link is deleted");
		} else {
			Assert.fail("The link is not deleted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on the link$")
	public void click_on_the_link() throws Throwable {
		parent_window = login.driver.getWindowHandle();
		// System.out.println("Parent Window Handle is: " + driver.getWindowHandle());
		CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='attachments-item-link--row']//a)[2]", 5)
				.click();
	}

	@Then("^User should be redirected to the link in new browser tab$")
	public void user_should_be_redirected_to_the_link_in_new_browser_tab() throws Throwable {
		CommonFunctionality.wait(5000);
		Set<String> allWindows_1 = login.driver.getWindowHandles();
		System.out.println("Total Windows: " + allWindows_1.size());
		for (String hand1 : allWindows_1) {
			if (!parent_window.equals(hand1)) {
				login.driver.switchTo().window(hand1);
				String newTab = login.driver.getCurrentUrl();
				login.Log4j.info(newTab);
				if (newTab.contains(ExpectedLink)) {
					login.Log4j.info("User is redirected to the link in new browser tab");
				} else {
					Assert.fail("Verification is failed");
				}
				login.driver.close();
			}
			login.driver.switchTo().window(parent_window);
			//CommonFunctionality.DeleteVisual();
		}
	}

	@Then("^The Link should be saved$")
	public void the_Link_should_be_saved() throws Throwable {
		CommonFunctionality.wait(1000);
		boolean link = login.driver.findElement(By.xpath("(//*[@class='attachments-item-link--row']//a)[2]"))
				.isEnabled();
		if (link == true) {
			login.Log4j.info("The link is saved");
		} else {
			Assert.fail("The link is not saved");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on Cancel$")
	public void click_on_Cancel() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Cancel')]", 8).click();
	}

	@Then("^Entered link and title should be removed from the respective fields$")
	public void entered_link_and_title_should_be_removed_from_the_respective_fields() throws Throwable {
		CommonFunctionality.wait(1500);
		Boolean Link = login.driver.findElement(By.xpath("//*[@class='links-tab--editor']/*[1]//input[@type='text']"))
				.getText().isEmpty();
		Boolean Title = login.driver.findElement(By.xpath("//*[@class='links-tab--editor']/*[2]//input[@type='text']"))
				.getText().isEmpty();
		if (Link == true && Title == true) {
			login.Log4j.info("Verification is pass");
		} else {
			Assert.fail("Verification is failed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on Uploads tab$")
	public void click_on_Uploads_tab() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-tab='uploads']", 10).click();
	}

	@And("^Choose file from system and upload$")
	public void choose_file_from_system_and_upload() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='dropzone-default--icon']", 10).click();
		commentary.select_image();
	}

	@Then("^The file should be uploaded$")
	public void the_file_should_be_uploaded() throws Throwable {
		CommonFunctionality.wait(1200);
		Boolean image = login.driver.findElement(By.xpath("//*[@class='dz-image']")).isDisplayed();
		if (image == true) {
			login.Log4j.info("file is uploaded");
		} else {
			Assert.fail("File is not uploaded");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on Remove file$")
	public void click_on_Remove_file() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.linkText("Remove file")).click();
	}

	@Then("^The file should be removed$")
	public void the_file_should_be_removed() throws Throwable {
		CommonFunctionality.wait(1000);
		if (login.driver.findElements(By.xpath("//*[@class='dz-image']")).size() == 0) {
			login.Log4j.info("The file is removed");
		} else {
			Assert.fail("The file is not removed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on the file$")
	public void click_on_the_file() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement ele = login.driver.findElement(By.xpath("//*[@class='uploader-tab--files-list']//a"));
		// String fileName = ele.getText();
		ele.click();
	}

	@Then("^The file should be downloaded$")
	public void the_file_should_be_downloaded() throws Throwable {
		String format = "png";
		CommonFunctionality.getTheNewestFile(format);
		File file = CommonFunctionality.theNewestFile;
		/*
		 * if (file.delete()) { System.out.println(file.getName() + " is deleted!"); }
		 * else { System.out.println("Delete operation is failed."); }
		 */
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Try to upload multiple files in the same visual$")
	public void try_to_upload_multiple_files_in_the_same_visual() throws Throwable {
		click_on_Uploads_tab();
		choose_file_from_system_and_upload();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'attachments-uploader dropzone dz-clickable ')]", 8).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Screenshot.png");
		CommonFunctionality.wait(8000);
	}

	@Then("^Should allow to upload multiple files to the visual$")
	public void should_allow_to_upload_multiple_files_to_the_visual() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> list_files = login.driver
				.findElements(By.xpath("//*[@class='uploader-tab--files-list']//div[@js-type='file']"));
		if (list_files.size() > 1) {
			login.Log4j.info("Multiple files uploaded");
		} else {
			Assert.fail("Multiple files not uploaded");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Unselect the visual$")
	public void unselect_the_visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--content']", 5).click();
	}

	@And("^Now select the visual$")
	public void now_select_the_visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='empty-visual-overlay--content']", 5).click();
	}

	@Then("^The default tab for attachement is \"([^\"]*)\"$")
	public void the_default_tab_for_attachement_is(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		Boolean links = login.driver.findElement(By.xpath("//*[@class='tabs__tab-item active']")).isEnabled();
		if (links == true) {
			CommonFunctionality.wait(1000);
			String Links = login.driver.findElement(By.xpath("//*[@class='tabs__tab-item active']")).getText();
			if (Links.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The default tab is " + arg1);
			} else {
				Assert.fail("The default tab is not " + arg1);
			}
		} else {
			Assert.fail("The link tab is not active");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Attachments should be copied to clipboard$")
	public void attachments_should_be_copied_to_clipboard() throws Throwable {
		WebElement GrowlPopUp = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='growl-message-text']", 8);
		if (GrowlPopUp.isDisplayed()) {
			CommonFunctionality.wait(2000);
			String Clipboard_data = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
					.getData(DataFlavor.stringFlavor);
			login.Log4j.info(Clipboard_data);
			if (Clipboard_data.contains(ExpectedLink)) {
				login.Log4j.info("Attachments is copied to clipboard");
			} else {
				Assert.fail("Verification failed");
			}
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Attachments visual should be pasted$")
	public void attachments_visual_should_be_pasted() throws Throwable {
		String ActulLink = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='attachments-item-link']//div//a", 10).getText();
		if (ActulLink.contains(ExpectedLink)) {
			login.Log4j.info("Attachments visual is pasted");
		} else {
			Assert.fail("Attachments visual is not pasted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Attachments should be cut$")
	public void attachments_should_be_cut() throws Throwable {
		commentary.commentary_should_be_cut();
	}

	@Then("^Attachments should be deleted$")
	public void attachments_should_be_deleted() throws Throwable {

		if (login.driver.findElements(By.xpath("//*[@data-name='title']")).size() == 0) {
			login.Log4j.info("Attachments visual is deleted");
		} else {
			Assert.fail("Attachments visual is not deleted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Attachments visual should be created in the same view tab$")
	public void attachments_visual_should_be_created_in_the_same_view_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		List<WebElement> AttachmentsTitle = login.driver.findElements(By.xpath("//*[@data-name='title']"));
		for (int i = 0; i < AttachmentsTitle.size(); i++) {
			if (AttachmentsTitle.get(i).getText().contains("Attachments")) {
				login.Log4j.info("Attachments visual is created");
			} else {
				Assert.fail("Attachments visual is not created");
			}
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Copied attachments visual should be pasted$")
	public void copied_attachments_visual_should_be_pasted() throws Throwable {
		attachments_visual_should_be_created_in_the_same_view_tab();
	}

	@And("^Create attachments visual$")
	public void create_attachments_visual() throws Throwable {
		click_on_Insert_Attachments();
	}

	@Then("^All the contents should be removed from the attachments visual$")
	public void all_the_contents_should_be_removed_from_the_attachments_visual() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver
				.findElements(By.xpath("//*[@class='links-tab--list']//*[@class='attachments-item-link--row']//a"))
				.size() == 0) {
			login.Log4j.info("All the contents has been removed");
		} else {
			Assert.fail("All the contents has not been removed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Uploaded image should be removed$")
	public void uploaded_image_should_be_removed() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement backGroundImage = login.driver.findElement(By.xpath("//*[@class='attachments-visual--container']"));
		String insight_url = backGroundImage.getCssValue("background-image");
		login.Log4j.info(insight_url);
		if (insight_url.contains("https://stage.ceicdata.com") && insight_url.contains("null")
				|| insight_url.contains("https://insights.ceicdata.com") && insight_url.contains("null")) {
			login.Log4j.info("Uploaded image is removed");
		} else {
			Assert.fail("Uploaded image is NOT removed");
		}
		//CommonFunctionality.DeleteVisual();
	}

}
