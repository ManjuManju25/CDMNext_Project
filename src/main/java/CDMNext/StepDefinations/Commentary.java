package CDMNext.StepDefinations;

import java.awt.Robot;
//import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
	WebElement DescriptionTxt;
	static Boolean UnCheck = false;
	public static String ActualColor;
	List<String> ListOfalignmentValue = new ArrayList<>();
	public static String format;
	int SelectedRows;
	List<WebElement> ListOfCells;
	List<WebElement> BeforeInsert_ListOfRows;
	String var1, var2, var3, Actualcolor, DiscriptionTxt;
	List<WebElement> BeforeInsert_ListOfColumns;
	String ActualInsight_Name;
	List<String> Visuals_list = new ArrayList<>();
	
	//public static String SelectedColor;
	
	
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
		commentary = "//*[contains(@title,'insert Text')]//*[@class='insight-action-panel--btn-icon']//div";
		ViewContainer = "//*[@class='view-components-over--visuals']//*[@class='view-components-over--visual'][1]";
		DragAndDrop(commentary, ViewContainer);
	}

	@Then("^Commentary should be inserted$")
	public void commentary_should_be_inserted() throws Throwable {
		WebElement commentaryTitle = CommonFunctionality.getElementByProperty(login.driver, "commentary_visual", 4);
		if (commentaryTitle.isDisplayed()) {
			login.Log4j.info("Commentary visual is created");
		} else {
			Assert.fail("Commentary visual is not created");
		}

	}

	@And("^Click on \"([^\"]*)\" option on visual header$")
	public void click_on_option_on_visual_header(String arg1) throws Throwable {
		if (arg1.equalsIgnoreCase("Title")) {
			CommonFunctionality.getElementByProperty(login.driver, "Title_popup", 5).click();
		} else if (arg1.equalsIgnoreCase("Visual")) {
			CommonFunctionality.getElementByProperty(login.driver, "VisualEle", 5).click();
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
			Title_txt = CommonFunctionality.getElementByProperty(login.driver, "TitlePopup_title", 4).getText();
			if (Title_txt.equals(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
			click_on_X_icon_to_close_the_popup();
		} else if (arg1.equalsIgnoreCase("Table Properties")) {
			Title_txt = CommonFunctionality.getElementByProperty(login.driver, "TableProperties_popUp", 4).getText();
			if (Title_txt.equalsIgnoreCase(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
			CommonFunctionality.getElementByProperty(login.driver, "Tox_icon", 4).click();
		} else if (arg1.equals("Rename")) {
			String Rename_PopUp_txt = CommonFunctionality
					.getElementByProperty(login.driver, "Movable_modal_popup_text", 4).getText();
			if (Rename_PopUp_txt.contains(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
				CommonFunctionality.getElementByProperty(login.driver, "MovableModal_popUp_close", 4).click();

			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
		} else if (arg1.equals("Edit visual")) {
			String EditVisual_PopUp_txt = CommonFunctionality
					.getElementByProperty(login.driver, "Movable_modal_popup_text", 6).getText();
			if (EditVisual_PopUp_txt.equals(arg1)) {
				login.Log4j.info(arg1 + " popup is displayed");
				CommonFunctionality.getElementByProperty(login.driver, "MovableModal_popUp_close", 4).click();

			} else {
				Assert.fail(arg1 + " popup is NOT displayed");
			}
		}
	}

	@And("^Add some text in the description field$")
	public void add_some_text_in_the_description_field() throws Throwable {
		create_Commentary_visual();
		Description = "SampleText";
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		DescriptionTxt = CommonFunctionality.getElementByProperty(login.driver, "description", 10);
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
		CommonFunctionality.getElementByProperty(login.driver, "VisualTitle", 20).click();
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

		} else {
			
			UnCheck = true;
		}
	}

	@Then("^No title name should display for the Commentary$")
	public void no_title_name_should_display_for_the_Commentary() throws Throwable {
		TitleOFF();
	}

	@And("^Check the box and enter the title name as \"([^\"]*)\"$")
	public void check_the_box_and_enter_the_title_name_as(String arg1) throws Throwable {
		
		CommonFunctionality.getElementByProperty(login.driver, "Title_input", 8).clear();
		CommonFunctionality.getElementByProperty(login.driver, "Title_input", 8).sendKeys(arg1);
	}

	@Then("^The commentary should update the \"([^\"]*)\" name to \"([^\"]*)\"$")
	public void the_commentary_should_update_the_name_to(String arg1, String arg2) throws Throwable {
		TitleAndSubTitleValidation(arg1, arg2);
	}

	@And("^Choose text color is blue$")
	public void choose_text_color_is_blue() throws Throwable {

		CommonFunctionality.getElementByProperty(login.driver, "TitleColor", 20).click();
		WebElement element = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		ActualColor = element.getCssValue("background-color");
		login.Log4j.info("Actual color is "+ ActualColor);
		element.click();
		CommonFunctionality.wait(200);
		click_on_X_icon_to_close_the_popup();

	}

	@Then("^The commentary should update the \"([^\"]*)\" text color as blue$")
	public void the_commentary_should_update_the_text_color_as_blue(String arg1) throws Throwable {
		String color = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 20)
				.getCssValue("color");
		ColorValidation(color,ActualColor);

	}

	@And("^Choose highlight color is Orange$")
	public void choose_highlight_color_is_Orange() throws Throwable {
		WebElement highlightEle;
		CommonFunctionality.wait(500);
		try {
			highlightEle = CommonFunctionality.getElementByProperty(login.driver, "HighlightEle", 20);
			highlightEle.click();
			WebElement colorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 20);
			ActualColor = colorEle.getCssValue("background-color");
			login.Log4j.info(ActualColor);
			colorEle.click();
			CommonFunctionality.wait(100);
			click_on_X_icon_to_close_the_popup();
		} catch (Exception e) {
			highlightEle = CommonFunctionality.getElementByProperty(login.driver, "LabelsHighlightEle",
					20);
			highlightEle.click();
			CommonFunctionality.wait(500);	
			WebElement colorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 20);
			ActualColor = colorEle.getCssValue("background-color");
			login.Log4j.info(ActualColor);
			colorEle.click();
			CommonFunctionality.wait(100);
			click_on_X_icon_to_close_the_popup();
		}
	}

	@Then("^The commentary should update the \"([^\"]*)\" highlight color as Orange$")
	public void the_commentary_should_update_the_highlight_color_as_Orange(String arg1) throws Throwable {
		String backgroundColor = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 20).getCssValue("background-color");
		ColorValidation(backgroundColor,ActualColor);

	}

	@And("^Choose \"([^\"]*)\" from the drop-down for the font size$")
	public void choose_from_the_drop_down_for_the_font_size(String arg1) throws Throwable {
		
		Thread.sleep(1000);
		String size = CommonFunctionality.getElementByProperty(login.driver, "Title_font_size", 20)
				.getAttribute("value");
		int length = Integer.parseInt(arg1) - Integer.parseInt(size);

		for (int i = 1; i <= length; i++) {
			Thread.sleep(200);
			CommonFunctionality.getElementByProperty(login.driver, "FontSize_spinnerUp", 8).click();
		}
	}

	@Then("^The commentary should update the \"([^\"]*)\" font as \"([^\"]*)\"$")
	public void the_commentary_should_update_the_font_as(String arg1, String arg2) throws Throwable {
//		login.driver.navigate().refresh();
		CommonFunctionality.wait(2000);
		String Txtfont = login.driver.findElement(By.xpath("//*[@data-name='" + arg1 + "']")).getCssValue("font-size");
		login.Log4j.info(Txtfont);
		FontSizeValidation(Txtfont, arg2);

	}

	@And("^Click on Bold icon for \"([^\"]*)\"$")
	public void click_on_Bold_icon_for(String arg1) throws Throwable {
		WebElement bold = null;
		if (arg1.equalsIgnoreCase("title")) {
		
			bold = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("bold")));
		} else if (arg1.equalsIgnoreCase("Copyright")) {
			bold = CommonFunctionality.getElementByProperty(login.driver, "CopyRight_BoldFormat", 20);
		} else if (arg1.equals("Items")) {
			bold = CommonFunctionality.getElementByProperty(login.driver, "Tooltip_BoldFormat", 20);
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
		// CommonFunctionality.DeleteVisual();
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
			CommonFunctionality.getElementByProperty(login.driver, "CopyRight_underline", 15).click();
		}
	}

	@Then("^The visual \"([^\"]*)\" should be \"([^\"]*)\"$")
	public void the_visual_should_be(String arg1, String format) throws Throwable {
		StyleSelection(arg1, format);

	}

	@And("^Click on left,center and right alignment for title$")
	public void click_on_left_center_and_right_alignment_for_title() throws Throwable {
		check_the_box_for_the_title_name();
		List<WebElement> alignment = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Title_align")));

		for (int i = 0; i < alignment.size(); i++) {
			CommonFunctionality.wait(300);
			alignment.get(i).click();
			String alignmentValue = CommonFunctionality.getElementByProperty(login.driver, "VisualTitle_Alignment", 6)
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
	}

	@And("^Check the box and enter the sub-title name as \"([^\"]*)\"$")
	public void check_the_box_and_enter_the_sub_title_name_as(String arg1) throws Throwable {
		ExpandSubTitle_CheckBox();
		CommonFunctionality.getElementByProperty(login.driver, "SubTitle", 4).clear();
		CommonFunctionality.getElementByProperty(login.driver, "SubTitle", 6).sendKeys(arg1);
		CommonFunctionality.getElementByProperty(login.driver, "close_popup", 8).click();
	}

	@And("^Choose text color is blue for subtitle$")
	public void choose_text_color_is_blue_for_subtitle() throws Throwable {
		ExpandSubTitle_CheckBox();
		CommonFunctionality.getElementByProperty(login.driver, "SubTitleColorPicker", 4).click();
		WebElement colorEle = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		ActualColor = colorEle.getCssValue("background-color");
		login.Log4j.info(ActualColor);
		colorEle.click();
		CommonFunctionality.wait(200);
		click_on_X_icon_to_close_the_popup();
	
	}

	@And("^Choose highlight color is Orange for subtitle$")
	public void choose_highlight_color_is_Orange_for_subtitle() throws Throwable {
		ExpandSubTitle_CheckBox();
		WebElement highlightEle = CommonFunctionality.getElementByProperty(login.driver, "SubTitle_highlightEle", 4);
		CommonFunctionality.wait(200);
		highlightEle.click();
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "OrangeColor", 4);
		ActualColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
		CommonFunctionality.wait(500);
		click_on_X_icon_to_close_the_popup();
	}

	@And("^Choose \"([^\"]*)\" from the drop-down for the font size of subtitle$")
	public void choose_from_the_drop_down_for_the_font_size_of_subtitle(String value) throws Throwable {
		ExpandSubTitle_CheckBox();
		String size = CommonFunctionality.getElementByProperty(login.driver, "SubTitleFontSize", 8)
				.getAttribute("value");
		int length = 0;
		if (value.equals("10")) {
			length = Integer.parseInt(size) - Integer.parseInt(value);
		} else if (value.equals("20")) {
			length = Integer.parseInt(value) - Integer.parseInt(size);
		}

		for (int i = 1; i <= length; i++) {
			if (value.equals("10")) {
				CommonFunctionality.getElementByProperty(login.driver, "FontSize_uiSpinnerDown", 8).click();
			} else {
				// Histogram or pie visual
				// Select font size for sub title
				CommonFunctionality.getElementByProperty(login.driver, "FontSize_uiSpinnerUp_histogram", 8).click();
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
		List<WebElement> alignment = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SubTitle_align")));

		for (int i = 0; i < alignment.size(); i++) {
			CommonFunctionality.wait(500);
			alignment.get(i).click();
			String alignmentValue = CommonFunctionality
					.getElementByProperty(login.driver, "SubTitle_visualTitleContainer", 6).getAttribute("style");
			ListOfalignmentValue.add(alignmentValue);
		}
	}

	@Then("^The sub_title should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as user set$")
	public void the_sub_title_should_align_to_and_as_user_set(String arg1, String arg2, String arg3) throws Throwable {
		AlignmentValidation(arg1, arg2, arg3, ListOfalignmentValue);

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

		} else if (arg1.equalsIgnoreCase("title") || arg1.equalsIgnoreCase("Copyright")) {
			PopUp_validation(arg1);

		}
	}

	@SuppressWarnings("deprecation")
	@And("^Double click on the visual title/subtitle$")
	public void double_click_on_the_visual_title_subtitle() throws Throwable {
		click_on_edit_commentary_icon();
		check_the_box_for_the_title_name();
		CommonFunctionality.wait(3000);
		WebElement title = CommonFunctionality.getElementByProperty(login.driver, "VisualTitle", 4);
		new Actions(login.driver).pause(300).doubleClick(title).build().perform();
	}

	@Then("^The title popup should be appeared$")
	public void the_title_popup_should_be_appeared() throws Throwable {
		if (CommonFunctionality.getElementByClassName(login.driver, "popover--title", 4).isDisplayed()) {
			login.Log4j.info("Title popup is displayed");
		} else {
			Assert.fail("Title popUp is not displayed");
		}

	}

	@SuppressWarnings("deprecation")
	@And("^Click on edit commentary icon$")
	public void click_on_edit_commentary_icon() throws Throwable {
		//click_on_visual_title();
		//check_the_box_for_the_title_name();
		WebElement title = CommonFunctionality.getElementByProperty(login.driver, "EditCommentaryIcon", 4);
		new Actions(login.driver).pause(500).moveToElement(title).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "EditCommentaryIcon", 4).click();

	}

	@Then("^By default Horizontal align should be disabled$")
	public void by_default_Horizontal_align_should_be_disabled() throws Throwable {
		WebElement DefaultHorizontal_Align = CommonFunctionality.getElementByProperty(login.driver, "HorizontalAlign",
				4);
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

	}

	@Then("^Select Horizontal align of visual to \"([^\"]*)\"$")
	public void select_Horizontal_align_of_visual_to(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
		click_on_X_icon_to_close_the_popup();
		// UnselectVisual();
	}

	@Then("^The Visual area should be align to \"([^\"]*)\"$")
	public void the_Visual_area_should_be_align_to(String arg1) throws Throwable {
		WebElement visual_align = null;
		try {
			// commentary visual align
			visual_align = CommonFunctionality.getElementByProperty(login.driver, "CommentaryVisualAlign", 20);
		} catch (Exception e) {

			// Attachments visual align
			visual_align = CommonFunctionality.getElementByProperty(login.driver, "AttachmentsTemplate", 20);

		}
		if (arg1.equalsIgnoreCase("Left")) {
			String left = visual_align.getAttribute("x-align");
			if (left.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			// click on visual header
			CommonFunctionality.getElementByProperty(login.driver, "VisualEle", 20).click();

		}
		if (arg1.equalsIgnoreCase("Center")) {
			String center = visual_align.getAttribute("x-align");
			if (center.equalsIgnoreCase(arg1)) {
				login.Log4j.info("The Visual area is aligned to " + arg1);

			} else {
				Assert.fail("Verification Failed");
			}
			// click on visual header
			CommonFunctionality.getElementByProperty(login.driver, "VisualEle", 20).click();
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

	}

	@And("^Check for Background$")
	public void check_for_Background() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "VisualBackground", 20).click();
	}

	@Then("^By default \"([^\"]*)\" should be disabled$")
	public void by_default_should_be_disabled(String arg1) throws Throwable {
		WebElement byDefaultVisualEle = null;
		if (arg1.equals("Background")) {
			byDefaultVisualEle = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("VisualBackgroundOptions")));

		} else if (arg1.equals("Border")) {
			byDefaultVisualEle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("VisualBorderOPtions")));

		}
		if (byDefaultVisualEle.getAttribute("class").contains("disabled")) {
			login.Log4j.info("By default " + arg1 + " is disabled");
		} else {
			Assert.fail("By default " + arg1 + " is not disabled");
		}

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

		WebElement checkbox = CommonFunctionality.getElementByProperty(login.driver, "VisualBackgroundCheckBox", 20);
		new Actions(login.driver).pause(500).moveToElement(checkbox).click().build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='color-picker-control']/*[1]", 20).click();
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		ActualColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
		click_on_X_icon_to_close_the_popup();
		UnselectVisual();

	}

	@Then("^Selected color should be applied to the visual background$")
	public void selected_color_should_be_applied_to_the_visual_background() throws Throwable {
	//	UnselectVisual();
		String Background_color = CommonFunctionality.getElementByProperty(login.driver, "VisualItemTemplate", 20)
				.getCssValue("background-color");
		ColorValidation(Background_color,ActualColor);

	}

	@SuppressWarnings("deprecation")
	@And("^Click on browse > Select image for visual background$")
	public void click_on_browse_Select_image_for_visual_background() throws Throwable {
		WebElement checkbox = CommonFunctionality.getElementByProperty(login.driver, "VisualBackgroundCheckBox", 20);
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
		WebElement backGroundImage = CommonFunctionality.getElementByProperty(login.driver, "VisualItemTemplate", 8);
		backgroundImage(backGroundImage);

	}

	@And("^Click on remove icon for uploaded image$")
	public void click_on_remove_icon_for_uploaded_image() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "BackGroundImageRemove", 30).click();
	}

	@Then("^The uploaded image should be removed$")
	public void the_uploaded_image_should_be_removed() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ImageUploaded"))).size() == 0) {
			login.Log4j.info("Uploaded image is removed");
		} else {
			Assert.fail("Uploaded image is NOT removed");
		}

		// after refresh the page deleted visuals are displaying so throwing technical
		// error for 35 & 36 tc's
		// Delete the insight
		login.driver.navigate().refresh();
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 30).click();
		CommonFunctionality.getElementByProperty(login.driver, "Delete", 30).click();
		CommonFunctionality.getElementByProperty(login.driver, "Delete_forever", 30).click();
		CommonFunctionality.DeleteVisual();

	}

	@And("^Check for Border$")
	public void check_for_Border() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "VisualBorder", 20).click();
	}

	@And("^Select color for visual border$")
	public void select_color_for_visual_border() throws Throwable {
		BorderCheckbox();
		CommonFunctionality.getElementByProperty(login.driver, "Border_colorPickerControl", 20).click();
		WebElement ColorEle = CommonFunctionality.getElementByProperty(login.driver, "BlueColor", 20);
		ActualColor = ColorEle.getCssValue("background-color");
		ColorEle.click();
		click_on_X_icon_to_close_the_popup();
		UnselectVisual();
	}

	@Then("^The visual border should be changed as per the selection$")
	public void the_visual_border_should_be_changed_as_per_the_selection() throws Throwable {
		//UnselectVisual();
		String border_color = CommonFunctionality.getElementByProperty(login.driver, "VisualItemTemplate", 20)
				.getCssValue("border-color");
		ColorValidation(border_color, ActualColor);

	}

	@And("^Select border width (\\d+) for visual border$")
	public void select_border_width_for_visual_border(int arg1) throws Throwable {
		BorderCheckbox();
		// String BorderWidth = CommonFunctionality
		// .getElementByXpath(login.driver, "//*[@name='visual_area_border_width']", 20)
		// .getAttribute("aria-valuenow");
		// int length = arg1 - Integer.parseInt(BorderWidth);

		for (int i = 1; i <= arg1; i++) {

			CommonFunctionality.getElementByProperty(login.driver, "Border_uiSpinnerUp", 8).click();
		}
	}

	@Then("^\"([^\"]*)\" should be updated to \"([^\"]*)\"$")
	public void should_be_updated_to(String arg1, String arg2) throws Throwable {
		click_on_X_icon_to_close_the_popup();
		UnselectVisual();

		if (arg1.equals("Width")) {
			String ActualWidth;
			try {
				// border width for commentary visual
				ActualWidth = CommonFunctionality.getElementByProperty(login.driver, "VisualItemTemplate", 8)
						.getCssValue("border-width");
			} catch (Exception e) {
				try {
					// border width for attachment visual
					ActualWidth = CommonFunctionality.getElementByProperty(login.driver, "AttachmentsTemplate", 8)
							.getCssValue("border-width");
				} catch (Exception e1) {
					// border width for filter visual
					ActualWidth = CommonFunctionality.getElementByProperty(login.driver, "FilterVisualTemplate", 8)
							.getCssValue("border-width");
				}
			}
			login.Log4j.info(ActualWidth);
			FontSizeValidation(ActualWidth, arg2);
		} else if (arg1.equalsIgnoreCase("Radius")) {
			String ActualRadius;
			try {
				// Radius for commentary visual
				ActualRadius = CommonFunctionality.getElementByProperty(login.driver, "VisualItemTemplate", 8)
						.getCssValue("border-radius");
			} catch (Exception e) {
				try {
					// Radius for Attachment visual
					ActualRadius = CommonFunctionality.getElementByProperty(login.driver, "AttachmentsTemplate", 8)
							.getCssValue("border-radius");
				} catch (Exception e1) {
					// Radius for filter visual
					ActualRadius = CommonFunctionality.getElementByProperty(login.driver, "FilterVisualTemplate", 8)
							.getCssValue("border-radius");
				}
			}
			login.Log4j.info("Actual value is :" + ActualRadius);
			FontSizeValidation(ActualRadius, arg2);
		}

	}

	@And("^Tick checkbox for border and choose radius as (\\d+)$")
	public void tick_checkbox_for_border_and_choose_radius_as(int arg1) throws Throwable {

		BorderCheckbox();
		Radius(arg1);
	}

	@And("^Tick checkbox for border and choose different border as \"([^\"]*)\"$")
	public void tick_checkbox_for_border_and_choose_different_border_as(String arg1) throws Throwable {
		BorderCheckbox();
		CommonFunctionality.getElementByProperty(login.driver, "BorderDropdown", 20).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 20).click();
	}

	@Then("^The \"([^\"]*)\" border should be applied to the visual$")
	public void the_border_should_be_applied_to_the_visual(String arg1) throws Throwable {
		click_on_X_icon_to_close_the_popup();
		UnselectVisual();
		String BorderStyle;
		try {
			// Select border style for commentary visual
			BorderStyle = CommonFunctionality.getElementByProperty(login.driver, "VisualItemTemplate", 8)
					.getCssValue("border-style");
		} catch (Exception e) {
			try {
				// Select border style for attachments visual
				BorderStyle = CommonFunctionality.getElementByProperty(login.driver, "AttachmentsTemplate", 8)
						.getCssValue("border-style");
			} catch (Exception e1) {
				// Select border style for filter visual
				BorderStyle = CommonFunctionality.getElementByProperty(login.driver, "FilterVisualTemplate", 8)
						.getCssValue("border-style");
			}

		}
		login.Log4j.info("Actual value is " + BorderStyle);
		FontSizeValidation(BorderStyle, arg1);

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
			CommonFunctionality.getElementByProperty(login.driver, "CopyIcon", 12).click();
		} catch (Exception e) {
			// click on copy icon in expanded image visual window
			CommonFunctionality.getElementByProperty(login.driver, "CopyIcon_expandedImageVisualwindow", 12).click();
			CommonFunctionality.getElementByProperty(login.driver, "closebuttoninpopup", 12).click();
		}
	}

	@And("^Paste within the insight$")
	public void paste_within_the_insight() throws Throwable {
		CreateViewTab();
		WebElement ActiveViewEle = CommonFunctionality.getElementByProperty(login.driver, "ViewTab_ActiveEle", 20);
		// contextClick() method to do right click on the element
		action.contextClick(ActiveViewEle).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "PasteVisual", 20).click();
	}

	@Then("^The visual should be pasted in the insight$")
	public void the_visual_should_be_pasted_in_the_insight() throws Throwable {
		CommonFunctionality.wait(1000);
		try {
			// paste commentary visual
			String ExpectedDiscription = CommonFunctionality
					.getElementByProperty(login.driver, "DescriptionFrom_PastedCommentaryVisual", 20).getText();
			DiscriptionValidation(ExpectedDiscription);
		} catch (Exception e) {
			// paste Histogram/pie visual
			String ActualText = CommonFunctionality.getElementByProperty(login.driver, "VisualTitle", 15)
					.getText();
			if (ActualText.equals(Histogram.Visual_Title_txt) || ActualText.equals(PieVisual.Visual_Title_txt) ) {
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
		// CommonFunctionality.wait(2000);
		WebElement ViewTabEle = CommonFunctionality.getElementByProperty(login.driver, "ViewTabEleInNewInsiaght", 8);
		ViewTabEle.click();
		// contextClick() method to do right click on the element
		action.pause(500).contextClick(ViewTabEle).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "PasteVisual", 20).click();
	}

	@Then("^The visual should be pasted to new insight$")
	public void the_visual_should_be_pasted_to_new_insight() throws Throwable {
		the_visual_should_be_pasted_in_the_insight();
	}

	@Then("^Paste in Excel and the text should be pasted to excel$")
	public void paste_in_Excel_and_the_text_should_be_pasted_to_excel() throws Throwable {
		PasteToExcel(Description);

	}

	@Then("^Paste in word and the text should be pasted in word file$")
	public void paste_in_word_and_the_text_should_be_pasted_in_word_file() throws Throwable {
		WriteToWord(Description);
		readDocFile(Description);

	}

	@Then("^Paste in ppt and the text should be pasted PPT$")
	public void paste_in_ppt_and_the_text_should_be_pasted_PPT() throws Throwable {
		WriteToPPT(Description);
		ReadPPT(Description);

	}

	@And("^Click on Download icon$")
	public void click_on_Download_icon() throws Throwable {
		CommonFunctionality.wait(2000);
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

	}

	@Then("^Commentary should be downloaded in \"([^\"]*)\" format$")
	public void commentary_should_be_downloaded_in_format(String arg1) throws Throwable {
		// commentary_should_be_downloaded_in_PNG_format();
		CommonFunctionality.wait(3000);
		CommonFunctionality.getTheNewestFile(format);
		ReadFormatData(Description);
		File_delete.delete();

	}

	@Then("^Drop down should be opened with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void drop_down_should_be_opened_with_and(String arg1, String arg2) throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> dropDown_list = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Add_to_insights_options")));
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

	}

	@Then("^The insight should be opened and added visual should be available in My visual$")
	public void the_insight_should_be_opened_and_added_visual_should_be_available_in_My_visual() throws Throwable {
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		CommonFunctionality.getElementByProperty(login.driver, "view1", 10).click();
		try {
			String ActualText = CommonFunctionality
					.getElementByProperty(login.driver, "DescriptionFrom_PastedCommentaryVisual", 15).getText();
			if (ActualText.equals(Description)) {
				login.Log4j.info("Commentary visual is created in new insiaght");
			} else {
				Assert.fail("Commentary visual is not created ");
			}
		} catch (Exception e) {
			String ActualText = CommonFunctionality.getElementByProperty(login.driver, "VisualTitle", 15)
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

	}

	@Then("^\"([^\"]*)\" popup should be dispalyed$")
	public void popup_should_be_dispalyed(String arg1) throws Throwable {
		String confirm_popUp;
		if (arg1.equals("Confirmation")) {
			confirm_popUp = CommonFunctionality.getElementByProperty(login.driver, "ConfirmationPopup", 10).getText();
			if (confirm_popUp.equals(arg1)) {
				login.Log4j.info(arg1 + " is displayed");
				CommonFunctionality.getElementByProperty(login.driver, "confirmation_Ok", 8).click();
			} else {
				Assert.fail(arg1 + " is not displayed");
			}
		} else if (arg1.equals("Do you want to remove this visual?")) {
			confirm_popUp = CommonFunctionality.getElementByProperty(login.driver, "cant_apply_function_msg", 10)
					.getText();

			if (confirm_popUp.contains(arg1)) {
				login.Log4j.info(arg1 + " is displayed");
				CommonFunctionality.getElementByProperty(login.driver, "confirmation_Ok", 10).click();
			} else {
				Assert.fail(arg1 + " is not displayed");
			}
		}

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
			CommonFunctionality.wait(500);
			login.driver.switchTo().defaultContent();
			CommonFunctionality.wait(1000);
			WebElement dropdown = CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']/*[2]", 15);
			action.moveToElement(dropdown).clickAndHold().pause(300).release(dropdown).build().perform();
		} else if (arg1.equalsIgnoreCase("Font Sizes")) {
			// select the data
			login.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "a");
			login.driver.switchTo().defaultContent();
			CommonFunctionality.wait(2000);
			WebElement dropdown = CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']/*[1]", 15);
//			action.doubleClick(dropdown).build().perform();
			dropdown.click();
		} else if (arg1.equals("Table")) {
			WebElement more = CommonFunctionality.getElementByXpath(login.driver,"//*[@title='More...']",10);
			action.clickAndHold(more).pause(300).release().build().perform();
			CommonFunctionality.wait(2500);
			WebElement table_dropdown = CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15);
			table_dropdown.click();
		}

	}
	@And("^Click on \"([^\"]*)\" drop down from More dropdown$")
	public void click_on_drop_down_from_More_dropdown(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		WebElement table_dropdown = CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15);
		table_dropdown.click();
	}


	@Then("^\"([^\"]*)\" table options should be available$")
	public void table_options_should_be_available(String arg1) throws Throwable {
		String[] str = arg1.split(",");
		CommonFunctionality.wait(1500);
		List<WebElement> TableOptions = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("TableOptions")));
		int i = 0;
		if(TableOptions.size() > 0) {
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
		}else {
			Assert.fail("Table option size is zero");
		}

	}

	@SuppressWarnings("deprecation")
	@And("^Create table$")
	public void create_table() throws Throwable {
		WebElement ele = null;
		CommonFunctionality.getElementByProperty(login.driver, "SelectTable_fromTableDropdown", 15).click();
		List<WebElement> listOfRows = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("SelectListOfRows")));
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
				.findElements(By.xpath(login.LOCATORS.getProperty("CreatedListOfRows")));
		if (SelectedRows + 1 == Aft_tab_cretn_ListOfRows.size()) {
			login.Log4j.info("Table is created");
		} else {
			Assert.fail("Table is not created");
		}
		login.driver.switchTo().defaultContent();

	}

	@And("^Set \"([^\"]*)\" for table \"([^\"]*)\"$")
	public void set_for_table(String arg1, String arg2) throws Throwable {
		if (arg1.equalsIgnoreCase("width")) {
			CommonFunctionality.getElementByProperty(login.driver, "Table_width", 15).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Table_width", 15).sendKeys(arg2);

		} else if (arg1.equalsIgnoreCase("height")) {
			CommonFunctionality.getElementByProperty(login.driver, "Table_height", 15).sendKeys(arg2);
		} else if (arg1.equalsIgnoreCase("cell spacing")) {
			CommonFunctionality.getElementByProperty(login.driver, "Table_cellSpacing", 15).sendKeys(arg2);
		} else if (arg1.equalsIgnoreCase("cell padding")) {
			CommonFunctionality.getElementByProperty(login.driver, "Table_cellPadding", 15).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Table_cellPadding", 15).sendKeys(arg2);
		}
		CommonFunctionality.getElementByProperty(login.driver, "TableSave", 15).click();
	}

	@Then("^The table \"([^\"]*)\" should be displayed as \"([^\"]*)\"$")
	public void the_table_should_be_displayed_as(String arg1, String arg2) throws Throwable {
		Boolean ResultMatch = false;
		CommonFunctionality.wait(2000);
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		String ExpectedValue = arg2;
		if (arg1.equalsIgnoreCase("width") || arg1.equalsIgnoreCase("height")) {
			String str = CommonFunctionality.getElementByProperty(login.driver, "commentary_table", 8)
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
			String Actual_Value = CommonFunctionality.getElementByProperty(login.driver, "commentary_table", 8)
					.getAttribute("style");
			String[] border_space = Actual_Value.split("border-spacing:");

			if (border_space[1].trim().contains(ExpectedValue)) {
				login.Log4j.info("The table " + arg1 + " is " + border_space[1].trim());

			} else {
				Assert.fail("The table " + arg1 + " is not matched");
			}
		} else if (arg1.equalsIgnoreCase("cell padding")) {
			String Actual_Value = CommonFunctionality.getElementByProperty(login.driver, "CellPadding", 8)
					.getCssValue("padding");

			if (Actual_Value.contains(ExpectedValue)) {
				login.Log4j.info("The table " + arg1 + " is " + arg2);

			} else {
				Assert.fail("The table " + arg1 + " is not matched");
			}
		}

		login.driver.switchTo().defaultContent();

	}

	@And("^Click on Open icon$")
	public void click_on_Open_icon() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "OpenIcon", 15).click();
	}

	@Then("^The visual should be displayed in maximized window$")
	public void the_visual_should_be_displayed_in_maximized_window() throws Throwable {
		if (CommonFunctionality.getElementByProperty(login.driver, "MaximizedWindow", 4).isDisplayed()) {
			login.Log4j.info("The visual is displayed in maximized window");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 15).click();
		} else {
			Assert.fail("Fail");
		}

	}

	@And("^Click on x icon to close$")
	public void click_on_x_icon_to_close() throws Throwable {
		try {
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 15).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByProperty(login.driver, "MovableModal_popUp_close", 4).click();
		}
	}

	@Then("^The modal window should be closed$")
	public void the_modal_window_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);
		if ((login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ModalWindowClosed"))).size()) == 0) {
			login.Log4j.info("The modal window is closed");
		} else {
			Assert.fail("Fail");
		}

	}

	@SuppressWarnings("deprecation")
	@And("^Check Caption for table$")
	public void check_Caption_for_table() throws Throwable {
		WebElement CaptioncheckBox = CommonFunctionality.getElementByProperty(login.driver, "Table_caption_checkbox",
				4);
		new Actions(login.driver).pause(300).moveToElement(CaptioncheckBox).click().build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "TableSave", 15).click();
	}

	@Then("^Caption should be added to the table$")
	public void caption_should_be_added_to_the_table() throws Throwable {
		SwitchToFrame();
		WebElement caption = CommonFunctionality.getElementByProperty(login.driver, "TableCaption", 10);
		if (caption.isDisplayed()) {
			login.Log4j.info("Caption is added to table");
		} else {
			Assert.fail("Caption is not added");
		}
		login.driver.switchTo().defaultContent();

	}

	@And("^Uncheck caption for table$")
	public void uncheck_caption_for_table() throws Throwable {
		String arg = "Table";
		String arg1 = "Table properties";
		check_Caption_for_table();
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		WebElement caption = CommonFunctionality.getElementByProperty(login.driver, "TableCaption", 10);
		if (caption.isDisplayed()) {
			login.driver.switchTo().defaultContent();
			//click_on_drop_down(arg);
			WebElement table_dropdown = CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg + "']", 15);
			table_dropdown.click();
			st.click_on(arg1);
			check_Caption_for_table();

		}
	}

	@Then("^Caption shoud be removed$")
	public void caption_shoud_be_removed() throws Throwable {
		SwitchToFrame();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("TableCaption"))).size() == 0) {
			login.Log4j.info("Caption is removed");
		} else {
			Assert.fail("Caption is not removed");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^The table properties popup should be closed$")
	public void the_table_properties_popup_should_be_closed() throws Throwable {
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Table_properties_popup"))).size() == 0) {
			login.Log4j.info("The table properties popup is closed");
		} else {
			Assert.fail("The table properties popup is not closed");
		}

	}

	@Then("^The table should be deleted from the visual$")
	public void the_table_should_be_deleted_from_the_visual() throws Throwable {
		SwitchToFrame();
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Table_deleted"))).size() == 0) {
			login.Log4j.info("The table is deleted");
		} else {
			Assert.fail("The table is not deleted");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^The Cell properties popup should be displayed$")
	public void the_Cell_properties_popup_should_be_displayed() throws Throwable {
		CommonFunctionality.wait(500);
		if (CommonFunctionality.getElementByProperty(login.driver, "CellPropertiesPopup", 15).isDisplayed()) {
			CommonFunctionality.getElementByProperty(login.driver, "Tox_icon", 15).click();
			login.Log4j.info("Cell properties popup is displayed");
		} else {
			Assert.fail("Cell properties popup is not displayed");
		}

	}

	@And("^Select cells to merge$")
	public void select_cells_to_merge() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		ListOfCells = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SelectListOfCells")));
		// login.Log4j.info("Before splitting total no of cell " + ListOfCells.size());
		new Actions(login.driver).clickAndHold(ListOfCells.get(0)).keyDown(Keys.CONTROL).release(ListOfCells.get(1))
				.keyUp(Keys.CONTROL).build().perform();
		login.driver.switchTo().defaultContent();
	}

	@Then("^The selected cells should be merged$")
	public void the_selected_cells_should_be_merged() throws Throwable {
		SwitchToFrame();
		String str = CommonFunctionality.getElementByProperty(login.driver, "selectedCellsMerged", 8)
				.getAttribute("colspan");
		Integer colspan = Integer.parseInt(str);
		if (colspan == 2) {
			login.Log4j.info("Selected cells is merged");
		} else {
			Assert.fail("Selected cells not merged");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^The cell should be split the cell$")
	public void the_cell_should_be_split_the_cell() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		List<WebElement> AfterSplit_ListOfCells = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("SelectListOfCells")));
		if (ListOfCells.size() == AfterSplit_ListOfCells.size()) {
			login.Log4j.info("The cell is splited");
		} else {
			Assert.fail("The cell is not splited");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^The row should be insertd before the selected table$")
	public void the_row_should_be_insertd_before_the_selected_table() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		List<WebElement> ListOfRows = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ListOfRows")));
		if (ListOfRows.size() > BeforeInsert_ListOfRows.size()) {
			login.Log4j.info("The row is inserted");
		} else {
			Assert.fail("The row is not inserted");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^The row should be insertd after selected the table$")
	public void the_row_should_be_insertd_after_selected_the_table() throws Throwable {
		the_row_should_be_insertd_before_the_selected_table();
	}

	@And("^Verify row count$")
	public void verify_row_count() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		BeforeInsert_ListOfRows = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ListOfRows")));
		login.driver.switchTo().defaultContent();
	}

	@Then("^The selected row should be deleted$")
	public void the_selected_row_should_be_deleted() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ListOfRows"))).size() == 0) {
			login.Log4j.info("The row is deleted");
		} else {
			Assert.fail("The row is not deleted");
		}
		login.driver.switchTo().defaultContent();

	}

	@And("^Enter text in a cell$")
	public void enter_text_in_a_cell() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.getElementByProperty(login.driver, "EnterText_cell", 15).sendKeys("Nadiya");
		login.driver.switchTo().defaultContent();
	}

	@And("^Apply \"([^\"]*)\" as \"([^\"]*)\"$")
	public void apply_as(String arg1, String arg2) throws Throwable {

		switch (arg1) {
		case "Row type":
			var1 = arg2;
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']/*[1]", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 15).click();
			break;
		case "Alignment":
			var2 = arg2;
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']/*[1]", 4).click();
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 15).click();
			break;
		case "Height":
			var3 = arg2;
			CommonFunctionality.getElementByProperty(login.driver, "Row_height", 15).sendKeys(arg2);
			break;
		default:

		}

	}

	@Then("^Applied properties should be display$")
	public void applied_properties_should_be_display() throws Throwable {
		WebElement ele = null;
		CommonFunctionality.getElementByProperty(login.driver, "TableSave", 15).click();
		SwitchToFrame();
		if (var1.equalsIgnoreCase("Footer")) {
			if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_footer"))).isDisplayed()) {
				login.Log4j.info("Row type is " + var1);
			} else {
				Assert.fail("Row type is not " + var1);
			}
		}
		if (var2.equalsIgnoreCase("Right")) {
			ele = CommonFunctionality.getElementByProperty(login.driver, "Table_footer_right", 15);
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
				.findElements(By.xpath(login.LOCATORS.getProperty("CreatedListOfRows")));
		login.driver.switchTo().defaultContent();
	}

	@Then("^The column should be inserted before selected column$")
	public void the_column_should_be_inserted_before_selected_column() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		List<WebElement> ListOfColumns = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("CreatedListOfRows")));
		if (ListOfColumns.size() > BeforeInsert_ListOfColumns.size()) {
			login.Log4j.info("The Column is inserted");
		} else {
			Assert.fail("The Column is not inserted");
		}
		login.driver.switchTo().defaultContent();

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
				.findElements(By.xpath(login.LOCATORS.getProperty("CreatedListOfRows")));
		if (ListOfColumns.size() < BeforeInsert_ListOfColumns.size()) {
			login.Log4j.info("The Column is deleted");
		} else {
			Assert.fail("The Column is not deleted");
		}
		login.driver.switchTo().defaultContent();

	}

	@And("^Choose font size as \"([^\"]*)\"$")
	public void choose_font_size_as(String arg1) throws Throwable {

		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='" + arg1 + "']", 15).click();

	}

	@Then("^Text should be changed to \"([^\"]*)\" size$")
	public void text_should_be_changed_to_size(String arg1) throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		WebElement TextEle = CommonFunctionality.getElementByProperty(login.driver, "TextEle", 8);
		CommonFunctionality.wait(2000);
		login.Log4j.info(TextEle.getCssValue("font-size"));
		if (TextEle.getCssValue("font-size").equals(arg1)) {
			login.Log4j.info("The text size is matched with the applied size as " + arg1);
		} else {
			Assert.fail("The text size is not matched with the " + arg1);
		}
		login.driver.switchTo().defaultContent();

	}

	@And("^Choose text color as \"([^\"]*)\"$")
	public void choose_text_color_as(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		// Actualcolor =
		// login.driver.findElement(By.xpath("//table//tbody//tr[3]//td[1]//div"))
		// .getCssValue("background-color");
		CommonFunctionality.getElementByXpath(login.driver, "//div[@title='#FF0000']", 15).click();
		CommonFunctionality.wait(1000);
	}

	@Then("^The Text should be changed to \"([^\"]*)\"$")
	public void the_Text_should_be_changed_to(String arg1) throws Throwable {
		String ExpectedColor = "#ff0000";
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		try {
			WebElement TextEle = CommonFunctionality.getElementByProperty(login.driver, "TextEle", 8);
			CommonFunctionality.wait(2000);
			String colorEle = TextEle.getCssValue("color");
			String ActualColor = Color.fromString(colorEle).asHex();
			login.Log4j.info(ActualColor);
			Assert.assertEquals(ActualColor, ExpectedColor);
			// login.Log4j.info(TextEle.getCssValue("background-color"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * if (TextEle.getCssValue("color").equals(Actualcolor.trim())) {
		 * login.Log4j.info("The text color is " + arg1); } else if
		 * (TextEle.getCssValue("background-color").equals(Actualcolor)) {
		 * login.Log4j.info("The text color is " + arg1); } else {
		 * Assert.fail("The text color is not matched with " + arg1); }
		 */
		login.driver.switchTo().defaultContent();

	}

	@Then("^The background of text should be changed to \"([^\"]*)\"$")
	public void the_background_of_text_should_be_changed_to(String arg1) throws Throwable {
		String ExpectedColor = "#ff0000";
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		try {
			WebElement TextEle = CommonFunctionality.getElementByProperty(login.driver, "TextEle", 8);
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
		if(arg1.equalsIgnoreCase("Align left")) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='More...']", 15).click();
		}
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']", 15);
		//action.doubleClick(ele).build().perform();
		ele.click();
	}

	@Then("^Title should align to \"([^\"]*)\"$")
	public void title_should_align_to(String arg1) throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		WebElement TextEle = CommonFunctionality.getElementByProperty(login.driver, "TitleTextalign", 8);
		CommonFunctionality.wait(2000);
		login.Log4j.info(TextEle.getCssValue("text-align"));
		if (TextEle.getCssValue("text-align").equalsIgnoreCase(arg1)) {
			login.Log4j.info("The text is align to " + arg1);
		} else {
			Assert.fail("The text is not align to " + arg1);
		}
		login.driver.switchTo().defaultContent();


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
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Selected_list"))).size() > 0) {
			login.Log4j.info("Bullet list is displayed");
		} else if (login.driver.findElements(By.xpath("//html//body[@id='tinymce']//ol")).size() > 0) {
			login.Log4j.info("Number list is displayed");
		} else {
			Assert.fail("Selected list is not displayed");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^Selected text should be moved as per the selection$")
	public void selected_text_should_be_moved_as_per_the_selection() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		String Increase_indent = CommonFunctionality.getElementByProperty(login.driver, "TitleTextalign", 15)
				.getAttribute("style");
		login.Log4j.info(Increase_indent);
		if (Increase_indent.contains("40px")) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Verification failed");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^The text should be changed to \"([^\"]*)\"$")
	public void the_text_should_be_changed_to(String arg1) throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Text_format"))).size() == 1) {
			login.Log4j.info("The text is displayed in " + arg1);
		} else if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Text_format1"))).size() == 1) {
			login.Log4j.info("The text is displayed in " + arg1);

		} else {
			Assert.fail("The text is not displayed in " + arg1 + " format");
		}
		login.driver.switchTo().defaultContent();

	}

	@And("^Select image$")
	public void select_image() throws Throwable {
		CommonFunctionality.wait(2000);
		
		//To run on local machine
		 // creating object of Robot class
	    Robot rb = new Robot();
	 
	    // copying File path to Clipboard
	    StringSelection str = new StringSelection("C:\\Users\\NadiyaMaduru\\OneDrive - SHRAVAS TECHNOLOGIES INDIA PRIVATE LIMITED\\Documents\\CDMNextAutomation\\Cucumber_project\\AutoIT\\Shravas.png");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
	 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    //To run on uit machines
//		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
//				System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
//				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		
		CommonFunctionality.wait(5000);
	}

	@Then("^Selected image should be uploaded$")
	public void selected_image_should_be_uploaded() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		WebElement Image = CommonFunctionality.getElementByProperty(login.driver, "Selected_image", 8);

		if (Image.isDisplayed()) {
			login.Log4j.info("Selected image is uploaded to the visual");
		} else {
			Assert.fail("Selected image is NOT uploaded");
		}
		login.driver.switchTo().defaultContent();

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
		CommonFunctionality.wait(2000);
		try {
		WebElement title = CommonFunctionality.getElementByProperty(login.driver, "VisualTitleName", 6);
		new Actions(login.driver).pause(500).contextClick(title).build().perform();
		}catch(Exception e) {
			WebElement title = CommonFunctionality.getElementByProperty(login.driver, "VisualTitle", 6);
			new Actions(login.driver).pause(500).contextClick(title).build().perform();
		}
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
		WebElement GrowlPopUp = CommonFunctionality.getElementByProperty(login.driver, "growl_popup", 4);
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

	}

	@And("^Paste in insight$")
	public void paste_in_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "ViewTab", 15).click();
		WebElement Ele = CommonFunctionality.getElementByProperty(login.driver, "ViewTabActive", 10);
		new Actions(login.driver).contextClick(Ele).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "SelectPaste", 15).click();
	}

	@Then("^Commentary visual should be pasted$")
	public void commentary_visual_should_be_pasted() throws Throwable {
		String ExpectedText = CommonFunctionality
				.getElementByProperty(login.driver, "DescriptionFrom_PastedCommentaryVisual", 10).getText();
		if (DiscriptionTxt.equals(ExpectedText)) {
			login.Log4j.info("Commentary visual is pasted");
		} else {
			Assert.fail("Commentary visual is not pasted");
		}

	}

	@Then("^Commentary should be cut$")
	public void commentary_should_be_cut() throws Throwable {
		WebElement GrowlPopUp = CommonFunctionality.getElementByProperty(login.driver, "growl_popup", 10);
		if (GrowlPopUp.isDisplayed()) {
			login.Log4j.info("PASS");
		} else {
			Assert.fail("Growl popup is not displayed");
		}

	}

	@Then("^Commentary should be deleted$")
	public void commentary_should_be_deleted() throws Throwable {
		try {
			CommonFunctionality.getElementByProperty(login.driver, "commentary_delete_ok", 10).click();
		} catch (Exception e) {

		}
		CommonFunctionality.wait(2000);
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("VisualTitle"))).size() == 0) {
			login.Log4j.info("visual is deleted");
		} else {
			Assert.fail("visual is not deleted");
		}

	}

	@And("^Choose Add chart as \"([^\"]*)\"$")
	public void choose_Add_chart_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Add_chart", 10).click();
		switch(arg1) {
		case "Chart" :
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'icon--chart-line_large')]", 8).click();
			break;
		
		case "Map":
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'icon--map-filled_large')]", 8).click();
			break;
		case "Table":
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'icon--table-vertical_large')]", 8).click();
			break;
		case "Heat map":
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'icon--heatmap_large')]", 8).click();
			break;
		case "Histogram":
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'icon--histogram_large')]", 8).click();
			try {
				//if confirmation popup is displayed
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[contains(text(),'Ok')]", 8).click();
			}catch(Exception e) {
				
			}
			break;
		case "Pie":
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'icon--pie_chart-pie_large')]", 8).click();
			break;
		default:
				Assert.fail("failed due to xpath got changed");
	}
		
	}

	@Then("^\"([^\"]*)\" visual should be created in the same view tab$")
	public void visual_should_be_created_in_the_same_view_tab(String arg1) throws Throwable {
		
		if (arg1.equals("Attachments") ||  arg1.equals("Filter")) {
			CommonFunctionality.wait(4000);
			WebElement VisualTitle = login.driver
					.findElement(By.xpath("//*[@class='view-components']//*[contains(text(),'" + arg1 + "')]"));
			if (VisualTitle.isDisplayed()) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}
		} else if(arg1.equals("Commentary")){
			CommonFunctionality.wait(4000);
			WebElement VisualTitle = login.driver
					.findElement(By.xpath("//*[@class='visual-item-template visual-select-area text-template']"));
//			login.Log4j.info(VisualTitle.getText());
			if (VisualTitle.isDisplayed()) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}
		}
		else if(arg1.equals("Image")){
			CommonFunctionality.wait(4000);
			WebElement VisualTitle = login.driver
					.findElement(By.xpath("//*[contains(@class,'image-template')]"));

			if (VisualTitle.isDisplayed()) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}
		}else {
			CommonFunctionality.wait(4000);
			String EditVisualText = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditVisual"))).getText();
			if (EditVisualText.contains(arg1)) {
				login.Log4j.info(arg1 + " visual is created");
			} else {
				Assert.fail(arg1 + " visual is not created");
			}
		}

	}

	@Then("^The commentary visual should be created in the same view tab$")
	public void the_commentary_visual_should_be_created_in_the_same_view_tab() throws Throwable {
		List<WebElement> CreatedCommentaryVisuals = null;
		List<WebElement> VisualTitle = null;
		CommonFunctionality.wait(2000);
		try {
			CreatedCommentaryVisuals = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("VisualItemTemplate")));
		} catch (Exception e) {
			//
		}
		if (CreatedCommentaryVisuals.size() > 0) {
			for (int i = 0; i < CreatedCommentaryVisuals.size(); i++) {
				if (CreatedCommentaryVisuals.get(i).isDisplayed()) {
					login.Log4j.info("Commentary visual is created/pasted");
				} else {
					Assert.fail("Commentary visual is not created/pasted");
				}
			}
		} else {
			VisualTitle = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("PieVisual_title")));
			for (int i = 0; i < VisualTitle.size(); i++) {
				if (VisualTitle.get(i).getText().contains("Pie")) {
					login.Log4j.info("Pie visual is created");
				} else if(VisualTitle.get(i).getText().contains("Map")){
					login.Log4j.info("Map visual is created");
				}else {
					Assert.fail(VisualTitle.get(i).getText() + " visual is not created");
				}
			}
		}

	}

	@And("^Again Right click on visual header$")
	public void again_Right_click_on_visual_header() throws Throwable {
		CommonFunctionality.wait(5000);
		right_click_on_visual_header();
		// WebElement title = CommonFunctionality.getElementByXpath(login.driver,
		// "//*[@data-name='title']", 4);
		// new Actions(login.driver).contextClick(title).build().perform();
	}

	@Then("^Copied visual should be pasted$")
	public void copied_visual_should_be_pasted() throws Throwable {
		the_commentary_visual_should_be_created_in_the_same_view_tab();
		/*CommonFunctionality.wait(2000);
		List<WebElement> No_OfVisuals = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("visuals")));
		if(No_OfVisuals.size() == 2)	{
			login.Log4j.info("Commentary visual is pasted");
				
				
		}else {
			Assert.fail("Commentary visual is not pasted");
		}*/
	}

	@Then("^All the contents should be removed from the visual$")
	public void all_the_contents_should_be_removed_from_the_visual() throws Throwable {
		SwitchToFrame();
		CommonFunctionality.wait(2000);
		String Expected_Descriptn = CommonFunctionality.getElementByProperty(login.driver, "TitleTextalign", 8)
				.getText();

		if (Expected_Descriptn.isEmpty()) {
			login.Log4j.info("All the contents has been removed");
		} else {
			Assert.fail("All the contents has not been removed");
		}
		login.driver.switchTo().defaultContent();

	}

	@Then("^\"([^\"]*)\" options should be displayed$")
	public void options_should_be_displayed(String arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> Drop_downMenuList = login.driver
				.findElements(By.xpath(login.LOCATORS.getProperty("Dropdown_menuList")));
		for (int i = 0; i < Drop_downMenuList.size(); i++) {
			String ExpectedStr = Drop_downMenuList.get(i).getText();
			if (arg1.contains(ExpectedStr)) {
				login.Log4j.info(ExpectedStr + " is displayed");
			} else {
				Assert.fail(ExpectedStr + " is not displayed");
			}
		}

	}

	@And("^Choose Download as \"([^\"]*)\"$")
	public void choose_Download_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "DownloadCommentary", 20).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"(//ul[@class='dropdown-menu'])[2]//li//span//*[contains(text(),'" + arg1 + "')]", 10).click();
	}

	@Then("^Download popup should be appeared with \"([^\"]*)\" tab selection$")
	public void download_popup_should_be_appeared_with_tab_selection(String arg1) throws Throwable {

		String ViewTab = CommonFunctionality.getElementByProperty(login.driver, "linksActive", 8).getText();
		if (ViewTab.equals(arg1)) {
			login.Log4j.info("Download popup is appeared");
			CommonFunctionality.getElementByClassName(login.driver, "sphere-modal__close", 10).click();
		} else {
			Assert.fail("Download popup is not appeared");
		}

	}

	@SuppressWarnings("deprecation")
	@And("^Create all visuals in an insight$")
	public void create_all_visuals_in_an_insight() throws Throwable {
		// CommonFunctionality.CreateNewInsight();
		CommonFunctionality.wait(2000);
		login.driver.findElement(By.linkText("My insights")).click();
		CommonFunctionality.getElementByProperty(login.driver, "MyInsights_created", 10).click();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByProperty(login.driver, "SearchWithInsight", 10)
				.sendKeys("Automation testdata (File options)");
		CommonFunctionality.wait(2000);
		WebElement InsightName = CommonFunctionality.getElementByProperty(login.driver, "ExpectedInsightName", 8);
		// jse.executeScript("arguments[0].scrollIntoView(true);", InsightName);
		new Actions(login.driver).moveToElement(InsightName).pause(1000).build().perform();
		CommonFunctionality.getElementByProperty(login.driver, "Customize", 10).click();
		
		try {
			// if Latest changes in your insight popup is opened then close it
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MovableModal_popUp_close"))).click();
		} catch (Exception e) {
			//
		}
		

	}

	@And("^Perform \"([^\"]*)\"$")
	public void perform(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 30).click();
		ActualInsight_Name = "Automation_Insight";
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='items-wrapper']//li//span[contains(text(),'" + arg1 + "')]", 30).click();
		CommonFunctionality.getElementByProperty(login.driver, "InputText_copyInsightPopup", 30).clear();
		CommonFunctionality.getElementByProperty(login.driver, "InputText_copyInsightPopup", 30)
				.sendKeys(ActualInsight_Name);
		CommonFunctionality.getElementByProperty(login.driver, "CopyInsighthButton", 30).click();
	}

	@Then("^The insight should be copied successfully$")
	public void the_insight_should_be_copied_successfully() throws Throwable {
		CommonFunctionality.wait(7000);
		String ExpectedInsight_Name = CommonFunctionality.getElementByProperty(login.driver, "selectedgrowl_popup", 8)
				.getText();
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
		CommonFunctionality.getElementByProperty(login.driver, "MyInsights_created", 10).click();
		CommonFunctionality.wait(5000);
		WebElement InsightName = CommonFunctionality.getElementByProperty(login.driver, "CreatedInsiaght", 8);
		// jse.executeScript("arguments[0].scrollIntoView(true);", InsightName);
		new Actions(login.driver).moveToElement(InsightName).pause(1000).build().perform();
		InsightName.click();
		try {
			// if Latest changes in your insight popup is opened then close it
			CommonFunctionality.getElementByProperty(login.driver, "MovableModal_popUp_close", 30).click();
		} catch (Exception e) {
			//
		}
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "OPenFileOptions_delete", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "Delete_forever", 20).click();
	}

	@Then("^The insight should be deleted successfully$")
	public void the_insight_should_be_deleted_successfully() throws Throwable {
		CommonFunctionality.wait(500);
		WebElement GrowlPopUp_Delete = CommonFunctionality.getElementByProperty(login.driver, "growl_popup", 8);
		login.Log4j.info("Growl text is for deleting insight:- " + GrowlPopUp_Delete.getText());
		if (GrowlPopUp_Delete.isDisplayed()) {
			login.Log4j.info("The insight is deleted successfully");
		} else {
			Assert.fail("The insight is not deleted ");
		}
	}

	@And("^Perform Share$")
	public void perform_Share() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 30).click();
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByProperty(login.driver, "OpenFileOptions_share", 20).click();
	}

	@Then("^Share popup should be opened$")
	public void share_popup_should_be_opened() throws Throwable {
		CommonFunctionality.wait(3000);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sharepopup"))).isDisplayed()) {
			login.Log4j.info("Share popup is opened");
		} else {
			Assert.fail("Share popup is not opened");
		}
		CommonFunctionality.getElementByProperty(login.driver, "Name_Insight_Close", 10).click();
	}

	@And("^Perform download to excel with all views$")
	public void perform_download_to_excel_with_all_views() throws Throwable {
		CommonFunctionality.ExpandLeft();
		CommonFunctionality.getElementByProperty(login.driver, "FileMenu", 30).click();
		CommonFunctionality.wait(2000);
		List<WebElement> Views_list = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ViewsList")));
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
		// CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Open File
		// menu']", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "OpenFileOptions_download", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "DownloadWindow_SelectViewsTab", 20).click();
		CommonFunctionality.getElementByProperty(login.driver, "DownloadButton_inDownloadPopup", 20).click();

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
		if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Insight_deleted"))).size() == 0) {
			login.Log4j.info("The visual is deleted");
		} else {
			Assert.fail("The visual is not deleted");
		}

	}

	@Then("^The popup should be closed and delete visual process should be declined$")
	public void the_popup_should_be_closed_and_delete_visual_process_should_be_declined() throws Throwable {
		CommonFunctionality.wait(1500);
		if (login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insight_deleted"))).isDisplayed()) {
			login.Log4j.info("The visual is not deleted");
		} else {
			Assert.fail("The visual is deleted");
		}

	}

	void CreateViewTab() {
		// Create new View tab
		CommonFunctionality.getElementByProperty(login.driver, "ViewTab", 50).click();
	}

	public static void ColorValidation(String ExpectedColorEle , String SelectedColor) throws Exception {
	
		String ExpectedColor = Color.fromString(ExpectedColorEle).asHex();
		login.Log4j.info(ExpectedColor);
		String AppliedColor = Color.fromString(SelectedColor).asHex();
		login.Log4j.info(AppliedColor);
		Assert.assertEquals(AppliedColor, ExpectedColor);

	}

	void StyleSelection(String arg1, String Text_format) throws Exception {
		String style = null;
		if (Text_format.equals("italic")) {
			if (arg1.equalsIgnoreCase("Copyright")) {
				/*
				 * style = CommonFunctionality .getElementByXpath(login.driver,
				 * "//*[@class='visual-item-wrapper--text ']", 10) .getCssValue("font-style");
				 */
				style = CommonFunctionality.getElementByProperty(login.driver, "style_format", 10)
						.getAttribute("style");
			} else {
				style = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='" + arg1 + "']", 15)
						.getCssValue("font-style");
			}
		} else if (Text_format.equals("underline")) {
			if (arg1.equalsIgnoreCase("Copyright")) {
				style = CommonFunctionality.getElementByProperty(login.driver, "style_format", 10)
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

	}

	void BoldFormatVerification(String arg1) throws Exception {
		Thread.sleep(2000);
		String fontWeight = null;
		if (arg1.equalsIgnoreCase("Copyright")) {
			fontWeight = CommonFunctionality.getElementByProperty(login.driver, "Edit_table_copyright_Changename", 8)
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

	}

	void WriteToDescription() throws InterruptedException {
		CommonFunctionality.wait(1000);
		Description = "Testing Horizontal Alignment" + "\n" + " for Visual popUp " + "\n\n"
				+ " BackGround Color verification" + "\n" + "File uploading";
		SwitchToFrame();
		WebElement DescriptionTxt = CommonFunctionality.getElementByProperty(login.driver, "description", 8);
		DescriptionTxt.sendKeys(Keys.chord(Keys.CONTROL, "a"), Description);
		login.driver.switchTo().defaultContent();
		CommonFunctionality.getElementByProperty(login.driver, "VisualEle", 10).click();
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
		WebElement UncheckVisual = CommonFunctionality.getElementByProperty(login.driver, "UnselectVisual", 20);
		new Actions(login.driver).pause(500).moveToElement(UncheckVisual).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	void BorderCheckbox() throws InterruptedException {
		WebElement checkbox = CommonFunctionality.getElementByProperty(login.driver, "BorderCheckBox", 12);
		new Actions(login.driver).pause(500).moveToElement(checkbox).click().build().perform();
	}

	void DiscriptionValidation(String ExpectedDiscr) throws Exception {
		if (Description.equals(ExpectedDiscr)) {
			login.Log4j.info("Verification is passed");
		} else {
			Assert.fail("Text is not added to description field");
		}
		login.driver.switchTo().defaultContent();

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
		//CommonFunctionality.DeleteVisual();
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
