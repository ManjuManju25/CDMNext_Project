Feature: Heat Map feature
		
  @Heatmap
  Scenario: TC_HM_01: Verify creating HeatMap visual from Chart menu
    And Navigate to series Tab
    And Select few series and Add to My series tab
    And Click on select all and right click on the series
    And click on Add chart and click on HeatMap
    Then HeatMap visual should be created

  @Heatmap
  Scenario: TC_HM_04: Verify creating HeatMap visual from View panel by clicking on HeatMap icon
    And Navigate to series Tab
    And Select few Series
    And Click on Create new view tab
    And Click on HeatMap visual icon
    Then HeatMap visual should be created
																		
  @Heatmap
  Scenario: TC_HM_05: Verify HeatMap visual creating with function applied series
    And Navigate to series Tab
    And Create new Insight
    And Select few series and Add to My series tab
    And checked select all check box in my series panel
    And click on fx and apply some functions
    And Create HeatMap on applied function series
    And click on Apply button
    Then verify the functions applied to the visual series

  @Heatmap
  Scenario: TC_HM_06: Verify Series harmonization when visual is created with different frequencies
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed

  @Heatmap
  Scenario: TC_HM_07: Series harmonization - Verify Frequency
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the default lowest value will be selected in Series Harmonization window

  @Heatmap
  Scenario: TC_HM_08: Series harmonization - Verify Frequency Dropdown
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the default lowest value will be selected in Series Harmonization window
    And click on frequency dropdown and verify the frequency dropdown list
    Then Changes made in the frequencies will be applied to all the selected series

  @Heatmap
  Scenario: TC_HM_09: Series harmonization - Verify Missing value method
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    Then verify the "Keep as reported" value will be selected in missing value method on Series Harmonization window

  @Heatmap
  Scenario: TC_HM_10: Series harmonization - Verify Missing value method Dropdown
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And click on Missing value method Dropdown and verify the Missing value method list
    Then Changes made in the Missing value method will be applied to all the selected series

  @Heatmap
  Scenario: TC_HM_11: Series harmonization - Verify Missing value method Dropdown = Specific value
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And click on Missing value method Dropdown and select "Specific value" in dropdown list
    Then By default "1" value will be displayed and changes made in specific value will be reflected in seires

  @Heatmap
  Scenario: TC_HM_12: Series harmonization - Verify Currency conversion
    And Search for the series "1692001;7874601;2126801;369703767;7884401" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    Then verify the "Keep as reported" value default selected in Currency conversion on Series Harmonization window
    Then Verify the "as reported" message display in Currency conversion on Series Harmonization window

  @Heatmap
  Scenario: TC_HM_13: Series harmonization - Verify Currency conversion Dropdown
    And Search for the series "1692001;7874601;2126801;369703767;7884401" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And click on currency conversion Dropdown and verify the keep as reported list
    And click on currency dropdown and verify the "as reported" list
    Then verify the Appropriate changes will be reflected in the series

  @Heatmap
  Scenario: TC_HM_14: Series harmonization - Verify "Keep different frequencies"
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And Click on 'Keep different frequencies' button
    Then HeatMap visual should be created with different frequencies

  @Heatmap
  Scenario: TC_HM_15: Series harmonization - Verify Apply button
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And Select frequencies from 'lowest in group' to 'Daily' and click on Apply button
    Then Verify the HeatMap visual frequencies should be efforted in my series

  @Heatmap
  Scenario: TC_16: Series harmonization - Verify Minimize button
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And Click on minimize button
    Then Verify the Series Harmonization window minimized

  @Heatmap
  Scenario: TC_HM_17: Series harmonization - Verify Full -screen button
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And Click on Full-screen button
    Then Verify the Series Harmonization window fully maximizied

  @Heatmap
  Scenario: TC_HM_18: Series harmonization - Verify Close button
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And Click on close('X') button
    Then Verify the Series Harmonization window fully closed and applied changes will not be affected

  @Heatmap
  Scenario: TC_HM_19: Empty visual - Verify 'Edit HeatMap' button
    And Navigate to series Tab
    And Click on Create new view tab
    And Click on HeatMap visual icon
    Then Verify the 'Edit HeatMap' button should be disabled

  @Heatmap
  Scenario: TC_HM:20: Empty visual - Verify 'Edit series' option
    And Navigate to series Tab
    And Click on Create new view tab
    And Click on HeatMap visual icon
    Then Verify The 'Edit series' panel should be enabled and opened

  @Heatmap
  Scenario: TC_HM_21: Empty visual - Verify default tab for 'Edit series' option
    And Navigate to series Tab
    And Click on Create new view tab
    And Click on HeatMap visual icon
    Then verify the By default user should redirect to "Add from My series" tab

  @Heatmap
  Scenario: TC_HM_22: Empty visual - Verify description message for empty visual if have series in My series
    And Navigate to series Tab
    And Select few series and Add to My series tab
    And Click on Create new view tab
    And Click on HeatMap visual icon
    Then Verify the text on HeatMap visual "Heat map", "Drag series here","Or, ","Add from My Series"

  @Heatmap
  Scenario: TC_HM_23: Empty visual - Verify description message for empty visual if have NO series in My series
    And Navigate to series Tab
    And My series tab should be empty
    And Click on Create new view tab
    And Click on HeatMap visual icon
    Then Verify the text on HeatMap visual "Heat map", "Drag series here"

  @Heatmap
  Scenario: TC_HM_24: Empty visual - Verify Add from my series option
    And Navigate to series Tab
    And Select few series and Add to My series tab
    And Click on Create new view tab
    And Click on HeatMap visual icon
    And Verify the text "Add from my series" and Click on "Add from my series" link
    Then verify the "Add from My Series" panel should be opened

  @Heatmap
  Scenario: TC_HM_25: Empty visual - Verify HeatMap tab when no series added for visual
    And Navigate to series Tab
    And My series tab should be empty
    And Click on Create new view tab
    And Click on HeatMap visual icon
    And Click on 'Edit series' link
    And click on  "HeatMap tab" on Add from My Series panel
    Then verify the description on Add from My Series panel

  @Heatmap
  Scenario: TC_HM_26 &TC_HM_27: Empty visual - Verify "+ Add from My Series" option in edit series panel
    And Navigate to series Tab
    And My series tab should be empty
    And Click on Create new view tab
    And Click on HeatMap visual icon
    And Click on 'Edit series' link
    And click on  "HeatMap tab" on Add from My Series panel
    And click on "+ Add from My Series" link
    Then Verify the redirect to "+ Add from My Series" tab

  @Heatmap
  Scenario: TC_HM_28: Empty visual - Verify adding series to empty visual
    And Navigate to series Tab
    And Select few series and Add to My series tab
    And Click on Create new view tab
    And Click on Drag- and-drop to Heat Map
    And Click on 'Edit series' link
    And Checked select all check box
    And click on Apply button
    Then Verify The series should be added to HeatMap with its data
					
  @Heatmap
  Scenario: TC_HM_29: Verify default attributes for HeatMap visual
    And Navigate to series Tab
    And Select few series and Add to My series tab
    And Click on Create new view tab
    And Click on HeatMap visual icon
    And Click on 'Edit series' link
    And Checked select all check box
    And click on Apply button
    And mouse hover on the series name and verify the Attributes

  @Heatmap
  Scenario: TC_HM_30: Verify clicking on series
    And Navigate to series Tab
    And Select few Series
    And Click on Create new view tab
    And Click on HeatMap visual icon
    Then HeatMap visual should be created
    Then Click on series on HeatMap visual and Verify the Series info popup (SSP) should be opened

  @Heatmap
  Scenario: TC_HM_31: Verify Edit series on visual
    And Navigate to series Tab
    And Select few Series
    And Click on Create new view tab
    And Click on HeatMap visual icon
    And click on Apply button
    Then HeatMap visual should be created
    And Mouse move on series name and click on cogwheel icon
    And Verify the dropdown list

  @Heatmap
  Scenario: TC_HM_32: Verify Rename option from cogwheel icon
    And Navigate to series Tab
    And Select few Series
    And Click on Create new view tab
    And Click on HeatMap visual icon
    And click on Apply button
    Then HeatMap visual should be created
    And Mouse move on series name and click on cogwheel icon
    Then Click on rename and verify the Rename popup should be displayed

  @Heatmap
  Scenario: TC_HM_33: Verify Frequency option from cogwheel icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Mouse move on series name and click on cogwheel icon
    And Mouse hover on "Frequency" and verify the dropdown list
    Then Verify the selected frequency applied to the series

  @Heatmap
  Scenario: TC_HM_34: Verify Currency option from cogwheel icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And mouse over on series name and click on cogwheel icon
    And click on "Currency" and verify the dropdown list
    Then Verify the selected currency applied to the series

  @Heatmap
  Scenario: TC_HM_35: Verify Change option from cogwheel icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And mouse over on series name and click on cogwheel icon
    And click on 'Change' and verify the dropdown list
    Then Verify the selected 'Change' applied to the series

  @Heatmap
  Scenario: TC_HM_36: Verify Remove series icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Mouse move on series and Click on Remove series(x)
    Then Verify The series should be removed from the visual

  @Heatmap
  Scenario: TC_HM_37: Verify double click on title
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Double click on title and Verify the Title popup should be displayed

  @Heatmap
  Scenario: TC_HM_38: Verify clicking on edit visual icon for title
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    Then Click on edit visual title icon and Verify the Title popup should be displayed

  @Heatmap
  Scenario: TC_HM_41: Verify Double Click on Date
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Double click on dates
    Then Verify the "Time Axis" window popup is displayed

  @Heatmap
  Scenario: TC_43: Edit series - Verify Edit series option for HeatMap visual
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then Verify the Edit series panel opened with "HeatMap" tab

  @Heatmap
  Scenario: TC_HM:44: Edit series - Verify series under HeatMap tab
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then Verify the Edit series panel opened with "HeatMap" tab
    Then Verify the Associated series should be available

  @Heatmap
  Scenario: TC_HM_45: Edit series - Verify Rename option
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    Then Verify the "Rename" popup should be displayed

  @Heatmap
  Scenario: TC_HM:46: Rename - Verify default mouse focus
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then Verify the Edit series panel opened with "HeatMap" tab
    And Click on Rename option
    Then By default "Find" field should be focused

  @Heatmap
  Scenario: TC_HM:47: Rename - Verify number of selected series
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    Then Verify the Number of selected series count should be shown on the rename popup header

  @Heatmap
  Scenario: TC_HM_48: Rename - Verify number of available items
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then Verify the Edit series panel opened with "HeatMap" tab
    And Click on Rename option
    Then Verify the Number of available series count should be shown under the find field

  @Heatmap
  Scenario: TC_HM_49 & TC_HM_50: Rename - Verify find field and Rename -  Verify number of searched result
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then Verify the Edit series panel opened with "HeatMap" tab
    And Click on Rename option
    Then Search for the series in find field and verify the Result should be loaded for searched keyword

  @Heatmap
  Scenario: TC_HM_51 & TC_HM_52: Rename - Verify Replace field and Rename - Verify 'Replace' button
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then Verify the Edit series panel opened with "HeatMap" tab
    And Click on Rename option
    And Search for the series you want to rename in find field
    And Enter keyword in replace field and click on Replace button
    And Click on Rename option
    Then Verify the searched keyword should be replaced with entered keyword in series names

  @Heatmap
  Scenario: TC_HM_53: Rename - Verify 'Replace All' button
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Search for the series you want to rename in find field
    And Enter keyword in replace field and click on Replace All button
    And Click on 'OK' button
    Then verify the replace name updated or not in Edit series popup

  @Heatmap
  Scenario: TC_HM_55: Rename - Verify find next button
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    Then find Next Button should be disabled always

  @Heatmap
  Scenario: TC_HM_56: Rename - Verify Replace, Replace All and find next buttons by default
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    Then Replace,ReplaceAll and Find Next buttons should be disabled

  @Heatmap
  Scenario: TC_HM_57: Rename - Verify for invalid search
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Search with invalid series name
    Then Verify the "No matches found" should be displayed under the find field

  @Heatmap
  Scenario: TC_HM_58: Rename - Verify 'Edit series info' dropdown
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    Then Click on Edit series info dropdown and verify the dropdown list

  @Heatmap
  Scenario: TC_HM_59: Rename - Verify default selection for 'Edit series info' dropdown
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    Then Verify the By default "Name" should be selected in Edit series info field

  @Heatmap
  Scenario: TC_HM:60: Rename - Verify 'Name' selection
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "name"
    Then Verify the Series should be displayed by name

  @Heatmap
  Scenario: TC_HM_61: Rename - Verify 'Function description' selection
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "function_description"
    Then Verify the Series should be displayed by "function_description"

  @Heatmap
  Scenario: TC_HM_62: Rename - Verify function description selection without function apply
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And Click on 'Close' button on Series Harmonization window
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "function_description"
    Then Verify the "Empty rows" should be displayed since no description

  @Heatmap
  Scenario: TC_HM_63: Rename - Verify editing function description
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "function_description"
    And Edit the Series function description and click on "OK" button
    Then Verify the edit function discription should be updated in 'edit series panel'

  @Heatmap
  Scenario: TC_HM_65: Rename - Function discription - Verify apply original title icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "function_description"
    And Update the Series Function Description
    Then Verify the 'Apply original title' (<) should be enabled

  @Heatmap
  Scenario: TC_HM_66: Rename - Function discription -Verify Apply original title icon behavior
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "function_description"
    And Update the Series Function Description
    And Click on 'Apply original title' (<) icon
    Then Verify The changes should be reverted to original title

  @Heatmap
  Scenario: TC_HM_67: Rename - Function discription - Verify "Apply original title for all series" icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "function_description"
    And Update the Series Function Description
    And Click on 'Original titles to all series'(<) icon next to 'Original Function description'
    Then Verify The changes should be reverted to original title

  @Heatmap
  Scenario: TC_HM_68: Rename - Function discription - Verify clicking on series name
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "function_description"
    And Click on Series Name
    Then Verify The SSP window should be displayed

  @Heatmap
  Scenario: TC_HM_69 and 70: Rename - Name - Verify Editing series name and Verify Apply original title icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "name"
    And Edit the Series Title and click on "OK" button
    Then Verify the Series name updated in visual series
    And Click on Rename option
    And Click on 'Apply original title' (<) icon
    Then Verify the changes should be reverted to original series name

  @Heatmap
  Scenario: TC_HM_71:Rename - Name - Verify "Apply original title for all series" icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "name"
    And Edit the Series Title and click on "OK" button
    And Click on Rename option
    And Click on 'Apply original title for all series' (<) icon
    Then Verify the changes should be reverted to original series name

  @Heatmap
  Scenario: TC_HM_72:Rename - Verify '<' icon if no changes in series attributes
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "name"
    Then Verify the The '<' icon should be disabled if no changes

  @Heatmap
  Scenario: TC_HM_73: Rename - Verify Region selection
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "country"
    Then Verify The Series displayed by Region

  @Heatmap
  Scenario: TC_HM_74: Rename - Rename region
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name "+" icon and select "Region"
    And Click on Edit series info dropdown Select "country"
    And Edit the Series Title and click on "OK" button
    Then Verify The region should be renamed for the series

  @Heatmap
  Scenario: TC_HM_76: Rename - Region - Verify Apply original region icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name "+" icon and select "Region"
    And Click on Edit series info dropdown Select "country"
    And Edit the Series Title and click on "OK" button
    And Click on Rename option
    And Click on Edit series info dropdown Select "country"
    And Click on '<' icon apply orginal title
    And Click on 'OK' button
    And Click on Rename option
    And Click on Edit series info dropdown Select "country"
    Then Verify The Rename - Region - Verify Apply original region icon

  @Heatmap
  Scenario: TC_HM_77: Rename - Region - Verify "Apply original region for all series" icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name "+" icon and select "Region"
    And Click on Edit series info dropdown Select "country"
    And Edit the Series Title and click on "OK" button
    And Click on Rename option
    And Click on Edit series info dropdown Select "country"
    And Click on '<' icon apply orginal titles to all series
    And Click on 'OK' button
    And Click on Rename option
    And Click on Edit series info dropdown Select "country"
    Then Verify The Rename - Region - Verify Apply original region icon

  @Heatmap
  Scenario: TC_HM_78: Rename - unit - Verify Editing series unit
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name '+' icon and select "Unit"
    And Click on Edit series info dropdown Select "unit"
    And Edit the Series Unit and click on "OK" button
    Then Verify The Editing series Unit updated in visual series

  @Heatmap
  Scenario: TC_HM_79: Rename - unit - Verify 'Apply original title icon'
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name '+' icon and select "Unit"
    And Click on Edit series info dropdown Select "unit"
    And Edit the Series Unit and click on "OK" button
    And Click on Rename option
    And Click on Edit series info dropdown Select "unit"
    And Click on '<' icon apply orginal title
    And Click on 'OK' button
    And Click on Rename option
    And Click on Edit series info dropdown Select "unit"
    Then Verify The changes should be reverted to original series unit

  @Heatmap
  Scenario: TC_HM_80: Rename - unit - Verify "Apply original unit for all series" icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name '+' icon and select "Unit"
    And Click on Edit series info dropdown Select "unit"
    And Edit the Series Unit and click on "OK" button
    And Click on Rename option
    And Click on Edit series info dropdown Select "unit"
    And Click on '<' icon apply orginal titles to all series
    And Click on 'OK' button
    And Click on Rename option
    And Click on Edit series info dropdown Select "unit"
    Then Verify All the changes should be revert back with original unit

  @Heatmap
  Scenario: TC_HM_81: Rename - frequency - Verify Editing series frequency
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name '+' icon and Select "Frequency"
    And Click on Edit series info dropdown Select "frequency"
    And Edit the Series Frequency and click on "OK" button
    Then Verify The Editing series Frequency updated in visual series

  @Heatmap
  Scenario: TC_HM_82: Rename - frequency - Verify 'Apply original title icon'
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name '+' icon and Select "Frequency"
    And Click on Edit series info dropdown Select "frequency"
    And Edit the Series Frequency and click on "OK" button
    And Click on Rename option
    And Click on Edit series info dropdown Select "frequency"
    And Click on '<' icon apply orginal title icon
    And Click on 'OK' button
    And Click on Rename option
    And Click on Edit series info dropdown Select "frequency"
    Then Verify The changes should be reverted to original series frequency

  @Heatmap
  Scenario: TC_HM_83: Rename - frequency - Verify "Apply original titles to all series" icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Auto name '+' icon and Select "Frequency"
    And Click on Edit series info dropdown Select "frequency"
    And Edit the Series Frequency and click on "OK" button
    And Click on Rename option
    And Click on Edit series info dropdown Select "frequency"
    And Click on '<' icon apply orginal titles to all series icon
    And Click on 'OK' button
    And Click on Rename option
    And Click on Edit series info dropdown Select "frequency"
    Then Verify All the changes should be revert back with original frequency

  @Heatmap
  Scenario: TC_HM_84: Rename - Verify Auto name check box
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    Then checkbox should be checked by default.

  @Heatmap
  Scenario: TC_HM_85: Rename - Verify attributes dropdown
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Open dropdown for auto name and Verify the dropdown data

  @Heatmap
  Scenario: TC_HM_86: Rename - Verify selection of attributes
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Open dropdown for auto name
    And Select Anyone Attribute
    And Click on Apply/save button
    Then Verify The visual series name should be displayed as selected attribute

  @Heatmap
  Scenario: TC_HM_87: Rename - Verify selecting 'multiple attributes' for series name
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Open dropdown for auto name
    And Select multiple Attribute
    And Click on Apply/save button
    Then Verify The Selected attributes should be displayed as series name

  @Heatmap
  Scenario: TC_HM_88: Rename - Veriy series in My series after visual series renamed
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And remove the applied functions
    And Click on Open dropdown for auto name
    And click on Region in the dropdown.
    And Click on Apply/save button
    Then changess should be applied only to visual and series in edit series.

  @Heatmap
  Scenario: TC_HM_89: Rename - Verify 'Apply' button
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "name"
    And Edit the series name
    And Click on 'Apply' button
    Then Verify The changes should be saved and rename popup remains displayed

  @Heatmap
  Scenario: TC_HM_90: Rename - Verify OK button
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Edit series info dropdown Select "name"
    And Edit the series name
    And Click on 'OK' button
    Then Verify The changes should be saved and applied to visual series in edit series panel and the popup should be closed

  @Heatmap
  Scenario: TC_HM_91: Rename - Minimize option
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on minimize button
    Then Verify The minimize popup should be minimized

  @Heatmap
  Scenario: TC_HM_92: Rename - Verify maximize option
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on minimize button
    And click on maximized button
    Then Verify The popup should be 'maximized'

  @Heatmap
  Scenario: TC_HM_93: Rename - Verify full-screen
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Full-screen button
    Then Verify The popup should be displayed in full-screen

  @Heatmap
  Scenario: TC_HM_94: Rename - Verify exit full screen
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on Full-screen button
    And Click on 'Exit full-screen' option
    Then Verify The popup should be displayed in normal size

  @Heatmap
  Scenario: TC_HM_95: Rename - Verify Cancel/x icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on Rename option
    And Click on close('X') button
    Then Verify The rename popup should be 'closed'

  @Heatmap
  Scenario: TC_HM_96: Rename - Verify opening rename popup by keyboard shortcut
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Press "Ctrl+H" on keyboard
    Then Verify The 'Rename' popup should be displayed
    And Click on 'OK' button
		
  @Heatmap
  Scenario: TC_HM_97: Edit series - Verify appling 'Currency conversation' function
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on currency and select "USD"
    Then Verify the Selected currency should be applied to all series

  @Heatmap
  Scenario: TC_HM_98: Edit series - Verify appling 'Calculate change' function
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Change" and select "Difference Year-over-Year (YoY)"
    Then Verify the Selected function should be applied to all series

  @Heatmap
  Scenario: TC_HM_99: Edit series - Verify 'Aggregate' function apply
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on 'Aggregate' and Select "Yearly (SUM)"
    Then Verify the 'Aggregate' function should be applied to all series

  @Heatmap
  Scenario: TC_HM_100: Edit series - Verify 'Accumulate' function apply
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Accumulate" and Select "YTD"
    Then Verify the 'Accumulate' function should be applied to all series

 # @Heatmap
 # Scenario: TC_HM_101: Edit series - Verify 'FX more' drop down
 #  And Navigate to series Tab
 #   And Search for the series "7874301;249445301" with different frequencies
 #   And "2" check boxs checked
 #   And right click on checked series
 #   And click on Add chart and click on HeatMap
#    And click on Apply button
 #   And Click on Edit series
 #   And Click on 'FX' More dropdown and select any option
 #   Then Verify The Selected 'FX' function should be applied to all series

#  @Heatmap
 # Scenario: TC_HM_102: Edit series - Verify 'FX more' icon
    And Navigate to series Tab
    And Search for the series "1692001;7874601;2126801;292514601;369703887" with different frequencies
    And checked selected series
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on FX more icon
    Then Verify The "Apply functions to visual series" popup should be opened

  @Heatmap
  Scenario: TC_HM_106: Edit series - Verify 'Type a function' field
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Type a function" area
    Then Verify The List of functions dropdown should be opened and selected functions should be applied to the series

  @Heatmap
  Scenario: TC_HM_107: Edit series - Verify FX icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on FX icon next to a Type function
    Then Verify The "Apply functions to visual series" popup should be opened

  @Heatmap
  Scenario: TC_HM_108: Edit series - Verify delete series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on 'X' icon in Edit series panel for a series
    Then Verify The series should be removed from the visual and edit series panel

  @Heatmap
  Scenario: TC_HM_109: Edit series - Verify 'delete all series' icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on 'X' icon for attribute(Next to name)
    Then Verify The All the series should be removed from the visual and edit series panel

  @Heatmap
  Scenario: TC_HM_110: Edit series - Verify SSP by clicking on series name
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on series name in Edit series panel
    Then Verify The SSP popup should be displayed

  @Heatmap
  Scenario: TC_HM_111: Edit series - Verify Rename series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Mouse move on series and Click on 'rename series icon'
    Then Verify The Rename popup should be displayed for selected series

  @Heatmap
  Scenario: TC_HM_112: Edit series - Verify edit series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Mouse move on series and Click on 'Edit series' icon
    Then Verify The data in Edit dropdown list

  @Heatmap
  Scenario: TC_HM_113: Edit series - Verify Rename option under edit series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Mouse move on series and Click on 'Edit series' icon
    And Click on "Rename"  on Edit series Dropdwon list
    Then Verify Rename popup should be displayed for selected series

  @Heatmap
  Scenario: TC_HM_114: Edit series - Verify 'Frequency' option under edit series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Mouse move on series and Click on 'Edit series' icon
    And Click on "Frequency" on Edit series and select anyone on Dropdwon list
    Then Verify The Selected function should be applied to the series

  @Heatmap
  Scenario: TC_HM_116: Edit series - Verify 'Change' option under edit series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Mouse move on series and Click on 'Edit series' icon
    And Click on "Change" on Edit series and select anyone on dropdown listt
    Then Verify the Selected 'Change' should be applied to all series

  @Heatmap
  Scenario: TC_HM_117: Edit series - Verify clicking on frequency or dropdown
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on 'Frequency' or its dropdown in Edit series
    Then verify the Series Harmonization window is displayed

  @Heatmap
  Scenario: TC_HM_118: Edit series - Series data conversion - Verify applying frequency
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on 'Frequency' or its dropdown in Edit series
    And Select any 'Frequency' from dropdown in Series data conversion popup
    And click on Apply button
    Then Verify The selected frequency should be applied to available series

  @Heatmap
  Scenario: TC_HM_119: Edit series - Series data conversion - Verify applying Missing values method
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on 'Frequency' or its dropdown in Edit series
    And Select any 'Missing values mathod' from dropdown in Series data conversion popup
    And click on Apply button
    Then Verify The "Missing values method" should be applied with selected series

  @Heatmap
  Scenario: TC_HM_121: Edit series - Frequency - Minimize option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Frequency" Dropdown
    And Click on minimize button
    Then Verify the Series Harmonization window minimized

  @Heatmap
  Scenario: TC_HM_122: Edit series- Frequency - Verify maximize option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Frequency" Dropdown
    And Click on minimize button
    And click on maximized button
    Then Verify The popup should be 'maximized'

  @Heatmap
  Scenario: TC_HM_123: Edit series - Frequency - verify full-screen
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Frequency" Dropdown
    And Click on Full-screen button
    Then Verify The popup should be displayed in full-screen

  @Heatmap
  Scenario: TC_HM_124: Edit series - verify exit full screen
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Frequency" Dropdown
    And Click on Full-screen button
    And Click on 'Exit full-screen' option
    Then Verify The popup should be displayed in normal size

  @Heatmap
  Scenario: TC_HM_125: Edit series - Verify Cancel/x icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "Frequency" Dropdown
    And Click on close('X') button
    Then Verify The rename popup should be 'closed'

  @Heatmap
  Scenario: TC_HM_126: Edit series - Verify dropdown for frequency in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on dropdown for frequency in series level
    Then Verify The List of applicable frequencies should be available under the dropdown

  @Heatmap
  Scenario: TC_HM_127: Edit series - Verify appling frequency in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on dropdown for frequency in series level
    And select any frequency

  @Heatmap
  Scenario: TC_HM_128: Edit series - Verify appling currency in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on dropdown for currency in series level
    And select any currency

  @Heatmap
  Scenario: TC_HM_129: Edit series - Verify clicking on type a function field
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And click on type a function field in series level

  @Heatmap
  Scenario: TC_HM_130: Edit series - Verify appling function in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And close the Series Harmonization window
    And Click on Edit series
    And click on type a function field in series level
    Then select function=>click on Apply function.
#(CVISION-22547)
  @Heatmap
  Scenario: TC_HM_132: Edit series - Verify multiple functions apply
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And click on type a function field in series level
    Then select multiple functions=>click on Apply function.

  @Heatmap
  Scenario: TC_HM_133: Edit series - Verify search for functions
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And click on type a function field in series level
    Then search for functions=>Searched function should display.
#(CVISION-22547)
  @Heatmap
  Scenario: TC_HM_134: Edit series - Verify removing applied functions
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And close the Series Harmonization window
    And Click on Edit series
   	And apply a function in series level
    Then remove the applied function.

  @Heatmap
  Scenario: TC_HM_135: Edit series - Verify applied funtion in function toolbar
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And close the Series Harmonization window
    And Click on Edit series
    And click on type a function field in series level
    Then select function=>click on Apply function.
    Then function should be displayed in toolbar.

  @Heatmap
  Scenario: TC_HM_136: Edit series - Verify appling invalid function for series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And click on type a function field in series level
    And select Invalid function for series.
    Then function cannot be applied popup should be displayed.

  @Heatmap
  Scenario: TC_HM_137: Edit seires - Verify OK button on "The function cannot be applied to selected series" popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And click on type a function field in series level
    And select Invalid function for series.
    And function cannot be applied popup should be displayed.
    Then popup should be closed.

  @Heatmap
  Scenario: TC_HM_138:Edit series - Verify Region, Unit and Series ID fields.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then check for region, unit and seriesId fields.

  @Heatmap
  Scenario: TC_HM_139:Edit series - Verify horizontal scroll bar for series.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    Then Horizontal scroll bar should be available and all series attributes displayed upon moving.

  @Heatmap
  Scenario: TC_HM_140: Edit series - Verify "+Add from my series" option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on '+Add from My series' option
    Then Verify User should redirect to "+Add from my series" tab

  @Heatmap
  Scenario: TC_HM_144: Edit series - Verify default sort by in add from my series tab.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series=>Myseries
    Then by default checked sortby should be applied in ascending order.

  @Heatmap
  Scenario: TC_HM_145: Edit seires - Verify Edit series option on visual if edit series panel is opened
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Verify the Edit series popup open and edit series option should be disabled if already opened

  @Heatmap
  Scenario: TC_HM_146: Edit series - Verify edit series panel close
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Edit series
    And Click on "x" icon to close the edit series panel
    Then Verify The edit series panel should be closed

  @Heatmap
  Scenario: TC_HM_147: Verify Edit HeatMap for the visual created
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    Then Verify The "Edit visual" popup should be displayed

  @Heatmap
  Scenario: TC_HM_148: Edit HeatMap - Verify Style Save button for creating template.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    Then Verify Name your style popup should be displayed

  @Heatmap
  Scenario: TC_HM_149: Edit HeatMap - Verify auto naming for template
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    Then Verify Auto name should be available as "My template1, My template 2…

  @Heatmap
  Scenario: TC_HM_150: Edit HeatMap - Edit HeatMap - Verify template creating
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Click on Save new style
    Then Verify The New template should be created with the current changes

  @Heatmap
  Scenario: TC_HM_151: Edit HeatMap - Verify Cancel icon for template popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Click on cancel button for template popup
    Then Verify The template popup should closed

  @Heatmap
  Scenario: TC_HM_152: Edit HeatMap - Verify selection of created template
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Select the created template and Click on Save button
    And click on 'Save' button
    Then Verify The customized settings should be applied to visual

  @Heatmap
  Scenario: TC_HM_153: Edit HeatMap - Verify dropdown for template
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on styles dropdown for template
    Then Verify CEIC styles Default & Solid color templates should be available

  @Heatmap
  Scenario: TC_HM_154: Edit HeatMap - Verify 'Set as default for future HeatMap visual' is checked
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Click on Save new style
    And click on 'Save' button
    And Click on 'Edit HeatMap'
    And Check the box for 'Set as default for future HeatMap visual'
    And click on 'Save' button
    And Click on "myseries" in right side
    And Checked Select all checkbox
    And mouseover on series name and right click on mouse
    And click on Add chart and click on HeatMap
    And click on Apply button
    Then Verify The HeatMap should be created with the format of previous template selection

  @Heatmap
  Scenario: TC_HM_155: Edit HeatMap - Verify 'Set as default for future HeatMap visual' is Unchecked.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Click on Save new style
    And click on 'Save' button
    And Click on 'Edit HeatMap'
    And Uncheck the box for 'Set as default for future HeatMap visual'
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    Then Verify The HeatMap should be created with default format template

  @Heatmap
  Scenario: TC_HM_156: Edit HeatMap - Verify delete template icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Click on Save new style
    And Click on delete template icon
    Then Verify the Confirmation popup should be displayed to delete template

  @Heatmap
  Scenario: TC_HM_157: Edit HeatMap - Verify description for confirmation popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Click on Save new style
    And Click on delete template icon
    Then Verify the description for confirmation popup

  @Heatmap
  Scenario: TC_HM_158: Edit HeatMap - Verify OK button on confirmation popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Make some changes in 'Edit visual' popup
    And Click on Save in Edit visual
    And Click on Save new style
    And Click on delete template icon
    Then Click on "Ok" button on popup
    Then Verify The template should be deleted from the list
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_159: Edit HeatMap - Verify cancel/x icon on confirmation popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Save in Edit visual
    And Click on Save new style
    And click on 'Save' button
    And Click on 'Edit HeatMap'
    And Click on delete template icon
    And Click on cancel/X icon on confirmation popup
    Then Verify The confirmation popup should be closed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_161: Edit HeatMap -  Title - Verify Title=Yes
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Edit visual and Title=Check
    Then Verify The title of the visual should be displayed

  @Heatmap
  Scenario: TC_HM_160: Edit HeatMap -  Title - Verify default selection for title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Edit visual and by default Title checked
    Then Verify The title of the visual should be displayed

  @Heatmap
  Scenario: TC_HM_161: Edit HeatMap -  Title - Verify Title=NO
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Edit visual and Title=Uncheck
    Then Verify The title of the visual should be removed

  @Heatmap
  Scenario: TC_HM_163:Edit HeatMap -  Title - Verify Auto title
    And Navigate to series Tab
    And Search for the series "7874301" and select checkbox
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Edit visual and by default Title checked
    And Make empty in title field
    And click on 'Save' button
    Then Auto Title should be displayed as series name

  @Heatmap
  Scenario: TC_HM_164: Edit HeatMap - Title - Verify renaming title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Edit visual and by default Title checked
    And Enter title name in title field
    And click on 'Save' button
    Then Verify The title name should be changed

  @Heatmap
  Scenario: TC_HM_165: Edit HeatMap - Title - Verify sub title by default
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    Then Verify The sub title check box should be 'unchecked' by default
    
  @Heatmap
  Scenario: TC_HM_166: Edit HeatMap - Title - Verify sub title=Check
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    Then Verify The sub title check box should be 'checked'
    And click on 'Save' button
    Then Verify The Sub title should be displayed for the visual

  @Heatmap
  Scenario: TC_HM_167: Edit HeatMap - Title - Verify sub title=Uncheck
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Uncheck the sub title check box
    And click on 'Save' button
    Then Verify The 'Sub title' should not be displayed for the visual

  @Heatmap
  Scenario: TC_HM_168: Edit HeatMap - Title - Verify default title for sub title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    Then Verify The sub title check box should be 'checked'
    And click on 'Save' button
    Then Verify the Default sub title is "Sub title" displayed

  @Heatmap
  Scenario: TC_HM_171: Edit HeatMap - Title - Verify color for visual title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title='Check' and Select color
    And click on 'Save' button
    Then Verify the Visual title should be displayed in selected color

  @Heatmap
  Scenario: TC_HM_172: Edit HeatMap - Title - Verify color for visual title background
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and Select color for title background 'highlight'
    And click on 'Save' button
    Then Verify the Visual title background should be displayed in selected color

  @Heatmap
  Scenario: TC_HM_173: Edit HeatMap - Title - Verify font size for visual title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and Select size for visual title "20"
    And click on 'Save' button
    Then Verify The title font size should be changed as per the selection

  @Heatmap
  Scenario: TC_HM_174 and 175: Edit HeatMap - Title - Verify bold style default selection
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and bold icon selected by default
    And click on 'Save' button
    Then Verify The title should be displayed in Bold format

  @Heatmap
  Scenario: TC_HM_176: Edit HeatMap - Title - Verify Italic style for visual title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and Click on 'Italic icon'
    And click on 'Save' button
    Then Verify The title should be displayed in 'Italic' format

  @Heatmap
  Scenario: TC_HM_177:Edit HeatMap - Title - Verify Underline style for visual title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and 'Underline icon'
    And click on 'Save' button
    Then Verify The title should be 'underlined'

  @Heatmap
  Scenario: TC_HM_178:Edit HeatMap - Title - Verify horizontal alignment (left, right, center)
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and Select alignment "left"
    And click on 'Save' button
    Then Verify The Title should align to "left" side
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and Select alignment "right"
    And click on 'Save' button
    Then Verify The Title should align to 'right' side
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Verify the Title ='Check' and Select alignment "center"
    And click on 'Save' button
    Then Verify The Title should align to 'center'

  @Heatmap
  Scenario: TC_HM_179: Edit HeatMap - Title - Verify color for visual sub title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "Sub-title"icon and Checked 'Sub-title'
    And Select color in Edit visual
    And click on 'Save' button
    Then Verify The Visual 'sub title' should be displayed in 'selected color'

  @Heatmap
  Scenario: TC_HM_180: Edit HeatMap - Verify color for visual sub title background
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "Sub-title"icon and Checked 'Sub-title'
    And Select color for Sub title background 'highlight'
    And click on 'Save' button
    Then Verify The Visual sub title background should be displayed in selected color

  @Heatmap
  Scenario: TC_HM_181: Edit HeatMap - Title - Verify font size for visual sub title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "Sub-title"icon and Checked 'Sub-title'
    And Select size for visual Sub title ex: "20"
    And click on 'Save' button
    Then Verify The sub title 'font size' should be changed as per the selection

  @Heatmap
  Scenario: TC_HM_182: Edit HeatMap - Title - Verify bold style for visual sub title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "Sub-title"icon and Checked 'Sub-title'
    And Click on 'Bold' icon
    And click on 'Save' button
    Then Verify The sub title should be displayed in 'Bold' formate

  @Heatmap
  Scenario: TC_HM_183: Edit HeatMap - Title - Verify Italic style for visual sub title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "Sub-title"icon and Checked 'Sub-title'
    And Click on 'Italic' icon
    And click on 'Save' button
    Then Verify The sub title should be displayed in 'Italic' format

 @Heatmap
  Scenario: TC_HM_184:Edit HeatMap - Verify Underline style for visual sub title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "Sub-title"icon and Checked 'Sub-title'
    And Click on 'Underline' icon
    And click on 'Save' button
    Then Verify The sub title should be displayed in 'underlined'

  @Heatmap
  Scenario: TC_HM_185: Edit HeatMap - Title - Verify horizontal alignment (left, right, center)
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "Sub-title"icon and Checked 'Sub-title'
    And Select alignment "left" side
    And click on 'Save' button
    Then Verify the sub-title should be displayed in 'Left' side
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on 'sub-title' icon
    And Select alignment "right" side
    And click on 'Save' button
    Then Verify the sub-title should be displayed in 'Right' side
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on 'sub-title' icon
    And Select alignment "center" side
    And click on 'Save' button
    Then Verify the sub-title should be displayed in 'center'

  @Heatmap
  Scenario: TC_HM_186: Edit HeatMap - Title - Verify expanding and collapsing the title and subtitle sections
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on +/- icons in the popup to get the title and subtitle sections expand/collapse
    Then Verify The sections should be expnaded/collapsed

  @Heatmap
  Scenario: TC_HM_187: Edit HeatMap - Title - Verify closing of Titles popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on Edit visual
    And Click on "×" icon on Titles popup
    Then Verify The Titles popup should be closed

  @Heatmap
  Scenario: TC_HM_188: Edit HeatMap - 'Border' - Verify HeatMap color
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check 'Heat map'  checkbox
    And Click on color and select color
    And click on 'Save' button
    Then Verify The 'Border' should be displayed for HeatMap with selected color

  @Heatmap
  Scenario: TC_HM_189: Edit HeatMap - Border - Verify HeatMap width
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check 'Heat map'  checkbox
    And Select width to "5"
    And click on 'Save' button
    Then Verify The HeatMap 'border width' should be changed as per the selction

  @Heatmap
  Scenario: TC_HM_190: Edit HeatMap - Border - Verify HeatMap radius
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check 'Heat map'  checkbox
    And Select radius to "15"
    And click on 'Save' button
    Then Verify The selected 'border radius' should be applied to the HeatMap

  @Heatmap
  Scenario: TC_HM_191: Edit HeatMap - Border - Verify HeatMap style
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check 'Heat map'  checkbox
    And select style for HeatMap.
    Then selected border is applied to visual.

  @Heatmap
  Scenario: TC_HM_192: Edit HeatMap - Verify Border=NO for visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And click on 'Save' button
    Then Defaultly visual check box uncheck and Verify The Border should not be seen for visual

  @Heatmap
  Scenario: TC_HM_193: Edit HeatMap - Verify Border=Yes for visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check visual check box
    And click on 'Save' button
    Then Verify The Border should be displayed for visual

  @Heatmap
  Scenario: TC_HM_194: Edit HeatMap - Border - Verify visual color
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check visual check box
    And Click on color and select border color
    And click on 'Save' button
    Then Verify The 'Border' should be displayed for visual with selected color

  @Heatmap
  Scenario: TC_HM_195: Edit HeatMap - Border - Verify visual width
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check visual check box
    And Select border width to "5"
    And click on 'Save' button
    Then Verify The visual border width should be changed as per the selction

  @Heatmap
  Scenario: TC_HM_196: Edit HeatMap - Border - Verify visual Radius
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Check visual check box
    And Select Radius as "15"
    And click on 'Save' button
    Then Verify The Radius should be changed as per selection

  @Heatmap
  Scenario: TC_HM_198: Edit HeatMap - Border - Verify advance settings
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border dropdown
    And Click on 'Advanced settings' link
    Then Verify The Visual popup should be opened with "Heat map border" and "Visual background"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_199: Edit HeatMap - Border - Verify advance settings cogwheel
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Border cogwheel icon (open advance settings popup)
    Then Verify The Visual popup should be opened with "Heat map border" and "Visual background"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_200: Edit HeatMap - Verify Background=NO for visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background dropdown
    And visual check box unchecked defaultly
    And click on 'Save' button
    Then Verify The Background should not be seen for visual

  @Heatmap
  Scenario: TC_HM_201: Edit HeatMap - Verify Background=Yes for visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background dropdown
    And Check on visual check box
    And click on 'Save' button
    Then Verify The Background should be displayed for visual

  @Heatmap
  Scenario: TC_HM_202: Edit HeatMap - Background - Verify visual color
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background dropdown
    And Check on visual check box
    And Click on color and Select Color
    And click on 'Save' button
    Then Verify The Background should be displayed for visual with selected color

  @Heatmap
  Scenario: TC_HM_203: Edit HeatMap - Background - Verify background image
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background dropdown
    And Check on visual check box
    And Click on Browse and Select image
    And click on 'Save' button
    Then Verify The Selected image should be displayed as background of HeatMap visual

  @Heatmap
  Scenario: TC_HM_204: Edit HeatMap - Background - Verify visual Opacity
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background dropdown
    And Check on visual check box
    And Select Opacity as "30"
    And click on 'Save' button
    Then Verify The Opacity should be updated on visual

  @Heatmap
  Scenario: TC_HM_205: Edit HeatMap - Background - Verify advance settings
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background dropdown
    And Click on Advance settings
    Then Verify The Visual popup should be opened with "Heat map border" and "Visual background"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_206: Edit HeatMap - Background - Verify advance settings cogwheel
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background cogwheel iocn
    Then Verify The Visual popup should be opened with "Heat map border" and "Visual background"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_Hm_207: Edit HeatMap - Background - Verify closing of visual popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    Then verify the Series Harmonization window is displayed
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on background cogwheel iocn
    And Click "×" icon on visual popup
    Then Verify The popup should be closed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_208: Edit HeatMap - Verify size of visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    Then Verify The Default size "100% x 100%" should be displayed in visual dropdown
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_209: Edit HeatMap - Verify horizontal alignement for size
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on size dropdown
    Then Verify The Horizontal allignment options should be 'disabled'
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_210: Edit HeatMap - Verify proportion for size
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on size dropdown
    Then Verify The X-axis should be set to "100" with enable state & Y-axis should be set to "100" with disable state
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_211: Edit HeatMap - Verify enabling horizontal proportions for visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on size dropdown
    And Change the Proportion X-axis "30"
    Then verify The horizontal alignment options should be 'Enabled'
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_217: Edit HeatMap - Verify left alignment of visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on size dropdown
    And Change the Proportion X-axis "30"
    And Click on "Left" alignment icon
    Then Verify The Visual should be seen at 'left side' of the edit visual pane
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_218: Edit HeatMap - Verify right alignment of visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on size dropdown
    And Change the Proportion X-axis "30"
    And Click on 'Right' alignment icon
    Then Verify The Visual should be seen at 'right' side of the edit visual pane
    And click on 'Save' button

  @Heatmap
  Scenario: TC_Hm_219: Edit HeatMap - Number format dropdown
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'Number format' dropdown
    Then Verify The "Decimal places", "Decimal separator", "Grouping separator" should be display
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_220: Edit HeatMap - Number format - Verify default Decimal places
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'Number format' dropdown
    Then Verify The "2" decimals should be selected by default
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_221: Edit HeatMap - Number format - Verify Decimal separator
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'Number format' dropdown
    And Select decimal separator as (,)
    And click on 'Save' button
    Then Verify The selected decimal separator(,) should be displayed on HeatMap value

  @Heatmap
  Scenario: TC_HM_222: Edit HeatMap - Number format - Verify Grouping separator.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'Number format' dropdown
    And Select Grouping separator as (')
    And click on 'Save' button
    Then Verify The selected Grouping separator(') should be displayed on HeatMap value

  @Heatmap
  Scenario: TC_HM_223: Edit HeatMap - Date format
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    Then Verify The date format field Automatic as mm/yyyy should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_224: Edit HeatMap - date format dropdown
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on date format field dropdown
    Then Verify The "Auto" & "Custom" options should be available
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_225: Edit HeatMap - date format dropdown -custom
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on date format field dropdown
    And Select "Custom" radio button
    Then Verify The Date format should be able to custom manually with help of tips
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_226: Edit HeatMap - Verify Gridlines = Check
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Check "Gridlines" checkbox
    And click on 'Save' button
    Then Verify The 'Gridlines' should be applied to the 'Heat map' visual when checked

  @Heatmap
  Scenario: TC_HM_227: Edit HeatMap - Verify Gridlines = Uncheck
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Un-Check "Gridlines" checkbox
    And click on 'Save' button
    Then Verify The Gridlines should be removed from the HeatMap visual when unchecked

  @Heatmap
  Scenario: TC_HM_228: Edit HeatMap - Verify Gridlines "advanced Settings popup" cogwheel
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Open Advanced settings popup (cogwheel) icon
    Then Verify The Visual window should be displayed by default
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_229: Edit HeatMap - Verify Gridlines "advanced Settings popup" cogwheel - Lines = Check
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Open Advanced settings popup (cogwheel) icon
    And Lines check box checked
    And click on 'Save' button
    Then Verify The Gridlines should be displayed in visual

  @Heatmap
  Scenario: TC_HM_230: Edit HeatMap - Gridlines - Verify visual lines color
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Open Advanced settings popup (cogwheel) icon
    And Lines check box checked
    And Select Lines color
    And click on 'Save' button
    Then Verify The Gridlines should be applied for visual with selected color

  @Heatmap
  Scenario: TC_HM_231: Edit HeatMap - Gridlines - Verify visual lines width
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Open Advanced settings popup (cogwheel) icon
    And Lines check box checked
    And Select Width "5"
    And click on 'Save' button
    Then Verify The gridline width should be changed as per the selction

  @Heatmap
  Scenario: TC_HM_232: Edit HeatMap - Gridlines - Verify visual lines radius
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Open Advanced settings popup (cogwheel) icon
    And Lines check box checked
    And Select radius to 10
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_233: Edit HeatMap - legend
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    Then Verify The Legend options should be "checked" by default and "Bottom center" options should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_234: Edit HeatMap - legend dropdown
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    Then Veirfy The "Vertical align:", "Horizontal align:", "Advanced settings" as hyperlink should be seen
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_235: Edit HeatMap - legend dropdown - vertical align - down align icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And click down vertical align icon.
    And click on 'Save' button
    Then visual legends should be displayed downside of visual.

  @Heatmap
  Scenario: TC_HM_236: Edit HeatMap - legend dropdown - vertical align - up align icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And click up vertical align icon.
    And click on 'Save' button
    Then visual legends should be displayed upside of visual.

  @Heatmap
  Scenario: TC_HM_237: Edit HeatMap - legend dropdown - vertical align - mid align icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And click mid vertical align icon.
    And click on 'Save' button
    Then visual legends should be displayed mid of visual.

  @Heatmap
  Scenario: TC_HM_238: Edit HeatMap - legend dropdown - horizontal align - down align icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And click left horizontal align icon.
    And click on 'Save' button
    Then visual legends should be displayed left side of visual.

  @Heatmap
  Scenario: TC_HM_239: Edit HeatMap - legend dropdown - horizontal align - up align icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And click right horizontal align icon.
    And click on 'Save' button
    Then visual legends should be displayed right side of visual.

  @Heatmap
  Scenario: TC_HM_240: Edit HeatMap - legend dropdown - horizontal align - mid align icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And click mid horizontal align icon.
    And click on 'Save' button
    Then visual legends should be displayed on mid side of visual.

  @Heatmap
  Scenario: TC_HM_241: Edit HeatMap - legend - advanced settings under dropdown
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And Click on "Advanced settings" hyper link
    Then Verify The Legend window list "Common", "Color axes", "Position", "Background", "Border"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_242: Edit HeatMap - legend - advanced settings under dropdown - show legend
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And Click on "Advanced settings" hyper link
    Then Verify The "Show Legend" check box Should be checked by default
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_244: Edit HeatMap - legend - advanced settings under dropdown - items
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And Click on "Advanced settings" hyper link
    And Click on "Color axes" plus icon
    Then Verify The "Gradient", "Solid color", "Step(s)", "Logarithmic", "Per series" should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_246: Edit HeatMap - legend - advanced settings under dropdown - color axes
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And Click on "Advanced settings" hyper link
    And Click on "Color axes" plus icon
    And vary steps of legends.
    Then legends should display with selected steps.

  @Heatmap
  Scenario: TC_HM_249: Edit HeatMap - legend - advanced settings under dropdown - position
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on legend dropdown
    And Click on "Advanced settings" hyper link
    And Click on "Position" plus icon
    Then Verify the Alignment options "Vertical align:", "Horizontal align:" should be available
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_288: Edit HeatMap - Verify Copyright=Check
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And click on 'Save' button
    Then Verify The Copyright(Source:CEIC Data) should be displayed for visual

  @Heatmap
  Scenario: TC_HM_289: Edit HeatMap - Verify Copyright=Uncheck
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify the Copyright=Uncheck
    And click on 'Save' button
    Then Verify The The Copyright(Source:CEIC Data) should be removed for visual

  @Heatmap
  Scenario: TC_HM_290: Edit HeatMap - Copyright - Verify 'Vertical align'
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on copyright dropdown and select "Bottom"
    And click on 'Save' button
    Then Verify The Copyright - vertical align as "bottom"
    And Click on 'Edit HeatMap'
    And Click on copyright dropdown and select "Top"
    And click on 'Save' button
    Then Verify The Copyright - vertical align as "top"

  @Heatmap
  Scenario: TC_HM_292: Edit HeatMap - Copyright - Verify 'Horizontal align'
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on copyright dropdown and select "Left"
    And click on 'Save' button
    Then Verify The Copyright should be displayed in "left"
    And Click on 'Edit HeatMap'
    And Click on copyright dropdown and select "Center"
    And click on 'Save' button
    Then Verify The Copyright should be displayed in "center"
    And Click on 'Edit HeatMap'
    And Click on copyright dropdown and select "Right"
    And click on 'Save' button
    Then Verify The Copyright should be displayed in "right"

  @Heatmap
  Scenario: TC_HM_293: Edit HeatMap - Copyright - Verify advance settings
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on copy right dropdown
    And Click on 'Advanced settings' link
    Then Verify The Copyright popup should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_294: Edit HeatMap - Copyright - Verify advance settings cogwheel
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_295: Edit HeatMap - Copyright - Verify text=check
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    Then Verify the copyright checkbox checked
    And click on 'Save' button
    Then Verify The Copyright(Source:CEIC Data) should be displayed for visual

  @Heatmap
  Scenario: TC_HM_296: Edit HeatMap - Copyright - Verify default text for copyright
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Verify the Image is by default selected
    And click on 'Save' button
    Then Verify The Copyright(Source:CEIC Data) should be displayed for visual

  @Heatmap
  Scenario: TC_HM_297: Edit HeatMap - Copyright - Verify text change for copyright
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC Data"
    And click on 'Save' button
    Then Verify The Updated copyright should be displayed on visual

  @Heatmap
  Scenario: TC_HM_299: Edit HeatMap - Copyright - Verify copyright color
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Select copyright color
    And click on 'Save' button
    Then Verify The Visual copyright should be displayed in selected color

  @Heatmap
  Scenario: TC_HM_300: Edit HeatMap - Copyright - Verify font size
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Select font size for visual copyright "20"
    And click on 'Save' button
    Then Verify The copyright font size should be changed as per the selection

  @Heatmap
  Scenario: TC_HM_301: Edit HeatMap - Copyright - Verify bold style
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Click on copyright 'Bold' icon
    And click on 'Save' button
    Then Verify The copyright should be displayed in "bold" format

  @Heatmap
  Scenario: TC_HM_302: Edit HeatMap - Copyright - Verify Italic style
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Click on copyright style 'Italic' icon
    And click on 'Save' button
    Then Verify The copyright should be displayed in "italic" format

  @Heatmap
  Scenario: TC_HM_303: Edit HeatMap - Copyright - Verify Underline style
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Click on copyright style 'Underline' icon
    And click on 'Save' button
    Then Verify The copyright should be displayed in "underline" format

  @Heatmap
  Scenario: TC_HM_304: Edit HeatMap - Copyright - Verify horizontal alignment (left, right, center)
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Select horizontal alignment "left"
    And click on 'Save' button
    Then Verify The copyright align should be displayed in "left"
    And Click on 'Edit HeatMap'
    And Click on Copyright cogwheel icon (open advance settings popup)
    And Select horizontal alignment "center"
    And click on 'Save' button
    Then Verify The copyright align should be displayed in 'center'
    And Click on 'Edit HeatMap'
    And Click on Copyright cogwheel icon (open advance settings popup)
    And Select horizontal alignment "right"
    And click on 'Save' button
    Then Verify The copyright align should be displayed in 'right'

  @Heatmap
  Scenario: TC_HM_305: Edit HeatMap - Copyright - Verify vertical alignment (Top and bottom)
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Select horizontal alignment "top"
    And click on 'Save' button
    Then Verify The copyright horizontal align should be display on 'top'
    And Click on 'Edit HeatMap'
    And Click on Copyright cogwheel icon (open advance settings popup)
    And Select horizontal alignment "bottom"
    And click on 'Save' button
    Then Verify The copyright horizontal align should be display on 'bottom'

  @Heatmap
  Scenario: TC_HM_306: Edit HeatMap - Copyright - Verify closing copyright popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    And Click on copyright popup close (x) icon
    Then Verify The popup should be closed

  @Heatmap
  Scenario: TC_HM_308: Edit HeatMap - Data labels
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    Then Verify The "Data labels" Should be checked by default and advanced settings option should be present
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_309: Edit HeatMap - Data labels - advanced settings cogwheel
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Data labels open advanced settings popup (cogwheel) icon
    Then Verify The Label section should be seen and can be opened/collapsed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_310: Edit HeatMap - Data labels - advanced settings cogwheel- labels - color
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Data labels open advanced settings popup (cogwheel) icon
    Then Verify the 'Labels' checked by default
    And Select labels color
    And click on 'Save' button
    Then Verify The labels color Should be display with selected color

  @Heatmap
  Scenario: TC_HM_311: Edit HeatMap - Data labels - advanced settings cogwheel - labels - Highlight
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Data labels open advanced settings popup (cogwheel) icon
    Then Verify the 'Labels' checked by default
    And Click on labels Highlight and select color
    And click on 'Save' button
    Then Verify the labels highlight color Should be displayed with selected color in visual

  @Heatmap
  Scenario: TC_HM_312: Edit HeatMap - Data labels - advanced settings cogwheel - labels - Size
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Data labels open advanced settings popup (cogwheel) icon
    Then Verify The size default "11"
    And Select size in Labels "25"
    And click on 'Save' button
    Then Verify The Selected size should be displayed in visual

  @Heatmap
  Scenario: TC_HM_313: Edit HeatMap - Data labels - advanced settings Cogwheel- labels - styles
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Data labels open advanced settings popup (cogwheel) icon
    And Select label style "bold"
    And click on 'Save' button
    Then Verify The "bold" style should be displayed in labels
    And Click on 'Edit HeatMap'
    And Click on Data labels open advanced settings popup (cogwheel) icon
    And Select label style as "italic"
    And click on 'Save' button
    Then Verify The "italic" style should be displayed in labels
    And Click on 'Edit HeatMap'
    And Click on Data labels open advanced settings popup (cogwheel) icon
    And Select label style as "underline"
    And click on 'Save' button
    Then Verify The "underline" style should be displayed in labels

  @Heatmap
  Scenario: TC_HM_316: Edti HeatMap - Date and Value format
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    Then Verify The by default date and value checkbox shoud be checked
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_317: Edti HeatMap - tooltip dropdown default display
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    Then Verify The tooltip field "Date +2" value should be displayed as default
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_318: Edit HeatMap - Name tooltip for HeatMap visual
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The tooltip field "Date +3" value should be displayed.
    And click on 'Save' button
    Then tooltip should include with region for series with Date+3.

  @Heatmap
  Scenario: TC_HM_319: Edit HeatMap - 'Region' tooltip for HeatMap visual
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Select "Region" field
    And click on 'Save' button
    Then Verify The tooltips of visual should include with "Region:" of series

  @Heatmap
  Scenario: TC_HM_320: Edit HeatMap - 'Frequency' tooltip for HeatMap visual
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Select "Frequency" field
    And click on 'Save' button
    Then Verify The tooltips of visual should include with "Frequency:" of series

  @Heatmap
  Scenario: TC_HM_321: Edit HeatMap - 'Function description' tooltip for HeatMap visual
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Select "Function description" field
    And click on 'Save' button
    And Click on 'Edit series' link
    And Apply the function in series and save
    Then Verify The tooltips of visual should include with "Functions:" of series

  @Heatmap
  Scenario: TC_HM_323: Edit HeatMap - tooltip dropdown - advanced settings
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    Then Verify The "Common","Items" should be available
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_324: Edit HeatMap - tooltip dropdown - advanced settings - Common
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    Then Verify The Tooltip "show tooltips" should be checked default
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_325: Edit HeatMap - tooltip dropdown - advanced settings - Common
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    And UnSelecte the "Show tooltips" check box
    And click on 'Save' button
    Then Verify The 'Tooltips' for visual should not be shown

  @Heatmap
  Scenario: TC_HM_326: Edit HeatMap - tooltip dropdown - advanced settings - items
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    And Items - click on plus icon
    And click on items - plus icon and Verify the dropdown data "Name", "Region", "Frequency", "Function description"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_327: Edit HeatMap - tooltip dropdown - advanced settings - items
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    And Items - click on plus icon
    And try to add atrributes=>Name attribute should be added

  @Heatmap
  Scenario: TC_HM_328: Edit HeatMap - tooltip dropdown - advanced settings - items
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    And Click on "Items" plus iocn
    And click on plus icon - try adding "Region" attributes to be present in tooltip of visual
    And click on 'Save' button
    Then Verify The "Region" attribute should be display in tooltips

  @Heatmap
  Scenario: TC_HM_329: Edit HeatMap - tooltip dropdown - advanced settings - items
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    And Click on "Items" plus iocn
    And click on plus icon - adding "Frequency" attributes to be present in tooltip of visual
    And click on 'Save' button
    Then Verify The "Frequency" attribute should be display in tooltips

  @Heatmap
  Scenario: TC_HM_330: Edit HeatMap - tooltip dropdown - advanced settings - items
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'tooltip dropdown'
    And Click on "Advanced settings" hyper link
    And Click on "Items" plus iocn
    And click on plus icon - adding "Function description" attributes in tooltip of visual
    And click on 'Save' button
    And Click on 'Edit series' link
    And Apply the function in series and save
    Then Verify The tooltips of visual should include with "Functions:" of series

  @Heatmap
  Scenario: TC_HM_350: Edit HeatMap - Verify Solid Color button
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    Then color steps 2 to 7 values can be set for color steps

  @Heatmap
  Scenario: TC_HM_351: Edit HeatMap - Verify Solid Color button - Color Steps Dropdown
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    Then Verify The color steps by default "5" selected
    And Click on color steps dropdown and Verify the values 2 to 7
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_352: Edit HeatMap - Verify Solid Color button - Color Steps
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    And click on color steps dropdown.
    Then selected color steps will be created.

  @Heatmap
  Scenario: TC_HM_353: Edit HeatMap - Verify Solid Color button - Color Steps - Smallest Value and Highest Value
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    And click on color steps dropdown.
    And select the steps
    Then smallest and largest values are displayed with respective colors.

  @Heatmap
  Scenario: TC_HM_354: Edit HeatMap - Verify Solid Color button - Color Steps = Smallest Value
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    And click on color steps dropdown.
    And select the steps
    Then smallest value is displayed with selected color.

  @Heatmap
  Scenario: TC_HM_356: Edit HeatMap - Verify Solid Color button - Advanced settings cogwheel
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    And Solid color - Click on "Open advanced settings popup" cogwheel
    Then Verify The Open advanced settings popup list
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_357: Edit HeatMap - Verify Solid Color button - Advanced settings cogwheel - Common
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    And Solid color - Click on "Open advanced settings popup" cogwheel
    And Click on ( + ) icon from "Common" section
    Then Verify The "Show legend" checkbox checked by default
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_358: Edit HeatMap - Verify Solid Color button - Advanced settings cogwheel - Position
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Solid color
    And Solid color - Click on "Open advanced settings popup" cogwheel
    And Click on ( + ) icon from "Position" section
    Then Verify The "Position" section is displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_361: Edit HeatMap - Gradient color button
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'Gradient' button
    Then Verify The list "Step(s)", "Logarithmic", "Per series", "Smallest Value", "Largest Value"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_362: Edit HeatMap - Gradient color button - Steps Dropdown
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'Gradient' button
    Then Verify The By default "0" color step will be displayed
    Then Verify The Steps dropdown from 0 to 5 will be available
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_363: Edit HeatMap - Gradient color button - Steps change
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on 'Gradient' button
    And Click on steps dropdown and Select value "5"
    Then Verift The Selected color steps will be created with smallest and highest values

  @Heatmap
  Scenario: TC_HM_369: Edit HeatMap - Verify series axis chekbox = check
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The "Series axis" checked by default
    And click on 'Save' button
    Then Verify The Series names displayed in visual

  @Heatmap
  Scenario: TC_HM_370: Edit HeatMap - Verify series axis chekbox = uncheck
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And uncheck the "Series axis"
    And click on 'Save' button
    Then Verify The Series names not displayed in visual

  @Heatmap
  Scenario: TC_HM_371: Edit HeatMap - Verify series axis chekbox advanced setting cogwheel
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify The 'Label section' and opened/collapsed should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_372: Edit HeatMap - Verify series axis chekbox advanced setting cogwheel - Label = check
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify the label checkbox checked by default
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_373: Edit HeatMap - Verify series axis chekbox advanced setting cogwheel - Label color
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify the label checkbox checked by default
    And Click on color and change the color
    And click on 'Save' button
    Then Verify The Selected color should be applied and displayed

  @Heatmap
  Scenario: TC_HM_374: Edit HeatMap - Verify series axis chekbox advanced setting cogwheel - Label size
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify the label checkbox checked by default
    And Change the 'Size' in Label "20"
    And click on 'Save' button
    Then Verify the 'Series size' should be applied and displayed

  @Heatmap
  Scenario: TC_HM_375:Edit HeatMap - Verify series axis chekbox advanced setting cogwheel - Label style - bold, italic, underline
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify the label checkbox checked by default
    And Change the style to "bold"
    And click on 'Save' button
    Then Verify the Selected style "bold" displayed in visual
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify the label checkbox checked by default
    And Click on the style to "italic"
    And click on 'Save' button
    Then Verify the Selected style "italic" displayed in visual
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify the label checkbox checked by default
    And Click on the style to "underline"
    And click on 'Save' button
    Then Verify the Selected style "underline" displayed in visual

  @Heatmap
  Scenario: TC_HM_376: Edit HeatMap - Verify series axis chekbox advanced setting cogwheel - Label rotation
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Series axis - Click on Open Advanced settings popup - cogwheel
    Then Verify the label checkbox checked by default
    And Change the rotation "115"
    And click on 'Save' button
    Then Verify The Label rotation Selected series will be rotated clockwise

  @Heatmap
  Scenario: TC_HM_377: Edit HeatMap - Verify time axis chekbox = check
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    Then Verify The By default "Time axis" checkbox will be checked
    And click on 'Save' button
    Then Verify The time will be added below HeatMap visual

  @Heatmap
  Scenario: TC_HM_378: Edit HeatMap - Verify time axis chekbox = uncheck
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Uncheck Time axis checkbox
    And click on 'Save' button
    Then Verify The time will be removed from the heatmap visual

  @Heatmap
  Scenario: TC_HM_379: Edit HeatMap - Verify time axis chekbox advanced setting cogwheel
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on time axis advanced setting cogwheel icon
    Then Verify The window "Axis setup", "Labels", "Date format"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_380: Edit HeatMap - Verify time axis chekbox advanced setting cogwheel - Label
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on time axis advanced setting cogwheel icon
    And Click on "Labels" section
    Then Verify The 'Labels' section checkbox checked and "Color", "Axis color", "Size", "Style" should be seen
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_381: Edit HeatMap - time axis - Reverse direction = check
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on time axis advanced setting cogwheel icon
    And check reverse dirction.
    Then visual timepoints and dates are reversed.

  @Heatmap
  Scenario: TC_HM_382: Edit HeatMap - time axis - Reverse direction = uncheck
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on time axis advanced setting cogwheel icon
    Then visual timepoints and dates are by default in original state.

  @Heatmap
  Scenario: TC_HM_383: Edit HeatMap - time axis - opposite direction of the chart = check
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on time axis advanced setting cogwheel icon
    And check opposite direction of chart.
    Then visual date will be in opposite direction.

  @Heatmap
  Scenario: TC_HM_384: Edit HeatMap - time axis - opposite direction of the chart = uncheck
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on time axis advanced setting cogwheel icon
    Then visual date will be in original  direction by default.

  @Heatmap
  Scenario: TC_HM_298:Edit HeatMap - Copyright - Verify link for copyright
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Verify The Copyright=Check
    And Click on Copyright cogwheel icon (open advance settings popup)
    Then Verify The Copyright popup should be displayed
    And Select Type 'Text=check'
    And Edit the text as "CEIC DATA"
    And Enter the link in link textbox "https://www.ceicdata.com/en"
    And click on 'Save' button
    Then Click on the copyright and Verify The should redirect to mentioned link

  @Heatmap
  Scenario: TC_HM_212: Edit HeatMap - Size - Dropdown settings  - HeatMap position
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on size dropdown
    Then Verify The "Horizontal align:" & "Proportion:" should be shown
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_386: Edit HeatMap - Verify the changes reflected in edit visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Select "Border:" dropdown and visual checkbox checked
    And Change visual border "14"
    Then Verify The changes in Edit visual popup only
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_387: Edit HeatMap - Verify title icon on visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Mouse move on 'visual title' and Click on 'edit icon'
    Then Verify The 'Titles' popup should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_388: Edit HeatMap - Verify titles popup open by double click on visual title
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Double click on visual title
    Then Verify The 'Titles' popup should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_390: Edit HeatMap - Verify double clicking on visuals
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Double click on visual in edit visual window
    Then Verify The 'Visual' popup should be displayed
    And change the color in visual popup
    Then Verify The changes should apply to edit visual
    And click on 'Save' button
    Then Verify The changes should apply to heatmap visual

  @Heatmap
  Scenario: TC_HM_391: Edit HeatMap - Verify double clicking on date field
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Double click on date
    Then Verify The 'Time Axis' popup should be displayed
    And change the size "24" in Time Axis popup and verify the changes should apply to edit visual
    And click on 'Save' button
    Then Verify the 'size' changes should be displayed on visual

  @Heatmap
  Scenario: TC_HM_392: Edit HeatMap - Verify double clicking on timepoints
    And Navigate to series Tab
    And Search for the series "1692001;414250207" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Double click on timepoints
    Then Verify The 'Labels' popup should be displayed
    And change the size "27" in Label popup and verify the changes should apply to edit visual
    And click on 'Save' button
    Then Verify the timepoints 'size'  changes should be displayed on visual

  @Heatmap
  Scenario: TC_HM_393: Edit HeatMap - Verify removing attributes by clicking 'x' icon.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And mouse hover on series attribute of visual
    And click on x icon.

  @Heatmap
  Scenario: TC_HM_394: Edit HeatMap - Verify clicking on series name
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on series on HeatMap visual
    Then Verify The Series info popup should be opened
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_395: Edit HeatMap - Verify Edit series on visual
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Mouse move on serie name and click on cogwheel icon
    Then Verify The dropdown values "Rename", "Frequency", "Currency", "Change"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_396: Edit HeatMap - Verify Rename option from cogwheel icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Mouse move on serie name and click on cogwheel icon and Click on "Rename"
    Then Verify The Rename popup should be displayed with all series and series name should be updated as per the change
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_397: Edit HeatMap - Verify Frequency option from cogwheel icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Mouse move on serie name and click on cogwheel icon and Click on "Frequency"
    And Select the "Yearly (Sum)"
    Then Verify The Selected frequency "Yearly (Sum)" should be applied to the series
    And click on 'Save' button
####
  @Heatmap
  Scenario: TC_HM_398: Edit HeatMap - Verify Currency option from cogwheel icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Mouse move on serie name and click on cogwheel icon and Click on "Currency"
    And Select the "USD"
    Then Verify The Selected Currency "USD" should be applied to the series
    And click on 'Save' button
    And Click on Ok buttoon

  @Heatmap
  Scenario: TC_HM_399: Edit HeatMap - Verify Change option from cogwheel icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Mouse move on serie name and click on cogwheel icon and Click on "Change"
    And Select the "Difference Year-over-Year (YoY)"
    Then Verify The Selected Change "CHANGE" should be applied to the series
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_400: Edit HeatMap - Verify Remove series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Remove series(x)
    Then Verify The "series" should be removed from the visual
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_401: Edit HeatMap - Verify tooltip for series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Mouse hover on series name
    Then Verify The Series tooltip should be displayed with options

  @Heatmap
  Scenario: TC_HM_402: Edit HeatMap - Verify vretical scroll.
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And verify vertical scroll bar=>All Timepoints should be right side.

  @Heatmap
  Scenario: TC_HM_403: Edit HeatMap - Verify horizontal scroll.
    And Navigate to series Tab
    And Search for the series "369703817;414249197" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And verify Horizontal scroll bar=>All Timepoints should be right side.

  @Heatmap
  Scenario: TC_HM_404: Edit HeatMap - Verify selecting another visual from visual panel
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Select other visual Ex: "Line chart"
    And click on 'Save' button
    And click on Apply button
    Then Verify The visual should be converted as user selected "Chart"

  @Heatmap
  Scenario: TC_HM_405:Edit HeatMap - Verify selecting another visual from dropdown
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on dropdown on visual panel and Select any visual Ex: "Pie"
    And click on 'Save' button
    And click on Apply button
    Then Verify The visual should be converted as user selected "Pie"

  @Heatmap
  Scenario: TC_HM_437: Edit HeatMap - Verify feedback option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Feedback option
    Then Verify The "Still cannot find an answer?" popup window should be displayed
    And Click on close "×" icon
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_438: Edit HeatMap - Feedback - Verify description for popup
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Feedback option
    Then Verify The description for popup "Do you need any additional features? Please send us your feedback for product enhancements."
    And Click on close "×" icon
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_439: Edit HeatMap - Feedback - Verify adding text in the field
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Feedback option
    And Enter text on description field
    Then Verify The should able to add text in the description field
    And Click on close "×" icon
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_440: Edit HeatMap - Feedback - Verify Submit and cancel buttons when description field is empty
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Feedback option
    Then Verify The 'Submit' and 'Cancel' buttons should be disabled by default
    And Click on close "×" icon
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_441: Edit HeatMap - Feedback - Verify cancel button
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Feedback option
    And Enter text on description field
    And Click on cancel button
    Then Verify The Feedback popup should be closed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_442: Edit HeatMap - Feedback - Verify Submit button
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Feedback option
    And Enter text on description field
    Then Verify The user feedback should be sent to FD and popup should be closed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_443: Edit HeatMap - Feedback - Verify growl message after  Submit feedback
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Feedback option
    And Enter text on description field
    And Click on submit button
    Then Verify The "Thank you for submitting a question to us." message should be displayed in a growl popup
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_444: Edit HeatMap - Verify cancel/x button
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on Cancel/x button
    Then Verify The edit visual popup should be closed

  @Heatmap
  Scenario: TC_HM_445: Edit HeatMap - Verify save button.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And click on change title.
    Then changes should be reflected to HeatMap visual.

  @Heatmap
  Scenario: TC_HM_406: Edit HeatMap - Edit series - Verify delete series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on x icon for a series
    Then Verify The series should be removed from edit series panel
    And click on 'Save' button
    Then Verify The series should be removed from visual panel

  @Heatmap
  Scenario: TC_HM_407: Edit HeatMap - Edit series - Verify delete all series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on x icon for attribute(Next to name)
    Then Verify The all series should be removed from edit series panel
    And click on 'Save' button
    Then Verify The All series should be removed from visual panel

  @Heatmap
  Scenario: TC_HM_408: Edit HeatMap - Edit series - Verify SSP by clicking on series name
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series -  Click on series name
    Then Verify The SSP popup should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_409: Edit HeatMap - Edit series - Verify Rename series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Mouse move on series and click on "Rename series" icon
    Then Verify The "Rename" popup should be displayed for selected series
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_410: Edit HeatMap - Edit series - Verify edit series icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Mouse move on series and click on "Edit series" icon
    Then Verify The dropdown list "Rename", "Frequency", "Currency", "Change"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_411: Edit HeatMap - Edit series - Verify 'Rename' option under edit series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Mouse move on series and click on "Edit series" icon
    And Click on 'Rename' option
    Then Verify The "Rename" popup should be displayed for selected series
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_412: Edit HeatMap - Edit series - Verify 'Frequency' option under edit series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Mouse move on series and click on "Edit series" icon
    And Click on 'Frequency' option
    And Select the "Yearly (Sum)"
    Then Verify the Selected function should be applied to the Edit visual
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_413: Edit HeatMap - Edit series - Verify 'Currency' option under edit series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Mouse move on series and click on "Edit series" icon
    And Click on currency and select "USD"
    Then Verify the Selected 'currency' function should be applied to the Edit visual
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_414: Edit HeatMap - Edit series - Verify Change option under edit series
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Mouse move on series and click on "Edit series" icon
    And Click on "Change" and select "Difference Year-over-Year (YoY)"
    Then Verify the Selected 'Change' function should be applied to the visual
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_415: Edit HeatMap - Edit series - Verify clicking on frequency or dropdown
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    Then Verify The "Series Harmonization" popup should be displayed
    And Click on "Apply" button on 'Series Harmonization' window

  @Heatmap
  Scenario: TC_HM_416: Edit HeatMap - Edit series - Series Harmonization - Verify applying frequency
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    And Click on "Frequency" dropdown and Select frequency "Semiannual"
    And Click on "Apply" button on 'Series Harmonization' window
    And click on 'Save' button
    Then Verify The selected frequency "Half-yearly" should be displayed on heat map visual

  @Heatmap
  Scenario: TC_HM_417: Edit HeatMap - Edit series - Series Harmonization - Verify applying Missing values method
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    And Click on "Missing values method" dropdown and select "Calculate with linear extrapolate"
    And Click on "Apply" button on 'Series Harmonization' window
    And click on 'Save' button
    Then Verify The "Missing values method" should be applied with selected frequency "Calculate with linear extrapolate"

  @Heatmap
  Scenario: TC_HM_419: Edit HeatMap - Edit series - Series Harmonization -Minimize option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    And Click on 'Minimize' option
    Then Verify The popup should be "Minimize"
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_420: Edit HeatMap - Edit series - Series Harmonization -Verify maximize option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    And Click on 'Minimize' option
    Then Verify The popup should be "Minimize"
    And Click on 'Maximize'option
    Then Verify The popup should be "Maximize"
    And Click on "Apply" button on 'Series Harmonization' window
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_421: Edit HeatMap - Edit series - Series Harmonization -verify full screen
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    And Click on 'Full-screen' option
    Then Verify The popup should be displayed in "Full-screen"
    And Click on "Apply" button on 'Series Harmonization' window
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_422: Edit HeatMap - Edit series - Series Harmonization -verify exit full screen
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    And Click on 'Full-screen' option
    And Click on 'Exit full-screen' option
    Then Verify The popup should be displayed in normal size
    And Click on "Apply" button on 'Series Harmonization' window
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_423: Edit HeatMap - Edit series - Series Harmonization -Verify Cancel/x icon
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on "Frequency" or its dropdown
    And Click on cancel/x icon option
    Then Verify The "Series Harmonization" popup should be closed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_424: Edit HeatMap - Edit series - Verify dropdown for frequency in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on dropdown for "Frequency" in series level
    Then Verify The frequencies should be available under the dropdown
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_425: Edit HeatMap - Edit series - Verify appling frequency in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on dropdown for "Frequency" in series level
    And Select a frequency "Weekly (Replicate)"
    Then Verify The Selected frequency "Weekly (Replicate)" should be displayed to ONLY selected series
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_426: Edit HeatMap - Edit series - Verify appling currency in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Edit series - Click on dropdown for currency in series level
    And Select a frequency "USD"
    Then Verify The Selected currency "USD" should be displayed to ONLY selected series
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_427:Edit HeatMap - Edit series - Verify clicking on type a function field
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on type a function field in series level
    And List of series dropdown should be opened
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_428: Edit HeatMap - Edit series -  Verify appling function in series level
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on type a function field in series level
    And Select a function "ROUND" and Click on "Apply function"
    Then Verify The Selected function "ROUND" should be displayed to ONLY selected series
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_431: Edit HeatMap - Edit series - Verify search for functions
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'Edit HeatMap'
    And Click on type a function field in series level
    And Search for functions "ROUND" in type a function
    Then Verify The Searched functions "ROUND" should be displayed
    And click on 'Save' button

  @Heatmap
  Scenario: TC_HM_446: Verify 'Add related series' option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And click on "Add related series" option
    Then Verify The 'Series suggestion manager' popup should be displayed

  @Heatmap
  Scenario: TC_HM_447: Verify 'Add related series' option when the visual is empty
    And Click on Create new view tab
    And Click on 'Heat map' visual
    Then Verify The "Add related series" should be disabled if have no series associated with the visual

  @Heatmap
  Scenario: TC_HM_449: Verify add to insight option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on "Add to insight" (+) icon on header
    Then Verify The "Add to new tab", "Add to new insight" options should be displayed

  @Heatmap
  Scenario: TC_HM_450: Add to insight - Verify 'Add' option under Add to insight.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on "Add to insight" (+) icon on header
    And click on Add to new tab option.
    Then visual should be created in new tab

  @Heatmap
  Scenario: TC_HM_451: Add to insight - Verify confirmation message for adding visual to new insight
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on "Add to insight" (+) icon on header
    And Select 'Add to new insight' option
    Then Verify The "New insight with the selected visual created." and "Go to new insight" confirmation message should be displayed

  @Heatmap
  Scenario: TC_HM_452: Add to insight - Validate the added visual by opening new insight.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on "Add to insight" (+) icon on header
    And Select 'Add to new insight' option
    Then the insight should be opened and added visual should be available in view tab.

  @Heatmap
  Scenario: TC_HM_453: Add to insight - Verify growl popup auto close
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on "Add to insight" (+) icon on header
    And Select 'Add to new insight' option
    Then Verify The growl message should be auto closed

  @Heatmap
  Scenario: TC_HM_454: Copy - Verify 'Copy' option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Copy icon
    Then Verify The visual should be copied

  @Heatmap
  Scenario: TC_HM_456: Copy - Validate copied visual by pasting with in the insight.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Copy icon
    And paste within the insight

  @Heatmap
  Scenario: TC_HM_457: Copy - Validate copied visual by pasting to new insight.
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Copy icon
    And paste within the new insight

  @Heatmap
  Scenario: TC_HM_458: Copy - Verify the confrimation message for pasting visual in insight
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on Copy icon
    And Click on Create new view tab
    And Paste to insight
    Then Verify The "Data pasted from clipboard" message should be displayed

  @Heatmap
  Scenario: TC_HM_462: Copy - Validate by clicking on more options
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on 'More options'
    And Click on Copy icon
    Then Verify The Download window is displayed

  @Heatmap
  Scenario: TC_HM_463: Download - Verify Download option
    And Navigate to series Tab
    And Search for the series "7874301;249445301" with different frequencies
    And "2" check boxs checked
    And right click on checked series
    And click on Add chart and click on HeatMap
    And click on Apply button
    And Click on download option
    Then Verify The Download window is displayed

  @Heatmap
  Scenario: TC_HM_475: Verify Open option.
    Given user creates a HeatMap Visual
    Then click on Open icon.

  @Heatmap
  Scenario: TC_HM_476: Verify closing of maximized window.
    Given user creates a HeatMap Visual
    Then click on Open icon=>click on close icon.

  @Heatmap
  Scenario: TC_HM_477: Verify Delete HeatMap.
    Given user creates a HeatMap Visual
    And click on Delete icon.
    Then confirmation popup should display.

  @Heatmap
  Scenario: TC_HM_478: Verify description for delete confirmation popup.
    Given user creates a HeatMap Visual
    And click on Delete icon.
    Then "Do you want to remove this visual?" should be displayed.

  @Heatmap
  Scenario: TC_HM_479: Verify OK button in delete confirmation popup.
    Given user creates a HeatMap Visual
    And click on Delete icon=>clock OK button.

  @Heatmap
  Scenario: TC_HM_480: Verify Cancel/x icon in delete confirmation popup.
    Given user creates a HeatMap Visual
    And click on Delete icon.
    Then click Cance/X icon.

  @Heatmap
  Scenario: TC_HM_481: Verify right click options.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then below options should be available

  @Heatmap
  Scenario: TC_HM_482: Right click - Verify Copy HeatMap
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then choose copy HeatMap.

  @Heatmap
  Scenario: TC_HM_483: Right click - Validate copied HeatMap.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then choose copy HeatMap.
    And Right clicks on Visual.
    Then paste in Application=>Heat Map visual should be copied

  @Heatmap
  Scenario: TC_HM_484: Right click - Verify Cut HeatMap.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then choose cut HeatMap.

  @Heatmap
  Scenario: TC_HM_485: Right click - Validate Cut HeatMap.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And choose cut HeatMap.
    And Right clicks on Visual.
    Then paste in Application=>Heat Map visual should be pasted

  @Heatmap
  Scenario: TC_HM_486: Right click - Verify Delete HeatMap
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And Delete HeatMap.

  @Heatmap
  Scenario: TC_HM_487: Right click - Verify Add Chart sub dropdown.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And hover on Add Chart.
    Then options should be available in sub dropdown.

  @Heatmap
  Scenario: TC_HM_488: Right click - Verify chart under Add Chart
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And choose insert visual=>Chart.

  @Heatmap
  Scenario: TC_HM_489: Right click - Verify Pie under Add Chart
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And choose insert visual=>Pie.

  @Heatmap
  Scenario: TC_HM_491: Right click - Verify map under Add Chart
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And choose insert visual=>Map.

  @Heatmap
  Scenario: TC_HM_492: Right click - Verify HeatMap under Add Chart
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And choose insert visual=>HeatMap.

  @Heatmap
  Scenario: TC_HM_493: Right click - Verify Histogram under Add Chart
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And choose insert visual=>Histogram

  @Heatmap
  Scenario: TC_HM_494: Right click - Verify Scatter under Add Chart
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And choose insert visual=>Scatter

  @Heatmap
  Scenario: TC_HM_495: Right click - Verify Commentary under insert visual
    Given user creates a HeatMap Visual
    And click on insert Commentary.
    Then Commentary visual should be created in same view tab.

  @Heatmap
  Scenario: TC_HM_496: Right click - Verify Attachment under insert visual
    Given user creates a HeatMap Visual
    And click on insert Attachments.
    Then Attachment visual should be created in same view tab.

  @Heatmap
  Scenario: TC_HM_497: Right click - Verify image under insert visual
    Given user creates a HeatMap Visual
    And click on insert image.
    Then image visual should be created in same view tab.

  @Heatmap
  Scenario: TC_HM_498: Right click - Verify Filter under insert visual
    Given user creates a HeatMap Visual
    And click on insert filter.
    Then filter visual should be created in same view tab.

  @Heatmap
  Scenario: TC_HM_499: Right click - Verify Paste visual
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And copy visual.
    And Right clicks on Visual.
    And click on paste visual.

  @Heatmap
  Scenario: TC_HM_500: Right click - Verify Change Chart typesub dropdown.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And hover on change chart type
    Then subdropdown should be opened.

  @Heatmap
  Scenario: TC_HM_501: Right click - Change Chart type - Verify Chart.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And HeatMap visual should be changed to chart visual.

  @Heatmap
  Scenario: TC_HM_502: Right click - Change Chart type - Verify Map.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And HeatMap visual should be changed to Map visual.

  @Heatmap
  Scenario: TC_HM_503: Right click - Change Chart type - Verify Histogram
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And HeatMap visual should be changed to Histogram visual.

  @Heatmap
  Scenario: TC_HM_504: Right click - Change Chart type - Verify Pie.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And HeatMap visual should be changed to Pie visual.

  @Heatmap
  Scenario: TC_HM_505: Right click - Change Chart type - Verify Scatter.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And HeatMap visual should be changed to Scatter visual.

  @Heatmap
  Scenario: TC_HM_506: Right click - Change Chart type - Verify Heatmap.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And HeatMap visual should be changed to HeatMap visual.

  @Heatmap
  Scenario: TC_HM_507: Right click - Verify Calculated series sub dropdown.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And select calculated series.

  @Heatmap
  Scenario: TC_HM_508: Right click - Verify appling function from Calculated series.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And select calculated series.
    Then apply the function to selected visual.

  @Heatmap
  Scenario: TC_HM_509: Right click - Verify Edit series option.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    And select edit series option.

  @Heatmap
  Scenario: TC_HM_510: Right click - Verify Clear contents.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then select clear contents.

  @Heatmap
  Scenario: TC_HM_511: Right click - Verify reset format.
    Given user creates a HeatMap Visual
    And clicks on Edit HeatMap.
    And make changes in Edit visual.
    And Right clicks on Visual.
    Then click on Reset Format=>It should be changed back to default.

  @Heatmap
  Scenario: TC_HM_512: Right click - Verify reset format option if have no changes in visual.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then Reset format option should be disabled.

  @Heatmap
  Scenario: TC_HM_513: Right click -  Verify download sub dropdown.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then HeatMap and view options should be displayed.

  @Heatmap
  Scenario: TC_HM_514: Right click -  Verify download > HeatMap.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then download popup should be displayed with HeatMap tab.

  @Heatmap
  Scenario: TC_HM_515: Right click -  Verify download > View.
    Given user creates a HeatMap Visual
    And Right clicks on Visual.
    Then download popup should be displayed with views tab.

  @Heatmap
  Scenario: TC_HM_516: Verify the visual options if visual is not selected.
    Given user creates a HeatMap Visual
    And visual option should be hidden.

  @Heatmap
  Scenario: TC_HM_517: Verify visual drag.
    Given user creates an Empty HeatMap visual
    And try to drag the visual
