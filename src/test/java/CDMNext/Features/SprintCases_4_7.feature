Feature: SprintCases_4.7 feature
@sprint_4.7
 Scenario:TC_18207_01: Verify 'Load more' button in Datasets when filter is applied
 And click on Datasets tab
 And click on more button 
 And checked "With suggestions for rebased/discontinued series" and click on Apply filter button
 #And Scroll down datasets list
 # And Click "Load more" on the bottom of list
  #Then verify Load more button should work and load series
@sprint_4.7
   Scenario:TC_18788_01: Verify note about notification display period
 And Click on notification icon
 And Click on notification tab
 And Observe the text "Your notifications for the last 30 days" on header of the notifications
 Then "Your notifications for the last 30 days" should be present
@sprint_4.7
 Scenario:TC_16831_01: Verify display order of frequencies
 And click on frequency dropdown
 Then check the frequency order as "Daily, Weekly, Monthly, Quarterly, Semiannualy, Yearly, Quinquennially, Decadal"
@sprint_4.7
 Scenario:TC_18783_01: Verify 'Save sorting' button for table visual
 And Create table visual
 And  Click on Edit table
 And Uncheck the Invert and click on Save button
 And Click on date stamp on header
 And click on Save period button
 And Refresh page
 Then sorting should be saved for table visuals
@sprint_4.7
 Scenario:TC_18868_01: Verify color of the sorting icon
 
  And Create table visual
 And  Click on Edit table
 And Uncheck the Invert and click on Save button
 And Click on date stamp on header
 Then color of the icon should take the color of the labels in the header
 @sprint_4.7
 Scenario:TC_18779_01: Verify copyright for save template
 
 And Create table visual
 And Click on Edit table
 And make changes to copyright parameters
 Then Save template icon should be enabled
 @sprint_4.7
 Scenario:TC_18875_01: Verify Move icon for visuals
 And Create two visuals in single view1
 Then Mouse move on visual header1 "Move icon should be displayed and able to drag visuals"
 @sprint_4.7
 Scenario:TC_18717_01:Visual: Custom date selection is skipping last tp to be plotted in visual.
 And Create a chart for series "236997503"
And Click on the timeframe to choose custom dates from "2013" to "2018"
@sprint_4.7
Scenario:TC_18612 :Verify if Zoom option is  removed from edit visual
And Create a chart visual
And Open edit visual
Then Check if zoom option is available
@sprint_4.7
Scenario:TC_18762 :Check the background to the date picker area for specific "one-color" chart styles
And Create a chart visual
And Open edit visual
And Apply a color palette and save "#05999A"
And Check for the applied palette on the visual
@sprint_4.7
Scenario:TC_18643 :User Issue : Search with keyword 'MG' not yielding any results
And Search for keyword "MG"
@sprint_4.7
Scenario:TC_13974_02:User Request : Enhance required in search
And Search for series "PMI;69851501"
@sprint_4.7
 Scenario:TC_19790:When C series is checked in SSP, the selected period should be ALL (by default) to better see the long history
 
  And Open more filter
  And Checked "With historical extension of continuous series" check box and click on Apply filter
  And Open any series with C icon
 And Check for continuous checkbox in SSP window
 Then Time period should change to All by default
 
@sprint_4.7
 Scenario:TC_19675: Enhance Continuous series look&feel in SSP
 
  And Open more filter
  And Checked "With historical extension of continuous series" check box and click on Apply filter
  And Open any series with C icon
 And Check for continuous checkbox in SSP window
 And click on any one continues series and click on continuous series details
 #Then check open ssp of continuous series present in SSP opened
