Feature: Verifying All Tab tab functionality 

Background: 
	Given User has successful logged in 
	And Click on "All" tab 
	
@Alltab 
Scenario: TC_AT_01: All Tab's contents when there is no keyword search applied 
	Then All tab should contain these sections "Top Insights,Popular Series,Recently Updated Datasets,New Datasets" 
	
@Alltab 
Scenario: TC_AT_02: Verify the types of insights to be displayed 
	And Click on "All Insights" Switch 
	Then All Tab should show insights from All Insights in Top Insights section 
	
@Alltab 
Scenario: TC_AT_03: Verify the types of insights to be displayed 
	And Click on "EMIS Insights" Switch 
	Then All Tab should show insights from EMIS Insights in Top Insights section 
	
@Alltab 
Scenario: TC_AT_04: Verify Top Insights contents 
	And Observe the number of insights displayed by default 
	Then "6" insights should be displayed by default 
	
@Alltab 
Scenario: TC_AT_05: Verify View More link for All Insights switch 
	And Click on "All Insights" Switch 
	And Click on "View more" link 
	Then User should be navigated to "Insight Explorer" page 
	
@Alltab 
Scenario: TC_AT_06: Verify View More link for EMIS Insights switch 
	And Click on "EMIS Insights" Switch 
	And Click on "View more" link 
	Then User should be navigated to "Insight Explorer" page 
	
@Alltab 
Scenario: TC_AT_07: Verify Openning the insights 
	And Click on the insight title 
	Then The particular insight should get opened in View mode 
	
@Alltab 
Scenario: TC_AT_08: Verify popular Series section contents 
	And "10" popular series should be displayed by default 
	
	#@Alltab1 
	#Scenario: TC_AT_09: Verify Total Usage sort
	#	And Select "Total Usage"	
	#	Then The popular series should be sorted by "Total Usage"
	
@Alltab 
Scenario: TC_AT_09: Verify SSP 
	And Hover the mouse on any series 
	And Click on i icon in blue 
	Then SSP window should be poped up 
	
@Alltab 
Scenario: TC_AT_10: Verify Tooltip 
	And Hover the mouse on any series 
	Then Series info as tooltip should get poped up 
	
@Alltab 
Scenario: TC_AT_11: Verify mouse hover options 
	And Hover the mouse on any series 
	Then "Show Database,View as Chart. Type `c`,Open footnote,More actions" should get displayed 
	
@Alltab 
Scenario: TC_AT_12:Verify Show Database option 
	And Hover the mouse on any series 
	And Click on "Show Database" mouse hover icon 
	Then Database should navigate to the particular database and highlight the series 
	
@Alltab 
Scenario: TC_AT_13:Verify View As Chart option 
	And Hover the mouse on any series 
	And Click on "View as Chart. Type `c`" mouse hover icon 
	Then Chart should be created with the selected series 
	
@Alltab 
Scenario: TC_AT_14:Verify Open Footnote option 
	And Hover the mouse on any series 
	And Click on "Open footnote" mouse hover icon 
	Then Footnote window should be opened for the selected series 
	
@Alltab 
Scenario: TC_AT_15:Verify Unselect All option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Click on "Unselect all" 
	Then The selected series should be unselected 
	
@Alltab 
Scenario: TC_AT_16:Verify View as Chart option
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "View as Chart" 
	Then Visual should be created with "Edit Chart" 
	
@Alltab 
Scenario: TC_AT_17:Verify View as Map option
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "View as Map" 
	Then Visual should be created with "Edit Map" 
	
@Alltab 
Scenario: TC_AT_18:Verify View as Table option
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "View as Table" 
	Then Visual should be created with "Edit Table" 
	
@Alltab 
Scenario: TC_AT_19:Verify View as Pie option
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "Pie" 
	Then Visual should be created with "Edit Pie" 
	
@Alltab 
Scenario: TC_AT_20:Verify View as Heat map option
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "Heat map" 
	Then Visual should be created with "Edit Heat map"
	
@Alltab  
Scenario: TC_AT_21:Verify View as Histogram  option
	And Hover the mouse on any series
	And Click on More actions 
	And Select "Histogram" 
	Then Visual should be created with "Edit Histogram" 
	
@Alltab
Scenario: TC_AT_22:Verify Download  option
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And  Select "Download" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_23:Verify Copy  option
	And Hover the mouse on any series level
	And Click on "More actions" 
	And Select "Copy" 
	Then The message should be in growl popup as "Selected series copied."
	
@Alltab 
Scenario: TC_AT_24:Verify Copy data option
	And Hover the mouse on any series level
	And Click on "More actions" 
	And Select "Copy data" 
	Then The download popup should be opened 
	
@Alltab 
Scenario: TC_AT_25:Verify Copy data optionVerify Copy link(s) option
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Copy link(s)" 
	Then URL should be generated for selected series 
	
@Alltab
Scenario: TC_AT_26:Verify Series Info  option
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Series Info" 
	Then The SSP window should be opened 
	
@Alltab 
Scenario: TC_AT_27:Verify Footnote option
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Footnotes"  
	Then Footnotes window should be opened 
	
@Alltab 
Scenario: TC_AT_28:Verify Show Dataset option
	And Hover the mouse on any series 
	And Click on More actions
	And Select "Show Dataset" 
	And Click on Back button 
	Then Should redirect to database tab 
	
@Alltab 
Scenario: TC_AT_29:Verify Selection of any series
	And Hover the mouse on any series level
	Then Download button should get enabled 
	Then In search field,'x selected' should appear with edit icon 
	
@Alltab
Scenario: TC_AT_30:Verify ' v ' icon for a series to display details
	And Hover the mouse on any series
	And Click on ' v ' icon to expand the series details
	Then Should display "Active/Discontinued,Read More,DATASETS,INSIGHTS" 
	
@Alltab 
Scenario: TC_AT_31:Verify ' ^ ' icon to Collapse
	And Hover the mouse on any series
	And Click on "Show related data" 
	And Click on "Hide related data" 
	Then The related data dropdown should be collapsed
	
@Alltab
Scenario: TC_AT_32:Verify ' + ' icon
	And Hover the mouse on any series
	And Click on + icon for a series 
	Then The series should be added to my series
	
@Alltab
Scenario: TC_AT_33:Verify + dropdown
	And Hover the mouse on any series
	And Click on the 'v' icon to expand the dropdown
	Then The dropdown should be opened with these items "Add,Add and replace,Add and group,Add to new insight,Add to existing insight" 

@Alltab
Scenario: TC_AT_34:Verify Add option
	And Hover the mouse on any series
	And Select "Add" option 
	Then The series should be added to my series 
	
@Alltab
Scenario: TC_AT_35:Verify Add and Replace option
    And Create a visual and select visual
	And Hover the mouse on any series click on dropdown icon
	And Click on "Add and replace" 
	Then The selected series should be replaced with existing series on the visual
	
@Alltab
Scenario: TC_AT_36:Verify Add and group option
   	And Hover the mouse on any series click on dropdown icon
	And Click on "Add and group" 
	Then Selected series should be added as group in My series 
	
@Alltab
Scenario: TC_AT_37:Verify Add to new insight option
   	And Hover the mouse on any series click on dropdown icon
	And Click on "Add to new insight" 
	Then The new insight should be created with selected series 
	
@Alltab
Scenario: TC_AT_38:Verify Add to existing insight option
   	And Hover the mouse on any series click on dropdown icon
	And Click on "Add to existing insight" 
	And Select multiple insights 
	And Click on "Add to insights" 
	Then Open the insights and verify the series in My series 
	
@Alltab
Scenario: TC_AT_39:Verify Unselect All option
  	And  Right click on any series level
	And  Select "Unselect all" 
	Then The selected series should be unselected 
	
@Alltab
Scenario: TC_AT_40:Verify View as Chart option
	And  Right click on any series level	
	And  Select "View as Chart" 
	Then Visual should be created with "Edit Chart"
	
@Alltab
Scenario: TC_AT_41:Verify View as Map option
   	And  Right click on any series level
	And  Select "View as Map" 
	Then Visual should be created with "Edit Map"
	
@Alltab
Scenario: TC_AT_42:Verify View as Table option
   	And  Right click on any series level
	And  Select "View as Table" 
	Then Visual should be created with "Edit Table"
	
@Alltab
Scenario: TC_AT_43:Verify View as Pie  option
   	And  Right click on any series level
	And  Select "Pie" 
	Then Visual should be created with "Edit Pie" 
	
@Alltab
Scenario: TC_AT_44:Verify View as Heat map  option
   	And  Right click on any series level
	And  Select "Heat map" 
	Then Visual should be created with "Edit Heat map" 
	
@Alltab
Scenario: TC_AT_45:Verify View as Histogram  option
   	And  Right click on any of the series level
	And  Select "Histogram" 
	Then Visual should be created with "Edit Histogram"
	
#@Alltab
#Scenario: TC_AT_46:Verify Download  option
#   	And  Right click on any series level
#	And  Select "Download" 
#	Then Download window should be appeared with selected series count 
#	
#@Alltab
#Scenario: TC_AT_47:Verify Copy  option
#   	And  Right click on any series level
#	And   Select "Copy" 
#	Then The message should be in growl popup as "Selected series copied." 
#	
#@Alltab
#Scenario: TC_AT_48:Verify Copy data option
#   	And  Right click on any series level
#	And   Select "Copy data" 
#	Then Download window should be appeared with selected series count
#	
#@Alltab
#Scenario: TC_AT_49:Verify Copy link(s) option
#   	And  Right click on any series level
#	And Select "Copy link(s)" 
#	Then URL should be generated for selected series
#	
#@Alltab
#Scenario: TC_AT_50:Verify Series Info option
#   	And  Right click on any of the series level
#	And Select "Series Info" 
#	Then The SSP window should be opened	
#	
#@Alltab
#Scenario: TC_AT_51:Verify Footnote option
#   	And  Right click on any of the series level
#	And  Select "Footnotes" 
#	Then Footnote window should be opened for the selected series	
#	
#@Alltab
#Scenario: TC_AT_52:Verify Show Dataset option
#   	And  Right click on any of the series level
#	And Select "Show Dataset" 
#	And Click on Back button 
#	Then Should redirect to database tab 
#	
#@Alltab
#Scenario: TC_AT_53:Verify View More link for popular series
#   	And  Click in View More link
#	Then Should be navigated to Series Tab 
#	
#@Alltab
#Scenario: TC_AT_54:Verify Recently updated datasets section contents
#   	And  Recently updated datasets should contain max "10" datasets 
#   	
#@Alltab1
#Scenario: TC_AT_55:Verify View More link for Recently updated datasets 
#   	And  Click on View More link for Recently updated datasets 	
#   	Then Should be navigated to Datasets tab
	