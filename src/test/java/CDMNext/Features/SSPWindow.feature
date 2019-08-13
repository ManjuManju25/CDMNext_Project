Feature: Verifying SSP window Functionality

Background:
   Given User has successful logged in

@SSPWindow
Scenario: TC_SSP_01: Try to open SSP window from myseries
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   Then Verify SSP window
   
@SSPWindow
Scenario: TC_SSP_02: Try to open SSP window from Search.
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   Then Verify SSP window
   
@SSPWindow
Scenario: TC_SSP_03: Verify the options available on the main bar of the SSP window
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window and clicking on "+" icon
   Then Verify options on top bar of window
   
@SSPWindow
Scenario: TC_SSP_04: Verify the Add option
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window
   And Click on Add option
   Then The series should add into right pane
 
@SSPWindow
Scenario: TC_SSP_05: Verify the Add and group option
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And Click on Add and group option
   Then The series should add into right pane and be grouped
   
@SSPWindow
Scenario: TC_SSP_06: Verify the Add to new insight option
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And Click on Add to new insight option
   Then Series has been added to new insight message should display
   Then Clicking on the insight name should open the new insight with the added series
   
@SSPWindow
Scenario: TC_SSP_07: Verify the Add to existing insight option
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And Click on Add to existing insight option
   Then Insight explorer page should open
   Then Any insight could be selected for the series to be added
   
@SSPWindow
Scenario: TC_SSP_08: Verify create chart option
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And click on create chart option
   Then chart should be created in a view for series
   
@SSPWindow
Scenario: TC_SSP_09: Verify copy to clipboard option from SSP
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And click on CTC button
   Then Download settings window to be opened

@SSPWindow
Scenario: TC_SSP_11: Verify Download button option
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And Click on download button
   And Download data to excel
   Then Should be able to download data
   
@SSPWindow
Scenario: TC_SSP_13: Verify minimize button
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And Clicking on minimize icon
   Then verify that SSP window should be minimized
   
@SSPWindow
Scenario: TC_SSP_14: Verify full screen button
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And Clicking on full screen icon
   Then verify that SSP window SSP window should be maximized to full screen
  
@SSPWindow
Scenario: TC_SSP_15: Verify close button
   #And Checking modalbox is open
   And Go to search
   And  hightlight any one series from search list and click on  "i" icon .
   And Open SSP window 
   And Clicking on close button
   Then Verify that SSP window SSP window should be closed

@SSPWindow
Scenario: TC_SSP_16: Verify attributes display in SSP window
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   Then Verify attributes such as Region,frequency,unit,indicator,source and read more
   
@SSPWindow
Scenario: TC_SSP_17: Verify region in SSP window
   #And Checking modalbox is open
   And Open SSP for the series "385319507"
   And Checking the "Region:" of the series
   Then Verify the "Region:" of the series should be "China" 
   
@SSPWindow
Scenario: TC_SSP_18: Verify frequency in SSP window
   #And Checking modalbox is open
   And Open SSP for the series "385319507"
   And Checking the "Frequency:" of the series
   Then Verify the "Frequency:" of the series should be "Monthly" 
   
@SSPWindow
Scenario: TC_SSP_19: Verify unit in SSP window
   #And Checking modalbox is open
   And Open SSP for the series "385319507"
   And Checking the "Unit:" of the series
   Then Verify the "Unit:" of the series should be "2012=100"
   
@SSPWindow
Scenario: TC_SSP_20: Verify the update request information in SSP Window
   #And Checking modalbox is open
   And Open SSP for the series "7874601"
   And Click on releases tab
   And Click on update request link
   And Enter some text in the update request popup opened
   Then Verify the Thank you message
   
@SSPWindow
Scenario: TC_SSP_21: Verify Series ID in SSP window
   #And Checking modalbox is open
   And Open SSP for the series "5724301"
   #And Check for series id
   Then Verify the Series id should be "5724301"
 
@SSPWindow
Scenario: TC_SSP_22: Verify SR code in SSP window
   #And Checking modalbox is open
   And Open SSP for the series "5724301"
   #And Check for SR code
   Then SR code has to be "SR280306" 
   
@SSPWindow
Scenario: TC_SSP_23: Verify Mnemonic in SSP window
   #And Checking modalbox is open
   And Open SSP for the series "5724301"
   #And Check for mnemonic code
   Then Mnemonic code should be "CN.CPI.PY.M" 
   
@SSPWindow
Scenario: TC_SSP_24: Verify Mnemonic hyperlink in SSP window
   #And Checking modalbox is open
   And Open SSP for the series "5724301"
   And Click on the mnemonic hyperlink
   Then Navigate to search result of same series in series pane
   
@SSPWindow
Scenario: TC_SSP_27: Verify indicator drop down
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And clicking indicator drop down
   Then Drop down should display indicators list and clicking on specific indicators should navigate to results page
   
@SSPWindow
Scenario: TC_SSP_28: Verify indicator selection from drop down
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And clicking indicator drop down
   Then Selecting indicator from indicator drop down should show search result in left for same indicator
   
@SSPWindow
Scenario: TC_SSP_29: Verify source link
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on "Source" name
   Then It should apply source filter in search pane to display it's result
   
@SSPWindow
Scenario: TC_SSP_31: Verify read more option
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And click on "Read More" link in SSP window
   Then Footnotes window should be displayed with related details
   
@SSPWindow
Scenario: TC_SSP_32: Verify Ask Question link
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on Ask Question link in SSP window
   Then Should open still can not find an answer window
   
@SSPWindow
Scenario: TC_SSP_33: Trying to send a question
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on Ask Question link in SSP window
   And Still can not find an answer window opens now enter question and click on submit
   Then Verify that user should be able to send question successfully
   
@SSPWindow
Scenario: TC_SSP_34: Verify chart tab
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on "Chart" tab
   Then Should create a chart visual
   
@SSPWindow
Scenario: TC_SSP_40: Verify Data tab
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on "Data" tab
   And Observe full data display
   Then Complete observations must be displayed
   
@SSPWindow
Scenario: TC_SSP_44: Verify Statistics tab
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on "Statistics" tab
   And Check contents
   Then Should have details on location,variability,shape
   
@SSPWindow
Scenario: TC_SSP_45: Verify related data tab
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on "Related Data" tab
   And Check contents inside Related data
   Then Should display related keyword of that series and have "Datasets" and "Insights" details
   
@SSPWindow
Scenario: TC_SSP_46: Click on each links under datasets and verify
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on "Related Data" tab
   Then Click on each links available under "Datasets" and verify the changes
   
@SSPWindow
Scenario: TC_SSP_47: Click on each links under insights and verify
   #And Checking modalbox is open
   And Add few series to myseries
   And hightlight any one series and click on  "i" icon .
   And Open SSP window
   And Click on "Related Data" tab
   Then Click on each links available under "Insights" and it should open respective insights
   
@SSPWindow
Scenario: TC_SSP_48: Check for adding suggested series from SSP window
   #And Checking modalbox is open
   And Search for the series "253736802" 
   And hightlight any one series and click on  "i" icon .
   And Click on "Manage Suggestions" link
   And Click on "Add" , "Apply" and "Ok" buttons
   Then Suggested series has to be added into right pane into the same insight
   
@SSPWindow
Scenario: TC_SSP_49: Check for adding suggested series from SSP window
   #And Checking modalbox is open
   And Search for the series "253736802" 
   And hightlight any one series and click on  "i" icon .
   And Click on "Manage Suggestions" link
   And Click on "Replace" , "Apply" and "Ok" buttons
   Then Discontinued series has to be replaced with suggested series into right
   
@SSPWindow
Scenario: TC_SSP_50: Verify the preview option for rebased series in SSP window
   #And Checking modalbox is open
   And Search for the series "253736802" 
   And hightlight any one series and click on  "i" icon .
   And Click on "Manage Suggestions" link
   And Click on "Preview" button
   Then Both inactive and suggestion should be viewed as chart
   
@SSPWindow
Scenario: TC_SSP_51: Verify click on the replacement suggestion series
   #And Checking modalbox is open
   And Search for the series "1053401" 
   And hightlight any one series and click on  "i" icon .
   And Click on replacement series name hyperlink 
   Then SSP for replacement series should open as a new popup
   
@SSPWindow
Scenario: TC_SSP_52: Verify click on the replacement suggestion series dropdown
   #And Checking modalbox is open
   And Search for the series "1053401" 
   And hightlight any one series and click on  "i" icon .
   And Click on replacement series name dropdown
   Then Both inactive and suggestion should be viewed as chart
   
@SSPWindow
Scenario: TC_SSP_53: Verify SSP for calculated series
   #And Checking modalbox is open
   And Search for the series "1053401" 
   And Select the series checkbox from myseries
   And Apply a function on any series in my series
   And hightlight any one series and click on  "i" icon .
   Then SSP should be opened for the series and series name should be suffixed with function name
   
 