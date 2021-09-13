Feature: Verifying sprint cases functionality

  #Background:
  #Given User has successful logged in
  @Sprint
  Scenario: TC_12744_01: Clear All filters button to clear all filters set
   And User enters keyword "Banglore"
    And Click on "More" filter
    And User selects "Date" as "Last observation after"
    And User has clicked on "Apply filter"
    Then "Sorry, no results were found here." message should be displayed
    And Click on "Search without any filters"
    Then Search without any filters link should be removed

  @Sprint
  Scenario: TC_16277_02: Support 3rd subnational level on the India map
    And User enters keyword "Andhra Pradesh"
    And Create India map with indian cities supporting subnational attribute
    Then Andhra Pradesh subnational city should appear on India map

  @Sprint
  Scenario: TC_15709_03: SSP and other modals: implement different handling for window in the collapsed state
    And User enters "19496901"
    And Open ssp window
    And Minimize ssp window
    Then The modal window should get collapsed into row

  @Sprint
  Scenario: TC_13722_04: Search: expand results down to the series level when a user performs a search
    And User enters keyword "Banglore"
    And Select "Matches only" filter
    Then For search results less than 100, the system will display all the tables and on the first table – down to series level

  @Sprint
  Scenario: TC_13722_05:
    And User enters "94277107;96334807"
    And Select "Matches only" filter
    Then For search results less than 10, the system will expand all the levels

  @Sprint
  Scenario: TC_15336_06: Search, my series: show tooltip only when mousing over series name (not the row as now)
    And User enters "94277107"
    And Hover the mouse over series in Search panel or in My series tab
    Then Series info tooltip should only be displayed when mouse hovered on the series name and not on the series row

  @Sprint
  Scenario: TC_15496_07: Improve Insights Summary popup
    And User enters "383438937"
    And Create visual
    Then "Latest changes in your Insight" should be displayed in the summary popup
    And "Replacements" should be displayed in the summary popup

  @Sprint
  Scenario: TC_14218_08:Add a possibility to copy a view from same insight
    And User enters "389517677"
    And Create visual
    And Right click on the View and select Copy View
    And Paste in the View section
    Then The copied View and its contents should be pasted in the same insight

  @Sprint
  Scenario: TC_14218_09:Add a possibility to copy all views from same insight
    And User enters "384681617;232081403"
    And Create visual
    And Right click on the View and select "Copy all views"
    And Paste in the View section
    Then All Views and contents from the insight should be pasted in the same insight

  @Sprint
  Scenario: TC_14218_10:Add a possibility to copy all views from new insight
    And User enters "384681617;232081403"
    And Create visual
    And Right click on the View and select "Copy all views"
    And Create new insight
    And Paste in the View section for new insight
    Then All Views and contents from the insight should be pasted in the new/other insight

  @Sprint
  Scenario: TC_6603_11:FEEDBACK: Improve customizing of color palettes in map
    And User enters series_id "384681617"
    And Create a map visual
    And Click on Edit Map
    And Select Gradient
    Then Default value should be "0" and the steps range should be from "0,1,2,3,4 5"
    And Select Solid color
    Then Default value should be "5" and the colors range should be from "2,3,4,5,6,7,8,9,10"

  @Sprint
  Scenario: TC_6603_12:Verify the changes inEdit Visual modal
    And User enters series_id "384681617"
    And Create a map visual
    And Click on Edit Map
    And Select Solid color
    Then Clicking on the color box will open the color picker

  @Sprint
  Scenario: TC_6603_13:Verify if more gradient steps are selected
    And User enters series_id "384681617"
    And Create a map visual
    And Click on Edit Map
    And Select Gradient
    Then The options will look as steps and the steps values could be customized only when min and max values are set to fixed values

  @Sprint
  Scenario: TC_12897_14: FEEDBACK:37192 Include China map with Taiwan
    And User enters series_id "45184301"
    And Create map with taiwan series
    Then The taiwan should be included in China map

  @Sprint
  Scenario: TC_15651_15: Verify Correct order of style templates
    And User enters series_id "384681617"
    And Create a map visual
    And Click on Edit Map
    And Uncheck the "Legend" option
    And Create a new template and "Template popup"
    Then The new template should be created in the beginning of the list

  @Sprint
  Scenario: TC_15651_16: Verify Selected style visiblity in the template list
    And User enters series_id "384681617"
    And Create a map visual
    And Click on Edit Map
    And Uncheck the "Legend" option
    And Create multiple templates
    And Clicking on the hiding template from the style template dropdown
    Then Selected template should be highlighted in the template Menu

  @Sprint
  Scenario: TC_14172_17: Edit visual: implement a possibility to save a custom style
    And User enters series_id "384681617"
    And Create a map visual
    And Click on Edit Map
    And Uncheck the "Legend" option
    And Create a new template and "Template popup"
    Then The new template should be created

  @Sprint
  Scenario: TC_14218_18:Add a possibility to copy a view from new insight
    And User enters "212298602"
    And Create visual
    And Right click on the View and select Copy View
    And Create new insight
    And Paste in the View section for new insight
    Then The copied View and its contents should be pasted in other/new insight
    
  #@Sprint
  #Scenario: flex details
    #And Enter "366672387"
    #And Verify the time points
