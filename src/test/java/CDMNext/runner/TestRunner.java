package CDMNext.runner;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.*;

import CDMNext.StepDefinations.HTML_Report;
import CDMNext.StepDefinations.login;
//import CDMNext.util.SendmailWithAttachment;

@CucumberOptions(// features="classpath:",
		features = "src/test/java/CDMNext/Features/",
		glue = { "CDMNext.StepDefinations" }, 
		tags = {"@DB, @ExelDatacomparision,@FilterSearch,@SynonymSearch,@KeywordSearch,@KeywordSearch,@MySeries,@SeriesTab" }, 
		dryRun = false, 
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/surefire-reports/html/report.html", })
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeSuite
	public void setUpClass() throws Throwable {
		login.Log4j.info("\nInside TestNG > @BeforeSuite");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		HTML_Report.openHTMLReport();
		HTML_Report.html_Header();

	}

	// TestNG @Test
	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		login.Log4j.info("\nInside TestNG > @Test");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	// TestNG @DataProvider
	@DataProvider
	public Object[][] features() {
		login.Log4j.info("\nInside TestNG > @DataProvider");
		return testNGCucumberRunner.provideFeatures();
	}

	// TestNG @Aftersuite
	@AfterSuite
	public void tearDownClass() throws Throwable {
		login.Log4j.info("\nInside TestNG > @AfterSuite");
		testNGCucumberRunner.finish();
		if (login.driver != null) {
			login.Log4j.info("\n CLOSING THE BROWSER WE YOU GO");
			login.driver.manage().deleteAllCookies();
			login.driver.quit();
			login.driver = null;
			HTML_Report.html_Footer();
			HTML_Report.bw.close();
		}
		// login.Log4j.info("\n ****Inside Email*****");
		// SendmailWithAttachment.report();
	}

}
