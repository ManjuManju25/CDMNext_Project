package CDMNext.StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.Then;

public class Comparables {

	@Then("^The total number of series should be displayed in search tab for Section level in comparables tab$")
	public void the_total_number_of_series_should_be_displayed_in_search_tab_for_Section_level_in_comparables_tab()
			throws Throwable {
		WebElement seriesCount = CommonFunctionality.wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-input--results-container")));
		if (seriesCount.isDisplayed()) {
			login.Log4j.info("Series is displayed for sectional level in search tab");
		} else {
			Assert.fail("Verification failed");
		}
	}
}
