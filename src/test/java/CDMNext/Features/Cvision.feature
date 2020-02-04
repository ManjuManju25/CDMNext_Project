Feature: Verifying Cvision Functionality

Background:
   Given User has successful logged in

@Cvision
Scenario: TC_Cvision_15211_01: Verify the quick functions in All functions popup
   And Refreshing the page
   And Close the filter button
   And Add to myseries
   And Select a series on right
   And Click on functions wizard from right panel series
   And Check for the function buttons
   Then Accumulate-QTD, YTD;Calculate change- YOY,%YOY,POP,%POP;Currency - USD, RMB, GBP, JPY, RUB, MYR, EUR;Aggregate - Sum, Avg & frequency dropdown
   
#@Cvision
#Scenario: TC_Cvision_15211_02: Check for the tooltips of quick functions in 'All functions' popup
#   And Add few series to myseries
#   And Select a series on right
#   And Click on functions wizard from right panel series
#   And Highlight the functions and check for the tooltips
#   Then Tooltips should display for each functions methods
   
@Cvision
Scenario: TC_Cvision_16283_01: Verify if series selection is removed after chart visual creation using hover options
   And Refreshing the page
   #And Close the filter button
   And Reset the values in "Databases" tab
   And Right click on any series level of data from DB tab
   And Hover to click on create "Chart" 
   Then Series selected should be removed
   
@Cvision
Scenario: TC_Cvision_16283_02: Verify if series selection is removed after chart visual creation using more actions
	 And Reset the values in "Series" tab
   And Right click on any series level of data from series
   And  Click on more actions to create "View as Chart" 
   Then Series selected should be removed
   
@Cvision
Scenario: TC_Cvision_16283_03: Verify if series selection is removed after table visual creation using hover options
   And Reset the values in "Databases" tab
   And Right click on any series level of data from DB tab
   And  Click on more actions to create "View as Table" 
   Then Series selected should be removed
   
@Cvision
Scenario: TC_Cvision_16283_04: Verify if series selection is removed after table visual creation using more actions
	 And Reset the values in "Series" tab
   And Right click on any series level of data from series
   And  Click on more actions to create "View as Table" 
   Then Series selected should be removed
   
@Cvision
Scenario: TC_Cvision_16283_05: Verify if series selection is removed after map visual creation using hover options
   And Reset the values in "Databases" tab
   And Right click on any series level of data from DB tab
   And  Click on more actions to create "View as Map" 
   Then Series selected should be removed
  
@Cvision
Scenario: TC_Cvision_16283_06: Verify if series selection is removed after map visual creation using more actions
	 And Reset the values in "Series" tab
   And Right click on any series level of data from series
   And  Click on more actions to create "View as Map" 
   Then Series selected should be removed
 
@Cvision
Scenario: TC_Cvision_16283_07: Verify if series selection is removed after pie visual creation using hover options
   And Reset the values in "Databases" tab
   And Right click on any series level of data from DB tab
   And Click on more actions
   And Choose "View as ..." > "Pie" 
   Then Series selected should be removed
   
@Cvision
Scenario: TC_Cvision_16283_08: Verify if series selection is removed after pie visual creation using more actions
	 And Reset the values in "Series" tab
   And Right click on any series level of data from series
   And Click on more actions
   And Choose "View as ..." > "Pie" 
   Then Series selected should be removed 

@Cvision
Scenario: TC_Cvision_16283_09: Verify if series selection is removed after heatmap visual creation using hover options
   And Reset the values in "Databases" tab
   And Right click on any series level of data from DB tab
   And Click on more actions
   And Choose "View as ..." > "Heat map" 
   Then Series selected should be removed 
   
@Cvision
Scenario: TC_Cvision_16283_10: Verify if series selection is removed after heatmap visual creation using more actions
	 And Reset the values in "Series" tab
   And Right click on any series level of data from series
   And Click on more actions
   And Choose "View as ..." > "Heat map" 
   Then Series selected should be removed  
 
@Cvision
Scenario: TC_Cvision_16283_11: Verify if series selection is removed after histogram visual creation using hover options
   And Reset the values in "Databases" tab
   And Right click on any series level of data from DB tab
   And Click on more actions
   And Choose "View as ..." > "Histogram" 
   Then Series selected should be removed 
   
@Cvision
Scenario: TC_Cvision_16283_12: Verify if series selection is removed after histogram visual creation using more actions
   And Reset the values in "Series" tab
   And Right click on any series level of data from series
   And Click on more actions
   And Choose "View as ..." > "Histogram" 
   Then Series selected should be removed  
 
@Cvision
Scenario: TC_Cvision_15402_01: Check if the axis date format - Automatic is applied
   And Refreshing the page
   #And Close the filter button
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual 
   And Choose "Time axis" > "advanced settings" > "Date format" > "Auto" >
   And Clicking "Save" option
   Then  "Auto" date format has to reflect on the "Chart" visual
   
@Cvision
Scenario: TC_Cvision_15402_02: Check if the axis date format - Custom is applied
   And Refreshing the page
   #And Close the filter button
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual 
   And Choose "Time axis" > "advanced settings" > "Date format" > "Custom" >
   And Select date format as "YYYY/MM/DD" 
   And Clicking "Save" option
   Then  "Custom" date format has to reflect on the "Chart" visual
   
@Cvision
Scenario: TC_Cvision_15335: Check for possibility to hover over smart series tooltip 
   And Refreshing the page
   And Select few series
   And Open a "Chart" visual
   And Hover on the series "Name:" in legend 
   Then Tooltip should display as in search series
   
@Cvision
Scenario: TC_Cvision_15662_01: Verify date picker in timeframe for yearly frequency
   And Refreshing the page
   #And Click on "Filter" button from search
   And Resetting the filters
   And User selects "Frequency" as "Yearly" 
   And User has selected "Yearly" frequency unit
	 And User has clicked on "Apply filter" 
	 And Search for the series with SID "304366404"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify for annual series - just annual date picker
   
@Cvision
Scenario: TC_Cvision_15662_02: Verify date picker in timeframe for semi annual frequency
   And Resetting the filters
   And User selects "Frequency" as "Semiannually" 
   And User has selected "Semiannually" frequency unit
	 And User has clicked on "Apply filter" 
   And Search for the series with SID "359237987"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify for semi annual series - month and yr date picker
  
@Cvision
Scenario: TC_Cvision_15662_03: Verify date picker in timeframe for quarterly frequency
   And Resetting the filters
   And User selects "Frequency" as "Quarterly" 
   And User has selected "Quarterly" frequency unit
	 And User has clicked on "Apply filter" 
   And Search for the series with SID "360461777"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify for quarterly series - month and yr date picker
   
@Cvision
Scenario: TC_Cvision_15662_04: Verify date picker in timeframe for monthly frequency
   And Resetting the filters
   And User selects "Frequency" as "Monthly" 
   And User has selected "Monthly" frequency unit
	 And User has clicked on "Apply filter" 
   And Search for the series with SID "107958108"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify for monthly series - month and yr date picker
   
@Cvision
Scenario: TC_Cvision_15662_05: Verify date picker in timeframe for weekly frequency
   And Resetting the filters
   And User selects "Frequency" as "Weekly" 
   And User has selected "Weekly" frequency unit
	 And User has clicked on "Apply filter" 
   And Search for the series with SID "389772587"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify for weekly series - day, month and yr date picker
   
@Cvision
Scenario: TC_Cvision_15662_06: Verify date picker in timeframe for daily frequency
   And Resetting the filters
   And User selects "Frequency" as "Daily" 
   And User has selected "Daily" frequency unit
	 And User has clicked on "Apply filter" 
   And Search for the series with SID "114157808"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify for daily series - day, month and yr date picker
   
@Cvision
Scenario: TC_Cvision_15662_07: Verify date picker in timeframe for mixed frequencies - daily, quaterly, yearly
   And Resetting the filters
   And User selects "Frequency" as "Daily;Quarterly;Yearly" 
   And User has selected "Daily;Quarterly;Yearly" frequency unit
	 And User has clicked on "Apply filter" 
   And Search for the series with SID "114157808"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify that the date picker should display day,month and yr
   
@Cvision
Scenario: TC_Cvision_15662_08: Verify date picker in timeframe for mixed frequencies - monthly, yearly
   And Resetting the filters
   #And Close the filter button
   And User selects "Frequency" as "Monthly;Yearly" 
   And User has selected "Monthly;Yearly" frequency unit
	 And User has clicked on "Apply filter" 
   And Search for the series with SID "205441502"
   And Open a "Chart" visual
   And Check the display day-unit date picker
   Then Verify that the date picker should display month and yr
   
@Cvision
Scenario: TC_Cvision_15242_02: Verify stroke option for non-line charts
   And Resetting the filters
   #And Close the filter button
   And Search for the series "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Select type as "Column chart" 
   And Check "stroke" option
   Then Stroke options to be in disabled state
   
@Cvision
Scenario: TC_Cvision_15242_03: Verify move to right for per-series
   And Search for the series with SID "Registered unemployment Rate" 
   And Select 2 series and click on "Chart" option
   And Click on "Edit" visual
   And Check "Move to right" option
   Then Choosen series should shift to "right" axis 
   
@Cvision
Scenario: TC_Cvision_15242_04: Verify move to left for per-series
   And Search for the series with SID "Registered unemployment Rate"
   And Select 2 series and click on "Chart" option
   And Click on "Edit" visual
   And Check "Move to left" option
   Then Choosen series should shift to "left" axis 

@Cvision
Scenario: TC_Cvision_15262_01: Check if the Chart Time within option is synced with timeframe period
   And Refreshing the page
   And Search for the series "360937287"
   And  Click on more actions to create "View as Chart" 
   And Set the range as "2019-01-01" to "2018-01-01"
   And Click "Save period" button
   And Click on "Edit" visual
   And Check Time axis> Time within period
   Then The time within period should sync with chart "timeframe" period.
   
@Cvision
Scenario: TC_Cvision_15262_02: Check if the Chart within option is synced with zoom period
   And Search for the series "360937287"
   And  Click on more actions to create "View as Chart" 
   And Select "1y" tab 
   And Click "Save period" button
   And Get date from chart
   And Click on "Edit" visual
   And Check Time axis> Time within period
   Then Time within period should sync with chart "zoom" period

@Cvision
Scenario: TC_Cvision_16457: Validate the message for comaprables when no indicators available for specific countries
   And Clear the values in search
   And Goto comparables search tab
   And User selects "Region" as "Albania;Finland;Portugal" 
   And User has clicked on "Apply filter"
   And Go to "Production" > "Agricultural Production Index" > "(DC)Production Index: 1999-2001: Crop" > "(DC)Production Index: 1999-2001: Food" > "(DC)Production Index: 1999-2001: Livestock" 
   Then The indicator is not available for selected countries
   
@Cvision
Scenario: TC_Cvision_16312_01: Check if comparables tab is default
   And Check if comparables tab is displayed by default
   Then Tab should display without being hidden
   
@Cvision
Scenario: TC_Cvision_16312_02: Check the tooltip for table-level comparables hover
   And Resetting the filters 
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Hover on icon 
   Then Tooltip as "View table cross country" should display for table
      
@Cvision1234567
Scenario: TC_Cvision_16312_03: Check the tooltip for series-level comparables hover
   And Resetting the filters
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Hover on icon
   Then Tooltip as "View series cross country" should display for series
   
@Cvision
Scenario: TC_Cvision_16312_04: Verify the comparable for table-level
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on table level
   Then Respective indicator of table should open in comparable tab
   
@Cvision
Scenario: TC_Cvision_16312_05: Verify the comparable for series-level
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on series level
   Then Respective indicator of series should open in comparable tab
   
@Cvision
Scenario: TC_Cvision_16312_06: Verify for default tree when clicked on cross icon in the filter
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on series level
   And Click on cross icon indicator in comparable tab
   Then Default tree should be shown
   
@Cvision
Scenario: TC_Cvision_16312_07: Verify region filter selection
   And Click on closing active comparatable icon and "Databases" tab
   And Clicking the database "Global Database" 
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on series level
   And User selects "Region" as "Albania" 
   And User has selected "Albania" frequency unit
   And User has clicked on "Apply filter"
   And Check if the result displays only for the selected regions
   Then  "See all countries" should display for region selection
   
@Cvision
Scenario: TC_Cvision_16312_08: Verify 'All countries' display in comparables tab
   And Resetting the filters
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on series level
   And User selects "Region" as "Albania" 
   And User has clicked on "Apply filter"
   And  "See all countries" should display result of all region
   Then Indicators for all countries should display
   
@Cvision
Scenario: TC_Cvision_16312_09: Verify default results sorting
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on series level
   Then The results to be sorted based on country
   
@Cvision
Scenario: TC_Cvision_16312_10: Verify expanded state of icon
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on table level
   And  Click on expand control
   Then Icon to change to expanded state
   
@Cvision
Scenario: TC_Cvision_16312_11: Verify fully selected state of series
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on series level
   And  Click on select all control
   Then  "Fully" selected icon to display
   
@Cvision
Scenario: TC_Cvision_16312_12: Verify partially selected state of series
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on table level
   And  Click on select all control
   Then  "Partially" selected icon to display
   
@Cvision
Scenario: TC_Cvision_16312_13: Verify unselected state of series
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on table level
   Then  "Not" selected icon to display
   
@Cvision
Scenario: TC_Cvision_16312_14: Verify label in the filter
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual" 
   And Click on table level
   Then The filter should be without country code "AF." 
   
@Cvision
Scenario: TC_Cvision_16312_15: Verify the sources for comparables tab
   And Click on closing active comparatable icon and "Databases" tab
   And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: Production" > "Table AF.World Bank.WDI: Agricultural Production Index" 
   And Select all series from the table
   And Also Expand "Table AF.World Bank.WDI: Agricultural Production and Consumption" 
   And Select all series from the table2
   And Then Expand "Table AF.World Bank.WDI: Land Use, Protected Areas and National Wealth" 
   And Select all series from the table3
   
@Cvision
Scenario: TC_Cvision_13924_1: Verify cogwheel icon for series
   And Click on closing active comparatable icon and "Series" tab
   And Hover to click on create "Chart" 
   And Click on "Edit" visual 
   And Check the legend icon at visual and edit visual for series
   Then  "Cogwheel" to be present and its "Edit series" 
   
@Cvision
Scenario: TC_Cvision_13924_2: Verify cross icon for series
   And Hover to click on create "Chart" 
   And Click on "Edit" visual 
   And Check the legend icon at visual and edit visual for series
   Then  "Cross icon" to be present and its "Remove series" 
   
@Cvision
Scenario: TC_Cvision_14824: Verify label default in edit visual
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual 
   And Choose "labels" > "advanced settings" > "Labels" > "Specific" >
   Then  "Last observations" be selected by default
   
@Cvision12345
Scenario: TC_Cvision_15126: Verify validation if no observations are found within requested range in Date
   And Search for the series "408925837" 
   And Select a series on right
   And Perform "Download" operation
   And Perform download with timeframe "Range": "2017-12-31" to "2018-12-31"
   Then The Message "No observations are found within requested range" should be displayed
   
@Cvision
Scenario: TC_Cvision_14392_01: Verify if series positions changes for 'Bring to front' selection
   And Search for the series with SID "Registered unemployment Rate"
   And Select 2 series and click on "Chart" option
   Then Country names should be series names

@Cvision
Scenario: TC_Cvision_16392: Verify the text for not found FN
   And Click "Help" > "Footnotes" 
   And Click "World Trend Plus" > "CEIC Leading Indicator" > "CEIC Leading Indicator" > "CEIC Leading Indicator:" 
   Then The Message "Footnote is limited for your selection, you can view related footnote below." be displayed
   
@Cvision
Scenario: TC_Cvision_14635: Trend method should be default selection in Function Toolbar
   And Add few series to myseries
   And Select a series on right
   And click on 'fx' to open 'All functions' popup
   And choose "HPFILTER" function
   Then  "Trend" method should be checked
   
@Cvision
Scenario: TC_Cvision_15209: Verify UI changes for Update function
   And Add few series to myseries
   And Select a series on right
   And click on 'fx' to open 'All functions' popup
   And choose "UPDATE" function
   Then  "Fill gaps and future time points" method should be checked
   
@Cvision
Scenario: TC_Cvision_6192_1: Verify if selection of function should enable Cancel button in Smart toolbar
   And Add few series to myseries
   And Select a series on right
   And click on 'fx' to open 'All functions' popup
   And check "Cancel" button
   And choose "HPFILTER" function
   Then  "Cancel" button should be enabled for user to cancel the operation at any time
   
@Cvision
Scenario: TC_Cvision_6192_2: Verify if Escape function can cancel the operation of Selection of function in Smart toolbar
   And Add few series to myseries
   And Select a series on right
   And click on 'fx' to open 'All functions' popup
   And choose "HPFILTER" function
   And Press "Escape" button in keyboard
   Then  "Escape" button should be enabled for user to cancel the operation at any time
   
@Cvision
Scenario: TC_Cvision_13416_1: Verify the tooltip of date marker
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual 
   And click on "-annotations__horizontal" option under annotations
   And Click on "Single date" option from annotation selection
   And hover on to "Annotations" 
   Then  "Click to add date marker" tooltip should present
   
@Cvision
Scenario: TC_Cvision_13416_2: Verify the options of date marker
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual 
   And click on "-annotations__horizontal" option under annotations
   And Click on "Single date" option from annotation selection
   And hover on to "Annotations" 
   Then  "Date, Color, Thickness, LineType and Remove" options should present
   
@Cvision
Scenario: TC_Cvision_12162: Verify if custom format is retained for new visuals
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual 
   And Uncheck the "Zoom" and "Slider" options
   And Create a new template and "Set as default for future Chart visual" 
   And Clicking "Save" option
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual 
   And  "Delete template" the newly created template
   Then The new visual should save the changes 
   
@Cvision
Scenario: TC_Cvision_15495: Check the name for add related series popup
   And Select few series
   And Open a "Chart" visual
   And Click on "Add related series" visual 
   Then The popup name has to be "Add related series" 
   
@Cvision
Scenario: TC_Cvision_15497_01: Verify if manage all option is hidden if there is only 1 series for replacement
   And Add few series to myseries
   And Search for the series with SID "253736802"
   And Add few series to myseries
   And Select all series from myseries and click on "Related Series" option
   And Click on "Replacements" tab in popup
   Then  "Manage all" and "Select all" options should "not" display
   
@Cvision
Scenario: TC_Cvision_15497_03: Verify if manage all option is hidden if there is only 1 series for forecast
   And Add few series to myseries
   And Search for the series with SID "32189801"
   And Add few series to myseries
   And Select all series from myseries and click on "Related Series" option
   And Click on "Forecast" tab in popup
   Then  "Manage all" and "Select all" options should "not" display
   
@Cvision
Scenario: TC_Cvision_15497_04: Verify if manage all option is hidden if there is only 1 dependency series
   And Add few series to myseries
   And Search for the series with SID "389705827"
   And Add few series to myseries
   And Select all series from myseries and click on "Related Series" option
   And Click on "Dependencies" tab in popup
   Then  "Manage all" and "Select all" options should "not" display
   
@Cvision
Scenario: TC_Cvision_15909_01: Verify if preserve formula is hidden for series not applied with function
   And Add few series to myseries
   And Search for the series with SID "253736802"
   And Add few series to myseries
   And Select all series from myseries and click on "Related Series" option
   And Click on "Replacements" tab in popup
   Then Preserve "formula" option should "not" display
   
@Cvision
Scenario: TC_Cvision_15909_02: Verify if preserve formula is hidden for series not applied with function
   And Add few series to myseries
   And Search for the series with SID "32189801"
   And Add few series to myseries
   And Select all series from myseries and click on "Related Series" option
   And Click on "Forecast" tab in popup
   Then Preserve "formula" option should "not" display
   
@Cvision
Scenario: TC_Cvision_15909_03: Verify if preserve names is hidden for series not available with differently named dependency series
   And Add few series to myseries
   And Search for the series with SID "389705827"
   And Add few series to myseries
   And Select all series from myseries and click on "Related Series" option
   And Click on "Dependencies" tab in popup
   Then Preserve "names" option should "not" display
   
@Cvision
Scenario: TC_Cvision_15338_01: Verify the smart tooltips of attributes from seris tab
   And Click on any series from series tab
   Then Verify for "Observations" and "Classification" 
   
@Cvision
Scenario: TC_Cvision_15338_02: Verify the smart tooltips of attributes from db tab
   And Search for the series in db tab with SID "205424302"
   And Hovor first series from series list
   Then Verify for "Observations" and "Classification" 
   
#@Cvision
#Scenario: TC_Cvision_15346: Check if few icons are hidden in collapsed state of SSP
   #And Go to search
   #And  hightlight any one series from search list and click on  "i" icon .
   #And Open SSP window
   #And Clicking on minimize icon
   #Then  "Add series" , "Create Chart" , "Copy to Clipboard" , "Download" icons should be in hidden state.
   
@Cvision
Scenario: TC_Cvision_15332: Verify the smart tooltip for series name in SSP
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window
   And Hover the "single-series-preview--title " 
   Then Smart tooltip should popup
   
@Cvision
Scenario: TC_Cvision_16243: Verify for minimize and full screen controls on the video tutorials window
   And Click "Help" > "Video Tutorials" 
   And Check for "Fullscreen" and "Non-Fullscreen" controls
   Then Both should be available
   
@Cvision
Scenario: TC_Cvision_15749: Verify title bar actions for breakdown series
   And Open SSP for the series "383937057" 
   And Click on "Drilldown" icon from SSP window
   And Select 1 series from drilldown series list
   Then  "Add series" , "Create Chart" , "Copy to Clipboard" , "Download" actions should be possible
  
@Cvision
Scenario: TC_Cvision_7067_01: Verify if series name are same, then country name is displayed as series name in chart
   And Search for the series with SID "Registered unemployment Rate"
   And Select 2 series and click on "Chart" option
   Then Country names should be series names
   
@Cvision
Scenario: TC_Cvision_7067_02: Verify the chart title if series names are same in a chart visual
   And Search for the series with SID "Registered unemployment Rate"
   And Get the text for first 2 series
   And Select 2 series and click on "Chart" option
   Then Chart title has to be series name
   
@Cvision
Scenario: TC_Cvision_15222_01: Check for order of dbs in products
   And Click "Products" > "World Trend Plus" 
   Then Check the order "World Trend Plus" , "Global Database" 
   Then Check the order of premium database "Brazil" , "China" , "India" , "Indonesia" , "Russia" 
   
@Cvision
Scenario: TC_Cvision_15932_01: Verify if 0 obs series is displayed in search results for external user login
   And Search for the series with SID "315926001" 
   Then The series is not displayed
   
@Cvision
Scenario: TC_Cvision_15932_02: Verify if 0 obs series is displayed in database tree for external user login
   And Click on "Databases" tab in left panel
   And Search for the series with SID "315926001"
   Then The series is not displayed
   
@Cvision
Scenario: TC_Cvision_15932_03: Verify if 0 obs series is displayed in search results for internal user login
   And Search for the series with SID "315926001"  
   Then The series is displayed for internal users
   
@Cvision
Scenario: TC_Cvision_15932_04: Verify if 0 obs series is displayed in database tree for internal user login
   And Search for the series with SID "315926001" 
   And Click on "Databases" tab in left panel
   Then The series is displayed for internal users
   
@Cvision
Scenario: TC_Cvision_16499_01: Verify if negative timepoint is indicated in red in SSP
   And Open SSP for the series "322664401"
   Then  "Negative" timepoints should be in "red" color in SSP
   
@Cvision
Scenario: TC_Cvision_16499_02: Verify if transformed timepoints are in red for negative SSP
   And Search for the series "322664401"
   And Select a series on right
   And click on 'fx' to open 'All functions' popup
   And Enter "CONVERTCUR" , "US Dollars" , "as reported" function
   And Click "Apply" button
   And Click the series title which matching applied function name
   Then  "Negative" timepoints should be in "red" color in SSP
   
@Cvision
Scenario: TC_Cvision_16499_03: Verify if tables have negative timepoint indicated in red color
   And Search for the series "322664401"
   And  Click on more actions to create "View as Table"  
   And Check for the font color of negative timepoints in table
   Then Negative timepoints should be in red color
   
@Cvision12
Scenario: TC_15341_01: Verify selecting attributes under attributes popup
   And Select few series
   And  Click on more actions to create "View as Table" 
   #And Click on "Edit Table" visual 
   #And Choose "Attributes" > "advanced settings" > "Attributes" > "Attributes" > 
   And Double click on attribute in the table
   Then  "Select few" attributes checkbox
   
@Cvision12
Scenario: TC_15494_01: Verify title for Ask a question popup
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window
   And Verify the title in SSP Window
   And Click on Ask Question link in SSP window
   Then The title should be "Ask a question about" 
   
@Cvision12
Scenario: TC_15269_01: Verify ascending and descending icon for 'Recently update' sort by
   And Search for the series with SID "205424302;205441502;205428302"
   And Select 2 series and click on "A" option
   And Select all series from myseries and click on "Customize your selection" option
   And Customize popup is opened and Click on "Sort series by" option
   And Click "Recently Updated" option from dropdown
   And Clicking "Save" option
   Then Ascending and descending icon should not displayed for "Recently Updated" 
   
@Cvision12
Scenario: TC_14142_01: Verify downloading CNA packages
   And Click "Help" > "Excel Add-in" 
   Then Should redirect to "https://www.ceicdata.com/en/login" and from there user should download the builds
   
@Cvision12
Scenario: TC_14668_01: Verify zebra selection under Edit table
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Choose options "Zebra" > "Rows" 
   Then Should enable only "Rows" coloring when selected zebra checkbox
   
#TC_14172_01 and TC_14172_03
@Cvision12
Scenario: TC_14172_01: Verify click on '+' icon and save option to save a custome style
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Uncheck the "Attributes" and "Wrap text" options
   And Create a new template and "Template popup" 
   Then The new template should be created in the beginning of the list
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And  "Delete template" the newly created customized template
   
@Cvision12
Scenario: TC_14172_04: Verify cancel icon
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Uncheck the "Attributes" and "Wrap text" options
   And Create a new template and "Template popup" and click "Cancel" icon 
   Then The popup should be closed
   
@Cvision12
Scenario: TC_Cvision_12162: Verify default style template for future visual creation
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Uncheck the "Attributes" and "Wrap text" options
   And Create a new template and "Set as default for future Table visual" 
   And Clicking "Save" option
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And  "Delete template" the newly created template
   Then The new visual should be created with selected template style
   
@Cvision12
Scenario: TC_Cvision_13924_1: Verify cogwheel icon for visual
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Check the legend icon at visual and edit visual
   Then  "Rename" , "Frequency" and "Change" should be displayed
   
@Cvision12
Scenario: TC_13924_02: Cogwheel - Verify Rename
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Check the legend icon at visual and edit visual
   And Click "Rename" text from cogwheel
   Then  "Rename" option should display
   
@Cvision12
Scenario: TC_13924_03: Cogwheel - Verify Frequency
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Check the legend icon at visual and edit visual
   And Click "Frequency" text from cogwheel
   And Click "Yearly (Sum)" from the drop down
   Then The selected "Frequency" is applied to the table
   
@Cvision12
Scenario: TC_13924_05: Cogwheel - Verify Change
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Check the legend icon at visual and edit visual
   And Click "Change" text from cogwheel
   And Click "Difference Year-over-Year (YoY)" from the drop down
   Then The selected "Change" is applied to the table visual
   
@Cvision12
Scenario: TC_13924_07: Verify remove series icon
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Check the legend icon at visual and remove visual
   Then The series should be removed from the visual
   
@Cvision12
Scenario: TC_15651_01: Verify Selected style visiblity in the template list
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Uncheck the "Attributes" and "Wrap text" options
   And Create a new template and "Template popup" 
   And Clicking on the hiding template from the style template dropdown
   Then Selected template should be visible in the template Menu
   
@Cvision12
Scenario: TC_15289_01: Verify 'Add related series' option for empty visual
   And Click to create an empty visual
   And Click on empty "Table" visual
   And Observe the "Add related series" button
   Then  "Add related series" should not be available for empty visual
   
@Cvision1234
Scenario: TC_14173_01: Verify Unit in histogram tooltip
   And Right click on any series level of data from series
   And Click on more actions
   And Choose "View as ..." > "Histogram" 
   And Capture the "Unit:" tooltip indicator value
   Then  "Unit" should be shown on tooltip
  
@Cvision12
Scenario: TC_15656_01: Verify Histogram methodology
   And Right click on any series level of data from series
   And Click on more actions
   And Choose "View as ..." > "Histogram" 
   And Mouse over to "help-button" 
   Then Histogram methodology info should be displayed in tooltip
   
@Cvision12
Scenario: TC_15656_02: Verify Histogram methodology in Insight view mode
   And Right click on any series level of data from series
   And Click on more actions
   And Choose "View as ..." > "Histogram" 
   And Click "File" > "View" 
   And Click on the insight point
   And Mouse over to "help-button" from insights
   Then Histogram methodology info should be displayed in tooltip
   
@Cvision12
Scenario: TC_13671_01: Verify tooltip for 'Contents' icon on footnotes
   And Click "Help" > "Footnotes" 
   And Collapse the footnotes
   And Hover on to the "Open Contents" 
   Then  "Open Contents" tooltip should be displayed
   
@Cvision12
Scenario: TC_13651_01: Verify upload popup behaviour when the upload is completed
   And Click to create an empty visual
   And Click "Insert Image" option from empty list
   And Click "Upload image" button to upload images
   Then Verify the uploaded image comes under iframe
   
@Cvision1234
Scenario: TC_16290_01: Verify shadow for notification panel
   And Open notification panel
   Then Shadow should be applied to notification panel
   
@Cvision12
Scenario: TC_14601_01: Verify confirmation message for copy link
   And Click "File" > "Open" 
   And Click "View as a table" option from empty list
   And Right click on Insight name and click on "Copy link" 
   Then The message should be "Link is copied" 
   
@Cvision12
Scenario: TC_14601_02: Verify confirmation message for copy Insight
   And Click "File" > "Open" 
   And Click "View as a table" option from empty list
   And Right click on Insight name and click on "Copy" 
   And Click on the insight button "Copy Insight" 
   Then The message should be "Selected insight(s) copied"
   
@Cvision12
Scenario: TC_15328_01: Verify loader for PDF viewer
   And Click "File" > "Open" 
   And Click on "Analytics" tab in insights
   And Click on one ingisht under EMIS insight
   Then  "Loading insight..." label should be displayed under the spinner
   
@Cvision12
Scenario: TC_14907_01: Verify message for non data visual copy
   And Click to create an empty visual
   And Click "Insert Image" option from empty list
   And Click "Copy" button in images wizard
   Then  "Image copied" message for non data visual should be displayed
   
@Cvision12
Scenario: TC_15259_01: Verify confirmation popup for insight sharing
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   Then Share "Confirmation" popup should display every time share insight
   
@Cvision12
Scenario: TC_15259_02: Verify description for share confirmation popup
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   Then The description should be "Do you want to email users about sharing changes?" 
   
@Cvision12
Scenario: TC_15259_03: Share confirmation popup - Verify OK button
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "OK" button in insight preview
   And The "OK" button is clickable
   Then The title for "Shared Insight" 
   
@Cvision12
Scenario: TC_15259_05: Share confirmation popup - Verify 'Don't email' button.
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "Don't email" button in insight preview
   And The "Don't email" button is clickable
   Then The title for "Shared Insight" 
   
@Cvision12
Scenario: TC_15259_06: Share confirmation popup - Verify 'Cancel changes' button
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "Cancel changes" button in insight preview
   And The "Cancel changes" button is clickable
   And Click on "Insight" icon to share insight
   Then The share process should be declined
   
@Cvision12
Scenario: TC_15259_09: Verify confirmation popup for second time share
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "Don't email" button in insight preview
   And The "Don't email" button is clickable
   And Click on "Insight" icon to share insight
   And Select Users to share for second time
   And Click on "Save" button to share
   Then The confirmation popup should be displayed only for first time share
   
@Cvision12
Scenario: TC_15336_01: Verify mouse hover tooltip when only move the mouse on series name
   And Select "Series" tab in header
   Then Tooltip only displayed when hover the mouse on series name
   
@Cvision12
Scenario: TC_14781_01: Verify creating non data visuals with series
   And Select few series
   And Click to create an empty visual
   And Click "Insert Image" option from empty list
   And Click "Upload image" button to upload images
   And Select my series tab
   Then The non data visuals should not create with series
   
@Cvision12
Scenario: TC_15910_01: Verify new title for "Series data conversion" popup
   And Search for the series with SID "384681617;385320997"
   And  Click on more actions to create "View as Table"
   And Observe the "movable-modal--title-message" for popup
   Then The title of the pop up should be "Series Harmonization" 
   
@Cvision12
Scenario: TC_15910_01: Verify new title for "Series data conversion" popup
   And Search for the series with SID "384681617;385320997"
   And  Click on more actions to create "View as Table"
   And Observe the "series-data-conversion--info" for popup
   Then The message in the pop up should be "Your selection includes series of different frequency and calendar. Please perform these conversions for better analysis and visualization." 
   
@Cvision12
Scenario: TC_15649_01: Verify 'Enter' for save style template
   And Reset the values in "Series" tab
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And Uncheck the "Attributes" and "Wrap text" options
   And Create a new template
   Then The style template should be saved
   And Select few series
   And  Click on more actions to create "View as Table"
   And Click on "Edit Table" visual
   And  "Delete template" the newly created template
   And Close the model box
   
@Cvision12
Scenario: TC_16428_01: Verify Notification icon click
   And Open notification panel
   Then The notification panel is opened and "What's new" tab is default
   And Open notification panel
   
#@Cvision12
#Scenario: TC_16428_02: Verify Notification tab
   #And Open notification panel
   #Then The notification panel is opened and "What's new" tab is default
   #And Open notification panel
   
@Cvision12
Scenario: TC_16310_01: Verify user name on preference dropdown
   And Open preference dropdown
   And Click on "profile-menu--edit-icon" from preferences
   And Choose "Prefix" , "First Name" , "Last Name" from preferences
   And Close the dialog popup
   And Open preference dropdown
   Then Prefix,First name and Last name should be displayed
   And Open preference dropdown
   
@Cvision12
Scenario: TC_16310_02: Verify User name Edit icon
   And Open preference dropdown
   And Click on "profile-menu--edit-icon" from preferences
   And Check for the popup window in preferences
   And Close the dialog popup
   Then  "Change profile settings" popup should be displayed
   
@Cvision12
Scenario: TC_16310_03: Verify changing prefix
   And Open preference dropdown
   And Click on "profile-menu--edit-icon" from preferences
   And Click on edit in "Prefix" from preferences
   And Click "Save" button in preferences
   And Open preference dropdown
   Then The updated prefix should show under preference
   And Open preference dropdown

@Cvision123
Scenario: TC_16310_04: Verify changing user's first name
   And Open preference dropdown
   And Click on "profile-menu--edit-icon" from preferences
   And Click on edit in "First Name" from preferences option
   And Click "Save" button in preferences
   And Open preference dropdown
   And Click on "profile-menu--edit-icon" from preferences
   And Click on edit in "First Name" from user preferences
   And Open preference dropdown
   Then The updated prefix should show under preference
   And Open preference dropdown