/*package CDMNext.StepDefinations;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:" })
public class RunCukesTest {
	
	@AfterSuite
	public void tearDownClass() throws Throwable {
		if (login.driver != null) {
			login.Log4j.info("\n CLOSING THE BROWSER WE YOU GO");
			login.driver.manage().deleteAllCookies();
			login.driver.quit();
			login.driver = null;

		}
	}

}*/
