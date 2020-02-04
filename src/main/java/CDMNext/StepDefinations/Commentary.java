package CDMNext.StepDefinations;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class Commentary {
	Actions action = new Actions(login.driver);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	String Description;
	Boolean UnCheck = false;
	String ActualColor;
	 List<String> ListOfalignmentValue = new ArrayList<>();
	@And("^Go to View tab$")
	public void go_to_View_tab() throws Throwable {
		CommonFunctionality.CreateNewInsight();
		CreateViewTab();
	}

	@And("^Drag and drop commentary visual to the page$")
	public void drag_and_drop_commentary_visual_to_the_page() throws Throwable {
		String commentary = null;
		String ViewContainer = null;
		commentary = "//*[@title='Insert Commentary']//*[@class='insight-action-panel--btn-icon']//div";
		ViewContainer = "//*[@class='view-components-over--visuals']//*[@class='view-components-over--visual'][1]";
		DragAndDrop(commentary, ViewContainer);
	}

	@Then("^Commentary should be inserted$")
	public void commentary_should_be_inserted() throws Throwable {
		WebElement commentaryTitle = CommonFunctionality.getElementByProperty(login.driver,
				"TitleName", 4);
		if (commentaryTitle.isDisplayed()) {
			login.Log4j.info("Commentary visual is created");
		} else {
			Assert.fail("Commentary visual is not created");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Click on Title option on visual header$")
	public void click_on_Title_option_on_visual_header() throws Throwable {
		CreateViewTab();
		drag_and_drop_commentary_visual_to_the_page();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Title')]", 4).click();
	}

	@Then("^The Title popup should be displayed$")
	public void the_Title_popup_should_be_displayed() throws Throwable {
		WebElement TitlePopUp = CommonFunctionality.getElementByClassName(login.driver, "popover--wrapper", 4);
		if (TitlePopUp.isDisplayed()) {
			login.Log4j.info("Title popup is displayed");
		} else {
			Assert.fail("Title popup is NOT displayed");
		}
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
		CommonFunctionality.Views_list();
	}
	@And("^Add some text in the description field$")
	public void add_some_text_in_the_description_field() throws Throwable {
		CreateViewTab();
		drag_and_drop_commentary_visual_to_the_page();
		Description = "SampleText";
		ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("mce_0_ifr"));
		login.driver.switchTo().frame("mce_0_ifr");
		WebElement DescriptionTxt = CommonFunctionality.getElementByProperty(login.driver, "description", 4);
		DescriptionTxt.sendKeys(Keys.chord(Keys.CONTROL, "a"),Description);
		
	}

	@Then("^Should able to add text in the description field$")
	public void should_able_to_add_text_in_the_description_field() throws Throwable {
		String ExpectedDiscription = CommonFunctionality.getElementByProperty(login.driver, "description", 4).getText();
		if(Description.equals(ExpectedDiscription)) {
			login.Log4j.info("Verification is passed");
		} else {
			Assert.fail("Text is not added to description field");
		}
	}
	@And("^Click on visual title$")
	public void click_on_visual_title() throws Throwable {
		click_on_Title_option_on_visual_header();
	}

	@SuppressWarnings("deprecation")
	@And("^Check the box for the title name$")
	public void check_the_box_for_the_title_name() throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TitleCheckbox"))).isSelected();
	   if(checkbox == false) {
		   WebElement checkbox1 = CommonFunctionality.getElementByProperty(login.driver, "unchecked", 4);
		   new Actions(login.driver).pause(300).moveToElement(checkbox1).click().build().perform();
	   }
	}

	@Then("^The title name should reflect on the Commentary$")
	public void the_title_name_should_reflect_on_the_Commentary() throws Throwable {
	    if( CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4).isDisplayed()) {
	    	login.Log4j.info("Verification of title name is passed");
	    } else {
	    	Assert.fail("Verification is failed");
	    }
	    CommonFunctionality.Views_list();
	}
	@SuppressWarnings("deprecation")
	@And("^Uncheck the box for the title name$")
	public void uncheck_the_box_for_the_title_name() throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TitleCheckbox"))).isSelected();
		   if(checkbox == true) {
			   WebElement checkbox1 = CommonFunctionality.getElementByProperty(login.driver, "unchecked", 4);
			   new Actions(login.driver).pause(300).moveToElement(checkbox1).click().build().perform();
			   UnCheck = true;
		   } 
	}

	@Then("^No title name should display for the Commentary$")
	public void no_title_name_should_display_for_the_Commentary() throws Throwable {
		  if(UnCheck == true) {
		    	login.Log4j.info("Verification is pass");
		    } else {
		    	Assert.fail("Title is displayed");
		    }
		    CommonFunctionality.Views_list();
	}
	@And("^Check the box and enter the title name as \"([^\"]*)\"$")
	public void check_the_box_and_enter_the_title_name_as(String arg1) throws Throwable {
		check_the_box_for_the_title_name();
		login.driver.findElement(By.xpath("//*[@class='accordion-config ']//*[@name='title']")).sendKeys(arg1);
	}

	@Then("^The commentary should update the title name to \"([^\"]*)\"$")
	public void the_commentary_should_update_the_title_name_to(String arg1) throws Throwable {
		String titleName = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4).getText();
		if (titleName.equals(arg1)) {
			login.Log4j.info("The title name is updated with " + arg1);
		} else {
			Assert.fail("The title name is NOT updated");
		}
		CommonFunctionality.Views_list();
	}

	@And("^Choose text color is blue$")
	public void choose_text_color_is_blue() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver,"//*[@name='title_color']//following::div[1]" , 4).click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[contains(@class,'color-picker-selection')]//*[contains(@class,'sp-palette-row-0')]//*[@title='#2b60d0']");
		/*Thread.sleep(1000);
		WebElement Color = login.driver.findElement(By.xpath("//*[contains(@class,'color-picker-selection')][1]//*[contains(@class,'sp-palette-row-0')]//*[@title='#2b60d0']")) ;
		ActualColor = Color.getAttribute("title");
		login.Log4j.info(ActualColor);
		Color.click();*/
	    CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();

	}

	@Then("^The commentary should update the title text color as blue$")
	public void the_commentary_should_update_the_title_text_color_as_blue() throws Throwable {
     String color = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4).getCssValue("color");
     ColorValidation(color);
	}
	@And("^Choose highlight color is Orange$")
	public void choose_highlight_color_is_Orange() throws Throwable {
		WebElement highlightEle = CommonFunctionality.getElementByProperty(login.driver, "HighlightEle",4);
		highlightEle.click();
		CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "//*[contains(@class,'color-picker-selection')]//*[contains(@class,'sp-palette-row-0')]//*[@title='#fda546']");
		CommonFunctionality.getElementByClassName(login.driver, "popover--close", 4).click();
	}

	@Then("^The commentary should update the title highlight color as Orange$")
	public void the_commentary_should_update_the_title_highlight_color_as_Orange() throws Throwable {
		 String color = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4).getCssValue("background-color");
		 ColorValidation(color);
	}
	@And("^Choose \"([^\"]*)\" from the drop-down for the font size$")
	public void choose_from_the_drop_down_for_the_font_size(String arg1) throws Throwable {
		Thread.sleep(1000);
		String size = CommonFunctionality.getElementByXpath(login.driver, "//*[@name='title_font_size']", 4).getAttribute("value");
		int length = Integer.parseInt(arg1) - Integer.parseInt(size);
		
		for(int i = 1 ; i <= length ; i++) {
			Thread.sleep(500);
		   login.driver.findElement(By.xpath("(//*[contains(@class,'ui-spinner')]//button[contains(@class,'ui-spinner-up')])[1]")).click();
		}
	}

	@Then("^The commentary should update the title font as \"([^\"]*)\"$")
	public void the_commentary_should_update_the_title_font_as(String arg1) throws Throwable {
		Thread.sleep(2000);
		String Txtfont = login.driver.findElement(By.xpath("//*[@data-name='title']"))
				.getCssValue("font-size");
		login.Log4j.info(Txtfont);
		if (Txtfont.contains(arg1)) {
			login.Log4j.info("Title font size is " + arg1);
		} else {
			Assert.fail("Verification is failed");
		}
		CommonFunctionality.Views_list();
	}
	@And("^Click on B under style$")
	public void click_on_B_under_style() throws Throwable {
		WebElement bold = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("bold")));
		if (bold.getAttribute("class").contains("selected")) {
			//No need to select Bold format
		} else {
			bold.click();
		}
	}

	@Then("^The visual title should be in bold style$")
	public void the_visual_title_should_be_in_bold_style() throws Throwable {
		Thread.sleep(2000);
	    String fontWeight = login.driver.findElement(By.xpath("//*[@data-name='title']")).getCssValue("font-weight");
	    login.Log4j.info(fontWeight);
		Assert.assertTrue(Integer.parseInt(fontWeight) == 700);
		CommonFunctionality.Views_list();
	}
	@And("^Click on Italic under style$")
	public void click_on_Italic_under_style() throws Throwable {
	    CommonFunctionality.getElementByProperty(login.driver, "Italic", 4).click();
	}

	@Then("^The visual title should be in \"([^\"]*)\" style$")
	public void the_visual_title_should_be_in_style(String arg1) throws Throwable {
		//Thread.sleep(2000);
	    String Italic = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4).getCssValue("font-style");
	    formatVerification(Italic, arg1);
	}
	@And("^Click on Underlined\\(U\\) under style$")
	public void click_on_Underlined_U_under_style() throws Throwable {
		  CommonFunctionality.getElementByProperty(login.driver, "underline", 4).click();
	}

	@Then("^The visual title should be \"([^\"]*)\"$")
	public void the_visual_title_should_be(String arg1) throws Throwable {
		  String Underline = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 4).getCssValue("text-decoration");
		    formatVerification(Underline, arg1);
	}
	@And("^Click on left,center and right alignment for title$")
	public void click_on_left_center_and_right_alignment_for_title() throws Throwable {
	    List<WebElement> alignment = login.driver.findElements(By.xpath("//*[@name='title_align']"));
	    
	    for(int i = 0; i < alignment.size() ; i++ ) {
		 alignment.get(i).click();
		 String alignmentValue = login.driver.findElement(By.xpath("(//*[@class='visual-title visual-select-area visual-title--wrapper'])[1]")).getAttribute("style");
		 ListOfalignmentValue.add(alignmentValue);
	  }
	}

	@Then("^The title should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as user set$")
	public void the_title_should_align_to_and_as_user_set(String arg1, String arg2, String arg3) throws Throwable {
		 arg1 = "start";
		 arg2 = "center";
		 arg3 = "end";
		
		for (String ExpectedAlignment : ListOfalignmentValue) {
			if (ExpectedAlignment.contains(arg1) || ExpectedAlignment.contains(arg2) || ExpectedAlignment.contains(arg3) ) {
				login.Log4j.info("The title is align to "+ arg1 + " OR "+ arg2 + " OR "+ arg3 );
			} else {
				Assert.fail("Verification is failed");
			}
		}
		CommonFunctionality.Views_list();
	}
	@SuppressWarnings("deprecation")
	@And("^Check the box for sub-title$")
	public void check_the_box_for_sub_title() throws Throwable {
		CommonFunctionality.wait(1500);
		WebElement expand = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand")));
		new Actions(login.driver).pause(300).moveToElement(expand).click().build().perform();
		WebElement checkbox = CommonFunctionality.getElementByProperty(login.driver, "SubTitleCheckBox", 4);
		new Actions(login.driver).pause(300).moveToElement(checkbox).click().build().perform();
	}

	@Then("^The \"([^\"]*)\" should reflect on the Commentary$")
	public void the_should_reflect_on_the_Commentary(String arg1) throws Throwable {
	    String sub_title = CommonFunctionality.getElementByProperty(login.driver, "subTitle", 4).getText();
	    if(sub_title.equals(arg1)) {
	    	login.Log4j.info(sub_title + " is displayed");
	    } else {
	    	Assert.fail(sub_title + " is NOT displayed");
	    }
	    CommonFunctionality.Views_list();
	}
	@SuppressWarnings("deprecation")
	@And("^Uncheck the box for sub-title$")
	public void uncheck_the_box_for_sub_title() throws Throwable {
		boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SubTitleCheckBox"))).isSelected();
		   if(checkbox == true) {
			   WebElement checkbox1 = CommonFunctionality.getElementByProperty(login.driver, "SubTitleUnchecked", 4);
			   new Actions(login.driver).pause(300).moveToElement(checkbox1).click().build().perform();
			  
		   } else if(checkbox == false) {
			   //By default sub-title check box is not selected
			   login.Log4j.info("sub-title check box is not selected");
			   UnCheck = true;
		   }
	}

	@Then("^No sub-title name should be displayed$")
	public void no_sub_title_name_should_be_displayed() throws Throwable {
		 if(UnCheck == true) {
		    	login.Log4j.info("Sub title is not displayed");
		    } else {
		    	Assert.fail("Sub Title is displayed");
		    }
		    CommonFunctionality.Views_list();
	}
	@SuppressWarnings("deprecation")
	void DragAndDrop(String locator, String locator1) throws InterruptedException {
		WebElement VisualEle = CommonFunctionality.getElementByXpath(login.driver, locator, 4);
		WebElement ViewContainerlEle = CommonFunctionality.getElementByXpath(login.driver, locator1, 4);
		action.pause(500).clickAndHold(VisualEle).dragAndDrop(VisualEle, ViewContainerlEle).build().perform();
	}
	void CreateViewTab() {
		// Create new View tab
		CommonFunctionality.getElementByProperty(login.driver, "ViewTab", 4).click();
	}
	void ColorValidation(String color) throws Exception {
		String ExpectedColor = Color.fromString(color).asHex();
		login.Log4j.info(ExpectedColor);
		Assert.assertEquals(CommonFunctionality.ActualColor, ExpectedColor);
		CommonFunctionality.Views_list();
	}
	void formatVerification(String format, String arg1) throws Exception {
		login.Log4j.info("Font style is " + format);
		if (format.equals(arg1) || format.contains(arg1)) {
			login.Log4j.info("The visual title is shown in "+ format);
		} else {
			Assert.fail("The visual title is not shown in "+ format);
		}
		CommonFunctionality.Views_list();
	}
}
