package CDMNext.StepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class IndiaFilter {
	ChinaFilter CF = new ChinaFilter();
	List<String> statesTD = new ArrayList<>();
	Map<String, Object> StatesTD1 = new LinkedHashMap<>();
	Map<String, Object> StatesTD2 = new LinkedHashMap<>();
	List<String> parliamentaryTD = null;
	List<String> AssemblyTD = null;
	XSSFSheet sheet = null;
	XSSFCell stateTxt;
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	
	@Given("^Read the Election data Excel file \"([^\"]*)\"$")
	public void read_the_Election_data_Excel_file(String arg1) throws Throwable {
		// Create an object of File class to open xlsx file
		File src = new File(System.getProperty("user.dir") + "\\Testdata\\" + arg1);
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// for each sheet in the workbook
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {

			System.out.println("Sheet name: " + wb.getSheetName(i));

			if (wb.getSheetName(i).contentEquals("State")) {
				sheet = wb.getSheetAt(i);
				int rowcount = sheet.getLastRowNum();
				login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
				int colcount = sheet.getRow(1).getLastCellNum();
				login.Log4j.info("Total number of columns present in the sheet: " + colcount);
				for (int j = 1; j <= rowcount; j++) {

					stateTxt = sheet.getRow(j).getCell(0);
					statesTD.add(stateTxt.getStringCellValue());

				}
				login.Log4j.info(statesTD);

			} else if (wb.getSheetName(i).contentEquals("Parliamentary")) {
				sheet = wb.getSheetAt(i);
				int rowcount = sheet.getLastRowNum();
				login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
				int colcount = sheet.getRow(1).getLastCellNum();
				login.Log4j.info("Total number of columns present in the sheet: " + colcount);
				for (int j = 1; j <= rowcount; j++) {
					stateTxt = sheet.getRow(j).getCell(0);
					parliamentaryTD = (List<String>) StatesTD1.get(stateTxt.getStringCellValue());
					if (parliamentaryTD == null) {
						if (sheet.getRow(j).getCell(1) != null) {
							parliamentaryTD = new ArrayList<>();
							parliamentaryTD.add(sheet.getRow(j).getCell(1).getStringCellValue());
							Collections.sort(parliamentaryTD);
							StatesTD1.put(stateTxt.getStringCellValue(), parliamentaryTD);

						}
						if (sheet.getRow(j).getCell(1) == null) {
							parliamentaryTD = null;

						}

					} else {

						if (sheet.getRow(j).getCell(1) != null) {
							parliamentaryTD.add(sheet.getRow(j).getCell(1).getStringCellValue());
							// Collections.sort(parliamentaryTD);
						}
						StatesTD1.put(stateTxt.getStringCellValue(), parliamentaryTD);

					}
					// login.Log4j.info("State level data : " + states);
				}
				// login.Log4j.info("State level data : " + StatesTD1);

			} else if (wb.getSheetName(i).contentEquals("StateAssembly")) {
				sheet = wb.getSheetAt(i);
				int rowcount = sheet.getLastRowNum();
				login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
				int colcount = sheet.getRow(1).getLastCellNum();
				login.Log4j.info("Total number of columns present in the sheet: " + colcount);
				for (int j = 1; j <= rowcount; j++) {
					stateTxt = sheet.getRow(j).getCell(0);
					AssemblyTD = (List<String>) StatesTD2.get(stateTxt.getStringCellValue());
					if (AssemblyTD == null) {
						if (sheet.getRow(j).getCell(1) != null) {
							AssemblyTD = new ArrayList<>();
							AssemblyTD.add(sheet.getRow(j).getCell(1).getStringCellValue());
							Collections.sort(AssemblyTD);
							StatesTD2.put(stateTxt.getStringCellValue(), AssemblyTD);

						}
						if (sheet.getRow(j).getCell(1) == null) {
							AssemblyTD = null;

						}

					} else {

						if (sheet.getRow(j).getCell(1) != null) {
							AssemblyTD.add(sheet.getRow(j).getCell(1).getStringCellValue());
							Collections.sort(AssemblyTD);
						}
						StatesTD2.put(stateTxt.getStringCellValue(), AssemblyTD);

					}
					// login.Log4j.info("State level data : " + states);
				}
				// login.Log4j.info("State level data : " + StatesTD2);
			}
		}

		fis.close();

	}

	@Then("^Verify the \"([^\"]*)\" ,\"([^\"]*)\" and \"([^\"]*)\" with test data$")
	public void verify_the_and_with_test_data(String arg1, String arg2, String arg3) throws Throwable {
		int stateVar = 0;
		Set<String> StatesList = new HashSet<String>(statesTD);
		Set<String> StateKeys = StatesTD1.keySet();
		Set<String> StateKeys1 = StatesTD2.keySet();
		Set<String> ParliamentListTD = null;
		Set<String> AssemblyListTD = null;
		String ActiveEleXpath;
		List<WebElement> GridActiveElements;
		CommonFunctionality.wait(1000);
		// Verify States with Testdata
		String StateXpath = "//*[contains(@class,'subnational--section__first')]//*[@class='tree-filter-list']//*[contains(@class,'tree-filter-item__list')]//*[@class='filter-item--body'][1]//following-sibling::*[@class='text-dots']";
		ChinaFilter.ValidationMethod(StatesList, StateXpath);
		ChinaFilter.CollapseAllmethod();

		// Verify no.of Parliaments for given states with testdata
		for (String stateName : StateKeys) {
			parliamentaryTD = (List<String>) StatesTD1.get(stateName);
			if (parliamentaryTD != null) {
				int StatesCountTD = StateKeys.size();
				login.Log4j.info(arg1 + " in Excel is: " + stateName);
				login.Log4j.info(arg2 + " list : " + parliamentaryTD);
				int ParliamentList = 0;

				// Convert List to Set
				ParliamentListTD = new HashSet<String>(parliamentaryTD);
				ParliamentList = ParliamentListTD.size();

				ActiveEleXpath = "//*[contains(@class,'subnational--section__second')]//*[contains(@class,'open-icon')]";
				GridActiveElements = login.driver.findElements(By.xpath(ActiveEleXpath));
				for (int i = stateVar; i < GridActiveElements.size();) {
					login.Log4j.info(i);
					GridActiveElements.get(i).click();
					String ParliamentaryXpath = "//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')]//*[@class='tree-filter-list']//*[@class='filter-item--body'][1]//following-sibling::*[@class='text-dots']";
					ChinaFilter.ValidationMethod(ParliamentListTD, ParliamentaryXpath);
					stateVar = i + 1;
					break;
				}
				// unselect state

				if (login.driver.findElements(By.xpath(
						"//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')]//*[contains(@class,'close-icon')]"))
						.size() == 1) {
					ChinaFilter.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')][1]//*[contains(@class,'close-icon')]")))
							.click();

				}
			}
		}
		CommonFunctionality.wait(1000);
		stateVar = 0;

		// Verify no.of Assemblies for given states with testdata
		for (String stateName : StateKeys1) {
			AssemblyTD = (List<String>) StatesTD2.get(stateName);
			if (AssemblyTD != null) {

				login.Log4j.info(arg1 + " in Excel is: " + stateName);
				login.Log4j.info(arg3 + " list : " + AssemblyTD);
				int AssemblyList = 0;

				// Convert List to Set
				AssemblyListTD = new HashSet<String>(AssemblyTD);
				AssemblyList = AssemblyListTD.size();

				ActiveEleXpath = "//div[@class='subnational--section subnational--section__third']/div/div[2]/div/div[1]/div[1]/div[1]";
				GridActiveElements = login.driver.findElements(By.xpath(ActiveEleXpath));
				for (int i = stateVar; i < GridActiveElements.size();) {
					login.Log4j.info(i);
					GridActiveElements.get(i).click();
					String AssemblyXpath = "//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')]//*[@class='tree-filter-list']//*[@class='filter-item--body'][1]//following-sibling::*[@class='text-dots']";
					ChinaFilter.ValidationMethod(AssemblyListTD, AssemblyXpath);
					jse.executeScript("arguments[0].scrollIntoView(true);", GridActiveElements.get(i));

					stateVar = i + 1;
					break;
				}
				// unselect state

				if (login.driver.findElements(By.xpath(
						"//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')]//*[contains(@class,'close-icon')]"))
						.size() == 1) {
					ChinaFilter.wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')][1]//*[contains(@class,'close-icon')]")))
							.click();

				}
			}
		}
	}

}
