Feature: Verifying Databases tab functionality

Background:
Given User has successful logged in

@DB
Scenario: TC_DB_01: Verify multiple databases selection
Given Click on All Databases dropdown
And Select database as "China Premium Database,Brazil Premium Database,Russia Premium Database" 
Then User can see the results for multiple database selection

@DB
Scenario: TC_DB_02: Verifying Database selection 
Given Click on All Databases dropdown
And Select database as "India Premium Database" 
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
And Click on Collapse option
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
When  Click on footnote's icon
Then Footnotes should be opened for related "DB"

@DB
Scenario: TC_DB_07: Verifying Copy link(s) for DB level
Given Right click on any Database
And "Copy link(s)" option should be available
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
Given Click on All Databases dropdown
And Select database as "World Trend Plus" 
And Click on x icon to remove DB
Then Selected database shold be removed

@DB
Scenario: TC_DB_10: Verify closing of insight explorer window
Given Click on "All insights" option
When Click on Close
Then The Insight Explorer popup should be closed

@DB
Scenario: TC_DB_11: Verifying Filters for DB tab
And Select filter "Region" as "Japan"
And User has clicked on "Apply filter"
And User selected "All databases" as "Global Database"
Then Result should be displayed as per the filters applied

@DB
Scenario: TC_DB_12: Verifying remove icon for filters.
And  User selects "Frequency" as "Monthly"
And User has clicked on "Apply filter"
When Click on x icon 
Then The applied filters should be removed 

@DB
Scenario: TC_DB_13: Verifying Collapse option when search/filter applied
Given User enters "Banglore"
And Click on "Collapse"
Then The data tree should be collapsed

@DB
Scenario: TC_DB_14: Verifying Expand option when search/filter applied
Given User enters "Banglore"
And Click on "Expand"
Then The data tree should be expanded

@DB
Scenario: TC_DB_15: Verifying message if no results found for the search
Given User enters "UN"
Then "Sorry, no results were found here." message should be displayed

@DB
Scenario: TC_DB_16: Verifying 'See our search help'
Given User enters "X"
And  Click on "See our Search help"
Then The "Keyword search tips" popup should be opened

@DB
Scenario: TC_DB_17: Verifying 'our help desk team'
Given User enters "UN"
And  Click on "our help desk team"
Then User should redirect to "https://support.ceicdata.com/support/tickets/new"

@DB
Scenario: TC_DB_18: Verifying behavior after search removed
Given User enters "money"
And After loaded the results ,click on Remove for search keyword
Then The result should be loaded without search

@DB
Scenario: TC_DB_19: Verifying right click options for Databases level
Given Right click on any database 
Then "Set language,Copy link(s),Footnotes" options should be available

@DB
Scenario Outline: <TCID>: Verifying DB language change in right click
And Right click on "<database>"
And "Set language" as "<language>"
Then The Databases language should be changed to selected language

Examples:
	| TCID |     database               | language |
	| 20   | World Trend Plus           | 中文  |
	| 21   | Russia Premium Database    | Русский  |
	| 22   | Indonesia Premium Database | Bahasa   |
	
@DB
Scenario: TC_DB_23: Verifying DB language change for right click when the database is expaned
And Select Global database  
And Expand till series level
And Right click on "Global Database"
And "Set language" as "中文"
Then The Databases language should be changed to selected language

@DB
Scenario: TC_DB_24: Verifying mouse hover options for Topic level
And Mouse hover on any topic level of data
Then "Copy link(s)" should be available
When Paste it in new tab
Then The selected "topic" should be highlighted

@DB
Scenario: TC_DB_25: Verifying mouse hover options for Topic level
And Mouse hover on any topic level of data
Then "Footnotes" should be available
When click on it
Then Footnotes should be opened for related "topic"

@DB
Scenario: TC_DB_26: Verify right click options for Topic level
And Right click on any topic level of data
Then "Copy link(s),Footnotes" options should be available

@DB
Scenario: TC_DB_27: Verifying Copy link(s) for Topic level
And Right click on any topic level of data
And "Copy link(s)" option should be available
When Paste it in new tab
Then The selected "topic" should be highlighted

@DB
Scenario: TC_DB_28: Verifying Footnotes for Topic level
And Right click on any topic level of data
And "Footnotes" option should be available
When click on it
Then Footnotes should be opened for related "topic"

@DB
Scenario: TC_DB_29: Verifying mouse hover options for Section level
And Mouse hover on any Section level of data
Then "Copy link(s)" should be available
When Paste it in new tab
Then The selected "section" should be highlighted

@DB
Scenario: TC_DB_30: Verifying mouse hover options for Section level
And Mouse hover on any Section level of data
Then "Footnotes" should be available
When click on it
Then Footnotes should be opened for related "section"

@DB
Scenario: TC_DB_31: Verify right click options for section level
And Right click on any section level of data
Then "Copy link(s),Footnotes" options should be available

@DB
Scenario: TC_DB_32: Verifying right click options for Section level
And Right click on any section level of data
And "Copy link(s)" option should be available
When Paste it in new tab
Then The selected "section" should be highlighted

@DB
Scenario: TC_DB_33: Verifying Footnotes for Section level
And Right click on any section level of data
And "Footnotes" option should be available
When click on it
Then Footnotes should be opened for related "section"

@DB
Scenario: TC_DB_34: Verifying copy link(s) for table level
And  Mouse hover on any table level 
And "Copy link(s)" should be available
Then The link should be copied

@DB
Scenario: TC_DB_35: Verifying confirmation message for Copy link
And  Mouse hover on any table level 
And "Copy link(s)" should be available
Then "1 URL link(s) copied." message should be displayed

@DB
Scenario: TC_DB_36:Validating copied link
And  Mouse hover on any table level 
And "Copy link(s)" should be available
When Paste it in new tab
Then The selected "table" should be highlighted

@DB
Scenario: TC_DB_37:Verifying Copy link for multiple tables selected
And  Select multiple tables
And Click on "Copy link(s)"
Then The links should be generated for selected tables

@DB
Scenario: TC_DB_38: Validating copied link for multiple tables selection.
And  Select multiple tables
And Click on "Copy link(s)"
Then Multiple table's link should be copied to clipboard and open respective "table" should be highlighted when run links one by one in browser

@DB
Scenario: TC_DB_39: Verifying Footnotes for table level
And Mouse hover on any table level 
And "Footnotes" should be available
When click on it
Then Footnotes should be opened for related "table"

@DB
Scenario: TC_DB_40:Verifying + icon for table level
And Mouse hover on any table level 
And "+" should be available
When click on it
Then The entire table should be added to my series

@DB
Scenario: TC_DB_41:Verifying Add dropdown for table level
And Mouse hover on any table level
And Click on dropdown next to + icon
Then The dropdown should be opened with these items "Add,Add and replace,Add and group,Add to new insight,Add to existing insight"

@DB
Scenario: TC_DB_42:Verifying Add option under add dropdown for table level
And Mouse hover on any table level 
And  Select "Add" option
Then The entire table should be added to my series

@DB
Scenario: TC_DB_43:Verifying Add and Replace for table level
And Create a visual and Mouse hover on any table 
And  Click on dropdown icon 
And  Click on "Add and replace"
Then The selected table data should be replaced with existing data on the visual

@DB
Scenario: TC_DB_44:Verifying Add and Group for table level
And Mouse hover on any table level of data
And  Click on dropdown icon 
And  Click on "Add and group"
Then Selected table should be added as group in My series

@DB
Scenario: TC_DB_45:Verifying Add to new insight for table level
And Mouse hover on any table level
And  Click on dropdown icon 
And  Click on "Add to new insight"
Then The new insight should be created with selected data

@DB
Scenario: TC_DB_46:Verifying confirmation message for adding table to new insight
And Mouse hover on any table level 
And  Click on dropdown icon 
And  Click on "Add to new insight"
Then Confirmation message should be displayed as below "New insight with the selected series created."

@DB
Scenario: TC_DB_47:Validating the added series by opening new insight
And Mouse hover on any table level 
And  Click on dropdown icon 
And  Click on "Add to new insight"
Then The insight should be opened and added series should be available in My series

@DB
Scenario: TC_DB_48:Verifying 'add to existing' insight for table level
And Mouse hover on any table level 
And  Click on dropdown icon 
And  Click on "Add to existing insight"
Then The "Insight Explorer" popup should be appeared

@DB
Scenario: TC_DB_49:Verifying 'Add to insights' button
And Mouse hover on any table level 
And  Click on dropdown icon 
And  Click on "Add to existing insight"
Then The "Add to insights" button should be disabled by default and enable after any insight selection

@DB
Scenario: TC_DB_50:Verifying adding data to existing insight
And Mouse hover on any table level 
And  Click on dropdown icon 
And  Click on "Add to existing insight"
Then The "Selected series added to insights:" popup should be appeared

@DB
Scenario: TC_DB_51:Validating the added table data by opening existing insight
And Mouse hover on any table level of data
And  Click on dropdown icon 
And  Click on "Add to existing insight"
Then The data should be added to My series for selected insight

@DB
Scenario: TC_DB_52:Verifying number of selected insights count
And Mouse hover on any table level
And  Click on dropdown icon 
And  Click on "Add to existing insight"
And Select multiple insights
Then The number of selected insights count should be shown on popup header

@DB
Scenario: TC_DB_53:Verifying Open option
And Mouse hover on any table level
And  Click on dropdown icon 
And  Click on "Add to existing insight"
And Click on "Open"
Then "Insight Explorer" page should be opened in new tab

@DB
Scenario: TC_DB_54:Verifying Close/x for insight explorer modal window
And Mouse hover on any table level
And  Click on dropdown icon 
And  Click on "Add to existing insight"
And Click on "×"
Then The insight explorer popup should be closed

@DB
Scenario: TC_DB_55:Verifying 'Unselect all' for table level
And Right click on any table level
And  Select "Unselect all"
Then The selected data should be unselected

@DB
Scenario: TC_DB_56:Verifying "View as Chart" for table level
And Right click on any table level
And  Select "View as Chart"
Then "Chart" should be created with series in views panel

@DB
Scenario: TC_DB_57:Verifying "View as Map" for table level
And Right click on any table level
And  Select "View as Map"
Then "Map" should be created with series in views panel

@DB
Scenario: TC_DB_58:Verifying "View as Table" for table level
And Right click on any table level
And  Select "View as Table"
Then "Table" should be created with series in views panel

@DB
Scenario: TC_DB_59:Verifying "View as Pie" for table level
And Right click on any table level
And  Select "Pie"
Then "Pie" should be created with series in views panel

@DB
Scenario: TC_DB_60:Verifying "View as Heat map" for table level
And Right click on any table level
And  Select "Heat map"
Then "Heat map" should be created with series in views panel

@DB
Scenario: TC_DB_61:Verifying "Histogram" for table level
And Right click on any table level
And  Select "Histogram"
Then "Histogram" should be created with series in views panel

@DB
Scenario: TC_DB_62:Verify creating visual with more than max seires selection
And Right click on any table level and select more than max series
And  Select "View as Chart"
Then "Confirmation" window should be displayed

@DB
Scenario: TC_DB_63:Verify confirmation window for more than max series selection for visual creation
And Right click on any table level and select more than max series
And  Select "View as Chart"
Then Confirmation window should display with "You cannot create a chart with more than 20 series. Proceed with 20 series?"

@DB
Scenario: TC_DB_64:Verifying cancel/x button for confrimation popup
And Right click on any table level and select more than max series
And  Select "View as Chart"
And Click on "Cancel"

@DB
Scenario: TC_DB_65:Verifying Ok button for confrimation popup
And Right click on any table level and select more than max series
And  Select "View as Chart"
And Click on "Ok"
Then "Chart" visual should be created with max series

@DB
Scenario: TC_DB_66:Verifying Download option for table level
And Right click on any table level
And  Select "Download"
Then Download window should be appeared with selected series count

@DB
Scenario: TC_DB_67:Verifying Copy link(s) for table level
And Right click on any table level
And Select "Copy link(s)"
When Paste it in new tab
Then The selected "table" should be highlighted

@DB
Scenario: TC_DB_68:Verifying Footnotes option for table level
And Right click on any table level
And Select "Footnotes"
Then Footnotes should be opened for related "table"

@DB
Scenario: TC_DB_69:Verifying Show dataset for table level
And Right click on any table level
And Select "Show Dataset"
Then All the series under the table should be shown

@DB
Scenario: TC_DB_70:Verifying 'NEW' icon for table level
And User selects "New only"
And User has clicked on "Apply filter"
And Select Global database  
And Expand till table level
Then "NEW" icon should be displayed in table level

@DB
Scenario: TC_DB_71:Verifying adding table by keyboard shortcut
And  Right click on any table level
And  Press A on keyboard
Then The entire table should be added to my series

@DB
Scenario: TC_DB_72:Verifying adding table by drag and drop
And Mouse hover on any table level
And  Drag and drop to my series/visual
Then The entire table should be added to my series

@DB
Scenario: TC_DB_73:Verifying clicking on series name
And  Select database as Daily Database
And  Expand till series level
And Click on series name
Then Series information popup should be opened

@DB
Scenario: TC_DB_74:Verifying related data
And   Select database as Daily Database 
And  Expand till series level
And Click on "Show related data" icon
Then Related data should be displayed under the dropdown

@DB
Scenario: TC_DB_75:Verify Related data > Remarks
And  Expand World Trend Plus till series level
And Click on Show related data icon
Then "Remarks:" should be displayed if available for the series

@DB
Scenario: TC_DB_76:Verify 'Read more' for Remarks under Related data
And  Expand World Trend Plus till series level
And Click on Show related data icon
And Click on "Read More"
Then Should open related footnotes

@DB
Scenario: TC_DB_77:Verify clicking Datasets
And   Select database as Daily Database 
And  Expand till series level
And Click on Show related data icon
And Click on datalinks under datasets
Then Should redirect to respective datasets

@DB
Scenario: TC_DB_78:Verify related insights
And   Select database as Daily Database 
And  Expand till series level
And Click on Show related data icon
And Click on any insights under insights section
Then Insights should be opened in preview mode

@DB
Scenario: TC_DB_79:Verify share icon for insight
And   Select database as Daily Database 
And  Expand till series level
And Click on Show related data icon
And Click on share under insights section
Then Share popup should be opened if have permission to share

@DB
Scenario: TC_DB_80:Verify add to favorite icon
And   Select database as Daily Database 
And  Expand till series level
And Click on Show related data icon
And Click on add to favourite under insights section
Then The insights should be added to favorite list

@DB
Scenario: TC_DB_81:Verify hide related data
And   Select database as Daily Database 
And  Expand till series level
And Click on "Show related data" 
And Click on "Hide related data" 
Then The related data dropdown should be collapsed

@DB
Scenario: TC_DB_82: Verifying 'View as chart'
And Mouse hover on any series level 
And Click on "View as Chart. Type `c`"
Then Chart should be created with the series

@DB
Scenario: TC_DB_83: Verify the series selection in Database after created visual
And Mouse hover on any series level 
And Click on "View as Chart. Type `c`"
Then The series should be selected in search panel although visual created

@DB
Scenario: TC_DB_84:Verifying Footnote icon
And Mouse hover on any series level 
And Click on Footnote icon
Then Footnotes should be opened for related "series"

@DB
Scenario: TC_DB_85:More actions - Verify Unselect all
And Mouse hover on any series level of data
And Click on "More actions"
And Click on "Unselect all"
Then The selected series should be unselected

@DB
Scenario: TC_DB_86:More actions - Verify "View as Chart" for series level
And Mouse hover on any series level of data
And Click on "More actions"
And Select "View as Chart"
Then Visual should be created with "Edit Chart"

@DB
Scenario: TC_DB_87:More actions - Verify "View as Map" for series level
And Mouse hover on any series level of data
And Click on "More actions"
And Select "View as Map"
Then Visual should be created with "Edit Map"

@DB
Scenario: TC_DB_88:More actions - Verify "View as Table" for series level
And Mouse hover on any series level of data
And Click on "More actions"
And Select "View as Table"
Then Visual should be created with "Edit Table"

@DB
Scenario: TC_DB_89:More actions - Verify View as Pie for series level
And Mouse hover on any series level of data
And Click on "More actions"
And Select "Pie"
Then Visual should be created with "Edit Pie"

@DB
Scenario: TC_DB_90:More actions - Verify View as Heat map for series level
And Mouse hover on any series level of data
And Click on "More actions"
And Select "Heat map"
Then Visual should be created with "Edit Heat map"
#
#@DB
#Scenario: TC_DB_91:More actions - Verify View as Histogram for series level
#And Mouse hover on any series level
#And Click on More actions
##And Mouse hover on any series level of data
##And Click on "More actions"
#And Select "Histogram"
#Then Visual should be created with "Edit Histogram"
#
#@DB
#Scenario: TC_DB_92:More actions - Verify download option for series
#And Mouse hover on any series level of data
#And Click on "More actions"
#And  Select "Download"
#Then Download window should be appeared with selected series count
#
#@DB
#Scenario: TC_DB_93:More actions - Verify creating visual with more than max seires selection
#And Mouse hover on any series level and select more than max series
#And Select "View as Chart"
#Then Confirmation window should be displayed and proceed with max series if click on "Ok" button
#Then "Chart" visual should be created with max series
#
#@DB
#Scenario: TC_DB_94:More actions - Verify 'Copy' for series level
#And Mouse hover on any series level of data
#And Click on "More actions"
#And Select "Copy"
#Then Selected series should be copied
#
@DB1
Scenario: TC_DB_95:More actions - Verify pasting the copied series
And Mouse hover on any series level
And Click on More actions
And Select "Copy"
And Paste in application
Then Copied series should be pasted
#
#@DB
#Scenario: TC_DB_96:More actions - Verify the confirmation message
#And Mouse hover on any series level
#And Click on More actions
#And Select "Copy"
#Then The message should be in growl popup as "Selected series copied."
#
#@DB
#Scenario: TC_DB_97:More actions - Verify copy data for series
#And Mouse hover on any series level
#And Click on More actions
#And Select "Copy data"
#Then The download popup should be opened
#
#@DB
#Scenario: TC_DB_98:More actions - Verify Copy links for a series
#And Mouse hover on any series level
#And Click on More actions
#And Select "Copy link(s)"
#Then URL should be generated for selected series
#
#@DB
#Scenario: TC_DB_99:More actions - Validate copied URL
#And Mouse hover on any series level
#And Click on More actions
#And Select "Copy link(s)"
#When Paste it in new tab
#Then The Series information popup should be opened in untitled insight for selected series
#
#@DB
#Scenario: TC_DB_100:More actions - Verify Copy links for multiple series
#And Mouse hover on any series level of data
#And Click on "More actions"
#And Select "Copy link(s)"
#Then URL should be generated for selected series
#
#@DB
#Scenario: TC_DB_101:More actions - Validate copied URL for multiple series
#And Mouse hover on any series level of data
#And Click on "More actions"
#And Select "Copy link(s)"
#And Paste in clipboard and take url one by one 
#Then The Series information popup should be opened 
#
#@DB
#Scenario: TC_DB_102:More actions - Verify 'Series info' option for series
#And Mouse hover on any series level 
#And Click on More actions
#And Select "Series Info"
#Then The SSP window should be opened
#
#@DB
#Scenario: TC_DB_103:More actions - Verify 'Footnotes' options for a series
#And Mouse hover on any series level 
#And Click on More actions
#And Select "Footnotes"
#Then Footnotes should be opened for related "series"
#
#@DB
#Scenario: TC_DB_104:More actions - Verify back button
#And Mouse hover on any series level of data
#And Click on "More actions"
#And Select "Show Dataset"
#And Click on Back button
#Then Should redirect to database tab
#
#@DB
#Scenario: TC_DB_105:More actions - Verify closing of more dropdown
#And Mouse hover on any series level 
#And Click on More actions
#And Click on More actions
#Then The dropdown should be closed
#
#@DB1
#Scenario: TC_DB_106:Verify + icon for series
#And Mouse hover on any series level 
#And  Click on + icon for a series 
#Then The series should be added to my series
#
#@DB1
#Scenario: TC_DB_107:Verify + icon when user in view tab
#And Click on View tab on right side
#And Mouse hover on any series level 
#And  Click on + icon for a series 
#Then Chart should be created with selected seires


