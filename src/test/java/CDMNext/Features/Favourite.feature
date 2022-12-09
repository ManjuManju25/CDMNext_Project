Feature: Verify favorite function popup

  @Favourite
  Scenario: Tc_Favfunc_01 : Verify favorite function popup
    Given user add some series into my series.
    And clicks on fx icon.

  @Favourite2
  Scenario: Tc_Favfunc_02 : Verify starred icon for functioned series
    Given user add some series into my series.
    And Apply function on a series from function bar
    And Apply function on a series from function wizard.

  @Favourite
  Scenario: Tc_Favfunc_03 : Verify favoriting the function applied series
    Given user add some series into my series.
    And Apply function on a series=>click on starred icon
    Then starred icon should be filled.

  @Favourite
  Scenario: Tc_Favfunc_04 : Verify Favorited function in favorite function popup
    Given user add some series into my series.
    And Apply function on a series=>click on starred icon
    Then starred icon should be filled.
    Then Applied function should be shown in favorite function feild.

  @Favourite
  Scenario: Tc_Favfunc_09: Verify marking favorite function from edit series
    Given user Creates any visual.
    And click on Edit series
    Then mark series as favourite.

  @Favourite
  Scenario: Tc_Favfunc_10: Verify marking favorite function from function applied from edit series.
    Given user Creates any visual.
    And click on Edit series
    And navigate to my series.
    Then should be made as favorite.

  @Favourite
  Scenario: Tc_Favfunc_14: Verify favorite the function for multiple function applied on series
    Given user add some series into my series.
    And Apply series with more than one function.
    And click on starred icon.
    Then should be mark as favorite.

  @Favourite
  Scenario: Tc_Favfunc_15: Verify remove one function from favorited function
    Given user add some series into my series.
    And Apply series with more than one function.
    And click on starred icon.
    Then remove the function applied.

  @Favourite
  Scenario: Tc_Favfunc_16: Verify marking same function as favorite multiple times
    Given user add some series into my series.
    And Apply first series with function round
    And click on starred icon.
    Then select second series and apply same function as round.

  @Favourite
  Scenario: Tc_Favfunc_08: Verify marking one of the function as favorite in recents
    Given user add some series into my series.
    And Apply first series with function.
    And click on starred icon.
    And refresh the page.
    Then should be able to see starred icon in both recent and favorite tabs

  @Favourite
  Scenario: Tc_Favfunc_17: Verify applying favorited function on other series
    Given user add some series into my series.
    And Apply first series with function.
    And click on starred icon.
    And select second series=>click on previously Marked favorite marked function.
    Then second series must be applied with same as first series function.

  @Favourite
  Scenario: Tc_Favfunc_18: Verify filled starred icon in edit series and calculate series
    Given user creates a visual=>click on edit series
    And Apply with function=>Mark as favorite
    Then click on more function dropdown at same time=>Right click on visual

  @Favourite
  Scenario: Tc_Favfunc_19: Verify remove marked as favorite function to unfavorite
    Given user add some series into my series.
    And Apply series with more than one function.
    And click on starred icon.
    Then favorite should be marked as unfavorite.

  @Favourite
  Scenario: Tc_Favfunc_20: Verify remove marked favorite function to unfavorite
    Given user add some series into my series.
    And Apply series with more than one function.
    And click on starred icon.
    And favorite should be marked as unfavorite.
    Then should be able to unmark in favorite function pop up window

  @Favourite
  Scenario: Tc_Favfunc_05: Verify max recent functions in fav func popup.
    Given user add 5 series into my series.
    And Apply each with different functions
    And click on fx.
    Then last applied function should be on top.
   
