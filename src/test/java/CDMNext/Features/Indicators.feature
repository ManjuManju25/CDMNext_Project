Feature: Indicators feature

  @Indicators
  Scenario: TC_01: Verify indicator tab in an insight
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    Then Indicator tab in series suggestion manager window should be open

  @Indicators
  Scenario: TC_02: Verify related series tab in my series for opening indicator tab
    And Select some series to my series tab
    And try selecting related series in my series
    Then Should not be enabled

  @Indicators
  Scenario: TC_03: Verify related series tab in my series for opening indicator tab
    And Select some series to my series tab
    And select all series check box checked
    And try click on selecting related series in my series
    Then related series button should be enabled

  @Indicators
  Scenario: TC_04: Verify mouse point hover on I icon of indicator tab
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And hover mouse on I icon of indicator tab
    Then Tooltip should be displayed

  @Indicators
  Scenario: TC_05:Verify country tabs creation in indicators of series suggestion manager window
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And Add indicators to my series by click on plus icon beside indicators of country selected
    Then Maximum of 5 country/region tabs can be created

  @Indicators
  Scenario: TC_06: Verify opening select a region for indicators
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on select a region text box dropdown
    Then Regions list for selecting DB series should be opened

  @Indicators
  Scenario: TC_07:Verify footnotes open through indicators tab
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on I icon of indicators tab
    Then Footnotes popup should be opened

  @Indicators
  Scenario: TC_08: Verify adding indicator series into my series panel
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on plus icon in indicators tab
    Then should get reflected in my series tab as related series

  @Indicators
  Scenario: TC_09: Verify adding indicator series into visual selection panel
    And Select some series to my series tab
    And Create the visual like table
    And click on Add related series
    And select any of the indicators for series being in visual selection pane
    Then indicators tab should get reflected in visual selection panel as related series

  @Indicators
  Scenario: TC_10:Verify frequency conversion popup window for indicator tab
    And User Select Series ID  as "16164001"
    And series check box checked
    And Create the visual like table
    And click on Add related series
    And select any of the indicators for series being in visual selection
    And adding indicators with different frequency/unit for visual selection pane
    Then frequency conversion window to create visuals from indicators tab in series suggestion manager window

  @Indicators
  Scenario: TC_11: Verify minimizing series suggestion manager with indicators tab open
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on minimize icon at top right corner of window
    Then indicators tab opened should be minimized

  @Indicators
  Scenario: TC_12:Verify selecting region's for first level indicators
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And select CPI of the indicators in first level  for chose of region clicking over plus icon
    Then Should be able to create regions tab for particular first level indicators

  @Indicators
  Scenario: TC_13:Verify selecting region's for second level indicators
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And select FX Rate of the indicators in second level for chose of region
    Then Should be able to create region's/country's tab for particular second level indicators

  @Indicators
  Scenario: TC_14:Verify selecting region's for third level indicators
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And select any of the indicators in third level for chose of region
    Then Should be able to create region tab for particular third level indicators

  @Indicators
  Scenario: TC_15: Verify open SSP in indicator's tab
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on name of any of the indicators
    Then SSP of that particular indicator's should be opened

  @Indicators
  Scenario: TC_16: Verify expanding series suggestion manager with indicators tab
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on two arrow mark present in opp direction at right cornered window
    Then Window with indicator's tab should be exandable

  @Indicators
  Scenario: TC_17:Verify contrasting series suggestion manager with indicators tab
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on two arrow mark present in opp direction at right cornered window
    And click again on arrow mark directed towards
    Then Window with indicator's tab should be contrastable

  @Indicators
  Scenario: TC_18: Verify closing window with indicator's tab
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on cross mark at right cornered window
    Then Window opened should be closed

  @Indicators
  Scenario: TC_19: Verify indicators tab opened with other tabs in series suggestion manager window
    And User Select Series ID's as "384240277;454809317"
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And navigate from indicators to any other tab if present
    Then indicator tab should not cause low loadness for indicator's tab & vice-versa

  @Indicators
  Scenario: TC_20:Verify tooltips for minimize, full-scren and close icon's for indicator tab in series suggsetion manager window
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And hover mouse pointer over those icon's
    Then Minimize,full-screen/Exit full-scren,close tooltips should be seen

  @Indicators
  Scenario: TC_21: Verify tooltips for same icon's with minimized indicator's tab series suggestion manager
    And Select some series to my series tab
    And select all series check box checked
    And click on related series tab
    And click on minimize icon at top right corner of window
    And hover mouse pointer over those icon's
    Then Minimize,full-screen/Exit full-scren,close tooltips should be seen
