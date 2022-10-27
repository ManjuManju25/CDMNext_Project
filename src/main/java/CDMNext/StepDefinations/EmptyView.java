package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class EmptyView {
	String[] exp;
	Histogram hs = new Histogram();
	Commentary comm = new Commentary();
	DatabasesTab db = new DatabasesTab();
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	String ExpectedTxt;
	WebDriverWait wait = new WebDriverWait(login.driver, 2000);
	int max_of_visuals_created;
	public String region1,region2;
	int chartCount = 0;
	int mapCount = 0,TableCount = 0,CommentaryCount=0,AttachmentsCount=0,FilterCount=0;
	
	@And("^Click on View tab$")
	public static void click_on_View_tab() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
	}

	@SuppressWarnings("deprecation")
	@And("^Select some series and drag and drop onto the visual$")
	public void select_some_series_and_drag_and_drop_onto_the_visual() throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Search", 5).sendKeys("210698402");
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(500);
		WebElement source = login.driver.findElement(By.xpath("//*[@class='series-item--name']"));
		WebElement target = CommonFunctionality.getElementByProperty(login.driver, "DropTable", 4);
		new Actions(login.driver).clickAndHold(source).pause(2000).dragAndDrop(source, target).build().perform();
	}

	@Then("^Series dropped should be created in the selected visual$")
	public void series_dropped_should_be_created_in_the_selected_visual() throws Throwable {
		boolean visual_title = login.driver.findElement(By.xpath("//*[@data-name='title']")).isDisplayed();
		if (visual_title == true) {
			login.Log4j.info("Visual is created by drag and drop");
		} else {
			Assert.fail("Visual is not created by drag and drop");
		}

	}

	@And("^Click on plus icon$")
	public void click_on_plus_icon() throws Throwable {
		click_on_View_tab();
	}

	@Then("^New view tab should be created with all visual options$")
	public void new_view_tab_should_be_created_with_all_visual_options() throws Throwable {
		boolean new_view_tab = login.driver.findElement(By.xpath("//*[@class='new-visual-panel insight-action-panel']"))
				.isDisplayed();
		if (new_view_tab == true) {
			login.Log4j.info("View tab is created");
		} else {
			Assert.fail("View tab is not created");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Mouse hover on the view tab$")
	public void mouse_hover_on_the_view_tab() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View 1']", 20);
		new Actions(login.driver).pause(500).moveToElement(ele).build().perform();
	}

	@And("^Click on cross icon$")
	public void click_on_cross_icon() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Delete view']", 20).click();
	}

	@Then("^Selected view tab should be deleted$")
	public void selected_view_tab_should_be_deleted() throws Throwable {

		if (login.driver.findElements(By.xpath("//*[@title='View 1']")).size() == 0) {
			login.Log4j.info("Selected view tab is deleted");
		} else {
			Assert.fail("Selected view tab is not deleted");
		}

	}

	@And("^Select the \"([^\"]*)\" dropdown$")
	public void select_the_dropdown(String arg1) throws Throwable {
		CommonFunctionality.wait(500);
		CommonFunctionality
				.getElementByXpath(login.driver,
						"//*[contains(text(),'" + arg1 + "')]",
						20)
				.click();
	}

	@Then("^Verify different types of Line charts$")
	public void verify_different_types_of_Line_charts() throws Throwable {

		String[] exp = { "Line", "Spline", "Step", "Dotted" };
		List<WebElement> LineChart_options = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']//*[@class='visuals-panel']/*/*[1]/*[1]/*[2]/*/*[1]"));
		Histogram.DropdownOptions(exp, LineChart_options);

	}

	@Then("^Verify different types of Area charts$")
	public void verify_different_types_of_Area_charts() throws Throwable {
		String[] exp = { "Area", "Stacked","100% Stacked" };
		List<WebElement> AreaChart_options = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']//*[@class='visuals-panel']/*/*[1]/*[2]/*[2]/*/*[1]"));
		Histogram.DropdownOptions(exp, AreaChart_options);
	}

	@Then("^Verify different types of Column charts$")
	public void verify_different_types_of_Column_charts() throws Throwable {
		String[] exp = { "Column", "Stacked","100% Stacked" };
		List<WebElement> ColumnChart_options = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']//*[@class='visuals-panel']/*/*[1]/*[3]/*[2]/*/*[1]"));
		Histogram.DropdownOptions(exp, ColumnChart_options);
	}

	@Then("^Verify different types of map options available$")
	public void verify_different_types_of_map_options_available() throws Throwable {
		String[] exp = { "World", "Africa", "Asia", "Europe", "Europe without Russia", "EU", "Middle East", "N America",
				"Oceania", "S America", "China", "Russia", "India" };
		List<WebElement> ColumnChart_options = login.driver
				.findElements(By.xpath("//*[@class='items-wrapper']//li/span"));
		Histogram.DropdownOptions(exp, ColumnChart_options);
	}

	@Then("^Verify different types of Bar charts$")
	public void verify_different_types_of_Bar_charts() throws Throwable {
		String[] exp = { "Bar", "Stacked","100% Stacked" };
		List<WebElement> BarChart_options = login.driver.findElements(By.xpath("//*[@class='items-wrapper']//*[@class='visuals-panel']/*/*[1]/*[4]/*[2]/*/*[1]"));
		Histogram.DropdownOptions(exp, BarChart_options);
	}

	@And("^Click on \"([^\"]*)\" in the view tab$")
	public void click_on_in_the_view_tab(String arg1) throws Throwable {
		CommonFunctionality.getElementByProperty(login.driver, "Search", 5).sendKeys("210698402");
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg1 + "')]", 20).click();
	}
	@And("^Select \"([^\"]*)\" from \"([^\"]*)\" dropdown$")
	public void select_from_dropdown(String arg1, String arg2) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'" + arg2 + "')]", 20).click();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'icon--histogram_large')]", 20).click();
	}
	@And("^Click on \"([^\"]*)\" in the menu bar$")
	public void click_on_in_the_menu_bar(String arg1) throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@data-title='" + arg1 + "']", 20).click();
	}

	@And("^Add the series to the visual$")
	public void add_the_series_to_the_visual() throws Throwable {
		// CommonFunctionality.getElementByProperty(login.driver, "Search",
		// 5).sendKeys("210698402");
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByProperty(login.driver, "Series", 20).click();
		CommonFunctionality.wait(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 10).click();

	}

	@And("^Click on plus icon and create (\\d+) view tabs on every click$")
	public void click_on_plus_icon_and_create_view_tabs_on_every_click(int arg1) throws Throwable {
		CommonFunctionality.ExpandLeft();
		for (int i = 0; i < arg1; i++) {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@title='Create new View tab']")).click();
		}

	}

	@Then("^(\\d+) views should be created$")
	public void views_should_be_created(int arg1) throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> views = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
		if (views.size() == arg1) {
			login.Log4j.info("Maximum number of views 10 is created");
		} else {
			Assert.fail("Maximum number of views 10 is not created");
		}

	}

	@SuppressWarnings("deprecation")
	@Then("^Hovering mouse on each option should show tooltip for each present in the menu bar$")
	public void hovering_mouse_on_each_option_should_show_tooltip_for_each_present_in_the_menu_bar() throws Throwable {
		CommonFunctionality.wait(1000);
		List<WebElement> list_visual_options = login.driver.findElements(By.xpath(
				"//*[@class='new-visual-panel insight-action-panel']/*[not(@class='insight-action-panel--separator')]"));

		// List<WebElement> list_visual_options = login.driver.findElements(
		// By.xpath("//*[@class='new-visual-panel
		// insight-action-panel']/*[contains(@class,'insight-action-panel--btn
		// ui-draggable ui-draggable-handle')]"));
		for (int i = 1; i < list_visual_options.size(); i++) {
			new Actions(login.driver).moveToElement(list_visual_options.get(i)).pause(500).build().perform();
			if (!list_visual_options.get(i).getAttribute("title").isEmpty()) {
				login.Log4j.info("Tooltip is : " + list_visual_options.get(i).getAttribute("title"));
			} else {
				Assert.fail("Tooltip " + list_visual_options.get(i).getAttribute("title") + " is not displayed");
			}
		}
	}


	@And("^Create Histogram and Map visuals$")
	public void create_Histogram_and_Map_visuals() throws Throwable {
		click_on_View_tab();
		CommonFunctionality.wait(500);
		CommonFunctionality.getElementByProperty(login.driver, "Search", 20).sendKeys("210698402");
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		// create histogram visual
		hs.click_on_histogram_visual_icon();
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_Tab", 20).click();
		CommonFunctionality.wait(1500);
		region1 = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--country country-information']", 10).getText();
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 10).click();
		// create map visual
		CommonFunctionality.getElementByProperty(login.driver, "AddChart", 4).click();
		CommonFunctionality.getElementByProperty(login.driver, "AddChart_map", 6).click();
		CommonFunctionality.ResetMethod();
		CommonFunctionality.getElementByProperty(login.driver, "Search", 20).sendKeys("5958801");
		CommonFunctionality.getElementByClassName(login.driver, "search-input-text", 4).sendKeys(Keys.ENTER);
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByProperty(login.driver, "Series_Tab", 20).click();
		CommonFunctionality.wait(1500);
		region2 = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-item--country country-information']", 10).getText();
		CommonFunctionality.wait(1500);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='add-to-data-selection--icon']", 20).click();
	}

	@SuppressWarnings("deprecation")
	@Then("^Visuals should be interplaced by drag and drop$")
	public void visuals_should_be_interplaced_by_drag_and_drop() throws Throwable {
		CommonFunctionality.wait(2000);
		// Visuals position before drag and drop
		WebElement sourecEle = login.driver.findElement(
				By.xpath("(//*[@data-row-index='2']//*[@class='visual-title--text text-dots'])[1]"));
		String Visual2_map_title_text = sourecEle.getText();
		CommonFunctionality.wait(2000);
		WebElement targetEle = login.driver.findElement(
				By.xpath("(//*[contains(@class,'histogram-visual')]//*[@class='visual-title--text text-dots'])[1]"));
		CommonFunctionality.wait(500);
		String Visual1_hs_title_text = targetEle.getText();
		CommonFunctionality.wait(1000);
		jse.executeScript("arguments[0].scrollIntoView(true);", targetEle);
		new Actions(login.driver).pause(2000).dragAndDrop(sourecEle, targetEle).perform();
		// Visuals after drag and drop
		CommonFunctionality.wait(500);
		String visual1_text = login.driver.findElement(By.xpath("(//*[@data-name='title'])[1]")).getText();
		String visual2_text = login.driver.findElement(By.xpath("(//*[@data-name='title'])[2]")).getText();
		if (!visual1_text.equals(Visual1_hs_title_text) && !visual2_text.equals(Visual2_map_title_text)) {
			login.Log4j.info("Visuals interchanged by drag and drop");
		} else {
			Assert.fail("Verification failed");
		}

	}

	@And("^Create any of the visual$")
	public void create_any_of_the_visual() throws Throwable {
		hs.create_histogram_visual_with_series();
	}

	@SuppressWarnings("deprecation")
	@And("^Paste in new view tab$")
	public void paste_in_new_view_tab() throws Throwable {
		CommonFunctionality.wait(6000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Create new View tab']", 15).click();
		WebElement Ele = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab__active')]//a", 20);
		new Actions(login.driver).pause(500).contextClick(Ele).build().perform();
		try {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Paste visual']", 15).click();
		} catch (Exception e) {
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Paste view(s)']", 15).click();
		}
	}

	@Then("^Copied visual should be pasted without empty view$")
	public void copied_visual_should_be_pasted_without_empty_view() throws Throwable {
		CommonFunctionality.wait(2500);
		String ExpectedTitle = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 10)
				.getText();
		if (Histogram.Visual_Title_txt.equals(ExpectedTitle)) {
			if (login.driver.findElements(By.xpath("//*[@class='highcharts-root']")).size() != 0) {
				login.Log4j.info("Copied visual is pasted");
			}
		} else {
			Assert.fail("Copied visual is not pasted");
		}
	}

	@And("^Create any empty visual$")
	public void create_any_empty_visual() throws Throwable {
		hs.create_a_Histogram_visual_without_selecting_series();
	}

	@Then("^Copied visual should be pasted with empty view$")
	public void copied_visual_should_be_pasted_with_empty_view() throws Throwable {
		if (login.driver.findElements(By.xpath("//*[@class='highcharts-root']")).size() == 0) {
			login.Log4j.info("Copied visual is pasted");
		} else {
			Assert.fail("Verification failed ...pasting empty view in new tab");
		}
	}

	@Then("^Selected visual should be deleted$")
	public void selected_visual_should_be_deleted() throws Throwable {
		comm.commentary_should_be_deleted();
	}

	@Then("^Visual should be converted into selected visual format$")
	public void visual_should_be_converted_into_selected_visual_format() throws Throwable {
		hs.the_visual_should_be_converted_as_visual("visual", "Chart");
	}

	@Then("^Calculate series should be in disabled state$")
	public void calculate_series_should_be_in_disabled_state() throws Throwable {
		CommonFunctionality.wait(300);
		boolean calculate_series = login.driver.findElement(By.xpath("//*[@title='Calculate series']"))
				.getAttribute("class").contains("disabled");
		if (calculate_series == true) {
			login.Log4j.info("Calculate series displayed in disabled state");

		} else {
			Assert.fail("Calculate series not displayed in disabled state");
		}
	}

	@Then("^The edit series popup should be opened$")
	public void the_edit_series_popup_should_be_opened() throws Throwable {
		CommonFunctionality.wait(2000);
		if(login.driver.findElements(By.xpath("//*[@class='sidebar-panel sidebar-panel__opened']")).size() == 1) {
			login.Log4j.info("The edit series popup is opened");
		} else {
			Assert.fail("The edit series popup is not opened");
		}
	}

	@Then("^Clear contents option should be disabled$")
	public void clear_contents_option_should_be_disabled() throws Throwable {
		CommonFunctionality.wait(300);
		boolean calculate_series = login.driver.findElement(By.xpath("//*[@title='Clear contents']"))
				.getAttribute("class").contains("disabled");
		if (calculate_series == true) {
			login.Log4j.info("Clear contents displayed in disabled state");

		} else {
			Assert.fail("Clear contents not displayed in disabled state");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Right click on empty view tab$")
	public void right_click_on_empty_view_tab() throws Throwable {
		CommonFunctionality.wait(2000);
		WebElement viewTab = CommonFunctionality.getElementByXpath(login.driver,
				"//*[contains(@class,'insight-page-view-tab--link__active')]", 20);
		new Actions(login.driver).pause(1000).contextClick(viewTab).perform();
	}

	@And("^Change to \"([^\"]*)\" and Save$")
	public void change_to_and_Save(String arg1) throws Throwable {
		ExpectedTxt = arg1;
		WebElement rename = CommonFunctionality.getElementByXpath(login.driver,
				"//*[@class='insight-view-rename']/input[@type='text']", 20);
		rename.clear();
		rename.sendKeys(ExpectedTxt);
		//save the changes
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@class,'insight-view-rename--icon__apply')]", 20).click();
	}

	@Then("^View name should be updated$")
	public void view_name_should_be_updated() throws Throwable {
		CommonFunctionality.wait(500);
		String rename_txt = CommonFunctionality
				.getElementByXpath(login.driver, "//*[contains(@class,'insight-page-view-tab--link__active')]/*", 20)
				.getText();
		if (rename_txt.equalsIgnoreCase(ExpectedTxt)) {
			login.Log4j.info("View name is updated by renaming view ");
		} else {
			Assert.fail("Renaming view name is failed");
		}
		
	}

	@And("^Right click on view tab$")
	public void right_click_on_view_tab() throws Throwable {
		right_click_on_empty_view_tab();
	}

	@Then("^Duplicate view should be created$")
	public void duplicate_view_should_be_created() throws Throwable {
		String DuplicateView = null;
		CommonFunctionality.wait(2000);
		List<WebElement> views = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
		if (views.size() > 0) {

			DuplicateView = CommonFunctionality
					.getElementByXpath(login.driver, "//*[contains(@class,'insight-page-view-tab__active')]/*[1]/*", 20)
					.getText();
		}

		String ExpectedTitle = CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 10)
				.getText();

		if (Histogram.Visual_Title_txt.equals(ExpectedTitle) && DuplicateView.contains("copy")) {
			login.Log4j.info("Duplicate view is created");
		} else {
			Assert.fail("Duplicate view is not created");
		}
	}

	@Then("^Created visuals should be removed$")
	public void created_visuals_should_be_removed() throws Throwable {
		hs.histogram_should_be_deleted();
	}

	@Then("^Existing view tab should be deleted$")
	public void existing_view_tab_should_be_deleted() throws Throwable {
		try {
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='sphere-modal-controls--right']//*[contains(text(),'Ok')]", 10).click();
		} catch (Exception e) {

		}
		CommonFunctionality.wait(2000);
		List<WebElement> views = login.driver
				.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
		if (views.size() == 0) {
			login.Log4j.info("Existing view tab is deleted");
		} else {
			Assert.fail("Existing view tab is not deleted");
		}
	}

	@Then("^Existing all view tab should get deleted$")
	public void existing_all_view_tab_should_get_deleted() throws Throwable {
		existing_view_tab_should_be_deleted();
	}

	@Then("^If there is no visuals created in view tab, download option should be disabled$")
	public void if_there_is_no_visuals_created_in_view_tab_download_option_should_be_disabled() throws Throwable {
		CommonFunctionality.wait(2000);
		if (CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Download view']", 10).getAttribute("class")
				.contains("disabled")) {
			login.Log4j.info("Download option is disabled");

		} else {
			Assert.fail("Download option is not disabled");
		}
	}

	@Then("^If there is visuals present, \"([^\"]*)\" should enabled and open the download window$")
	public void if_there_is_visuals_present_should_enabled_and_open_the_download_window(String arg1) throws Throwable {
		CommonFunctionality.wait(2000);
		if (!CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Download view']", 10)
				.getAttribute("class").contains("disabled")) {
			login.Log4j.info("Download option is enabled");
			CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Download view']", 10).click();

		}
		CommonFunctionality.wait(2000);
		boolean download_window = login.driver
				.findElement(
						By.xpath("//*[@class='modal-content sphere-modal__content']//*[@class='download-modal-title']"))
				.isDisplayed();
		if (download_window == true) {
			login.Log4j.info("Download window is opened");
			CommonFunctionality
					.getElementByXpath(login.driver,
							"//*[contains(@class,'modal-window__active')]//*[@class='sphere-modal__close']", 10)
					.click();
		} else {
			Assert.fail("Download window is not opened");
		}
	}

	@SuppressWarnings("deprecation")
	@And("^Click on out space of the visual$")
	public void click_on_out_space_of_the_visual() throws Throwable {
		WebElement ele = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='visual-top-panel--content']", 10);
		new Actions(login.driver).pause(1000).contextClick(ele).build().perform();
	}

	@Then("^Should display menu bar options of the view tab$")
	public void should_display_menu_bar_options_of_the_view_tab() throws Throwable {
		Boolean menuBar = login.driver.findElement(By.xpath("//*[@class='dropdown-menu context-menu ']//*[@class='items-wrapper']")).isDisplayed();
		if(menuBar == true) {
			login.Log4j.info("Menu bar is displayed");
		} else {
			Assert.fail("Menu bar is not displayed when clock on out of the visual");
		}
	}

	@And("^Max of \"([^\"]*)\" visuals can be created are (\\d+)$")
	public void max_of_visuals_can_be_created_are(String arg1, int arg2) throws Throwable {
		
		List<WebElement> no_of_visuals = null;

		CommonFunctionality.wait(2000);
		if (arg1.equalsIgnoreCase("Chart")) {
			String visual = "Line";
		
			for (int i = 0; i <= arg2; i++) {
				CommonFunctionality.getElementByProperty(login.driver, "AddChart", 10).click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//div[contains(@class,'icon--chart-line_large')]", 8).click();
				CommonFunctionality.wait(1000);
				
			}
			visuals_verifucation(no_of_visuals, arg1, arg2, visual);
		} else if (arg1.equalsIgnoreCase("map")) {
			for (int i = 0; i <= arg2; i++) {
				CommonFunctionality.getElementByProperty(login.driver, "AddChart", 10).click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//div[contains(@class,'icon--map-filled_large')]", 8).click();
				CommonFunctionality.wait(1000);
			}

			visuals_verifucation(no_of_visuals, arg1, arg2, arg1);
		} else if (arg1.equalsIgnoreCase("table")) {
			for (int i = 0; i <= arg2; i++) {
				CommonFunctionality.getElementByProperty(login.driver, "AddChart", 10).click();
				CommonFunctionality.getElementByXpath(login.driver,
						"//div[contains(@class,'icon--table-vertical_large')]", 8).click();
				CommonFunctionality.wait(1000);
			}
			
			visuals_verifucation(no_of_visuals, arg1, arg2, arg1);
			CommonFunctionality.wait(1000);
		} else if (arg1.equalsIgnoreCase("commentary")) {
			for (int i = 0; i <= arg2; i++) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@data-title='Text']", 10).click();
				CommonFunctionality.wait(1000);
			}
			visuals_verifucation(no_of_visuals, arg1, arg2, arg1);
		} else if (arg1.equalsIgnoreCase("attachments")) {
			for (int i = 0; i <= arg2; i++) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@data-instance='attachments']", 10).click();
				CommonFunctionality.wait(1000);
			}

			visuals_verifucation(no_of_visuals, arg1, arg2, arg1);
		} else if (arg1.equalsIgnoreCase("Filter")) {
			for (int i = 0; i <= arg2; i++) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@data-instance='filter']", 10).click();
				CommonFunctionality.wait(1000);
			}

			visuals_verifucation(no_of_visuals, arg1, arg2, arg1);
		} else if (arg1.equalsIgnoreCase("Image")) {
			for (int i = 0; i <= arg2; i++) {
				CommonFunctionality.getElementByXpath(login.driver, "//*[@data-instance='image']", 10).click();
				CommonFunctionality.wait(1000);
			}

			visuals_verifucation(no_of_visuals, arg1, arg2, arg1);
		}

	}

	@And("^Create below visuals using keyboard shortcuts$")
	public void create_below_visuals_using_keyboard_shortcuts(List<String> list) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("Series"))));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_tab"))).click();
		CommonFunctionality.wait(2000);
		WebElement checkBox = login.driver
				.findElement(By.xpath("//div[@class='series-representation--list']//div[@class='series-list-item--checkbox-wrapper']/*"));
		Robot robot = new Robot();
		for (String visual : list) {
			if (visual.equalsIgnoreCase("Map")) {
				CommonFunctionality.wait(200);
				checkBox.click();
				robot.keyPress(KeyEvent.VK_M);
				CommonFunctionality.wait(200);
				robot.keyRelease(KeyEvent.VK_M);
				CommonFunctionality.wait(5000);
				if (login.driver.findElement(By.xpath("//*[contains(text(),'Edit Map')]")).isDisplayed()) {
					login.Log4j.info("Map visual is created ");
				} else {
					Assert.fail("Map visual is not created ");
				}

			} else if (visual.equalsIgnoreCase("Table")) {
				checkBox.click();
				robot.keyPress(KeyEvent.VK_T);
				CommonFunctionality.wait(200);
				robot.keyRelease(KeyEvent.VK_T);
				CommonFunctionality.wait(5000);
				if (login.driver.findElement(By.xpath("//*[contains(text(),'Edit Table')]")).isDisplayed()) {
					login.Log4j.info("Table visual is created ");
				} else {
					Assert.fail("Table visual is not created ");
				}
			} else if (visual.equalsIgnoreCase("Chart")) {
				checkBox.click();
				robot.keyPress(KeyEvent.VK_C);
				CommonFunctionality.wait(200);
				robot.keyRelease(KeyEvent.VK_C);
				CommonFunctionality.wait(5000);
				if (login.driver.findElement(By.xpath("//*[contains(text(),'Edit Chart')]")).isDisplayed()) {
					login.Log4j.info("Chart visual is created ");
				} else {
					Assert.fail("Chart visual is not created ");
				}
			}
		}

	}

	@And("^Click inside of the visual box created$")
	public void click_inside_of_the_visual_box_created() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@class='empty-visual-overlay--title']", 20).click();
	}

	@Then("^Menu bar should be displayed with respective visual edit options$")
	public void menu_bar_should_be_displayed_with_respective_visual_edit_options() throws Throwable {
		CommonFunctionality.wait(500);
		if (login.driver.findElement(By.xpath("//*[@class='visual-top-panel']")).isDisplayed()) {
			login.Log4j.info("Menu bar is displayed");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^Copy the visual$")
	public void copy_the_visual() throws Throwable {
		CommonFunctionality.wait(1000);
	WebElement titleEle = 	CommonFunctionality.getElementByXpath(login.driver, "//*[@data-name='title']", 15);
	new Actions(login.driver).pause(500).contextClick(titleEle).build().perform();
	CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Copy table')] | //*[contains(text(),'Copy histogram')]", 15).click();
	}

	@And("^Paste it onto the another view tab$")
	public void paste_it_onto_the_another_view_tab() throws Throwable {
		Robot robot = new Robot();
		CommonFunctionality.wait(2000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='Create new View tab']", 15).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}

	@And("^Max of Table visuals can be created are (\\d+)$")
	public void max_of_Table_visuals_can_be_created_are(int arg1) throws Throwable {
		max_of_visuals_created = arg1;
		for (int i = 0; i < arg1; i++) {
			CommonFunctionality.wait(3000);
			CommonFunctionality.getElementByProperty(login.driver, "AddChart", 10).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(@class,'icon--table-vertical_large')]", 8).click();

		}
	}

	@And("^Create table visual in view tab$")
	public void create_table_visual_in_view_tab() throws Throwable {
		click_on_plus_icon();
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByProperty(login.driver, "AddChart", 10).click();
		CommonFunctionality.getElementByXpath(login.driver,
				"//div[contains(@class,'icon--table-vertical_large')]", 8).click();
		hs.add_series_to_the_my_series_tab();
	}

	@And("^Try to paste it onto the max number of table created view$")
	public void try_to_paste_it_onto_the_max_number_of_table_created_view() throws Throwable {
		CommonFunctionality.getElementByXpath(login.driver, "//*[@title='View 1']", 15).click();
		CommonFunctionality.wait(1000);
		WebElement firstTable = CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='empty-visual-overlay--title'])[1]", 15);
		//Right click on first table and select paste visual
		new Actions(login.driver).pause(500).contextClick(firstTable).build().perform();
		CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Paste visual')]", 15).click();
	}

	@Then("^Copy pasting of visual from other view should not be allowed$")
	public void copy_pasting_of_visual_from_other_view_should_not_be_allowed() throws Throwable {
		Boolean growl_text = login.driver.findElement(By.xpath("//*[@class='growl-message growl-info']")).isDisplayed();
		String growlInfo = login.driver.findElement(By.xpath("//*[@class='growl-message growl-info']")).getText();
		if (growl_text == true && growlInfo.contains(String.valueOf(max_of_visuals_created))) {
			login.Log4j.info("Verification pass");
		} else {
			Assert.fail("Verification failed");
		}
	}

	@And("^Press backspace in the keyboard$")
	public void press_backspace_in_the_keyboard() throws Throwable {
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(100);
	}

	@Then("^Should not allow the navigation from view tab to my series tab$")
	public void should_not_allow_the_navigation_from_view_tab_to_my_series_tab() throws Throwable {
		if (login.driver.findElements(By.xpath(
				"//*[@data-page='myseries']//*[@class='insight-page-view-tab--link insight-page-view-tab--link__active']"))
				.size() == 0) {
			login.Log4j.info("Not navigated to my series tab by pressing key Backspace");
		} else {
			Assert.fail("Navigated to my series tab by pressing key Backspace");
		}
	}

	void visuals_verifucation(List<WebElement> no_of_visuals, String arg1, int arg2,
			String TypeOfvisual) {
		//when hit maximum limit of the visuals it creates visuals in new view tab i.e view2
		//Delete view 2 and count no.of visuals in view1
		
		WebElement view2 = login.driver.findElement(By.xpath("//*[@title='View 2']"));
		if(view2.isDisplayed()) {
			new Actions(login.driver).contextClick(view2).pause(1000).build().perform();
			 login.driver.findElement(By.xpath("//*[contains(text(),'Delete view')]")).click();
			 login.driver.findElement(By.xpath("//button[contains(text(),'Ok')]")).click();
			
		}
		CommonFunctionality.wait(2000);
		no_of_visuals = login.driver.findElements(By .xpath("//*[@class='view-components']/*[@class='insight-visuals-row text-content'] | //*[@class='view-components']/*[@class='insight-visuals-row--list'] | //*[@class='view-components']/*[@class='insight-visuals-row']"));
		/*
		 * if (arg1.equalsIgnoreCase("Commentary") || arg1.equalsIgnoreCase("Filter") ||
		 * arg1.equalsIgnoreCase("Image")) { no_of_visuals =
		 * login.driver.findElements(By .xpath("//*[contains(text(),'" + TypeOfvisual +
		 * "')]")); } else { no_of_visuals = login.driver.findElements(By
		 * .xpath("//*[@class='empty-visual-overlay--content']//*[contains(text(),'" +
		 * TypeOfvisual + "')]")); }
		 */
		
		switch(arg1) {
			case "Chart": 
				if (no_of_visuals.size() == arg2) {
					login.Log4j.info(arg1 + " visuals are created");
					chartCount = arg2;
				} else {
					Assert.fail("max of " + arg1 + " visuals are not created");
				}
				break;
			case "Map":
				if (no_of_visuals.size() == arg2+chartCount) {
					login.Log4j.info(arg1 + " visuals are created");
					mapCount = arg2+chartCount;
				} else {
					Assert.fail("max of " + arg1 + " visuals are not created");
				}
				break;
			case "Table":
				if (no_of_visuals.size() == arg2+mapCount) {
					login.Log4j.info(arg1 + " visuals are created");
					TableCount = arg2+mapCount;
				} else {
					Assert.fail("max of " + arg1 + " visuals are not created");
				}
				break;
			case "Commentary":
				if (no_of_visuals.size() == arg2+TableCount) {
					login.Log4j.info(arg1 + " visuals are created");
					CommentaryCount = arg2+TableCount;
				} else {
					Assert.fail("max of " + arg1 + " visuals are not created");
				}
				break;
			case "Attachments":
				if (no_of_visuals.size() == arg2+CommentaryCount) {
					login.Log4j.info(arg1 + " visuals are created");
					AttachmentsCount = arg2+CommentaryCount;
				} else {
					Assert.fail("max of " + arg1 + " visuals are not created");
				}
				break;
			case "Filter":
				if (no_of_visuals.size() == arg2+AttachmentsCount) {
					login.Log4j.info(arg1 + " visuals are created");
					FilterCount = arg2+AttachmentsCount;
				} else {
					Assert.fail("max of " + arg1 + " visuals are not created");
				}
				break;
			case "Image":
				if (no_of_visuals.size() == arg2+FilterCount) {
					login.Log4j.info(arg1 + " visuals are created");
					
				} else {
					Assert.fail("max of " + arg1 + " visuals are not created");
				}
				break;
			default: 
				Assert.fail("max of " + arg1 + " visuals are not created");	
				
		}
			
	}
}
