Feature: Verifying All Search related cases

  @AdvanceSearch
  Scenario: TC_01 : Verifying All of these words
    And Click on "More" filter
    And Click on "Advanced search"
    And Enter All of these words as "India;Japan;Russia;China"
    And Click on "Search" button
    Then All of the words should display in the result pane

  @AdvanceSearch
  Scenario: TC_02 : Verifying Any of these words
    And Click on "More" filter
    And Click on "Advanced search"
    And Enter Any of these words as "Import;Export"
    And Click on "Search" button
    Then Any of the words should display in the result pane

  @AdvanceSearch
  Scenario: TC_03 : Verifying Exact phrase
    And Click on "More" filter
    And Click on "Advanced search"
    And Enter Exact phrase as "Retail Price"
    And Click on "Search" button
    Then Exact keyword should display in the result pane

  @AdvanceSearch
  Scenario: TC_04 : Verifying Exclude these words
    And Click on "More" filter
    And Click on "Advanced search"
    And Enter Exclude words as "Import;Export"
    And Click on "Search" button
    Then Search results should dispaly with out searching keywords

  @AdvanceSearch
  Scenario: TC_05 : Verifying Any of these series IDs
    And Click on "More" filter
    And Click on "Advanced search"
    And Enter Any of these series IDs as "274069502;274027202"
    And Click on "Search" button
    Then Verify the Search results

  @ContinuousSeries
  Scenario: TC_06:Verifying "With historical extension of continuous series" filter for series tab
    And User has selects "More" as "With historical extension of continuous series"
    When Click on "Apply filter"
    Then User verify corresponding results for selected filter
    
     @HideSeries
  Scenario: TC_07:Verifying "Hide series with 0 observations" filter for series tab
    And User has selects "More" as "Hide series with 0 observations"
    When Click on "Apply filter"
    Then User verify corresponding results for selected filter
