Feature: Verifying map visual functionality

  @Map
  Scenario: TC_Map_01:Verify creating Map visual from Chart menu
    And Select some series
    And Right click on the series
    And Select "View as Map" > "World"
    Then Map visual should be created

  @Map
  Scenario: TC_Map_02:Verify creating Map visual by drag and drop
    And Select some series
    And Drag and drop the series to view
    Then Map visual should be created

  @Map
  Scenario: TC_Map_03:Verify creating Map visual from View panel by drag and drop
    And Click on View tab
    And Drag and drop Map visual to view
    Then Empty Map visual should be created

  @Map
  Scenario: TC_Map_04:Verify creating Map visual from View panel by clicking on Map icon
    And Click on View tab
    And Click on Map visual icon
    Then Empty Map visual should be created

  @Map
  Scenario: TC_Map_05:Verify Map visual creating with keyboard shortcuts
    And Select some series
    And Press "M" on KB
    Then Visual should be created with "Edit Map"

  @Map
  Scenario: TC_Map_06:Verify Map visual creating with keyboard shortcuts when added to Insight
    And Add some series to the Data tab
    And Select series and Press "M" on KB
    Then Visual should be created with "Edit Map"

  @Map
  Scenario: TC_Map_07:Verify Map visual creating with function applied series
    And Apply function for a series in my series tab
    And Select series and Create Map
    And Verify applied function in edit series panel
    Then The functions should be applied to the visual series

  @Map
  Scenario: TC_Map_08:Verify Series harmonization when visual is created with different frequencies
    And Select different frequency series "3671601;403770597" and click on "Map" icon
    Then "Series Harmonization" popup should be opened

  @Map
  Scenario: TC_Map_09: Series harmonization - Verify Frequency Dropdown
    And Select different frequency series "3671601;403770597" and click on "Map" icon
    Then The following frequencies should be available
      | Daily            |
      | Weekly           |
      | Highest in group |
      | Quarterly        |
      | Lowest in group  |
      | Yearly           |

  @Map
  Scenario: TC_Map_10:  Series harmonization - Verify Missing value method Dropdown
    And Select different frequency series "3671601;403770597" and click on "Map" icon
    Then The following missing values method should be available
      | Keep as reported                         |
      | Previous value                           |
      | Next value                               |
      | Specific value                           |
      | Calculate with linear interpolation      |
      | Calculate with linear extrapolate        |
      | Calculate with exponential interpolation |
      | Calculate with cubic spline              |

  @Map
  Scenario: TC_Map_11:  Series harmonization - Verify Currency conversion Dropdown
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    Then The following Currency conversion options should be available
      | Keep as reported   |
      | US Dollars         |
      | Chinese Yuan (RMB) |
      | Japanese Yen       |
      | UK Pounds          |
      | Euros              |
      | Malaysian Ringgit  |
      | Russian Ruble      |

  @Map
  Scenario: TC_Map_12: Verify options present in Currency multiples of conversion field dropdown
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    Then The following Currency multiples of conversion options should be available
      | as reported  |
      | in Thousands |
      | in Millions  |
      | in Billions  |

  @Map
  Scenario: TC_Map_13: Series harmonization - Verify Missing value method Dropdown = Specific value
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    And Select "Specific value" from Missing value method dropdown
    Then By default 1 value will be seen

  @Map
  Scenario: TC_Map_14: Series harmonization - Verify "keep different Frequencies"
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    And Select "Keep different frequencies"
    Then Visual should be created with "Edit Map"

  @Map
  Scenario: TC_Map_15: Series harmonization - Verify Apply button
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    And Select frequency as "Daily"
    Then Map visual should be created with "Daily" frequencies

  @Map
  Scenario: TC_Map_16: Series harmonization - Verify Minimize button
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    And Click on minus icon
    Then The Window should be minimized

  @Map
  Scenario: TC_Map_17: Series harmonization - Verify Full -screen button
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    Then Verify viewing "Full-screen" of frequency conversion popup

  @Map
  Scenario: TC_Map_18: Series harmonization - Verify Close button
    And Select different frequency series "226311002;16190501" and click on "Map" icon
    Then Verify viewing "Closing" of frequency conversion popup

  @Map
  Scenario: TC_Map_19: Empty visual - Verify 'Edit Map' button
    And Create a Map visual without selecting series
    Then The "Edit Map" button should be disabled

  @Map
  Scenario: TC_Map_20: Empty visual - Verify 'Edit series' option
    And Create a Map visual without selecting series
    Then The "Edit Series" button should be enabled
    And Click on Edit series option
    Then Edit series panel should be opened

  @Map
  Scenario: TC_Map_21: Empty visual - Verify default tab for 'Edit series' option
    And Create a Map visual without selecting series
    And Click on Edit series option
    Then By deault user should redirect to "Add from My Series" tab

  @Map
  Scenario: TC_Map_22:Empty visual - Verify description message for empty visual if have series in My series
    And Add some series to my series
    And Create a Map visual without selecting series
    Then The "Map" and "Drag series here Or, Add from My Series" should be displayed

  @Map
  Scenario: TC_Map_23: Empty visual - Verify description message for empty visual if have NO series in My series.
    And Create a Map visual without selecting series
    Then The "Map" and "Drag series here" should be displayed for empty visual

  @Map
  Scenario: TC_Map_24: Empty visual - Verify Map tab when no series added for visual
    And Create a Map visual without selecting series
    And Click on Edit series option
    And Choose "Map" tab
    Then The "There are no series for selected visual. Please add series from + Add from My Series." message should be displayed

  @Map
  Scenario: TC_Map_25:Empty visual - Verify "+ Add from My Series" option in edit series panel
    And Create a Map visual without selecting series
    And Click on Edit series option
    And Choose "Map" tab
    And Click on "+ Add from My Series"
    Then Should redirect to "+ Add from My Series" tab

  @Map
  Scenario: TC_Map_26:Empty visual - Verify description message for "+ Add from My Series" option in edit series panel if have NO series in My series
    And Create a Map visual without selecting series
    And Click on Edit series option
    And Choose "Map" tab
    And Click on "+ Add from My Series"
    Then The "No series added" and "Search Series" button should be displayed for empty visual

  @Map
  Scenario: TC_Map_27:Empty visual - Verify adding series to empty visual
    And Add series to the my series tab
    And Create a Map visual without selecting series
    And Click on Edit series option
    And Choose series from  "+ Add from My Series"
    Then The series should be added to "Map" with its data

  @Map
  Scenario: TC_Map_28:Empty visual - Verify Add from my series option
    And Add series to the my series tab
    And Create a Map visual without selecting series
    And Click on "Add from My Series"
    Then "Add from My Series" panel should be opened

  @Map
  Scenario: TC_Map_29:Verify click on visual title
    And Create a map visual with series
    And Click on the visual title
    Then The "Titles" popup should be appeared

  @Map
  Scenario: TC_Map_30:Verify clicking on edit visual icon for title
    And Create a map visual with series
    And Mouse hover on visual title
    And Click on edit icon
    Then The title popup should be appeared

  @Map
  Scenario: TC_Map_31:Verify clicking on edit visual icon for title
    And Create a map visual with series
    And Click on visual region
    Then SSP popup should be displayed

  @Map
  Scenario: TC_Map_32:Edit series - Verify Edit series option for Map visual
    And Create a map visual with series
    And Click on Edit series option
    Then Edit series panel should be opened with "Map" tab

  @Map
  Scenario: TC_Map_33:Edit series - Verify series under Map tab.
    And Create a map visual with series
    And Click on Edit series option
    Then Associated series should be available in edit series popup

  @Map
  Scenario: TC_Map_34:Verify Double Click on Visuals legends
    And Create a map visual with series
    And Click on visual legend
    Then "Legend" popup should be displayed

  @Map
  Scenario: TC_Map_35:Edit series - Verify Rename option.
    And Create a map visual with series
    And Click on Edit series option
    And Click on "Rename" option
    Then The "Rename" popup should be displayed

  @Map
  Scenario: TC_Map_36:Rename - Verify number of selected series.
    And Create a map visual with series
    And Click on Edit series option
    And Click on "Rename" option
    Then Number of selected series count should be shown on the rename popup header

  @Map
  Scenario: TC_Map_37:Rename - Verify number of selected series.
    And Create a map visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    Then The total number of matches result should be displayed in below the find field

  @Map
  Scenario: TC_Map_38:Rename - Verify find field.
    And Create a map visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    Then Result should be loaded for searched keyword

  @Map
  Scenario: TC_Map_39: Rename -  Verify number of searched result
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    Then The total number of matches result should be displayed in below the find field

  @Map
  Scenario: TC_Map_40: Rename - Verify 'Replace' button
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    And Enter keyword you want to replace with
    And Click on Replace
    Then The keyword should be replaced for selected series

  @Map
  Scenario: TC_Map_41: Rename - Verify 'Replace All' button
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Enter the keyword you want to rename
    And Enter the keyword you want to replace with
    And Click on "Replace All"
    Then All the available series should be replaced with the keyword

  @Map
  Scenario: TC_Map_42: Rename - Verify for invalid search
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search with invalid series name
    Then "No matches found" should be displayed under the find field

  @Map
  Scenario: TC_Map_43: Rename - Verify 'Edit series info' dropdown
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    Then Below options should be displayed
      | Name                 |
      | Function description |
      | Region               |
      | Unit                 |
      | Frequency            |

  @Map
  Scenario: TC_Map_44: Rename - Verify default selection for 'Edit series info' dropdown
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    Then By default "Name" should be selected in Edit series info dropdown

  @Map
  Scenario: TC_Map_45: Rename - Verify 'Name' selection
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    Then Series should be displayed by name

  @Map
  Scenario: TC_Map_46: Rename - Verify 'Function description' selection
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "View as Map" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    Then The series should be displayed by function description

  @Map
  Scenario: TC_Map_47:Rename - verify function description selection without function apply
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    Then Empty row should be dispalyed

  @Map
  Scenario: TC_Map_48:Rename - Verify editing function description
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "View as Map" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Edit function description
    And Click on "Apply"
    Then Should allowed to edit function discription and should be updated in edit series panel

  @Map
  Scenario: TC_Map_49:Rename - Verify adding function description
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "View as Map" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on "Apply"
    Then Should allowed to add function discription and should be updated in edit series panel

  @Map
  Scenario: TC_Map_50:Rename - Function discription -Verify Apply original title icon behavior
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "View as Map" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on '>' icon
    Then The changes should be revert to original series "function"

  @Map
  Scenario: TC_Map_51:Rename - Function discription - Verify'Apply original title for all series' icon
    And Add series to the my series tab and Apply function
    And Right click on series
    And Select "View as Map" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "function"

  @Map
  Scenario: TC_Map_52:Rename - Function discription - Verify clicking on series name
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "View as Map" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Click on series name
    Then The SSP window should be displayed

  @Map
  Scenario: TC_Map_53:Rename - Name - verify Editing series name
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on "Apply"
    Then Should able to edit the insight title and updated in visual series

  @Map
  Scenario: TC_Map_54:Rename - Name - Verify Apply original title icon
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on '>' icon
    Then The changes should be revert to original series "name"

  @Map
  Scenario: TC_Map_55:Rename - Name - Verify "Apply original title for all series" icon
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "name"

  @Map
  Scenario: TC_Map_56:Rename - Verify Region selection
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    Then Series should be displayed by Region

  @Map
  Scenario: TC_Map_57:Rename - Rename region
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    Then The region should be renamed for the series

  @Map
  Scenario: TC_Map_58:Rename - Region - Verify Apply original region icon
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    And Click on '>' icon
    Then The changes should be revert to original series "region"

  @Map
  Scenario: TC_Map_59:Rename - Region - Verify "Apply original region for all series" icon
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "region"

  @Map
  Scenario: TC_Map_60:Rename - unit - verify Editing series unit
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on "Apply"
    Then Should able to edit series unit and updated in visual series as per the changes

  @Map
  Scenario: TC_Map_61:Rename - unit - Verify Apply original unit icon
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on '>' icon
    Then The changes should be revert to original series "unit"

  @Map
  Scenario: TC_Map_62:Rename - unit - Verify "Apply original unit for all series" icon
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "unit"

  @Map
  Scenario: TC_Map_63:Rename - frequency - verify Editing series frequency
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on "Apply"
    Then Should able to edit series frequency and updated in visual series as per the changes

  @Map
  Scenario: TC_Map_64:Rename - frequency - Verify Apply original frequency icon
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on '>' icon
    Then The changes should be revert to original series "frequency"

  @Map
  Scenario: TC_Map_65:Rename - frequency - Verify "Apply original frequency for all series" icon
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "frequency"

  @Map
  Scenario: TC_Map_66:Rename - Verify Auto name check box
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    Then Check box should be checked by default for auto name

  @Map
  Scenario: TC_Map_67:Rename - verify attributes dropdown
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Open dropdown for auto name
    Then Below options should be available
      | Name                 |
      | Function description |
      | Region               |
      | Unit                 |
      | Frequency            |

  @Map
  Scenario: TC_Map_68:Rename - verify selecting multiple attributes for series name
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Select multiple attributes
    And Click on "Apply"
    Then Selected attributes should be displayed as series name

  @Map
  Scenario: TC_Map_69:Rename - Veriy series in My series after visual series renamed
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    Then The changes should be applied to only visual and its series in edit series panel NOT for my series

  @Map
  Scenario: TC_Map_70:Rename - Verify 'Apply' button
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on "Apply"
    Then The changes should be saved and rename popup remains displayed
