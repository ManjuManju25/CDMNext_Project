Feature: SprintCases_4.9 feature

  @sprint_4.9
  Scenario: TC_18940_01:Verify negative and forcast timepoints under SSP in Data tab
    And User Select Series ID as "366947417;205441502"
    And click on first series name
    And click on data under SSP window
    Then forecast timepoints should be in green color
    And click on second series name
    And click on data under SSP window
    Then Negative timepoints should be red color

  @sprint_4.9
  Scenario: TC_18729_01: Verify moved 'CEIC monthly newsletter' under analysis
    And click on Analysis tab
    And click '+' icon on monthly product updates
    And click '+' icon on what's new
    Then Check 'CEIC monthly newsletter'under analysis

  @sprint_4.9
  Scenario: TC_18729_02: Verify 'See all insights' under What's new tab
    And click on Notification icon in right side panel top
    And Scroll down and click on 'See all insights'
    Then Should be open under Analysis tab Monthly product updates

  @sprint_4.9
  Scenario: TC_19161_01: Verify background color for whole visual area
    And click on + icon in right side panel
    And Create commentary visual
    And add some test in commentary panel
    And click on visual dropdown and click on background
    And visual check box checked and select color
    Then The color should applied to whole visual area

  @sprint_4.9
  Scenario: TC_14534_01: Verify manage suggestion window from SSP
    And Add this series into my series "13132401"
    And click on series name and SSP popup open

  #And click on Manage button
  #Then The Popup should be open
  @sprint_4.9
  Scenario: TC_19169_01: Verify 'Webinars & Events' on notification panel
    And click on Notification icon in right side panel top
    And 'webinars and events' tab check under notification panel
    Then verify 'webinars and events' tab should be displayed

  @sprint_4.9
  Scenario: TC_19215_01:Verify 'See all Webinars' under What's new
    And click on Notification icon in right side panel top
    And 'whats new' tab check under notification panel
    And Scroll down and click on 'See all Webinars'
    Then verify 'Webinars & Events' tab should be opened

  @sprint_4.9
  Scenario: TC_19501: Implement support for World Trend > Forecast> Regional Forecast (source = OECD) in Comparables
    And Select source "OECD"
    And Navigate to World Trend >Forecast >Regional Forecast
    Then verify the comparable tab "OECD"

  @sprint_4.9
  Scenario: TC_19397: Verify the section name in comparable.
    Then verify the comparable tab "IMF.WEO: Gross Domestic Product"

  @sprint_4.9
  Scenario: TC_19318: Verify if Replacement Series to be Placed on the Same Positions in the Layout as their Parent Series
    And Search for series "8474401" in layout
    And Click show related data
    Then Check Replacement suggestions dataset

  @sprint_4.9
  Scenario: TC_19276: Verify if group with Popular Indicators to the Indicator filter ( Top Indicators tab)
    And Click on Indicator filter
    Then Popular group has to be selected by default

  @sprint_4.9
  Scenario: TC_19222: Verify if help is updated for Base value adjustment function
    And Select any series1
    And Click on function toolbar
    Then Select BVA function and go to the help section

  @sprint_4.9
  Scenario: TC_19160: Verify if Expand all from cross-country ( table mode) view in Comparables is removed
    And In database tree expand global db Afghanistan Afghanistan National Accounts
    And Click cross-country for first table
    Then It navigates to comparables tab

  @sprint_4.9
  Scenario: TC_19019: Verify if - Copy link  is added as a right click option to the Analysis tree (to all levels)
    And Open Analysis tab
    And Rightclick any of the sections copy link should be available "Analysis"

  @sprint_4.9
  Scenario: TC_18968_01: Verify round function from function toolbar
    And Add a series "1692001" into right-pane
    And Click on function toolbar apply round function "ROUND"
    Then Download to excel and verify the results "GDP Index PY100"

  @sprint_4.9
  Scenario: TC_18968_02 :Verify round function to replace original series
    And Add a series "1692001" into right-pane
    And Click on function toolbar apply round function and choose replace original series
    Then Download to excel and verify the results "GDP Index PY100 (1)"

  @sprint_4.9
  Scenario: TC_18968_03 :Verify round function to from download setting window
    And Add a series "1692001" into right-pane
    And Select download button, select function window from data transformation section and  apply round function
    Then Download to excel and verify the results "GDP Index PY100 (2)"

  @sprint_4.9
  Scenario: TC_18968_04 :Verify round function from chart visual
    And Create chart visual for series "1692001"
    And Select chart to right click and apply round function
    Then Verify the transformed series in chart

  @sprint_4.9
  Scenario: TC_18924 :Verify support for geo translation in SSP
    And Create SSP for series "319659201"
    Then Verify the Region "China"

  @sprint_4.9
  Scenario: TC_18773 :Verify if current title is displayed to allow minimum edit while renaming
    And Open a chart visual "319659201"
    And Click on title for editing
    Then Existing title to be displayed

  @sprint_4.9
  Scenario: TC_16153:Verify in Chart. "Edit visual" popup ifTimeframe is not changed for the line chart type
    And Create new insight1
    And Add any series and Create a line chart with it
    And Open "Edit Chart" popup
    And Select "Spline chart" type on the left panel
    And Set new timeframe by dragging timeframe bar on the chart
    And Select "Line chart" type on the left panel1

  @sprint_4.9
  Scenario: TC_19303: added Chinese translation is not reflected
    And Set Db language for WTP as chinese
    And Search for series "380482527" and create SSP

  @sprint_4.9
  Scenario: TC_19083: Post save sorting and CTC action pastes original heatmap visual
    And Create heatmap or table in an insight
    And Change date for sorting heatmap or table "2013" "2019"
    And click on copy icon or Ctrl+C
    Then Paste it onto excel

  @sprint_4.9
  Scenario: TC_19317:Verify subscription control for Footnotes and ssp
    Given login with that username
    Then Try to access the ssp and footnotes for the unsubscribed series
