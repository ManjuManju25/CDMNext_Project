package CDMNext.StepDefinations;

import java.awt.Robot;

//import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Download {
	public static String DownloadedFilesCount;
	public static String InsightsCount_Tabs;
	public static WebDriver driver;
	//public static String InsightName;
	WebElement element;
	WebElement element1;
	Actions action = new Actions(login.driver);
	// private static String downloadPath =
	// "C:\\Users\\Admin\\Downloads\\CDMNext_Download";
	public static final Logger Log4j = Logger.getLogger("Log4j");
	public static Properties LOCATORS;
	//private static Boolean logged = false;
	public static String InsightName; 
	// Actions action = new Actions(driver);

	@When("^User select on Download$")
	public void user_select_on_Download() throws Throwable {
		Thread.sleep(20000);
		login.Log4j.info("Clicking on download button - " + login.LOCATORS.getProperty("btnDownload"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownload"))).click();
	}

	@When("^User select on Pop up download$")
	public void user_select_on_Pop_up_download() throws Throwable {
		Thread.sleep(1000);
		//login.Log4j.info("Clicking on Pop up download button - " + login.LOCATORS.getProperty("Popup_Downloadbtn"));
		
		//WebDriverWait wait = new WebDriverWait(login.driver, 10);
		//element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Download')]")));
		//element.click();
		//"/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[2]/button[4]/span"
		//WebElement x = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Popup_Downloadbtn")));
		//WebElement x = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[2]/button[4]/span"));
		//x.sendKeys(Keys.TAB);
		//x.sendKeys(Keys.ENTER);
		login.driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[2]/div[2]/button[4]/span")).click();
	}

	@And("^User download should be Sucess$")
	public void user_download_should_be_Sucess() throws Throwable {
		
		
		
		Latestfiledownload.lastFileModified();
		
		
		
		
	 /*
		String y = "FAIL";
		File file = new File(System.getProperty("user.home") + "\\Downloads");
		
		File[] files = file.listFiles();
		for (File currentfile : files) {
			login.Log4j.info("****************> THE SUCCESFULLY DOWNLOADED INSIGHTS  - >***************");
			String x = (double) currentfile.length() / 1024 + "  kb";
			if(currentfile.exists()){
				y = "PASS";
			login.Log4j.info("The Downloaded Insight are - " + currentfile.getName() +   " - Size : " +  x  +   " - Status : " + y );
			
		}
			else{
				//String y = "FAIL";
				login.Log4j.info("The Downloaded Insight are - " + currentfile.getName() +   " - Size : " +  x  +   " - Status : " + y );
			}
	}
	*/
	}
	@Given("^Select China Premium Data Talk tab$")
	public void select_China_Premium_Data_Talk_tab() throws Throwable {

		login.Log4j.info("Clicking on China Premium Button - " + login.LOCATORS.getProperty("chinaPremium_Tab"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chinaPremium_Tab"))).click();
	}

	@And("^User Select Analytic tab$")
	public void user_Select_Analytic_tab() throws Throwable {
		Thread.sleep(5000);
		login.Log4j.info("Clicking on Analytic tab - " + login.LOCATORS.getProperty("Analytic_Tab"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Analytic_Tab"))).click();
		login.Log4j.info("Clicking on Table view tab - " + login.LOCATORS.getProperty("Table_Tab"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Tab"))).click();
	}
	
	
	@And("^User Download the CEIC GALLERY Insights$")
	public void user_Download_the_CEIC_GALLERY_Insights() throws Throwable {
			login.driver
					.findElement(By
							.xpath("//*[@id='landing_page']/div[2]/div/div[1]/div[3]/div/div[1]/div/span[1]/span/span/i[1]"))
					.click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/table/tr[1]")).click();
			login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/table/tr[2]")).click();
			login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/table/tr[3]")).click();
			login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/table/tr[4]")).click();
			login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/table/tr[5]")).click();
			login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[1]/table/tr[6]")).click();
			Thread.sleep(3000);
			login.driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div[2]")).click();
			Thread.sleep(3000);
			

			JavascriptExecutor jse = (JavascriptExecutor) login.driver;
			
			
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'Caixin China Indices')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'China Belt and Road Initiative')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'Russia - Macro Overview')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			
			
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'ASEAN Public Finance')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'India Foreign Trade')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'China Cement')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'ASEAN Tourism')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'China Li Keqiang Index')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'Indonesia Inflation')]"));
			
			
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'India: Inflation')]"));
			
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'China CPI')]"));
			
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'China Property Price')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'Mexico - Retail Sales')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'Abenomics')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'China FAI')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			//element = login.driver.findElement(By.xpath("//div/a[contains(text(),'CIS Macro Overview')]"));
			//jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(20000);

			WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ceicgallery_Tab")));
			String CEICGalleryTab_Name = element.getText();

			String str = CEICGalleryTab_Name;
			String numbers;
			numbers = str.replaceAll("[^0-9]", "");

			int result = Integer.parseInt(numbers);
			System.out.println("Total Numbers  of Insights in CEICGalleryTab: " + result);

			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));
			login.Log4j.info("Total Insights are- " + objLinks.size());
			System.out.println("Total Insights are : " + objLinks.size());

			//if (result == objLinks.size()) 
			//{
				//System.out.println(" Insights Numbers Matched, can proceed to  download");

				 //for (int i = 0; i < objLinks.size(); i++)
				for (int i = 0; i < 1; i++) 
				{
					try {
					int n = i + 1;
					login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size()   +    " - The Downloading Insight is - " + objLinks.get(i).getText());
					//login.Log4j.info("Downloading Insight " + n);
					//login.Log4j.info("The Downloading Insight is - " + objLinks.get(i).getText());
					//System.out.println(objLinks.get(i).getText());
			    	String InsightName = objLinks.get(i).getText();
					// login.driver.findElement(By.xpath("//div/a[contains(text(),'ChinaFinancial
					// Risk')]")).click();
					//login.driver.findElement(By.xpath("//div/a[contains(text(),'CISMacro Overview')]")).click();
					login.driver.findElement(By.linkText(InsightName)).click();
					//login.Log4j.info("Clicking on Downloading icon - " + login.LOCATORS.getProperty("Downloadicon"));
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadicon"))).click();
					Thread.sleep(10000);

					// get the current window handle

					String parentHandle = login.driver.getWindowHandle();
					java.util.Set<String> winHandle = login.driver.getWindowHandles();

					// if(!(winHandle.isEmpty()))
					if (login.driver
							.findElements(
									By.xpath("//button[@class='sphere-modal-control sphere-modal-control--filled']"))
							.size() != 0) 
						//if (login.driver
							//	.findElements(
							//			By.xpath("/html/body/div[1]/div/div[4]/div[2]/div/div[1]/h4"))
							//	.size() != 0) 	
					{
						login.Log4j.info("Data contain deleted series in Insight " + InsightName);
						//System.out.println(" Data contain deleted series in Insight " + InsightName);
						// for (String winHandle1 :
						// login.driver.getWindowHandles())
						// {
						// login.driver.switchTo().window(winHandle1);// switch
						// focus of WebDriver to the next found window handle
						// (that's your newly opened window)
						// System.out.println("Entered into new window ");
						// }
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Unexpected_error_ok"))).click();

						// login.driver
						// .findElement(By
						// .xpath("//button[@class='sphere-modal-control
						// sphere-modal-control--filled']"))
						// .click();

						// code to do something on new window
						// login.driver.close(); // close newly opened window
						// when done with it
						// login.driver.switchTo().window(parentHandle);

						user_select_on_Pop_up_download();

						Thread.sleep(50000);
						//login.Log4j.info("Clicking on Insight-preview-close - "
								//+ login.LOCATORS.getProperty("insight-preview-close"));
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight-preview-close"))).click();
						// login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
						Thread.sleep(50000);
						// user_download_should_be_Sucess();
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_ENTER);
					}
					else 
					{
						user_select_on_Pop_up_download();
						Thread.sleep(90000);
						//login.Log4j.info("Clicking on Insight-preview-close - "
							//	+ login.LOCATORS.getProperty("insight-preview-close"));
						login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight-preview-close"))).click();
						// login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
						Thread.sleep(50000);
						user_download_should_be_Sucess();
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_TAB);
						robot.keyPress(KeyEvent.VK_ENTER);
					}
				//}					
		//}		
			//else 
			//{
				//System.out.println(" Insights Numbers Does'nt Matched !!!!! ");
				//Assert.fail(" Insights Numbers Does'nt Matched !!!!! ");
			//}
	}catch (Exception e) 
		{
			File src = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:/Users/Admin/Pictures/error.png"));
			 
			if (login.driver
					.findElements(By.xpath("//button[@class='sphere-modal-control sphere-modal-control--filled']"))
					.size() != 0) 
			{
				String InsightName = objLinks.get(i).getText();
				 login.Log4j.info("Unexpected Error in Insight" + InsightName);
				//System.out.println("Unexpected Error in Insight" + str);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Unexpected_error_ok"))).click();

				// login.driver
				// .findElement(By.xpath("//button[@class='sphere-modal-control
				// sphere-modal-control--filled']"))
				// .click();		
			}
			continue;
			//login.Log4j.error(" THE WEBELEMENT IS NOT VISIABLE !!!!!! ");
			//Assert.fail(" THE WEBELEMENT IS NOT VISIABLE !!!!!! " + e.getMessage());
			//continue;
		}			
	}
}
	@And("^User Download the CHINA PREMIUM Insights$")
	public void user_Download_the_CHINA_PREMIUM_Insights() throws Throwable {

		
			WebElement element = login.driver
					.findElement(By.xpath("//div[@class='insights-sub-groups-list-item-title']/div[2]"));
			String CHINAPREMIUMTab_Name = element.getText();
			System.out.println(CHINAPREMIUMTab_Name);
			String str = CHINAPREMIUMTab_Name;
			String numbers;
			numbers = str.replaceAll("[^0-9]", "");
			// System.out.println("Numbers are: " + numbers);
			int result = Integer.parseInt(numbers);
			System.out.println("Total Numbers  of Insights in CHINAPREMIUMTab: " + result);

			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));

			login.Log4j.info("Total Insights are- " + objLinks.size());
			// System.out.println("Total Insights are : "+objLinks.size());
			Thread.sleep(3000);
			//if(result == objLinks.size())
			//{
			//System.out.println(" Insights Numbers Matched, can proceed to download");
			//for (int i = 0; i < objLinks.size(); i++)
			 for(int i=0;i<2;i++)
			{
				 try 
					{
				int n = i + 1;
				login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size()   +    " - The Downloading Insight is - " + objLinks.get(i).getText());
				//login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size());
				//login.Log4j.info("Downloading Insight " + n);
				//login.Log4j.info("The Downloading Insight is - " + objLinks.get(i).getText());
				// System.out.println(objLinks.get(i).getText());
				String InsightName = objLinks.get(i).getText();
				login.driver.findElement(By.linkText(InsightName)).click();
				login.Log4j.info("Clicking on Downloading icon - " + login.LOCATORS.getProperty("Downloadicon"));
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadicon"))).click();
				Thread.sleep(10000);
				login.Log4j.info("Clicking on PDF - " + login.LOCATORS.getProperty("PDF_Format"));
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format"))).click();
				Thread.sleep(20000);
				user_select_on_Pop_up_download();
				Thread.sleep(50000);
				login.Log4j.info(
						"Clicking on Insight-preview-close - " + login.LOCATORS.getProperty("insight-preview-close"));
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight-preview-close"))).click();
				// login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
				Thread.sleep(20000);
				user_download_should_be_Sucess();
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_ENTER);
				// Thread.sleep(30000);
			//}
			//}
			// else
			// {
			 //System.out.println(" Insights Numbers Does'nt Matched !!!!! ");
			// }
		} catch (Exception e) {
			File src = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:/Users/Admin/Pictures/BDD/error.png"));
			if (login.driver
					.findElements(By.xpath("//button[@class='sphere-modal-control sphere-modal-control--filled']"))
					.size() != 0) 
			{
				String InsightName = objLinks.get(i).getText();
				login.Log4j.info("Unexpected Error in Insight" + InsightName);
				//System.out.println("Entered *************** ");
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Unexpected_error_ok"))).click();

				// login.driver
				// .findElement(By.xpath("//button[@class='sphere-modal-control
				// sphere-modal-control--filled']"))
				// .click();		
			}
			continue;
			//login.Log4j.error(" THE WEBELEMENT IS NOT VISIABLE !!!!!! ");
			//Assert.fail(" THE WEBELEMENT IS NOT VISIABLE !!!!!! " + e.getMessage());
		}
		}
	}

	@And("^User Select Focus Economics tab$")
	public void user_Select_Focus_Economics_tab() throws Throwable {
		Thread.sleep(5000);
		login.Log4j.info("Clicking on Focus Economics button - " + login.LOCATORS.getProperty("FocusEconomics_Tab"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab"))).click();
		//login.driver.findElement(By.xpath("//span[contains(text(),'Focus Economics')]")).click();
	}

	@And("^User Download the Focus Economics Insights$")
	public void user_Download_the_Focus_Economics_Insights() throws Throwable {

		
			JavascriptExecutor jse = (JavascriptExecutor) login.driver;
			
			
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Base Metals Commodities - July 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast ASEAN - July 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Nordic Economies – June 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Base Metals Commodities - May 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Latin America - April 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Euro Area – April 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Switzerland – March 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By
					.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Euro Area – February 2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'FocusEconomics Consensus Forecast CIS Countries - December 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'FocusEconomics Consensus Forecast Base Metals Commodities – December 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'FocusEconomics Consensus Forecast South-Eastern Europe - November 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'FocusEconomics Consensus Forecast CIS Countries – October 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'FocusEconomics Consensus Forecast Central America and Caribbean - September 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By
					.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Switzerland - August 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By
					.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast CIS Countries - July 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'FocusEconomics Consensus Forecast Middle East and North Africa - June 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast ASEAN - February 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'FocusEconomics Consensus Forecast Central America and Caribbean - April 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast ASEAN - March 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By
					.xpath("//div/a[contains(text(),'FocusEconomics Consensus Forecast Latin America - March 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(30000);
			// List<WebElement> objLinks =
			// login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));
			// System.out.println("Total Insights are : "+objLinks.size());

			WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab_C")));
					//login.driver.findElement(By.xpath("//span[contains(text(),'Focus Economics (264)')]"));
			String FocusTab_Name = element.getText();
			System.out.println(FocusTab_Name);
			String str = FocusTab_Name;
			String numbers;
			numbers = str.replaceAll("[^0-9]", "");
			// System.out.println("Numbers are: " + numbers);
			int result = Integer.parseInt(numbers);
			System.out.println("Total Numbers  of Insights in Focus_Tab: " + result);

			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));

			login.Log4j.info("Total Insights are- " + objLinks.size());
			// System.out.println("Total Insights are : "+objLinks.size());

			//if (result == objLinks.size()) {
				//System.out.println(" Insights Numbers Matched, can proceed to download");

				//int DownloadedFilesCount = objLinks.size();

				 for(int i=0;i<objLinks.size();i++)
				//for (int i = 0; i < 1; i++) 
				{
					try {
					int n = i + 1;
					login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size()   +    " - The Downloading Insight is - " + objLinks.get(i).getText());
					//login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size());
					//login.Log4j.info("Downloading Insight " + n);
					//login.Log4j.info("The Downloading Insight is - " + objLinks.get(i).getText());
					// System.out.println(objLinks.get(i).getText());
					String InsightName = objLinks.get(i).getText();
					login.driver.findElement(By.linkText(InsightName)).click();
					login.Log4j.info("Clicking on Downloading icon - " + login.LOCATORS.getProperty("Downloadicon"));
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadicon"))).click();
					Thread.sleep(10000);
					// login.Log4j.info("Clicking on PDF - "
					// +login.LOCATORS.getProperty("PDF_Format"));
					// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format"))).click();
					// Thread.sleep(20000);
					// user_select_on_Pop_up_download();
					Thread.sleep(50000);
					login.Log4j.info("Clicking on Insight-preview-close - "
							+ login.LOCATORS.getProperty("insight-preview-close"));
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight-preview-close"))).click();
					// login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
					Thread.sleep(20000);
					user_download_should_be_Sucess();
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_ENTER);
					// Thread.sleep(30000);
					// user_download_should_be_Sucess();
					// Thread.sleep(10000);

				//}
			//}
				//else 
				//{
				//System.out.println(" Insights Numbers Does'nt Matched !!!!! ");
			//}
		} catch (Exception e) {
			File src = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:/Users/Admin/Pictures/BDD/error.png"));
			if (login.driver
					.findElements(By.xpath("//button[@class='sphere-modal-control sphere-modal-control--filled']"))
					.size() != 0) 
			{
				String InsightName = objLinks.get(i).getText();
				login.Log4j.info("Unexpected Error in Insight" + InsightName);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Unexpected_error_ok"))).click();

				// login.driver
				// .findElement(By.xpath("//button[@class='sphere-modal-control
				// sphere-modal-control--filled']"))
				// .click();		
			}
			continue;
			//login.Log4j.error(" THE WEBELEMENT IS NOT VISIABLE !!!!!! ");
			//Assert.fail(" THE WEBELEMENT IS NOT VISIABLE !!!!!! " + e.getMessage());
		}
		}
	}

	@And("^User Select Sentix tab$")
	public void user_Select_Sentix_tab() throws Throwable {
		Thread.sleep(5000);
		login.Log4j.info("Clicking on Sentix button - " + login.LOCATORS.getProperty("Sentix_Tab"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sentix_Tab"))).click();
		//login.driver.findElement(By.xpath("//div[@title='View Sentix Reports']")).click();
	}

	@And("^User Download the Sentix Insights$")
	public void user_Download_the_Sentix_Insights() throws Throwable {

		
			JavascriptExecutor jse = (JavascriptExecutor) login.driver;
			element = login.driver.findElement(By.xpath("//div/a[contains(text(),'Sentix Report: January 2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(30000);

			// WebElement element
			// =login.driver.findElement(By.xpath("//div[@class='insights-sub-groups-list-item-title']/div[2]"));
			WebElement element = login.driver
					.findElement(By.xpath("//div[@class='insights-sub-groups']/div[1]/div[4]/div[1]/div[2]"));

			String SentixTab_Name = element.getText();
			// System.out.println(SentixTab_Name);
			String str = SentixTab_Name;
			String numbers;
			numbers = str.replaceAll("[^0-9]", "");
			// System.out.println("Numbers are: " + numbers);
			int result = Integer.parseInt(numbers);
			System.out.println("Total Numbers  of Insights in SentixTab: " + result);

			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));

			login.Log4j.info("Total Insights are- " + objLinks.size());
			// System.out.println("Total Insights are : "+objLinks.size());

			//if (result == objLinks.size()) {
				//System.out.println(" Insights Numbers Matched, can proceed to download");

				//int DownloadedFilesCount = objLinks.size();

				//for (int i = 0; i < objLinks.size(); i++)
				 for(int i=0;i<2;i++)
				{
					 try {
					int n = i + 1;
					login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size()   +    " - The Downloading Insight is - " + objLinks.get(i).getText());
					//login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size());
					//login.Log4j.info("Downloading Insight " + n);
					//login.Log4j.info("The Downloading Insight is - " + objLinks.get(i).getText());
					// System.out.println(objLinks.get(i).getText());
					String InsightName = objLinks.get(i).getText();
					login.driver.findElement(By.linkText(InsightName)).click();
					login.Log4j.info("Clicking on Downloading icon - " + login.LOCATORS.getProperty("Downloadicon"));
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadicon"))).click();
					Thread.sleep(10000);
					// login.Log4j.info("Clicking on PDF - "
					// +login.LOCATORS.getProperty("PDF_Format"));
					// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format"))).click();
					// Thread.sleep(20000);
					// user_select_on_Pop_up_download();
					// Thread.sleep(50000);
					login.Log4j.info("Clicking on Insight-preview-close - "
							+ login.LOCATORS.getProperty("insight-preview-close"));
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight-preview-close"))).click();
					// login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
					Thread.sleep(20000);
					user_download_should_be_Sucess();
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_ENTER);
					// Thread.sleep(30000);
					// user_download_should_be_Sucess();

				//}
			//}
				// else 
				// {
				//System.out.println(" Insights Numbers Does'nt Matched !!!!! ");
			//}
		} catch (Exception e) {
			File src = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:/Users/Admin/Pictures/BDD/error.png"));
			if (login.driver
					.findElements(By.xpath("//button[@class='sphere-modal-control sphere-modal-control--filled']"))
					.size() != 0) 
			{
				String InsightName = objLinks.get(i).getText();
				login.Log4j.info("Unexpected Error in Insight" + InsightName);
				//System.out.println("Entered *************** ");
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Unexpected_error_ok"))).click();

				// login.driver
				// .findElement(By.xpath("//button[@class='sphere-modal-control
				// sphere-modal-control--filled']"))
				// .click();		
			}
			continue;
			//login.Log4j.error(" THE WEBELEMENT IS NOT VISIABLE !!!!!! ");
			//Assert.fail(" THE WEBELEMENT IS NOT VISIABLE !!!!!! " + e.getMessage());
		}
				}
	}

	@And("^User Select EMIS Insights tab$")
	public void user_Select_EMIS_Insights_tab() throws Throwable {
		login.Log4j.info("Clicking on EMIS button - " + login.LOCATORS.getProperty("EMIS_Tab"));
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab"))).click();
		//login.driver.findElement(By.xpath("//span[contains(text(),'EMIS Insights (346)')]")).click();

	}

	@And("^User Download the EMIS Insights$")
	public void user_Download_the_EMIS_Insights() throws Throwable {

		

			JavascriptExecutor jse = (JavascriptExecutor) login.driver;
			// element =
			// login.driver.findElement(By.xpath("//div/a[contains(text(),'Thailand
			// Automotive Sector Report 2016/2017')]"));
			
			
			
			element = login.driver
			.findElement(By.xpath("//div/a[contains(text(),'Poland Electric Power Sector Report 2017-2021')]"));
	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	
	element = login.driver
			.findElement(By.xpath("//div/a[contains(text(),'Peru Mining Sector Report 2018/2019')]"));
	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	
	element = login.driver
			.findElement(By.xpath("//div/a[contains(text(),'China ICT Sector Report 2017/2021')]"));
	jse.executeScript("arguments[0].scrollIntoView(true);", element);
	
			
	
			
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Poland IT Sector Report 2018-2022')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'China Agriculture Sector Report 2017/2021')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element1 = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'China Insurance Sector Report 2017 3rd Quarter')]"));
			System.out.println("Insights is : " + element1);
			jse.executeScript("arguments[0].scrollIntoView(true);", element1);
			element = login.driver.findElement(By.xpath(
					"//div/a[contains(text(),'Czech Republic Real Estate and Construction Sector Report 2018/2019')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Romania Agriculture Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'China Railways Sector Report 2017/2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Poland Food Sector Report 2017/2021')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Mexico Mining Sector Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'Poland Telecommunications Sector Report 2017/2021')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'China Banking Sector Report 2017/2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Turkey Banking Sector Report 2017/2018')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Romania ICT Sector Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Brazil Construction Sector Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(
					By.xpath("//div/a[contains(text(),'China Iron and Steel Sector Report 2016 3rd Quarter')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver.findElement(By
					.xpath("//div/a[contains(text(),'Chile Healthcare and Pharmaceuticals Sector Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'China Textile Sector Report 2017 1st Quarter')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'Poland Banking Sector Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'India Electric Power Sector Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'China Beverage Sector Report 2016 3rd Quarter')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			element = login.driver
					.findElement(By.xpath("//div/a[contains(text(),'India Steel Sector Report 2016/2017')]"));
			jse.executeScript("arguments[0].scrollIntoView(true);", element);

			// List<WebElement> objLinks =
			// login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));
			// System.out.println("Total Insights are : "+objLinks.size());

			Thread.sleep(30000);

			WebElement element = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab")));
					//login.driver.findElement(By.xpath("//span[contains(text(),'EMIS Insights (346)')]"));
			String EMISTab_Name = element.getText();
			System.out.println(EMISTab_Name);
			String str = EMISTab_Name;
			String numbers;
			numbers = str.replaceAll("[^0-9]", "");
			// System.out.println("Numbers are: " + numbers);
			int result = Integer.parseInt(numbers);
			System.out.println("Total Numbers  of Insights in EMISTab: " + result);

			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));

			login.Log4j.info("Total Insights are- " + objLinks.size());
			// System.out.println("Total Insights are : "+objLinks.size());
			
			//if (result == objLinks.size()) {
				//System.out.println(" Insights Numbers Matched, can proceed to download");

				//int DownloadedFilesCount = objLinks.size();

				 //for(int i=0;i<objLinks.size();i++)
				for (int i = 0; i < 3; i++) 
				{
					try {
					int n = i + 1;
					login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size()   +    " - The Downloading Insight is - " + objLinks.get(i).getText());
					//login.Log4j.info("Downloading Insight " + n + " of " + objLinks.size());
					//login.Log4j.info("Downloading Insight " + n);
					//login.Log4j.info("The Downloading Insight is - " + objLinks.get(i).getText());
					// System.out.println(objLinks.get(i).getText());
					String InsightName = objLinks.get(i).getText();
					login.driver.findElement(By.linkText(InsightName)).click();
					login.Log4j.info("Clicking on Downloading icon - " + login.LOCATORS.getProperty("Downloadicon"));
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadicon"))).click();
					Thread.sleep(10000);
					// login.Log4j.info("Clicking on PDF - "
					// +login.LOCATORS.getProperty("PDF_Format"));
					// login.driver.findElement(By.xpath(login.LOCATORS.getProperty("PDF_Format"))).click();
					// Thread.sleep(20000);
					// user_select_on_Pop_up_download();
					// Thread.sleep(50000);
					login.Log4j.info("Clicking on Insight-preview-close - "
							+ login.LOCATORS.getProperty("insight-preview-close"));
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight-preview-close"))).click();
					// login.driver.findElement(By.xpath("//div[@class='insight-preview--close']")).click();
					Thread.sleep(20000);
					user_download_should_be_Sucess();
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_TAB);
					robot.keyPress(KeyEvent.VK_ENTER);
					// Thread.sleep(30000);
					// user_download_should_be_Sucess();
				//}
			//} else {
				//System.out.println(" Insights Numbers Does'nt Matched !!!!! ");
			//}
		} catch (Exception e) 
		{
			File src = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:/Users/Admin/Pictures/BDD/error.png"));
			if (login.driver
					.findElements(By.xpath("//button[@class='sphere-modal-control sphere-modal-control--filled']"))
					.size() != 0) 
			{
				String InsightName = objLinks.get(i).getText();
				login.Log4j.info("Unexpected Error in Insight" + InsightName);
				//System.out.println("Entered *************** ");
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Unexpected_error_ok"))).click();

				// login.driver
				// .findElement(By.xpath("//button[@class='sphere-modal-control
				// sphere-modal-control--filled']"))
				// .click();		
			}
			continue;
			//login.Log4j.error(" THE WEBELEMENT IS NOT VISIABLE !!!!!! ");
			//Assert.fail(" THE WEBELEMENT IS NOT VISIABLE !!!!!! " + e.getMessage());
		}
			
		} 

	}
	

@And("^User Select Download button$")
public void user_Select_Download_button() throws Throwable {
	Thread.sleep(10000);
	login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/div[3]/div[2]/button")).click();
	
}

@And("^User Select pop up Download button$")
public void user_Select_pop_up_Download_button() throws Throwable {
	Thread.sleep(10000);
	login.driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[2]/div[2]/button[4]/span")).click();
	   
}

@And("^User Compare exel sheet$")
public void user_Compare_exel_sheet() throws Throwable {
	Thread.sleep(10000);
	System.out.println("Comparing Data in Two Exel Sheets");
	CompareExcel.Excel();
}




}
