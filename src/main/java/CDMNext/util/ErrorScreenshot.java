package CDMNext.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CDMNext.StepDefinations.login;
import cucumber.api.Scenario;

public class ErrorScreenshot {
	// It will execute after every test execution
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
//			Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(login.driver);
//
//			ImageIO.write(screenshot.getImage(), "jpg", new File("c:\\ElementScreenshot.jpg"));
			try {
				// Copy files to specific location
				FileUtils.copyFile(srcFile, destFile);
				login.Log4j.info("Screenshot is taken successfully.");
				// ExtentReports extent = ExtentReports.get(AdvanceReporting.class);
				// extent.attachScreenshot("C:\\Mukesh\\image1.jpg");
			} catch (IOException e) {
				login.Log4j.error("Exception while taking screenshot\n " + e.getMessage());

			}

		}
	}
	/*public static void takeScreenshotOnFailure(ITestResult result) throws IOException {
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
				System.out.println("Screenshot is taken successfully.");
//				 ExtentReports extent = ExtentReports.get(AdvanceReporting.class);
//				 extent.attachScreenshot("C:\\Mukesh\\image1.jpg");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}
	}*/
}
