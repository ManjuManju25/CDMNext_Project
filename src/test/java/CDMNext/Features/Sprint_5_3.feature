Feature: Sprint_5.3

  @Sprint_5.3
  Scenario: TC_20741_01: Check The Drilldown button on second level indicators
    And Open indicator popup
    And Navigate to All tab
    Then Mouse move on the indicator in right panel

  @Sprint_5.3
  Scenario: TC_20741_02: Verify clicking on Drilldown button
    And Open indicator popup
    And Navigate to All tab
    Then Mouse move on the indicator in right panel
    Then Click on Drilldown

  @Sprint_5.3
  Scenario: TC_20740_01 :Verify selecting indicator by default.
    And Open indicator popup
    # And Navigate to All tab
    Then Check the main indicator is selected

  @Sprint_5.3
  Scenario: TC_20740_02:Verify double click to unselect indicator
    And Open indicator popup
    # And Navigate to All tab
    Then Double click on the main indicator

  @Sprint_5.3
  Scenario: TC_20740_03:Verify search for all categories
    And Open indicator popup
    And Search with some keyword "GDP"
    Then Check the result under "All" and "Top indicators" tab

  @Sprint_5.3
  Scenario: TC_20648_01:Verify Refresh popup for insight changes
    And Share an insight with User2
    And Login to User2 and Open the shared insight
    Then Make changes to the insight from User1

  @Sprint_5.3
  Scenario: TC_20648_02:Verify text for refresh popup.
    And Share an insight with User2
    And Login to User2 and Open the shared insight
    Then Make changes to the insight from User2

  @Sprint_5.3
  Scenario: TC_20541_01:Verify the group title in bold format when its expanded
    And Add a data table to My series
    And Expand the table
    Then Check the bold format for the Group title

  @Sprint_5.3
  Scenario: TC_20530_01:Verify i icon for series in search and My series panel.
    And Mouse move on the series in search and My series panels and Check for the i icon

  @Sprint_5.3
  Scenario: TC_20460_01:Verify the full path to the indicator in the pill box tooltip.
    And Open indicator popup
    And Select any indicator
    Then Mouse move on the indicator in the pill box "Real GDP Growth"

  @Sprint_5.3
  Scenario: TC_20460_02:Verify the full path to the subnational in the pillbox tooltip
    And click_On_Dropdown "All Regions"
    And select_subnational_as_region "China"
    And Select any subnational "Beijing"
    Then Mouse move on the indicator in the pill box "Beijing"

  @Sprint_5.3
  Scenario: TC_20358_01:Verify copyright configuration popup when click on logo on visual
    And Create a visual "10"
    Then Click on CEIC logo1

  @Sprint_5.3
  Scenario: TC_20351_01:Verify OS Windows 11 under Select Microsoft Windows Version dropdown.
    And Open Help "Excel Addin" popup
    And Open dropdown for "Select Microsoft Windows Version"
    Then Check for OS "Windows 11" in the dropdown

  @Sprint_5.3
  Scenario: TC_20351_02:Verify Office 2021 under Select Microsoft Office Version dropdown
    And Open Help "Excel Addin" popup
    And Open dropdown for "Select Microsoft Office Version"
    Then Check for OS "Office 2021;Office 2021 (64 Bit)" in the dropdown

  @Sprint_5.3
  Scenario: TC_20077_01:Verify displaying multiple databases when click on show in databases under data briefings
    And Search for this series "211637002"
    And Open the Data briefings
    Then Click on See in Database

  @Sprint_5.3
  Scenario: TC_20077_02:Verify 'See in Database' in the tooltip for the database navigation
    And Navigate to Series tab1
    Then Mouse move the See in database icon

  @Sprint_5.3
  Scenario: TC_15925_01:Verify right-click options popup for series on the table visual
    And Create a table visual2
    Then Right click on series1

  @Sprint_5.3
  Scenario: TC_18923_01:Verify opening list of My series in commentary visual
    And Add some series1
    And Create a commentary visual
    Then Type this "{"

  @Sprint_5.3
  Scenario: TC_18923_02:Verify selecting series
    And Add some series1
    And Create a commentary visual
    Then Type this "{"
    Then select "GDP Index: PY=100"

  @Sprint_5.3
  Scenario: TC_18923_03:Verify selecting a series variables in the dropdown
    And Add some series1
    And Create a commentary visual
    Then Type this "{"
    Then select1 "GDP Index: PY=100" "Database"
    Then Unselect visual

  @Sprint_5.3
  Scenario: TC_18923_04:Verify Additional format dropdown for some variables
    And Add some series1
    And Create a commentary visual
    Then Type this "{"
    Then select1 "GDP Index: PY=100" "End date"
    Then Select format "MMM-YYYY (Jan-1990)"
    Then Unselect visual

  @Sprint_5.3
  Scenario: TC_20436_01:Verify the message when Excel doesnt support 3-axis charts
    And Add some series1
    And Create a chart visual
    And Right click on each series name on the visual "L1 Axis;R1 Axis;Move to new Right axis;R2 Axis;L1 Axis"
    Then Download1

  @Sprint_5.3
  Scenario: TC_15724_01:Verify the order of the series,when different types of charts are created
    And Add some series1
    And Create a chart visual
    Then Check the last value for all the series

  @Sprint_5.3
  Scenario: TC_20348_01:Verify the preserved List/Table state in My Series per user
    And Open any insights by having series
    And Click on the Cogwheel icon
    And Create new insight1
    Then Add some series1

  @Sprint_5.3
  Scenario: TC_20358_02:Verify clicking on the copyright logo on read-only visuals (preview popup and view-only sharing mode)
    And Create a visual "10"
    And Open the insight in view mode
    Then Click on CEIC logo under a visual
