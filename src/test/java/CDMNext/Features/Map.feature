Feature: Verifying map visual functionality

  #.......................Created by Teju.............#
  @CMap
  Scenario: Creation of map
    And selectSeries "10"
    Then keyBoardmap

  @CMap
  Scenario: Creation a china map
    And click_On_Dropdown "All Regions"
    And select_subnational_as_region "China"
    And select_Subregion "Beijing,Gansu,Guangxi"
    And selectSeries "100"
    And view_As_map "View on China Map"
    And click_on_EditMap
    And selectColor "#FFD620" "#54B582"
    And checkForTitleBorderBackground "Border"
    And borderDropDown "Map"
    And widthSelectionOfMap 5
    And radiusOfMap 10
    And styleOfMap "Dotted"
    And sizeSelection 45,"Right"
    And dateFormat "Custom","MM/D/YY"
    And numberFormat 5,".","Space"
    And markerType "Filled"
    And legend "Vertical","Bottom"
    And copyRight "Horizontal","Left"
    And dataLabels "Value"
    And highLightFilter "#000000","1000"
    And colorDivision "Gradient",4,5,"#ddcf34"
    Then Save

  @CMap
  Scenario: Creation a India map
    And click_On_Dropdown "All Regions"
    And select_subnational_as_region "India"
    And select_Subregion " Bihar,Gujarat,Karnataka"
    And selectSeries "100"
    And view_As_map "View on India Map"
    And click_on_EditMap
    And selectColor "#FFD620" "#54B582"
    And checkForTitleBorderBackground "Border"
    And borderDropDown "Visual"
    And colorSelectionOfMap "#000000"
    And sizeSelection 45,"Right"
    And show "Zoom"
    And dateFormat "Custom","M/D/YY"
    And numberFormat 4,",","-"
    And markerType "Bubble"
    And legend "Vertical","Top"
    And copyRight "Horizontal","Right"
    And dataLabels "Region,Value"
    And highLightFilter "#000000","500"
    And colorDivision "Solid color",4,5,"#3425af"
    And titleSettings "sub_title","Highlight","#3425af",28,"underline","left"
    And backGroundSettings "Visual background","visual",20,"",0,0,"",0,""
    And legendSettings "Border","",0,"","","",0,"#000000","Dotted",6,17,"",0
    And copyrightSettings "Text","","","facebbok.com","left","ceic data","#54b582",30,"italic"
    And dataLabelsSettings "Labels","Region,Value","Color,Outline","#3425af,#3425af",35,"italic"
    And colorAxes "Color axes","",0,"","","",0,"#34224a","Dotted",6,17,"Solid color",4
    Then Save

  @CMap
  Scenario: Creation a Russian Federation map
    And click_On_Dropdown "All Regions"
    And select_subnational_as_region "Russian Federation"
    And select_Subregion_federal "Bryansk Region,Tula Region,Moscow Region"
    And selectSeries "100"
    And view_As_map "View on Russian Federation Map"

  #.............................End ........................#
  @Map
  Scenario: TC_Map_01:Verify creating Map visual from Chart menu
    And Select some series
    And Right click on the series
    And Select "Add chart" and create a map visual
    Then Map visual should be created

  @Map
  Scenario: TC_Map_02:Verify creating Map visual by drag and drop
    And Select some series
    And Drag and drop the series to view
    Then Map visual should be created

  #@Map
  #Scenario: TC_Map_03:Verify creating Map visual from View panel by drag and drop
  #And Click on View tab
  #And Drag and drop Map visual to view
  #Then Empty Map visual should be created
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
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    Then The total number of matches result should be displayed in below the find field

  @Map
  Scenario: TC_Map_38:Rename - Verify find field.
    And Create a map visual with series id's "408940397;408929327"
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
    And Select "Add chart" and create a map visual
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
    And Select "Add chart" and create a map visual
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
    And Select "Add chart" and create a map visual
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
    And Select "Add chart" and create a map visual
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
    And Select "Add chart" and create a map visual
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
    And Select "Add chart" and create a map visual
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
    And Click on "OK"
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

  @Map
  Scenario: TC_Map_71:Rename - Minimize option
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Minimize" option
    Then The Popup should be minimized

  @Map
  Scenario: TC_Map_72:Rename - Verify maximiz option
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The popup should be maximized

  @Map
  Scenario: TC_Map_73:Rename - verify full screen
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Full-screen" option
    Then The popup should be displayed in full screen

  @Map
  Scenario: TC_Map_74:Rename - verify exit full screen
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The popup should be displayed in normal screen

  @Map
  Scenario: TC_Map_75:Rename - Verify Cancel/x icon
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Cancel button
    Then The rename popup should be closed

  @Map
  Scenario: TC_Map_76:Rename - Verify opening rename popup by keyboard shortcut
    And Create a map visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Press Ctrl+H on keyboard
    Then Rename popup should be displayed

  @Map
  Scenario: TC_Map_77:Edit series - Verify applying 'Currency conversation' function
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Choose any function from Currency conversation
    Then Selected currency should be applied to all series

  @Map
  Scenario: TC_Map_78:Edit series - Verify applying 'Calculate change' function
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Choose any function from Calculate change
    Then Selected function should be applied to all series

  @Map
  Scenario: TC_Map_79:Edit series - Verify 'Aggregate' function apply
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on Aggregate and choose any option
    Then Selected function should be applied to all series

  @Map
  Scenario: TC_Map_80:Edit series - Verify 'Accumulate' function apply
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on Accumulate and choose any option
    Then Selected function should be applied to all series

  @Map
  Scenario: TC_Map_81:Edit series - Verify 'FX more' drop down
    And Create a map visual with series id's "239796903"
    And Click on Edit series option
    And Click on FX More dropdown and Choose any function
    Then Selected function should display in series

  @Map
  Scenario: TC_Map_82:Edit series - Verify FX icon.
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on FX icon
    Then The "Apply functions to visual series" popup should be opened

  @Map
  Scenario: TC_Map_83:Edit series - Verify applying function by clicking on function icon
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on FX icon
    And Click on type a function field
    And Select any function
    And Click on "Apply"
    Then The selected function should be displayed

  #@Map
  #Scenario: TC_Map_84:Edit series - Verify hiding function toolbar
  #And Create a map visual with series id's "408940397"
  #And Click on Edit series option
  #And Click on "Hide the function bar"
  #Then The function toolbar should be hidden
  #
  #@Map
  #Scenario: TC_Map_85:Edit series - Verify showing the function toolbar
  #And Create a map visual with series id's "408940397"
  #And Click on Edit series option
  #And Click on "Hide the function bar"
  #And Click on "Show the function bar"
  #Then The function toolbar should be shown
  @Map
  Scenario: TC_Map_86:Edit series - Verify 'Type a function' field
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on type a function field
    And Select any function
    And Click on "Apply"
    Then The selected function should be displayed

  @Map
  Scenario: TC_Map_87:Edit series - Verify delete series icon
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on x icon for a series
    Then The series should be removed from the visual and edit series panel

  @Map
  Scenario: TC_Map_88:Edit series - Verify delete all series icon
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on x icon before Name attribute
    Then All series should be removed from the visual and edit series panel

  @Map
  Scenario: TC_Map_89:Edit series - Verify SSP by clicking on series name
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on series name
    Then SSP popup should be displayed

  @Map
  Scenario: TC_Map_90:Edit series - Verify Rename series icon
    And Create a map visual with series id's "408940397"
    And Click on Edit series option
    And Click on rename series icon
    Then Rename popup should be displayed for selected series

  @Map
  Scenario: TC_Map_91:Edit series - Verify edit series icon
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on edit series icon
    Then Below options should be available
      | Rename    |
      | Frequency |
      | Currency  |
      | Change    |

  @Map
  Scenario: TC_Map_92:Edit series - Verify Rename option under edit series
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Rename"
    Then Rename popup should be displayed for selected series

  @Map
  Scenario: TC_Map_93:Edit Histogram - Edit series - Verify Currency option under edit series
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Currency"
    Then Selected currency function should be applied to the series

  @Map
  Scenario: TC_Map_94:Edit series - Verify Change option under edit series
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Change"
    Then Selected change function should be applied to the series

  @Map
  Scenario: TC_Map_95:Edit series - Verify Frequency option under edit series.
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Frequency"
    Then Selected function should be applied to the series

  @Map
  Scenario: TC_Map_96:Edit series - Verify clicking on frequency or dropdown
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on frequency
    Then "Series Harmonization" popup should be opened

  @Map
  Scenario: TC_Map_97:Edit series - Series data conversion - Verify applying frequency.
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on frequency
    And Select frequency as "Daily"
    Then The selected "Daily" frequency should be applied to available series

  @Map
  Scenario: TC_Map_98:Edit series - Series data conversion - Verify applying Missing values method.
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on frequency
    And Select "Frequency" as "Daily" from dropdown
    And Select "Missing values method" as "Next value" from dropdown
    Then Missing values method should be applied with selected frequency

  @Map
  Scenario: TC_Map_99:Edit series - Series data conversion -Verify maximize option
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on frequency
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The Series Hormonization popup should be maximized

  @Map
  Scenario: TC_Map_100:Edit series - Series data conversion -verify exit full screen
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on frequency
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The Series Hormonization popup should be displayed in normal screen

  @Map
  Scenario: TC_Map_101:Edit series - Verify applying frequency in series level
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on frequency dropdown in series level
    And Select "Yearly (Sum)" from frequency dropdown
    Then Selected frequency should be applied to ONLY selected series

  @Map
  Scenario: TC_Map_102:Edit series - Verify applying currency in series level
    And Create a map visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on currency dropdown in series level
    And Select "RMB" from currency dropdown
    Then Selected currency should be applied to ONLY selected series

  @Map
  Scenario: TC_Map_103:Edit series - Verify applying function in series level
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    Then Selected function should applied to the series

  @Map
  Scenario: TC_Map_104:Edit series - Verify multiple functions apply
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select multiple functions "ACCUMULATE"  and "LOG"
    And Click on "Apply function"
    Then The Selected functions should applied to the series

  @Map
  Scenario: TC_Map_105:Edit series -  Verify cancel icon for selected function
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on type a function field in series level
    And Select a function
    And Click on cancel function icon
    Then The selected function should be cancelled

  @Map
  Scenario: TC_Map_106:Edit series - Verify search for functions
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on type a function field in series level
    And Search with function "YTD"
    Then Searched functions should be displayed

  @Map
  Scenario: TC_Map_107:Edit series - Verify removing applied functions
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    And Click on x icon to remove the function
    Then The function should be removed from the series

  @Map
  Scenario: TC_Map_108:Edit series - Verify applied funtion in function toolbar
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    Then The applied function should be displayed on the toolbar

  @Map
  Scenario: TC_Map_109:Edit series - Verify applying invalid function for series
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select an invalid function for the series
    Then "The function cannot be applied to selected series" popup should be displayed

  @Map
  Scenario: TC_Map_110:Edit seires - Verify OK button on "The function cannot be applied to selected series" popup
    And Create a map visual with series id's "369703417"
    And Click on Edit series option
    And Click on type a function field in series level
    And Select an invalid function
    And Click on "Apply function"
    And Click on "Ok"
    Then The function cannot be applied to selected series popup should be closed

  @Map
  Scenario: TC_Map_111:Edit series - Verify Region, Unit and Series ID fields
    And Create a map visual with series id's "16240301;16243001"
    And Click on Edit series option
    Then "Region", "Unit" and "Series id" fields should be available for respective series

  @Map
  Scenario: TC_Map_112:Edit series - Verify "+Add from my series" option
    And Create a map visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on "+ Add more from My Series" option
    Then User should redirect to "+Add from My Series" tab

  @Map
  Scenario: TC_Map_113:Edit series - Verify adding series from my series
    And Add series to the my series tab
    And Create a empty Map visual
    And Click on Edit series option
    And Redirect to MySeries tab > Select a series in edit series panel
    Then The selected series should be displayed in Map tab

  @Map
  Scenario: TC_Map_114:Edit series - Verify max series for Map visual
    And Select more than 300 series and try to create Map visual
    Then Map should allow max 300 series

  @Map
  Scenario: TC_Map_115:Edit series - Verify message for selecting more than 300 series
    And Select more than 300 series and try to create Map visual
    Then "You cannot create a map with more than 300 series. Proceed with 300 series?" growl message should be displayed

  @Map
  Scenario: TC_Map_116:Edit series - Verify default sort by in add from my series tab
    And Create a map visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on "Add from My Series"
    Then By default checked sort by should be applied

  @Map
  Scenario: TC_Map_117:Edit seires - Verify Edit series option on visual if edit series panle is opened.
    And Create a map visual with series id's "16240301;16243001"
    And Click on Edit series option
    Then The "Edit Series" option should be disabled if already opened

  @Map
  Scenario: TC_Map_118:Edit series - Verify edit series panel close
    And Create a map visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on x icon to close the edit seires panel
    Then The edit series panel should be closed

  @Map
  Scenario: TC_Map_119:Verify Edit Map for the visual created
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    Then The "Edit visual" popup should be displayed

  @Map
  Scenario: TC_Map_120:Edit Pie - Verify template creating
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Make any changes in edit visual
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    Then New template should be created with the name of "Shravas"

  @Map
  Scenario: TC_Map_121:Edit Map -  Verify auto naming for template.
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Make any changes in edit visual
    And Click on create template icon
    And Click on green tick mark
    Then Auto name should be available as "My template 1"

  @Map
  Scenario: TC_Map_122:Edit Map - Verify Cancel icon for template popup
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Make any changes in edit visual
    And Click on create template icon
    And Click on x icon in the template popup
    Then The template popup should closed

  @Map
  Scenario: TC_Map_123:Edit Map - Verify dropdown for template
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Make any changes in edit visual
    And Click on create template icon
    And Click on green tick mark
    And Click on dropdown for template
    Then The following templates should be available
      | CEIC Styles |
      | My Styles   |

  @Map
  Scenario: TC_Map_124:Edit Map - Verify 'Set as default for future Map visual' is checked
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Mouse move on existing visual templates
    And Click on template dropdown
    And Check the box for "Set as default for future Map visual"
    And Click on "Save"
    And Create a new map visual
    Then The Map should be created with the format of previous template selection

  @Map
  Scenario: TC_Map_125:Edit Map - Verify 'Set as default for future Map visual' is Unchecked
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Mouse move on existing visual templates
    And Click on template dropdown
    And Check the box for "Set as default for future Map visual" should be unchecked
    And Click on "Save"
    And Create a new map visual
    Then The map should be created with default format template

  @Map
  Scenario: TC_Map_126:Edit Map - Verify delete template icon
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    Then "Confirmation" popup should be diaplayed

  @Map
  Scenario: TC_Map_127:Edit Map - Verify description for confirmation popup
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    Then The description should be "Are you sure you want to delete this style template?" diaplayed

  @Map
  Scenario: TC_Map_128:Edit Map - Verify OK button on confirmation popup
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    And Click on "Ok"
    Then The template should be deleted from the list

  @Map
  Scenario: TC_Map_129:Edit Map - Verify cancel/x icon on confirmation popup
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    And Click on "Cancel"
    Then The confirmation popup should be closed

  @Map
  Scenario: TC_Map_130:Edit Map - Title - Verify Title=Yes
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Title drop down
    And Check Title and Save
    Then The title of the visual should be displayed

  @Map
  Scenario: TC_Map_131:Edit Map - Title - Verify Title=No
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Title drop down
    And UnCheck Title and Save
    Then The title of the visual should be removed from the visual

  @Map
  Scenario: TC_Map_132:Edit MAp -  Title - Verify default selection for title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Title drop down
    Then The title should be selected by default

  @Map
  Scenario: TC_Map_133:Edit Map -  Title - Verify Auto title
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on Title drop down
    And Check title with empty title field and Save
    Then Auto title should be displayed as series name

  @Map
  Scenario: TC_Map_134:Edit Map - Title - Verify renaming title
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on Title drop down
    And Enter visual name and Save
    Then The visual name should be changed

  @Map
  Scenario: TC_Map_135:Edit Map - Title - Verify sub title by default
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on Title drop down
    Then The sub title check box should be unchecked by default

  @Map
  Scenario: TC_Map_136:Edit Map - Title - Verify sub title=Check
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on Title drop down
    And Check Subtitle and Save
    Then Sub title should be displayed for the visual

  @Map
  Scenario: TC_Map_137:Edit Map -  Title - Verify sub title=Uncheck
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on Title drop down
    And UnCheck Subtitle and Save
    Then Sub title should not be displayed for the visual

  @Map
  Scenario: TC_Map_138:Edit Map - Title - Verify default title for sub title
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on Title drop down
    And Check Subtitle and Save
    Then Default sub title should be "Sub title"

  @Map
  Scenario: TC_Map_139:Edit Map - Title - Verify advance settings
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on Title drop down
    And Click on "Advanced settings"
    Then Titles popup should be displayed

  @Map
  Scenario: TC_Map_140:Edit Map - Verify advance settings cogwheel icon
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    Then Titles popup should be displayed

  @Map
  Scenario: TC_Map_141:Edit Map - Title - Verify color for visual title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select color for "Title"
    When Click on "Save"
    Then Visual "title" should be displayed in selected color

  @Map
  Scenario: TC_Map_142:Edit Map - Title - Verify color for visual title background
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select color for "title" background highlight
    When Click on "Save"
    Then Visual "title" background should be displayed in selected color

  @Map
  Scenario: TC_Map_143:Edit Map - Title - Verify font size for visual title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select size for visual "title" as "20"
    When Click on "Save"
    Then The "title" font size should be changed as "20"

  @Map
  Scenario: TC_Map_144:Edit Map - Title - Verify bold style for visual title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Bold icon for "title"
    When Click on "Save"
    Then The "title" should be displayed in Bold format

  @Map
  Scenario: TC_Map_145:Edit Map - Title - Verify bold style default selection
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    Then The bold icon should be selected by default

  @Map
  Scenario: TC_Map_146:Edit Map - Title - Verify Italic style for visual title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Italic under style
    When Click on "Save"
    Then The "title" should be "italic"

  @Map
  Scenario: TC_Map_147:Edit Map - Title - Verify Underline style for visual title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Underline icon for "title"
    When Click on "Save"
    Then The "title" should be "underline"

  @Map
  Scenario: TC_Map_148:Edit Map - Title - Verify horizontal alignment (left, right, center)
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select alignment of title to "left"
    Then The title should align to "left"
    And Select alignment of title to "center"
    Then The title should align to "center"
    And Select alignment of title to "right"
    Then The title should align to "right"

  @Map
  Scenario: TC_Map_149:Edit Map - Title - Verify color for visual sub title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select color for "Sub title"
    When Click on "Save"
    Then Visual "sub_title" should be displayed in selected color

  @Map
  Scenario: TC_Map_150:Edit Map - Verify color for visual sub title background
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select color for "Sub title" background highlight
    When Click on "Save"
    Then Visual "sub_title" background should be displayed in selected color

  @Map
  Scenario: TC_Map_151:Edit Map - Title - Verify font size for visual sub title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Select size for visual "Sub title" as "20"
    When Click on "Save"
    Then The "sub_title" font size should be changed as "20"

  @Map
  Scenario: TC_Map_152:Edit Map - Title - Verify bold style for visual sub title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Click on B under style for sub-title
    When Click on "Save"
    Then The "sub_title" should be displayed in Bold format

  @Map
  Scenario: TC_Map_153:Edit Map - Title - Verify Italic style for visual sub title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Click on Italic under style for sub-title
    When Click on "Save"
    Then The "sub_title" should be "italic"

  @Map
  Scenario: TC_Map_154:Edit Map - Verify Underline style for visual sub title.
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Click on Underline icon for sub-title
    When Click on "Save"
    Then The "sub_title" should be "underline"

  @Map
  Scenario: TC_Map_155:Edit Map - Title - Verify horizontal alignment (left, right, center)
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select alignment of sub title to "left"
    Then The subtitle should align to "left"
    And Select alignment of sub title to "center"
    Then The subtitle should align to "center"
    And Select alignment of sub title to "right"
    Then The subtitle should align to "right"

  @Map
  Scenario: TC_Map_156:Edit Map - Title - Verify expanding and collapsing the title and subtitle sections
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Expand the Title section
    Then The section should be expnaded
    And Collapse the Title section
    Then The section should be collapsed
    And Expand the Sub-title section
    Then The Sub-title section should be expnaded
    And Collapse the Sub-title section
    Then The Sub-title section should be collapsed

  @Map
  Scenario: TC_Map_157:Edit Map - Title - Verify closing of Titles popup
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on cogwheel icon for title
    And Click on X icon to close the popup
    Then The "Title" popup should be closed

  @Map
  Scenario: TC_Map_158:Edit Map - Border - Verify Map color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Check Map for "Border"
    And Select color
    Then Border should be displayed for "map visual" with selected color

  @Map
  Scenario: TC_Map_159:Edit Map - Border - Verify map width
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Check Map for "Border"
    And Select Width to 5
    Then The map border "Width" should be updated to "5"

  @Map
  Scenario: TC_Map_160:Edit Map - Border - Verify map Radius
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Check Map for "Border"
    And Select Radius as 10
    Then Radius should be updated to 10 on map

  @Map
  Scenario: TC_Map_161:Edit Map - Border - Verify visual color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Check Visual check box
    And Select color for Visual
    Then Border should be displayed for visual with selected color

  @Map
  Scenario: TC_Map_162:Edit Map - Border - Verify visual width
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Check Visual check box
    And Select Width to 5
    Then The visual border "Width" should be updated to "5"

  @Map
  Scenario: TC_Map_163:Edit Map - Border - Verify visual Radius
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Check Visual check box
    And Select Radius to 10
    Then The visual border "Radius" should be updated to "10"

  @Map
  Scenario: TC_Map_164:Edit Map - Border - Verify visual style
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Check Visual check box
    And Select below Styles for visual border
      | Solid  |
      | Dashed |
      | Dotted |
    Then The selected border should be applied to the visual

  @Map
  Scenario: TC_Map_165:Edit Map - Border - Verify advance settings
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Click on "Advanced settings"
    Then Visual popup should be opened

  @Map
  Scenario: TC_Map_166:Edit Map - Border - Verify advance settings cogwheel
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Border drop down
    And Click on "Open advanced settings popup"
    Then Visual popup should be opened

  @Map
  Scenario: TC_Map_167:Edit Map - Verify Background=NO
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Uncheck "Map" and Visual
    Then Background should not be seen for "map" and visual

  @Map
  Scenario: TC_Map_168:Edit Map - Verify Background=YES
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Check "Map" and Visual
    Then Background should be displayed for "map" and visual

  @Map
  Scenario: TC_Map_169:Edit Map - Background - Verify map color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Check Map for "Background"
    And Select background color
    Then Background should be displayed for "map" with selected color

  @Map
  Scenario: TC_Map_170:Edit Map - Background - Verify map background image
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Check Map for "Background"
    And click on Browse > upload image
    Then Uploaded image should be displayed in "map" background

  @Map
  Scenario: TC_Map_171:Edit Map - Background - Verify message for map background image when selcetd more than maximum size
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Check Map for "Background"
    And Select image more than 1 MB
    Then "The selected file is too large. The maximum size of file is: 1.00 Mb" growl message is displayed and auto closed

  @Map
  Scenario: TC_Map_172:Edit Map - Background - Verify visual color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Check Visual check box
    And Select color for Visual
    Then Background should be displayed for visual with selected color

  @Map
  Scenario: TC_Map_173:Edit Map - Background - Verify image upload for visual
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Check Visual check box
    And click on Browse > upload image
    Then Uploaded image should be displayed in visual background

  @Map
  Scenario: TC_Map_174:Edit Map - Background - Verify message for visual background image when selcetd more than maximum size
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Check Visual check box
    And Select image more than 1 MB
    Then "The selected file is too large. The maximum size of file is: 1.00 Mb" growl message is displayed and auto closed

  @Map
  Scenario: TC_Map_175:Edit Map - Background - Verify advance settings
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Click on "Advanced settings"
    Then Visual popup should be opened

  @Map
  Scenario: TC_Map_176:Edit Map - Background - Verify advance settings cogwheel
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Click on "Open advanced settings popup"
    Then Visual popup should be opened

  @Map
  Scenario: TC_Map_177:Edit Map - Background - Verify closing of visual popup
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on Background drop down
    And Click on "Open advanced settings popup"
    And Click on X icon
    Then The visual popup should be closed

  @Map
  Scenario: TC_Map_178:Edit Map > Verify size of visual
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    Then The default Edit Visual popup height and width should be "100%"

  @Map
  Scenario: TC_Map_179:Edit Map > Verify horizontal alignement for size
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Open Size dropdown
    Then The "Horizontal align" should be disabled if proportion is "100%"

  @Map
  Scenario: TC_Map_180:Edit Map > Verify proportion for size
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Open Size dropdown
    Then X axis should be set to "100" with enable state & Y axis should be set to "100" with disable state

  @Map
  Scenario: TC_Map_181:Edit Map - Size - Dropdown settings  - Map position
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Open Size dropdown
    Then "Horizontal align:" and "Proportion:" should be shown

  @Map
  Scenario: TC_Map_182:Edit Map - Verify Show of the visual
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    Then "Zoom" and "Play" options should be available

  @Map
  Scenario: TC_Map_183:Edit Map - Show- Verify Zoom control = check
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check zoom control checkbox
    Then Zooming options will be displayed for the map visual

  @Map
  Scenario: TC_Map_184:Edit Map - Show- Verify Zoom control = uncheck
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And UnCheck zoom control checkbox
    Then Zooming options will not be displayed for the map visual

  @Map
  Scenario: TC_Map_185:Edit Map - Show- Verify date selection = check
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check play control  checkbox
    Then Date selection checkbox will be visible below map visual

  @Map
  Scenario: TC_Map_186:Edit Map - Show- Verify Date selection = uncheck
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And UnCheck play control checkbox
    Then Date selection checkbox will be not be visible below map visual

  @Map
  Scenario: TC_Map_187:Edit Map - Number format - Verify default Decimal places
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Open "Number format" dropdown
    Then 2 decimals should be selected by default

  @Map
  Scenario: TC_Map_188:Edit Map - Number format - Verify Decimal separator
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Open "Number format" dropdown
    And Select decimal separator as ","
    And Click on "Save"
    Then The selected decimal separator "," should be displayed on Map value

  @Map
  Scenario: TC_Map_189:Edit Map - legend
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    Then Legend option should be checked by default
    Then "Bottom Center" option should be displayed

  @Map
  Scenario: TC_Map_190:Edit Map - legend - advanced settings under dropdown - show legend
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    Then Show legend option should be checked by default

  @Map
  Scenario: TC_Map_191:Edit Map > legend dropdown
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    Then The following legend options should be available
      | Vertical align    |
      | Horizontal align  |
      | Advanced settings |

  @Map
  Scenario: TC_Map_192:Edit Map > legend > advanced settings under dropdown > Title
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Title"
    Then By default title options are disabled
    And Check legend "Title"
    Then Should enable the legend options

  @Map
  Scenario: TC_Map_193:Edit Map > legend > advanced settings under dropdown > Title color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Title"
    And Check legend "Title"
    And Enter the text "Shravas" for legend title
    And Select color for "Legend"
    When Click on "Save"
    Then Legend "title" should be displayed in selected color

  @Map
  Scenario: TC_Map_194:Edit Map > legend > advanced settings under dropdown > Title-Font style
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Title"
    And Check the checkbox for "Title" section
    And Enter the text "Shravas" for legend title
    And Select any "Legends Style" for chart visual
    Then The Selected "Font style" should reflect in the chart visual legand

  @Map
  Scenario: TC_Map_195:Edit Map > legend > advanced settings under dropdown > Background color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Background" section from Legand popup should expand
    And Check the checkbox for "Background" section
    And Select background color for legend
    When Click on "Save"
    Then The Selected "Background color" should reflect in the visual legand

  @Map
  Scenario: TC_Map_196:Edit Map > legend > advanced settings under dropdown > Border color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Border" section from Legand popup should expand
    And Check the checkbox for "Border" section
    And Select border color for legend
    When Click on "Save"
    Then The Selected "Border color" should reflect in the pie visual legand

  @Map
  Scenario: TC_Map_197:Edit Map > legend > advanced settings under dropdown > Border width
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Border" section from Legand popup should expand
    And Check the checkbox for "Border" section
    And Select "Legend Title Border Width" for chart visual to 3
    Then The Selected "Border width" should reflect in the chart visual legand

  @Map
  Scenario: TC_Map_198:Edit map > legend > advanced settings under dropdown > Border radius
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Border" section from Legand popup should expand
    And Check the checkbox for "Border" section
    And Select "Legend Title Border Radius" for chart visual to 8
    Then The Selected "Border radius" should reflect in the chart visual legand

  @Map
  Scenario: TC_Map_199:Edit Map - Verify Copyright=Check
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Check Copyright and Save
    Then The Copyright logo should be displayed for visual

  @Map
  Scenario: TC_Map_200:Edit Map - Verify Copyright=Uncheck
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And UnCheck Copyright
    Then The Copyright logo should be removed for visual

  @Map
  Scenario: TC_Map_201:Edit Map - Copyright - Verify 'Vertical align'
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Select vertical align as "top" and save
    Then The copyright should be displayed in top
    And Select vertical align as "bottom" and save
    Then The copyright should be displayed in bottom

  @Map
  Scenario: TC_Map_202:Edit Map -Copyright - Verify 'Vertical align' for middle
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Open drop down for "Copyright"
    Then The middle align option should be disabled since cannot show in the middle of the table

  @Map
  Scenario: TC_Map_203:Edit Map - Copyright - Verify 'Horizontal align'
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Select Horizontal alignment of copyright to "left" and save
    Then The copyright image should align to "Left"
    And Select Horizontal alignment of copyright to "center" and save
    Then The copyright image should align to "Center"
    And Select Horizontal alignment of copyright to "right" and save
    Then The copyright image should align to "Right"

  @Map
  Scenario: TC_Map_204:Edit Map - Copyright - Verify advance settings.
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Click on Advanced settings
    Then "Copyright" popup should be displayed

  @Map
  Scenario: TC_Map_205:Edit Map - Copyright - Verify advance settings cogwheel.
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Click on "Open advanced settings popup" icon
    Then "Copyright" popup should be displayed

  @Map
  Scenario: TC_Map_206:Edit Map - Copyright - Verify text=check.
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button from copyright popup
    Then The default text should be "Source: CEIC Data"
    When Click on "Save"
    Then Copyright text "Source: CEIC Data" should be displayed on visual

  @Map
  Scenario: TC_Map_207:Edit Map - Copyright - Verify text change for copyright
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button and Edit the text as "CDMNext" and Save
    Then Updated copyright "CDMNext" should be displayed on visual

  @Map
  Scenario: TC_Map_208:Edit Map - Copyright - Verify link for copyright
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button from copyright popup and Save
    And Click on the Copyright
    Then "Copyright" popup should be displayed

  @Map
  Scenario: TC_Map_209:Edit Map - Copyright -Verify copyright color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select color for "Copyright"
    When Click on "Save"
    Then Visual "Copyright" should be displayed in selected color

  @Map
  Scenario: TC_Map_210:Edit Map - Copyright - Verify font size
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select size for visual "Copyright" as "20"
    When Click on "Save"
    Then The "Copyright" font size should be changed as "20"

  @Map
  Scenario: TC_Map_211:Edit Map - Copyright - Verify bold style
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Bold icon for "Copyright"
    When Click on "Save"
    Then The "Copyright" should be displayed in Bold format

  @Map
  Scenario: TC_Map_212:Edit Map - Copyright - Verify Italic style
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Italic icon
    When Click on "Save"
    Then The "Copyright" should be "italic"

  @Map
  Scenario: TC_Map_213:Edit Map - Copyright - Verify Underline style
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Underline icon for "Copyright"
    When Click on "Save"
    Then The "Copyright" should be "underline"

  @Map
  Scenario: TC_Map_214:Edit Map - Copyright - Verify horizontal alignment (left, right, center)
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select Horizontal alignment of copyright to "left" and save
    Then The copyright image should align to "Left"
    And Select Horizontal alignment of copyright to "center" and save
    Then The copyright image should align to "Center"
    And Select Horizontal alignment of copyright to "right" and save
    Then The copyright image should align to "Right"

  @Map
  Scenario: TC_Map_215:Edit Map - Copyright - Verify vertical alignment (Top and bottom).
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select vertical align as "top" and save
    Then The copyright should be displayed in top
    And Select vertical align as "bottom" and save
    Then The copyright should be displayed in bottom

  @Map
  Scenario: TC_Map_216:Edit Map - Copyright - Verify closing copyright popup
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Click on X icon to close the popup
    Then The "Copyright" popup should be closed

  @Map
  Scenario: TC_Map_217:Edit Map - Data labels
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    Then "Data labels" should be checked by default

  @Map
  Scenario: TC_Map_218:Edit Map - Data labels - advanced settings cogwheel- labels - color
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on the "Data labels" checkbox to "Check"
    And Click on the "Data labels" Container
    And Expand "Labels" section from "Labels" popup
    And Click on the "Labels" checkbox to "Check"
    And Select data label "color" from the list
    And Choose Data label color is blue
    When Click on "Save"
    Then Should be able to display with selected "color"

  @Map
  Scenario: TC_Map_219:Edit Map - Data labels - advanced settings cogwheel - labels - Outline
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on the "Data labels" checkbox to "Check"
    And Click on the "Data labels" Container
    And Expand "Labels" section from "Labels" popup
    And Click on the "Labels" checkbox to "Check"
    And Choose highlight color is Orange
    When Click on "Save"
    Then Should be able to display with selected "Outline color"

  @Map
  Scenario: TC_Map_220:Edit Map - Data labels - advanced settings cogwheel - labels - Size
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    And Click on the "Data labels" checkbox to "Check"
    And Click on the "Data labels" Container
    And Expand "Labels" section from "Labels" popup
    And Click on the "Labels" checkbox to "Check"
    Then Default size should be "11"
    And Select "Data Labels font size" for chart visual to 18
    When Click on "Save"
    Then The Selected font size should update with selected input

  @Map
  Scenario: TC_Map_221:Edit Map - Data labels - advanced settings cogwheel - labels - Size
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    And Click on the "Data labels" checkbox to "Check"
    And Click on the "Data labels" Container
    And Expand "Labels" section from "Labels" popup
    And Click on the "Labels" checkbox to "Check"
    And Select any "Data Labels Style" for chart visual
    When Click on "Save"
    Then The Selected font Styles should update with selected input

  @Map
  Scenario: TC_Map_222:Edit Map - Verify Highlight Filter displaying in the map
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    Then By Default Highlight filter will grayed out

  @Map
  Scenario: TC_Map_223:Edit Map - Verify Highlight Filter when checked
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    When Check "Highlight filter"
    Then Highlight Filter will be displayed with value 0
    Then Highlight Filter will be displayed with color Red

  @Map
  Scenario: TC_Map_224:Edit Map - Verify Solid Color button - Advanced settings cogwheel - Common
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    And Select "Solid color" button
    And Click on "Open advanced settings popup" cogwheel
    When Expand "Common" section
    Then "Show legend" should be checked by default

  @Map
  Scenario: TC_Map_225:Edit Map - Verify Solid Color button - Advanced settings cogwheel - Position
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    And Select "Solid color" button
    And Click on "Open advanced settings popup" cogwheel
    When Expand "Position" section
    Then "Position" section from Legand popup should expand

  @Map
  Scenario: TC_Map_226:Edit Map - Verify title icon on visual
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    And Mouse hover on visual title for Edit visual popup
    And Click on edit icon for Edit visual popup
    Then The "Titles" popup should be appeared

  @Map
  Scenario: TC_Map_227:Edit Map - Verify titles popup open by double click on visual title.
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Edit Map"
    And Click on the visual title
    Then The "Titles" popup should be appeared

  @Map
  Scenario: TC_Map_228:Edit Map - Verify clicking on series name.
    And Create a map visual with series id's "5724301"
    And Click on "Edit Map"
    And Click on Series name on map visual
    Then The SSP window should be displayed

  @Map
  Scenario: TC_Map_229:Verify 'Add related series' option.
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Add related series"
    Then The series suggestion manager popup should be displayed

  @Map
  Scenario: TC_Map_230:Verify 'Add related series' option when the visual is empty
    And Create a empty map visual
    Then The Add related series option should be hidden if have no series associated with the visual

  @Map
  Scenario: TC_Map_231:Verify adding series from 'Series suggestion manager' popup
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Add related series"
    And Select a region as "Albania"
    Then The related series should be added to the map visual

  @Map
  Scenario: TC_Map_232:Verify add to insight option
    And Create a map visual with series id's "5724301;5823501"
    And Click on + icon on header
    Then Below options should be displayed
      | Add to new tab     |
      | Add to new insight |

  #@Map
  #Scenario: TC_Map_233:Verify Map Visuals Type under World Dropdown
  #And Click on View tab
  #When Click on world drop down button
  #Then Below options should be available
  #| World                 |
  #| Africa                |
  #| Asia                  |
  #| Europe                |
  #| Europe without Russia |
  #| EU                    |
  #| Middle East           |
  #| N America             |
  #| Oceania               |
  #| S America             |
  #| China                 |
  #| Russia                |
  #| India                 |
  #
  #@Map
  #Scenario Outline: TC_Map_234:Verify each Country/continent for Map Visual
  #And Select some series
  #And Click on View tab
  #When Click on world drop down button
  #And Select "<TypesOfMaps>" map
  #Then Respective map should be created
  #
  #Examples:
  #| TypesOfMaps           |
  #| World                 |
  #| Africa                |
  #| Asia                  |
  #| Europe                |
  #| Europe without Russia |
  #| EU                    |
  #| Middle East           |
  #| N America             |
  #| Oceania               |
  #| S America             |
  #| China                 |
  #| Russia                |
  #| India                 |
  @Map
  Scenario: TC_Map_235:Add to insight - Verify 'Add to new tab' option under Add to insight
    And Create a map visual with series id's "5724301;5823501"
    And Click on + icon on header
    And Click on "Add to new tab"
    Then The Map visual should be created in vew tab on current insight

  @Map
  Scenario: TC_Map_236:Add to insight - Verify confirmation message for adding visual to new insight
    And Create a map visual with series id's "5724301;5823501"
    And Click on + icon on header
    And Click on "Add to new insight"
    Then "New insight with the selected visual created" and "Go to new insight" confirmation message should be displayed

  @Map
  Scenario: TC_Map_237:Add to insight - Validate the added visual by opening new insight
    And Create a map visual with series id's "5724301;5823501"
    And Click on + icon on header
    And Click on "Add to new insight"
    And Click on "Go to new insight"
    Then The new insight should be opened and added map visual should be available in My visual

  @Map
  Scenario: TC_Map_238:Copy - Verify confirmation message for copy visual
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Copy" icon
    Then "Map with series copied." and "More options" confirmation message should be displayed

  @Map
  Scenario: TC_Map_239:Copy - Validate copied visual by pasting with in the insight
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Copy" icon
    And Paste within the insight
    Then The map visual should be pasted in the insight

  @Map
  Scenario: TC_Map_240:Copy - Validate copied visual by pasting to new insight
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Copy" icon
    And Paste to new insight
    Then The map visual should be pasted to new insight

  @Map
  Scenario: TC_Map_241:Copy - Verify the confrimation message for pasting visual in insight
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Copy" icon
    And Paste within the insight
    Then "Data pasted from clipboard" message should be displayed

  @Map
  Scenario: TC_Map_242:Copy - Validate by clicking on more options
    And Create a map visual with series id's "5724301;5823501"
    And Click on "Copy" icon
    And Click on More options
    Then Download window is displayed

  @Map
  Scenario: TC_Map_243:Download - Verify Download option
    And Create a map visual with series id's "5724301;5823501"
    And Click on Download icon
    Then Download popup should be appeared

  @Map
  Scenario: TC_Map_244:Download - Verify Map visual download with excel format
    And Create a map visual with series id's "5724301;5823501"
    And Click on Download icon
    And Select "xlsx" format
    And Click on "Download"
    Then Map visual and related series should be downloaded in excel

  @Map
  Scenario: TC_Map_245:Download - Verify map visual download with PDF format
    And Create a map visual with series id's "5724301;5823501"
    And Click on Download icon
    And Select "pdf" format
    And Click on "Download"
    Then Map visual should be downloaded in PDF format

  @Map
  Scenario: TC_Map_246:Download - Verify Map visual download with PNG format
    And Create a map visual with series id's "5724301;5823501"
    And Click on Download icon
    And Select "png" format
    And Click on "Download"
    Then Pie visual should be downloaded in PNG format

  @Map
  Scenario: TC_Map_247:Download - Verify Map visual download with JPG format.
    And Create a map visual with series id's "5724301;5823501"
    And Click on Download icon
    And Select "jpeg" format
    And Click on "Download"
    Then Pie visual should be downloaded in JPG format

  @Map
  Scenario: TC_Map_248:Download - Verify size for JPG/PNG download.
    And Create a map visual with series id's "5724301;5823501"
    And Click on Download icon
    And Select "jpeg" format
    And Select width size "589"
    And Click on "Download"
    Then The visual should be downloaded with selected size

  @Map
  Scenario: TC_Map_249:Verify Open option.
    And Create a map visual with series id's "5724301;5823501"
    And Click on Open icon
    Then The visual should be displayed in maximized window

  @Map
  Scenario: TC_Map_250:Verify closing of maximized window.
    And Create a map visual with series id's "5724301;5823501"
    And Click on Open icon
    And Click on x icon to close
    Then The modal window should be closed

  @Map
  Scenario: TC_Map_251:Verify Delete map
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a map visual with series id's "16240301;16243001"
    And Click on "delete"
    Then "Confirmation" popup should be dispalyed

  @Map
  Scenario: TC_Map_252:Verify description for delete confirmation popup
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a map visual with series id's "16240301;16243001"
    And Click on "delete"
    Then "Do you want to remove this visual?" popup should be dispalyed

  @Map
  Scenario: TC_Map_253:Verify OK button in delete confirmation popup
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a map visual with series id's "16240301;16243001"
    And Click on "delete"
    And Click on "Ok"
    Then The visual should be deleted

  @Map
  Scenario: TC_Map_254:Verify Cancel/x icon in delete confirmation popup
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a map visual with series id's "16240301;16243001"
    And Click on "delete"
    And Click on "Cancel"
    Then The popup should be closed and delete visual process should be declined

  @Map
  Scenario: TC_Map_255:Right click - Validate copied Map
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Copy map"
    And Paste in insight
    Then Map visual should be pasted

  @Map
  Scenario: TC_Map_256:Right click - Verify Cut map
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Cut map"
    Then Map chart should be cut

  @Map
  Scenario: TC_Map_257:Right click - Validate Cut map
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Cut map"
    And Paste in insight
    Then Map visual should be pasted

  @Map
  Scenario: TC_Map_258:Right click - Verify Delete map
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Delete map"
    Then Map chart should be deleted

  @Map
  Scenario: TC_Map_259:Right click - Verify chart under insert visual
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Chart"
    Then "Chart" visual should be created in the same view tab

  @Map
  Scenario: TC_Map_260:Right click - Verify Pie under insert visual
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Pie"
    Then "Pie" visual should be created in the same view tab

  @Map
  Scenario: TC_Map_261:Right click - Verify table under insert visual
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Table"
    Then "Table" visual should be created in the same view tab

  @Map
  Scenario: TC_Map_262:Right click - Verify map under insert visual
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Map"
    Then "Map" visual should be created in the same view tab

  @Map
  Scenario: TC_Map_263:Right click - Verify Heat map under insert visual
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Heat map"
    Then "Heat map" visual should be created in the same view tab

  @Map
  Scenario: TC_Map_264:Right click - Verify Histogram under insert visual
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Histogram"
    Then "Histogram" visual should be created in the same view tab

  #@Map
  #Scenario: TC_Map_265:Right click - Verify commentary under insert visual
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Choose Insert visual as "Commentary"
  #Then The commentary visual should be created in the same view tab
  #
  #@Map
  #Scenario: TC_Map_266:Right click - Verify attachments under insert visual
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Choose Insert visual as "Attachments"
  #Then "Attachments" visual should be created in the same view tab
  #
  #@Map
  #Scenario: TC_Map_267:Right click - Verify Image under insert visual
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Choose Insert visual as "Image"
  #Then "Image" visual should be created in the same view tab
  #
  #@Map
  #Scenario: TC_Map_268:Right click - Verify Filter under insert visual
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Choose Insert visual as "Filter"
  #Then "Filter" visual should be created in the same view tab
  @Map
  Scenario: TC_Map_269:Right click - Verify Paste visual
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Copy map"
    And Again Right click on visual header
    And Choose "Paste visual"
    Then Copied visual should be pasted

  #@Map
  #Scenario: TC_Map_270:Right click - View as - Verify Chart
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Select View as > "Chart"
  #Then The "Map" visual should be converted as "Chart" visual
  #
  #@Map
  #Scenario: TC_Map_271:Right click - View as - Verify Table
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Select View as > "Table"
  #Then The "Map" visual should be converted as "Table" visual
  #
  #@Map
  #Scenario: TC_Map_272:Right click - View as - Verify Pie
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Select View as > "Pie"
  #Then The "Map" visual should be converted as "Pie" visual
  #
  #@Map
  #Scenario: TC_Map_273:Right click - View as - Verify Histogram
  #And Create a map visual with series id's "16240301"
  #And Right click on visual header
  #And Select View as > "Histogram"
  #Then The "Map" visual should be converted as "Histogram" visual
  #
  #@Map
  #Scenario: TC_Map_274:Right click - View as - Verify Heat map
  #And Create a map visual with series id's "16240301;16243001"
  #And Right click on visual header
  #And Select View as > "Heat map"
  #Then The "Map" visual should be converted as "Heat map" visual
  @Map
  Scenario: TC_Map_275:Right click - Verify Calculated series sub dropdown
    And Create a map visual with series id's "16240301"
    And Right click on visual header
    And Choose "Calculate series"
    And Select function "RMB"
    And Click on My Series tab
    Then The applied function should be applied to the series

  @Map
  Scenario: TC_Map_276:Right click - Verify Edit series option
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Edit series"
    Then The edit series popup should be opened with "Map" tab

  @Map
  Scenario: TC_Map_277:Right click - Verify Clear contents
    And Create a map visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Clear contents"
    Then The content should be removed

  @Map
  Scenario: TC_Map_278:Right click - Verify reset format
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And UnCheck Copyright
    Then The Copyright logo should be removed for visual
    And Right click on visual header
    And Choose "Reset format"
    Then The Copyright logo should be displayed for visual

  @Map
  Scenario: TC_Map_279:Right click - Verify reset format option if have no changes in visual
    And Create a map visual with series id's "16240301"
    And Right click on visual header
    Then The Reset format option should be disabled

  @Map
  Scenario: TC_Map_280:Right click -  Verify download sub dropdown
    And Create a map visual with series id's "16240301"
    And Right click on visual header
    And Choose "Download"
    Then "Map" and "View" options should be displayed

  @Map
  Scenario: TC_Map_281:Right click -  Verify download > Map
    And Create a map visual with series id's "16240301"
    And Right click on visual header
    And Choose "Download"
    And Select Map
    Then Download popup should be displayed with Map tab selection

  @Map
  Scenario: TC_Map_282:Right click -  Verify download > View
    And Create a map visual with series id's "16240301"
    And Right click on visual header
    And Choose "Download"
    And Select View
    Then Download popup should be displayed with views tab selection

  @Map
  Scenario: TC_Map_283:Verify the visual options if visual is not selected
    And Create a map visual with series id's "16240301"
    And Unhighlight the visual
    Then The visual options should be hidden

  @Map
  Scenario: TC_Map_284: Edit Map - Verify clicking on series name
    And Create a map visual with series id's "408940397"
    And Click on "Edit Map"
    And Click on Series name
    Then The SSP window should be displayed

  @Map
  Scenario: TC_Map_285:Edit Map - Verify Rename series icon
    And Create a map visual with series id's "408940397"
    And Click on "Edit Map"
    And Click on cogwheel icon on series level
    And Click on "Rename"
    Then "Rename" popup should be displayed for selected series

  @Map
  Scenario: TC_Map_286:Edit Map - Verify Frequency option under edit series.
    And Create a map visual with series id's "408940397"
    And Click on "Edit Map"
    And Click on cogwheel icon on series level
    And Select "Frequency" as "Monthly (Replicate)"
    Then Selected function should be applied to the series

  @Map
  Scenario: TC_Map_287:Edit Map - Verify Currency option under edit series.
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on cogwheel icon on series level
    And Select "Currency" as "RMB"
    Then Selected currency should be applied to the series

  @Map
  Scenario: TC_Map_288:Edit Map - Verify Change option under edit series.
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on cogwheel icon on series level
    And Select "Change" as "% Year-over-Year (%YoY)"
    Then Selected change function should be applied to the series

  @Map
  Scenario: TC_Map_289:Edit Map - Verify selecting another visual from visual panel
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select any visual from visual panel
    And Click on "Save"
    Then The visual should be converted as user selected

  @Map
  Scenario: TC_Map_290:Edit Map - Verify selecting another visual from visual panel
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on visual panel dropdown
    And Select "Histogram" visual
    And Click on "Save"
    Then The visual should be converted as user selected

  @Map
  Scenario: TC_Map_291:Edit Map - Edit series - Verify delete series icon
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on x icon for a series
    Then The series should be removed from visual and edit series panel

  @Map
  Scenario: TC_Map_292:Edit Map - Edit series - Verify delete all series icon.
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on x icon before Name attribute
    Then All series should be removed from the visual and edit series panel

  @Map
  Scenario: TC_Map_293:Edit Map - Edit series - Verify Rename series icon
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Rename series" icon
    Then "Rename" popup should be displayed for selected series

  @Map
  Scenario: TC_Map_294:Edit Map - Edit series -Verify clicking on frequency or dropdown
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    Then "Series Harmonization" popup should be opened

  @Map
  Scenario: TC_Map_295:Edit Map - Edit series - Series data conversion - Verify applying frequency
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    And Select "Frequency" as "Daily" from dropdown
    And Click on "Apply"
    Then The selected frequency should be applied to available series

  @Map
  Scenario: TC_Map_296:Edit Map - Edit series - Series data conversion - Verify applying Missing values method
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    And Select "Frequency" as "Daily" from dropdown
    And Select "Missing values method" as "Next value" from dropdown
    Then Missing values method should be applied with selected frequency

  @Map
  Scenario: TC_Map_297:Edit Map - Edit series - Series data conversion -Minimize option
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    And Click on "Minimize" option
    Then The Series Hormonization popup should be minimized

  @Map
  Scenario: TC_Map_298:Edit Map - Edit series - Series data conversion -Verify maximize option
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The Series Hormonization popup should be maximized

  @Map
  Scenario: TC_Map_299:Edit map - Edit series - Series data conversion -verify full screen
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    And Click on "Full-screen" option
    Then The Series Hormonization popup should be displayed in full screen

  @Map
  Scenario: TC_Map_300:Edit map - Edit series - Series data conversion -verify exit full screen
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The Series Hormonization popup should be displayed in normal screen

  @Map
  Scenario: TC_Map_301:Edit map - Edit series - Series data conversion -Verify Cancel/x icon
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Frequency"
    And Click on Cancel button
    Then The Series Hormonization popup should be closed

  @Map
  Scenario: TC_Map_302:Edit map - Edit series - Verify dropdown for frequency in series level
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on frequency dropdown
    Then List of frequenceies should be available

  @Map
  Scenario: TC_Map_303:Edit map - Edit series - Verify applying frequency in series level
    And Create a map visual with series id's "16240301;16243001"
    And Click on "Edit Map"
    And Click on frequency dropdown
    And Select frequence as "Yearly (Sum)"
    Then Selected frequency should be displayed in the series

  @Map
  Scenario: TC_Map_304:Edit map - Edit series - Verify applying currency in series level
    And Create a map visual with series id's "16240301;5958801"
    And Click on "Edit Map"
    And Click on currency dropdown
    And Select currency as "USD"
    Then Selected currency should be displayed in the series

  @Map
  Scenario: TC_Map_305:Edit map - Edit series - Verify clicking on type a function field
    And Create a map visual with series id's "16240301;447233267"
    And Click on "Edit Map"
    And Click on type a function field in series level
    Then List of functions dropdown should be opened

  @Map
  Scenario: TC_Map_306:Edit map - Edit series - Verify applying function in series level
    And Create a map visual with series id's "272965603;273074003"
    And Click on "Edit Map"
    And Click on type a function field in series level
    And Select a function
    And Click on "Apply function"
    Then The selected function should be applied to the series

  @Map
  Scenario: TC_Map_307:Edit map - Edit series - Verify cancel icon for selected function
    And Create a map visual with series id's "16240301;447233267"
    And Click on "Edit Map"
    And Click on type a function field in series level
    And Select a function
    And Click on cancel function icon
    Then The selected function should be cancelled

  @Map
  Scenario: TC_Map_308:Edit map - Edit series - Verify multiple functions apply
    And Create a map visual with series id's "272965603;273074003"
    And Click on "Edit Map"
    And Click on type a function field in series level
    And Select multiple functions
    And Click on Apply function
    Then The selected functions should be applied to the series

  @Map
  Scenario: TC_Map_309:Edit series - Verify search for functions
    And Create a map visual with series id's "16240301"
    And Click on "Edit Map"
    And Click on type a function field in series level
    And Search with function "YTD"
    Then Searched functions should be displayed

  @Map
  Scenario: TC_Map_310:Edit map - Edit  series - Verify removing applied functions
    And Create a map visual with series id's "272965603;273074003"
    And Click on "Edit Map"
    And Click on type a function field in series level
    And Select a function
    And Click on "Apply function"
    And Click on cancel function icon
    Then The function should be removed from the series

  @Map
  Scenario: TC_Map_311:Edit Map - Edit series - Verify applying invalid function for series
    And Create a map visual with series id's "210698402"
    And Click on "Edit Map"
    And Click on type a function field in series level
    And Select an invalid function
    And Click on Apply function
    Then "The function cannot be applied to selected series" popup should be displayed

  @Map
  Scenario: TC_Map_312:Edit Map - Edit seires - Verify OK button on "The function cannot be applied to selected series" popup
    And Create a map visual with series id's "210698402"
    And Click on "Edit Map"
    And Click on type a function field in series level
    And Select an invalid function
    And Click on Apply function
    And Click on "Ok"
    Then The function cannot be applied to selected series popup should be closed

  @Map
  Scenario: TC_Map_313:Edit Map - Edit series - Verify Region, Unit and Series ID fields
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    Then "Region", "Unit" and "Series id" fields should be available for respective series

  @Map
  Scenario: TC_Map_314:Edit Map - Verify feedback option
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Feedback" option
    Then "Still cannot find an answer?" popup should be displayed

  @Map
  Scenario: TC_Map_315:Edit Map -  Feedback - Verify description for popup
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Feedback" option
    Then The description should be "Do you need any additional features? Please send us your feedback for product enhancements."

  @Map
  Scenario: TC_Map_316:Edit Map - Feedback - Verify Submit and cancel buttons when description field is empty
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Feedback" option
    Then Submit and Cancel buttons should be disabled by default

  @Map
  Scenario: TC_Map_317:Edit Map - Feedback - Verify cancel button
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Feedback" option
    And Enter text in description field
    And Click on cancel button
    Then The feedback popup should be closed

  @Map
  Scenario: TC_Map_318:Edit Map - Feedback - Verify growl message after  Submit feedback
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Feedback" option
    And Enter text in description field
    And Click on submit button
    Then "Thank you for submitting a question to us." message should be displayed in a growl popup

  @Map
  Scenario: TC_Map_319:Edit Map - Verify cancel/x button
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Click on "Cancel" button
    Then The edit visual popup should be closed

  @Map
  Scenario: TC_Map_320:Edit Map - Verify save button
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Change title in edit visual window
    And Click on "Save" button
    Then The changes should be reflected to histogram visual and Edit visual popup should be closed

  @Map
  Scenario: TC_Map_321:Edit Map - Verify Solid Color button - Color Steps Dropdown
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Solid color
    Then Default value should be "3" and the colors range should be from "2,3,4,5,6,7"

  @Map
  Scenario: TC_Map_322:Edit Map - Verify Solid Color button - Color Steps
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Solid color
    And Click on color steps dropdown
    Then Selected color steps will be created as per the selection

  @Map
  Scenario: TC_Map_323:Edit Map - Verify Solid Color button - Color Steps - Smallest Value and Highest Value
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Solid color
    Then Smallest value for Map will be displayed in decimal points with respective color
    Then Highest Value will be displayed in decimal points with respective color

  @Map
  Scenario: TC_Map_324:Edit Map - Verify Solid Color button - Color Steps - Smallest Value = Color
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Solid color
    And Click on the color button for the smallest value and change it to Red
    Then Selected color will be changed accordingly

  @Map
  Scenario: TC_Map_325:Edit Map - Verify Solid Color button - Advanced settings cogwheel
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Solid color
    And Click on Advanced Setting popup cogwheel
    Then The following list will be displayed
      | Common     |
      | Color axes |
      | Position   |
      | Title      |
      | Background |
      | Border     |

  @Map
  Scenario: TC_Map_326:Edit Map - Gradient color button - Steps Dropdown
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Gradient
    Then Steps from "0,1,2,3,4,5" will be available and By default 0 color step will be displayed

  @Map
  Scenario: TC_Map_327:Edit Map - Gradient color button - Steps change
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Gradient
    And Click on color steps dropdown
    Then Selected steps will be created as per the selection
