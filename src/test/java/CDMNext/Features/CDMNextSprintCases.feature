Feature: Verifying Sprintcases

  @SprintCases
  Scenario: TC_Cvision_15211_01: Verify the quick functions in All functions popup
    And Add to myseries
    And Select a series on right
    And Click on functions wizard option  from right panel series
    And Check for the function buttons
    Then Accumulate-QTD, YTD;Calculate change- YOY,%YOY,POP,%POP;Currency - USD, RMB, GBP, JPY, RUB, MYR, EUR;Aggregate - Sum, Avg & frequency dropdown

  @Cvision
  Scenario: TC_Cvision_15211_02: Check for the tooltips of quick functions in 'All functions' popup
    And Add few series to myseries
    And Select a series on right
    And Click on functions wizard option  from right panel series
    And Highlight the functions and check for the tooltips
    Then Tooltips should display for each functions methods

  @SprintCases1
  Scenario: TC_Cvision_16283_01: Verify if series selection is removed after chart visual creation using hover options
    And Reset the values in "Databases" tab
    And Select 5 series and click on chart option
    Then Series selected should be removed

  @SprintCases
  Scenario: TC_Cvision_16283_02: Verify if series selection is removed after chart visual creation using more actions
    And Reset the values in "Series" tab
    And Right click on any series level of data from series
    And Click on more actions to create "View as Chart"
    Then Series selected should be removed

  @SprintCases1
  Scenario: TC_Cvision_16283_03: Verify if series selection is removed after table visual creation using hover options
    And Reset the values in "Databases" tab
    And Right click on any series level of data from DB tab
    And Click on more actions and create "View as Table" 
    Then Series selected should be removed

  @SprintCases
  Scenario: TC_Cvision_16283_04: Verify if series selection is removed after table visual creation using more actions
    And Reset the values in "Series" tab
    And Right click on any series level of data from series
    And Click on more actions and create "View as Table" 
    Then Series selected should be removed

  @SprintCases1
  Scenario: TC_Cvision_16283_05: Verify if series selection is removed after map visual creation using hover options
    And Reset the values in "Databases" tab
    And Right click on any series level of data from DB tab
    And Create a Map.
    Then Series selected should be removed

  @SprintCases
  Scenario: TC_Cvision_16283_06: Verify if series selection is removed after map visual creation using more actions
    And Reset the values in "Series" tab
    And Right click on any series level of data from series
    And Create a Map.
    Then Series selected should be removed

  @SprintCases1
  Scenario: TC_Cvision_16283_07: Verify if series selection is removed after pie visual creation using hover options
    And Reset the values in "Databases" tab
    And Right click on any series level of data from DB tab
    And Create Pie.
    Then Series selected should be removed

  @SprintCases
  Scenario: TC_Cvision_16283_08: Verify if series selection is removed after pie visual creation using more actions
    And Reset the values in "Series" tab
    And Right click on any series level of data from series
    And Click on more actions dropdown	
    And Create Pie. 
    Then Series selected should be removed

  @SprintCases1
  Scenario: TC_Cvision_16283_09: Verify if series selection is removed after heatmap visual creation using hover options
    And Reset the values in "Databases" tab
    And Right click on any series level of data from DB tab
    And Click on more actions dropdown
    And create HeatMap. 
    Then Series selected should be removed

  @SprintCases
  Scenario: TC_Cvision_16283_10: Verify if series selection is removed after heatmap visual creation using more actions
    And Reset the values in "Series" tab
    And Right click on any series level of data from series
    And Click on more actions dropdown
    And create HeatMap. 
    Then Series selected should be removed

  @SprintCases1
  Scenario: TC_Cvision_16283_11: Verify if series selection is removed after histogram visual creation using hover options
    And Reset the values in "Databases" tab
    And Right click on any series level of data from DB tab
    And Click on more actions dropdown
    And create a Histogram.
    Then Series selected should be removed

  @SprintCases
  Scenario: TC_Cvision_16283_12: Verify if series selection is removed after histogram visual creation using more actions
    And Reset the values in "Series" tab
    And Right click on any series level of data from series
    And Click on more actions dropdown
    And create a Histogram.
    Then Series selected should be removed

  @SprintCases
   Scenario: TC_Cvision_15402_01: Check if the axis date format - Automatic is applied
    And Search for the series with SID "385345667"
    And Click on more actions
    And Click on "Edit" visual
    And Choose "Time axis" > "advanced settings" > "Date format" > "Auto" >
    And Clicking "Save" option
    Then "Auto" date format has to reflect on the "Chart" visual

  @SprintCases1
  Scenario: TC_Cvision_15402_02: Check if the axis date format - Custom is applied
    And Search for the series with SID "385345667"
    And Click on more actions
    And Click on "Edit" visual
    And Choose "Time axis" > "advanced settings" > "Date format" > "Custom" >
    And Select date format as "YYYY/MM/DD"
    And Clicking "Save" option
    Then "Custom" date format has to reflect on the "Chart" visual

  @SprintCases
  Scenario: TC_Cvision_15335: Check for possibility to hover over smart series tooltip
    And Select few series
    And Click on more actions to create=>View as chart.
    And Hover on the series "Name" in legend
    Then Tooltip should display as in search series

  @SprintCases
  Scenario: TC_Cvision_15662_01: Verify date picker in timeframe for yearly frequency
    And Setting the date format values in preferences
    And User selects "Frequency" as "Yearly"
    And User has selected "Yearly" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "304366404"
    And Click on more actions
    And Check the display day-unit date picker
    Then Verify for annual series - just annual date picker

  @SprintCases
  Scenario: TC_Cvision_15662_02: Verify date picker in timeframe for semi annual frequency
    And User selects "Frequency" as "Semiannually"
    And User has selected "Semiannually" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "359237987"
    And Click on more actions
    And Check the display day-unit date picker
    Then Verify for semi annual series - month and yr date picker

  @SprintCases
  Scenario: TC_Cvision_15662_03: Verify date picker in timeframe for quarterly frequency
    And User selects "Frequency" as "Quarterly"
    And User has selected "Quarterly" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "360461777"
    And Click on more actions
    And Check the display day-unit date picker
    Then Verify for quarterly series - month and yr date picker

  @SprintCases
  Scenario: TC_Cvision_15662_04: Verify date picker in timeframe for monthly frequency
    And User selects "Frequency" as "Monthly"
    And User has selected "Monthly" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "107958108"
    And Click on more actions to create=>View as chart.
    And Check the display day-unit date picker
    Then Verify for monthly series - month and yr date picker

  @SprintCases
  Scenario: TC_Cvision_15662_05: Verify date picker in timeframe for weekly frequency
    And User selects "Frequency" as "Weekly"
    And User has selected "Weekly" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "389772587"
    And Click on more actions
    And Check the display day-unit date picker
    Then Verify for weekly series - day, month and yr date picker

  @SprintCases
  Scenario: TC_Cvision_15662_06: Verify date picker in timeframe for daily frequency
    And User selects "Frequency" as "Daily"
    And User has selected "Daily" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "114157808"
    And Click on more actions
    And Check the display day-unit date picker
    Then Verify for daily series - day, month and yr date picker

  @SprintCases
  Scenario: TC_Cvision_15662_07: Verify date picker in timeframe for mixed frequencies - daily, quaterly, yearly
    And User selects "Frequency" as "Daily;Quarterly;Yearly"
    And User has selected "Daily;Quarterly;Yearly" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "114157808"
    And Click on more actions
    And Check the display day-unit date picker
    Then Verify that the date picker should display day,month and yr

  @SprintCases
  Scenario: TC_Cvision_15662_08: Verify date picker in timeframe for mixed frequencies - monthly, yearly
    And User selects "Frequency" as "Monthly;Yearly"
    And User has selected "Monthly;Yearly" frequency unit
    And User has clicked on "Apply filter"
    And Search for the series with SID "205441502"
    And Click on more actions
    And Check the display day-unit date picker
    Then Verify that the date picker should display month and yr

  @SprintCases
  Scenario: TC_Cvision_15242_02: Verify stroke option for non-line charts
    And Search for the series "360937287"
   And Click on more actions to create=>View as chart.
    And Click on "Edit" visual
    And Select type as Column chart
    And Check "stroke" option
    Then Stroke options to be in disabled state

  @SprintCases1
  Scenario: TC_Cvision_15242_03: Verify move to right for per-series
    And Search for the series with SID "Registered unemployment Rate"
    And Select 2 series and click on "Chart" option
    And Check "Move to right" axis option
    Then Choosen axis should shift to "right" axis

  @SprintCases1
  Scenario: TC_Cvision_15242_04: Verify move to left for per-series
    And Search for the series with SID "Registered unemployment Rate"
    And Select 2 series and click on "Chart" option
    And Check "Move to left" axis option
    Then Choosen axis should shift to "left" axis

  @SprintCases1
  Scenario: TC_Cvision_15262_01: Check if the Chart Time within option is synced with timeframe period
    And Search for the series "1053401"
   And Click on more actions to create=>View as chart.
    And In Chart tab click on timeframe date field and change date
    And Click "Save period" button
    And Click on "Edit" visual
    And Check Time axis> Time within period
    Then The time within period should sync with chart "timeframe" period.

  @SprintCases1
  Scenario: TC_Cvision_15262_02: Check if the Chart within option is synced with zoom period
    And Search for the series "360937287"
    And create a chart for the above series.
    And Select "1Y" tab
    And Click "Save period" button	
    And Get date from chart
    And Click on "Edit" visual
    Then Time within period should sync with chart "zoom" period

  @SprintCases1
  Scenario: TC_Cvision_16457: Validate the message for comaprables when no indicators available for specific countries
    And Goto comparables search tab
    And Click on "All Regions" dropdown
    And User selects "Region" as "Albania;Finland;Portugal"
    And User has clicked on "Apply filter"
    And Go to "Production" > "Agricultural Production Index" > "Production Index: 1999-2001: Crop" > "Production Index: 1999-2001: Food" > "Production Index: 1999-2001: Livestock"
    Then The indicator is not available for selected countries

  @SprintCases
  Scenario: TC_Cvision_16312_01: Check if comparables tab is default
    And Check if comparables tab is displayed by default
    Then Tab should display without being hidden

  @SprintCases
  Scenario: TC_Cvision_16312_02: Check the tooltip for table-level comparables hover
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual"
    Then Tooltip as "View table cross country" should display for table

  @SprintCases
  Scenario: TC_Cvision_16312_03: Check the tooltip for series-level comparables hover
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual"
    Then Tooltip as "View series cross country" should display for series

  @SprintCases
  Scenario: TC_Cvision_16312_04: Verify the comparable for table-level
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual"
    And Click on table level
    Then Respective indicator of table should open in comparable tab

  @SprintCases
  Scenario: TC_Cvision_16312_05: Verify the comparable for series-level
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual"
    And Click on series level
    Then Respective indicator of series should open in comparable tab

  @SprintCases
  Scenario: TC_Cvision_16312_06: Verify for default tree when clicked on cross icon in the filter
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual"
    And Click on series level
    Then Tooltip as "View series cross country" should display for series
    Then Default tree should be shown

  @SprintCases1
  Scenario: TC_Cvision_16312_07: Verify region filter selection
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual"
    And Click on series level
    And Click on "All Regions" dropdown
    And User selects "Region" as "Albania"
    And User has selected "Albania" frequency unit
    And User has clicked on "Apply filter"
    And Check if the result displays only for the selected regions
    Then "See all countries" should display for region selection

  @SprintCases1
  Scenario: TC_Cvision_16312_08: Verify 'All countries' display in comparables tab
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "IMF.IFS: Gross Domestic Product: by Expenditure"
    And Click on series level
    And Click on "All Regions" dropdown
    And User selects "Region" as "Albania"
    And User has clicked on "Apply filter"
    And "See all countries" should display result of all region
    Then Indicators for all countries should display

  @SprintCases
  Scenario: TC_Cvision_16312_09: Verify default results sorting
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "IMF.IFS: Gross Domestic Product: by Expenditure"
    And Click on series level
    Then The results to be sorted based on country

  @SprintCases
  Scenario: TC_Cvision_16312_10: Verify expanded state of icon
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "IMF.IFS: Gross Domestic Product: by Expenditure"
    And Click on table level
    And Click on expand control
    Then Icon to change to expanded state

  @SprintCases
  Scenario: TC_Cvision_16312_11: Verify fully selected state of series
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "IMF.IFS: Gross Domestic Product: by Expenditure"
    And Click on series level
    And Click on select all control
    Then "Fully" selected icon to display

  @SprintCases
  Scenario: TC_Cvision_16312_12: Verify partially selected state of series
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "IMF.IFS: Gross Domestic Product: by Expenditure"
    And Click on table level
    And Click on select all control
    Then "Partially" selected icon to display

  @SprintCases
  Scenario: TC_Cvision_16312_13: Verify unselected state of series
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "IMF.IFS: Gross Domestic Product: by Expenditure"
    And Click on table level
    Then "Not" selected icon to display

  @SprintCases
  Scenario: TC_Cvision_16312_14: Verify label in the filter
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: National Accounts" > "Table AF.IMF.IFS: Gross Domestic Product: by Expenditure: Annual"
    And Click on table level
    Then The filter should be without country code "AF."

  @SprintCases
  Scenario: TC_Cvision_16312_15: Verify the sources for comparables tab
    And Click on closing active comparatable icon and "Databases" tab
    And Expand "Global Database" > "All Regions" > "Afghanistan" > "Afghanistan: Production" > "World Bank.WDI: Agricultural Production Index"
    And Select all series from the table
    And Also Expand "World Bank.WDI: Agricultural Production Index"
    And Select all series from the table2

  @SprintCases
  Scenario: TC_Cvision_13924_1: Verify cogwheel icon for series
    And Click on closing active comparatable icon and "Series" tab
    And Hover to click on create "Chart"
    And Click on "Edit" visual
    And Check the legend icon at visual and edit visual for series
    Then "Cogwheel" to be present and its "Edit series"

  @SprintCases
  Scenario: TC_Cvision_13924_2: Verify cross icon for series
    And Click on closing active comparatable icon and "Series" tab
    #And Click on more actions
   And Hover to click on create "Chart"
    And Click on "Edit" visual
    And Check the legend icon at visual and edit visual for series
    Then "Cross icon" to be present and its "Remove series"

  @SprintCases
  Scenario: TC_Cvision_14824: Verify label default in edit visual
    And Select few series
    And Click on more actions
   # And Open a "Chart" visual
    And Click on "Edit" visual
    And Choose "Labels" > "advanced settings" > "Labels" > "Specific" >
    Then "Last observations" be selected by default

  #@SprintCases
  #Scenario: TC_Cvision_15126: Verify validation if no observations are found within requested range in Date
    #And Search for the series "408925837"
    #And Select a series on right
    #And Perform "Download" operation
    #And Perform download with timeframe "Range": "2000-12-31" to "2001-12-31"
    #Then The Message "No observations are found within requested range" should be displayed

  @SprintCases1
  Scenario: TC_Cvision_14392_01: Verify if series positions changes for 'Bring to front' selection
    And Search for the series with SID "Registered unemployment Rate"
    And Select 2 series and click on "Chart" option
    Then Country names should be series names

  @SprintCases
  Scenario: TC_Cvision_16392: Verify the text for not found FN
    And Click "Help" > "Footnotes"
    And Click "World Trend Plus" > "CEIC Leading Indicator" > "CEIC Leading Indicator" > "CEIC Leading Indicator:"
    Then The Message "Footnote is limited for your selection, you can view related footnote below." be displayed

  @SprintCases1
  Scenario: TC_Cvision_14635: Trend method should be default selection in Function Toolbar
    And Add few series to myseries
    And Select a series on right
    And click on 'fx' to open 'All functions' popup
    And choose "HPFILTER" function
    Then "Trend" method should be checked

  @SprintCases1
  Scenario: TC_Cvision_15209: Verify UI changes for Update function
    And Add few series to myseries
    And Select a series on right
    And click on 'fx' to open 'All functions' popup
    And choose "UPDATE" function
    Then "Fill gaps and future time points" method should be checked

  @SprintCases1
  Scenario: TC_Cvision_6192_1: Verify if selection of function should enable Cancel button in Smart toolbar
    And Add few series to myseries
    And Select a series on right
    And click on 'fx' to open 'All functions' popup
    And check "Cancel" button
    And choose "HPFILTER" function
    Then "Cancel" button should be enabled for user to cancel the operation at any time

  @SprintCases1
  Scenario: TC_Cvision_6192_2: Verify if Escape function can cancel the operation of Selection of function in Smart toolbar
    And Add few series to myseries
    And Select a series on right
    And click on 'fx' to open 'All functions' popup
    And choose "HPFILTER" function
    And Press "Escape" button in keyboard
    Then "Escape" button should be enabled for user to cancel the operation at any time

  @SprintCases1
  Scenario: TC_Cvision_13416_1: Verify the tooltip of date marker
    And Select few series
    And Click on more actions dropdown
    And create a chart
    #And Click on more actions
    #And Open a "Chart" visual
    And Click on "Edit" visual
    And click on "-annotations__horizontal" option under annotations
    And Click on "Single date" option from annotation selection
    And hover on to "Annotations"
    Then "Click to add date marker" tooltip should present

  @SprintCases1
  Scenario: TC_Cvision_13416_2: Verify the options of date marker
    And Select few series
    And Click on more actions
   # And Open a "Chart" visual
    And Click on "Edit" visual
    And click on "-annotations__horizontal" option under annotations
    And Click on "Single date" option from annotation selection
    And hover on to "Annotations"
    Then "Date, Color, Thickness, LineType and Remove" options should present

  @SprintCases
  Scenario: TC_Cvision_12162: Verify if custom format is retained for new visual
    And Select few series
    And Click on more actions
   # And Open a "Chart" visual
    And Click on "Edit" visual
    And Uncheck the "Zoom" and "Slider" options
    And Create a new template and "Set as default for future Chart visual"
    And Clicking "Save" option
    And Click on "Edit" visual
    And "Delete template" the newly created template
    Then The new visual should save the changes

  @SprintCases
  Scenario: TC_Cvision_15495: Check the name for add related series popup
    And Select few series
    And Click on more actions
   # And Open a "Chart" visual
    And Click on "Add related series" visual
    Then The popup name has to be "Add related series"

  @SprintCases
  Scenario: TC_Cvision_15497_01: Verify if manage all option is hidden if there is only 1 series for replacement
    And Add few series to myseries
     Given User selects Add continous series
    And User has clicked on "Apply filter"
    And Search for the series with SID "253736802" 
    And click on add icon
    #And Add few series to myseries
    And Select all series from myseries and click on "Related series" option
    And Click on "Continuous" tab in popup
    Then "Manage all" and "Select all" options should "not" display

  @SprintCases1
  Scenario: TC_Cvision_15497_03: Verify if manage all option is hidden if there is only 1 series for forecast
  And Login back to internal user with user "vvagicharla" and password "ZAQ!2wsx@7989"
   # And Add few series to myseries
    And Search for  series with SID "32189801"
   # And Add few series to myseries
    And Select all series from myseries and click on "Related series" option
    And Click on "Forecast" tab in popup
    Then "Manage all" and "Select all" options should "not" display

  @SprintCases
  Scenario: TC_Cvision_15497_04: Verify if manage all option is hidden if there is only 1 dependency series
    And Add few series to myseries
    And Search for  series with SID "389705827"
    #And Add few series to myseries
    And Select all series from myseries and click on "Related series" option
    And Click on "Dependencies" tab in popup
    Then "Manage all" and "Select all" options should "not" display

  @SprintCases
  Scenario: TC_Cvision_15909_01: Verify if preserve formula is hidden for series not applied with function
    And click on More dropdown and select continuos checkbox.
    And User has clicked on "Apply filter"
    And Add few series to myseries tab
  #  And Search for the series with SID "253736802"
     And click on add icon
   #And Add few series to myseries
    And Select all series from myseries and click on "Related series" option
    And Click on "Continuous" tab in popup
    Then Preserve "formula" option should "not" display

  @SprintCases
  Scenario: TC_Cvision_15909_02: Verify if preserve formula is hidden for series not applied with function
    #And Add few series to myseries
    And Search for  series with SID "32189801"
    #And Add few series to myseries
    And Select all series from myseries and click on "Related series" option
    And Click on "Forecast" tab in popup
    Then Preserve "formula" option should "not" display

  @SprintCases
  Scenario: TC_Cvision_15909_03: Verify if preserve names is hidden for series not available with differently named dependency series
    And Login back to internal user with user "vvagicharla" and password "ZAQ!2wsx@7989"
   # And Add few series to myseries
    And Search for  series with SID "389705827"
   # And Add few series to myseries
    And Select all series from myseries and click on "Related series" option
    And Click on "Dependencies" tab in popup
    Then Preserve "names" option should "not" display

	 # @SprintCases
	  #Scenario: TC_Cvision_15338_01: Verify the smart tooltips of attributes from seris tab
	   # And Click on any series from series tab
	    #Then Verify for "Observations" and "Classification"
	
	  #@SprintCases
	  #Scenario: TC_Cvision_15338_02: Verify the smart tooltips of attributes from db tab
	   # And Hovor first series from db list
	    #Then Verify for "Observations" and "Classification"

  @Cvision
  Scenario: TC_Cvision_15346: Check if few icons are hidden in collapsed state of SSP
    And Go to search
    And hightlight any one series from search list and click on  "i" icon .
    And Open SSP window
    And Clicking on minimize icon
    Then "Add series" , "Create Chart" , "Copy to Clipboard" , "Download" icons should be in hidden state.

  @SprintCases
  Scenario: TC_Cvision_15332: Verify the smart tooltip for series name in SSP
    And Go to search
    And hightlight any one series from search list and click on  "i" icon .
    And Open SSP window
    And Hover the "series-preview-modal-header--link"
    Then Smart tooltip should popup

  #@SprintCases...need to check
  #Scenario: TC_Cvision_16243: Verify for minimize and full screen controls on the video tutorials window
    #And Click "Help" > "Video tutorials"
    #And Check for "Fullscreen" and "Exit Fullscreen" controls
    #Then Both should be available

  @SprintCases1
  Scenario: TC_Cvision_15749: Verify title bar actions for breakdown series
    And Open SSP for the series "383937057"
    And Click on "Drilldown" icon from SSP window
    And Select 1 series from drilldown series list
    And Open SSP window
    Then "Add series" , "View as" , "Watch" , "Download" actions should be possible

  @SprintCases1
  Scenario: TC_Cvision_7067_01: Verify if series name are same, then country name is displayed as series name in chart
    And Search for the series with SID "Registered unemployment Rate"
    And Select 2 series and click on "Chart" option
    Then Country names should be series names

  @SprintCases
  Scenario: TC_Cvision_7067_02: Verify the chart title if series names are same in a chart visual
    And Search for the series with SID "Registered unemployment Rate"
    And Get the text for first 2 series
    And Select 2 series and click on "Chart" option
    Then Chart title has to be series name

  #@Cvision1..... functionality has been removed
  #Scenario: TC_Cvision_15222_01: Check for order of dbs in products
    #And Click "Products" > "World Trend Plus"
    #Then Check the order "World Trend Plus" , "Global Database"
    #Then Check the order of premium database "Brazil" , "China" , "India" , "Indonesia" , "Russia"

  @SprintCases
  Scenario: TC_Cvision_15932_01: Verify if 0 obs series is displayed in search results for external user login
    And Search for the series with SID "315926001"
    Then The series is not displayed

  @SprintCases
  Scenario: TC_Cvision_15932_02: Verify if 0 obs series is displayed in database tree for external user login
    And Search for the series with SID "315926001"
    And Click on "Databases" tab in left panel
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

  @SprintCases
  Scenario: TC_Cvision_16499_01: Verify if negative timepoint is indicated in red in SSP
    And Open SSP for the series "322664401"
    Then "Negative" timepoints should be in "red" color in SSP

  @SprintCases
  Scenario: TC_Cvision_16499_02: Verify if transformed timepoints are in red for negative SSP
    And Search for the series "322664401"
    And Select a series on right
    And click on 'fx' to open 'All functions' popup
    And Enter "CONVERTCUR" , "US Dollars" , "as reported" function
    And Click "Apply" button
    And Click the series title which matching applied function name
    Then "Negative" timepoints should be in "red" color in SSP

  @SprintCases
  Scenario: TC_Cvision_16499_03: Verify if tables have negative timepoint indicated in red color
   # And Search for the series "322664401"
    And Click on more actions and create "View as Table" 
   #And Click on more actions to create "View as Table"
    And Check for the font color of negative timepoints in table
    Then Negative timepoints should be in red color

  # ---------------------------------------------------- CDMNext sprint cases 3.1 and above -----------------------------------------
  @CDMNextsprintcases3.1
  Scenario: TC_15341_01: Verify selecting attributes under attributes popup
    And Select few series
   #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Check the count of attributes in table
    And Click on Attributes from the table list
    And Select few attributes "Subnational"
    Then All attributes should be applied to table visual

  @CDMNextsprintcases3.1
  Scenario: TC_15341_02: Verify 'select all' check box when all the attributes selected
    And Select few series
    #And Click on more actions to create "View as Table"
     And Click on more actions=>"View as Table"
    And Click on Attributes from the table list
    And Select attributes checkbox
    And Click title attribute checkbox
    Then "All" attributes should be selected

  @CDMNextsprintcases3.1
  Scenario: TC_15341_03: Verify unselect all attributes with unchecking main checkbox
    And Select few series
    #And Click on more actions to create "View as Table"
     And Click on more actions=>"View as Table"
    And Click on Attributes from the table list
    And Select attributes checkbox
    And Double click title attribute checkbox
    Then "None" attributes should be selected

  @CDMNextsprintcases3.1
  Scenario: TC_15341_04: Verify partly check attributes
    And Select few series
    #And Click on more actions to create "View as Table"
     And Click on more actions=>"View as Table"
    And Click on Attributes from the table list
    And Select attributes checkbox
    Then "Partial" attributes should be selected

  @CDMNextsprintcases3.1
  Scenario: TC_15494_01: Verify title for Ask a question popup
    And Go to search
    And hightlight any one series from search list and click on  "i" icon .
    And Open SSP window
    And Verify the title in SSP Window	
    
    And Click on Ask Question link in SSP window
    Then The title should be "Ask a question about"

 # @CDMNextsprintcases3.1
  #Scenario: TC_15269_01: Verify ascending and descending icon for 'Recently update' sort by
   # And Search for the series with SID "205424302;205441502;205428302"
    #And Select 2 series and click on "A" option
    #And Select all series from myseries and click on "Customize your selection" option
    #And Customize popup is opened and Click on "Sort series by" option
    #And Click "Recently Updated" option from dropdown
    #And Clicking "Save" option
    #Then Ascending and descending icon should not displayed for "Recently Updated"

  #@CDMNextsprintcases3.1
  #Scenario: TC_14142_01: Verify downloading CNA packages
    #And Click "Help" > "Excel Addin"
    #Then User should download the builds

  @CDMNextsprintcases3.1
  Scenario: TC_14668_01: Verify zebra selection under Edit table
    And Select few series
    #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Choose options "Zebra" > "Rows"
    Then Should enable only "Rows" coloring when selected zebra checkbox

  #TC_14172_01 and TC_14172_03
  @CDMNextsprintcases3.1
  Scenario: TC_14172_01: Verify click on '+' icon and save option to save a custome style
    And Select few series
   # And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Uncheck the "Attributes" and "Wrap text" options
    And Create a new template
    Then The new template should be created in the beginning of the list
    And Select few series
    #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And "Delete template" the newly created customized template

  @CDMNextsprintcases3.1
  Scenario: TC_14172_04: Verify cancel icon
    And Select few series
    #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Uncheck the "Attributes" and "Wrap text" options
    And Create a new template and "Template popup" and click "Cancel" icon
    Then The popup should be closed

  @CDMNextsprintcases3.11
  Scenario: TC_Cvision_12162: Verify default style template for future visual creation
    And Select few series
    #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Uncheck the "Attributes" and "Wrap text" options
    And Create a new template and "Set as default for future Table visual"
    And Clicking "Save" option
    And Select few series
    #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And "Delete template" the newly created template
    Then The new visual should be created with selected template style

  @CDMNextsprintcases3.1
  Scenario: TC_Cvision_13924_1: Verify cogwheel icon for visual
    And Select few series
   # And Click on more actions to create "View as Table"
   And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Check the legend icon at visual and edit visual
    Then "Rename" , "Frequency" , "Currency" and "Change" should be displayed

  @CDMNextsprintcases3.1
  Scenario: TC_13924_02: Cogwheel - Verify Rename
    And Select few series
   # And Click on more actions to create "View as Table"
   And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Check the legend icon at visual and edit visual
    And Click "Rename" text from cogwheel
    Then "Rename" option should display

  @CDMNextsprintcases3.1
  Scenario: TC_13924_03: Cogwheel - Verify Frequency
    And Select few series
   # And Click on more actions to create "View as Table"
   And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Check the legend icon at visual and edit visual
    And Click "Frequency" text from cogwheel
    And Click "Weekly (Distribute)" from the drop down
    Then The selected "Frequency" is applied to the table

  @CDMNextsprintcases3.1
  
  Scenario: TC_13924_05: Cogwheel - Verify Change
    And Select few series
    #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Check the legend icon at visual and edit visual
    And Click "Change" text from cogwheel
    And Click "Difference Year-over-Year (YoY)" from the drop down
    Then The selected "Change" is applied to the table visual

  @Preferences123
  Scenario: TC_13924_07: Verify remove series icon
    And Select few series
    And Click on more actions to create "View as Table"
    And Click on "Edit Table" visual
    And Check the legend icon at visual and remove visual
    Then The series should be removed from the visual

  @CDMNextsprintcases3.1
  Scenario: TC_15651_01: Verify Selected style visiblity in the template list
    And Select few series
    And Click on more actions=>"View as Table"
   # And Click on more actions to create "View as Table"
    And Click on "Edit Table" visual
    And Uncheck the "Attributes" and "Wrap text" options
    And Create a new template and "Template popup"
    And Clicking on the hiding template from the style template dropdown
    Then Selected template should be visible in the template Menu

  @CDMNextsprintcases3.1
  Scenario: TC_15289_01: Verify 'Add related series' option for empty visual
    And Click to create an empty visual
    And Click on empty "Table" visual
    And Observe the "Add related series" button
    Then "Add related series" should not be available for empty visual

  #n1
  #Scenario: TC_14173_01: Verify Unit in histogram tooltip
  #And Right click on any series level of data from series
  #And Click on more actions
  #And Choose "View as ..." > "Histogram"
  #And Capture the "Unit:" tooltip indicator value
  #Then  "Unit" should be shown on tooltip
  @CDMNextsprintcases3.1
  Scenario: TC_15656_01: Verify Histogram methodology
    And Right click on any series level of data from series
    #And Click on more actions
    And Click on more actions dropdown
    And create a Histogram.
   # And Choose "View as ..." > "Histogram"
    And Mouse over to "help-button"
    Then Histogram methodology info should be displayed in tooltip

  @CDMNextsprintcases3.1
  Scenario: TC_15656_02: Verify Histogram methodology in Insight view mode
    And Right click on any series level of data from series
    #And Click on more actions
    And Click on more actions dropdown
    And create a Histogram.
   # And Choose "View as ..." > "Histogram"
    And Click "File" > "View"
    And Click the new insight option
    And Mouse over to "help-button" from insights
    Then Histogram methodology info should be displayed in tooltip

  @CDMNextsprintcases3.1
  Scenario: TC_13671_01: Verify tooltip for 'Contents' icon on footnotes
    And Click "Help" > "Footnotes"
    And Collapse the footnotes
    And Hover on to the "Open Contents"
    Then "Open Contents" tooltip should be displayed

  @CDMNextsprintcases3.11
  Scenario: TC_13651_01: Verify upload popup behaviour when the upload is completed
    And Click to create an empty visual
    And Click "Image" option from empty list
    And Click "Upload image" button to upload images
    Then Verify the uploaded image comes under iframe

  #@Cvision1... not executing
  #Scenario: TC_16290_01: Verify shadow for notification panel
  #And Open notification panel
  #Then Shadow should be applied to notification panel
  @CDMNextsprintcases3.11
  Scenario: TC_14907_01: Verify message for non data visual copy
    And Click to create an empty visual
    And Click "Image" option from empty list
    And Click "Upload image" button to upload images
    And Click "Copy" button in images wizard
    Then "Image copied" message for non data visual should be displayed

  @CDMNextsprintcases3.1
  Scenario: TC_14601_01: Verify confirmation message for copy link
    And Click on my insights
    And Click "View as a table"  from empty list
    And Right click on Insight name and click on "Copy link"
    Then The message should be "Link is copied"
    And Navigating to back

  @CDMNextsprintcases3.1
  Scenario: TC_14601_02: Verify confirmation message for copy Insight
    And Click on my insights
    And Click "View as a table"  from empty list
    And Right click on Insight name and click on "Copy"
    And Click on the insight button "Copy Insight"
    Then The message should be "Selected insight(s) copied"
    And Navigating to back

  @Cvision
  Scenario: TC_15328_01: Verify loader for PDF viewer
    And Click "File" > "Open"
    And Click on "Analysis" tab in insights
    And Click on one ingisht under EMIS insight
    Then "Loading insight..." label should be displayed under the spinner

  @CDMNextsprintcases3.1
  Scenario: TC_15336_01: Verify mouse hover tooltip when only move the mouse on series name
    And Select "Series" tab in header
    Then Tooltip only displayed when hover the mouse on series name

  @CDMNextsprintcases3.11
  Scenario: TC_14781_01: Verify creating non data visuals with series
    And Select few series
    And Click to create an empty visual
    And Click "Image" option from empty list
    And Click "Upload image" button to upload images
    And Select my series tab
    Then The non data visuals should not create with series

  @CDMNextsprintcases3.1
  Scenario: TC_15107_01: Verify search with old city name and updated city name.
    And Search for the series with SID "Bengaluru"
    And Getting the text of first search keyword
    And Search for the series with SID "Bangalore"
    And Getting the text of next search keyword
    Then Both the series results should be same

  @CDMNextsprintcases3.1
  Scenario: TC_15910_01: Verify new title for "Series data conversion" popup
    And Search for the series with SID "384681617;385320997"
    And Click on more actions and create "View as Table"
   # And Click on more actions to create "View as Table"
    And Observe the "movable-modal--title-message" for popup
    Then The title of the pop up should be "Series Harmonization"

  @CDMNextsprintcases3.1
  Scenario: TC_15910_02: Verify description for "Series Harmonization" popup
    And Search for the series with SID "384681617;385320997"
    And Click on more actions and create "View as Table"
    #And Click on more actions to create "View as Table"
    And Observe the "series-data-conversion--info" for popup
    Then The message in the pop up should be "Your selection includes series of different frequency and calendar. Please perform these conversions for better analysis and visualization."

  @CDMNextsprintcases3.1
  Scenario: TC_15649_01: Verify 'Enter' for save style template
    And Reset the values in "Series" tab
    And Select few series
    #And Click on more actions to create "View as Table"
    And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And Uncheck the "Attributes" and "Wrap text" options
    And Create a new template
    Then The style template should be saved
    And Select few series
    #And Click on more actions to create "View as Table"
     And Click on more actions=>"View as Table"
    And Click on "Edit Table" visual
    And "Delete template" the newly created template
    And Close the model box

  @CDMNextsprintcases3.1
  Scenario: TC_16428_01: Verify Notification icon click
    And Open notification panel
    Then The notification panel is opened
    And Open notification panel

  @Cvision
  Scenario: TC_16428_02: Verify Notification tab
    And Open notification panel
    Then The notification panel is opened
    And Open notification panel

  @Preferences
  Scenario: TC_16310_01: Verify user name on preference dropdown
    #And Login as current execution login by taking username rowcount as 1 and cellcount as 0 and for password rowcount as 1 and cellcount as 1
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Choose "Prefix" , "First Name" , "Last Name" from preferences
    And Close the dialog popup
    And Open preference dropdown
    Then Prefix,First name and Last name should be displayed
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_02: Verify User name Edit icon
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Check for the popup window in preferences
    And Close the dialog popup
    Then "Change profile settings" popup should be displayed

  @Preferences
  Scenario: TC_16310_03: Verify changing prefix
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Click on edit in "Prefix" from preferences
    And Click "Save" button in preferences
    And Open preference dropdown
    Then The updated prefix should show under preference
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_04: Verify changing user's first name
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Click on edit in "First Name" from preferences option
    And Click "Save" button in preferences
    And Click Refresh button in settings changed
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Getting the value in "First Name" from user preferences
    And Getting the value in "Last Name" from user preference option
    And Close the dialog popup
    And Refresh page
    And Open preference dropdown
    Then The updated "First Name" should show under preference
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_05: Verify changing user's last name
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Click on edit in "Last Name" from preferences options
    And Click "Save" button in preferences
    And Click Refresh button in settings changed
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Getting the value in "First Name" from user preferences
    And Getting the value in "Last Name" from user preference option
    And Close the dialog popup
    And Refresh page
    And Open preference dropdown
    Then The updated "Last Name" should show under preference
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_06: Validate "E-mail" field under Profile
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Click on edit in "Email" option from preferences
    Then "Email" ID should be pre-exist in non editable mode
    And Close the dialog popup

  @Preferences
  Scenario: TC_16310_07: Verify Save button
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Click on edit in "First Name" from preferences dropdown
    And Click "Save" button in preferences
    And Click Refresh button in settings changed
    And "Change profile settings" popup should be closed
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Getting the value in "First Name" from user preferences
    Then The user changes should "Save"
    And Close the dialog popup

  @Preferences
  Scenario: TC_16310_08: Verify Cancel/X button
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Click on edit in "Last Name" from preferences dropdown
    And Click "Cancel" button in preferences
    And "Change profile settings" popup should be closed
    And Open preference dropdown
    And Click on "profile-menu--edit-icon" from preferences
    And Getting the value in "Last Name" from user preference option
    Then The user changes should "Not Save"
    And Close the dialog popup

  @Preferences
  Scenario: TC_16310_09: Validate "Profile picture"
    And Open preference dropdown
    And Click on "edit-avatar--edit-btn" from preferences
    And Click on the Upload button to upload "Image"
    Then The image should upload successfully

  @Preferences
  Scenario: TC_16310_10: Verify "Profile picture" uploading with max size
    And Open preference dropdown
    And Click on "edit-avatar--edit-btn" from preferences
    And Click on the Upload button to upload "Large Image"
    Then "Max avatar size is 1Mb" error message should be displayed
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_11: Verify different types of files upload
    And Open preference dropdown
    And Click on "edit-avatar--edit-btn" from preferences
    And Click on the Upload button to upload "Videos"
    Then "Avatar could be .jpg, .jpeg or .png" error message should be displayed
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_12: Validate 'Change password' option
    And Open preference dropdown
    And Click on "Change password" from preferences
    Then "Change password" popup should appear
    And Close the dialog popup

  @Preferences
  Scenario: TC_16310_13: Verify New and retype password field
    And Open preference dropdown
    And Click on "Change password" from preferences
    And Enter the password "Old password" as "Ceic@123"
    And Enter the password "New password" as "Ceic@1234567"
    And Enter the password "Retype new password" as "Ceic@1234567"
    And Click "Save" button in preferences
    Then "Your password has been successfully changed" message needs to appear

  @Preferences
  Scenario: TC_16310_14: Verify validation message for old password wrong entered
    And Open preference dropdown
    And Click on "Change password" from preferences
    And Enter the password "Old password" as "Ceic@123456"
    And Enter the password "New password" as "Ceic@12345678"
    And Enter the password "Retype new password" as "Ceic@12345678"
    And Click "Save" button in preferences
    Then "Incorrect current password" message needs to appear

  @Preferences
  Scenario: TC_16310_17: Verify validation message for password mismatch
    And Open preference dropdown
    And Click on "Change password" from preferences
    And Enter the password "Old password" as "Ceic@1234567"
    And Enter the password "New password" as "Ceic@12345678"
    And Enter the password "Retype new password" as "Ceic@123456789"
    And Click "Save" button in preferences
    Then "Password repeat must be the same as New Password" message needs to appear

  @Preferences
  Scenario: TC_16310_19: Verify Cancel button
    And Open preference dropdown
    And Click on "Change password" from preferences
    And "Change password" popup should appear
    And Click "Cancel" button in preferences
    And Open preference dropdown
    Then Click on "Change password" from preferences menu
    And Close the dialog popup

  @Preferences
  Scenario: TC_16310_21: Validate language selection - English
    And Open preference dropdown
    And Select "English" as language
    And Capture the Selected language
    And Open preference dropdown
    Then The UI should contains "Datasets" for language "English"

  @Preferences
  Scenario: TC_16310_22: Validate language selection - ??
    And Open preference dropdown
    And Select "??" as language
    And Open preference dropdown
    And Capture the Selected language
    And Open preference dropdown
    Then The UI should contains "???" for language "??"

  @Preferences
  Scenario: TC_16310_23: Validate language selection - ???
    And Open preference dropdown
    And Select "???" as language
    And Open preference dropdown
    And Capture the Selected language
    And Open preference dropdown
    Then The UI should contains "??????" for language "???"

  @Preferences
  Scenario: TC_16310_24: Validate language selection - ???
    And Open preference dropdown
    And Select "???" as language
    And Open preference dropdown
    And Capture the Selected language
    And Open preference dropdown
    Then The UI should contains "??? ??" for language "???"

  @Preferences
  Scenario: TC_16310_25: Validate language selection - ???????
    And Open preference dropdown
    And Select "???????" as language
    And Open preference dropdown
    And Capture the Selected language
    And Open preference dropdown
    Then The UI should contains "??????? ??????" for language "???????"

  @Preferences
  Scenario: TC_16310_26: Validate language selection - Bahasa
    And Open preference dropdown
    And Select "Bahasa" as language
    And Open preference dropdown
    And Capture the Selected language
    And Open preference dropdown
    Then The UI should contains "Set Data" for language "Bahasa"
    And Open preference dropdown
    And Select "English" as language
    And Wait for the language to update

  @Preferences
  Scenario: TC_16310_27: Verify Date Format - Date(Automatic)
    And Open preference dropdown
    And Clicking on "Date format" option in preference
    And Click "Auto" format date option
    And Select few series
    And Open SSP for the selected series
    And Select Updated date format in SSP
    Then "Auto" data format should be updated in the application

  @Preferences
  Scenario: TC_16310_28: Verify Date Format - Date(Custom)
    And Open preference dropdown
    And Clicking on "Date format" option in preference
    And Click "Custom" format date option
    And Enter "Valid" custom date
    And Select few series
    And Open SSP for the selected series
    And Select Updated date format in SSP
    Then "Custom" data format should be updated in the application

  @Preferences
  Scenario: TC_16310_29: Verify invalid format entry in custom field
    And Open preference dropdown
    And Clicking on "Date format" option in preference
    And Click "Custom" format date option
    And Enter "Invalid" custom date
    Then "Invalid date format. Please enter a valid format" message should display in "Red" color
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_30: Verify saving with empty date format
    And Open preference dropdown
    And Clicking on "Date format" option in preference
    And Click "Custom" format date option
    And Enter "Empty" custom date
    Then "Custom date pattern cannot be empty" message should display in "Red" color
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_31: Verify Number format - Decimal Places
    And Open preference dropdown
    And Clicking on "Number format" option in preference
    And Click on "Decimal places" in format and enter value as 2
    And Refresh page
    And Open preference dropdown
    And Clicking on "Number format" option in preference
    And Get Value of "Decimal separator" in Preference
    And Get Text on "Decimal places" in format
    And Refresh page
    And Search for the series "5823601"
    And Open SSP for the selected series
    And Click on "Data" tab
    And Capture the Timepoint value inside "Data" tab
    Then Decimal places should be as per the selection in "Data" tab

  @Preferences
  Scenario: TC_16310_32: Verify Number Formate - Decimal separator
    And Open preference dropdown
    And Clicking on "Number format" option in preference
    And Click on "Decimal places" in format and enter value as 4
    And Refresh page
    And Open preference dropdown
    And Clicking on "Number format" option in preference
    And Get Text on "Decimal places" in format
    And Get Value of "Decimal separator" in Preference
    And Search for the series with SID "384226477"
    And Open SSP for the selected series
    And Click on "Data" tab
    And Capture the Timepoint value inside "SSP" tab
    Then Check the data in the insight for "Decimal separator"

  @Preferences
  Scenario Outline: TC_16310_33: Verify Number Formate - Grouping separator
    And Open preference dropdown
    And Clicking on "Number format" option in preference
    And Enter <grouping_separator> values
    Then Check the data in the insight for "Grouping separator"

    Examples: 
      | grouping_separator |
      | "."                |
      | "Space"            |
      | "'"                |
      | "-"                |
      | "None"             |
      | ","                |

  @Preferences
  Scenario: TC_16310_34: Preferences - Verify 'Ask me to confirm the download settings' - Checked
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown
    And Open preference dropdown
    And Check the checkbox for "Ask me to confirm the download settings"
    And Select few series
    And Click on Download button in header
    And Check for "Download" popup
    Then "Download settings" window should be "appeared" and the count is 1

  @Preferences
  Scenario: TC_16310_35: Preferences - Verify 'Ask me to confirm the download settings' - Unchecked
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Uncheck"
    And Open preference dropdown
    And Open preference dropdown
    And Check the checkbox for "Ask me to confirm the download settings"
    And Select few series
    And Click on Download button in header
    And Check for "Download" popup
    Then "Download settings" window should be "not appeared" and the count is 0

  @Preferences
  Scenario: TC_16310_36: Preferences - Verify the case for Download window appered even download settings unchecked
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Uncheck"
    And Open preference dropdown
    And Open preference dropdown
    And Check the checkbox for "Ask me to confirm the download settings"
    And Add few series to myseries
    And Right Click the selected series to "Copy data"
    And Check for "Download" popup
    Then "Download settings" window should be "appeared" and the count is 1
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown

  @Preferences
  Scenario: TC_16310_37: Preferences - Verify unchecking 'Ask me to confirm the download settings' in download popup
    And Select few series
    And Click on the download button in header
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Uncheck"
    And Click on the download button in popup
    And Close the dialog popup
    And Open preference dropdown
    And Check the checkbox for "Ask me to confirm the download settings"
    Then The checkbox should be unchecked for "Ask me to confirm the download settings"

  @Cvision
  Scenario: TC_16310_38: Preference - Verify 'Visual deletion - Unchecked'
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Uncheck"
    And Search for the series with SID "385345667"
    And Click on more actions
    #And Open a "Chart" visual
    And Try to delete the visual
    Then Delete visual confirmation message should not be displayed to users while deleting visual

  @Preferences
  Scenario: TC_16310_40: Preference - Verify 'Show latest changes in my insights upon login' - 'Checked'
    And Open preference dropdown
    And Clicking on "Show latest changes in my insights upon opening" option under user preference to be "Check"
    And Create new and Save the Insight
    And Search for the series with SID "253736802"
    And Add Replacement series to myseries
    And Refresh page
    And Closing the replacement button
    And Open preference dropdown
    And Click on "Sign out" from the application
    And Login back to application
    And Click on "My insights" option in layout
    And Check for Replacement Suggestion Popup
    And Open preference dropdown
    And Check the checkbox for "Show latest changes in my insights upon opening"
    And Open preference dropdown
    Then The "Replacement popup" should "be" displayed to the user

  @Preferences
  Scenario: TC_16310_41: Preference - Verify 'Show latest changes in my insights upon login' - 'Unchecked'
    And Open preference dropdown
    And Clicking on "Show latest changes in my insights upon opening" option under user preference to be "Uncheck"
    And Create new and Save the Insight
    And Search for the series with SID "253736802"
    And Add Replacement series to myseries
    And Refresh page
    And Open preference dropdown
    And Click on "Sign out" from the application
    And Login back to application
    And Click on "My insights" option in layout
    And Check for Replacement Suggestion Popup
    And Open preference dropdown
    And Check the checkbox for "Show latest changes in my insights upon opening"
    And Open preference dropdown
    Then The "Replacement popup" should "not be" displayed to the user

  @Preferences
  Scenario: TC_16310_42: Preference - Verify Unchecking checkbox in replacement popup
    And Open preference dropdown
    And Clicking on "Show latest changes in my insights upon opening" option under user preference to be "Check"
    And Create new and Save the Insight
    And Search for the series with SID "253736802"
    And Add Replacement series to myseries
    And Refresh page
    And Check "Do not show again" Checkbox in replacement popup
    And Open preference dropdown
    And Check the checkbox for "Show latest changes in my insights upon Login"
    And Open preference dropdown
    Then The "Replacement popup" should not be displayed to the user and should be unchecked under preference as well

  @Preferences
  Scenario: TC_16310_43: Preference - Verify 'Preserve search selection after actions - Checked'
    And Open preference dropdown
    And Clicking on "Preserve search selection after download/CTC actions" option under user preference to be "Check"
    And Reset the values in "Series" tab
    And Select few series
    And Perform Download operation
    Then The Series "has not" removed in search panel after done actions

  @Preferences
  Scenario: TC_16310_44: Preference - Verify 'Preserve search selection after actions - Unchecked'
    And Open preference dropdown
    And Clicking on "Preserve search selection after download/CTC actions" option under user preference to be "Uncheck"
    And Reset the values in "Series" tab
    And Select few series
    And Perform Download operation
    Then The Series "has" removed in search panel after done actions
#
  #@Cvision123
  #Scenario: TC_16310_45: Preference - Verify 'Always preserve the order of selection when adding/downloading series= Checked'
    #And Open preference dropdown
    #And Clicking on "Preserve the order of selection when adding/downloading series" option under user preference to be "Check"
    #And Reset the values in "Series" tab
    #And Select few series
    #And Perform Download operation
    #Then The Series "has" removed in search panel after done actions

  @Preferences
  Scenario: TC_16310_47: Preference - 'Show search result without pagination= Uncheck'
    And Open preference dropdown
    And Clicking on "Show search results without pagination" option under user preference to be "Uncheck"
    And Open preference dropdown
    And Open preference dropdown
    And Check the checkbox for "Show search results without pagination"
    And Reset the values in "Series" tab
    Then Pagination option "should" visible

  @Preferences
  Scenario: TC_16310_47: Preference - 'Show search result without pagination= check'
    And Open preference dropdown
    And Clicking on "Show search results without pagination" option under user preference to be "Check"
    And Open preference dropdown
    And Open preference dropdown
    And Check the checkbox for "Show search results without pagination"
    And Reset the values in "Series" tab
    Then Pagination option "should not" visible

  @Preferences
  Scenario: TC_16310_51: Preference - Verify Keyboard Shortcut - 'ON'
    And Open preference dropdown
    And Clicking on "Keyboard shortcuts" option under user preference be "ON"
    And Reset the values in "Series" tab
    And Select few series
    And Perform any Keyboard operation
    Then The "Keyboard Shortcut" action "should" possible

  @Preferences
  Scenario: TC_16310_52: Preference - Verify Keyboard Shortcut - 'OFF'
    And Open preference dropdown
    And Clicking on "Keyboard shortcuts" option under user preference be "OFF"
    And Reset the values in "Series" tab
    And Select few series
    And Perform any Keyboard operation
    Then The "Keyboard Shortcut" action "should not" possible

  @Preferences
  Scenario: TC_16310_53: Preference - Verify clicking on keyboard hints option
    And Open preference dropdown
    And Clicking on "keyboard hints" option under user preference
    Then The "Keyboard Shortcuts" dialog box should open

  @Preferences
  Scenario: TC_16310_56: Preference dropdown - Verify excel add-in
    And Open preference dropdown
    And Clicking on "Excel Add-in" option under user preference
    Then The "Applications Help" dialog box should open and "Excel Add-in" is default

  @Preferences
  Scenario: TC_16310_57: Preference dropdown - Verify CEIC API access
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    Then The "CEIC API Access" dialog box should open

  @Preferences
  Scenario: TC_16310_58: CEIC API access - Verify description message for API popup
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    Then The "You already have generated an API key. You can verify your API key here, or generate a new one to replace your previous key" message in dialog box should display

  @Preferences
  Scenario: TC_16310_59: CEIC API Access - Verify the token field
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    Then Paste the token "dLqP2gucYVN1wQUSlz8zPNqHhnAOMReHKyWAiR7vd7SvJuBPQGbycFvjcySlNZfqtGoznlcJbZS47Nj4OU0GzvlIAfeT07EyLL8yBYJmqWoKrhmchKOq4GNGi09fSpmx" to "Enable Verify Key" button

  @Preferences
  Scenario: TC_16310_60: CEIC API Access - Verify the token field
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    Then Paste the token "dLqP2gucYVN1wQUSlz8zPNqHhnAOMReHKyWAiR7vd7SvJuBPQGbycFvjcySlNZfqtGoznlcJbZS47Nj4OU0GzvlIAfeT07EyLL8yBYJmqWoKrhmchKOq4GNGi09fSpmx" to "Disable Verify Key" button

  @Preferences
  Scenario: TC_16310_61: CEIC API Access - Validate the 'Verify key' button
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    And Copied API key is stored into a string
    And Click on "Verify Key " button from CEIC API access
    Then The "The key is valid" message should come in "#53b582" color

  @Preferences
  Scenario: TC_16310_62: CEIC API Access - Validate the 'Verify key' button
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on "Cancel" button from CEIC API access
    Then The "The key is invalid" message should come in "#ef5350" color

  @Preferences
  Scenario: TC_16310_63: CEIC API Access - Verify 'Generate new key' button
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    Then The new token key should be generated

  @Preferences
  Scenario: TC_16310_64: CEIC API Access - Verify 'Copy' button
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    Then Copied message should display

  @Preferences
  Scenario: TC_16310_65: CEIC API Access - Validate copied token
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    And Copied API key is stored into a string
    Then Open the link in a new tab and verify

  @Preferences
  Scenario: TC_16310_66: CEIC API Access - Verify message after copy token
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    Then The "API key copied to clipboard" message should be displayed

  @Preferences
  Scenario: TC_16310_67: CEIC API Access - Verify popup description after generated new token
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    Then The description of CEIC API access popup should be "Your API key has been generated"

  @Preferences
  Scenario: TC_16310_68: CEIC API Access -  Verify CEIC API Help option
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on "CEIC API Help" help button from CEIC API access
    And CEIC Help dialog box is opened
    Then The default tab should be "API"

  @Preferences
  Scenario: TC_16310_69: CEIC API Access -  Verify Cancel/x icon
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on close button of CEIC API access dialog box
    Then The popup should be cancelled

  @Preferences
  Scenario: TC_16310_70: Verify closing of Preference dropdown
    And Open preference dropdown
    And Open preference dropdown
    Then Preference dropdown should be closed

  @Preferences
  Scenario: TC_16310_71: Preference - Verify Sign out option
    And Open preference dropdown
    And Click on "Sign out" from the application
    Then The application should be logged out
