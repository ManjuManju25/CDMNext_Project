Feature: Verifying the Forecast series functionality

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _01:Verify forecast tab in series suggestion tab
    Given User enters "32190101"
    And Add series to the right pane
    And Click on "Related Series"
    Then "Forecast" tab should be seen in series suggestion manager window

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _02:Verify series having forecast suggestions in search pane
    Given User enters "32190101"
    And Add series to the right pane
    And Open SSP window for the series
    Then "Forecasts" suggestions flag bar should be shown

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _03:Verify checkbox for series having suggestion in search pane
    Given User enters "32190101"
    And Add series to the right pane
    And Open SSP window for the series
    And Check the checkbox for forecast series
    Then Chart with forecast suggestions legends should be displayed

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _04:Verify deselecting legends in forecast suggestion dropdown
    Given User enters "32190101"
    And Add series to the right pane
    And Open SSP window for the series
    And Check the checkbox for forecast series
    And click on cross icon for any legends name
    Then Cross clicked legend of the chart in suggestion chart should be disabled

  @ForecastSeries01
  Scenario: Tc_Forecast Series Sugg _05:Verify opening ssp for more than suggestion of forecast in its chart suggestion dropdown
    Given User enters "32190101"
    And Add series to the right pane
    And Open SSP window for the series
    And Check the checkbox for forecast series
    And Click on suggested series of forecast
    Then Should be able to open respective ssp window

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _06:Verify collapsing available suggestion in forecast tab
    Given User enters "32190101"
    And Add series to the right pane
    And Click on "Related Series"
    And Click on minus sign checkbox
    Then All opened forecast suggestions are collapsed

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _07:Verify expanding collapsed suggestion in forecast tab
    Given User enters "32190101"
    And Add series to the right pane
    And Click on "Related Series"
    And Click on minus sign checkbox
    And click again on plus sign checkbox
    Then Closed forecast suggestions must be expanded

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _08:Verify selecting all available forecast suggestions
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All checkbox
    Then All the available forecast suggestions should get selected

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _09:Verify deselecting selected forecast suggestions
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All checkbox
    And Click again Manage All checkbox to deselect the suggestions
    Then Selected suggestions should get deselected

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _10:Verify selecting particular suggestions in forecast tab
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    Then Should be able to select particular suggestion for series

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _11:Verify manage all dropdown in forecast series suggestion manager
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All dropdown
    Then Below options should be shown
      | Add Forecasts              |
      | Add as new series          |
      | Replace the current series |

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _12:Verify Add forecasts in manage all dropdown of forecast tab in series suggestion manager window
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All dropdown
    And Select "Add Forecasts"
    Then All suggestions by default should get added with keep status

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _13:Verify f icon for forecast suggeted series in series suggestion manager window of forecast tab
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    Then "f" icon in a box should be seen for suggestion series of forecast

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _14:Verify chart icon for series which has forecast suggestions
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Chart should be displayed for suggestion series by default
    When Click on Chart icon
    Then Chart displayed should be hidden

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _15:Verify minimizing series suggestion window with forecast tab
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on "Minimize" option
    Then The Popup should be minimized

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _16:Verify expanding series suggestion window with forecast tab
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on "Full-screen" option
    Then The popup should be displayed in full screen

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _17:Verify closing series suggestion window for forecast tab
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on x icon to close
    Then The modal window should be closed

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _18:Verify splice func in forecast tab of series suggestion window
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Check "Splice" function
    Then "Adj. factor formula:" should be selected "Average ratio" by default

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _19:Verify splice func in forecast tab of series suggestion window
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Check "Splice" function
    Then "Adj. factor period:" should be selected "All" by default

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _20:Verify opening SSP for forecast suggestion series in forecast tab of series suggestion manager window
    Given Enter series id's"103003607; 399976317;103003507"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Hover on forecast series and click on "i" icon
    Then The SSP window should be opened

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _21:Verify preserve names with add forecasts
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    And Check Preserve as "names"
    And Click on Manage All dropdown
    And Select "Add Forecasts"
    Then Selected suggestions by default should get added with keep status

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _22:Verify preserve names with replace the current series
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    And Check Preserve as "names"
    And Click on Manage All dropdown
    And Select "Replace the current series"
    Then Selected suggestion should get replaced with current series

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _23:Verify preserve frequency with add forecasts
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    And Check Preserve as "frequency"
    And Click on Manage All dropdown
    And Select "Add Forecasts"
    Then Verify preserve frequency in my series tab

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _24:Verify click on ok without applying any modifications for forecast tab
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on "Ok"
    Then Series suggestion window should get closed

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _25:Verify click on cancel without modifications in forecast tab
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on "Cancel"
    Then Series suggestion window should get closed

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _26:Verify click on cancel with modifications in forecast tab
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    And Click on Manage All dropdown
    And Select "Add Forecasts"
    Then Series suggestion window should get closed

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _27:Verify click on apply button without modifications
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    Then Apply button should be disabled

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _28:Verify Replace current series in manage all dropdown of forecast tab in series suggestion manager window
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All dropdown
    And Select "Replace the current series"
    Then All suggestions should get replaced with current series

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _29:Verify creating any visual type with forecast suggestion series in my series pane
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All dropdown
    And Select "Replace the current series"
    And Click on "Apply"
    And Click on "Ok"
    And Select forecast suggestion series
    And Create table visual
    Then Visual should be created with "Edit Table"

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _30:Verify applying functions over forecast suggestion series in my series through function wizard
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All dropdown
    And Select "Replace the current series"
    And Click on "Apply"
    And Click on "Ok"
    And Select forecast suggestion series from my series pane
    And try to apply any of the function through function wizard
    Then Function should be able to apply

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _31:Verify applying functions over forecast suggestion series in my series through function tool bar
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All dropdown
    And Select "Replace the current series"
    And Click on "Apply"
    And Click on "Ok"
    And Select forecast suggestion series from my series pane
    And try to apply any of the function through function toolbar
    Then Function should be able to apply

  @ForecastSeries
  Scenario: Tc_For1ecast Series Sugg _32:Verify applying func over forecast suggestion series visual
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Click on Manage All dropdown
    And Select "Replace the current series"
    And Click on "Apply"
    And Click on "Ok"
    And Select forecast suggestion series
    And Create TableVisual
    And Right click on visual
    And Select "Calculate series"
    And Click on "All functions"
    And Apply with any function
    Then Function should be applied to the visual

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _33:Verify preserve frequency with replace the current series
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    And Check Preserve as "frequency"
    And Click on Manage All dropdown
    And Select "Replace the current series"
    Then Verify preserve frequency for forecast series with replace the current series in my series tab

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _34:Verify preserve formula with add forecasts
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Apply any function to any of the added series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    And Check Preserve as "formula"
    And Click on Manage All dropdown
    And Select "Add Forecasts"
    Then Verify preserve formula with add forecasts in my series tab

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _35:Verify preserve formula with replace the current series
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Apply any function to any of the added series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    And Select any particular suggestions by checking its checkbox
    And Check Preserve as "formula"
    And Click on Manage All dropdown
    And Select "Replace the current series"
    Then Verify preserve formula with replace the current series in my series tab

  @ForecastSeries
  Scenario: Tc_Forecast Series Sugg _36:Verify forecast suggested chart in forecast tab of series suggestion manager window
    Given Enter series id's"103003407;103003507;103003607"
    And Add some series to my series
    And Click on "Related Series"
    And Open forecast tab in series suggestion window
    Then Series legends should disable when mouse hover/clicking on the cross mark on the series
