
Feature: Verify Comparables feature

  @Comparables
  Scenario: Tc_Comparables_01: Verify results loading in comparable tab
    And Clicking "Comparables" icon
    Then The Section level results for series should be present

  @Comparables
  Scenario: Tc_Comparables_02: Verify navigation to insight explorer window
    And Clicking "Comparables" icon
    And Clicking "My insights" link
    Then Should open Insight Explorer window in same tab

  #Tc_Comparables_03 & Tc_Comparables_04
  #@Comparables
  #Scenario: Tc_Comparables_03: Verify tooltips available for sections in comparables
  #And Clicking "Comparables" icon
  #And Right Click "National Accounts" section from Comparables tab
  #Then The "Copy link(s)" and "Footnotes" option for section should present
  #@Comparables
  #Scenario: Tc_Comparables_05: Verify changing order of placing comparables with other tab
  #And Count the number of texts in header
  #And Drag and Drop the Comparables text
  #Then Should be able to alter place of comparables tab with other tabs present over same row
  
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
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
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
  Scenario: Tc_Comparables_11: Verify copy link in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Click on "More actions" option in series level
    And Select the "Copy selected links" option
    And URL should be generated for selected series
    Then The Series information popup should be opened for selected series

  @Comparables
  Scenario: Tc_Comparables_12: Verify opening footnotes in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Click on "Open footnote" option in series level
    Then The Footnotes window tab should be opened

  #@Comparables
  #Scenario: Tc_Comparables_13: Verify right click options for section level's in comparables
  #And Clicking "Comparables" icon
  #And Right Click "National Accounts" section from Comparables tab
  #Then The "Copy selected links" and "Footnotes" option should present
  #
  #@Comparables2
  #Scenario: Tc_Comparables_14: Verify copy link on right click in comparables
  #And Clicking "Comparables" icon
  #And Right Click "National Accounts" section from Comparables tab
  #And Select the "Copy selected links" option
  #And URL should be generated for selected series
  #Then Copied URL should navigate to home page
  #
  #@Comparables2
  #Scenario: Tc_Comparables_15: Verify opening footnotes on right click in comparables
  #And Clicking "Comparables" icon
  #And Right Click "National Accounts" section from Comparables tab
  #And Select the "Footnotes" option
  #Then The Footnotes window should be opened
  #
  #@Comparables2
  #Scenario: Tc_Comparables_16: Verify copied link for section level in comparables
  #And Clicking "Comparables" icon
  #And Clicking "National Accounts" section from Comparables tab
  #And Get href of "National Accounts" section from Comparables tab
  #And Right Click "National Accounts" section from Comparables tab
  #And Select the "Copy selected links" option
  #And URL should be generated for selected series
  #Then Copied URL should paste in a new tab as respective section
  #
  #@Comparables2
  #Scenario: Tc_Comparables_17: Very message for copied link cogwheel popup
  #And Clicking "Comparables" icon
  #And Right Click "National Accounts" section from Comparables tab
  #And Select the "Copy selected links" option
  #And Message should display
  #Then The "1 URL link(s) copied." message should be popped up
  @Comparables
  Scenario: Tc_Comparables_18: Verify results for applying filters in comparables
    And Clicking "Comparables" icon
    And User selects "Frequency" as "Monthly"
    And Count the series in selected Filter
    And User has clicked on "Apply filter"
    Then The comparables count should match to applied filter count

  @Comparables
  Scenario: Tc_Comparables_19: Verifying removing filters in comparables
    And Clicking "Comparables" icon
    And The Section level results for series should be present
    And User selects "Frequency" as "Monthly"
    And Count the series in selected Filter
    And User has clicked on "Apply filter"
    And Resetting the filters
    Then The comparables count should match to actual count

  @Comparables
  Scenario: Tc_Comparables_20: Verify applying multiple filters to get required results
    And Clicking "Comparables" icon
    And User selects "Frequency" as "Daily;Quarterly;Monthly;Yearly"
    And Count the series in multiple selected Filter
    And User has clicked on "Apply filter"
    Then The comparables count should match to applied filters count

  @Comparables
  Scenario: Tc_Comparables_21: Verify reset button in comparables tab
    And Clicking "Comparables" icon
    And The Section level results for series should be present
    And User selects "Frequency" as "Daily;Quarterly;Monthly;Yearly"
    And Count the series in multiple selected Filter
    And User has clicked on "Apply filter"
    And The comparables count should match to applied filters count
    And Resetting the filters
    Then The comparables count after reset should match to applied filter count

  @Comparables
  Scenario: Tc_Comparables_28: Verify search results for comparables
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    Then Related results should be shown in comparables

  @Comparables
  Scenario: Tc_Comparables_29: Verify collapse all option for comparables->Table
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    And Click "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" to collapse
    And Clicking Collapse tree
    Then Should be able to collapse section levels results

  @Comparables
  Scenario: Tc_Comparables_30: Verify collapse all option for comparables->series
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    And Clicking Collapse tree
    Then Should be able to collapse section levels results

  #@Comparables....removed for table level
  #Scenario: Tc_Comparables_31: Verify options for table level's in comparables
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
    #And Clicking "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
    #And Clicking "add-to-data-selection--toggle" option from Table
    #Then "Add" , "Add and replace" , "Add and group" , "Add to new insight" , "Add to recent insight" Options should present

  #@Comparables.. right click options has been removed
  #Scenario: Tc_Comparables_32: Verify right click options in table level of comparables
  #And Clicking "Comparables" icon
  #And Search for "249416501"
  #And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" > "Industrial Production Index: YoY: Monthly: sa: Japan"
  #And Click "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" to collapse
  #And Get href of "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Right Click "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Select the "Copy selected links" option
  #And URL should be generated for selected series
  #Then Copied URL should paste in a new tab as respective section
  #
  #@Comparables
  #Scenario: Tc_Comparables_33: Verify footnotes in table level of comparables
  #And Clicking "Comparables" icon
  #And Search for "249416501"
  #And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" > "Industrial Production Index: YoY: Monthly: sa: Japan"
  #And Click "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Select the "Footnotes" option
  #Then The Footnotes window should be opened
  #
  #@Comparables.. add icon (+) is removed
  #Scenario: Tc_Comparables_34: Verify add series in table level of comparables
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Get the count of series inside first table
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Clicking "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Clicking "add-to-data-selection--toggle" option from Table
  #And Get Text of Table
  #And Clicking "Add series" from dropdown list
  #Then The Table level series are added into my series panel
  #
  #@Comparables
  #Scenario: Tc_Comparables_36: Verify add and group for comparables in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Select 2 series inside table
  #And Clicking + option from series
  #And Clicking "Add and group series" from dropdown list
  #Then The Selected series should get added into right pane with "Group"
  #
  #@Comparables
  #Scenario: Tc_Comparables_37: Verify add to new insight
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Clicking "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Clicking "add-to-data-selection--toggle" option from Table
  #And Get Text of Table
  #And Clicking "Add to new insight" from dropdown list
  #And Series has been added to new insight message should display
  #Then Clicking on the insight name should open the new insight
  #
  #@Comparables
  #Scenario: Tc_Comparables_38: Verify add to existing insight
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Clicking "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Clicking "add-to-data-selection--toggle" option from Table
  #And Clicking "Add to recent insight" from dropdown list
  #Then Any insight could be selected for the table to add
  #And Closing the chart visual
  
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
    #And User has clicked on "Apply filter"
    #And Verify Subscribed series only filter under filters
    And Select "key" checkbox from more section
    And User has clicked on "Apply filter"
    And Clicking "Comparables" icon
    And Expand the tree for key icons
    And Hovor on the series from table
    Then The Applied "Multiple" filter is displaying under Comparables

  @Comparables
  Scenario: Tc_Comparables_41: Verify SSP window for series level
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Click on series name
    Then Verify SSP window

  @Comparables
  Scenario: Tc_Comparables_42: Verify checkbox selection for tables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Check the checkbox "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
    Then The series present inside the Table should gets selected

  @Comparables
  Scenario: Tc_Comparables_43: Verify check box selection for series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Select 1 series inside table
    Then The series should gets selected

  @Comparables
  Scenario: Tc_Comparables_44: Verify check box selection for multiple series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Select 2 series inside table
    Then The series should gets selected

  @Comparables
  Scenario: Tc_Comparables_45: Verify unchecking selection of tables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Uncheck the checkbox "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
    Then The series present inside the Table should gets deselected

  @Comparables
  Scenario: Tc_Comparables_46: Verify unchecking selection of series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Deselect 2 series inside table
    Then The series should gets deselected

  @Comparables
  Scenario: Tc_Comparables_48: Verify opening SSP when click on series name
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to series name
    Then SSP window for specific series should be opened

  @Comparables
  Scenario: Tc_Comparables_49: Verify drag and drop for comparable series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 1 series inside table
    And Get the name of series
    And Perform Drag and Drop operation
    Then Series should get added into myseries pane

  @Comparables
  Scenario: Tc_Comparables_50: Verify drag and drop for multiple comparable series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 3 series inside table
    And Get the name of series
    And Perform Drag and Drop operation
    Then Series should get added into myseries pane

  @Comparables
  Scenario: Tc_Comparables_51: Verify downloading series selected in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 2 series inside table
    And Get the name of series
    And Clicking "Download" button from Header portion
    Then The Series selected should gets downloaded to excel

  @Comparables
  Scenario: Tc_Comparables_52: Verify CTC of series in comparables
    And Clicking "Comparables" icon
    And Search for "249416501"
    And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    And Select 1 series inside table
    And Get the name of series
    And Clicking "Copy to Clipboard" button from Header portion
    And Copy the data after clicking Copy button
    Then The Series selected should gets copied to excel
#
  #@Comparables
  #Scenario: Tc_Comparables_53: Verify opening dropdown for series in comparables
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #Then The "Show related data" Option for the series should present
#
  #@Comparables
  #Scenario: Tc_Comparables_54: Verify closing dropdown for series in comparables
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And Click "Hide related data" option in series
    #Then The "Hide related data" Option for the series should present

  @Comparables
  Scenario: Tc_Comparables_55: Verify collapse all for series in comparables without any filter's
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Clicking Collapse tree
    Then Should be able to collapse section levels results

  @Comparables
  Scenario: Tc_Comparables_56: Verify creating chart for selected series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 1 series inside table
    And Get the name of series
    And Click on more actions to create "View as Chart"
    And Copy the insight title
    Then The "Selected Series Chart" should create for the series

  @Comparables
  Scenario: Tc_Comparables_57: Verify creating chart for unselected series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    And Click on more actions to create "View as Chart"
    And Copy the insight title
    Then The "Unselected Series Chart" should create for the series

  @Comparables
  Scenario: Tc_Comparables_58: Verify creating chart for multiple series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Select 2 series inside table
    And Hovor on to i icon without click
    And Click on more actions to create "View as Chart"
    Then The "Multiple Series Chart" should create for the series

  @Comparables
  Scenario: Tc_Comparables_59: Verify opening footnotes for series
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Select 2 series inside table
    And Click on "Open footnote" option in series level
    Then The Footnotes window tab should be opened

  @Comparables
  Scenario: Tc_Comparables_60: Verify more options for series in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Click on "More actions" option in series level
    Then The "Unselect all" , "Add", "Add to new insight", "Add to recent insight", "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy" , "Copy data" , "Copy selected links" , "Add to Watchlist" , "Series Info" , "Footnotes" , "Show Dataset" options should available

  @Comparables
  Scenario: Tc_Comparables_61: Verify series selection when click on more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    Then The series should get selected by default

  @Comparables
  Scenario: Tc_Comparables_62: Verify add series in series level of comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Get the count of series inside table
    And Select 1 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add series" from dropdown list
    Then The series should add into right pane

  @Comparables
  Scenario: Tc_Comparables_64: Verify add and group in series level of comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Get the count of series inside table
    And Select 1 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add and group series" from dropdown list
    Then The Selected series should get added into right pane with "Group"

  @Comparables
  Scenario: Tc_Comparables_65: Verify add to new insight
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Get the count of series inside table
    And Select 2 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add to new insight" from dropdown list
    And Series has been added to new insight message should display
    Then Clicking on the insight name should open the new insight with the added series
    And Closing the chart visual
    And Remove series from myseries pane

  @Comparables
  Scenario: Tc_Comparables_66: Verify add to existing insight
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Select 2 series inside table
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add to recent insight" from dropdown list
    Then Any insight could be selected for the series to add
    And Closing the chart visual

  @Comparables
  Scenario: Tc_Comparables_67: Verify unselect all in more option
    And Remove series from myseries pane
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Select 2 series inside table
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "Unselect all" button in Comparables
    Then Selected series should get deselected

  @Comparables
  Scenario: Tc_Comparables_68: Verify view as chart in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "View as Chart" button in Comparables
    Then The "Edit Chart" option is displayed

  @Comparables
  Scenario: Tc_Comparables_69: Verify view as Map in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "View as Map" button in Comparables
    Then The "Edit Map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_70: Verify view as Table in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "View as Table" button in Comparables
    Then The "Edit Table" option is displayed

  @Comparables
  Scenario: Tc_Comparables_71: Verify view as... in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "View as ..." button in Comparables
    Then The "Pie" , "Heat map" , "Histogram" options are present

  @Comparables
  Scenario: Tc_Comparables_72: Verify view as Pie in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Choose "View as ..." > "Pie"
    Then The "Edit Pie" option is displayed

  @Comparables
  Scenario: Tc_Comparables_73: Verify view as Heatmap in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Choose "View as ..." > "Heat map"
    Then The "Edit Heat map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_74: Verify view as Histogram in more options
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Choose "View as ..." > "Histogram"
    Then The "Edit Histogram" option is displayed

  @Comparables
  Scenario: Tc_Comparables_75: Verify download in more option
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "Download" button in Comparables
    Then The "Download" option is shown

  @Comparables
  Scenario: Tc_Comparables_76: Verify copy data in more option
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "Copy data" button in Comparables
    Then The "Copy data" option is shown

  @Comparables
  Scenario: Tc_Comparables_77: Verify copy in more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Click on "Copy" button in Comparables
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy" option is shown

  @Comparables
  Scenario: Tc_Comparables_78: Verify copy links in more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to series name without click
    And Click on "More actions" button in Comparables
    And Select the "Copy selected links" option
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy selected links" option is shown

  @Comparables
  Scenario: Tc_Comparables_79: Verify series info for more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to series name without click
    And Click on "More actions" button in Comparables
    And Select the "Series Info" option
    Then The "Series Info" option is shown

  @Comparables
  Scenario: Tc_Comparables_80: Verify footnotes for more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Select the "Footnotes" option
    Then The "Footnotes" option is shown

  @Comparables
  Scenario: Tc_Comparables_81: Verify show dataset for more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Select the "Show Dataset" option
    Then The "Show Dataset" option is shown

  @Comparables
  Scenario: Tc_Comparables_82: Verify back button in dataset of more option
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Click on "More actions" button in Comparables
    And Select the "Show Dataset" option
    Then The "Back Button" option is shown

  #@Comparables2
  #Scenario: Tc_Comparables_83: Verify right options for topic level's in comparables
  #And Clicking "Comparables" icon
  #And Click "National Accounts" to collapse
  #And Right Click "Global Economic Monitor" section from Comparables tab
  #Then The "Copy selected links" and "Footnotes" option should present
  #
  #@Comparables2
  #Scenario: Tc_Comparables_84: Verify copy link(s) in right click for topic level
  #And Clicking "Comparables" icon
  #And Click "National Accounts" to collapse
  #And Right Click "Global Economic Monitor" section from Comparables tab
  #And Select the "Copy selected links" option
  #And URL should be generated for selected series
  #Then Copied URL should navigate to home page
  #
  #@Comparables2
  #Scenario: Tc_Comparables_85: Verify footnotes in right click for topic level
  #And Clicking "Comparables" icon
  #And Click "National Accounts" to collapse
  #And Right Click "Global Economic Monitor" section from Comparables tab
  #And Select the "Footnotes" option
  #Then The Footnotes window should be opened
  #
  #@Comparables
  #Scenario: Tc_Comparables_86: Verify right click options for table level's in comparables
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy link(s)" , "Add to Watchlist" , "Footnotes" , "Show Dataset" options should available in table
  #
  #@Comparables
  #Scenario: Tc_Comparables_87: Verify unselect all in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Click on "Unselect all" button in Comparables
  #Then The "Table - Unselect all" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_88: Verify view as chart in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Click on "View as Chart" button in Comparables
  #Then The "Table - Edit Chart" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_89: Verify view as Map in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Click on "View as Map" button in Comparables
  #Then The "Table - Edit Map" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_90: Verify view as Table in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Click on "View as Table" button in Comparables
  #Then The "Table - Edit Table" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_91: Verify view as... in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Click on "View as ..." button in Comparables
  #Then The "Pie" , "Heat map" , "Histogram" options are present
  #
  #@Comparables
  #Scenario: Tc_Comparables_92: Verify view as Pie in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Choose "View as ..." > "Pie"
  #Then The "Table - Edit Pie" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_93: Verify view as Heatmap in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Choose "View as ..." > "Heat map"
  #Then The "Table - Edit Heat map" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_94: Verify view as Histogram in table level
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Choose "View as ..." > "Histogram"
  #Then The "Table - Edit Histogram" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_95: Verify download in table
  #And Open preference dropdown
  #And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
  #And Open preference dropdown
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Get the name of series inside table
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Click on "Download" button in Comparables
  #Then The "Table - Download" option is shown
  #
  #@Comparables
  #Scenario: Tc_Comparables_96: Verify copy links in table
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Get href of "Table: Real GDP: Q-o-Q Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Select the "Copy selected links" option
  #And URL should be generated for selected series
  #And Copy the data after clicking Copy button
  #Then Copied URL should paste in a new tab as respective section
  #
  #@Comparables
  #Scenario: Tc_Comparables_97: Verify footnotes in table
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Q-o-Q Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Select the "Footnotes" option
  #Then The Footnotes window should be opened
  #
  #@Comparables
  #Scenario: Tc_Comparables_98: Verify show dataset in table
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Count the series inside "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia"
  #And Get the name of series inside table
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Select the "Show Dataset" option
  #Then The "Show Dataset" option should present
  #
  #@Comparables
  #Scenario: Tc_Comparables_99: Verify show dataset series select in table
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Select the "Show Dataset" option
  #Then The "Selected series in Dataset" option should present
  #
  #@Comparables
  #Scenario: Tc_Comparables_100: Verify show dataset back button in table
  #And Clicking "Comparables" icon
  #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
  #And Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
  #And Right Click "Table: Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
  #And Select the "Show Dataset" option
  #Then The "Back button in Dataset" option should present
  @Comparables
  Scenario: Tc_Comparables_103: Verify right click options for series in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    Then The "Unselect all" , "Add", "Add to new insight", "Add to recent insight", "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy" , "Copy data" , "Copy selected links" , "Add to Watchlist" , "Series Info" , "Footnotes" , "Show Dataset" options should available

  @Comparables
  Scenario: Tc_Comparables_104: Verify unselect all for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Select 1 series inside table
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "Unselect all" button in Comparables
    Then Selected series should get deselected

  @Comparables
  Scenario: Tc_Comparables_105: Verify view as chart for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "View as Chart" button in Comparables
    Then The "Edit Chart" option is displayed

  @Comparables
  Scenario: Tc_Comparables_106: Verify view as Map for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "View as Map" button in Comparables
    Then The "Edit Map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_107: Verify view as Table for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "View as Table" button in Comparables
    Then The "Edit Table" option is displayed

  @Comparables
  Scenario: Tc_Comparables_108: Verify view as... for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "View as ..." button in Comparables
    Then The "Pie" , "Heat map" , "Histogram" options are present

  @Comparables
  Scenario: Tc_Comparables_109: Verify view as Pie for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Choose "View as ..." > "Pie"
    Then The "Edit Pie" option is displayed

  @Comparables
  Scenario: Tc_Comparables_110: Verify view as Heatmap for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Choose "View as ..." > "Heat map"
    Then The "Edit Heat map" option is displayed

  @Comparables
  Scenario: Tc_Comparables_111: Verify view as Histogram for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Choose "View as ..." > "Histogram"
    Then The "Edit Histogram" option is displayed

  @Comparables
  Scenario: Tc_Comparables_112: Verify download for series level right click comparables
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "Download" button in Comparables
    Then The "Download" option is shown

  @Comparables
  Scenario: Tc_Comparables_113: Verify copy data for series level right click comparables
    And Open preference dropdown
    And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check"
    And Open preference dropdown
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "Copy data" button in Comparables
    Then The "Copy data" option is shown

  @Comparables
  Scenario: Tc_Comparables_114: Verify copy for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Click on "Copy" button in Comparables
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy" option is shown

  @Comparables
  Scenario: Tc_Comparables_115: Verify copy links for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to series name without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Select the "Copy selected links" option
    And URL should be generated for selected series
    And Copy the data after clicking Copy button
    Then The "Copy selected links" option is shown

  @Comparables
  Scenario: Tc_Comparables_116: Verify series info for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Select the "Series Info" option
    Then The "Series Info" option is shown

  @Comparables
  Scenario: Tc_Comparables_117: Verify footnotes for series level right click comparbles
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Select the "Footnotes" option
    Then The "Footnotes" option is shown

  @Comparables
  Scenario: Tc_Comparables_118: Verify show dataset for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Select the "Show Dataset" option
    Then The "Show Dataset" option is shown

  @Comparables
  Scenario: Tc_Comparables_119: Verify back button for series level right click comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Right Click "Real GDP: YoY: Quarterly: sa: Australia" section from Comparables tab
    And Select the "Show Dataset" option
    Then The "Back Button" option is shown

  @Comparables
  Scenario: Tc_Comparables_122: Verify top button when comparables tab is scrolled down
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Also Expand the "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Europe and Central Asia"
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

  #TC_124 and TC_125
  @Comparables
  Scenario: Tc_Comparables_124: Verify maximizing and minimizing comprables tab
    And Clicking "Comparables" icon
    And Click "Expand search" option from top
    Then The Comparables tab is "Maximized"
    And Click "Expand views" option from top
    Then The Comparables tab is "Minimized"

  #@Comparables
  #Scenario: Tc_Comparables_127: Verify Read more for series in comparables
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Read More" option for series should present
    #Then The Footnotes window should be open
#
  #@Comparables
  #Scenario: Tc_Comparables_128: Verify contents in dropdown beside series name
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #Then The "Read More" option in series should present
    #Then The "Datasets" option in series should present
    #And The "Related Insights" option in series should present
    #Then The "related-series-data--remarks" option in series should be present
    #And Click "Hide related data" option in series
#
  #@Comparables
  #Scenario: Tc_Comparables_129: Verify data sets for related series
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "series-data-set--table-name" option for series should present
    #Then The link is navigating to "Single Series"
    #And Click "Hide related data" option in series
#
  #@Comparables
  #Scenario: Tc_Comparables_130: Verify data sets for Multiple related series
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #Then The link is navigating to "Multiple Series"
    #And Click "Hide related data" option in series
#
  #@Comparables
  #Scenario: Tc_Comparables_131: Verify navigating to database for related series in series level
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And Click on "database" for related series
    #Then The related "Database" for the series should shown
#
  #@Comparables
  #Scenario: Tc_Comparables_132: Verify navigating to topic for related series in series level
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And Click on "topic" for related series
    #Then The related "Topic" for the series should shown
#
  #@Comparables
  #Scenario: Tc_Comparables_133: Verify navigating to section for related series in series level
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And Click on "section" for related series
    #Then The related "Section" for the series should shown
#
  #@Comparables
  #Scenario: Tc_Comparables_134: Verify related insights for comparables in series level
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #Then The "Related Insights" option in series should present
    #And Click "Hide related data" option in series
#
  #@Comparables
  #Scenario: Tc_Comparables_136: Verify opening any of related insights in comparables
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Related Insights" option in series should present
    #And Check the data of first insight
    #And Click "Hide related data" option in series
#
  #@Comparables
  #Scenario: Tc_Comparables_137: Verify favoriting related insight in comparables
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Related Insights" option in series should present
    #And The "First" Insight should present
    #And Clicking favorite icon of related insight
    #And Click on "My insights" option in insights page
    #Then The Related insights should be added to favourite list in insight explorer window of favorite tab
#
  #@Comparables
  #Scenario: Tc_Comparables_138: Verify sharing of related insight in comparables
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Related Insights" option in series should present
    #Then The Sharing insight window should be opened
#
  #@Comparables2
  #Scenario: Tc_Comparables_139: Verify sharing of non sharing related insight
    #And Clicking "Comparables" icon
    #And Search for "249416501"
    #And Expand "Production" > "Global Economic Monitor" > "Industrial Production Index: Y-o-Y Growth: Monthly: Seasonally Adjusted: Asia" > "Industrial Production Index: YoY: Monthly: sa: Japan"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Insights" option in series should present
    #And The "Non shareable Insight" Insight should present
    #Then The Share icon should not present for non sharing related insight

  @Comparables
  Scenario: Tc_Comparables_140: Verify series added to new insight in comparables using growl popup
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    And Clicking + option from series
    And Clicking "Add to new insight" from dropdown list
    And Series has been added to new insight message should display
    Then Clicking on go to the insight name should open the new insight with the added series

  @Comparables
  Scenario: Tc_Comparables_141: Verify opening insight explorer window for series added to existing insight in comprables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    And Clicking + option from series
    And Clicking "Add to recent insight" from dropdown list
    Then Insight explorer window should be opened
    And Remove series from myseries pane

  @Comparables
  Scenario: Tc_Comparables_144: Verify adding series into existing insight by add to insight in insight explorer window
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    And Clicking + option from series
    And Clicking "Add to recent insight" from dropdown list
    Then Any insight could be selected for the series to add
    And Insight explorer window should be closed

  @Comparables
  Scenario: Tc_Comparables_145: Verify adding series into existing insight with existing insight shown in growl msg popup
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    And Clicking + option from series
    And Clicking "Add to recent insight" from dropdown list
    Then Should be able to navigate to existing insight
    And Remove series from myseries pane

  @Comparables
  Scenario: Tc_Comparables_147: Verify series tooltip for series in comparables
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor only series name
    Then The options should present inside tooltip

  #@Comparables
  #Scenario: Tc_Comparables_148: Verify showing tool tip for mouse hover options in section level
    #And Clicking "Comparables" icon
    #And Right Click "National Accounts" section from Comparables tab
    #Then The "Copy link(s)" and "Footnotes" option for section should present

  #@Comparables
  #Scenario: Tc_Comparables_149: Verify showing tool tip for mouse hover options in table level
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" to collapse
    #And Right Click "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" section from Comparables tab
    #Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy link(s)" , "Add to Watchlist" , "Footnotes" , "Show Dataset" options should available in table

  @Comparables
  Scenario: Tc_Comparables_150: Verify showing tool tip for mouse hover options in series level
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    And Hovor on to i icon without click
    Then The "Add to watchlist" , "View as Chart. Type `c`" , "Open footnote" and "More actions" option for series should present

  #@Comparables
  #Scenario: Tc_Comparables_151: Verify deselecting series when series dropdown opened
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Select 1 series inside table
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And Unselect 1 series inside table
    #Then The opened dropdown should not close
#
  #@Comparables
  #Scenario: Tc_Comparables_152: Verify presence of related insights in series level of comprables tab
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Related Insights" option in series should present
    #Then The tooltip as "Name" and "Number of series" should present
#
  #@Comparables
  #Scenario: Tc_Comparables_153: Verify creator of related insight present in series level comparables tab
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Related Insights" option in series should present
    #Then The creator tooltip should present
#
  #@Comparables
  #Scenario: Tc_Comparables_154: Verify time period of related insight present in series level comparables tab
    #And Clicking "Comparables" icon
    #And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Australia"
    #And Hovor on to i icon without click
    #And Click "Show related data" option in series
    #And The "Related Insights" option in series should present
    #Then The Modified time tooltip should present

  @Comparables
  Scenario: TC_Comparables_155: Verify Add to Watchlist icon in series level
    And Clicking "Comparables" icon
	    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    #And Click on "More actions" option in series level
    And Click on "Add to Watchlist" option in series level
    And Select "popup_notifications" option from watchlist
    And Select "email_notifications" option from watchlist
    And Select "Daily" option from watchlist
    And User has clicked on "Apply"
    And Growl message as "Watchlist changes applied" should display
    Then The selected actions should reflect inside watchlist tab

  @Comparables
  Scenario: TC_Comparables_156: Verify Add to Watchlist option in series level right click
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    #And Right click the first series
    And Click on "Add to Watchlist" option in series level
    And Select "popup_notifications" option from watchlist
    And Select "email_notifications" option from watchlist
    And Select "Weekly" option from watchlist
    And User has clicked on "Apply"
    And Growl message as "Watchlist changes applied" should display
    Then The selected actions should reflect inside watchlist tab

  @Comparables
  Scenario: TC_Comparables_157: Verify Add to Watchlist option in series level more actions
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    #And Click on "More actions" option in series level
    And Click on "Add to Watchlist" option in series level
    And Select "popup_notifications" option from watchlist
    And Select "email_notifications" option from watchlist
    And Select "Monthly" option from watchlist
    And User has clicked on "Apply"
    And Growl message as "Watchlist changes applied" should display
    Then The selected actions should reflect inside watchlist tab

  @Comparables
  Scenario: TC_Comparables_158: Verify Add to Watchlist option in series level more actions
    And Clicking "Comparables" icon
    And Expand "National Accounts" > "Global Economic Monitor" > "Real GDP: Y-o-Y Growth: Quarterly: Seasonally Adjusted: Asia" > "Real GDP: YoY: Quarterly: sa: Albania"
    And Hovor on to i icon without click
    #And Click on "More actions" option in series level
    And Click on "Add to Watchlist" option in series level
    And Select "popup_notifications" option from watchlist
    And Select "email_notifications" option from watchlist
    And Select "Hourly" option from watchlist
    And User has clicked on "Apply"
    And Growl message as "Watchlist changes applied" should display
    Then The selected actions should reflect inside watchlist tab

