Feature: Verifying Pie Visual Functionality

  @PieVisual
  Scenario: TC_Pie_01: Verify Pie option under Views > Visuals tab
    And Open preference dropdown
    And Clicking on "Keyboard shortcuts" option under user preference be "ON"
    And Open preference dropdown
    And Creating an Insight by selecting few series
    And Click to create an empty visual
    Then Should display "Pie" options on the right pane under "Views" > "Visuals" tab

  @PieVisual
  Scenario: TC_Pie_02: Verify creating Pie visual with random series present in a search pane of an insight
    And Select different frequency series "3671601;403770597" and click on "Pie" icon
    Then Pie visual should be created with frequency conversion window popped up

  #@PieVisual
  #Scenario: TC_Pie_03: Verify Drag and drop of Pie option
    #And Click to create an empty visual
    #And Hovor on Insert Pie
    #And "Drag and Drop" the Insert pie option
    #Then Pie visual should add to view area by "DragandDrop"

  @PieVisual
  Scenario: TC_Pie_04: Verify any of the frequencied series to weekly series to visualize pie
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then Frequency conversion window should be popped for selecting other than weekly frequency in same window

  @PieVisual
  Scenario: TC_Pie_05: Verify click on cancel in currency conversion popup
    And Select series with same filter and different units "226311002;405159937"
    And Create a Pie visual
    Then The Data conversion window should get closed

  @PieVisual
  Scenario: TC_Pie_06: Verify changing data into US dollars in currency conversion popup with keep as reported
    And Select series with same filter and different units "226311002;405159937"
    And Create a Pie visual
    And Make the changes in series harmonization popup
    Then US currency should be applicable for series in visual pie

  @PieVisual
  Scenario: TC_Pie_07: Verify maxmizing currency data conversion popup
    And Select series with same filter and different units "226311002;405159937"
    And Create a Pie visual
    And Make the changes in the series harmonization popup
    Then The Window should be maximized

  @PieVisual
  Scenario: TC_Pie_08: Verify viewing fullscreen of data currency conversion popup
    And Select series with same filter and different units "226311002;405159937"
    And Create a Pie visual
    And Make the changes in the series harmonization popup
    Then Verify viewing "Full-screen" of data currency conversion popup

  @PieVisual
  Scenario: TC_Pie_09: Verify viewing fullscreen of data currency conversion popup
    And Select series with same filter and different units "226311002;405159937"
    And Create a Pie visual
    And Make the changes in the series harmonization popup
    Then Verify viewing "Exit full-screen" of data currency conversion popup

  @PieVisual
  Scenario: TC_Pie_10: Verify Closing data currency conversion popup
    And Select series with same filter and different units "226311002;405159937"
    And Create a Pie visual
    And Make the changes in the series harmonization popup
    Then Verify viewing "Closing" of data currency conversion popup

  @PieVisual
  Scenario: TC_Pie_11: Verify default value for field Missing values method in frequency conversion popup window
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then Verify default values of data currency conversion popup

  @PieVisual
  Scenario: TC_Pie_12:Edit Pie - Border - Verify closing of visual popup
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Click on "Open advanced settings popup"
    And Click on X icon
    Then The visual popup should be closed

  @PieVisual
  Scenario: TC_Pie_13: Verify functions applies in frequency conversion
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then Verify the function applied in frequency conversion popup

  @PieVisual
  Scenario: TC_Pie_14: Verify End dropdown for functions dropdown in frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then The number of days should able to select in a functions End dropdown

  @PieVisual
  Scenario: TC_Pie_15: Verify series having negative timepoints in pie chart
    And Search for the series with SID "16164001"
    And Click on more actions
     And Choose Add chart as "Pie"
    Then The message should appear

  @PieVisual
  Scenario: TC_Pie_16: Verify tooltip for different frequency series in pie
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then Should be able to open frequency conversion popup with all the available options present

  @PieVisual
  Scenario: TC_Pie_17: Edit series - Verify Edit series option for Pie visual
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then The Edit series panel should be opened with "Pie" tab

  @PieVisual
  Scenario: TC_Pie_18: Verify Series Harmonization popup for pie visual
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then "Series Harmonization" popup should be opened

  @PieVisual
  Scenario Outline: <TCID>: Verify changing data into <Currency> in currency conversion popup with keep as reported
    And Select series with same filter and different units "365384457;414249197"
    And Create a Pie visual
    And Select Currency conversion as "<Currency>" and with "<Unit>"
    Then "<Currency>" currency should get converted as "<Unit>" in visual pie

    Examples: 
      | TCID      | Currency           | Unit         |
      | TC_Pie_19 | US Dolllars        | in Thousands |
      | TC_Pie_20 | US Dolllars        | in Millions  |
      | TC_Pie_21 | US Dolllars        | in Billions  |
      | TC_Pie_22 | Chinese Yuan (RMB) | as reported  |
      | TC_Pie_23 | Chinese Yuan (RMB) | in Thousands |
      | TC_Pie_24 | Chinese Yuan (RMB) | in Millions  |
      | TC_Pie_25 | Chinese Yuan (RMB) | in Billions  |
      | TC_Pie_26 | Japanese Yen       | as reported  |
      | TC_Pie_27 | Japanese Yen       | in Thousands |
      | TC_Pie_28 | Japanese Yen       | in Millions  |
      | TC_Pie_29 | Japanese Yen       | in Billions  |
      | TC_Pie_30 | UK Pounds          | as reported  |
      | TC_Pie_31 | UK Pounds          | in Thousands |
      | TC_Pie_32 | UK Pounds          | in Millions  |
      | TC_Pie_33 | UK Pounds          | in Billions  |
      | TC_Pie_34 | Euros              | as reported  |
      | TC_Pie_35 | Euros              | in Thousands |
      | TC_Pie_36 | Euros              | in Millions  |
      | TC_Pie_37 | Euros              | in Billions  |
      | TC_Pie_38 | Malaysian Ringgit  | as reported  |
      | TC_Pie_39 | Malaysian Ringgit  | in Thousands |
      | TC_Pie_40 | Malaysian Ringgit  | in Millions  |
      | TC_Pie_41 | Malaysian Ringgit  | in Billions  |
      | TC_Pie_42 | Russian Ruble      | as reported  |
      | TC_Pie_43 | Russian Ruble      | in Thousands |
      | TC_Pie_44 | Russian Ruble      | in Millions  |
      | TC_Pie_45 | Russian Ruble      | in Billions  |

  @PieVisual
  Scenario: TC_Pie_46: Verify minimizing currency data conversion popup
    And Select series with same filter and different units "226311002;405159937"
    And Create a Pie visual
    And Click on minus icon
    And Make the changes in the series harmonization popup
    Then The Window should be minimized

  @PieVisual
  Scenario: TC_Pie_47: Verify fields present in Series Hormonization window for visual pie
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then The following options should be available
      | Frequency             |
      | Missing values method |
      | Currency conversion   |

  @PieVisual
  Scenario: TC_Pie_48: Verify default value for field Frequency in Series Hormonization popup window
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then The following frequencies should be available
      | Daily      |
      | Weekly     |
      | Monthly    |
      | Quarterly  |
      | Semiannual |
      | Yearly     |

  @PieVisual
  Scenario: TC_Pie_49: Verify default value for field missing values method in Series Hormonization popup window
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then The following missing values method should be available
      | Keep as reported                         |
      | Previous value                           |
      | Next value                               |
      | Specific value                           |
      | Calculate with linear interpolation      |
      | Calculate with linear extrapolate        |
      | Calculate with exponential interpolation |
      | Calculate with cubic spline              |

  @PieVisual
  Scenario: TC_Pie_50: Verify options present in Currency conversion field dropdown
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then The following Currency conversion options should be available
      | Keep as reported   |
      | US Dollars         |
      | Chinese Yuan (RMB) |
      | Japanese Yen       |
      | UK Pounds          |
      | Euros              |
      | Malaysian Ringgit  |
      | Russian Ruble      |

  @PieVisual
  Scenario: TC_Pie_51: Verify options present in Currency multiples of conversion field dropdown
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then The following Currency multiples of conversion options should be available
      | as reported  |
      | in Thousands |
      | in Millions  |
      | in Billions  |

  @PieVisual
  Scenario: TC_Pie_52: Verify functions dropdown in frequency conversion popup window
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Click on Functions dropdown
    Then The following arguments should be available
      | End    |
      | Method |

  @PieVisual
  Scenario: TC_Pie_53: Verify edit option for particualr series in a frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Click on edit series function icon
    Then The following arguments should be available
      | End    |
      | Method |

  @PieVisual
  Scenario: TC_Pie_54:Verify End dropdown for edit icon click in frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Click on edit series function icon
    Then The below "end" dropdown options should be available
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |

  @PieVisual
  Scenario: TC_Pie_55:Verify Method dropdown for functions dropdown in frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Click on Functions dropdown
    Then The below "method" dropdown options should be available
      | Sum             |
      | Avg             |
      | Min             |
      | Max             |
      | Last            |
      | First           |
      | Nth observation |

  @PieVisual
  Scenario: TC_Pie_56:Verify Method dropdown for edit icon in frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Click on edit series function icon
    Then The below "method" dropdown options should be available
      | Sum             |
      | Avg             |
      | Min             |
      | Max             |
      | Last            |
      | First           |
      | Nth observation |

  @PieVisual
  Scenario: TC_Pie_57:Verify minimizing frequency conversion popup for visual pie
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Click on minus icon
    Then The Window should be minimized

  @PieVisual
  Scenario: TC_Pie_58:Verify maximizing frequency conversion popup for visual pie
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Click on minus icon again
    Then The Window should get maximized

  @PieVisual
  Scenario: TC_Pie_59: Verify viewing fullscreen of frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then Verify viewing "Full-screen" of frequency conversion popup

  @PieVisual
  Scenario: TC_Pie_60: Verify Exit-fullscreen of frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then Verify viewing "Exit full-screen" of frequency conversion popup

  @PieVisual
  Scenario: TC_Pie_61: Verify Closing frequency conversion popup
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    Then Verify viewing "Closing" of frequency conversion popup

  @PieVisual
  Scenario: TC_Pie_62: Verify pie with different frequency
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Select "Keep different frequencies"
    Then Should create pie chart with different freq by disabling highest frequency

  @PieVisual
  Scenario: TC_Pie_63: Verify date field
    And Create a pie visual with series id's "296237202;408940397"
    And Click on date field
    Then Date popup should be displayed
    And Select date as "2011"
    Then Selected date should be applied to the visual

  @PieVisual
  Scenario: TC_Pie_64: Verify making same frequency for all series in pie by selecting keep different freq
    And Select series with different filter and units "226311002;16190501"
    And Create a Pie visual
    And Select "Keep different frequencies"
    And Click on Exclamatory icon of the series which are disabled in pie visual
    And Select frequency as "Daily"
    Then Should be able to turn all series frequency into desired frequency

  @PieVisual
  Scenario: TC_Pie_65: Verify double clicking on timepoints
    And Create a pie visual with series id's "408940397;408929327"
    And Double click on timepoints
    Then The Labels popup should be displayed
    And Choose highlight color is Orange
    Then The label color should update as Orange

  @PieVisual
  Scenario: TC_Pie_66: Rename - Verify number of selected series
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    Then Number of selected series count should be displayed on the rename popup header

  @PieVisual
  Scenario: TC_Pie_67: Rename - Verify number of available itmes
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    Then Number of available series count should be shown under the find field

  @PieVisual
  Scenario: TC_Pie_68: Rename - Verify find field
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    Then Result should be loaded for searched keyword

  @PieVisual
  Scenario: TC_Pie_69: Rename -  Verify number of searched result
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    Then The total number of matches result should be displayed in below the find field

  @PieVisual
  Scenario: TC_Pie_70: Rename - Verify 'Replace' button
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search for the series you want to rename
    And Enter keyword you want to replace with
    And Click on Replace
    Then The keyword should be replaced for selected series

  @PieVisual
  Scenario: TC_Pie_71: Rename - Verify 'Replace All' button
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Enter the keyword you want to rename
    And Enter the keyword you want to replace with
    And Click on "Replace All"
    Then All the available series should be replaced with the keyword

  @PieVisual
  Scenario: TC_Pie_72: Rename - Verify for invalid search
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Search with invalid series name
    Then "No matches found" should be displayed under the find field

  @PieVisual
  Scenario: TC_Pie_73: Rename - Verify 'Edit series info' dropdown
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    Then Below options should be displayed
      | Name                 |
      | Function description |
      | Region               |
      | Unit                 |
      | Frequency            |

  @PieVisual
  Scenario: TC_Pie_74: Rename - Verify default selection for 'Edit series info' dropdown
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    Then By default "Name" should be selected in Edit series info dropdown

  @PieVisual
  Scenario: TC_Pie_75: Rename - Verify 'Name' selection
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    Then Series should be displayed by name

  @PieVisual
  Scenario: TC_Pie_76: Rename - Verify 'Function description' selection
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Pie" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    Then The series should be displayed by function description

  @PieVisual
  Scenario: TC_Pie_77:Rename - verify function description selection without function apply
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    Then Empty row should be dispalyed

  @PieVisual
  Scenario: TC_Pie_78:Rename - Verify editing function description
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Pie" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Edit function description
    And Click on "Apply"
    Then Should allowed to edit function discription and should be updated in edit series panel

  @PieVisual
  Scenario: TC_Pie_79:Rename - Verify adding function description
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Pie" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on "Apply"
    Then Should allowed to add function discription and should be updated in edit series panel

  @PieVisual
  Scenario: TC_Pie_80:Rename - Function discription -Verify Apply original title icon behavior
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Pie" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on '>' icon
    Then The changes should be revert to original series "function"

  @PieVisual
  Scenario: TC_Pie_81:Rename - Function discription - Verify'Apply original title for all series' icon
    And Add series to the my series tab and Apply function
    And Right click on series
    And Select "Pie" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "function"

  @PieVisual
  Scenario: TC_Pie_82:Rename - Function discription - Verify clicking on series name
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Pie" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Click on series name
    Then The SSP window should be displayed

  @PieVisual
  Scenario: TC_Pie_83:Rename - Name - verify Editing series name
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on "Apply"
    Then Should able to edit the insight title and updated in visual series

  @PieVisual
  Scenario: TC_Pie_84:Rename - Name - Verify Apply original title icon
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on '>' icon
    Then The changes should be revert to original series "name"

  @PieVisual
  Scenario: TC_Pie_85:Rename - Name - Verify "Apply original title for all series" icon
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "name"

  @PieVisual
  Scenario: TC_Pie_86:Rename - Verify Region selection
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    Then Series should be displayed by Region

  @PieVisual
  Scenario: TC_Pie_87:Rename - Rename region
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    Then The region should be renamed for the series

  @PieVisual
  Scenario: TC_Pie_88:Rename - Region - Verify Apply original region icon
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    And Click on '>' icon
    Then The changes should be revert to original series "region"

  @PieVisual
  Scenario: TC_Pie_89:Rename - Region - Verify "Apply original region for all series" icon
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "region"

  @PieVisual
  Scenario: TC_Pie_90:Rename - unit - verify Editing series unit
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on "Apply"
    Then Should able to edit series unit and updated in visual series as per the changes

  @PieVisual
  Scenario: TC_Pie_91:Rename - unit - Verify Apply original unit icon
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on '>' icon
    Then The changes should be revert to original series "unit"

  @PieVisual
  Scenario: TC_Pie_92:Rename - unit - Verify "Apply original unit for all series" icon
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "unit"

  @PieVisual
  Scenario: TC_Pie_93:Rename - frequency - verify Editing series frequency
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on "Apply"
    Then Should able to edit series frequency and updated in visual series as per the changes

  @PieVisual
  Scenario: TC_Pie_94:Rename - frequency - Verify Apply original frequency icon
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on '>' icon
    Then The changes should be revert to original series "frequency"

  @PieVisual
  Scenario: TC_Pie_95:Rename - frequency - Verify "Apply original frequency for all series" icon
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "frequency"

  @PieVisual
  Scenario: TC_Pie_96:Rename - Verify Auto name check box
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    Then Check box should be checked by default for auto name

  @PieVisual
  Scenario: TC_Pie_97:Rename - verify attributes dropdown
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Open dropdown for auto name
    Then Below options should be available
      | Name                 |
      | Function description |
      | Region               |
      | Unit                 |
      | Frequency            |

  @PieVisual
  Scenario: TC_Pie_98:Rename - verify selecting multiple attributes for series name
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Select multiple attributes
    And Click on "Apply"
    And Click on "OK"
    Then Selected attributes should be displayed as series name

  @PieVisual
  Scenario: TC_Pie_99:Rename - Veriy series in My series after visual series renamed
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    Then The changes should be applied to only visual and its series in edit series panel NOT for my series

  @PieVisual
  Scenario: TC_Pie_100:Rename - Verify 'Apply' button
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on "Apply"
    Then The changes should be saved and rename popup remains displayed

  @PieVisual
  Scenario: TC_Pie_101:Rename - Minimize option
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Minimize" option
    Then The Popup should be minimized

  @PieVisual
  Scenario: TC_Pie_102:Rename - Verify maximiz option
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The popup should be maximized

  @PieVisual
  Scenario: TC_Pie_103:Rename - verify full screen
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Full-screen" option
    Then The popup should be displayed in full screen

  @PieVisual
  Scenario: TC_Pie_104:Rename - verify exit full screen
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The popup should be displayed in normal screen

  @PieVisual
  Scenario: TC_Pie_105:Rename - Verify Cancel/x icon
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Cancel button
    Then The rename popup should be closed

  @PieVisual
  Scenario: TC_Pie_106:Rename - Verify opening rename popup by keyboard shortcut
    And Create a pie visual with series id's "408940397;408929327"
    And Click on Edit series option
    And Press Ctrl+H on keyboard
    Then Rename popup should be displayed

  @PieVisual
  Scenario: TC_Pie_107:Edit series - Verify applying 'Currency conversation' function
    And Create a pie visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Choose any function from Currency conversation
    Then Selected currency should be applied to all series

  @PieVisual
  Scenario: TC_Pie_108:Edit series - Verify applying 'Calculate change' function
    And Create a pie visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Choose any function from Calculate change
    Then Selected function should be applied to all series

  @PieVisual
  Scenario: TC_Pie_109:Edit series - Verify 'Aggregate' function apply
    And Create a pie visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on Aggregate and choose any option
    Then Selected function should be applied to all series

  @PieVisual
  Scenario: TC_Pie_110:Edit series - Verify 'Accumulate' function apply
    And Create a pie visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on Accumulate and choose any option
    Then Selected function should be applied to all series

  @PieVisual
  Scenario: TC_Pie_111:Edit series - Verify 'FX more' drop down
    And Create a pie visual with series id's "239796903"
    And Click on Edit series option
    And Click on FX More dropdown and Choose any function
    Then Selected function should display in series

  @PieVisual
  Scenario: TC_Pie_112:Edit series - Verify FX icon.
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on FX icon
    Then The "Apply functions to visual series" popup should be opened

 @PieVisual
  Scenario: TC_Pie_113:Edit series - Verify applying function by clicking on function icon
    And Create a pie visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on FX icon
    And Click on type a function field
    And Select any function
    And Click on "Apply"
    Then The selected function should be displayed

  #@PieVisual
  #Scenario: TC_Pie_114:Edit series - Verify hiding function toolbar
    #And Create a pie visual with series id's "408940397"
    #And Click on Edit series option
    #And Click on "Hide the function bar"
    #Then The function toolbar should be hidden

  #@PieVisual
  #Scenario: TC_Pie_115:Edit series - Verify showing the function toolbar
    #And Create a pie visual with series id's "408940397"
    #And Click on Edit series option
    #And Click on "Hide the function bar"
    #And Click on "Show the function bar"
    #Then The function toolbar should be shown

 @PieVisual
  Scenario: TC_Pie_116:Edit series - Verify 'Type a function' field
    And Create a pie visual with series id's "226311002;405159937"
    And Click on Edit series option
    And Click on type a function field
    And Select any function
    And Click on "Apply"
    Then The selected function should be displayed

  @PieVisual
  Scenario: TC_Pie_117:Edit series - Verify delete series icon
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on x icon for a series
    Then The series should be removed from the visual and edit series panel

  @PieVisual
  Scenario: TC_Pie_118:Edit series - Verify SSP by clicking on series name
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on series name
    Then SSP popup should be displayed

  @PieVisual
  Scenario: TC_Pie_119:Edit series - Verify Rename series icon
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on rename series icon
    Then Rename popup should be displayed for selected series

  @PieVisual
  Scenario: TC_Pie_120:Edit series - Verify edit series icon
    And Create a pie visual with series id's "226311002"
    And Click on Edit series option
    And Click on edit series icon
    Then Below options should be available
      | Rename    |
      | Color     |
      | Frequency |
      | Currency  |
      | Change    |

  @PieVisual
  Scenario: TC_Pie_121:Edit series - Verify Rename option under edit series
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Rename"
    Then Rename popup should be displayed for selected series

 @PieVisual
  Scenario: TC_Pie_122:Edit series - Verify Color option under edit series
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Color"
    Then Selected color should be applied to the series

  @PieVisual
  Scenario: TC_Pie_123:Edit Histogram - Edit series - Verify Currency option under edit series
    And Create a pie visual with series id's "226311002"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Currency"
    Then Selected currency function should be applied to the series

  @PieVisual
  Scenario: TC_Pie_124:Edit series - Verify Change option under edit series
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on edit series icon
    And Select "Change"
    Then Selected change function should be applied to the series

  @PieVisual
  Scenario: TC_Pie_125:Edit series - Verify delete all series icon
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on "Delete series" icon before name attribute
    Then All the series should be removed from the visual and edit series panel

  @PieVisual
  Scenario: TC_Pie_126:Edit series - Verify applying frequency in series level
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on frequency dropdown in series level
    And Select "Yearly (Sum)" from frequency dropdown
    Then Selected frequency should be applied to ONLY selected series

  @PieVisual
  Scenario: TC_Pie_127:Edit series - Verify applying currency in series level
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on currency dropdown in series level
    And Select "RMB" from currency dropdown
    Then Selected currency should be applied to ONLY selected series

 @PieVisual
  Scenario: TC_Pie_128:Edit series - Verify applying function in series level
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    Then Selected function should applied to the series

 @PieVisual
  Scenario: TC_Pie_129:Edit series - Verify multiple functions apply
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select multiple functions "ACCUMULATE"  and "LOG"
    And Click on "Apply function"
    Then The Selected functions should applied to the series

  @PieVisual
  Scenario: TC_Pie_130:Edit series -  Verify cancel icon for selected function
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on type a function field in series level
    And Select a function
    And Click on cancel function icon
    Then The selected function should be cancelled

  @PieVisual
  Scenario: TC_Pie_131:Edit series - Verify search for functions
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on type a function field in series level
    And Search with function "YTD"
    Then Searched functions should be displayed

 @PieVisual
  Scenario: TC_Pie_132:Edit series - Verify removing applied functions
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    And Click on x icon to remove the function
    Then The function should be removed from the series

 @PieVisual
  Scenario: TC_Pie_133:Edit series - Verify applied funtion in function toolbar
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    Then The applied function should be displayed on the toolbar

 @PieVisual
  Scenario: TC_Pie_134:Edit series - Verify applying invalid function for series
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select an invalid function for the series
    Then "The function cannot be applied to selected series" popup should be displayed

 @PieVisual
  Scenario: TC_Pie_135:Edit seires - Verify OK button on "The function cannot be applied to selected series" popup
    And Create a pie visual with series id's "408940397"
    And Click on Edit series option
    And Click on type a function field in series level
    And Select an invalid function
    And Click on "Apply function"
    And Click on "Ok"
    Then The function cannot be applied to selected series popup should be closed

 @PieVisual
  Scenario: TC_Pie_136:Edit series - Verify Region, Unit and Series ID fields
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Edit series option
    Then "Region", "Unit" and "Series id" fields should be available for respective series

  @PieVisual
  Scenario: TC_Pie_137:Edit series - Verify "+Add from my series" option
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on "+ Add more from My Series" option
    Then User should redirect to "+Add from My Series" tab

  @PieVisual
  Scenario: TC_Pie_138:Edit series - Verify edit series panel close
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on x icon to close the edit seires panel
    Then The edit series panel should be closed

  @PieVisual
  Scenario: TC_Pie_139:Verify Edit Pie
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    Then The "Edit visual" popup should be displayed

  @PieVisual
  Scenario: TC_Pie_140:Edit Pie - Verify dropdown for template
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on dropdown for template
    Then The following templates should be available
      | CEIC Styles |
      | My Styles   |

  @PieVisual
  Scenario: TC_Pie_141:Edit Pie - Verify template creating
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Make any changes in edit visual
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    Then New template should be created with the name of "Shravas"

  @PieVisual
  Scenario: TC_Pie_142:Edit Pie - Verify Cancel icon for template popup
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Make any changes in edit visual
    And Click on create template icon
    And Click on x icon in the template popup
    Then The template popup should closed

  @PieVisual
  Scenario: TC_Pie_143:Edit Pie - Verify description for confirmation popup
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    Then The description should be "Are you sure you want to delete this style template?" diaplayed

  @PieVisual
  Scenario: TC_Pie_144:Edit Pie - Verify delete template icon
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    Then "Confirmation" popup should be diaplayed

  @PieVisual
  Scenario: TC_Pie_145:Edit Pie - Verify OK button on confirmation popup
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    And Click on "Ok"
    Then The template should be deleted from the list

  @PieVisual
  Scenario: TC_Pie_146:Edit Pie - Verify cancel/x icon on confirmation popup
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And UnCheck Legend option
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    And Click on "Cancel"
    Then The confirmation popup should be closed

 @PieVisual
  Scenario: TC_Pie_147:Edit Pie - Border - Verify Pie color
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Check Pie for "Border"
    And Select color
    Then Border should be displayed for "pie visual" with selected color

  @PieVisual
  Scenario: TC_Pie_148:Edit Pie - Border - Verify pie width
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Check Pie for "Border"
    And Select Width to 5
    Then The pie border "Width" should be updated to "5"

  @PieVisual
  Scenario: TC_Pie_149:Edit Pie - Border - Verify pie Radius
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Check Pie for "Border"
    And Select Radius as 10
    Then Radius should be updated to 10 on pie

 @PieVisual
  Scenario: TC_Pie_150:Edit Pie - Border - Verify visual color
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Check Visual check box
    And Select color for Visual
    Then Border should be displayed for visual with selected color

  @PieVisual
  Scenario: TC_Pie_151:Edit series - Verify adding series from my series
    And Add series to the my series tab
    And Create Pie empty visual
    And Click on Edit series option
    And Redirect to MySeries tab > Select a series
    Then The selected series should be displayed in Table tab

  @PieVisual
  Scenario: TC_Pie_152:Verify max series for Pie visual
    And Select more than 20 series and try to create Pie visual
    Then Pie should allow max 20 series

  @PieVisual
  Scenario: TC_Pie_153:Edit series - Verify default sort by in add from my series tab
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Edit series option
    And Click on "Add from My Series"
    Then By default checked sort by should be applied

  @PieVisual
  Scenario: TC_Pie_154:Edit Pie - Verify 'Set as default for future pie visual' is checked
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Mouse move on existing visual templates
    And Click on template dropdown
    And Check the box for "Set as default for future Pie visual"
    And Click on "Save"
    And Create a new pie visual
    Then The Pie should be created with the format of previous template selection

  @PieVisual
  Scenario: TC_Pie_155:Edit Pie - Verify 'Set as default for future Pie visual' is Unchecked
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Mouse move on existing visual templates
    And Click on template dropdown
    And Check the box for "Set as default for future Pie visual" should be unchecked
    And Click on "Save"
    And Create a new pie visual
    Then The pie should be created with default format template

 @PieVisual
  Scenario: TC_Pie_156:Edit pie - Border - Verify visual width
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Check Visual check box
    And Select Width to 5
    Then The visual border "Width" should be updated to "5"

 @PieVisual
  Scenario: TC_Pie_157:Edit pie - Border - Verify visual Radius
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Check Visual check box
    And Select Radius to 10
    Then The visual border "Radius" should be updated to "10"

 @PieVisual
  Scenario: TC_Pie_158:Edit pie - Border - Verify visual style
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Check Visual check box
    And Select below Styles for visual border
      | Solid  |
      | Dashed |
      | Dotted |
    Then The selected border should be applied to the visual

  @PieVisual
  Scenario: TC_Pie_159:Edit pie - Border - Verify advance settings
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Click on "Advanced settings"
    Then Visual popup should be opened

  @PieVisual
  Scenario: TC_Pie_160:Edit Pie - Border - Verify advance settings cogwheel
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Border drop down
    And Click on "Open advanced settings popup"
    Then Visual popup should be opened

  @PieVisual
  Scenario: TC_Pie_161:Edit Pie - Title - Verify Title=Yes
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Title drop down
    And Check Title and Save
    Then The title of the visual should be displayed

  @PieVisual
  Scenario: TC_Pie_162:Edit Pie - Title - Verify Title=No
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Title drop down
    And UnCheck Title and Save
    Then The title of the visual should be removed from the visual

  @PieVisual
  Scenario: TC_Pie_163:Edit Pie -  Title - Verify default selection for title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Title drop down
    Then The title should be selected by default

  @PieVisual
  Scenario: TC_Pie_164:Edit Pie -  Title - Verify Auto title
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Title drop down
    And Check title with empty title field and Save
    Then Auto title should be displayed as series name

  @PieVisual
  Scenario: TC_Pie_165:Edit Pie - Title - Verify renaming title
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Title drop down
    And Enter visual name and Save
    Then The visual name should be changed

  @PieVisual
  Scenario: TC_Pie_166:Edit Pie - Title - Verify sub title by default
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Title drop down
    Then The sub title check box should be unchecked by default

  @PieVisual
  Scenario: TC_Pie_167:Edit Pie - Title - Verify sub title=Check
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Title drop down
    And Check Subtitle and Save
    Then Sub title should be displayed for the visual

  @PieVisual
  Scenario: TC_Pie_168:Edit Pie -  Title - Verify sub title=Uncheck
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Title drop down
    And UnCheck Subtitle and Save
    Then Sub title should not be displayed for the visual

  @PieVisual
  Scenario: TC_Pie_169:Edit Pie - Title - Verify default title for sub title
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Title drop down
    And Check Subtitle and Save
    Then Default sub title should be "Sub title"

  @PieVisual
  Scenario: TC_Pie_170:Edit Pie - Title - Verify advance settings
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Title drop down
    And Click on "Advanced settings"
    Then Titles popup should be displayed

  @PieVisual
  Scenario: TC_Pie_171:Edit Pie - Verify advance settings cogwheel icon
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    Then Titles popup should be displayed

 @PieVisual
  Scenario: TC_Pie_172:Edit Pie - Title - Verify color for visual title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select color for "Title"
    When Click on "Save"
    Then Visual "title" should be displayed in selected color

 @PieVisual
  Scenario: TC_Pie_173:Edit Pie - Title - Verify color for visual title background
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select color for "title" background highlight
    When Click on "Save"
    Then Visual "title" background should be displayed in selected color

  @PieVisual
  Scenario: TC_Pie_174:Edit Pie - Title - Verify font size for visual title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select size for visual "title" as "20"
    When Click on "Save"
    Then The "title" font size should be changed as "20"

  @PieVisual
  Scenario: TC_Pie_175:Edit Pie - Title - Verify bold style for visual title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Bold icon for "title"
    When Click on "Save"
    Then The "title" should be displayed in Bold format

  @PieVisual
  Scenario: TC_Pie_176:Edit Pie - Title - Verify Italic style for visual title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Italic under style
    When Click on "Save"
    Then The "title" should be "italic"

  @PieVisual
  Scenario: TC_Pie_177:Edit Pie - Title - Verify Underline style for visual title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Underline icon for "title"
    When Click on "Save"
    Then The "title" should be "underline"

  @PieVisual
  Scenario: TC_Pie_178:Edit Pie - Title - Verify bold style default selection
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    Then The bold icon should be selected by default

 @PieVisual
  Scenario: TC_Pie_179:Edit Pie - Title - Verify horizontal alignment (left, right, center)
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select alignment of title to "left"
    Then The title should align to "left"
    And Select alignment of title to "center"
    Then The title should align to "center"
    And Select alignment of title to "right"
    Then The title should align to "right"

 @PieVisual
  Scenario: TC_Pie_180:Edit Pie - Title - Verify color for visual sub title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select color for "Sub title"
    When Click on "Save"
    Then Visual "sub_title" should be displayed in selected color

 @PieVisual
  Scenario: TC_Pie_181:Edit Pie - Verify color for visual sub title background
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select color for "Sub title" background highlight
    When Click on "Save"
    Then Visual "sub_title" background should be displayed in selected color

  @PieVisual
  Scenario: TC_Pie_182:Edit Pie - Title - Verify font size for visual sub title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Select size for visual "Sub title" as "20"
    When Click on "Save"
    Then The "sub_title" font size should be changed as "20"

  @PieVisual
  Scenario: TC_Pie_183:Edit Pie - Title - Verify bold style for visual sub title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Click on B under style for sub-title
    When Click on "Save"
    Then The "sub_title" should be displayed in Bold format

  @PieVisual
  Scenario: TC_Pie_184:Edit Pie - Title - Verify Italic style for visual sub title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Click on Italic under style for sub-title
    When Click on "Save"
    Then The "sub_title" should be "italic"

  @PieVisual
  Scenario: TC_Pie_185:Edit Pie - Verify Underline style for visual sub title.
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Click on Underline icon for sub-title
    When Click on "Save"
    Then The "sub_title" should be "underline"

 @PieVisual
  Scenario: TC_Pie_186:Edit Pie - Title - Verify horizontal alignment (left, right, center)
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select alignment of sub title to "left"
    Then The subtitle should align to "left"
    And Select alignment of sub title to "center"
    Then The subtitle should align to "center"
    And Select alignment of sub title to "right"
    Then The subtitle should align to "right"

  @PieVisual
  Scenario: TC_Pie_187:Edit Pie - Title - Verify expanding and collapsing the title and subtitle sections
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Expand the Title section
    Then The section should be expnaded
    And Collapse the Title section
    Then The section should be collapsed
    And Expand the Sub-title section
    Then The Sub-title section should be expnaded
    And Collapse the Sub-title section
    Then The Sub-title section should be collapsed

  @PieVisual
  Scenario: TC_Pie_188:Edit Pie - Title - Verify closing of Titles popup
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on cogwheel icon for title
    And Click on X icon to close the popup
    Then The "Title" popup should be closed

  @PieVisual
  Scenario: TC_Pie_189:Edit Pie - Verify Copyright=Check
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check Copyright and Save
    Then The Copyright logo should be displayed for visual

  @PieVisual
  Scenario: TC_Pie_190:Edit Pie - Verify Copyright=Uncheck
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And UnCheck Copyright
    Then The Copyright logo should be removed for visual

  @PieVisual
  Scenario: TC_Pie_191:Edit Pie - Copyright - Verify 'Vertical align
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Select vertical align as "top" and save
    Then The copyright should be displayed in top
    And Select vertical align as "bottom" and save
    Then The copyright should be displayed in bottom

  @PieVisual
  Scenario: TC_Pie_192:Edit Pie -Copyright - Verify 'Vertical align' for middle
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Open drop down for "Copyright"
    Then The middle align option should be disabled since cannot show in the middle of the table

  @PieVisual
  Scenario: TC_Pie_193:Edit pie - Copyright - Verify 'Horizontal align'
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Select Horizontal alignment of copyright to "left" and save
    Then The copyright image should align to "Left"
    And Select Horizontal alignment of copyright to "center" and save
    Then The copyright image should align to "Center"
    And Select Horizontal alignment of copyright to "right" and save
    Then The copyright image should align to "Right"

  @PieVisual
  Scenario: TC_Pie_194:Edit pie - Copyright - Verify advance settings cogwheel
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    Then "Copyright" popup should be displayed

 @PieVisual
  Scenario: TC_Pie_195:Edit pie - Copyright - Verify text=check
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button from copyright popup and Save
    Then Copyright text "Source: CEIC Data" should be displayed on visual

 @PieVisual
  Scenario: TC_Pie_196:Edit pie - Copyright - Verify text change for copyright
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button and Edit the text as "CDMNext" and Save
    Then Updated copyright "CDMNext" should be displayed on visual

 @PieVisual
  Scenario: TC_Pie_197:Edit pie - Copyright - Verify link for copyright
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button from copyright popup and Save
    And Click on the Copyright
    Then "Copyright" popup should be displayed

  #Then The user should redirect to "https://www.ceicdata.com/en" link
 @PieVisual
  Scenario: TC_Pie_198:Edit pie - Copyright -Verify copyright color
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select color for "Copyright"
    When Click on "Save"
    Then Visual "Copyright" should be displayed in selected color

 @PieVisual
  Scenario: TC_Pie_199:Edit pie - Copyright - Verify font size
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select size for visual "Copyright" as "20"
    When Click on "Save"
    Then The "Copyright" font size should be changed as "20"

 @PieVisual
  Scenario: TC_Pie_200:Edit pie - Copyright - Verify bold style
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Bold icon for "Copyright"
    When Click on "Save"
    Then The "Copyright" should be displayed in Bold format

 @PieVisual
  Scenario: TC_Pie_201:Edit pie - Copyright - Verify Italic style
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Italic icon
    When Click on "Save"
    Then The "Copyright" should be "italic"

 @PieVisual
  Scenario: TC_Pie_202:Edit pie - Copyright - Verify Underline style
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Underline icon for "Copyright"
    When Click on "Save"
    Then The "Copyright" should be "underline"

  @PieVisual
  Scenario: TC_Pie_203:Edit pie - Copyright - Verify horizontal alignment (left, right, center)
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select Horizontal alignment of copyright to "left" and save
    Then The copyright image should align to "Left"
    And Select Horizontal alignment of copyright to "center" and save
    Then The copyright image should align to "Center"
    And Select Horizontal alignment of copyright to "right" and save
    Then The copyright image should align to "Right"

  @PieVisual
  Scenario: TC_Pie_204:Edit Table - Copyright - Verify vertical alignment (Top and bottom).
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select vertical align as "top" and save
    Then The copyright should be displayed in top
    And Select vertical align as "bottom" and save
    Then The copyright should be displayed in bottom

  @PieVisual
  Scenario: TC_Pie_205:Edit pie - Copyright - Verify closing copyright popup
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Click on X icon to close the popup
    Then The "Copyright" popup should be closed

  @PieVisual
  Scenario: TC_Pie_206:Edit Pie - tooltips - Verify the list of date formats
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    Then The following list of dates format should be opened
      | Date                 |
      | Value                |
      | Name                 |
      | Region               |
      | Frequency            |
      | Function description |
      | Percentage           |

  @PieVisual
  Scenario: TC_Pie_207:Edti pie - tooltip dropdown default display
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    Then "Date +1" value should be displayed as default

  @PieVisual
  Scenario Outline: <TCID>:Edit Pie - <ActualAttribute> tooltip for pie visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Select "<ActualAttribute>" field
    Then The Tooltip default value should be changed to "Date +2" and tooltips of visual should include with "<ExpectedAttribute>" of series

    Examples: 
      | TCID       | ActualAttribute      | ExpectedAttribute    |
      | TC_Pie_208 | Name                 | Name                 |
      | TC_Pie_209 | Region               | Region               |
      | TC_Pie_210 | Frequency            | Frequency            |
      | TC_Pie_211 | Percentage           | Percentage           |
      | TC_Pie_212 | Function description | Function description |

  @PieVisual
  Scenario: TC_Pie_209:Edit pie - Region tooltip for pie visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Select "Region" field
    Then The Tooltip default value should be changed to "Date +2" and tooltips of visual should include with "Region" of series

  @PieVisual
  Scenario: TC_Pie_210:Edit pie - Frequency tooltip for pie visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Select "Frequency" field
    Then The Tooltip default value should be changed to "Date +2" and tooltips of visual should include with "Frequency" of series

  @PieVisual
  Scenario: TC_Pie_212:Edit pie - Function description tooltip for pie visual
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Pie" visual
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Select "Function description" field
    Then The Tooltip default value should be changed to "Date +2" and tooltips of visual should include with "Function description" of series

  @PieVisual
  Scenario: TC_Pie_212:Edit pie - percentage tooltip for pie visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Select "Percentage" field
    Then The Tooltip default value should be changed to "Date +2" and tooltips of visual should include with "Percentage" of series

  @PieVisual
  Scenario: TC_Pie_213:Edit pie > tooltip dropdown > advanced settings
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    Then The following items should be available
      | Common |
      | Items  |

  #| Border |
  @PieVisual
  Scenario: TC_Pie_214:Edit pie > tooltip dropdown > advanced settings > Common
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    Then "Show tooltips" should be checked by default

  @PieVisual
  Scenario: TC_Pie_215:Edit pie > tooltip dropdown > advanced settings > Common
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    And UnCheck "Show tooltips"
    And Click on "Save"
    And Tooltips for visual should not be shown

  @PieVisual
  Scenario: TC_Pie_216:Edit pie > tooltip dropdown > advanced settings > items
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    Then The following list of items should be opened
      | Name                 |
      | Region               |
      | Frequency            |
      | Function description |
      | Percentage           |

  @PieVisual
  Scenario Outline: <TCID>:Edit pie > tooltip dropdown > advanced settings > items
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Select items as "<ActualItem>" from dropdown
    And Click on "Save"
    Then "<ExpectedItem>" attribute should get added in tooltips

    Examples: 
      | TCID       | ActualItem | ExpectedItem |
      | TC_Pie_217 | Name       | Name         |
      | TC_Pie_218 | Region     | Region       |
      | TC_Pie_219 | Frequency  | Frequency    |
      | TC_Pie_220 | Percentage | Percentage   |

  @PieVisual
  Scenario: TC_Pie_221:Edit pie > tooltip dropdown > advanced settings > items > Function description
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Pie" visual
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Select items as "Function description" from dropdown
    And Click on "Save"
    Then "Function description" attribute should get added in tooltips

  @PieVisual
  Scenario: TC_Pie_222:Edit pie > tooltip dropdown > advanced settings > items > Verify text color in tooltip
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Select color for "Items"
    When Click on "Save"
    Then "tooltip text" should be displayed in selected color

  @PieVisual
  Scenario: TC_Pie_223:Edit pie > tooltip dropdown > advanced settings > items > Verify font size
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Open date dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Select font size as "18"
    When Click on "Save"
    Then Size of tooltips should get changed as "18"

  #@PieVisual(https://securities.jira.com/browse/CVISION-20015)
  #Scenario: TC_Pie_224:Edit pie > tooltip dropdown > advanced settings > items > Verify bold style
  #And Create a pie visual with series id's "16240301;16243001"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Items"
  #And Click on Bold icon for "Items"
  #When Click on "Save"
  #Then Tooltip text should turn into "Bold" format
  #
  #@PieVisual
  #Scenario: TC_Pie_225:Edit pie > tooltip dropdown > advanced settings > items > Verify Italic style
  #And Create a pie visual with series id's "16240301;16243001"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Items"
  #And Click on "Italic" icon for items
  #When Click on "Save"
  #Then Tooltip text should turn into "Italic" format
  #
  #@PieVisual
  #Scenario: TC_Pie_226:Edit pie > tooltip dropdown > advanced settings > items > Verify underline style
  #And Create a pie visual with series id's "16240301"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Items"
  #And Click on "Underline" icon for items
  #When Click on "Save"
  #Then Tooltip text should turn into "Underline" format
  #
  #@PieVisual
  #Scenario: TC_Pie_227:Edit pie > tooltip dropdown > advanced settings > items > Verify unbold format
  #And Create a pie visual with series id's "16240301;16243001"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Items"
  #And Click on "Bold" icon for items
  #And Click on same
  #When Click on "Save"
  #Then Tooltip text should turn into "Unbold" format
  #
  #@PieVisual
  #Scenario: TC_Pie_228:Edit pie > tooltip dropdown > advanced settings > items > Verify non Italic style
  #And Create a pie visual with series id's "16240301;16243001"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Items"
  #And Click on "Italic" icon for items
  #And Click on same
  #When Click on "Save"
  #Then Tooltip text should turn into "NonItalic" format
  #
  #@PieVisual
  #Scenario: TC_Pie_229:Edit pie > tooltip dropdown > advanced settings > items > Verify non underlined style
  #And Create a pie visual with series id's "16240301;16243001"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Items"
  #And Click on "Underline" icon for items
  #And Click on same
  #When Click on "Save"
  #Then Tooltip text should turn into "NonUnderlined" format
  #
  #@PieVisual
  #Scenario: TC_Pie_230:Edit pie - Tooltip - Verify color for tooltip border
  #And Create a pie visual with series id's "16240301;16243001"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Border"
  #And Select color for "tooltip border"
  #And Click on "Save"
  #Then Border of tooltip should be applied with selected color
  #
  #@PieVisual
  #Scenario: TC_Pie_231:Edit pie - Tooltip - Verify border width
  #And Create a pie visual with series id's "16240301;16243001"
  #And Click on "Edit Pie"
  #And Check "Tooltips"
  #And Open date dropdown
  #And Click on "Advanced settings"
  #And Expand "Border"
  #And Select Width to 5
  #And Click on "Save"
  #Then The tooltp border width should be changed as "5"
  @PieVisual
  Scenario: TC_Pie_232:Edit pie > Verify size of visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    Then The default Edit Visual popup height and width should be "100%"

  @PieVisual
  Scenario: TC_Pie_233:Edit pie > Verify horizontal alignement for size
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Open Size dropdown
    Then The "Horizontal align" should be disabled if proportion is "100%"

  @PieVisual
  Scenario: TC_Pie_234:Edit pie > Verify proportion for size
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Open Size dropdown
    Then X axis should be set to "100" with enable state & Y axis should be set to "100" with disable state

  @PieVisual
  Scenario: TC_Pie_235:Edit pie > - Size - Verify Horizontal align for visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Open Size dropdown
    And Reduce proportion to 80
    And Click on Horizontal align of visual to "Left"
    Then The Visual area should align to "Left"
    And Click on Horizontal align of visual to "Center"
    Then The Visual area should align to "Center"
    And Click on Horizontal align of visual to "Right"
    Then The Visual area should align to "Right"

  @PieVisual
  Scenario: TC_Pie_236:Edit pie > legend
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    Then "Legend" should be checked by default

  @PieVisual
  Scenario: TC_Pie_237:Edit pie > legend dropdown
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on legend dropdown
    Then The following legend options should be available
      | Vertical align    |
      | Horizontal align  |
      | Advanced settings |

  @PieVisual
  Scenario: TC_Pie_238:Edit pie > legend > advanced settings under dropdown
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    Then The following options should be available
      | Common     |
      | Items      |
      | Size       |
      | Title      |
      | Background |
      | Border     |

  @PieVisual
  Scenario: TC_Pie_239:Edit pie > legend > advanced settings under dropdown > show legend
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    Then "Show legend" should be checked by default

  @PieVisual
  Scenario: TC_Pie_240:Edit pie > legend > advanced settings under dropdown > items color
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Items" section from Legand popup should expand
    And Select color for "Items"
    #And Select "#2b60d0" legend color from list
    When Click on "Save"
    Then The Selected "Color" should reflect in the pie visual legand

  @PieVisual
  Scenario: TC_Pie_241:Edit pie > legend > advanced settings under dropdown > items size
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Select font size as "18"
    When Click on "Save"
    Then Size of legend should get changed as "18"

  @PieVisual
  Scenario: TC_Pie_242:Edit pie > legend > advanced settings under dropdown > items  > verify bold stayle
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Click on Bold icon for "Items"
    When Click on "Save"
    Then The "items" should be displayed in Bold format

  @PieVisual
  Scenario: TC_Pie_243:Edit pie > legend > advanced settings under dropdown > items > verify italic style
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Click on "Italic" icon for items
    When Click on "Save"
    Then Legend text should turn into "Italic" format

  @PieVisual
  Scenario: TC_Pie_244:Edit pie > legend > advanced settings under dropdown > items > verify underline style
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Items"
    And Click on "Underline" icon for items
    When Click on "Save"
    Then Legend text should turn into "Underline" format

  @PieVisual
  Scenario: TC_Pie_244:Edit pie > legend > advanced settings under dropdown > Title
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Title"
    Then By default title options are disabled
    And Check legend "Title"
    Then Should enable the legend options

  @PieVisual
  Scenario: TC_Pie_245:Edit pie > legend > advanced settings under dropdown > Title color
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Title"
    And Check legend "Title"
    And Enter the text "Shravas" for legend title
    And Select color for "Legend"
    When Click on "Save"
    Then Legend "title" should be displayed in selected color

  @PieVisual
  Scenario: TC_Pie_246:Edit pie > legend > advanced settings under dropdown > Title-Font size
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Title"
    And Check the checkbox for "Title" section
    And Enter the text "Shravas" for legend title
    And Select "Legend Title font size" for chart visual to 16
    Then The Selected "Font size" should reflect in the chart visual legand

  @PieVisual
  Scenario: TC_Pie_247:Edit pie > legend > advanced settings under dropdown > Title-Font style
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And Expand "Title"
    And Check the checkbox for "Title" section
    And Enter the text "Shravas" for legend title
    And Select any "Legends Style" for chart visual
    Then The Selected "Font style" should reflect in the chart visual legand

  @PieVisual
  Scenario: TC_Pie_248:Edit pie > legend > advanced settings under dropdown > Background color
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Background" section from Legand popup should expand
    And Check the checkbox for "Background" section
    And Select background color for legend
    When Click on "Save"
    Then The Selected "Background color" should reflect in the visual legand

  @PieVisual
  Scenario: TC_Pie_249:Edit pie > legend > advanced settings under dropdown > Border color
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Border" section from Legand popup should expand
    And Check the checkbox for "Border" section
    And Select border color for legend
    When Click on "Save"
    Then The Selected "Border color" should reflect in the pie visual legand

  @PieVisual
  Scenario: TC_Pie_250:Edit pie > legend > advanced settings under dropdown > Border width
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Border" section from Legand popup should expand
    And Check the checkbox for "Border" section
    And Select "Legend Title Border Width" for chart visual to 3
    Then The Selected "Border width" should reflect in the chart visual legand

  @PieVisual
  Scenario: TC_Pie_251:Edit pie > legend > advanced settings under dropdown > Border radius
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on legend dropdown
    And Click on "Advanced settings"
    And "Border" section from Legand popup should expand
    And Check the checkbox for "Border" section
    And Select "Legend Title Border Radius" for chart visual to 8
    Then The Selected "Border radius" should reflect in the chart visual legand

  @PieVisual
  Scenario: TC_Pie_252:Edit pie > legend > advanced settings icon
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Advanced settings icon
    Then Visual popup should be opened
    Then The following options should be available
      | Common     |
      | Items      |
      | Size       |
      | Title      |
      | Background |
      | Border     |

  @PieVisual
  Scenario: TC_Pie_253:Edit pie > Data labels
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    Then "Data labels" should be checked by default

  @PieVisual
  Scenario: TC_Pie_254:Edit pie > Data labels > advanced settings > Show labels
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on Advanced settings icon for Data labels
    Then "Show labels" should be checked by default

  @PieVisual
  Scenario: TC_Pie_255:Edit pie > Data labels > advanced settings > labels >attributes popup
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Advanced settings icon for Data labels
    And Expand "Labels" section from "Labels" popup
    And Select attributes "Name" and "Percentage"
    Then Selected attributes should be displayed along with percentage attribute for visual

  @PieVisual
  Scenario: TC_Pie_256:Edit pie > Data labels > advanced settings > labels > color
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Advanced settings icon for Data labels
    And Expand "Labels" section from "Labels" popup
    And Select data label "color" from the list
    And Select the color for Labels
    And Clicking "Save" option
    Then Selected color should be applied for visuals

  @PieVisual
  Scenario: TC_Pie_257:Edit pie > Data labels > advanced settings > labels > highlight
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Advanced settings icon for Data labels
    And Expand "Labels" section from "Labels" popup
    And Select data label "highlight" from the list
    And Select the Highlight color for label
    And Clicking "Save" option
    Then Selected highlight color for labels should be shown

  @PieVisual
  Scenario: TC_Pie_258:Edit pie > Data labels > advanced settings > labels > size
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Advanced settings icon for Data labels
    And Expand "Labels" section from "Labels" popup
    And Select "Data Labels font size" for chart visual to 18
    And Clicking "Save" option
    Then The Selected "Font size" should be applied

  @PieVisual
  Scenario: TC_Pie_259:Edit pie > Data labels > advanced settings > labels > styles
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Advanced settings icon for Data labels
    And Expand "Labels" section from "Labels" popup
    And Select any "Data Labels Style" for chart visual
    And Clicking "Save" option
    Then The Selected "Font Style" should be updated

  @PieVisual
  Scenario: TC_Pie_260:Edit pie > Data labels > advanced settings > labels > position
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Click on Advanced settings icon for Data labels
    And Expand "Labels" section from "Labels" popup
    Then "Outside" should be default position
    And Change its position to "Inside"
    Then Position "Inside" should be displayed

  @PieVisual
  Scenario Outline: TC_Pie_261:Edit Pie - Tooltip - Verify grouping and decimal under number separators
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Click on Number format dropdown
    And Select <decimal> and <group> separator from dropdown list
    And Click on "Save"
    Then The Selected Decimal seperator and Grouping seperator should be updated with selected input

    Examples: 
      | decimal | group   |
      | ","     | "."     |
      | ","     | "Space" |
      | ","     | "'"     |
      | ","     | "-"     |
      | ","     | "None"  |
      | "."     | ","     |
      | "."     | "Space" |
      | "."     | "'"     |
      | "."     | "-"     |
      | "."     | "None"  |

  @PieVisual
  Scenario: TC_Pie_262:Edit pie > number format dropdown > decimal places
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Check "Tooltips"
    And Click on Number format dropdown
    And Select "4" separator from "Decimal places" dropdown
    And Clicking "Save" option
    Then The Selected "Decimal Places" should be updated with selected input

  @PieVisual
  Scenario: TC_Pie_263:Edit pie > position
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    Then "Outside" should be default position
    And Change its position to "Inside"
    Then Position "Inside" should be displayed

  @PieVisual
  Scenario: TC_Pie_264:Edit Pie - Verify the changes reflected in edit visual
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And Uncheck copyright attribute
    Then The copyright logo should be removed in the edit visual popup

  @PieVisual
  Scenario: TC_Pie_265:Edit Pie - Verify title icon on visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Mouse hover on visual title for Edit visual popup
    And Click on edit icon for Edit visual popup
    Then The "Titles" popup should be appeared

  @PieVisual
  Scenario: TC_Pie_266:Edit Pie -  Verify titles popup open by double clicking on visual title
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Edit Pie"
    And Click on the visual title
    Then The "Titles" popup should be appeared

  @PieVisual
  Scenario: TC_Pie_267: Edit Pie - Verify date field
    And Create a pie visual with series id's "296237202;408940397"
    And Click on "Edit Pie"
    And Click on date filed in edit visual
    Then Date popup should be displayed
    And Select date as "2011" in edit visual popup
    Then Selected date should be applied to the edit visual

  @PieVisual
  Scenario: TC_Pie_268: Edit Pie - Verify double clicking on timepoints
    And Create a pie visual with series id's "408940397;408929327"
    And Click on "Edit Pie"
    And Double click on timepoints in the edit visual
    Then The Labels popup should be displayed
    And Choose highlight color is Orange
    Then The label color should update as Orange in the edit visual

  @PieVisual
  Scenario: TC_Pie_269: Edit pie - Verify clicking on series name
    And Create a pie visual with series id's "408940397"
    And Click on "Edit Pie"
    And Click on Series name
    Then The SSP window should be displayed

  @PieVisual
  Scenario: TC_Pie_270:Edit pie - Verify Rename series icon
    And Create a pie visual with series id's "408940397"
    And Click on "Edit Pie"
    And Click on cogwheel icon
    And Click on "Rename"
    Then "Rename" popup should be displayed for selected series

  @PieVisual
  Scenario: TC_Pie_271:Edit pie - Verify Frequency option under edit series.
    And Create a pie visual with series id's "408940397"
    And Click on "Edit Pie"
    And Click on cogwheel icon
    And Select "Frequency" as "Monthly (Replicate)"
    Then Selected function should be applied to the series

  @PieVisual
  Scenario: TC_Pie_272:Edit pie - Verify Currency option under edit series.
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on cogwheel icon
    And Select "Currency" as "RMB"
    Then Selected currency should be applied to the series

  @PieVisual
  Scenario: TC_Pie_273:Edit pie - Verify Change option under edit series.
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on cogwheel icon
    And Select "Change" as "% Year-over-Year (%YoY)"
    Then Selected change function should be applied to the series

  @PieVisual
  Scenario: TC_Pie_274:Edit pie - Verify Remove series icon.
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on Remove series
    Then The series should be removed from the edit visual

  @PieVisual
  Scenario: TC_Pie_275:Edit pie - Verify selecting another visual from visual panel
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Select any visual from visual panel
    And Click on "Save"
    Then The visual should be converted as user selected

  @PieVisual
  Scenario: TC_Pie_276:Edit pie - Verify selecting another visual from visual panel
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on visual panel dropdown
    And Select "Histogram" visual
    And Click on "Save"
    Then The visual should be converted as user selected

  @PieVisual
  Scenario: TC_Pie_277:Edit pie - Edit series - Verify delete series icon
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on x icon for a series
    Then The series should be removed from visual and edit series panel

  @PieVisual
  Scenario: TC_Pie_278:Edit pie - Edit series - Verify SSP by clicking on series name.
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on Series
    Then SSP popup should be displayed

  @PieVisual
  Scenario: TC_Pie_279:Edit pie - Edit series - Verify Rename series icon
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Rename series" icon
    Then "Rename" popup should be displayed for selected series

  @PieVisual
  Scenario: TC_Pie_280:Edit pie - Edit series - Verify Rename option under settings icon.
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Edit series" icon
    And Select "Rename"
    Then "Rename" popup should be displayed for selected series

  @PieVisual
  Scenario: TC_Pie_281:Edit pie - Edit series - Verify Frequency option under edit series
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Edit series" icon
    And Select "Frequency" as "Yearly (Sum)"
    Then Selected function should be applied to the series

  @PieVisual
  Scenario: TC_Pie_282:Edit pie - Edit series - Verify Color option under edit series
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Edit series" icon
    And Select "Color" as "Orange"
    Then Selected color should be applied to the series

  @PieVisual
  Scenario: TC_Pie_283:Edit pie - Edit series - Verify currency option under edit series
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Edit series" icon
    And Select "Currency" as "RMB"
    Then Selected currency should be applied to the series

  @PieVisual
  Scenario: TC_Pie_284:Edit pie - Edit series - Verify change option under edit series
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Edit series" icon
    And Select "Change" as "% Year-over-Year (%YoY)"
    Then Selected change function should be applied to the series

  @PieVisual
  Scenario: TC_Pie_285:Edit pie - Edit series -Verify clicking on frequency or dropdown
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    Then "Series Harmonization" popup should be opened

  @PieVisual
  Scenario: TC_Pie_286:Edit pie - Edit series - Series data conversion - Verify applying frequency
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    And Select "Frequency" as "Daily" from dropdown
    And Click on "Apply"
    Then The selected frequency should be applied to available series

  @PieVisual
  Scenario: TC_Pie_287:Edit pie - Edit series - Series data conversion - Verify applying Missing values method
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    And Select "Frequency" as "Daily" from dropdown
    And Select "Missing values method" as "Next value" from dropdown
    Then Missing values method should be applied with selected frequency

  @PieVisual
  Scenario: TC_Pie_288:Edit pie - Edit series - Series data conversion -Minimize option
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    And Click on "Minimize" option
    Then The Series Hormonization popup should be minimized

  @PieVisual
  Scenario: TC_Pie_289:Edit pie - Edit series - Series data conversion -Verify maximize option
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The Series Hormonization popup should be maximized

  @PieVisual
  Scenario: TC_Pie_290:Edit pie - Edit series - Series data conversion -verify full screen
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    And Click on "Full-screen" option
    Then The Series Hormonization popup should be displayed in full screen

  @PieVisual
  Scenario: TC_Pie_291:Edit pie - Edit series - Series data conversion -verify exit full screen
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The Series Hormonization popup should be displayed in normal screen

  @PieVisual
  Scenario: TC_Pie_292:Edit pie - Edit series - Series data conversion -Verify Cancel/x icon
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Frequency"
    And Click on Cancel button
    Then The Series Hormonization popup should be closed

  @PieVisual
  Scenario: TC_Pie_293:Edit pie - Edit series - Verify dropdown for frequency in series level
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on frequency dropdown
    Then List of frequenceies should be available

  @PieVisual
  Scenario: TC_Pie_294:Edit pie - Edit series - Verify applying frequency in series level
    And Create a pie visual with series id's "272965603;273074003"
    And Click on "Edit Pie"
    And Click on frequency dropdown
    And Select frequence as "Yearly (Sum)"
    Then Selected frequency should be displayed in the series

  @PieVisual
  Scenario: TC_Pie_295:Edit pie - Edit series - Verify applying currency in series level
    And Create a pie visual with series id's "272965603;273074003"
    And Click on "Edit Pie"
    And Click on currency dropdown
    And Select currency as "USD"
    Then Selected currency should be displayed in the series

  @PieVisual
  Scenario: TC_Pie_296:Edit pie - Edit series - Verify clicking on type a function field
    And Create a pie visual with series id's "272965603;273074003"
    And Click on "Edit Pie"
    And Click on type a function field in series level
    Then List of functions dropdown should be opened

  @PieVisual
  Scenario: TC_Pie_297:Edit pie - Edit series - Verify applying function in series level
    And Create a pie visual with series id's "272965603;273074003"
    And Click on "Edit Pie"
    And Click on type a function field in series level
    And Select a function
    And Click on "Apply function"
    Then The selected function should be applied to the series

  @PieVisual
  Scenario: TC_Pie_298:Edit pie - Edit series - Verify cancel icon for selected function
    And Create a pie visual with series id's "272965603;273074003"
    And Click on "Edit Pie"
    And Click on type a function field in series level
    And Select a function
    And Click on cancel function icon
    Then The selected function should be cancelled

  @PieVisual
  Scenario: TC_Pie_299:Edit Pie - Edit series - Verify multiple functions apply
    And Create a pie visual with series id's "272965603;273074003"
    And Click on "Edit Pie"
    And Click on type a function field in series level
    And Select multiple functions
    And Click on "Apply function"
    Then The selected functions should be applied to the series

  @PieVisual
  Scenario: TC_Pie_300:Edit Pie - Edit  series - Verify removing applied functions
    And Create a pie visual with series id's "272965603;273074003"
    And Click on "Edit Pie"
    And Click on type a function field in series level
    And Select a function
    And Click on "Apply function"
    And Click on cancel function icon
    Then The function should be removed from the series

  @PieVisual
  Scenario: TC_Pie_301:Edit Pie - Edit series - Verify applying invalid function for series
    And Create a pie visual with series id's "210698402"
    And Click on "Edit Pie"
    And Click on type a function field in series level
    And Select an invalid function
    And Click on "Apply function"
    Then "The function cannot be applied to selected series" popup should be displayed

  @PieVisual
  Scenario: TC_Pie_302:Edit Pie - Edit seires - Verify OK button on "The function cannot be applied to selected series" popup
    And Create a pie visual with series id's "210698402"
    And Click on "Edit Pie"
    And Click on type a function field in series level
    And Select an invalid function
    And Click on "Apply function"
    And Click on "Ok"
    Then The function cannot be applied to selected series popup should be closed

  @PieVisual
  Scenario: TC_Pie_303:Edit Pie - Edit series - Verify 'Type a function' field
    And Create a pie visual with series id's "272965603"
    And Click on Edit series option
    And Click on type a function field
    And Select any function
    And Click on "Apply"
    Then The selected function should be displayed

  @PieVisual
  Scenario: TC_Pie_304:Edit Pie - Edit series - Verify Region, Unit and Series ID fields
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    Then "Region", "Unit" and "Series id" fields should be available for respective series

  @PieVisual
  Scenario: TC_Pie_305:Edit Pie - Verify feedback option
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Feedback" option
    Then "Still cannot find an answer?" popup should be displayed

  @PieVisual
  Scenario: TC_Pie_306:Edit Pie -  Feedback - Verify description for popup
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Feedback" option
    Then The description should be "Do you need any additional features? Please send us your feedback for product enhancements."

  @PieVisual
  Scenario: TC_Pie_307:Edit Pie - Feedback - Verify Submit and cancel buttons when description field is empty
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Feedback" option
    Then Submit and Cancel buttons should be disabled by default

  @PieVisual
  Scenario: TC_Pie_308:Edit Pie - Feedback - Verify cancel button
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Feedback" option
    And Enter text in description field
    And Click on cancel button
    Then The feedback popup should be closed

  @PieVisual
  Scenario: TC_Pie_309:Edit Pie - Feedback - Verify growl message after  Submit feedback
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Feedback" option
    And Enter text in description field
    And Click on submit button
    Then "Thank you for submitting a question to us." message should be displayed in a growl popup

  @PieVisual
  Scenario: TC_Pie_310:Edit Pie - Verify cancel/x button
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Click on "Cancel" button
    Then The edit visual popup should be closed

  @PieVisual
  Scenario: TC_Pie_311:Edit Pie - Verify save button
    And Create a pie visual with series id's "272965603"
    And Click on "Edit Pie"
    And Change title in edit visual window
    And Click on "Save" button
    Then The changes should be reflected to histogram visual and Edit visual popup should be closed

  @PieVisual
  Scenario: TC_Pie_312:Verify add to insight option
    And Create a pie visual with series id's "16240301;16243001"
    And Click on + icon on header
    Then Below options should be displayed
      | Add to new tab     |
      | Add to new insight |

  @PieVisual
  Scenario: TC_Pie_313:Add to insight - Verify 'Add to new tab' option under Add to insight
    And Create a pie visual with series id's "16240301;16243001"
    And Click on + icon on header
    And Click on "Add to new tab"
    Then The Pie visual should be created in vew tab on current insight

  @PieVisual
  Scenario: TC_Pie_314:Add to insight - Verify confirmation message for adding visual to new insight
    And Create a pie visual with series id's "16240301;16243001"
    And Click on + icon on header
    And Click on "Add to new insight"
    Then "New insight with the selected visual created" and "Go to new insight" confirmation message should be displayed

  @PieVisual
  Scenario: TC_Pie_315:Add to insight - Validate the added visual by opening new insight
    And Create a pie visual with series id's "16240301;16243001"
    And Click on + icon on header
    And Click on "Add to new insight"
    And Click on "Go to new insight"
    Then The new insight should be opened and added visual should be available in My visual

  @PieVisual
  Scenario: TC_Pie_316:Copy - Verify confirmation message for copy visual
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Copy" icon
    Then "Pie with series copied." and "More options" confirmation message should be displayed

  @PieVisual
  Scenario: TC_Pie_317:Copy - Validate copied visual by pasting with in the insight
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Copy" icon
    And Paste within the insight
    Then The visual should be pasted in the insight

  @PieVisual
  Scenario: TC_Pie_318:Copy - Validate copied visual by pasting to new insight
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Copy" icon
    And Paste to new insight
    Then The visual should be pasted to new insight

  @PieVisual
  Scenario: TC_Pie_319:Copy - Verify the confrimation message for pasting visual in insight
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Copy" icon
    And Paste within the insight
    Then "Data pasted from clipboard" message should be displayed

  @PieVisual
  Scenario: TC_Pie_320:Download - Verify Download option
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Download icon
    Then Download popup should be appeared

  @PieVisual
  Scenario: TC_Pie_321:Download - Verify pie visual download with excel format
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Download icon
    And Select "xlsx" format
    And Click on "Download"
    Then Pie visual and related series should be downloaded in excel

  @PieVisual
  Scenario: TC_Pie_322:Download - Verify pie visual download with PDF format
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Download icon
    And Select "pdf" format
    And Click on "Download"
    Then Pie visual should be downloaded in PDF format

  @PieVisual
  Scenario: TC_Pie_323:Download - Verify pie visual download with PNG format
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Download icon
    And Select "png" format
    And Click on "Download"
    Then Pie visual should be downloaded in PNG format

  @PieVisual
  Scenario: TC_Pie_324:Download - Verify pie visual download with JPG format
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Download icon
    And Select "jpeg" format
    And Click on "Download"
    Then Pie visual should be downloaded in JPG format

  @PieVisual
  Scenario: TC_Pie_325:Download - Verify size for JPG/PNG download
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Download icon
    And Select "jpeg" format
    And Select width size "589"
    And Click on "Download"
    Then The visual should be downloaded with selected size

  @PieVisual
  Scenario: TC_Pie_326:Verify Open option.
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Open icon
    Then The visual should be displayed in maximized window

  @PieVisual
  Scenario: TC_Pie_327:Verify closing of maximized window.
    And Create a pie visual with series id's "16240301;16243001"
    And Click on Open icon
    And Click on x icon to close
    Then The modal window should be closed

  @PieVisual
  Scenario: TC_Pie_328:Verify Delete pie
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "delete"
    Then "Confirmation" popup should be dispalyed

  @PieVisual
  Scenario: TC_Pie_329:Right click - Validate copied pie
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Copy pie chart"
    And Paste in insight
    Then Pie visual should be pasted

  @PieVisual
  Scenario: TC_Pie_330:Right click - Verify Cut pie
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Cut pie chart"
    Then Pie chart should be cut

  @PieVisual
  Scenario: TC_Pie_331:Right click - Validate Cut pie
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Cut pie chart"
    And Paste in insight
    Then Pie visual should be pasted

  @PieVisual
  Scenario: TC_Pie_332:Right click - Verify Delete pie
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Delete pie"
    Then Pie chart should be deleted

  @PieVisual
  Scenario: TC_Pie_333:Right click - Verify chart under insert visual
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Chart"
    Then "Chart" visual should be created in the same view tab

  @PieVisual
  Scenario: TC_Pie_334:Right click - Verify Pie under insert visual
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Pie"
    Then "Pie" visual should be created in the same view tab

  @PieVisual
  Scenario: TC_Pie_335:Right click - Verify table under insert visual
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Table"
    Then "Table" visual should be created in the same view tab

  @PieVisual
  Scenario: TC_Pie_336:Right click - Verify map under insert visual
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Map"
    Then "Map" visual should be created in the same view tab

  @PieVisual
  Scenario: TC_Pie_337:Right click - Verify Heat map under insert visual
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Heat map"
    Then "Heat map" visual should be created in the same view tab

  @PieVisual
  Scenario: TC_Pie_338:Right click - Verify Histogram under insert visual
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose Add chart as "Histogram"
    Then "Histogram" visual should be created in the same view tab

  #@PieVisual
  #Scenario: TC_Pie_339:Right click - Verify commentary under insert visual
    #And Create a pie visual with series id's "16240301;16243001"
    #And Right click on visual header
    #And Choose Add chart as "Commentary"
    #Then The commentary visual should be created in the same view tab
#
  #@PieVisual
  #Scenario: TC_Pie_340:Right click - Verify attachments under insert visual
    #And Create a pie visual with series id's "16240301;16243001"
    #And Right click on visual header
    #And Choose Add chart as "Attachments"
    #Then "Attachments" visual should be created in the same view tab
#
  #@PieVisual
  #Scenario: TC_Pie_341:Right click - Verify Image under insert visual
    #And Create a pie visual with series id's "16240301;16243001"
    #And Right click on visual header
    #And Choose Add chart as "Image"
    #Then "Image" visual should be created in the same view tab
#
  #@PieVisual
  #Scenario: TC_Pie_342:Right click - Verify Filter under insert visual
    #And Create a pie visual with series id's "16240301;16243001"
    #And Right click on visual header
    #And Choose Insert visual as "Filter"
    #Then "Filter" visual should be created in the same view tab

  @PieVisual
  Scenario: TC_Pie_343:Right click - Verify Paste visual
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Copy pie chart"
    And Again Right click on visual header
    And Choose "Paste visual"
    Then Copied visual should be pasted

  #@PieVisual
  #Scenario: TC_Pie_344:Right click - View as - Verify Chart
    #And Create a pie visual with series id's "16240301;16243001"
    #And Right click on visual header
    #And Select View as > "Chart"
    #Then The "Pie" visual should be converted as "Chart" visual
#
  #@PieVisual
  #Scenario: TC_Pie_345:Right click - View as - Verify Map
    #And Create a pie visual with series id's "16240301;16243001"
    #And Right click on visual header
    #And Select View as > "Map"
    #Then The "Pie" visual should be converted as "Map" visual
#
  #@PieVisual
  #Scenario: TC_Pie_346:Right click - View as - Verify Table
    #And Create a pie visual with series id's "16240301;16243001"
    #And Right click on visual header
    #And Select View as > "Table"
    #Then The "Pie" visual should be converted as "Table" visual
#
  #@PieVisual
  #Scenario: TC_Pie_347:Right click - View as - Verify Histogram
    #And Create a pie visual with series id's "16240301"
    #And Right click on visual header
    #And Select View as > "Histogram"
    #Then The "Pie" visual should be converted as "Histogram" visual

  @PieVisual
  Scenario: TC_Pie_348:Right click - View as - Verify Heat map
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Select View as > "Heat map"
    Then The "Pie" visual should be converted as "Heat map" visual

  @PieVisual
  Scenario: TC_Pie_349:Right click - Verify Calculated series sub dropdown
    And Create a pie visual with series id's "16240301"
    And Right click on visual header
    And Choose "Calculate series"
    And Select function "RMB"
    Then The function should be applied for the series

  @PieVisual
  Scenario: TC_Pie_350:Right click - Verify Edit series option
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Edit series"
    Then The edit series popup should be opened with "Pie" tab

  @PieVisual
  Scenario: TC_Pie_351:Right click - Verify Clear contents
    And Create a pie visual with series id's "16240301;16243001"
    And Right click on visual header
    And Choose "Clear contents"
    Then The content should be removed

  @PieVisual
  Scenario: TC_Pie_352:Right click - Verify reset format
    And Create a pie visual with series id's "16240301"
    And Click on "Edit Pie"
    And UnCheck Copyright
    Then The Copyright logo should be removed for visual
    And Right click on visual header
    And Choose "Reset format"
    Then The Copyright logo should be displayed for visual

  @PieVisual
  Scenario: TC_Pie_353:Right click - Verify reset format option if have no changes in visual
    And Create a pie visual with series id's "16240301"
    And Right click on visual header
    Then The Reset format option should be disabled

  @PieVisual
  Scenario: TC_Pie_354:Right click -  Verify download sub dropdown
    And Create a pie visual with series id's "16240301"
    And Right click on visual header
    And Choose "Download"
    Then "Pie" and "View" options should be displayed

  @PieVisual
  Scenario: TC_Pie_355:Right click -  Verify download > Pie
    And Create a pie visual with series id's "16240301"
    And Right click on visual header
    And Choose "Download"
    And Select Pie
    Then Download popup should be displayed with Pie tab selection

  @PieVisual
  Scenario: TC_Pie_356:Right click -  Verify download > View
    And Create a pie visual with series id's "16240301"
    And Right click on visual header
    And Choose "Download"
    And Select View
    Then Download popup should be displayed with views tab selection

  @PieVisual
  Scenario: TC_Pie_357:Verify the visual options if visual is not selected
    And Create a pie visual with series id's "16240301"
    And Unhighlight the visual
    Then The visual options should be hidden

  @PieVisual
  Scenario: TC_Pie_358:Verify applying function under download window for series of pie
    And Create a pie visual with series id's "16240301"
    And Click on Download icon
    And Select "series" tab
    And Apply any function inside the download window
    Then Applied functions should be shown in the header of download window

  @PieVisual
  Scenario: TC_Pie_359:Verify description for delete confirmation popup
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "delete"
    Then "Do you want to remove this visual?" popup should be dispalyed

  @PieVisual
  Scenario: TC_Pie_360:Verify OK button in delete confirmation popup
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "delete"
    And Click on "Ok"
    Then The visual should be deleted

  @PieVisual
  Scenario: TC_Pie_361:Verify Cancel/x icon in delete confirmation popup
    And Open preference dropdown
    And Clicking on "Ask me to confirm visual deletion" option under user preference to be "Check"
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "delete"
    And Click on "Cancel"
    Then The popup should be closed and delete visual process should be declined

  @PieVisual
  Scenario: TC_Pie_362:Verify 'Add related series' option
    And Create a pie visual with series id's "16240301;16243001"
    And Click on "Add related series"
    Then The series suggestion manager popup should be displayed

  @PieVisual
  Scenario: TC_Pie_363:Verify adding series from 'Series suggestion manager' popup
    And Create a pie visual with series id's "5823501"
    And Click on "Add related series"
    And Select a region as "Albania"
    Then The related series should be added to the visual

  @PieVisual
  Scenario: TC_Pie_364:Verify applying function under download window for series of pie
    And Create a pie visual with series id's "16240301"
    And Click on Download icon
    And Select "series" tab
    And Apply any function inside the download window
    And Click on "Download"
    Then Applied functions with created pie chart should be downloaded
