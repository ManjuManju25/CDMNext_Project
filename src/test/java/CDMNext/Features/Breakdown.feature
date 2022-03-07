Feature: Title of your featureVerify Breakdown functionality

  @Breakdown
  Scenario: TC_Breakdown_01:Verify if group option is present for Global database> South African table
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Click on the "Group" option
    Then The series should be grouped

  @Breakdown
  Scenario: TC_Breakdown_02:Verify if ungroup option is present for Global database> South African table
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Click on the "Group" option
    And Uncheck the "Group" option
    Then The series grouped previously should be un-grouped

  @Breakdown
  Scenario: TC_Breakdown_03:Verify if select all works with grouped option is  for Global database> South African table
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Click on the "Group" option
    And Click on "Select All" option for the first group
    And Click on "Add"
    Then All selected series should add to right pane-my series
    
  @Breakdown
  Scenario: TC_Breakdown_04:Verify if de-select all works with grouped option is  for Global database> South African table
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Click on the "Group" option
    And Click on "Select All" option for the first group
    And Click on the "Unselect all" option
    Then All selected series should get de-selected

  @Breakdown1
  Scenario: TC_Breakdown_05:Verify if adding few series can be possible from  breakdown tab
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Add first series into right pane
    And Click on "Related Series"
    And Open Breakdown tab and select a few series
    And Click on "Apply"
    And Click on "Ok"
    Then Selected series should be added into my series

  @Breakdown
  Scenario: TC_Breakdown_06:Verify if grouped series can be added from  breakdown tab
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Add first series into right pane
    And Click on "Related Series"
    And Open Breakdown tab and click "Select All"
    And Click on "Apply"
    And Click on "Ok"
    Then All selected series should be added into my series

  @Breakdown
  Scenario: TC_Breakdown_07:Verify if visualization is possible from  breakdown tab
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Add first series into right pane
    And Click on "Related Series"
    And Open Breakdown tab and select a series and click on chart icon
    And Click on "Apply"
    And Click on "Ok"
    Then Respective chart should be created

  @Breakdown
  Scenario: TC_Breakdown_08:Verify if series can be drilled down in SSP
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Add first series into right pane
    And Click to open SSP window
    And Click on the "Drilldown" option
    Then Respective series has to be drilled down

  @Breakdown
  Scenario: TC_Breakdown_09:Verify if back option works for drilled down series in SSP
    And Expand Global database till "South Africa"
    And Expand "South Africa: National Accounts" till first table level
    And Add first series into right pane
    And Click to open SSP window
    And Click on the "Drilldown" option
    And Click on the "Back" option
    Then Drilled down series should reset back to original series

  @Breakdown
  Scenario: TC_Breakdown_10:Verify if group option is present for Global database> Singapore table
    And Expand Global database till "Singapore"
    And Expand "Singapore: National Accounts" till second table level
    And Click on the "Group" option
    Then The series should be grouped

  @Breakdown
  Scenario: TC_Breakdown_11:Verify if ungroup option is present for Global database> Singapore table
    And Expand Global database till "Singapore"
    And Expand "Singapore: National Accounts" till second table level
    And Click on the "Group" option
    And Uncheck the "Group" option
    Then The series grouped previously should be un-grouped
