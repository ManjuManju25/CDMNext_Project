
Feature: Verifying Country Filter functionality

  Background: 
    And Go to View tab
    And Click on insert Filter visual icon

  @FilterVisual
  Scenario: Tc_FilterVisual_1:Verify creating filter visual
    Then "Filter" visual should be created

  @FilterVisual
  Scenario: Tc_FilterVisual_2:Verify content present in the filter visual
    Then Below optins should be displayed
      | Visual             |
      | Download. Type `d` |
      | Open               |
      | Delete             |

  @FilterVisual
  Scenario: Tc_FilterVisual_3:Verify expanding filter visual
    And Click on Open icon
    Then The visual should be displayed in maximized window

  @FilterVisual
  Scenario: Tc_FilterVisual_4:Verify closing of maximized window.
    And Click on Open icon
    And Click on x icon to close
    Then The modal window should be closed

  @FilterVisual
  Scenario: Tc_FilterVisual_5:Verify changing title of the filter
    And Mouse hover on visual title
    And Click on edit icon
    And Edit the name of the title
    Then The title popup should be appeared
    And The changes should be reflected to filter visual

  @FilterVisual
  Scenario: Tc_FilterVisual_6:Verify naming subtitle of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Check "sub-title"
    Then Sub title should be displayed for the visual

  #@FilterVisual1...title dropdown is removed
  #Scenario: Tc_FilterVisual_7:Verify click on title dropdown and able to edit the title
    #And Click on title dropdown of the filter visual
    #Then The title popup should be appeared
    #And Edit the name of the title
    #And The changes should be reflected to filter visual

  @FilterVisual
  Scenario: Tc_FilterVisual_8:Verify changing subtitle of the filter
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Check the box and enter the sub-title name as "New subtitle"
    Then The filter visual should update the "sub_title" name to "New subtitle"

  @FilterVisual
  Scenario: Tc_FilterVisual_9:Verify title text color
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Choose text color is blue
    Then The filter visual should update the "title" text color as blue

  @FilterVisual
  Scenario: Tc_FilterVisual_10:Verify highlight color
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Choose highlight color is Orange
    Then The filter visual should update the "title" highlight color as Orange

  @FilterVisual
  Scenario: Tc_FilterVisual_11:Verify 'font size'
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Choose "20" from the drop-down for the font size
    Then The filter visual should update the "title" font as "20"

  @FilterVisual
  Scenario: Tc_FilterVisual_12:Verify title in bold style
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on Bold icon for "title"
    Then The visual "title" should be in bold style

  @FilterVisual
  Scenario: Tc_FilterVisual_13:Verify title in Italic style
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on Italic under style
    Then The visual "title" should be "italic"

  @FilterVisual
  Scenario: Tc_FilterVisual_14:Verify title as underlined
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on Underline icon for "title"
    Then The visual "title" should be "underline"

  @FilterVisual
  Scenario: Tc_FilterVisual_15:Verify horizontal alignment (left, right, center)
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on left,center and right alignment for title
    Then The title should align to "left" , "center" and "right" as user set

  @FilterVisual
  Scenario: Tc_FilterVisual_16:Verify Sub-title text color
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Choose text color is blue for subtitle
    Then The filter visual should update the "sub_title" text color as blue

  @FilterVisual
  Scenario: Tc_FilterVisual_17:Subtitle > Verify highlight color
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Choose highlight color is Orange for subtitle
    Then The filter visual should update the "sub_title" highlight color as Orange

  @FilterVisual
  Scenario: Tc_FilterVisual_18:Subtitle > Verify 'font size'
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Choose "10" from the drop-down for the font size of subtitle
    Then The filter visual should update the "sub_title" font as "10"

  @FilterVisual
  Scenario: Tc_FilterVisual_19:Verify Subtitle in bold style
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on B under style for sub-title
    Then The visual "sub_title" should be in bold style

  @FilterVisual
  Scenario: Tc_FilterVisual_20:Verify Subtitle in Italic style
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on Italic under style for sub-title
    Then The visual "sub_title" should be "italic"

  @FilterVisual
  Scenario: Tc_FilterVisual_21:Verify Subtitle as underlined
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on Underline icon for sub-title
    Then The visual "sub_title" should be "underline"

  @FilterVisual
  Scenario: Tc_FilterVisual_22:Verify horizontal alignment (left, right, center) of sub_title
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on left,center and right alignment for sub_title
    Then The sub_title should align to "left" , "center" and "right" as user set

  @FilterVisual
  Scenario: Tc_FilterVisual_23:Verify crossmark when title window opened
    #And Click on title dropdown of the filter visual
    And Mouse hover on visual title
    And Click on edit icon
    And Click on X icon to close the popup
    Then The "Title" popup should be closed

  @FilterVisual
  Scenario: Tc_FilterVisual_24:Verify alignment
    And Click on "Visual" option on visual header
    Then By default Horizontal align should be disabled
    And Select Proportion value to 70
    And Select Horizontal align of visual to "Left"
    Then The Filter position should be align to "flex-start"
    And Select Horizontal align of visual to "Center"
    Then The Filter position should be align to "center"
    And Select Horizontal align of visual to "Right"
    Then The Filter position should be align to "flex-end"

  @FilterVisual
  Scenario: Tc_FilterVisual_25:Verify border color
    And Click on "Visual" option on visual header
    And Check for Filter Border
    And Select color for visual border
    Then The Filter border should be changed as per the selection

  @FilterVisual
  Scenario: Tc_FilterVisual_26:Verify border width
    And Click on "Visual" option on visual header
    And Check for Filter Border
    And Select border width 5 for visual border
    Then "Width" should be updated to "5"

  @FilterVisual
  Scenario: Tc_FilterVisual_27:Verify border radius
    And Click on "Visual" option on visual header
    And Check for Filter Border
    And Tick checkbox for border and choose radius as 10
    Then "Radius" should be updated to "10"

  @FilterVisual
  Scenario: Tc_FilterVisual_28:Verify visual border type
    And Click on "Visual" option on visual header
    And Check for Filter Border
    And Tick checkbox for border and choose different border as "Dotted"
    Then The "dotted" border should be applied to the visual

  @FilterVisual
  Scenario: Tc_FilterVisual_29:Verify closing of visual popup
    And Click on "Visual" option on visual header
    And Click on X icon to close the popup
    Then The "Visual" popup should be closed

  @FilterVisual
  Scenario: Tc_FilterVisual_30:Verify right click on mouse for filter visual
    And Right click on visual header
    Then Popup should be opened with editing options

  @FilterVisual
  Scenario: Tc_FilterVisual_31:Verify delete filter option
    And Right click on visual header
    And Choose "Delete filter"
    Then Filter visual should be deleted

  #@FilterVisual..... insert visual is removed
  #Scenario: Tc_FilterVisual_32:Verify insert visual for filter visual
    #And Right click on visual header
    #And Choose "Insert visual"
    #Then Verify insert visual sub dropdown options for filter visual

  @FilterVisual
  Scenario: Tc_FilterVisual_33:Verify creating filter visual with other visuals
    And Create any other visuals in a view
    And Create filter visual
    And Click inside filter visual
    Then Countries name which are included in the other all visual should be listed and displayed

  @FilterVisual
    Scenario: Tc_FilterVisual_34:Verify reset country filter notification message and click on reset country filter when notification popped up
    And Create one visual with countryfilter
    And click on filter and modify visual with specific countries
    And create another visual in the same view
    Then Reset country filter notification should be popped
    And Click on "Reset country filter"
    Then filter visual should get reset with "All countries" name present in all visuals in view

  #@FilterVisual1...drag and drop is not possible for this tc on stage5.6.0-rc.3
  #Scenario: Tc_FilterVisual_35:Verify country filter 'move' option
    #And Create histogram visual with series
    #And Create filter visual
    #And Hover the cursor on the title and try to move with in the view
    #Then Country filter visual should move

  @FilterVisual
  Scenario: Tc_FilterVisual_36:Verify crossmark for all country selected
    And Click on crossmark when all countries are selected
    Then Should unselect all countries
