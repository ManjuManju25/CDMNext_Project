Feature: Verify Comparables feature

  @Comparables
  Scenario: Tc_Comparables_01: Verify results loading in comparable tab
    And Clicking on "Comparables" icon
    Then The Section level results for series should be present

  @Comparables
  Scenario: Tc_Comparables_06: Verify disappearing comparables in search tab
    And Click three dots in search pane
    And "Uncheck"  "Comparables" checkbox
    And Clicking "Save" button in search popup
    Then Comparables tab "should not" be visible in search pane

  @Comparables
  Scenario: Tc_Comparables_07: Verify showing comparables in search tab
    And Click three dots in search pane
    And "Check"  "Comparables" checkbox
    And Clicking "Save" button in search popup
    Then Comparables tab "should" be visible in search pane

  @Comparables
  Scenario: Tc_Comparables_08: Verify expanding section level's in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    Then Should be able to expand section levels results upto table level

  @Comparables
  Scenario: Tc_Comparables_09: Verify expanding section level's in comparables with keyboard shortcuts
    And Open preference dropdown
    And Clicking on "Keyboard shortcuts" option under user preference be "ON"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Clicking "National Accounts" section from Comparables tab
    And Using keyboard shortcuts for "expanding" the section
    Then Should be able to expand section levels results upto table level
    And Using keyboard shortcuts for "collapsing" the section
    Then Should be able to collapse section levels results

 @Comparables
  Scenario: Tc_Comparables_10: Verify changing section level's in comparables with keyboard shortcuts
    And Open preference dropdown
    And Clicking on "Keyboard shortcuts" option under user preference be "ON"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Clicking "National Accounts" section from Comparables tab
    And Using keyboard shortcuts for "moving down" the section
    Then Should be able to move down the section levels results
    And Using keyboard shortcuts for "moving up" the section
    Then Should be able to move up the section levels results

  @Comparables
  Scenario: Tc_Comparables_18: Verify results for applying filters in comparables
    And Clicking "Comparables" icon
    And User selects "Frequency" as "Monthly"
    And Count the series in selected Filter
    And User has clicked on "Apply filter"
    Then The comparables count should match to applied filter count

 @Comparables
  Scenario: Tc_Comparables_28: Verify search results for comparables
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    Then Related results should be shown in comparables

  @Comparables
  Scenario: Tc_Comparables_29: Verify collapse all option for comparables->Table
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    And Click "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted" to collapse
    And Clicking Collapse tree
    Then Should be able to collapse section levels results

  @Comparables
  Scenario: Tc_Comparables_30: Verify collapse all option for comparables->series
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    And Clicking Collapse tree
    Then Should be able to collapse section levels results

 @Comparables
  Scenario: Tc_Comparables_39: Verify new/replace/forescast/key icon's infront of series name in comparables
    And Verify Subscribed series only filter under filters
    And Select "new" checkbox from more section
    And User has clicked on "Apply filter"
    And Clicking "Comparables" icon
    And Expand the tree for key icons
    And Hovor on the series from table
    Then The Applied "Single" filter is displaying under Comparables

 @Comparables
  Scenario: Tc_Comparables_40: Verify multiple above icons to be present in series level
    And Verify Subscribed series only filter under filters
    And Select "new" checkbox from more section
    And Select "key" checkbox from more section
    And User has clicked on "Apply filter"
    And Clicking "Comparables" icon
    And Expand the tree for key icons
    And Hovor on the series from table
    Then The Applied "Multiple" filter is displaying under Comparables

 @Comparables
  Scenario: Tc_Comparables_41: Verify SSP window for series level
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Click on series name
    Then Verify SSP window

 @Comparables
  Scenario: Tc_Comparables_42: Verify checkbox selection for tables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Check the checkbox "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted"
    Then The series present inside the Table should gets selected

  @Comparables
  Scenario: Tc_Comparables_43: Verify check box selection for series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 1 series inside table
    Then The series should gets selected

  @Comparables
  Scenario: Tc_Comparables_45: Verify unchecking selection of tables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Uncheck the checkbox "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted"
    Then The series present inside the Table should gets deselected

  @Comparables
  Scenario: Tc_Comparables_46: Verify unchecking selection of series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Deselect 2 series inside table
    Then The series should gets deselected

  @Comparables
  Scenario: Tc_Compaables_48: Verify opening SSP when click on series name
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to series name
    Then SSP window for specific series should be opened

 @Comparables
  Scenario: Tc_Comparables_49: Verify drag and drop for comparable series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 1 series inside table
    And Get the name of series
    And Perform Drag and Drop operation
    Then Series should get added into myseries pane

 @Comparables
  Scenario: Tc_Comparables_50: Verify drag and drop for multiple comparable series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 3 series inside table
    And Get the name of series
    And Perform Drag and Drop operation
    Then Series should get added into myseries pane

 @Comparables
  Scenario: Tc_Comparables_51: Verify downloading series selected in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 2 series inside table
    And Get the name of series
    And Clicking "Download" button from Header portion
    Then The Series selected should gets downloaded to excel

 @Comparables
  Scenario: Tc_Comparables_52: Verify CTC of series in comparables
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    And Select 1 series inside table
    And Get the name of series
    And Clicking "Copy to Clipboard" button from Header portion
    And Copy the data after clicking Copy button
    Then The Series selected should gets copied to excel

  @Comparables
  Scenario: Tc_Comparables_55: Verify collapse all for series in comparables without any filter's
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Clicking Collapse tree
    Then Should be able to collapse section levels results

 @Comparables
   Scenario: Tc_Comparables_56: Verify creating chart for selected series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 1 series inside table
    And Get the name of series
    And Click on "View as Chart. Type `c`" option in series level
    And Copy the insight title
    Then The "Selected Series Chart" should create for the series

 @Comparables
  Scenario: Tc_Comparables_58: Verify creating chart for multiple series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 2 series inside table
    And Hovor on series level only without click
    And Click on "View as Chart. Type `c`" option in series level
    Then The "Multiple Series Chart" should create for the series

 @Comparables
  Scenario: Tc_Comparables_59: Verify opening footnotes for series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 2 series inside table
    And Click on "Open footnote" option in series level
    Then The Footnotes window tab should be opened

 @Comparables
  Scenario: Tc_Comparables_60: Verify more options for series in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    Then More options for series should be present

  @Comparables
  Scenario: Tc_Comparables_61: Verify series selection when click on more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    Then The series should get selected by default

 @Comparables
  Scenario: Tc_Comparables_62: Verify add series in series level of comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Get the count of series inside table
    And Select 1 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add" from dropdown list
    Then The series should add into right pane

  @Comparables
  Scenario: Tc_Comparables_64: Verify add and group in series level of comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Get the count of series inside table
    And Select 1 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add and group series" from dropdown list
    Then The Selected series should get added into right pane with "Group"

  @Comparables
  Scenario: Tc_Comparables_65: Verify add to new insight
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Get the count of series inside table
    And Select 2 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add to new insight" from dropdown list
    And Series has been added to new insight message should display
    Then Clicking on the insight name should open the new insight with the added series
    And Closing the chart visual
    And Remove series from myseries pane

 @Comparables
  Scenario: Tc_Comparables_66: Verify add to recent insight
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 2 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add to recent insight" from dropdown list
    Then Any insight could be selected for the series to add

  @Comparables
  Scenario: Tc_Comparables_68: Verify view as chart in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on Add chart as "Line" in chart
    Then The "Edit Chart" option is displayed

  @Comparables
  Scenario: Tc_Comparables_69: Verify view as Map in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on Add chart as "Map"
    Then The "Edit Map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_70: Verify view as Table in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on Add chart as "Vertical"in Table
    Then The "Edit Table" option is displayed

  @Comparables
  Scenario: Tc_Comparables_72: Verify Addchart > Pie in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on Add chart as "Pie"
    Then The "Edit Pie" option is displayed

  @Comparables
  Scenario: Tc_Comparables_73: Verify Addchart > Heatmap in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on Add chart as "Heat map"
    Then The "Edit Heat map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_74: Verify Add chart >  Histogram in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on Add chart as "Histogram"
    Then The "Edit Histogram" option is displayed

  @Comparables
  Scenario: Tc_Comparables_75: Verify download in more option
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Select the "Download" in more option
    Then The "Download" option is shown
    
    @Comparables
  Scenario: Tc_Comparables_77: Verify copy in more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on "Copy" button in Comparables
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy" option is shown

  @Comparables
  Scenario: Tc_Comparables_78: Verify copy links in more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Select the "Copy selected links" option
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy selected links" option is shown

  @Comparables
  Scenario: Tc_Comparables_79: Verify series info for more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Select the "Series Info" in more option
    Then The "Series Info" option is shown

  @Comparables
  Scenario: Tc_Comparables_80: Verify footnotes for more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
   And Select the "Footnotes" in more option
    Then The "Footnotes" option is shown

  @Comparables
  Scenario: Tc_Comparables_81: Verify show dataset for more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
  	And Select the "Show Dataset" in more option
    Then The "Show Dataset" option is shown

  @Comparables
  Scenario: Tc_Comparables_82: Verify back button in dataset of more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
   And Select the "Show Dataset" in more option
    Then The "Back Button" option is shown

  @Comparables
  Scenario: Tc_Comparables_103: Verify right click options for series in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    Then Right click options should be available

  @Comparables
  Scenario: Tc_Comparables_105: Verify view as chart for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on Add chart as "Line" in chart
    Then The "Edit Chart" option is displayed

  @Comparables
  Scenario: Tc_Comparables_106: Verify view as Map for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on Add chart as "Map"
    Then The "Edit Map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_107: Verify view as Table for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on Add chart as "Vertical"in Table
    Then The "Edit Table" option is displayed

  @Comparables
  Scenario: Tc_Comparables_109: Verify Add chart > Pie for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on Add chart as "Pie"
    Then The "Edit Pie" option is displayed

  @Comparables
  Scenario: Tc_Comparables_110: Verify view as Heatmap for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on Add chart as "Heat map"
    Then The "Edit Heat map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_111: Verify view as Histogram for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on Add chart as "Histogram"
    Then The "Edit Histogram" option is displayed

  @Comparables
  Scenario: Tc_Comparables_112: Verify download for series level right click comparables
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on "Download" button in Comparables
    Then The "Download" option is shown

   @Comparables
  Scenario: Tc_Comparables_114: Verify copy for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on "Copy" button in Comparables
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy" option is shown

  @Comparables
  Scenario: Tc_Comparables_115: Verify copy links for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to series name without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Select the "Copy selected links" option
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy selected links" option is shown

  @Comparables
  Scenario: Tc_Comparables_116: Verify series info for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Select the "Series Info" option
    Then The "Series Info" option is shown

  @Comparables
  Scenario: Tc_Comparables_117: Verify footnotes for series level right click comparbles
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Select the "Footnotes" option
    Then The "Footnotes" option is shown

  @Comparables
  Scenario: Tc_Comparables_118: Verify show dataset for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Select the "Show Dataset" option
    Then The "Show Dataset" option is shown

  @Comparables
  Scenario: Tc_Comparables_119: Verify back button for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Select the "Show Dataset" option
    Then The "Back Button" option is shown

  @Comparables
  Scenario: Tc_Comparables_122: Verify top button when comparables tab is scrolled down
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Also Expand the "Real GDP: Y-o-Y Growth: Annual"
    Then The "Top button" option is shown

  @Comparables
  Scenario: Tc_Comparables_123: Verify unchecking comparables in three dot option (stay on comparables)
    And Click three dots in search pane
    And "Uncheck"  "Comparables" checkbox
    And Clicking "Save" button in search popup
    Then The Data tab is active by default
    And Click three dots in search pane
    And "Check"  "Comparables" checkbox
    And Clicking "Save" button in search popup

  @Comparables
  Scenario: Tc_Comparables_124 & Tc_Comparables_125: Verify maximizing and minimizing comprables tab
    And Clicking "Comparables" icon
    And Click "Expand search" option from top
    Then The Comparables tab is "Maximized"
    And Click "Expand views" option from top
    Then The Comparables tab is "Minimized"

  @Comparables
  Scenario: Tc_Comparables_140: Verify series added to new insight in comparables using growl popup
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
   	And Clicking on dropdown next to + option from series
    And Clicking "Add to new insight" from dropdown list
    And Series has been added to new insight message should display
    Then Clicking on go to the insight name should open the new insight with the added series

 @Comparables
  Scenario: Tc_Comparables_144: Verify adding series into existing insight by add to insight in insight explorer window
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
   And Clicking on dropdown next to + option from series
    And Clicking "Add to recent insight" from dropdown list
    Then Any insight could be selected for the series to add
    
  @Comparables
  Scenario: Tc_Comparables_145: Verify adding series into existing insight with existing insight shown in growl msg popup
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Clicking on dropdown next to + option from series
    And Clicking "Add to recent insight" from dropdown list
    Then Should be able to navigate to existing insight
    And Remove series from myseries pane

 @Comparables
  Scenario: Tc_Comparables_147: Verify series tooltip for series in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor only series name
    Then The options should present inside tooltip

 @Comparables
  Scenario: Tc_Comparables_150: Verify showing tool tip for mouse hover options in series level
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    Then The "Add to watchlist" , "View as Chart. Type `c`" , "Open footnote" , "More actions" and "Add series (A)" option for series should present

  @Comparables
  Scenario: Tc_Comparables_151: Verify view as scatter/bubble in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on series level only without click
    And Click on "More actions" button in Comparables
    And Click on Add chart as "Scatter"
    Then The "Edit Scatter" option is displayed
    
  @Comparables
  Scenario: Tc_Comparables_152: Verify view as Scatter/Bubble for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Albania" section from Comparables tab
    And Click on Add chart as "Scatter"
    Then The "Edit Scatter" option is displayed
