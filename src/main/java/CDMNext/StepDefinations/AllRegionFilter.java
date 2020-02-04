/*package CDMNext.StepDefinations;



	import java.io.File;

	import java.io.FileInputStream;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.LinkedHashMap;
	import java.util.LinkedHashSet;
	import java.util.List;
	import java.util.Map;
	import java.util.Set;
	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import cucumber.api.java.en.And;
	import cucumber.api.java.en.Then;

	public class AllRegionFilter {
		WebDriverWait wait = new WebDriverWait(login.driver, 5000);
		
		
		List<String> ProvinceArr = new ArrayList<>();
		List<String> PrefectureArr = new ArrayList<>();
		List<String> CountiesArr = new ArrayList<>();

		@And("^Read the Excel file \"([^\"]*)\"$")
		public void read_the_Excel_file(String arg1) throws Throwable {

			// Create an object of File class to open xlsx file
			File file = new File(System.getProperty("user.dir") + "\\" + arg1);
			// Create an object of FileInputStream class to read excel file
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = null;
			XSSFSheet sheet = null;
			if (file.exists()) {
				wb = new XSSFWorkbook(fis);
				sheet = wb.getSheet("sheet4");
			} else {
				login.Log4j.info("File is not exists");
			}
			int rowcount = sheet.getLastRowNum();
			login.Log4j.info("Total number of rows present in the sheet: " + rowcount);
			int colcount = sheet.getRow(1).getLastCellNum();
			login.Log4j.info("Total number of columns present in the sheet: " + colcount);
			// Row row = sheet1.getRow(0);
			// login.Log4j.info(row.getLastCellNum());
			String provinceTxt;
			String prefectureTxt;
		
			// Creating a HashMap
			Map<String, String> provinces = new HashMap<>();
			//Map<String, String> prefectures = new HashMap<>();
			 Map<String, List<String>> prefectures = new HashMap<String, List<String>>();
			 Set<String> PrefectureElements = new
					  LinkedHashSet<>(); 

			for (int i = 1; i <= rowcount; i++) {
				provinceTxt = sheet.getRow(i).getCell(2).getStringCellValue();
				prefectureTxt = sheet.getRow(i).getCell(3).getStringCellValue();
				// Add the elements to set
				PrefectureArr.add(prefectureTxt);
				//PrefectureElements.addAll(PrefectureArr);
				prefectures.put(provinceTxt, (List<String>) PrefectureArr);

			}

			login.Log4j.info(prefectures);

			
			 * // Function to remove duplicates from an ArrayList
			 * 
			 * 
			 * // Create a new LinkedHashSet Set<String> uniqueProvinceElements = new
			 * LinkedHashSet<>(); // Add the elements to set
			 * uniqueProvinceElements.addAll(ProvinceArr);
			 * login.Log4j.info("Unique elements list " + uniqueProvinceElements);
			 * login.Log4j.info("Unique elements size " + uniqueProvinceElements.size()); //
			 * Clear the list ProvinceArr.clear();
			 * 
			 * // add the elements of set // with no duplicates to the list
			 * ProvinceArr.addAll(uniqueProvinceElements); for (int i = 1; i <= rowcount;
			 * i++) { XSSFCell provinceEle = sheet.getRow(i).getCell(2);
			 * 
			 * for (String ProvinceTxt : ProvinceArr) { if
			 * (ProvinceTxt.equalsIgnoreCase(provinceEle.getStringCellValue())) {
			 * prefectureTxt = sheet.getRow(i).getCell(3); try { prefectureTxt =
			 * sheet.getRow(i).getCell(3);
			 * PrefectureArr.add(prefectureTxt.getStringCellValue());
			 * login.Log4j.info("Prefecture Array " + PrefectureArr); } catch(Exception e) {
			 * Set<String> uniquePrefectureElements = new LinkedHashSet<>(); // Add the
			 * elements to set uniquePrefectureElements.addAll(PrefectureArr);
			 * login.Log4j.info("Unique elements list " + uniquePrefectureElements);
			 * login.Log4j.info("Unique elements size " + uniquePrefectureElements.size());
			 * // Clear the list PrefectureArr.clear();
			 * 
			 * // add the elements of set // with no duplicates to the list
			 * PrefectureArr.addAll(uniquePrefectureElements); }
			 * 
			 * }
			 * 
			 * } }
			 
		}

		@And("^Click on \"([^\"]*)\" dropdown$")
		public void click_on_dropdown(String arg1) throws Throwable {
			login.Log4j.info("Clicking on All Regions filter");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'" + arg1 + "')]"))).click();
			
		}

		@And("^Select subnational as \"([^\"]*)\"$")
		public void select_subnational_as(String arg1) throws Throwable {
			login.Log4j.info("Selecting subnational "+ arg1);
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1 + "')]")).click();
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='tabs__tabs-box']//*[contains(text(),'" + arg1 + "')]"))).click();
		}

		@Then("^Compare \"([^\"]*)\" and \"([^\"]*)\" with test data for country China$")
		public void compare_and_with_test_data_for_country_China(String arg1, String arg2) throws Throwable {
			WebElement ActiveEle;
			String ProvinceTxtEle;
			String[] subNationalCategory = arg1.split(",");
			Thread.sleep(2000);
			List<WebElement> provincesNameList = login.driver.findElements(By.xpath("//*[@class='subnational--section subnational--section__first']//*[@class='filter-list']//*[@class='subnational-filter-item']//*[@class='text-dots']"));
			List<WebElement> provincesActiveList = login.driver.findElements(By.xpath("//*[@class='subnational--section subnational--section__first']//*[@class='filter-list']//*[@class='subnational-filter-item']//*[@class='subnational-filter-item--expand']//*[@class='subnational-filter-item--activate']"));
			login.Log4j.info("Provinces List size : "+ provincesNameList.size() );
			if(subNationalCategory[0].equals("Provinces")) {
				for(int i = 1; i < provincesNameList.size(); i++) {
					Thread.sleep(1000);
				//	int j = i + 1 ;
					ProvinceTxtEle = provincesNameList.get(i).getText();
					login.Log4j.info(ProvinceTxtEle);
					ActiveEle = provincesActiveList.get(i);
				}
				
			}
		}
	}


*/