Feature: SeriesTab

Background:
 	Given User has successful logged in
 
#@SeriesTab 
#Scenario: TC_SeriesTab_01:Verify "All Insights" option
#When Click on "All insights" 
#Then The "Insight Explorer" popup should be appeared
#
#@SeriesTab 
#Scenario: TC_SeriesTab_02:Verify indicator filter  for series tab
#And Select indicator "Transport" as "Freight Traffic"
#And Select indicator "Tourism" as "Tourism Statistics"
#When Click on "Apply filter"
#Then Result should be displayed as per selection
#
#@SeriesTab 
#Scenario: TC_SeriesTab_03:Verify Reset option  for series tab
#Given User enters "GDP" 
#And   User selects "Source" as "World Bank"
#And   User has clicked on "Apply filter"
#When Click on "Reset"
#Then Selected options should be reset to default
#
#@SeriesTab
#Scenario: TC_SeriesTab_04:Verify series count for search
#Given User enters keyword "gdp" 
#Then Series count should be matched with displayed result
#
#@SeriesTab	
#Scenario: TC_SeriesTab_05:Verifying "Unselect all" option for series level
#Given User enters seriesID "146381801;1380601;245178303" 
#When User right click on any series
#Then User can able to see "Unselect all" option from dropdown menu
#
#@SeriesTab 
#Scenario: TC_SeriesTab_06:Verifying "Copy" option for series level
#Given User enters seriesID "1380601;245178303" 
#When User right click on any series
#Then User can able to see "Copy" option from dropdown menu
#
#@SeriesTab
#Scenario: TC_SeriesTab_07:Verifying "Copy data" option for series level
#Given User enters seriesID "146381801;228912101" 
#When User right click on any series
#Then User can able to see "Copy data" option from dropdown menu
#
#@SeriesTab
#Scenario: TC_SeriesTab_08:Verifying "Series Info" option for series level
#Given User enters seriesID "261975301;237211603" 
#When User right click on any series
#Then User can able to see "Series Info" option from dropdown menu
#
#@SeriesTab
#Scenario: TC_SeriesTab_09:Verifying "View as Chart" option for series level
#Given User enters seriesID "357567097;357567537" 
#When User right click on any series
#Then User can able to see "View as Chart" option from dropdown menu
#
#@SeriesTab
#Scenario: TC_SeriesTab_10:Verifying "View as Map" option for series level
#Given User enters seriesID "357567757;375404477" 
#When User right click on any series
#Then User can able to see "View as Map" option from dropdown menu
#
#@SeriesTab
#Scenario: TC_SeriesTab_11:Verifying "View as Table" option for series level
#Given User enters seriesID "359084467;241769403" 
#When User right click on any series
#Then User can able to see "View as Table" option from dropdown menu
#
#@SeriesTab
#Scenario: TC_SeriesTab_12:Verifying "Download" option for series level
#Given User enters seriesID "268193601;69326701" 
#When User right click on any series
#Then User can able to see "Download" option from dropdown menu
#
#@SeriesTab 
#Scenario: TC_SeriesTab_13:Verifying "Footnotes" option for series level
#Given User enters seriesID "354673701;354674001" 
#When User right click on any series
#Then User can able to see "Footnotes" option from dropdown menu
#
#@SeriesTab 
#Scenario: TC_SeriesTab_14:Verifying "Copy link(s)" option for series level
#Given User enters seriesID "298772102" 
#When User right click on any series
#Then User can able to see "Copy link(s)" option from dropdown menu
#
#@SeriesTab
#Scenario: TC_SeriesTab_15:Verifying "Copy link(s)" option for series level
#Given User enters seriesID "322968702;213834902" 
#When User right click on any series
#Then User can able to see "Copy link(s)" option from dropdown menu
#
#@SeriesTab 
#Scenario: TC_SeriesTab_16:Verifying "Show Dataset" option for series level
#Given User enters seriesID "258074801;406097377" 
#When User right click on any series
#Then User can able to see "Show Dataset" option from dropdown menu
#
#@SeriesTab 
#Scenario: TC_SeriesTab_17:Verifying "Show Database" option for series level
#Given User enters seriesID "5823601;5793201(CIUA)" 
#When User right click on any series
#Then User can able to see "Show Database" option from dropdown menu
#
#@SeriesTab 
#Scenario: TC_SeriesTab_18:Verifying SSP for series
#Given User enters "GDP" 
#When Click on (i) icon
#Then SSP window should be displayed
#
#@SeriesTab
#Scenario: TC_SeriesTab_19:Verifying "key only" filter for series tab
#Given User enters keyword "GCF"
#And   User has selects "More" as "Key only"
#When  Click on "Apply filter"
#Then  User verify corresponding results for selected filter
#
#@SeriesTab
#Scenario: TC_SeriesTab_20:Verifying "with release schedule" filter for series tab
#Given User enters "FDI"
#And   User has selects "More" as "With release schedule"
#When  Click on "Apply filter"
#Then  User verify corresponding results for selected filter
#
#@SeriesTab
#Scenario: TC_SeriesTab_21:Verifying "with suggestions for rebased/discontinued series " filter for series tab
#Given User enters "PSI"
#And   User has selects "More" as "With suggestions for rebased/discontinued series"
#When  Click on "Apply filter"
#Then  User verify corresponding results for selected filter
#
@SeriesTab
Scenario: TC_SeriesTab_22:Verifying "Forecast" filter for series tab
Given User enters "FDI"
And   User has selects "More" as "Forecast"
When  Click on "Apply filter"
Then  User verify corresponding results for selected filter

@SeriesTab
Scenario: TC_SeriesTab_23:Verify 'Mouse over' icons for series level
Given User enters "5724301"
When  User Mouse hover on series
Then  Selected icons should be available when mouse hovered





