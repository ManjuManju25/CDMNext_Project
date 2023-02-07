Feature: Verify Bubble visual functionality

  @Bubble
  Scenario: Tc_bubble_01: Bubble- Verify the number of series we need to create a group in bubble
    And Create empty buble visual
    And Observe total number of series to create a group
    Then Total 3 series should use to create a group in bubble

  @Bubble
  Scenario: Tc_bubble_02: Bubble- Verify the title of the bubblle chart when 3 series
    And Select any 3 series and Create a bubble visual
    Then The title of the visual should be the name of the 3 series selected and vs is shifted in the title bubble

  @Bubble
  Scenario: Tc_bubble_03: Bubble- Verify the title if series less than 6
    And Select any 5 series and Create a bubble visual
    Then The title of the visual should be the name of the 3 series selected and vs is shifted in the title bubble

  @Bubble
  Scenario: Tc_bubble_04: Bubble- Verify the title if series more than 6
    And Select any series more than 6 and Create a bubble visual
    Then The title should be displayed by the name of "Bubble"

  @Bubble
  Scenario: Tc_bubble_05: Bubble- Verify the legend if select 3 series from different country
    And Select any 3 series from different countries and Create a bubble visual
    Then Legend should display all 3 country names

  @Bubble
  Scenario: Tc_bubble_06: Bubble- Verify the legend if select 3 series from same country
    And Select any 3 series from same country and Create a bubble visual
    Then Legend should display only one country name

  @Bubble
  Scenario: Tc_bubble_07: Bubble- Verify the legend if series less than 6
    And Select any series less than 6  and Create a bubble visual
    Then Series country should be display as a legend separated by comma

  @Bubble
  Scenario: Tc_bubble_08: Bubble- Verify the legend if series more than 6
    And Select any series more than 6 from different countries and Create a bubble visual
    Then Series country should be display as a legend separated by comma

  @Bubble
  Scenario: Tc_bubble_09: Bubble- Verify the axes if series less than 6
    And Select any series less than 6
    And Create a bubble visual
    Then X-axis should be displayed as series X,unit
    Then Y-axis should be displayed as series Y,unit

  @Bubble
  Scenario: Tc_bubble_10: Bubble- Verify the axes if series more than 6
    And Select any series more than 6
    And Create a bubble visual
    Then Axes should not be visible

  @Bubble
  Scenario: Tc_bubble_11: Bubble- edit bubble- Verify checkbox of data labels
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    Then "Data labels" should be unchecked by default and adavnced settings option should be present

  @Bubble
  Scenario: Tc_bubble_12: Bubble- edit bubble-Verify data label value when  data labels option is unchecked
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    Then Should be display "Date" that is disabled

  @Bubble
  Scenario: Tc_bubble_13: Bubble- edit bubble-Verify data label value when  data labels option is checked
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    And Click on the "Data labels" checkbox to "Check"
    Then Date should be displayed on each bubble of visual

  @Bubble
  Scenario: Tc_bubble_14: Bubble-edit bubble- Verify data label value when  size is checked
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    And Click on the "Data labels" checkbox to "Check"
    And Check "Size" radio button
    Then Size should be displayed on each bubble of visual

  @Bubble
  Scenario: Tc_bubble_15: Bubble- edit bubble-Verify data label value when  region is checked
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    And Click on the "Data labels" checkbox to "Check"
    And Check "Region" radio button
    Then Region should be displayed on each bubble of visual

  @Bubble
  Scenario: Tc_bubble_16: Bubble- Edit bubble > Data labels > advanced settings > labels > color
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    And Click on the "Data labels" checkbox to "Check"
    And Click on advanced settings icon
    And Choose "Color" for labels
    Then Selected color should be applied on labels of visual

  @Bubble
  Scenario: Tc_bubble_17: Bubble- Edit bubble > Data labels > advanced settings > labels > highlight
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    And Click on the "Data labels" checkbox to "Check"
    And Click on advanced settings icon
    And Choose "Highlight" for labels
    Then Selected highlight should be applied on labels of visual

  @Bubble
  Scenario: Tc_bubble_18: Bubble- Edit bubble > Data labels > advanced settings > labels > size
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    And Click on the "Data labels" checkbox to "Check"
    And Click on advanced settings icon
    And Choose "Size" for labels to 16
    Then Selected size should be applied on labels of visual

  @Bubble
  Scenario: Tc_bubble_19: Bubble- Edit bubble > Data labels > advanced settings > labels > styles
    And Select any 3 series and Create a bubble visual
    And Click on "Edit Bubble"
    And Click on the "Data labels" checkbox to "Check"
    And Click on advanced settings icon
    And Choose "Style" for labels 
    Then Selected style should be applied on labels of visual
