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
And Click on Unselect
Then Selected series should be unselected

@DB
Scenario: TC_DB_06: Verifying mouse hover options for DB level
Given Hover the mouse on any Database
Then Footnotes icon should be displayed
When  Click on footnote's icon
Then Footnotes should be opened for related DB

@DB
Scenario: TC_DB_07: Verifying Copy link(s) for DB level
Given Right click on any Database
And Click on "Copy link(s)"
When Paste in new tab
Then The selected DB should be highlighted

@DB
Scenario: TC_DB_08: Verifying 'Footnotes' for DB level
Given Right click on any Database
And Click on "Footnotes"
Then Footnotes should be opened for selected DB

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

#@DB
#Scenario: TC_DB_11: Verifying Filters for DB tab
#And Select filter "Region" as "Japan"
#And User has clicked on "Apply filter"
#And User selected "All databases" as "Global Database"
#Then Result should be displayed as per the filters applied

#@DB
#Scenario: TC_DB_12: Verifying remove icon for filters.
#And  User selects "Frequency" as "Monthly"
#And User has clicked on "Apply filter"
#When Click on x icon 
#Then The applied filters should be removed 

