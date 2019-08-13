package CDMNext.runner;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


import org.testng.annotations.*;
import CDMNext.StepDefinations.HTML_Report;
import CDMNext.StepDefinations.login;

//import CDMNext.util.SendmailWithAttachment;

@CucumberOptions(// features="classpath:",
		strict = true,
		features = "src/test/java/CDMNext/Features/", 
		glue = { "CDMNext.StepDefinations" }, 
		tags = {"@Alltab1,@SSPWindow1" },
		// tags = {"@DB1,@Mnemonics1,@SeriesTab1,@KeywordSearch1,@Filte						eq2rSearch1" },
		monochrome = true,
		//dryRun = true,
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/surefire-reports/html/report.html", })
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
	public void feature(CucumberFeatureWrapper cucumberFeature) throws Throwable {
		login.Log4j.info("\nInside TestNG > @Test");
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
//		testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());


	}

	// TestNG @DataProvider
	 @DataProvider public Object[][] features() {
	 login.Log4j.info("\nInside TestNG > @DataProvider");
	 return testNGCucumberRunner.provideFeatures(); }
	
	/*@DataProvider(parallel=true)
    public Object[][] features() {
       // return testNGCucumberRunner.provideFeatures();    	
    	 return testNGCucumberRunner.provideScenarios();
    }*/
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
			// login.Log4j.info("\n ****Inside Email*****");
			// SendmailWithAttachment.report();
		}
	}
}
