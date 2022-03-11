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
