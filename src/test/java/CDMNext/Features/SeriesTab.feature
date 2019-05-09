Feature: SeriesTab

Background:
 	Given User has successful logged in
	
@SeriesTab1
Scenario: TC_SeriesTab_01:Verify indicator filter  for series tab
And Select indicator "Transport" as "Freight Traffic"
And Select indicator "Tourism" as "Tourism Statistics"
When Click on "Apply filter"
Then Result should be displayed as per selection

@SeriesTab 
Scenario: TC_SeriesTab_02:Verify "All Insights" option
When Click on "All insights" 
Then The "Insight Explorer" popup should be appeared

@SeriesTab 
Scenario: TC_SeriesTab_03:Verify Reset option  for series tab
Given User enters "GDP" 
And   User selects "Source" as "World Bank"
And   User has clicked on "Apply filter"
When Click on "Reset"
Then Selected options should be reset to default

@SeriesTab	
Scenario: TC_SeriesTab_04:Verifying "Unselect all" option for series level
Given User enters seriesID "146381801;1380601;245178303" 
When User right click on any series
Then User can able to see "Unselect all" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_05:Verify series count for search
Given User enters keyword "gdp" 
Then Series count should be matched with displayed result

@SeriesTab 
Scenario: TC_SeriesTab_06:Verifying "Copy" option for series level
Given User enters seriesID "1380601;245178303" 
When User right click on any series
Then User can able to see "Copy" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_07:Verifying "Copy data" option for series level
Given User enters seriesID "146381801;228912101" 
When User right click on any series
Then User can able to see "Copy data" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_08:Verifying "Series Info" option for series level
Given User enters seriesID "261975301;237211603" 
When User right click on any series
Then User can able to see "Series Info" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_09:Verifying "View as Chart" option for series level
Given User enters seriesID "357567097;357567537" 
When User right click on any series
Then User can able to see "View as Chart" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_10:Verifying "View as Map" option for series level
Given User enters seriesID "7872901;7874601" 
When User right click on any series
Then User can able to see "View as Map" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_11:Verifying "View as Table" option for series level
Given User enters seriesID "7872901;7874601" 
When User right click on any series
Then User can able to see "View as Table" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_12:Verifying "Download" option for series level
Given User enters seriesID "268193601;69326701" 
When User right click on any series
Then User can able to see "Download" option from dropdown menu

@SeriesTab 
Scenario: TC_SeriesTab_13:Verifying "Footnotes" option for series level
Given User enters seriesID "354673701;354674001" 
When User right click on any series
Then User can able to see "Footnotes" option from dropdown menu

@SeriesTab 
Scenario: TC_SeriesTab_14:Verifying "Copy link(s)" option for series level
Given User enters seriesID "3640701" 
When User right click on any series
Then User can able to see "Copy link(s)" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_15:Verifying "Copy link(s)" option for series level
Given User enters seriesID "322968702;213834902" 
When User right click on any series
Then User can able to see "Copy link(s)" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_16:Verifying "Show Dataset" option for series level
Given User enters seriesID "258074801;406097377" 
When User right click on any series
Then User can able to see "Show Dataset" option from dropdown menu

@SeriesTab 
Scenario: TC_SeriesTab_17:Verifying "Show Database" option for series level
Given User enters seriesID "5823601;5793201(CIUA)" 
When User right click on any series
Then User can able to see "Show Database" option from dropdown menu

@SeriesTab
Scenario: TC_SeriesTab_18:Verifying SSP for series
Given User enters "GDP" 
When Click on (i) icon
Then SSP window should be displayed

@SeriesTab
Scenario: TC_SeriesTab_19:Verifying "key only" filter for series tab
Given User enters keyword "GCF"
And   User has selects "More" as "Key only"
When  Click on "Apply filter"
Then  User verify corresponding results for selected filter

@SeriesTab
Scenario: TC_SeriesTab_20:Verifying "with release schedule" filter for series tab
Given User enters "FDI"
And   User has selects "More" as "With release schedule"
When  Click on "Apply filter"
Then  User verify corresponding results for selected filter

@SeriesTab
Scenario: TC_SeriesTab_21:Verifying "with suggestions for rebased/discontinued series " filter for series tab
Given User enters "PSI"
And   User has selects "More" as "With suggestions for rebased/discontinued series"
When  Click on "Apply filter"
Then  User verify corresponding results for selected filter

@SeriesTab
Scenario: TC_SeriesTab_22:Verifying "Forecast" filter for series tab
Given User enters "FDI"
And   User has selects "More" as "Forecast"
When  Click on "Apply filter"
Then  User verify corresponding results for selected filter

@SeriesTab
Scenario: TC_SeriesTab_23:Verify 'Mouse over' icons for series level
Given User enters "5724301"
When User Mouse hover on "Show Database" icon
Then User can selects "Global Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_24:Verify 'Mouse over' icons for series level
Given User enters "262498601"
When User Mouse hover on "Show Database" icon
Then User can selects "Global Key Series Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_25:Verify 'Mouse over' icons for series level
Given User enters "5190001"
When User Mouse hover on "Show Database" icon
Then User can selects "China Premium Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_26:Verify 'Mouse over' icons for series level
Given User enters "5823501"
When User Mouse hover on "Show Database" icon
Then User can selects "World Trend Plus"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_27:Verify 'Mouse over' icons for series level
Given User enters "1025401"
When User Mouse hover on "Show Database" icon
Then User can selects "Daily Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_28:Verify 'Mouse over' icons for series level
Given User enters "376239567"
When User Mouse hover on "Show Database" icon
Then User can selects "Brazil Premium Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_29:Verify 'Mouse over' icons for series level
Given User enters "389489677"
When User Mouse hover on "Show Database" icon
Then User can selects "Russia Premium Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_30:Verify 'Mouse over' icons for series level
Given User enters "360724907"
When User Mouse hover on "Show Database" icon
Then User can selects "India Premium Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_31:Verify 'Mouse over' icons for series level
Given User enters "249445301"
When User Mouse hover on "Show Database" icon
Then User can selects "Indonesia Premium Database"
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_32:Verify 'Mouse over' icons for series level
Given User enters "400841827"
When User Mouse hover on "Show Database" icon
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_33:Verify 'Mouse over' icons for series level
Given User enters "122834404"
When User Mouse hover on "Show Database" icon
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_34:Verify 'Mouse over' icons for series level
Given User enters "377030917"
When User Mouse hover on "Show Database" icon
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_35:Verify 'Mouse over' icons for series level
Given User enters "295755902"
When User Mouse hover on "Show Database" icon
Then User can see the selected database in Databases tab 

@SeriesTab
Scenario: TC_SeriesTab_36:Verify 'Mouse over' icons for series level
Given User enters seriesID "371376337"
When User Mouse hover on "View as Chart. Type `c`" icon
Then User can see the Chart Visual in the right pannel  

@SeriesTab
Scenario: TC_SeriesTab_37:Verify 'Add and replace' from dropdown
Given User enters seriesID "5724301;5958801"
And  Click on drop down icon next to +
And  Click on "Add and replace"
Then Highlighted visual series should be replaced new series

@SeriesTab
Scenario: TC_SeriesTab_38:Verify 'Mouse over' icons for series level
Given User enters seriesID "368921927"
When User Mouse hover on "Open footnote" icon
Then Footnotes window should be open 

@SeriesTab
Scenario: TC_SeriesTab_39:Verify selected 'series count' under series tab.
Given User enters seriesID "146381801;1380601;245178303"
Then Verify the selected series count

@SeriesTab
Scenario: TC_SeriesTab_40:Verify "Add series" by click on '+'
Given User enters seriesID "7872901;7874601"
When Click on + icon on series
Then The series should be added to Data tab

@SeriesTab
Scenario: TC_SeriesTab_41:Verify Pin/unpin filters
When Hover the mouse on any filter and click on Pin
Then filter should be pined/unpined the filter to left panel

@SeriesTab
Scenario: TC_SeriesTab_42:Verify 'Add' series from dropdown
Given User enters seriesID "368921927;371376337"
And Click on drop down icon next to +
And Click on "Add"
Then The series should be added to Data tab

@SeriesTab
Scenario: TC_SeriesTab_43:Verify 'add to exist insight' in dropdown
Given User enters seriesID "368921927;371376337"
And  Click on drop down icon next to +
And  Click on "Add to existing insight"
Then Choose any existing insights to add this series
Then The series should be added to selected insight

@SeriesTab
Scenario: TC_SeriesTab_44:Verify 'Add to new insight' in dropdown
Given User enters seriesID "122834404;295755902"
And  Click on drop down icon next to +
And  Click on "Add to new insight"
Then New insight should be created and the series should be added to the insight