Feature: SprintCases_4.8 feature

  @sprint_4.8
  Scenario: TC_18934_01: Verify new class 'CDMNext table'
    And click on + icon in right side panel
    And Create commentary visual
    And Add table and text
    And click on table properties
    And click on class dropdown and select CDMNext table
    And click on Ok button
    Then CDMNext table format should be apply

  @sprint_4.8
  Scenario: TC_18879_01: Verify customize button for GDP nowcast insights
    And click on Analysis tab
    And click on CEIC insights and click on '+ icon on india'
    And click on GDP nowcast insight
    And Verify Customize button for insight
    Then Customize button should not available

  @sprint_4.8
  Scenario: TC_18842_01:Verify automatically open GDP Nowcast insight
    And click on Analysis tab
    And click on CEIC insights and click on '+ icon on india'
    And click on GDP nowcast insight
    Then GDP Nowcast should open insight in preview mode.View as grid mode
    And GDP Nowcast should open insight in preview mode.View as table mode

  @sprint_4.8
  Scenario: TC_18786_01: Verify Windows verison auto detect for windows 10 64-bit
    And click on menu icon in left side panel
    And click on Excel Add-in
    And Check 'Select Microsoft Windows Version'
    Then Windows 10 (64 Bit) should select by default

  @sprint_4.8
  Scenario: TC_18757_01: Verify fit to width option for image visual
    And create image visual
    And upload image visual
    Then select Fit to width

  @sprint_4.8
  Scenario: TC_18958: Verify tab bar design of footnotes
    And Choose a series in  Database tree
    And Create footnote for the series
    Then Check the tabs in footnotes

  
