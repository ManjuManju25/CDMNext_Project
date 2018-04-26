package CDMNext.runner;
import cucumber.api.CucumberOptions;

import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.*;


 
@CucumberOptions(
        features = "src/test/java/CDMNext/Features/search.Feature",
        glue = {"CDMNext.StepDefinations"},
        //tags = {"@Keywordsearch"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/report.html",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class TestRunner {
	
      private TestNGCucumberRunner testNGCucumberRunner;
 
    @BeforeSuite
    public void setUpClass() throws Exception {
    	System.out.println("\nInside TestNG > @BeforeSuite");	
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass()); 
    }
 
    // TestNG @Test
    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
    	System.out.println("\nInside TestNG > @Test");
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
    
    // TestNG @DataProvider
    @DataProvider
    public Object[][] features() {
    	System.out.println("\nInside TestNG > @DataProvider");
        return testNGCucumberRunner.provideFeatures();
    }
   
   
    // TestNG @AfterSuite
    @AfterSuite
    public void tearDownClass() throws Exception {
    	System.out.println("\nInside TestNG > @AfterSuite");
        testNGCucumberRunner.finish();
        if (CDMNext.StepDefinations.login.driver != null) {
 			System.out.println("\n CLOSING THE BROWSER WE YOU GO");
 			CDMNext.StepDefinations.login.driver.manage().deleteAllCookies();
		    CDMNext.StepDefinations.login.driver = null;	
		   
 		 }
    }
    
   
}
