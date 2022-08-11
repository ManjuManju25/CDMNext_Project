Feature: Verifying Covid Filter Functionality
@Covid19
Scenario:TC_CovidFilter_02:Verify the Popup is displayed and Covid_19
Given Navigates to CEIC page verify the Covid Dropdown is displayed and click
And Clicking on "COVID-19"
Then Getting list of series "Series id" 
@Covid19
Scenario:TC_CovidFilter_02:Verify the Popup is displayed and Impact of COVID-19
Given Navigates to CEIC page verify the Covid Dropdown is displayed and click
And Clicking on "Impact of COVID-19"
Then Getting list of series "Series id"
@Covid19
Scenario:TC_CovidFilter_02:Verify the Popup is displayed and Impact of COVID-19
Given Navigates to CEIC page verify the Covid Dropdown is displayed and click
And Clicking on both "Impact of COVID-19" "COVID-19"
Then Getting list of series "Series id"