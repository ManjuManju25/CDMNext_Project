Feature: Verifying AllRegion filter functionality

  #Background: 
    #Given User has successful logged in

  @AllRegion
  Scenario: TC_AR_01: Verifying provinces , prefectures and counties for subnational "China"
    And Read the Excel file "Geo_Tag_Production.xlsx"
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    Then Compare the provinces , prefectures and counties with test data
