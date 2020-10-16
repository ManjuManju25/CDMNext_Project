Feature: Verifying China filter functionality

  @Chinafilter
  Scenario: TC_CN_01: Verifying provinces , prefectures and counties for subnational "China"
    And Read the Excel file "Geo_Tag_Production.xlsx"
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    Then Compare the provinces , prefectures and counties with test data
