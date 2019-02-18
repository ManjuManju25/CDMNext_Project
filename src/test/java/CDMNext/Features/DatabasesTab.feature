Feature: Verifying Databases tab functionality

Background:
Given User has successful logged in

#@DB
#Scenario: TC_DB_01: Verify multiple databases selection
#Given Click on All Databases dropdown
#And Select database as "China Premium Database,Brazil Premium Database,Russia Premium Database" 
#Then User can see the results for multiple database selection
#
#@DB
#Scenario: TC_DB_02: Verifying Database selection 
#Given Click on All Databases dropdown
#And Select database as "India Premium Database" 
#Then Result should be loaded only for selected database
#
#@DB
#Scenario: TC_DB_03: Verifying Expand --> DB > Topic > Section > Table
#And Select database as Daily Database
#And Expand till series level
#Then Should able to expand all the DB/Topic/section/table under Databases tab
#
#@DB
#Scenario: TC_DB_04: Verifying Collapse option
#And Select Global database  
#And Expand till series level
#And Click on Collapse option
#Then Opened data tree should be collapsed

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

#@DB
#Scenario: TC_DB_09: Verifying remove icon for database
#Given Click on All Databases dropdown
#And Select database as "World Trend Plus" 
#And Click on x icon to remove DB
#Then Selected database shold be removed
#
#@DB
#Scenario: TC_DB_10: Verify closing of insight explorer window
#Given Click on "All insights" option
#When Click on Close
#Then The Insight Explorer popup should be closed
#
#@DB
#Scenario: TC_DB_11: Verifying Filters for DB tab
#And Select filter "Region" as "Japan"
#And User has clicked on "Apply filter"
#And User selected "All databases" as "Global Database"
#Then Result should be displayed as per the filters applied
#
#@DB
#Scenario: TC_DB_12: Verifying remove icon for filters.
#And  User selects "Frequency" as "Monthly"
#And User has clicked on "Apply filter"
#When Click on x icon 
#Then The applied filters should be removed 
#
#@DB
#Scenario: TC_DB_13: Verifying Collapse option when search/filter applied
#Given User enters "Banglore"
#And Click on "Collapse"
#Then The data tree should be collapsed
#
#@DB
#Scenario: TC_DB_14: Verifying Expand option when search/filter applied
#Given User enters "Banglore"
#And Click on "Expand"
#Then The data tree should be expanded
#
#@DB
#Scenario: TC_DB_15: Verifying message if no results found for the search
#Given User enters "UN"
#Then "Sorry, no results were found here." message should be displayed
#
#@DB
#Scenario: TC_DB_16: Verifying 'See our search help'
#Given User enters "X"
#And  Click on "See our Search help"
#Then The "Keyword search tips" popup should be opened
#
#@DB
#Scenario: TC_DB_17: Verifying 'our help desk team'
#Given User enters "UN"
#And  Click on "our help desk team"
#Then User should redirect to "https://support.ceicdata.com/support/tickets/new"
#
#@DB
#Scenario: TC_DB_18: Verifying behavior after search removed
#Given User enters "money"
#And After loaded the results ,click on Remove for search keyword
#Then The result should be loaded without search
#
#@DB
#Scenario: TC_DB_19: Verifying right click options for Databases level
#Given Right click on any database 
#Then "Set language,Copy link(s),Footnotes" options should be available

@DB
Scenario Outline: <TCID>: Verifying DB language change in right click
And Right click on "<database>"
And "Set language" as "<language>"
Then The Databases language should be changed to selected language

Examples:
	| TCID |     database               | language |
#	| 20   | World Trend Plus           | 中文  |
	| 21   | Russia Premium Database    | Русский  |
#	| 22   | Indonesia Premium Database | Bahasa   |
#	
#@DB
#Scenario: TC_DB_23: Verifying DB language change for right click when the database is expaned
#And Select Global database  
#And Expand till series level
#And Right click on "Global Database"
#And "Set language" as "中文"
#Then The Databases language should be changed to selected language
#
#@DB
#Scenario: TC_DB_24: Verifying mouse hover options for Topic level
#And Mouse hover on any topic level of data
#Then "Copy link(s)" should be available
#When Paste it in new tab
#Then The selected "topic" should be highlighted
#
#@DB
#Scenario: TC_DB_25: Verifying mouse hover options for Topic level
#And Mouse hover on any topic level of data
#Then "Footnotes" should be available
#When click on it
#Then Footnotes should be opened for related "topic"
#
#@DB
#Scenario: TC_DB_26: Verify right click options for Topic level
#And Right click on any topic level of data
#Then "Copy link(s),Footnotes" options should be available
#
#@DB
#Scenario: TC_DB_27: Verifying Copy link(s) for Topic level
#And Right click on any topic level of data
#And "Copy link(s)" option should be available
#When Paste it in new tab
#Then The selected "topic" should be highlighted
#
#@DB
#Scenario: TC_DB_28: Verifying Footnotes for Topic level
#And Right click on any topic level of data
#And "Footnotes" option should be available
#When click on it
#Then Footnotes should be opened for related "topic"
#
#@DB
#Scenario: TC_DB_29: Verifying mouse hover options for Section level
#And Mouse hover on any Section level of data
#Then "Copy link(s)" should be available
#When Paste it in new tab
#Then The selected "section" should be highlighted
#
#@DB
#Scenario: TC_DB_30: Verifying mouse hover options for Section level
#And Mouse hover on any Section level of data
#Then "Footnotes" should be available
#When click on it
#Then Footnotes should be opened for related "section"
#
#@DB
#Scenario: TC_DB_31: Verify right click options for section level
#And Right click on any section level of data
#Then "Copy link(s),Footnotes" options should be available
#
#@DB
#Scenario: TC_DB_32: Verifying right click options for Section level
#And Right click on any section level of data
#And "Copy link(s)" option should be available
#When Paste it in new tab
#Then The selected "section" should be highlighted
#
#@DB
#Scenario: TC_DB_33: Verifying Footnotes for Section level
#And Right click on any section level of data
#And "Footnotes" option should be available
#When click on it
#Then Footnotes should be opened for related "section"
#
#@DB
#Scenario: TC_DB_34: Verifying copy link(s) for table level
#And  Mouse hover on any table level of data
#And "Copy link(s)" should be available
#Then The link should be copied
#
#@DB
#Scenario: TC_DB_35: Verifying confirmation message for Copy link
#And  Mouse hover on any table level of data
#And "Copy link(s)" should be available
#Then "1 URL link(s) copied." message should be displayed
#
#@DB
#Scenario: TC_DB_36:Validating copied link
#And  Mouse hover on any table level of data
#And "Copy link(s)" should be available
#When Paste it in new tab
#Then The selected "table" should be highlighted
