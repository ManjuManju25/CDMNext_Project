package CDMNext.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CovidFilter {
	Actions a=new Actions(login.driver);
	@Given("^Navigates to CEIC page verify the Covid Dropdown is displayed and click$")
	public void navigates_to_CEIC_page_verify_the_Covid_Dropdown_is_displayed_and_click() throws InterruptedException
	{
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[contains(text(),'COVID-19')]")).click();
	    
	}
	@And("^Clicking on \"([^\"]*)\"$")
	public void clicking_on(String str) throws InterruptedException
	{
		login.driver.switchTo().activeElement();
		
		Thread.sleep(1000);
		login.driver.findElement(By.xpath("//span[@title='"+str+"']/parent::div/parent::div//label/span")).click();
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		
	}
	@Then("^Getting list of series \"([^\"]*)\"$") 
	public void getting_list_of_series(String str) throws InterruptedException
	{
		Thread.sleep(3000);
		login.driver.findElement(By.xpath("//div[@title='View results as List']")).click();
		List<WebElement>l1=login.driver.findElements(By.xpath("//div[@class='series-item--name']"));
		for(int i=1;i<=l1.size();i++)
		{
			Thread.sleep(2000);
			String str1=login.driver.findElement(By.xpath("(//div[@class='series-item--name'])["+i+"]")).getText().toString();
		System.out.println(str1);
		
		}
	}
	@And("^Clicking on both \"([^\"]*)\" \"([^\"]*)\"$")
	public void clicking_on_both(String str1,String str2) throws InterruptedException
	{
		login.driver.switchTo().activeElement();
		Thread.sleep(1000);
		
		login.driver.findElement(By.xpath("//span[@title='"+str1+"']/parent::div/parent::div//label/span")).click();
		login.driver.findElement(By.xpath("//span[@title='"+str2+"']/parent::div/parent::div//label/span")).click();
		
		login.driver.findElement(By.xpath("//div[contains(text(),'Apply filter')]")).click();
		
	}
	
}
