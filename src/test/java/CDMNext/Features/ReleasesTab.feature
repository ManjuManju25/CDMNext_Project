Feature: Verify ReleasesTab functionality
 
@ReleasesTab
Scenario: TC_Releases_01: Verify the contents for Releases tab
  And Clicking "Releases" icon
  And The "Release time interval matrix" should present
  And Release status "Pending" should present
  And Release status "Delayed" should present
  And Release status "Released" should present
  And The "Load More" buttton should present
  
@ReleasesTab
Scenario: TC_Releases_02: Verify the default number of datasets present
  And Clicking "Releases" icon
  Then By default 50 datasets should present
  
@ReleasesTab
Scenario: TC_Releases_03: Verify when all the release status are not selected
  And Clicking "Releases" icon
  And By default 50 datasets should present
  Then Verify no release status should select
  
@ReleasesTab
Scenario: TC_Releases_04: Verify when release status is selected
  And Clicking "Releases" icon
  And Clicking the release status as "Released" 
  Then Only "Released" status icon should present
  
@ReleasesTab
Scenario: TC_Releases_05: Verify when pending status is selected
  And Clicking "Releases" icon
  And Clicking the release status as "Pending" 
  Then Only "Pending" status icon should present
  
@ReleasesTab
Scenario: TC_Releases_06: Verify when delayed status is selected
  And Clicking "Releases" icon
  And Clicking the release status as "Delayed" 
  Then Only "Delayed" status icon should present
  
@ReleasesTab
Scenario: TC_Releases_07: Verify when all status is selected
  And Clicking "Releases" icon
  And Clicking the release status as "Released" 
  And Clicking the release status as "Pending" 
  And Clicking the release status as "Delayed" 
  Then Only "All" status icon should present
  
@ReleasesTab
Scenario: TC_Releases_08: Verify when all status is deselected
  And Clicking "Releases" icon
  And Check the deselected option
  Then Only "All" status icon should present
  
@ReleasesTab
Scenario: TC_Releases_09: Expand the one of the Datasets
  And Clicking "Releases" icon
  And Expand first Dataset
  And Get the text of expanded Dataset
  Then Verify the "expanded" dataset
  
@ReleasesTab
Scenario: TC_Releases_10: Collapse the datasets
  And Clicking "Releases" icon
  And Expand first Dataset
  Then Verify the "collapsed" dataset
  
@ReleasesTab
Scenario: TC_Releases_12: Verify Selection of any datasets
  And Clicking "Releases" icon
  And Search for the series "176412302" in ReleasesTab
  And Select "-1Y" timeframe button
  And Select first Dataset
  Then Download button should enable and x series selected should appear in search
  
@ReleasesTab
Scenario: TC_Releases_13: Verify ' v ' icon for a series to display details
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click "Show related data" option in series
  Then The "Read More" option in series should present
  Then The "Datasets" option in series should present
  Then The "Related Insights" option in series should present
  
@ReleasesTab
Scenario: TC_Releases_14: Verify ' ^ ' icon for a series to collapse details
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click "Show related data" option in series
  And Click "Hide related data" option in series 
  Then The "Hide related data" Option for the series should present

@ReleasesTab
Scenario: TC_Releases_15: Hovor on to ' + ' icon
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Hovor on to "add-to-data-selection--title" 
  Then  "Add series" , "Add and replace series" Options should present
  
@ReleasesTab
Scenario: TC_Releases_16: Verify ' + ' icon
  And Clicking "Releases" icon
  And Expand first Dataset
  And Select 1 series inside table
  And Clicking "add-to-data-selection--icon" option from Series list
  Then The series should add into right pane
  
@ReleasesTab
Scenario: TC_Releases_17: Verify ' + ' dropdown
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  Then  "Add" , "Add and replace" , "Add and group" , "Add to new insight" , "Add to recent insight" Options should present
  
@ReleasesTab
Scenario: TC_Releases_18: Hovor on to Add option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Hovoring "Add" option from dropdown list
  Then The "Add series (A)" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_19: Verify add option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Clicking "Add series" from dropdown list
  Then The series should add into right pane
  
@ReleasesTab
Scenario: TC_Releases_20: Hovor on to Add and replace option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Hovoring "Add and replace" option from dropdown list
  Then The "Add and replace series in visual (R)" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_22: Hovor on to Add and group option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Hovoring "Add and group" option from dropdown list
  Then The "Add and group series in My Series (G)" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_23: Verify Add and group option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Select 1 series inside table
  And Clicking + option from series
  And Clicking "Add and group series" from dropdown list
  Then The Selected series should get added into right pane with "Group" 
  
@ReleasesTab
Scenario: TC_Releases_24: Hovor on to Add to new insight option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Hovoring "Add to new insight" option from dropdown list
  Then The "Add to new insight" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_25: Verify Add to new insight option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Clicking + option from series
  And Clicking "Add to new insight" from dropdown list
  And Series has been added to new insight message should display
  Then Clicking on go to the insight name should open the new insight with the added series
  
@ReleasesTab
Scenario: TC_Releases_26: Hovor on to Add to recent insight option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Hovoring "Add to recent insight" option from dropdown list
  Then The "Add to recent insight" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_27: Verify Add to recent insight option
  And Clicking "Releases" icon
  And Expand first Dataset
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Clicking "Add to recent insight" from dropdown list
  Then Any insight could be selected for the series to add
  And Closing the chart visual
  
@ReleasesTab
Scenario: TC_Releases_28: Verify right click option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy" , "Copy data" , "Copy selected links" , "Add to Watchlist" , "Series Info" , "Footnotes" , "Show Dataset" options should available  
  
@ReleasesTab
Scenario: TC_Releases_29: Hovor on to unselect All option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Unselect all" option from dropdown list
  Then The "Unselect all" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_30: Verify unselect All option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Select 1 series inside table
  And Right click the first series
  And Click on "Unselect all" button in Comparables
  Then Selected series should get deselected
  And Check the download button and search box
  
@ReleasesTab
Scenario: TC_Releases_31: Hovor on to View as Chart option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "View as Chart" option from dropdown list
  Then The "View as Chart" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_32: Verify View as Chart option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Click on "View as Chart" button in Comparables
  Then The "Edit Chart" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_33: Hovor on to View as Map option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "View as Map" option from dropdown list
  Then The "View as Map" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_34: Verify View as Map option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Click on "View as Map" button in Comparables
  Then The "Edit Map" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_35: Hovor on to View as Table option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "View as Table" option from dropdown list
  Then The "View as Table" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_36: Verify View as Table option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Click on "View as Table" button in Comparables
  Then The "Edit Table" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_37: Hovor on to View as Pie option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "View as ..." option and "Pie"  
  Then The "Pie" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_38: Verify View as Pie option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Choose "View as ..." > "Pie" 
  Then The "Edit Pie" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_39: Hovor on to View as Heat map option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "View as ..." option and "Heat map" 
  Then The "Heat map" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_40: Verify View as Heat map option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Choose "View as ..." > "Heat map" 
  Then The "Edit Heat map" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_41: Hovor on to View as Histogram option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "View as ..." option and "Histogram" 
  Then The "Histogram" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_42: Verify View as Histogram option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Choose "View as ..." > "Histogram" 
  Then The "Edit Histogram" option is displayed
 
@ReleasesTab
Scenario: TC_Releases_43: Hovor on to Download option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Download" option from dropdown list
  Then The "Download" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_44: Verify Download option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Click on "Download" button in Comparables 
  Then The "Download" option is shown
  
@ReleasesTab
Scenario: TC_Releases_45: Hovor on to Copy option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Copy" option from dropdown list
  Then The "Copy" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_46: Verify Copy option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Right click the first series
  And Click on "Copy" button in Comparables
  And URL should be generated for selected series 
  And Copy the data after clicking Copy button
  Then The "Copy" option is shown
  
@ReleasesTab
Scenario: TC_Releases_47: Hovor on to Copy Data option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Copy data" option from dropdown list
  Then The "Copy data" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_48: Verify Copy data option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Click on "Copy data" button in Comparables 
  Then The "Copy data" option is shown
  
@ReleasesTab
Scenario: TC_Releases_49: Hovor on to Copy link(s) option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Copy selected links" option from dropdown list
  Then The "Copy selected links" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_50: Verify Copy link(s) option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to series name without click
  And Right click the first series
  And Select the "Copy selected links" option 
  And URL should be generated for selected series 
  And Copy the data after clicking Copy button
  Then The "Copy selected links" option is shown
  
@ReleasesTab
Scenario: TC_Releases_51: Hovor on to Series Info for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Series Info" option from dropdown list
  Then The "Series Info" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_52: Verify Series Info option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to series name without click
  And Right click the first series
  And Select the "Series Info" option
  Then The "Series Info" option is shown
  
@ReleasesTab
Scenario: TC_Releases_53: Hovor on to Footnotes option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Footnotes" option from dropdown list
  Then The "Footnotes" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_54: Verify Footnotes option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Right click the first series
  And Select the "Footnotes" option
  Then The "Footnotes" option is shown
  
@ReleasesTab
Scenario: TC_Releases_54: Verify Footnotes option for the series(Multiple Footnotes)
  And Clicking "Releases" icon
  And Search for the series "5724301" in ReleasesTab
  And Expand first Dataset
  And Hovor on to i icon without click
  And Right click the first series
  And Hovor on to the "Footnotes" option
  Then The "Multiple Footnotes" Option Should show
  
@ReleasesTab
Scenario: TC_Releases_57: Hovor on to Show Dataset option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Show Dataset" option from dropdown list
  Then The "Show Dataset" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_58: Verify Show Dataset option for the series(Multiple datasets)
  And Clicking "Releases" icon
  And Search for the series "5724301" in ReleasesTab
  And Expand first Dataset
  And Hovor on to i icon without click
  And Right click the first series
  And Hovor on to the "Show Dataset" option
  Then The "Multiple Dataset" Option Should show
  
@ReleasesTab
Scenario: TC_Releases_58: Verify Show Dataset option for the series
  And Clicking "Releases" icon 
  And Expand first Dataset
  And Hovor on to i icon without click
  And Right click the first series
  And Select the "Show Dataset" option
  Then The "Back Button Click" option is shown

@ReleasesTab
Scenario: TC_Releases_71: Hovor on to ' + ' icon for dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title" 
  Then  "Add series" , "Add and replace series" Options should present
  
@ReleasesTab
Scenario: TC_Releases_73: Verify ' + ' dropdown for dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  Then  "Add" , "Add and replace" , "Add and group" , "Add to new insight" , "Add to recent insight" Options should present
  
@ReleasesTab
Scenario: TC_Releases_74: Hovor on to Add option in Dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Hovoring "Add" option from dropdown list
  Then The "Add series (A)" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_75: Verify add option in Dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Get Text of Dataset
  And Clicking "Add series" from dropdown list
  Then The Dataset level series are added into my series panel
  
@ReleasesTab
Scenario: TC_Releases_76: Hovor on to Add and replace option in Dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Hovoring "Add and replace" option from dropdown list
  Then The "Add and replace series in visual (R)" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_78: Hovor on to Add and group option in Dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Hovoring "Add and group" option from dropdown list
  Then The "Add and group series in My Series (G)" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_79: Verify Add and group option in Dataset
  And Clicking "Releases" icon
  And Expand first Dataset
  And Get the count of series inside table
  And Select 1 series inside table
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Series list
  And Clicking "Add and group series" from dropdown list
  Then The Selected series should get added into right pane with "Group" 
  
@ReleasesTab
Scenario: TC_Releases_80: Hovor on to Add to new insight option in Dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Hovoring "Add to new insight" option from dropdown list
  Then The "Add to new insight" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_81: Verify Add to new insight option in Dataset
  And Clicking "Releases" icon
  And Get Text of Dataset
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Clicking "Add to new insight" from dropdown list
  And Series has been added to new insight message should display
  Then Clicking on the insight name should open the new insight for Dataset
  
@ReleasesTab
Scenario: TC_Releases_82: Hovor on to Add to existing insight option in Dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Hovoring "Add to recent insight" option from dropdown list
  Then The "Add to recent insight" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_83: Verify Add to existing insight option in Dataset
  And Clicking "Releases" icon
  And Hovor on to "add-to-data-selection--title"
  And Clicking "add-to-data-selection--toggle" option from Table
  And Clicking "Add to recent insight" from dropdown list
  Then Any insight could be selected for the series to add
  And Closing the chart visual
  And Remove series from myseries pane
  
@ReleasesTab
Scenario: TC_Releases_84: Verify clicking on more actions option for the series
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy" , "Copy data" , "Copy selected links" , "Add to Watchlist" , "Series Info" , "Footnotes" , "Show Dataset" options should available
  
@ReleasesTab
Scenario: TC_Releases_85: Hovor on to unselect All option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Unselect all" option from dropdown list
  Then The "Unselect all" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_86: Verify unselect All option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Select 1 series inside table
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Click on "Unselect all" button in Comparables
  Then Selected series should get deselected 

@ReleasesTab
Scenario: TC_Releases_87: Hovor on to View as Chart option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "View as Chart" option from dropdown list
  Then The "View as Chart" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_88: Verify View as Chart option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Click on "View as Chart" button in Comparables
  Then The "Edit Chart" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_89: Hovor on to View as Map option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "View as Map" option from dropdown list
  Then The "View as Map" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_90: Verify View as Map option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Click on "View as Map" button in Comparables
  Then The "Edit Map" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_91: Hovor on to View as Table option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "View as Table" option from dropdown list
  Then The "View as Table" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_92: Verify View as Table option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Click on "View as Table" button in Comparables
  Then The "Edit Table" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_93: Hovor on to View as Pie option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "View as ..." option and "Pie"  
  Then The "Pie" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_94: Verify View as Pie option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Choose "View as ..." > "Pie" 
  Then The "Edit Pie" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_95: Hovor on to View as Heat map option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "View as ..." option and "Heat map" 
  Then The "Heat map" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_96: Verify View as Heat map option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Choose "View as ..." > "Heat map" 
  Then The "Edit Heat map" option is displayed
  
@ReleasesTab
Scenario: TC_Releases_97: Hovor on to View as Histogram option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "View as ..." option and "Histogram" 
  Then The "Histogram" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_98: Verify View as Histogram option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Choose "View as ..." > "Histogram" 
  Then The "Edit Histogram" option is displayed
 
@ReleasesTab
Scenario: TC_Releases_99: Hovor on to Download option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Download" option from dropdown list
  Then The "Download" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_100: Verify Download option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Click on "Download" button in Comparables 
  Then The "Download" option is shown
  
@ReleasesTab
Scenario: TC_Releases_101: Hovor on to Copy option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Copy" option from dropdown list
  Then The "Copy" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_102: Verify Copy option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Click on "Copy" button in Comparables
  And URL should be generated for selected series 
  And Copy the data after clicking Copy button
  Then The "Copy" option is shown
  
@ReleasesTab
Scenario: TC_Releases_103: Hovor on to Copy Data option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Copy data" option from dropdown list
  Then The "Copy data" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_104: Verify Copy data option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Click on "Copy data" button in Comparables 
  Then The "Copy data" option is shown
  
@ReleasesTab
Scenario: TC_Releases_105: Hovor on to Copy link(s) option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Copy selected links" option from dropdown list
  Then The "Copy selected links" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_106: Verify Copy link(s) option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to series name without click
  And Click on "More actions" option in series level
  And Select the "Copy selected links" option 
  And URL should be generated for selected series 
  And Copy the data after clicking Copy button
  Then The "Copy selected links" option is shown
  
@ReleasesTab
Scenario: TC_Releases_107: Hovor on to Series Info for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Series Info" option from dropdown list
  Then The "Series Info" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_108: Verify Series Info option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to series name without click
  And Click on "More actions" option in series level
  And Select the "Series Info" option
  Then The "Series Info" option is shown
  
@ReleasesTab
Scenario: TC_Releases_109: Hovor on to Footnotes option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Footnotes" option from dropdown list
  Then The "Footnotes" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_110: Verify Footnotes option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Select the "Footnotes" option
  Then The "Footnotes" option is shown
  
@ReleasesTab
Scenario: TC_Releases_110: Verify Footnotes option for the series in More actions(Multiple Footnotes)
  And Clicking "Releases" icon
  And Search for the series "5724301" in ReleasesTab
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovor on to the "Footnotes" option
  Then The "Multiple Footnotes - More actions" Option Should show
  
@ReleasesTab
Scenario: TC_Releases_113: Hovor on to Show Dataset option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Show Dataset" option from dropdown list
  Then The "Show Dataset" tooltip should be displayed
  
@ReleasesTab
Scenario: TC_Releases_114: Verify Show Dataset option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Select the "Show Dataset" option
  Then The "Back Button Click" option is shown
  
@ReleasesTab
Scenario: TC_Releases_114: Verify Show Dataset option for the series in more actions(Multiple datasets)
  And Clicking "Releases" icon
  And Search for the series "5724301" in ReleasesTab
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovor on to the "Show Dataset" option
  Then The "Multiple Dataset - More actions" Option Should show
  
@ReleasesTab
Scenario: TC_Releases_117: Verify for Unselect link related to  all sections
  And Clicking "Releases" icon
  And Expand first Dataset
  And Select 1 series inside table
  Then The "Unselect" link should display in "#ef5350" color
  
@ReleasesTab
Scenario: TC_Releases_118: Verify Unselect link
  And Clicking "Releases" icon
  And Expand first Dataset
  And Select 1 series inside table
  Then The "Unselect" link should be clicked
  
@ReleasesTab
Scenario Outline: TC_Releases_119: Verify the Release time intervals
  And Clicking "Releases" icon
  Then The date <timeframe> difference in timeframe buttons should match
 Examples:
     | timeframe |
     | "-1Y"   |
     | "-3M"   |
     | "-1M"   |
     | "-1W"   |
     | "-1D"   |
     | "TODAY" |
     | "+1D"   |
     | "+1W"   |
     | "+1M"   |
     | "+3M"   |
     | "+1Y"   |
  
@ReleasesTab
Scenario: TC_Releases_120: Verify Load more option
  And Clicking "Releases" icon
  Then The "Load More" button should present
  
@ReleasesTab
Scenario: TC_Releases_121: Verify right click options on Dataset
  And Clicking "Releases" icon
  And Right Click the first dataset
  Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" options should available
 
@ReleasesTab
Scenario Outline: TC_Releases_122: Hovoring right click options on Dataset
  And Clicking "Releases" icon
  And Right Click the first dataset
  And Hovor on to the <Dataset> option
  Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" options should available 
  Examples:
		|     Dataset     |
		| "Unselect all"  |
		| "View as Chart" |
		| "View as Map"   |
		| "View as Table" |
		| "View as ..."   |
		| "Download"      |
		
@ReleasesTab
Scenario Outline: TC_Releases_123: Hovor on to View as ... option for the dataset
  And Clicking "Releases" icon
  And Right Click the first dataset
  And Hovoring "View as ..." option and <Visual>  
  Then The <Visual> tooltip should be displayed
  Examples:
    | Visual      |
		| "Pie"       |
		| "Heat map"  |
		| "Histogram" |
 
@ReleasesTab
Scenario: TC_Releases_124: Verify unselect All option for the Datasets
  And Clicking "Releases" icon
  And Right Click the first dataset
  And Click on "Unselect all" button in Comparables
  Then Selected dataset should get deselected
  And Check the download button and search box
 
@ReleasesTab
Scenario: TC_Releases_125: Verify View as Chart option for the Datasets
  And Clicking "Releases" icon
  And Expand first Dataset
  And Count the series inside "First Dataset" 
  And Right Click the first dataset
  And Click on "View as Chart" button in Comparables
  Then The "Edit Chart" option in dataset should get verified
 
@ReleasesTab
Scenario: TC_Releases_126: Verify View as Map option for the Datasets
  #And Resetting the filters 
  And Clicking "Releases" icon
  And Search for the series "5724301" in ReleasesTab
  And Expand first Dataset
  And Count the series inside "First Dataset" 
  And Right Click the first dataset
  And Click on "View as Map" button in Comparables
  Then The "Edit Map" option in dataset should get verified

@ReleasesTab
Scenario: TC_Releases_127: Verify View as Table option for the Datasets
  And Clicking "Releases" icon
  And Search for the series "176412302" in ReleasesTab
  And Select "-1Y" timeframe button
  And Expand first Dataset
  And Count the series inside "First Dataset" 
  And Right Click the first dataset
  And Click on "View as Table" button in Comparables
  Then The "Edit Table" option in dataset should get verified
    
@ReleasesTab
Scenario: TC_Releases_128: Verify View as Pie option for the Datasets
  And Clicking "Releases" icon
  And Search for the series "176412302" in ReleasesTab
  And Select "-1Y" timeframe button
  And Expand first Dataset
  And Count the series inside "First Dataset" 
  And Right Click the first dataset
  And Choose "View as ..." > "Pie" 
  Then The "Edit Pie" option in dataset should get verified
  
@ReleasesTab
Scenario: TC_Releases_129: Verify View as Heat map option for the Datasets
  And Clicking "Releases" icon
  And Search for the series "5724301" in ReleasesTab
  And Expand first Dataset
  And Count the series inside "First Dataset" 
  And Right Click the first dataset
  And Choose "View as ..." > "Heat map" 
  Then The "Edit Heat map" option in dataset should get verified
 
@ReleasesTab
Scenario: TC_Releases_130: Verify View as Histogram option for the Datasets
  And Clicking "Releases" icon
  And Search for the series "176412302" in ReleasesTab
  And Select "-1Y" timeframe button
  And Expand first Dataset
  And Count the series inside "First Dataset" 
  And Right Click the first dataset
  And Choose "View as ..." > "Histogram" 
  Then The "Edit Histogram" option in dataset should get verified
 
@ReleasesTab
Scenario: TC_Releases_131: Verify Download option for the Datasets
  And Open preference dropdown
  And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check" 
  And Open preference dropdown
  And Clicking "Releases" icon
  And Search for the series "176412302" in ReleasesTab
  And Select "-1Y" timeframe button
  And Rename Insight to Download
  And Expand first Dataset
  And Count the series inside "First Dataset"
  And Get the name of series inside table 
  And Right Click the first dataset
  And Click on "Download" button in Comparables 
  Then The "Table - Download" option is shown
  
@ReleasesTab
Scenario: Tc_Releases_132: Verify Read more for series in ReleasesTab
    And Clicking "Releases" icon
    And Expand first Dataset  
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    And The "Read More" option for series should present
    Then The "Footnotes" option is shown
    
@ReleasesTab
Scenario: Tc_Releases_133: Verify datasets for Multiple related series
    And Clicking "Releases" icon
    And Search for the series "365306577" in ReleasesTab
    And Select "-1Y" timeframe button
    And Expand first Dataset
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    Then The link is navigating to "Multiple Series" 
    
@ReleasesTab
Scenario: Tc_Releases_133: Verify navigating to database for related series
    And Clicking "Releases" icon
    And Expand first Dataset
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    And Click on "database" for related series
    Then The related "Database" for the series should shown
    
@ReleasesTab
Scenario: Tc_Releases_134: Verify navigating to topic for related series
    And Clicking "Releases" icon  
    And Expand first Dataset
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    And Click on "topic" for related series
    Then The related "Topic" for the series should shown
    
@ReleasesTab
Scenario: Tc_Releases_135: Verify navigating to section for related series
    And Clicking "Releases" icon  
    And Expand first Dataset 
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    And Click on "section" for related series
    Then The related "Section" for the series should shown
    
@ReleasesTab
Scenario: Tc_Releases_136: Verify opening any of related insights
    And Clicking "Releases" icon
    And Expand first Dataset
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    And The "Related Insights" option in series should present
    And Check the data of first insight
    
@ReleasesTab
Scenario: Tc_Releases_137: Verify favoriting related insight
    And Clicking "Releases" icon
    And Expand first Dataset
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    And The "Related Insights" option in series should present
    And The "First" Insight should present
    And Clicking favorite icon of related insight
    And Click on "My insights" option in insights page
    Then The Related insights should be added to favourite list in insight explorer window of favorite tab
    
@ReleasesTab
Scenario: Tc_Releases_138: Verify sharing of related insight
    And Clicking "Releases" icon
    And Expand first Dataset  
    And Hovor on to i icon without click
    And Click "Show related data" option in series 
    And Click to "Share Insight" 
    Then The Sharing insight window should be opened
    
@ReleasesTab
Scenario: Tc_Releases_139: Verify sharing of non sharing related insight
    And Clicking "Releases" icon
    And Search for the series "5724301" in ReleasesTab 
    And Expand first Dataset
    And Hovor on to i icon without click
    And Click "Show related data" option in series
    And The "Related Insights" option in series should present
    And The "Non shareable Insight" Insight should present
    Then The Share icon should not present for non sharing related insight 
    
@ReleasesTab
Scenario: Tc_Releases_140: Verify presence of related insights tooltip
    And Clicking "Releases" icon
    And Expand first Dataset  
    And Hovor on to i icon without click
    And Click "Show related data" option in series
    And The "Related Insights" option in series should present
    Then The tooltip as "Name" and "Number of series" should present
    
@ReleasesTab
Scenario: Tc_Releases_141: Verify creator tooltip of related insight present 
    And Clicking "Releases" icon
    And Expand first Dataset
    And Hovor on to i icon without click
    And Click "Show related data" option in series
    And The "Related Insights" option in series should present
    Then The creator tooltip should present
    
@ReleasesTab
Scenario: Tc_Releases_142: Verify time period of related insight present
    And Clicking "Releases" icon
    And Expand first Dataset  
    And Hovor on to i icon without click
    And Click "Show related data" option in series
    And The "Related Insights" option in series should present
    Then The Modified time tooltip should present
    
@ReleasesTab
Scenario Outline: TC_Releases_143: Hovor on to Add to Watchlist option for the series by right click
  And Clicking "Releases" icon
  And Expand first Dataset
  And Right click the first series
  And Hovoring "Add to Watchlist" option and get the text <watchlist_hovor>  
  Then The <watchlist_verify> watchlist tooltip should be displayed
  Examples:
     |     watchlist_hovor   |   |    watchlist_verify    |
     | "popup_notifications" |   | "Pop-up notifications" |
     | "email_notifications" |   | "Email notifications"  |
     
@ReleasesTab
Scenario Outline: TC_Releases_144: Hovor on to View as Add to Watchlist option for the series in more actions
  And Clicking "Releases" icon
  And Expand first Dataset
  And Hovor on to i icon without click
  And Click on "More actions" option in series level
  And Hovoring "Add to Watchlist" option and get the text <watchlist_hovor>  
  Then The <watchlist_verify> watchlist tooltip should be displayed
  Examples:
     |     watchlist_hovor   |   |    watchlist_verify    |
     | "popup_notifications" |   | "Pop-up notifications" |
     | "email_notifications" |   | "Email notifications"  |
     
@ReleasesTab
Scenario Outline: TC_Releases_145: Verify showing tool tip for mouse hover options in series level
    And Clicking "Releases" icon
    And Expand first Dataset
    And Hovor on to i icon without click
    Then The <hovor_options> for series should present
    Examples:
    |  hovor_options  |
    | "Add to watchlist" |
    | "View as Chart. Type `c`" |
    | "Open footnote" |
    | "More actions"  |
     
@ReleasesTab
Scenario: TC_Releases_146: Verify Add to Watchlist icon in series level
  And Clicking "Releases" icon
  And Select released database
  And Click on "Add to watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Daily" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab
  
@ReleasesTab
Scenario: TC_Releases_147: Verify Add to Watchlist option in series level right click
  And Clicking "Releases" icon
  And Select released database
  And Right click the first series
  And Click on "Add to Watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Weekly" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab
  
@ReleasesTab
Scenario: TC_Releases_148: Verify Add to Watchlist option in series level more actions
  And Clicking "Releases" icon
  And Select released database
  And Click on "More actions" option in series level
  And Click on "Add to Watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Monthly" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab
  
@ReleasesTab
Scenario: TC_Comparables_149: Verify Add to Watchlist option in series level more actions
  And Clicking "Releases" icon
  And Select released database
  And Click on "More actions" option in series level
  And Click on "Add to Watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Hourly" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab
  
@ReleasesTab123 
Scenario: Tc_Releases_149: Verify series added to new insight in Dataset
    And Clicking "Releases" icon
    And Search for the series "384123687" in ReleasesTab
    And Select "-1Y" timeframe button
    And Expand first Dataset
    And Hovor on to i icon without click
    And Clicking + option from series
    And Clicking "Add to new insight" from dropdown list
    And Series has been added to new insight message should display
    Then Clicking on go to the insight name should open the new insight with the added series
    
@ReleasesTab123
Scenario: Tc_Comparables_150: Verify adding series into existing insight with existing insight shown in growl msg popup
    And Clicking "Releases" icon
    And Search for the series "384123687" in ReleasesTab
    And Select "-1Y" timeframe button
    And Expand first Dataset
    And Hovor on to i icon without click
    And Clicking + option from series
    And Clicking "Add to recent insight" from dropdown list
    Then Should be able to navigate to existing insight