Feature: Verifying View tab functionality

  @EmptyView
  Scenario: Tc_EmptyView_01 : Verify creating any visuals in the visualisation panel
    And Click on View tab
    And Select some series and drag and drop onto the visual
    Then Series dropped should be created in the selected visual

  @EmptyView
  Scenario: Tc_EmptyView_02 : Verify creating new view tab
    And Click on plus icon
    Then New view tab should be created with all visual options

  @EmptyView
  Scenario: Tc_EmptyView_03 : Verify deleting any view
    And Click on View tab
    And Mouse hover on the view tab
    And Click on cross icon
    Then Selected view tab should be deleted

  @EmptyView
  Scenario: Tc_EmptyView_04 : Verify displaying different line charts
    And Click on View tab
    And Select the "Line" dropdown
    Then Verify different types of Line charts

  @EmptyView
  Scenario: Tc_EmptyView_05 : Verify displaying different area charts
    And Click on View tab
    And Select the "Area" dropdown
    Then Verify different types of Area charts

  @EmptyView
  Scenario: Tc_EmptyView_06 : Verify displaying different column charts
    And Click on View tab
    And Select the "Column" dropdown
    Then Verify different types of Column charts

  @EmptyView
  Scenario: Tc_EmptyView_07 : Verify displaying different Bar charts
    And Click on View tab
    And Select the "Bar" dropdown
    Then Verify different types of Bar charts

  @EmptyView
  Scenario: Tc_EmptyView_08 : Verify creating Pie chart in a view
    And Click on View tab
    And Click on "Pie" in the menu bar
    And Add the series to the visual
    Then "Pie" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_09 : Verify creating Heat map
    And Click on View tab
    And Click on "Heat map" in the menu bar
    And Add the series to the visual
    Then "Heat map" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_10 : Verify inserting Histogram into the view
    And Click on View tab
    And Click on "Histogram" in the menu bar
    And Add the series to the visual
    Then "Histogram" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_11 : Verify displaying different country selecting maps
    And Click on View tab
    And Select the "Map" dropdown
    Then Verify different types of map options available

  @EmptyView
  Scenario: Tc_EmptyView_12 : Verify creating 'Table' in view tab
    And Click on View tab
    And Click on "Table" in the menu bar
    And Add the series to the visual
    Then "Table" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_13 : Verify inserting 'Commentary' in view tab
    And Add some text in the description field
    And Get the text from the description field
    Then The commentary visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_14 : Verify inserting 'Attachments' in view tab
    And Click on View tab
    And Click on "Attachments" in the menu bar
    Then "Attachments" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_15 : Verify inserting 'Image' in view tab
    And Click on View tab
    And Click on "Image" in the menu bar
    Then "Image" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_16 : Verify inserting 'Filter' in view tab
    And Click on View tab
    And Click on "Filter" in the menu bar
    Then "Filter" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_17 : Verify total number of view tabs created
    And Click on plus icon and create 10 view tabs on every click
    Then 10 views should be created

  @EmptyView
  Scenario: Tc_EmptyView_18 : Verify tooltip display in a view tab
    And Click on View tab
    Then Hovering mouse on each option should show tooltip for each present in the menu bar

  @EmptyView
  Scenario: Tc_EmptyView_19 : Verify interplacing of visuals created in a view
    And Create Histogram and Map visuals
    Then Visuals should be interplaced by drag and drop

  @EmptyView
  Scenario: Tc_EmptyView_20 : Verify copy pasting of visuals should not empty the copied view tab visuals
    And Create any of the visual
    And Right click on visual header
    And Choose "Copy histogram"
    And Paste in new view tab
    Then Copied visual should be pasted without empty view

  @EmptyView
  Scenario: Tc_EmptyView_21 : Verify deleting the created visuals
    And Create any empty visual
    And Right click on visual header
    And Choose "Delete histogram"
    Then Selected visual should be deleted

  @EmptyView
  Scenario: Tc_EmptyView_22 : Verify inserting visuals from right click on mouse
    And Create any of the visual
    And Right click on visual header
    And Choose Insert visual as "Chart"
    Then "Chart" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_23 : Verify visuals 'view as' option from right clickon mouse
    And Create any empty visual
    And Right click on visual header
    And Select View as > "Chart"
    Then Visual should be converted into selected visual format

  @EmptyView
  Scenario: Tc_EmptyView_24 : Verify calculate series for empty visuals in a view tab
    And Create any empty visual
    And Right click on visual header
    Then Calculate series should be in disabled state

  @EmptyView
  Scenario: Tc_EmptyView_25 : Verify edit series from right click on mouse
    And Create any empty visual
    And Right click on visual header
    And Choose "Edit series"
    Then The edit series popup should be opened

  @EmptyView
  Scenario: Tc_EmptyView_26 : Verify clear contents option from the right click on mouse
    And Create any empty visual
    And Right click on visual header
    Then Clear contents option should be disabled

  @EmptyView
  Scenario: Tc_EmptyView_27 : Verify rename view from right click on mouse
    And Click on View tab
    And Right click on empty view tab
    And Select "Rename view"
    And Change to "Test View" and Save
    Then View name should be updated

  @EmptyView
  Scenario: Tc_EmptyView_28 : Verify creating duplicate view
    And Create any of the visual
    And Right click on view tab
    And Select "Duplicate view"
    Then Duplicate view should be created

  @EmptyView
  Scenario: Tc_EmptyView_29 : Verify clear view option
    And Create any of the visual
    And Right click on view tab
    And Select "Clear view"
    Then Created visuals should be removed

  @EmptyView
  Scenario: Tc_EmptyView_30 : Verify delete view option
    And Create any of the visual
    And Right click on view tab
    And Select "Delete view"
    Then Existing view tab should be deleted

  @EmptyView
  Scenario: Tc_EmptyView_31 : Verify delete all view option
    And Click on View tab
    And Create any of the visual
    And Right click on view tab
    And Select "Delete all views"
    Then Existing all view tab should get deleted

  @EmptyView
  Scenario: Tc_EmptyView_32 : Verify insert visual option from right click on mouse
    And Click on View tab
    And Right click on view tab
    And Choose Insert visual as "Chart"
    Then "Chart" visual should be created in the same view tab

  @EmptyView
  Scenario: Tc_EmptyView_33 : Verify paste visual from right click on view tab
    And Create any of the visual
    And Right click on view tab
    And Select "Copy view"
    And Paste in new view tab
    Then Copied visual should be pasted without empty view

  @EmptyView
  Scenario: Tc_EmptyView_34 : Verify downlod view option
    And Click on View tab
    And Right click on view tab
    Then If there is no visuals created in view tab, download option should be disabled
    And Create any of the visual
    And Right click on view tab
    Then If there is visuals present, "Download view" should enabled and open the download window

  @EmptyView
  Scenario: Tc_EmptyView_35 : Verify to get menu bar options in view tab
    And Create any of the visual
    And Click on out space of the visual
    Then Should display menu bar options of the view tab

  @EmptyView
  Scenario: Tc_EmptyView_36 : Verify creating total number of visuals in a single view
    And Click on View tab
    And Max of "Chart" visuals can be created are 20
    And Max of "Map" visuals can be created are 10
    And Max of "Table" visuals can be created are 10
    And Max of "Commentary" visuals can be created are 40
    And Max of "Attachments" visuals can be created are 15
    And Max of "Filter" visuals can be created are 1
    And Max of "Image" visuals can be created are 20

  @EmptyView
  Scenario: Tc_EmptyView_37 : Verify creating visuals from the search tabs using keyboard shortcuts
    And User enters seriesID "3640701"
    And Create below visuals using keyboard shortcuts
      | Map   |
      | Table |
      | Chart |

  @EmptyView
  Scenario: Tc_EmptyView_38 : Verify options displayed menu bar when particular visual empty box is created
    And Create any empty visual
    And Click inside of the visual box created
    Then Menu bar should be displayed with respective visual edit options

  @EmptyView
  Scenario: Tc_EmptyView_39 : Verify paste visual from right click on view tab
    And Create any of the visual
    And Copy the visual
    And Paste it onto the another view tab
    Then Copied visual should be pasted without empty view

  @EmptyView
  Scenario: Tc_EmptyView_40 : Verify copy pasting of visuals more than that of the maximum visuals can be created
    And Click on View tab
    And Max of Table visuals can be created are 10
    And Create table visual in view tab
    And Copy the visual
    And Try to paste it onto the max number of table created view
    Then Copy pasting of visual from other view should not be allowed

  @EmptyView
  Scenario: Tc_EmptyView_41 : Verify backspace clicked on keyboard should not navigate from view tab to my series tab
    And Create any of the visual
    And Click on "Edit Histogram"
    And Press backspace in the keyboard
    Then Should not allow the navigation from view tab to my series tab

  @EmptyView
  Scenario: Tc_EmptyView_42 : Verify renaming  copied view tab
    And Create any of the visual
    And Right click on view tab
    And Select "Copy view"
    And Paste in new view tab
    And Right click on view tab
    And Select "Rename view"
    And Change to "Test View" and Save
    Then View name should be updated

  @EmptyView
  Scenario: Tc_EmptyView_43 : Verify paste visual from right click on view tab
    And Create any of the visual
    And Click on "Copy" icon
    And Click on View tab
    And Right click on view tab
    And Select "Paste visual"
    Then Copied visual should be pasted without empty view
