Feature: SprintCases_4.11 feature
 @sprint_4.11
 Scenario:TC_19499_01: Verify a single quote for first name or last name
 And Open preference dropdown1
  And click on pencile button
  And add a single quote in first name and last name
  And click on save button
  And Open preference dropdown1
  Then Should be able to save first name and last name with single quote
  @sprint_4.11
   Scenario:TC_18707_01: Verify 'Series Remarks and Suggestions' attribute on table and downloaded file
   And User Select Series ID as "365383927"
  And Create table visual
  And double click on any one attribute on table
  And 'Series Remarks and Suggestions' check box checked
  And click on Download button in right side header 
  Then 'Series Remarks and Suggestions' attributes should displayed to table visual and should displayed in download table
  @sprint_4.11
  Scenario:TC_14772_01: Verify search for EU
 
 And Search "EU" in search panel
 Then Result should be displayed for EU search
 @sprint_4.11
  Scenario:TC_19487_01: Verify full group name in the group popup
And Select some series to my series tab
And create group in same name in series
And  Select a series and click on Group and mouse hover on group name
Then verify Tooltip should displayed with full group name
 @sprint_4.11
 
 Scenario:TC_19687: Implement support for "Add menu" under the right click menu
 
 And click on More button
 And checked "With historical extension of continuous series" checkbox and click on apply filter
 And Right click on series and mouse over the 'Add'
 Then should be able to see "Add as continuous series" menu
  @sprint_4.11
  
 Scenario:TC_19075: Implement support for Continuous series in SSP
 And click on More button
 And checked "With historical extension of continuous series" checkbox and click on apply filter
 And Open any series with C icon
 And Check for continuous checkbox in SSP window
 Then Series should be shown with all contributed series for one continuous series to be made
 @sprint_4.11
 Scenario:TC_19779_01: Verify if series name is updated for splice function
 
 And Add 2 series into an insight
 And Apply "Splice" function
And  Check the function description
@sprint_4.11
Scenario:TC_19779_02: Verify if series name is updated for update function


  And Add 2 series into an insight
  And  Apply "Update" function
  And  Check the function description
  @sprint_4.11
Scenario:TC_19686:Verify filter name for continuos series
 And Open more filter
 And Verify text for c series
 Then It should be "With historical extension of continuous series"
  @sprint_4.11
  Scenario:TC_12978_01:Verify country filter on view mode(insight view or shared in view mode).
And Select some series from different region "1692001;447233417;378276697;386588657"
And Create any visual1
And Create country filter on same view
And Select any one region from country filter
And Open insight in view mode
And Select or unselect region in country filter
@sprint_4.11
Scenario:TC_17238: Saved search : For no search results, save button should not be enabled
 And Search for random word like "greenary" Which yields no search results
 And Save button should not be shown
 @sprint_4.11
 Scenario:TC_19790:When C series is checked in SSP, the selected period should be ALL (by default) to better see the long history
 
  And Open more filter
  And Checked "With historical extension of continuous series" check box and click on Apply filter
  And Open any series with C icon
 And Check for continuous checkbox in SSP window
 Then Time period should change to All by default
 
 @sprint_4.11
 
 Scenario:TC_19073:Add the icon (c) to the series in Search, My series
 
  And Open more filter
  And check "With historical extension of continuous series"should be shown
  And Checked "With historical extension of continuous series" check box and click on Apply filter
  Then series which are continuous should be shown with C icon infront of series name
 @sprint_4.11
 Scenario:TC_19673:Continuous series: when a user adds a continuous series from search/SSP - add not only continuous chains but also all series contributed to them
 And click on More button
 And checked "With historical extension of continuous series" checkbox and click on apply filter
 And Open any series with C icon
 Then Add as continuous to my series
 @sprint_4.11
 Scenario:TC_10175: FEEDBACK: functions - make Most frequently used application (maths functions) to be shown easily or bookmarked
 And Create new insight1
 And Add a series "1692001" into right-pane
 And Click on function toolbar apply round function "ROUND"
 And select series with applied function
 @sprint_4.11
 Scenario:TC_19675: Enhance Continuous series look&feel in SSP
 
  And Open more filter
  And Checked "With historical extension of continuous series" check box and click on Apply filter
  And Open any series with C icon
 And Check for continuous checkbox in SSP window
 And click on any one continues series and click on continuous series details
 Then check open ssp of continuous series present in SSP opened
 @sprint_4.11
 Scenario:TC_18804:Verify if Fill blank observations has 0 in CDMNext download settings page
 And Select a series with gap " 9380901"
Then Click on download button with fill observations as 0 click ok
@sprint_4.11
Scenario:TC_13790: Pie: implement the Compare option
And Create any pie chart and set number of pie to seen as 1,2,4 
And Switch from smaller to bigger number of pie will inherit time period as default pie
And switch from bigger to smaller number of pie will keep the left top corner of pie as default "#FFD620" "#54B582"
@sprint_4.11
Scenario:TC_10703 :FEEDBACK: Option to copy multiple functions already applied for one series to other series 
And Add some series into my series 
And Apply them into different functions to make them as favorite by clicking on starred icon beside functions applied in function bar "ROUND;MULTIPLY;POWER;AGGREGATE;UNIT_MULTIPLIER;ADD;DIVIDE;RECIP;DISAGGREGATE;%CHANGE;FILLGAP;SUBTRACT;YTD;SMOOTH;SQRT;ANTILOG;LOG10;EXP;LAG"
 
And click on fx symbol to go to favorited functions popup
@sprint_4.11
Scenario:TC_19533 :Pie chart controls update
And Create pie chart
And Update pie chart date picker controls for multiple pie in single pie according to frequency of series
@sprint_4.11
Scenario:TC_19264:Download: implement support for downloading multiple pie charts in one visual
And Create multiple pie in single pie visual 
And set different date pickers for each and download to excel "Q1;Q2;Q3;Q4"
 
 