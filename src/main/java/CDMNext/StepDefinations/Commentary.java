
package CDMNext.StepDefinations;

//import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
//import java.awt.event.KeyEvent;
//import java.awt.image.BufferedImage;
//import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import CDMNext.util.CommonFunctionality;
import Javaxlxs.File_delete;
//import Javaxlxs.Last_file_download;
import Javaxlxs.ReadExcel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Commentary {
	SeriesTab st = new SeriesTab();
	static Actions action = new Actions(login.driver);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	String Description;
	static Boolean UnCheck = false;
	String ActualColor;
	List<String> ListOfalignmentValue = new ArrayList<>();
	public static String format;
	int SelectedRows;
	List<WebElement> ListOfCells;
	List<WebElement> BeforeInsert_ListOfRows;
	String var1, var2, var3, Actualcolor, DiscriptionTxt;
	List<WebElement> BeforeInsert_ListOfColumns;
	String ActualInsight_Name;
	List<String> Visuals_list = new ArrayList<>();

	@And("^Go to View tab$")
	public void go_to_View_tab() throws Throwable {
		CommonFunctionality.CreateNewInsight();
		CreateViewTab();
	}

	@And("^Drag and drop commentary visual to the page$")
	public void drag_and_drop_commentary_visual_to_the_page() throws Throwable {
		String commentary = null;
		String ViewContainer = null;
		CommonFunctionality.wait(1500);
		commentary = "//*[contains(@title,'insert Commentary')]//*[@class='insight-action-panel--btn-icon']//div";
		ViewContainer = "//*[@class='view-components-over--visuals']//*[@class='view-components-over--visual'][1]";
		DragAndDrop(commentary, ViewContainer);
	}

	@Then("^Commentary should be inserted$")
	public void commentary_should_be_inserted() throws Throwable {
		WebElement commentaryTitle = CommonFunctionality.getElementByProperty(login.driver, "TitleName", 4);
		if (commentaryTitle.isDisplayed()) {
			login.Log4j.info("Commentary visual is created");
		} else {
			Assert.fail("Commentary visual is not created");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on \"([^\"]*)\" option on visual header$")
	public void click_on_option_on_visual_header(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Title")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-popup='title']", 5).click();
		} else if (arg1.equalsIgnoreCase("Visual")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Visual')]", 5).click();
		}
	}

	@Then("^The \"([^\"]*)\" popup should be displayed$")
	public void the_popup_should_be_displayed(String arg1) throws Throwable {
		String Title_txt = null;
		CommonFunctionality.wait(300);
		if (arg1.equals("Visual")) {
			Title_txt = CommonFunctionality.getElementByClassName(login.driver, "popover--title", 4).getText();
			if (Title_txt.equals(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
			click_on_X_icon_to_close_the_popup();
		} else if (arg1.equals("Title")) {
			Title_txt = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@data-id='title']//*[@class='title']", 4).getText();
			if (Title_txt.equals(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
			click_on_X_icon_to_close_the_popup();
		} else if (arg1.equalsIgnoreCase("Table Properties")) {
			Title_txt = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='tox-dialog__title']", 4).getText();
			if (Title_txt.equalsIgnoreCase(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='tox-icon']", 4).click();
		} else if (arg1.equals("Rename")) {
			String Rename_PopUp_txt = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--title-message']", 4).getText();
			if (Rename_PopUp_txt.contains(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();

			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
		} else if (arg1.equals("Edit visual")) {
			String EditVisual_PopUp_txt = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='movable-modal--title-message']", 6).getText();
			if (EditVisual_PopUp_txt.equals(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
				CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();

			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
		}
		//CommonFunctionality.Views_list();
	}

	@And("^Add some text in the description field$")
	public void add_some_text_in_the_description_field() throws Throwable {
		create_Commentary_visual();
		Description = "SampleText";
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		WebElement DescriptionTxt = CommonFunctionality.getElementByProperty(login.driver, "description", 10);
		CommonFunctionality.wait(500);
		DescriptionTxt.sendKeys(Keys.chord(Keys.CONTROL, "a"), Description);
		// login.driver.switchTo().defaultContent();
		CommonFunctionality.elementHighlight(login.driver, DescriptionTxt);
		CommonFunctionality.wait(2000);

	}

	@Then("^Should able to add text in the description field$")
	public void should_able_to_add_text_in_the_description_field() throws Throwable {
		String ExpectedDiscription = CommonFunctionality.getElementByProperty(login.driver, "description", 4).getText();
		DiscriptionValidation(ExpectedDiscription);
	}

	@And("^Click on visual title$")
	public void click_on_visual_title() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-popup='title']", 20).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the box for the title name$")
	public void check_the_box_for_the_title_name() throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TitleCheckbox"))).isSelected();
		if (checkbox == false) {
			WebElement checkbox1 = CommonFunctionality.getElementByProperty(login.driver, "unchecked", 4);
			new Actions(login.driver).pause(300).moveToElement(checkbox1).click().build().perform();
		}
	}

	@Then("^The title name should reflect on the Commentary$")
	public void the_title_name_should_reflect_on_the_Commentary() throws Throwable {
		TitleON();
	}

	@SuppressWarnings("deprecation")
	@And("^Uncheck the box for the title name$")
	public void uncheck_the_box_for_the_title_name() throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TitleCheckbox"))).isSelected();
		if (checkbox == true) {
			WebElement checkbox1 = CommonFunctionality.getElementByProperty(login.driver, "unchecked", 4);
			new Actions(login.driver).pause(500).moveToElement(checkbox1).click().build().perform();
			UnCheck = true;
		
		}
	}

	@Then("^No title name should display for the Commentary$")
	public void no_title_name_should_display_for_the_Commentary() throws Throwable {
		TitleOFF();
	}

	@And("^Check the box and enter the title name as \"([^\"]*)\"$")
	public void check_the_box_and_enter_the_title_name_as(String arg1) throws Throwable {
		check_the_box_for_the_title_name();
		login.driver.findElement(By.xpath("//*[@class='accordion-config ']//*[@name='title']")).sendKeys(arg1);
	}

	@Then("^The commentary should update the \"([^\"]*)\" name to \"([^\"]*)\"$")
	public void the_commentary_should_update_the_name_to(String arg1, String arg2) throws Throwable {
		TitleAndSubTitleValidation(arg1, arg2);
	}

	@And("^Choose text color is blue$")
	public void choose_text_color_is_blue() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='title_color']//following::div[1]", 20).click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"//*[contains(@class,'color-picker-selection')]//*[contains(@class,'sp-palette-row-0')]//*[@title='#2b60d0']");
		CommonFunctionality.wait(200);
		click_on_X_icon_to_close_the_popup();

	}

	@Then("^The commentary should update the \"([^\"]*)\" text color as blue$")
	public void the_commentary_should_update_the_text_color_as_blue(String arg1) throws Throwable {
		String color = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 20)
				.getCssValue("color");
		ColorValidation(color);
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Choose highlight color is Orange$")
	public void choose_highlight_color_is_Orange() throws Throwable {
		WebElement highlightEle;
		CommonFunctionality.wait(500);
		try {
			highlightEle = CommonFunctionality.getElementByProperty(login.driver, "HighlightEle", 20);
			highlightEle.click();
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
					"//*[contains(@class,'color-picker-selection')]//*[contains(@class,'sp-palette-row-0')]//*[@title='#fda546']");
			CommonFunctionality.wait(500);
			click_on_X_icon_to_close_the_popup();
		} catch (Exception e) {
			highlightEle = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='sp-preview-inner'])[2]",
					20);
			highlightEle.click();
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
					"(//*[contains(@class,'color-picker-selection')]//*[contains(@class,'sp-palette-row-0')]//*[@title='#fda546'])[2]");
			CommonFunctionality.wait(500);
			CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='popover--wrapper']//*[@class='popover--close']", 20)
					.click();
		}
	}

	@Then("^The commentary should update the \"([^\"]*)\" highlight color as Orange$")
	public void the_commentary_should_update_the_highlight_color_as_Orange(String arg1) throws Throwable {
		String backgroundColor = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 20).getCssValue("background-color");
		ColorValidation(backgroundColor);
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Choose \"([^\"]*)\" from the drop-down for the font size$")
	public void choose_from_the_drop_down_for_the_font_size(String arg1) throws Throwable {
		Thread.sleep(1000);
		String size = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='title_font_size']", 20)
				.getAttribute("value");
		int length = Integer.parseInt(arg1) - Integer.parseInt(size);

		for (int i = 1; i <= length; i++) {
			Thread.sleep(500);
			login.driver.findElement(By.xpath(
					"//*[@class='accordion-config ' and(not(@class='accordion-config collapsed'))]//*[contains(@class,'ui-spinner')]//button[contains(@class,'ui-spinner-up')]"))
					.click();
		}
	}

	@Then("^The commentary should update the \"([^\"]*)\" font as \"([^\"]*)\"$")
	public void the_commentary_should_update_the_font_as(String arg1, String arg2) throws Throwable {
		login.driver.navigate().refresh();
		CommonFunctionality.wait(2000);
		String Txtfont = login.driver.findElement(By.xpath("//*[@data-name='" + arg1 + "']")).getCssValue("font-size");
		login.Log4j.info(Txtfont);
		FontSizeValidation(Txtfont, arg2);
		// CommonFunctionality.DeleteVisual();
		// CommonFunctionality.Views_list();
	}

	@And("^Click on Bold icon for \"([^\"]*)\"$")
	public void click_on_Bold_icon_for(String arg1) throws Throwable {

		WebElement bold = null;
		if (arg1.equalsIgnoreCase("title")) {
			bold = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("bold")));
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			bold = CommonFunctionality.getElementByXpath(login.driver, "//button[@name='credits_font_weight']", 20);
		} else if (arg1.equals("Items")) {
			bold = CommonFunctionality.getElementByXpath(login.driver,
					"//button[@name='tooltip_font_weight'] | //button[@name='legend_item_font_weight']", 20);
		}
		if (bold.getAttribute("class").contains("selected")) {
			// No need to select Bold format
		} else {
			bold.click();
		}
	}

	@Then("^The visual \"([^\"]*)\" should be in bold style$")
	public void the_visual_should_be_in_bold_style(String title) throws Throwable {
		BoldFormatVerification(title);
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on Italic under style$")
	public void click_on_Italic_under_style() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Italic", 4).click();
	}

	@And("^Click on Underline icon for \"([^\"]*)\"$")
	public void click_on_Underline_icon_for(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("title")) {
			CommonFunctionality.getElementByProperty(login.driver, "underline", 4).click();
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@name='credits_font_underline']", 15).click();
		}
	}

	@Then("^The visual \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void the_visual_should_be(String arg1, String format) throws Throwable {
		StyleSelection(arg1, format);
		//CommonFunctionality.DeleteVisual();

	}

	@And("^Click on left,center and right alignment for title$")
	public void click_on_left_center_and_right_alignment_for_title() throws Throwable {
		List<WebElement> alignment = login.driver.findElements(By.xpath("//*[@name='title_align']"));

		for (int i = 0; i < alignment.size(); i++) {
			CommonFunctionality.wait(300);
			alignment.get(i).click();
			String alignmentValue = login.driver
					.findElement(By.xpath("(//*[@class='visual-title visual-title--wrapper'])[1]"))
					.getAttribute("style");
			ListOfalignmentValue.add(alignmentValue);
		}
	}

	@Then("^The title should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as user set$")
	public void the_title_should_align_to_and_as_user_set(String arg1, String arg2, String arg3) throws Throwable {
		AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);

	}

	@And("^Check the box for sub-title$")
	public void check_the_box_for_sub_title() throws Throwable {
		ExpandSubTitle_CheckBox();
	}

	@Then("^The \"([^\"]*)\" should reflect on the Commentary$")
	public void the_should_reflect_on_the_Commentary(String arg1) throws Throwable {
		SubtitleCheck(arg1);
	}

	@SuppressWarnings("deprecation")
	@And("^Uncheck the box for sub-title$")
	public void uncheck_the_box_for_sub_title() throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SubTitleCheckBox")))
				.isSelected();
		if (checkbox == true) {
			WebElement checkbox1 = CommonFunctionality.getElementByProperty(login.driver, "SubTitleUnchecked", 4);
			new Actions(login.driver).pause(300).moveToElement(checkbox1).click().build().perform();

		} else if (checkbox == false) {
			// By default sub-title check box is not selected
			login.Log4j.info("sub-title check box is not selected");
			UnCheck = true;
		}
	}

	@Then("^No sub-title name should be displayed$")
	public void no_sub_title_name_should_be_displayed() throws Throwable {
		if (UnCheck == true) {
			login.Log4j.info("Sub title is not displayed");
		} else {
			Assert.fail("Sub Title is displayed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Check the box and enter the sub-title name as \"([^\"]*)\"$")
	public void check_the_box_and_enter_the_sub_title_name_as(String arg1) throws Throwable {
		ExpandSubTitle_CheckBox();
		login.driver.findElement(By.xpath("//*[@name='sub_title']")).clear();
		login.driver.findElement(By.xpath("//*[@name='sub_title']")).sendKeys(arg1);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='popover--close']", 8).click();
	}

	@And("^Choose text color is blue for subtitle$")
	public void choose_text_color_is_blue_for_subtitle() throws Throwable {
		ExpandSubTitle_CheckBox();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@name='sub_title_color']//following::div[1]", 4)
				.click();

		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"(//*[contains(@class,'color-picker-selection')]//*[contains(@class,'sp-palette-row-0')]//*[@title='#2b60d0'])[3]");
		CommonFunctionality.wait(500);
		click_on_X_icon_to_close_the_popup();
	}

	@And("^Choose highlight color is Orange for subtitle$")
	public void choose_highlight_color_is_Orange_for_subtitle() throws Throwable {
		ExpandSubTitle_CheckBox();
		WebElement highlightEle = CommonFunctionality.getElementByProperty(login.driver, "SubTitle_highlightEle", 4);
		CommonFunctionality.wait(200);
		highlightEle.click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"(//*[contains(@class,'color-picker-selection')]//*[contains(@class,'sp-palette-row-0')]//*[@title='#fda546'])[4]");
		CommonFunctionality.wait(500);
		click_on_X_icon_to_close_the_popup();
	}

	@And("^Choose \"([^\"]*)\" from the drop-down for the font size of subtitle$")
	public void choose_from_the_drop_down_for_the_font_size_of_subtitle(String value) throws Throwable {
		ExpandSubTitle_CheckBox();
		Thread.sleep(2000);
		String size = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='sub_title_font_size']", 8)
				.getAttribute("value");
		int length = 0;
		if (value.equals("10")) {
			length = Integer.parseInt(size) - Integer.parseInt(value);
		} else if (value.equals("20")) {
			length = Integer.parseInt(value) - Integer.parseInt(size);
		}

		for (int i = 1; i <= length; i++) {
			Thread.sleep(500);
			if (value.equals("10")) {
				login.driver
						.findElement(By.xpath(
								"(//*[contains(@class,'ui-spinner')]//button[contains(@class,'ui-spinner-down')])[2]"))
						.click();
			} else {
				// Histogram or pie visual
				// Select font size for sub title
				login.driver
						.findElement(By.xpath(
								"//*[@class='popover--wrapper']/*[2]/*/*[2]//button[contains(@class,'ui-spinner-up')]"))
						.click();
			}
		}
	}

	@And("^Click on B under style for sub-title$")
	public void click_on_B_under_style_for_sub_title() throws Throwable {
		ExpandSubTitle_CheckBox();
		WebElement SubTitle_bold = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle-bold")));
		if (SubTitle_bold.getAttribute("class").contains("selected")) {
			// No need to select Bold format
		} else {
			SubTitle_bold.click();
		}
	}

	@And("^Click on Italic under style for sub-title$")
	public void click_on_Italic_under_style_for_sub_title() throws Throwable {
		ExpandSubTitle_CheckBox();
		CommonFunctionality.getElementByProperty(login.driver, "subtitle_italic", 4).click();
	}

	@And("^Click on Underline icon for sub-title$")
	public void click_on_Underline_icon_for_sub_title() throws Throwable {
		ExpandSubTitle_CheckBox();
		CommonFunctionality.getElementByProperty(login.driver, "subtitle_underline", 4).click();
	}

	@And("^Click on left,center and right alignment for sub_title$")
	public void click_on_left_center_and_right_alignment_for_sub_title() throws Throwable {
		ExpandSubTitle_CheckBox();
		CommonFunctionality.wait(500);
		List<WebElement> alignment = login.driver.findElements(By.xpath("//*[@name='sub_title_align']"));

		for (int i = 0; i < alignment.size(); i++) {
			CommonFunctionality.wait(500);
			alignment.get(i).click();
			String alignmentValue = login.driver.findElement(By.xpath("//*[@class='visual-title--container']/*[2]"))
					.getAttribute("style");
			ListOfalignmentValue.add(alignmentValue);
		}
	}

	@Then("^The sub_title should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as user set$")
	public void the_sub_title_should_align_to_and_as_user_set(String arg1, String arg2, String arg3) throws Throwable {
		AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on X icon to close the popup$")
	public void click_on_X_icon_to_close_the_popup() throws Throwable {
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 15).click();
	}

	@Then("^The \"([^\"]*)\" popup should be closed$")
	public void the_popup_should_be_closed(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("tooltip")) {
			PopUp_validation(arg1);
			CommonFunctionality.getElementByClassName(login.driver, "movable-modal--close", 10).click();
			// CommonFunctionality.Views_list();
		} else if (arg1.equalsIgnoreCase("title") || arg1.equalsIgnoreCase("Copyright")) {
			PopUp_validation(arg1);
			// CommonFunctionality.DeleteVisual();
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Double click on the visual title/subtitle$")
	public void double_click_on_the_visual_title_subtitle() throws Throwable {
		CommonFunctionality.wait(3000);
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4);
		new Actions(login.driver).pause(300).doubleClick(title).build().perform();
	}

	@Then("^The title popup should be appeared$")
	public void the_title_popup_should_be_appeared() throws Throwable {
		if (CommonFunctionality.getElementByClassName(login.driver, "popover--title", 4).isDisplayed()) {
			login.Log4j.info("Title popup is displayed");
		} else {
			Assert.fail("Title popUp is not displayed");
		}
		// CommonFunctionality.Views_list();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on edit commentary icon$")
	public void click_on_edit_commentary_icon() throws Throwable {
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4);
		new Actions(login.driver).pause(500).moveToElement(title).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Edit visual title']", 4).click();

	}

	@Then("^By default Horizontal align should be disabled$")
	public void by_default_Horizontal_align_should_be_disabled() throws Throwable {
		WebElement DefaultHorizontal_Align = CommonFunctionality.getElementByXpath(login.driver,
				"(//*[@class='size-control']//*[@class='size-control--row'])[1]/div[2]", 4);
		if (DefaultHorizontal_Align.getAttribute("class").contains("disabled")) {
			login.Log4j.info("By default Horizontal align is disabled");
		} else {
			Assert.fail("By default Horizontal align is not disabled");
		}
		click_on_X_icon_to_close_the_popup();

	}

	@And("^Click on \"([^\"]*)\" option in visual header to (\\d+)$")
	public void click_on_option_in_visual_header_to(String arg1, int arg2) throws Throwable {
		WriteToDescription();
		String Proportiovalue = Integer.toString(arg2);
		WebElement proportion = CommonFunctionality.getElementByXpath(login.driver,
				"//*[text()='" + arg1 + "']//following::input[1]", 4);
		proportion.sendKeys(Keys.chord(Keys.CONTROL, "a"), Proportiovalue);
		proportion.sendKeys(Keys.TAB);
		// CommonFunctionality.wait(3000);
	}

	@Then("^Select Horizontal align of visual to \"([^\"]*)\"$")
	public void select_Horizontal_align_of_visual_to(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
		click_on_X_icon_to_close_the_popup();
		//UnselectVisual();
	}

	@Then("^The Visual area should be align to \"([^\"]*)\"$")
	public void the_Visual_area_should_be_align_to(String arg1) throws Throwable {
		WebElement visual_align = null;
		try {
			// commentary visual align
			visual_align = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='text-block-editor']", 20);
		} catch (Exception e) {

			// Attachments visual align
			visual_align = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='attachments-visual--container']", 20);

		}
		if (arg1.equalsIgnoreCase("Left")) {
			String left = visual_align.getAttribute("x-align");
			if (left.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			// click on visual header
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Visual')]", 20).click();

		}
		if (arg1.equalsIgnoreCase("Center")) {
			String center = visual_align.getAttribute("x-align");
			if (center.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			// click on visual header
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Visual')]", 20).click();
		}
		if (arg1.equalsIgnoreCase("Right")) {
			String right = visual_align.getAttribute("x-align");
			if (right.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			CommonFunctionality.DeleteVisual();
		}
	}

	@SuppressWarnings("deprecation")
	void DragAndDrop(String locator, String locator1) throws InterruptedException {
		WebElement VisualEle = CommonFunctionality.getElementByXpath(login.driver, locator, 20);
		WebElement ViewContainerlEle = CommonFunctionality.getElementByXpath(login.driver, locator1, 20);
		action.pause(500).clickAndHold(VisualEle).dragAndDrop(VisualEle, ViewContainerlEle).build().perform();
	}

	@Then("^By default Proportion should be \"([^\"]*)\"$")
	public void by_default_Proportion_should_be(String arg1) throws Throwable {
		String DefProportion_value = CommonFunctionality.getElementByProperty(login.driver, "ProportionValue", 20)
				.getAttribute("value");
		if (arg1.equals(DefProportion_value)) {
			login.Log4j.info("By default proportion value is" + arg1);
		} else {
			Assert.fail("Verification is failed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Check for Background$")
	public void check_for_Background() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "VisualBackground", 20).click();
	}

	@Then("^By default \"([^\"]*)\" should be disabled$")
	public void by_default_should_be_disabled(String arg1) throws Throwable {
		WebElement byDefaultVisualEle = null;
		if (arg1.equals("Background")) {
			byDefaultVisualEle = login.driver.findElement(By.xpath("//*[@class='background-control--options']/*[1]"));

		} else if (arg1.equals("Border")) {
			byDefaultVisualEle = login.driver.findElement(By.xpath("//*[@class='border-settings--container']/*[1]"));

		}
		if (byDefaultVisualEle.getAttribute("class").contains("disabled")) {
			login.Log4j.info("By default " + arg1 + " is disabled");
		} else {
			Assert.fail("By default " + arg1 + " is not disabled");
		}
		// CommonFunctionality.DeleteVisual();
		// CommonFunctionality.wait(5000);
		// login.driver.navigate().refresh();
		// CommonFunctionality.Create_New_Insight();
		// CommonFunctionality.ContinueSameInsight();
	}

	@And("^Enter some data to description field$")
	public void enter_some_data_to_description_field() throws Throwable {
		// CommonFunctionality.ContinueSameInsight();
		create_Commentary_visual();
		WriteToDescription();

	}

	@SuppressWarnings("deprecation")
	@And("^Select color for visual background$")
	public void select_color_for_visual_background() throws Throwable {

		WebElement checkbox = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'visual-background-control')]//*[@class='input-control--indicator']/*", 20);
		new Actions(login.driver).pause(500).moveToElement(checkbox).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='background-control--options']//*[@class='sp-replacer sp-light']", 20).click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"(//*[@class='sp-palette-container']//*[@title='#fda546'])[2]");
		UnselectVisual();
		click_on_X_icon_to_close_the_popup();

	}

	@Then("^Selected color should be applied to the visual background$")
	public void selected_color_should_be_applied_to_the_visual_background() throws Throwable {
		UnselectVisual();
		String Background_color = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-item-template visual-select-area text-template']", 20)
				.getCssValue("background-color");
		ColorValidation(Background_color);
		//CommonFunctionality.DeleteVisual();
	}

	@SuppressWarnings("deprecation")
	@And("^Click on browse > Select image for visual background$")
	public void click_on_browse_Select_image_for_visual_background() throws Throwable {
		WebElement checkbox = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'visual-background-control')]//*[@class='input-control--indicator']/*", 20);
		new Actions(login.driver).pause(500).moveToElement(checkbox).click().build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "image", 20).click();
		select_image();

	}

	@Then("^Selected image should be uploaded and applied to the visual background$")
	public void selected_image_should_be_uploaded_and_applied_to_the_visual_background() throws Throwable {
		CommonFunctionality.wait(2000);
		click_on_X_icon_to_close_the_popup();
		UnselectVisual();
		CommonFunctionality.wait(2000);
		WebElement backGroundImage = login.driver
				.findElement(By.xpath("//*[@class='visual-item-template visual-select-area text-template']"));
		backgroundImage(backGroundImage);

	}

	@And("^Click on remove icon for uploaded image$")
	public void click_on_remove_icon_for_uploaded_image() throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='background-image--remove icon--red-cross']", 30).click();
	}

	@Then("^The uploaded image should be removed$")
	public void the_uploaded_image_should_be_removed() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//*[@value='Image uploaded']")).size() == 0) {
			login.Log4j.info("Uploaded image is removed");
		} else {
			Assert.fail("Uploaded image is NOT removed");
		}
		//CommonFunctionality.DeleteVisual();

	}

	@And("^Check for Border$")
	public void check_for_Border() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "VisualBorder", 20).click();
	}

	@And("^Select color for visual border$")
	public void select_color_for_visual_border() throws Throwable {
		BorderCheckbox();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='border-settings--container']/*[1]//*[@class='sp-replacer sp-light']", 20).click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath",
				"(//*[@class='sp-palette-container']//*[@title='#2b60d0'])[1]");
		UnselectVisual();
		click_on_X_icon_to_close_the_popup();
	}

	@Then("^The visual border should be changed as per the selection$")
	public void the_visual_border_should_be_changed_as_per_the_selection() throws Throwable {
		UnselectVisual();
		String border_color = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-item-template visual-select-area text-template']", 20).getCssValue("border-color");
		ColorValidation(border_color);
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Select border width (\\d+) for visual border$")
	public void select_border_width_for_visual_border(int arg1) throws Throwable {
		// Thread.sleep(1000);
		BorderCheckbox();
		// String BorderWidth = CommonFunctionality
		// .getElementByXpath(login.driver, "//*[@name='visual_area_border_width']", 20)
		// .getAttribute("aria-valuenow");
		// int length = arg1 - Integer.parseInt(BorderWidth);

		for (int i = 1; i <= arg1; i++) {
			Thread.sleep(500);
			login.driver.findElement(By.xpath(
					"(//*[@class='border-settings--container']//*[contains(@class,'ui-spinner')]//button[contains(@class,'ui-spinner-up')])[1]"))
					.click();
		}
	}

	@Then("^\"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void should_be_updated_to(String arg1, String arg2) throws Throwable {
		click_on_X_icon_to_close_the_popup();
		UnselectVisual();
		Thread.sleep(2000);
		if (arg1.equals("Width")) {
			String ActualWidth;
			try {
				// border width for commentary visual
				ActualWidth = login.driver
						.findElement(By.xpath("//*[@class='visual-item-template visual-select-area text-template']"))
						.getCssValue("border-width");
			} catch (Exception e) {
				try {
					// border width for attachment visual
					ActualWidth = login.driver.findElement(By.xpath("//*[@class='attachments-visual--container']"))
							.getCssValue("border-width");
				} catch (Exception e1) {
					// border width for filter visual
					ActualWidth = login.driver.findElement(By.xpath("//*[@class='filter-template--multi-select']"))
							.getCssValue("border-width");
				}
			}
			login.Log4j.info(ActualWidth);
			FontSizeValidation(ActualWidth, arg2);
		} else if (arg1.equalsIgnoreCase("Radius")) {
			String ActualRadius;
			try {
				// Radius for commentary visual
				ActualRadius = login.driver
						.findElement(By.xpath("//*[@class='visual-item-template visual-select-area text-template']"))
						.getCssValue("border-radius");
			} catch (Exception e) {
				try {
					// Radius for Attachment visual
					ActualRadius = login.driver.findElement(By.xpath("//*[@class='attachments-visual--container']"))
							.getCssValue("border-radius");
				} catch (Exception e1) {
					// Radius for filter visual
					ActualRadius = login.driver.findElement(By.xpath("//*[@class='filter-template--multi-select']"))
							.getCssValue("border-radius");
				}
			}
			login.Log4j.info("Actual value is :" + ActualRadius);
			FontSizeValidation(ActualRadius, arg2);
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Tick checkbox for border and choose radius as (\\d+)$")
	public void tick_checkbox_for_border_and_choose_radius_as(int arg1) throws Throwable {
		// Thread.sleep(1000);
		BorderCheckbox();
		Radius(arg1);
	}

	@And("^Tick checkbox for border and choose different border as \"([^\"]*)\"$")
	public void tick_checkbox_for_border_and_choose_different_border_as(String arg1) throws Throwable {
		BorderCheckbox();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='select2-arrow']//*", 20).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
	}

	@Then("^The \"([^\"]*)\" border should be applied to the visual$")
	public void the_border_should_be_applied_to_the_visual(String arg1) throws Throwable {
		UnselectVisual();
		click_on_X_icon_to_close_the_popup();
		UnselectVisual();
		String BorderStyle;
		try {
			// Select border style for commentary visual
			BorderStyle = login.driver
					.findElement(By.xpath("//*[@class='visual-item-template visual-select-area text-template']"))
					.getCssValue("border-style");
		} catch (Exception e) {
			try {
				// Select border style for attachments visual
				BorderStyle = login.driver.findElement(By.xpath("//*[@class='attachments-visual--container']"))
						.getCssValue("border-style");
			} catch (Exception e1) {
				// Select border style for filter visual
				BorderStyle = login.driver.findElement(By.xpath("//*[@class='filter-template--multi-select']"))
						.getCssValue("border-style");
			}

		}
		login.Log4j.info("Actual value is " + BorderStyle);
		FontSizeValidation(BorderStyle, arg1);
	//	CommonFunctionality.DeleteVisual();

	}

	@And("^Create Commentary visual$")
	public void create_Commentary_visual() throws Throwable {
		// login.driver.navigate().refresh();
		// CommonFunctionality.ContinueSameInsight();
		CommonFunctionality.wait(1000);
		CreateViewTab();
		drag_and_drop_commentary_visual_to_the_page();
	}

	@And("^Click on Copy icon$")
	public void click_on_Copy_icon() throws Throwable {

		try {
			login.driver.switchTo().defaultContent();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Copy']", 12).click();
		} catch (Exception e) {
			// click on copy icon in expanded image visual window
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='vis-elem-menu vis-elem-menu__modal']//*[@title='Copy']", 12).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sphere-modal__close']", 12).click();
		}
	}

	@And("^Paste within the insight$")
	public void paste_within_the_insight() throws Throwable {
		CreateViewTab();
		WebElement ActiveViewEle = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link__active')]", 20);
		// contextClick() method to do right click on the element
		action.contextClick(ActiveViewEle).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Paste visual')]", 20).click();
	}

	@Then("^The visual should be pasted in the insight$")
	public void the_visual_should_be_pasted_in_the_insight() throws Throwable {
		CommonFunctionality.wait(1000);
		try {
			// paste commentary visual
			String ExpectedDiscription = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='text-block-editor']/*", 20).getText();
			DiscriptionValidation(ExpectedDiscription);
		} catch (Exception e) {
			// paste Histogram/pie visual
			String ActualText = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 15)
					.getText();
			if (ActualText.equals(Histogram.Visual_Title_txt) || ActualText.equals(PieVisual.Visual_Title_txt)) {
				login.Log4j.info("Histogram/pie visual is created in the same insiaght");
			} else {
				Assert.fail("Histogram/pie visual is not created in the same insight");
			}
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Paste to new insight$")
	public void paste_to_new_insight() throws Throwable {
		String arg = "New";
		// Create a New insight
		DatabasesTab.create_a_insight(arg);
		CommonFunctionality.wait(2000);
		WebElement ViewTabEle = login.driver.findElement(By.xpath("//*[@class='insight-page-view-tab--title']"));
		ViewTabEle.click();
		// contextClick() method to do right click on the element
		action.pause(500).contextClick(ViewTabEle).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Paste visual')]", 20).click();
	}

	@Then("^The visual should be pasted to new insight$")
	public void the_visual_should_be_pasted_to_new_insight() throws Throwable {
		the_visual_should_be_pasted_in_the_insight();
	}

	@Then("^Paste in Excel and the text should be pasted to excel$")
	public void paste_in_Excel_and_the_text_should_be_pasted_to_excel() throws Throwable {
		PasteToExcel(Description);
		// CommonFunctionality.DeleteVisual();
	}

	@Then("^Paste in word and the text should be pasted in word file$")
	public void paste_in_word_and_the_text_should_be_pasted_in_word_file() throws Throwable {
		WriteToWord(Description);
		readDocFile(Description);
	//	CommonFunctionality.DeleteVisual();
	}

	@Then("^Paste in ppt and the text should be pasted PPT$")
	public void paste_in_ppt_and_the_text_should_be_pasted_PPT() throws Throwable {
		WriteToPPT(Description);
		ReadPPT(Description);
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on Download icon$")
	public void click_on_Download_icon() throws Throwable {
		login.driver.switchTo().defaultContent();
		CommonFunctionality.getElementByProperty(login.driver, "DownloadIcon_var", 20).click();
	}

	@Then("^Download popup should be appeared$")
	public void download_popup_should_be_appeared() throws Throwable {
		if (CommonFunctionality.getElementByProperty(login.driver, "DownloadTitle", 20).isDisplayed()) {
			login.Log4j.info("Download popup is appeared");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 20).click();
		} else {
			Assert.fail("Download popup is not appeared");
		}
		// CommonFunctionality.DeleteVisual();
	}

	@And("^Select \"([^\"]*)\" format$")
	public void select_format(String arg1) throws Throwable {
		format = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-format='" + arg1 + "']", 20).click();
		// Last_file_download.getTheNewestFile(format);
	}

	/*
	 * @Then("^Excel file should be download with the visual$") public void
	 * excel_file_should_be_download_with_the_visual() throws Throwable {
	 * CommonFunctionality.wait(3000); Last_file_download.getTheNewestFile(format);
	 * ReadExcel.getTheData(Description); File_delete.delete();
	 * CommonFunctionality.DeleteVisual(); }
	 */
	@Then("^The tab name should be \"([^\"]*)\"$")
	public void the_tab_name_should_be(String arg1) throws Throwable {
		CommonFunctionality.wait(3000);
		CommonFunctionality.getTheNewestFile(format);
		ReadExcel.getTheData(arg1);
		File_delete.delete();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Commentary should be downloaded in \"([^\"]*)\" format$")
	public void commentary_should_be_downloaded_in_format(String arg1) throws Throwable {
		// commentary_should_be_downloaded_in_PNG_format();
		CommonFunctionality.wait(3000);
		CommonFunctionality.getTheNewestFile(format);
		ReadFormatData(Description);
		File_delete.delete();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Drop down should be opened with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void drop_down_should_be_opened_with_and(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> dropDown_list = login.driver.findElements(By.xpath("//*[@class='items-wrapper']//li"));
		for (int i = 0; i < dropDown_list.size(); i++) {
			String ele = dropDown_list.get(i).getText();
			if (arg1.equals(ele)) {
				login.Log4j.info(arg1 + " exists in Add to insights dropdown");
			} else if (arg2.equals(ele)) {
				login.Log4j.info(arg2 + " exists in Add to insights dropdown");
			} else {
				Assert.fail(ele + " does not exist");
			}
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The Visual should be created in new tab on current insight$")
	public void the_Visual_should_be_created_in_new_tab_on_current_insight() throws Throwable {
		SwitchToFrame();
		String ActualText = CommonFunctionality.getElementByProperty(login.driver, "description", 20).getText();
		login.driver.switchTo().defaultContent();

		if (ActualText.equals(Description)) {
			login.Log4j.info("Commentary Visual is created in new tab");
		} else {
			Assert.fail("Commentary Visual is not created for Add option");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" confirmation message should be displayed$")
	public void and_confirmation_message_should_be_displayed(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(300);
		String growlText = CommonFunctionality.getElementByProperty(login.driver, "confirm_popup", 10).getText();
		login.Log4j.info(growlText);
		if (growlText.contains(arg1) && growlText.contains(arg2)) {
			login.Log4j.info(growlText + " is displayed");
			// CommonFunctionality.getElementByXpath(login.driver,
			// "//*[@class='growl-message-close']", 4).click();
		} else {
			Assert.fail(growlText + " is not displayed");
		}
		// CommonFunctionality.wait(7000);
		// CommonFunctionality.DeleteVisual();

	}

	@Then("^The insight should be opened and added visual should be available in My visual$")
	public void the_insight_should_be_opened_and_added_visual_should_be_available_in_My_visual() throws Throwable {
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		CommonFunctionality.getElementByXpath(login.driver, "//a[@title='View 1']", 10).click();
		try {
			String ActualText = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='text-block-editor']//p", 15).getText();
			if (ActualText.equals(Description)) {
				login.Log4j.info("Commentary visual is created in new insiaght");
			} else {
				Assert.fail("Commentary visual is not created ");
			}
		} catch (Exception e) {
			String ActualText = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 15)
					.getText();
			if (ActualText.equals(Histogram.Visual_Title_txt)) {
				login.Log4j.info("Histogram visual is created in new insiaght");
			} else {
				Assert.fail("Histogram visual is not created in new insight");
			}

		}
		CommonFunctionality.DeleteVisual();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));
		// CommonFunctionality.DeleteVisual();
	}

	@Then("^\"([^\"]*)\" popup should be dispalyed$")
	public void popup_should_be_dispalyed(String arg1) throws Throwable {
		String confirm_popUp;
		if (arg1.equals("Confirmation")) {
			confirm_popUp = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='modal-header sphere-modal__header']//h4", 10)
					.getText();
			if (confirm_popUp.equals(arg1)) {
				login.Log4j.info(arg1 + " is displayed");
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='sphere-modal-controls']//*[contains(text(),'Ok')]", 8).click();
			} else {
				Assert.fail(arg1 + " is not displayed");
			}
		} else if (arg1.equals("Do you want to remove this visual?")) {
			confirm_popUp = CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='modal-body sphere-modal__body']", 10).getText();

			if (confirm_popUp.contains(arg1)) {
				login.Log4j.info(arg1 + " is displayed");
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='sphere-modal-controls']//*[contains(text(),'Ok')]", 10).click();
			} else {
				Assert.fail(arg1 + " is not displayed");
			}
		}
		//CommonFunctionality.DeleteVisual();
	}

	/*
	 * @And("^Select visual$") public void create_Commentary_visual() throws
	 * Throwable { login.driver.navigate().refresh(); CreateViewTab();
	 * drag_and_drop_commentary_visual_to_the_page(); }
	 */

	@And("^Click on \"([^\"]*)\" drop down$")
	public void click_on_drop_down(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Text color") || arg1.equalsIgnoreCase("Background color")) {
			// select the data
			login.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
			login.driver.switchTo().defaultContent();
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']/*[2]", 15)
					.click();
		} else if (arg1.equalsIgnoreCase("Font Sizes")) {
			// select the data
			login.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
			login.driver.switchTo().defaultContent();
			CommonFunctionality.wait(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']/*[1]", 15).click();
		} else if (arg1.equals("Table")) {
			CommonFunctionality.wait(2500);
			CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
		}

	}

	@Then("^\"([^\"]*)\" table options should be available$")
	public void table_options_should_be_available(String arg1) throws Throwable {
		String[] str = arg1.split(",");
		CommonFunctionality.wait(1500);
		List<WebElement> TableOptions = login.driver
				.findElements(By.xpath("//*[contains(@class,'mce-container-body')]//*[@class='mce-text']"));
		int i = 0;
		for (String strTable : str) {
			for (int j = i; j < TableOptions.size();) {
				String TableEle = TableOptions.get(j).getText();
				if (strTable.equalsIgnoreCase(TableEle)) {
					login.Log4j.info(TableEle);
					i = i + 1;
				} else {
					Assert.fail(TableEle + " not available in Table");
				}
				break;
			}
		}
	//	CommonFunctionality.DeleteVisual();
	}

	@SuppressWarnings("deprecation")
	@And("^Create table$")
	public void create_table() throws Throwable {
		WebElement ele = null;
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@title='Table']//*[contains(text(),'Table')]", 15)
				.click();
		List<WebElement> listOfRows = login.driver.findElements(By.xpath("//*[@class='tox-insert-table-picker']/*"));
		// List<WebElement> listOfRows =
		// login.driver.findElements(By.xpath("//table//tr"));
		for (int i = 1; i < listOfRows.size(); i++) {
			ele = listOfRows.get(i);
			new Actions(login.driver).pause(300).moveToElement(ele).build().perform();
			if (i == 9) {
				ele.click();
				SelectedRows = i;
				break;
			}
		}
	}

	@Then("^Table should be created as per the selection$")
	public void table_should_be_created_as_per_the_selection() throws Throwable {
		SwitchToFrame();
		List<WebElement> Aft_tab_cretn_ListOfRows = login.driver
				.findElements(By.xpath("//table[@class='table-default mce-item-table']//tr//td"));
		if (SelectedRows + 1 == Aft_tab_cretn_ListOfRows.size()) {
			login.Log4j.info("Table is created");
		} else {
			Assert.fail("Table is not created");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Set \"([^\"]*)\" for table \"([^\"]*)\"$")
	public void set_for_table(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("width")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='tox-form__grid tox-form__grid--2col']/*[1]/*[2]", 15)
					.clear();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='tox-form__grid tox-form__grid--2col']/*[1]/*[2]", 15)
					.sendKeys(arg2);

		} else if (arg1.equalsIgnoreCase("height")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='tox-form__grid tox-form__grid--2col']/*[2]/*[2]", 15)
					.sendKeys(arg2);
		} else if (arg1.equalsIgnoreCase("cell spacing")) {
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='tox-form__grid tox-form__grid--2col']/*[3]/*[2]", 15)
					.sendKeys(arg2);
		} else if (arg1.equalsIgnoreCase("cell padding")) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='tox-form__grid tox-form__grid--2col']/*[4]/*[2]", 15).clear();
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[@class='tox-form__grid tox-form__grid--2col']/*[4]/*[2]", 15)
					.sendKeys(arg2);
		}
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@title='Save']", 15).click();
	}

	@Then("^The table \"([^\"]*)\" should be displayed as \"([^\"]*)\"$")
	public void the_table_should_be_displayed_as(String arg1, String arg2) throws Throwable {
		Boolean ResultMatch = false;
		CommonFunctionality.wait(2000);
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		String ExpectedValue = arg2;
		if (arg1.equalsIgnoreCase("width") || arg1.equalsIgnoreCase("height")) {
			String str = login.driver.findElement(By.xpath("//table[@class='table-default mce-item-table']"))
					.getAttribute("style");
			String[] strValue = str.split(";");
			for (String ActualValue : strValue) {
				if (ActualValue.contains(arg1) && ActualValue.contains(ExpectedValue)) {
					login.Log4j.info("The table " + arg1 + " is " + arg2);
					ResultMatch = true;
					break;
				}
			}
			if (ResultMatch == false) {
				Assert.fail("The table " + arg1 + " is not matched");
			}

		} else if (arg1.equalsIgnoreCase("cell spacing")) {
			String Actual_Value = login.driver.findElement(By.xpath("//table[@class='table-default mce-item-table']"))
					.getAttribute("style");
			String[] border_space = Actual_Value.split("border-spacing:");

			if (border_space[1].trim().contains(ExpectedValue)) {
				login.Log4j.info("The table " + arg1 + " is " + border_space[1].trim());

			} else {
				Assert.fail("The table " + arg1 + " is not matched");
			}
		} else if (arg1.equalsIgnoreCase("cell padding")) {
			String Actual_Value = login.driver.findElement(By.xpath("//table[@class='table-default mce-item-table']/*/*/*[1]"))
					.getCssValue("padding");

			if (Actual_Value.contains(ExpectedValue)) {
				login.Log4j.info("The table " + arg1 + " is " + arg2);

			} else {
				Assert.fail("The table " + arg1 + " is not matched");
			}
		}

		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Click on Open icon$")
	public void click_on_Open_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open']", 15).click();
	}

	@Then("^The visual should be displayed in maximized window$")
	public void the_visual_should_be_displayed_in_maximized_window() throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='modal-window modal-window__full-screen modal-window__active']", 4).isDisplayed()) {
			login.Log4j.info("The visual is displayed in maximized window");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 15).click();
		} else {
			Assert.fail("Fail");
		}
	//	CommonFunctionality.DeleteVisual();
	}

	@And("^Click on x icon to close$")
	public void click_on_x_icon_to_close() throws Throwable {
		try {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 15).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 4).click();
		}
	}

	@Then("^The modal window should be closed$")
	public void the_modal_window_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);
		if ((login.driver.findElements(By.xpath("//*[@class='modal-dialog sphere-modal-dialog ']")).size()) == 0) {
			login.Log4j.info("The modal window is closed");
		} else {
			Assert.fail("Fail");
		}
	//	CommonFunctionality.DeleteVisual();
	}

	@SuppressWarnings("deprecation")
	@And("^Check Caption for table$")
	public void check_Caption_for_table() throws Throwable {
		WebElement CaptioncheckBox = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='tox-checkbox']/*[2]", 4);
		new Actions(login.driver).pause(300).moveToElement(CaptioncheckBox).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@title='Save']", 15).click();
	}

	@Then("^Caption should be added to the table$")
	public void caption_should_be_added_to_the_table() throws Throwable {
		SwitchToFrame();
		WebElement caption = CommonFunctionality.getElementByXpath(login.driver, "//table//caption", 10);
		if (caption.isDisplayed()) {
			login.Log4j.info("Caption is added to table");
		} else {
			Assert.fail("Caption is not added");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Uncheck caption for table$")
	public void uncheck_caption_for_table() throws Throwable {
		String arg = "Table";
		String arg1 = "Table properties";
		check_Caption_for_table();
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		WebElement caption = CommonFunctionality.getElementByXpath(login.driver, "//table//caption", 10);
		if (caption.isDisplayed()) {
			login.driver.switchTo().defaultContent();
			click_on_drop_down(arg);
			st.click_on(arg1);
			check_Caption_for_table();

		}
	}

	@Then("^Caption shoud be removed$")
	public void caption_shoud_be_removed() throws Throwable {
		SwitchToFrame();
		if (login.driver.findElements(By.xpath("//table//caption")).size() == 0) {
			login.Log4j.info("Caption is removed");
		} else {
			Assert.fail("Caption is not removed");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The table properties popup should be closed$")
	public void the_table_properties_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("(//*[@aria-label='Table properties'])[2]")).size() == 0) {
			login.Log4j.info("The table properties popup is closed");
		} else {
			Assert.fail("The table properties popup is not closed");
		}

		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The table should be deleted from the visual$")
	public void the_table_should_be_deleted_from_the_visual() throws Throwable {
		SwitchToFrame();
		if (login.driver.findElements(By.xpath("//*[@id='tinymce']//table")).size() == 0) {
			login.Log4j.info("The table is deleted");
		} else {
			Assert.fail("The table is not deleted");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The Cell properties popup should be displayed$")
	public void the_Cell_properties_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(500);
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Cell Properties')]", 15).isDisplayed()) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='tox-icon']", 15).click();
			login.Log4j.info("Cell properties popup is displayed");
		} else {
			Assert.fail("Cell properties popup is not displayed");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Select cells to merge$")
	public void select_cells_to_merge() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		ListOfCells = login.driver.findElements(By.xpath("//*[@id='tinymce']//table//tr//td"));
		// login.Log4j.info("Before splitting total no of cell " + ListOfCells.size());
		new Actions(login.driver).clickAndHold(ListOfCells.get(0)).keyDown(Keys.CONTROL).release(ListOfCells.get(1))
				.keyUp(Keys.CONTROL).build().perform();
		login.driver.switchTo().defaultContent();
	}

	@Then("^The selected cells should be merged$")
	public void the_selected_cells_should_be_merged() throws Throwable {
		SwitchToFrame();
		String str = login.driver.findElement(By.xpath("//*[@id='tinymce']//table//tr//td[1]")).getAttribute("colspan");
		Integer colspan = Integer.parseInt(str);
		if (colspan == 2) {
			login.Log4j.info("Selected cells is merged");
		} else {
			Assert.fail("Selected cells not merged");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The cell should be split the cell$")
	public void the_cell_should_be_split_the_cell() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		List<WebElement> AfterSplit_ListOfCells = login.driver
				.findElements(By.xpath("//*[@id='tinymce']//table//tr//td"));
		if (ListOfCells.size() == AfterSplit_ListOfCells.size()) {
			login.Log4j.info("The cell is splited");
		} else {
			Assert.fail("The cell is not splited");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The row should be insertd before the selected table$")
	public void the_row_should_be_insertd_before_the_selected_table() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		List<WebElement> ListOfRows = login.driver
				.findElements(By.xpath("//table[@class='table-default mce-item-table']//tr"));
		if (ListOfRows.size() > BeforeInsert_ListOfRows.size()) {
			login.Log4j.info("The row is inserted");
		} else {
			Assert.fail("The row is not inserted");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();

	}

	@Then("^The row should be insertd after selected the table$")
	public void the_row_should_be_insertd_after_selected_the_table() throws Throwable {
		the_row_should_be_insertd_before_the_selected_table();
	}

	@And("^Verify row count$")
	public void verify_row_count() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		BeforeInsert_ListOfRows = login.driver
				.findElements(By.xpath("//table[@class='table-default mce-item-table']//tr"));
		login.driver.switchTo().defaultContent();
	}

	@Then("^The selected row should be deleted$")
	public void the_selected_row_should_be_deleted() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//table[@class='table-default mce-item-table']//tr")).size() == 0) {
			login.Log4j.info("The row is deleted");
		} else {
			Assert.fail("The row is not deleted");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Enter text in a cell$")
	public void enter_text_in_a_cell() throws Throwable {
		SwitchToFrame();
		CommonFunctionality
				.getElementByXpath(login.driver, "//table[@class='table-default mce-item-table']//tr//td[1]", 15)
				.sendKeys("Nadiya");
		login.driver.switchTo().defaultContent();
	}

	@And("^Apply \"([^\"]*)\" as \"([^\"]*)\"$")
	public void apply_as(String arg1, String arg2) throws Throwable {

		switch (arg1) {
		case "Row type":
			var1 = arg2;
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='" + arg1 + "']/*[1]",
					4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 15).click();
			break;
		case "Alignment":
			var2 = arg2;
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='" + arg1 + "']/*[1]", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 15).click();
			break;
		case "Height":
			var3 = arg2;
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='tox-form__group']//input", 15)
					.sendKeys(arg2);
			break;
		default:

		}

	}

	@Then("^Applied properties should be display$")
	public void applied_properties_should_be_display() throws Throwable {
		WebElement ele = null;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Save']", 15).click();
		SwitchToFrame();
		if (var1.equalsIgnoreCase("Footer")) {
			if (login.driver.findElement(By.xpath("//table//tfoot")).isDisplayed()) {
				login.Log4j.info("Row type is " + var1);
			} else {
				Assert.fail("Row type is not " + var1);
			}
		}
		if (var2.equalsIgnoreCase("Right")) {
			ele = CommonFunctionality.getElementByXpath(login.driver, "//table//tfoot//tr", 15);
			String alignment = ele.getAttribute("style");
			if (alignment.toUpperCase().contains(var2.toUpperCase())) {
				login.Log4j.info("Alignment is " + var2);
			} else {
				Assert.fail("Alignment is not " + var2);
			}
		}
		if (var3.equalsIgnoreCase("50px")) {
			String Height = ele.getAttribute("style");
			if (Height.contains(var3)) {
				login.Log4j.info("Height is " + var3);
			} else {
				Assert.fail("Height does not equal to " + var3);
			}
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The selected row should be cut$")
	public void the_selected_row_should_be_cut() throws Throwable {
		the_selected_row_should_be_deleted();
	}

	@And("^Verify column count$")
	public void verify_column_count() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(1000);
		BeforeInsert_ListOfColumns = login.driver
				.findElements(By.xpath("//table[@class='table-default mce-item-table']//tr//td"));
		login.driver.switchTo().defaultContent();
	}

	@Then("^The column should be inserted before selected column$")
	public void the_column_should_be_inserted_before_selected_column() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		List<WebElement> ListOfColumns = login.driver
				.findElements(By.xpath("//table[@class='table-default mce-item-table']//tr//td"));
		if (ListOfColumns.size() > BeforeInsert_ListOfColumns.size()) {
			login.Log4j.info("The Column is inserted");
		} else {
			Assert.fail("The Column is not inserted");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The column should be inserted after selected column$")
	public void the_column_should_be_inserted_after_selected_column() throws Throwable {
		the_column_should_be_inserted_before_selected_column();
	}

	@Then("^The column should be deleted$")
	public void the_column_should_be_deleted() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		List<WebElement> ListOfColumns = login.driver
				.findElements(By.xpath("//table[@class='table-default mce-item-table']//tr//td"));
		if (ListOfColumns.size() < BeforeInsert_ListOfColumns.size()) {
			login.Log4j.info("The Column is deleted");
		} else {
			Assert.fail("The Column is not deleted");
		}
		login.driver.switchTo().defaultContent();
	//	CommonFunctionality.DeleteVisual();
	}

	@And("^Choose font size as \"([^\"]*)\"$")
	public void choose_font_size_as(String arg1) throws Throwable {

		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 15).click();

	}

	@Then("^Text should be changed to \"([^\"]*)\" size$")
	public void text_should_be_changed_to_size(String arg1) throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		WebElement TextEle = login.driver.findElement(By.xpath("//html//body[@id='tinymce']//p//span"));
		login.Log4j.info(TextEle.getCssValue("font-size"));
		if (TextEle.getCssValue("font-size").equals(arg1)) {
			login.Log4j.info("The text size is matched with the applied size as " + arg1);
		} else {
			Assert.fail("The text size is not matched with the " + arg1);
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Choose text color as \"([^\"]*)\"$")
	public void choose_text_color_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
//		Actualcolor = login.driver.findElement(By.xpath("//table//tbody//tr[3]//td[1]//div"))
//				.getCssValue("background-color");
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='" + arg1 + "']", 15)
				.click();
		CommonFunctionality.wait(1000);
	}

	@Then("^The Text should be changed to \"([^\"]*)\"$")
	public void the_Text_should_be_changed_to(String arg1) throws Throwable {
		String ExpectedColor = "#e03e2d";
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		try {
			WebElement TextEle = login.driver.findElement(By.xpath("//html//body[@id='tinymce']//p//span"));
			String colorEle = TextEle.getCssValue("color");
			String ActualColor = Color.fromString(colorEle).asHex();
			login.Log4j.info(ActualColor);
			Assert.assertEquals(ActualColor, ExpectedColor);
			// login.Log4j.info(TextEle.getCssValue("background-color"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*if (TextEle.getCssValue("color").equals(Actualcolor.trim())) {
			login.Log4j.info("The text color is " + arg1);
		} else if (TextEle.getCssValue("background-color").equals(Actualcolor)) {
			login.Log4j.info("The text color is " + arg1);
		} else {
			Assert.fail("The text color is not matched with " + arg1);
		}*/
		login.driver.switchTo().defaultContent();
		

	}

@Then("^The background of text should be changed to \"([^\"]*)\"$")
public void the_background_of_text_should_be_changed_to(String arg1) throws Throwable {
	String ExpectedColor = "#e03e2d";
	SwitchToFrame();
	CommonFunctionality.wait(2000);
	try {
		WebElement TextEle = login.driver.findElement(By.xpath("//html//body[@id='tinymce']//p//span"));
		String colorEle = TextEle.getCssValue("background-color");
		String ActualColor = Color.fromString(colorEle).asHex();
		login.Log4j.info(ActualColor);
		Assert.assertEquals(ActualColor, ExpectedColor);
	} catch (Exception e) {
		e.printStackTrace();
	}
	login.driver.switchTo().defaultContent();
}

	@And("^Choose background color as \"([^\"]*)\"$")
	public void choose_background_color_as(String arg1) throws Throwable {
		choose_text_color_as(arg1);
	}

	@And("^Choose alignment as \"([^\"]*)\"$")
	public void choose_alignment_as(String arg1) throws Throwable {
		login.driver.switchTo().defaultContent();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15).click();
	}

	@Then("^Title should align to \"([^\"]*)\"$")
	public void title_should_align_to(String arg1) throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		WebElement TextEle = login.driver.findElement(By.xpath("//html//body[@id='tinymce']//p"));

		if (TextEle.getAttribute("style").contains(arg1)) {
			login.Log4j.info("The text is align to " + arg1);
		} else {
			Assert.fail("The text is not align to " + arg1);
		}
		login.driver.switchTo().defaultContent();
		if (arg1.equalsIgnoreCase("center")) {
			CommonFunctionality.DeleteVisual();
		}

	}

	@And("^Enter data to description field$")
	public void enter_data_to_description_field() throws Throwable {
		Description = "Testing Horizontal Alignment" + "\n" + " for Visual popUp " + "\n\n"
				+ " BackGround Color verification" + "\n" + "File uploading";
		CommonFunctionality.wait(5000);
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		WebElement DescriptionTxt = CommonFunctionality.getElementByProperty(login.driver, "description", 15);
		DescriptionTxt.sendKeys(Keys.chord(Keys.CONTROL, "a"), Description);
		login.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
		login.driver.switchTo().defaultContent();
	}

	@Then("^Choosed list should be displayed$")
	public void choosed_list_should_be_displayed() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//html//body[@id='tinymce']//ul")).size() > 0) {
			login.Log4j.info("Bullet list is displayed");
		} else if (login.driver.findElements(By.xpath("//html//body[@id='tinymce']//ol")).size() > 0) {
			login.Log4j.info("Number list is displayed");
		} else {
			Assert.fail("Selected list is not displayed");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();

	}

	@Then("^Selected text should be moved as per the selection$")
	public void selected_text_should_be_moved_as_per_the_selection() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		String Increase_indent = CommonFunctionality
				.getElementByXpath(login.driver, " //html//body[@id='tinymce']//p", 15).getAttribute("style");
		login.Log4j.info(Increase_indent);
		if (Increase_indent.contains("40px")) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Verification failed");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The text should be changed to \"([^\"]*)\"$")
	public void the_text_should_be_changed_to(String arg1) throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//html//body[@id='tinymce']//p//strong")).size() == 1) {
			login.Log4j.info("The text is displayed in " + arg1);
		} else if (login.driver.findElements(By.xpath("//html//body[@id='tinymce']//p//em")).size() == 1) {
			login.Log4j.info("The text is displayed in " + arg1);

		} else {
			Assert.fail("The text is not displayed in " + arg1 + " format");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Select image$")
	public void select_image() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		CommonFunctionality.wait(5000);
	}

	@Then("^Selected image should be uploaded$")
	public void selected_image_should_be_uploaded() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		WebElement Image = login.driver.findElement(By.xpath("//html//body[@id='tinymce']//p//img"));

		if (Image.isDisplayed()) {
			login.Log4j.info("Selected image is uploaded to the visual");
		} else {
			Assert.fail("Selected image is NOT uploaded");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Get the text from the description field$")
	public void get_the_text_from_the_description_field() throws Throwable {
		CommonFunctionality.wait(2000);
		DiscriptionTxt = CommonFunctionality.getElementByProperty(login.driver, "description", 15).getText();
		login.Log4j.info(DiscriptionTxt);
		login.driver.switchTo().defaultContent();
		if (!DiscriptionTxt.isEmpty()) {
			login.Log4j.info("It allows the comments in description field");
		} else {
			Assert.fail("It doesn't allow the comments in description field");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on visual header$")
	public void right_click_on_visual_header() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement title = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 6);
		new Actions(login.driver).pause(500).contextClick(title).build().perform();
	}

	@And("^Choose \"([^\"]*)\"$")
	public void choose(String arg1) throws Throwable {
		try {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='items-wrapper']//*[contains(text(),'" + arg1 + "')]", 10).click();
		} catch (Exception e) {
			CommonFunctionality.DeleteVisual();
			Assert.fail(arg1 + " option is disabled");
		}

	}

	@Then("^Commentary should be copied to clipboard$")
	public void commentary_should_be_copied_to_clipboard() throws Throwable {
		WebElement GrowlPopUp = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='growl-message-text']", 4);
		if (GrowlPopUp.isDisplayed()) {
			CommonFunctionality.wait(2000);
			// Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			// String Clipboard_data = (String) clipboard.getData(DataFlavor.stringFlavor);
			String Clipboard_data = (String) Toolkit.getDefaultToolkit().getSystemClipboard()
					.getData(DataFlavor.stringFlavor);
			login.Log4j.info(Clipboard_data);
			if (Clipboard_data.equals(DiscriptionTxt)) {
				login.Log4j.info("Commentary is copied to clipboard");
			} else {
				Assert.fail("Verification failed");
			}
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Paste in insight$")
	public void paste_in_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Create new View tab']", 15).click();
		WebElement Ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab__active')]//a", 10);
		new Actions(login.driver).contextClick(Ele).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='paste']", 15).click();
	}

	@Then("^Commentary visual should be pasted$")
	public void commentary_visual_should_be_pasted() throws Throwable {
		String ExpectedText = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='text-block-editor']//p", 10).getText();
		if (DiscriptionTxt.equals(ExpectedText)) {
			login.Log4j.info("Commentary visual is pasted");
		} else {
			Assert.fail("Commentary visual is not pasted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^Commentary should be cut$")
	public void commentary_should_be_cut() throws Throwable {
		WebElement GrowlPopUp = CommonFunctionality.getElementByXpath(login.driver,
				"//div[@class='growl-message-text']", 10);
		if (GrowlPopUp.isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Growl popup is not displayed");
		}
	//	CommonFunctionality.DeleteVisual();
	}

	@Then("^Commentary should be deleted$")
	public void commentary_should_be_deleted() throws Throwable {
		try {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls--right']//*[contains(text(),'Ok')]", 10).click();
		} catch (Exception e) {

		}
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath("//*[@data-name='title']")).size() == 0) {
			login.Log4j.info("visual is deleted");
		} else {
			Assert.fail("visual is not deleted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Choose Insert visual as \"([^\"]*)\"$")
	public void choose_Insert_visual_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Insert visual')]", 10).click();
		CommonFunctionality.getElementByXpath(login.driver, "//ul//li//*[contains(text(),'" + arg1 + "')]", 8).click();
	}

	@Then("^\"([^\"]*)\" visual should be created in the same view tab$")
	public void visual_should_be_created_in_the_same_view_tab(String arg1) throws Throwable {
		CommonFunctionality.wait(4000);
		if (arg1.equals("Attachments") || arg1.equals("Image") || arg1.equals("Filter") || arg1.equals("Commentary")) {
			WebElement VisualTitle = login.driver
					.findElement(By.xpath("//*[@class='view-components']//*[contains(text(),'" + arg1 + "')]"));
			if (VisualTitle.isDisplayed()) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}
		} else {
			WebElement EditVisual = login.driver.findElement(By.xpath(
					"//*[contains(@class,'insight-visual__selected')]//*[@class='visual-top-panel--left-controls']//button[1]"));
			if (EditVisual.getText().contains(arg1)) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}
		}
	//	CommonFunctionality.DeleteVisual();
	}

	@Then("^The commentary visual should be created in the same view tab$")
	public void the_commentary_visual_should_be_created_in_the_same_view_tab() throws Throwable {
		List<WebElement> CommentaryTitle = null;
		List<WebElement> PieTitle = null;
		CommonFunctionality.wait(2000);
		try {
			CommentaryTitle = login.driver.findElements(By.xpath(
					"//*[@class='visual-item-template visual-select-area text-template']//*[@data-name='title']"));
		} catch (Exception e) {
			//
		}
		if (CommentaryTitle.size() > 0) {
			for (int i = 0; i < CommentaryTitle.size(); i++) {
				if (CommentaryTitle.get(i).getText().contains("Commentary")) {
					login.Log4j.info("Commentary visual is created");
				} else {
					Assert.fail("Commentary visual is not created");
				}
			}
		} else {
			PieTitle = login.driver.findElements(By.xpath(
					"//*[@class='visual-item-template visual-select-area highcharts-group-visual']//*[@data-name='title']"));
			for (int i = 0; i < PieTitle.size(); i++) {
				if (PieTitle.get(i).getText().contains("Pie")) {
					login.Log4j.info("Pie visual is created");
				} else {
					Assert.fail("Pie visual is not created");
				}
			}
		}
	//	CommonFunctionality.DeleteVisual();
	}

	@And("^Again Right click on visual header$")
	public void again_Right_click_on_visual_header() throws Throwable {
		right_click_on_visual_header();
		// WebElement title = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[@data-name='title']", 4);
		// new Actions(login.driver).contextClick(title).build().perform();
	}

	@Then("^Copied visual should be pasted$")
	public void copied_visual_should_be_pasted() throws Throwable {
		the_commentary_visual_should_be_created_in_the_same_view_tab();
	}

	@Then("^All the contents should be removed from the visual$")
	public void all_the_contents_should_be_removed_from_the_visual() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		String Expected_Descriptn = login.driver.findElement(By.xpath("//html//body[@id='tinymce']//p")).getText();

		if (Expected_Descriptn.isEmpty()) {
			login.Log4j.info("All the contents has been removed");
		} else {
			Assert.fail("All the contents has not been removed");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^\"([^\"]*)\" options should be displayed$")
	public void options_should_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> Drop_downMenuList = login.driver
				.findElements(By.xpath("(//ul[@class='dropdown-menu'])[2]//li//span//span[@class='name-li']"));
		for (int i = 0; i < Drop_downMenuList.size(); i++) {
			String ExpectedStr = Drop_downMenuList.get(i).getText();
			if (arg1.contains(ExpectedStr)) {
				login.Log4j.info(ExpectedStr + " is displayed");
			} else {
				Assert.fail(ExpectedStr + " is not displayed");
			}
		}
		//CommonFunctionality.DeleteVisual();
	}

	@And("^Choose Download as \"([^\"]*)\"$")
	public void choose_Download_as(String arg1) throws Throwable {
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='items-wrapper']//*[contains(text(),'Download')]", 20)
				.click();
		CommonFunctionality.getElementByXpath(login.driver,
				"(//ul[@class='dropdown-menu'])[2]//li//span//*[contains(text(),'" + arg1 + "')]", 10).click();
	}

	@Then("^Download popup should be appeared with \"([^\"]*)\" tab selection$")
	public void download_popup_should_be_appeared_with_tab_selection(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		String ViewTab = login.driver.findElement(By.xpath("//*[@class='tabs__tab-item active']")).getText();
		if (ViewTab.equals(arg1)) {
			login.Log4j.info("Download popup is appeared");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 10).click();
		} else {
			Assert.fail("Download popup is not appeared");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@SuppressWarnings("deprecation")
	@And("^Create all visuals in an insight$")
	public void create_all_visuals_in_an_insight() throws Throwable {
		// CommonFunctionality.CreateNewInsight();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.linkText("My insights")).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-tab='my']", 10).click();
		CommonFunctionality.wait(5000);
		WebElement InsightName = login.driver.findElement(By.xpath(
				"//*[text()='Automation testdata (File options)']/following::a[contains(text(),'Customize')][1]"));
		 jse.executeScript("arguments[0].scrollIntoView(true);", InsightName);
		new Actions(login.driver).moveToElement(InsightName).pause(1000).build().perform();
		InsightName.click();
		try {
			//if Latest changes in your insight popup is opened then close it
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 30).click();
		} catch(Exception e) {
			//
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 30).click();

	}

	@And("^Perform \"([^\"]*)\"$")
	public void perform(String arg1) throws Throwable {
		ActualInsight_Name = "Automation_Insight";
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//li//span[contains(text(),'" + arg1 + "')]", 30).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='modal-body sphere-modal__body']//*[@type='text']", 30)
				.clear();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='modal-body sphere-modal__body']//*[@type='text']", 30)
				.sendKeys(ActualInsight_Name);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Copy Insight')]", 30).click();
	}

	@Then("^The insight should be copied successfully$")
	public void the_insight_should_be_copied_successfully() throws Throwable {
		CommonFunctionality.wait(7000);
		String ExpectedInsight_Name = login.driver
				.findElement(By.xpath("//*[@class='insight-breadcrumb--title-block text-dots']")).getText();
		if (ExpectedInsight_Name.equals(ActualInsight_Name)) {
			login.Log4j.info("Insight is copied successfully");
		} else {
			Assert.fail("Insight is not copied successfully");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Delete the created insight with all visuals$")
	public void delete_the_created_insight_with_all_visuals() throws Throwable {
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.linkText("My insights")).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-tab='my']", 10).click();
		CommonFunctionality.wait(5000);
		WebElement InsightName = login.driver.findElement(
				By.xpath("//*[text()='Automation_Insight']/following::a[contains(text(),'Customize')][1]"));
		// jse.executeScript("arguments[0].scrollIntoView(true);", InsightName);
		new Actions(login.driver).moveToElement(InsightName).pause(1000).build().perform();
		InsightName.click();
		try {
			//if Latest changes in your insight popup is opened then close it
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='movable-modal--close']", 30).click();
		} catch(Exception e) {
			//
		}
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 20).click();
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='items-wrapper']//li//span[contains(text(),'Delete')]", 20)
				.click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Delete forever')]", 20).click();
	}

	@Then("^The insight should be deleted successfully$")
	public void the_insight_should_be_deleted_successfully() throws Throwable {
		WebElement GrowlPopUp_Delete = login.driver.findElement(By.xpath("//div[@class='growl-message-text']"));
		login.Log4j.info("Growl text is for deleting insight:- " + GrowlPopUp_Delete.getText());
		if (GrowlPopUp_Delete.isDisplayed()) {
			login.Log4j.info("The insight is deleted successfully");
		} else {
			Assert.fail("The insight is not deleted ");
		}
	}

	@And("^Perform Share$")
	public void perform_Share() throws Throwable {
		// CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File
		// menu']", 30).click();
		CommonFunctionality.wait(5000);
		CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='items-wrapper']//li//span[contains(text(),'Share')]", 20)
				.click();
	}

	@Then("^Share popup should be opened$")
	public void share_popup_should_be_opened() throws Throwable {
		CommonFunctionality.wait(3000);
		if (login.driver.findElement(By.xpath("//*[@class='modal-title sphere-modal__title text-dots']"))
				.isDisplayed()) {
			login.Log4j.info("Share popup is opened");
		} else {
			Assert.fail("Share popup is not opened");
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='sphere-modal__close']", 10).click();
	}

	@And("^Perform download to excel with all views$")
	public void perform_download_to_excel_with_all_views() throws Throwable {
		CommonFunctionality.ExpandLeft();
		CommonFunctionality.wait(4000);
		List<WebElement> Views_list = login.driver
				.findElements(By.xpath("//*[@data-id='myseries'] | //*[@class='insight-page-view-tab--title']"));
		for (int i = 0; i < Views_list.size(); i++) {
			WebElement ele = Views_list.get(i);
			String ViewsText = ele.getText();
			if (!ViewsText.isEmpty()) {
				Visuals_list.add(ViewsText);
				login.Log4j.info(Visuals_list);
			}
			// jse.executeScript("arguments[0].click();", ele);
			// String innerText = (String) ((JavascriptExecutor)
			// login.driver).executeScript("return arguments[0].innerHTML",
			// Views_list.get(i).getText());
			// System.out.println(innerText);
			// Visuals_list.add(ele.getText());
			// login.Log4j.info(Visuals_list);

		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File menu']", 20).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//li//span[contains(text(),'Download')]", 20).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Views')]", 20).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='sphere-modal-controls--right']//*[contains(text(),'Download')]", 20).click();

	}

	@Then("^All visuals should be downloaded successfully$")
	public void all_visuals_should_be_downloaded_successfully() throws Throwable {
		CommonFunctionality.wait(30000);
		format = "xlsx";
		CommonFunctionality.getTheNewestFile(format);
		ReadExcelAndValidate();
		File_delete.delete();

	}

	@Then("^The visual should be deleted$")
	public void the_visual_should_be_deleted() throws Throwable {
		CommonFunctionality.wait(1500);
		if (login.driver
				.findElements(
						By.xpath("//*[@class='insight-visual insight-visual__can-hover insight-visual__selected']"))
				.size() == 0) {
			login.Log4j.info("The visual is deleted");
		} else {
			Assert.fail("The visual is not deleted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	@Then("^The popup should be closed and delete visual process should be declined$")
	public void the_popup_should_be_closed_and_delete_visual_process_should_be_declined() throws Throwable {
		CommonFunctionality.wait(1500);
		if (login.driver
				.findElement(
						By.xpath("//*[@class='insight-visual insight-visual__can-hover insight-visual__selected']"))
				.isDisplayed()) {
			login.Log4j.info("The visual is not deleted");
		} else {
			Assert.fail("The visual is deleted");
		}
		//CommonFunctionality.DeleteVisual();
	}

	void CreateViewTab() {
		// Create new View tab
		CommonFunctionality.getElementByProperty(login.driver, "ViewTab", 50).click();
	}

	void ColorValidation(String ColorEle) throws Exception {
		String ExpectedColor = Color.fromString(ColorEle).asHex();
		login.Log4j.info(ExpectedColor);
		Assert.assertEquals(CommonFunctionality.ActualColor, ExpectedColor);
		// CommonFunctionality.DeleteVisual();
	}

	void StyleSelection(String arg1, String Text_format) throws Exception {
		String style = null;
		if (Text_format.equals("italic")) {
			if (arg1.equalsIgnoreCase("Copyright")) {
				/*
				 * style = CommonFunctionality .getElementByXpath(login.driver,
				 * "//*[@class='visual-item-wrapper--text ']", 10) .getCssValue("font-style");
				 */
				style = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--credits-text']/*", 10)
						.getAttribute("style");
			} else {
				style = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 15)
						.getCssValue("font-style");
			}
		} else if (Text_format.equals("underline")) {
			if (arg1.equalsIgnoreCase("Copyright")) {
				style = CommonFunctionality
						.getElementByXpath(login.driver, "//*[@class='visual-item-wrapper--credits-text']/*", 10)
						.getAttribute("style");
			} else {
				style = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 15)
						.getCssValue("text-decoration");
			}
		}
		formatVerification(style, Text_format);
	}

	void formatVerification(String format, String arg2) throws Exception {
		login.Log4j.info("Font style is " + format);
		if (format.equals(arg2) || format.contains(arg2)) {
			login.Log4j.info("The visual title is shown in " + arg2);
		} else {
			Assert.fail("The visual title is not shown in " + arg2);
		}
		// CommonFunctionality.DeleteVisual();
	}

	void BoldFormatVerification(String arg1) throws Exception {
		Thread.sleep(2000);
		String fontWeight = null;
		if (arg1.equalsIgnoreCase("Copyright")) {
			fontWeight = login.driver.findElement(By.xpath("//*[@class='visual-item-wrapper--text ']"))
					.getCssValue("font-weight");
		} else if (arg1.equalsIgnoreCase("items")) {
			fontWeight = login.driver
					.findElement(By.xpath("//*[@class='series-edit--title series-edit--title__editable']"))
					.getCssValue("font-weight");
		} else {
			fontWeight = login.driver.findElement(By.xpath("//*[@data-name='" + arg1 + "']"))
					.getCssValue("font-weight");
		}
		login.Log4j.info(fontWeight);
		Assert.assertTrue(Integer.parseInt(fontWeight) == 700);
	}

	@SuppressWarnings("deprecation")
	void ExpandSubTitle_CheckBox() {
		CommonFunctionality.wait(1500);
		WebElement expand = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand")));
		new Actions(login.driver).pause(300).moveToElement(expand).click().build().perform();
		WebElement checkbox = CommonFunctionality.getElementByProperty(login.driver, "SubTitleCheckBox", 15);
		new Actions(login.driver).pause(300).moveToElement(checkbox).click().build().perform();

	}

	void TitleAndSubTitleValidation(String Actual, String Expected) throws Exception {
		CommonFunctionality.wait(2000);
		String titleName = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='" + Actual + "']", 30)
				.getText();
		if (titleName.equals(Expected) && !Actual.equals(titleName)) {
			login.Log4j.info("The title/sub-title is updated with " + Expected);
		} else {
			Assert.fail("The title/sub-title is NOT updated");
		}
		//CommonFunctionality.DeleteVisual();
	}

	void PopUp_validation(String arg1) {
		if (login.driver.findElements(By.className("popover--close")).size() == 0) {
			login.Log4j.info(arg1 + " popup is closed");

		} else {
			Assert.fail(arg1 + " popUp is not closed");
		}
	}

	void FontSizeValidation(String ActualValue, String ExpectedValue) throws Exception {
		login.Log4j.info("Expected value is :" + ExpectedValue);
		if (ActualValue.contains(ExpectedValue)) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Verification is failed");
		}
		// CommonFunctionality.DeleteVisual();
	}

	void AlignmentValidation(String arg1, String arg2, String arg3, List<String> ListOfalignmentValue)
			throws Exception {
		arg1 = "flex-start";
		arg2 = "center";
		arg3 = "flex-end";

		for (String ExpectedAlignment : ListOfalignmentValue) {
			if (ExpectedAlignment.contains(arg1)) {
				login.Log4j.info("The title is align to " + arg1);
			} else if (ExpectedAlignment.contains(arg2)) {
				login.Log4j.info("The title is align to " + arg2);
			} else if (ExpectedAlignment.contains(arg3)) {
				login.Log4j.info("The title is align to " + arg3);

			} else {
				Assert.fail("Verification is failed");
			}
		}
		// CommonFunctionality.DeleteVisual();
	}

	void WriteToDescription() throws InterruptedException {
		Description = "Testing Horizontal Alignment" + "\n" + " for Visual popUp " + "\n\n"
				+ " BackGround Color verification" + "\n" + "File uploading";
		SwitchToFrame();
		WebElement DescriptionTxt = CommonFunctionality.getElementByProperty(login.driver, "description", 8);
		DescriptionTxt.sendKeys(Keys.chord(Keys.CONTROL, "a"), Description);
		login.driver.switchTo().defaultContent();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Visual')]", 10).click();
	}

	void HorizontalAlign(String align, String arg1, WebElement visual_align) {
		if (align.equalsIgnoreCase(arg1)) {
			login.Log4j.info("The Visual area is aligned to " + arg1);

		} else {
			Assert.fail("Verification Failed");
		}
		// highlighting visual
		visual_align.click();
	}

	@SuppressWarnings("deprecation")
	void UnselectVisual() throws InterruptedException {
		WebElement UncheckVisual = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='visual-top-panel--content']", 20);
		new Actions(login.driver).pause(500).moveToElement(UncheckVisual).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	void BorderCheckbox() throws InterruptedException {
		WebElement checkbox = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='border-settings--toggler']/*[1]", 12);
		new Actions(login.driver).pause(500).moveToElement(checkbox).click().build().perform();
	}

	void DiscriptionValidation(String ExpectedDiscr) throws Exception {
		if (Description.equals(ExpectedDiscr)) {
			login.Log4j.info("Verification is passed");
		} else {
			Assert.fail("Text is not added to description field");
		}
		login.driver.switchTo().defaultContent();
		//CommonFunctionality.DeleteVisual();
	}

	void PasteToExcel(String ExpectedDescription) throws Throwable {
		CommonFunctionality.wait(5000);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		String Clipboard_data = (String) clipboard.getData(DataFlavor.stringFlavor);
		login.Log4j.info(Clipboard_data);
		XSSFSheet sheet;
		XSSFWorkbook wb = new XSSFWorkbook();
		File file = new File(System.getProperty("user.dir") + "\\" + "Commentary.xlsx");
		FileOutputStream fileOut = new FileOutputStream(file);

		if (file.exists()) {
			try {
				file.delete();
				login.Log4j.info(" Existing file is deleted");
				wb = new XSSFWorkbook();
				sheet = wb.createSheet("copy");

				// wb = (XSSFWorkbook) WorkbookFactory.create(file);
			} catch (Exception e) {
				// e.printStackTrace();
			}
			// sheet = wb.createSheet("Copy");
		} else {
			wb = new XSSFWorkbook();
			sheet = wb.createSheet("copy");
		}
		sheet = wb.getSheetAt(0);
		int rownum = 0;
		int columnCount = 0;
		Row row = sheet.createRow(rownum);
		Cell cell = row.createCell(columnCount);

		sheet.getRow(0).getCell(0);
		// sheet.getRow(0).getCell(0).setCellValue("Nadiya");
		CommonFunctionality.wait(2000);
		Action seriesOfActions = action.keyDown(Keys.CONTROL).sendKeys(Keys.chord(Keys.CONTROL, Clipboard_data))
				.keyUp(Keys.CONTROL).build();
		seriesOfActions.perform();
		// action.sendKeys(Keys.chord(Keys.CONTROL,"v",Clipboard_data)).build().perform();
		// action.keyDown(Keys.CONTROL).sendKeys(Clipboard_data).keyUp(Keys.CONTROL).build().perform();

		int rowcount = sheet.getLastRowNum();

		for (int i = 0; i <= rowcount; i++) {
			String ActualDes = sheet.getRow(i).getCell(0).getStringCellValue();
			if (ExpectedDescription.equalsIgnoreCase(ActualDes)) {
				login.Log4j.info(ExpectedDescription + " copied to Excel");
			} else {
				Assert.fail("Selected series are not copied to Excel");
			}
		}

		wb.write(fileOut);
		fileOut.close();

	}

	void WriteToWord(String ExpectedDescription) throws IOException {
		// Blank Document
		XWPFDocument document = new XWPFDocument();
		File file = new File(System.getProperty("user.dir") + "\\" + "Commentary.docx");
		// Write the Document in file system
		FileOutputStream fileOut = new FileOutputStream(file);
		// Create a blank spreadsheet
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText(ExpectedDescription);
		document.write(fileOut);
		fileOut.close();
		System.out.println("Commentary.docx written successully");

	}

	void readDocFile(String ExpectedDescription) {
		XWPFDocument docx = null;
		// String file = System.getProperty("user.dir")+"\\" + "Commentary.docx";
		try {
			FileInputStream fis = new FileInputStream("Commentary.docx");
			docx = new XWPFDocument(fis);
			List<XWPFParagraph> paragraphList = docx.getParagraphs();
			for (XWPFParagraph paragraph : paragraphList) {
				login.Log4j.info(paragraph.getText());
				String ActualTxt = paragraph.getText();
				if (ExpectedDescription.equals(ActualTxt)) {
					login.Log4j.info("Successfully the text is copied to word document");
				} else {
					Assert.fail("Copy the text to word document from commentary visual is failed");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void WriteToPPT(String ExpectedDescription) throws IOException {
		// creating a new empty slide show
		XMLSlideShow ppt = new XMLSlideShow();
		// creating an FileOutputStream object
		File file = new File(System.getProperty("user.dir") + "\\" + "Commentary.pptx");
		FileOutputStream fileOut = new FileOutputStream(file);
		// getting the slide master object
		XSLFSlideMaster slideMaster = ppt.getSlideMasters()[0];

		// select a layout from specified list
		XSLFSlideLayout slidelayout = slideMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);

		// creating a slide with title and content layout
		XSLFSlide slide = ppt.createSlide(slidelayout);

		// selection of title place holder
		XSLFTextShape body = slide.getPlaceholder(1);
		// clear the existing text in the slide
		body.clearText();

		// adding new paragraph
		XSLFTextParagraph paragraph = body.addNewTextParagraph();
		// formatting line 1
		XSLFTextRun run = paragraph.addNewTextRun();
		run.setText(ExpectedDescription);
		// saving the changes to a file
		ppt.write(fileOut);
		System.out.println("Written successfully");
		fileOut.close();
	}

	void ReadPPT(String ExpectedDescription) throws IOException {
		XMLSlideShow ppt;
		Boolean textMatch = false;
		try {
			FileInputStream fis = new FileInputStream("Commentary.pptx");
			ppt = new XMLSlideShow(fis);
			// CoreProperties props = ppt.getProperties().getCoreProperties();
			// String title = props.getTitle();
			// System.out.println("Title: " + title);
			for (XSLFSlide slide : ppt.getSlides()) {
				System.out.println("Starting slide...");
				XSLFShape[] shapes = slide.getShapes();

				for (XSLFShape shape : shapes) {
					String Actualtext = ((XSLFTextShape) shape).getText();

					if (ExpectedDescription.equals(Actualtext)) {
						login.Log4j.info("Text: " + Actualtext);
						textMatch = true;
						break;
					}
				}
				if (textMatch == false) {
					Assert.fail("FAIL");
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void ReadFormatData(String ExpectedDescription) throws TesseractException {
		String filepath = CommonFunctionality.theNewestFile.getPath();
		File imgFile = new File(filepath);
		ITesseract instance = new Tesseract();
		// instance.setLanguage("eng");
		instance.setDatapath(System.getProperty("user.dir") + "\\" + "TestDATA1");
		String result = instance.doOCR(imgFile);
		login.Log4j.info(result);
		login.Log4j.info(ExpectedDescription);
		if (result.toUpperCase().contains(ExpectedDescription.toUpperCase())) {
			login.Log4j.info("PASS");
			// login.Log4j.info("Commentary visual is downloaded in PNG format");
		} else {
			Assert.fail("FAIL");
			// Assert.fail("PNG format is not downloaded");
		}
	}

	void SwitchToFrame() {
		CommonFunctionality.wait(6000);
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
	}

	void ReadExcelAndValidate() throws IOException {
		// List<String> sheetNames = new ArrayList<String>();
		File file = CommonFunctionality.theNewestFile;
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		if (file.exists()) {
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				// sheetNames.add(wb.getSheetName(i));
				if (Visuals_list.contains(wb.getSheetName(i))) {
					login.Log4j.info(wb.getSheetName(i) + " is downloaded");
				} else {
					Assert.fail(wb.getSheetName(i) + " IS NOT downloaded");
				}

			}
			/*
			 * boolean bool = Visuals_list.equals(sheetNames); if (bool == true) {
			 * login.Log4j.info(sheetNames + " is downloaded"); } else {
			 * Assert.fail(sheetNames + " IS NOT downloaded"); }
			 */
		} else {
			Assert.fail(file + " doesn't exist");
		}
		fis.close();
	}

	void TitleON() throws InterruptedException {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 20).isDisplayed()) {
			login.Log4j.info("Title name is displayed");
		} else {
			Assert.fail("Verification is failed");
		}
		CommonFunctionality.DeleteVisual();
	}

	void TitleOFF() throws InterruptedException {
		if (UnCheck == true) {
			login.Log4j.info("Verification is pass");
		} else {
			Assert.fail("Title is displayed");
		}
		CommonFunctionality.DeleteVisual();
	}

	void SubtitleCheck(String arg1) throws InterruptedException {
		String sub_title = CommonFunctionality.getElementByProperty(login.driver, "subTitle", 20).getText();
		if (sub_title.equals(arg1)) {
			login.Log4j.info(sub_title + " is displayed");
		} else {
			Assert.fail(sub_title + " is NOT displayed");
		}
		CommonFunctionality.DeleteVisual();
	}

	void backgroundImage(WebElement backGroundImage) throws InterruptedException {
		CommonFunctionality.wait(2000);
		String insight_url = backGroundImage.getCssValue("background-image");
		// login.Log4j.info(insight_url);
		if (insight_url.contains("https://stage.ceicdata.com")
				|| insight_url.contains("https://insights.ceicdata.com")) {
			login.Log4j.info("Selected image is uploaded to the visual background");
		} else {
			Assert.fail("Selected image is NOT uploaded");
		}
		CommonFunctionality.DeleteVisual();
	}

	void Radius(int arg1) throws InterruptedException {
		Thread.sleep(500);
		// String radius = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[@name='visual_area_border_radius']", 10)
		// .getAttribute("aria-valuenow");
		// login.Log4j.info(radius);
		// int length = arg1 - Integer.parseInt(radius);

		for (int i = 1; i <= arg1; i++) {
			Thread.sleep(400);
			login.driver
					.findElement(By.xpath("//*[@class='spinner-control'][2]//button[contains(@class,'ui-spinner-up')]"))
					.click();
			// login.driver.findElement(By.xpath(
			// "(//*[@class='spinner-control']//button[contains(@class,'ui-spinner-up')])[3]"))
			// .click();
		}
		Thread.sleep(2000);
	}
}

