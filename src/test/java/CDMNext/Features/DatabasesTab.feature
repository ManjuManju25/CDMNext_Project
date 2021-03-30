Feature: Verifying Databases tab functionality

  @DB
  Scenario: TC_DB_01: Verify multiple databases selection
    Given Click on More filter
    And Select database as "China Premium Database,Brazil Premium Database,Russia Premium Database"
    And User has clicked on "Apply filter"
    Then User can see the results for multiple database selection

  @DB
  Scenario: TC_DB_02: Verifying Database selection
    Given Click on More filter
    And Select database as "India Premium Database"
    And User has clicked on "Apply filter"
    Then Result should be loaded only for selected database

  @DB
  Scenario: TC_DB_03: Verifying Expand --> DB > Topic > Section > Table
    And Select database as Daily Database
    And Expand till series level
    Then Should able to expand all the DB/Topic/section/table under Databases tab

  @DB
  Scenario: TC_DB_04: Verifying Collapse option
    And Select Global database
    And Expand till series level
    And Click on Collapse all option
    Then Opened data tree should be collapsed

  @DB
  Scenario: TC_DB_05: Verifying unselect option
    And Select any number of series
    And Click on "Unselect"
    Then Selected series should be unselected

  @DB
  Scenario: TC_DB_06: Verifying mouse hover options for DB level
    Given Hover the mouse on any Database
    Then Footnotes icon should be displayed
    When Click on footnote's icon
    Then Footnotes should be opened for related "DB"

  @DB
  Scenario: TC_DB_07: Verifying Copy link(s) for DB level
    Given Right click on any Database
    And Click on "Copy as URL"
    When Paste it in new tab
    Then The selected "DB" should be highlighted

  @DB
  Scenario: TC_DB_08: Verifying 'Footnotes' for DB level
    Given Right click on any Database
    And "Footnotes" option should be available
    When click on it
    Then Footnotes should be opened for related "DB"

  @DB
  Scenario: TC_DB_09: Verifying remove icon for database
    Given Click on More filter
    And Select database as "World Trend Plus"
    And User has clicked on "Apply filter"
    And Click on x icon to remove DB
    Then Selected database shold be removed
#
  #@DB
  #Scenario: TC_DB_10: Verify closing of insight explorer window
    #Given Click on "All insights" option
    #When Click on Close
    #Then The Insight Explorer popup should be closed

  @DB
  Scenario: TC_DB_10: Verifying message if no results found for the search
    Given User enters "UN"
    Then "Sorry, no results were found here." message should be displayed

  @DB
  Scenario: TC_DB_11: Verifying Collapse option when search/filter applied
    Given User enters keyword "Banglore"
    And Click on "Collapse all"
    Then The data tree should be collapsed

  @DB
  Scenario: TC_DB_12: Verifying 'See our search help'
    Given User enters "X"
    And Click on "See our Search help"
    Then The "Keyword search tips" popup should be opened

  @DB
  Scenario: TC_DB_13: Verifying Expand option when search/filter applied
    Given User enters keyword "Banglore"
    And Click on "Expand all"
    Then The data tree should be expanded

  @DB
  Scenario: TC_DB_14: Verifying 'our help desk team'
    Given User enters "UN"
    And Click on "our help desk team"
    Then User should redirect to "https://support.ceicdata.com/support/tickets/new"

  @DB
  Scenario: TC_DB_15: Verifying Filters for DB tab
    And User selects "All Regions" as "Japan"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then Result should be displayed as per the filters applied

  @DB
  Scenario: TC_DB_16: Verifying remove icon for filters.
    And User selects "Frequency" as "Monthly"
    And User has clicked on "Apply filter"
    When Click on x icon
    Then The applied filters should be removed

  @DB
  Scenario: TC_DB_17: Verifying behavior after search removed
    Given User enters "money"
    And After loaded the results ,click on Remove for search keyword
    Then The result should be loaded without search

  @DB
  Scenario: TC_DB_18: Verifying right click options for Databases level
    Given Right click on any database
    Then "Set language,Copy selected links,Footnotes,Copy as URL,Copy as R code,Copy as PyCEIC code,Copy as API call,Explore in API Portal" options should be available

  @DB
  Scenario Outline: <TCID>: Verifying DB language change in right click
    And Right click on "<database>"
    And "Set language" as "<language>"
    Then The Databases language should be changed to selected language

    Examples: 
      | TCID     | database                   | language |
      | TC_DB_19 | World Trend Plus           | 中文       |
      | TC_DB_20 | Russia Premium Database    | Русский  |
      | TC_DB_21 | Indonesia Premium Database | Bahasa   |

  @DB
  Scenario: TC_DB_22: Verifying DB language change for right click when the database is expaned
    And Select Global database
    And Expand till series level
    And Right click on "Global Database"
    And "Set language" as "中文"
    Then The Databases language should be changed to selected language

  @DB
  Scenario: TC_DB_23: Verifying mouse hover options for Topic level
    And Mouse hover on any topic level of data
    Then "Copy link(s)" should be available
    And Click on "Copy as URL"
    When Paste it in new tab
    Then The selected "topic" should be highlighted

  @DB
  Scenario: TC_DB_24: Verifying mouse hover options for Topic level
    And Mouse hover on any topic level of data
    Then "Footnotes" should be available
    When click on it
    Then Footnotes should be opened for related "topic"

  @DB
  Scenario: TC_DB_25: Verify right click options for Topic level
    And Right click on any topic level of data
    Then "Copy selected links,Footnotes,Copy as URL,Copy as R code,Copy as PyCEIC code,Copy as API call,Explore in API Portal" options should be available

  @DB
  Scenario: TC_DB_26: Verifying Copy link(s) for Topic level
    And Right click on any topic level of data
    And Click on "Copy as URL"
    When Paste it in new tab
    Then The selected "topic" should be highlighted

  @DB
  Scenario: TC_DB_27: Verifying Footnotes for Topic level
    And Right click on any topic level of data
    And "Footnotes" option should be available
    When click on it
    Then Footnotes should be opened for related "topic"

  @DB
  Scenario: TC_DB_28: Verifying mouse hover options for Section level
    And Mouse hover on any Section level of data
    Then "Copy link(s)" should be available
    And Click on "Copy as URL"
    When Paste it in new tab
    Then The selected "section" should be highlighted

  @DB
  Scenario: TC_DB_29: Verifying mouse hover options for Section level
    And Mouse hover on any Section level of data
    Then "Footnotes" should be available
    When click on it
    Then Footnotes should be opened for related "section"

  @DB
  Scenario: TC_DB_30: Verify right click options for section level
    And Right click on any section level of data
    Then "Copy selected links,Footnotes,Copy as URL,Copy as R code,Copy as PyCEIC code,Copy as API call,Explore in API Portal" options should be available

  @DB
  Scenario: TC_DB_31: Verifying right click options for Section level
    And Right click on any section level of data
    And Click on "Copy as URL"
    When Paste it in new tab
    Then The selected "section" should be highlighted

  @DB
  Scenario: TC_DB_32: Verifying Footnotes for Section level
    And Right click on any section level of data
    And "Footnotes" option should be available
    When click on it
    Then Footnotes should be opened for related "section"

  @DB
  Scenario: TC_DB_33: Verifying copy link(s) for table level
    And Mouse hover on any table level
    And "Copy link(s)" should be available
    And Click on "Copy as URL"
    Then The link should be copied

  @DB
  Scenario: TC_DB_34: Verifying confirmation message for Copy link
    And Mouse hover on any table level
    And "Copy link(s)" should be available
    And Click on "Copy as URL"
    Then "URL link copied." message should be displayed

  @DB
  Scenario: TC_DB_35:Validating copied link
    And Mouse hover on any table level
    And "Copy link(s)" should be available
    And Click on "Copy as URL"
    When Paste it in new tab
    Then The selected "table" should be highlighted

  @DB
  Scenario: TC_DB_36:Verifying Copy link for multiple tables selected
    And Select multiple tables
    And Click on "Copy link(s)"
    And Click on "Copy selected links"
    Then The links should be generated for selected tables

  @DB
  Scenario: TC_DB_37: Validating copied link for multiple tables selection.
    And Select multiple tables
    And Click on "Copy link(s)"
    And Click on "Copy selected links"
    Then Multiple table's link should be copied to clipboard and open respective "table" should be highlighted when run links one by one in browser

  @DB
  Scenario: TC_DB_38: Verifying Footnotes for table level
    And Mouse hover on any table level
    And "Footnotes" should be available
    When click on it
    Then Footnotes should be opened for related "table"

  @DB
  Scenario: TC_DB_39:Verifying + icon for table level
    And Mouse hover on any table level
    And "+" should be available
    When click on it
    Then The entire table should be added to my series

  @DB
  Scenario: TC_DB_40:Verifying Add dropdown for table level
    And Mouse hover on any table level
    And Click on dropdown next to + icon
    Then The dropdown should be opened with these items "Add,Add and replace,Add and group,Add to new insight,Add to recent insight"

  @DB
  Scenario: TC_DB_41:Verifying Add option under add dropdown for table level
    And Mouse hover on any table level
    And Select "Add" option
    Then The entire table should be added to my series

  @DB
  Scenario: TC_DB_42:Verifying Add and Replace for table level
    And Create a visual and Mouse hover on any table
    And Click on dropdown icon
    And Click on "Add and replace"
    Then The selected table data should be replaced with existing data on the visual

  @DB
  Scenario: TC_DB_43:Verifying Add and Group for table level
    And Mouse hover on any table level
    And Click on dropdown icon
    And Click on "Add and group"
    Then Selected table should be added as group in My series

  @DB
  Scenario: TC_DB_44:Verifying Add to new insight for table level
    And Mouse hover on any table level
    And Click on dropdown icon
    And Click on "Add to new insight"
    Then The new insight should be created with selected data

  @DB
  Scenario: TC_DB_45:Verifying confirmation message for adding table to new insight
    And Mouse hover on any table level
    And Click on dropdown icon
    And Click on "Add to new insight"
    Then Confirmation message should be displayed as below "New insight with the selected series created."

  @DB
  Scenario: TC_DB_46:Validating the added series by opening new insight
    And Mouse hover on any table level
    And Click on dropdown icon
    And Click on "Add to new insight"
    Then The insight should be opened and added series should be available in My series

  @DB
  Scenario: TC_DB_47:Verifying adding data to recent insight
    And Mouse hover on any table level
    And Click on dropdown icon
    And Click on "Add to recent insight"
    And Select any recent insight from the dropdown
    And Click on "Apply"
    Then The "Selected series added to insights:" popup should be appeared

  @DB
  Scenario: TC_DB_48:Validating the added table data by opening recent existing insight
    And Mouse hover on any table level
    And Click on dropdown icon
    And Click on "Add to recent insight"
    And Select any recent insight from the dropdown
    And Click on "Apply"
    Then The data should be added to My series for selected insight

  #
  #@DB
  #Scenario: TC_DB_48:Verifying 'add to existing' insight for table level
  #	And Mouse hover on any table level
  #	And  Click on dropdown icon
  #	And  Click on "Add to existing insight"
  #	Then The "Insight Explorer" popup should be appeared
  #
  #@DB
  #Scenario: TC_DB_49:Verifying 'Add to insights' button
  #	And Mouse hover on any table level
  #	And  Click on dropdown icon
  #	And  Click on "Add to existing insight"
  #	Then The "Add to insights" button should be disabled by default and enable after any insight selection
  #
  #@DB
  #Scenario: TC_DB_50:Verifying adding data to existing insight
  #	And Mouse hover on any table level
  #	And  Click on dropdown icon
  #	And  Click on "Add to existing insight"
  #	Then The "Selected series added to insights:" popup should be appeared
  #
  #@DB
  #Scenario: TC_DB_51:Validating the added table data by opening existing insight
  #	And Mouse hover on any table level
  #	And  Click on dropdown icon
  #	And  Click on "Add to existing insight"
  #	Then The data should be added to My series for selected insight
  #
  #@DB
  #Scenario: TC_DB_52:Verifying number of selected insights count
  #	And Mouse hover on any table level
  #	And  Click on dropdown icon
  #	And  Click on "Add to existing insight"
  #	And Select multiple insights
  #Then The number of selected insights count should be shown on popup header
  #
  ##@DB
  ##Scenario: TC_DB_53:Verifying Open option
  ##	And Mouse hover on any table level
  ##	And  Click on dropdown icon
  ##	And  Click on "Add to existing insight"
  ##	And Click on "Open"
  ##	Then "Insight Explorer" page should be opened in new tab
  ##
  ##@DB
  ##Scenario: TC_DB_54:Verifying Close/x for insight explorer modal window
  ##	And Mouse hover on any table level
  ##	And  Click on dropdown icon
  ##	And  Click on "Add to existing insight"
  ##	And Click on "×"
  ##	Then The insight explorer popup should be closed
  ##
  @DB
  Scenario: TC_DB_49:Verifying 'Unselect all' for table level
    And Right click on any table level
    And Select "Unselect all"
    Then The selected series should be unselected

  @DB
  Scenario: TC_DB_50:Verifying "View as Chart" for table level
    And Right click on any table level
    And Select "View as Chart"
    Then "Chart" should be created with series in views panel

  @DB
  Scenario: TC_DB_51:Verifying "View as Map" for table level
    And Right click on any table level
    And Select "View as Map" as "N America"
    Then "Map" should be created with series in views panel

  @DB
  Scenario: TC_DB_52:Verifying "View as Table" for table level
    And Right click on any table level
    And Select "View as Table"
    Then "Table" should be created with series in views panel

  @DB
  Scenario: TC_DB_53:Verifying "View as Pie" for table level
    And Right click on any table level
    And Select "Pie"
    Then "Pie" should be created with series in views panel

  @DB
  Scenario: TC_DB_54:Verifying "View as Heat map" for table level
    And Right click on any table level
    And Select "Heat map"
    Then "Heat map" should be created with series in views panel

  @DB
  Scenario: TC_DB_55:Verifying "Histogram" for table level
    And Right click on any table level
    And Select "Histogram"
    Then "Histogram" should be created with series in views panel

  @DB
  Scenario: TC_DB_56:Verify creating visual with more than max seires selection
    And Right click on any table level and select more than max series
    And Select "View as Chart"
    Then "Confirmation" window should be displayed

  @DB
  Scenario: TC_DB_57:Verify confirmation window for more than max series selection for visual creation
    And Right click on any table level and select more than max series
    And Select "View as Chart"
    Then Confirmation window should display with "You cannot create a chart with more than 20 series. Proceed with 20 series?"

  @DB
  Scenario: TC_DB_58:Verifying cancel/x button for confrimation popup
    And Right click on any table level and select more than max series
    And Select "View as Chart"
    And Click on "Cancel"

  @DB
  Scenario: TC_DB_59:Verifying Ok button for confrimation popup
    And Right click on any table level and select more than max series
    And Select "View as Chart"
    And Click on "Ok"
    Then "Chart" visual should be created with max series

  @DB
  Scenario: TC_DB_60:Verifying Download option for table level
    And Right click on any table level
    And Select "Download"
    Then Download window should be appeared with selected series count

  @DB
  Scenario: TC_DB_61:Verifying Copy link(s) for table level
    And Right click on any table level
    And Click on "Copy selected links"
    When Paste it in new tab
    Then The selected "table" should be highlighted

  @DB
  Scenario: TC_DB_62:Verifying Footnotes option for table level
    And Right click on any table level
    And Select "Footnotes"
    Then Footnotes should be opened for related "table"

  @DB
  Scenario: TC_DB_63:Verifying Show dataset for table level
    And Right click on any table level
    And Select "Show Dataset"
    Then All the series under the table should be shown

  @DB
  Scenario: TC_DB_64:Verifying 'NEW' icon for table level
    And Click on "More" filter
    And User selects "New only"
    And User has clicked on "Apply filter"
    And Select Global database
    And Expand till table level
    Then "NEW" icon should be displayed in table level

  @DB
  Scenario: TC_DB_65:Verifying adding table by keyboard shortcut
    And Select a table
    And Press A on keyboard
    Then The entire table should be added to my series

  @DB
  Scenario: TC_DB_66:Verifying adding table by drag and drop
    And Mouse hover on any table level
    And Drag and drop to my series/visual
    Then The entire table should be added to my series

  @DB
  Scenario: TC_DB_67:Verifying related data
    And Select database as Daily Database
    And Expand till series level
    And Click on "Show related data" icon
    Then Related data should be displayed under the dropdown

  @DB
  Scenario: TC_DB_68:Verify Related data > Remarks
    And Expand World Trend Plus till series level
    And Click on Show related data icon
    Then "Remarks:" should be displayed if available for the series

  @DB
  Scenario: TC_DB_69:Verify 'Read more' for Remarks under Related data
    And Expand World Trend Plus till series level
    And Click on Show related data icon
    And Click on "Read More"
    Then Should open related footnotes

  @DB
  Scenario: TC_DB_70:Verify clicking Datasets
    And Select database as Daily Database
    And Expand till series level
    And Click on Show related data icon
    And Click on datalinks under datasets
    Then Should redirect to respective datasets

  @DB
  Scenario: TC_DB_71:Verify related insights
    And Select database as Daily Database
    And Expand till series level
    And Click on Show related data icon
    And Click on any insights under insights section
    Then Insights should be opened in preview mode

  @DB
  Scenario: TC_DB_72:Verify share icon for insight
    And Select database as Daily Database
    And Expand till series level
    And Click on Show related data icon
    And Click on share under insights section
    Then Share popup should be opened if have permission to share

  @DB
  Scenario: TC_DB_73:Verify add to favorite icon
    And Select database as Daily Database
    And Expand till series level
    And Click on Show related data icon
    And Click on add to favourite under insights section
    Then The insights should be added to favorite list

  @DB
  Scenario: TC_DB_74:Verify hide related data
    And Select database as Daily Database
    And Expand till series level
    And Click on "Show related data"
    And Click on "Hide related data"
    Then The related data dropdown should be collapsed

  @DB
  Scenario: TC_DB_75: Verifying 'View as chart'
    And Mouse hover on any series level
    And Click on "View as Chart. Type `c`"
    Then Chart should be created with the series

  #
  #@DB
  #Scenario: TC_DB_83: Verify the series selection in Database after creating visual
  #	And Mouse hover on any series level
  #	And Click on "View as Chart. Type `c`"
  #	Then The series should be selected in search panel although visual created
  @DB
  Scenario: TC_DB_76:Verifying Footnote icon
    And Mouse hover on any series level
    And Click on Footnote icon
    Then Footnotes should be opened for related "series"

  @DB
  Scenario: TC_DB_77:More actions - Verify Unselect all
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Click on "Unselect all"
    Then The selected series should be unselected

  @DB
  Scenario: TC_DB_78:More actions - Verify "View as Chart" for series level
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "View as Chart"
    Then Visual should be created with "Edit Chart"

  @DB
  Scenario: TC_DB_79:More actions - Verify "View as Map" for series level
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "View as Map" as "World"
    Then Visual should be created with "Edit Map"

  @DB
  Scenario: TC_DB_80:More actions - Verify "View as Table" for series level
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "View as Table"
    Then Visual should be created with "Edit Table"

  @DB
  Scenario: TC_DB_81:More actions - Verify View as Pie for series level
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "Pie"
    Then Visual should be created with "Edit Pie"

  @DB
  Scenario: TC_DB_82:More actions - Verify View as Heat map for series level
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "Heat map"
    Then Visual should be created with "Edit Heat map"

  @DB
  Scenario: TC_DB_83:More actions - Verify View as Histogram for series level
    And Mouse hover on any series level
    And Click on More actions
    And Select "Histogram"
    Then Visual should be created with "Edit Histogram"

  @DB
  Scenario: TC_DB_84:More actions - Verify download option for series
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "Download"
    Then Download window should be appeared with selected series count

  @DB
  Scenario: TC_DB_85:More actions - Verify creating visual with more than max seires selection
    And Mouse hover on any series level and select more than max series
    And Select "View as Chart"
    Then Confirmation window should be displayed and proceed with max series if click on "Ok" button
    Then "Chart" visual should be created with max series

  @DB
  Scenario: TC_DB_86:More actions - Verify 'Copy' for series level
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "Copy"
    Then Selected series should be copied

  @DB
  Scenario: TC_DB_87:More actions - Verify pasting the copied series
    And Mouse hover on any series level
    And Click on More actions
    And Select "Copy"
    And Paste in application
    Then Copied series should be pasted

  @DB
  Scenario: TC_DB_88:More actions - Verify the confirmation message
    And Mouse hover on any series level
    And Click on More actions
    And Select "Copy"
    Then The message should be in growl popup as "Selected series copied."

  @DB
  Scenario: TC_DB_89:More actions - Verify copy data for series
    And Mouse hover on any series level
    And Click on More actions
    And Select "Copy data"
    Then The download popup should be opened

  @DB
  Scenario: TC_DB_90:More actions - Verify Copy links for a series
    And Mouse hover on any series level
    And Click on More actions
    And Select "Copy selected links"
    Then URL should be generated for selected series

  @DB
  Scenario: TC_DB_91:More actions - Validate copied URL
    And Mouse hover on any series level
    And Click on More actions
    And Select "Copy selected links"
    When Paste it in new tab
    Then The Series information popup should be opened in untitled insight for selected series

  @DB
  Scenario: TC_DB_92:More actions - Verify Copy links for multiple series
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "Copy selected links"
    Then URL should be generated for selected series

  @DB
  Scenario: TC_DB_93:More actions - Validate copied URL for multiple series
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "Copy selected links"
    And Paste in clipboard and take url one by one
    Then The SSP window should be opened

  @DB
  Scenario: TC_DB_94:More actions - Verify 'Series info' option for series
    And Mouse hover on any series level
    And Click on More actions
    And Select "Series Info"
    Then The SSP window should be opened

  @DB
  Scenario: TC_DB_95:More actions - Verify 'Footnotes' options for a series
    And Mouse hover on any series level
    And Click on More actions
    And Select "Footnotes"
    Then Footnotes should be opened for related "series"

  @DB
  Scenario: TC_DB_96:More actions - Verify back button
    And Mouse hover on any series level of data
    And Click on "More actions"
    And Select "Show Dataset"
    And Click on Back button
    Then Should redirect to database tab

  @DB
  Scenario: TC_DB_97:More actions - Verify closing of more dropdown
    And Mouse hover on any series level
    And Click on More actions
    And Click on More actions
    Then The dropdown should be closed

  @DB
  Scenario: TC_DB_98:Verify + icon for series
    And Mouse hover on any series level
    And Click on + icon for a series
    Then The series should be added to my series

  @DB
  Scenario: TC_DB_99:Verify + icon when user in view tab
    And Click on View tab on right side
    And Mouse hover on any series level
    And Click on + icon
    Then Chart should be created with the series

  #	Then Chart should be created with selected seires
  @DB
  Scenario: TC_DB_100:Verify Add option under add dropdown
    And Mouse hover on any series level
    And Select "Add" option
    Then The series should be added to my series

  @DB
  Scenario: TC_DB_101:Verify Add option when Views tab opened in right side panel
    And Click on View tab on right side
    And Mouse hover on any series level
    And Select "Add" option
    Then Chart should be created with the series

  #	Then Chart should be created with selected seires
  @DB
  Scenario: TC_DB_102:Verify Add and Replace
    And Create a visual and select visual
    And Select a series and Click on dropdown icon
    And Click on "Add and replace"
    Then The selected series should be replaced with existing series on the visual

  @DB
  Scenario: TC_DB_103:Verify Add and Group
    And Select a series and Click on dropdown icon
    And Click on "Add and group"
    Then Selected series should be added as group in My series

  @DB
  Scenario: TC_DB_104:Verify Add to new insight
    And Select a series and Click on dropdown icon
    And Click on "Add to new insight"
    Then The new insight should be created with selected data

  @DB
  Scenario: TC_DB_105:Verify confirmation message for adding series to new insight
    And Select a series and Click on dropdown icon
    And Click on "Add to new insight"
    Then Confirmation message should be displayed as below "New insight with the selected series created."

  @DB
  Scenario: TC_DB_106:Validate the added series by opening new insight
    And Select a series and Click on dropdown icon
    And Click on "Add to new insight"
    Then The new insight should be created with selected series

  @DB
  Scenario: TC_DB_107:Verify adding series to recent insight
    And Select a series and Click on dropdown icon
    And Click on "Add to recent insight"
    And Select any recent insight from the dropdown
    And Click on "Apply"
    Then The "Selected series added to insights:" popup should be appeared

  @DB
  Scenario: TC_DB_108:Validate the added series by opening recent insight
    And Select a series and Click on dropdown icon
    And Click on "Add to recent insight"
    And Select any recent insight from the dropdown
    And Click on "Apply"
    Then The series should be added to My series tab for selected insight

  #
  ##@DB
  ##Scenario: TC_DB_115:Verify 'add to existing' insight
  ##	And  Select a series and Click on dropdown icon
  ##	And Click on "Add to existing insight"
  ##	Then The "Insight Explorer" popup should be appeared
  ##
  ##@DB
  ##Scenario: TC_DB_116:Validate the added series by opening existing insight
  ##	And  Select a series and Click on dropdown icon
  ##	And Click on "Add to existing insight"
  ##	Then The series should be added to My series tab for selected insight
  ##
  ##@DB
  ##Scenario: TC_DB_117:Verify adding series to existing insight
  ##	And  Select a series and Click on dropdown icon
  ##	And Click on "Add to existing insight"
  ##	Then The "Selected series added to insights:" popup should be appeared
  ##
  ##@DB
  ##Scenario: TC_DB_118:Verify adding series to multiple existing insights
  ##	And  Select a series and Click on dropdown icon
  ##	And Click on "Add to existing insight"
  ##	And Select multiple insights
  ##	And Click on "Add to insights"
  #	Then Open the insights and verify the series in My series
  #
  @DB
  Scenario: TC_DB_109:Verify adding series by drag and drop to my series
    And Select a series
    And Drag and drop to my series/visual
    Then The series should be added to my series

  @DB
  Scenario: TC_DB_110:Verify adding series by drag and drop to empty view panel
    And Create new view pannel
    And Select a series
    And Drag and drop to any visual template
    Then Respective visual should be created as per the series drop

  @DB
  Scenario: TC_DB_111:Verify adding series by keyboard shortcut
    And Select a series
    And Click on 'A' on keyboard
    Then The series should be added to my series

  @DB
  Scenario: TC_DB_112:Verify adding series by double click on series
    And Select some series
    And Just double click on series
    Then The selected series should be added to My series/visuals

  @DB
  Scenario: TC_DB_113:Verify adding series to my series with expanded search panel
    And Expand search panel
    And Select series in any database
    And Click on My series
    Then The selected series should be added to My series/visuals

  @DB
  Scenario: TC_DB_114:Verify creating visuals with selected series from expanded search panel
    And Expand search panel
    And Select series in any database
    And Click on any visual type
    Then The selected series should be added to visuals

  @DB
  Scenario: TC_DB_115:Right click - Verify Unselect all
    And Right click on any series level of data
    And Select "Unselect all"
    Then The selected series should be unselected

  @DB
  Scenario: TC_DB_116:Right click - Verify "View as Chart" for series level
    And Right click on any series level of data
    And Select "View as Chart"
    Then Visual should be created with "Edit Chart"

  @DB
  Scenario: TC_DB_117:Right click - Verify "View as Map" for series level
    And Right click on any series level of data
    And Select "View as Map" as "World"
    Then Visual should be created with "Edit Map"

  @DB
  Scenario: TC_DB_118:Right click - Verify "View as Table" for series level
    And Right click on any series level of data
    And Select "View as Table"
    Then Visual should be created with "Edit Table"

  @DB
  Scenario: TC_DB_119:Right click - Verify "View as Pie" for series level
    And Right click on any series level of data
    And Select "Pie"
    Then Visual should be created with "Edit Pie"

  @DB
  Scenario: TC_DB_120:Right click - Verify "View as Heat map" for series level
    And Right click on any series level of data
    And Select "Heat map"
    Then Visual should be created with "Edit Heat map"

  @DB
  Scenario: TC_DB_121:Right click - Verify "View as Histogram" for series level
    And Right click on any series level of data
    And Select "Histogram"
    Then Visual should be created with "Edit Histogram"

  @DB
  Scenario: TC_DB_122:Right click - Verify creating visual with more than max seires selection
    And Right click on any series level and select more than max series
    And Select "View as Chart"
    Then Confirmation window should be displayed and proceed with max series if click on "Ok" button
    Then "Chart" visual should be created with max series

  @DB
  Scenario: TC_DB_123:Right click - Verify download option for series
    And Right click on any series level of data
    And Select "Download"
    Then Download window should be appeared with selected series count

  @DB
  Scenario: TC_DB_124:Right click - Verify 'Copy' for series level
    And Right click on any series level of data
    And Select "Copy"
    Then Selected series should be copied

  @DB
  Scenario: TC_DB_125:Right click - Verify pasting the copied series
    And Right click on any series level of data
    And Select "Copy"
    And Paste in application
    Then Copied series should be pasted to my series tab

  @DB
  Scenario: TC_DB_126:Right click - Verify the confirmation message
    And Right click on any series level of data
    And Select "Copy"
    Then The message should be in growl popup as "Selected series copied."

  @DB
  Scenario: TC_DB_127:Right click - Verify copy data for series
    And Right click on any series level of data
    And Select "Copy data"
    Then The download popup should be opened

  @DB
  Scenario: TC_DB_128:Right click - Verify Copy links for a series
    And Right click on any series
    And Select "Copy selected links"
    Then URL should be generated for selected series

  @DB
  Scenario: TC_DB_129:Right click - Validate copied URL
    And Right click on any of the series
    And Select "Copy selected links"
    When Paste it in new tab
    Then The Series information popup should be opened in untitled insight for selected series

  @DB
  Scenario: TC_DB_130:Right click - Verify Copy links for multiple series
    And Right click on any series level of data
    And Select "Copy selected links"
    Then URL should be generated for selected series

  @DB
  Scenario: TC_DB_131:Right click - Validate copied URL for multiple series
    And Create a "New" insight
    And Right click on any series level of data
    And Select "Copy selected links"
    And Paste in clipboard and take url one by one
    Then The SSP window should be opened

  @DB
  Scenario: TC_DB_132:Right click - Verify 'Series info' option for series
    And Right click on any series
    And Select "Series Info"
    Then The SSP window should be opened

  @DB
  Scenario: TC_DB_133:Right click - Verify 'Footnotes' option for series
    And Right click on any series
    And Select "Footnotes"
    Then Footnotes should be opened for related "series"

  @DB
  Scenario: TC_DB_134:Right click - Verify back button
    And Right click on any series
    And Select "Show Dataset"
    And Click on Back button
    Then Should redirect to database tab

  @DB
  Scenario: TC_DB_135:Verify adding separators with series
    And Select series with separators
    And Add to my series
    Then Selected series and separators should be added to my series

  @DB
  Scenario: TC_DB_136:Verify series order when table data added
    And Select a table and add to my series
    Then The series in the table should be ordered as in the table in search panel

  @DB
  Scenario: TC_DB_137:Verify selected 'series count' under DB tab
    And Select some series
    Then Selected series count should be shown correctly

  @DB
  Scenario: TC_DB_138:Verify 'Search selection'
    And Select some series from series level
    And Click on selected series count
    Then "Search Selection" panel should be opened

  @DB
  Scenario: TC_DB_139:Series selection - Verify 'SSP' in series selection
    And Select some series from series level
    And Click on selected series count
    And Click on series
    Then SSP window should be opened

  @DB
  Scenario: TC_DB_140:Series selection - Verify 'SSP' in series selection
    And Select some series from series level
    And Click on selected series count
    #	And Observe the series count in Series Selection window
    Then Series count should be match with available series in Series Selection window

  @DB
  Scenario: TC_DB_141:Series selection - Verify add series to My series tab from search selection
    And Select some series from series level
    And Click on selected series count
    #	And Observe the series count in Series Selection window
    And Click on +icon on series
    And Close search selection window
    Then The series should add to My series panel

  @DB
  Scenario: TC_DB_142:Series selection - Add series to My Series tab by using + icon on series selection header
    And Select some series from series level
    And Click on selected series count
    #	And Observe the series count in Series Selection window
    And Click on +icon on header
    And Close search selection window
    Then The series should be added to My series panel

  @DB
  Scenario: TC_DB_143:Series selection - Verify 'add' series from dropdown
    And Select some series from series level
    And Click on selected series count
    #	And Observe the series count in Series Selection window
    And Click on dropdown icon next to +
    And Click on "Add"
    And Close search selection window
    Then The series should be added to My series panel

  @DB
  Scenario: TC_DB_144:Series selection - Verify 'Add and replace' from dropdown
    And Create a visual and select visual
    And Select any series
    And Click on selected series count
    And Click on dropdown icon next to +
    And Click on "Add and replace"
    And Close search selection window
    Then The selected series should be replaced with existing series on the visual

  #@DB
  #Scenario: TC_DB_156:Series selection - Verify 'Add to existing insight' in dropdown
  #	And Select any series
  #	And Click on selected series count
  #	And Click on dropdown icon next to +
  #	And Click on "Add to recent insight"
  #	And Select any recent insight from the dropdown
  #And Click on "Apply"
  #	Then The series should be added to My series tab for selected insight
  @DB
  Scenario: TC_DB_145:Series selection - Verify 'Create new insight' in dropdown
    And Select some series from series level
    And Click on selected series count
    #And Observe the series count in Series Selection window
    And Click on dropdown icon next to +
    And Click on "Add to new insight"
    Then New insight should be created with selected series in my series

  @DB
  Scenario: TC_DB_146:Series selection - Verify chart option
    And Select some series from series level
    And Click on selected series count
    And Click on "Create Chart" icon on header
    Then Visual should be created with "Edit Chart"

  @DB
  Scenario: TC_DB_147:Series selection - Verify CTC
    And Select some series from series level
    And Click on selected series count
    And Click on "Copy to Clipboard" icon on header
    Then Download window should be appeared with selected series count

  @DB
  Scenario: TC_DB_148:Series selection - Verify Download
    And Select some series from series level
    And Click on selected series count
    And Click on "Download" icon on header
    Then Download window should be appeared with selected series count

  @DB
  Scenario: TC_DB_149:Series selection - Verify minimize option
    And Select some series from series level
    And Click on selected series count
    And Click on "Minimize" icon on header
    Then The window should be "minimized"

  @DB
  Scenario: TC_DB_150:Series selection - Verify maximize option
    And Select some series from series level
    And Click on selected series count
    And Click on "Maximize" icon on header
    Then The window should be "maximized"

  @DB
  Scenario: TC_DB_151:Series selection - Verify exit full screen icon
    And Select some series from series level
    And Click on selected series count
    And Click on "Maximize" icon on header
    And Click on Exit full-screen icon
    Then The popup should be displayed in normal size

  @DB
  Scenario: TC_DB_152:Series selection - Verify series count after removed some series
    And Select some series from series level
    And Click on selected series count
    #And Observe the series count in Series Selection window
    And Mouse hover on any series
    And Click on close icon
    Then Series count should be reduced as per the series deletion

  @DB
  Scenario: TC_DB_153:Series selection - verify series remove icon
    And Select some series from series level
    And Click on selected series count
    #And Observe the series count in Series Selection window
    And Mouse hover on any series
    And Click on close icon
    Then The series should be removed from the popup

  @DB
  Scenario: TC_DB_154:Series selection - Verify close button(x)
    And Select some series from series level
    And Click on selected series count
    And Click on "Close" icon on header
    Then The window should be closed

  @DB
  Scenario: TC_DB_155:Verify 'New' label for new series
    And Click on "More" filter
    And User selects "New only"
    And User has clicked on "Apply filter"
    And Select Matches only
    And Select Global database
    And Expand till table level
    Then "NEW" icon should be displayed for series

  @DB
  Scenario: TC_DB_156:Verify 'K' icon for key series
    And Clear the applied filters
    And Click on "More" filter
    And User selects "Key only"
    And User has clicked on "Apply filter"
    And Select Global database
    And Expand till table level
    Then "k" icon should be displayed for series

  @DB
  Scenario: TC_DB_157:Verify 'F' icon for key series
    And Clear the applied filters
    And Click on "More" filter
    And User selects "Forecast"
    And User has clicked on "Apply filter"
    And Select Global database
    And Expand till table level
    Then "f" icon should be displayed for series

  @DB
  Scenario: TC_DB_158:Verify 'S' icon for with suggestions for rebased/discountinued series
    And Clear the applied filters
    And Click on "More" filter
    And User selects "With suggestions for rebased/discontinued series"
    And User has clicked on "Apply filter"
    And Select Global database
    And Expand till table level
    Then "s" icon should be displayed for series

  @DB
  Scenario: TC_DB_159:Verify Default tab for insight
    And Database tab should be loaded as default tab for the insight

  @DB
  Scenario: TC_DB_160:Verify clicking on Database when view panel in full screen
    And Make View pannel as fullscreen
    And Click on "Databases"
    Then Search panel should be exapanded and Databases tab should be loaded

  @DB
  Scenario: TC_DB_161:Verifying clicking on series name
    And Select database as Daily Database
    And Expand till series level
    And Click on series name
    Then Series information popup should be opened

  @DB
  Scenario: TC_DB_162:Series selection - Verify 'Add to recent insight' in dropdown
    And Select any series
    And Click on selected series count
    And Click on dropdown icon next to +
    And Click on "Add to recent insight"
    And Select any recent insight from the dropdown
    And Click on "Apply"
    Then The series should be added to My series tab for selected insight
