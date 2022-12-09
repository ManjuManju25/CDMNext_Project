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

  Scenario: TC_06_21433_01: Verify toolbar in my series when no series selected.
    And Add series to the my series tab
    Then Check toolbar and the toolbar should be greyed out instead of hiding

  Scenario: TC_07_21425_01: Verify Paste option in series right click under my series.
    And Add series to the my series tab
    And Right-click on the series
    And Select "Copy"
    And Select "Paste" in series right click under my series
    And The Paste option should be present and work

  Scenario: TC_08_21337_01: Verify the Vertical table visual under Add chart popup.
    And Add series to the my series tab
    And Right-click on the series
    And Add chart > Check the placement for vertical visual under Table
    Then The Vertical visual should be displayed in first place under Table

  Scenario: TC_09_21295_02: Verify prefix to the list of sources.
    And Open copyright under preference
    And Click on "Change" option
    And Select "Series sources"
    And Create any visual
    Then "Sources: CEIC," should be displayed as prefix
    
    Scenario: TC_10_21295_01:Verify new copyright type 'Series sources'
    And Open copyright under preference
    And Click on "Change" option
    And Select "Series sources"
    And Create a pie visual with series id's "369703417;5958801"
    Then The list of series sources should be displayed
    
    Scenario: TC_11_21295_03:Verify translation for 'Source' label in non English UI.
    And Open copyright under preference
    And Click on "Change" option
    And Select "Series sources"
    And Create a pie visual with series id's "369703417"
    And Change the UI language
    Then The "Sources" label should be translated
    
    @sprint5.51
    Scenario: TC_12_21264_01:Verify creating visuals in the same/current view.
    And Create a view in right panel
    And Create 3 visuals from search panel
    Then The visuals should be created in same focused view
    
