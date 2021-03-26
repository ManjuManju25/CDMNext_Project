Feature: Verifying Insight general Functionality

  @InsightGeneral
  Scenario: Tc_InsightGeneral_01:Verify CEIC logo
    And Login as current execution login by taking username rowcount as 2 and cellcount as 0 and for password rowcount as 2 and cellcount as 1
    And Setting values in preference
    And Verify CEIC logo

  @InsightGeneral
  Scenario: Tc_InsightGeneral_02:Verify clicking on CEIC logo
    And Creating new insight
    Then Click on CEIC logo to verify
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_03:Verify insight title change
    And Click  insight title
    And Verify insight title change

  @InsightGeneral
  Scenario: Tc_InsightGeneral_04:Verify Clicking on my insights
    And My Insights should be loaded

  @InsightGeneral
  Scenario: Tc_InsightGeneral_05:Verify insight URL after changed insight title
    And Creating new insight
    And Change insight title and verify insight URL after changed insight title
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_06:Verify insight URL after changed insight title with existing insight title
    And Verify insight URL after changed insight title with existing insight title

  @InsightGeneral
  Scenario: Tc_InsightGeneral_07:Verify tooltip for insight title
    And Verify tooltip for insight title

  @InsightGeneral
  Scenario Outline: Tc_InsightGeneral_08_<TC_ID> :Verify 'File' menu(Cogwheel icon).
    And Click "Open File menu" option from the title
    And Check for the <cogwheel> options
    And Click "Open File menu" option from the title

    Examples: 
      | TC_ID | cogwheel          |
      | "01"  | "View"            |
      | "02"  | "New"             |
      | "03"  | "Open Recent"     |
      | "04"  | "Save"            |
      | "05"  | "Save as"         |
      | "06"  | "Delete"          |
      | "07"  | "Download"        |
      | "08"  | "Settings"        |
      | "09"  | "Refresh"         |
      | "10"  | "Add to favorite" |
      | "11"  | "Share"           |

  @InsightGeneral
  Scenario Outline: Tc_InsightGeneral_09_<TC_ID> :Verify 'File' menu(Cogwheel icon).
    And Click "Open File menu" option from the title
    And Check for the <cogwheel> options <icon>
    And Click "Open File menu" option from the title

    Examples: 
      | TC_ID | cogwheel          | icon       |
      | "01"  | "View"            | "view"     |
      | "02"  | "New"             | "plus"     |
      | "03"  | "Open Recent"     | "open"     |
      | "04"  | "Save"            | "save"     |
      | "05"  | "Save as"         | "save_as"  |
      | "06"  | "Delete"          | "delete"   |
      | "07"  | "Download"        | "download" |
      | "08"  | "Settings"        | "settings" |
      | "09"  | "Refresh"         | "refresh"  |
      | "10"  | "Add to favorite" | "favorite" |
      | "11"  | "Share"           | "share"    |

  @InsightGeneral
  Scenario: Tc_InsightGeneral_10:Verify View option
    And Creating new insight
    And Click on File menu
    And Click on View option and Verify
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_11:Verify insight in preview mode.
    And Creating new insight
    And Create Visual
    And Click on File menu
    And Click "View" option from the title
    And Insight should not be editable
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_12:Verify preview modal window after click on Open
    And Creating new insight
    And Click on File menu
    And Click "View" option from the title
    And Insight popup should close on clicking Open icon
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_13:Verify 'Copy' option in insight preview.
    And Creating new insight
    And Click on File menu
    And Click "View" option from the title
    And Click on Copy button
    And Verify 'Copy' option in insight preview.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_14:Verify default insight title while coping insight.
    And Creating new insight
    And Click on File menu
    And Click "View" option from the title
    And Click on Copy button
    And Verify default insight title while coping insight.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_15:Insight title update in 'Copy the insight' popup.
    And Creating new insight
    And Click "Open File menu" option from the title
    And Click "View" option from the title
    And Verify the insight saved with updated title.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_16:Verify 'Copy insight' button.
    And Creating new insight
    And Click "Open File menu" option from the title
    And Click "View" option from the title
    And Verify the insight by clicking "Copy Insight" button
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_17:Verify 'Cancel' button.
    And Creating new insight
    And Click "Open File menu" option from the title
    And Click "View" option from the title
    And Verify the insight by clicking "Cancel" button
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_18:Verify 'Download' option in insight preview without visual
    And Creating new insight
    And Click "Open File menu" option from the title
    And Click "View" option from the title
    And Verify 'Download' option in insight preview without visual
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_19:Verify 'Download' option in insight preview with visual
    And Creating new insight
    And Create Visual
    And Click on View
    And Click on Download
    And Verify 'Download' option in insight preview with visual
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_20:Verify 'Maximize' option in insight preview
    And Creating new insight
    And Click on View
    And Click on Maximize button
    And Verify 'Maximize' option in insight preview
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_21:Verify 'Restore down' option in insight preview.
    And Creating new insight
    And Click on View
    And Click on Maximize button
    And Verify 'Restore down' option in insight preview.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_22:Verify Close option for insight preview popup.
    And Creating new insight
    And Click on View
    And Verify Cancel option for insight preview popup.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_23:Verify "Related Insights" in insight preview.
    And Creating new insight
    And Search for related insight series
    And Click on View
    And Verify Related Insights in insight preview.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_24:Verify New option.
    And Click on File menu
    And Click on New
    And Verify New option.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_25:Verify auto title for Create insight..
    And Click on File menu
    And Click on New
    And Verify auto title for Create insight.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_26:Verify 'Create insight' button.
    And Click on File menu
    And Click on New
    And Verify 'Create insight' button.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_27:Verify 'Cancel' button for new insight popup.
    And Click on File menu
    And Click on New
    And Verify 'Cancel' button for new insight popup.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_28:Verify 'Open recent' sub dropdown
    And Click on File menu
    And Click "Open Recent" option from the title
    And List of recent opened insights should be displayed

  @InsightGeneral
  Scenario: Tc_InsightGeneral_29:Verify number of insights limit for recent dropdown
    And Click on File menu
    And Click "Open Recent" option from the title
    And List of 10 recent opened insights should be displayed

  @InsightGeneral
  Scenario: Tc_InsightGeneral_30:Try to open recent insight
    And Click on File menu
    And Click "Open Recent" option from the title
    And List of 1 recent opened insights should be displayed

  @InsightGeneral
  Scenario: Tc_InsightGeneral_31:Verify 'Save' option.
    And Click on File menu
    And Click "Save" option from the title
    And Save changes is shown

  @InsightGeneral
  Scenario: Tc_InsightGeneral_32:Verify 'Save As' option.
    And Click on File menu
    And Click "Save as" option from the title
    And Save as changes is shown

  @InsightGeneral
  Scenario: Tc_InsightGeneral_33: Verify default insight title while coping insight.
    And Creating new insight
    And Click on File menu
    And Click "Save as" option from the title
    And Verify default insight title while coping insight.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_34: Insight title update in 'Copy the insight' popup.
    And Creating new insight
    And Click on File menu
    And Click "Save as" option from the title
    And Verify Insight title update in Copy the insight popup
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_35: Verify default insight title while coping insight.
    And Creating new insight
    And Click on File menu
    And Click "Save as" option from the title
    And Verify Copy insight button
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_36:Verify 'Cancel' button for 'Copy the insight' popup.
    And Creating new insight
    And Click on File menu
    And Click on View option
    And Click on Copy button
    And Verify 'Cancel' button for 'Copy the insight' popup.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_37:Verify Delete option.
    And Click on File menu
    And Click on Delete
    And Verify Delete option.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_38:Verify Popup header for delete.
    And Click on File menu
    And Click on Delete
    And Verify Popup header for delete.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_39:Verify description for delete confirmation popup.
    And Click on File menu
    And Click on Delete
    And Verify description for delete confirmation popup.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_40:Verify 'Our help desk team'.
    And Click on File menu
    And Click on Delete
    And The Email template should be opened with auto filled email ID "helpdesk@ceicdata.com"

  @InsightGeneral
  Scenario: Tc_InsightGeneral_41:Verify Delete forever button.
    And Verify Delete forever button.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_42:Verify CDMNext after current opened insight deleted.
    And The default landing page should be loaded as set in the preference

  @InsightGeneral
  Scenario: Tc_InsightGeneral_43:Verify Download option for new insight.
    And Creating new insight
    And Click on File menu
    And Verify Download option for new insight.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_44:Verify download option when series selected in search panel.
    And Creating new insight
    And Create Visual
    And Click on File menu
    And Verify download option when series selected in search panel.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_45:Verify Settings option.
    And Click on File menu
    And Click on Settings
    And Verify Settings option.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_46:Verify the available tabs in the settings popup.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Verify the available tabs in the settings popup.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_47:Verify Name field in General tab.
    And Creating new insight
    And Click on Settings and Verify the available tabs in the settings popup
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_48:Verify changing of insight name in General tab.
    And Update the name under Settings and Verify

  @InsightGeneral
  Scenario: Tc_InsightGeneral_49:Verify insight URL after insight title change.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Verify insight URL after insight title change.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_50:Verify edit icon for insight URL.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And The Edit icon should be displayed and URL should be selected when click on it
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_51:Verify the alert message while changing insight URL.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Verify insight URL after insight title change.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_52:Change Insight URL with new title.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And The URL should be changed as per updated
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_53:Change insight URL with existing insight name.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Verify Change insight URL with existing insight name
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_54:Verify 'Copy' permanent link' option.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And The original link of insight should be copied
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_55:Validate the copied link.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Validate the copied link.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_83:Verify Description field for General tab
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Should able to add insight descripiton
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_84:Verify added description under insight explorer
    And Click "File" > "New"
    And Create a fresh insight
    And Click on File menu
    And Click on Settings
    And The descripton should be visible to user
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_85:Verify Save and Apply buttons when settings opened
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And By default the Save and Apply buttons should be disabled and enable after any changes made
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_86:Verify Save button when settings opened
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And The "Save" button is clicked and popup size is 0
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_87:Verify Apply button when settings opened
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And The "Apply" button is clicked and popup size is 1
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_88:Verify confirmation message after click on Apply.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    Then The "Changes are saved" message should popup
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_89:Verify Apply and Save buttons when redirect to next tabs with changes.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    Then The Apply and Save buttons remains enabled
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_90:Verify Cancel/X buttons.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    Then The "Cancel" message should popup
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_91:Verify Created field under Information tab.
    And Verify Created field under Information tab.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_92:Verify Last editor field.
    And Verify Last editor field.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_93:Verify sharing settings field.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Check sharing settings field.
    And Share insight and Check the sharing settings field
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_94:Verify 'Change' option for sharing settings.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Verify 'Change' option for sharing settings.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_95:Verify number of the view/s for the insight.
    And Add Views
    And Verify number of the view/s for the insight.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_96:Verify Data series.
    And Add series to myseries
    And Verify Data series under info tab in settings

  @InsightGeneral
  Scenario: Tc_InsightGeneral_97:Verify Permission tabs description.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Permissions tab
    And Verify Permission tabs description.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_98:Verify default selection for permission tab.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Permissions tab
    And Verify default selection for permission tab.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_99:Verify ON for all the options.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Permissions tab
    And Verify "ON" for all options
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_100:Verify OFF for all the options.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Permissions tab
    And Verify "OFF" for all options
    And Delete Insight

  #----------------------------------------------------------Internal login --------------------------------------------------------
  @InsightGeneral
  Scenario: Tc_InsightGeneral_101:Verify Subscription tabs description.
    And Login back to internal user with user "nmaduru" and password "Selenium@123$"
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify Subscription tabs description.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_102:Verify Select service code field.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify Select service code field.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_103:Verify search for service code.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify search for service code.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_104:Verify message for invalid search.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify message for invalid search.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_105:Verify remove icon for service code field.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify remove icon for service code field.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_106:Verify service code selection.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify service code selection.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_107:Verify remove icon for selected service code.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify remove icon for selected service code.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_108:Verify product code field.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify product code field.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_109:Verify default selection for product code field.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify default selection for product code field.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_110:Verify product code field.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify product code field.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_111:Verify remove icon for selected product codes.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Subscription tab
    And Verify remove icon for selected product codes.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_112:Verify keywords for the insights.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Keywords tab
    Then The Keywords tab is active
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_113:Verify keywords for the insights.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Keywords tab
    And Verify keywords for the insights.
    And Delete Insight

  @InsightGeneral12345
  Scenario: Tc_InsightGeneral_114:Verify the insight for added keywords in insight explorer.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Keywords tab
    And Add Keywords
    And Verify the insight for added keywords in insight explorer.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_115:Verify adding multiple keywords.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Keywords tab
    And Add Multiple Keywords and Verify
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_116:Verify remove icon for keywords.
    And Creating new insight
    And Click on File menu
    And Click on Settings
    And Click on Keywords tab
    And Remove keywords and Verify
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_117:Verify Refresh option.
    And Creating new insight
    And Click on Add views
    And Click on File menu
    And Click on Refresh
    And Verify Refresh option.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_118:Verify 'Favorite' icon.
    And Creating new insight
    And Click on File menu
    And Verify "Add" to favorite option
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_119:Verify remove from favorites option
    And Creating new insight
    And Click on File menu
    And Verify "Remove" to favorite option
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_120:Verify tag icon
    And Creating new insight
    And Click on File menu
    And Click on tag icon
    And Verify tag popup is displayed
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_121:Verify tags field
    And Creating new insight
    And Click on File menu
    And Click on tag icon and enter the tags
    And Verify tag in insight explorer
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_122:Verify Cancel/Dismiss(X) options for tag popup.
    And Creating new insight
    And Click on File menu
    And Click on tag icon
    And Verify Cancel option in tag popup
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_123:Verify Share icon.
    And Creating new insight
    And Click on File menu
    And Click on Share icon
    And Verify share popup is shown
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_124:Verify Share for untitled insight.
    And Click on Share icon for untitled insight
    And Verify Share for untitled insight.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_125:Verify edit of insight title in the popup.
    And Verify that the insight saved with updated title.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_126:Verify edit icon for insight URL.
    And Click on Share icon for untitled insight
    And Click on Edit icon on insight URL field and Verify

  @InsightGeneral
  Scenario: Tc_InsightGeneral_127:Verify the alert message while click on edit icon for insight URL change.
    And Click on Share icon for untitled insight
    And Verify the alert message while click on edit icon for insight URL change

  @InsightGeneral
  Scenario: Tc_InsightGeneral_128:Change Insight URL with new keyword.
    And Click on Share icon for untitled insight
    And Verify insight url updated after insight title changed

  @InsightGeneral12345
  Scenario: Tc_InsightGeneral_129:Verify 'Copy' permanent link' option.
    And Click on File menu
    And Click on Share icon
    And The original link of insight should be copied

  @InsightGeneral
  Scenario: Tc_InsightGeneral_130:Validate the copied link.
    And Click on File menu
    And Click on Share icon
    And Validate the copied link.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_131:Verify the tooltip for Copy permanent link.
    And Click on Share icon for untitled insight
    And Verify the tooltip for Copy permanent link.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_132:Verify disabled save button.
    And Click on Share icon for untitled insight
    And Verify disabled save button.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_133:Verify Cancel/Dismiss(X) options for 'Name Insight' popup
    And Click on Share icon for untitled insight
    And The popup should close

  @InsightGeneral
  Scenario: Tc_InsightGeneral_134:Verify share after renamed.
    And Navigate to "File" -> "Share"
    Then The "Share" window should present

  @InsightGeneral
  Scenario: Tc_InsightGeneral_135:Verify Protect option.
    And Creating new insight
    And Click on File menu
    And Click on Protect
    And Verify Protect option.
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_136:Verify Protect option for untitled insight.
    And Click on File menu
    And Verify protect option is not present for Untitled insight

  @InsightGeneral
  Scenario: InsightGeneral: Login back to default login.
    And Login back to default execution login

  @InsightGeneral
  Scenario Outline: Tc_InsightGeneral_137:Verify Protect option for untitled insight.
    And Click on Notifications icon
    And Get text of <datatab> available for <notifications>

    Examples: 
      | datatab           | notifications     |
      | "ceic_insiders"   | "What's new"      |
      | "recommendations" | "Recommendations" |
      | "notifications"   | "Notifications"   |

  @InsightGeneral
  Scenario: Tc_InsightGeneral_138:Verify Latest insights from our experts under what's new
    And Click "Notifications" -> "What's new"
    Then The latest 10 insights should be displayed

  @InsightGeneral
  Scenario: Tc_InsightGeneral_139:Verify announcments
    And Click "Notifications" -> "What's new"
    Then The announcement popup should be displayed

  @InsightGeneral
  Scenario: Tc_InsightGeneral_149:Verify Recent insights under Recommendations tab
    Then The "Recent Insights" should open in preview mode with limit 5

  @InsightGeneral
  Scenario: Tc_InsightGeneral_151:Verify Latest insights from our experts under Recommendations tab
    Then The "Latest insights from our experts" should open in preview mode with limit 10

  @InsightGeneral
  Scenario: Tc_InsightGeneral_154:Verify Most popular CEIC insights.
    Then The "Most popular CEIC Insights" should open in preview mode with limit 10

  @InsightGeneral
  Scenario: Tc_InsightGeneral_156:Verify Latest EMIS Insights.
    Then The "Latest EMIS Insights" should open in preview mode with limit 10

  @InsightGeneral
  Scenario Outline: Tc_InsightGeneral_164:Verify Help menu(CDMNext, CEIC's Data Manager)
    And Creating new insight
    And Click on Help dropdown
    Then Verify the option for <label> with <text>
    And Click on Help dropdown
    And Delete Insight

    Examples: 
      | label           | text                  |
      | "About CDMNext" | "Video tutorials"     |
      | "About CDMNext" | "Online tours"        |
      | "About CDMNext" | "Start guide"         |
      | "About CDMNext" | "Search help"         |
      | "About CDMNext" | "CEIC mnemonic codes" |
      | "About CDMNext" | "Keyboard shortcuts"  |
      | "Learning"      | "Footnotes"           |
      | "Learning"      | "Knowledge base"      |
      | "CEIC Help"     | "Contact Us"          |
      | "CEIC Help"     | "Email us"            |
      | "CEIC Help"     | "Diagnostics"         |
      | "CEIC Help"     | "Report a problem"    |
      | "Applications"  | "Excel Add-in"        |
      | "Applications"  | "WPS Add-in"          |
      | "Applications"  | "API"                 |
      | "Applications"  | "R"                   |
      | "Applications"  | "PyCEIC"              |
      | "Applications"  | "EViews"              |

  @InsightGeneral
  Scenario Outline: Tc_InsightGeneral_164:Verify Help menu(CDMNext, CEIC's Data Manager)
    And Creating new insight
    And Click on Help dropdown
    Then Verify the option for the <chat> with <option>
    And Click on Help dropdown
    And Delete Insight

    Examples: 
      | chat        | option |
      | "Live chat" | "ON"   |
      | "Live chat" | "OFF"  |

  @InsightGeneral
  Scenario: Tc_InsightGeneral_165:Verify 'Video tutorials'
    And Click on "Help" -> "Video tutorials"
    Then The available videos should be played

  @InsightGeneral
  Scenario: Tc_InsightGeneral_166:Video turorials - verify 'Quick start Guide'
    And Click on "Help" -> "Video tutorials"
    Then The "Quick Start Guide" should open in new tab

  @InsightGeneral
  Scenario: Tc_InsightGeneral_167:Video turorials - verify window dismiss button.
    And Click on "Help" -> "Video tutorials"
    Then The popup window should be closed

  @InsightGeneral
  Scenario: Tc_InsightGeneral_168:Verify tours
    And Creating new insight
    And Click on "Help" -> "Online tours"
    Then The tour should be started
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_176:Tour - Verify window 'dismiss(x)' option.
    And Creating new insight
    And Click on "Help" -> "Online tours"
    Then The tour should be closed
    And Delete Insight

  @InsightGeneral
  Scenario: Tc_InsightGeneral_177:Verify 'Quick start guide'
    And Click on "Help" -> "Start guide"
    Then The Start guide is opening in new tab

  @InsightGeneral
  Scenario: Tc_InsightGeneral_178:Verify 'search help'
    And Click on "Help" -> "Search help"
    Then The keyword search tips window should open

  @InsightGeneral
  Scenario: Tc_InsightGeneral_180:Verify 'Keyboard shortcuts'
    And Click on "Help" -> "Keyboard shortcuts"
    Then The keyboard shortcuts window should open

  @InsightGeneral
  Scenario: Tc_InsightGeneral_181:Verify Open footnotes
    And Click on "Help" -> "Footnotes"
    Then The Footnotes window should open

  @InsightGeneral
  Scenario: Tc_InsightGeneral_182:Live chat ON
    And Click on "Help" -> "Live chat"
    Then The Live chat is "ON"
    And Click on Help

  @InsightGeneral
  Scenario: Tc_InsightGeneral_183:Live chat OFF
    And Click on "Help" -> "Live chat"
    Then The Live chat is "OFF"
    And Click on Help

  @InsightGeneral
  Scenario: Tc_InsightGeneral_184:Verify 'Contact Us'
    And Click on Help
    And Click on contact us
    And Verify redirection to contact page

  @InsightGeneral
  Scenario: Tc_InsightGeneral_185:Verify 'Email Us'
    And Click on Help
    And Click on Email us
    And Verify Email us pop up is shown

  @InsightGeneral
  Scenario: Tc_InsightGeneral_186:Verify 'Email Us' for mandatory fields
    And Click on Help
    And Click on Email us
    And Verify red color for mandatory fields

  @InsightGeneral
  Scenario: Tc_InsightGeneral_187:Verify email Subject
    And Click on "Help" -> "Email us"
    Then The "Subject" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_188:Email Us - verify CC recipients.
    And Click on "Help" -> "Email us"
    Then The "Invalid mail in CC" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_190:Email Us - verify multipe email IDs for CC field.
    And Click on "Help" -> "Email us"
    Then The "Multiple mails in CC" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_191:Email Us - verify CC recipients without entering email ID.
    And Click on "Help" -> "Email us"
    Then The "No CC" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_192:Email Us - verify 'Message' field.
    And Click on "Help" -> "Email us"
    Then The "Message" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_193:Email Us - verify 'growl message' send button.
    And Click on "Help" -> "Email us"
    Then The "Your message was sent successfully" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_196:Email Us - verify 'growl message' auto close.
    And Click on "Help" -> "Email us"
    Then The "Growl autoclose" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_197:Email Us - verify attachment upload.
    And Click on "Help" -> "Email us"
    Then The "Attachment upload" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_199:Email Us - verify attachment remove.
    And Click on "Help" -> "Email us"
    Then The "Attachment remove" field is adding the text

  @InsightGeneral
  Scenario: Tc_InsightGeneral_200:Verify 'Cancel/Dismiss' button in Email popup.
    And Click on Help
    And Click on Email us
    And Verify 'Cancel/Dismiss' button in Email popup.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_202:Verify 'Knowledge base'
    And Click on Help
    And Click on Knowledge base
    And Verify 'Knowledge base'

  @InsightGeneral
  Scenario: Tc_InsightGeneral_203:Verify 'Diagnostics'.
    And Click on Help
    And Click on Diagnostics
    And Verify 'Diagnostics'.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_204:Verify Diagnostics configurations options.
    And Click on Help
    And Click on Diagnostics
    And Verify Diagnostics configurations options.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_205: Verify 'Report a problem' in Diagnostics page.
    And Click on Help
    And Click on Diagnostics
    And Verify 'Report a problem' in Diagnostics page.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_207:Verify 'Send' button on Report a problem window.
    And Click on Help
    And Click on Diagnostics
    And verify 'Send' button on Report a problem window.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_208:Verify 'Attachments' on Report a problem
    And Click on Help
    And Click on Diagnostics
    And Verify 'Attachments' on Report a problem

  @InsightGeneral
  Scenario: Tc_InsightGeneral_209: Verify 'Cancel and dismiss' buttons on the window.
    And Click on Help
    And Click on Diagnostics
    And Verify 'Cancel and dismiss' buttons on the window.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_210: Verify 'Report a problem' under Help menu.
    And Click on Help
    And Click on Report button
    And Verify 'Report a problem' under Help menu.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_211: Verify description and attach screenshot for 'Report a problem' under Help menu.
    And Click on Help
    And Click on Report button
    And Verify description and attach screenshot

  @InsightGeneral
  Scenario: Tc_InsightGeneral_213: Verify Send the Report with attachment
    And Click on Help
    And Click on Report button
    And Enter the description
    And Add the attachment
    And Verify Send Report

  @InsightGeneral
  Scenario: Tc_InsightGeneral_214: Verify Cancel/x buttons for report a problem under HElp dropdown.
    And Click on Help
    And Click on Report button
    And Verify Cancel/x buttons for report a problem under HElp dropdown.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_215:Verify Excel add-in
    And Click on Help
    And Click on Application Excel Add-in
    And Verify Excel Add-in tab is open

  @InsightGeneral
  Scenario: Tc_InsightGeneral_216:Verify Excel add-in version on popup.
    And Click on Help
    And Click on Application Excel Add-in
    And Verify Excel add-in version in popup

  @InsightGeneral
  Scenario: Tc_InsightGeneral_217:Verify 'OS and MS Office' selection on popup.
    And Click on Help
    And Click on Application Excel Add-in
    And Verify 'OS and MS Office' selection on popup.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_218:Verify 'Download' CDMNext add-in.
    And Click on Help
    And Click on Application Excel Add-in
    And Verify 'Download' CDMNext add-in navigate to new tab

  @InsightGeneral
  Scenario: Tc_InsightGeneral_219:Verify available 'Documents' in add-in popup.
    And Click on Help
    And Click on Application Excel Add-in
    And Click on Document link
    And Verify available 'Documents' in add-in popup

  @InsightGeneral
  Scenario: Tc_InsightGeneral_220:Verify 'Open' the popup with new tab.
    And Click on Help
    And Click on Application Excel Add-in
    And Verify 'Open' the popup with new tab

  @InsightGeneral
  Scenario: Tc_InsightGeneral_221:Verify Popup dismiss(x) option.
    And Click on Help
    And Click on Application Excel Add-in
    And Verify Popup dismiss option

  @InsightGeneral
  Scenario: Tc_InsightGeneral_222:Verify the 'next tabs' in the popup.
    And Click on Help
    And Click on Application Excel Add-in
    And Click on API tab and Verify
    And Click on R tab and Verify
    And Click on Eviews tab and Verify

  @InsightGeneral
  Scenario: Tc_InsightGeneral_223:Verify the WPS addin
    And Click on "Help" -> "WPS Add-in"
    And Verify the WPS addin

  @InsightGeneral
  Scenario: Tc_InsightGeneral_227:Verify API.
    And Click on Help
    And Click on API and Verify

  @InsightGeneral
  Scenario: Tc_InsightGeneral_228:Verify 'API SDK' download.
    And Click on Help
    And Click on API
    And Click on Python SDK and Verify 'API SDK' download

  @InsightGeneral
  Scenario: Tc_InsightGeneral_229:Verify 'API SDK' download through URL.
    And Click on Help
    And Click on API
    And Verify 'API SDK' download through URL

  @InsightGeneral
  Scenario: Tc_InsightGeneral_230:Verify available 'Documents' in API popup.
    And Click on Help
    And Click on API
    And Verify documents opening in new tab

  @InsightGeneral
  Scenario: Tc_InsightGeneral_231:Verify 'R'.
    And Click on Help
    And Click on R
    And Verify R tab is open

  @InsightGeneral
  Scenario: Tc_InsightGeneral_232:Verify 'R' package download.
    And Click on Help
    And Click on R
    And Verify 'R' package download

  @InsightGeneral
  Scenario: Tc_InsightGeneral_234:Verify available 'Documents' in R popup.
    And Click on Help
    And Click on R
    And Click on Document links and Verify

  @InsightGeneral
  Scenario: Tc_InsightGeneral_235:Verify 'EViews'
    And Click on Help
    And Click on Eviews
    And Verify 'EViews'

  @InsightGeneral
  Scenario: Tc_InsightGeneral_236:Verify Eviews download (x86 and x64 bit)
    And Click on Help
    And Click on Eviews
    And Click on Download CEIC EViews Module 32-Bit and Verify
    And Click on Download CEIC EViews Module 64-Bit

  @InsightGeneral
  Scenario: Tc_InsightGeneral_237:Verify available 'Documents' in EViews popup.
    And Click on Help
    And Click on Eviews
    And Click on  Eviews Document links and Verify

  @InsightGeneral
  Scenario: Tc_InsightGeneral_238:Verify Undo option enable.
    And Add few series to myseries
    And Verify Undo option enable.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_239:Verify Redo option enable.
    And Add few series to myseries
    And Add few series to myseries
    And Click on Undo icon
    And Verify Redo option enable

  @InsightGeneral
  Scenario: Tc_InsightGeneral_240:Verify Undo option behavior for My series tab.
    And Add few series to myseries
    And Click on Undo icon
    And Verify Undo option behavior for My series tab.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_241:Verify Redo option behavior for my series tab.
    And Add few series to myseries
    And Capture the myseries name
    And Click on Undo icon
    And Click on Redo icon
    And Verify Redo option behavior for my series tab.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_242:Verify Undo and Redo option for views tab.
    And Add a Visual
    And Click on Undo icon
    And Verify Undo option for views tab.
    And Click on Redo icon
    And Verify Redo option for views tab.

  @InsightGeneral
  Scenario: Tc_InsightGeneral_247:Verify Undo and redo option after refresh
    And Add few series to myseries
    And Click on Undo icon
    And Click on Redo icon
    And Verify refresh behavior
    And Login back to default execution login
