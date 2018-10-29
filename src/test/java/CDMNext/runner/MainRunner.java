package CDMNext.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/java/CDMNext/Features/search.Feature" }, glue = { "CDMNext.StepDefinations" },
		// tags="@search",
		monochrome = true, plugin = { "pretty", "html:target/cucumber", "json:target/Cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html" }

)

public class MainRunner {

}
