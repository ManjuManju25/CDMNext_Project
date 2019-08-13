package CDMNext.StepDefinations;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
	public static WebDriver driver;
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

	@Before
	public void setup() throws Throwable {
		System.out.println("\nInside Cucumber @Before in Login.java.  Launching Browser..");
		logged_in = false;
		// day = date.get(Calendar.DAY_OF_MONTH);
		// month = date.get(Calendar.MONTH);
		// year = date.get(Calendar.YEAR);
		// second = date.get(Calendar.SECOND);
		// minute = date.get(Calendar.MINUTE);
		// hour = date.get(Calendar.HOUR);
		Invoke_browser();

	}

	@After
	public void tearDownClass() throws Exception {
		System.out.println("\nInside Cucumber > @After in Login.java.  Tearing down.");
		// driver.quit();

	}

	@Given("^User navigates to the CDMNext appliction$")
	public void user_navigates_to_the_CDMNext_appliction() throws Throwable {
		// Thread.sleep(3000);
		driver.get(CONFIG.getProperty("testsiteURL"));
		Log4j.info("Launching site .. ");
	}

	@And("^Enters username \"([^\"]*)\"$")
	public void enters_username(String username) throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.name("user-id")).clear();
		Log4j.info("Trying to login with Username:" + username);
		driver.findElement(By.name("user_id")).sendKeys(username);

	}

	@And("^Enters password \"([^\"]*)\"$")
	public void enters_password(String password) throws Throwable {
		driver.findElement(By.name("password")).clear();
		Log4j.info("Trying to login with Password:" + password);
		driver.findElement(By.name("password")).sendKeys(password);

	}

	@When("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on(String arg1) throws Throwable {

		switch (arg1) {
		case "login":
			Log4j.info("Clicking on login button ");
			driver.findElement(By.xpath(LOCATORS.getProperty("btnLogin"))).click();
			break;
		case "download":
			break;
		}

	}

	@Then("^Application login should be successful$")
	public void application_login_should_be_successful() throws Throwable {
		// Thread.sleep(2000);
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

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\geckodriver.exe");

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
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			// Added this for downloading files into default project folder
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			// To disable save password dialog during runtime
			chromePrefs.put("credentials_enable_service", false);
			chromePrefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("disable-infobars"); // To disable infobars
			driver = new ChromeDriver(options);

		}
		long implicitWaitTime = Long.parseLong(CONFIG.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(implicitWaitTime,
		// TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(implicitWaitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

}
