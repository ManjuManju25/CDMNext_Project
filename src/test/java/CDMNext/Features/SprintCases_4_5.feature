Feature: SprintCases_4.5 feature
@sprint_4.5
 Scenario:TC_4.5_18478_01: Verify watchlist notification switch OFF when main notification is OFF
 And Open preference dropdown
 And Turn 'OFF' Notification under profile dropdow
 And click on Watchlist
 Then verify Enable all button should be turn 'OFF' and notifcaiton should not displayed
 @sprint_4.5
 Scenario:TC_4.5_17675_02: Verify watchlist notification switch ON when main notification is ON
 And Open preference dropdown
 And Turn 'ON' Notification under profile dropdow
 And click on Watchlist
 Then verify Enable all button should be turn 'ON' and notifcaiton should not displayed
 @sprint_4.5
 Scenario:TC_4.5_17675_03: Verify turning ON/OFF watchlist notification will sync with main notification
 And Open preference dropdown
 And click on turn 'OFF' in enable all button
  And click on Watchlist
 And Check Notification 'ON' in the setting under profile dropdown
 Then verify notification turn 'ON' setting on watchlist should not sync with main notification under profile dropdown
 @sprint_4.5
Scenario:TC-18256 :Verify China City grouping in SSP
And Create SSP for series "367487277"
And Verify the Region "Banan" 
@sprint_4.5
Scenario:TC-18218 :Verify the icon for watchlist notification
And Click on the bell icon on right top corner
And Go to notifications tab
Then Check for watchlist notification  
@sprint_4.5
Scenario:TC-17937: Verify if number format is listed for pie chart
And Create a pie chart
And Click on edit visual
Then Check for the number format option 
