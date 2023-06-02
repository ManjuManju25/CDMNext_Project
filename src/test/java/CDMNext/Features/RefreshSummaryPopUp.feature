Feature: Refresh Summary PopUp feature

  @RSP
  Scenario: RSP_01: Verify RSP for 'series'
    And add some series into my series with more dropdown rebased filter
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then Latest changes in your insights popup should be display

  @RSP
  Scenario: TC_02:Verify RSP for 'visuals'
    And create some visuals with more dropdown rebased filter
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then Latest changes in your insights popup should be display

  @RSP
  Scenario: TC_03: Verify RSP for replacement series when logged in freshly
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    And select all series check box checked
    And click on related series tab
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then Only replacement tab should be shown in RSP

  @RSP
  Scenario: TC_04: Verify RSP for replacement series for visuals
    And new insight search series ids as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    And add series into visuals
    And Click on my series and selct all checkbox
    And click on add related series
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then Only replacement tab should be shown in RSP

  @RSP
  Scenario: TC_05: Verify RSP for different kind of updates
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    And select all series check box checked
    And click on related series tab
    Then some tabs display in RSP

  @RSP
  Scenario: TC_06: Verify Replacement for series under RSP
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on manageAll dropdown then click on Replace inactive series
    And click on Apply
    Then Replacement of series should be showed in myseries

  @RSP
  Scenario: TC_07: Verify Replacement for 'visuals under RSP'
    And new insight search series ids as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    And add series into visuals
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on manageAll dropdown then click on Replace inactive series
    And click on Apply and ok
    Then Replacement of series in a visuals should be myseries

  @RSP
  Scenario: TC_08:Verify RSP when don’t show again is checked
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And Check don’t show again checkbox
    And click on close window
    Then click on signout
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then RSP should not be shown

  @RSP
  Scenario: TC_09: Verify RSP to enable RSP when don’t show again is checked
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And Check don’t show again checkbox
    And click on close window
    Then click on signout
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on profile dropdown
    And check for show latest changes for insights upon opening
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then RSP should be shown again

  @RSP
  Scenario: TC_10: Verify minimising RSP
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on minimize icon on RSP
    Then RSP should be minimized

  @RSP
  Scenario: TC_11: Verify maxmizing RSP
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on minimize icon on RSP
    And click on outside arrow icon on minimised RSP
    Then RSP should be miximized

  @RSP
  Scenario: TC_12: Verify enlarging RSP
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on outside arrow icon RSP
    Then RSP should be enlarged

  @RSP
  Scenario: TC_13: Verify cross mark in RSP
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on cross mark in RSP
    Then RSP should get closed

  @RSP
  Scenario: TC_14:Verify cancel button in RSP
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on cancel button in RSP
    Then RSP should get closed

  @RSP
  Scenario: TC_15:Verify RSP for new insight
    And New insight search with given data as "19525401;91271701" with two series
    And click on profile dropdown
    Then observe for 'show latest updates in my insights upon opening' Option should be checked by default

  @RSP
  Scenario: TC_16: Verify RSP when site is refreshed
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on cancel button in RSP
    And refresh the page
    Then RSP should be opened

  @RSP
  Scenario: TC_17:Verify refresh from settings icon
    And New insight search with given data as "19525401;91271701" with two series
    And click on open file menu(settings icon)
    And click on refresh
    And click on Continue button in Do you want to keep your insight popup
    Then RSP should be opened

  @RSP
  Scenario: TC_18: Verify not showing RSP
    And New insight search with given data as "384240277;384238147;454809317;32189801;103003507;353687487;199660502;353687507;114179008;319781402"
    And click on profile dropdown
    And uncheck the Show latest changes in my insights upon opening
    And refresh the site
    Then RSP not display

  @RSP
  Scenario: TC_19:Verify RSP for unsaved insight
    And New insight search with given data as "19525401;91271701" with two series
    And refresh the site
    Then RSP should be closed

  @RSP
  Scenario: TC_20: Verify dismiss button in RSP
    And add some series into my series with more dropdown rebased filter
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on dismiss button in RSP window
    Then click on signout
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then RSP window should not be opened

  @RSP
  Scenario: TC_21: Verify dismiss button in RSP for refresh action
    And add some series into my series with more dropdown rebased filter
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on dismiss button in RSP window
    And refresh the page
    Then RSP window should not be opened

  @RSP
  Scenario: TC_22:Verify dismiss button in new insight for same filter as previous insight
    And add some series into my series with more dropdown rebased filter
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    And click on dismiss button in RSP window
    And refresh the page
    Then RSP window should not be opened
    And click on CDMNext, CEIC’s Data Manager
    And add some series into my series with more dropdown rebased filter
    Then logout by saving insight
    And login again with username "rmane@isimarkets.com" and passowrd as "Arnav@4116#90"
    And click on Myinsights
    And click on recent saved insights
    And click on open
    Then RSP should be opened

  @RSP
  Scenario: TC_23: Verify click on dismiss button should not uncheck show latest changes in my insight upon opening
    And add some series into my series with more dropdown rebased filter
    And refresh the site
    And click on dismiss button in RSP window
    And click on profile dropdown
    Then show latest changes in my insight upon opening option should be checked only
