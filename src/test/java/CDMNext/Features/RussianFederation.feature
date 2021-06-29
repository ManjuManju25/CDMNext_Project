
Feature: Verifying Russian Federation filter functionality

  @RussianFederation
  Scenario: TC_Russian_01: Verifying Federal disricts , Regions and Cities for subnational Russian Federation
    And Read the Excel file "RUP_all_map.xlsx"
    And Click on "All Regions" dropdown
    And Select subnational as "Russian Federation"
    Then Compare the "Federal Districts" , "Rigions" and "Cities" with test data
