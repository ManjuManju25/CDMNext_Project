package CDMNext.StepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import junit.framework.Assert;

public class AllRegion {
	Actions action = new Actions(login.driver);
	JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	Map<String, Object> RegionTD = new LinkedHashMap<>();
	Map<String, Object> Sub_regionTD = null;
	List<String> countryNameTD = null;
	String ProvinceTxtEle;
	String PrefectureTxt = null;
	Map<String,List<String>> EcoGroupTD = new LinkedHashMap<>();
	List<String> countryList_TD = null;

	@Given("^Read the Geography data from \"([^\"]*)\" excel file and sheet \"([^\"]*)\"$")
	public void read_the_Geography_data_from_excel_file_and_sheet(String arg1, String arg2) throws Throwable {
		// Create an object of File class to open xlsx file
		File src = new File(System.getProperty("user.dir") + "\\" + arg1);
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// XSSFCellStyle style = wb.createCellStyle();

		// CellStyle style = wb.createCellStyle();
		if (arg2.equalsIgnoreCase("Geography_TestData")) {
			XSSFSheet sheet = wb.getSheet(arg2);
			int rowcount = sheet.getLastRowNum();
			login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
			int colcount = sheet.getRow(1).getLastCellNum();
			login.Log4j.info("Total number of columns present in the sheet: " + colcount);
			XSSFCell regionTxt;

			for (int i = 1; i <= rowcount; i++) {
				regionTxt = sheet.getRow(i).getCell(0);
				Sub_regionTD = (Map<String, Object>) RegionTD.get(regionTxt.getStringCellValue());

				if (Sub_regionTD == null) {
					// prefetureList = new ArrayList<>();
					if (sheet.getRow(i).getCell(1) != null) {
						Sub_regionTD = new LinkedHashMap<>();
					}

					if (sheet.getRow(i).getCell(2) != null) {
						countryNameTD = new ArrayList<>();
						countryNameTD.add(sheet.getRow(i).getCell(2).getStringCellValue());
						// login.Log4j.info("Country name list: " + countryNameTD);
					}
					if (sheet.getRow(i).getCell(2) == null) {
						countryNameTD = null;
					}
					if (sheet.getRow(i).getCell(1) != null) {
						Sub_regionTD.put(sheet.getRow(i).getCell(1).getStringCellValue(), countryNameTD);
						// login.Log4j.info("sub_region : " + Sub_regionTD);

					}

				} else {

					if (sheet.getRow(i).getCell(1) != null) {
						countryNameTD = (List<String>) Sub_regionTD
								.get(sheet.getRow(i).getCell(1).getStringCellValue());
						// login.Log4j.info(countryNameTD);
						if (countryNameTD == null && sheet.getRow(i).getCell(2) != null) {
							countryNameTD = new ArrayList<>();
						}
						if (sheet.getRow(i).getCell(2) != null) {
							countryNameTD.add(sheet.getRow(i).getCell(2).getStringCellValue());
							// login.Log4j.info("Country name list: " + countryNameTD);
						}
						Sub_regionTD.put(sheet.getRow(i).getCell(1).getStringCellValue(), countryNameTD);
						// login.Log4j.info("sub_region list: " + Sub_regionTD);
					}
				}

				RegionTD.put(regionTxt.getStringCellValue(), Sub_regionTD);
				// login.Log4j.info("Region data : " + RegionTD.toString());

			}
		} else if (arg2.equalsIgnoreCase("EconomicGroups")) {
			XSSFSheet sheet = wb.getSheet(arg2);
			int rowcount = sheet.getLastRowNum();
			login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
			int colcount = sheet.getRow(1).getLastCellNum();
			login.Log4j.info("Total number of columns present in the sheet: " + colcount);
			XSSFCell EcoGroupTxt;
			for (int i = 1; i <= rowcount; i++) {
				EcoGroupTxt = sheet.getRow(i).getCell(1);
				//login.Log4j.info(EcoGroupTxt);
				 countryList_TD = EcoGroupTD.get(EcoGroupTxt.getStringCellValue());
					if (countryList_TD == null) {
						if (sheet.getRow(i).getCell(1) != null) {
							EcoGroupTD = new LinkedHashMap<>();
						}
						if (sheet.getRow(i).getCell(2) != null) {
							countryList_TD = new ArrayList<>();
							countryList_TD.add(sheet.getRow(i).getCell(2).getStringCellValue());
							login.Log4j.info("Country name list: " + countryList_TD);
						}
						if (sheet.getRow(i).getCell(1) != null) {
							EcoGroupTD.put(sheet.getRow(i).getCell(1).getStringCellValue(), countryList_TD);
							login.Log4j.info("sub_region : " + EcoGroupTD);

						}
					} else {

						if (sheet.getRow(i).getCell(1) != null) {
//							countryList_TD = (List<String>) EcoGroupTD
//									.get(sheet.getRow(i).getCell(1).getStringCellValue());
//							login.Log4j.info(countryList_TD);
							// EcoGroupTD = new LinkedHashMap<>();

//							if (countryList_TD == null && sheet.getRow(i).getCell(2) != null) {
//								//countryList_TD = new ArrayList<>();
//								EcoGroupTD = new LinkedHashMap<>();
//							}
							if (sheet.getRow(i).getCell(2) != null) {
								countryList_TD.add(sheet.getRow(i).getCell(2).getStringCellValue());
								login.Log4j.info("Country name list: " + countryList_TD);
							}
							
						}
					}
					 EcoGroupTD.put(EcoGroupTxt.getStringCellValue(),
							 countryList_TD);
							login.Log4j.info("Economic groups list: " + EcoGroupTD);
				}
			// break;
		}

		fis.close();

	}

	@And("^Select \"([^\"]*)\" tab from filter dropdown$")
	public void select_tab_from_filter_dropdown(String allRegion) throws Throwable {
		CommonFunctionality.wait(5000);
		CommonFunctionality.getElementByXpath(login.driver, "//*[text()='" + allRegion + "']", 20).click();
		login.Log4j.info("clicking on All regions tab");
	}

	@Then("^Compare the Regions , sub-regions and country names with test data$")
	public void compare_the_Regions_sub_regions_and_country_names_with_test_data() throws Throwable {
		int regionVar = 0;
		String ActiveEleXpath;
		List<WebElement> GridActiveElements;
		Set<String> regionKeys = RegionTD.keySet();
		int regionCountTD = regionKeys.size();
		Set<String> CountryListTD = null;
		String regionXpath = null;
		CommonFunctionality.wait(1000);
		try {
			// if Region is expanded
			if (CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[1]", 20)
					.getAttribute("class").contains("tree-filter-item__open")) {
				regionXpath = "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[1]/*[2]//*[@class='text-dots']";
			}
			// if Economic group is expanded then collapse
			if (CommonFunctionality
					.getElementByXpath(login.driver, "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[2]", 20)
					.getAttribute("class").contains("tree-filter-item__open")) {
				CommonFunctionality.getElementByXpath(login.driver,
						"//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[2]/*[1]/*[1]", 20).click();
			}
		} catch (Exception e) {
			// if Region is not expanded
			CommonFunctionality.getElementByXpath(login.driver,
					"//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[1]/*[1]/*[1]/*[1]", 20).click();
			regionXpath = "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[1]/*[2]//*[@class='text-dots']";
		}

		ValidationMethod(regionKeys, regionXpath);
		regionVar = 0;
		for (String regionName : regionKeys) {
			int sub_regionVar = 0;
			Sub_regionTD = (Map<String, Object>) RegionTD.get(regionName);
			Set<String> sub_regionTDKeys = Sub_regionTD.keySet();
			Thread.sleep(1000);
			ActiveEleXpath = "(//*[contains(text(),'Region')]/following::*[@class='tree-filter-item--children'])[1]/*[1]/*/*[1]/*[2]/*";
			GridActiveElements = login.driver.findElements(By.xpath(ActiveEleXpath));
			login.Log4j.info("Region in Excel is: " + regionName);
			login.Log4j.info("SubRegion Count in Excel is: " + Sub_regionTD);
			for (int i = regionVar; i < GridActiveElements.size();) {
				login.Log4j.info(i);
				String regionTxt = GridActiveElements.get(i).getText();
				if (regionName.equals(regionTxt)) {
					Thread.sleep(200);
					CommonFunctionality
							.getElementByXpath(
									login.driver, "(//*[contains(text(),'Region')]/following::*[contains(text(),'"
											+ regionName + "')])[1]/preceding::*[@class='tree-filter-item--toggle'][1]",
									30)
							.click();
					Thread.sleep(700);
					try {
						// if sub region has open/toggle icon then expand
						if (login.driver.findElements(By.xpath(
								"//*[@class='tree-filter-item--children']//*[@class='tree-filter-item tree-filter-item__open']/*[2]//*[@class='tree-filter-item']//*[@class='tree-filter-item--open-icon']"))
								.size() == 1) {
							login.driver.findElement(By.xpath(
									"//*[@class='tree-filter-item--children']//*[@class='tree-filter-item tree-filter-item__open']/*[2]//*[@class='tree-filter-item']//*[@class='tree-filter-item--open-icon']"))
									.click();

						}
					} catch (Exception e) {
						// sub region has no toggle
					}
					String SubRegionXpath = "//*[@class='tree-filter-item--children']//*[@class='tree-filter-item tree-filter-item__open']/*[2]//*[@class='filter-item--title']";
					ValidationMethod(sub_regionTDKeys, SubRegionXpath);

					for (String sub_region : sub_regionTDKeys) {
						int CountryList = 0;
						countryNameTD = (List<String>) Sub_regionTD.get(sub_region);
						login.Log4j.info("Country list : " + countryNameTD);
						if (countryNameTD != null) {
							// Convert List to Set
							CountryListTD = new HashSet<String>(countryNameTD);
							CountryList = CountryListTD.size();
						}

						List<WebElement> Sub_regionElements = login.driver.findElements(By.xpath(SubRegionXpath));
						for (int j = sub_regionVar; j < Sub_regionElements.size();) {
							String subregionTxt = Sub_regionElements.get(j).getText();
							if (sub_region.equals("Sub-Saharan Africa")
									|| sub_region.equals("Central America and the Caribbean")) {
								sub_regionVar = j + 1;
							} else if (sub_region.equalsIgnoreCase(subregionTxt)) {
								CommonFunctionality.wait(200);
								Sub_regionElements.get(j).click();
								CommonFunctionality.wait(400);
								String CounntryNameXpath = "//*[@class='filter-list regions-filter-list']/*//*[@class='text-dots']";
								login.Log4j.info("Region in Excel is: " + regionName);
								login.Log4j.info("Sub region in Excel is: " + sub_region);
								ValidationMethod(CountryListTD, CounntryNameXpath);
								sub_regionVar = j + 1;
							} else {
								// Log4j.error("We don't see " + sub_region + " on site");

							}
							break;
						}

					}
					try {
						// unselect subregion
						login.driver.findElement(By.xpath(
								"//*[@class='tree-filter-item--children']//*[@class='tree-filter-item tree-filter-item__open']/*[1]/*[1]/*[2]"))
								.click();

					} catch (NoSuchElementException e) {

					}
					regionVar = i + 1;
				} else {
					// Log4j.error("We don't see " + regionName + " on site");

				}
				break;
			}
			// Collapse Region
			// login.driver.findElement(By.xpath("//*[@class='tree-filter-item
			// tree-filter-item__open'][1]/*[1]/*[1]"))
			// .click();

		}

	}

	@Then("^Compare the country names with test data for economic groups$")
	public void compare_the_country_names_with_test_data_for_economic_groups() throws Throwable {

	}


	void ValidationMethod(Set<String> ListElementsTD, String XpathGridEle) {
		// Make Web Elements Text array
		List<String> ListOfWebElements = new ArrayList<String>();
		List<WebElement> GridElements = login.driver.findElements(By.xpath(XpathGridEle));
		login.Log4j.info("WebElements size is on site: " + GridElements.size());

		for (int i = 0; i < GridElements.size(); i++) {
			// String WebEle = GridElements.get(i).getText();
			// Log4j.info("WebElement is : " + GridElements.get(i).getText());
			ListOfWebElements.add(GridElements.get(i).getText());
		}

		// Compare Size
		if (ListElementsTD.size() == ListOfWebElements.size()) {
			login.Log4j.info("Both list have same size of " + ListElementsTD.size());
		} else if (ListElementsTD.size() != ListOfWebElements.size()) {
			login.Log4j.error("ERROR : We have " + ListElementsTD.size() + " elements in Excel but see only "
					+ ListOfWebElements.size() + " elements on site");

		}

		for (String str : ListOfWebElements) {
			if (ListElementsTD.contains(str)) {
				login.Log4j.info("Web element " + str + " Found in Excel");
			} else {
				login.Log4j.error("ERROR : We don't find " + str + " in Excel");
			}
		}

		/*
		 * for (String str : ListElementsTD) { if (ListOfWebElements.contains(str)) {
		 * login.Log4j.info("Excel item " + str + " found on site"); } else {
		 * login.Log4j.error("ERROR : We don't find " + str + " is on Site");
		 * HTML_Report.strTCResult = "FAIL"; HTML_Report.execRemarks =
		 * "ERROR : We don't find " + str + " is on Site"; } }
		 */

	}
}
