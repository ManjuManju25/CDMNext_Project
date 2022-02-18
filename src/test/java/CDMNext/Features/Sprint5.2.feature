Feature: Verify shared saved search from search panel.

  @Sprint5_2_1
  Scenario: TC_19719_01 : Verify sharing saved search from search panel.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And Login to the shared user account.
    Then check for shared search under "saved search".

  @Sprint5_2_1
  Scenario: TC_19719_02 : Verify running search by selecting saved search.
    And waittime
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And Login to the shared user account.
    Then select Shared Search.

  @Sprint5_2_1
  Scenario: TC_19719_03 : Verify share icon for shared search.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And Login to the shared user account.
    Then Move the mouse on "shared search" under Share with Me.

  @Sprint5_2_1
  Scenario: TC_19719_04 : Verify copy icon for shared search.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And Login to the shared user account.
    Then Click on Copy Icon.

  @Sprint5_2_1
  Scenario: TC_19719_11 : Validate copied saved search
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And Login to the shared user account.
    And Click on Copy Icon and open browser.
    Then Run in the browserand copy the URL in the new Tab

  @Sprint5_2_1
  Scenario: TC_19719_06 : Verify growl message for sharing saved search.
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share and growl message should be displayed.

  @Sprint5_2_1
  Scenario: TC_19719_07 : Verify stop sharing saved search..
    Given User enters "India" in the search panel and save the search and click on the share icon
    And select a user and share.
    And Launch the private window
    And Enters username username
    And Enters password password
    When User clicks on "login"
    And Login to the shared user account.
    And select Shared Search option.
    And stop sharing saved Search.
    And Check for Shared Search

  @Sprint5_2_1
  Scenario: Verify copy icon for saved search.
    Given User enters "India" in the search panel and save the search
    And move the mouse on the saved Search
    Then click on copy Icon

  @Sprint5_2_1
  Scenario: TC_19719_11: Validate copied saved search.
    Given User enters "India" in the search panel and save the search
    And move the mouse on the saved Search
    And click on copy Icon
    Then Run URL in the browser

  @Sprint5_2_1
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
    And check for shared style.
    And stop sharing saved Style.
    Then check for Shared style under shared with me.

  @Sprint5_2_14
  Scenario: TC_20270_03: Verify border and scroll bar for saved search.
    Given user enters  searches "raj","guru1","test2","test","mahesh","shankar".
    And save the search.
    Then scroll bar should be displayed and border should be applied for the popup after 5 saved searchs created.
 
    
  @Sprint5_2_2
  Scenario: TC_14304_01: Verify check box for Data tab.
    Given user clicks on 3 dots in datatab header
    And observe the checkbox for Datatab.
   

  @Sprint5_2_2
  Scenario: TC_14362_01: Verify 'Add and Group' option for table level in database.
    Given user clicks on Database section.
    And expand the database till table level.
    Then check for Add and group option.

  @Sprint5_2_17
  Scenario: TC_12173_01: Verify frozen date column in table visual.
    Given user creates a table visual with 10 series.
    And scroll horizontal and verify the date column.

  @Sprint5_2_2
  Scenario: TC_14859_01 : Verify tooltip for 'fx' option under download popup.
    Given user clicks on Download window.
    And move the mouse on fx options.
    

  @Sprint5_2_2
  Scenario: TC_19891_01 : Verify unchecking the show copyright checkbox.
    Given user clicks on view and edit profile information.
    And click on change for copyright. 
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
  Scenario: TC_20334_01: Verify 0 observation series for external users.
    Given user Clicks on Login to CDMNext with an external account
    Then Search for 0 observation series : "299244904 299241004".
    
    	
    		
    			
    				
    				
    @Sprint5_2_26
  Scenario: TC_14144_01: Verify the title checkbox when removing custom text in the title popup under edit visual. 
    Given user selects View as a Histogram from More actions
    And clicks on edit Histogram and enter title as "shankar".
    And Title > Add your title for the visual > displayed on visual
    Then Removes the title.
    
    
    
     @Sprint5_2_3
  Scenario: TC_20270_03: Verify email field for Non-email users. 
    Given user Logout from current user
    And User logins into CDM Next with Username : "suresh" and Password : "Ceic@123".
    Then Check for Email Id field for watchlist across the application.
#=========================Internal Account=========================================================================
   
   @Sprint5_2_3
  Scenario:	TC_20076_01 : Verify "CEIC Insights" under notification if shared insight from internal user.
    Given user Logout from current user
    And Logins with internal account with username : "svenkatraju" and Password : "z0lfdt?Dkj"
    And Share insight "Company" from internal to external account.
    And Login to shared user account.
    Then Notification > check for the shared user name.
    
    @Sprint5_2_3
  Scenario: TC_20060_01 : Verify 'FocusEconomics' under Analysis tab.
    Given user Logout from current user
    And Logins with internal account with username : "svenkatraju" and Password : "z0lfdt?Dkj"
    And Navigate to Analysis > FocusEconomics
    Then The folder name should be 'FocusEconomics'(oneword).
    
   
   
    @Sprint5_2_30
  Scenario: TC_19984_01 : Verify indication for internal series when the 'Show all' filter is applied.
    Given user Logout from current user
    And Logins with internal account with username : "svenkatraju" and Password : "z0lfdt?Dkj"
    And Search "Table CN.GE" in the search field.
    And select ShowAll filter.
    And Open DB > Topic >Section>Table.
    Then Orange and Green dots should display to indicate Orange as internal series and Green as Matched series.
    
    
    
    
    
    
    
    
    
