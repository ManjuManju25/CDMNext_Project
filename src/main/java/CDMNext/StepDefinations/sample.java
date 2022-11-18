package CDMNext.StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='nav-search-field ']//input")).sendKeys("electronics");
		driver.findElement(By.xpath("//*[@class='nav-search-field ']//input")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.close();

	}

}
