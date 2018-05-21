package CDMNext.screenShot;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import CDMNext.StepDefinations.login;

public class CaptureScreenShot {

	public static String captureScreenMethod(WebDriver driver, String screenshotName) throws Exception {
		try {
			File screenshotFile = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile,
					new File("C:\\Users\\mnadiya\\Documents\\cucumber_project\\target\\CDMNext-0.0.1-SNAPSHOT.jar  " + screenshotName + ".png"));
			System.out.println("Screenshot is taken successfully.");
		} catch (IOException e) {
			System.out.println("Exception while taking screenshot " + e.getMessage());
		}
		return screenshotName;
	}

}
