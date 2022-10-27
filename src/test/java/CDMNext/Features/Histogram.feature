Feature: Verifying Histogram Visual functionality

  #@Histogram
  #Scenario: TC_Histogram_01:Verify creating Histogram visual from View panel by drag and drop
    #And Go to View tab
    #And Drag and drop histogram visual to the page
    #Then Histogram should be inserted

  @Histogram
  Scenario: TC_Histogram_02:Verify creating Histogram visual from View panel by clicking on histogram icon
    And Go to View tab
    And Click on histogram visual icon
    Then Histogram should be inserted

  @Histogram
  Scenario: TC_Histogram_03:Verify histogram visual creating with function applied series
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select Histogram visual
    And Click on Edit series option
    Then The functions should be applied to the series

  @Histogram
  Scenario: TC_Histogram_04:Empty visual - Verify 'Edit histogram' button
    And Create a Histogram visual without selecting series
    Then The Edit histogram should be disabled

  @Histogram
  Scenario: TC_Histogram_05:Empty visual - Verify 'Edit series' option
    And Create a Histogram visual without selecting series
    And Click on Edit series option
    Then The Edit series panel should be opened

  @Histogram
  Scenario: TC_Histogram_06:Empty visual - Verify default tab for 'Edit series' option
    And Create a Histogram visual without selecting series
    And Click on Edit series option
    Then By deault user should redirect to "Add from My Series" tab

  @Histogram
  Scenario: TC_Histogram_07:Empty visual - Verify description message for empty visual if have series in My series
    And Add some series to my series
    And Create a Histogram visual without selecting series
    Then The "Histogram" and "Drag series here Or, Add from My Series" should be displayed

  @Histogram
  Scenario: TC_Histogram_08:Empty visual - Verify description message for empty visual if have NO series in My series
    And Create a Histogram visual without selecting series
    Then The "Histogram" and "Drag series here" should be displayed for empty visual

  @Histogram
  Scenario: TC_Histogram_09:Empty visual - Verify Histogram tab when no series added for visual
    And Create a Histogram visual without selecting series
    And Click on Edit series option
    And Choose "Histogram" tab
    Then The "There are no series for selected visual. Please add series from + Add from My Series." message should be displayed

  @Histogram
  Scenario: TC_Histogram_10:Empty visual - Verify "+ Add from My Series" option in edit series panel
    And Create a Histogram visual without selecting series
    And Click on Edit series option
    And Choose "Histogram" tab
    And Click on "+ Add from My Series"
    Then Should redirect to "+ Add from My Series" tab

  @Histogram
  Scenario: TC_Histogram_11:Empty visual - Verify Add from my series option
    And Add series to the my series tab
    And Create a Histogram visual without selecting series
    And Click on "Add from My Series"
    Then "Add from My Series" panel should be opened

  @Histogram
  Scenario: TC_Histogram_12:Empty visual - Verify adding series to empty visual
    And Add series to the my series tab
    And Create a empty visual 
    And Click on Edit series option
    And Choose series from  "+ Add from My Series"
    Then The series should be added to "histogram" with its data

  @Histogram
  Scenario: TC_Histogram_13:Edit series - Verify Edit series option for histogram visual
    And Create histogram visual with series
    And Click on Edit series option
    Then Edit series panel should be opened with "Histogram" tab

  @Histogram
  Scenario: TC_Histogram_14:Edit series - Verify series under histogram tab
    And Create histogram visual with series
    And Click on Edit series option
    Then Associated series should be available

  @Histogram
  Scenario: TC_Histogram_15:Edit series - Verify Rename option
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    Then The "Rename" popup should be displayed
	
#	 @Histogram
  #Scenario: TC_Histogram_16:Rename - verify number of selected series
    #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Rename" option
    #Then Number of selected series count should be shown on the rename popup header
#
  #@Histogram
  #Scenario: TC_Histogram_17:Rename - verify find field
    #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Rename" option
    #And Search for the series you want to rename
    #Then Result should be loaded for searched keyword
#
  #@Histogram
  #Scenario: TC_Histogram_18:Rename -  verify number of searched result
    #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Rename" option
    #And Search for the series you want to rename
    #Then The total number of matches result should be displayed in below the find field
#
  #@Histogram
  #Scenario: TC_Histogram_19:Rename - verify 'Replace' button
    #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Rename" option
    #And Search for the series you want to rename
    #And Enter keyword you want to replace with
    #And Click on Replace
    #Then The keyword should be replaced for selected series
#
  #@Histogram
  #Scenario: TC_Histogram_20:Rename - verify 'Replace All' button
    #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Rename" option
    #And Search for the series you want to rename
    #And Enter keyword you want to replace with
    #And Click on "Replace All"
    #Then All the available series should be replaced with the keyword

  @Histogram
  Scenario: TC_Histogram_21:Rename - Verify default selection for 'Edit series info' dropdown
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    Then By default "Name" should be selected in Edit series info dropdown

  @Histogram
  Scenario: TC_Histogram_22:Rename - Verify 'Name' selection
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    Then Series should be displayed by name

  @Histogram
  Scenario: TC_Histogram_23:Rename - Verify 'Function description' selection
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Histogram" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    Then The series should be displayed by function description

  @Histogram
  Scenario: TC_Histogram_24:Rename - verify function description selection without function apply
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    Then Empty row should be dispalyed

  @Histogram
  Scenario: TC_Histogram_25:Rename - Verify adding function description
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Histogram" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on "Apply"
    Then Should allowed to add function discription and should be updated in edit series panel

  @Histogram
  Scenario: TC_Histogram_26:Rename - Verify editing function description
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Histogram" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Edit function description
    And Click on "Apply"
    Then Should allowed to edit function discription and should be updated in edit series panel

  @Histogram
  Scenario: TC_Histogram_27:Rename - Function discription -Verify Apply original title icon behavior
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Histogram" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on '>' icon
    Then The changes should be revert to original series "function"

  @Histogram
  Scenario: TC_Histogram_28:Rename - Function discription - Verify "Apply original title for all series" icon
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Histogram" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Add function description
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "function"

  @Histogram
  Scenario: TC_Histogram_29:Rename - Function discription - Verify clicking on series name
    And Add series to the my series tab
    And Apply function for a series
    And Right click on series
    And Select "Histogram" visual
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Function description"
    And Click on series name
    Then The SSP window should be displayed

  @Histogram
  Scenario: TC_Histogram_30:Rename - Name - verify Editing series name
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on "Apply"
    Then Should able to edit the insight title and updated in visual series

  @Histogram
  Scenario: TC_Histogram_31:Rename - Name - Verify Apply original title icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on '>' icon
    Then The changes should be revert to original series "name"

  @Histogram
  Scenario: TC_Histogram_32:Rename - Name - Verify "Apply original title for all series" icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "name"

  @Histogram
  Scenario: TC_Histogram_33:Rename - Verify Region selection
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    Then Series should be displayed by Region

  @Histogram
  Scenario: TC_Histogram_34:Rename - Region - Verify Apply original region icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    And Click on '>' icon
    Then The changes should be revert to original series "region"

  @Histogram
  Scenario: TC_Histogram_35:Rename - Region - Verify "Apply original region for all series" icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "region"

  @Histogram
  Scenario: TC_Histogram_36:Rename - Rename region
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Region"
    And Edit series region
    Then The region should be renamed for the series

  @Histogram
  Scenario: TC_Histogram_37:Rename - unit - verify Editing series unit
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on "Apply"
    Then Should able to edit series unit and updated in visual series as per the changes

  @Histogram
  Scenario: TC_Histogram_38:Rename - unit - Verify Apply original unit icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on '>' icon
    Then The changes should be revert to original series "unit"

  @Histogram
  Scenario: TC_Histogram_39:Rename - unit - Verify "Apply original unit for all series" icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Unit"
    And Edit series unit
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "unit"

  @Histogram
  Scenario: TC_Histogram_40:Rename - frequency - verify Editing series frequency
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on "Apply"
    Then Should able to edit series frequency and updated in visual series as per the changes

  @Histogram
  Scenario: TC_Histogram_41:Rename - frequency - Verify Apply original frequency icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on '>' icon
    Then The changes should be revert to original series "frequency"

  @Histogram
  Scenario: TC_Histogram_42:Rename - frequency - Verify "Apply original frequency for all series" icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Frequency"
    And Edit series frequency
    And Click on '>' icon for original titles to all series
    Then All the changes should be revert back with original "frequency"

  @Histogram
  Scenario: TC_Histogram_43:Rename - Verify Auto name check box
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    Then Check box should be checked by default for auto name

  @Histogram
  Scenario: TC_Histogram_44:Rename - verify selecting multiple attributes for series name
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Select multiple attributes
    And Click on "Apply"
    And Click on "OK"
    Then Selected attributes should be displayed as series name

  @Histogram
  Scenario: TC_Histogram_45:Rename - Minimize option
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Minimize" option
    Then The Popup should be minimized

  @Histogram
  Scenario: TC_Histogram_46:Rename - Verify maximiz option
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The popup should be maximized

  @Histogram
  Scenario: TC_Histogram_47:Rename - verify full screen
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Full-screen" option
    Then The popup should be displayed in full screen

  @Histogram
  Scenario: TC_Histogram_48:Rename - verify exit full screen
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The popup should be displayed in normal screen

  @Histogram
  Scenario: TC_Histogram_49:Rename - Verify Cancel/x icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Cancel button
    Then The rename popup should be closed

  @Histogram
  Scenario: TC_Histogram_50:Rename - Verify opening rename popup by keyboard shortcut
    And Create histogram visual with series
    And Click on Edit series option
    And Press Ctrl+H on keyboard
    Then Rename popup should be displayed

  @Histogram
  Scenario: TC_Histogram_51:Edit series - Verify appling 'Currency conversation' function
    And Create a histogram visual with series
    And Click on Edit series option
    And Choose any function from Currency conversation
    Then Selected currency should be applied to all series

  @Histogram
  Scenario: TC_Histogram_52:Edit series - Verify appling 'Calculate change' function
    And Create a histogram visual with series
    And Click on Edit series option
    And Choose any function from Calculate change
    Then Selected function should be applied to all series

  @Histogram
  Scenario: TC_Histogram_53:Edit series - Verify 'Aggregate' function apply
    And Create a histogram visual with series
    And Click on Edit series option
    And Click on Aggregate and choose any option
    Then Selected function should be applied to all series

  @Histogram
  Scenario: TC_Histogram_54:Edit series - Verify 'Accumulate' function apply
    And Create a histogram visual with series
    And Click on Edit series option
    And Click on Accumulate and choose any option
    Then Selected function should be applied to all series

  @Histogram
  Scenario: TC_Histogram_55:Edit series - Verify 'FX more' drop down
    And Create a histogram visual with series
    And Click on Edit series option
    And Click on FX More dropdown and Choose any function
    Then Selected function should display in series

  @Histogram
  Scenario: TC_Histogram_56:Edit series - Verify FX icon.
    And Create a histogram visual with series
    And Click on Edit series option
    And Click on FX icon
    Then The "Apply functions to visual series" popup should be opened

  @Histogram
  Scenario: TC_Histogram_57:Edit series - Verify delete series icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on x icon for a series
    Then The series should be removed from the visual and edit series panel

  @Histogram
  Scenario: TC_Histogram_58:Edit series - Verify SSP by clicking on series name
    And Create histogram visual with series
    And Click on Edit series option
    And Click on series name
    Then SSP popup should be displayed

  @Histogram
  Scenario: TC_Histogram_59:Edit series - Verify Rename series icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on rename series icon
    Then Rename popup should be displayed for selected series

  @Histogram
  Scenario: TC_Histogram_60:Edit series - Verify Rename option under edit series
    And Create histogram visual with series
    And Click on Edit series option
    And Click on edit series icon
    And Select "Rename"
    Then Rename popup should be displayed for selected series

  @Histogram
  Scenario: TC_Histogram_61:Edit series - Verify Frequency option under edit series
    And Create histogram visual with series
    And Click on Edit series option
    And Click on edit series icon
    And Select Frequency
    Then Selected function should be applied to the series

  @Histogram
  Scenario: TC_Histogram_62:Edit series - Verify Change option under edit series
    And Create histogram visual with series
    And Click on Edit series option
    And Click on edit series icon
    And Select "Change"
    Then Selected change function should be applied to the series

  @Histogram
  Scenario: TC_Histogram_63:Edit series - Verify Currency option under edit series
    And Create histogram visual with series
    And Click on Edit series option
    And Click on edit series icon
    And Select "Currency"
    Then Selected currency function should be applied to the series

  @Histogram
  Scenario: TC_Histogram_64:Edit series - Series data conversion - Verify applying frequency
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    And Select "Daily" frequency from drop down
    And Click on "Apply"
    Then The selected frequency should be applied to available series

  @Histogram
  Scenario: TC_Histogram_65:Edit series - Series data conversion - Verify applying Missing values method
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    And Select "Daily" frequency from drop down
    And Select "Specific value" from Missing values method
    And Click on "Apply"
    Then Missing values method should be applied with selected frequency

  @Histogram
  Scenario: TC_Histogram_66:Edit series - Minimize option
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    And Click on "Minimize" option
    Then The Popup should be minimized

  @Histogram
  Scenario: TC_Histogram_67:Edit series - maximize option
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The popup should be maximized

  @Histogram
  Scenario: TC_Histogram_68:Edit series - full screen
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    And Click on "Full-screen" option
    Then The popup should be displayed in full screen

  @Histogram
  Scenario: TC_Histogram_69:Edit series -  exit full screen
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The popup should be displayed in normal screen

  @Histogram
  Scenario: TC_Histogram_70:Edit series - Verify Cancel/x icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    And Click on Cancel button
    Then The popup should be closed for close icon

  @Histogram
  Scenario: TC_Histogram_71:Edit series - Verify applying frequency in series level
    And Create histogram visual with series
    And Click on Edit series option
    And Click on frequency dropdown in series level
    And Select "Monthly (Distribute)" from frequency dropdown
    Then Selected frequency should be applied to ONLY selected series

  @Histogram
  Scenario: TC_Histogram_72:Edit series - Verify applying currency in series level
    And Create histogram visual with series
    And Click on Edit series option
    And Click on currency dropdown in series level
    And Select "RMB" from currency dropdown
    Then Selected currency should be applied to ONLY selected series

  @Histogram
  Scenario: TC_Histogram_73:Edit series - Verify applying function in series level
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    Then Selected function should applied to the series

  @Histogram
  Scenario: TC_Histogram_74:Edit series - Verify multiple functions apply
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select multiple functions "ACCUMULATE"  and "LOG"
    And Click on "Apply function"
    Then The Selected functions should applied to the series

  @Histogram
  Scenario: TC_Histogram_75:Edit series - Verify removing applied functions
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    And Click on x icon to remove the function
    Then The function should be removed from the series

  @Histogram
  Scenario: TC_Histogram_76:Edit series - Verify applied funtion in function toolbar
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select "ACCUMULATE" function
    And Click on "Apply function"
    Then The applied function should be displayed on the toolbar

  @Histogram
  Scenario: TC_Histogram_77:Edit series - Verify applying invalid function for series
    And Create a histogram visual with series
    And Click on Edit series option
    And Click on "Type a function" field in series level
    And Select an invalid function for the series
    Then "The function cannot be applied to selected series" popup should be displayed

  @Histogram
  Scenario: TC_Histogram_78:Edit series - Verify Region, Unit and Series ID fields
    And Create a histogram visual with series
    And Click on Edit series option
    Then "Region", "Unit" and "Series id" fields should be available for respective series

  @Histogram
  Scenario: TC_Histogram_79:Edit series - Verify "+Add from my series" option
    And Create a histogram visual with series
    And Click on Edit series option
    And Click on "+ Add more from My Series" option
    Then User should redirect to "+Add from My Series" tab

  @Histogram
  Scenario: TC_Histogram_80:Verify title icon for histogram
    And Create histogram visual with series
    And Mouse hover on visual title
    And Click on edit icon
    Then The title popup should be appeared

  @Histogram
  Scenario: TC_Histogram_81:Verify titles popup open by double click on visual title
    And Create histogram visual with series
    And Double click on the visual title
    Then The title popup should be appeared

  @Histogram
  Scenario: TC_Histogram_82:Verify visual legend
    And Create histogram visual with series
    Then Visual legend "Series" and "Histogram" should be displayed

  @Histogram
  Scenario: TC_Histogram_83:Veirfy disabling of series legend
    And Create histogram visual with series
    And Click on series legend
    Then Series data should be hidden from the visual

  @Histogram
  Scenario: TC_Histogram_84:Veirfy disabling of histogram legend
    And Create histogram visual with series
    And Click on Histogram legend
    Then The Histogram data should be hidden from visual

  @Histogram
  Scenario: TC_Histogram_85:Verify enabling of legends
    And Create histogram visual with series
    And Click on series legend
    And Again click on the same
    Then The legend should be enabled

  @Histogram
  Scenario: TC_Histogram_86:Verify Edit Histogram
    And Create histogram visual with series
    And Click on "Edit Histogram"
    Then The "Edit visual" popup should be displayed

  @Histogram
  Scenario: TC_Histogram_87:Edit Histogram - Verify template creating
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Make any changes
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    Then New template should be created with the name of "Shravas"

  @Histogram
  Scenario: TC_Histogram_88:Edit Histogram - Verify dropdown for template
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on dropdown for template
    Then The following templates should be available
      | CEIC Styles |
      | My Styles   |

  @Histogram
  Scenario: TC_Histogram_89:Edit Histogram - Verify description for confirmation popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And UnCheck Show Series
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    Then The description should be "Are you sure you want to delete this style template?" diaplayed

  @Histogram
  Scenario: TC_Histogram_90:Edit Histogram - Verify cancel/x icon on confirmation popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And UnCheck Show Series
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    And Click on "Cancel"
    Then The confirmation popup should be closed

  @Histogram
  Scenario: TC_Histogram_91:Edit Histogram - Verify OK button on confirmation popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And UnCheck Show Series
    And Click on create template icon
    And Enter new template name as "Shravas"
    And Click on green tick mark
    And Click on "Delete template" icon
    And Click on "Ok"
    Then The template should be deleted from the list

  @Histogram
  Scenario: TC_Histogram_92:Edit Histogram - Border - Verify Histogram color
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Histogram for "Border"
    And Select color 
    Then Border should be displayed for "histogram" with selected color

  @Histogram
  Scenario: TC_Histogram_93:Edit Histogram - Border - Verify histogram width
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Histogram for "Border"
    And Select Width to 5
    Then The histogram border "Width" should be updated to "5"

  @Histogram
  Scenario: TC_Histogram_94:Edit Histogram - Verify Border=NO for visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Uncheck Visual check box
    Then Border should not be displayed for visual

  @Histogram
  Scenario: TC_Histogram_95:Edit Histogram - Verify Border=Yes for visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Visual check box
    Then Border should be displayed for visual

  @Histogram
  Scenario: TC_Histogram_96:Edit Histogram - Border - Verify visual color
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Visual check box
    And Select color for Visual
    Then Border should be displayed for visual with selected color

  @Histogram
  Scenario: TC_Histogram_97:Edit Histogram - Border - Verify visual width
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Visual check box
    And Select Width to 5
    Then The visual border "Width" should be updated to "5"

  @Histogram
  Scenario: TC_Histogram_98:Edit Histogram - Border - Verify visual Radius
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Visual check box
    And Select Radius to 10
    Then The visual border "Radius" should be updated to "10"

  @Histogram
  Scenario: TC_Histogram_99:Edit Histogram - Border - Verify visual style
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Visual check box
    And Select below Styles for visual border
      | Solid  |
      | Dashed |
      | Dotted |
    Then The selected border should be applied to the visual

  @Histogram
  Scenario: TC_Histogram_100:Edit Histogram - Border - Verify advance settings
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Click on "Advanced settings"
    Then Visual popup should be opened

  @Histogram
  Scenario: TC_Histogram_101:Edit Histogram - Border - Verify advance settings cogwheel
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Click on "Open advanced settings popup"
    Then Visual popup should be opened

  @Histogram
  Scenario: TC_Histogram_102:Edit Histogram - Border - Verify closing of visual popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Click on "Open advanced settings popup"
    And Click on X icon
    Then The visual popup should be closed

  @Histogram
  Scenario: TC_Histogram_103:Edit Histogram - Verify Background=NO
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Uncheck "Histogram" and Visual
    Then Background should not be seen for "histogram" and visual

  @Histogram
  Scenario: TC_Histogram_104:Edit Histogram - Verify Background=YES
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Check "Histogram" and Visual
    Then Background should be displayed for "histogram" and visual

  @Histogram
  Scenario: TC_Histogram_105:Edit Histogram - Background - Verify histogram color
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Check Histogram for "Background"
    And Select background color
    Then Background should be displayed for "histogram" with selected color

  @Histogram
  Scenario: TC_Histogram_106:Edit Histogram - Background - Verify image upload for histogram
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Check Histogram for "Background"
    And click on Browse > upload image
    Then Uploaded image should be displayed in "histogram" background

  @Histogram
  Scenario: TC_Histogram_107:Edit Histogram - Background - Verify uploading different format of file for histogram
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Check Histogram for "Background"
    And click on Browse > try to upload PDF file
    Then "Selected image is not accepted. You can select any image of this types: image/jpeg, image/jpg, image/png, image/gif" message should be displayed

  @Histogram
  Scenario: TC_Histogram_108:Edit Histogram - Background - Verify visual color
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Check Visual check box
    And Select color for Visual
    Then Background should be displayed for visual with selected color

  @Histogram
  Scenario: TC_Histogram1_109:Edit Histogram - Background - Verify image upload for visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Check Visual check box
    And click on Browse > upload image
    Then Uploaded image should be displayed in visual background

  @Histogram
  Scenario: TC_Histogram_110:Edit Histogram - Background - Verify uploading different format of file for visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Check Visual check box
    And click on Browse > try to upload PDF file
    Then "Selected image is not accepted. You can select any image of this types: image/jpeg, image/jpg, image/png, image/gif" message should be displayed

  @Histogram
  Scenario: TC_Histogram_111:Edit Histogram - Background - Verify advance settings
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Click on "Advanced settings"
    Then Visual popup should be opened

  @Histogram
  Scenario: TC_Histogram_112:Edit Histogram - Background - Verify advance settings cogwheel
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Background drop down
    And Click on "Open advanced settings popup"
    Then Visual popup should be opened

  @Histogram
  Scenario: TC_Histogram_113:Edit Histogram - Verify Show series - checked
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check Show Series and Save
    Then Data of series should be shown on the visual

  @Histogram
  Scenario: TC_Histogram_114:Edit Histogram - Verify Show series - uncheck
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And UnCheck Show Series and Save
    Then Data of series should be removed from the visual

  @Histogram
  Scenario: TC_Histogram_115:Edit Histogram - Verify Title=Yes
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And Check Title and Save
    Then The title of the visual should be displayed

  @Histogram
  Scenario: TC_Histogram_116:Edit Histogram - Verify Title=No
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And UnCheck Title and Save
    Then The title of the visual should be removed from the visual

  @Histogram
  Scenario: TC_Histogram_117:Edit Histogram - Verify default selection for title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    Then The title should be selected by default

  @Histogram
  Scenario: TC_Histogram_118:Edit Histogram - Verify Auto title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And Check title with empty title field and Save
    Then Auto title should be displayed as series name

  @Histogram
  Scenario: TC_Histogram_119:Edit Histogram - Verify renaming title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And Enter visual name and Save
    Then The visual name should be changed

  @Histogram
  Scenario: TC_Histogram_120:Edit Histogram - Verify sub title by default
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    Then The sub title check box should be unchecked by default

  @Histogram
  Scenario: TC_Histogram_121:Edit Histogram - Verify sub title=Check
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And Check Subtitle and Save
    Then Sub title should be displayed for the visual

  @Histogram
  Scenario: TC_Histogram_122:Edit Histogram - Verify sub title=UnCheck
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And UnCheck Subtitle and Save
    Then Sub title should not be displayed for the visual

  @Histogram
  Scenario: TC_Histogram_123:Edit Histogram - Verify default title for sub title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And Check Subtitle and Save
    Then Default sub title should be "Sub title"

  @Histogram
  Scenario: TC_Histogram_124:Edit Histogram - Verify advance settings
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Title drop down
    And Click on "Advanced settings"
    Then Titles popup should be displayed

  @Histogram
  Scenario: TC_Histogram_125:Edit Histogram - Verify advance settings cogwheel icon
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    Then Titles popup should be displayed

  @Histogram
  Scenario: TC_Histogram_126:Edit Histogram - Verify color for visual title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select color for "Title"
    When Click on "Save"
    Then Visual "title" should be displayed in selected color

  @Histogram
  Scenario: TC_Histogram_127:Edit Histogram - Verify color for visual title background
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select color for "title" background highlight
    When Click on "Save"
    Then Visual "title" background should be displayed in selected color

  @Histogram
  Scenario: TC_Histogram_128:Edit Histogram - Verify font size for visual title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select size for visual "title" as "20"
    When Click on "Save"
    Then The "title" font size should be changed as "20"

  @Histogram
  Scenario: TC_Histogram_129:Edit Histogram - Verify bold style for visual title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Bold icon for "title"
    When Click on "Save"
    Then The "title" should be displayed in Bold format

  @Histogram
  Scenario: TC_Histogram_130:Edit Histogram - Verify Italic style for visual title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Italic under style
    When Click on "Save"
    Then The "title" should be "italic"

  @Histogram
  Scenario: TC_Histogram_131:Edit Histogram - Verify Underline style for visual title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    And Click on Underline icon for "title"
    When Click on "Save"
    Then The "title" should be "underline"

  @Histogram
  Scenario: TC_Histogram_132:Edit Histogram - Verify horizontal alignment (left, right, center)
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    And Select alignment of title to "left"
    Then The title should align to "left"
    And Select alignment of title to "center"
    Then The title should align to "center"
    And Select alignment of title to "right"
    Then The title should align to "right"

    @Histogram
  Scenario: TC_Histogram_133:Edit Histogram - Verify color for visual sub title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select color for "Sub title"
    When Click on "Save"
    Then Visual "sub_title" should be displayed in selected color

  @Histogram
  Scenario: TC_Histogram_134:Edit Histogram - Verify color for visual sub title background
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select color for "Sub title" background highlight
    When Click on "Save"
    Then Visual "sub_title" background should be displayed in selected color

  @Histogram
  Scenario: TC_Histogram_135:Edit Histogram - Verify font size for visual sub title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Select size for visual "Sub title" as "20"
    When Click on "Save"
    Then The "sub_title" font size should be changed as "20"

  @Histogram
  Scenario: TC_Histogram_136:Edit Histogram - Verify bold style for visual sub title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Click on B under style for sub-title
    When Click on "Save"
    Then The "sub_title" should be displayed in Bold format

  @Histogram
  Scenario: TC_Histogram_137:Edit Histogram - Verify Italic style for visual sub title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Click on Italic under style for sub-title
    When Click on "Save"
    Then The "sub_title" should be "italic"

  @Histogram
  Scenario: TC_Histogram_138:Edit Histogram - Verify Unnderline style for visual sub title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Click on Underline icon for sub-title
    When Click on "Save"
    Then The "sub_title" should be "underline"

  @Histogram
  Scenario: TC_Histogram_139:Edit Histogram - Verify horizontal alignment (left, right, center)
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "sub-title"
    And Select alignment of sub title to "left"
    Then The subtitle should align to "left"
    And Select alignment of sub title to "center"
    Then The subtitle should align to "center"
    And Select alignment of sub title to "right"
    Then The subtitle should align to "right"

  @Histogram
  Scenario: TC_Histogram_140:Edit Histogram - Verify closing of Titles popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Click on X icon to close the popup
    Then The Title popup should be closed

  @Histogram
  Scenario: TC_Histogram_141:Edit Histogram - Verify size of the visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    Then The default Edit Visual popup height and width should be "100%"

  @Histogram
  Scenario: TC_Histogram_142:Edit Histogram - Size - Verify Horizontal align for visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Open Size dropdown
    And Reduce proportion to 80
    And Click on Horizontal align of visual to "Left"
    Then The Visual area should align to "Left"
    And Click on Horizontal align of visual to "Center"
    Then The Visual area should align to "Center"
    And Click on Horizontal align of visual to "Right"
    Then The Visual area should align to "Right"

   @Histogram
  Scenario: TC_Histogram_143:Edit Histogram - Size - Verify Horizontal align by defaullt
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Open Size dropdown
    Then The "Horizontal align" should be disabled if proportion is "100%"

  @Histogram
  Scenario: TC_Histogram_144:Edit Histogram - Verify Copyright=Check
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check Copyright and Save
    Then The Copyright logo should be displayed for visual

  @Histogram
  Scenario: TC_Histogram_145:Edit Histogram - Verify Copyright=UnCheck
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And UnCheck Copyright
    Then The Copyright logo should be removed for visual

  @Histogram
  Scenario: TC_Histogram_146:Edit Histogram - Copyright - Verify 'Horizontal align'
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Click on Horizontal align of visual to "Left"
    Then The copyright image should align to "Left"
    And Click on Horizontal align of visual to "Center"
    Then The copyright image should align to "Center"
    And Click on Horizontal align of visual to "Right"
    Then The copyright image should align to "Right"

   @Histogram
  Scenario: TC_Histogram_147:Edit Histogram - Copyright - Verify advance settings
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Open drop down for "Copyright"
    And Click on "Advanced settings"
    Then "Copyright" popup should be displayed

  @Histogram
  Scenario: TC_Histogram_148:Edit Histogram - Copyright - Verify advance settings cogwheel
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    Then "Copyright" popup should be displayed

  @Histogram
  Scenario: TC_Histogram_149:Edit Histogram - Copyright - Verify text=check
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    #And Open drop down for "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button from copyright popup and Save
    Then Copyright text "Source: CEIC Data" should be displayed on visual

  @Histogram
  Scenario: TC_Histogram_150:Edit Histogram - Copyright - Verify text change for copyright
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    #And Open drop down for "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button and Edit the text as "CDMNext" and Save
    Then Updated copyright "CDMNext" should be displayed on visual

  @Histogram
  Scenario: TC_Histogram_151:Edit Histogram - Copyright - Verify link for copyright
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button from copyright popup and Save
    And Click on the Copyright
    Then "Copyright" popup should be displayed
    #Then The user should redirect to "https://www.ceicdata.com/en" link

  @Histogram
  Scenario: TC_Histogram_152:Edit Histogram - Copyright - Verify copyright color
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    #And Open drop down for "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select color for "Copyright"
    When Click on "Save"
    Then Visual "Copyright" should be displayed in selected color

  @Histogram
  Scenario: TC_Histogram_153:Edit Histogram - Copyright - Verify font size
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select size for visual "Copyright" as "20"
    When Click on "Save"
    Then The "Copyright" font size should be changed as "20"

  @Histogram
  Scenario: TC_Histogram_154:Edit Histogram - Copyright - Verify bold style
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Bold icon for "Copyright"
    When Click on "Save"
    Then The "Copyright" should be displayed in Bold format

  @Histogram
  Scenario: TC_Histogram_155:Edit Histogram - Copyright - Verify italic style
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Italic icon
    When Click on "Save"
    Then The "Copyright" should be "italic"

  @Histogram
  Scenario: TC_Histogram_156:Edit Histogram - Copyright - Verify Underline style
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Click on Underline icon for "Copyright"
    When Click on "Save"
    Then The "Copyright" should be "underline"

  @Histogram
  Scenario: TC_Histogram_157:Edit Histogram - Copyright - Verify horizontal alignment (left, right, center)
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Copyright"
    And Click on "Open advanced settings popup" icon
    And Select Text radio button
    And Select Horizontal alignment of copyright to "left"
    Then The copyright image should align to "Left"
    And Select Horizontal alignment of copyright to "center"
    Then The copyright image should align to "Center"
    And Select Horizontal alignment of copyright to "right"
    Then The copyright image should align to "Right"

  @Histogram
  Scenario: TC_Histogram_158:Edit Histogram - Copyright - Verify closing copyright popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Open advanced settings popup" icon
    And Click on X icon to close the popup
    Then The "Title" popup should be closed

  @Histogram
  Scenario: TC_Histogram_159:Edit Histogram - Verify tooltip=Check
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on "Save"
    Then Tooltip should be displayed when mouse hover on visual data

  @Histogram
  Scenario: TC_Histogram_160:Edit Histogram - Verify tooltip=UnCheck
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And UnCheck Tooltips
    And Click on "Save"
    Then No Tooltip should be displayed when mouse hover on visual data

  @Histogram
    Scenario: TC_Histogram_161:Edit Histogram - Tootip - Verify selecting attributes
    And Create a histogram visual
    And Add a series to the visual
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Open drop down for "Tooltips"
    And Select attributes
      | Name      |
      | Region    |
      | Frequency |
    And Click on "Save"
    Then Selected attributes should be displayed in tooltip when mouse hover on visual data

  @Histogram
  Scenario: TC_Histogram_162:Edit Histogram - Tootip - Verify advance settings in dropdown
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Open drop down for "Tooltips"
    And Click on "Advanced settings"
    Then "Tooltip" should be displayed

  @Histogram
  Scenario: TC_Histogram_163:Edit Histogram - Tootip - Verify advance settings in cogwheel
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    Then "Tooltip" should be displayed

  @Histogram
  Scenario: TC_Histogram_164:Edit Histogram - Tootip - Verify show tooltip=checked
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And Check "Show tooltips"
    And Click on "Save"
    And Tooltip should be displayed when mouse hover on visual data

  @Histogram
  Scenario: TC_Histogram_165:Edit Histogram - Tootip - Verify show tooltip=Unchecked
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And UnCheck "Show tooltips"
    And Click on "Save"
    And No Tooltip should be displayed when mouse hover on visual data

  @Histogram
  Scenario: TC_Histogram_166:Edit Histogram - Tootip - Verify Items
    And Create a histogram visual
    And Add a series to the visual
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And Expand "Items"
    And Select items as "Region" from dropdown
    And Click on "Save"
    Then The selected items should be displayed in the tooltip  when mouse hover on visual data

  @Histogram
  Scenario: TC_Histogram_167:Edit Histogram - Tootip - Verify multiple items selection
    And Create a histogram visual
    And Add a series to the visual
    And Click on "Edit Histogram"
     And Check Show Series
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And Expand "Items"
    And Select multiple items from dropdown
      | Name      |
      | Region    |
      | Frequency |
    And Click on "Save"
    Then Selected attributes should be displayed in tooltip when mouse hover on visual data

  @Histogram
  Scenario: TC_Histogram_168:Edit Histogram - Tooltip - Verify text color in tooltip
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And Expand "Items"
    And Select items as "Region" from dropdown
    And Select color for "Items"
    When Click on "Save"
    Then Visual "tooltip text" should be displayed in selected color

  @Histogram
  Scenario: TC_Histogram_169:Edit Histogram - Tooltip - Verify font size
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And Expand "Items"
    And Select items as "Region" from dropdown
    And Select font size as "15"
    When Click on "Save"
    Then The font size in tooltip should be changed as "15"

  #@Histogram..... font styles has been removed(https://securities.jira.com/browse/CVISION-20015)
  #Scenario: TC_Histogram_170:Edit Histogram - Tooltip - Verify bold style
    #And Create histogram visual with series
    #And Click on "Edit Histogram"
    #And Check "Tooltips"
    #And Click on cogwheel for advance settings
    #And Expand "Items"
    #And Select items as "Region" from dropdown
    #And Click on Bold icon for "Items"
    #When Click on "Save"
    #Then The text in tooltip should be displayed in "Bold" format

  #@Histogram
  #Scenario: TC_Histogram_171:Edit Histogram - Tooltip - Verify Italic style
    #And Create a histogram visual
    #And Add a series to the visual
    #And Click on "Edit Histogram"
    #And Check "Tooltips"
    #And Click on cogwheel for advance settings
    #And Expand "Items"
    #And Select items as "Region" from dropdown
    #And Click on "Italic" icon for items
    #When Click on "Save"
    #Then The text in tooltip should be displayed in "Italic" format
#
  #@Histogram
  #Scenario: TC_Histogram_172:Edit Histogram - Tooltip - Verify underline style
    #And Create histogram visual with series
    #And Click on "Edit Histogram"
    #And Check "Tooltips"
    #And Click on cogwheel for advance settings
    #And Expand "Items"
    #And Select items as "Region" from dropdown
    #And Click on "Underline" icon for items
    #When Click on "Save"
    #Then The text in tooltip should be displayed in "Underline" format

  @Histogram
  Scenario Outline: TC_Histogram_173: Edit Histogram - Tooltip - Verify grouping and decimal under number separators.
    And Create histogram visual with series
    And Click on "Edit Histogram"
     And Check Show Series
    And Check "Tooltips"
    And Click on Number format dropdown
    And Select <decimal> and <group> separator from dropdown list
    And Click on "Save"
    Then The Selected Decimal seperator and Grouping seperator should update with selected input

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

  @Histogram
  Scenario: TC_Histogram_174: Edit Histogram - Tooltip - Verify decimal places
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on Number format dropdown
    And Set the Decimal places as 5
    And Click on "Save"
    Then Selected decimal places should be displayed with data

  @Histogram
  Scenario: TC_Histogram_175:Edit Histogram - Tooltip - Verify closing tooltip popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And Click on X icon to close the popup
    Then The "tooltip" popup should be closed

  #@Histogram(https://securities.jira.com/browse/CVISION-20015)
  #Scenario: TC_Histogram_176:Edit Histogram - Tooltip - Verify color for tooltip border
    #And Create histogram visual with series
    #And Click on "Edit Histogram"
    #And Check "Tooltips"
    #And Click on cogwheel for advance settings
    #And Expand "Border"
    #And Select color for "tooltip border"
    #And Click on "Save"
    #Then Tooltip border should be displayed with selected color
#
  #@Histogram
  #Scenario: TC_Histogram_177:Edit Histogram - Tooltip - Verify border width
    #And Create histogram visual with series
    #And Click on "Edit Histogram"
    #And Check "Tooltips"
    #And Click on cogwheel for advance settings
    #And Expand "Border"
    #And Select Width to 5
    #And Click on "Save"
    #Then The tooltp border width should be updated to "5"

  @Histogram
  Scenario: TC_Histogram_178:Edit Histogram - Verify the changes reflected in edit visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Border drop down
    And Check Visual check box
    And Select visual border as "Dashed"
    Then The selected border should be applied to the visual

  @Histogram
  Scenario: TC_Histogram_179:Edit Histogram - Verify title icon on visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Mouse hover on visual title for Edit visual popup
    And Click on edit icon for Edit visual popup
    Then The "Titles" popup should be appeared

  @Histogram
  Scenario: TC_Histogram_180:Edit Histogram - Verify titles popup open by clicking on visual title
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on the visual title
    Then The "Titles" popup should be appeared

  @Histogram
  Scenario: TC_Histogram_181:Edit Histogram - Verify selecting another visual from visual panel
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Select any visual from visual panel
    And Click on "Save"
    Then The visual should be converted as user selected

  @Histogram
  Scenario: TC_Histogram_182:Edit Histogram - Verify selecting another visual from dropdown
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on visual panel dropdown
    And Select "Pie" visual
    And Click on "Save"
    Then The visual should be converted as user selected

  @Histogram
  Scenario: TC_Histogram_183:Edit Histogram - Edit series - Verify delete series icon
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on x icon for a series
    Then The series should be removed from visual and edit series panel

  @Histogram
  Scenario: TC_Histogram_184:Edit Histogram - Edit series - Verify SSP by clicking on series name.
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on Series
    Then SSP popup should be displayed

  @Histogram
  Scenario: TC_Histogram_185:Edit Histogram - Edit series - Verify Rename series icon
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Rename series" icon
    Then "Rename" popup should be displayed for selected series

  @Histogram
  Scenario: TC_Histogram_186:Edit Histogram - Edit series - Verify Rename option under edit series.
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Edit series" icon
    And Select "Rename"
    Then "Rename" popup should be displayed for selected series

  @Histogram
  Scenario: TC_Histogram_187:Edit Histogram - Edit series - Verify Frequency option under edit series.
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Edit series" icon
    And Select "Frequency" as "Yearly (Sum)"
    Then Selected function should be applied to the series

  @Histogram
  Scenario: TC_Histogram_188:Edit Histogram - Edit series - Verify Currency option under edit series
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Edit series" icon
    And Select "Currency" as "RMB"
    Then Selected currency should be applied to the series

  @Histogram
  Scenario: TC_Histogram_189:Edit Histogram - Edit series - Verify Change option under edit series
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Edit series" icon
    And Select "Change" as "% Year-over-Year (%YoY)"
    Then Selected change function should be applied to the series

  @Histogram
  Scenario: TC_Histogram_190:Edit Histogram - Edit series - Verify clicking on frequency or dropdown
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    Then "Series Harmonization" popup should be opened

  @Histogram
  Scenario: TC_Histogram_191:Edit Histogram - Edit series - Series data conversion - Verify applying frequency
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    And Select "Frequency" as "Daily" from dropdown
    And Click on "Apply"
    Then The selected frequency should be applied to available series

  @Histogram
  Scenario: TC_Histogram_192:Edit Histogram - Edit series - Series data conversion - Verify applying Missing values method
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    And Select "Frequency" as "Daily" from dropdown
    And Select "Missing values method" as "Next value" from dropdown
    Then Missing values method should be applied with selected frequency

  @Histogram
  Scenario: TC_Histogram_193:Edit Histogram - Edit series - Series data conversion -Minimize option
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    And Click on "Minimize" option
    Then The Series Hormonization popup should be minimized

  @Histogram
  Scenario: TC_Histogram_194:Edit Histogram - Edit series - Series data conversion -Verify maximize option
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    And Click on "Minimize" option
    And Click on "Maximize" option
    Then The Series Hormonization popup should be maximized

  @Histogram
  Scenario: TC_Histogram_195:Edit Histogram - Edit series - Series data conversion -verify full screen
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    And Click on "Full-screen" option
    Then The Series Hormonization popup should be displayed in full screen

  @Histogram
  Scenario: TC_Histogram_196:Edit Histogram - Edit series - Series data conversion -verify exit full screen
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    And Click on "Full-screen" option
    And Click on "Exit full-screen" option
    Then The Series Hormonization popup should be displayed in normal screen

  @Histogram
  Scenario: TC_Histogram_197:Edit Histogram - Edit series - Series data conversion -Verify Cancel/x icon
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Frequency"
    And Click on Cancel button
    Then The Series Hormonization popup should be closed

  @Histogram
  Scenario: TC_Histogram_198:Edit Histogram - Edit series - Verify dropdown for frequency in series level
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on frequency dropdown
    Then List of frequenceies should be available

  @Histogram
  Scenario: TC_Histogram_199:Edit Histogram - Edit series - Verify applying frequency in series level
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on frequency dropdown
    And Select frequence as "Yearly (Sum)"
    Then Selected frequency should be displayed in the series

  @Histogram
  Scenario: TC_Histogram_200:Edit Histogram - Edit series - Verify applying currency in series level
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on currency dropdown
    And Select currency as "USD"
    Then Selected currency should be displayed in the series

  @Histogram
  Scenario: TC_Hstogram_201:Edit Histogram - Edit series - Verify clicking on type a function field
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on type a function field in series level
    Then List of functions dropdown should be opened

  @Histogram
  Scenario: TC_Histogram_202:Edit Histogram - Edit series -  Verify applying function in series level
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on type a function field in series level
    And Select a function
    And Click on "Apply function"
    Then The selected function should be applied to the series

  @Histogram
  Scenario: TC_Histogram_203:Edit Histogram - Edit series -  Verify cancel icon for selected function
    And Create histogram visual with series
    And Click on "Edit Histogram"	
    And Click on type a function field in series level
    And Select a function
    And Click on cancel function icon
    Then The selected function should be cancelled

  @Histogram
  Scenario: TC_Histogram_204:Edit Histogram - Edit series - Verify multiple functions apply
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on type a function field in series level
    And Select multiple functions
    And Click on "Apply function"
    Then The selected functions should be applied to the series

  @Histogram
  Scenario: TC_Histogram_205:Edit Histogram - Edit  series - Verify removing applied functions
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on type a function field in series level
    And Select a function
    And Click on "Apply function"
    And Click on cancel function icon
    Then The function should be removed from the series

  @Histogram
  Scenario: TC_Histogram_206:Edit Histogram - Edit series - Verify appling invalid function for series
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on type a function field in series level
    And Select an invalid function
    And Click on "Apply function"
    Then "The function cannot be applied to selected series" popup should be displayed

  @Histogram
  Scenario: TC_Histogram_207:Edit seires - Verify OK button on "The function cannot be applied to selected series" popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on type a function field in series level
    And Select an invalid function
    And Click on "Apply function"
    And Click on "Ok"
    Then The function cannot be applied to selected series popup should be closed

  @Histogram
  Scenario: TC_Histogram_208:Edit Histogram - Verify feedback option
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Feedback" option
    Then "Still cannot find an answer?" popup should be displayed

  @Histogram
  Scenario: TC_Histogram_209:Edit Histogram - Feedback - Verify description for popup
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Feedback" option
    Then The description should be "Do you need any additional features? Please send us your feedback for product enhancements."

  @Histogram
  Scenario: TC_Histogram_210:Edit Histogram - Feedback - Verify cancel button
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Feedback" option
    And Enter text in description field
    And Click on cancel button
    Then The feedback popup should be closed

  @Histogram
  Scenario: TC_Histogram_211:Edit Histogram - Feedback - Verify growl message after  Submit feedback
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Feedback" option
    And Enter text in description field
    And Click on submit button
    Then "Thank you for submitting a question to us." message should be displayed in a growl popup

  @Histogram
  Scenario: TC_Histogram_212:Edit Histogram - Verify cancel/x button
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Cancel" button
    Then The edit visual popup should be closed

  @Histogram
  Scenario: TC_Histogram_213:Edit Histogram - Verify save button
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Change title in edit visual window
    And Click on "Save" button
    Then The changes should be reflected to histogram visual and Edit visual popup should be closed

  @Histogram
  Scenario: TC_Histogram_214:Verify add to insight option
    And Create histogram visual with series
    And Click on + icon on header
    Then Below options should be displayed
      | Add to new tab     |
      | Add to new insight |

  @Histogram
  Scenario: TC_Histogram_215:Add to insight - Verify 'Add to new tab' option under Add to insight
    And Create histogram visual with series
    And Click on + icon on header
    And Click on "Add to new tab"
    Then The Histogram visual should be created in vew tab on current insight

  @Histogram
  Scenario: TC_Histogram_216:Add to insight - Verify confirmation message for adding visual to new insight
    And Create histogram visual with series
    And Click on + icon on header
    And Click on "Add to new insight"
    Then "New insight with the selected visual created" and "Go to new insight" confirmation message should be displayed

  @Histogram
  Scenario: TC_Histogram_217:Add to insight - Validate the added visual by opening new insight
    And Create histogram visual with series
    And Click on + icon on header
    And Click on "Add to new insight"
    And Click on "Go to new insight"
    Then The insight should be opened and added visual should be available in My visual

  @Histogram
    Scenario: TC_Histogram_218:Copy - Verify confirmation message for copy visual
    And Create histogram visual with series
    And Click on "Copy" icon
    Then "Histogram copied." confirmation message should be displayed

  @Histogram
  Scenario: TC_Histogram_219:Copy - Validate copied visual by pasting with in the insight
    And Create histogram visual with series
    And Click on "Copy" icon
    And Paste within the insight
    Then The visual should be pasted in the insight

  @Histogram
  Scenario: TC_Histogram_220:Copy - Validate copied visual by pasting to new insight
    And Create histogram visual with series
    And Click on "Copy" icon
    And Paste to new insight
    Then The visual should be pasted to new insight

  @Histogram
  Scenario: TC_Histogram_221:Copy - Verify the confrimation message for pasting visual in insight
    And Create histogram visual with series
    And Click on "Copy" icon
    And Paste within the insight
    Then "Data pasted from clipboard" message should be displayed

  @Histogram
  Scenario: TC_Histogram_222:Download - Verify Download option
    And Create histogram visual with series
    And Click on Download icon
    Then Download popup should be appeared

  @Histogram
  Scenario: TC_Histogram_223:Download - Verify histogram visual download with excel format
    And Create histogram visual with series
    And Click on Download icon
    And Select "xlsx" format
    And Click on "Download"
    Then Histogram visual and related series should be downloaded in excel

  @Histogram
  Scenario: TC_Histogram_224:Download - Verify histogram visual download with PDF format
    And Create histogram visual with series
    And Click on Download icon
    And Select "pdf" format
    And Click on "Download"
    Then Histogram visual should be downloaded in PDF format

  @Histogram
  Scenario: TC_Histogram_225:Download - Verify histogram visual download with PNG format
    And Create histogram visual with series
    And Click on Download icon
    And Select "png" format
    And Click on "Download"
    Then Histogram visual should be downloaded in PNG format

  @Histogram
  Scenario: TC_Histogram_226:Download - Verify histogram visual download with JPG format
    And Create histogram visual with series
    And Click on Download icon
    And Select "jpeg" format
    And Click on "Download"
    Then Histogram visual should be downloaded in JPG format

  @Histogram
  Scenario: TC_Histogram_227:Download - Verify size for JPG/PNG download
    And Create histogram visual with series
    And Click on Download icon
    And Select "jpeg" format
    And Select width size "589"
    And Click on "Download"
    Then The visual should be downloaded with selected size

  @Histogram
  Scenario: TC_Histogram_228:Verify Open option.
    And Create histogram visual with series
    And Click on Open icon
    Then The visual should be displayed in maximized window

  @Histogram
  Scenario: TC_Histogram_229:Verify closing of maximized window.
    And Create histogram visual with series
    And Click on Open icon
    And Click on x icon to close
    Then The modal window should be closed

  @Histogram
  Scenario: TC_Histogram_230:Verify Delete Histogram
    And Create histogram visual with series
    And Click on "delete"
    Then "Confirmation" popup should be dispalyed

  @Histogram
  Scenario: TC_Histogram_231:Verify description for delete confirmation popup.
    And Create histogram visual with series
    And Click on "delete"
    Then "Do you want to remove this visual?" popup should be dispalyed

  @Histogram
  Scenario: TC_Histogram_232:Verify OK button in delete confirmation popup
    And Create histogram visual with series
    And Click on "delete"
    And Click on "Ok"
    Then The visual should be deleted

  @Histogram
  Scenario: TC_Histogram_233:Verify Cancel/x icon in delete confirmation popup
    And Create histogram visual with series
    And Click on "delete"
    And Click on "Cancel"
    Then The popup should be closed and delete visual process should be declined

  @Histogram
  Scenario: TC_Histogram_234:Right click - Validate copied Histogram
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Copy histogram"
    And Paste in insight
    Then Histogram visual should be pasted

  @Histogram
  Scenario: TC_Histogram_235:Right click - Verify Cut Histogram
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Cut histogram"
    Then Histogram should be cut

  @Histogram
  Scenario: TC_Histogram_236:Right click - Validate Cut Histogram
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Cut histogram"
    And Paste in insight
    Then Histogram visual should be pasted

  @Histogram
  Scenario: TC_Histogram_237:Right click - Verify Delete Histogram
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Delete histogram"
    Then Histogram should be deleted

  @Histogram
  Scenario: TC_Histogram_238:Right click - Verify chart under insert visual
    And Create histogram visual with series
    And Right click on visual header
    And Choose Add chart as "Chart"
    Then "Chart" visual should be created in the same view tab

  @Histogram
  Scenario: TC_Histogram_239:Right click - Verify Pie under insert visual
    And Create histogram visual with series
    And Right click on visual header
    And Choose Add chart as "Pie"
    Then "Pie" visual should be created in the same view tab

  @Histogram
  Scenario: TC_Histogram_240:Right click - Verify table under insert visual
    And Create histogram visual with series
    And Right click on visual header
    And Choose Add chart as "Table"
    Then "Table" visual should be created in the same view tab

  @Histogram
  Scenario: TC_Histogram_241:Right click - Verify map under insert visual
    And Create histogram visual with series
    And Right click on visual header
    And Choose Add chart as "Map"
    Then "Map" visual should be created in the same view tab

  @Histogram
  Scenario: TC_Histogram_242:Right click - Verify Heat map under insert visual
    And Create histogram visual with series
    And Right click on visual header
    And Choose Add chart as "Heat map"
    Then "Heat map" visual should be created in the same view tab

  @Histogram
  Scenario: TC_Histogram_243:Right click - Verify Histogram under insert visual
    And Create histogram visual with series
    And Right click on visual header
    And Choose Add chart as "Histogram"
    Then "Histogram" visual should be created in the same view tab

  #@Histogram
  #Scenario: TC_Histogram_244:Right click - Verify commentary under insert visual
    #And Create histogram visual with series
    #And Right click on visual header
    #And Choose Insert visual as "Commentary"
    #Then The commentary visual should be created in the same view tab
#
  #@Histogram
  #Scenario: TC_Histogram_245:Right click - Verify attachments under insert visual
    #And Create histogram visual with series
    #And Right click on visual header
    #And Choose Insert visual as "Attachments"
    #Then "Attachments" visual should be created in the same view tab
#
  #@Histogram
  #Scenario: TC_Histogram_246:Right click - Verify Image under insert visual
    #And Create histogram visual with series
    #And Right click on visual header
    #And Choose Insert visual as "Image"
    #Then "Image" visual should be created in the same view tab
#
  #@Histogram
  #Scenario: TC_Histogram_247:Right click - Verify Filter under insert visual
    #And Create histogram visual with series
    #And Right click on visual header
    #And Choose Insert visual as "Filter"
    #Then "Filter" visual should be created in the same view tab

  @Histogram
  Scenario: TC_Histogram_248:Right click - Verify Paste visual
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Copy histogram"
    And Again Right click on visual header
    And Choose "Paste visual"
    Then Copied visual should be pasted

  #@Histogram
  #Scenario: TC_Histogram_249:Right click - View as - Verify Chart
    #And Create histogram visual with series
    #And Right click on visual header
  #	And Choose Add chart as "Chart"
    #Then The "Hisogram" visual should be converted as "Chart" visual
#
  #@Histogram
  #Scenario: TC_Histogram_250:Right click - View as - Verify Map
    #And Create histogram visual with series
    #And Right click on visual header
    #And Select View as > "Map"
    #Then The "Hisogram" visual should be converted as "Map" visual
#
  #@Histogram
  #Scenario: TC_Histogram_251:Right click - View as - Verify Table
    #And Create histogram visual with series
    #And Right click on visual header
    #And Select View as > "Table"
    #Then The "Hisogram" visual should be converted as "Table" visual
#
  #@Histogram
  #Scenario: TC_Histogram_252:Right click - View as - Verify Pie
    #And Create histogram visual with series
    #And Right click on visual header
    #And Select View as > "Pie"
    #Then The "Hisogram" visual should be converted as "Pie" visual
#
  #@Histogram
  #Scenario: TC_Histogram_253:Right click - View as - Verify Heat map
    #And Create histogram visual with series
    #And Right click on visual header
    #And Select View as > "Heat map"
    #Then The "Hisogram" visual should be converted as "Heat map" visual

  @Histogram
  Scenario: TC_Histogram_254:Right click - Verify Calculated series sub dropdown
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Calculate series"
    And Select function "RMB"
    Then The Selected function should be applied for the series

  @Histogram
  Scenario: TC_Histogram_255:Right click - Verify Edit series option
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Edit series"
    Then The edit series popup should be opened with "Histogram" tab

  @Histogram
  Scenario: TC_Histogram_256:Right click - Verify Clear contents
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Clear contents"
    Then The content should be removed

  @Histogram
  Scenario: TC_Histogram_257:Right click - Verify reset format
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And UnCheck Show Series and Save
    Then Data of series should be removed from the visual
    And Right click on visual header
    And Choose "Reset format"
    Then All the changes should be revert back to default

  @Histogram
  Scenario: TC_Histogram_258:Right click - Verify reset format option if have no changes in visual
    And Create histogram visual with series
    And Right click on visual header
    Then The Reset format option should be disabled

  @Histogram
  Scenario: TC_Histogram_259:Right click -  Verify download sub dropdown
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Download"
    Then "Histogram" and "View" options should be displayed

  @Histogram
  Scenario: TC_Histogram_260:Right click -  Verify download > Histogram
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Download"
    And Select Histogram
    Then Download popup should be displayed with Histogram tab selection

  @Histogram
  Scenario: TC_Histogram_261:Right click -  Verify download > View
    And Create histogram visual with series
    And Right click on visual header
    And Choose "Download"
    And Select View
    Then Download popup should be displayed with views tab selection

  @Histogram
  Scenario: TC_Histogram_262:Verify the visual options if visual is not selected
    And Create histogram visual with series
    And Unhighlight the visual
    Then The visual options should be hidden

  #@Histogram
  #Scenario: TC_Histogram_263:Rename - verify for invalid search
    #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Rename" option
    #And Search with invalid series name
    #Then "No matches found" should be displayed under the find field

  @Histogram
  Scenario: TC_Histogram_264:Edit series - Verify adding series from my series
    And Select a series
    And Click on 'A' on keyboard
    And Create a Histogram visual without selecting series
    And Click on Edit series option
    And Select a series from My series tab
    And Choose "Histogram" tab
    Then The added series should be displayed in histogram tab

  @Histogram
    Scenario: TC_Histogram_265:Rename - Verify 'Edit series info' dropdown
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    Then Below options should be displayed
      | Name                 |
      | Function description |
      | Region               |
      | Unit                 |
      | Frequency            |

  @Histogram
  Scenario: TC_Histogram_266:Rename - verify attributes dropdown
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Open dropdown for auto name
    Then Below options should be available
      | Name                 |
      | Function description |
      | Region               |
      | Unit                 |
      | Frequency            |

  @Histogram
  Scenario: TC_Histogram_267:Rename - Veriy series in My series after visual series renamed
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    Then The changes should be applied to only visual and its series in edit series panel NOT for my series

  @Histogram
  Scenario: TC_Histogram_268:Rename - Verify 'Apply' button
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Rename" option
    And Click on Edit series info dropdown
    And Select "Name"
    And Edit series title
    And Click on "Apply"
    Then The changes should be saved and rename popup remains displayed

  @Histogram
  Scenario: TC_Histogram_269:Edit series - Verify edit series icon
    And Create histogram visual with series
    And Click on Edit series option
    And Click on edit series icon
    Then Below options should be available
      | Rename    |
      | Frequency |
      | Currency  |
      | Change    |

  @Histogram
  Scenario: TC_Histogram_270:Edit series - Verify applying function by clicking on function icon
    And Create a histogram visual with series
    And Click on Edit series option
    And Click on FX icon
    And Click on type a function field
    And Select any function
    And Click on "Apply"
    Then The selected function should be displayed

  @Histogram
  Scenario: TC_Histogram_271:Edit series - Verify search for functions
    And Create histogram visual with series
    And Click on Edit series option
    And Click on type a function field in series level
    And Search with function "YTD"
    Then Searched functions should be displayed

  @Histogram
  Scenario: TC_Histogram_272:Edit series - Verify clicking on frequency or dropdown
    And Create histogram visual with series
    And Click on Edit series option
    And Click on "Frequency"
    Then "Series Harmonization" popup should be opened

  @Histogram
  Scenario: TC_Histogram_273:Edit series -  Verify cancel icon for selected function
    And Create histogram visual with series
    And Click on Edit series option
    And Click on type a function field in series level
    And Select a function
    And Click on cancel function icon
    Then The selected function should be cancelled

  @Histogram
  Scenario: TC_Histogram_274:Edit seires - Verify OK button on "The function cannot be applied to selected series" popup
    And Create histogram visual with series
    And Click on Edit series option
    And Click on type a function field in series level
    And Select an invalid function
    And Click on Apply function
    And Click on "Ok"
    Then The function cannot be applied to selected series popup should be closed

  @Histogram
  Scenario: TC_Histogram_275:Verify disabling	both series and histogram legends at a time
    And Create histogram visual with series
    And Click on series legend
    Then Should disable only "series" legend
    And Click on Histogram legend
    Then Should disable only "histogram" legend

  @Histogram
  Scenario: TC_Histogram_276:Edit Histogram - Verify 'Set as default for future Histogram visual' is checked
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Mouse hover on existing visual templates
    And Click on template dropdown
    And Check the box for "Set as default for future Histogram visual"
    And Click on "Save"
    And Create a new histogram visual
    Then The Histogram should be created with the format of previous template selection

  @Histogram
  Scenario: TC_Histogram_277:Edit Histogram - Verify 'Set as default for future Histogram visual' is Unchecked
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check Show Series
    And  Mouse hover on existing visual templates
    And Click on template dropdown
    And Check the box for "Set as default for future Histogram visual" should be unchecked
    And Click on "Save"
    And Create a new histogram visual
    Then The Histogram should be created with default format template

  @Histogram
  Scenario: TC_Histogram_278:Edit Histogram - Verify bold style default selection.
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on cogwheel icon for title
    And Check "Title"
    Then The bold icon should be selected by default

  @Histogram
  Scenario: TC_Histogram_279:Edit Histogram - Size - Verify Proportion for the visual
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Open Size dropdown
    And Reduce proportion to 80
    And Click on "Save"
    Then The visual should change its size to selected size

  #@Histogram
  #Scenario: TC_Histogram_280:Edit Histogram - Copyright - Verify expanding and collapsing the copyright sections
    #And Create histogram visual with series
    #And Click on "Edit Histogram"
    #And Check "Copyright"
    #And Open drop down for "Copyright"
    #And Click on "Advanced settings"
    #And Click on - icon in the copyright popup
    #Then The section should be collapsed
    #And Click on + icon in the copyright popup
    #Then The section should be expnaded

  @Histogram
  Scenario: TC_Histogram_281: Edit Histogram - Tooltip - Verify date format
    And Create histogram visual with series
    And Open preference dropdown
     And Clicking on "Date format" option in preference
    And Click "Auto" format date option
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on Date format dropdown
    Then "Auto" format should be selected by default

  @Histogram
  Scenario: TC_Histogram_282: Edit Histogram - Tooltip - Verify date format selection in the dropdown
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on Date format dropdown
    And Select custom Date format  as "YYYY/MM/DD"
    And Click on "Save"
    Then Selected date format should be displayed in visual

  @Histogram
  Scenario Outline: TC_Histogram_283:Edit Histogram - Tooltip - Verify expanding and collapsing the tooltip sections
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Check "Tooltips"
    And Click on cogwheel for advance settings
    And Expand <Tooltip_expand> from "Tooltip" popup
    And Collapse <Tooltip_collapse> from "Tooltip" popup

    Examples: 
      | Tooltip_expand | Tooltip_collapse |
      | "Common"       | "Common"         |
      | "Items"        | "Items"          |
      #| "Border"       | "Border"         |

  @Histogram
  Scenario: TC_Histogram_284:Edit Histogram - Edit series - Verify edit series icon
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on edit series icon
    Then Below options should be available
      | Rename    |
      | Frequency |
      | Currency  |
      | Change    |

  @Histogram
  Scenario: TC_Histogram_285:Edit Histogram - Edit series - Verify search for functions
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on type a function field in series level
    And Search with function "YTD"
    Then Searched functions should be displayed

  @Histogram
  Scenario: TC_Histogram_286:Edit Histogram - Edit series - Verify Region, Unit and Series ID fields
    And Create a histogram visual with series
    And Click on "Edit Histogram"
    Then "Region", "Unit" and "Series id" fields should be available for respective series

  @Histogram
  Scenario: TC_Histogram_287:Edit Histogram - Feedback - Verify Submit and cancel buttons when description field is empty
    And Create histogram visual with series
    And Click on "Edit Histogram"
    And Click on "Feedback" option
    Then Submit and Cancel buttons should be disabled by default

  @Histogram
  Scenario: TC_Histogram_288:Verify right click options
    And Create histogram visual with series
    And Right click on visual header
    Then Verify right click options for histogram visual

  #@Histogram
  #Scenario: TC_Histogram_289:Right click - Verify insert visual sub dropdown
    #And Create histogram visual with series
    #And Right click on visual header
    #Then Verify insert visual sub dropdown options for histogram visual
#
  #@Histogram
  #Scenario: TC_Histogram_290:Right click - Verify View as sub dropdown.
    #And Create histogram visual with series
    #And Right click on visual header
    #Then Verify View as sub dropdown options for histogram visual
    
    #@Histogram
  #Scenario: TC_Histogram_291:Edit series - Verify hiding function toolbar
     #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Hide the function bar"
    #Then The function toolbar should be hidden
    #
     #@Histogram
  #Scenario: TC_Histogram_292:Edit series - Verify showing the function toolbar
     #And Create histogram visual with series
    #And Click on Edit series option
    #And Click on "Hide the function bar"
    #And Click on "Show the function bar"
    #Then The function toolbar should be shown
    
     @Histogram
  Scenario: TC_Histogram_293:Edit series - Verify 'Type a function' field
    And Create histogram visual with series
    And Click on Edit series option
    And Click on type a function field
    And Select any function
    And Click on "Apply"
    Then The selected function should be displayed
