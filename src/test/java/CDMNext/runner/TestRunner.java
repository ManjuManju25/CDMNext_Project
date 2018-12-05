package CDMNext.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import java.io.File;
import org.testng.annotations.*;
import CDMNext.StepDefinations.login;
//import CDMNext.util.SendmailWithAttachment;

@CucumberOptions(//features="classpath:",
		features = "src/test/java/CDMNext/Features/",
		glue = {"CDMNext.StepDefinations" }, 
        tags = {"@Mnemonics"},
		dryRun = false, plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/surefire-reports/html/report.html",
				 })
public class TestRunner {
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeSuite
	public void setUpClass() throws Exception {
		login.Log4j.info("\nInside TestNG > @BeforeSuite");
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
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
	public void tearDownClass() throws Exception {
		login.Log4j.info("\nInside TestNG > @AfterSuite");
		testNGCucumberRunner.finish();
		if (login.driver != null) {
			login.Log4j.info("\n CLOSING THE BROWSER WE YOU GO");
			login.driver.manage().deleteAllCookies();
			login.driver.quit();
			login.driver = null;
		}
		// login.Log4j.info("\n ****Inside Email*****");
		// SendmailWithAttachment.report();
	}

}
