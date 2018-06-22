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

Scenario: TC_Filters_Search_05 
Given User enters Series id "261975301"
And   User clicks on Filters 
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_06 
Given User enters Series id "228912101"
And   User clicks on Filters 
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_07
Given User enters Series id "19289601"
And   User clicks on Filters 
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Daily Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_08
Given User enters Series id "1380601"
And   User clicks on Filters 
And   User selects "Source" as "Brazil Ministry of development, Industry and foreign trade"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_09
Given User enters Series id "245178303"
And   User clicks on Filters 
And   User selects "Source" as "The Central Bank of the Russian Federation"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_10
Given User enters Series id "213834902"
And   User clicks on Filters 
And   User selects "Source" as "Reserve Bank of India"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_11
Given User enters Series id "146381801"
And   User clicks on Filters 
And   User selects "Source" as "China National Bureau of Statistics"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_12
Given User enters Series id "322968702"
And   User clicks on Filters 
And   User selects "Source" as "Hong Kong AIA Group limited"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Global Sector"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_13
Given User enters Series id "278655402"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_14
Given User enters Series id "277207202"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_15
Given User enters Series id "298772102"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_16
Given User enters Series id "293654602"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "OECD - Productivity"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_17
Given User enters Series Tag "MDPIJB"
And   User clicks on Filters 
And   User selects "Source" as "Malaysian Rubber Exchange"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_18
Given User enters Series Tag "BRAFAC"
And   User clicks on Filters 
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_19
Given User enters Series Tag "BRAFAC"
And   User clicks on Filters 
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_20
Given User enters Series Tag "BRDLAC"
And   User clicks on Filters 
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Daily Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_21
Given User enters Series Tag "IDIAAAG"
And   User clicks on Filters 
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_22
Given User enters Series Tag "CZACKC"
And   User clicks on Filters 
And   User selects "Source" as "China Banking and Insurance regulatory commision"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_23
Given User enters Series Tag "HKIRGAAAUA"
And   User clicks on Filters 
And   User selects "Source" as "Hong Kong AIA Group Limited"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_24
Given User enters Keyword "Agar"
And   User clicks on Filters 
And   User selects "Source" as "Morocco Foreign Exchange Office"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_25
Given User enters Keyword "IDIAB"
And   User clicks on Filters 
And   User selects "Source" as "India Bombay stock exchange Limited"
And   User has clicked on "Apply Filter"
And   User selects "All databases" as "India Premium Database"
Then  User verify Filter search results 