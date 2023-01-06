package CDMNext.StepDefinations;

import java.awt.Robot;


import java.io.FileInputStream;
import java.lang.reflect.Method;
//import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
//import org.testng.ITestResult;



import CDMNext.util.CommonFunctionality;
import CDMNext.util.ErrorScreenshot;
import CDMNext.util.Hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class login {
	public static WebDriver driver;
	public static WebDriver driver1;
	public static final Logger Log4j = Logger.getLogger("Log4j");
	public static Boolean logged_in = false;
	public static Robot robot;
	public String username = "";
	public String password = "";
	GregorianCalendar date = new GregorianCalendar();
	int day, month, year;
	int second, minute, hour;

	public static int currentSuiteID;
	public static String currentTestSuite;

	// Global executing the tests cases under the suite
	// *** login feature branch ****

	// *** to make it more visible ***
	public static int currentTestCaseID;
	public static String currentTestCaseName;

	// for executing the keywords for each testcase
	public static int currentTestStepID;
	public static String currentKeyword;
	public static int currentTestDataSetID;
	public static long start_time;
	public static long end_time;
	public static double difference;

	public static long TC_start_time;
	public static long TC_end_time;
	public static double TC_difference;

	public static int currentTestCaseRowNum;
	public static int currentIteration;

	public static Method method[];
	public static Method capturescreenShot_method;
	public static String keyword_execution_result;

	public static ArrayList<String> resultSet;

	// Properties files
	public static Properties CONFIG;
	public static Properties LOCATORS;
	// public static Properties LOCATORS1;

	public static String data;
	public static String object;
	public static String parameters;
	//TestRunner testRunner = new TestRunner();
	
	
	//@Before("~@Search,~@FilterSearch")
	@Before
	public void setUp(Scenario scenario) throws Throwable {
		//driver.manage().deleteAllCookies();
		System.out.println("\nInside Cucumber @Before in Login.java.  Launching Browser..");
		logged_in = false;
		ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger("org.apache.http");
	    root.setLevel(ch.qos.logback.classic.Level.INFO);
		Invoke_browser();	
		SearchTest.user_has_successful_logged_in();	
		//Hooks.before_run();
		String feature_file = Hooks.getFeatureFileNameFromScenarioId(scenario);
		if (feature_file.toLowerCase().contains("filtersearch") || feature_file.toLowerCase().contains("synonym search")) {
			//Hooks.CloseAnnouncementPopUp();
			//Hooks.Handle_BrowserNotification_popup();
			login.driver.navigate().refresh();
			CommonFunctionality.ResetMethod();
		} else {
			Hooks.before_run();
		}
		
	}

/*	@Before("@Search,@FilterSearch")
	public void setUp1() throws Throwable {
		Invoke_browser();
		SearchTest.user_has_successful_logged_in();
		login.driver.navigate().refresh();
		CommonFunctionality.ResetMethod();

	}*/
	@After
	public void afterScenario(Scenario scenario) throws Throwable {
		ErrorScreenshot.takeScreenshotOnFailure(scenario);
		String feature_file = Hooks.getFeatureFileNameFromScenarioId(scenario);
		if (!feature_file.toLowerCase().contains("filtersearch") || !feature_file.toLowerCase().contains("synonym search")) {
			Hooks.after_run();
		} 
		
		//Hooks.copyingOldReports();
		//System.out.println("\nInside Cucumber > @After in Login.java.  Tearing down.");
		// driver.quit();

	}	

	@After
	public void tearDownClass() throws Exception {
		//	 System.out.println("\nInside Cucumber > @After in Login.java. Tearing
		// down.");
		Hooks.copyingOldReports();
	}
	@Given("^User navigates to the CDMNext appliction$")
	public void user_navigates_to_the_CDMNext_appliction() throws Throwable {
		// Thread.sleep(3000);
		driver.get(CONFIG.getProperty("testsiteURL"));
		Log4j.info("Launching site .. ");
		
	}

	@And("^Enters username \"([^\"]*)\"$")
	public void enters_username(String username) throws Throwable {
		Thread.sleep(3000);
		driver.findElement(By.name("user-id")).clear();
//		driver.findElement(By.xpath(LOCATORS.getProperty("input_username"))).clear();
		Log4j.info("Trying to login with Username:" + username);
		driver.findElement(By.name("user_id")).sendKeys(username);
		//driver.findElement(By.xpath(LOCATORS.getProperty("input_username"))).sendKeys(username);
	}

	@And("^Enters password \"([^\"]*)\"$")
	public void enters_password(String password) throws Throwable {
		Thread.sleep(3000);
		//driver.findElement(By.name("password")).clear();
		driver.findElement(By.xpath(LOCATORS.getProperty("input_password"))).clear();
		Log4j.info("Trying to login with Password:" + password);
		//driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.xpath(LOCATORS.getProperty("input_password"))).sendKeys(password);

	}

	@When("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) throws Throwable {
		Thread.sleep(2000);
		switch (arg1) {
		case "login":
			Log4j.info("Clicking on login button ");
			driver.findElement(By.xpath(LOCATORS.getProperty("btnLogin"))).click();
			Thread.sleep(2000);
			break;
		case "download":
			break;
		}	
			
		

	}

	@Then("^Application login should be successful$")
	public void application_login_should_be_successful() throws Throwable {
		 Thread.sleep(2000);
		WebElement downloadButton = driver.findElement(By.cssSelector(LOCATORS.getProperty("download")));
		Log4j.info("Is 'Download' button displayed? - True/False:: " + downloadButton.isDisplayed());
		Assert.assertEquals(true, downloadButton.isDisplayed());
		if (downloadButton.isDisplayed()) {
			driver.findElement(By.xpath(LOCATORS.getProperty("logout_dropdown"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(LOCATORS.getProperty("logout"))).click();

		}

	}

	@Then("^Application login should be unsuccessful-UI$")
	public void application_login_should_be_unsuccessful_UI() throws Throwable {
		Thread.sleep(2000);
		if (username == null) {

			WebElement emailrequired = driver.findElement(By.xpath(LOCATORS.getProperty("uname_required")));
			Log4j.info("Is 'emailrequired' button displayed? - True/False:: " + emailrequired.isDisplayed());

		}
		if (password == null) {
			WebElement pwdrequired = driver.findElement(By.xpath(LOCATORS.getProperty("pwd_required")));
			Log4j.info("Is 'pwdrequired' button displayed? - True/False:: " + pwdrequired.isDisplayed());
			Assert.assertEquals(true, pwdrequired.isDisplayed());
		} else {
			Log4j.info("error message");

		}
	}

	@Then("^Application login should be unsuccessful-WS$")
	public void application_login_should_be_unsuccessful_WS() throws Throwable {
		// Thread.sleep(2000);
		Log4j.info("Trying to login with invalid credentials");
		WebElement inusrpwd = driver.findElement(By.xpath(LOCATORS.getProperty("invalid_usrpwd")));
		Assert.assertEquals(true, inusrpwd.isDisplayed());

	}

	public static void application_login() throws InterruptedException {
		Thread.sleep(2000);
		driver.get(CONFIG.getProperty("testsiteURL"));
		Log4j.info("Launching site .. ");
		driver.findElement(By.xpath(LOCATORS.getProperty("input_username"))).clear();
		Log4j.info("Trying to login with Username:");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LOCATORS.getProperty("input_username"))).sendKeys(CONFIG.getProperty("username"));
		driver.findElement(By.xpath(LOCATORS.getProperty("input_password"))).clear();
		Log4j.info("Trying to login with Password:");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LOCATORS.getProperty("input_password"))).sendKeys(CONFIG.getProperty("password"));
		Log4j.info("Clicking on login button ");
		Thread.sleep(1000);
		driver.findElement(By.xpath(LOCATORS.getProperty("btnLogin"))).click();
		logged_in = true;
		Thread.sleep(1000);
		// invoke_browser();
		// Navigate to login page
		// Enter username
		// enter password
		// click login
		// asset login and set 'logged_in' = True

	}

	public static void Invoke_browser() throws Throwable {
		

		LOCATORS = new Properties();

		System.out.println(System.getProperty("user.dir"));
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Config\\locators.properties");
		LOCATORS.load(fs);

		CONFIG = new Properties();
		FileInputStream fs1 = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Config\\config.properties");
		CONFIG.load(fs1);
		Log4j.info("Logger initialized and writing using logger");
		Log4j.info("\nInside setup");
		if (driver != null) {
			// We have a valid driver, re-use the same...
			Log4j.info("Reusing same driver..");
			return;
		}

		if (CONFIG.getProperty("browserType").equals("Mozilla")) {
			DesiredCapabilities capa = DesiredCapabilities.firefox();
			capa.setCapability("marionette", true);
			//WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"null");
			driver = new FirefoxDriver(capa);

			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

		} else if (CONFIG.getProperty("browserType").equals("IE")) {
			// Method and Description - static DesiredCapabilities internetExplorer()
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			// Method and Description - void setCapability(java.lang.String capabilityName,
			// boolean value)
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);

		} else if (CONFIG.getProperty("browserType").equals("EDGE")) {
			// Method and Description - static DesiredCapabilities internetExplorer()
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			// Method and Description - void setCapability(java.lang.String capabilityName,
			
			// boolean value)
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver(capabilities);

		} else if (CONFIG.getProperty("browserType").equalsIgnoreCase("CHROME")) {
			
			//disableSeleniumLogs();
			// Killing the running chromedriver instances
			
			WindowsUtils.killByName("chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\chromedriver.exe");
			//disable chrome logs
			System.setProperty("webdriver.chrome.silentOutput","true");
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);*/
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			String download = System.getProperty("user.home") + "\\Downloads";
			prefs.put("profile.default_content_settings.popups", 0);
			prefs.put("download.default_directory", download);
			prefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
			prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito"); //open in incognito window
    		options.addArguments("disable-geolocation"); // disable location settings
    		options.addArguments("disable-infobars"); //disable any infobars
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-extensions"); //disable extensions if available
			options.addArguments("--ignore-certificate-errors"); //ignoring certificate issues if there
			options.setExperimentalOption("useAutomationExtension", false); // disable automation message
			options.setExperimentalOption("prefs", prefs);
			
			DesiredCapabilities capabilities = new DesiredCapabilities();	
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);	 // accept SSL certificates
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true); // accept insecure certificates if any
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT); // accept unexpected alerts if open
			capabilities.setCapability(ChromeOptions.CAPABILITY, options); //merging Chromeoptions with Desiredcapabilities 
		    driver = new ChromeDriver(capabilities); // passing capabilities argument into driver constructor
		}
		driver.manage().window().maximize();
		long implicitWaitTime = Long.parseLong(CONFIG.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(implicitWaitTime,
		// TimeUnit.SECONDS);
		login.driver.manage().timeouts().pageLoadTimeout(10	
				, TimeUnit.SECONDS);
		//driver.manage().timeouts().setScriptTimeout(implicitWaitTime, TimeUnit.SECONDS);
		
			
	}	
	
	//Method for disabling ChromeDriverService loggers
	public static void disableSeleniumLogs() {    
	    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	    Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
	}
	public static void flex_application_login() throws InterruptedException {
		driver.get(CONFIG.getProperty("testsiteURL"));
		Log4j.info("Launching site");
		CommonFunctionality.getElementByProperty(driver, "input_username", 1).clear();
		CommonFunctionality.getElementByProperty(driver, "input_username", 1)
				.sendKeys(CONFIG.getProperty("flex_username"));
		Log4j.info("Login with Flex Username");
		CommonFunctionality.getElementByProperty(driver, "input_password", 1).clear();
		CommonFunctionality.getElementByProperty(driver, "input_password", 1)
				.sendKeys(CONFIG.getProperty("flex_password"));
		Log4j.info("Login with Flex Password");
		boolean login = CommonFunctionality.getElementByXpath(driver, "//*[@class='form-group']//*[@class='btn']", 1)
				.isEnabled();
		if (login == true) {
			WebElement signin = CommonFunctionality.getElementByProperty(driver, "btnLogin", 1);
			signin.click();

			Log4j.info("Clicking on login button");
		} else {
			Assert.fail("Login failure");
		}
		logged_in = true;
	}
}
