Feature: Verifying Datasets functionality
 
@DatasetsTab
Scenario Outline: TC_Data_set_05: Verify Sort by option for dataset tab
   And Clicking "Datasets" tab from menu
   Then Verify Sort by option <actual> for <index>
Examples:
   |     actual          |  index   |
   |  "Popularity"       |     1    |
   |  "Recently Updated" |     2    |
   |  "New Series"       |     3    |
   |  "Region"           |     4    |
   
@DatasetsTab
Scenario: TC_Data_set_06: Verify closing Sort by option for dataset tab
   And Open preference dropdown
   And Clicking on "Ask me to confirm the download settings" option under user preference to be "Check" 
   And Clicking on "Keyboard shortcuts" option under user preference be "ON"
   And Open preference dropdown
   And Clicking "Datasets" tab from menu
   And Click on the Sort by option	
   Then Verify closing the Sort by option
   
@DatasetsTab
Scenario Outline: TC_Data_set_07: Verify the tooltips for Sort by options in dataset tab
   And Clicking "Datasets" tab from menu
   Then Verify the <tooltips> with Sort by options for <index>
Examples:
   |      tooltips      |   index  |
   | "Popularity"       |     1    |
   | "Recently Updated" |     2    |
   | "New Series"       |     3    |
   | "Region"           |     4    |
   
@DatasetsTab
Scenario: TC_Data_set_08: Verify the expand option in dataset tab
   And Clicking "Datasets" tab from menu
   Then Verify "Expand" the datasets "Without" keyboard shortcuts
   
@DatasetsTab
Scenario: TC_Data_set_09: Verify the expand option in dataset tab with keyboard shortcuts
   And Right Click "Dataset" section from Comparables tab
   Then Verify "Expand" the datasets "With" keyboard shortcuts
   
@DatasetsTab
Scenario: TC_Data_set_10: Verify the collapse option in dataset tab
   And Clicking "Datasets" tab from menu
   Then Verify "Collapse" the datasets "Without" keyboard shortcuts
   
@DatasetsTab
Scenario: TC_Data_set_11: Verify the collapse option in dataset tab with keyboard shortcuts
   And Right Click "Dataset" section from Comparables tab
   Then Verify "Collapse" the datasets "With" keyboard shortcuts
   
@DatasetsTab
Scenario: TC_Data_set_12: Verify the tooltips for different datasets
   And Clicking "Datasets" tab from menu
   Then Verify the tooltips for different dataset
   
@DatasetsTab
Scenario: TC_Data_set_13: Verify selecting dataset's in search dataset tab
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   Then Verify Checkbox is checked
   
@DatasetsTab
Scenario: TC_Data_set_14: Verify adding any dataset into my series tab	
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Click on "A" option shortcut
   Then Verify that the dataset is added in right pane
   
@DatasetsTab
Scenario: TC_Data_set_15: Verify adding any dataset into my series tab	by drag and drop
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Click on "Drag and Drop a Dataset" option shortcut
   Then Verify that the dataset is added in right pane
   
@DatasetsTab
Scenario: TC_Data_set_16: Verify adding any series into my series tab
   And Clicking "Datasets" tab from menu
   And Verify "Expand" the datasets "Without" keyboard shortcuts
   And Select the series checkbox
   And Click on "A" option shortcut
   Then Verify that the series is added in right pane
   
@DatasetsTab
Scenario: TC_Data_set_17: Verify adding any series into my series tab by drag and drop
   And Clicking "Datasets" tab from menu
   And Verify "Expand" the datasets "Without" keyboard shortcuts
   And Select the series checkbox
   And Click on "Drag and Drop a Series" option shortcut
   Then Verify that the series is added in right pane
   
@DatasetsTab
Scenario Outline: TC_Data_set_18: Verify adding dataset into visual pane
   And Search for the "Datasets" with ID "TB5350" and click on <shortcut> option
   Then Verify the <visual> and validate <edit> option
   Examples:
   |  shortcut    | visual   |      edit      |
   |     "C"      | "Chart"  |  "Edit Chart"  |
   |     "T"      | "Table"  |  "Edit Table"  |
   |     "M"      | "Map"    |  "Edit Map"    |
   
@DatasetsTab
Scenario Outline: TC_Data_set_19: Verify adding dataset into visual pane by drag and drop
   And Create an empty view and click on <type> option
   And Search for the "Datasets" with ID "TB5350" 
   And Click on "Drag and Drop a Dataset" option shortcut
   Then Verify the <visual> and validate <edit> option
   Examples:
   | visual   |      edit      |  type   |
   | "Chart"  |  "Edit Chart"  | "Line"  |
   | "Table"  |  "Edit Table"  | "Table" |
   | "Map"    |  "Edit Map"    | "Map"   |
   
@DatasetsTab
Scenario Outline: TC_Data_set_20: Verify adding series of a dataset into visual pane
   And Search for "Datasets" with ID "368640317" and click on <shortcut> option
   Then Verify the <visual> for series and validate <edit> option
   Examples:
   |  shortcut    | visual   |      edit      |
   |     "C"      | "Chart"  |  "Edit Chart"  |
   |     "T"      | "Table"  |  "Edit Table"  |
   |     "M"      | "Map"    |  "Edit Map"    |
   
@DatasetsTab
Scenario Outline: TC_Data_set_21: Verify adding series of a dataset into visual pane by drag and drop
   And Create an empty view and click on <type> option
   And Search for the "Datasets" with ID "368640317" 
   And Verify "Expand" the datasets "Without" keyboard shortcuts
   And Click on "Drag and Drop a Series" option shortcut	
   Then Verify the <visual> for series and validate <edit> option
   Examples:
   | visual   |      edit      |  type   |
   | "Chart"  |  "Edit Chart"  | "Line"  |
   | "Table"  |  "Edit Table"  | "Table" |
   | "Map"    |  "Edit Map"    | "Map"   |
   
@DatasetsTab
Scenario: TC_Data_set_26: Verify load more option for dataset's tab
   And Clicking "Datasets" tab from menu
   And Clicking Load more option
   Then Verify the Load more button
   
@DatasetsTab
Scenario Outline: TC_Data_set_27: Verify Sort by option for dataset tab
   And Clicking "Datasets" tab from menu
   Then Verify Sort by option <actual> for <index>
Examples:
   |     actual          |  index   |
   |  "Popularity"       |     1    |
   |  "Recently Updated" |     2    |
   |  "New Series"       |     3    |
   |  "Region"           |     4    |
   
@DatasetsTab
Scenario: TC_Data_set_31: Verify opening footnotes for dataset tab
   And Clicking "Datasets" tab from menu
   And Click the footnotes icon
   Then Verify the footnotes option
   
@DatasetsTab
Scenario: TC_Data_set_32: Verify adding any dataset into my series tab with + icon
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Clicking "add-to-data-selection--title" option from Table
   Then Verify that the dataset is added in right pane
   
@DatasetsTab
Scenario: TC_Data_set_33: Verify dropdown for mouse hover options
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Clicking "add-to-data-selection--toggle" option from Table
    Then  "Add" , "Add and replace" , "Add and group" , "Add to new insight" , "Add to recent insight" Options should present
    
@DatasetsTab
Scenario: TC_Data_set_34: Verify adding any dataset into my series tab with Add option
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Clicking "add-to-data-selection--toggle" option from Table
   And Clicking "Add series" from dropdown list
   Then Verify that the dataset is added in right pane
   
@DatasetsTab
Scenario: TC_Data_set_35: Verify add and replace into visual pane
   And Search for the "Datasets" with ID "TB3840" and click on "C" option
   And Search for the "Datasets" with ID "TB5350" 
   And Clicking "add-to-data-selection--toggle" option from Table
   And Clicking "Add and replace series" from dropdown list
   And Select any checkbox for dataset
   Then Verify the replaced series
   
@DatasetsTab
Scenario: TC_Data_set_36 & TC_Data_set_38: Verify add to new insight and growl message into visual pane
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Clicking "add-to-data-selection--toggle" option from Table
   And Clicking "Add to new insight" from dropdown list
   And Series has been added to new insight message should display
   Then Clicking on the insight name should open new insight
   
@DatasetsTab
Scenario: TC_Data_set_37: Verify add to existing insight into visual pane
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Clicking "add-to-data-selection--toggle" option from Table
   And Clicking "Add to recent insight" from dropdown list
   Then Any insight could be selected for the table to add
   
@DatasetsTab
Scenario: TC_Data_set_40: Verify add and Group insight into visual pane
   And Clicking "Datasets" tab from menu
   And Select any checkbox for dataset
   And Clicking "add-to-data-selection--toggle" option from Table
   And Clicking "Add and group series" from dropdown list
   Then Verify that the dataset is added in right pane
   
@DatasetsTab
Scenario: TC_Data_set_43: Verify unselect all for right click on dataset
   And Right Click "Dataset" section from Comparables tab
   And Select any checkbox for dataset
   And Verify "Expand" the datasets "Without" keyboard shortcuts
   And Collapse the dataset and perform right click operation
   And Click on "Unselect all" button in Comparables
   Then The "Table - Unselect all" option is shown
   Then Check the download button and search box
   
@DatasetsTab
Scenario: TC_Data_set_44: Verify view as chart for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Collapse the dataset and perform right click operation
    And Click on "View as Chart" button in Comparables
    Then The "Table - Edit Chart" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_45: Verify view as map for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Collapse the dataset and perform right click operation
    And Click on "View as Map" button in Comparables
    Then The "Table - Edit Map" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_46: Verify view as table for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Collapse the dataset and perform right click operation
    And Click on "View as Table" button in Comparables
    Then The "Table - Edit Table" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_47: Verify view as... for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Collapse the dataset and perform right click operation
    And Click on "View as ..." button in Comparables
    Then The "Pie" , "Heat map" , "Histogram" options are present
    
@DatasetsTab
Scenario: TC_Data_set_48: Verify view as pie for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Collapse the dataset and perform right click operation
    And Choose "View as ..." > "Pie" 
    Then The "Table - Edit Pie" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_49: Verify view as heatmap for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Collapse the dataset and perform right click operation
    And Choose "View as ..." > "Heat map" 
    Then The "Table - Edit Heat map" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_50: Verify view as histogram for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Collapse the dataset and perform right click operation
    And Choose "View as ..." > "Histogram"  
    Then The "Table - Edit Histogram" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_51: Verify download for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset"
    And Get the name of series inside table 
    And Collapse the dataset and perform right click operation
    And Click on "Download" button in Comparables 
    Then The "Table - Download" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_54: Verify Copy selected links for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Select any checkbox for dataset
    And Get href of "First Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Get the name of series inside table
    And Collapse the dataset and perform right click operation
    And Select the "Copy selected links" option 
    And URL should be generated for selected series 
    And Copy the data after clicking Copy button
    Then Verify selected links are copied
    
@DatasetsTab
Scenario: TC_Data_set_55: Verify footnotes for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Collapse the dataset and perform right click operation
    And Select the "Footnotes" option
    Then The Footnotes window tab for Datasets should be opened
    
@DatasetsTab
Scenario: TC_Data_set_56: Verify Show Dataset for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Count the series inside "Selected Dataset" 
    And Get the name of series inside table
    And Collapse the dataset and perform right click operation
    And Select the "Show Dataset" option
    Then The "Show Dataset" option should present
    
@DatasetsTab
Scenario: TC_Data_set_57: Verify Back button in show dataset for right click on dataset
    And Right Click "Dataset" section from Comparables tab
    And Collapse the dataset and perform right click operation
    And Select the "Show Dataset" option
    Then The "Back button in Dataset" option should present
    
@DatasetsTab
Scenario: TC_Data_set_58: Verify creating chart for selected series on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Select 1 series inside table
    And Get the name of series
    And  Click on more actions to create "View as Chart"
    And Copy the insight title
    Then The "Selected Series Chart" should create for the series
    
@DatasetsTab
Scenario: TC_Data_set_59: Verify creating chart for unselected series on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to i icon without click
    And  Click on more actions to create "View as Chart"
    And Copy the insight title
    Then The "Unselected Series Chart" should create for the series
    
@DatasetsTab
Scenario: TC_Data_set_60: Verify creating chart for multiple series on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Select 2 series inside table
    And  Click on more actions to create "View as Chart"
    Then The "Multiple Series Chart" should create for the series
    
@DatasetsTab
Scenario: TC_Data_set_61: Verify opening footnotes for series on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Click on "Open footnote" option in series level of Dataset
    Then The Footnotes window tab should be opened
    
@DatasetsTab
Scenario: TC_Data_set_62: Verify more options for series on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Click on "More actions" option in series level of Dataset
    Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy" , "Copy data" , "Copy selected links" , "Add to Watchlist" , "Series Info" , "Footnotes" , "Show Dataset" options should available

@DatasetsTab12
Scenario: TC_Data_set_63: Verify series selection when click on more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset  
    And The series should get selected by default       
    Then The "Unselect all" , "View as Chart" , "View as Map" , "View as Table" , "View as ..." , "Download" , "Copy" , "Copy data" , "Copy selected links" , "Add to Watchlist" , "Series Info" , "Footnotes" , "Show Dataset" options should available
    
@DatasetsTab
Scenario: TC_Data_set_64: Verify adding series for series level on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Select 1 series inside table
    And Hovor on to the series name
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add series" from dropdown list
    Then Verify that the series is added successfully in right pane
    
@DatasetsTab
Scenario: TC_Data_set_65: Verify add and replace series for series level on dataset
    And Clicking "Datasets" tab from menu
    #And Search for "177610602"
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Click on more actions to create "View as Chart"
    And Copy the insight title
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add and replace series" from dropdown list
    Then Verify that the series is replaced successfully in right pane
    
@DatasetsTab
Scenario: TC_Data_set_66: Verify adding and grouping series for series level on dataset
    And Right Click "Dataset" section from Comparables tab	
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Select 1 series inside table
    And Hovor on to the series name
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add and group series" from dropdown list
    Then Verify that the series is added successfully in right pane with Group
    
@DatasetsTab
Scenario: TC_Data_set_67: Verify add into new insight for series level on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Select 3 series inside table
    And Hovor on to the series name
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add to new insight" from dropdown list
    And Series has been added to new insight message should display
    Then Clicking on go to insight name should open the new insight with the added series
    
@DatasetsTab
Scenario: TC_Data_set_68: Verify add into recent insight for series level on dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Select 3 series inside table
    And Hovor on to the series name
    And Clicking "add-to-data-selection--toggle" option from Series list
    And Clicking "Add to recent insight" from dropdown list
    Then Should be able to navigate to the existing insight
    
@DatasetsTab
Scenario: Tc_Data_set_69: Verify unselect all in more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Select 2 series inside table
    And Click on "More actions" option in series level of Dataset
    And Click on "Unselect all" button in Comparables
    Then Selected series should get deselected
   
@DatasetsTab
Scenario: Tc_Data_set_70: Verify view as chart in more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Click on "View as Chart" button in Comparables
    Then The "Edit Chart" option is displayed
   
@DatasetsTab
Scenario: Tc_Data_set_71: Verify view as Map in more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Click on "View as Map" button in Comparables
    Then The "Edit Map" option is displayed
   
@DatasetsTab
Scenario: Tc_Data_set_72: Verify view as Table in more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Click on "View as Table" button in Comparables
    Then The "Edit Table" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_73: Verify view as... in more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Click on "View as ..." button in Comparables
    Then The "Pie" , "Heat map" , "Histogram" options are present
   
@DatasetsTab
Scenario: Tc_Data_set_74: Verify view as Pie in more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Choose "View as ..." > "Pie" 
    Then The "Edit Pie" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_75: Verify view as Heatmap in more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Choose "View as ..." > "Heat map" 
    Then The "Edit Heat map" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_76: Verify view as Histogram in more options
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Choose "View as ..." > "Histogram"  
    Then The "Edit Histogram" option is displayed
   
@DatasetsTab
Scenario: Tc_Data_set_77: Verify download in more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Click on "Download" button in Comparables 
    Then The "Download" option is shown
   
@DatasetsTab
Scenario: Tc_Data_set_78: Verify copy data in more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Click on "Copy data" button in Comparables
    Then The "Copy data" option is shown
    
@DatasetsTab
Scenario: Tc_Data_set_79: Verify copy in more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Click on "Copy" button in Comparables
    And URL should be generated for selected series 
    And Copy the data after clicking Copy button
    Then The "Copy" option is shown
  
@DatasetsTab
Scenario: Tc_Data_set_80: Verify copy links in more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to series name without click
    And Click on "More actions" option in series level of Dataset
    And Select the "Copy selected links" option
    And URL should be generated for selected series 
    And Copy the data after clicking Copy button
    Then The "Copy selected links" option is shown
    
@DatasetsTab
Scenario: Tc_Data_set_81: Verify series info for more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to series name without click
    And Click on "More actions" option in series level of Dataset
    And Select the "Series Info" option
    Then The "Series Info" option is shown
 
@DatasetsTab
Scenario: Tc_Data_set_82: Verify footnotes for more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Select the "Footnotes" option
    Then The "Footnotes" option is shown
   
@DatasetsTab
Scenario: Tc_Data_set_83: Verify show dataset for more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    #And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Select the "Show Dataset" option
    Then The "Show Dataset" option is shown
 
@DatasetsTab
Scenario: Tc_Data_set_84: Verify back button in dataset of more option
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to i icon without click
    And Click on "More actions" option in series level of Dataset
    And Select the "Show Dataset" option
    Then The "Back Button in Dataset" option is shown
    
@DatasetsTab
Scenario: TC_Data_set_86: Verify dropdown for mouse hover options in series level
   And Clicking "Datasets" tab from menu
   And Verify "Expand" the datasets "Without" keyboard shortcuts
   And Select 1 series inside table
   And Hovor on to the series name
   And Clicking "add-to-data-selection--toggle" option in Dataset
   Then  "Add" , "Add and replace" , "Add and group" , "Add to new insight" , "Add to recent insight" Options should present
    
@DatasetsTab
Scenario: Tc_Data_set_96: Verify unselect all for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Click on "Unselect all" button in Comparables
    Then Selected series should get deselected
    
@DatasetsTab
Scenario: Tc_Data_set_97: Verify unselect all for multiple series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 3 series
    And Click on "Unselect all" button in Comparables
    Then Selected series should get deselected
    
@DatasetsTab
Scenario: Tc_Data_set_98: Verify view as chart for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Click on "View as Chart" button in Comparables
    Then The "Edit Chart" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_99: Verify view as Map for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Click on "View as Map" button in Comparables
    Then The "Edit Map" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_100: Verify view as Table for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Click on "View as Table" button in Comparables
    Then The "Edit Table" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_101: Verify view as... for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Click on "View as ..." button in Comparables
    Then The "Pie" , "Heat map" , "Histogram" options are present
   
@DatasetsTab
Scenario: Tc_Data_set_102: Verify view as Pie for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Choose "View as ..." > "Pie" 
    Then The "Edit Pie" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_103: Verify view as Heatmap for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Choose "View as ..." > "Heat map" 
    Then The "Edit Heat map" option is displayed
    
@DatasetsTab
Scenario: Tc_Data_set_104: Verify view as Histogram for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Choose "View as ..." > "Histogram"  
    Then The "Edit Histogram" option is displayed
   
@DatasetsTab
Scenario: Tc_Data_set_105: Verify download for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Click on "Download" button in Comparables 
    Then The "Download" option is shown
  
@DatasetsTab
Scenario: Tc_Data_set_106: Verify copy data for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 1 series
    And Click on "Copy data" button in Comparables
    Then The "Copy data" option is shown
   
@DatasetsTab
Scenario: Tc_Data_set_107: Verify copy for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Hovor on to i icon without click
    And Right Click 1 series
    And Click on "Copy" button in Comparables
    And URL should be generated for selected series 
    And Copy the data after clicking Copy button
    Then The "Copy" option is shown
   
@DatasetsTab
Scenario: Tc_Data_set_108: Verify copy links for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Hovor on to series name without click
    And Right Click 1 series
    And Select the "Copy selected links" option
    And URL should be generated for selected series 
    And Copy the data after clicking Copy button
    Then The "Copy selected links" option is shown
    
@DatasetsTab
Scenario: Tc_Data_set_109: Verify copy links for series level right click for multiple series
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts 
    And Right Click 5 series
    And Select the "Copy selected links" option
    And URL should be generated for selected series 
    Then Paste in the clipboard and take url one by one
    
@DatasetsTab
Scenario: Tc_Data_set_110: Verify series info for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to i icon without click
    And Right Click 1 series
    And Select the "Series Info" option
    Then The "Series Info" option is shown
  
@DatasetsTab
Scenario: Tc_Data_set_111: Verify footnotes for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to i icon without click
    And Right Click 1 series
    And Select the "Footnotes" option
    Then The "Footnotes" option is shown
   
@DatasetsTab
Scenario: Tc_Data_set_112: Verify show dataset for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to i icon without click
    And Right Click 1 series
    And Select the "Show Dataset" option
    Then The "Show Dataset" option is shown
   
@DatasetsTab
Scenario: Tc_Data_set_113: Verify back button for series level right click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on to i icon without click
    And Right Click 1 series
    And Select the "Show Dataset" option
    Then The "Back Button in Dataset" option is shown
    
@DatasetsTab
Scenario: Tc_Data_set_114: Verify unselect for series in dataset
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Right Click 4 series
    And Select the "Show Dataset" option
    Then The series in dataset getting unselected
   
@DatasetsTab
Scenario: Tc_Data_set_115: Verify top button when Datasets tab is scrolled down
    And Right Click "Top button" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Search for the series to scroll down 
    Then The "Top button" option is shown
   
@DatasetsTab
Scenario: Tc_Data_set_116: Verify dropdown open for series dataset tab
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    Then The "Updated on" option in series should present
    Then The "Read More" option in series should present
    Then The "Datasets" option in series should present
    Then The "Insights" option in dataset should present
    Then The "related-series-data--status" option in series should be present
    Then The "related-series-data--remarks" option in series should be present  
    And Click "Hide related data" option in series
    
@DatasetsTab
Scenario: Tc_Data_set_117: Verify Read more for series in datasets
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Read More" option for series should present
    Then The Footnotes window for Dataset should be open
    
@DatasetsTab
Scenario: Tc_Data_set_118: Verify related dataset for series opened in dropdown click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    Then The related dataset option should present
    
@DatasetsTab
Scenario: Tc_Data_set_120: Verify dataset for series opened in dropdown click
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And Click on "database" for related series
    Then The related "Database" for the series should shown
    
@DatasetsTab
Scenario: Tc_Data_set_121: Verify navigating to topic for related series in series level
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And Click on "topic" for related series
    Then The related "Topic" for the series should shown
    
@DatasetsTab
Scenario: Tc_Data_Set_122: Verify navigating to section for related series in series level
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And Click on "section" for related series
    Then The related "Section" for the series should shown
    
@DatasetsTab
Scenario: Tc_Data_Set_123: Verify presence of related insights in series level
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Insights" option in dataset should present
    Then The tooltip as "Name" and "Number of series" should present
    
@DatasetsTab
Scenario: Tc_Data_Set_124: Verify click on related insight name for series dataset tab
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Insights" option in dataset should present
    And Check the data of first insight
    
@DatasetsTab
Scenario: Tc_Data_Set_125: Verify creator of related insight present in series level
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Insights" option in dataset should present
    Then The creator tooltip should present
    
@DatasetsTab
Scenario: Tc_Data_Set_126: Verify time period of related insight present in series level
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Insights" option in dataset should present
    Then The Modified time tooltip should present
    
@DatasetsTab
Scenario: Tc_Data_set_127: Verify favoriting related insight
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Insights" option in dataset should present
    And The "First" Insight should present
    And Clicking favorite icon of related insight
    And Click on "My insights" option in insights page
    Then The Related insights should be added to favourite list in insight explorer window of favorite tab
    
@DatasetsTab
Scenario: Tc_Data_set_128: Verify sharing of related insight
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Insights" option in dataset should present
    Then The Sharing insight window should be opened
    
@DatasetsTab
Scenario: Tc_Data_set_129: Verify sharing of non sharing related insight
    And Clicking "Datasets" tab from menu
    And Search for "249416501"
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    And Click "Show related data" option in series 
    And The "Insights" option in dataset should present
    And The "Non shareable Insight" Insight should present
    Then The Share icon should not present for non sharing related insight 
    
#130 and 131    
@DatasetsTab
Scenario: Tc_Data_set_130: Verify maximizing and minimizing Datasets tab
    And Clicking "Datasets" tab from menu
    And Click "Expand search" option from top
    Then The Comparables tab is "Maximized" 
    And Click "Expand views" option from top
    Then The Comparables tab is "Minimized" 
    
@DatasetsTab
Scenario Outline: Tc_Data_set_132: Verify series tooltip for series
    And Clicking "Datasets" tab from menu
    And Search for "177610602"
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor only series name 
    Then The <index> should present on tooltip <name>
Examples:
   |        name         |  index   |
   |  "Region"           |     1    |
   |  "Name"             |     2    |
   |  "Unit"             |     3    |
   |  "Frequency"        |     4    |
   |  "First obs. date"  |     5    |
   |  "Last obs. date"   |     6    |
   |  "Observations"     |     7    |
   |  "Last value"       |     8    |
   |  "Last update time" |     9    |
   |  "Source"           |     10   |
   |  "Series id"        |     11   |
   |  "Mnemonic"         |     12   |
   |  "Classification"   |     13   |
   |  "Indicator"        |     14   |
   |  "More"             |     15   |
   
@DatasetsTab
Scenario Outline: Tc_Data_set_138: Hovor on to Add to Watchlist option for the series by right click
  And Right Click "Dataset" section from Comparables tab
  And Verify "Expand" the datasets "Without" keyboard shortcuts
  And Right Click 1 series
  And Hovoring "Add to Watchlist" option and get the text <watchlist_hovor>  
  Then The <watchlist_verify> watchlist tooltip should be displayed
  Examples:
     |     watchlist_hovor   |   |    watchlist_verify    |
     | "popup_notifications" |   | "Pop-up notifications" |
     | "email_notifications" |   | "Email notifications"  |
     
@DatasetsTab
Scenario Outline: Tc_Data_set_139: Hovor on to View as Add to Watchlist option for the series in more actions
  And Right Click "Dataset" section from Comparables tab
  And Verify "Expand" the datasets "Without" keyboard shortcuts
  And Click on "More actions" option in series level of Dataset
  And Hovoring "Add to Watchlist" option and get the text <watchlist_hovor>  
  Then The <watchlist_verify> watchlist tooltip should be displayed
  Examples:
     |     watchlist_hovor   |   |    watchlist_verify    |
     | "popup_notifications" |   | "Pop-up notifications" |
     | "email_notifications" |   | "Email notifications"  |
     
@DatasetsTab
Scenario Outline: Tc_Data_set_140: Verify showing tool tip for mouse hover options in series level
    And Right Click "Dataset" section from Comparables tab
    And Verify "Expand" the datasets "Without" keyboard shortcuts
    And Hovor on icon
    Then The <hovor_options> for series should present
    Examples:
    |  hovor_options  |
    | "Add to watchlist" |
    | "View as Chart. Type `c`" |
    | "Open footnote" |
    | "More actions"  |
     
@DatasetsTab
Scenario: Tc_Data_set_141: Verify Add to Watchlist icon in series level
  And Right Click "Dataset" section from Comparables tab
  And Verify "Expand" the datasets "Without" keyboard shortcuts
  And Click on "More actions" option in series level of Dataset
  And Click on "Add to watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Daily" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab
  
@DatasetsTab
Scenario: Tc_Data_set_142: Verify Add to Watchlist option in series level right click
  And Right Click "Dataset" section from Comparables tab
  And Verify "Expand" the datasets "Without" keyboard shortcuts
  And Right Click 1 series
  And Click on "Add to Watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Weekly" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab
  
@DatasetsTab
Scenario: Tc_Data_set_143: Verify Add to Watchlist option in series level more actions
  And Right Click "Dataset" section from Comparables tab
  And Verify "Expand" the datasets "Without" keyboard shortcuts
  And Click on "More actions" option in series level of Dataset
  And Click on "Add to Watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Monthly" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab
  
@DatasetsTab
Scenario: TC_Data_set_144: Verify Add to Watchlist option in series level more actions
  And Right Click "Dataset" section from Comparables tab
  And Verify "Expand" the datasets "Without" keyboard shortcuts
  And Click on "More actions" option in series level of Dataset
  And Click on "Add to Watchlist" option in series level
  And Select "popup_notifications" option from watchlist 
  And Select "email_notifications" option from watchlist
  And Select "Hourly" option from watchlist
  And User has clicked on "Apply" 
  And Growl message as "Watchlist changes applied" should display
  Then The selected actions should reflect inside watchlist tab