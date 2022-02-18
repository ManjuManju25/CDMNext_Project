	
	Feature: Display Continuos series Tag

   @Sprint5_1	 
  Scenario: TC_19072_01 : Display continous series for transformed series
    Given User selects Add continous series
    And User has clicked on "Apply filter"
    And Add Continuos Series into "series Tab"
    Then "Continuos tag" should display infront of series name

  @Sprint5_1
  Scenario: TC_20134_02 : Display continuous series with different functions
    Given User selects Add continous series
    And User has clicked on "Apply filter"
    And Add Continuos Series into "series Tab"
    Then Multiple continuos series with "sameId" but "different functions" should be added.

   @Sprint5_1
  Scenario: TC_20146_01 :  What's new tab should be hide for demo users.
    Given User selects Notification tab.
    And Hide "What's new tab" from Demo users.

   @Sprint5_1
  Scenario: TC_20044_01 :  Verify the last editor for automatically generated Data Briefings.
    Given user selects Data Briefings
    When user expands Data Briefings
    Then last editor name should be CEIC Insights for auto generated Data Briefings
	
	