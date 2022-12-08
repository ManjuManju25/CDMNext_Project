@sprint5.5
Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: TC_01_21528_01: Verify preselecting 'Alternative data' checkbox
    And Click on "Alternative Data" dropdown
    Then The "Alternative Data" checkbox should be checked by default

  Scenario: TC_02_21132_01: Veirfy Alternative data display position in the dropdown
    And Click on "Alternative Data" dropdown
    Then The "Alternative Data" should be displayed on the top always

  Scenario: TC_03_21132_02: Verify the button name for Alternative data dropdown
    Then The button name should be "Alternative Data"

   Scenario: TC_04_21132_04: Verify the 'Alt' tag in front of series
    And Click on "Alternative Data" dropdown
    And The "Alternative Data" checkbox should be checked by default
    And Click on "Apply filter"
    Then The "Alt" tag should be displayed for all series.
    
 
     Scenario: TC_05_21446_01: Verify series effect in Table view.
   	And Add series to the my series tab
    And Switch on "Table" mode
    And Mouse hover on series
    Then The series should be "underline"
    
      @sprint5.5
     Scenario: TC_06_21433_01: Verify toolbar in my series when no series selected.
   	And Add series to the my series tab
    Then Check toolbar and the toolbar should be greyed out instead of hiding
    
      @sprint5.51
     Scenario: TC_07_21425_01: Verify Paste option in series right click under my series.
   	And Add series to the my series tab
    And Right-click on the series
     And Select "Copy" 
    And Select "Paste" in series right click under my series
    And The Paste option should be present and work

