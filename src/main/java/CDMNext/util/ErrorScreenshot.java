package CDMNext.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import CDMNext.StepDefinations.login;

public class ErrorScreenshot {
	// It will execute after every test execution

	public static void takeScreenshotOnFailure(ITestResult result) throws IOException {
		// if test case is failing then only it will enter into if condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// Create refernce of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) login.driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our
				// project home directory and
				// result.getName() will return name of test case so that screenshot name will
				// be same
				FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
				System.out.println("Screenshot taken");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}
	}
}
