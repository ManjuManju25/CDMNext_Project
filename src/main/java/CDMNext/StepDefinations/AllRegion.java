
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
import java.util.TreeSet;

//import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import junit.framework.Assert;


public class AllRegion extends CommonFunctionality{
	SoftAssert softAssert = new SoftAssert();
	Map<String, Object> RegionTD = new LinkedHashMap<>();
	Map<String, Object> Sub_regionTD = null;
	List<String> countryNameTD = null;
	String ProvinceTxtEle;
	String PrefectureTxt = null;
	Map<String, List<String>> EcoGroupTD = new LinkedHashMap<>();
	List<String> countryList_TD = null;

	@SuppressWarnings("unchecked")
	@Given("^Read the Geography data from \"([^\"]*)\" excel file and sheet \"([^\"]*)\"$")
	public void read_the_Geography_data_from_excel_file_and_sheet(String arg1, String arg2) throws Throwable {

		// Create an object of File class to open xlsx file
		File src = new File(System.getProperty("user.dir") + "\\Testdata\\" + arg1);
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
				// login.Log4j.info(EcoGroupTxt);
				countryList_TD = (List<String>) EcoGroupTD.get(EcoGroupTxt.getStringCellValue());

				if (countryList_TD == null) {

					if (sheet.getRow(i).getCell(2) != null) {
						countryList_TD = new ArrayList<>();
						countryList_TD.add(sheet.getRow(i).getCell(2).getStringCellValue());
						// login.Log4j.info("Country name list: " + countryList_TD);
					}

				} else {

					if (sheet.getRow(i).getCell(2) != null) {
						countryList_TD.add(sheet.getRow(i).getCell(2).getStringCellValue());
						// login.Log4j.info("Country name list: " + countryList_TD);
					}

				}
				EcoGroupTD.put(EcoGroupTxt.getStringCellValue(), countryList_TD);
				// login.Log4j.info("Economic groups list: " + EcoGroupTD);

			}

		}

		fis.close();

	}

	@And("^Select \"([^\"]*)\" tab from filter dropdown$")
	public void select_tab_from_filter_dropdown(String allTab) throws Throwable {
		wait(5000);
		getElementByXpath(login.driver, "//*[@data-tab='" + allTab + "']", 20).click();
		login.Log4j.info("clicking on All regions tab");
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Then("^Compare the Regions , sub-regions and country names with test data$")
	public void compare_the_Regions_sub_regions_and_country_names_with_test_data() throws Throwable {
		Boolean Regions = false;
		int regionVar = 0;
		String ActiveEleXpath;
		List<WebElement> GridActiveElements;
		Set<String> regionKeys = RegionTD.keySet();
		
		//int regionCountTD = regionKeys.size();
		Set<String> CountryListTD = null;
		String regionXpath = null;
		wait(1000);
		try {
			// if Region is expanded
			if (getElementByProperty(login.driver, "RegionVar", 20)
					.getAttribute("class").contains("tree-filter-item__open")) {
				regionXpath = "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[1]/*[2]//*[@class='text-dots']";
			}
			// if Economic group is expanded then collapse
			if (getElementByProperty(login.driver, "EconomicGroup", 20)
					.getAttribute("class").contains("tree-filter-item__open")) {
				getElementByProperty(login.driver,
						"Collapse_EconomicGroup", 20).click();
			}
		} catch (Exception e) {
			// if Region is not expanded
			getElementByProperty(login.driver,
					"Expand_Region", 20).click();
			regionXpath = "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[1]/*[2]//*[@class='text-dots']";
		}

		ValidationMethod(regionKeys, regionXpath);
		// regionVar = 0;
		for (String regionName : regionKeys) {
			int sub_regionVar = 0;
			Sub_regionTD = (Map<String, Object>) RegionTD.get(regionName);
			Set<String> sub_regionTDKeys = Sub_regionTD.keySet();
			wait(1000);
			ActiveEleXpath = "(//*[contains(text(),'Region')]/following::*[@class='tree-filter-item--children'])[1]/*[1]/*/*[1]/*[2]/*";
			GridActiveElements = login.driver.findElements(By.xpath(ActiveEleXpath));
			login.Log4j.info("Region is: " + regionName);
			
			for (int i = regionVar; i < GridActiveElements.size();) {
				login.Log4j.info(i);
				String regionTxt = GridActiveElements.get(i).getText();
				if (regionName.equals(regionTxt)) {
					wait(200);
					getElementByXpath(
									login.driver, "(//*[contains(text(),'Region')]/following::*[contains(text(),'"
											+ regionName + "')])[1]/preceding::*[@class='tree-filter-item--toggle'][1]",
									30)
							.click();
					wait(700);
					try {
						// if sub region has open/toggle icon then expand
						if (login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Sub_sahranAfrica")))
								.size() == 1) {
							getElementByProperty(login.driver, "Sub_sahranAfrica", 6).click();

						}
					} catch (Exception e) {
						// sub region has no toggle
					}
					String SubRegionXpath = "//*[@class='tree-filter-item--children']//*[@class='tree-filter-item tree-filter-item__open']/*[2]//*[@class='filter-item--title']";
					ValidationMethod(sub_regionTDKeys, SubRegionXpath);

					for (String sub_region : sub_regionTDKeys) {
						int CountryList = 0;
						countryNameTD = (List<String>) Sub_regionTD.get(sub_region);
						login.Log4j.info("SubRegion is: " + sub_region);
						
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
								wait(200);
								Sub_regionElements.get(j).click();
								wait(1000);
								WebElement CountryListGrid = getElementByProperty(login.driver, "AllRegions_gridElement",8);
								wait(500);
								String CounntryNameXpath = "//*[@class='filter-list regions-filter-list']/*//*[@class='text-dots']";
//								login.Log4j.info("Region is: " + regionName);
//								login.Log4j.info("Sub region is: " + sub_region);
								ChinaFilter.ScrollToBottom(CountryListGrid, CounntryNameXpath, CountryList);
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
						getElementByProperty(login.driver, "Unselect_subRegion",8).click();

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

	@SuppressWarnings("unused")
	@Then("^Compare the country names with test data for economic groups$")
	public void compare_the_country_names_with_test_data_for_economic_groups() throws Throwable {
		Boolean Economic_group = true;
		int ecoVar = 0;
		Set<String> EconomicKeys = EcoGroupTD.keySet();
		//int economicCountTD = EconomicKeys.size();
		Set<String> CountryListTD = null;
		String EcoXpath = null;
		wait(2000);
		String EcoGroupVar = getElementByProperty(login.driver, "EconomicGroup", 20)
				.getAttribute("class");
		wait(2000);
		try {
			// if Region is expanded
			if (getElementByProperty(login.driver, "RegionVar", 20)
					.getAttribute("class").contains("tree-filter-item__open")) {
				getElementByProperty(login.driver, "Collapse_Region", 20)
						.click();
			}
			// if Economic group is not expanded
			if (!EcoGroupVar.contains("tree-filter-item__open")) {
			getElementByProperty(login.driver,
						"Expand_Economicgroup", 20).click();
				EcoXpath = "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[2]/*[2]//*[@class='text-dots']";
			} else {
				// if Eco group is expanded
				EcoXpath = "//*[@class='all-regions-tab']/*[1]/*[2]/*[1]/*[2]/*[2]//*[@class='text-dots']";
			}

		} catch (Exception e) {

		}
		ValidationMethod(EconomicKeys, EcoXpath);
		List<WebElement> EconomicElements = login.driver.findElements(By.xpath(EcoXpath));
		for (String Expected_economicTxt : EconomicKeys) {

			for (int i = ecoVar; i < EconomicElements.size();) {
				String Actual_ecoTxt = EconomicElements.get(i).getText();
				login.Log4j.info("Economic groups is : " + Expected_economicTxt);
				if (Expected_economicTxt.equalsIgnoreCase(Actual_ecoTxt)) {
					Thread.sleep(200);
					EconomicElements.get(i).click();
					int CountryList = 0;

					countryList_TD = (List<String>) EcoGroupTD.get(Expected_economicTxt);
//					login.Log4j.info("Country list : " + countryList_TD);
					if (countryList_TD != null) {
						// Convert List to Set
						CountryListTD = new HashSet<String>(countryList_TD);
						CountryList = CountryListTD.size();
					}
					jse.executeScript("arguments[0].scrollIntoView(true);", EconomicElements.get(i));
					wait(2000);
					WebElement CountryListGrid = getElementByProperty(login.driver, "AllRegions_gridElement",8);
					String countryName = "//*[@class='filter-list regions-filter-list']/*//*[@class='text-dots']";
					ChinaFilter.ScrollToBottom(CountryListGrid, countryName, CountryList);
					ValidationMethod(CountryListTD, countryName);
					ecoVar = i + 1;
					

				} else {
					ecoVar = i + 1;
					softAssert.assertNotEquals(Actual_ecoTxt, Expected_economicTxt);
					//Assert.fail(Expected_economicTxt + " not equals " + Actual_ecoTxt);
					
				}
				break;
			}
			
			
		}

	}

	/*	void ValidationMethod(Set<String> ListElementsTD, String XpathGridEle, Boolean booleanVar) {
		
		List<WebElement> GridElements = login.driver.findElements(By.xpath(XpathGridEle));
		login.Log4j.info("WebElements size is on site: " + GridElements.size());
	
		// Compare Size
		if (ListElementsTD.size() == GridElements.size()) {
			login.Log4j.info("Both list have same size of " + ListElementsTD.size());
		} else if (ListElementsTD.size() != GridElements.size()) {
			login.Log4j.error("ERROR : We have " + ListElementsTD.size() + " elements in Excel but see only "
					+ GridElements.size() + " elements on site");

		}
		Boolean result = false;
		List<String> ExpectedName = new ArrayList<String>();
		for (int i = 0; i < GridElements.size(); i++) {
			CommonFunctionality.wait(200);
			 String WebEle = GridElements.get(i).getText();
			// Log4j.info("WebElement is : " + GridElements.get(i).getText());
			 for (String ElementTD : ListElementsTD) {
				 if(ElementTD.contains(WebEle) || WebEle.contains(ElementTD) || WebEle.equalsIgnoreCase(ElementTD)) {
						login.Log4j.info("Excel item " + ElementTD + " found on site");
						result = true;
						break;
				 } else if(result == false){
					 ExpectedName.add(ElementTD);
				 }
			 }
			jse.executeScript("arguments[0].scrollIntoView(true);", GridElements.get(i));
			
			if(result == false) {
				login.Log4j.error("ERROR : We don't find " + ExpectedName + " is on Site");
			}
		}
		
		}}*/
		void ValidationMethod(Set<String> ListElementsTD, String XpathGridEle) {
			
			// Make Web Elements Text array
			List<String> ListOfWebElements = new ArrayList<String>();
			List<WebElement> GridElements = login.driver.findElements(By.xpath(XpathGridEle));
			login.Log4j.info("WebElements size is on site: " + GridElements.size());
			
			for (int i = 0; i < GridElements.size(); i++) {
				// String WebEle = GridElements.get(i).getText();
				// Log4j.info("WebElement is : " + GridElements.get(i).getText());
				wait(200);
				ListOfWebElements.add(GridElements.get(i).getText());
				jse.executeScript("arguments[0].scrollIntoView(true);", GridElements.get(i));
				
			}
			// Compare Size
			if (ListElementsTD.size() == ListOfWebElements.size()) {
				login.Log4j.info("Both list have same size of " + ListElementsTD.size());
			} else if (ListElementsTD.size() != ListOfWebElements.size()) {
				login.Log4j.error("ERROR : We have " + ListElementsTD.size() + " elements in Excel but see only "
						+ ListOfWebElements.size() + " elements on site");

			}
		
		
			//int l = 0;			
				/*for (int i = 0; i < ListOfWebElements.size();) {
					String str = ListOfWebElements.get(i);
					for (int k = l; k < list.size();) {
						String ElementTD = list.get(k);
						if (ElementTD.contains(str) || str.contains(ElementTD) || ElementTD.equalsIgnoreCase(str)) {
							login.Log4j.info("Excel item " + ElementTD + " found on site");
						
						} else {
							login.Log4j.error("ERROR : We don't find " + ElementTD + " is on Site");
						}
						l = k + 1;
						break;
						
					}
					i = i + 1;
				}
				
			}
			*/
		
		
				for (String str : ListElementsTD) {

					if (ListOfWebElements.contains(str)) {
						login.Log4j.info("Excel item " + str + " found on site");
					} else {
						login.Log4j.error("ERROR : We don't find " + str + " is on Site");
						// HTML_Report.strTCResult = "FAIL"; HTML_Report.execRemarks =
						// "ERROR : We don't find " + str + " is on Site";
					}
				}

				/*for (String str : ListOfWebElements) {
					if (ListElementsTD.contains(str)) {
						login.Log4j.info("Web element " + str + " Found in Excel");
					} else {
						login.Log4j.error("ERROR : We don't find " + str + " in Excel");
					}
				}*/

			}
}


