package CDMNext.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		//features = { "src/test/java/CDMNext/Features/" }, 
		//glue = { "CDMNext.StepDefinations" },
		// tags="@search",
		//monochrome = true, 
		plugin = { "pretty" }

)

public class MainRunner {

}
