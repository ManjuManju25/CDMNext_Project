package CDMNext.StepDefinations;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CDMNext.util.CommonFunctionality;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ChinaFilter {
	static WebDriverWait wait = new WebDriverWait(login.driver, 3000);
	Actions action = new Actions(login.driver);
	static JavascriptExecutor jse = (JavascriptExecutor) login.driver;
	Map<String, Object> provinceTD = new LinkedHashMap<>();
	Map<String, Object> prefetureTD = null;
	List<String> countiesTD = null;
	String ProvinceTxtEle;
	String PrefectureTxt = null;
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";

	@SuppressWarnings("unchecked")
	@Given("^Read the Excel file \"([^\"]*)\"$")
	public void read_the_Excel_file(String arg1) throws Throwable {
		// Create an object of File class to open xlsx file
		File src = new File(System.getProperty("user.dir") + "\\Testdata\\" + arg1);
		// Create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// XSSFCellStyle style = wb.createCellStyle();
		CellStyle style = wb.createCellStyle();
		XSSFSheet sheet = wb.getSheet("Sheet3");
		int rowcount = sheet.getLastRowNum();
		login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
		int colcount = sheet.getRow(1).getLastCellNum();
		login.Log4j.info("Total number of columns present in the sheet: " + colcount);
		XSSFCell provinceTxt;
		// Row row = sheet1.getRow(0);
		// Log4j.info(row.getLastCellNum());
		
		for (int i = 1; i <= rowcount; i++) {
			provinceTxt = sheet.getRow(i).getCell(1);
			// style.setFillForegroundColor(IndexedColors.RED.getIndex());
			// style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			// provinceTxt.setCellStyle(style);

			prefetureTD = (Map<String, Object>) provinceTD.get(provinceTxt.getStringCellValue());
			if (prefetureTD == null) {
				// prefetureList = new ArrayList<>();
				if (sheet.getRow(i).getCell(2) != null) {
					prefetureTD = new LinkedHashMap<>();
				}

				if (sheet.getRow(i).getCell(3) != null) {
					countiesTD = new ArrayList<>();
					countiesTD.add(sheet.getRow(i).getCell(3).getStringCellValue());
					// Log4j.info("Counties list: " + countiesTD);
				}
				if (sheet.getRow(i).getCell(3) == null) {
					countiesTD = null;
				}
				if (sheet.getRow(i).getCell(2) != null) {
					prefetureTD.put(sheet.getRow(i).getCell(2).getStringCellValue(), countiesTD);
					// Log4j.info("Prefecture : " + prefetureTD);

				}

			} else {

				if (sheet.getRow(i).getCell(2) != null) {
					countiesTD = (List<String>) prefetureTD.get(sheet.getRow(i).getCell(2).getStringCellValue());
					// Log4j.info(countiesTD);
					if (countiesTD == null && sheet.getRow(i).getCell(3) != null) {
						countiesTD = new ArrayList<>();
					}
					if (sheet.getRow(i).getCell(3) != null) {
						countiesTD.add(sheet.getRow(i).getCell(3).getStringCellValue());
						// Log4j.info("Counties list: " + countiesTD);
					}
					prefetureTD.put(sheet.getRow(i).getCell(2).getStringCellValue(), countiesTD);
					// Log4j.info("prefectureL: " + prefetureTD);
				}
			}
			provinceTD.put(provinceTxt.getStringCellValue(), prefetureTD);
			// login.Log4j.info("Province/state data : " + provinceTD.toString());
			
		}
		
		fis.close();

	}

	@And("^Click on \"([^\"]*)\" dropdown$")
	public void click_on_dropdown(String arg1) throws Throwable {
		CommonFunctionality.ResetMethod();
		login.Log4j.info("Clicking on All Regions filter");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + arg1 + "')]"))).click();

	}

	@And("^Select subnational as \"([^\"]*)\"$")
	public void select_subnational_as(String arg1) throws Throwable {
		login.Log4j.info("Selecting subnational " + arg1);
		CommonFunctionality.wait(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1 + "')]"))).click();
	}

	@SuppressWarnings("unchecked")
	// @Then("^Compare the provinces , prefectures and counties with test data$")
	// public void compare_the_provinces_prefectures_and_counties_with_test_data()
	// throws Throwable {
	@Then("^Compare the \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\" with test data$")
	public void compare_the_and_with_test_data(String arg1, String arg2, String arg3) throws Throwable {
		int provinceVar = 0;
		String ActiveEleXpath;
		List<WebElement> GridActiveElements;
		Set<String> provinceKeys = provinceTD.keySet();
		int ProvinceCountTD = provinceKeys.size();
		Set<String> CountieListTD = null;
		CommonFunctionality.wait(1000);
		String ProvinceXpath = "//*[contains(@class,'subnational--section__first')]//*[@class='tree-filter-list']//*[contains(@class,'tree-filter-item__list')]//*[@class='filter-item--body'][1]//following-sibling::*[@class='text-dots']";
		//Verify provinces
		ValidationMethod(provinceKeys, ProvinceXpath);
		login.Log4j.info(arg1 + " size is: " + ProvinceCountTD);
		CollapseAllmethod();
		
		//Verify prefectures
		for (String provinceName : provinceKeys) {
			CommonFunctionality.wait(1000);
			prefetureTD = (Map<String, Object>) provinceTD.get(provinceName);
			if (prefetureTD != null) {
				Set<String> prefetureTDKeys = prefetureTD.keySet();
				int PrefectureCountTD = prefetureTDKeys.size();
				login.Log4j.info(arg1 + " in Excel is: " + provinceName);
				login.Log4j.info(arg2 + " Count in Excel is: " + PrefectureCountTD);
				login.Log4j.info(arg2 + " list : " + prefetureTDKeys);
				// CommonFunctionality.wait(1000);
				ActiveEleXpath = "//*[contains(@class,'subnational--section__second')]//*[contains(@class,'open-icon')]";
				GridActiveElements = login.driver.findElements(By.xpath(ActiveEleXpath));
				for (int i = provinceVar; i < GridActiveElements.size();) {
					login.Log4j.info(i);

					// CommonFunctionality.wait(500);
					if (provinceName.equals("Dadra and Nagar Haveli and Daman and Diu")) {
						GridActiveElements.get(i).click();
						// provinceVar = i + 1;
						GridActiveElements.get(i + 1).click();
						String PrefectureXpath = "//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')]//*[@class='tree-filter-list']//*[@class='filter-item--body'][1]//following-sibling::*[@class='text-dots']";
						ValidationMethod(prefetureTDKeys, PrefectureXpath);
						provinceVar = i + 2;
						break;
					} else {
						GridActiveElements.get(i).click();
						String PrefectureXpath = "//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')]//*[@class='tree-filter-list']//*[@class='filter-item--body'][1]//following-sibling::*[@class='text-dots']";
						ValidationMethod(prefetureTDKeys, PrefectureXpath);

						provinceVar = i + 1;

						break;
					}

				}
				// unselect province
				if (login.driver.findElements(By.xpath(
						"//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')]//*[contains(@class,'close-icon')]"))
						.size() > 1) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')][1]//*[contains(@class,'close-icon')]")))
							.click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"//*[contains(@class,'subnational--section__second')]//*[contains(@class,'tree-filter-item__open')]//*[contains(@class,'close-icon')]")))
							.click();
				} else {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							" ")))
							.click();
					// break;
				}
			}
		}
		// CommonFunctionality.getElementByXpath(driver, "//*[@class='dropdown--body
		// dropdown--body__open']//*[contains(text(),'Collapse all')]", 20).click();
		CommonFunctionality.wait(1000);
		ProvinceXpath = "//div[@class='subnational--section subnational--section__third']/div/div[2]/div/div[1]/div[2]";
		List<WebElement> ProvinceElements = login.driver.findElements(By.xpath(ProvinceXpath));
		provinceVar = 0;

		for (String provinceName : provinceKeys) {
			int prefectureVar = 0;
			prefetureTD = (Map<String, Object>) provinceTD.get(provinceName);
			if (prefetureTD != null) {
				Set<String> prefetureTDKeys = prefetureTD.keySet();
				Thread.sleep(1000);
				ActiveEleXpath = "//div[@class='subnational--section subnational--section__third']/div/div[2]/div/div[1]/div[1]/div[1]";
				GridActiveElements = login.driver.findElements(By.xpath(ActiveEleXpath));
				for (int i = provinceVar; i < ProvinceElements.size();) {
					String provinceTxt = ProvinceElements.get(i).getText();
					// if (provinceName.equals(provinceTxt)) {
					if (!provinceName.equals("Dadra and Nagar Haveli and Daman and Diu")) {
						Thread.sleep(200);
						GridActiveElements.get(i).click();
						provinceVar = i + 1;
					} else {
						// Log4j.error("We don't see " + provinceName + " on site");
						Thread.sleep(200);
						GridActiveElements.get(i).click();
						GridActiveElements.get(i + 1).click();
						provinceVar = i + 2;

					}
					Thread.sleep(300);
					try {
						Boolean expand = (login.driver.findElements(By.xpath(
								"//*[contains(@class,'subnational--section__third')]//*[@class='tree-filter-item tree-filter-item__open']//*[@class='tree-filter-item tree-filter-item__open']/*[1]/*[1]"))
								.size()) > 1;
						if (expand == false) {
							CommonFunctionality.getElementByXpath(login.driver,
									"//*[contains(@class,'subnational--section__third')]//*[@class='tree-filter-item tree-filter-item__open']//*[@class='tree-filter-item tree-filter-item__open']/*[1]/*[1]",
									15).click();
						} else {
							CommonFunctionality.getElementByXpath(login.driver,
									"//*[contains(@class,'subnational--section__third')]//*[@class='tree-filter-item tree-filter-item__open'][1]//*[@class='tree-filter-item tree-filter-item__open']/*[1]/*[1]",
									15).click();
							CommonFunctionality.getElementByXpath(login.driver,
									"//*[contains(@class,'subnational--section__third')]//*[@class='tree-filter-item tree-filter-item__open']//*[@class='tree-filter-item tree-filter-item__open']/*[1]/*[1]",
									15).click();
						}
					} catch (Exception e) {

					}
					for (String Prefecture : prefetureTDKeys) {
						// Thread.sleep(700);
						int CountieList = 0;
						countiesTD = (List<String>) prefetureTD.get(Prefecture);
						login.Log4j.info(arg3 + " list : " + countiesTD);
						if (countiesTD != null) {
							// Convert List to Set
							CountieListTD = new HashSet<String>(countiesTD);
							CountieList = CountieListTD.size();
						}

						Thread.sleep(500);
						String ActiveEleXpath1 = "//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')]/div[2]//div[1]//following-sibling::*[@class='tree-filter-item--open-icon']";
						List<WebElement> GridActiveElements1 = login.driver.findElements(By.xpath(ActiveEleXpath1));
						Thread.sleep(300);
						String PrefectureXpath = "//div[@class='subnational--section subnational--section__third']//*[contains(@class,'tree-filter-item__open')]/div[2]/div[1]/div/div[1]/div[2]";
						List<WebElement> PrefectureElements = login.driver.findElements(By.xpath(PrefectureXpath));
						for (int k = prefectureVar; k < PrefectureElements.size();) {
							String prefectureTxt = PrefectureElements.get(k).getText();
							if (Prefecture.trim().equalsIgnoreCase(prefectureTxt.trim())) {
								CommonFunctionality.wait(200);
								GridActiveElements1.get(k).click();
								CommonFunctionality.wait(400);
								String CountieXpath = "(//*[contains(@class,'subnational--section__third')]//*[@class='tree-filter-list']//*[contains(@class,'tree-filter-item__open')])[2]//*[@class='tree-filter-item--children']//*[@class='tree-filter-list']//*[@class='tree-filter-item--title']//following-sibling::*[@class='text-dots']";
								login.Log4j.info(arg1 + " in Excel is: " + provinceName);
								login.Log4j.info(arg2 + " in Excel is: " + Prefecture);
								ValidationMethod(CountieListTD, CountieXpath);
								prefectureVar = k + 1;
							} else {
								// Log4j.error("We don't see " + Prefecture + " on site");

							}

							break;
						}

						// unselect prefecture
						if (login.driver.findElements(By.xpath(
								"//div[@class='tree-filter-item--children']//div[@class='tree-filter-item tree-filter-item__open']/*[1]/*[1]"))
								.size() == 1) {

							CommonFunctionality.getElementByXpath(login.driver,
									"//div[@class='tree-filter-item--children']//div[@class='tree-filter-item tree-filter-item__open']/*[1]/*[1]",
									20).click();
						}
					}
//					provinceVar = i + 2;

					// unselect province
					if (login.driver.findElements(By.xpath(
							"(//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')])/*[1]//*[@class='tree-filter-item--close-icon']"))
							.size() == 1) {
						CommonFunctionality.getElementByXpath(login.driver,
								"(//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')])[1]/*[1]//*[@class='tree-filter-item--close-icon']",
								20).click();
					} else {
						CommonFunctionality.getElementByXpath(login.driver,
								"(//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')])[1]/*[1]//*[@class='tree-filter-item--close-icon']",
								20).click();
						CommonFunctionality.getElementByXpath(login.driver,
								"(//*[contains(@class,'subnational--section__third')]//*[contains(@class,'tree-filter-item__open')])[1]/*[1]//*[@class='tree-filter-item--close-icon']",
								20).click();
					}

					break;
				}
			}
		}
	}

	static void ScrollToBottom(WebElement Grid, String XpathGridEle, int ListSizeTD) throws InterruptedException {
		int loopCount = 0;
		Thread.sleep(2000);
		List<WebElement> GridElements = login.driver.findElements(By.xpath(XpathGridEle));
		int GridElementsCount = GridElements.size(); // Expecting default visible elements count
		// login.Log4j.info("Default list size in WE is: " + GridElementsCount);

		loopCount = (int) (ListSizeTD / GridElementsCount);
		// login.Log4j.info("Loop count for Web Element list is : " + loopCount);

		for (int i = 1; i <= loopCount; i++) {
			try {
				jse.executeScript("arguments[0].scrollTo(0, arguments[0].scrollHeight)", Grid);
			} catch (StaleElementReferenceException e) {

			}
			GridElements = login.driver.findElements(By.xpath(XpathGridEle));
			GridElementsCount = GridElements.size();
			// login.Log4j.info("After scrolling list size in WE when 'i' is " + i + " is "
			// + GridElementsCount);

		}

	}

	static void ValidationMethod(Set<String> ListElementsTD, String XpathGridEle) {
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
			// Log4j.error(ANSI_RED + " This text is red! "
			// + ANSI_RESET);
		}

		for (String str : ListOfWebElements) {
			if (ListElementsTD.contains(str.trim())) {
				 login.Log4j.info("Web element " + str + " Found in Excel");
				 
			} else {
				login.Log4j.error("ERROR : We don't find " + str + " in Excel");
			}
		}

		for (String str : ListElementsTD) {
			if (ListOfWebElements.contains(str)) {
				 login.Log4j.info("Excel item " + str + " found on site");
			} else {
				login.Log4j.error("ERROR : We don't find " + str + " is on Site");
			}
		}

	}
	static void CollapseAllmethod() {
		if (login.driver.findElement(By.xpath("//*[@class='subnational']//*[contains(text(),'Collapse all')]"))
				.isDisplayed()) {
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@class='subnational']//*[contains(text(),'Collapse all')]")))
					.click();
		}
	}

}
