package CDMNext.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CDMNext.StepDefinations.login;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class ErrorScreenshot {
	// It will execute after every test execution
	
	@After
	public static void takeScreenshotOnFailure(Scenario scenario) throws IOException {
		// if test case is failing then only it will enter into if condition
		if (scenario.isFailed()) {
			File srcFile = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			// scenario.getName() will return name of test case
			String var = scenario.getName();
			String[] TC = var.split(":");
			// TC[0] will return test case number so that screenshot name will be same as
			// test case number
			String dest = System.getProperty("user.dir") + "/ErrorScreenshot/" + TC[0] + ".png";
			File destFile = new File(dest);
			try {
				// Copy files to specific location
				FileUtils.copyFile(srcFile, destFile);
				login.Log4j.info("Screenshot is taken successfully.");

			} catch (IOException e) {
				login.Log4j.error("Exception while taking screenshot\n " + e.getMessage());

			}

		}
	}
}
