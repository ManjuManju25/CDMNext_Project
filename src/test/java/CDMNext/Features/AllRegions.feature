Feature: Verifying Allregions filter functionality

  @AllRegion
  Scenario: TC_AR_01: Verifying the Country classification details for Region title
    And Read the Geography data from "CountryClassification.xlsx"
    And Click on "All Regions" dropdown
    And Select "All regions" tab
    Then Compare the Regions , sub-regions and country names with test data
