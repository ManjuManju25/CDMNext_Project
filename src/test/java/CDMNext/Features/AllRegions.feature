Feature: Verifying Allregions filter functionality

  @Regions
  Scenario: TC_AR_01: Verifying the Country classification details for Region title
    And Read the Geography data from "CountryClassification_EconomicGroups.xlsx" excel file and sheet "Geography_TestData"
    And Click on "All Regions" dropdown
    And Select "ALL" tab from filter dropdown
    Then Compare the Regions , sub-regions and country names with test data

  @EconomicGroups
  Scenario: TC_AR_02: Verifying the list of countries for economic groups
    And Read the Geography data from "CountryClassification_EconomicGroups.xlsx" excel file and sheet "EconomicGroups"
    And Click on "All Regions" dropdown
    And Select "ALL" tab from filter dropdown
    Then Compare the country names with test data for economic groups

