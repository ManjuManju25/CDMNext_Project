package CDMNext.StepDefinations;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class LandingpageAnalytics


   {
	public String CopylinkRightclick;
	public int Emisinsightresult;
	public int Focusinsightresult;
	public int Result_IndicatorinFocus;
	
	@And("^Navigate to Analytics tab$")
	public void navigate_to_Analytics_tab() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Analytics_Tab_inLandingPage"))).click();
	}

	@And("^Navigate to China Premium tab$")
	public void navigate_to_China_Premium_tab() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chinaPremium_Tab"))).click();
	}

	@And("^Select mode as tabel mode$")
	public void select_mode_as_tabel_mode() throws Throwable {
		Thread.sleep(2000);
		login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Table_Tab"))).click();
	}

	@And("^Verify China Premium Data talk insights count on tab header$")
	public void verify_China_Premium_Data_talk_insights_count_on_tab_header() throws Throwable {
		Thread.sleep(2000);
		List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));
		int chinapremium_insight_count = objLinks.size();
		System.out.println("Total Insights are- " + chinapremium_insight_count);
		
		String Listofinsightcountinchinapremium= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chinaPremium_Tab_count"))).getText();
		System.out.println("List of insight count in china premium- " + Listofinsightcountinchinapremium);
		String str = Listofinsightcountinchinapremium;
		String Numbers;
		Numbers = str.replaceAll("[^0-9]", "");
		int result = Integer.parseInt(Numbers);
		System.out.println(result);
		
		System.out.println(chinapremium_insight_count +":"+ result);
		 if(chinapremium_insight_count == result   ) 
		 {
			 System.out.println("China Premium Data talk Insights count on tab header is Verified Succesfully");
		  }
		 else
		 {
			  Assert.fail("China Premium Data talk Insights count on tab header is NOT Verified Succesfully");
		  }
		
	}

		@And("^Select mode as grid mode$")
		public void select_mode_as_grid_mode() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("gridmode"))).click();
		}
		
		@And("^Verify created users name$")
		public void verify_created_users_name() throws Throwable {
			Thread.sleep(2000); 
		
					if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Lasteditornameintosharedaccnt"))).size() != 0)
					{
				           Thread.sleep(2500);
				       	String Text1 = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Lasteditornameintosharedaccnt"))).getText();
				        System.out.println(Text1);
				        String Text2 = "V C";
				        System.out.println( Text1 + ":" + Text2);
				    	if(Text1.equalsIgnoreCase(Text2))
						{
							System.out.println("Successfully Verified  Created users name");
							 Thread.sleep(4500);
						}
				  }
					else
				  {
					  Assert.fail("Successfully NOT Verified Created users name"); 
				  }
		}
		@And("^Share for China Premium Data talk$")
		public void share_for_China_Premium_Data_talk() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Disable_shared_icon"))).size() != 0)
			{
				System.out.println("Share for China Premium Data talk Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Share for China Premium Data talk is Not Verified Successfully"); 
		  }
		}
		@And("^Verify Last editor name and time$")
		public void verify_Last_editor_name_and_time() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Lasteditornameintosharedaccnt"))).size() != 0)
			{
				System.out.println("Last editor Name is Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Last editor Name is NOT Verified Successfully"); 
		  }
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Last_editor_time"))).size() != 0)
			{
				System.out.println("Last editor Time is Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Last editor Time is NOT Verified Successfully"); 
		  }
		}
		@And("^Select favorite icon$")
		public void select_favorite_icon() throws Throwable {
			Thread.sleep(6000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_icon"))).click();
		}

		@And("^favorite functionality in China Premium Data talk$")
		public void favorite_functionality_in_China_Premium_Data_talk() throws Throwable {
			Thread.sleep(2000);
			String FavouriteInsightinanlyticstab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_Tab_inLandingPage"))).click();
			Thread.sleep(2000);
			String FavouriteInsightinFavoritetab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			System.out.println(  FavouriteInsightinanlyticstab +":"+ FavouriteInsightinFavoritetab);
			 if(FavouriteInsightinanlyticstab.equalsIgnoreCase(FavouriteInsightinFavoritetab)){
				 
				  System.out.println("Favorite Functionality in China Premium Data talk is working Successfully");
				  navigate_to_Analytics_tab();
				  }
			 else
				  {
					  Assert.fail("Favorite Functionality in China Premium Data talk is NOT working Successfully"); 
					  navigate_to_Analytics_tab();
				  }
		}
		@And("^Select Right click options$")
		public void select_Right_click_options() throws Throwable {
			Thread.sleep(2000);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(AddTag).build().perform();
		}

		@And("^Verify Right click options$")
		public void verify_Right_click_options() throws Throwable {
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Right_click_options"))).size() != 0)
			{
				System.out.println("Successfully verified Right click options");
			}
			 else
			  {
				  Assert.fail("Successfully NOT verified  Right click options");
			  }
		}
		@And("^Verify View insight$")
		public void verify_View_insight() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Right_click"))).click();
			Thread.sleep(1500);
			 WebElement View_Close = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Close")));
			 login.Log4j.info("Is 'View insight' Displayed? - True/False:: " + View_Close.isDisplayed());
			  Assert.assertEquals(true,View_Close.isDisplayed());
			  Thread.sleep(1500);
			  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Close"))).click();
		}
		@And("^Verify Open on insight right click$")
		public void verify_Open_on_insight_right_click() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Open_Right_click"))).click();
			Thread.sleep(2500);
			  WebElement btnDownload = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownload")));
				 login.Log4j.info("Is 'btnDownload' Displayed? - True/False:: " + btnDownload.isDisplayed());
				  Assert.assertEquals(true,btnDownload.isDisplayed());
				  Thread.sleep(5500);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Verify Open with new tab on insight right click$")
		public void verify_Open_with_new_tab_on_insight_right_click() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("OpenNewTab_Right_click"))).click();
			Thread.sleep(2500);
			  ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500); 
			    WebElement btnDownload = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownload")));
				 login.Log4j.info("Is 'btnDownload' Displayed? - True/False:: " + btnDownload.isDisplayed());
				  Assert.assertEquals(true,btnDownload.isDisplayed());
			    login.driver.close();
			    login.driver.switchTo().window(tabs2.get(0));
		}
		@And("^Verify Copy on insight right click$")
		public void verify_Copy_on_insight_right_click() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Copy_Right_click"))).click();
			Thread.sleep(2500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copyinsight"))).click();
			
			Thread.sleep(2500);
			String CopyInsight = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Insightname"))).getText();
			  Thread.sleep(5500);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
				 Thread.sleep(5500);
				
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("MyInsight_Tab_inLandingPage"))).click();
					 Thread.sleep(2000);
				String IECopyInsight = 	login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
		
				 System.out.println(CopyInsight +":"+ IECopyInsight);
				 if(CopyInsight.equalsIgnoreCase(IECopyInsight)   ) {
					 System.out.println("Copying Functionality is working Succesfully in GRID mode");
				  }else{
					  Assert.fail("Copying Functionality is NOT working Succesfully in GRID mode");
				  }
				 }
		@And("^Select Add tags options$")
		public void select_Add_tags_options() throws Throwable {
			Thread.sleep(6500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddTag_Right_click"))).click();
		}

		@And("^Verify Add tags on insight right click$")
		public void verify_Add_tags_on_insight_right_click() throws Throwable {
			Thread.sleep(1000);
			login.driver.findElement(By.xpath("//div[@class='form-group']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//input[@class='ui-widget-content ui-autocomplete-input']")).sendKeys("AddedTag");
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='modal-header sphere-modal__header']")).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls--right']/button[2]")).click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div")).click();
			Thread.sleep(4500);
			login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).click();
			String Text1 =login.driver.findElement(By.xpath("//span[contains(text(),'AddedTag')]")).getText();
			System.out.println("Text1- " + Text1);
			Thread.sleep(4500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
			action.contextClick(AddTag).build().perform();
			Thread.sleep(4500);
			//selecting Add tag option
			login.driver.findElement(By.xpath("//div[@class='items-wrapper']/li[8]")).click();
			Thread.sleep(4500);
			WebElement AddedTag = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("AddedTag")));
			Assert.assertEquals(true,AddedTag.isDisplayed());
			String Text2 =login.driver.findElement(By.xpath("//span[@class='tagit-label']")).getText();
			System.out.println("Text2- " + Text2);	
			
			if(Text1.equalsIgnoreCase(Text2))
			{
				System.out.println("All tags drop down is Verified Successfully");
				HTML_Report.strTCResult="PASS";
				  HTML_Report.execRemarks="All tags drop down is Verified Successfully";
			}
			else
			{
				 Assert.fail( "All tags drop down is NOT Verified Successfully");
				 HTML_Report.strTCResult="FAIL";
				  HTML_Report.execRemarks="All tags drop down is NOT Verified Successfully";
			}
			
			Thread.sleep(4500);
			login.driver.findElement(By.xpath("//span[@class='text-icon']")).click();
			Thread.sleep(4500);
			login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls--right']/button[2]")).click();
			Thread.sleep(4500);
			login.driver.findElement(By.xpath("//div[@class='landing-content--filters-panel']/div[2]/div/div/div/div/span")).click();
		}
		@And("^Select view options$")
		public void select_view_options() throws Throwable {
			Thread.sleep(6500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("View_Right_click"))).click();
		}

		@And("^Verify insights view on insight right click$")
		public void verify_insights_view_on_insight_right_click() throws Throwable {
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("View_content"))).size() != 0)
			{
				System.out.println("Successfully verified insights view on insight right click");
			}
			 else
			  {
				  Assert.fail("Successfully NOT verified insights view on insight right click");
			  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
		}
		@And("^Verify Related Insights in view mode$")
		public void verify_Related_Insights_in_view_mode() throws Throwable {
			Thread.sleep(6500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Related_insight"))).click();
			Thread.sleep(6500);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Related_insight_inside"))).size() != 0)
			{
				System.out.println("Successfully verified Related Insights in view mode");
			}
			 else
			  {
				  Assert.fail("Successfully NOT verified Related Insights in view mode");
			  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
		}
		@And("^Select Open options in preview$")
		public void select_Open_options_in_preview() throws Throwable {
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("openinviewingridmode"))).click();
		}

		@And("^Verify Open in view mode$")
		public void verify_Open_in_view_mode() throws Throwable {
			Thread.sleep(4500); 
			ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500);
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("btnDownload"))).size() != 0)
					{
						System.out.println("Successfully verified Open option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified Open option in insight preview");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(5000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Select Copy options in preview$")
		public void select_Copy_options_in_preview() throws Throwable {
			Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copyinviewingridmode"))).click();
		}

		@And("^Verify Copy in view mode$")
		public void verify_Copy_in_view_mode() throws Throwable {
			 Thread.sleep(9500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("copyinsightinpopup"))).click();
			 Thread.sleep(4500);
			String Text2= login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field-text text-dots']")).getText();
			System.out.println(Text2);
			CharSequence seq = "copy"; 
			    boolean bool = Text2.contains(seq); 
			    System.out.println("Found copy ?: " + bool); 
			    if (bool==true)
			    {
			    	System.out.println("Successfully verified default insight title while coping insight");
			    }
			    else
			    {
			    	 Assert.fail("Successfully NOT verified default insight title while coping insight");
			    }
			    Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			 
		}
		@And("^Select Download options in preview$")
		public void select_Download_options_in_preview() throws Throwable {
			Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Downloadinviewingridmode"))).click();
		}

		@And("^Verify Download in view mode$")
		public void verify_Download_in_view_mode() throws Throwable {
			 Thread.sleep(4500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("btnDownloadinpopup"))).size() != 0)
				{
					System.out.println("Successfully verified Download option in insight preview");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Download option in insight preview");
				  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpopup"))).click();
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Select Expand options in preview$")
		public void select_Expand_options_in_preview() throws Throwable {
			Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Expandicon"))).click();
		}

		@And("^Verify Expand in view mode$")
		public void verify_Expand_in_view_mode() throws Throwable {
			Thread.sleep(4500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("collapseicon"))).size() != 0)
				{
					System.out.println("Successfully verified Maximize option in insight preview");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Maximize option in insight preview");
				  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("collapseicon"))).click();
			 Thread.sleep(4500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Expandicon"))).size() != 0)
				{
					System.out.println("Successfully verified Minimized option in insight preview");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Minimized option in insight preview");
				  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Verify Close in view mode$")
		public void verify_Close_in_view_mode() throws Throwable {
			 Thread.sleep(4500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).size() != 0)
				{
					System.out.println("Successfully verified Close option for insight preview popup");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Close option for insight preview popup");
				  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Verify my series and view tabs$")
		public void verify_my_series_and_view_tabs() throws Throwable {
			Thread.sleep(4500); 
			ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500);
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Myseries_in_Open"))).size() != 0)
					{
						System.out.println("Successfully verified My Series option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified My Series option in insight preview");
					  }
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("View_in_Open"))).size() != 0)
					{
						System.out.println("Successfully verified View option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified View option in insight preview");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(5000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Select my series options$")
		public void select_my_series_options() throws Throwable {
			Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Myseries_in_Open"))).click();
		}

		@And("^Select Download option$")
		public void select_Download_option() throws Throwable {
			Thread.sleep(4500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownload"))).click();
			Thread.sleep(4500);
			WebElement element = login.driver.findElement(By.xpath("//div[@class='sphere-modal-controls']/div[2]/button[3]"));
			Actions action = new Actions(login.driver);
			Thread.sleep(5000);
			action.moveToElement(element).click().perform();    
		}

		@And("^Verify Download scenario for Data$")
		public void verify_Download_scenario_for_Data() throws Throwable 
		{
			Thread.sleep(25000); 
			File theNewestFile = null;
			    File dir = new File(System.getProperty("user.home") + "\\Downloads");
			   String y="xlxs";
			    //System.out.println("^^^^^^^^^^^^"+y);
			    String ext="xlxs";
				FileFilter fileFilter = new WildcardFileFilter("*." + ext);
			    
				File[] files = dir.listFiles(fileFilter);

			    if (files.length > 0) {
			        /** The newest file comes first **/
			    	 //System.out.println("^^^^^^^^^^^^Entered");
			        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			        theNewestFile = files[0];
			        
			    //}
			    
			    System.out.println("The Successfully downloaded file is " + theNewestFile);
			    String E =getFileExtension(theNewestFile);
			    System.out.println("The Successfully extension file is " +  E);
			    //return theNewestFile;
			    if(E.equalsIgnoreCase(ext)){
			    	 System.out.println("Downloaded File Format Matched Successfully."  + "'"+ y +  "' <> '" + E + "'");
			    }
			    else{
			    	
			    	 Assert.fail( "Downloaded File Format is NOT Matched."  +"'" +  y +  "' <> '" + ext + "'");
			    }
			   
			    }
			    Thread.sleep(25000); 
			    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		public static String getFileExtension(File file) {
		    String name = file.getName();
		    try {
		        return name.substring(name.lastIndexOf(".") + 1);
		       
		    } catch (Exception e) {
		        return "";
		    }
		}
		@And("^Verify China Premium Data talk insight Edit access$")
		public void verify_China_Premium_Data_talk_insight_Edit_access() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]")).click();
			Thread.sleep(5500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]"));
			action.contextClick(AddTag).build().perform();
			Thread.sleep(5500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Right_click_options"))).size() != 0)
				{
					System.out.println("Successfully verified China Premium Data talk insight Edit access");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified China Premium Data talk insight Edit access");
				  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
			
		}
		@And("^Navigate to Sentix Premium tab$")
		public void navigate_to_Sentix_Premium_tab() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sentix_Tab"))).click();
		}

		@And("^Verify Sentix insights count on tab header$")
		public void verify_Sentix_insights_count_on_tab_header() throws Throwable {
			Thread.sleep(2000);
			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));
			int Sentix_insight_count = objLinks.size();
			System.out.println("Total Insights are- " + Sentix_insight_count);
			
			String Listofinsightcountinchinapremium= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sentix_Tab"))).getText();
			System.out.println("List of insight count in china premium- " + Listofinsightcountinchinapremium);
			String str = Listofinsightcountinchinapremium;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			int result = Integer.parseInt(Numbers);
			System.out.println(result);
			
			System.out.println(Sentix_insight_count +":"+ result);
			 if(Sentix_insight_count == result   ) 
			 {
				 System.out.println("Sentix Insights count on tab header is Verified Succesfully");
			  }
			 else
			 {
				  Assert.fail("Sentix Insights count on tab header is NOT Verified Succesfully");
			  }
			
		}
		@And("^Share for Sentix Premium Data talk$")
		public void share_for_Sentix_Premium_Data_talk() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Disable_shared_icon"))).size() != 0)
			{
				System.out.println("Share for Sentix Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Share for Sentix is Not Verified Successfully"); 
		  }
		}
		@And("^favorite functionality in Sentix$")
		public void favorite_functionality_in_Sentix() throws Throwable {
			String FavouriteInsightinanlyticstab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_Tab_inLandingPage"))).click();
			Thread.sleep(2000);
			String FavouriteInsightinFavoritetab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			System.out.println(  FavouriteInsightinanlyticstab +":"+ FavouriteInsightinFavoritetab);
			 if(FavouriteInsightinanlyticstab.equalsIgnoreCase(FavouriteInsightinFavoritetab)){
				 
				  System.out.println("Favorite Functionality in Sentix is working Successfully");
				  navigate_to_Analytics_tab();
				  }
			 else
				  {
					  Assert.fail("Favorite Functionality in Sentix is NOT working Successfully"); 
					  navigate_to_Analytics_tab();
				  }
		}
		@And("^Verify Copy link on insight right click$")
		public void verify_Copy_link_on_insight_right_click() throws Throwable {
			Thread.sleep(1500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CopyLink_Right_click"))).click();
			 Thread.sleep(2500);
			  CopylinkRightclick = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			  Thread.sleep(2500);
				 Robot r = new Robot();        
		          r.keyPress(KeyEvent.VK_CONTROL);
		          r.keyPress(KeyEvent.VK_T);
		          r.keyRelease(KeyEvent.VK_CONTROL);
		          r.keyRelease(KeyEvent.VK_T);
		          Thread.sleep(2500);
		          r.keyPress(KeyEvent.VK_CONTROL);
		          r.keyPress(KeyEvent.VK_V);
		          r.keyRelease(KeyEvent.VK_CONTROL);
		          r.keyRelease(KeyEvent.VK_V);
		          r.keyPress(KeyEvent.VK_ENTER);
		          r.keyRelease(KeyEvent.VK_ENTER);
		          Thread.sleep(2500);
		          ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
				    login.driver.switchTo().window(tabs2.get(1));
				    
				    
				    String Copylinkinsightname = login.driver.findElement(By.xpath("//div[@class='page-main-header--title-field-text text-dots']")).getText();
				    
					System.out.println(  CopylinkRightclick +":"+ Copylinkinsightname);
					if(CopylinkRightclick.equalsIgnoreCase(Copylinkinsightname)){
					  System.out.println("Copy link Option is working Successfully in Sent");
					  }else{
						  Assert.fail("Copy link Option is NOT working Successfully");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
		}
		
		@And("^Verify my series and view tabs in Sentix tab$")
		public void verify_my_series_and_view_tabs_in_Sentix_tab() throws Throwable {
			Thread.sleep(4500); 
			ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500);
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Myseries_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified My Series option in insight preview in Sentix tab");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified My Series option in insight preview in Sentix tab");
					  }
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("View_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified View option in insight preview in Sentix tab");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified View option in insight preview in Sentix tab");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(5000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		   
		}
		@And("^Select Download option in Sentix tab$")
		public void select_Download_option_in_Sentix_tab() throws Throwable {
			Thread.sleep(4500);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownload"))).click();
		}

		@And("^Verify Download scenario for Data in Sentix tab$")
		public void verify_Download_scenario_for_Data_in_Sentix_tab() throws Throwable {
			
		}
		@And("^Verify Sentix Edit access$")
		public void verify_Sentix_Edit_access() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]")).click();
			Thread.sleep(5500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]"));
			action.contextClick(AddTag).build().perform();
			Thread.sleep(5500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Right_click_options"))).size() == 0)
				{
					System.out.println("Successfully verified Sentix insight Edit access");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Sentix insight Edit access");
				  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Navigate to EMIS tab$")
		public void navigate_to_EMIS_tab() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab"))).click();
		}

		@And("^Verify EMIS insights count on tab header$")
		public void verify_EMIS_insights_count_on_tab_header() throws Throwable {
			Thread.sleep(2000);
			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));
			int EMIS_insight_count = objLinks.size();
			System.out.println("Total Insights are- " + EMIS_insight_count);
			
			String ListofinsightcountinEMIS= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab_C"))).getText();
			System.out.println("List of insight count in EMIS- " + ListofinsightcountinEMIS);
			String str = ListofinsightcountinEMIS;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			Emisinsightresult = Integer.parseInt(Numbers);
			System.out.println(Emisinsightresult);
			
			System.out.println(EMIS_insight_count +":"+ Emisinsightresult);
			 if(EMIS_insight_count != Emisinsightresult   ) 
			 {
				 System.out.println("EMIS Insights count on tab header is Verified Succesfully");
			  }
			 else
			 {
				  Assert.fail("EMIS count on tab header is NOT Verified Succesfully");
			  }
			
		}
		
		@And("^Select any indicators from EMIS dropdown$")
		public void select_any_indicators_from_EMIS_dropdown() throws Throwable {
			Thread.sleep(2000);
			String ListofinsightcountinEMIS= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab_C"))).getText();
			System.out.println("List of insight count in EMIS- " + ListofinsightcountinEMIS);
			String str = ListofinsightcountinEMIS;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			Emisinsightresult = Integer.parseInt(Numbers);
			System.out.println(Emisinsightresult);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Indicater"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_filter_emis"))).click();
		}

		
		@And("^Select any Indicators from EMIS dropdown$")
		public void select_any_Indicators_from_EMIS_dropdown() throws Throwable {
			Thread.sleep(2000);
			String ListofinsightcountinEMIS= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab_C"))).getText();
			System.out.println("List of insight count in EMIS- " + ListofinsightcountinEMIS);
			String str = ListofinsightcountinEMIS;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			Emisinsightresult = Integer.parseInt(Numbers);
			System.out.println(Emisinsightresult);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Indicater"))).click();
			Thread.sleep(2000);
		}

		@And("^Verify Clear All functionality$")
		public void verify_Clear_All_functionality() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("clear_All"))).size() != 0)
			{
				System.out.println("Clear All functionality is Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Clear All functionality is Not Verified Successfully"); 
		  }
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("clear_All"))).click();
		}
		@And("^Verify EMIS dropdown$")
		public void verify_EMIS_dropdown() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab"))).click();
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Emis_Dropdown"))).size() != 0)
			{
				System.out.println("Emis Drop Down is Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Emis Drop Down is Not Verified Successfully"); 
		  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@And("^Verify Apply Indicators filters$")
		public void verify_Apply_Indicators_filters() throws Throwable {
			Thread.sleep(2000);
			String ListofinsightcountinEMIS= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab_C_After_Filter"))).getText();
			System.out.println("List of insight count in EMIS- " + ListofinsightcountinEMIS);
			String str = ListofinsightcountinEMIS;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			int EmisinsightresultAfterfilter = Integer.parseInt(Numbers);
			System.out.println(EmisinsightresultAfterfilter);
			 if(Emisinsightresult != EmisinsightresultAfterfilter   ) 
			 {
				 System.out.println("Apply Indicators filters is Verified Succesfully");
			  }
			 else
			 {
				  Assert.fail("Apply Indicators filters is NOT Verified Succesfully");
			  }
			 Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_in_Emis_tab"))).click();
		}

		@And("^Search for any region$")
		public void search_for_any_region() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emis_indicater_search"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Emis_indicater_search"))).sendKeys("construction");
		}

		@And("^Verify Search in Emis Indicators$")
		public void verify_Search_in_Emis_Indicators() throws Throwable {
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Emis_region_construction"))).size() != 0)
			{
				System.out.println("Successfully verified Search in Emis Indicators");
			}
			 else
			  {
				  Assert.fail("Successfully NOT verified Search in Emis Indicators");
			  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@And("^Verify page numbers in Emis Indicators$")
		public void verify_page_numbers_in_Emis_Indicators() throws Throwable {
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("pages_in_Emis_insight"))).size() != 0)
			{
				System.out.println("Successfully verified page numbers in Emis");
			}
			 else
			  {
				  Assert.fail("Successfully NOT verified page numbers in Emis");
			  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		
		}
		@And("^Verify created users name in Emis$")
		public void verify_created_users_name_in_Emis() throws Throwable {
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Created_username_Emis_insight"))).size() != 0)
			{
				System.out.println("Successfully verified created users name in Emis");
			}
			 else
			  {
				  Assert.fail("Successfully NOT verified created users name in Emis");
			  }
			 Thread.sleep(4500);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Verify Share for EMIS$")
		public void verify_Share_for_EMIS() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Disable_shared_icon"))).size() != 0)
			{
				System.out.println("Share for EMIS Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Share for EMIS is Not Verified Successfully"); 
		  }
		}
		@And("^Verify Add EMIS insights to favorite$")
		public void verify_Add_EMIS_insights_to_favorite() throws Throwable {
			Thread.sleep(2000);
			String FavouriteInsightinanlyticstab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_Tab_inLandingPage"))).click();
			Thread.sleep(2000);
			String FavouriteInsightinFavoritetab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			System.out.println(  FavouriteInsightinanlyticstab +":"+ FavouriteInsightinFavoritetab);
			 if(FavouriteInsightinanlyticstab.equalsIgnoreCase(FavouriteInsightinFavoritetab)){
				 
				  System.out.println("Favorite Functionality in China Premium Data talk is working Successfully");
				  navigate_to_Analytics_tab();
				  }
			 else
				  {
					  Assert.fail("Favorite Functionality in China Premium Data talk is NOT working Successfully"); 
					  navigate_to_Analytics_tab();
		}
		}
		
		@And("^Verify Download in view mode of EMIS tab$")
		public void verify_Download_in_view_mode_of_EMIS_tab() throws Throwable {
			
			Thread.sleep(25000); 
			File theNewestFile = null;
			    File dir = new File(System.getProperty("user.home") + "\\Downloads");
			   String y="pdf";
			    //System.out.println("^^^^^^^^^^^^"+y);
			    String ext="pdf";
				FileFilter fileFilter = new WildcardFileFilter("*." + ext);
			    
				File[] files = dir.listFiles(fileFilter);

			    if (files.length > 0) {
			        /** The newest file comes first **/
			    	 //System.out.println("^^^^^^^^^^^^Entered");
			        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			        theNewestFile = files[0];
			        
			    //}
			    
			    System.out.println("The Successfully downloaded file is " + theNewestFile);
			    String E =getFileExtension(theNewestFile);
			    System.out.println("The Successfully extension file is " +  E);
			    //return theNewestFile;
			    if(E.equalsIgnoreCase(ext)){
			    	 System.out.println("Downloaded File Format Matched Successfully."  + "'"+ y +  "' <> '" + E + "'");
			    }
			    else{
			    	
			    	 Assert.fail( "Downloaded File Format is NOT Matched."  +"'" +  y +  "' <> '" + ext + "'");
			    }
			   
			    }
				 Thread.sleep(4500);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
		}
		
		@And("^Verify my series and view tabs in EMIS tab$")
		public void verify_my_series_and_view_tabs_in_EMIS_tab() throws Throwable {
			Thread.sleep(4500); 
			ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500);
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Myseries_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified My Series option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified My Series option in insight preview");
					  }
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("View_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified View option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified View option in insight preview");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(5000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@And("^Verify EMIS insight Edit access$")
		public void verify_EMIS_insight_Edit_access() throws Throwable {
		   
		}
		@And("^Navigate to Focus tab$")
		public void navigate_to_Focus_tab() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab"))).click();
		}

		@And("^Verify Focus insights count on tab header$")
		public void verify_Focus_insights_count_on_tab_header() throws Throwable {
			Thread.sleep(2000);
			List<WebElement> objLinks = login.driver.findElements(By.xpath("//div[@class='insights-grid-row--title']"));
			int Focous_insight_count = objLinks.size();
			System.out.println("Total Insights are- " + Focous_insight_count);
			
			String Listofinsightcountinchinapremium= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chinaPremium_Tab_count"))).getText();
			System.out.println("List of insight count in china premium- " + Listofinsightcountinchinapremium);
			String str = Listofinsightcountinchinapremium;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			int result = Integer.parseInt(Numbers);
			System.out.println(result);
			
			System.out.println(Focous_insight_count +":"+ result);
			 if(Focous_insight_count == result   ) 
			 {
				 System.out.println("Focous Insights count on tab header is Verified Succesfully");
			  }
			 else
			 {
				  Assert.fail("Focous Insights count on tab header is NOT Verified Succesfully");
			  }
			
		}
		@And("^Verify Focus dropdown$")
		public void verify_Focus_dropdown() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab"))).click();
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Emis_Dropdown"))).size() != 0)
			{
				System.out.println("Focus Drop Down is Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Focus Drop Down is Not Verified Successfully"); 
		  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		
		}
		@And("^Select any indicators from Focus dropdown$")
		public void select_any_indicators_from_Focus_dropdown() throws Throwable {
			Thread.sleep(2000);
			String ListofinsightcountinFocus= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab_C"))).getText();
			System.out.println("List of insight count in Focus- " + ListofinsightcountinFocus);
			String str = ListofinsightcountinFocus;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			Focusinsightresult = Integer.parseInt(Numbers);
			System.out.println(Focusinsightresult);
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Indicater_Focus"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applaybtninfilter"))).click();
			Thread.sleep(2000);
		}
		@And("^Verify Apply Indicators filters in Focus tab$")
		public void verify_Apply_Indicators_filters_in_Focus_tab() throws Throwable {
			Thread.sleep(2000);
			String ListofinsightcountinFocus= login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Focus_Tab_C_After_Filter"))).getText();
			System.out.println("List of insight count in Focus- " + ListofinsightcountinFocus);
			String str = ListofinsightcountinFocus;
			String Numbers;
			Numbers = str.replaceAll("[^0-9]", "");
			int FocusinsightresultAfterfilter = Integer.parseInt(Numbers);
			System.out.println(FocusinsightresultAfterfilter);
			 if(Focusinsightresult != FocusinsightresultAfterfilter   ) 
			 {
				 System.out.println("Apply Indicators filters is Verified Succesfully");
			  }
			 else
			 {
				  Assert.fail("Apply Indicators filters is NOT Verified Succesfully");
			  }
			 Thread.sleep(2000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_in_Focus_tab"))).click();
		}
		@And("^Select any Indicators from Focus dropdown$")
		public void select_any_Indicators_from_Focus_dropdown() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab"))).click();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applay_Indicater_Focus"))).click();
			Thread.sleep(2000);
			String IndicatorinFocus = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FirstindicatorName_in_Focus_Tab"))).getText();
			 System.out.println( IndicatorinFocus);
			 String Numbers;
				Numbers = IndicatorinFocus.replaceAll("[^0-9]", "");
				Result_IndicatorinFocus = Integer.parseInt(Numbers);
				System.out.println(Result_IndicatorinFocus);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applaybtninfilter"))).click();
			
		}

		@And("^Verify Clear All functionality in Focus tab$")
		public void verify_Clear_All_functionality_in_Focus_tab() throws Throwable {
			Thread.sleep(2000);
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Remove_icon_in_Focus_tab"))).size() != 0)
			{
				System.out.println("Clear All functionality in Focus tab is Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Clear All functionality in Focus tab is Not Verified Successfully"); 
		  }
			 Thread.sleep(5000);
			 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Remove_icon_in_Focus_tab"))).click();
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@And("^Verify number of insights for indicators in Focus tab$")
		public void verify_number_of_insights_for_indicators_in_Focus_tab() throws Throwable {
			String FocustabCount = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Focus_Tab_C_After_Filter"))).getText();
			 System.out.println( FocustabCount);
			 String Numbers;
				Numbers = FocustabCount.replaceAll("[^0-9]", "");
				int result = Integer.parseInt(Numbers);
				System.out.println(result);
				System.out.println(  result +":"+ Result_IndicatorinFocus);
				if(result == Result_IndicatorinFocus){
					System.out.println("Displayed insights count be matched with the indicator count");
				}
				else
				  {
					  Assert.fail("Displayed insights count mismatched with the indicator count"); 
				  }
		}
		
		@And("^Share for Focus tab$")
		public void share_for_Focus_tab() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Disable_shared_icon"))).size() != 0)
			{
				System.out.println("Share for Focus tab Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Share for Focus tab is Not Verified Successfully"); 
		  }
		}
		
		@And("^Verify Add Focus insights to favorite$")
		public void verify_Add_Focus_insights_to_favorite() throws Throwable {
			String FavouriteInsightinanlyticstab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_Tab_inLandingPage"))).click();
			Thread.sleep(2000);
			String FavouriteInsightinFavoritetab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			System.out.println(  FavouriteInsightinanlyticstab +":"+ FavouriteInsightinFavoritetab);
			 if(FavouriteInsightinanlyticstab.equalsIgnoreCase(FavouriteInsightinFavoritetab)){
				 
				  System.out.println("Favorite Functionality in Focus is working Successfully");
				  navigate_to_Analytics_tab();
				  }
			 else
				  {
					  Assert.fail("Favorite Functionality in Focus is NOT working Successfully"); 
					  navigate_to_Analytics_tab();
				  }
		}
		@And("^Verify Download in view mode of Focus tab$")
		public void verify_Download_in_view_mode_of_Focus_tab() throws Throwable {
			Thread.sleep(25000); 
			File theNewestFile = null;
			    File dir = new File(System.getProperty("user.home") + "\\Downloads");
			   String y="pdf";
			    String ext="pdf";
				FileFilter fileFilter = new WildcardFileFilter("*." + ext);
			    
				File[] files = dir.listFiles(fileFilter);

			    if (files.length > 0) {
			        /** The newest file comes first **/
			        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			        theNewestFile = files[0];	    
			    System.out.println("The Successfully downloaded file is " + theNewestFile);
			    String E =getFileExtension(theNewestFile);
			    System.out.println("The Successfully extension file is " +  E);
			    if(E.equalsIgnoreCase(ext)){
			    	 System.out.println("Downloaded File Format Matched Successfully."  + "'"+ y +  "' <> '" + E + "'");
			    }
			    else{
			    	
			    	 Assert.fail( "Downloaded File Format is NOT Matched."  +"'" +  y +  "' <> '" + ext + "'");
			    }
			   
			    }
			    Thread.sleep(25000); 
			    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("insight_preview_close"))).click();
			    Thread.sleep(25000); 
			    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}

		@And("^Verify my series and view tabs in Focus tab$")
			public void verify_my_series_and_view_tabs_in_Focus_tab() throws Throwable {
			Thread.sleep(7500); 
			verify_my_series_and_view_tabs_in_Sentix_tab();
}
		@And("^Verify Focus tab Edit access$")
		public void verify_Focus_tab_Edit_access() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]")).click();
			Thread.sleep(5500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]"));
			action.contextClick(AddTag).build().perform();
			Thread.sleep(5500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Right_click_options"))).size() == 0)
				{
					System.out.println("Successfully verified Focus tab Edit access");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Focus tab Edit access");
				  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Share for WPIC Platinum Quaterly$")
		public void share_for_WPIC_Platinum_Quaterly() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Disable_shared_icon"))).size() != 0)
			{
				System.out.println("Share for WPIC Platinum Quaterly Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Share for WPIC Platinum Quaterly is Not Verified Successfully"); 
		  }
		}
		@And("^Navigate to WPIC tab$")
		public void navigate_to_WPIC_tab() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("WPIC_Tab"))).click();
		}

		@And("^Verify Add WPIC Platinum Quaterly insights to favorite$")
		public void verify_Add_WPIC_Platinum_Quaterly_insights_to_favorite() throws Throwable {
			Thread.sleep(2000);
			String FavouriteInsightinanlyticstab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_Tab_inLandingPage"))).click();
			Thread.sleep(2000);
			String FavouriteInsightinFavoritetab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			System.out.println(  FavouriteInsightinanlyticstab +":"+ FavouriteInsightinFavoritetab);
			 if(FavouriteInsightinanlyticstab.equalsIgnoreCase(FavouriteInsightinFavoritetab)){
				 
				  System.out.println("Favorite Functionality in WPIC is working Successfully");
				  navigate_to_Analytics_tab();
				  }
			 else
				  {
					  Assert.fail("Favorite Functionality in WPIC is NOT working Successfully"); 
					  navigate_to_Analytics_tab();
				  }
		}
		@And("^Verify Download in view mode of  WPIC$")
		public void verify_Download_in_view_mode_of_WPIC() throws Throwable {
			Thread.sleep(25000); 
			File theNewestFile = null;
			    File dir = new File(System.getProperty("user.home") + "\\Downloads");
			   String y="xlsx";
			    String ext="xlsx";
				FileFilter fileFilter = new WildcardFileFilter("*." + ext);
				File[] files = dir.listFiles(fileFilter);
			    if (files.length > 0) {
			        /** The newest file comes first **/
			        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			        theNewestFile = files[0];
			    System.out.println("The Successfully downloaded file is " + theNewestFile);
			    String E =getFileExtension(theNewestFile);
			    System.out.println("The Successfully extension file is " +  E);
			    //return theNewestFile;
			    if(E.equalsIgnoreCase(ext)){
			    	 System.out.println("Downloaded File Format Matched Successfully."  + "'"+ y +  "' <> '" + E + "'");
			    }
			    else{
			    	
			    	 Assert.fail( "Downloaded File Format is NOT Matched."  +"'" +  y +  "' <> '" + ext + "'");
			    }
			   
			    }
				 Thread.sleep(4500);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
		}
		@And("^Verify my series and view tabs in WPIC\\.$")
		public void verify_my_series_and_view_tabs_in_WPIC() throws Throwable {
			Thread.sleep(4500); 
			ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500);
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Myseries_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified My Series option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified My Series option in insight preview");
					  }
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("View_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified View option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified View option in insight preview");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(5000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@And("^Verify WPIC insight Edit access$")
		public void verify_WPIC_insight_Edit_access() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]")).click();
			Thread.sleep(5500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]"));
			action.contextClick(AddTag).build().perform();
			Thread.sleep(5500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Right_click_options"))).size() == 0)
				{
					System.out.println("Successfully verified Sentix insight Edit access");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Sentix insight Edit access");
				  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Verify my series and view tabs in WPIC tab$")
		public void verify_my_series_and_view_tabs_in_WPIC_tab() throws Throwable {
			Thread.sleep(4500); 
			ArrayList<String> tabs2 = new ArrayList<String> (login.driver.getWindowHandles());
			    login.driver.switchTo().window(tabs2.get(1));
			    Thread.sleep(4500);
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Myseries_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified My Series option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified My Series option in insight preview");
					  }
				 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("View_in_Open"))).size() == 0)
					{
						System.out.println("Successfully verified View option in insight preview");
					}
					 else
					  {
						  Assert.fail("Successfully NOT verified View option in insight preview");
					  }
				  login.driver.close();
				    login.driver.switchTo().window(tabs2.get(0));
				    Thread.sleep(5000);
					login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Verify WPIC Edit access$")
		public void verify_WPIC_Edit_access() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("//*[@id='viewer']/div[1]/div[2]")).click();
			Thread.sleep(5500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]"));
			action.contextClick(AddTag).build().perform();
			Thread.sleep(5500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Right_click_options"))).size() == 0)
				{
					System.out.println("Successfully verified China Premium Data talk insight Edit access");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified China Premium Data talk insight Edit access");
				  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^Navigate to CEIC tab$")
		public void navigate_to_CEIC_tab() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ceicgallery_Tab"))).click();
		}

		@And("^Verify Sub tabs under Analytics$")
		public void verify_Sub_tabs_under_Analytics() throws Throwable {
			Thread.sleep(2000);
			if(login.driver.findElements(By.xpath("//div[@class='insights-groups']/div[3]")).size() != 0)
			{
			WebElement Favorite_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("chinaPremium_Tab")));
			  Assert.assertEquals(true,Favorite_Tab_inLandingPage.isDisplayed());
			  Thread.sleep(500);
			 WebElement MyInsight_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("ceicgallery_Tab")));
			  Assert.assertEquals(true,MyInsight_Tab_inLandingPage.isDisplayed());
			  Thread.sleep(500);
			  WebElement Analytics_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("FocusEconomics_Tab")));
			  Assert.assertEquals(true,Analytics_Tab_inLandingPage.isDisplayed());
			  Thread.sleep(500);
			  WebElement SharedInsight_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Sentix_Tab")));
			  Assert.assertEquals(true,SharedInsight_Tab_inLandingPage.isDisplayed());
			  Thread.sleep(500);
			  WebElement Recent_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("WPIC_Tab")));
			  Assert.assertEquals(true,Recent_Tab_inLandingPage.isDisplayed());
			  Thread.sleep(500);
			  WebElement All_Tab_inLandingPage = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("EMIS_Tab")));
			  Assert.assertEquals(true,All_Tab_inLandingPage.isDisplayed());
			 
			}
			else
			{
					  Assert.fail("Sub Tabs present under Analytics is NOT Verified Successfully!!!"); 
			}
		}
		@And("^Select CEIC Gallery dropdown$")
		public void select_CEIC_Gallery_dropdown() throws Throwable {
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ceic_gallery_dropdown"))).click();
		}

		@And("^Verify CEIC Gallery dropdown$")
		public void verify_CEIC_Gallery_dropdown() throws Throwable {
			Thread.sleep(5000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Drop_down_list_ceic_gallery"))).size() != 0)
				{
					System.out.println("Successfully verified CEIC Gallery dropdown");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified CEIC Gallery dropdown");
				  }
			
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Ceic_gallery_dropdown_hide"))).click();
		}
		
		@And("^select any filter from dropdown$")
		public void select_any_filter_from_dropdown() throws Throwable {
			Thread.sleep(20500);
			login.driver.findElement(By.xpath("//div[@class='select-field-options-container-wrapper']/div/div[1]/table/tr[1]/td[1]/*[1]/*[1]")).click();
			//login.driver.findElement(By.cssSelector("body > div.main-content.no-touch-device > div.select-field-options-container.dropdown-series-filter-frequency.multiselect > div.select-field-options-container-wrapper > div > div.select-field-options-container-list-wrapper > table > tr:nth-child(1) > td.count-select-item-title > svg > use").click();
			Thread.sleep(5000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Applaybtninfilter"))).click();
                   
		}

		@And("^Verify categories filters in CEIC tab is applied Successfully$")
		public void verify_categories_filters_in_CEIC_tab_is_applied_Successfully() throws Throwable {
			 Thread.sleep(4500);
			 Actions action = new Actions(login.driver);
				WebElement RightclickonInsight = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a"));
				action.contextClick(RightclickonInsight).build().perform();
				 Thread.sleep(2500);
				login.driver.findElement(By.xpath("//ul[@class='dropdown-menu context-menu '] /div[3]/li[2]")).click();
				 Thread.sleep(3500);
					login.driver.findElement(By.xpath("//div[@class='header-menu-file header-menu-item']")).click();
			    Thread.sleep(3500);
			    login.driver.findElement(By.xpath("	//div[@class='header-menu-item--dropdown']/div[10]")).click();
			    Thread.sleep(4500);
				  WebElement Hot_tpoics = login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Hot_tpoics")));
					 login.Log4j.info("Is 'Hot_tpoics' Displayed? - True/False:: " + Hot_tpoics.isDisplayed());
					  Assert.assertEquals(true,Hot_tpoics.isDisplayed());
					  Thread.sleep(4500);
					    login.driver.findElement(By.xpath("//div[@class='insight-settings-general']/div[4]/div/div/a/span[2]/b")).click();
					    Thread.sleep(4500);
					    login.driver.findElement(By.xpath("//ul[@class='select2-results']/li[1]/div/div[2]")).click();
					    Thread.sleep(4500);
					    login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Savebuttoninshared"))).click();
					  Thread.sleep(2500);
					  login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		@And("^select Multiple filter from dropdown$")
		public void select_Multiple_filter_from_dropdown() throws Throwable {
		    
		}

		@And("^Verify categories for Multi\\[le filters in CEIC tab is applied Successfully$")
		public void verify_categories_for_Multi_le_filters_in_CEIC_tab_is_applied_Successfully() throws Throwable {
		    
		}
		
		@And("^Verify Share for CEIC$")
		public void verify_Share_for_CEIC() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Disable_shared_icon"))).size() != 0)
			{
				System.out.println("Share for CEIC Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Share for CEIC is Not Verified Successfully"); 
		  }
		}
		@And("^verify favorite functionality in CEIC$")
		public void verify_favorite_functionality_in_CEIC() throws Throwable {
			Thread.sleep(2000);
			String FavouriteInsightinanlyticstab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("Favorite_Tab_inLandingPage"))).click();
			Thread.sleep(2000);
			String FavouriteInsightinFavoritetab = login.driver.findElement(By.xpath("//div[@class='insights-grid-body']/div[1]/div[2]/div/a")).getText();
			Thread.sleep(2000);
			System.out.println(  FavouriteInsightinanlyticstab +":"+ FavouriteInsightinFavoritetab);
			 if(FavouriteInsightinanlyticstab.equalsIgnoreCase(FavouriteInsightinFavoritetab)){
				 
				  System.out.println("Favorite Functionality in China Premium Data talk is working Successfully");
				  navigate_to_Analytics_tab();
				  }
			 else
				  {
					  Assert.fail("Favorite Functionality in China Premium Data talk is NOT working Successfully"); 
					  navigate_to_Analytics_tab();
				  }
		}
		@And("^Verify Download in view mode of CEIC tab$")
		public void verify_Download_in_view_mode_of_CEIC_tab() throws Throwable {
			Thread.sleep(5000);  
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("btnDownloadinpopup"))).click();
			Thread.sleep(25000); 
			File theNewestFile = null;
			    File dir = new File(System.getProperty("user.home") + "\\Downloads");
			   String y="xlsx";
			    String ext="xlsx";
				FileFilter fileFilter = new WildcardFileFilter("*." + ext);
			  
				File[] files = dir.listFiles(fileFilter);

			    if (files.length > 0) {
			        /** The newest file comes first **/
			        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			        theNewestFile = files[0];
			    System.out.println("The Successfully downloaded file is " + theNewestFile);
			    String E =getFileExtension(theNewestFile);
			    System.out.println("The Successfully extension file is " +  E);
			    //return theNewestFile;
			    if(E.equalsIgnoreCase(ext)){
			    	 System.out.println("Downloaded File Format Matched Successfully."  + "'"+ y +  "' <> '" + E + "'");
			    }
			    else{
			    	
			    	 Assert.fail( "Downloaded File Format is NOT Matched."  +"'" +  y +  "' <> '" + ext + "'");
			    }
			   
			    }
				 Thread.sleep(4500);
				 login.driver.findElement(By.xpath(login.LOCATORS.getProperty("closebuttoninpreview"))).click();
		}
		@And("^Verify CEIC insight Edit access$")
		public void verify_CEIC_insight_Edit_access() throws Throwable {
			Thread.sleep(5500);
			login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]")).click();
			Thread.sleep(5500);
			Actions action = new Actions(login.driver);
			WebElement AddTag = login.driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div[1]/div/div[2]"));
			action.contextClick(AddTag).build().perform();
			Thread.sleep(5500);
			 if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Right_click_options"))).size() != 0)
				{
					System.out.println("Successfully verified China Premium Data talk insight Edit access");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified China Premium Data talk insight Edit access");
				  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@And("^Navigate to Shared tab$")
		public void navigate_to_Shared_tab() throws Throwable {
			Thread.sleep(2000);
			login.driver.findElement(By.xpath(login.LOCATORS.getProperty("SharedInsight_Tab_inLandingPage"))).click();
		}

		@And("^Verify Insight in shared Tab$")
		public void verify_Insight_in_shared_Tab() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Firstinsight"))).size() != 0)
				{
					System.out.println("Successfully verified Insight in Shared Tab");
				}
				 else
				  {
					  Assert.fail("Successfully NOT verified Insight in Shared Tab");
				  }
			 Thread.sleep(5000);
				login.driver.findElement(By.xpath(login.LOCATORS.getProperty("CEIC_Logo"))).click();
		}
		
		@And("^Verify Share icon in shared Tab$")
		public void verify_Share_icon_in_shared_Tab() throws Throwable {
			Thread.sleep(2000); 
			if( login.driver.findElements(By.xpath(login.LOCATORS.getProperty("Disable_shared_icon"))).size() != 0)
			{
				System.out.println("Share icon in shared Tab Verified Successfully");
		        
		  }
			else
		  {
			  Assert.fail("Share icon in shared Tab is Not Verified Successfully"); 
		  }
		}
} 

