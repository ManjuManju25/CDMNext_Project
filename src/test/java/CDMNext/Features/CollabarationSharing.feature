Feature: Verifying Insight Share functionality
  
@CollabarationSharing
Scenario: TC_Delete_Insight: Verify Delete Insight
   And Deleting insights as prerequesties
    
@CollabarationSharing
Scenario: TC_Share_02: Verify Share option from insight > File
   And Login as current execution login by taking username rowcount as 1 and cellcount as 0 and for password rowcount as 1 and cellcount as 1
   And Navigate to "File" -> "Share" 
   Then The "Share" window should present
   
@CollabarationSharing
Scenario: TC_Share_03: Verify Share option from insight > Grid mode
   And Click on my insights
   And Click "View as a grid" option from empty list
   And Move the mouse on any one of the insights
   And Click "Share" option
   Then The "Share" window should present
   
@CollabarationSharing
Scenario: TC_Share_04: Verify Share option from insight > Table mode
   And Click on my insights
   And Click "View as a table" option from empty list
   And Right click on Insight name and click on "Share" 
   Then The "Share" window should present
   
@CollabarationSharing
Scenario: TC_15259_01: Verify confirmation popup for insight sharing
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Entering mail to share the insight
   And Click on "Save" button to share
   Then Share "Confirmation" popup should display every time share insight
   
@CollabarationSharing
Scenario: TC_15259_02: Verify description for share confirmation popup
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   Then The description should be "Do you want to email users about sharing changes?" 
   
@CollabarationSharing
Scenario: TC_15259_03: Share confirmation popup - Verify OK button
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "OK" button in insight preview
   And The "OK" button is clickable 
   
@CollabarationSharing
Scenario: TC_15259_05: Share confirmation popup - Verify 'Don't email' button
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "Don't email" button in insight preview
   Then The "Don't email" button is clickable
   
@CollabarationSharing
Scenario: TC_15259_06: Share confirmation popup - Verify 'Cancel changes' button
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "Cancel changes" button in insight preview
   And The "Cancel changes" button is clickable
   And Click on "Insight" icon to share insight
   Then The share process should be declined
   
@CollabarationSharing
Scenario: TC_15259_09: Verify confirmation popup for second time share
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   And Hover on "Don't email" button in insight preview
   And The "Don't email" button is clickable
   And Click on "Insight" icon to share insight
   And Select Users to share for second time
   And Click on "Save" button to share
   Then The confirmation popup should be displayed only for first time share
   
@CollabarationSharing
Scenario: TC_Share_06: Verify Share option status when insights shared/not.
   And Click "File" > "New" 
   And Create a fresh insight
   Then Verify the insight for "share" icon
   And Click on "Insight" icon to share insight
   And Select Users to share
   And Click on "Save" button to share
   Then Verify the insight for "shared" icon
   
@CollabarationSharing
Scenario: TC_Share_10: Verify user email ID for already shared and not shared insights.
   And Verify Share option status
   And Click on my insights
   And Click "View as a table" option from empty list
   And Select the first insight
   And Click "Insight Share" option
   Then The shared mail should display in Share popup
   
@CollabarationSharing
Scenario: TC_Share_13: Verify 'Share' option for untitled insight in CDMNext.
   And Navigate to "File" -> "Share" 
   And The "Name insight" window is present
   Then The "Share" window popups
   
@CollabarationSharing
Scenario: TC_Share_14:Verify number of insights counts for sharing.
   And Click on my insights
   And Click "View as a table" option from empty list
   And Select 3 insights from table mode
   And Click "Insight Share" option
   Then The number of insights selected should match
   
@CollabarationSharing
Scenario: TC_Share_15:Verify insight owner name and email ID in share popup.
   And Click on my insights
   And Click "View as a table" option from empty list
   And Select 4 insights from table mode
   And Click "Insight Share" option
   Then The Insight owner name and Email ID should be displayed
   
@CollabarationSharing
Scenario: TC_Share_17:Verify 'Any user within the company Accounts'.
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   Then Click on dropdown to view permission list to check for "none" , "can view" and "can edit" and "none" is selected by default
   
@CollabarationSharing
Scenario: TC_Share_20:Verify 'Users' dropdown
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   #And Click on "Users" dropdown in share popup
   Then The list of users name with email ID should be displayed
   
#TC_21 to TC_24   
@CollabarationSharing
Scenario: TC_Share_21:Users - Search for user name/email ID you want to invite.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   #And Click on "Users" dropdown in share popup
   Then The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can view" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "view" permission in next user login
   And Login back to current user
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_26:User - Verify sharing insight with can edit permission.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   #And Click on "Users" dropdown in share popup
   Then The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can edit" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "edit" permission in next user login
   And Login back to current user
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_27:User - Verify sharing insight with can manage permission.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   #And Click on "Users" dropdown in share popup
   Then The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can manage" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "manage" permission in next user login
   And Login back to current user
   And Delete Insight
   
@CollabarationSharing
Scenario Outline: TC_Share_62:Verify 'Permission' tab under insight settings.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click "Open File menu" option from the title
   And Click "Protect" option
   Then The expected permission <insight_settings> should display
Examples:   
       | insight_settings  |
       |      "Edit"       |
       |      "Copy"       |
       
@CollabarationSharing
Scenario: TC_Share_71: Verify Cancel/Dismiss(X) button for share window.
   And Navigate to "File" -> "Share" 
   And The "Name insight" window is present
   Then The Cancel icon in share popup should verify
      
# ---------------------------------------------------------> Two logins <-----------------------------------------------------------------
@CollabarationSharing
Scenario: TC_Share_07: Verify 'Multiple insights' sharing.
   And Create 3 new insights
   And Click on my insights
   And Click "View as a table" option from empty list
   And Select newly created insights in table mode
   And Click "Insight Share" option
   And Entering mail to share the insight
   And Perform Share action
   And Logout from current user
   And Login as next user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created Insights should appear in next user login
   And Login back to current user
   And Click on my insights
   And Click "Created" tab
   And Delete Insight
        
@CollabarationSharing
Scenario: TC_Share_18: Verify share to 'Any user within the company Accounts with Can view permission'.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on dropdown to view permission list to select "can view" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "view" permission in next user login
   And Login back to current user
   And Click on my insights
   And Click "Created" tab
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_19: Verify share to 'Any user within the company Accounts with Can edit permission'.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on dropdown to view permission list to select "can edit" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "edit" permission in next user login
   And Login back to current user
   And Click on my insights
   And Click "Created" tab
   And Delete Insight
   
#TC_21 to TC_24   
@CollabarationSharing
Scenario: TC_Share_21:Users - Search for user name/email ID you want to invite.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on "Users" dropdown in share popup
   Then The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can view" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "view" permission in next user login
   And Login back to current user
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_26:User - Verify sharing insight with can edit permission.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on "Users" dropdown in share popup
   Then The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can edit" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "edit" permission in next user login
   And Login back to current user
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_27:User - Verify sharing insight with can manage permission.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on "Users" dropdown in share popup
   Then The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can manage" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "manage" permission in next user login
   And Login back to current user
   And Delete Insight
      
@CollabarationSharing
Scenario: TC_Share_51: Verify shared insights under 'Shared insights' tab in insight explorer.
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   #And Click on "Users" dropdown in share popup
   And Entering mail to share the insight
   And Perform Share action
   And Logout from current user
   And Login as next user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created Insight should appear in next user login at first place
   And Login back to current user
   And Click on my insights
   And Click "Created" tab
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_53: Verify stoping shared insight.
   And Capture the creator user name
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Entering mail to share the insight
   And Click on dropdown to select "can edit" permission
   And Login as next user
   Then The newly created Insight should appear in second login before stopping of sharing with shared user name   
   And Open sharing window next time
   Then The newly created insight should vanish in second login when insight is stopped sharing
   
@CollabarationSharing
Scenario: TC_Share_65:Permission - Validate "Edit=Off" for shared insight with edit permission.
   And Click "File" > "New" 
   And Create a fresh insight 
   And Click on "Insight" icon to share insight
   And The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can edit" permission
   And Perform first login actions
   Then The newly created insight should appear as "edit" permission in next user login
   And Perform second login actions
   And Click on "File" > "Protect" > "Edit" > "OFF" > "Apply" 
   And Perform first login actions
   Then The newly created insight should appear as "view" permission in next user login
   And Perform third login actions
   
@CollabarationSharing
Scenario: TC_Share_66:Permission - Validate "Edit=Off" for shared insight with manage permission.
   And Click "File" > "New" 
   And Create a fresh insight 
   And Click on "Insight" icon to share insight
   And The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can manage" permission
   And Perform first login actions
   Then The newly created insight should appear as "manage" permission in next user login
   And Perform second login actions
   And Click on "File" > "Protect" > "Edit" > "OFF" > "Apply" 
   And Perform first login actions
   Then Perform some actions in Manage insight of next login
   And Perform third login actions
   
@CollabarationSharing
Scenario: TC_Share_67:Permission - verify "Copy=ON" for shared insights.
   And Click "File" > "New" 
   And Create a fresh insight 
   And Click on "Insight" icon to share insight
   And The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can view" permission
   And Click on File > Protect > Copy > ON > Apply 
   Then Perform "Copy" action by using "Save as" option in the context menu
   And Perform third login actions
   
@CollabarationSharing
Scenario: TC_Share_68:Permission - Verify save as option under file when "Copy=OFF" and Verify 'Copy' option under insight explorer
   And Click "File" > "New" 
   And Create a fresh insight 
   And Click on "Insight" icon to share insight
   And The searched user "ceicsuresh10@gmail.com" is fetching proper results and given "can view" permission
   And Click on "File" > "Protect" > "Copy" > "OFF" > "Apply"
   Then The "Copy" option should be hidden in explorer and "Save as" option is hidden in file menu
   And Perform third login actions
     
# ---------------------------------------------------------- Internal account --------------------------------------------------------------

#TC 28 - TC 33
@CollabarationSharing
Scenario: TC_Share_28:Users - Search for user name/email ID you want to invite.
   And Login back to internal user with user "nmaduru" and password "Selenium@123$" 
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on "External users/accounts/companies" dropdown in share popup
   Then The searched user "cvision-suresh" is fetching proper results and given "can view" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "view" permission in next user login
   And Login back to internal user with user "nmaduru" and password "Selenium@123$" 
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_34:Accounts - Verify sharing insight with can edit permission
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on "External users/accounts/companies" dropdown in share popup
   Then The searched user "cvision-suresh" is fetching proper results and given "can edit" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "edit" permission in next user login
   And Login back to internal user with user "nmaduru" and password "Selenium@123$"
   And Delete Insight
   
#TC_35 to TC_40
@CollabarationSharing
Scenario: TC_Share_35:Accounts - Verify sharing insight with can view permission for company
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on "External users/accounts/companies" dropdown in share popup	
   Then The searched user "CEIC Development – CDMNext 2" is fetching proper results and given "can view" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "view" permission in next user login
   And Login back to internal user with user "nmaduru" and password "Selenium@123$"  
   And Delete Insight
   
@CollabarationSharing
Scenario: TC_Share_41: Accounts - Verify sharing insight with can edit permission for company
   And Click "File" > "New" 
   And Create a fresh insight
   And Click on "Insight" icon to share insight
   And Click on "External users/accounts/companies" dropdown in share popup
   Then The searched user "CEIC Development – CDMNext 2" is fetching proper results and given "can edit" permission
   And Logout from current user
   And Login as ceic user
   And Click on my insights
   And Click "Shared" tab
   Then The newly created insight should appear as "edit" permission in next user login
   And Login back to internal user with user "nmaduru" and password "Selenium@123$" 
   And Delete Insight
   
@CollabarationSharing
Scenario Outline: TC_Share_41:Verify remove(x) icon.
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Click on <Invite> dropdown in share popup
   And The Invite specific user <user_name> is fetching proper results
   And Click on "Save" button to share
   Then The Verify the remove icon in shared insight
Examples:
   |            Invite                      |           user_name             |
   | "External users/accounts/companies"    | "ceicsuresh10@gmail.com"        |
   | "External users/accounts/companies"    | "cvision-suresh"                |
   | "External users/accounts/companies"    | "CEIC Development – CDMNext 2"  |
   
@CollabarationSharing
Scenario Outline: TC_Share_42:Verify selecting user/account/company with permission pre-set for view permission
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Click on <Invite> dropdown in share popup
   And The searched user <user_name> is fetching proper results for "can view" 
   And Click on "Save" button to share
   Then The same permission can prepopulate in insight share field
Examples:
   |            Invite                      |           user_name             |
   | "External users/accounts/companies"    | "ceicsuresh10@gmail.com"        |
   | "External users/accounts/companies"    | "cvision-suresh"                |
   | "External users/accounts/companies"    | "CEIC Development – CDMNext 2"  |
   
@CollabarationSharing
Scenario Outline: TC_Share_43:Verify selecting user/account/company with permission pre-set for edit permission
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Click on <Invite> dropdown in share popup
   And The searched user <user_name> is fetching proper results for "can edit" 
   And Click on "Save" button to share
   Then The same permission can prepopulate in insight share field
 Examples:
   |            Invite                      |           user_name             |
   | "External users/accounts/companies"    | "ceicsuresh10@gmail.com"        |
   | "External users/accounts/companies"    | "cvision-suresh"                |
   | "External users/accounts/companies"    | "CEIC Development – CDMNext 2"  |
   
@CollabarationSharing
Scenario: TC_Share_43:Verify selecting user with permission pre-set for manage permission
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   And Click on "External users/accounts/companies" dropdown in share popup
   And The searched user "ceicsuresh10@gmail.com" is fetching proper results for "can manage" 
   And Click on "Save" button to share
   Then The same permission can prepopulate in insight share field
   And Rename Insight to Download
   
@CollabarationSharing
Scenario: TC_Share_07: Verify 'Share' option for Guest users.
   And Login back to internal user with user "nmaduru" and password "Selenium@123$" 
   And Click Guest access
   And Click "File" > "New" 
   And Click "Create insight" to create a new insight
   And Click on "Insight" icon to share insight
   Then The "Register now!" popup should appears

# ------------------------------------------------- Growl message ----------------------------------------------------------------------------
   
@CollabarationSharing
Scenario: TC_Share_08: Verify 'Multiple insights' sharing.
   And Logout from current user
   And Login back to default execution login
   And Enter mail for "Multiple insights sharing" with action as "shared" an insight
   
@CollabarationSharing
Scenario: TC_Share_47: Verify notification for shared insight.
   And Enter mail for "Notification for shared insight" with action as "shared" an insight
   
@CollabarationSharing
Scenario: TC_Share_48: Verify growl message for shared insight.
   And Enter mail for "Growl message for shared insight" with action as "shared" an insight
   
@CollabarationSharing
Scenario: TC_Share_49: Verify clicking on insight title in growl message
   And Enter mail for "Clicking Insight title for shared insight" with action as "shared" an insight
   
@CollabarationSharing
Scenario: TC_Share_50: Verify closing of growl popup.
   And Enter mail for "Closing growl popup" with action as "shared" an insight
   
@CollabarationSharing
Scenario: TC_Share_54: Verify growl message for stoping shared insight.
   And Enter mail for "Growl popup for stopped sharing" with action as "stopped sharing" an insight
   
@CollabarationSharing
Scenario: TC_Share_55: Verify growl message for insight stopped sharing.
   And Enter mail for "Notification for stopped sharing" with action as "stopped sharing" an insight
   
#TC_Share_59 - TC_Share-61   
@CollabarationSharing
Scenario: TC_Share_59: Verify notification for changes in shared insight
   And Enter mail for "Notification for changes in shared insight" with action as "sharing" an insight
   
@CollabarationSharing
Scenario:Tc_Share_72: Verify Notifications when turn OFF notification under Profile dropdown
   And Enter mail for "Notification growl" with action as "Turn OFF notifications" the insight
   
@CollabarationSharing
Scenario:Tc_Share_73: Verify Notifications when turn ON notification under Profile dropdown
   And Enter mail for "Notification growl" with action as "Turn ON notifications" the insight
   And Login back to default execution login