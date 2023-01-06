		

package CDMNext.runner;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

import org.testng.annotations.*;

import CDMNext.StepDefinations.login;
//import CDMNext.util.SendmailWithAttachment;
import CDMNext.util.Hooks;

@CucumberOptions(// features="classpath:",
		strict = true,
		features = "src/test/java/CDMNext/Features/",
		glue = { "CDMNext.StepDefinations" }, 
<<<<<<< HEAD
		tags = {"@Sprint5_4"},	
		
=======
		tags = {"@sprint5.51"},	
>>>>>>> 2bb777c4abe008908b04c1b8941d7bf5efa2788b
		monochrome = true,
		// dryRun = true,
		plugin = { "html:target/cucumber-reports/cucumber-pretty",
				// "json:target/cucumber-reportsa/CucumberTestReport.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/surefire-reports/html/report.html", })

public class TestRunner {
	
	
	private TestNGCucumberRunner testNGCucumberRunner;
	public static CucumberFeatureWrapper cucumberFeature;

	@BeforeSuite
	public void setUpClass() throws Throwable {
		login.Log4j.info("\nInside TestNG > @BeforeSuite");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	/*
	 * @AfterMethod public void tearDown(ITestResult result) throws Throwable {
	 * ErrorScreenshot.takeScreenshotOnFailure1(result); Hooks.after_run(); }
	 */

	// TestNG @Test
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) throws Throwable {
		login.Log4j.info("\nInside TestNG > @Test");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

	}

	@DataProvider
	public Object[][] features() {
		login.Log4j.info("\nInside TestNG > @DataProvider");
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterSuite(alwaysRun = true)
	public void tearDownClass() throws Throwable {
		login.Log4j.info("\nInside TestNG > @AfterSuite");
		testNGCucumberRunner.finish();
		if (login.driver != null) {
			login.Log4j.info("\n CLOSING THE BROWSER WE YOU GO");
			login.driver.manage().deleteAllCookies();
			login.driver.quit();
			login.driver = null;
//			Hooks.copyingOldReports();
			Hooks.createDateBasedDirectory(Hooks.ExecutionReports, Hooks.folderdateTime);
			Hooks.CopytoCurrentdateTimeDir(Hooks.SourceReportPath, Hooks.ExecutionReports);
			// login.Log4j.info("\n ****Inside Email*****");
			// SendmailWithAttachment.report();
		}
	}
}
