Feature: filters 

Background:
 	Given User has successful logged in

Scenario: TC_Filters_Search_01
And   User clicks on Filters 
And   User selects "Source" as "World Bank"
And   User has clicked on "Apply Filter"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_02  
Given User enters Series id "228912101"
And   User clicks on Filters 
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_03
Given User enters Keyword "Agar"
And   User clicks on Filters
And   User selects "Source" as "India Ministry of Commerce and Industry"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_04
Given User enters Keyword "Agar"
And   User clicks on Filters
And   User selects "Source" as "India Ministry of Commerce and Industry,Morrocco Foreign Exchange Office"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Global Database,India Premium Database"
Then  User verify Filter search results
