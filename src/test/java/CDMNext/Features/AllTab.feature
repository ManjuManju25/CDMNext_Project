Feature: Verifying All Tab tab functionality 

Background: 
	Given User has successful logged in 
	And Click on "All" tab 
	
@Alltab 
Scenario: TC_AT_01: All Tab's contents when there is no keyword search applied 
	Then All tab should contain these sections "Top Insights,Popular Series,Recently Updated Datasets,New Datasets" 
	
#@Alltab 
#Scenario: TC_AT_02: Verify the types of insights to be displayed 
#	And Click on "All Insights" Switch 
#	Then All Tab should show insights from All Insights in Top Insights section 
#	
#@Alltab 
#Scenario: TC_AT_03: Verify the types of insights to be displayed 
#	And Click on "EMIS Insights" Switch 
#	Then All Tab should show insights from EMIS Insights in Top Insights section 
	
@Alltab 
Scenario: TC_AT_02: Verify Top Insights contents 
	And Observe the number of insights displayed by default 
	Then "6" insights should be displayed by default 
	
@Alltab 
Scenario: TC_AT_03: Verify View More link for All Insights switch 
	And Click on "All Insights" Switch 
	And Click on "View more" link 
	Then User should be navigated to "Insight Explorer" page 
	
@Alltab 
Scenario: TC_AT_04: Verify View More link for EMIS Insights switch 
	And Click on "EMIS Insights" Switch 
	And Click on "View more" link 
	Then User should be navigated to "Insight Explorer" page 
	
@Alltab 
Scenario: TC_AT_05: Verify Openning the insights 
	And Click on the insight title 
	Then The particular insight should get opened in View mode 
	
@Alltab 
Scenario: TC_AT_06: Verify popular Series section contents 
	And "10" popular series should be displayed by default 
	
	#@Alltab1 
	#Scenario: TC_AT_09: Verify Total Usage sort
	#	And Select "Total Usage"	
	#	Then The popular series should be sorted by "Total Usage"
	
@Alltab 
Scenario: TC_AT_07: Verify SSP 
	And Hover the mouse on any series 
	And Click on i icon in blue 
	Then SSP window should be poped up 
	
@Alltab 
Scenario: TC_AT_08: Verify Tooltip 
	And Hover the mouse on any series 
	Then Series info as tooltip should get poped up 
	
@Alltab 
Scenario: TC_AT_09: Verify mouse hover options 
	And Hover the mouse on any series 
	Then "Show Database,View as Chart. Type `c`,Open footnote,More actions" should get displayed 
	
@Alltab 
Scenario: TC_AT_10:Verify Show Database option 
	And Hover the mouse on any series 
	And Click on "Show Database" mouse hover icon 
	Then Database should navigate to the particular database and highlight the series 
	
@Alltab 
Scenario: TC_AT_11:Verify View As Chart option 
	And Hover the mouse on any series 
	And Click on "View as Chart. Type `c`" mouse hover icon 
	Then Chart should be created with the selected series 
	
@Alltab
Scenario: TC_AT_12:Verify Open Footnote option 
	And Hover the mouse on any series 
	And Click on "Open footnote" mouse hover icon 
	Then Footnote window should be opened for the selected series 
	
@Alltab 
Scenario: TC_AT_13:Verify Unselect All option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	Then Context menu should be poped up
		
@Alltab 
Scenario: TC_AT_14:Verify Unselect All option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Click on "Unselect all" 
	Then The selected series should be unselected 
	
@Alltab 
Scenario: TC_AT_15:Verify View as Chart option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "View as Chart" 
	Then Visual should be created with "Edit Chart" 
	
@Alltab 
Scenario: TC_AT_16:Verify View as Map option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "View as Map" 
	Then Visual should be created with "Edit Map" 
	
@Alltab 
Scenario: TC_AT_17:Verify View as Table option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "View as Table" 
	Then Visual should be created with "Edit Table" 
	
@Alltab 
Scenario: TC_AT_18:Verify View as Pie option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "Pie" 
	Then Visual should be created with "Edit Pie" 
	
@Alltab 
Scenario: TC_AT_19:Verify View as Heat map option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "Heat map" 
	Then Visual should be created with "Edit Heat map" 
	
@Alltab 
Scenario: TC_AT_20:Verify View as Histogram  option 
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Histogram" 
	Then Visual should be created with "Edit Histogram" 
	
@Alltab 
Scenario: TC_AT_21:Verify Download  option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And  Select "Download" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_22:Verify Copy  option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "Copy" 
	Then The message should be in growl popup as "Selected series copied." 
	
@Alltab 
Scenario: TC_AT_23:Verify Copy data option 
	And Hover the mouse on any series level 
	And Click on "More actions" 
	And Select "Copy data" 
	Then The download popup should be opened 
	
@Alltab 
Scenario: TC_AT_24:Verify Copy data optionVerify Copy link(s) option 
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Copy link(s)" 
	Then URL should be generated for selected series 
	
@Alltab 
Scenario: TC_AT_25:Verify Series Info  option 
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Series Info" 
	Then The SSP window should be opened 
	
@Alltab 
Scenario: TC_AT_26:Verify Footnote option 
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Footnotes" 
	Then Footnotes window should be opened 
	
@Alltab 
Scenario: TC_AT_27:Verify Show Dataset option 
	And Hover the mouse on any series 
	And Click on More actions 
	And Select "Show Dataset" 
	And Click on Back button 
	Then Should redirect to database tab 
	
@Alltab 
Scenario: TC_AT_28:Verify Selection of any series 
	And Hover the mouse on any series level 
	Then Download button should get enabled 
	Then In search field,'x selected' should appear with edit icon 
	
@Alltab 
Scenario: TC_AT_29:Verify ' v ' icon for a series to display details 
	And Hover the mouse on any series 
	And Click on ' v ' icon to expand the series details 
	Then Should display "Active/Discontinued,Read More,DATASETS,INSIGHTS" 
	
@Alltab 
Scenario: TC_AT_30:Verify ' ^ ' icon to Collapse 
	And Hover the mouse on any series 
	And Click on "Show related data" 
	And Click on "Hide related data" 
	Then The related data dropdown should be collapsed 
	
@Alltab 
Scenario: TC_AT_31:Verify ' + ' icon 
	And Hover the mouse on any series 
	And Click on + icon for a series 
	Then The series should be added to my series 
	
@Alltab 
Scenario: TC_AT_32:Verify + dropdown 
	And Hover the mouse on any series 
	And Click on the 'v' icon to expand the dropdown 
	Then The dropdown should be opened with these items "Add,Add and replace,Add and group,Add to new insight,Add to existing insight" 
	
@Alltab 
Scenario: TC_AT_33:Verify Add option 
	And Hover the mouse on any series 
	And Select "Add" option 
	Then The series should be added to my series 
	
@Alltab 
Scenario: TC_AT_34:Verify Add and Replace option 
	And Create a visual and select visual 
	And Hover the mouse on any series click on dropdown icon 
	And Click on "Add and replace" 
	Then The selected series should be replaced with existing series on the visual 
	
@Alltab 
Scenario: TC_AT_35:Verify Add and group option 
	And Hover the mouse on any series click on dropdown icon 
	And Click on "Add and group" 
	Then Selected series should be added as group in My series 
	
@Alltab 
Scenario: TC_AT_36:Verify Add to new insight option 
	And Hover the mouse on any series click on dropdown icon 
	And Click on "Add to new insight" 
	Then The new insight should be created with selected series 
	
@Alltab 
Scenario: TC_AT_37:Verify Add to existing insight option 
	And Hover the mouse on any series click on dropdown icon 
	And Click on "Add to existing insight" 
	And Select multiple insights 
	And Click on "Add to insights" 
	Then Open the insights and verify the series in My series 
	
@Alltab 
Scenario: TC_AT_38:Verify Unselect All option 
	And  Right click on any series level 
	Then Context menu should be poped up
		
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
	
@Alltab 
Scenario: TC_AT_46:Verify Download  option 
	And  Right click on any series level 
	And  Select "Download" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_47:Verify Copy  option 
	And  Right click on any series level 
	And   Select "Copy" 
	Then The message should be in growl popup as "Selected series copied." 
	
@Alltab 
Scenario: TC_AT_48:Verify Copy data option 
	And  Right click on any series level 
	And   Select "Copy data" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_49:Verify Copy link(s) option 
	And  Right click on any series level 
	And Select "Copy link(s)" 
	Then URL should be generated for selected series 
	
@Alltab 
Scenario: TC_AT_50:Verify Series Info option 
	And  Right click on any of the series level 
	And Select "Series Info" 
	Then The SSP window should be opened 
	
@Alltab 
Scenario: TC_AT_51:Verify Footnote option 
	And  Right click on any of the series level 
	And  Select "Footnotes" 
	Then Footnote window should be opened for the selected series 
	
@Alltab 
Scenario: TC_AT_52:Verify Show Dataset option 
	And  Right click on any of the series level 
	And Select "Show Dataset" 
	And Click on Back button 
	Then Should redirect to database tab 
	
@Alltab 
Scenario: TC_AT_53:Verify View More link for popular series 
	And  Click in View More link 
	Then Should be navigated to Series Tab 
	
@Alltab 
Scenario: TC_AT_54:Verify Recently updated datasets section contents 
	And  Recently updated datasets should contain max "10" datasets 
	
@Alltab 
Scenario: TC_AT_55:Verify View More link for Recently updated datasets 
	And  Click on View More link for Recently updated datasets 
	Then Should be navigated to Datasets tab 
	
@Alltab 
Scenario: TC_AT_56:Expand the one of the Datasets 
	And  Click on + box 
	Then The dataset should get expanded 
	
@Alltab 
Scenario: TC_AT_57:Collapse the datasets 
	And Click on - icon 
	Then The dataset should get collapsed 
	
@Alltab 
Scenario: TC_AT_58:Verify mouse hover options 
	And Hover the mouse on any of the Datasets 
	Then "Open footnote,Add series or Add and replace series" icons should get displayed 
	
@Alltab 
Scenario: TC_AT_59:Verify Open Footnote option 
	And  Hover the mouse on any of the Datasets 
	And  Click on Open footnote icon 
	Then Footnote window should be opened for the selected datasets 
	
@Alltab 
Scenario: TC_AT_60:Verify Selection of any datasets 
	And  Select any of the datasets 
	Then Download button should get enabled 
	Then In search field,'x selected' should appear with edit icon 
	
@Alltab 
Scenario: TC_AT_61:Verify ' v ' icon for a series to display details 
	And  Expand the dataset 
	And Click on 'v' icon for a series to display details 
	Then Should display "Active/Discontinued,Read More,DATASETS,INSIGHTS" 
	
@Alltab 
Scenario: TC_AT_62:Verify ' ^ ' icon to Collapse 
	And Expand the dataset 
	And Click on 'v' icon for a series to display details 
	And Click on "Hide related data" 
	Then The related data dropdown should be collapsed 
	
@Alltab 
Scenario: TC_AT_63:Verify ' + ' icon 
	And Expand the dataset 
	And Click on '+' icon 
	Then The selected series should get added to the visual in focus 
	
@Alltab 
Scenario: TC_AT_64:Verify + dropdown 
	And Expand the dataset 
	And Click on the v to expand the dropdown 
	Then The dropdown should be opened with these items "Add,Add and replace,Add and group,Add to new insight,Add to existing insight" 
	
@Alltab 
Scenario: TC_AT_65:Verify Add option 
	And Click on View tab 
	And Expand the dataset 
	And Click on "Add" option from dropdown 
	Then The selected series should get added to the visual in focus 
	
@Alltab 
Scenario: TC_AT_66:Verify Add and replace option 
	And Expand the dataset 
	And Create a visual 
	And Click on "Add and replace" option from dropdown 
	Then The selected series should replace the series in the visual in the focus 
	
@Alltab 
Scenario: TC_AT_67:Verify Add and group option 
	And Expand the dataset 
	And Click on "Add and group" option from dropdown 
	Then The selected series should get grouped in My Series 
	
@Alltab 
Scenario: TC_AT_68:Verify Add to new insight option 
	And Expand the dataset 
	And Click on "Add to new insight" option from dropdown 
	Then The selected series should get added to the new insight 
	
@Alltab 
Scenario: TC_AT_69:Verify Add to existing insight option 
	And Expand the dataset and select "Add to existing insight" option 
	And Select multiple insights 
	And Click on "Add to insights" 
	Then Open the insights and verify the series in My series 
	
@Alltab 
Scenario: TC_AT_70:Verify Unselect All option 
	And Expand the dataset and right click on any series 
	Then Context menu should be poped up
		
@Alltab 
Scenario: TC_AT_71:Verify Unselect All option 
	And Expand the dataset and right click on any series 
	And  Select "Unselect all" 
	Then The selected series should be unselected 
	
@Alltab 
Scenario: TC_AT_72:Verify View as Chart option 
	And Expand the dataset and right click on any series 
	And  Select "View as Chart" 
	Then Visual should be created with "Edit Chart" 
	
@Alltab 
Scenario: TC_AT_73:Verify View as Map option 
	And Expand the dataset and right click on any series 
	And  Select "View as Map" 
	Then Visual should be created with "Edit Map" 
	
@Alltab 
Scenario: TC_AT_74:Verify View as Table option 
	And Expand the dataset and right click on any series 
	And  Select "View as Table" 
	Then Visual should be created with "Edit Table" 
	
@Alltab 
Scenario: TC_AT_75:Verify View as Pie option 
	And Expand the dataset and right click on any series 
	And Select "Pie" 
	Then Visual should be created with "Edit Pie" 
	
@Alltab 
Scenario: TC_AT_76:Verify View as Heat map option 
	And Expand the dataset and right click on any series 
	And Select "Heat map" 
	Then Visual should be created with "Edit Heat map" 
	
@Alltab 
Scenario: TC_AT_77:Verify View as Histogram option 
	And Expand the dataset and right click on any series 
	And Select "Histogram" 
	Then Visual should be created with "Edit Histogram" 
	
@Alltab 
Scenario: TC_AT_78:Verify Download option 
	And  Expand the dataset and right click on any series 
	And  Select "Download" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_79:Verify Copy option 
	And  Expand the dataset and right click on any series 
	And  Select "Copy" 
	Then The message should be in growl popup as "Selected series copied." 
	
@Alltab 
Scenario: TC_AT_80:Verify Copy data option 
	And  Expand the dataset and right click on any series 
	And  Select "Copy data" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_81:Verify Copy link(s) option 
	And  Expand the dataset and right click on any series 
	And  Select "Copy link(s)" 
	Then URL should be generated for selected series 
	
@Alltab 
Scenario: TC_AT_82:Verify Series Info option 
	And  Expand the dataset and right click on any series 
	And  Select "Series Info" 
	Then The SSP window should be opened 
	
@Alltab 
Scenario: TC_AT_83:Verify Footnote option 
	And  Expand the dataset and right click on any series 
	And  Select "Footnotes" 
	Then Footnote window should be opened for the selected series 
	
@Alltab 
Scenario: TC_AT_84:Verify Show Dataset option 
	And  Expand the dataset and right click on any series 
	And Select "Show Dataset" 
	And Click on Back button 
	Then Should redirect to database tab 
	
@Alltab 
Scenario: TC_AT_85:Verify column for no of series for each Dataset 
	And  Observe column for no of series for each Dataset 
	
@Alltab 
Scenario: TC_AT_86:Verify column for Datasets updated Date 
	And  Observe column for updated Date for each Dataset 
	
@Alltab 
Scenario: TC_AT_87:Verify the New Datasets section contents 
	And  Observe the contents of the New Datasets section 
	Then There should be "10" new datasets displayed by default at max 
	
@Alltab 
Scenario: TC_AT_88:Verify View more link for New Datasets 
	And  Click on View more link 
	Then Should be navigated to Datasets tab 
	
@Alltab 
Scenario: TC_AT_89:Expand the one of the Datasets 
	And  Click on + box for New datasets 
	Then The dataset should get expanded 
	
@Alltab 
Scenario: TC_AT_90:Collapse the datasets 
	And  Click on - icon for New datasets 
	Then The dataset should get collapsed 
	
@Alltab 
Scenario: TC_AT_91:Verify mouse hover options 
	And Hover the mouse on any of the Datasets for New datasets 
	Then "Open footnote,Add series or Add and replace series" icons should get displayed 
	
@Alltab 
Scenario: TC_AT_92:Verify Open Footnote option 
	And  Hover the mouse on any of the Datasets for New datasets 
	And  Click on Open footnote icon 
	Then Footnote window should be opened for the selected datasets 
	
@Alltab
Scenario: TC_AT_93:Verify Selection of any datasets 
	And  Select any of the datasets for New datasets 
	Then Download button should get enabled 
	Then In search field,'x selected' should appear with edit icon 
	
@Alltab 
Scenario: TC_AT_94:Verify ' v ' icon for a series to display details 
	And  Expand the dataset for New datasets 
	And Click on 'v' icon for a series to display details 
	Then Should display "Active/Discontinued,Read More,DATASETS,INSIGHTS" 
	
@Alltab 
Scenario: TC_AT_95:Verify ' ^ ' icon to Collapse 
	And Expand the dataset for New datasets 
	And Click on 'v' icon for a series to display details 
	And Click on "Hide related data" 
	Then The related data dropdown should be collapsed 
	
@Alltab 
Scenario: TC_AT_96:Verify ' + ' icon 
	And  Expand the dataset for New datasets 
	And Click on '+' icon 
	Then The selected series should get added to the visual in focus 
	
@Alltab 
Scenario: TC_AT_97:Verify + dropdown 
	And Expand the dataset for New datasets 
	And Click on the v to expand the dropdown 
	Then The dropdown should be opened with these items "Add,Add and replace,Add and group,Add to new insight,Add to existing insight" 
	
@Alltab 
Scenario: TC_AT_98:Verify Add option 
	And Click on View tab 
	And Expand the dataset for New datasets 
	And Click on "Add" option from dropdown 
	Then The selected series should get added to the visual in focus 
	
@Alltab
Scenario: TC_AT_99:Verify Add and replace option 
	And Expand the dataset for New datasets 
	And Create a visual 
	And Click on "Add and replace" option from dropdown 
	Then The selected series should replace the series in the visual in the focus 
	
@Alltab 
Scenario: TC_AT_100:Verify Add and group option 
	And Expand the dataset for New datasets 
	And Click on "Add and group" option from dropdown 
	Then The selected series should get grouped in My Series 
	
@Alltab 
Scenario: TC_AT_101:Verify Add to new insight option 
	And Expand the dataset for New datasets 
	And Click on "Add to new insight" option from dropdown 
	Then The selected series should get added to the new insight 
	
@Alltab 
Scenario: TC_AT_102:Verify Add to existing insight option 
	And Expand the dataset for New datasets and select "Add to existing insight" option 
	And Select multiple insights 
	And Click on "Add to insights" 
	Then Open the insights and verify the series in My series
	
@Alltab 
Scenario: TC_AT_103:Verify Unselect All option 
	And Expand the dataset for New datasets and right click on any series
	Then Context menu should be poped up
	
@Alltab 
Scenario: TC_AT_104:Verify Unselect All option 
	And Expand the dataset for New datasets and right click on any series 
	And  Select "Unselect all" 
	Then The selected series should be unselected 
	
@Alltab 
Scenario: TC_AT_105:Verify View as Chart option 
	And Expand the dataset for New datasets and right click on any series 
	And  Select "View as Chart" 
	Then Visual should be created with "Edit Chart"
	
@Alltab 
Scenario: TC_AT_106:Verify View as Map option 
	And Expand the dataset for New datasets and right click on any series 
	And  Select "View as Map" 
	Then Visual should be created with "Edit Map" 
	
@Alltab 
Scenario: TC_AT_107:Verify View as Table option 
	And Expand the dataset for New datasets and right click on any series 
	And  Select "View as Table" 
	Then Visual should be created with "Edit Table" 
	
@Alltab 
Scenario: TC_AT_108:Verify View as Pie option 
	And Expand the dataset for New datasets and right click on any series 
	And Select "Pie" 
	Then Visual should be created with "Edit Pie" 
	
@Alltab 
Scenario: TC_AT_109:Verify View as Heat map option 
	And Expand the dataset for New datasets and right click on any series 
	And Select "Heat map" 
	Then Visual should be created with "Edit Heat map" 
	
@Alltab 
Scenario: TC_AT_110:Verify View as Histogram option 
	And Expand the dataset for New datasets and right click on any series 
	And Select "Histogram" 
	Then Visual should be created with "Edit Histogram" 
	
@Alltab
Scenario: TC_AT_111:Verify Download option 
	And  Expand the dataset for New datasets and right click on any series 
	And  Select "Download" 
	Then Download window should be appeared with selected series count 	
	
@Alltab 
Scenario: TC_AT_112:Verify Copy option 
	And  Expand the dataset for New datasets and right click on any series 
	And  Select "Copy" 
	Then The message should be in growl popup as "Selected series copied." 
	
@Alltab 
Scenario: TC_AT_113:Verify Copy data option 
	And  Expand the dataset for New datasets and right click on any series
	And  Select "Copy data" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_114:Verify Copy link(s) option 
	And  Expand the dataset for New datasets and right click on any series 
	And  Select "Copy link(s)" 
	Then URL should be generated for selected series 
	
@Alltab 
Scenario: TC_AT_115:Verify Series Info option 
	And Expand the dataset for New datasets and right click on any series
	And  Select "Series Info" 
	Then The SSP window should be opened 
	
@Alltab 
Scenario: TC_AT_116:Verify Footnote option 
	And  Expand the dataset for New datasets and right click on any series 
	And  Select "Footnotes" 
	Then Footnote window should be opened for the selected series 
	
@Alltab 
Scenario: TC_AT_117:Verify Show Dataset option 
	And  Expand the dataset for New datasets and right click on any series 
	And Select "Show Dataset" 
	And Click on Back button 
	Then Should redirect to database tab 
	
@Alltab 
Scenario: TC_AT_118:Verify column for no of series for each Dataset 
	And  Observe column for no of series for each Dataset under NewDatasets
	
@Alltab 
Scenario: TC_AT_119:Verify column for Datasets updated Date 
	And  Observe column for updated Date for each Dataset under NewDatasets
	
@Alltab
Scenario: TC_AT_120:Verify for Unselect link related to  all sections
	And Select few series in any of the sections
	Then Unselect link should be displayed at the top with red color font
	
@Alltab
Scenario: TC_AT_121:Verify for Unselect link related to  all sections
	And Click in the Unselect link
	Then The series / datasets selection should get cleared off
	
@Alltab 
Scenario: TC_AT_122: All Tab's contents when there is keyword search applied
	And Search keyword with "gdp" 
	Then All tab should contain these sections "Explore Insights,Explore Datasets,Explore Series,Explore Releases" 
	
@Alltab 
Scenario: TC_AT_123: Verify Explore Insights contents
#	And Search keyword with "gdp" 
	And Observe the number of insights displayed by default 
	Then "6" insights should be displayed by default 
	
@Alltab 
Scenario: TC_AT_124: Verify Openning the insights 
#	And Search keyword with "gdp" 
	And Click on the insight title 
	Then The particular insight should get opened in View mode 	
	
@Alltab 
Scenario: TC_AT_125:Verify Explore datasets section contents
#	And Search keyword with "gdp"  
	And  Explore Datasets should contain max "10" datasets 
	
@Alltab 
Scenario: TC_AT_126:Verify if there are no search results
	And  Search keyword with "xyz" 
	Then "Sorry, no results were found here." message should be displayed
	
@Alltab 
Scenario: TC_AT_127:Verify View More link for Explore datasets 
	And  Search keyword with "gdp" 
	And  Click on View More link for Explore datasets 
	Then User Should be navigated to Datasets tab 
	
@Alltab 
Scenario: TC_AT_128:Expand the one of the Datasets 
#	And Search keyword with "gdp" 
	And  Click on + box for Explore datasets
	Then The dataset should get expanded
	
@Alltab 
Scenario: TC_AT_129:Collapse the datasets
#	And Search keyword with "gdp"  
	And Click on - icon for Explore datasets
	Then The dataset should get collapsed 
	
@Alltab 
Scenario: TC_AT_130:Verify mouse hover options
#	And Search keyword with "gdp"  
	And Hover the mouse on any of the Datasets under Explore datasets
	Then "Open footnote,Add series or Add and replace series" icons should get displayed 
	
@Alltab 
Scenario: TC_AT_131:Verify Open Footnote option 
#	And Search keyword with "gdp"  
	And Hover the mouse on any of the Datasets under Explore datasets 
	And  Click on Open footnote icon for Explore datasets
	Then Footnote window should be opened for the selected datasets
	
@Alltab 
Scenario: TC_AT_132:Verify Selection of any datasets 
	And Search keyword with "gdp"  
	And Select any of the Explore datasets 
	Then Download button should get enabled 
	Then In search field,'x selected' should appear with edit icon 
	
@Alltab 
Scenario: TC_AT_133:Verify ' v ' icon for a series to display details 
#	And Search keyword with "gdp"  
	And  Expand the dataset from Explore datasets
	And Click on 'v' icon for a series to display details 
	Then Should display "Active/Discontinued,Read More,DATASETS,INSIGHTS" 
	
@Alltab 
Scenario: TC_AT_134:Verify ' ^ ' icon to Collapse 
#	And Search keyword with "gdp"  
	And  Expand the dataset from Explore datasets
	And Click on 'v' icon for a series to display details  
	And Click on "Hide related data" 
	Then The related data dropdown should be collapsed 
	
@Alltab 
Scenario: TC_AT_135:Verify ' + ' icon 
#	And Search keyword with "gdp"  
	And  Expand the dataset from Explore datasets 
	And Click on '+' icon 
	Then The selected series should get added to the visual in focus 
	
@Alltab 
Scenario: TC_AT_136:Verify + dropdown 
#	And Search keyword with "gdp"  
	And  Expand the dataset from Explore datasets 
	And Click on the v to expand the dropdown 
	Then The dropdown should be opened with these items "Add,Add and replace,Add and group,Add to new insight,Add to existing insight"
	
@Alltab 
Scenario: TC_AT_137:Verify Add option
#	And Search keyword with "gdp" 
	And Click on View tab 
	And  Expand the dataset from Explore datasets 
	And Click on "Add" option from dropdown 
	Then The selected series should get added to the visual in focus  
	
@Alltab 
Scenario: TC_AT_138:Verify Add and replace option 
#	And Search keyword with "gdp" 	
	And  Expand the dataset from Explore datasets 
	And Create a visual 
	And Click on "Add and replace" option from dropdown 
	Then The selected series should replace the series in the visual in the focus
	
@Alltab 
Scenario: TC_AT_139:Verify Add and group option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets 
	And Click on "Add and group" option from dropdown 
	Then The selected series should get grouped in My Series 
	
@Alltab 
Scenario: TC_AT_140:Verify Add to new insight option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets 
	And Click on "Add to new insight" option from dropdown 
	Then The selected series should get added to the new insight  
	
@Alltab 
Scenario: TC_AT_141:Verify Add to existing insight option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets and select "Add to existing insight" option 
	And Select multiple insights 
	And Click on "Add to insights" 
	Then Open the insights and verify the series in My series 
	
@Alltab 
Scenario: TC_AT_142:Verify Unselect All option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets and right click on any series 
	Then Context menu should be poped up
	
@Alltab 
Scenario: TC_AT_143:Verify Unselect All option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets and right click on any series 
	And  Select "Unselect all" 
	Then The selected series should be unselected 
	
@Alltab 
Scenario: TC_AT_144:Verify View as Chart option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets and right click on any series 
	And  Select "View as Chart" 
	Then Visual should be created with "Edit Chart"
	
@Alltab 
Scenario: TC_AT_145:Verify View as Map option
#	And Search keyword with "gdp" 
	And Expand the dataset from Explore datasets and right click on any series 
	And  Select "View as Map" 
	Then Visual should be created with "Edit Map" 
	
@Alltab 
Scenario: TC_AT_146:Verify View as Table option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets and right click on any series 
	And  Select "View as Table" 
	Then Visual should be created with "Edit Table" 
	
@Alltab 
Scenario: TC_AT_147:Verify View as Pie option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets and right click on any series 
	And Select "Pie" 
	Then Visual should be created with "Edit Pie" 
	
@Alltab 
Scenario: TC_AT_148:Verify View as Heat map option 
#	And Search keyword with "gdp"
	And Expand the dataset from Explore datasets and right click on any series 
	And Select "Heat map" 
	Then Visual should be created with "Edit Heat map" 
	
@Alltab 
Scenario: TC_AT_149:Verify View as Histogram option
#	And Search keyword with "gdp" 
	And Expand the dataset from Explore datasets and right click on any series 
	And Select "Histogram" 
	Then Visual should be created with "Edit Histogram" 
	
@Alltab 
Scenario: TC_AT_150:Verify Download option
#	And Search keyword with "gdp" 
	And  Expand the dataset from Explore datasets and right click on any series 
	And  Select "Download" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_151:Verify Copy option 
#	And Search keyword with "gdp"
	And  Expand the dataset from Explore datasets and right click on any series 
	And  Select "Copy" 
	Then The message should be in growl popup as "Selected series copied." 
	
@Alltab 
Scenario: TC_AT_152:Verify Copy data option 
#	And Search keyword with "gdp"
	And  Expand the dataset from Explore datasets and right click on any series 
	And  Select "Copy data" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_153:Verify Copy link(s) option 
#	And Search keyword with "gdp"
	And  Expand the dataset from Explore datasets and right click on any series 
	And  Select "Copy link(s)" 
	Then URL should be generated for selected series 
	
@Alltab 
Scenario: TC_AT_154:Verify Series Info option 
#	And Search keyword with "gdp"
	And  Expand the dataset from Explore datasets and right click on any series 
	And  Select "Series Info" 
	Then The SSP window should be opened 
	
@Alltab
Scenario: TC_AT_155:Verify Footnote option 
#	And Search keyword with "gdp"
	And  Expand the dataset from Explore datasets and right click on any series
	And  Select "Footnotes" 
	Then Footnote window should be opened for the selected series 
	
@Alltab 
Scenario: TC_AT_156:Verify Show Dataset option 
#	And Search keyword with "gdp"
	And  Expand the dataset from Explore datasets and right click on any series
	And Select "Show Dataset" 
	And Click on Back button 
	Then Should redirect to database tab 
	
@Alltab 
Scenario: TC_AT_157:Verify column for no of series for each Dataset 
	And  Observe column for no of series for each Dataset under Explore dataset
	
@Alltab 
Scenario: TC_AT_158:Verify column for Datasets updated Date 
	And  Observe column for updated Date for each Dataset under Explore dataset

@Alltab 
Scenario: TC_AT_159: Verify Explore Series section contents
 	And "10" explore series should be displayed by default 
 	
 @Alltab 
Scenario: TC_AT_160: Verify SSP 
	And Hover the mouse on any series under explore series
	And Click on i icon in blue 
	Then SSP window should be poped up 
 	
 @Alltab 
Scenario: TC_AT_161: Verify Tooltip 
	And Hover the mouse on any series under explore series 
	Then Series info as tooltip should get poped up 
	
@Alltab
Scenario: TC_AT_162: Verify mouse hover options 
	And Hover the mouse on any series under explore series 
	Then "Show Database,View as Chart. Type `c`,Open footnote,More actions" should get displayed 
	
@Alltab 
Scenario: TC_AT_163:Verify Show Database option 
	And Hover the mouse on any series under explore series 
	And Click on "Show Database" mouse hover icon 
	Then Database should navigate to the particular database and highlight the series 
	
@Alltab 
Scenario: TC_AT_164:Verify View As Chart option 
	And Hover the mouse on any series under explore series
	And Click on "View as Chart. Type `c`" mouse hover icon 
	Then Chart should be created with the selected series 
	
@Alltab 
Scenario: TC_AT_165:Verify Open Footnote option 
	And Hover the mouse on any series under explore series 
	And Click on "Open footnote" mouse hover icon 
	Then Footnote window should be opened for the selected series 
	
@Alltab 
Scenario: TC_AT_166:Verify Unselect All option 
	And Hover the mouse on any series under explore series
	And Click on More actions 
	Then Context menu should be poped up
	
@Alltab 
Scenario: TC_AT_167:Verify Unselect All option 
	And  Hover the mouse on any series level under explore series 
	And Click on "More actions" 
	And Click on "Unselect all" 
	Then The selected series should be unselected 
	
@Alltab 
Scenario: TC_AT_168:Verify View as Chart option 
	And Hover the mouse on any series level under explore series 
	And Click on "More actions" 
	And Select "View as Chart" 
	Then Visual should be created with "Edit Chart" 
	
@Alltab 
Scenario: TC_AT_169:Verify View as Map option 
	And Hover the mouse on any series level under explore series  
	And Click on "More actions" 
	And Select "View as Map" 
	Then Visual should be created with "Edit Map" 
	
@Alltab 
Scenario: TC_AT_170:Verify View as Table option 
	And Hover the mouse on any series level under explore series 
	And Click on "More actions" 
	And Select "View as Table" 
	Then Visual should be created with "Edit Table" 
	
@Alltab 
Scenario: TC_AT_171:Verify View as Pie option 
	And Hover the mouse on any series level under explore series 
	And Click on "More actions" 
	And Select "Pie" 
	Then Visual should be created with "Edit Pie" 
	
@Alltab 
Scenario: TC_AT_172:Verify View as Heat map option 
	And Hover the mouse on any series level under explore series  
	And Click on "More actions" 
	And Select "Heat map" 
	Then Visual should be created with "Edit Heat map" 
	
@Alltab 
Scenario: TC_AT_173:Verify View as Histogram  option 
	And Hover the mouse on any series under explore series  
	And Click on More actions 
	And Select "Histogram" 
	Then Visual should be created with "Edit Histogram" 
	
@Alltab 
Scenario: TC_AT_174:Verify Download  option 
	And Hover the mouse on any series level under explore series  
	And Click on "More actions" 
	And  Select "Download" 
	Then Download window should be appeared with selected series count 
	
@Alltab 
Scenario: TC_AT_175:Verify Copy  option 
	And Hover the mouse on any series level under explore series  
	And Click on "More actions" 
	And Select "Copy" 
	Then The message should be in growl popup as "Selected series copied." 
	
@Alltab 
Scenario: TC_AT_176:Verify Copy data option 
	And Hover the mouse on any series level under explore series
	And Click on "More actions" 
	And Select "Copy data" 
	Then The download popup should be opened 
	
@Alltab 
Scenario: TC_AT_177:Verify Copy link(s) option 
	And Hover the mouse on any series under explore series
	And Click on More actions 
	And Select "Copy link(s)" 
	Then URL should be generated for selected series 
	
@Alltab 
Scenario: TC_AT_178:Verify Series Info  option 
	And Hover the mouse on any series under explore series 
	And Click on More actions 
	And Select "Series Info" 
	Then The SSP window should be opened 
	
@Alltab
Scenario: TC_AT_179:Verify Footnote option 
	And Hover the mouse on any series under explore series 
	And Click on More actions 
	And Select "Footnotes" 
	Then Footnotes window should be opened 
	
@Alltab 
Scenario: TC_AT_180:Verify Show Dataset option 
	And Hover the mouse on any series under explore series 
	And Click on More actions 
	And Select "Show Dataset" 
	And Click on Back button 
	Then Should redirect to database tab 
	
@Alltab
Scenario: TC_AT_181:Verify Show Database option 
	And Hover the mouse on any series under explore series 
	And Click on More actions 
	And Select "Show Database"
	Then Database should navigate to the particular database and highlight the series 