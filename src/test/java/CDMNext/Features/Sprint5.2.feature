Feature: Verify shared saved search from search panel.

  @Sprint5_2_2
  Scenario: TC_19719_01 : Verify sharing saved search from search panel.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    # And Login to the shared user account.
    Then check for shared search under "saved search".

  @Sprint5_2_2
  Scenario: TC_19719_02 : Verify running search by selecting saved search.
    # And waittime
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    #And Login to the shared user account.
    Then select Shared Search.

  @Sprint5_2_2
  Scenario: TC_19719_03 : Verify share icon for shared search.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    # And Login to the shared user account.
    Then Move the mouse on "shared search" under Share with Me.

  @Sprint5_2_2
  Scenario: TC_19719_04 : Verify copy icon for shared search.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    # And Login to the shared user account.
    Then Click on Copy Icon.

  @Sprint5_2_2
  Scenario: TC_19719_11 : Validate copied saved search
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    #And Login to the shared user account.
    And Click on Copy Icon and open browser.

  #Then Run in the browserand copy the URL in the new Tab
  @Sprint5_2_2
  Scenario: TC_19719_06 : Verify growl message for sharing saved search.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share and growl message should be displayed.

  @Sprint5_2_2
  Scenario: TC_19719_07 : Verify stop sharing saved search..
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    # And Login to the shared user account.
    And select Shared Search option.
    And stop sharing saved Search.
    And Check for Shared Search

  @Sprint5_2_2
  Scenario: Verify copy icon for saved search.
    Given User enters "India" in the search panel and save the search
    And move the mouse on the saved Search
    Then click on copy Icon

  @Sprint5_2_2
  Scenario: TC_19719_11: Validate copied saved search.
    Given User enters "India" in the search panel and save the search
    And move the mouse on the saved Search
    And click on copy Icon
    Then Run URL in the browser

  @Sprint5_2_2
  Scenario: TC_19720_01: Verify share icon for visual styles.
    Given User selects any series and creates a visual Table from More Actions.
    And clicks on Edit Table which is under view Tab.
    And make changes in settings.
    And click on the + icon and enter the text as "Suresh" and save the style.
    Then Move the mouse on saved style and click on share icon.

  @Sprint5_2_2
  Scenario: TC_19720_02: Verify sharing visual style.
    Given User selects any series and creates a visual Table from More Actions.
    And clicks on Edit Table which is under view Tab.
    And make changes in settings.
    And click on the + icon and enter the text as "Suresh" and save the style.
    And Move the mouse on saved style and click on the share icon.
    And select a user and share style.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And shared visual style should be available under 'Shared to me'.

  @Sprint5_2_2
  Scenario: TC_19720_03: Verify applying shared visual style.
    Given User selects any series and creates a visual Table from More Actions.
    And clicks on Edit Table which is under view Tab.
    And make changes in settings.
    And click on the + icon and enter the text as "Suresh" and save the style.
    And Move the mouse on saved style and click on the share icon.
    And select a user and share style.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And Select shared style.
    Then Validate Visual Style.

  @Sprint5_2_2
  Scenario: TC_19720_04: Verify share/delete options for shared styles.
    Given User selects any series and creates a visual Table from More Actions.
    And clicks on Edit Table which is under view Tab.
    And make changes in settings.
    And click on the + icon and enter the text as "Suresh" and save the style.
    And Move the mouse on saved style and click on the share icon.
    And select a user and share style.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And mouseover on the shared style.
    Then Validate Share and delete options.

  @Sprint5_2_2
  Scenario: TC_19719_07: Verify stop sharing saved search.
    Given User selects any series and creates a visual Table from More Actions.
    And clicks on Edit Table which is under view Tab.
    And make changes in settings.
    And click on the + icon and enter the text as "Suresh" and save the style.
    And Move the mouse on saved style and click on the share icon.
    And select a user and share style.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    # And Login to the shared user account.
    And check for shared style.
    And stop sharing saved Style.
    Then check for Shared style under shared with me.

  @Sprint5_2_2
  Scenario: TC_14304_01: Verify check box for Data tab.
    Given user clicks on 3 dots in datatab header
    And observe the checkbox for Datatab.

  @Sprint5_2_2
  Scenario: TC_14362_01: Verify 'Add and Group' option for table level in database.
    Given user clicks on Database section.
    And expand the database till table level.
    Then check for Add and group option.

  #@Sprint5_2_2
  #Scenario: TC_12173_01: Verify frozen date column in table visual.
  #Given user creates a table visual with 10 series.
  #And scroll horizontal and verify the date column.
  @Sprint5_2_2
  Scenario: TC_14859_01 : Verify tooltip for 'fx' option under download popup.
    Given user clicks on Download window.
    And move the mouse on fx options.

  @Sprint5_2_2
  Scenario: TC_19891_01 : Verify unchecking the show copyright checkbox.
    Given user clicks on view and edit profile information.
    And click on change for copyright.
    And uncheck the checkbox for copyright.
    Then All options under setup should be greyed out when unchecked.

  @Sprint5_2_2
  Scenario: TC_19428_01 : Verify remove icon for attachment in report a problem popup.
    Given user clicks on Help Title.
    And Open report a problem popup.
    And Upload attachment .
    Then click on remove icon.

  @Sprint5_2_2
  Scenario: TC_14687_01 : Verify the current visual in visual type dropdown under edit visual.
    Given user Click on the edit table.
    And Click on the visual type dropdown.
    Then current visual(table) should not display under the visual dropdown.

  @Sprint5_2_2
  Scenario: TC_20145_01 : Verify copyright information under Help menu.
    Given user Click on Help Menu Popup.
    And Check for copyright information.

  @Sprint5_2_2
  Scenario: TC_20145_02 : Verify the current year in the copyright information.
    Given user Click on Help Menu Popup.
    And Check for copyright information for current year.

  @Sprint5_2_2
  Scenario: TC_20240_01 : Verify insight name in the delete confirmation popup.
    Given user Clicks on Open File Menu beside Insights
    And Enters insight name as "CEIC Insights"
    And Try to delete an insight.
    Then insight name should be displayed in the delete confirmation popup.

  @Sprint5_2_2
  Scenario: TC_	20334_01: Verify 0 observation series for external users.
    Given user Clicks on Login to CDMNext with an external account
    Then Search for 0 observation series : "291668204 286849804".

  #@Sprint5_2_2
  #Scenario: TC_14144_01: Verify the title checkbox when removing custom text in the title popup under edit visual.
  # Given user selects View as a Histogram from More actions
  # And clicks on edit Histogram and enter title as "shankar".
  #And Title > Add your title for the visual > displayed on visual
  #Then Removes the title.
  @Sprint5_2_2
  Scenario: TC_20431_02 : Verify comparables based on non applicable source
    Given user Search with sources: "Central bureau of statistics"
    And Verify comparables

  @Sprint5_2_2
  Scenario: TC_14161_06: UI Pre-condition: Cross Section & Sum - prevent apply over a single series
    Given user selects series into my series tab
    And Try to apply cross section or sum over single series from functions wizard.

  @Sprint5_2_2
  Scenario: TC_11664_01: FEEDBACK: an option to use custom symbols for "Fill blank observations with .." in Download
    Given user selects some series into my series tab
    And click on download button.
    Then open dropdown for Output Series Details

  @Sprint5_2_2
  Scenario: TC_9817_13: Select All series > 'Move Up/bottom' button doesn't work
    Given user selects some series into my series tab
    And Select all series->look for move down or move up icons

  @Sprint5_2_2
  Scenario: TC_17815_01: Verify  that labels in the legend are always fully visible
    Given user creates a Map Visual.
    And Oberve the legend which will be present in the bottom of the map visual.

  @Sprint5_2_2
  Scenario: TC_19793_07: Verify  Search:Improve the source display in the search filter "Sources".
    Given user selects Goto sources dropdown in search pane.
    And enter "CEIC Data" in search feild.

  @Sprint5_2_2
  Scenario: TC_20272_01: Source filter: search by abbreviation.
    Given user clicks on source filter.
    And apply some filters by abbreviation : "MOF" and "ABIPLAST".
    And by default top matches option is displayed.

  @Sprint5_2_2
  Scenario: TC_20272_02: Source filter: search by abbreviation when "All sources" option is selected
    Given user clicks on source filter.
    And apply some filters by abbreviation : "MOF" and "ABIPLAST".

  @Sprint5_2_2
  Scenario: TC_20272_03: Source filter: search by abbreviation when "Exclude Value" checkbox is check
    Given user clicks on source filter.
    And apply some filters in search bar like : "MOF" and "ABIPLAST".
    And by default top matches option is displayed.

  @Sprint5_2_2
  Scenario: TC_20272_04: Source filter: search by abbreviation when "Exclude Value" checkbox is uncheck
    Given user clicks on source filter.
    And apply some source filters as "MOF" , "ABIPLAST" and checkbox should be uncheck.

  @Sprint5_2_2
  Scenario: TC_19976_16: URL redirect issue
    Given user clicks on any Apply filter in the application
    And clicks on Copy as URL
    And Paste the copied URL in the search bar.

  @Sprint5_2_2
  Scenario: TC_19825_01: Implement support to display table along with the map
    Given user selects any series and creates a Map Visual
    And click on Click on  Map+Table icon next to world Map

  @Sprint5_2_2
  Scenario: TC_19531_15: Support countries groups from EDGE
    Given user selects Search pane->Open All regions dropdown.
    And Group of countries list under All regions should be loaded.

  @Sprint5_2_2
  Scenario: TC_20096_03:Remove "Select series" dropdown from the Function Wizard popup
    Given user selects some series
    And Open function wizard for any series to apply with function

  @Sprint5_2_2
  Scenario: TC_19830_05: Pie: add support for the absolute values
    Given user searches with series Id : "211194302;5190701".
    And try to create a Pie with negative value.
    And Edit visual check for absolute value.

  @Sprint5_2_2
  Scenario: TC_19704_02: Implement support for a Donut chart (as a subtype of the Pie chart)
    Given user clicks on New insight->open pie dropdown->click on donut
    And try to open edit Visual for donut.

  @Sprint5_2_2
  Scenario: TC_19271_08: Add tooltips to dots used in search ( internal series, see in tree, the node contains matches)
    Given user Filter out search with continuous under More dropdown.
    And User has clicked on "Apply filter"
    And check for orange series.
    And expand release tab for green series.
    And Open database for purple series.

  @Sprint5_2_2
  Scenario: TC_20270_03: Verify border and scroll bar for saved search.
    Given user enters five saved searches and scroll bar should be displayed.
    And Delete the saved searches.
    

  @Sprint5_2_2
  Scenario: TC_20210_11: Search: Replacement icon is missing for series having both continuous and replacements.
    Given user selects S from More Actions.
    And User has clicked on "Apply filter"
    And Replacement series should be shown.
    And selects C from More Actions.
    And User has clicked on "Apply filter"
    And Continuos series should be shown.

  @Sprint5_2_2
  Scenario: TC_19791_04: Implement a tab for continuous series in the Insight summary popup
    Given user Filter out search with continuous under More dropdown.
    And User has clicked on "Apply filter"
    And user selects some series into my series tab
    And click on refresh Insight.

  @Sprint5_2_2
  Scenario: TC_20333: Verify accessible to Test topics to external user accounts.
    Given user logins with external account
    And access comparables tab.

  #@Sprint5_2_2
  #Scenario: TC_20270_03: Verify email field for Non-email users.
  # Given user Logout from current user
  #And User logins into CDM Next with Username : "suresh" and Password : "Ceic@123".
  #Then Check for Email Id field for watchlist across the application.
  #=========================Internal Account=========================================================================
  @Sprint5_2_2
  Scenario: TC_20076_01 : Verify "CEIC Insights" under notification if shared insight from internal user.
    Given user Logout from current user
    And Logins with internal account with username : "svenkatraju" and Password : "z0lfdt?Dkjln"
    And Share insight "Company" from internal to external account.
    And Login to shared user account.
    And Login to the shared user account.
    Then Notification > check for the shared user name.

 # @Sprint5_2_2
  #Scenario: TC_20060_01 : Verify 'FocusEconomics' under Analysis tab.
    #Given user Logout from current user
   # And Logins with internal account with username : "svenkatraju" and Password : "z0lfdt?Dkjln"
    #And Navigate to Analysis > FocusEconomics
    #Then The folder name should be 'FocusEconomics'(oneword).

  @Sprint5_2_2
  Scenario: TC_19984_01 : Verify indication for internal series when the 'Show all' filter is applied.
    Given user Logout from current user
    And Logins with internal account with username : "svenkatraju" and Password : "z0lfdt?Dkjln"
    And Search "Table CN.GE" in the search field.
    And select ShowAll filter.
    And Open DB > Topic >Section>Table.
    Then Orange and Green dots should display to indicate Orange as internal series and Green as Matched series.

  @Sprint5_2_2
  Scenario: TC_19598_01: Verify email field for Non-email users.
    Given user Logout from current user
    And User logins into CDM Next with Username : "suresh" and Password : "Ceic@123".
    And Login to the shared user account.
    Then Check for Email Id field for watchlist across the application.
