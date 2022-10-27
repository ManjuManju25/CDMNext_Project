	package CDMNext.StepDefinations;
	
	//import static org.testng.Assert.fail;
	
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.Clipboard;
	import java.awt.datatransfer.DataFlavor;
	import java.awt.datatransfer.Transferable;
	import java.awt.event.KeyEvent;
	import java.io.File;
	import java.io.FileFilter;
	//import java.time.LocalDate;
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;
	
	import org.apache.commons.io.comparator.LastModifiedFileComparator;
	import org.apache.commons.io.filefilter.WildcardFileFilter;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	//import org.openqa.selenium.support.ui.Select;
	//import org.openqa.selenium.support.ui.Wait;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	
	import com.google.common.collect.Ordering;
	
	import CDMNext.util.CommonFunctionality;
	//import Javaxlxs.Last_file_download;
	import cucumber.api.java.en.And;
	import cucumber.api.java.en.Given;
	
	public class TableVisual {
		String Applied_currency;
		CDMNextSprintCases cdmnext = new CDMNextSprintCases();
		Histogram hs = new Histogram();
		DatabasesTab db = new DatabasesTab();
		SeriesTab st = new SeriesTab();
		Commentary commentary = new Commentary();
		PieVisual pie = new PieVisual();
		Actions action = new Actions(login.driver);
		SprintCases sprint = new SprintCases();
		WebDriverWait wait = new WebDriverWait(login.driver, 30);
		JavascriptExecutor jse = (JavascriptExecutor) login.driver;
		public static String FunctionApplied;
	
		// TC_TV_01
		@And("^create visual tab$")
		public void create_visual_tab() throws Throwable {
			Thread.sleep(3000);
			CommonFunctionality.getElementByProperty(login.driver, "CreateViewTab", 8).click();
		}
	
		// TC_TV_01
		@SuppressWarnings("deprecation")
		@And("^drag and drop the table visual$")
		public void drag_and_drop_the_table_visual() throws Throwable {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login.LOCATORS.getProperty("TableVisual"))));
			WebElement sourceLocator = CommonFunctionality.getElementByProperty(login.driver, "TableVisual", 4);
			WebElement targetLocator = CommonFunctionality.getElementByProperty(login.driver, "DropTable", 4);
			action.clickAndHold(sourceLocator).pause(2000).dragAndDrop(sourceLocator, targetLocator).build().perform();
	
		}
	
		// TC_TV_01
		@And("^verify the Table visual creating from View panel by drag and drop$")
		public void verify_the_Table_visual_creating_from_View_panel_by_drag_and_drop() throws Throwable {
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() != 0) {
				System.out.println("Table visual creating from View panel by drag and drop is working fine");
			} else {
				Assert.fail("Table visual creating from View panel by drag and drop is Not working fine");
			}
		}
	
		// TC_TV_02
		@And("^select the table visual$")
		public void select_the_table_visual() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "AddChart", 4).click();
			CommonFunctionality.getElementByProperty(login.driver, "TableVisual", 10).click();
		}
	
		// TC_TV_02
		@And("^verify the Table visual creating from View panel by clicking$")
		public void verify_the_Table_visual_creating_from_View_panel_by_clicking() throws Throwable {
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() != 0) {
				System.out.println("Table visual creating from View panel by clicking is working fine");
			} else {
				Assert.fail("Table visual creating from View panel by clicking is Not working fine");
			}
		}
	
		// TC_TV_03
		@SuppressWarnings("deprecation")
		@And("^Applay function$")
		public void applay_function() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "Series_select_all", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "function_applay", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "First_function_applay", 8).click();
			WebElement we = login.driver.findElement(By.xpath(
					"//div[@class='webix_column list-series-name webix_last']/div[1]/div[1]/div[1]/div[1]/span[1]/span"));
			action.moveToElement(we).pause(1000).build().perform();
			String function_series_name = CommonFunctionality.getElementByProperty(login.driver, "ToolTip_Function", 8)
					.getText();
			FunctionApplied = function_series_name;
	
		}
	
		// TC_TV_03
		@And("^create table for applied function$")
		public void create_table_for_applied_function() throws Throwable {
			WebElement mouseover = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-name-field--series-name'])[1]", 10);
			// mouseover
			action.pause(1000).contextClick().build().perform();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as Table')]", 10).click();
			// login.driver.findElement(By.xpath("//span[contains(text(),'5Y')]")).click();
			System.out.println("Exit from create table visual");
	
		}
	
		// TC_TV_03
		@And("^verify Table visual creating with function applied series$")
		public void verify_Table_visual_creating_with_function_applied_series() throws Throwable {
			WebElement we = CommonFunctionality.getElementByXpath(login.driver, "//*[@class='series-edit--title']", 6);
			action.moveToElement(we).pause(1000).build().perform();
			String Function_Tabel = CommonFunctionality.getElementByProperty(login.driver, "ToolTip_Function", 10)
					.getText();
			String s1 = Function_Tabel;
			System.out.println(s1 + ":" + FunctionApplied);
	
			if (FunctionApplied.equalsIgnoreCase(s1)) {
				System.out.println("Table visual creating with function applied series is working fine");
			} else {
				Assert.fail("Table visual creating with function applied series is Not working fine");
			}
		}
	
		// TC_TV_04
		@And("^verify Edit Table button is disable$")
		public void verify_Edit_Table_button_is_disable() throws Throwable {
			CommonFunctionality.wait(1000);
			boolean editTable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittable"))).isEnabled();
			if (editTable == false) {
				System.out.println("Edit Table button is disable");
			} else {
				Assert.fail("Edit Table button is NOT disable");
			}
		}
	
		// TC_TV_05
		@And("^verify Edit series button$")
		public void verify_Edit_series_button() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeriesopen"))).isDisplayed());
			System.out.println("Edit series Opened");
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_06
		@And("^verify default tab for Edit series option$")
		public void verify_default_tab_for_Edit_series_option() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			if (login.driver.getPageSource().contains("Add from My Series")) {
				login.Log4j.info("Add from My Series is default tab for Edit series option");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_07
		@And("^verify description message for empty visual if have series in My series$")
		public void verify_description_message_for_empty_visual_if_have_series_in_My_series() throws Throwable {
			select_the_table_visual();
			Thread.sleep(2000);
			if (login.driver.getPageSource().contains("Add from My Series")
					&& login.driver.getPageSource().contains("Drag series here")) {
				login.Log4j.info("Verified");
			} else {
	
				Assert.fail();
			}
		}
	
		// TC_TV_08
		@And("^verify description message for empty visual if have NO series in My series$")
		public void verify_description_message_for_empty_visual_if_have_NO_series_in_My_series() throws Throwable {
			select_the_table_visual();
			Thread.sleep(2000);
			if (login.driver.getPageSource().contains("Drag series here")) {
				login.Log4j.info("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_09
		@And("^verify Add from my series option$")
		public void verify_Add_from_my_series_option() throws Throwable {
			select_the_table_visual();
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeries", 8).click();
			CommonFunctionality.wait(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Listandtable"))).isDisplayed());
			System.out.println("Add from my series option is verified");
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_10
		@And("^verify Table tab when no series added for visual$")
		public void verify_Table_tab_when_no_series_added_for_visual() throws Throwable {
			select_the_table_visual();
			CommonFunctionality.wait(1000);
			hs.click_on_Edit_series_option();
			CommonFunctionality.getElementByProperty(login.driver, "TableinEditSeries", 8).click();
			Thread.sleep(1000);
			if (login.driver.getPageSource().contains("There are no series for selected visual. Please add series from")) {
				login.Log4j.info("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_11
		@And("^verify \\+ Add from My Series option in edit series panel$")
		public void verify_Add_from_My_Series_option_in_edit_series_panel() throws Throwable {
			try {
				select_the_table_visual();
				CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeries", 8).click();
				CommonFunctionality.getElementByProperty(login.driver, "TableinEditSeries", 8).click();
				CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeriesTable", 8).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Listandtable"))).isDisplayed());
				System.out.println("Add from my series option is verified");
				CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
	
				select_the_table_visual();
				CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeries", 8).click();
				CommonFunctionality.getElementByProperty(login.driver, "TableinEditSeries", 8).click();
				CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeriesTable", 8).click();
				Assert.assertTrue(
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Listandtable"))).isDisplayed());
				System.out.println("Add from my series option is verified");
				CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
			}
		}
		// Close_window
	
		// TC_TV_12
		@And("^verify Verify adding series to empty visual$")
		public void verify_Verify_adding_series_to_empty_visual() throws Throwable {
			select_the_table_visual();
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeries", 8).click();
			CommonFunctionality
					.getElementByXpath(login.driver, "//span[@class='series-tab--text' and contains(text(),'List')]", 8)
					.click();
			CommonFunctionality.getElementByProperty(login.driver, "SelectAllinEditSeries", 8).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("TableCreated"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_13
		@And("^verify default attributes for Table visual$")
		public void verify_default_attributes_for_Table_visual() throws Throwable {
			// select_the_table_visual();
			Thread.sleep(5000);
			List<WebElement> TableAtttribute = login.driver.findElements(By.xpath("//tr[@class=' heading']/th[1]"));
			for (WebElement VerifyTableAtttribute : TableAtttribute) {
				Thread.sleep(1000);
				String TableAtttributes = VerifyTableAtttribute.getText();
				System.out.println(TableAtttributes);
				if (TableAtttributes.contains("Name") || TableAtttributes.contains("Region")
						|| TableAtttributes.contains("Frequency") || TableAtttributes.contains("Unit")
						|| TableAtttributes.contains("Series ID") || TableAtttributes.contains("First Obs. Date")
						|| TableAtttributes.contains("Last Obs. Date") || TableAtttributes.contains("Last Update Time")) {
					System.out.println(" TableAtttributes are Verified Successfully ");
				} else {
					Assert.fail();
	
				}
			}
		}
	
		// TC_TV_14
		@And("^verify the attributes rows$")
		public void verify_the_attributes_rows() throws Throwable {
	
			Thread.sleep(2000);
			List<WebElement> TableAtttribute = login.driver.findElements(By.xpath("//tr[@class=' heading']/th[2]"));
			if (TableAtttribute.size() == 8) {
				System.out.println("Verified the attributes rows ");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_15
		@And("^verify removing attributes by clicking x icon$")
		public void verify_removing_attributes_by_clicking_x_icon() throws Throwable {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
			// WebElement Sereiesnameintable
			// =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			// action.moveToElement(Sereiesnameintable).build().perform();
			action.moveToElement(login.driver.findElement(By.xpath("//span[@class='series-edit--title']"))).build()
					.perform();
			CommonFunctionality.getElementByProperty(login.driver, "RemoveIconseries", 10).click();
			verify_the_Table_visual_creating_from_View_panel_by_drag_and_drop();
		}
	
		// TC_TV_16
		@And("^verify clicking on series name$")
		public void verify_clicking_on_series_name() throws Throwable {
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
			WebElement Sereiesnameintable = CommonFunctionality.getElementByXpath(login.driver,
					"//span[@class='series-edit--title']", 8);
			action.moveToElement(Sereiesnameintable).pause(300).click().build().perform();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
			System.out.println("verified clicking on series name");
			CommonFunctionality.getElementByProperty(login.driver, "SSP_Dialogue_X_Icon", 4).click();
		}
	
		// TC_TV_17
		@And("^verify Edit series on visual$")
		public void verify_Edit_series_on_visual() throws Throwable {
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "EditseriesTable", 8).click();
			String[] exp = { "Rename", "Frequency", "Change" };
			List<WebElement> options = login.driver.findElements(
					By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']/div[3]/li"));
			for (WebElement we : options) {
				boolean match = false;
				for (int j = 0; j < exp.length; j++) {
					String X = we.getText();
					if (X.equals(exp[j])) {
						System.out.println(X + exp[j]);
						match = true;
						System.out.println("DropDown is verified successfully");
					}
				}
				// Assert.assertTrue(match);
				if (match = false) {
					Assert.fail();
				}
			}
		}
	
		// TC_TV_18
		@And("^Select the rename option in tabel visual$")
		public void select_the_rename_option_in_tabel_visual() throws Throwable {
	
			CommonFunctionality.wait(1000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//th[@class='hor-vertical-header'])[2]"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
			// WebElement Sereiesnameintable
			// =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "EditseriesTable", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Series_TV", 8).click();
		}
	
		// TC_TV_18
		@And("^verify Rename option from cogwheel icon$")
		public void verify_Rename_option_from_cogwheel_icon() throws Throwable {
			CommonFunctionality.wait(1000);
			WebElement RenameSeriesTV = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Search")));
			RenameSeriesTV.clear();
			String Renaming = "Testing";
			RenameSeriesTV.sendKeys(Renaming);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OK_Button"))).click();
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			String AfterRenaming = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
			if (Renaming.equalsIgnoreCase(AfterRenaming)) {
				System.out.println("Verified Successfully");
			}
	
			else {
				Assert.fail();
			}
		}
	
		// TC_TV_19
		@And("^Select the Frequency option in tabel visual$")
		public void select_the_Frequency_option_in_tabel_visual() throws Throwable {
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//th[@class='hor-vertical-header'])[2]"));
			// WebElement Sereiesnameintable
			// =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "EditseriesTable", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Frquency_Series_TV", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Frequency_replicate", 8).click();
		}
	
		// TC_TV_19
		@And("^verify Frequency option from cogwheel icon$")
		public void verify_Frequency_option_from_cogwheel_icon() throws Throwable {
	
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
			System.out.println(FunctionApplied);
	
			if (FunctionApplied.contains("DISAGGREGATE(Weekly; Sunday; Replicate)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_20
		@And("^Select the Currency option in tabel visual$")
		public void select_the_Currency_option_in_tabel_visual() throws Throwable {
			CreateTable();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
			CommonFunctionality.wait(1000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//th[@class='hor-vertical-header'])[2]"));
			// WebElement Sereiesnameintable
			// =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "EditseriesTable", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Currency_Series_TV", 8).click();
			WebElement rub = null;
			try {
	
				rub = CommonFunctionality.getElementByProperty(login.driver, "Currency_RUB", 8);
				((JavascriptExecutor) login.driver).executeScript("arguments[0].click();", rub);
			} catch (org.openqa.selenium.StaleElementReferenceException ex) {
				rub = CommonFunctionality.getElementByProperty(login.driver, "Currency_RUB", 8);
				((JavascriptExecutor) login.driver).executeScript("arguments[0].click();", rub);
			}
			Applied_currency = rub.getText();
		}
	
		// TC_TV_20
		@And("^verify Currency option from cogwheel icon$")
		public void verify_Currency_option_from_cogwheel_icon() throws Throwable {
			CommonFunctionality.wait(1000);
			WebElement Unit_intable = login.driver.findElement(By.xpath("//table/*[1]/tr[4]/th[2]"));
			String expectedCurrency = Unit_intable.getText();
			System.out.println(expectedCurrency);
	
			if (expectedCurrency.contains(Applied_currency)) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_21
		@And("^Select the Change option in tabel visual$")
		public void select_the_Change_option_in_tabel_visual() throws Throwable {
			CreateTable();
			WebDriverWait wait = new WebDriverWait(login.driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='series-edit--title']")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "EditseriesTable", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Change_Series_TV", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Change_pop", 8).click();
		}
	
		// TC_TV_21
		@And("^verify Change option from cogwheel icon$")
		public void verify_Change_option_from_cogwheel_icon() throws Throwable {
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
			System.out.println(FunctionApplied);
	
			if (FunctionApplied.contains("%CHANGE(Over Period; 1; Yes)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_22
		@And("^verify Remove series icon$")
		public void verify_Remove_series_icon() throws Throwable {
	
			Thread.sleep(2000);
			// WebElement Sereiesnameintable
			// =login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
	
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//th[@class='hor-vertical-header'])[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "RemoveIconseries", 8).click();
			verify_the_Table_visual_creating_from_View_panel_by_drag_and_drop();
		}
	
		// TC_TV_23
		@And("^verify tooltip for series$")
		public void verify_tooltip_for_series() throws Throwable {
	
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("//span[@class='series-edit--title']"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).isDisplayed());
		}
	
		// TC_TV_24
		@And("^verify scroll down till end of timepoints$")
		public void verify_scroll_down_till_end_of_timepoints() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
	
			WebElement element = login.driver.findElement(By.xpath("//img[@class='visual-item-wrapper--logo']"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEICData_Source"))).isDisplayed());
	
		}
	
		// TC_TV_25
		@And("^verify Name field when scroll down$")
		public void verify_Name_field_when_scroll_down() throws Throwable {
			CreateTable();
	
			CommonFunctionality.wait(4000);
			List<WebElement> listoftimepoints = login.driver.findElements(By.xpath("//table//tbody//tr/td[2]"));
			// WebElement element =
			// CommonFunctionality.getElementByXpath(login.driver,"//img[@class='visual-item-wrapper--logo']",8);
	
			for (int i = 0; i < listoftimepoints.size(); i++) {
				CommonFunctionality.wait(500);
				jse.executeScript("arguments[0].scrollIntoView(true);", listoftimepoints.get(i));
			}
			CommonFunctionality.wait(500);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name"))).isDisplayed());
	
		}
	
		// TC_TV_27
		@SuppressWarnings("deprecation")
		@And("^verify double click on title$")
		public void verify_double_click_on_title() throws Throwable {
	
			CommonFunctionality.wait(1000);
			WebElement Sereiesnameintable = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='visual-title--text text-dots'])[1]", 8);
			action.moveToElement(Sereiesnameintable).pause(1000).doubleClick().build().perform();
			Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "POP_title_close", 8).click();
		}
	
		// TC_TV_28
		@And("^verify clicking on edit icon for title$")
		public void verify_clicking_on_edit_icon_for_title() throws Throwable {
	
			CommonFunctionality.wait(2000);
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath("//i[@class='visual-title--icon visual-title--edit']"));
			action.moveToElement(Sereiesnameintable).pause(500).click().build().perform();
			Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title"))).isDisplayed());
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByProperty(login.driver, "POP_title_close", 8).click();
		}
	
		// TC_TV_29
		@And("^verify double click on attribute area$")
		public void verify_double_click_on_attribute_area() throws Throwable {
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).pause(500).doubleClick().build().perform();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Attributrpopup"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
		}
	
		// TC_TV_30
		@And("^verify Attributes popup -select all$")
		public void verify_Attributes_popup_select_all() throws Throwable {
	
			List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_before = attributes_list.size();
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
	
			WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Title']/following::*[contains(@class,'input-control__sm')][1]", 4);
			title_checkbox_webElement.click();
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
	
			List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_after = attributes_list_after.size();
	
			if (attributes_table_count_after != attributes_table_count_before) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_31
		@And("^verify Attributes popup -unselect all$")
		public void verify_Attributes_popup_unselect_all() throws Throwable {
	
			Thread.sleep(4000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).pause(500).doubleClick().build().perform();
			CommonFunctionality.wait(1000);
			WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
					"//*[text()='Title']/following::*[contains(@class,'input-control__sm')][1]", 4);
			action.moveToElement(title_checkbox_webElement).doubleClick().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
	
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Name"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_32
		@SuppressWarnings("deprecation")
		@And("^verify drag and drop attributes to change their order$")
		public void verify_drag_and_drop_attributes_to_change_their_order() throws Throwable {
	
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).pause(500).doubleClick().build().perform();
			CommonFunctionality.wait(500);
			WebElement sourceLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_name", 4);
			WebElement targetLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_FD", 4);
			action.clickAndHold(sourceLocator).pause(2000).dragAndDrop(sourceLocator, targetLocator).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
		}
	
		// TC_TV_33
		@And("^verify Attributes popup - Statistics$")
		public void verify_Attributes_popup_Statistics() throws Throwable {
	
			Thread.sleep(2000);
			List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_before = attributes_list.size();
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).doubleClick().pause(500).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Statistics_attributr", 8).click();
			WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(text(),'Statistics')]//following :: div[11]/div/label/span", 4);
			title_checkbox_webElement.click();
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
	
			List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_after = attributes_list_after.size();
	
			if (attributes_table_count_after != attributes_table_count_before) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_34
		@And("^verify Attributes popup - Statistics unselect all$")
		public void verify_Attributes_popup_Statistics_unselect_all() throws Throwable {
	
			Thread.sleep(5000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).pause(500).doubleClick().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Statistics_attributr", 8).click();
			Thread.sleep(2000);
			WebElement title_checkbox_webElement = CommonFunctionality.getElementByXpath(login.driver,
					"//div[contains(text(),'Statistics')]//following :: div[11]/div/label/span", 4);
			action.moveToElement(title_checkbox_webElement).click().build().perform();
			action.moveToElement(title_checkbox_webElement).pause(700).click().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Statistics_mean"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_35
		@And("^verify drag and drop Statistics attributes to change their order$")
		public void verify_drag_and_drop_Statistics_attributes_to_change_their_order() throws Throwable {
	
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
			WebElement sourceLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_name", 4);
			WebElement targetLocator = CommonFunctionality.getElementByProperty(login.driver, "Attributepopup_FD", 4);
			action.clickAndHold(sourceLocator).pause(2000).dragAndDrop(sourceLocator, targetLocator).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
		}
	
		// TC_TV_36
		@And("^verify default statistics selection for Table visual$")
		public void verify_default_statistics_selection_for_Table_visual() throws Throwable {
	
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).pause(500).doubleClick().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Statistics_attributr", 8).click();
			CommonFunctionality.wait(500);
			boolean statstitlecheckbox = login.driver
					.findElement(By.xpath("//div[contains(text(),'Statistics')]//following :: div[11]/div/label/span"))
					.isSelected();
			if (statstitlecheckbox == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
		}
	
		// TC_TV_37
		@And("^verify expand/collapse attribute and statistics sections$")
		public void verify_expand_collapse_attribute_and_statistics_sections() throws Throwable {
	
			Thread.sleep(5000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
	
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Attribute_verification"))).size() != 0) {
				System.out.println("Verified");
				login.driver.findElement(By.xpath("(//div[@class='icon-collapse'])[2]")).click();
			}
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Statistics_mean"))).size() != 0) {
				// (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Attribute_verification"))).size()
				// == 0)
				System.out.println("Verified");
				login.driver.findElement(By.xpath("(//div[@class='icon-expand'])[2]")).click();
			}
	
			else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Attributeclose", 8).click();
		}
	
		// TC_TV_36
		@And("^verify double clicking on date field$")
		public void verify_double_clicking_on_date_field() throws Throwable {
	
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_visual")));
			action.moveToElement(Sereiesnameintable).pause(700).doubleClick().build().perform();
			Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_popup"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "Date_Close", 8).click();
		}
	
		// TC_TV_37
		@And("^verify double clicking on timepoints$")
		public void verify_double_clicking_on_timepoints() throws Throwable {
	
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Timepoints_visual")));
			action.moveToElement(Sereiesnameintable).pause(700).doubleClick().build().perform();
			Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Date_popup"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "Date_Close", 8).click();
		}
	
		// TC_TV_38
		@And("^verify Edit series option for Table visual$")
		public void verify_Edit_series_option_for_Table_visual() throws Throwable {
	
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Series")));
			action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
			CommonFunctionality.wait(1000);
			boolean Editseries = login.driver.findElement(By.xpath("//*[contains(text(),'Edit Series')]")).isEnabled();
			if (Editseries == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_39
		@And("^verify series under Table tab$")
		public void verify_series_under_Table_tab() throws Throwable {
			Thread.sleep(4000);
			String BeforeSName = CommonFunctionality.getElementByProperty(login.driver, "Firstseries_getname", 8).getText();
			// CreateTable();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			Thread.sleep(2000);
			String AfterSName = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 8).getText();
			if (BeforeSName.equalsIgnoreCase(AfterSName)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_40
		@And("^verify Rename option$")
		public void verify_Rename_option() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "Rename_popup_close", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_41
		@And("^Select more than one series to my series tab$")
		public void select_more_than_one_series_to_my_series_tab() throws Throwable {
			Thread.sleep(5000);
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
			for (int i = 1; i <= 3; i++) {
				Thread.sleep(500);
				login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
			}
			CreateTable();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() > 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			} else {
				System.out.println("No Pop up appeared....");
			}
		}
	
		// TC_TV_42
		@And("^verify number of selected series in Rename pop up$")
		public void verify_number_of_selected_series_in_Rename_pop_up() throws Throwable {
	
			Thread.sleep(4000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			Thread.sleep(2000);
			List<WebElement> SName = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries")));
			int TotalSname = SName.size();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(2000);
			String selectedseries = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Selectedseries_Renamepopup"))).getText();
			String numberOnly = selectedseries.replaceAll("[^0-9]", "");
			int TotalSnamerenamepop = Integer.parseInt(numberOnly);
			if (TotalSname == TotalSnamerenamepop) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Rename_popup_close", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
	
		}
	
		// TC_TV_43
		@And("^verify number of available itmes in Rename pop Find field$")
		public void verify_number_of_available_itmes_in_Rename_pop_Find_field() throws Throwable {
			// CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			Thread.sleep(2000);
			List<WebElement> SName = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries")));
			int TotalSname = SName.size();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(2000);
			String selectedseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_count_find")))
					.getText();
			String numberOnly = selectedseries.replaceAll("[^0-9]", "");
			int TotalSnamerenamepop = Integer.parseInt(numberOnly);
			if (TotalSname == TotalSnamerenamepop) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Rename_popup_close", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_44
		@And("^verify find field in Rename pop$")
		public void verify_find_field_in_Rename_pop() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			String Findseriesbefore = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries_first", 8)
					.getText();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).sendKeys(Findseriesbefore);
			Thread.sleep(2000);
			String Findseriesafter = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Validation")))
					.getAttribute("value");
			if (Findseriesafter.contains(Findseriesbefore)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Rename_popup_close", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_45
		@And("^verify find number of searched result$")
		public void verify_find_number_of_searched_result() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			String Findseriesbefore = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries_first", 8)
					.getText();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).sendKeys(Findseriesbefore);
			List<WebElement> SName = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Find_Validation")));
			int TotalSname = SName.size();
			String selectedseries = CommonFunctionality.getElementByProperty(login.driver, "Series_count_find", 8)
					.getText();
			String numberOnly = selectedseries.replaceAll("[^0-9]", "");
			int TotalSnamerenamepop = Integer.parseInt(numberOnly);
			if (TotalSname == TotalSnamerenamepop) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Rename_popup_close", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_46
		@And("^verify Replace field in Rename pop$")
		public void verify_Replace_field_in_Rename_pop() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 4).click();
			CommonFunctionality.wait(500);
			String ReplaceFind = CommonFunctionality.getElementByProperty(login.driver, "Replace_first", 8)
					.getAttribute("value");
			CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).sendKeys(ReplaceFind);
			String Replaceafter = "Testing";
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByProperty(login.driver, "Replace_search_box", 8).sendKeys(Replaceafter);
			CommonFunctionality.getElementByProperty(login.driver, "Replace", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 6).click();
			Thread.sleep(1000);
			String Editseriesafterreplace = CommonFunctionality
					.getElementByProperty(login.driver, "Sname_EditSeries_first", 8).getText();
			if (Editseriesafterreplace.equalsIgnoreCase(Replaceafter)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_47
		@And("^verify Replace button in Rename pop$")
		public void verify_Replace_button_in_Rename_pop() throws Throwable {
			verify_Replace_field_in_Rename_pop();
		}
	
		// TC_TV_48
		@And("^verify Replace All button in Rename pop$")
		public void verify_Replace_All_button_in_Rename_pop() throws Throwable {
			Thread.sleep(2000);
	
			// CreateTable();
			for (int i = 1; i <= 3; i++) {
				login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
				Thread.sleep(500);
	
			}
			Thread.sleep(1000);
			WebElement mouseover = login.driver.findElement(By.xpath("(//*[@class='series-item--name'])[1]"));
			// mouseover.
			action.moveToElement(mouseover).pause(1000).contextClick().build().perform();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as Table')]", 8).click();
			try {
				CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Apply')]", 8).click();
			} catch (Exception e) {
				//
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(2000);
			String ReplaceFind = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Replace_first")))
					.getAttribute("value");
			CommonFunctionality.getElementByProperty(login.driver, "Find_search_box", 8).sendKeys(ReplaceFind);
			String Replaceafter = "Testing";
			CommonFunctionality.getElementByProperty(login.driver, "Replace_search_box", 8).sendKeys(Replaceafter);
			CommonFunctionality.getElementByProperty(login.driver, "Replace_All", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "OK_Button", 8).click();
			Thread.sleep(1000);
			String Editseriesafterreplace = CommonFunctionality
					.getElementByProperty(login.driver, "Sname_EditSeries_first", 8).getText();
			if (Editseriesafterreplace.contains(Replaceafter)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_48
		@And("^Select same series to my series tab$")
		public void select_same_series_to_my_series_tab() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "MyInsight_Tab", 8).click();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
			Thread.sleep(2000);
	
			for (int i = 1; i <= 3; i++) {
				login.driver.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
				Thread.sleep(500);
	
			}
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--title'])[1]", 8)
					.click();
		}
	
		// TC_TV_49
		@And("^verify Replace for selected series in Rename pop$")
		public void verify_Replace_for_selected_series_in_Rename_pop() throws Throwable {
			verify_Replace_field_in_Rename_pop();
		}
	
		// TC_TV_50
		@And("^verify find next button in Rename pop$")
		public void verify_find_next_button_in_Rename_pop() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(2000);
			boolean findnextbutton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_Next")))
					.isDisplayed();
			if (findnextbutton == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_51
		@And("^verify Replace, Replace All and find next buttons by default$")
		public void verify_Replace_Replace_All_and_find_next_buttons_by_default() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(2000);
			boolean findnextbutton = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("find_and_replace")))
					.isDisplayed();
			if (findnextbutton == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_52
		@And("^verify for invalid search$")
		public void verify_for_invalid_search() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Find_search_box"))).sendKeys("TESTING");
			String Nomatchesfound = "No matches found";
			String No_matches_found = CommonFunctionality.getElementByProperty(login.driver, "No_matches_found", 8)
					.getText();
			System.out.println(No_matches_found);
			if (No_matches_found.endsWith(Nomatchesfound)) {
				System.out.println("verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_53
		@And("^verify Edit series info dropdown$")
		public void verify_Edit_series_info_dropdown() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info", 8).click();
			String[] Dropdown = { "Name", "Function description", "Unit", "Frequency", " Region" };
			CommonFunctionality.wait(1000);
			List<WebElement> dropdownvaue = login.driver
					.findElements(By.xpath("//select[@class='find-and-replace--attribute-selector']/option"));
			for (WebElement we : dropdownvaue) {
				boolean match = false;
				for (int i = 0; i < Dropdown.length; i++) {
					if (we.getText().equals(Dropdown[i])) {
						match = true;
						System.out.println(we + ":" + Dropdown[i]);
	
						System.out.println("verified");
					}
				}
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_54
		@And("^verify default selection for Edit series info dropdown$")
		public void verify_default_selection_for_Edit_series_info_dropdown() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			String y = "Name";
			Thread.sleep(2000);
			String Editinfodefault = login.driver
					.findElement(By.xpath("//select[@class='find-and-replace--attribute-selector']/option")).getText();
			if (Editinfodefault.contains(y)) {
				System.out.println("verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_55
		@And("^verify Rename Name selection$")
		public void verify_Rename_Name_selection() throws Throwable {
	
			CommonFunctionality.wait(5000);
			String series_name = CommonFunctionality.getElementByProperty(login.driver, "Seriesnametable", 10).getText();
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.wait(500);
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(2000);
			String Rename_series_name = CommonFunctionality.getElementByProperty(login.driver, "Rename_first_series", 10)
					.getAttribute("value");
	
			if (series_name.equalsIgnoreCase(Rename_series_name)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_56
		@And("^verify Rename Function description selection$")
		public void verify_Rename_Function_description_selection() throws Throwable {
	
			// CreateTable();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_FD", 8).click();
			Thread.sleep(2000);
			String Rename_fseries_name = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).getAttribute("value");
			if (FunctionApplied.equalsIgnoreCase(Rename_fseries_name)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
	
		}
	
		// TC_TV_57
		@And("^verify Rename function description selection without function apply$")
		public void verify_Rename_function_description_selection_without_function_apply() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_FD", 8).click();
			CommonFunctionality.wait(1000);
			String Rename_fseries_name = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).getAttribute("value");
	
			if (Rename_fseries_name.isEmpty()) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_58
		@And("^verify editing function description$")
		public void verify_editing_function_description() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_FD", 8).click();
			String x = "Testing";
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Rename_first_series", 8).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_first_series", 8).sendKeys(x);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 8).click();
			Thread.sleep(3000);
			String Y = CommonFunctionality.getElementByProperty(login.driver, "series_name_title", 8).getText();
			String[] parts = Y.split(";");
			String part2 = parts[1];
			System.out.println("Verified" + x + part2);
	
			if (!x.contains(part2)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
	
		}
	
		// TC_TV_59
		@And("^verify adding function description$")
		public void verify_adding_function_description() throws Throwable {
			CreateTable();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_FD", 8).click();
	
			String x = "SUM";
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).sendKeys(x);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OKRename"))).click();
			String Y = CommonFunctionality.getElementByProperty(login.driver, "series_name_title", 8).getText();
			String[] parts = Y.split(";");
			String part2 = parts[1].replaceAll("\\s+", "");
			System.out.println("Verified" + x + part2);
	
			if (x.contains(part2)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
	
		}
	
		// TC_TV_60
		@And("^verify Function discription apply original title icon$")
		public void verify_Function_discription_apply_original_title_icon() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_FD", 8).click();
			String x = "SUM";
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).sendKeys(x);
			boolean Apply = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).isEnabled();
			if (Apply == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
	
		}
	
		// TC_TV_61
		@And("^verify Function discription Apply original title icon behavior$")
		public void verify_Function_discription_Apply_original_title_icon_behavior() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_FD", 8).click();
	
			String x = "SUM";
			CommonFunctionality.getElementByProperty(login.driver, "Rename_first_series", 8).sendKeys(x);
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Origional_icon_behaviour", 8).click();
			Thread.sleep(2000);
			String Rename_fseries_name = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Rename_first_series"))).getAttribute("value");
			if (Rename_fseries_name.isEmpty()) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
	
		}
	
		// TC_TV_62
		@And("^verify Function discription  Apply original title for all series icon$")
		public void verify_Function_discription_Apply_original_title_for_all_series_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(1000);
			ArrayList<String> ar = new ArrayList<String>();
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series")))
					.getAttribute("value");
			ar.add(x);
			Thread.sleep(1000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series")))
					.getAttribute("value");
			ar.add(y);
			Thread.sleep(1000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series")))
					.getAttribute("value");
			ar.add(z);
			System.out.println("Verified" + ar.toString());
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys("Testing1");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series"))).sendKeys("Testing2");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series"))).sendKeys("Testing3");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).click();
			Thread.sleep(1000);
	
			ArrayList<String> ar1 = new ArrayList<String>();
			String x1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series")))
					.getAttribute("value");
			ar1.add(x1);
			Thread.sleep(1000);
			String y1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_secondall_series")))
					.getAttribute("value");
			ar1.add(y1);
			Thread.sleep(1000);
			String z1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_thirdall_series")))
					.getAttribute("value");
			ar1.add(z1);
			System.out.println("Verified123" + ar1.toString());
			if (ar.equals(ar1)) {
				System.out.println("Verified");
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
				try {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 8).click();
				} catch (Exception e) {
	
				}
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_63
		@And("^verify Function discription  clicking on series name$")
		public void verify_Function_discription_clicking_on_series_name() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_FD", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Link_series", 8).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("SSPtable"))).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			WebElement Close = CommonFunctionality.getElementByProperty(login.driver, "SSPtable_close_table", 8);
			action.moveToElement(Close).click().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			try {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 8).click();
			} catch (Exception e) {
	
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_64
		@And("^verify Name Editing series name$")
		public void verify_Name_Editing_series_name() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).clear();
			String x = "Testing";
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).sendKeys(x);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 8).click();
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText()
					.replaceAll("\\s+", "");
			if (x.equalsIgnoreCase(y)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_65
		@And("^verify Apply original title icon$")
		public void verify_Apply_original_title_icon() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(1000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series")))
					.getAttribute("value");
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).sendKeys("Testing1");
			CommonFunctionality.getElementByProperty(login.driver, "All_Series_back", 8).click();
			Thread.sleep(1000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series")))
					.getAttribute("value");
			if (x.equalsIgnoreCase(y)) {
				System.out.println("Verified");
			} else {
				CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
				try {
					CommonFunctionality.getElementByXpath(login.driver,
							"//*[@class='modal-window modal-window__active']//*[contains(text(),'Ok')]", 8).click();
				} catch (Exception e) {
	
				}
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_66
		@And("^verify Apply original title for all series icon$")
		public void verify_Apply_original_title_for_all_series_icon() throws Throwable {
			verify_Function_discription_Apply_original_title_for_all_series_icon();
		}
	
		// TC_TV_67
		@And("^verify < icon if no changes in series attributes$")
		public void verify_icon_if_no_changes_in_series_attributes() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			Thread.sleep(1000);
			boolean icon = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Series_back"))).isEnabled();
			System.out.println("Verified" + icon);
			if (icon == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_68
		@And("^verify Region selection$")
		public void verify_Region_selection() throws Throwable {
			Thread.sleep(2500);
	
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Region"))).getText();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 8).click();
			CommonFunctionality.wait(1000);
			String y = CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8)
					.getAttribute("value");
			if (x.equalsIgnoreCase(y)) {
				System.out.println("Verified");
	
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_69
		@And("^verify Editing series region$")
		public void verify_Editing_series_region() throws Throwable {
	
			Thread.sleep(3000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 8).click();
			String a = " TestingRegion";
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2500);
	
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
			String[] parts = Y.split(";");
			String part2 = parts[1];
			System.out.println("Verified" + a + part2);
	
			if (a.matches(part2)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_70
		@And("^verify Region Apply original region icon$")
		public void verify_Region_Apply_original_region_icon() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 8).click();
			String a = " TestingRegion";
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "All_Series_back", 8).click();
			Thread.sleep(2000);
			String value = login.driver
					.findElement(
							By.xpath("//input[@class='form--control form--control__sm find-and-replace-item--name-input']"))
					.getAttribute("value");
			System.out.println("value:" + value);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 8).click();
			Thread.sleep(2000);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
			System.out.println("Y:" + Y);
	
			// String op= Y+"; "+value;
			String op = value;
			System.out.println("op:" + op);
			Thread.sleep(2000);
			String table_region = CommonFunctionality.getElementByProperty(login.driver, "Table_Region", 8).getText();
	
			System.out.println("table_region:" + table_region);
			if (op.equalsIgnoreCase(table_region)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 9).click();
		}
	
		// TC_TV_71
		@And("^verify Region Apply original region for all series icon$")
		public void verify_Region_Apply_original_region_for_all_series_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).sendKeys("Testing1");
			CommonFunctionality.getElementByProperty(login.driver, "Rename_secondall_series", 9).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_secondall_series", 9).sendKeys("Testing2");
			CommonFunctionality.getElementByProperty(login.driver, "Rename_thirdall_series", 9).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_thirdall_series", 9).sendKeys("Testing3");
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "All_Series_back", 10).click();
			Thread.sleep(2000);
			String value1 = login.driver
					.findElement(By.xpath(
							"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[1]"))
					.getAttribute("value");
			System.out.println("value:" + value1);
	
			String value2 = login.driver
					.findElement(By.xpath(
							"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[2]"))
					.getAttribute("value");
			System.out.println("value:" + value2);
	
			String value3 = login.driver
					.findElement(By.xpath(
							"(//input[@class='form--control form--control__sm find-and-replace-item--name-input'])[3]"))
					.getAttribute("value");
			System.out.println("value:" + value3);
	
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2000);
	
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText();
			System.out.println(x);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname")))
					.getText();
			System.out.println(Y);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname")))
					.getText();
			System.out.println(z);
	
			Thread.sleep(2000);
	
			if (x.contains(value1) && Y.contains(value2) && z.contains(value3)) {
				System.out.println("Verified");
			}
	
			else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 9).click();
		}
	
		// TC_TV_72
		@And("^verify unit Editing series unit$")
		public void verify_unit_Editing_series_unit() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_unit", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_unit", 8).click();
	
			Thread.sleep(2000);
			String a = " Testingunit";
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 6).click();
	
			Thread.sleep(5000);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
			// System.out.println(Y);
			String[] parts = Y.split(";");
			System.out.println(parts.length);
			String part2 = parts[1].replaceAll("\\s+", "");
			System.out.println("Y: " + Y);
			System.out.println("a: " + a);
			System.out.println("part2:" + part2);
			if (a.contains(part2)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_73
		@And("^verify unit Apply original unit icon$")
		public void verify_unit_Apply_original_unit_icon() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_unit", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_unit", 8).click();
	
			Thread.sleep(2000);
			String a = " Testingunit";
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 9).click();
	
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_unit", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "All_Series_back", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 9).click();
	
			Thread.sleep(2000);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
			String[] parts = Y.split(";");
			System.out.println(Y.length());
			String part2 = parts[1].replaceAll("\\s+", "");
			Thread.sleep(2000);
			String table_unit = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_unit"))).getText()
					.replaceAll("\\s+", "");
			System.out.println("123" + table_unit + part2);
			System.out.println("part2:" + part2);
			System.out.println("table_unit:" + table_unit);
			if (part2.equalsIgnoreCase(table_unit)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_74
		@And("^verify unit Apply original unit for all series icon$")
		public void verify_unit_Apply_original_unit_for_all_series_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_unit", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_unit", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).sendKeys("Testing1");
			CommonFunctionality.getElementByProperty(login.driver, "Rename_secondall_series", 9).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_secondall_series", 9).sendKeys("Testing2");
			CommonFunctionality.getElementByProperty(login.driver, "Rename_thirdall_series", 10).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_thirdall_series", 9).sendKeys("Testing3");
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_unit", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "All_Series_back", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText();
			String[] parts1 = x.split(";");
			String Firstseries = parts1[1].replaceAll("\\s+", "");
			System.out.println(Firstseries);
			Thread.sleep(1000);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname")))
					.getText();
			String[] parts2 = Y.split(";");
			String secondseries = parts2[1].replaceAll("\\s+", "");
			System.out.println(secondseries);
			Thread.sleep(1000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname")))
					.getText();
			String[] parts3 = z.split(";");
			String thirdseries = parts3[1].replaceAll("\\s+", "");
			System.out.println(thirdseries);
			Thread.sleep(1000);
			String a = CommonFunctionality.getElementByProperty(login.driver, "All_second_rename_unit", 10).getText()
					.replaceAll("\\s+", "");
			String b = CommonFunctionality.getElementByProperty(login.driver, "All_Third_rename_unit", 10).getText()
					.replaceAll("\\s+", "");
			String c = CommonFunctionality.getElementByProperty(login.driver, "All_fourth_rename_unit", 10).getText()
					.replaceAll("\\s+", "");
	
			System.out.println("Verified region:" + Firstseries + a + secondseries + b + thirdseries + c);
	
			Thread.sleep(2000);
			if (Firstseries.equalsIgnoreCase(a) && secondseries.equalsIgnoreCase(b) && thirdseries.equalsIgnoreCase(c)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_75
		@And("^verify frequency Editing series frequency$")
		public void verify_frequency_Editing_series_frequency() throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_frequency", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_frequency", 9).click();
			Thread.sleep(2000);
			String a = " TestingRegion";
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_firstall_series"))).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2000);
	
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
			System.out.println(Y);
			String[] parts = Y.split(";");
	
			String aaaa = parts.toString();
			System.out.println(aaaa);
			String part2 = parts[1];
			System.out.println("Verified" + a + part2);
	
			if (a.matches(part2)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_76
		@And("^verify frequency Apply original frequency icon$")
		public void verify_frequency_Apply_original_frequency_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_frequency", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_frequency", 10).click();
	
			String a = " Testingunit";
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_frequency", 9).click();
			CommonFunctionality.getElementByProperty(login.driver, "All_Series_back", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 8).click();
	
			Thread.sleep(2000);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText();
			String[] parts = Y.split(";");
			String part2 = parts[1].replaceAll("\\s+", "");
			Thread.sleep(2000);
			String table_frequency = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_frquency")))
					.getText().replaceAll("\\s+", "");
			System.out.println("123" + table_frequency + part2);
	
			if (part2.equalsIgnoreCase(table_frequency)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_77
		@And("^verify frequency Apply original frequency for all series icon$")
		public void verify_frequency_Apply_original_frequency_for_all_series_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_frequency", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_frequency", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).sendKeys("Testing1");
			CommonFunctionality.getElementByProperty(login.driver, "Rename_secondall_series", 10).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_secondall_series", 10).sendKeys("Testing2");
			CommonFunctionality.getElementByProperty(login.driver, "Rename_thirdall_series", 10).clear();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_thirdall_series", 10).sendKeys("Testing3");
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_frequency", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "All_Series_back", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText();
			String[] parts1 = x.split(";");
			String Firstseries = parts1[1].replaceAll("\\s+", "");
			System.out.println(Firstseries);
	
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname")))
					.getText();
			String[] parts2 = Y.split(";");
	
			String secondseries = parts2[1].replaceAll("\\s+", "");
			System.out.println(secondseries);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname")))
					.getText();
			String[] parts3 = z.split(";");
			String thirdseries = parts3[1].replaceAll("\\s+", "");
			System.out.println(thirdseries);
	
			String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_frequency")))
					.getText().replaceAll("\\s+", "");
			String b = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_third_rename_frequency")))
					.getText().replaceAll("\\s+", "");
			String c = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_frequency")))
					.getText().replaceAll("\\s+", "");
	
			System.out.println("Verified region" + Firstseries + a + secondseries + b + thirdseries + c);
	
			Thread.sleep(1000);
			if (Firstseries.equalsIgnoreCase(a) && secondseries.equalsIgnoreCase(b) && thirdseries.equalsIgnoreCase(c)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
	
		}
	
		// TC_TV_78
		@And("^verify Rename Auto name check box$")
		public void verify_Rename_Auto_name_check_box() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			Thread.sleep(1000);
			boolean checkbox = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Autoname_checkbox")))
					.isSelected();
			System.out.println(checkbox);
			if (checkbox == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_79
		@And("^verify Rename attributes dropdown$")
		public void verify_Rename_attributes_dropdown() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Autoname_dropdown1"))).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_80
		@And("^verify Rename selection of attributes$")
		public void verify_Rename_selection_of_attributes() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2000);
			String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region"))).getText()
					.replaceAll("\\s+", "");
			Thread.sleep(2000);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_series_rename"))).getText()
					.replaceAll("\\s+", "");
			String[] parts = Y.split(";");
			String part1 = parts[0];
			String part2 = parts[1];
			System.out.println(part1);
			System.out.println(part2);
			System.out.println("Verified" + a + part2);
	
			if (a.matches(part2)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_81
		@And("^verify Rename selecting multiple attributes for series name$")
		public void verify_Rename_selecting_multiple_attributes_for_series_name() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2000);
			String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region"))).getText()
					.replaceAll("\\s+", "");
			String b = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region"))).getText()
					.replaceAll("\\s+", "");
			String c = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region"))).getText()
					.replaceAll("\\s+", "");
			Thread.sleep(2000);
			String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText().replaceAll("\\s+", "");
			String[] parts = Y.split(";");
			String part2 = parts[1];
	
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_Third_rename_region_sname")))
					.getText().replaceAll("\\s+", "");
			String[] parts1 = x.split(";");
			String part3 = parts1[1];
	
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_fourth_rename_region_sname")))
					.getText().replaceAll("\\s+", "");
			String[] parts2 = z.split(";");
			String part4 = parts2[1];
			System.out.println("Verified region" + part2 + a + part3 + b + part4 + c);
			if (part2.equalsIgnoreCase(a) && part3.equalsIgnoreCase(b) && part4.equalsIgnoreCase(c)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_82
		@And("^verify Rename series in My series after visual series renamed$")
		public void verify_Rename_series_in_My_series_after_visual_series_renamed() throws Throwable {
			try {
				System.out.println("Enter into try block");
				CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).clear();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).sendKeys("Testing1");
				CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
	
				Thread.sleep(2000);
				String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
						.getText().replaceAll("\\s+", "");
				String[] parts = Y.split(";");
				String part2 = parts[1];
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Data_Tab"))).click();
	
				WebElement series = CommonFunctionality.getElementByProperty(login.driver, "Table_Series_Name", 10);
				action.moveToElement(series).build().perform();
				CommonFunctionality.getElementByProperty(login.driver, "Table_Series_Name", 10).click();
				Thread.sleep(2000);
				String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_SSP_Region"))).getText()
						.replaceAll("//s+", "");
				CommonFunctionality.getElementByProperty(login.driver, "SSPtable_close_table", 10).click();
	
				if (!part2.equalsIgnoreCase(a)) {
					System.out.println("Verified");
				} else {
					Assert.fail();
				}
	
			} catch (org.openqa.selenium.StaleElementReferenceException ex)
	
			{
				System.out.println("Enter into catch block");
				CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 10).click();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).clear();
				CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).sendKeys("Testing1");
				CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
	
				Thread.sleep(2000);
				String Y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
						.getText().replaceAll("\\s+", "");
				String[] parts = Y.split(";");
				String part2 = parts[1];
				CommonFunctionality.getElementByProperty(login.driver, "Data_Tab", 10).click();
	
				WebElement series = CommonFunctionality.getElementByProperty(login.driver, "Table_Series_Name", 10);
				action.moveToElement(series).build().perform();
				CommonFunctionality.getElementByProperty(login.driver, "Table_Series_Name", 10).click();
				Thread.sleep(2000);
				String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_SSP_Region"))).getText()
						.replaceAll("//s+", "");
				CommonFunctionality.getElementByProperty(login.driver, "SSPtable_close_table", 10).click();
	
				if (!part2.equalsIgnoreCase(a)) {
					System.out.println("Verified");
				} else {
					Assert.fail();
				}
			}
	
		}
	
		// TC_TV_83
		@And("^verify Rename Apply button$")
		public void verify_Rename_Apply_button() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).clear();
			String a = "Testing";
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 8).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "Applay_Button", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll("//s+", "");
			String[] parts1 = x.split(";");
			String part3 = parts1[1].replaceAll(" ", "");
			System.out.println("Verified123456" + part3);
			System.out.println("Verified" + a + part3);
	
			if (a.contains(part3)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
		}
	
		// TC_TV_84
		@And("^verify Rename OK button$")
		public void verify_Rename_OK_button() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Addbutton_region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_series_info_dropdown", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Region", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).clear();
			String a = "Testing";
			CommonFunctionality.getElementByProperty(login.driver, "Rename_firstall_series", 10).sendKeys(a);
			CommonFunctionality.getElementByProperty(login.driver, "OKRename", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText().replaceAll("//s+", "");
			String[] parts1 = x.split(";");
			String part3 = parts1[1].replaceAll(" ", "");
			System.out.println("Verified" + a + part3);
	
			if (a.contains(part3)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_85
		@And("^verify Rename Minimize option$")
		public void verify_Rename_Minimize_option() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Expand_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Collapse_rename", 10).click();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
		}
	
		// TC_TV_86
		@And("^verify Rename maximiz option$")
		public void verify_Rename_maximiz_option() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Expand_rename", 10).click();
			Thread.sleep(1000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
		}
	
		// TC_TV_87
		@And("^verify Rename full screen$")
		public void verify_Rename_full_screen() throws Throwable {
			verify_Rename_maximiz_option();
		}
	
		// TC_TV_88
		@And("^verify Rename exit full screen$")
		public void verify_Rename_exit_full_screen() throws Throwable {
			verify_Rename_Minimize_option();
		}
	
		// TC_TV_89
		@And("^verify Rename Cancel/x icon$")
		public void verify_Rename_Cancel_x_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Rename_Edit_series", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
	
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_90
		@And("^verify Rename opening rename popup by keyboard shortcut$")
		public void verify_Rename_opening_rename_popup_by_keyboard_shortcut() throws Throwable {
			WebElement chkbox = login.driver
					.findElement(By.xpath("(//span[@class='series-list-item--checkbox svg-checkbox'])[1]"));
			action.moveToElement(chkbox).click(chkbox).build().perform();
	
			Thread.sleep(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_H);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_H);
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Rename_Edit_series"))).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
		}
	
		// TC_TV_91
		@And("^verify Edit series appling Currency conversation function$")
		public void verify_Edit_series_appling_Currency_conversation_function() throws Throwable {
			CreateTable();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function", 10).click();
			Thread.sleep(3000);
			String a = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Currency_conversation_function")))
					.getText().replaceAll(" ", "");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Currency_conversation_function", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_unit"))).getText()
					.replaceAll(" ", "");
			System.out.println("Verified" + a + x);
			if (x.contains(a)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_92
		@And("^verify Edit series appling Calculate change function$")
		public void verify_Edit_series_appling_Calculate_change_function() throws Throwable {
	
			CreateTable();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function", 10).click();
			Thread.sleep(2000);
			String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll(" ", "");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Calculate_Change_function", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll(" ", "");
			System.out.println("Verified" + a + x);
			if (!x.equalsIgnoreCase(a)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_93
		@And("^verify Edit series appling Aggregate function$")
		public void verify_Edit_series_appling_Aggregate_function() throws Throwable {
			CreateTable();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function", 10).click();
			Thread.sleep(2000);
			String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Aggregate_function")))
					.getText().replaceAll(" ", "");
			CommonFunctionality.getElementByProperty(login.driver, "Aggregate_function", 10).click();
			// CommonFunctionality.getElementByProperty(login.driver,"Editseries_Aggregate_function",10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll(" ", "");
			// System.out.println("x==:" + x);
			// String[] parts1 = x.split(";");
			// String part3 = parts1[3].replaceAll(" ", "");
			// String part4 = part3.substring(0, 1);
			// System.out.println("Verified" + a + part4);
			//
			// System.out.println("Verified" + a + x);
			// if (part4.equalsIgnoreCase(a)) {
			if (x.contains(a)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_94
		@And("^verify Edit series appling Accumulate function$")
		public void verify_Edit_series_appling_Accumulate_function() throws Throwable {
			CreateTable();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function", 10).click();
			Thread.sleep(2000);
			String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Accumulate_function")))
					.getText().replaceAll(" ", "");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Accumulate_function", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll(" ", "");
			String[] parts1 = x.split(";");
			String part3 = parts1[1].replaceAll(" ", "");
			String part4 = part3.substring(0, 3);
			System.out.println("Verified" + a + part4);
	
			System.out.println("Verified" + a + x);
			if (part4.equalsIgnoreCase(a)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_95
		@And("^verify Edit series FX more drop down$")
		public void verify_Edit_series_FX_more_drop_down() throws Throwable {
			verify_Edit_series_appling_Accumulate_function();
		}
	
		// TC_TV_96
		@And("^verify Edit series FX more icon$")
		public void verify_Edit_series_FX_more_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			// CommonFunctionality.getElementByProperty(login.driver,"Editseries_functionWithoutseriesid",10).click();
			// CommonFunctionality.getElementByProperty(login.driver,"Editseries_function_link",10).click();
			CommonFunctionality.getElementByProperty(login.driver, "fx_icon", 10).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup")))
					.isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
		}
	
		// TC_TV_97
		@And("^verify Edit series appling function by clicking on function icon$")
		public void verify_Edit_series_appling_function_by_clicking_on_function_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			// CommonFunctionality.getElementByProperty(login.driver,"Editseries_functionWithoutseriesid",10).click();
			// CommonFunctionality.getElementByProperty(login.driver,"Editseries_function_link",10).click();
			CommonFunctionality.getElementByProperty(login.driver, "fx_icon", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Function_search_popup", 10).sendKeys("Change");
	
			Actions functiondclick = new Actions(login.driver);
			WebElement Fdoubleclick = CommonFunctionality.getElementByProperty(login.driver,
					"Editseries_function_popup_Change", 10);
			functiondclick.moveToElement(Fdoubleclick).doubleClick().build().perform();
			Thread.sleep(1000);
			String a = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup_Fname")))
					.getText().replaceAll(" ", "");
			CommonFunctionality.getElementByProperty(login.driver, "Applay_Button", 10).click();
			Thread.sleep(1000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText().replaceAll(" ", "");
			System.out.println("Verified1" + x);
			String[] parts1 = x.split(";");
			System.out.println("Verified123" + parts1[1]);
			String secondpart = parts1[1];
			String q = secondpart.substring(0, 7);
			System.out.println("Verified" + a + q);
			if (q.equalsIgnoreCase(a)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_98
		@And("^verify Edit series ahiding/showing function toolbar$")
		public void verify_Edit_series_ahiding_showing_function_toolbar() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_hiding_icon", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_open_icon", 10).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar"))).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_99
		@And("^verify Edit series Type a function field$")
		public void verify_Edit_series_Type_a_function_field() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("Change");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 8).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_searchbar")))
					.getText().replaceAll(" ", "");
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText().replaceAll(" ", "");
			System.out.println("Verified1" + y);
			String[] parts1 = x.split(";");
			System.out.println("Verified2" + parts1[0]);
			String secondpart = parts1[0];
			System.out.println("Verified4" + parts1[0] + secondpart);
	
			if (secondpart.equalsIgnoreCase(x)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_100
		@And("^verify Edit series FX icon$")
		public void verify_Edit_series_FX_icon() throws Throwable {
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_FX_icon", 10).click();
			Thread.sleep(1000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup"))).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
		}
	
		// TC_TV_101
		@And("^verify Edit delete series icon$")
		public void verify_Edit_delete_series_icon() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_X_icon", 10).click();
			Thread.sleep(1000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_X_icon_after"))).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_102
		@And("^verify Edit delete all series icon$")
		public void verify_Edit_delete_all_series_icon() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_X_icon", 10).click();
			Thread.sleep(1000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_X_icon_after"))).size() != 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_103
		@And("^verify Edit SSP by clicking on series name$")
		public void verify_Edit_SSP_by_clicking_on_series_name() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 10).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
			System.out.println("verified clicking on series name");
			CommonFunctionality.getElementByProperty(login.driver, "SSPtable_close_table", 10).click();
	
		}
	
		// TC_TV_104
		@And("^verify Edit Rename series icon$")
		public void verify_Edit_Rename_series_icon() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			WebElement we = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-name--icon'])[1]",
					10);
			action.moveToElement(we).pause(1000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_icon_rename", 10).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_rename_popup")))
					.isDisplayed());
			System.out.println("verified clicking on series name");
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		}
	
		// TC_TV_105
		@And("^verify Edit edit series icon$")
		public void verify_Edit_edit_series_icon() throws Throwable {
	
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			Thread.sleep(2000);
			WebElement we = CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='series-name--icon'])[1]",
					8);
			action.moveToElement(we).pause(5000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_icon_setting", 10).click();
	
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting_dropdown"))).isDisplayed());
			System.out.println("verified clicking on series name");
		}
	
		// TC_TV_106
		@And("^verify Edit Rename option under edit series$")
		public void verify_Edit_Rename_option_under_edit_series() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			Thread.sleep(2000);
			WebElement we = login.driver.findElement(By.xpath("(//div[@class='series-name--icon'])[1]"));
			action.moveToElement(we).pause(1000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_icon_setting", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_icon_setting_dropdown_rename", 10).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_rename_popup")))
					.isDisplayed());
			System.out.println("verified clicking on series name");
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
		}
	
		// TC_TV_107
		@And("^verify Edit Frequency option under edit series$")
		public void verify_Edit_Frequency_option_under_edit_series() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			WebElement we = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-name--title']", 8);
			action.moveToElement(we).pause(1000).build().perform();
			String x = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 8).getText();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_icon_setting", 10).click();
			WebElement we1 = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//following ::div[3]/li[3]", 8);
			action.moveToElement(we1).pause(1000).build().perform();
			WebElement we2 = CommonFunctionality.getElementByProperty(login.driver,
					"Editseries_icon_setting_dropdown_frequency_SUM", 8);
			action.moveToElement(we2).pause(1000).click().build().perform();
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_icon_setting_dropdown_frequency_SUM"))).click();
	
			String y = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 10).getText();
			System.out.println("Verified" + x + y);
			if (!x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_108
		@And("^verify Edit Currency option under edit series$")
		public void verify_Edit_Currency_option_under_edit_series() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			WebElement we = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-name--title']", 8);
			action.moveToElement(we).pause(1000).build().perform();
			String x = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 8).getText();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_icon_setting", 10).click();
			CommonFunctionality.wait(500);
			WebElement we1 = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//following ::div[3]/li[4]", 10);
			we1.click();
			CommonFunctionality.wait(500);
			WebElement we2 = CommonFunctionality.getElementByXpath(login.driver, "//*[@title='RUB']", 10);
			action.moveToElement(we2).pause(1000).click().build().perform();
			Thread.sleep(1000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("//*[@title='%
			// Period-over-Period Annualized (%PoP)']"))).click();
			String y = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 10).getText();
			System.out.println("Verified" + x + y);
			if (!x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_109
		@And("^verify Edit Change option under edit series$")
		public void verify_Edit_Change_option_under_edit_series() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			WebElement we = CommonFunctionality.getElementByXpath(login.driver, "//div[@class='series-name--title']", 8);
			action.moveToElement(we).pause(1000).build().perform();
			String x = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 8).getText();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_icon_setting", 10).click();
	
			WebElement we1 = CommonFunctionality.getElementByXpath(login.driver,
					"//ul[@class='dropdown-menu context-menu edit-series--context-menu']//following ::div[3]/li[5]", 10);
			action.moveToElement(we1).pause(1000).build().perform();
	
			WebElement we2 = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='% Period-over-Period Annualized (%PoP)']", 10);
			action.moveToElement(we2).pause(1000).click().build().perform();
			Thread.sleep(500);
			String y = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 10).getText();
			System.out.println("Verified" + x + y);
			if (!x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_110
		@And("^verify Edit clicking on frequency or dropdown$")
		public void verify_Edit_clicking_on_frequency_or_dropdown() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency", 10).click();
			CommonFunctionality.wait(1000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_Series_Harmonization")))
					.isDisplayed());
			System.out.println("verified clicking on Frequency");
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_110
		@And("^Select series to my series tab$")
		public void select_series_to_my_series_tab() throws Throwable {
			Thread.sleep(5000);
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 10).click();
	
			List<WebElement> Totallist = login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
			System.out.println("Totallist size are:" + Totallist.size());
	
			for (int i = 1; i <= Totallist.size(); i++) {
				Thread.sleep(500);
				login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
			}
			Thread.sleep(1000);
			// click on + icon
			CommonFunctionality.getElementByXpath(login.driver, "(//div[@class='add-to-data-selection--icon'])[1]", 8)
					.click();
			Thread.sleep(600);
			WebElement mouseover = CommonFunctionality.getElementByXpath(login.driver,
					"(//*[@class='series-name-field--series-name'])[1]", 9);
			// mouseover.
			action.moveToElement(mouseover).pause(500).contextClick().build().perform();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as Table')]", 8).click();
			Thread.sleep(500);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() > 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			} else {
				System.out.println("No Pop up appeared....");
			}
	
		}
	
		// TC_TV_111
	
		@Given("^User Select Series ID \"([^\"]*)\"$")
		public void user_Select_Series_ID(String arg1) throws Throwable {
	
			Thread.sleep(2000);
			// click on search bar
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).click();
			Thread.sleep(1000);
			// clear on search bar
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).clear();
	
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(arg1);
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//input[@class='search-input-text']")).sendKeys(Keys.ENTER);
			Thread.sleep(10000);
			Thread.sleep(5000);
			// click on series
			login.driver.findElement(By.xpath("(//*[@class='toggler-control-item--label'])[2]")).click();
			Thread.sleep(2000);
			List<WebElement> Totallist = login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
			System.out.println("Totallist size are:" + Totallist.size());
	
			for (int i = 1; i <= Totallist.size(); i++) {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
			}
			Thread.sleep(2000);
	
			WebElement mouseover = login.driver.findElement(By.xpath("(//div[@class='series-item--name'])[1]"));
			Thread.sleep(2000);
			String value = mouseover.getText().toString();
			System.out.println("value:" + value);
			// mouseover.
			action.moveToElement(mouseover).pause(1000).contextClick().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//span[contains(text(),'View as Table')]")).click();
			Thread.sleep(2000);
	
			if (login.driver.findElements(By.xpath("//div[@class='movable-modal--close']")).size() == 1) {
				login.driver.findElement(By.xpath("//div[@class='movable-modal--close']")).click();
			}
	
			else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_111
		@And("^verify Edit Series data conversion -applying frequency$")
		public void verify_Edit_Series_data_conversion_applying_frequency() throws Throwable {
			Thread.sleep(2000);
			String x = CommonFunctionality.getElementByXpath(login.driver, "//thead/tr[3]/th[2]", 8).getText();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency", 9).click();
			Thread.sleep(500);
			CommonFunctionality.getElementByProperty(login.driver, "Applay_Button", 9).click();
			Thread.sleep(2000);
			String y = CommonFunctionality
					.getElementByProperty(login.driver, "Editseries_Frequency_Second_Series_Harmonization", 8).getText();
	
			if (!x.equalsIgnoreCase(y)) {
				System.out.println("Verified");
	
			} else {
				Assert.fail();
			}
	
			System.out.println("verified clicking on Frequency");
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_112
		@And("^verify Edit Series data conversion -applying Missing values method$")
		public void verify_Edit_Series_data_conversion_applying_Missing_values_method() throws Throwable {
			verify_Edit_Series_data_conversion_applying_frequency();
		}
	
		// TC_TV_113
		@And("^verify Edit Series data conversion -Apply button$")
		public void verify_Edit_Series_data_conversion_Apply_button() throws Throwable {
			verify_Edit_Series_data_conversion_applying_frequency();
		}
	
		// TC_TV_114
		@And("^verify Series data Minimize$")
		public void verify_Series_data_Minimize() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Expand_rename", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Collapse_rename", 10).click();
			CommonFunctionality.wait(1000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
	
		}
	
		// TC_TV_115
		@And("^verify ESeries data Maximize$")
		public void verify_ESeries_data_Maximize() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Expand_rename", 10).click();
			CommonFunctionality.wait(1000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_116
		@And("^verify Series data full screen$")
		public void verify_Series_data_full_screen() throws Throwable {
			verify_Series_data_Minimize();
		}
	
		// TC_TV_117
		@And("^verify Series data exit full screen$")
		public void verify_Series_data_exit_full_screen() throws Throwable {
			verify_ESeries_data_Maximize();
		}
	
		// TC_TV_118
		@And("^verify Series data Cancel/x icon$")
		public void verify_Series_data_Cancel_x_icon() throws Throwable {
	
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Close_window", 8).click();
	
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
	
			}
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_119
		@And("^verify Series data dropdown for frequency in series level$")
		public void verify_Series_data_dropdown_for_frequency_in_series_level() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency_dropdownicon", 8).click();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_120
		@And("^verify Series data appling frequency in series level$")
		public void verify_Series_data_appling_frequency_in_series_level() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
	
			Thread.sleep(2000);
			String x = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 8).getText();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency_dropdownicon", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency_dropdownlist_firstitem", 8)
					.click();
			Thread.sleep(2000);
			String y = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 10).getText();
	
			if (!x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_121
		@And("^verify Series data appling currency in series level$")
		public void verify_Series_data_appling_currency_in_series_level() throws Throwable {
	
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			Thread.sleep(1000);
			String x = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 10).getText();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_currency_dropdownicon", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_Frequency_dropdownlist_firstitem", 10)
					.click();
			Thread.sleep(2000);
			String y = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 8).getText();
	
			if (!x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 8).click();
		}
	
		// TC_TV_122
		@And("^verify Edit Series clicking on type a function field$")
		public void verify_Edit_Series_clicking_on_type_a_function_field() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list")))
					.isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
		}
	
		// TC_TV_123
		@And("^verify Edit Series appling function in series level$")
		public void verify_Edit_Series_appling_function_in_series_level() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("Change");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			Thread.sleep(2000);
			String x = CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_searchbar", 10).getText()
					.replaceAll(" ", "");
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("All_second_rename_region_sname")))
					.getText().replaceAll(" ", "");
			System.out.println("Verified1" + y);
			String[] parts1 = x.split(";");
			System.out.println("Verified2" + parts1[0]);
			String secondpart = parts1[0];
			System.out.println("Verified4" + parts1[0] + secondpart);
	
			if (secondpart.equalsIgnoreCase(x)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_124
		@And("^verify Edit Series appling function  cancel icon for selected function$")
		public void verify_Edit_Series_appling_function_cancel_icon_for_selected_function() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			Thread.sleep(2000);
			String x = CommonFunctionality.getElementByProperty(login.driver, "Sname_EditSeries", 8).getText();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("Change");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_cancel", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText();
			Thread.sleep(1000);
			if (y.equalsIgnoreCase(x)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_125
		@And("^verify Edit Series multiple functions apply$")
		public void verify_Edit_Series_multiple_functions_apply() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("Change");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("LOG");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll(" ", "");
			String[] parts1 = x.split(";");
			String z = parts1[1];
			System.out.println("Verified123" + z);
			if (z.contains("CHANGE") && z.contains("LOG")) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_126
		@And("^verify Edit Series search for functions$")
		public void verify_Edit_Series_search_for_functions() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("Change");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 8).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_popup_Fname")))
					.getText().replaceAll(" ", "");
			if (x.contains("CHANGE")) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_127
		@And("^verify Edit Series removing applied functions$")
		public void verify_Edit_Series_removing_applied_functions() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll(" ", "");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("LOG");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			CommonFunctionality.wait(1000);
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_cancel_serieslevel", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply_serieslevel", 10).click();
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sname_EditSeries"))).getText()
					.replaceAll(" ", "");
	
			if (x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_128
		@And("^verify Edit Series applied funtion in function toolbar$")
		public void verify_Edit_Series_applied_funtion_in_function_toolbar() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).sendKeys("LOG");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_searchbar")))
					.getText().replaceAll(" ", "");
			if (x.contains("LOG")) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_129
		@And("^verify Edit Series appling invalid function for series$")
		public void verify_Edit_Series_appling_invalid_function_for_series() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10)
					.sendKeys("CROSSSEC");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Invalidfunction_popup"))).isDisplayed());
			System.out.println("Verified Editseries_Invalidfunction_popup");
			CommonFunctionality.getElementByProperty(login.driver, "Invalidfunction_popupClose_window", 10).click();
	
		}
	
		// TC_TV_130
		@And("^verify Edit Series OK button on The function cannot be applied to selected series popup$")
		public void verify_Edit_Series_OK_button_on_The_function_cannot_be_applied_to_selected_series_popup()
				throws Throwable {
	
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_input", 10)
					.sendKeys("CROSSSEC");
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_bar_list_first", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_function_Apply", 10).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).isDisplayed());
			CommonFunctionality.getElementByProperty(login.driver, "Invalidfunction_popupClose_ok", 10).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_131
		@And("^verify Edit Series Region, Unit and Series ID fields$")
		public void verify_Edit_Series_Region_Unit_and_Series_ID_fields() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
	
			WebElement element = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(text(),'Region')]",
					10);
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			WebElement element1 = CommonFunctionality.getElementByXpath(login.driver,
					"//div[@class='visual-series-panel--series']//following::div[contains(text(),'Unit')]", 10);
			jse.executeScript("arguments[0].scrollIntoView(true);", element1);
			WebElement element2 = CommonFunctionality.getElementByXpath(login.driver, "//div[contains(text(),'Series id')]",
					10);
			jse.executeScript("arguments[0].scrollIntoView(true);", element2);
	
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollSeriesid")))
					.isDisplayed());
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollunit"))).isDisplayed());
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollregion")))
					.isDisplayed());
		}
	
		// TC_TV_132
		@And("^verify Edit Series Verify horizontal scroll bar for series$")
		public void verify_Edit_Series_Verify_horizontal_scroll_bar_for_series() throws Throwable {
			verify_Edit_Series_Region_Unit_and_Series_ID_fields();
		}
	
		// TC_TV_133
		@And("^verify Edit Series Verify Verify \\+Add from my series option$")
		public void verify_Edit_Series_Verify_Verify_Add_from_my_series_option() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeries", 10).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Listandtable"))).isDisplayed());
			System.out.println("Add from my series option is verified");
		}
	
		// TC_TV_134
		@And("^verify Edit Series Verify adding series from my series$")
		public void verify_Edit_Series_Verify_adding_series_from_my_series() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Editseries_tablemode", 10).click();
			Thread.sleep(3000);
			boolean Table_mode_view = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_mode_view")))
					.isDisplayed();
			if (Table_mode_view == true) {
				System.out.println("Verified");
	
			} else {
				Assert.fail();
	
			}
			Thread.sleep(1000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(@title,'View as List')]", 10).click();
		}
	
		// TC_TV_135
		@And("^verify Edit Series Verify max series for Table visual$")
		public void verify_Edit_Series_Verify_max_series_for_Table_visual() throws Throwable {
			Thread.sleep(5000);
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
			JavascriptExecutor js = (JavascriptExecutor) login.driver;
			WebElement search_paginationELE = CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='search-series-pagination-count']", 10);
			js.executeScript("arguments[0].scrollIntoView(true);", search_paginationELE);
			// select 100 series
			CommonFunctionality.getElementByXpath(login.driver, "//select//*[@value='100']", 8).click();
			CommonFunctionality.wait(2000);
			List<WebElement> Totallist = login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
			System.out.println("Totallist size are:" + Totallist.size());
	
			for (int i = 1; i <= Totallist.size(); i++) {
				Thread.sleep(300);
				login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
			}
	
			Thread.sleep(700);
			WebElement mouseover = CommonFunctionality.getElementByXpath(login.driver,
					"(//div[@class='series-item--name'])[100]", 8);
			// mouseover.
			action.moveToElement(mouseover).pause(500).contextClick().build().perform();
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as Table')]", 10).click();
			Thread.sleep(500);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() > 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			} else {
				System.out.println("No Pop up appeared....");
			}
			Thread.sleep(500);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).isDisplayed());
			System.out.println("Verified max series for Table visual");
			CommonFunctionality.wait(1000);
			js.executeScript("arguments[0].scrollIntoView(true);", search_paginationELE);
			// select 20 series
			CommonFunctionality.getElementByXpath(login.driver, "//select//*[@value='20']", 8).click();
	
		}
	
		// TC_TV_136
		@And("^verify Edit Series Verify message for selecting more than (\\d+) series$")
		public void verify_Edit_Series_Verify_message_for_selecting_more_than_series(int arg1) throws Throwable {
			cdmnext.open_preference_dropdown();
			boolean withoutPaginationCheckbox = login.driver
					.findElement(By.xpath(
							"//*[contains(text(),'Show search results without pagination')]/preceding-sibling::input"))
					.isSelected();
			if (withoutPaginationCheckbox == false) {
				new Actions(login.driver)
						.moveToElement(login.driver.findElement(By.xpath(
								"//*[contains(text(),'Show search results without pagination')]/preceding-sibling::span")))
						.pause(1000).click().build().perform();
			}
			if (withoutPaginationCheckbox == true) {
				System.out.println("The Show search results without pagination Checkbox is checked");
			}
	
			Thread.sleep(5000);
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'Series')]", 8).click();
			CommonFunctionality.wait(2000);
			for (int i = 1; i <= 102; i++) {
				Thread.sleep(300);
				login.driver.findElement(By.xpath("(//*[@class='series-list-item--checkbox svg-checkbox'])[" + i + "]"))
						.click();
				if (i == 102) {
					Thread.sleep(500);
					WebElement mouseover = login.driver
							.findElement(By.xpath("(//*[@class='series-item--name'])[" + i + "]"));
					// mouseover.
					action.moveToElement(mouseover).pause(500).contextClick().build().perform();
				}
			}
	
			CommonFunctionality.getElementByXpath(login.driver, "//span[contains(text(),'View as Table')]", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "//button[contains(text(),'Ok')]", 10).click();
			Thread.sleep(500);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Close_window"))).size() > 0) {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Close_window"))).click();
			} else {
				System.out.println("No Pop up appeared....");
			}
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries"))).isDisplayed());
			System.out.println("Verified max series for Table visual");
			CommonFunctionality.getElementByProperty(login.driver, "Search_Top", 10).click();
			CommonFunctionality.getElementByXpath(login.driver, "(//*[@class='add-to-data-selection--icon'])[1]", 10)
					.click();
			Thread.sleep(500);
			if (login.driver.findElements(By.xpath("//div[@class='growl-message-text']")).size() != 0) {
				System.out.println("Validation message Verified Successfully!!! ");
			} else {
				Assert.fail();
			}
			cdmnext.open_preference_dropdown();
			new Actions(login.driver)
					.moveToElement(login.driver.findElement(By.xpath(
							"//*[contains(text(),'Show search results without pagination')]/preceding-sibling::span")))
					.pause(1000).click().build().perform();
		}
	
		// TC_TV_137
		@And("^verify Edit Series default sort by in add from my series tab$")
		public void verify_Edit_Series_default_sort_by_in_add_from_my_series_tab() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "AddfromMySeries", 10).click();
			Thread.sleep(3000);
			boolean Table_mode_view = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_checked_addseries"))).isDisplayed();
			System.out.println("Table_mode_view" + Table_mode_view);
			if (Table_mode_view == true) {
				System.out.println("Verified");
	
			} else {
				Assert.fail();
	
			}
	
		}
	
		// TC_TV_138
		@And("^verify Edit Series Edit series option on visual if edit series panle is opened$")
		public void verify_Edit_Series_Edit_series_option_on_visual_if_edit_series_panle_is_opened() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			Thread.sleep(3000);
			boolean Table_mode_view = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EditSeries")))
					.isEnabled();
			if (Table_mode_view == false) {
				System.out.println("Verified");
	
			} else {
				Assert.fail();
	
			}
	
		}
	
		// TC_TV_139
		@And("^verify Edit Series edit series panel close$")
		public void verify_Edit_Series_edit_series_panel_close() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "EditSeries", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "EditSeriesClose", 10).click();
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("AddfromMySeries"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
	
			}
		}
	
		// TC_TV_140
		@And("^verify Edit Table$")
		public void verify_Edit_Table() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 4).click();
			Thread.sleep(500);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_popup"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_close", 10).click();
		}
	
		// TC_TV_141
		@SuppressWarnings("deprecation")
		@And("^verify Edit Table popup of creating template$")
		public void verify_Edit_Table_popup_of_creating_template() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 8).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(1000).click().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_titlesetting_checkbox", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_titlesetting_close", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_template_icon", 10).click();
			Thread.sleep(500);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templateclose"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "Templateclose", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_close", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Invalidfunction_popupClose_ok", 10).click();
		}
	
		// TC_TV_142
		@And("^verify Edit Table auto naming for template$")
		public void verify_Edit_Table_auto_naming_for_template() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 8).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(1000).click().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_titlesetting_checkbox", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_template_icon", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Templatetick", 10).click();
			Thread.sleep(500);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename"))).getAttribute("title");
			if (x.contains("My template 1")) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
	
			}
			Thread.sleep(1000);
	
			WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			action.moveToElement(Deletetemplate).pause(1000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "DeleteTemplatename", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Invalidfunction_popupClose_ok", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_close", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Invalidfunction_popupClose_ok", 10).click();
		}
	
		// TC_TV_143
		@And("^verify Edit Table Verify template creating$")
		public void verify_Edit_Table_Verify_template_creating() throws Throwable {
			verify_Edit_Table_auto_naming_for_template();
		}
	
		// TC_TV_144
		@And("^verify Edit Table Cancel icon for template popup$")
		public void verify_Edit_Table_Cancel_icon_for_template_popup() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 8).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(1000).click().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_titlesetting_checkbox", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_template_icon", 10).click();
			Thread.sleep(500);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templateclose"))).isDisplayed());
			System.out.println("Verified");
			CommonFunctionality.getElementByProperty(login.driver, "Templateclose", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_close", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Invalidfunction_popupClose_ok", 10).click();
		}
	
		// TC_TV_145
		@And("^verify Edit Table selection of created template$")
		public void verify_Edit_Table_selection_of_created_template() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 10).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(1000).click().build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_titlesetting_checkbox", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_template_icon", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Templatetick", 10).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_save", 10).click();
			Thread.sleep(500);
			boolean tabletitle = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title")))
					.isDisplayed();
			System.out.println("tabletitle" + tabletitle);
			if (tabletitle == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 10).click();
			WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			action.moveToElement(Deletetemplate).pause(2000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "DeleteTemplatename", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Invalidfunction_popupClose_ok", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_close", 8).click();
		}
	
		// TC_TV_146
		@And("^verify Edit Table dropdown for template$")
		public void verify_Edit_Table_dropdown_for_template() throws Throwable {
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 8).click();
			sprint.uncheck_the_option("Show");
			cdmnext.create_a_new_template_and("Template popup");
			CommonFunctionality.getElementByProperty(login.driver, "Templatedropdown", 10).click();
			Thread.sleep(1000);
			boolean CEICStyles = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEICStyles"))).isDisplayed();
			boolean MyStyles = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyStyles"))).isDisplayed();
			System.out.println("CEICStyles" + CEICStyles);
			System.out.println("MyStyles" + MyStyles);
			if (MyStyles == true && CEICStyles == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_close", 10).click();
		}
	
		// TC_TV_147
		@And("^verify Edit Table Set as default for future Table visual is checked$")
		public void verify_Edit_Table_Set_as_default_for_future_Table_visual_is_checked() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Templatedropdown", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "SkyTemplate", 8).click();
			CommonFunctionality.getElementByProperty(login.driver, "Edit_Table_save", 10).click();
			Thread.sleep(2500);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SkyTemplatemyseriestab")))
					.getCssValue("background-color");
			if (x.contains("rgba(229, 238, 255, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_148
		@And("^verify Edit Table Set as default for future Table visual is Unchecked$")
		public void verify_Edit_Table_Set_as_default_for_future_Table_visual_is_Unchecked() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatedropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SkyTemplate"))).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2500);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatedropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DefaultTemplate"))).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(1500);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SkyTemplatemyseriestab")))
					.getCssValue("background-color");
			if (x.contains("rgba(133, 57, 142, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_149
		@And("^verify Edit Table delete template icon$")
		public void verify_Edit_Table_delete_template_icon() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			action.moveToElement(Deletetemplate).pause(5000).build().perform();
			Thread.sleep(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
			boolean deletetemplateicon = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("ConfirmationDeleteTemplate"))).isDisplayed();
			System.out.println("tabletitle" + deletetemplateicon);
			if (deletetemplateicon == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_150
		@And("^verify Edit Table description for confirmation popup$")
		public void verify_Edit_Table_description_for_confirmation_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			action.moveToElement(Deletetemplate).pause(5000).build().perform();
			Thread.sleep(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
			boolean deletetemplateicon = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("textDeleteTemplate"))).isDisplayed();
			System.out.println("tabletitle" + deletetemplateicon);
			if (deletetemplateicon == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_151
		@And("^verify Edit Table OK button on confirmation popup$")
		public void verify_Edit_Table_OK_button_on_confirmation_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			action.moveToElement(Deletetemplate).pause(5000).build().perform();
			Thread.sleep(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
	
			List<WebElement> listtemplate = login.driver
					.findElements(By.xpath("//div[@class='style-templates-menu--items']/div"));
			System.out.println("templatesize" + listtemplate.size());
			if (listtemplate.size() == 5) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_152
		@And("^verify Edit Table cancel/x icon on confirmation popup$")
		public void verify_Edit_Table_cancel_x_icon_on_confirmation_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_template_icon"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatetick"))).click();
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement Deletetemplate = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			action.moveToElement(Deletetemplate).pause(5000).build().perform();
			Thread.sleep(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ConfirmationDeleteTemplatecancel"))).click();
	
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ConfirmationDeleteTemplate"))).size() == 0)
	
			{
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement DeletetemplateX = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Templatename")));
			action.moveToElement(DeletetemplateX).pause(5000).build().perform();
			Thread.sleep(200);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("DeleteTemplatename"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_153
		@SuppressWarnings("deprecation")
		@And("^verify Edit Table Border - Verify Table color$")
		public void verify_Edit_Table_Border_Verify_Table_color() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			Thread.sleep(3000);
			WebElement x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
	
			action.moveToElement(x).pause(5000).click().build().perform();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput")))
					.sendKeys("5");
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(3000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable")))
					.getCssValue("background-color");
			System.out.println("Border colour" + y);
			Thread.sleep(3000);
	
			if (y.contains("rgba(0, 0, 0, 0)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_154
		@And("^verify Edit Table Border - Verify Table width$")
		public void verify_Edit_Table_Border_Verify_Table_width() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			Thread.sleep(3000);
			WebElement x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
	
			action.moveToElement(x).pause(5000).click().build().perform();
			Thread.sleep(3000);
			String width = "5";
			int widthbefore = Integer.parseInt(width);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput")))
					.sendKeys(width);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(3000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable")))
					.getCssValue("border-width");
			String wafter = y.replaceAll("\\D", "");
			int expectedwidth = Integer.parseInt(wafter);
			System.out.println("Border width" + expectedwidth);
			Thread.sleep(3000);
	
			if (widthbefore == expectedwidth) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_155
		@And("^verify Edit Table Border - Verify Table style$")
		public void verify_Edit_Table_Border_Verify_Table_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			Thread.sleep(3000);
			WebElement x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
			action.moveToElement(x).pause(5000).click().build().perform();
			Thread.sleep(3000);
			String width = "5";
			int widthbefore = Integer.parseInt(width);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput")))
					.sendKeys(width);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Borderstyledropdown"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderstyledropdownDashed"))).click();
			String m = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderstyledropdownDashed")))
					.getAttribute("title");
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(3000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable")))
					.getCssValue("border-style");
			Thread.sleep(3000);
			if (m.equalsIgnoreCase(y)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_156
		@And("^verify Edit Table Border - Verify Table type$")
		public void verify_Edit_Table_Border_Verify_Table_type() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			Thread.sleep(3000);
			WebElement x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_borderlengthinput_table")));
			action.moveToElement(x).pause(5000).click().sendKeys("5").build().perform();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Bordertypedropdown"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BordertypedropdownInner"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(3000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Bordertableinner")))
					.getCssValue("border-style");
			System.out.println("Verifiedtype" + y);
			Thread.sleep(3000);
			if (y.contains("dotted")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_157
		@And("^verify Edit Table Border=NO for visual$")
		public void verify_Edit_Table_Border_NO_for_visual() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
	
			Thread.sleep(3000);
			WebElement x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordervisualsetting_checkinput")));
			Actions border = new Actions(login.driver);
			border.moveToElement(x).pause(5000).build().perform();
			boolean y = x.isSelected();
			System.out.println("Boolean" + y);
			if (y == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_158
		@And("^verify Edit Table Border=Yes for visual$")
		public void verify_Edit_Table_Border_Yes_for_visual() throws Throwable {
			verify_Edit_Table_Border_Verify_Table_width();
		}
	
		// TC_TV_159
		@And("^verify Edit Table Border visual color$")
		public void verify_Edit_Table_Border_visual_color() throws Throwable {
			verify_Edit_Table_Border_Verify_Table_color();
		}
	
		// TC_TV_160
		@And("^verify Edit Table Border visual width$")
		public void verify_Edit_Table_Border_visual_width() throws Throwable {
			verify_Edit_Table_Border_Verify_Table_width();
		}
	
		// TC_TV_161
		@And("^verify Edit Table Border visual Radius$")
		public void verify_Edit_Table_Border_visual_Radius() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			Thread.sleep(3000);
			WebElement x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting_checkinput")));
	
			Actions border = new Actions(login.driver);
			border.moveToElement(x).pause(5000).click().build().perform();
			Thread.sleep(3000);
			String width = "10";
			int widthbefore = Integer.parseInt(width);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderRadius"))).sendKeys(width);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(3000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Blackbordertable")))
					.getCssValue("border-radius");
			String wafter = y.replaceAll("\\D", "");
			int expectedwidth = Integer.parseInt(wafter);
			System.out.println("Border Radius" + expectedwidth);
			Thread.sleep(3000);
	
			if (widthbefore == expectedwidth) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_162
		@And("^verify Edit Table Border visual style$")
		public void verify_Edit_Table_Border_visual_style() throws Throwable {
			verify_Edit_Table_Border_Verify_Table_style();
		}
	
		// TC_TV_163
		@And("^verify Edit Table Border advance settings$")
		public void verify_Edit_Table_Border_advance_settings() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingicon"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("AdvancesettingelementVisualborder"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_164
		@And("^verify Edit Table Border advance settings cogwheel$")
		public void verify_Edit_Table_Border_advance_settings_cogwheel() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("AdvancesettingelementVisualborder"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_165
		@And("^verify Edit Table Border closing of visual popup$")
		public void verify_Edit_Table_Border_closing_of_visual_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_Bordersetting"))).click();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_166
		@And("^verify Edit Table Show Check for attribute$")
		public void verify_Edit_Table_Show_Check_for_attribute() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableShowcheckbox")))
					.isSelected();
			System.out.println("BooleanVerified" + x);
			if (x == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_167
		@And("^verify Edit Table Show Unheck for attribute$")
		public void verify_Edit_Table_Show_Unheck_for_attribute() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableShowuncheckbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("NameAttributeshowuncheck"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_168
		@And("^verify Edit Table Show clicking on open advance settings popup$")
		public void verify_Edit_Table_Show_clicking_on_open_advance_settings_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("NameAttributeshowdropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableAttributepopup")))
					.isDisplayed());
			System.out.println("Verified");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
	
		}
	
		// TC_TV_169
		@And("^verify Edit Table Show Check for statistics$")
		public void verify_Edit_Table_Show_Check_for_statistics() throws Throwable {
			Thread.sleep(2000);
			List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_before = attributes_list.size();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_after = attributes_list_after.size();
	
			if (attributes_table_count_after != attributes_table_count_before) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_170
		@And("^verify Edit Table Show Unheck for statistics$")
		public void verify_Edit_Table_Show_Unheck_for_statistics() throws Throwable {
			Thread.sleep(2000);
			List<WebElement> attributes_list = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_before = attributes_list.size();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_after = attributes_list_after.size();
			if (attributes_table_count_after == attributes_table_count_before) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_171
		@And("^verify Edit Table Show clicking on open advance settings popup- statistics$")
		public void verify_Edit_Table_Show_clicking_on_open_advance_settings_popup_statistics() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticscheckbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ShowStatiticsdropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableAttributepopup")))
					.isDisplayed());
			System.out.println("Verified");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
	
		}
	
		// TC_TV_172
		@And("^verify Edit Table Title  as Title=Yes$")
		public void verify_Edit_Table_Title_as_Title_Yes() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EdittableTitle"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_173
		@And("^verify Edit Table Title  as Title=NO$")
		public void verify_Edit_Table_Title_as_Title_NO() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Tabletitlefornotitle"))).size() == 0)
	
			{
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_174
		@And("^verify Edit Table Title default selection for title$")
		public void verify_Edit_Table_Title_default_selection_for_title() throws Throwable {
			verify_Edit_Table_Title_as_Title_Yes();
		}
	
		// TC_TV_175
		@And("^verify Edit Table Auto title$")
		public void verify_Edit_Table_Auto_title() throws Throwable {
			Thread.sleep(2000);
	
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getText();
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(500);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edittabeldefaulttitlecheckbox")))
					.isSelected();
	
			if (y == true) {
				System.out.println("Verified title check box is checked");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting_checkbox"))).click();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(5000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).getText();
			if (x.equalsIgnoreCase(z)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_176
		@And("^verify Edit Table renaming title$")
		public void verify_Edit_Table_renaming_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(500);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(500);
			String input = "Testingseries";
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_defaulttitle_inputfield"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_defaulttitle_inputfield")))
					.sendKeys(input);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(5000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Tabletitlefornotitle"))).getText();
			System.out.println("z:" + z);
			System.out.println("input:" + input);
			if (input.equalsIgnoreCase(z)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_177
		@And("^verify Edit Table sub title=Check$")
		public void verify_Edit_Table_sub_title_Check() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).isDisplayed());
			System.out.println("Verified");
		}
	
		// TC_TV_178
		@And("^verify Edit Table sub title by default$")
		public void verify_Edit_Table_sub_title_by_default() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
	
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox")))
					.isSelected();
			if (x == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_179
		@And("^verify Edit Table sub title=UnCheck$")
		public void verify_Edit_Table_sub_title_UnCheck() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
	
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox")))
					.isSelected();
			if (x == false) {
				System.out.println("Verified that checkox is uncheck");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_checkbox"))).click();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).isDisplayed();
			if (y == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_180
		@And("^verify Edit Table default title for sub title$")
		public void verify_Edit_Table_default_title_for_sub_title() throws Throwable {
			verify_Edit_Table_sub_title_Check();
		}
	
		// TC_TV_181
		@And("^verify Edit Table advance settings-title$")
		public void verify_Edit_Table_advance_settings_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_tabel_subtitle_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("BorderAdvancesettingelement"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Advancesettingtitlepopup")))
					.isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_182
		@And("^verify Edit Table advance settings cogwheel icon-title$")
		public void verify_Edit_Table_advance_settings_cogwheel_icon_title() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Advancesettingtitlepopup")))
					.isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
	
		}
	
		// TC_TV_183
		@And("^verify Edit Table color for visual title$")
		public void verify_Edit_Table_color_for_visual_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_title"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_title_red"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title")))
					.getCssValue("background-color");
			System.out.println("Verified X as " + x);
			if (x.contains("rgba(0, 0, 0, 0)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_184
		@And("^verify Edit Table color for  visual title background$")
		public void verify_Edit_Table_color_for_visual_title_background() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_background_title"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_colour_background_orange_title"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath("//*[@class='visual-title']/*[2]/*[1]/*[1]"))
					.getAttribute("style");
			String color = "rgb(253, 165, 70)";
	
			System.out.println("Verified X as " + x);
	
			System.out.println("color " + color);
			if (x.contains(color)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_185
		@And("^verify Edit Table font size for visual title$")
		public void verify_Edit_Table_font_size_for_visual_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(2000).click().build().perform();
			Thread.sleep(2000);
			String visualsize = "30";
			int widthbefore = Integer.parseInt(visualsize);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_Size_title_input"))).clear();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_Size_title_input"))).sendKeys(visualsize);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(3000);
			String y = login.driver.findElement(By.xpath("(//*[@class='visual-title--text text-dots'])[1]"))
					.getCssValue("font-size");
			String wafter = y.replaceAll("\\D", "");
			int expectedwidth = Integer.parseInt(wafter);
			System.out.println("Border width" + expectedwidth);
			Thread.sleep(3000);
			System.out.println("widthbefore:" + widthbefore);
			System.out.println("expectedwidth:" + expectedwidth);
	
			if (widthbefore == expectedwidth) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_186
		@And("^verify Edit Table bold style for visual title$")
		public void verify_Edit_Table_bold_style_for_visual_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
	
			action.moveToElement(edittitlesetting).pause(2000).click().build().perform();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_BOLD")))
					.getAttribute("class");
			if (x.contains("selected")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_187
		@And("^verify Edit Table bold style default selection for visual title$")
		public void verify_Edit_Table_bold_style_default_selection_for_visual_title() throws Throwable {
			verify_Edit_Table_bold_style_for_visual_title();
		}
	
		// TC_TV_188
		@And("^verify Edit Table Italic style for visual title$")
		public void verify_Edit_Table_Italic_style_for_visual_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_Italics"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath("(//*[@class='visual-title--text text-dots'])[1]"))
					.getCssValue("font-style");
			System.out.println("Verified X as " + x);
	
			if (x.contains("italic")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_189
		@And("^verify Edit Table Underline style for visual title$")
		public void verify_Edit_Table_Underline_style_for_visual_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_underline"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath("(//*[@class='visual-title--text text-dots'])[1]"))
					.getCssValue("text-decoration");
			System.out.println("Verified X as " + x);
			if (x.contains("underline")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_190
		@And("^verify Edit Table horizontal alignment \\(left, right, center\\)$")
		public void verify_Edit_Table_horizontal_alignment_left_right_center() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			Actions etseting = new Actions(login.driver);
			etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Visual_text_title_left"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath("//*[@class='visual-title']/*[2]/*[1]/*[1]"))
					.getAttribute("style");
	
			System.out.println("Verified X as " + x);
			if (x.contains("flex-start")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_191
		@And("^verify Edit Table color for visual sub title$")
		public void verify_Edit_Table_color_for_visual_sub_title() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_colour_dropdown"))).click();
	
			Thread.sleep(3000);
			CommonFunctionality.Hidden_Webelements_handling(login.driver, "xpath", "(//span[@title='#a2c96a'])[3]");
	
			login.driver.findElement(By.xpath("(//span[@title='#a2c96a'])[3]")).click();
	
			String color = login.driver.findElement(By.xpath("(//span[@title='#a2c96a'])[3]")).getCssValue("data-color");
	
			System.out.println("color:" + color);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle")))
					.getCssValue("color");
			System.out.println("Verified colour X as " + x);
	
			if (x.contains(color)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_192
		@And("^verify Edit Table color for visual sub title background$")
		public void verify_Edit_Table_color_for_visual_sub_title_background() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_backgroundcolour"))).click();
	
			login.driver.findElement(By.xpath("(//span[@title='#792d82'])[4]")).click();
	
			String backgroundColor = login.driver.findElement(By.xpath("(//span[@title='#792d82'])[4]"))
					.getCssValue("data-color");
	
			// WebElement subtitlebackcolour =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_backgroundcolour_orange")));
			// Actions sub_titlebkcolour = new Actions(login.driver);
			// sub_titlebkcolour.moveToElement(subtitlebackcolour).pause(5000).click().build().perform();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle")))
					.getCssValue("background-color");
			System.out.println("Verified background colour X as " + x);
	
			if (x.contains(backgroundColor)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_193
		@And("^verify Edit Table font size for visual sub title$")
		public void verify_Edit_Table_font_size_for_visual_sub_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
			String width = "30";
			int widthbefore = Integer.parseInt(width);
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_size"))).clear();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_size"))).sendKeys(width);
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			// String y =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("font-size");
			String y = login.driver.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]"))
					.getCssValue("font-size");
			System.out.println("Verified fontsize Y as " + y);
			String wafter = y.replaceAll("\\D", "");
			int expectedwidth = Integer.parseInt(wafter);
			System.out.println("Border width" + expectedwidth);
			Thread.sleep(3000);
			System.out.println("widthbefore:" + widthbefore);
			System.out.println("expectedwidth:" + expectedwidth);
			if (widthbefore == expectedwidth) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_194
		@And("^verify Edit Table bold style for visual sub title$")
		public void verify_Edit_Table_bold_style_for_visual_sub_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_bold"))).click();
	
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle")))
					.getCssValue("font-style");
	
			System.out.println("Verified bold X as " + x);
			if (x.contains("normal")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_195
		@And("^verify Edit Table Italic style for visual sub title$")
		public void verify_Edit_Table_Italic_style_for_visual_sub_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_italic"))).click();
	
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			// String x =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("font-style");
	
			String x = login.driver.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]"))
					.getCssValue("font-style");
	
			if (x.contains("italic")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_196
		@And("^verify Edit Table Underline style for visual sub title$")
		public void verify_Edit_Table_Underline_style_for_visual_sub_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
	
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_underline"))).click();
	
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			// String x =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("text-decoration");
	
			String x = login.driver.findElement(By.xpath("(//span[@class='visual-title--text text-dots'])[2]"))
					.getCssValue("text-decoration");
			// String x =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle"))).getCssValue("text-decoration");
			if (x.contains("underline")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_197
		@And("^verify Edit Table horizontal alignment \\(left, right, center\\) of sub title$")
		public void verify_Edit_Table_horizontal_alignment_left_right_center_of_sub_title() throws Throwable {
	
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			Actions etseting = new Actions(login.driver);
			etseting.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_left"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("veiwtabel_subtitle")))
					.getAttribute("style");
			System.out.println("x:" + x);
	
			if (x.contains("flex-start")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_198
		@And("^verify Edit Table expanding and collapsing the title and subtitle sections$")
		public void verify_Edit_Table_expanding_and_collapsing_the_title_and_subtitle_sections() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_subtitle"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("subtitle_checkbox"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_199
		@And("^verify Edit Table closing of Titles popup$")
		public void verify_Edit_Table_closing_of_Titles_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement edittitlesetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_titlesetting")));
			action.moveToElement(edittitlesetting).pause(5000).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).isDisplayed());
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(3000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_200
		@And("^verify Edit Table Wrap text=checked$")
		public void verify_Edit_Table_Wrap_text_checked() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement Wraptextcheckbox = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text")));
			action.moveToElement(Wraptextcheckbox).pause(5000).build().perform();
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text_checkbox")))
					.isSelected();
	
			if (y == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_201
		@And("^verify Edit Table Wrap text=unchecked$")
		public void verify_Edit_Table_Wrap_text_unchecked() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement Wraptextcheckbox = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text")));
			action.moveToElement(Wraptextcheckbox).pause(5000).click().build().perform();
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_wrap_text_checkbox")))
					.isSelected();
			System.out.println("Verified y as" + y);
			if (y == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
		}
	
		// TC_TV_202
		@And("^verify Edit Table Invert=checked$")
		public void verify_Edit_Table_Invert_checked() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement Inverttextcheckbox = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_invert_checkbox")));
			action.moveToElement(Inverttextcheckbox).pause(5000).build().perform();
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_invert_checkbox")))
					.isSelected();
	
			if (y == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
		}
	
		// TC_TV_203
		@And("^verify Edit Table Invert=unchecked$")
		public void verify_Edit_Table_Invert_unchecked() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_invert"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("table_invert_myseries")))
					.getAttribute("class");
	
			if (x.contains("vertical")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_204
		@And("^verify Edit Table Zebra=checked$")
		public void verify_Edit_Table_Zebra_checked() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement zebratextcheckbox = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_checkbox")));
			action.moveToElement(zebratextcheckbox).pause(5000).build().perform();
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_checkbox")))
					.isSelected();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(1000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backround")))
					.getCssValue("background-color");
	
			System.out.println("Verified " + x + y);
			if (y == true && x.contains("rgba(168, 109, 175, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_205
		@And("^verify Edit Table Zebra=unchecked$")
		public void verify_Edit_Table_Zebra_unchecked() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			WebElement zebratextcheckbox = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra")));
			action.moveToElement(zebratextcheckbox).pause(5000).click().build().perform();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backround")))
					.getCssValue("background-color");
	
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
	
			if (x.contains("rgba(168, 109, 175, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_206
		@And("^verify Edit Table Alternating color for Rows$")
		public void verify_Edit_Table_Alternating_color_for_Rows() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_icon"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_dropdown"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_orange"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backround")))
					.getCssValue("background-color");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
	
			if (x.contains("rgba(168, 109, 175, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_207
		@And("^verify Edit Table Alternating color for  Column$")
		public void verify_Edit_Table_Alternating_color_for_Column() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_coloumn"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_dropdown"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_colour_orange"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_zebra_backroundalter")))
					.getCssValue("background-color");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
	
			if (x.contains("(168, 109, 175, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			// Thread.sleep(2000);
			// CommonFunctionality.Views_list();
	
		}
	
		// TC_TV_208
		@And("^verify Edit Table Header=checked$")
		public void verify_Edit_Table_Header_checked() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_checkbox")))
					.isSelected();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(1000);
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_title"))).isDisplayed();
			if (y == true && x == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// Table_title
	
		// TC_TV_209
		@And("^verify Edit Table Header=unchecked$")
		public void verify_Edit_Table_Header_unchecked() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header"))).click();
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_checkbox")))
					.isSelected();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(1000);
			boolean x = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Table_title"))).size() == 0;
			System.out.println("Verified x as" + x);
			System.out.println("Verified y as" + y);
	
			if (y == false && x == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_210
		@And("^verify Edit Table Header font color$")
		public void verify_Edit_Table_Header_font_color() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour_orange"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(500);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries")))
					.getCssValue("color");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
	
			if (x.contains("rgba(255, 91, 77, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_211
		@And("^verify Edit Table Header background color$")
		public void verify_Edit_Table_Header_background_color() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_background_colour"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_backcolour_orange")))
					.click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(500);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries")))
					.getCssValue("background-color");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
	
			if (x.contains("rgba(255, 91, 77, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_212
		@And("^verify Edit Table Header font size$")
		public void verify_Edit_Table_Header_font_size() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			String headersize = "10";
			int widthbefore = Integer.parseInt(headersize);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel"))).clear();
			Thread.sleep(5000);
			Actions act = new Actions(login.driver);
			WebElement header = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel")));
			act.moveToElement(header).pause(5000).sendKeys(headersize);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(3000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries")))
					.getCssValue("font-size");
			String wafter = y.replaceAll("\\D", "");
			int expectedwidth = Integer.parseInt(wafter);
			System.out.println("Border width" + expectedwidth);
			Thread.sleep(3000);
			if (widthbefore == expectedwidth) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_213
		@And("^verify Edit Table Header bold style$")
		public void verify_Edit_Table_Header_bold_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_bold_row"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries")))
					.getCssValue("font-weight");
			System.out.println("Verified x as" + x);
			if (x.contains("700")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_214
		@And("^verify Edit Table Header Italic style$")
		public void verify_Edit_Table_Header_Italic_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Italic_row"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries")))
					.getCssValue("font-style");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("italic")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_215
		@And("^verify Edit Table Header Italic Underline$")
		public void verify_Edit_Table_Header_Italic_Underline() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Underline_row"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries")))
					.getCssValue("text-decoration");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("underline")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_216
		@And("^verify Edit Table Header horizontal alignment \\(left, right, center\\)$")
		public void verify_Edit_Table_Header_horizontal_alignment_left_right_center() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_alignment_row"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries")))
					.getCssValue("text-align");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("center")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_217
		@And("^verify Edit Table Header column font color$")
		public void verify_Edit_Table_Header_column_font_color() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour_coloumn"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_font_colour_orange_coloumn")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn")))
					.getCssValue("color");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("rgba(255, 91, 77, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_218
		@And("^verify Edit Table Header column background color$")
		public void verify_Edit_Table_Header_column_background_color() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_background_colour_coloumn")))
					.click();
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_background_colourorange_coloumn")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn")))
					.getCssValue("background-color");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("rgba(255, 91, 77, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_219
		@And("^verify Edit Table Header column  font size$")
		public void verify_Edit_Table_Header_column_font_size() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel_coloumn"))).clear();
			String headersize = "10";
			int widthbefore = Integer.parseInt(headersize);
			Thread.sleep(2000);
			Actions act = new Actions(login.driver);
			WebElement header = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_pixel_coloumn")));
			act.moveToElement(header).pause(5000).sendKeys(headersize);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn")))
					.getCssValue("font-size");
			String wafter = x.replaceAll("\\D", "");
			int expectedwidth = Integer.parseInt(wafter);
			System.out.println("Border width" + expectedwidth);
			Thread.sleep(3000);
			if (widthbefore == expectedwidth) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_220
		@And("^verify Edit Table Header column bold style$")
		public void verify_Edit_Table_Header_column_bold_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_bold_row_coloumn"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn")))
					.getCssValue("font-weight");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("700")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_221
		@And("^verify Edit Table Header column Italic style$")
		public void verify_Edit_Table_Header_column_Italic_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Italic_row_coloumn"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn")))
					.getCssValue("font-style");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("italic")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_222
		@And("^verify Edit Table Header column underlined\\. style$")
		public void verify_Edit_Table_Header_column_underlined_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_Underline_row_coloumn")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn")))
					.getCssValue("text-decoration");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("underline")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_223
		@And("^verify Edit Table Header column horizontal alignment \\(left, right, center\\)$")
		public void verify_Edit_Table_Header_column_horizontal_alignment_left_right_center() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_rowcoloumn_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_headder_row_checkbox"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_header_alignment_coloumn"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_header_font_colour_Myseries_coloumn")))
					.getCssValue("text-align");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("center")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_224
		@And("^verify Edit Table Copyright=Check$")
		public void verify_Edit_Table_Copyright_Check() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_checkbox")))
					.isSelected();
			System.out.println("Verified y as" + y);
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='Source. Configure displaying of the source in the Table visual.']//*[@title='Open advanced settings popup']",
					8).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			boolean x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_source_myseries")))
					.isDisplayed();
	
			System.out.println("Verified x as" + x);
			if (x && y == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_225
		@And("^verify Edit Table Copyright=UnCheck$")
		public void verify_Edit_Table_Copyright_UnCheck() throws Throwable {
	
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_checkbox")))
					.isSelected();
			System.out.println("Verified y as" + y);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(8000);
			boolean x = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none")))
					.size() != 0;
			System.out.println("Verified x as:" + x);
			if (x == false && y == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			// Thread.sleep(2000);
			// CommonFunctionality.Views_list();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	
		}
	
		// TC_TV_226
		@And("^verify Edit Table Copyright Vertical align$")
		public void verify_Edit_Table_Copyright_Vertical_align() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).click();
	
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).isSelected();
			if (x == true) {
				System.out.println("copy right is selected....");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright"))).click();
			}
	
			Thread.sleep(2000);
			WebElement copyrightsetting = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown")));
			Actions etseting = new Actions(login.driver);
			etseting.moveToElement(copyrightsetting).pause(5000).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_top"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			boolean y = login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_top_myseries")))
					.size() == 0;
			System.out.println("Verified x as" + y);
	
			if (y == true) {
				System.out.println("Verified");
	
			} else {
	
				Assert.fail();
			}
		}
	
		// TC_TV_227
		@And("^verify Edit Table Copyright Vertical align for middle$")
		public void verify_Edit_Table_Copyright_Vertical_align_for_middle() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_middle")))
					.size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		}
	
		// TC_TV_228
		@And("^verify Edit Table Copyright Horizontal align$")
		public void verify_Edit_Table_Copyright_Horizontal_align() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@title='Source. Configure displaying of the source in the Table visual.']//*[@title='Open advanced settings popup']",
					8).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='copyright-config']/*[5]/*[1]/*[2]/*[1]/*[2]//*[@class='input-control--indicator']", 40)
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_horizontal_left"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none")))
					.getAttribute("style");
			System.out.println("Verified x as" + x);
			Thread.sleep(2000);
			if (x.contains("flex-start")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_229
		@And("^verify Edit Table Copyright advance settings$")
		public void verify_Edit_Table_Copyright_advance_settings() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
			Thread.sleep(1000);
			boolean x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_source_myseries")))
					.isDisplayed();
			if (x == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		}
	
		// TC_TV_230
		@And("^verify Edit Table Copyright advance settings cogwheel$")
		public void verify_Edit_Table_Copyright_advance_settings_cogwheel() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting_cogwheel")))
					.click();
	
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_popup")))
					.isDisplayed();
			if (x == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		}
	
		// TC_TV_231
		@And("^verify Edit Table Copyright popup text=check$")
		public void verify_Edit_Table_Copyright_popup_text_check() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
			/*
			 * Thread.sleep(2000);
			 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
			 * "Edit_table_copyright_advancesetting_cogwheel"))).click();
			 */
			Thread.sleep(2000);
			boolean x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_popup_checkbox"))).isSelected();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(3000);
			boolean y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_none")))
					.isDisplayed();
			System.out.println("Verified x as" + x);
			System.out.println("Verified y as" + y);
			if (x && y == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_232
		@And("^verify Edit Table Copyright popup default text for copyright$")
		public void verify_Edit_Table_Copyright_popup_default_text_for_copyright() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
			/*
			 * Thread.sleep(2000);
			 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
			 * "Edit_table_copyright_advancesetting_cogwheel"))).click();
			 */
			Thread.sleep(2000);
			String x = "Source: CEIC Data";
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_default_textforcopyright")))
					.getAttribute("value");
			Thread.sleep(1000);
			if (x.equalsIgnoreCase(y)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		}
	
		// TC_TV_233
		@And("^verify Edit Table Copyright popup text change for copyright$")
		public void verify_Edit_Table_Copyright_popup_text_change_for_copyright() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			hs.check("Copyright");
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button_and_Edit_the_text_as_and_Save("CDMNext");
			hs.updated_copyright_should_be_displayed_on_visual("CDMNext");
	
		}
	
		// TC_TV_234
		@And("^verify Edit Table Copyright popup link for copyright$")
		public void verify_Edit_Table_Copyright_popup_link_for_copyright() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			hs.check("Copyright");
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button_from_copyright_popup_and_Save();
			hs.click_on_the_Copyright();
			hs.the_user_should_redirect_to_link("https://www.ceicdata.com/en");
		}
	
		// TC_TV_235
		@And("^verify Edit Table Copyright popup link color$")
		public void verify_Edit_Table_Copyright_popup_link_color() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			hs.check("Copyright");
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button();
			hs.select_color_for("Copyright");
			st.click_on("Save");
			hs.visual_should_be_displayed_in_selected_color("Copyright");
		}
	
		// TC_TV_236
		@And("^verify Edit Table Copyright popup link font size$")
		public void verify_Edit_Table_Copyright_popup_link_font_size() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			hs.check("Copyright");
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button();
			hs.select_size_for_visual_as("Copyright", "20");
			st.click_on("Save");
			hs.the_font_size_should_be_changed_as("Copyright", "20");
	
		}
	
		// TC_TV_237
		@And("^verify Edit Table Copyright popup link bold style$")
		public void verify_Edit_Table_Copyright_popup_link_bold_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button();
			commentary.click_on_Bold_icon_for("Copyright");
			st.click_on("Save");
			hs.the_title_should_be_displayed_in_Bold_format("Copyright");
	
		}
	
		// TC_TV_238
		@And("^verify Edit Table Copyright popup link Italic style$")
		public void verify_Edit_Table_Copyright_popup_link_Italic_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button();
			hs.click_on_Italic_icon();
			st.click_on("Save");
			hs.the_should_be("Copyright", "italic");
		}
	
		// TC_TV_239
		@And("^verify Edit Table Copyright popup link Underline style$")
		public void verify_Edit_Table_Copyright_popup_link_Underline_style() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button();
			commentary.click_on_Underline_icon_for("Copyright");
			st.click_on("Save");
			hs.the_should_be("Copyright", "underline");
		}
	
		// TC_TV_240
		@And("^verify Edit Table Copyright popup link horizontal alignment \\(left, right, center\\)$")
		public void verify_Edit_Table_Copyright_popup_link_horizontal_alignment_left_right_center() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			db.click_on_icon("Open advanced settings popup");
			hs.select_Text_radio_button();
			pie.select_Horizontal_alignment_of_copyright_to_and_save("left");
			hs.the_copyright_image_should_align_to("Left");
			pie.select_Horizontal_alignment_of_copyright_to_and_save("center");
			hs.the_copyright_image_should_align_to("Center");
			pie.select_Horizontal_alignment_of_copyright_to_and_save("right");
			hs.the_copyright_image_should_align_to("Right");
	
		}
	
		// TC_TV_241
		@And("^verify Edit Table Copyright popup link vertical alignment \\(Top and bottom\\)$")
		public void verify_Edit_Table_Copyright_popup_link_vertical_alignment_Top_and_bottom() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			db.click_on_icon("Open advanced settings popup");
			pie.select_vertical_align_as_and_save("top");
			pie.the_copyright_should_be_displayed_in_top();
			pie.select_vertical_align_as_and_save("bottom");
			pie.the_copyright_should_be_displayed_in_bottom();
	
		}
	
		// TC_TV_242
	
		@And("^verify Edit Table Copyright popup closing$")
		public void verify_Edit_Table_Copyright_popup_closing() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			/*
			 * Thread.sleep(2000);
			 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
			 * "Edit_table_copyright_advancesetting_cogwheel"))).click();
			 */
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).click();
	
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("POP_title_close"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		}
	
		// TC_TV_243
		@And("^verify Edit Table Copyright popup expanding and collapsing the copyright sections$")
		public void verify_Edit_Table_Copyright_popup_expanding_and_collapsing_the_copyright_sections() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			/*
			 * Thread.sleep(2000);
			 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
			 * "Edit_table_copyright_advancesetting_cogwheel"))).click();
			 */
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_advancesetting"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_expand"))).click();
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_copyright_colapse")))
					.getAttribute("class");
			System.out.println("Verified x as" + y);
	
			if (y.contains("collapse")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
		}
	
		// TC_TV_244
		@And("^verify Edit Table dates$")
		public void verify_Edit_Table_dates() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_format"))).isDisplayed());
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_format"))).getText();
			System.out.println("X:" + x);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");
			// DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/YYYY");
			LocalDateTime now = LocalDateTime.now();
	
			// System.out.println(dtf.format(now));
			System.out.println(dtf.format(now) + x);
	
			if (dtf.format(now).contains(x)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_245
		@And("^verify Edit Table the list of date formats$")
		public void verify_Edit_Table_the_list_of_date_formats() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(5000);
			WebElement drop = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown")));
			Actions act = new Actions(login.driver);
			act.moveToElement(drop).click().build().perform();
	
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_list"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_246
		@And("^verify Edit Table Dates ascending order$")
		public void verify_Edit_Table_Dates_ascending_order() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
	
			boolean x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_checkbox")))
					.isSelected();
	
			if (x == true) {
				System.out.println("Ascending checkbox is selected");
			} else {
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending"))).click();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(8000);
			List<WebElement> Dates = login.driver
					.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (int i = 9; i < Dates.size(); i++) {
				String GotDates = Dates.get(i).getText();
				// String[] x1 =GotDates.split("/");
				int q = Integer.parseInt(GotDates);
	
				ar.add(q);
			}
			System.out.println("Ascending order are" + ar);
	
			boolean sorted = Ordering.natural().isOrdered(ar);
			if (sorted == true) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			//
			// Thread.sleep(2000);
			// CommonFunctionality.Views_list();
	
		}
	
		// TC_TV_247
		@And("^verify Edit Table Dates descending order$")
		public void verify_Edit_Table_Dates_descending_order() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			boolean x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Descending_checkbox"))).isSelected();
	
			if (x == true) {
				System.out.println("Descending checkbox is selected");
			} else {
				Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Descending"))).click();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(8000);
			List<WebElement> Dates = login.driver
					.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
			ArrayList<Integer> ar = new ArrayList<Integer>();
	
			try {
	
				for (int i = 9; i < Dates.size(); i++) {
					String GotDates = Dates.get(i).getText();
					// String[] x1 =GotDates.split("/");
					int q = Integer.parseInt(GotDates);
	
					ar.add(q);
	
				}
				System.out.println("Descending order are" + ar);
				boolean sorted = Ordering.natural().reverse().isOrdered(ar);
				if (sorted == true) {
					System.out.println("Verified");
				} else {
					Assert.fail();
	
				}
				// Thread.sleep(2000);
				// CommonFunctionality.Views_list();
			}
	
			catch (StaleElementReferenceException e) {
	
				for (int i = 9; i < Dates.size(); i++) {
	
					String GotDates = Dates.get(i).getText();
					String[] x1 = GotDates.split("/");
					int q = Integer.parseInt(x1[1]);
	
					ar.add(q);
					System.out.println("Descending order are" + ar);
				}
	
				boolean sorted = Ordering.natural().reverse().isOrdered(ar);
				if (sorted == true) {
					System.out.println("Verified");
				} else {
					Assert.fail();
				}
	
				// Thread.sleep(2000);
				// CommonFunctionality.Views_list();
			}
		}
	
		// TC_TV_248
		@And("^verify Edit Table Dates selection of date format$")
		public void verify_Edit_Table_Dates_selection_of_date_format() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown"))).click();
			Thread.sleep(2000);
			// WebElement Edit_table_custom_radio =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_radio")));
			// Actions border = new Actions(login.driver);
			// border.moveToElement(Edit_table_custom_radio).pause(5000).click().build().perform();
	
			login.driver.findElement(By.xpath("//span[@class='input-control--description' and contains(text(),'Custom')]"))
					.click();
	
			login.driver
					.findElement(By.xpath("//input[@class='form--control form--control__xs custom-date-format--input']"))
					.clear();
	
			login.driver
					.findElement(By.xpath("//input[@class='form--control form--control__xs custom-date-format--input']"))
					.sendKeys("MM/DD/YYYY");
	
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(8000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")))
					.getText();
			int sizedate = x.length();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");
			LocalDateTime now = LocalDateTime.now();
			int sizepattern = (dtf.format(now)).length();
			if (sizedate == sizepattern) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_249
		@And("^verify Edit Table Dates search$")
		public void verify_Edit_Table_Dates_search() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown"))).click();
			Thread.sleep(2000);
			// WebElement Edit_table_custom_radio =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_radio")));
			// Actions custom_radio = new Actions(login.driver);
			// custom_radio.moveToElement(Edit_table_custom_radio).pause(5000).click().build().perform();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("//span[@class='input-control--description' and contains(text(),'Custom')]"))
					.click();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search"))).clear();
			WebElement Edit_table_custom_search = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search")));
			Actions custom_search = new Actions(login.driver);
			String searchdate = "MMM";
			int sizepattern = searchdate.length();
			custom_search.moveToElement(Edit_table_custom_search).pause(5000).click().sendKeys(searchdate).build()
					.perform();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(8000);
	
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_search_dates")))
					.getText();
			int sizedate = x.length();
	
			if (sizedate == sizepattern) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_250
		@And("^verify Edit Table Dates invalid search$")
		public void verify_Edit_Table_Dates_invalid_search() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_dropdown"))).click();
			Thread.sleep(2000);
			// WebElement Edit_table_custom_radio =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_radio")));
			// Actions custom_radio = new Actions(login.driver);
			// custom_radio.moveToElement(Edit_table_custom_radio).pause(5000).click().build().perform();
			Thread.sleep(3000);
	
			login.driver.findElement(By.xpath("//span[@class='input-control--description' and contains(text(),'Custom')]"))
					.click();
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search"))).clear();
			WebElement Edit_table_custom_search = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search")));
			Actions custom_search = new Actions(login.driver);
			String searchdate = "MMMD";
			int sizepattern = searchdate.length();
			custom_search.moveToElement(Edit_table_custom_search).pause(5000).click().sendKeys(searchdate).build()
					.perform();
			Thread.sleep(3000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_custom_search_invalid"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_251
		@And("^verify Edit Table last observation$")
		public void verify_Edit_Table_last_observation() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			// for(int i=0;i<=21;i++) {
			// String x =login.driver.findElement(By.xpath("//input[@class='form--control
			// form--control__xs ui-spinner-input']"))
			// .getAttribute("aria-valuenow");
			// int y=Integer.parseInt(x);
			// System.out.println("Verified y as in if" + y);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Lastobservation_button"))).click();
			// if(y==5) {
			//
			// break;
			// }
			// }
			//
			// Thread.sleep(8000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			// Thread.sleep(5000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			// String x =login.driver.findElement(By.xpath("//input[@class='form--control
			// form--control__xs ui-spinner-input']"))
			// .getAttribute("value");
			// int z=Integer.parseInt(x);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			// Thread.sleep(5000);
			// List<WebElement> Lastobservation =
			// login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
			// System.out.println("Verified x as" + Lastobservation.size());
			// System.out.println("Verified y as" + z);
			// Thread.sleep(2000);
			// if(z ==Lastobservation.size()){
			// System.out.println("Verified");
			// }else {
			// Assert.fail();
			// }
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_252
		@And("^verify Edit Table last observation default=(\\d+)$")
		public void verify_Edit_Table_last_observation_default(int arg1) throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			// Thread.sleep(2000);
			// String x =login.driver.findElement(By.xpath("//input[@class='form--control
			// form--control__xs ui-spinner-input']"))
			// .getAttribute("value");
			// int z=Integer.parseInt(x);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			// Thread.sleep(5000);
			// List<WebElement> Lastobservation =
			// login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
			// System.out.println("Verified x as" + Lastobservation.size());
			// if(z ==Lastobservation.size()){
			// System.out.println("Verified");
			// }else {
			// Assert.fail();
			// }
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_253
		@And("^verify Edit Table Dates with in date range$")
		public void verify_Edit_Table_Dates_with_in_date_range() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range"))).click();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_from"))).clear();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_from"))).sendKeys("1995");
			//
			//
			//
			// WebElement Edit_table_date_active =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_active_95")));
			// Actions table_date_active = new Actions(login.driver);
			// table_date_active.moveToElement(Edit_table_date_active).pause(5000).click().build().perform();
			//
			//
			//
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_to"))).clear();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_within_range_to"))).sendKeys("2000");
			//
			// WebElement Edit_table_date_active1 =
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_date_active_20")));
			// Actions table_date_active1 = new Actions(login.driver);
			// table_date_active1.moveToElement(Edit_table_date_active1).pause(5000).click().build().perform();
			//
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(5000);
	
			// List<WebElement> Dates =
			// login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
			//
			// boolean lastnumber=false;
			// ArrayList<Integer> ar = new ArrayList<Integer>();
			// for(int i=0;i<Dates.size();i++) {
			// String GotDates = Dates.get(i).getText();
			//
			// int q = Integer.parseInt(GotDates);
			// ar.add(q);
			//
			// if(q<=2000) {
			// lastnumber=true;
			// System.out.println("Verified");
			// }
			// }
			// if(lastnumber==false) {
			// Assert.fail();
			// }
	
		}
	
		// TC_TV_254
		@And("^verify Edit Table Dates All observations$")
		public void verify_Edit_Table_Dates_All_observations() throws Throwable {
	
			Thread.sleep(2000);
			List<WebElement> Datesbefore = login.driver
					.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_All_observation"))).click();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			// Thread.sleep(5000);
			// List<WebElement> Datesafter =
			// login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
			// if(Datesbefore.size() != Datesafter.size()) {
			// System.out.println("Verified");
			// }else {
			// Assert.fail();
			// }
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_255
		@And("^verify Edit Table the selection of observations$")
		public void verify_Edit_Table_the_selection_of_observations() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			// boolean Lastobservation=
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_last_observation_input"))).isSelected();
			// boolean Allobservation=
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_All_observation_input"))).isSelected();
			//
			// if(Lastobservation ==true && Allobservation==false) {
			// System.out.println("Verified");
			// }else {
			// Assert.fail();
			// }
			// Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_256
		@And("^verify Edit Table Value font color$")
		public void verify_Edit_Table_Value_font_color() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value_colour"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value_colour_orange"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(6000);
	
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")))
					.getCssValue("color");
			Thread.sleep(2000);
	
			if (x.contains("rgba(255, 91, 77, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_257
		@And("^verify Edit Table Value font size$")
		public void verify_Edit_Table_Value_font_size() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
	
			Thread.sleep(2000);
	
			for (int i = 0; i <= 7; i++) {
				String x = login.driver
						.findElement(By.xpath("(//input[@class='form--control form--control__xs ui-spinner-input'])[1]"))
						.getAttribute("aria-valuenow");
				int y = Integer.parseInt(x);
				System.out.println("Verified y as in if" + y);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size_button"))).click();
				if (y == 20) {
	
					break;
				}
			}
	
			Thread.sleep(8000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(5000);
	
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")))
					.getCssValue("font-size");
			System.out.println("Verified z as" + z);
			Thread.sleep(2000);
	
			if (z.contains("20")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_258 :bold
		@And("^verify Edit Table Value font bold$")
		public void verify_Edit_Table_Value_font_bold() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size__bold"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(6000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")))
					.getCssValue("font-weight");
			System.out.println("Verified z as" + z);
			Thread.sleep(2000);
	
			if (z.contains("bold") || z.contains("700")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_259
		@And("^verify Edit Table Value font Italic$")
		public void verify_Edit_Table_Value_font_Italic() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size__Italic"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(6000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")))
					.getCssValue("font-style");
			System.out.println("Verified z as" + z);
			Thread.sleep(2000);
			if (z.contains("italic")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_260
		@And("^verify Edit Table Value font Underline\\.$")
		public void verify_Edit_Table_Value_font_Underline() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_size__Underline"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(6000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")))
					.getCssValue("text-decoration");
			System.out.println("Verified z as" + z);
			Thread.sleep(2000);
			if (z.contains("underline")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_261
		@And("^verify Edit Table Value font horizontal alignment \\(left, right, center\\)$")
		public void verify_Edit_Table_Value_font_horizontal_alignment_left_right_center() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Value"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_font_right"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(6000);
	
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_value_myseries")))
					.getCssValue("text-align");
			System.out.println("Verified z as" + z);
			Thread.sleep(2000);
			if (z.contains("right")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_262
		@And("^verify Edit Table Value Blank observations -default selection as \"([^\"]*)\"$")
		public void verify_Edit_Table_Value_Blank_observations_default_selection_as(String arg1) throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath("//*[contains(text(),'Filter out blanks')]")).getText();
			if (x.equalsIgnoreCase(arg1)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_263
		@And("^verify Edit Table Value Blank observations -Filter out blanks$")
		public void verify_Edit_Table_Value_Blank_observations_Filter_out_blanks() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(6000);
			List<WebElement> Dates = login.driver
					.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_date_Ascending_dates")));
	
			Boolean lastnumber = true;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (int i = 9; i < Dates.size(); i++) {
				String GotDates = Dates.get(i).getText();
	
				int q = Integer.parseInt(GotDates);
				ar.add(q);
				if (q == 1998) {
					lastnumber = false;
					Assert.fail();
					break;
	
				}
			}
			if (lastnumber.equals(true)) {
				System.out.println("Verified lastnumber as " + lastnumber);
	
			}
	
		}
	
		// TC_TV_264
		@And("^verify Edit Table Value Blank observations -Leave as blanks$")
		public void verify_Edit_Table_Value_Blank_observations_Leave_as_blanks() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[contains(text(),'Filter out blanks')]")).click();
			Thread.sleep(2000);
			CommonFunctionality.getElementByXpath(login.driver, "//*[contains(text(),'Leave as blank')]", 10).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(6000);
	
			List<WebElement> Dates = login.driver
					.findElements(By.xpath("//div[@class='visual-table-container']/table/tbody/tr/td[2]"));
	
			Boolean lastnumber = false;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (int i = 0; i < Dates.size(); i++) {
				String GotDates = Dates.get(i).getText();
				System.out.println("Q will be as " + GotDates);
	
				if (GotDates.isEmpty()) {
					lastnumber = true;
	
					break;
	
				}
			}
			if (lastnumber.equals(false)) {
				// Assert.fail();
			}
	
		}
	
		// TC_TV_265
		@And("^verify Edit Table Value Blank observations -Fill with N/A$")
		public void verify_Edit_Table_Value_Blank_observations_Fill_with_N_A() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[contains(text(),'Filter out blanks')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_lastobservation_FillwithN/A")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(6000);
			List<WebElement> Dates = login.driver
					.findElements(By.xpath("//div[@class='visual-table-container']/table/tbody/tr/td[2]"));
			Boolean lastnumber = false;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (int i = 0; i < Dates.size(); i++) {
				String GotDates = Dates.get(i).getText();
				System.out.println("Q will be as " + GotDates);
				if (GotDates.contains("N/A")) {
					lastnumber = true;
	
					break;
	
				}
			}
			if (lastnumber.equals(false)) {
				// Assert.fail();
			}
		}
	
		// TC_TV_266
		@And("^verify Edit Table Value Blank observations -Fill with dot$")
		public void verify_Edit_Table_Value_Blank_observations_Fill_with_dot() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[contains(text(),'Filter out blanks')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_lastobservation_Fillwithdot")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(6000);
			List<WebElement> Dates = login.driver
					.findElements(By.xpath("//div[@class='visual-table-container']/table/tbody/tr/td[2]"));
			Boolean lastnumber = false;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (int i = 0; i < Dates.size(); i++) {
				String GotDates = Dates.get(i).getText();
				System.out.println("Q will be as " + GotDates);
				if (GotDates.contains(".")) {
					lastnumber = true;
	
					break;
	
				}
			}
			if (lastnumber.equals(false)) {
				// Assert.fail();
			}
		}
	
		// TC_TV_267
		@And("^verify Edit Table Value Blank observations -Fill with hyphen$")
		public void verify_Edit_Table_Value_Blank_observations_Fill_with_hyphen() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//*[contains(text(),'Filter out blanks')]")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_lastobservation_Fillwithhyphen")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
			Thread.sleep(6000);
			List<WebElement> Dates = login.driver
					.findElements(By.xpath("//div[@class='visual-table-container']/table/tbody/tr/td[2]"));
			Boolean lastnumber = false;
			ArrayList<Integer> ar = new ArrayList<Integer>();
			for (int i = 0; i < Dates.size(); i++) {
				String GotDates = Dates.get(i).getText();
				System.out.println("Q will be as " + GotDates);
				if (GotDates.contains("-")) {
					lastnumber = true;
	
					break;
	
				}
			}
			if (lastnumber.equals(false)) {
				// Assert.fail();
			}
		}
	
		// TC_TV_268
		@And("^verify Edit Table Number format Decimal places$")
		public void verify_Edit_Table_Number_format_Decimal_places() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
	
			login.driver.findElement(By.xpath("//input[@name='number_decimal_places']")).clear();
	
			login.driver.findElement(By.xpath("//input[@name='number_decimal_places']")).sendKeys("4");
	
			/*
			 * int y=0; Thread.sleep(2000); for(int i=0;i<=1;i++) {
			 * 
			 * login.driver.findElement(By.xpath(login.LOCATORS.getProperty(
			 * "Edit_table_Numberformat_button"))).click(); String x
			 * =login.driver.findElement(By.
			 * xpath("(//input[@class='form--control form--control__xs ui-spinner-input'])[1]"
			 * )) .getAttribute("aria-valuenow"); y=Integer.parseInt(x);
			 * System.out.println("Verified y as in if" + y); if(y==4) {
			 * 
			 * break; } }
			 */
			Thread.sleep(8000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(5000);
			String z = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstvalue_myseries")))
					.getText();
			int q = z.substring(z.lastIndexOf(".") + 1).length();
			Thread.sleep(2000);
			System.out.println("q:" + q);
			if (q == 4) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_269
		@And("^verify Edit Table Number default Decimal places as \"([^\"]*)\"$")
		public void verify_Edit_Table_Number_default_Decimal_places_as(String arg1) throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
	
			String x = login.driver
					.findElement(By.xpath("(//input[@class='form--control form--control__xs ui-spinner-input'])[1]"))
					.getAttribute("value");
			Thread.sleep(2000);
			System.out.println("x:" + x);
			System.out.println("arg1:" + arg1);
			if (x.equalsIgnoreCase(arg1)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(8000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_270
		@And("^verify Edit Table Number default Decimal separator as comma$")
		public void verify_Edit_Table_Number_default_Decimal_separator_as_comma() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
			// CommonFunctionality.getElementByXpath(login.driver,
			// "//button[@class='ui-spinner-button ui-spinner-down']", 10).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_decimal_comma"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(8000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstvalue_myseriescomma")))
					.getText();
			System.out.println(x);
			// char comma = x.charAt(6);
			// String s = String.valueOf(comma);
			// System.out.println("Verified" + s);
			if (x.contains(",")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_271
		@And("^verify Edit Table Number default Decimal Grouping separator$")
		public void verify_Edit_Table_Number_default_Decimal_Grouping_separator() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_dropdown"))).click();
			CommonFunctionality.getElementByXpath(login.driver,
					"//input[@class='form--control form--control__xs ui-spinner-input']", 10).clear();
			CommonFunctionality.getElementByXpath(login.driver,
					"//input[@class='form--control form--control__xs ui-spinner-input']", 10).sendKeys("2");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Numberformat_decimal_grouping")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(8000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstvalue_myseriescomma")))
					.getText();
			char comma = x.charAt(1);
			System.out.println("comma:" + comma);
			String s = String.valueOf(comma);
			System.out.println("s:" + s);
			if (s.contains("-")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_272
		@And("^verify Edit Table horizontal scroll bar for settings sections$")
		public void verify_Edit_Table_horizontal_scroll_bar_for_settings_sections() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			WebElement element = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']/following::span[1]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
	
			boolean x = login.driver.findElement(By.xpath("//*[text()='Filter out blanks']/following::span[1]"))
					.isDisplayed();
	
			if (x == true) {
				System.out.println("Verified scrollBarPresent" + x);
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_273
		@And("^verify Edit Table the changes reflected in edit visual$")
		public void verify_Edit_Table_the_changes_reflected_in_edit_visual() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_cogwheel_title"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_cogwheel_title_colour"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_cogwheel_title_colour_orange")))
					.click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_changes_reflected_in_edit_visual")))
					.getCssValue("color");
			System.out.println("Verified " + x);
	
			if (x.contains("rgba(255, 91, 77, 1)")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_274
		@And("^verify Edit Table title icon on visual$")
		public void verify_Edit_Table_title_icon_on_visual() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
	
			WebElement EditTabletitleicon = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_changes_reflected_in_edit_visual")));
			action.moveToElement(EditTabletitleicon).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_title_edit_icon"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_title_edit_icon_popup")))
					.isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_275
		@And("^verify Edit Table titles popup open by double click on visual title$")
		public void verify_Edit_Table_titles_popup_open_by_double_click_on_visual_title() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
	
			WebElement EditTabletitleicon = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_changes_reflected_in_edit_visual")));
			action.moveToElement(EditTabletitleicon).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_title_edit_icon_popup")))
					.isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_276
		@And("^verify Edit Table double click on attribute area$")
		public void verify_Edit_Table_double_click_on_attribute_area() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_Name_attribute_inside")));
			action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_attribute_popup_inside")))
					.isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_277
		@And("^verify Edit Table double click on date field$")
		public void verify_Edit_Table_double_click_on_date_field() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_date_inside")));
			action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_date_popup_inside")))
							.isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_278
		@And("^verify Edit Table double click on timepoints$")
		public void verify_Edit_Table_double_click_on_timepoints() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_number_inside")));
			action.moveToElement(Sereiesnameintable).doubleClick().build().perform();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_number_popup_inside")))
							.isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_279
		@And("^verify Edit Table removing attributes by clicking x icon$")
		public void verify_Edit_Table_removing_attributes_by_clicking_x_icon() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(6000);
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath("(//th[@class='hor-vertical-header' and contains(text(),'Name')])[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
	
			login.driver.findElement(By.xpath(
					"(//th[@class='hor-vertical-header' and contains(text(),'Name')]//span[@class='attrs-edit--icon attrs-edit--icon__delete'])[2]"))
					.click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
	
			if (login.driver.findElements(By.xpath("//th[@class='hor-vertical-header' and contains(text(),'Name')]"))
					.size() == 0) {
				System.err.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_280
		@And("^verify Edit Table clicking on series name$")
		public void verify_Edit_Table_clicking_on_series_name() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
	
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")));
			action.moveToElement(Sereiesnameintable).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
			System.out.println("verified clicking on series name");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue_X_Icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_281
		@And("^verify Edit Table series on visuale inside Edit tabel popup$")
		public void verify_Edit_Table_series_on_visuale_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside")))
					.click();
			String[] exp = { "Rename", "Frequency", "Change" };
			List<WebElement> options = login.driver.findElements(
					By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']/div[3]/li"));
			for (WebElement we : options) {
				boolean match = false;
				for (int j = 0; j < exp.length; j++) {
					String X = we.getText();
					if (X.equals(exp[j])) {
						System.out.println(X + exp[j]);
						match = true;
						System.out.println("DropDown is verified successfully");
					}
				}
				// Assert.assertTrue(match);
				if (match = false) {
					Assert.fail();
				}
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_282
		@And("^verify Edit Table Rename option from cogwheel icon inside Edit tabel popup$")
		public void verify_Edit_Table_Rename_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_rename")))
					.click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
			System.out.println("verified clicking on series name");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_283
		@And("^verify Edit Table Frequency option from cogwheel icon inside Edit tabel popup$")
		public void verify_Edit_Table_Frequency_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath("(//span[@class='series-edit--title'])[2]/following::span[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frquency_Series_TV"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frequency_replicate"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable1 = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable1).build().perform();
	
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"))
					.getText();
			System.out.println(FunctionApplied);
	
			if (FunctionApplied.contains("DISAGGREGATE(Weekly; Sunday; Replicate)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_284
		@And("^verify Edit Table Currency option from cogwheel icon inside Edit tabel popup$")
		public void verify_Edit_Table_Currency_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath("(//span[@class='series-edit--title'])[2]/following::span[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_Series_TV"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//ul[@class='dropdown-menu']//*[contains(text(),'RUB')]")).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable1 = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable1).build().perform();
	
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"))
					.getText();
			System.out.println(FunctionApplied);
	
			if (FunctionApplied.contains("(Russian Ruble; as reported)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Reset"))).click();
	
		}
	
		// TC_TV_285
		@And("^verify Edit Table Change option from cogwheel icon inside Edit tabel popup$")
		public void verify_Edit_Table_Change_option_from_cogwheel_icon_inside_Edit_tabel_popup() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable = login.driver
					.findElement(By.xpath("(//span[@class='series-edit--title'])[2]/following::span[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_cogwheel_inside")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_Series_TV"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_pop"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable1 = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable1).build().perform();
	
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"))
					.getText();
			System.out.println(FunctionApplied);
	
			if (FunctionApplied.contains("%CHANGE(Over Period; 1; Yes)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_286
		@And("^verify Edit Table tooltip for series inside Edit tabel popup$")
		public void verify_Edit_Table_tooltip_for_series_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(500);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("tooltip_text"))).isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_287
		@And("^verify Edit Table scroll down till end of timepoints inside Edit tabel popup$")
		public void verify_Edit_Table_scroll_down_till_end_of_timepoints_inside_Edit_tabel_popup() throws Throwable {
	
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			JavascriptExecutor js = (JavascriptExecutor) login.driver;
			WebElement element = login.driver
					.findElement(By.xpath("(//div[@class='visual-table-container'])[2]/table/tbody/tr[1]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
	
			WebElement element1 = login.driver
					.findElement(By.xpath("(//div[@class='visual-table-container'])[2]/table/tbody/tr[5]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element1);
	
			WebElement element2 = login.driver
					.findElement(By.xpath("(//div[@class='visual-table-container'])[2]/table/tbody/tr[10]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element2);
	
			WebElement element3 = login.driver
					.findElement(By.xpath("(//div[@class='visual-table-container'])[2]/table/tbody/tr[15]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element3);
	
			WebElement element4 = login.driver
					.findElement(By.xpath("(//div[@class='visual-table-container'])[2]/table/tbody/tr[20]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element4);
	
			WebElement element5 = login.driver
					.findElement(By.xpath("(//div[@class='visual-table-container'])[2]/table/tbody/tr[23]"));
			js.executeScript("arguments[0].scrollIntoView(true);", element5);
			Thread.sleep(500);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_CEICImage_inside"))).isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_288
		@And("^verify Edit Table  horizontal scroll inside Edit tabel popup$")
		public void verify_Edit_Table_horizontal_scroll_inside_Edit_tabel_popup() throws Throwable {
			verify_Edit_Table_scroll_down_till_end_of_timepoints_inside_Edit_tabel_popup();
		}
	
		// TC_TV_289
		@And("^verify Edit Table selecting another visual from visual panel inside Edit tabel popup$")
		public void verify_Edit_Table_selecting_another_visual_from_visual_panel_inside_Edit_tabel_popup()
				throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisual_inside")))
					.click();
	
			Thread.sleep(500);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisualchart_inside")))
					.isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
	
		}
	
		// TC_TV_290
		@And("^verify Edit Table selecting another visual from visual dropdown inside Edit tabel popup$")
		public void verify_Edit_Table_selecting_another_visual_from_visual_dropdown_inside_Edit_tabel_popup()
				throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisual_inside")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisualdropdown_inside")))
					.click();
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisualdropdown_pie_inside")))
					.click();
			Thread.sleep(500);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_anothervisual_pie_inside")))
					.isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
	
		}
	
		// TC_TV_291
		@And("^verify Edit Table delete series icon inside Edit tabel popup$")
		public void verify_Edit_Table_delete_series_icon_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(6000);
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='remove-item-control'])[1]")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//*[@class='remove-item-control'])[1]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver
					.findElement(
							By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteseries")))
					.click();
			Thread.sleep(500);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_table_removed_inside")))
							.isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
	
		}
	
		// TC_TV_292
		@And("^verify Edit Table delete all series icon inside Edit tabel popup$")
		public void verify_Edit_Table_delete_all_series_icon_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(6000);
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='remove-item-control'])[2]")));
			WebElement Sereiesnameintable = login.driver.findElement(By.xpath("(//*[@class='remove-item-control'])[2]"));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver
					.findElement(By.xpath(
							login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")))
					.click();
			Thread.sleep(500);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_table_removed_inside")))
							.isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_close"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
	
		}
	
		// TC_TV_293
		@And("^verify Edit Table SSP by clicking on series name inside Edit tabel popup$")
		public void verify_Edit_Table_SSP_by_clicking_on_series_name_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_SSP"))).click();
			Thread.sleep(500);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SSP_Dialogue"))).isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_294
		@And("^verify Edit Table Rename series icon inside Edit tabel popup$")
		public void verify_Edit_Table_Rename_series_icon_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
	
			WebElement Sereiesnameintable = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_renameicon"))).click();
			Thread.sleep(500);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
			System.out.println("Verified Successfully");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(500);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_295
		@And("^verify Edit Table edit series icon inside Edit tabel popup$")
		public void verify_Edit_Table_edit_series_icon_inside_Edit_tabel_popup() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
	
			WebElement Sereiesnameintable = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon")))
					.click();
			String[] exp = { "Rename", "Frequency", "Change" };
			List<WebElement> options = login.driver.findElements(
					By.xpath("//ul[@class='dropdown-menu context-menu edit-series--context-menu']/div[3]/li"));
			for (WebElement we : options) {
				boolean match = false;
				for (int j = 0; j < exp.length; j++) {
					String X = we.getText();
					if (X.equals(exp[j])) {
						System.out.println(X + exp[j]);
						match = true;
						System.out.println("DropDown is verified successfully");
					}
				}
				// Assert.assertTrue(match);
				if (match = false) {
					Assert.fail();
				}
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_296
		@And("^verify Edit Table Rename option under edit series  inside Edit tabel popup$")
		public void verify_Edit_Table_Rename_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
	
			WebElement Sereiesnameintable = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_Series_TV"))).click();
	
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Rename_popup"))).isDisplayed());
			System.out.println("verified clicking on series name");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_297
		@And("^verify Edit Table Frequency option under edit series  inside Edit tabel popup$")
		public void verify_Edit_Table_Frequency_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
	
			WebElement Sereiesnameintable = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frquency_Series_TV"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Frequency_replicate"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable1 = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable1).build().perform();
	
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"))
					.getText();
			System.out.println(FunctionApplied);
	
			if (FunctionApplied.contains("DISAGGREGATE(Weekly; Sunday; Replicate)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_298
		@And("^verify Edit Table Currency option under edit series  inside Edit tabel popup$")
		public void verify_Edit_Table_Currency_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
	
			WebElement Sereiesnameintable = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_Series_TV"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Currency_RUB"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable1 = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable1).build().perform();
	
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"))
					.getText();
			System.out.println(FunctionApplied);
	
			if (FunctionApplied.contains("(Russian Ruble; as reported)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_299
		@And("^verify Edit Table Change option under edit series  inside Edit tabel popup$")
		public void verify_Edit_Table_Change_option_under_edit_series_inside_Edit_tabel_popup() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(1000);
	
			WebElement Sereiesnameintable = login.driver.findElement(
					By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_remove_inside_deleteallseries")));
			action.moveToElement(Sereiesnameintable).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_rename_cogwheelicon")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_Series_TV"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Change_pop"))).click();
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='series-edit--title'])[2]")));
			WebElement Sereiesnameintable1 = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"));
			action.moveToElement(Sereiesnameintable1).build().perform();
			Thread.sleep(2000);
			String FunctionApplied = login.driver.findElement(By.xpath("(//span[@class='series-edit--title'])[2]"))
					.getText();
			System.out.println(FunctionApplied);
			if (FunctionApplied.contains("%CHANGE(Over Period; 1; Yes)")) {
				System.out.println("Verified Successfully");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_300
		@And("^verify Edit Table clicking on frequency or dropdown inside Edit tabel popup$")
		public void verify_Edit_Table_clicking_on_frequency_or_dropdown_inside_Edit_tabel_popup() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
			Thread.sleep(500);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_Series_Harmonization")))
					.isDisplayed());
			System.out.println("Verified Successfully");
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_301
		@And("^verify Edit Table Series data conversion -Applay inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_Applay_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstSeriesname_frequency"))).getText();
			Thread.sleep(2000);
			System.out.println(x);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
	
			Thread.sleep(2000);
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Button"))).click();
			// Thread.sleep(2000);
			// login.driver.findElement(By.xpath("//div[@class='sphere-modal__close']")).click();
	
			String y = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstSeriesname_frequency"))).getText();
	
			if (!x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_302
		@And("^verify Edit Table Series data conversion applying Missing values method inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_applying_Missing_values_method_inside_Edit_tabel_popup()
				throws Throwable {
	
			verify_Edit_Table_Series_data_conversion_Applay_inside_Edit_tabel_popup();
		}
	
		// TC_TV_303
		@And("^verify Edit Table Series data conversion Apply button inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_Apply_button_inside_Edit_tabel_popup() throws Throwable {
	
			verify_Edit_Table_Series_data_conversion_Applay_inside_Edit_tabel_popup();
		}
	
		// TC_TV_304
		@And("^verify Edit Table Series data conversion Minimize option inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_Minimize_option_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_minimize"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_Maximize"))).click();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_minimize"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_305
		@And("^verify Edit Table Series data conversion maximize option inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_maximize_option_inside_Edit_tabel_popup() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_minimize"))).click();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_Maximize"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_frequency_Maximize"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_306
		@And("^verify Edit Table Series data conversion maximize full screen inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_maximize_full_screen_inside_Edit_tabel_popup()
				throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).click();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_307
		@And("^verify Edit Table Series data conversion exit full screen option inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_exit_full_screen_option_inside_Edit_tabel_popup()
				throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expand_rename"))).click();
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Collapse_rename"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_308
		@And("^verify Edit Table Series data conversion Cancel/x icon option inside Edit tabel popup$")
		public void verify_Edit_Table_Series_data_conversion_Cancel_x_icon_option_inside_Edit_tabel_popup()
				throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_EditSeries_frequency"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_cogwheel_inside_renameclose")))
					.click();
	
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_Series_Harmonization")))
					.size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_309
		@And("^verify Edit Table dropdown for frequency in series level inside Edit tabel popup$")
		public void verify_Edit_Table_dropdown_for_frequency_in_series_level_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownicon"))).click();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist"))).isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
		}
	
		// TC_TV_310
		@And("^verify Edit Table appling frequency in series level inside Edit tabel popup$")
		public void verify_Edit_Table_appling_frequency_in_series_level_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			String Frquencyseriesbefore = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstSeriesname_frequency"))).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownicon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist_firstitem")))
					.click();
			Thread.sleep(2000);
			String Frquencyseriesafter = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_firstSeriesname_frequency"))).getText();
			Thread.sleep(2000);
	
			if (!Frquencyseriesbefore.equalsIgnoreCase(Frquencyseriesafter)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_311
		@And("^verify Edit Table appling currency in series level inside Edit tabel popup$")
		public void verify_Edit_Table_appling_currency_in_series_level_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			String Frquencyseriesbefore = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_secondSeriesname_frequency"))).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_insidecurrencydropdown_frequency")))
					.click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Frequency_dropdownlist_firstitem")))
					.click();
			Thread.sleep(2000);
			String Frquencyseriesafter = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_secondSeriesname_frequency"))).getText();
			Thread.sleep(2000);
	
			if (!Frquencyseriesbefore.equalsIgnoreCase(Frquencyseriesafter)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_312
		@And("^verify Edit Table clicking on type a function field inside Edit tabel popup$")
		public void verify_Edit_Table_clicking_on_type_a_function_field_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list")))
					.isDisplayed());
			System.out.println("Verified");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_313
		@And("^verify Edit Table appling function in series level inside Edit tabel popup$")
		public void verify_Edit_Table_appling_function_in_series_level_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input")))
					.sendKeys("Change");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_searchbar")))
					.getText().replaceAll(" ", "");
			Thread.sleep(2000);
			String y = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")))
					.getText().replaceAll(" ", "");
			System.out.println("Verified1" + y);
			String[] parts1 = x.split(";");
			System.out.println("Verified2" + parts1[0]);
			String secondpart = parts1[0];
			System.out.println("Verified4" + parts1[0] + secondpart);
	
			if (secondpart.equalsIgnoreCase(x)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_314
		@And("^verify Edit Table cancel icon for selected function inside Edit tabel popup$")
		public void verify_Edit_Table_cancel_icon_for_selected_function_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")))
					.getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input")))
					.sendKeys("Change");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_cancel"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
			Thread.sleep(2000);
			String y = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")))
					.getText();
			Thread.sleep(1000);
			if (y.equalsIgnoreCase(x)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_315
		@And("^verify Edit Table multiple functions apply inside Edit tabel popup$")
		public void verify_Edit_Table_multiple_functions_apply_inside_Edit_tabel_popup() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input")))
					.sendKeys("Change");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("LOG");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(5000);
			WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
	
			action.moveToElement(tick).click().build().perform();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")))
					.getText().replaceAll(" ", "");
			String[] parts1 = x.split(";");
			String z = parts1[1];
			System.out.println("Verified123" + z);
			if (z.contains("CHANGE") && z.contains("LOG")) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_316
		@And("^verify Edit Table search for functions inside Edit tabel popup$")
		public void verify_Edit_Table_search_for_functions_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input")))
					.sendKeys("Change");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
	
			Thread.sleep(5000);
			WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
	
			action.moveToElement(tick).click().build().perform();
	
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")))
					.getText().replaceAll(" ", "");
			if (x.contains("CHANGE")) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_317
		@And("^verify Edit Table removing applied functions inside Edit tabel popup$")
		public void verify_Edit_Table_removing_applied_functions_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			String x = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")))
					.getText().replaceAll(" ", "");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).sendKeys("LOG");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(5000);
			WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
	
			action.moveToElement(tick).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_cancel_serieslevel")))
					.click();
			Thread.sleep(2000);
			WebElement tick2 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Applyfunctioninside")));
	
			action.moveToElement(tick2).click().build().perform();
	
			Thread.sleep(2000);
			String y = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_visual_SeriesName_attribute_inside")))
					.getText().replaceAll(" ", "");
	
			if (x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_318
		@And("^verify Edit Table appling invalid function for series inside Edit tabel popup$")
		public void verify_Edit_Table_appling_invalid_function_for_series_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input")))
					.sendKeys("convertcur");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			WebElement tick = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply")));
	
			action.moveToElement(tick).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_Invalidfunction_popup"))).isDisplayed());
			System.out.println("Verified Editseries_Invalidfunction_popup");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
			Thread.sleep(2000);
			CommonFunctionality.Views_list();
	
			if (login.driver
					.findElements(By.xpath(
							"//span[@class='series-tab']//span[@class='series-tab--text' and contains(text(),List)]"))
					.size() == 1) {
	
				login.driver
						.findElement(By.xpath(
								"//span[@class='series-tab']//span[@class='series-tab--text' and contains(text(),List)]"))
						.click();
			}
	
		}
	
		// TC_TV_319
		@And("^verify Edit Table OK button on The function cannot be applied to selected series popup inside Edit tabel popup$")
		public void verify_Edit_Table_OK_button_on_The_function_cannot_be_applied_to_selected_series_popup_inside_Edit_tabel_popup()
				throws Throwable {
			Thread.sleep(2000);
			CreateTable();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_input")))
					.sendKeys("convertcur");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			// us dollers
	
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_bar_list_first"))).click();
			Thread.sleep(2000);
			// as report
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_function_Apply"))).click();
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_320
		@And("^verify Edit Table Region, Unit and Series ID fields inside Edit tabel popup$")
		public void verify_Edit_Table_Region_Unit_and_Series_ID_fields_inside_Edit_tabel_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollSeriesid")))
					.isDisplayed());
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Editseries_scrollregion")))
					.isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_321
		@And("^verify Edit Table horizontal scroll bar for series inside Edit tabel popup$")
		public void verify_Edit_Table_horizontal_scroll_bar_for_series_inside_Edit_tabel_popup() throws Throwable {
			verify_Edit_Table_Region_Unit_and_Series_ID_fields_inside_Edit_tabel_popup();
		}
	
		// TC_TV_322
		@And("^verify Edit Table feedback option$")
		public void verify_Edit_Table_feedback_option() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
			Thread.sleep(2000);
	
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_popup")))
					.isDisplayed());
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_323
		@And("^verify Edit Table description for popup$")
		public void verify_Edit_Table_description_for_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Description"))).isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_324
		@And("^verify Edit Table adding text in the field$")
		public void verify_Edit_Table_adding_text_in_the_field() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
			Thread.sleep(2000);
			String x = "Testing";
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_textarea"))).sendKeys(x);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Submit"))).click();
			Thread.sleep(500);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack")))
					.isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_325
		@And("^verify Edit Table Submit and cancel buttons when description field is empty$")
		public void verify_Edit_Table_Submit_and_cancel_buttons_when_description_field_is_empty() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
	
			Thread.sleep(2000);
			String feedbacksubmit = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Submit_disable")))
					.getAttribute("class");
			if (feedbacksubmit.contains("disabled")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
	
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_326
		@And("^verify Edit Table cancel button$")
		public void verify_Edit_Table_cancel_button() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback"))).click();
			String x = "Testing";
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_textarea"))).sendKeys(x);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Cancel"))).click();
	
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_Cancel"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table_save"))).click();
	
		}
	
		// TC_TV_327
		@And("^verify Edit Table Submit button$")
		public void verify_Edit_Table_Submit_button() throws Throwable {
			verify_Edit_Table_adding_text_in_the_field();
		}
	
		// TC_TV_328
		@And("^verify Edit growl message after Submit button$")
		public void verify_Edit_growl_message_after_Submit_button() throws Throwable {
			verify_Edit_Table_adding_text_in_the_field();
		}
	
		// TC_TV_329
		@And("^verify Edit Table cancel/x button$")
		public void verify_Edit_Table_cancel_x_button() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Canceldown"))).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Edit_table_Canceldown"))).size() == 0) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_330
		@And("^verify Edit Table save button$")
		public void verify_Edit_Table_save_button() throws Throwable {
			verify_Edit_Table_Header_bold_style();
		}
	
		// TC_TV_331
		@And("^verify Add related series option$")
		public void verify_Add_related_series_option() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_popup")))
					.isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Harmonization"))).click();
	
		}
	
		// TC_TV_332
		@And("^verify Add related option when the visual is empty$")
		public void verify_Add_related_option_when_the_visual_is_empty() throws Throwable {
			Thread.sleep(2000);
			boolean relatedseries = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series")))
					.isEnabled();
			if (relatedseries == false) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_333
		@And("^Verify adding series from Series suggestion manager popup$")
		public void verify_adding_series_from_Series_suggestion_manager_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series"))).click();
			Thread.sleep(2000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_firsttitle")))
					.getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_regiondropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_region_albania"))).click();
			Thread.sleep(2000);
			String y = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_related_series_firsttitle")))
					.getText();
			System.out.println("Verified x as " + x);
			System.out.println("Verified y as " + y);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Series_Harmonization"))).click();
			Thread.sleep(2000);
			if (!x.equalsIgnoreCase(y)) {
	
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_334
		@And("^verify add to insight option$")
		public void verify_add_to_insight_option() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_insight")))
					.isDisplayed());
			Thread.sleep(500);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_add")))
					.isDisplayed());
	
		}
	
		// TC_TV_335
		@And("^verify Add option under Add to insight$")
		public void verify_Add_option_under_Add_to_insight() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_add"))).click();
			Thread.sleep(2000);
			List<WebElement> views = login.driver
					.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() >= 2) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_336
		@And("^verify confirmation message for adding visual to new insight$")
		public void verify_confirmation_message_for_adding_visual_to_new_insight() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_insight"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack")))
					.isDisplayed());
	
		}
	
		// TC_TV_337
		@And("^verify Validate the added visual by opening new insight$")
		public void verify_Validate_the_added_visual_by_opening_new_insight() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown"))).click();
			Thread.sleep(2000);
			String urlcurrenttab = login.driver.getCurrentUrl();
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Add_insight_dropdown_insight"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Createnew_insight"))).click();
			// a[@class='button growl-message-content--btns__fill']
	
			ArrayList<String> tabs2 = new ArrayList<String>(login.driver.getWindowHandles());
			login.driver.switchTo().window(tabs2.get(1));
			Thread.sleep(2000);
	
			String urlnewtab = login.driver.getCurrentUrl();
	
			login.driver.close();
			login.driver.switchTo().window(tabs2.get(0));
			if (!urlcurrenttab.equalsIgnoreCase(urlnewtab)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_338
		@And("^verify growl popup auto close$")
		public void verify_growl_popup_auto_close() throws Throwable {
			verify_confirmation_message_for_adding_visual_to_new_insight();
		}
	
		// TC_TV_339
		@And("^verify Copy option$")
		public void verify_Copy_option() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable contents = clipboard.getContents(null);
			String x = (String) contents.getTransferData(DataFlavor.stringFlavor);
			String y = x.replaceAll("\\s+", "");
			System.out.println(x);
			System.out.println(y);
			String Copy_link = "NameEmploymentRateRegionTunisiaFrequencyQuarterly,ending&quot;Mar,June,Sep,Dec&quot;Unit%SeriesID394611277FirstObs.Date06/2010LastObs.Date06/2017LastUpdateTime03/201906/201040,8000006/201138,5000012/201138,8000006/201259,9000009/201260,0000012/201260,2000003/201360,2000006/201360,5000009/201360,7000012/201360,8000003/201460,8000006/201460,9000009/201461,0000012/201460,9000003/201560,6000006/201560,3000009/201560,2000012/201560,1000003/201660,0000006/201660,0000009/201659,9000012/201659,8000003/201759,9000006/201759,80000"
					.replaceAll("\\s+", "");
			Thread.sleep(2000);
			if (y.equalsIgnoreCase(Copy_link)) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_340
		@And("^verify confirmation message for copy visual$")
		public void verify_confirmation_message_for_copy_visual() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack")))
					.isDisplayed());
	
		}
	
		// TC_TV_341
		@And("^verify copy here in growl message$")
		public void verify_copy_here_in_growl_message() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
			Thread.sleep(500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_clickhere"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
	
		}
	
		// TC_TV_342
		@And("^verify copied visual by pasting with in the insight$")
		public void verify_copied_visual_by_pasting_with_in_the_insight() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
	
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(8000);
			List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
			int attributes_table_count_after = attributes_list_after.size();
			System.out.println("Verified number as " + attributes_table_count_after);
			if (attributes_table_count_after >= 16) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_343
		@And("^verify copied visual by pasting to new insight$")
		public void verify_copied_visual_by_pasting_to_new_insight() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_icon_table"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CreateViewTab"))).click();
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack")))
					.isDisplayed());
			Thread.sleep(8000);
	
			List<WebElement> views = login.driver
					.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() >= 2) {
				List<WebElement> attributes_list_after = login.driver.findElements(By.className("hor-vertical-header"));
				int attributes_table_count_after = attributes_list_after.size();
				if (attributes_table_count_after >= 8) {
					System.out.println("Verified");
	
				} else {
					Assert.fail();
				}
			}
	
		}
	
		// TC_TV_344
		@And("^verify confrimation message for pasting visual in insight$")
		public void verify_confrimation_message_for_pasting_visual_in_insight() throws Throwable {
			verify_copied_visual_by_pasting_to_new_insight();
		}
	
		// TC_TV_345
		@And("^verify Download option$")
		public void verify_Download_option() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
			Thread.sleep(3000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Download_popup"))).isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
	
		}
	
		// TC_TV_347
		@And("^verify Table visual download with \"([^\"]*)\" format$")
		public void verify_Table_visual_download_with_format(String arg1) throws Throwable {
	
			File theNewestFile = null;
			File dir = new File(System.getProperty("user.home") + "\\Downloads");
			String ext = arg1;
			FileFilter fileFilter = new WildcardFileFilter("*." + ext);
			File[] files = dir.listFiles(fileFilter);
	
			if (files.length > 0) {
				/** The newest file comes first **/
				// System.out.println("^^^^^^^^^^^^Entered");
				Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
				theNewestFile = files[0];
	
				// }
	
				System.out.println("The Successfully downloaded file is " + theNewestFile);
				String E = getFileExtension(theNewestFile);
				System.out.println("The Successfully extension file is " + E);
				// return theNewestFile;
				if (E.equalsIgnoreCase(ext)) {
					System.out.println("Downloaded File Format Matched Successfully." + "'" + ext + "' <> '" + E + "'");
				} else {
	
					Assert.fail("Downloaded File Format is NOT Matched." + "'" + E + "' <> '" + ext + "'");
				}
			}
	
		}
	
		// TC_TV_347
		@And("^select PDF format$")
		public void select_PDF_format() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_PDF"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
	
		}
	
		// TC_TV_348
		@And("^select PNG format$")
		public void select_PNG_format() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_png"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
		}
	
		// TC_TV_349
		@And("^select JPG format$")
		public void select_JPG_format() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_jpeg"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
		}
	
		// TC_TV_346
		@And("^select XLSX format$")
		public void select_XLSX_format() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_icon"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Download_xlsx"))).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_download"))).click();
		}
	
		// TC_TV_350
		@And("^verify Open option$")
		public void verify_Open_option() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon"))).click();
			Thread.sleep(3000);
			String x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_copy"))).getText();
			if (x.contains("Copy")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
	
		}
	
		// TC_TV_351
		@And("^verify closing of maximized window$")
		public void verify_closing_of_maximized_window() throws Throwable {
	
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_window"))).click();
			Thread.sleep(2000);
			if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).size() == 0) {
				System.out.println("Table visual creating from View panel by drag and drop is working fine");
			} else {
				Assert.fail("Table visual creating from View panel by drag and drop is Not working fine");
			}
	
		}
	
		// TC_TV_352
		@And("^verify Delete Table$")
		public void verify_Delete_Table() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_popup"))).isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
	
		}
	
		// TC_TV_353
		@And("^verify description for delete confirmation popup$")
		public void verify_description_for_delete_confirmation_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_popup_inside")))
					.isDisplayed());
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadwindowclose"))).click();
	
		}
	
		// TC_TV_354
		@And("^verify Delete OK button in delete confirmation popup$")
		public void verify_Delete_OK_button_in_delete_confirmation_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_ok_empty"))).isDisplayed());
	
		}
	
		// TC_TV_355
		@And("^verify Delete Cancel/x icon in delete confirmation popup$")
		public void verify_Delete_Cancel_x_icon_in_delete_confirmation_popup() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_open_icon_delete"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_cancel"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_Table"))).isDisplayed());
	
		}
	
		// TC_TV_356
		@And("^verify right click options-Table visual$")
		public void verify_right_click_options_Table_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_copy"))).isDisplayed());
	
		}
	
		// TC_TV_357
		@And("^verify right click options-Copy Table$")
		public void verify_right_click_options_Copy_Table() throws Throwable {
			Thread.sleep(5000);
	
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_copy"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack")))
					.isDisplayed());
	
		}
	
		// TC_TV_358
		@And("^verify right click Validate copied Table$")
		public void verify_right_click_Validate_copied_Table() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_copy"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Add_icon"))).click();
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(8000);
			List<WebElement> views = login.driver
					.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() >= 2) {
				System.out.println("Verified");
				Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name"))).isDisplayed());
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_359
		@And("^verify right click options Cut Table$")
		public void verify_right_click_options_Cut_Table() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.pause(1000).contextClick(ele).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_cut"))).click();
			Thread.sleep(1000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Edit_table_Feedback_ack")))
					.isDisplayed());
	
		}
	
		// TC_TV_360
		@And("^verify right click  Validate Cut Table$")
		public void verify_right_click_Validate_Cut_Table() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_cut"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Add_icon"))).click();
			Thread.sleep(3000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(8000);
			List<WebElement> views = login.driver
					.findElements(By.xpath("//*[contains(@class,'insight-page-view-tab') and contains(text(),'View')]"));
			if (views.size() >= 2) {
				System.out.println("Verified");
				Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name"))).isDisplayed());
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_361
		@And("^verify right click  options Delete Table$")
		public void verify_right_click_options_Delete_Table() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.pause(2000).contextClick(ele).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_delete"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Invalidfunction_popupClose_ok"))).click();
			Thread.sleep(1500);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_delete_ok_empty"))).isDisplayed());
	
		}
	
		// TC_TV_362
		@And("^verify right click  options insert visual sub dropdown$")
		public void verify_right_click_options_insert_visual_sub_dropdown() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
	
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_chart")))
							.isDisplayed());
	
		}
	
		// TC_TV_363
		@And("^verify right click  chart under insert visual$")
		public void verify_right_click_chart_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(1000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_chart"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_chartvalid")))
					.isDisplayed());
	
		}
	
		// TC_TV_364
		@And("^verify right click  Pie under insert visual$")
		public void verify_right_click_Pie_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_pie"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_pievalid")))
					.isDisplayed());
		}
	
		// TC_TV_365
		@And("^verify right click  table under insert visual$")
		public void verify_right_click_table_under_insert_visual() throws Throwable {
	
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_table"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).isDisplayed());
	
		}
	
		// TC_TV_366
		@And("^verify right click  map under insert visual$")
		public void verify_right_click_map_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(3000).build().perform();
			Thread.sleep(2000);
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(3000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_map"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_mapvalid")))
					.isDisplayed());
	
		}
	
		// TC_TV_367
		@And("^verify right click  Heatmap under insert visual$")
		public void verify_right_click_Heatmap_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(3000).build().perform();
			Thread.sleep(2000);
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_heatmap"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_heatmapvalid"))).isDisplayed());
	
		}
	
		// TC_TV_368
		@And("^verify right click  Pyramid under insert visual$")
		public void verify_right_click_Pyramid_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.pause(3000).contextClick(ele).build().perform();
			Thread.sleep(2000);
	
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(3000).build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_pyramid"))).click();
			Thread.sleep(1500);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_pyramidvalid"))).isDisplayed());
	
		}
	
		// TC_TV_369
		@And("^verify right click  Commentary under insert visual$")
		public void verify_right_click_Commentary_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.pause(2000).contextClick(ele).build().perform();
			Thread.sleep(2000);
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.pause(2000).moveToElement(ele1).build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual_commentary")))
					.click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_commentaryvalid"))).isDisplayed());
	
		}
	
		// TC_TV_370
		@And("^verify right click  Attachment under insert visual$")
		public void verify_right_click_Attachment_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
	
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(2000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Table_rightclick_insertvisual_attachments", 10).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Attachmentsvalid"))).isDisplayed());
	
		}
	
		// TC_TV_371
		@And("^verify right click  image under insert visual$")
		public void verify_right_click_image_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(3000).build().perform();
			Thread.sleep(2000);
	
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(2000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Table_rightclick_insertvisual_Image", 10).click();
			System.out.println("=================================");
		}
	
		// TC_TV_372s
		@And("^verify right click  Filter under insert visual$")
		public void verify_right_click_Filter_under_insert_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			CommonFunctionality.action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(2000);
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_insertvisual")));
			action.moveToElement(ele1).pause(2000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Table_rightclick_insertvisual_filters", 10).click();
			Thread.sleep(3000);
			// jse.executeScript("window.scrollBy(0,550)", "");
			Assert.assertTrue(login.driver
					.findElements(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Filtervalid"))).size() == 1);
		}
	
		// TC_TV_373
		@And("^verify right click Paste visual$")
		public void verify_right_click_Paste_visual() throws Throwable {
	
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Table_rightclick_copy", 10).click();
			Thread.sleep(2000);
	
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Name")));
			action.contextClick(ele1).pause(3000).build().perform();
			CommonFunctionality.getElementByProperty(login.driver, "Table_rightclick_paste", 10).click();
	
			Thread.sleep(5000);
			if (login.driver.findElements(By.xpath("(//div[@class='visual-title visual-title--wrapper'])[3]"))
					.size() == 1) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
		}
	
		// TC_TV_374
		@And("^verify right click View as sub dropdown$")
		public void verify_right_click_View_as_sub_dropdown() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
	
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
			action.moveToElement(ele1).pause(2000).build().perform();
	
			String[] exp = { "Chart", "Map", "Pie", "Heat map", "Histogram" };
			List<WebElement> Viewasoptions = login.driver
					.findElements(By.xpath("(//span[@class='dropdown-submenu-icon'])[1]/following::ul[2]/li"));
			for (WebElement we : Viewasoptions) {
				boolean match = false;
				for (int j = 0; j < exp.length; j++) {
					String X = we.getText();
					if (X.equals(exp[j])) {
						System.out.println(X + exp[j]);
						match = true;
						System.out.println("DropDown is verified successfully");
					}
				}
				// Assert.assertTrue(match);
				if (match = false) {
					Assert.fail();
				}
			}
		}
	
		// TC_TV_375
		@And("^verify right click View as Chart$")
		public void verify_right_click_View_as_Chart() throws Throwable {
	
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
	
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
	
			WebElement ele2 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_chart")));
			action.moveToElement(ele2).pause(6000).click().build().perform();
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_chart"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_chartvalid"))).isDisplayed());
	
		}
	
		// TC_TV_376
		@And("^verify right click View as Map$")
		public void verify_right_click_View_as_Map() throws Throwable {
	
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_map")));
			action.moveToElement(ele2).pause(2000).click().build().perform();
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_map"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_maptvalid"))).isDisplayed());
	
		}
	
		// TC_TV_377
		@And("^verify right click View as Histogram$")
		public void verify_right_click_View_as_Histogram() throws Throwable {
	
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
	
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			WebElement ele2 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_histogram")));
			action.moveToElement(ele2).pause(2000).click().build().perform();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_tspanhistogram")))
					.click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_histogramvalid")))
							.isDisplayed());
	
		}
	
		// TC_TV_378
		@And("^verify right click View as Pie$")
		public void verify_right_click_View_as_Pie() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
	
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			WebElement ele2 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_pie")));
			action.moveToElement(ele2).pause(2000).click().build().perform();
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_pie"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_pievalid"))).isDisplayed());
		}
	
		// TC_TV_379
		@And("^verify right click View as Heatmap$")
		public void verify_right_click_View_as_Heatmap() throws Throwable {
			CreateTable();
			Thread.sleep(2000);
	
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(6000).build().perform();
			Actions action1 = new Actions(login.driver);
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas")));
			action1.moveToElement(ele1).pause(6000).build().perform();
			Thread.sleep(2000);
			Actions action2 = new Actions(login.driver);
			WebElement ele2 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_heatmap")));
			action2.moveToElement(ele2).pause(6000).click().build().perform();
			// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_heatmap"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_viewas_heatmapvalid")))
							.isDisplayed());
			// Thread.sleep(2000);
			// CommonFunctionality.Views_list();
			System.out.println("Test case pass");
		}
	
		// TC_TV_380
		@And("^verify right click Calculated series sub dropdown$")
		public void verify_right_click_Calculated_series_sub_dropdown() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
	
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculate_series")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculate_series_valid")))
					.isDisplayed());
	
		}
	
		// TC_TV_381
		@And("^verify right click appling function from Calculated series$")
		public void verify_right_click_appling_function_from_Calculated_series() throws Throwable {
			Thread.sleep(5000);
			String beforeseriesname = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.pause(2000).contextClick(ele).build().perform();
			WebElement ele1 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculate_series")));
			action.moveToElement(ele1).pause(2000).build().perform();
			Thread.sleep(2000);
	
			WebElement ele2 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_calculateseries_changeYoY")));
			action.moveToElement(ele2).pause(2000).doubleClick().build().perform();
			Thread.sleep(2000);
			String afterseriesname = login.driver.findElement(By.xpath("//span[@class='series-edit--title']")).getText();
			if (!beforeseriesname.equalsIgnoreCase(afterseriesname)) {
				System.out.println("Verified");
	
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_382
		@And("^verify right click  Edit series option$")
		public void verify_right_click_Edit_series_option() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Editseries"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_Editseriesvalid"))).isDisplayed());
	
		}
	
		// TC_TV_383
		@And("^verify right click Clear contents$")
		public void verify_right_click_Clear_contents() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			Thread.sleep(1000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_clearcontent"))).click();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ResultTableVisual"))).isDisplayed());
	
		}
	
		// TC_TV_384
		@And("^verify right click  reset format$")
		public void verify_right_click_reset_format() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver
					.findElement(By.xpath("//th[@class='hor-vertical-header' and contains(text(),'Region')]"));
			action.pause(2000).contextClick(ele).build().perform();
			login.driver.findElement(By.xpath(
					"//th[@class='hor-vertical-header' and contains(text(),'Region')]//span[@title='Remove attribute']"))
					.click();
	
			WebElement ele1 = login.driver
					.findElement(By.xpath("//th[@class='hor-vertical-header' and contains(text(),'Frequency')]"));
			action.contextClick(ele1).pause(2000).build().perform();
	
			Thread.sleep(2000);
			boolean resetrightclick = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_reset"))).isEnabled();
			if (resetrightclick == true) {
				System.out.println("Verified");
				Thread.sleep(500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_reset"))).click();
			}
	
		}
	
		// TC_TV_385
		@And("^verify right click  reset format option if have no changes in visual$")
		public void verify_right_click_reset_format_option_if_have_no_changes_in_visual() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.pause(2000).contextClick(ele).build().perform();
			Thread.sleep(2000);
			String ressetrightclick = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_reset_disable")))
					.getAttribute("class");
			if (ressetrightclick.contains("disabled")) {
				System.out.println("Verified");
			} else {
				Assert.fail();
			}
	
		}
	
		// TC_TV_386
		@And("^verify right click download sub dropdown$")
		public void verify_right_click_download_sub_dropdown() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.pause(2000).contextClick(ele).build().perform();
	
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download")));
			action.moveToElement(ele1).pause(2000).build().perform();
	
			String[] exp = { "Table", "View" };
			List<WebElement> Viewasoptions = login.driver
					.findElements(By.xpath("(//span[@class='dropdown-submenu-icon'])[1]/following::ul[4]/li"));
			for (WebElement we : Viewasoptions) {
				boolean match = false;
				for (int j = 0; j < exp.length; j++) {
					String X = we.getText();
					if (X.equals(exp[j])) {
						System.out.println(X + exp[j]);
						match = true;
						System.out.println("DropDown is verified successfully");
					}
				}
				// Assert.assertTrue(match);
				if (match = false) {
					Assert.fail();
				}
			}
	
		}
	
		// TC_TV_387
		@And("^verify right click download > Table$")
		public void verify_right_click_download_Table() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
	
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download")));
			action.moveToElement(ele1).pause(2000).build().perform();
	
			WebElement ele2 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_table")));
			action.moveToElement(ele2).pause(2000).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_tablevalid")))
							.isDisplayed());
			Thread.sleep(500);
			CommonFunctionality.getElementByProperty(login.driver, "Downloadwindowclose", 10).click();
		}
	
		// TC_TV_388
		@And("^verify right click download > View$")
		public void verify_right_click_download_View() throws Throwable {
			Thread.sleep(5000);
			WebElement ele = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("RClickTable")));
			action.contextClick(ele).pause(2000).build().perform();
			WebElement ele1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download")));
			action.moveToElement(ele1).pause(2000).build().perform();
			WebElement ele2 = login.driver
					.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_view")));
			action.moveToElement(ele2).pause(2000).click().build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_rightclick_download_viewvalid")))
							.isDisplayed());
			Thread.sleep(500);
			CommonFunctionality.getElementByProperty(login.driver, "Downloadwindowclose", 10).click();
		}
	
		@And("^Create a table visual$")
		public void create_a_table_visual() throws Throwable {
			CreateTable();
		}
	
		// Create_Table
		public void CreateTable() throws Throwable {
			CommonFunctionality.webDriverwait_keyvalue("series_tab");
			CommonFunctionality.getElementByProperty(login.driver, "series_tab", 8).click();
			Thread.sleep(2000);
			WebElement checkBox = login.driver.findElement(By.xpath("(//*[@class='series-item--name'])[1]/preceding::*[@class='series-list-item--checkbox-wrapper']/*"));
			checkBox.click();
			//action.moveToElement(mouseover).pause(1000).contextClick().build().perform();
			EmptyView.click_on_View_tab();
			CommonFunctionality.getElementByXpath(login.driver, "//*[@class='view-components-over--visuals']//*[@class='icon--table']", 8).click();
	
		}
	
		public static String getFileExtension(File file) {
			String name = file.getName();
			try {
				return name.substring(name.lastIndexOf(".") + 1);
	
			} catch (Exception e) {
				return "";
			}
		}
	
	}
