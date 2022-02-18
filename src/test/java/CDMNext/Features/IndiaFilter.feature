
Feature: Verifying India region filter functionality

  @Indiafilter
  Scenario: TC_IND_01: Verifying states , Districts and Cities/Towns in state administrative tab for India
    Given Read the Excel file "INP_administrative_map_PROD.xlsx"
    And Click on "All Regions" dropdown
    And Select subnational as "India"
    And Select "State Administrative"
    Then Compare the "state" , "districts" and "cities" with test data

  @Indiafilter
  Scenario: TC_IND_02: Verifying states , Parliamentary, State Assembly in General Election tab for India
    Given Read the Election data Excel file "INP_election_map_PROD.xlsx"
    And Click on "All Regions" dropdown
    And Select subnational as "India"
    And Select "General Election"
    Then Verify the "State" ,"Parliamentary" and "Assembly" with test data

   

