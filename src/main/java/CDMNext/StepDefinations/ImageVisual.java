package CDMNext.StepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import Javaxlxs.File_delete;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class ImageVisual {
	Commentary com = new Commentary();
	Attachments attachment = new Attachments();
	String Edit_title, sourceUrl, title;
	String dimension1, dimension2;
	List<String> ListOfalignmentValue = new ArrayList<>();
	String observation_count ;
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;

	@And("^Click on insert Image visual icon$")
	public void click_on_insert_Image_visual_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-instance='image']", 20).click();
		try {
			Boolean ImageTitle = login.driver.findElement(By.xpath("//*[@data-name='title']")).isDisplayed();
			if (ImageTitle == true) {
				login.Log4j.info("Image visual is created");
			}
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@data-instance='image']", 20).click();
		}
	}

	@And("^Select \"([^\"]*)\" icon$")
	public void select_icon(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + arg1 + "']/*", 20).click();
	}

	@And("^Upload any image$")
	public void upload_any_image() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		CommonFunctionality.wait(8000);
	}

	@Then("^The image visual should be pasted to new insight$")
	public void the_image_visual_should_be_pasted_to_new_insight() throws Throwable {
		CommonFunctionality.wait(2000);
		Boolean image = login.driver.findElement(By.xpath("//*[@title='Shravas.png']")).isDisplayed();
		if (image == true) {
			login.Log4j.info("Image visual is pasted ");
		} else {
			Assert.fail("Image visual is not pasted ");
		}
	}

	@Then("^Below optins should be available$")
	public void below_optins_should_be_available(List<String> list) throws Throwable {

		String arg1 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='mce-widget mce-btn mce-first']", 20)
				.getAttribute("aria-label");
		String arg2 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='mce-widget mce-btn mce-last']", 20)
				.getAttribute("aria-label");
		String arg3 = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='mce-txt']", 20).getText();
		String arg4 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='mce-widget mce-btn mce-first']", 20)
				.getAttribute("aria-label");
		String arg5 = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='mce-widget mce-btn']", 20)
				.getAttribute("aria-label");
		String arg6 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='mce-widget mce-btn mce-last']", 20)
				.getAttribute("aria-label");

		if (list.contains(arg1) && list.contains(arg2) && list.contains(arg3) && list.contains(arg4)
				&& list.contains(arg5) || list.contains(arg6)) {
			login.Log4j.info(arg1 + " AND " + arg2 + " AND " + arg3 + " AND " + arg4 + " AND " + arg5 + " AND " + arg6
					+ " options are displayed");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@Then("^The image visual should be pasted in vew tab on current insight$")
	public void the_image_visual_should_be_pasted_in_vew_tab_on_current_insight() throws Throwable {
		List<WebElement> views = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
		if (views.size() > 1) {
			CommonFunctionality.wait(1200);
			WebElement element = login.driver.findElement(By.tagName("iframe"));
			login.driver.switchTo().frame(element);
			Boolean img = login.driver.findElement(By.xpath("//html//body[@class='mce-content-body ']//p/img"))
					.isDisplayed();
			login.driver.switchTo().defaultContent();
			if (img == true) {
				login.Log4j.info("The Image visual is created in view tab");
			} else {
				Assert.fail("The Image visual is not created in view tab");
			}

		}
	}

	@Then("^The image visual should be added to new insight$")
	public void the_image_visual_should_be_added_to_new_insight() throws Throwable {
		ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
		login.driver.switchTo().window(tabs2.get(1));
		CommonFunctionality.getElementByXpath(login.driver, "//a[@title='View 1']", 10).click();
		CommonFunctionality.wait(1200);
		Boolean img = login.driver.findElement(By.xpath("//*[@class='text-block-editor']//img")).isDisplayed();

		if (img == true) {
			login.Log4j.info("The Image visual is created in view tab");
		} else {
			Assert.fail("The Image visual is not created in view tab");
		}
		CommonFunctionality.DeleteVisual();
		login.driver.close();
		login.driver.switchTo().window(tabs2.get(0));

	}

	@Then("^The image visual should be pasted in the other view tab$")
	public void the_image_visual_should_be_pasted_in_the_other_view_tab() throws Throwable {
		Boolean img = login.driver.findElement(By.xpath("//*[@class='text-block-editor']//img")).isDisplayed();

		if (img == true) {
			login.Log4j.info("The Image visual is pasted in view tab");
		} else {
			Assert.fail("The Image visual is not pasted in view tab");
		}
	}

	@Then("^Edit the title name as \"([^\"]*)\"$")
	public void edit_the_title_name_as(String arg1) throws Throwable {
		Edit_title = arg1;
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='accordion-config ']//*[@name='title']", 20)
				.clear();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='accordion-config ']//*[@name='title']", 20)
				.sendKeys(arg1);

	}

	@Then("^The title name should reflect on the Image$")
	public void the_title_name_should_reflect_on_the_Image() throws Throwable {
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 20).getText()
				.equalsIgnoreCase(Edit_title)) {
			login.Log4j.info("Updated title name is displayed");
		} else {
			Assert.fail("Verification is failed");
		}

	}

	@Then("^The subtitle should update as \"([^\"]*)\"$")
	public void the_subtitle_should_update_as(String arg1) throws Throwable {
		String titleName = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='sub_title']", 30)
				.getText();
		if (titleName.equals(arg1)) {
			login.Log4j.info("The sub-title is updated with " + arg1);
		} else {
			Assert.fail("The sub-title is NOT updated");
		}
	}

	@And("^Click on title dropdown$")
	public void click_on_title_dropdown() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, " //*[@data-popup='title']/*[2]", 30).click();
	}

	@Then("^The Image visual should update the \"([^\"]*)\" text color as blue$")
	public void the_Image_visual_should_update_the_text_color_as_blue(String arg1) throws Throwable {
		attachment.the_Attachments_should_update_the_text_color_as_blue(arg1);
	}

	@Then("^The Image visual should update the \"([^\"]*)\" highlight color as Orange$")
	public void the_Image_visual_should_update_the_highlight_color_as_Orange(String arg1) throws Throwable {
		attachment.the_Attachments_should_update_the_highlight_color_as_Orange(arg1);
	}

	@Then("^The Image visual should update the \"([^\"]*)\" font as \"([^\"]*)\"$")
	public void the_Image_visual_should_update_the_font_as(String arg1, String arg2) throws Throwable {
		attachment.the_Attachments_should_update_the_font_as(arg1, arg2);
	}

	@Then("^Image should be downloaded in \"([^\"]*)\" format$")
	public void image_should_be_downloaded_in_format(String arg1) throws Throwable {
		CommonFunctionality.getTheNewestFile(arg1);
		File_delete.delete();
	}

	@And("^Try to Upload multiple images$")
	public void try_to_Upload_multiple_images() throws Throwable {
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
		select_icon("Upload image");
		CommonFunctionality.wait(2000);
		CommonFunctionality.uploadTheFileusingAutoIT(login.driver,
				System.getProperty("user.dir") + "\\AutoIT\\UploadFile.exe",
				System.getProperty("user.dir") + "\\AutoIT\\Screenshot.png");
		CommonFunctionality.wait(8000);
	}

	@Then("^Should allow to add multiple images$")
	public void should_allow_to_add_multiple_images() throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> list_images = login.driver.findElements(By.xpath("//*[@class='text-block-editor']//p//img"));
		if (list_images.size() > 1) {
			login.Log4j.info("Multiple images uploaded");
		} else {
			Assert.fail("Unable to upload multiple images");
		}
	}

	@Then("^Below options should be available in General tab$")
	public void below_options_should_be_available_in_General_tab(List<String> list) throws Throwable {
		CommonFunctionality.wait(500);
		List<WebElement> generalTab_options = login.driver.findElements(By.xpath(
				"//*[@class='mce-container mce-form mce-abs-layout-item mce-first']//*[@class='mce-widget mce-label mce-abs-layout-item mce-first']"));
		int j = 0;
		for (int i = 0; i <= generalTab_options.size();) {
			login.Log4j.info(generalTab_options.get(i).getText().trim());
			for (String arg : list) {
				if (generalTab_options.get(i).getText().trim().equals(arg.trim())) {
					login.Log4j.info(arg + " is displayed");
					i = j + 1;
					break;
				} else {
					Assert.fail("Verification failed");
				}
			}
		}

		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='mce-close']", 30).click();
	}

	@And("^select uplod tab$")
	public void select_uplod_tab() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='mce-tabs']/*[2]", 30).click();
	}

	@Then("^Below options should be available in Upload tab$")
	public void below_options_should_be_available_in_Upload_tab(List<String> list) throws Throwable {
		String arg1 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='mce-reset']/*[2]/*[2]/*[2]/*[3]//button//*", 20)
				.getText();
		String arg2 = CommonFunctionality
				.getElementByXpath(login.driver, "//*[@class='mce-reset']/*[2]/*[2]/*[2]/*[3]/*[1]/*[3]/*", 20)
				.getText();
		for (String str : list) {
			if (str.equalsIgnoreCase(arg1)) {
				login.Log4j.info(arg1 + " is displayed");
			} else if (str.equalsIgnoreCase(arg2)) {
				login.Log4j.info(arg2 + " is displayed");
			} else {
				Assert.fail("Verification failed");
			}
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='mce-close']", 30).click();
	}

	@Then("^Image should be uploaded in view tab$")
	public void image_should_be_uploaded_in_view_tab() throws Throwable {
		CommonFunctionality.wait(1000);
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		Boolean img = login.driver.findElement(By.xpath("//html//body[@class='mce-content-body ']//p/img"))
				.isDisplayed();
		login.driver.switchTo().defaultContent();
		if (img == true) {
			login.Log4j.info("The Image visual is created in view tab");
		} else {
			Assert.fail("The Image visual is not created in view tab");
		}
	}

	@And("^click on cross mark button$")
	public void click_on_cross_mark_button() throws Throwable {
		// close insert/edit or upload image popup
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='mce-close']", 30).click();
	}

	@Then("^Window should be closed$")
	public void window_should_be_closed() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='mce-close']")).size() == 0) {
			login.Log4j.info("Pass");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^Enter Source as \"([^\"]*)\"$")
	public void enter_Source_as(String arg1) throws Throwable {
		sourceUrl = arg1;
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='mce-combobox mce-filepicker mce-abs-layout-item mce-last']//input", 30)
				.sendKeys(arg1);
	}

	@And("^Enter Image Title as \"([^\"]*)\"$")
	public void enter_Image_Title_as(String arg1) throws Throwable {
		title = arg1;
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='mce-container mce-abs-layout-item mce-formitem']//input", 30).sendKeys(arg1);
	}

	@And("^Enter Dimensions as (\\d+) and (\\d+)$")
	public void enter_Dimensions_as_and(int arg1, int arg2) throws Throwable {
		dimension1 = Integer.toString(arg1);
		dimension2 = Integer.toString(arg2);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='mce-container mce-abs-layout-item mce-last mce-formitem']/*[1]/*[3]/*[1]/*[2]", 30)
				.sendKeys(dimension1);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[@class='mce-container mce-abs-layout-item mce-last mce-formitem']/*[1]/*[3]/*[1]/*[4]", 30)
				.sendKeys(dimension2);
		CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='mce-container mce-panel mce-foot']//*[contains(text(),'Ok')]", 30).click();
	}

	@Then("^Image should be uploaded in view tab with given details$")
	public void image_should_be_uploaded_in_view_tab_with_given_details() throws Throwable {
		CommonFunctionality.wait(1200);
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		String source = CommonFunctionality
				.getElementByXpath(login.driver, "//html//body[@class='mce-content-body ']//p/img", 20)
				.getAttribute("src");
		String imageTitle = CommonFunctionality
				.getElementByXpath(login.driver, "//html//body[@class='mce-content-body ']//p/img", 20)
				.getAttribute("title");
		String dimension_width = CommonFunctionality
				.getElementByXpath(login.driver, "//html//body[@class='mce-content-body ']//p/img", 20)
				.getAttribute("width");
		String dimension_height = CommonFunctionality
				.getElementByXpath(login.driver, "//html//body[@class='mce-content-body ']//p/img", 20)
				.getAttribute("height");
		login.driver.switchTo().defaultContent();
		if (source.contains(sourceUrl) && imageTitle.equalsIgnoreCase(title)
				&& dimension_width.equalsIgnoreCase(dimension1) && dimension_height.equalsIgnoreCase(dimension2)) {
			login.Log4j.info("Image is uploaded successfully with given details");
		} else {
			Assert.fail("Verification failed");
		}

	}

	@And("^Click on \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\" alignment for image visual$")
	public void click_on_and_alignment_for_image_visual(String arg1, String arg2, String arg3) throws Throwable {
		Alignvisual(arg1);
		Alignvisual(arg2);
		Alignvisual(arg3);
	}

	@Then("^The image visual should align to \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" as user set$")
	public void the_image_visual_should_align_to_and_as_user_set(String arg1, String arg2, String arg3)
			throws Throwable {
		arg1 = "left";
		arg2 = "center";
		arg3 = "right";
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

	@And("^Create a Chart visual$")
	public void create_a_Chart_visual() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-action='line']", 4).click();
	}

	@And("^Add a series to the chart visual$")
	public void add_a_series_to_the_chart_visual() throws Throwable {
		CommonFunctionality.webDriverwait_keyvalue("Series_new");
		CommonFunctionality.getElementByProperty(login.driver, "Series_new", 8).click();
		CommonFunctionality.webDriverwait_keyvalue("Series_checkbox");
		WebElement series_cb = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_checkbox")));
		WebElement selected = CommonFunctionality.getElementByXpath(login.driver,
				"//ul[@class='search-series-list']/li[1]", 8);
		if (!(selected.getAttribute("class").contains("series-list-item__selected"))) {
			new Actions(login.driver).moveToElement(series_cb).pause(4000).click().build().perform();
		}
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 30).click();
	}
	@And("^Select timeframe as \"([^\"]*)\"$")
	public void select_timeframe_as(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 30).click();
		//observation_count = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='input-observation']/*[1]", 30).getText();
		
	}

	@And("^Select Data placement as \"([^\"]*)\"$")
	public void select_Data_placement_as(String arg1) throws Throwable {
		boolean radio_button = login.driver
				.findElement(By.xpath("//*[@data-format='rows']//*[@class='input-control--indicator']")).isSelected();
		if (radio_button == false) {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@data-format='rows']//*[@class='input-control--indicator']", 30).click();
		}
	}

	@Then("^Image with visuals should be downloaded with selected timeframe and data placement$")
	public void image_with_visuals_should_be_downloaded_with_selected_timeframe_and_data_placement() throws Throwable {
		CommonFunctionality.wait(15000);
		CommonFunctionality.getTheNewestFile("xlsx");
		File file = CommonFunctionality.theNewestFile;
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		XSSFRow row = null;
		//XSSFCell cell = null;
		List<String> list = new ArrayList<>();
		if (file.exists()) {
			// login.Log4j.info(wb.getNumberOfSheets());
			List lst = wb.getAllPictures();
			// login.Log4j.info(lst.size());
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				login.Log4j.info(wb.getSheetName(i));
				if (wb.getSheetName(i).equalsIgnoreCase("View 1") && wb.getSheetName(i).length() > 0) {
					if (lst.size() > 0) {
						login.Log4j.info(lst);
						// if(lst.contains("image1.png ") && lst.contains("image2.png ") ) {
						/*
						 * for (Iterator it = lst.iterator(); it.hasNext();) { PictureData pict =
						 * (PictureData) it.next(); String ext = pict.suggestFileExtension();
						 * 
						 * byte[] data = pict.getData(); login.Log4j.info(data[0]); }
						 */
						login.Log4j.info(wb.getSheetName(i) + " tab is downloaded with visuals");
						// }
					}
				} else if (wb.getSheetName(i).equalsIgnoreCase("My Series")) {
					sheet = wb.getSheet("My Series");
					// Making the object of excel row
					row = sheet.getRow(0);
					// login.Log4j.info(sheet.getRow(0).getCell(1)) ;
					if (sheet.getRow(0).getCell(1).getStringCellValue().equalsIgnoreCase("Region")) {
						login.Log4j.info("Data placement is woking as rows");
					} else {
						Assert.fail("Data placement is not working");
					}

					int colCount = row.getLastCellNum();
					System.out.println("Column Count :- " + colCount);
					for (int j = 26; j < colCount; j++) {
						int cell_obj = (int) sheet.getRow(1).getCell(j).getNumericCellValue();
						System.out.println(cell_obj);
						list.add(Integer.toString(cell_obj));
//						login.Log4j.info("Observation count is " + observation_count);

					}
					if (list.size() == 10) {
						System.out.println("Observation count is matched ");
					} else {
						Assert.fail("Observation count is not matched");
					}
				} else {
					Assert.fail(wb.getSheetName(i) + " IS NOT downloaded");
				}

			}

		} else {
			Assert.fail(file + " doesn't exist");
		}
		fis.close();

		File_delete.delete();
	}
	@Then("^Visuals should be interchanged by drag and drop$")
	public void visuals_should_be_interchanged_by_drag_and_drop() throws Throwable {
		CommonFunctionality.wait(2000);
		// Visuals position before drag and drop
		WebElement sourecEle = login.driver.findElement(
				By.xpath("(//*[contains(@class,'chart-template-view')]//*[@class='visual-title--text text-dots'])[1]"));
		String Visual1_chart_title_text = sourecEle.getText();
		CommonFunctionality.wait(2000);
		WebElement targetEle = login.driver.findElement(
				By.xpath("(//*[contains(@class,'image-template')]//*[@class='visual-title--text text-dots'])[1]"));
		CommonFunctionality.wait(500);
		String Visual2_image_title_text = targetEle.getText();
		CommonFunctionality.wait(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", targetEle);
		new Actions(login.driver).pause(2000).dragAndDrop(sourecEle, targetEle).perform();
		// Visuals after drag and drop
		CommonFunctionality.wait(500);
		String visual1_text = login.driver.findElement(By.xpath("(//*[@data-name='title'])[1]")).getText();
		String visual2_text = login.driver.findElement(By.xpath("(//*[@data-name='title'])[2]")).getText();
		if (!visual1_text.equals(Visual2_image_title_text) && !visual2_text.equals(Visual1_chart_title_text)) {
			login.Log4j.info("Visuals interchanged by drag and drop");
		} else {
			Assert.fail("Verification failed");
		}

	}
	void Alignvisual(String align) throws InterruptedException {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@aria-label='" + align + "']", 20).click();
		CommonFunctionality.wait(1200);
		WebElement element = login.driver.findElement(By.tagName("iframe"));
		login.driver.switchTo().frame(element);
		String align_str = login.driver.findElement(By.xpath("//html//body[@class='mce-content-body ']//p"))
				.getAttribute("style");
		ListOfalignmentValue.add(align_str);
		login.driver.switchTo().defaultContent();
	}
}
