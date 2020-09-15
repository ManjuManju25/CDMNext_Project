Feature: Verify Unit Manipulation functionality
 
Background:
  Given User has successful logged in
  And Remove series from myseries pane

@UnitManipulation
Scenario: Tc_Unit Manipulation_01: Verify applying unit manipulation for series
   And Check for keeping_insight popup
   And Login as current execution login by taking username rowcount as 2 and cellcount as 0 and for password rowcount as 2 and cellcount as 1
   And Check for keeping_insight popup
   And Resetting the filters
   And Open preference dropdown
   And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check" 
   And Clicking on "Keyboard shortcuts" option under user preference be "ON" 
   And Open preference dropdown
   And Sort the series in left pane
   And Search for the series with SID "SR866744;SR4878432" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "UNIT" in search field
	 And Select "Hundred" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert all multipliers" 
	 Then Rename the insight to "01" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "default Output Multiplier" and "default Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_01" 
	 
@UnitManipulation
Scenario: Tc_Unit Manipulation_02: Verify applying unit manipulation for series from function toolbar
   And Search for the series with SID "SR866744" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Copy the series" option
   And Type "UNIT" in functions input box
   And Check the checkbox for Unit manipulation as "" 
   Then Rename the insight to "02" and able to apply unit manipualtion function with base series and transformed series present in "Function toolbar" with "default Output Multiplier" and "default Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_02" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_03: Verify unit manipulation for series with func wizard without selecting any sub-methods
   And Search for the series with SID "SR4878432" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Hundred" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert all multipliers" 
   Then Rename the insight to "03" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_03" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_04: Verify func for thousand output multiplier with convert all multipliers method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Thousand" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert all multipliers" 
   Then Rename the insight to "04" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_04" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_05: Verify func for million output multiplier with convert all multipliers method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Million" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert all multipliers" 
   Then Rename the insight to "05" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_05" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_06: Verify func for Billion output multiplier with convert all multipliers method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Billion" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert all multipliers" 
   Then Rename the insight to "06" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_06"
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_07: Verify func for Trillion output multiplier with convert all multipliers method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Trillion" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert all multipliers" 
   Then Rename the insight to "07" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_07"  
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_08: Verify func for hundred output multiplier with convert only multipliers not in the unit name method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Hundred" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert only multipliers not in the unit name" 
   Then Rename the insight to "08" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert only multipliers not in the unit name" and then verify "TC_Unit Manipulation_08"  
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_09: Verify func for Thousand output multiplier with Convert only multipliers not in the unit name method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Thousand" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert only multipliers not in the unit name" 
   Then Rename the insight to "09" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert only multipliers not in the unit name" and then verify "TC_Unit Manipulation_09"  
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_10: Verify func for Million output multiplier with Convert only multipliers not in the unit name method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Million" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert only multipliers not in the unit name" 
   Then Rename the insight to "10" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert only multipliers not in the unit name" and then verify "TC_Unit Manipulation_10"  

@UnitManipulation
Scenario: Tc_Unit Manipulation_11: Verify func for Billion output multiplier with Convert only multipliers not in the unit name method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Billion" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert only multipliers not in the unit name" 
   Then Rename the insight to "11" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert only multipliers not in the unit name" and then verify "TC_Unit Manipulation_11"  
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_12: Verify func for Trillion output multiplier with Convert only multipliers not in the unit name method
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   And Select "Trillion" method from dropdown
   And Check the checkbox for Unit manipulation as "Convert only multipliers not in the unit name" 
   Then Rename the insight to "12" and able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "Output Multiplier" and "Method" and the checkbox "Convert only multipliers not in the unit name" and then verify "TC_Unit Manipulation_12"
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_13: Verify applying multiple functions on unit manipulation func
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   Then Apply "ACCUMULATE" on transformed series with renaming to "13" able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "default Output Multiplier" and "default Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_13" 

@UnitManipulation
Scenario: Tc_Unit Manipulation_14: Verify applying multiple functions on unit manipulation func with func toolbar
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   Then Apply "MULTIPLY" on transformed series with renaming to "14" able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "default Output Multiplier" and "default Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_14" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_15: Verify applying unit manipulation function over other transformed functions
   And Search for the series with SID "254123002" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "LAG" in search field
   Then Apply "UNIT_MULTIPLIER" on transformed series with renaming to "15" able to apply unit manipualtion function with base series and transformed series present in "Function wizard" with "default Output Multiplier" and "default Method" and the checkbox "Convert all multipliers" and then verify "TC_Unit Manipulation_15" 

@UnitManipulation
Scenario: Tc_Unit Manipulation_16: Verify applying unit manipulation function over other transformed functions with replace selected series
   And Search for the series with SID "254123002" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
   And Type "AGGREGATE" in functions input box
   And Type "UNIT" in functions input box
   Then The transformed series is replaced and applied functions are present in new series
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_17: Verify help on this function for unit multiplier function in func wizard
   And Search for the series with SID "254123002" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   Then The help field is present for "UNIT_MANIPULATION" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_18: Verify cancel applying function for unit multiplier from func wizard window
   And Search for the series with SID "254123002" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "UNIT" in search field  
	 Then The "Cancel" button is clicked and the functions wizard is closed
	 
@UnitManipulation
Scenario: Tc_Unit Manipulation_19: Verify applying function for visuals like chart/pie/map/table
   And Refreshing the page
   And Search for the series with SID "254123002" and click on "C" option
   And Right Click the "Chart" visual
   And Click on "Calculate series" to check the type of visual
   And Click "All functions" button
   And Click "By function" tab and enter "UNIT" in search field
   Then The function should apply successfully in "Chart" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_20: Verify applying crosssec func from edit visual window for visuals
   And Search for the series with SID "254123002" and click on "Pie" option
   And Click "More" option from insight action panel
   And Click "All functions" button
   And Click "By function" tab and enter "UNIT" in search field
   Then The function should apply successfully in "Pie" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_21: Verify unit multiplier function from edit series popup
   And Search for the series with SID "254123002" and click on "Heat map" option
   And Click on Edit series visual
   And Type "UNIT" in functions input box
   And Click on "Apply function" in functions box
   Then The function should apply successfully in "Heat map" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_22: Verify tooltip for unit multipler applied function on visuals
   And Search for the series with SID "254123002" and click on "Heat map" option
   And Click on Edit series visual
   And Type "UNIT" in functions input box
   And Click on "Apply function" in functions box
   Then The function should apply successfully in "Heat map" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_23: Verify applying unit multiplier for series in download window from search pane
   And Search for the series with SID "SR4878432" and click on "C" option
   And Copy the visual title
   And Search for the series with SID "SR4878432" and click on "Download" option
   And Select "series" tab in download popup and click on "fx" option and pass as "UNIT" 
   Then The "Download button" in Download window is to be present
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_24: Verify applying unit multiplier func on other functions in download window
   And Search for the series with SID "SR4878432" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "AGGREGATE" in search field
   Then Apply both function and rename series as "24" then validate the Testdata as "TC_Unit_Manipulation_24" 
   
@UnitManipulation123
Scenario: Tc_Unit Manipulation_25: Verify applying unit multiplier for visuals in view mode
   And Search for the series with SID "202916302" and click on "C" option
   And Search for the series with SID "202916302" and click on "Download" option
   And Select "views" tab in download popup and click on "fx" option and pass as "UNIT" 
   Then The "Views button" in Download window is to be present
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_26: Verify applying unit multiplier with kg,ton,euro,usd etc
   And Search for the series with SID "204883202;202916302;292524004;77161701" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   Then Apply function and rename series as "26" then validate the Testdata as "TC_Unit_Manipulation_26" 
   
@UnitManipulation
Scenario: Tc_Unit Manipulation_27: Verify applying unit multiplier with %,2000=100 etc
   And Search for the series with SID "203982302;198573502" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "UNIT" in search field
   Then The function should not apply for selected series
   And Rename Insight to Download
   And Sort the default series in left pane
   And Login back to default execution login