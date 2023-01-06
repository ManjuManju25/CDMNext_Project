Feature: WatchList feature

  @Watch
  Scenario: TC_CVISION_WL_001: Check for adding of series into watchlist from left and right pane
    And Select a few series from left and right pane
    And Add to watchlist "popup_notifications"
    Then Check if series are added in watchlist tab

  @Watch
  Scenario: TC_CVISION_WL_002:Check for adding of table into watchlist
    And Select a few tables from left  pane
    And Add to watchlist "popup_notifications"
    Then Check if tables are added in watchlist tab

  @Watch
  Scenario: TC_CVISION_WL_003 :Verify if series can be added to watchlist from data, comparables and releases tab
    And Select a few tables from all tabs "Data" "Comparables" "Releases"
    And Add to watchlist "popup_notifications"
    Then Check if selected series are added in watchlist tab

  @Watch
  Scenario: TC_CVISION_WL_005:Verify if popup-up notifications option selection is retained
    And Add a series to watchlist
    And Choose Popup-notification "popup_notifications"
    Then Highlight the series in watchlist and click bell-icon "popup_notifications"

  @Watch
  Scenario: TC_CVISION_WL_006: Verify if Email notifications - Hourly option selection is retained
    And Add a series to watchlist
    And Check Email notifications "email_notifications" "Hourly"
    Then Highlight the series in watchlist and click bell-icon "email_notifications"

  @Watch
  Scenario: TC_CVISION_WL_007: Verify if Email notifications - Daily option selection is retained
    And Add a series to watchlist
    And Check Email notifications "email_notifications" "Daily"
    Then Highlight the series in watchlist and click bell-icon "email_notifications"

  @Watch
  Scenario: TC_CVISION_WL_008:Verify if Email notifications - Weekly option selection is retained
    And Add a series to watchlist
    And Check Email notifications "email_notifications" "Weekly"
    Then Highlight the series in watchlist and click bell-icon "email_notifications"

  @Watch
  Scenario: TC_CVISION_WL_009:Verify if Email notifications - Monthly option selection is retained
    And Add a series to watchlist
    And Check Email notifications "email_notifications" "Monthly"
    Then Highlight the series in watchlist and click bell-icon "email_notifications"

  @Watch
  Scenario: TC_CVISION_WL_010: Verify edit alert - Change to weekly
    And Add a series to watchlist
    And Go to watchlist and select the series and click edit alert drop-down "email_notifications" "Weekly"
    Then Highlight the series in watchlist and click bell-icon "email_notifications"

  @Watch
  Scenario: TC_CVISION_WL_011:Verify edit alert - Change to popup notifications
    And Add a series to watchlist
    And Go to watchlist and select the series and click edit alert drop-down1 "email_notifications" "popup_notifications"
    Then Highlight the series in watchlist and click bell-icon "popup_notifications"

  @Watch
  Scenario: TC_CVISION_WL_012:Verify Delete option
    And Select a series and table under watchlist "popup_notifications"
    Then Click on delete

  @Watch
  Scenario: TC_CVISION_WL_013:Verify turning off 'Enable All' option.
    And Open Watchlist tab "popup_notifications"
    Then Change the switch of Enable All to "OFF"

  @Watch
  Scenario: TC_CVISION_WL_014:Verify 'Sort by' filter Recently updated.
    And Add series with different updated dates to watchlist "popup_notifications"
    Then Select recently updated option

  @Watch
  Scenario: TC_CVISION_WL_015:Verify 'Sort by' filter Notification type.
    And Add series to watchlist "popup_notifications"
    Then select "Notification type" option1

  @Watch
  Scenario: TC_CVISION_WL_016:Verify 'Sort by' filter Email frequency
    And Add series with different frequencies to watchlist "popup_notifications"
    Then select "Email frequency" option1

  @Watch
  Scenario: TC_CVISION_WL_017:Verify 'Sort by' filter Region.
    And Add series with different Region to watchlist "All Regions" "China" "Beijing,Gansu,Guangxi" "popup_notifications"
    Then select "Region" option1

  @Watch
  Scenario: TC_CVISION_WL_018:Check the orientation descending order
    And Add series with different frequencies to watchlist "popup_notifications"
    Then select "Email frequency" option1
    Then Change the orientation order

  @Watch
  Scenario: TC_CVISION_WL_021:Validating the maximum number of series in watchlist
    And Add 2001 series into watchlist having series "popup_notifications"

  @Watch
  Scenario: TC_CVISION_WL_022:Verify if 1999 items can be added to watchlist
    And Add 1999 into watchlist having series "popup_notifications"
