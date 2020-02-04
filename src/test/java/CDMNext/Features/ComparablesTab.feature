Feature: Verifying comparables tab functionality

Background: 
	Given User has successful logged in 
	And Click on "Comparables" tab
	
@Comparables 
Scenario: TC_Comparables_01:Verify results loading in comparable tab
	Then The total number of series should be displayed in search tab for Section level in comparables tab 	
	
@Comparables 
Scenario: TC_Comparables_02:Verify navigation to insight explorer window
	When Click on "All insights" 
	Then The "Insight Explorer" popup should be appeared 