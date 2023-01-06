package CDMNext.StepDefinations;

import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;
import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.*;
import test.ant.AntSystemPropertySet;

public class SprintCases_4_8 {
	Actions action=new Actions(login.driver);
	WebDriverWait wait = new WebDriverWait(login.driver, 30);
	JavascriptExecutor js = (JavascriptExecutor) login.driver;
	public String windowsversion;
	
	@And("^Add table and text$")
	public void add_table_and_text() throws Throwable {
		Thread.sleep(2000);

		// click on table dropdown
		login.driver.findElement(By.xpath("//button[@title='More...']//*[@class='tox-icon tox-tbtn__icon-wrap']")).click();
Thread.sleep(2000);
login.driver.findElement(By.xpath("//div[@class='tox-toolbar__overflow']//button[@class='tox-tbtn tox-tbtn--select']//div[@class='tox-tbtn__select-chevron']")).click();

		// mouse over the table
		WebElement table = login.driver.findElement(By.xpath("(//*[@class='tox-collection__item-label'])[1]"));
	
		action.moveToElement(table).click().perform();

		login.driver.findElement(By.xpath("//div[@class='tox-insert-table-picker__selected']")).click();

	//	login.driver.findElement(By.xpath("(//tbody/tr[1]/td[1])[2]")).sendKeys("Hello");

	}
/*	@And("^click on CEIC insights and click on '\\+ icon on india'$")
	public void click_on_CEIC_insights_and_click_on_icon_on_india() throws Throwable {
		Thread.sleep(1000);

		// click on CEIC Insights
		//login.driver.findElement(By.xpath("//*[contains(text(),'CEIC Insights')]")).click();

		// click on india +icon
Thread.sleep(2000);
		login.driver.findElement(By.xpath("(//div[@class='toggle'])[15]")).click();

	}*/
	@And("^click on GDP nowcast insight$")
	public void click_on_GDP_nowcast_insight() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[normalize-space(text())='GDP Nowcast']")).click();
		Thread.sleep(2000);
        // js.executeScript("arguments[0].ScrollIntoview().click();",login.driver.findElement(By.xpath("(//*[contains(text(),'State Elections in India: Punjab')])[1]")));
        // login.driver.findElement(By.xpath("(//*[contains(text(),'Indonesia Payment and Settlement System')])[1]")).click();

	}
	// TC_18934_01
	@And("^click on table properties$")
	public void click_on_table_properties() throws Throwable {

		Thread.sleep(2000);

		// click on table dropdown
		login.driver.findElement(By.xpath("//div[@class='tox-toolbar__overflow']//button[@class='tox-tbtn tox-tbtn--select']//div[@class='tox-tbtn__select-chevron']")).click();

		login.driver.findElement(By.xpath("(//*[contains(text(),'Table properties')])")).click();

	}

	// TC_18934_01
	@And("^click on class dropdown and select CDMNext table$")
	public void click_on_class_dropdown_and_select_CDMNext_table() throws Throwable {
		Thread.sleep(2000);
		WebElement dropdown = login.driver.findElement(By.xpath("(//*[@class='tox-listbox__select-chevron'])[2]"));
		action.moveToElement(dropdown).pause(500).click().perform();

		//login.driver.findElement(By.xpath("(//*[@class='mce-caret'])[11]")).click();

		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[contains(text(),'CDMNext table')]")).click();

	}

	// TC_18934_01
	@And("^click on Ok button$")
	public void click_on_Ok_button() throws Throwable {
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

	}

	// TC_18934_01
	@Then("^CDMNext table format should be apply$")
	public void cdmnext_table_format_should_be_apply() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='visual-top-panel--content']")).click();
		login.driver.findElement(By.xpath("//tbody/tr/td")).click();

		//String color = login.driver.findElement(By.xpath("//tbody/tr/td")).getCssValue("background-color");
		//System.out.println(color);

	}
	@And("^Verify Customize button for insight$")
	public void verify_Customize_button_for_insight() throws Throwable {
		Thread.sleep(5000);
	login.driver.switchTo().activeElement();
		login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();

		// mouse over on the series
		WebElement mouseover = login.driver.findElement(By.xpath("//*[@class='insight-grid-item--thumbnail-box']"));
		action.moveToElement(mouseover).pause(500).build().perform();

	}
	@Then("^Customize button should not available$")
	public void customize_button_should_not_available() throws Throwable {
		Thread.sleep(2000);

		if (login.driver.findElements(By.xpath("//*[contains(text(),'Customize')]")).size() == 0) {
			System.out.println("Customize button should not available");
		}

		else {
			Assert.fail();
		}

	}
	@Given("^click on \\+ icon in right side panel$")
	public void click_on_icon_in_right_side_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//*[@class='insight-page-menu-views-container--add']")).click();
	}
	@Given("^click on Analysis tab$")
	public void click_on_Analysis_tab() throws Throwable {
		Thread.sleep(3000);

		login.driver.findElement(By.xpath("(//*[contains(text(),'Analysis')])[1]")).click();

	}
	@Given("^Create commentary visual$")
	public void create_commentary_visual() throws Throwable {

		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[@class='icon--text']")).click();
		Thread.sleep(5000);

	}
	/*@Then("^GDP Nowcast should open insight in preview mode\\.View as grid mode$")
	public void gdp_Nowcast_should_open_insight_in_preview_mode_View_as_grid_mode() throws Throwable {
		Thread.sleep(1000);

		if (login.driver.findElements(By.xpath("//*[@class='insight-preview--actions']")).size() == 1) {
			System.out.println("GDP Nowcast should open insight in preview mode.view as grid mode");
		}

		else {
			Assert.fail();
		}
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();

	}*/
	@Then("^GDP Nowcast should open insight in preview mode\\.View as table mode$")
	public void gdp_Nowcast_should_open_insight_in_preview_mode_View_as_table_mode() throws Throwable {
		Thread.sleep(1000);
		// click on CEIC Insights
		login.driver.findElement(By.xpath("//*[contains(text(),'CEIC Insights')]")).click();

		// click on Table view

		login.driver.findElement(By.xpath("//div[@class='insights-view-modes--item insights-view-modes--item__table']"))
				.click();
		Thread.sleep(3000);
		// click on GDP nowcast insight
		login.driver.findElement(By.xpath("(//a[@class='link insight-table-item--title-link text-dots'])[1]")).click();

		if (login.driver.findElements(By.xpath("//*[@class='insight-preview--actions']")).size() == 1) {
			System.out.println("GDP Nowcast should open insight in preview mode.View as table mode");
		}

		else {
			Assert.fail();
		}

		login.driver.findElement(By.xpath("//*[@class='insight-preview--close']")).click();
	}
	@Given("^click on menu icon in left side panel$")
	public void click_on_menu_icon_in_left_side_panel() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath("//div[@class='help-title--icon']")).click();

	}

	// TC_18786_01
	@Given("^click on Excel Add-in$")
	public void click_on_Excel_Add_in() throws Throwable {

		Thread.sleep(1000);

		login.driver.findElement(By.xpath("//*[contains(text(),'Excel Add')]")).click();

	}

	// TC_18786_01
	@Given("^Check 'Select Microsoft Windows Version'$")
	public void check_Select_Microsoft_Windows_Version() throws Throwable {
		Thread.sleep(1000);

		WebElement data = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Windows 10 (64 Bit)')]")));
		String value = data.getText().toString();
		windowsversion = value.toLowerCase();
		System.out.println("Select Microsoft Windows Version:" + windowsversion);

	}

	// TC_18786_01
	@Then("^Windows (\\d+) \\((\\d+) Bit\\) should select by default$")
	public void windows_Bit_should_select_by_default(int arg1, int arg2) throws Throwable {

		String os = System.getProperty("os.name").toLowerCase();
		
		String excepted = os + " (64 bit)";
		System.out.println(excepted);

	

		if (windowsversion.equals(excepted)) {
			System.out.println("Windows 10 (64 Bit)should select by default");
		} else {
			Assert.fail();
		}

	}


	// TC_18757_01
	@Given("^upload image visual$")
	public void upload_image_visual() throws Throwable {
		Thread.sleep(5000);
		 Robot robot = new Robot();
		 robot.setAutoDelay(2000);
		// CommonFunctionality.uploadTheFileusingAutoIT(login.driver,System.getProperty("user.dir") + "\\AutoIT\\Shravas.exe",System.getProperty("user.dir") + "\\AutoIT\\Shravas.png");
			
	       StringSelection selection = new StringSelection("E:\\CDMNextProject\\CDMNext\\cucumber\\AutoIT\\Shravas.png");
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

	       robot.setAutoDelay(1000);

	       robot.keyPress(KeyEvent.VK_CONTROL);
	       robot.keyPress(KeyEvent.VK_V);

	       robot.keyRelease(KeyEvent.VK_CONTROL);
	       robot.keyRelease(KeyEvent.VK_V);

	       robot.setAutoDelay(1000);

	       robot.keyPress(KeyEvent.VK_ENTER);
	       robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(30000);
		Thread.sleep(5000);
		
		login.driver.switchTo().frame(0);
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].click();",login.driver.findElement(By.xpath("//body[@id='tinymce']//img" )));
		login.driver.switchTo().defaultContent();
		
	}

	// TC_18757_01
	@Then("^select Fit to width$")
	public void select_Fit_to_width() throws Throwable {
		Thread.sleep(7000);
      Thread.sleep(5000);

		//login.driver.findElement(By.xpath("//*[contains(text(),'Original size')]")).click();

		login.driver.findElement(By.xpath("//*[contains(text(),'Fit to width')]")).click();

		
		login.driver.switchTo().frame(0);
		if(login.driver.findElements(By.xpath("//p//img[@width='200']")).size()==1)
		{
			System.out.println("select Fit to width");
		}
		
		else {
			Assert.fail();
		}
		
		login.driver.switchTo().defaultContent();
		}
	@Given("^create image visual$")
	public void create_image_visual() throws Throwable {
		Thread.sleep(2000);

		login.driver.findElement(By.xpath("//*[@class='insight-page-menu-views-container--add']")).click();

		Thread.sleep(1000);
	
		login.driver.findElement(By.xpath("//*[@class='icon--image']")).click();
		login.driver.findElement(By.xpath(
				"//button[@title='Upload image']/span[@class='tox-icon tox-tbtn__icon-wrap']")).click();
	}
	@And("^Choose a series in  Database tree$")
	public void Choose_a_series_in_Database_tree()
	{
		login.driver.findElement(By.xpath("//span[contains(text(),'Databases')]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='GLOBAL']/div[@class='toggle'])[1]")).click();
		//login.driver.findElement(By.xpath("(//span[normalize-space(text())='Global Database']//ancestor::div/parent::div[@data-node-model-id='GLOBAL']//div)[1]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='GLOBAL&&ALL']/div[@class='toggle'])[1]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='TP2560837']/div[@class='toggle'])[1]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='SC2576097']/div[@class='toggle'])[1]")).click();
		login.driver.findElement(By.xpath("(//div[@data-node-model-id='TB2643987']/div[@class='toggle'])[1]")).click();
		action.moveToElement(login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]"))).build().perform();
	}
	@And("^Create footnote for the series$")
	public void Create_footnote_for_the_series()
	{
		login.driver.findElement(By.xpath("(//div[@class='series-list-item-data'])[1]/div[@class='series-list-item--action-icons']/span[@title='Open footnote']")).click();
	}
	@Then("^Check the tabs in footnotes$")
	public void Check_tabs_in_footnotes() throws InterruptedException
	{
		login.driver.switchTo().activeElement();
		Thread.sleep(4000);
		List<WebElement> l=login.driver.findElements(By.xpath("//div[@class='tabs__tabs-box']/div[@ui='$tab']"));
		for(WebElement l2:l)
		{
		  String s1=l2.getText().toString();
		  System.out.println(s1);
		}
	}

}
