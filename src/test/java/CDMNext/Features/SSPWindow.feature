Feature: Verifying SSP window Functionality

  @SSPWindow
  Scenario: TC_SSP_01: Try to open SSP window from myseries
    And Open preference dropdown
    And Clicking on "Date format" dropdown option in preference
    And Click "Custom" format date option
    And Enter "Valid" custom date
    And Open preference dropdown
    And Add few series to myseries
    And hightlight any one series and click on series name
    Then Verify SSP window

  @SSPWindow
  Scenario: TC_SSP_02: Try to open SSP window from Search
    And Go to search
    And hightlight any one series from search list and click on series name
    Then Verify SSP window

  @SSPWindow
  Scenario: TC_SSP_03: Verify the options available on the main bar of the SSP window
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window and clicking on "+" icon
    Then Verify options on top bar of window

  @SSPWindow
  Scenario: TC_SSP_04: Verify the Add option
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Click on Add option
    Then The series should add into right pane

  @SSPWindow
  Scenario: TC_SSP_05: Verify the Add and group option
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Click on Add and group option
    Then The series should add into right pane and "Group"

  @SSPWindow
  Scenario: TC_SSP_06: Verify the Add to new insight option
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Click on Add to new insight option
    And Series has been added to new insight message should display
    Then Clicking on the insight name should open the new insight with the added series

  @SSPWindow
  Scenario: TC_SSP_07: Verify the Add to existing insight option
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Click on Add to recent insight option
    And Click on sub dropdown option
    Then Any insight could be selected for the series to add

  @SSPWindow
  Scenario: TC_SSP_08: Verify create chart option
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And click on create chart option
    Then chart should be created in a view for series

  @SSPWindow
  Scenario: TC_SSP_09: Verify Download button option
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Click on download button
    And Download data to excel
    Then Should be able to download data

  @SSPWindow
  Scenario: TC_SSP_10: Verify minimize button
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Clicking on minimize icon
    Then verify that SSP window should be minimized

  @SSPWindow
  Scenario: TC_SSP_11: Verify full screen button
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Clicking on full screen icon
    Then verify that SSP window SSP window should be maximized to full screen

  @SSPWindow
  Scenario: TC_SSP_12: Verify close button
    And Go to search
    And hightlight any one series from search list and click on series name
    And Open SSP window
    And Clicking on close button
    Then Verify that SSP window SSP window should be closed

  @SSPWindow
  Scenario: TC_SSP_13: Verify attributes display in SSP window
    And Add few series to myseries
    And hightlight any one series from search list and click on series name
    And Open SSP window
    Then Verify attributes such as Region,frequency,unit,indicator,source and read more

  @SSPWindow
  Scenario: TC_SSP_14: Verify region in SSP window
    And Open SSP for the series "385319507"
    And Checking the "Region:" of the series
    Then Verify the "Region:" of the series should be "China"

  @SSPWindow
  Scenario: TC_SSP_15: Verify frequency in SSP window
    And Open SSP for the series "385319507"
    And Checking the "Frequency:" of the series
    Then Verify the "Frequency:"of the series should be "Monthly"

  @SSPWindow
  Scenario: TC_SSP_16: Verify unit in SSP window
    And Open SSP for the series "385319507"
    And Checking the "Unit:" of the series
    Then verify the "Unit:" of the series should be "2012=100"

  @SSPWindow
  Scenario: TC_SSP_17: Verify Series ID in SSP window
    And Open SSP for the series "5724301"
    Then Verify the Series id should be "5724301"

  @SSPWindow
  Scenario: TC_SSP_18: Verify SR code in SSP window
    And Open SSP for the series "5724301"
    Then SR code has to be "SR280306"

  @SSPWindow
  Scenario: TC_SSP_19: Verify Mnemonic in SSP window
    And Open SSP for the series "5724301"
    Then Mnemonic code should be "CN.CPI.PY.M"

  @SSPWindow
  Scenario: TC_SSP_20: Verify Mnemonic hyperlink in SSP window
    And Open SSP for the series "5724301"
    And Click on the mnemonic hyperlink
    Then Navigate to search result of same series in series pane

  @SSPWindow
  Scenario: TC_SSP_21: Verify blue color for udpated timepoint
    And Open SSP for the series "5724301"
    Then Recently updated timepoints within 30 days should highlight in blue color

  @SSPWindow
  Scenario: TC_SSP_22: Verify orange color for forecast timepoint
    And Open SSP for the series "72903202"
    Then Forecast timepoints should be highlighted in orange color

  @SSPWindow
  Scenario: TC_SSP_23: Verify indicator drop down
    And Close the popup
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And clicking indicator drop down
    Then Drop down should display indicators list and clicking on specific indicators should navigate to results page

  @SSPWindow
  Scenario: TC_SSP_24: Verify indicator selection from drop down
    And Close the popup
    And Resetting the filters
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    Then Selecting indicator from indicator drop down should show search result in left for same indicator

  @SSPWindow
  Scenario: TC_SSP_25: Verify source link
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on "Source:" name
    Then It should apply source filter in search pane to display it's result

  @SSPWindow
  Scenario: TC_SSP_26: Verify display of remarks for a series in SSP
    And Search for the series "1053401"
    And hightlight any one series and click on series name
    And Open SSP window
    Then Respective remarks of series should display

  @SSPWindow
  Scenario: TC_SSP_27: Verify read more option
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And click on "Read More" link in SSP window
    Then Footnotes window should be displayed with related details

  @SSPWindow
  Scenario: TC_SSP_28: Verify Ask Question link
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on Ask Question link in SSP window
    Then Should open still can not find an answer window

  @SSPWindow
  Scenario: TC_SSP_29: Trying to send a question
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on Ask Question link in SSP window
    And Still can not find an answer window opens now enter question and click on submit
    Then Verify that user should be able to send question successfully

  @SSPWindow
  Scenario: TC_SSP_30: Verify chart tab
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on chart tab
    Then Should create a chart visual

  @SSPWindow
  Scenario: TC_SSP_31: Verify zoom=1y
    And Open SSP for the series "5724301"
    And Open SSP window
    And Click on chart tab
    And Select "1Y" tab
    Then Last 1 year data to be plotted in chart visual

  @SSPWindow
  Scenario: TC_SSP_32: Verify zoom=3y
    And Open SSP for the series "5724301"
    And Open SSP window
    And Click on chart tab
    And Select "3Y" tab
    Then Last 3 year data to be plotted in chart visual

  @SSPWindow
  Scenario: TC_SSP_33: Verify zoom=5y
    And Open SSP for the series "5724301"
    And Open SSP window
    And Click on chart tab
    And Select "5Y" tab
    Then Last 5 year data to be plotted in chart visual

  @SSPWindow
  Scenario: TC_SSP_34: Verify zoom=All
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on chart tab
    And Select "All" tab
    Then Complete data for the series has to be plotted in chart visual

  @SSPWindow
  Scenario: TC_SSP_35: Verify From and To dates
    And Search for the series "1053401"
    And hightlight any one series and click on series name
    And Open SSP window
    And Enter from and to dates
    Then chart visual should update for the dates entered

  @SSPWindow
  Scenario: TC_SSP_36: Verify Data tab
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on "Data" tab
    And Observe full data display
    Then Complete observations must be displayed

  @SSPWindow
  Scenario: TC_SSP_37: Verify default no of timepoints displayed in chart
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    Then Should have lst 24 obs

  @SSPWindow
  Scenario: TC_SSP_38: Verify YTD,1Y,3Y,5Y,ALL options
    And Search for the series "210337202"
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on chart tab
    And Select "YTD" , "1Y" , "3Y" , "5Y" , "All" tabs
    Then Last 1 year, 3 year, 5 year, "All" data to be plotted in chart visual

  @SSPWindow
  Scenario: TC_SSP_39: Verify timeframe option for chart
    And Search for the series "1053401"
    And hightlight any one series and click on series name
    And Open SSP window
    And In Chart tab click on timeframe date field and change date
    Then Should display chart for timepoints within that timeframe range

  @SSPWindow
  Scenario: TC_SSP_40: Verify related data tab
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on Related data tab
    And Check contents inside Related data

  @SSPWindow
  Scenario: TC_SSP_41: Click on each links under datasets and verify
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on Related data tab
    Then Click on first link available under "Datasets" and verify the changes

  @SSPWindow
  Scenario: TC_SSP_42: Click on each links under insights and verify
    And Add few series to myseries
    And hightlight any one series and click on series name
    And Open SSP window
    And Click on the "Related Insights" tab
    And Check the data available under "Insights" and it should open respective insights
    And Check the data of first insight

  @SSPWindow
  Scenario: TC_SSP_43: Check for adding suggested series from SSP window
    And Search for the series "253736802"
    And hightlight any one series and click on series name
    And click on "Manage" suggestions subscription link
    And Click on "Add" , "Apply" and "Ok" buttons
    Then Suggested series has to be added into right pane into the same insight

  @SSPWindow
  Scenario: TC_SSP_44: Check for adding suggested series from SSP window
    And Search for the series "253736802"
    And hightlight any one series and click on series name
    And click on "Manage" suggestions subscription link
    And Click on "Replace" , "Apply" and "Ok" button
    Then The discontinued series has to be replaced with suggested series into right

  @SSPWindow
  Scenario: TC_SSP_45: Verify the preview option for rebased series in SSP window
    And Search for the series "253736802"
    And hightlight any one series and click on series name
    And click on "Manage" suggestions subscription link
    And Click on "Preview" button
    Then Both inactive and suggestion should be viewed as chart

  @SSPWindow
  Scenario: TC_SSP_46: Verify click on the replacement suggestion series
    And Search for the series "1053401"
    And hightlight any one series and click on series name
    And click on "Manage" suggestions subscription link
    And Click on replacement series name hyperlink
    Then SSP for replacement series should open as a new popup

  @SSPWindow
  Scenario: TC_SSP_47: Verify click on the replacement suggestion series dropdown
    And Search for the series "1053401"
    And hightlight any one series and click on series name
    And click on "Manage" suggestions subscription link
    Then Both inactive and suggestion should be viewed as chart

  @SSPWindow
  Scenario: TC_SSP_48: Verify SSP for calculated series
    And Search for the series "1053401"
    And Select the series checkbox from myseries
    And Apply a function on any series in my series
    And hightlight any one series and click on series name
    Then SSP should be opened for the series and series name should be suffixed with function name

  @SSPWindow
  Scenario: TC_SSP_49: Verify percentage change value
    And Search for the series "1053401"
    And hightlight any one series and click on series name
    And Open SSP window
    And Check the percentage change value
    Then Verify if the percentage change value displayed is correct

  @SSPWindow
  Scenario: TC_SSP_50: Verify manage suggestions from search pane
    And Search for the series "1053401"
    And hightlight any one series from search list and click on series name
    Then Manage suggestions option is not present
