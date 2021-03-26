package CDMNext.util;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

import CDMNext.StepDefinations.login;
import cucumber.api.Scenario;
//import ru.yandex.qatools.ashot.AShot;
//import ru.yandex.qatools.ashot.Screenshot;
//import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ErrorScreenshot {
	// It will execute after every test execution
	public static void takeScreenshotOnFailure(Scenario scenario) throws IOException, Exception {
		// if test case is failing then only it will enter into if condition
		if (scenario.isFailed()) {
			// scenario.getName() will return name of test case
			String var = scenario.getName();
			String[] TC = var.split(":");
			Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle screenRectangle = new Rectangle(screensize);
			Robot robot = new Robot();
			BufferedImage image = robot.createScreenCapture(screenRectangle);
			File srcFile = new File(System.getProperty("user.dir") + "\\CDMNext_"+ getCurrentDate() +".png");
			// TC[0] will return test case number so that screenshot name will be same as
			// test case number
			File destFile = new File(System.getProperty("user.dir") + "\\ErrorScreenshot\\" + TC[0] + ".png");
		    ImageIO.write(image, "png", srcFile);
			
			try {
				// Copy files to specific location
				FileUtils.copyFile(srcFile, destFile);
				srcFile.delete();
				login.Log4j.info("Screenshot is taken successfully.");
				
			} catch (IOException e) {
				login.Log4j.error("Exception while taking screenshot\n " + e.getMessage());

			}
		//	File srcFile = ((TakesScreenshot) login.driver).getScreenshotAs(OutputType.FILE);
			// scenario.getName() will return name of test case
			//String var = scenario.getName();
			//String[] TC = var.split(":");
			//String dest = System.getProperty("user.dir") + "/ErrorScreenshot/" + TC[0] + ".png";
			//File destFile = new File(dest);
			//take screenshot of the entire page
		/*  Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(login.driver);
            try {
                ImageIO.write(screenshot.getImage(),"PNG",new File(dest));
            } catch (IOException e) {
                e.printStackTrace();
            }
*/
		}
	}
	

	public static String getCurrentDate()
	{
		DateFormat date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		return date.format(currentDate);
	}
	public static void takeScreenshotOnFailure1(ITestResult result) throws IOException {
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
//				FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
//				System.out.println("Screenshot is taken successfully.");
				Robot robot = new Robot();
			    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			    
			    ImageIO.write(screenShot, "PNG", new File("./Screenshots/" + result.getName() + ".png"));
			    System.out.println("Screenshot is taken successfully.");

			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}
	}
}
