Feature: SprintCases_4.10 feature

  @sprint_4.10
  Scenario: TC_18834_01: Verify save state for data tabs
    And Click on series tab
    And Refresh page
    Then User should land to series tab instead of database

  @sprint_4.10
  Scenario: TC_18458_01: Verify group name with empty title
    And Select some series to my series tab
    And create group in same name in series
    And click on rename
    And Change name for Group and click on 'Ok' button
    And click on rename
    And Click on arrow icon for 'Original Name'
    Then verify the apply button disable under rename popup

  @sprint_4.10
  Scenario: TC_19208_01: Verify Top indicators
    And Click on indicator tab
    Then Top indicators should be displayed in a panel

  @sprint_4.10
  Scenario: TC_19208_02: Verify first category under top indicators selected by default
    And Click on indicator tab
    Then 'top indicators' selected by default and First category should always selected

  @sprint_4.10
  Scenario: TC_19208_03: Verify header and select all control when a category is selected
    And Click on indicator tab
    And Select any category in left panel
    Then any category is selected on the left side, the header with associated indicators should be presented on the right side with the "Select All" control

  @sprint_4.10
  Scenario: TC_19383_01: Verify 'The order of tabs and Uploads tab default one'
    And Create table visual
    And click on insert Attachment
    Then order is 'Uploads and links' and default tab is Uploads

  @sprint_4.10
  Scenario: TC_19277_01: Verify 'Search by series id' under My series
    And Add series into my series as "353687487;374827357"
    And Search series with series ID in my series filter
    Then related series should be searched

  @sprint_4.10
  Scenario: TC_18708_01: Verify 'First Obs. Date, Last Obs. Date and Last Update time' for table visual
    And Create table visual
    And attributes check on tables
    Then verify First Obs. Date, Last Obs. Date and Last Update time

  @sprint_4.10
  Scenario: TC_19098 :Verify for Timeframe options displayed on the bar chart
    And Create new insight1
    And Open View tab
    And Add bar chart in the view
    Then Add series in it from My series panel or from the search section

  @sprint_4.10
  Scenario: TC_18208: Validate unit manipulation function for series with function not applied
    And Select series with unit as person or unit "396019937"
    Then Apply Unit manipulation function

  @sprint_4.10
  Scenario: TC_17158 :Check if Region filter generates results for partial search entry
    And Open Region filter
    Then Enter Palestine and search

  @sprint_4.10
  Scenario: TC_16975 :Check if we support colors as a series/graph attribute
    And Open a chart visual "319659201"
    And Apply a color palette and save "#05999A"
    And set as default for future chart
    And Save the settings
    And Create a chart visual

  @sprint_4.10
  Scenario: TC_14825 :Check if Ask question in footnotes includes the selected table name
    And Try to access a footnotes for table level
    And The table name is displayed on the footnotes header
    Then Click "Ask Question"

  @sprint_4.10
  Scenario: TC_12069:Verify if Function displayed are same in Series Suggested Manager and in popup  list of series 'My series'
    And Create new insight1
    And Add series into my series as "282464801"
    And Apply Accumulate function
    Then Open Series Suggested Manager

  @sprint_4.10
  Scenario: TC_17072:While adding series to an empty visual,Search from Edit series do not navigate to Data tabs if either of analysis/watchlist tabs are already selected
    And Create new insight1
    And Open View tab
    And Add bar chart in the view
    And Click on edit series
    Then click on Search series
