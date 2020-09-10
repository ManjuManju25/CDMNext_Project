package CDMNext.util;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Baseclass {
	public static WebDriver driver;
	public static final Logger Log4j = Logger.getLogger("Log4j");
	// Properties files
		public static Properties CONFIG;
		public static Properties LOCATORS;
}
