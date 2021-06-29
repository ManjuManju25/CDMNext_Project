package CDMNext.StepDefinations;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.Then;

public class IndiaFilter {
	ChinaFilter CF = new ChinaFilter();

	/*@Then("^Compare the \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" with test data$")
	public void compare_the_and_with_test_data(String arg1, String arg2, String arg3) throws Throwable {
		int stateVar = 0;
		String ActiveEleXpath;
		List<WebElement> GridActiveElements;
		Set<String> stateKeys = CF.provinceTD.keySet();
		int StateCountTD = stateKeys.size();
		Set<String> CitiesListTD = null;
		CommonFunctionality.wait(1000);
		String StateXpath = "//*[contains(@class,'subnational--section__first')]//*[@class='tree-filter-list']//*[contains(@class,'tree-filter-item__list')]//*[@class='filter-item--body'][1]//following-sibling::*[@class='text-dots']";
		CF.ValidationMethod(stateKeys, StateXpath);
		if (login.driver.findElement(By.xpath("//*[@class='subnational']//*[contains(text(),'Collapse all')]"))
				.isDisplayed()) {
			CF.wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@class='subnational']//*[contains(text(),'Collapse all')]")))
					.click();
		}
		login.Log4j.info("State size is: " + StateCountTD);
	}*/
	
}
