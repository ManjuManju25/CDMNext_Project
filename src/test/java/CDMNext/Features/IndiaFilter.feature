Feature: Verifying India filter functionality

  @Indiafilter
  Scenario: TC_IND_01: Verifying states , Districts and Cities/Towns for subnational India
    And Read the Excel file "INP_administrative_map_PROD.xlsx"
    #And Click on "All Regions" dropdown
    #And Select subnational as "India"
    #Then Compare the states , districts and cities with test data
