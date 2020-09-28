Feature: Verify Cross section functionality
 
#Background:
  #Given User has successful logged in

@CrossSection
Scenario: Tc_Cross Section_01: Verify cross section functionality for series
   And Open preference dropdown
   And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check" 
   And Clicking on "Keyboard shortcuts" option under user preference be "ON" 
   And Open preference dropdown
   And Sort the series in left pane
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The "Sum" method is default and series should be applied with crosssec func with first series name as output
	 
@CrossSection
Scenario: Tc_Cross Section_02: Verify cross section function for single series
   And Sort the series in left pane
   And Search for the series with SID "310901701" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The "This function can only be applied over a selection of multiple series" message should display
	 
@CrossSection
Scenario: Tc_Cross Section_03: Verify crosssec output series in excel
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Rename the Insight to "03" and click Download option from "Download Window" 
	 And The output series has to be present inbetween the base series  
	 Then Enter the Testdata as "TC_Crosssection_03" 
	 
@CrossSection
Scenario: Tc_Cross Section_04: Verify crosssec func with list mode in myseries
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Clicking "List" option from myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The output series has to be present inbetween the base series and the "List" method is selected
	 
@CrossSection
Scenario: Tc_Cross Section_05: Verify crosssec func with table mode in myseries
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Clicking "Table" option from myseries
   And Select all series from table in myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The output series has to be present inbetween the base series and the "Table" method is selected
	 
@CrossSection
Scenario: Tc_Cross Section_06: Verify replace base series with its base series
   And List option should select
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The output series has to be present inbetween the base series and should be able to move up or down 
	 
@CrossSection123456789
Scenario: Tc_Cross Section_07: Verify sorting output series with sort by options dropdown
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 Then Clicking on sort by options
	 
@CrossSection
Scenario: Tc_Cross Section_08: Verify applying crossec func with func wizard window by myseries
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Type "CROSSSEC" in functions input box
	 Then The base series has not been replaced with output series
	 
@CrossSection
Scenario: Tc_Cross Section_09: Verify applying crossec func with func wizard window by function dropdown
   And Search for the series with SID "310901701;310901801" and click on "A" option
	 Then The Crosssec functions can validate through functions wizard
	 
@CrossSection
Scenario: Tc_Cross Section_10: Verify applying crosssec func with func toolbar
   And Search for the series with SID "9380901;9385301" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
	 Then The Crosssec functions for "Sum" can validate and rename as "10" and verify the testdata as "TC_Crosssection_10" 
	 
@CrossSection
Scenario: Tc_Cross Section_11: Verify applying crosssec func with func toolbar in fx wizard window
   And Remove series from myseries pane
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on fx option
   And Clicking "All functions" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Sum" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
	 And Rename the Insight to "11" and click Download option from "Download Window" 
	 And The output series has to be present inbetween the base series  
	 Then Enter the Testdata as "TC_Crosssection_11" 
	 
@CrossSection
Scenario: Tc_Cross Section_12: Verify cancel applying crosssec in functions wizard
   And Search for the series with SID "310901701;310901801" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field  
	 Then The "Cancel" button is clicked and the functions wizard is closed
	 
@CrossSection
Scenario: Tc_Cross Section_13: Verify cancel applying crosssec in functions toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Type "CROSSSEC" in functions input box
	 And Click on "Cancel function" in functions box
	 Then The Cancel applying crosssec in functions toolbar should verify
	 
@CrossSection
Scenario: Tc_Cross Section_15: Verify methods dropdown for crosssec function
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field  
	 Then The "Sum" , "Median" , "Avg" , "Product" methods should present
	 
@CrossSection1
Scenario: Tc_Cross Section_16: Verify apply crosssec for series with replace selected series
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Select "Sum" method from dropdown
   And Click "Replace selected series" text and "Checked" the checkbox
	 Then The Output series must get replaced with first "selected" base series
	 
@CrossSection
Scenario: Tc_Cross Section_17: Verify crosssec function with sum method in functions wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field 
	 And Select "Sum" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for "Sum" can validate and rename as "17" and verify the testdata as "TC_Crosssection_17" 
	 
@CrossSection1
Scenario: Tc_Cross Section_19: Verify crosssec func with sum method in functions wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Checked" the checkbox
   Then The Output series must get replaced with first "Uncheck Longest" base series
   
@CrossSection
Scenario: Tc_Cross Section_20: Verify crosssec func with sum method in functions wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Sum" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Output series must get replaced with first "Ignore missed Uncheck" base series
   
@CrossSection
Scenario: Tc_Cross Section_21: Verify crosssec func with sum method in functions wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Sum" method from dropdown
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Output series must get replaced with first "Both Uncheck" base series
   
@CrossSection
Scenario: Tc_Cross Section_22: Verify crosssec func with Median method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Median" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for "Median" can validate and rename as "22" and verify the testdata as "TC_Crosssection_22" 
   
@CrossSection1
Scenario: Tc_Cross Section_24: Verify crosssec func with Median method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Median" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Checked" the checkbox
   Then The Output series "should replace" the first base series for "Median" 
   
@CrossSection
Scenario: Tc_Cross Section_25: Verify crosssec func with Median method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Median" method from dropdown
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "No" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "25" and verify the testdata as "TC_Crosssection_25" 
   
@CrossSection
Scenario: Tc_Cross Section_26: Verify crosssec func with Median method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Median" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "Yes" and Ignore missed is "No" and Replace selected series is "No" and rename as "26" and verify the testdata as "TC_Crosssection_26" 
   
@CrossSection
Scenario: Tc_Cross Section_27: Verify crosssec func with Median method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Median" method from dropdown
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "No" and Ignore missed is "No" and Replace selected series is "No" and rename as "27" and verify the testdata as "TC_Crosssection_27" 
   
@CrossSection
Scenario: Tc_Cross Section_28: Verify crosssec func with Avg method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Avg" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "Yes" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "28" and verify the testdata as "TC_Crosssection_28" 
   
@CrossSection
Scenario: Tc_Cross Section_30: Verify crosssec func with Avg method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Avg" method from dropdown
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "No" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "30" and verify the testdata as "TC_Crosssection_30" 
   
@CrossSection
Scenario: Tc_Cross Section_31: Verify crosssec func with Avg method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Avg" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "Yes" and Ignore missed is "No" and Replace selected series is "No" and rename as "31" and verify the testdata as "TC_Crosssection_31" 

@CrossSection
Scenario: Tc_Cross Section_32: Verify crosssec func with Avg method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Avg" method from dropdown
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "No" and Ignore missed is "No" and Replace selected series is "No" and rename as "32" and verify the testdata as "TC_Crosssection_32" 
   
@CrossSection
Scenario: Tc_Cross Section_33: Verify crosssec func with Product method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Product" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "Yes" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "33" and verify the testdata as "TC_Crosssection_33" 

@CrossSection
Scenario: Tc_Cross Section_35: Verify crosssec func with Product method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Product" method from dropdown
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Check" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "No" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "35" and verify the testdata as "TC_Crosssection_35" 
   
@CrossSection
Scenario: Tc_Cross Section_36: Verify crosssec func with Product method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Product" method from dropdown
	 And Click "Extend to longest" text and "Check" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "Yes" and Ignore missed is "No" and Replace selected series is "No" and rename as "36" and verify the testdata as "TC_Crosssection_36" 
   
@CrossSection
Scenario: Tc_Cross Section_37: Verify crosssec func with Product method in func wizard
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Count the series in myseries
   And Select all series from myseries and click on "Open function editor" option
	 And Click "By function" tab and enter "CROSSSEC" in search field
	 And Select "Product" method from dropdown
	 And Click "Extend to longest" text and "Uncheck" the checkbox
   And Click "Ignore missed" text and "Uncheck" the checkbox 
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Crosssec functions for Extend to longest is "No" and Ignore missed is "No" and Replace selected series is "No" and rename as "37" and verify the testdata as "TC_Crosssection_37"
   
@CrossSection
Scenario: Tc_Cross Section_38: Verify crosssec function with Sum method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Sum" with extend to longest as "Yes" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Sum" with Extend to longest is "Yes" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "38" and verify the testdata as "TC_Crosssection_38"
   
@CrossSection
Scenario: Tc_Cross Section_39: Verify crosssec function with Sum method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Sum" with extend to longest as "No" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Sum" with Extend to longest is "No" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "39" and verify the testdata as "TC_Crosssection_39"
       
@CrossSection
Scenario: Tc_Cross Section_40: Verify crosssec function with Sum method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Sum" with extend to longest as "Yes" and ignore missed as "No" 
   Then The Crosssec functions for method "Sum" with Extend to longest is "Yes" and Ignore missed is "No" and Replace selected series is "No" and rename as "40" and verify the testdata as "TC_Crosssection_40"
   
@CrossSection
Scenario: Tc_Cross Section_41: Verify crosssec function with Sum method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Sum" with extend to longest as "No" and ignore missed as "No" 
   Then The Crosssec functions for method "Sum" with Extend to longest is "No" and Ignore missed is "No" and Replace selected series is "No" and rename as "41" and verify the testdata as "TC_Crosssection_41" 
   
@CrossSection
Scenario: Tc_Cross Section_42: Verify crosssec function with Median method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Median" with extend to longest as "Yes" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Median" with Extend to longest is "Yes" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "42" and verify the testdata as "TC_Crosssection_42" 
   
@CrossSection
Scenario: Tc_Cross Section_43: Verify crosssec function with Median method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Median" with extend to longest as "No" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Median" with Extend to longest is "No" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "43" and verify the testdata as "TC_Crosssection_43" 
   
@CrossSection
Scenario: Tc_Cross Section_44: Verify crosssec function with Median method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Median" with extend to longest as "Yes" and ignore missed as "No" 
   Then The Crosssec functions for method "Median" with Extend to longest is "Yes" and Ignore missed is "No" and Replace selected series is "No" and rename as "44" and verify the testdata as "TC_Crosssection_44" 
   
@CrossSection
Scenario: Tc_Cross Section_45: Verify crosssec function with Median method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Median" with extend to longest as "No" and ignore missed as "No" 
   Then The Crosssec functions for method "Median" with Extend to longest is "No" and Ignore missed is "No" and Replace selected series is "No" and rename as "45" and verify the testdata as "TC_Crosssection_45" 
   
@CrossSection
Scenario: Tc_Cross Section_46: Verify crosssec function with Avg method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Avg" with extend to longest as "Yes" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Avg" with Extend to longest is "Yes" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "46" and verify the testdata as "TC_Crosssection_46" 
   
@CrossSection
Scenario: Tc_Cross Section_47: Verify crosssec function with Avg method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Avg" with extend to longest as "No" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Avg" with Extend to longest is "No" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "47" and verify the testdata as "TC_Crosssection_47"   

@CrossSection
Scenario: Tc_Cross Section_48: Verify crosssec function with Avg method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Avg" with extend to longest as "Yes" and ignore missed as "No" 
   Then The Crosssec functions for method "Avg" with Extend to longest is "Yes" and Ignore missed is "No" and Replace selected series is "No" and rename as "48" and verify the testdata as "TC_Crosssection_48" 
   
@CrossSection
Scenario: Tc_Cross Section_49: Verify crosssec function with Avg method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Avg" with extend to longest as "No" and ignore missed as "No" 
   Then The Crosssec functions for method "Avg" with Extend to longest is "No" and Ignore missed is "No" and Replace selected series is "No" and rename as "49" and verify the testdata as "TC_Crosssection_49" 
   
@CrossSection
Scenario: Tc_Cross Section_50: Verify crosssec function with Product method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Product" with extend to longest as "Yes" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Product" with Extend to longest is "Yes" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "50" and verify the testdata as "TC_Crosssection_50" 
   
@CrossSection
Scenario: Tc_Cross Section_51: Verify crosssec function with Product method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Product" with extend to longest as "No" and ignore missed as "Yes" 
   Then The Crosssec functions for method "Product" with Extend to longest is "No" and Ignore missed is "Yes" and Replace selected series is "No" and rename as "51" and verify the testdata as "TC_Crosssection_51" 
   
@CrossSection
Scenario: Tc_Cross Section_52: Verify crosssec function with Product method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Product" with extend to longest as "Yes" and ignore missed as "No" 
   Then The Crosssec functions for method "Product" with Extend to longest is "Yes" and Ignore missed is "No" and Replace selected series is "No" and rename as "52" and verify the testdata as "TC_Crosssection_52" 
   
@CrossSection
Scenario: Tc_Cross Section_53: Verify crosssec function with Product method in function toolbar
   And Search for the series with SID "310902301;310902401" and click on "A" option
   And Select all series from myseries and click on "Copy the series" option
	 And Count the series in myseries
	 And Enter the function "CROSS" with method "Product" with extend to longest as "No" and ignore missed as "No" 
   Then The Crosssec functions for method "Product" with Extend to longest is "No" and Ignore missed is "No" and Replace selected series is "No" and rename as "53" and verify the testdata as "TC_Crosssection_53" 

@CrossSection
Scenario: Tc_Cross Section_54: Verify applying crosssec to series having different frequency
   And Search for the series with SID "210698402;206954202" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The Series should be of same "frequency" Validation message should appear
	 
@CrossSection
Scenario: Tc_Cross Section_55: Verify applying crosssec to series having different unit
   And Search for the series with SID "210698402;35709701" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The Series should be of same "unit" Validation message should appear
	 
@CrossSection
Scenario: Tc_Cross Section_56: Verify applying crosssec to series having different unit & frequency
   And Search for the series with SID "210698402;387139827" and click on "A" option
   And Select all series from myseries and click on "Open function editor" option
   And Click "By function" tab and enter "CROSSSEC" in search field
	 Then The Series should be of same "frequency" Validation message should appear
	 
@CrossSection
Scenario: Tc_Cross Section_57: Verify applying crossec for visuals in an insight
   And Search for the series with SID "310901701;310901801" and click on "C" option
   And Right Click the "Chart" visual
   And Click on "Calculate series" to check the type of visual
   And Click "All functions" button
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Click "Replace selected series" text and "Unchecked" the checkbox
	 Then The Function "Should" apply on the created visual
	 
@CrossSection
Scenario: Tc_Cross Section_58: Verify applying crossec for visuals in an insight with different frequency/unit
   And Search for the series with SID "210698402;387139827" and click on "C" option
   And Click on Apply in Series Harmonization popup
   And Right Click the "Chart" visual
   And Click on "Calculate series" to check the type of visual
   And Click "All functions" button
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Click "Replace selected series" text and "Unchecked" the checkbox
	 Then The Function "Should not" apply on the created visual
	 
@CrossSection
Scenario: Tc_Cross Section_59: Verify applying crosssec for visuals with its frequency conversion popup
   And Search for the series with SID "236388903;299202704" and click on "C" option
   And Click on "Keep different frequencies" in frequency conversion popup
   And Right Click the "Chart" visual
   And Click on "Calculate series" to check the type of visual
   And Click "All functions" button
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Series should be of Same "frequency" validation message appear
   
@CrossSection
Scenario: Tc_Cross Section_60: Verify applying crosssec for visuals with its frequency conversion popup by converting currency too for pie/chart/map
   And Search for the series with SID "313735501;339329501" and click on "C" option
   And Select "currency" as "EUR" in frequency popup
   And Click on "Apply" in frequency conversion popup
   And Right Click the "Chart" visual
   And Click on "Calculate series" to check the type of visual
   And Click "All functions" button
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Function should apply successfully in "Chart" 
   
@CrossSection
Scenario: Tc_Cross Section_61: Verify applying crosssec for visuals with its frequency conversion popup by converting currency too for pie/chart/map
   And Search for the series with SID "313735501;339329501" and click on "Heat map" option
   And Select "currency" as "EUR" in frequency popup
   And Click on "Apply" in frequency conversion popup
   And Right Click the "Heat map" visual
   And Click on "Calculate series" to check the type of visual
   And Click "All functions" button
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Function should apply successfully in "Heat map" 
   
@CrossSection
Scenario: Tc_Cross Section_62: Verify applying crosssec func from edit visual window for visuals
   And Search for the series with SID "310901701;310901801" and click on "Pie" option
   And Click "More" option from insight action panel
   And Click "All functions" button
   And Click "By function" tab and enter "CROSSSEC" in search field
   And Click "Replace selected series" text and "Unchecked" the checkbox
   Then The Function should apply successfully in "Pie" 
   
@CrossSection
Scenario: Tc_Cross Section_65: Verify applying crosssec function over search pane series throught download window
   And Search for the series with SID "310901701;310901801" and click on "Download" option
   And Select "series" tab in download popup and click on "fx" option and pass as "CROSSSEC" 
	 Then The "Download button" in Download window has to be present
	 
@CrossSection
Scenario: Tc_Cross Section_66: Verify cancel applied function over search pane series throught download window
   And Search for the series with SID "310901701;310901801" and click on "Download" option
   And Select "series" tab in download popup and click on "fx" option and pass as "CROSSSEC" 
	 Then The "Cancel button" in Download window has to be present   
	 And Sort the default series in left pane