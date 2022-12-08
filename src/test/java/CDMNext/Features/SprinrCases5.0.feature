Feature: Verifying sprintcases 5.0

  @Sprintcases5.0
  Scenario: TC_10205_01 : Verify moving insights from one folder to another folder
    And Navigate to "My insights"
    And Open insights in table mode
    And Open Myfolders panel
    And Mouse hover on any insight
    And Drag and drop the insight to the targeted folder
    Then The insight should be moved to the targetted folder

  @Sprintcases5.0
  Scenario: TC_10205_02 : Verify growl message after moved insight
    And Navigate to "My insights"
    And Open insights in table mode
    And Open Myfolders panel
    And Mouse hover on any insight
    And Drag and drop the insight to the targeted folder
    Then Growl popup should be displayed

  @Sprintcases5.0
  Scenario: TC_19693_01 : Verify tooltip for move icon on insights
    And Navigate to "My insights"
    And Open insights in table mode
    And Open Myfolders panel
    And Mouse hover on any insight
    Then The tooltip should be "Drag-and-drop the insight to a folder to move it there"

  @Sprintcases5.0
  Scenario: TC_7475_01:Verify disabled right-click options for Attachments
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Right click on visual header
    Then "Copy attachments", "Cut attachments" ,"Attachments", "View" options should be greyed out

  #@Sprintcases5.0.... removed on 5.5.0_rc.5
  #Scenario: TC_12501_01:Verify keyboard shortcut info for visuals under SSP
  #And Add few series to myseries
  #And Open SSP window
  #And Click on "View as" tab
  #Then The keyboard shortcut info should be displayed for Chart "(C)", Map "(M)" and Table "(T)"
  @Sprintcases5.0
  Scenario: TC_17399_01:Verify growl message when add visual to new insight
    And Create a pie visual with series id's "16240301;16243001"
    And Click on + icon on header
    And Click on "Add to new insight"
    Then "New insight with the selected visual created" and "Go to new insight" confirmation message should be displayed

  @Sprintcases5.0
  Scenario: TC_19489_02:Verify Data Briefings panel from next login after once closed
    And Open Data Briefings panel
    And Close Data briefings panel
    And Logout and relogin
    Then The DB panel should be in closed state

  @Sprintcases5.0
  Scenario: TC_19489_05:Verify clicking on Data Briefings
    And Click on any Data Briefings
    Then The specific Data Briefings should open in preview mode

  @Sprintcases5.0
  Scenario: TC_19489_06:Verify the name of every Data Briefings when opened in preview mode.
    And Click on any Data Briefings
    Then The window header should be "Data Briefing"

  @Sprintcases5.0
  Scenario: TC_19489_08:Verify Next button
    And Open any Data Briefings
    And Click on "Next" button
    Then Next Data Briefings should open in the same preview window

  @Sprintcases5.0
  Scenario: TC_19489_09:Verify previous button
    And Open any Data Briefings
    And Click on "Previous" button
    Then The previous Data Briefings should open in the same preview window

  @Sprintcases5.0
  Scenario: TC_19489_10:Verify opening SSP for Data Briefings
    And Click on any Data Briefings
    And Click on series below the visual
    Then The SSP window should open

  @Sprintcases5.0
  Scenario: TC_19489_11:Verify Download button
    And Click on any Data Briefings
    And Click on download
    Then The download popup should open for available series in the DB insight

  @Sprintcases5.0
  Scenario: TC_19489_12:Verify CTC for DB
    And Click on any Data Briefings
    And Click on download
    And Click on "Copy to Clipboard"
    Then The data should be copied to clipboard

  @Sprintcases5.0
  Scenario: TC_19489_12:Verify Download for DB
    And Click on any Data Briefings
    And Click on download
    And Click on "Download" button in download window
    Then The Data should be downloaded

  @Sprintcases5.0
  Scenario: TC_19489_13:Verify copy link
    And Click on any Data Briefings
    And Click on "Copy link" icon
    Then The insight link should be copied and growl should be displayed

  @Sprintcases5.0
  Scenario: TC_19489_14:Validate copied link by pasting in the browser
    And Click on any Data Briefings
    And Click on "Copy link" icon
    And Paste link in browser
    Then The Data Briefings should open in the preview mode

  @Sprintcases5.0
  Scenario: TC_19489_15:Verify minimize button
    And Click on any Data Briefings
    And Click on "Minimize" option
    Then The Popup should be minimized

  @Sprintcases5.0
  Scenario: TC_19489_15:Verify exit full screen
    And Click on any Data Briefings
    And Click on "Exit full-screen" option
    Then The popup should be displayed in normal screen

  @Sprintcases5.0
  Scenario: TC_19489_15:Verify exit full screen
    And Click on any Data Briefings
    And Click on Cancel button
    Then The rename popup should be closed

  @Sprintcases5.0
  Scenario: TC_19491_01:Verify 'Related Data Briefings' section.
    And Click on second Data Briefings
    And Scroll down till end
    Then Atleast two sections should be displayed if the Data Briefings not related

  @Sprintcases5.0
  Scenario: TC_19491_02:Verify Data Briefings in SSP
    And Click on second Data Briefings
    And Scroll down till end
    Then Should display 3 links in each section

  @Sprintcases5.0
  Scenario: TC_19490_01:Verify 'Related Data Briefings' section
    And Click on second Data Briefings
    And Open SSP for series linked with Data Briefings
    Then The related Data Briefings insight's information should available in the SSP of specific series

  @Sprintcases5.0
  Scenario: TC_19490_02:Verify opening Data Briefings from SSP
    And Click on second Data Briefings
    And Open SSP for series linked with Data Briefings
    And Click on the Data Briefings name
    Then The related Data Briefings insight should be opened

  @Sprintcases5.0
  Scenario: TC_19490_03:Verify clicking on read more on SSP in DB section
    And Click on second Data Briefings
    And Open SSP for series linked with Data Briefings
    And Click on "Read more" below the Data Briefings name
    Then The related Data Briefings insight should be opened

  @Sprintcases5.0
  Scenario: TC_19924_01:Verify tooltip for Download and copy link icons
    And Click on second Data Briefings
    And Mouse hover on Download icon
    Then The tooltip should be displayed as "Download. Type `d`"
    And Mouse hover on Copylink icon
    Then The tooltip should be displayed as "Copy link"

  @Sprintcases5.0
  Scenario: TC_19974_01:Verify sort by options
    And Open Data Briefings panel
    And Open the dropdown for sort by
    Then The following three sorting options should available in the dropdown
      | Top Releases     |
      | Popularity       |
      | Recently Updated |

  @Sprintcases5.0
  Scenario: TC_19491_03:Verify Related insights section
    And Search for the series with SID "414412197"
    And Add the series to my series tab and create a new insight
    And Open Data briefings
    Then Your insight should be listed under related insight section

  @Sprintcases5.0
  Scenario: TC_19494_01:Verify Data Briefings pane for Data and Release tab
    And Open "Data" tab
    Then The "Data Briefings" panel should be displayed
    And Open "Releases" tab
    Then The "Data Briefings" panel should be shown

  @Sprintcases5.0
  Scenario: TC_19494_02:Verify search for Data Briefings
    And Search for a series id
    Then The series id should display in Data briefings ssp window

  @Sprintcases5.0
  Scenario: TC_19494_02:Verify search for Data Briefings
    And Search for a Data briefings title
    Then The Data briefings title should displayed

  @Sprintcases5.0
  Scenario: TC_19494_03:Verify applying filters for Data Briefings
    And User selects "All Regions" as "Albania"
    And User has clicked on "Apply filter"
    Then The filters should be matched against Data Briefings's series if there

  @Sprintcases5.0
  Scenario: TC_19974_02:Verify Top releases selection
    And Select "Top Releases" option from "Sort By" dropdown
    Then The Data Briefings should displayed in the Top releases

  @Sprintcases5.0
  Scenario: TC_19974_03:Verify Popularity selection
    And Select "Popularity" option from "Sort By" dropdown
    Then The Data Briefings should displayed in the Popularity list

  @Sprintcases5.0
  Scenario: TC_19974_04:Verify Recently updated selection
    And Select "Recently Updated" option from "Sort By" dropdown
    Then The Recently updated Data Briefings should be displayed in the top

  @Sprintcases5.0
  Scenario: TC_19974_08:Verify the sort by options by switching between data tabs
    And Select "Recently Updated" option from "Sort By" dropdown
    And Switch from Data tab to Releases tab
    Then The sort by filter should be retained

  @Sprintcases5.0
  Scenario: TC_19974_07:Verify last applied sorting per user
    And Select "Recently Updated" option from "Sort By" dropdown
    And Relogin to CDMNext application
    Then The last applied sorting should be saved per user

  @Sprintcases5.0
  Scenario: TC_19820_02:Verify 'Create a chart with series' option check for Data Briefings download.
    And Click on any Data Briefings
    And Click on download
    Then The check box for 'Create a chart with serees' should be checked for each download by default

  @Sprintcases5.0
  Scenario: TC_19973_01:Verify if no result match under Data Briefings
    And Search with invalid keyword
    Then The "Sorry, no results were found here..." message should displayed in the panel

  @Sprintcases5.0
  Scenario: TC_19912_01:Verify 'See in databases'in Data Briefings
    And Click on second Data Briefings
    And Click on "See in Database"
    Then The related series should be focused in the Database and the Data Briefings popup should auto closed

  @Sprintcases5.0
  Scenario: TC_19982_01:Verify limited insights for related insights under Data Briefings.
    And Search for a series id
    And Add this series to 7 insights
    And Open Data briefings for the series
    And Count the insights under related insight
    Then The related insight should limit to 6 insights

  @Sprintcases5.0
  Scenario: TC_19831_01: Verify content shown in remarks field under the FAQ(i) option on the SSP window
    Given User enters "210337202"
    And Click on chart option from hover
    And Select "1Y"int the timeframe
    And Switch to a different tab and create a visual
    And Come back to the previous tab and check for the timeframe selection
    Then The selected timeframe should be saved if user switched to some other tabs

  @Sprintcases5.01
  Scenario: TC_52911_7806_01: Verify the visibility of FX icon as number of functions applied on a series  increased
    And Search for the series "454608037"
    And Select a series and apply multiple functions
    Then FX icon will not be disappear

  @Sprintcases5.0
  Scenario: TC_52911_17373_01: Verify the growl message when user add a series to a watchlist
    Given User enters "5823501"
    And Mouse hover on the series name
    And Click on "Add to watchlist"
    And Select any check box in that popup
    And Click on "Apply" button
    Then Message "Watchlist changes applied" will be appears and series will be added to the watchlist

  @Sprintcases5.0
  Scenario: TC_52911_17373_01: Verify the growl message when user add a series to a watchlist
    Given User enters "370045687;238290003"
    And Add the series to my series tab
    And Select the series from my series tab
    And Select the currency conversion function
    #And Apply the function
    Then The function cannot be applied to series should be displayed along with series name and "Continue with other series?" will be  appear

  @Sprintcases5.0
  Scenario: TC_10653_09 :Search - Invalid search results in Databases,Comparables tabs
    Given User enters keyword "automobile"
    Then Compare the results in database tab and comparables tab

  @Sprintcases5.0
  Scenario: TC_10425_11 : Modify the alert message 'Visual Copied.' for CTC icon
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Copy" icon
    Then "Pie with series copied." and "More options" confirmation message should be displayed
    And Click on Download icon
    And Click on "Copy to Clipboard"
    Then "Pie with series copied." and "More options" confirmation message should be displayed

  @Sprintcases5.0
  Scenario: TC_14850_12: Series Id/SR Code/Mnemonic Search doesn't expand db tree results to the Series level
    Given User enters Mnemonic "AE.AP.NMVA.AED-TH-A"
    Then Should be able to display tree mode for serached particular series

  @Sprintcases5.0
  Scenario: TC_20063_16:Reword "See in Tree" -> "See in Database" in Data Briefings
    And Click on any Data Briefings
    Then "See in Database" word must be there instead see in tree

  #@Sprintcases5.0
  #Scenario: TC_16922_13 :Keyword search for AMECO do not yield any results
    #Given User enters keyword "AMECO"
    #Then Should yield results as "AMECO" on table level under database tab

  @Sprintcases5.0
  Scenario: TC_19072_01 :Remove (c) icon for continuous series in Global Key series DB
    Given User enters "386587787"
    And User has selects "More" as "With historical extension of continuous series"
    And Click on "Apply filter"
    Then "c" icon for series should not be shows for global key series

  @Sprintcases5.0
  Scenario: TC_19929_02 :My series: Right mark for Create new group is not enabled
    And Add some series to my series tab
    And Group any of 2 series from right click options
    And Try to group another series from right click option
    Then Group rename popup should not displayed
    Then Should be able to crate group

  @Sprintcases5.0
  Scenario: TC_4542_06 :Pie: ArimaX13: Unable to recognize series to which arima cannot be applied
    Given User enters "5800701;322641501;447233417"
    And Select the series and create a pie visual
    And Apply visual with "X13ARIMA" from function wizard
    Then Should be able to recognize which series are unable to applied with X13 arima

  @Sprintcases5.0
  Scenario: TC_13657_07 :Calendar dropdown should not be displayed for the series which have 'No data available' for selected country filter visual
    And Create a chart visual with "5823501"
    And Create a pie visual with "28094101;40551701"
    And Create a country filter in the same view
    And Select the filter with "South Korea"
    Then Date picker dropdown should not be available which does not have korea country series

  @Sprintcases5.0
  Scenario Outline: <TCID>: Verifying DB language change in right click
    And Right click on "<database>"
    And "Set language" as "<language>"
    Then The Databases language should be changed to as per the selected language

    Examples: 
      | TCID        | database                   | language |
      | TC_10425_08 | World Trend Plus           | 中文       |
      | TC_10425_08 | Russia Premium Database    | Русский  |
      | TC_10425_08 | Indonesia Premium Database | Bahasa   |

  @Sprintcases5.0
  Scenario: TC_15829_04 :User issue: Products: Content of China premium DB insights in Chinese UI displayed incorrect
    And Change UI to chinese
    And Click on notifications bell icon
    And Click on "India Premium Database" database
    Then Data must be matched with header shown

  @Sprintcases5.0
  Scenario: TC_18392_01:Verify keyboard shortcut for Ctrl+C to copy visual in insight preview mode
    And Create an insight
    And Create a pie visual with series id's "16240301;16243001"
    And Open insight in preview mode
    And Select visual and use Ctrl + C to copy the visual
    Then The visual should be copied
