Feature: filters 

Background:
 	Given User has successful logged in

Scenario: TC_Filters_Search_01
And   User clicks on Filters 
And   User selects "Source" as "World Bank"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_02  
Given User enters "228912101"
And   User clicks on Filters 
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_03
Given User enters "Agar"
And   User clicks on Filters
And   User selects "Source" as "India Ministry of Commerce and Industry"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_04
Given User enters "Agar"
And   User clicks on Filters
And   User selects "Source" as "India Ministry of Commerce and Industry;Morocco Foreign Exchange Office"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Global Database,India Premium Database"
Then  User verify Filter search results

Scenario: TC_Filters_Search_5
Given User enters "BRJLA"
And   User clicks on Filters 
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_06 
Given User enters "228912101"
And   User clicks on Filters 
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_07
Given User enters "19289601"
And   User clicks on Filters 
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_08
Given User enters "1380601"
And   User clicks on Filters 
And   User selects "Source" as "Brazil Ministry of Development, Industry And Trade"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_09
Given User enters "245178303"
And   User clicks on Filters 
And   User selects "Source" as "The Central Bank of the Russian Federation"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_10
Given User enters "213834902"
And   User clicks on Filters 
And   User selects "Source" as "Reserve Bank of India"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_11
Given User enters "146381801"
And   User clicks on Filters 
And   User selects "Source" as "China National Bureau of Statistics"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_12
Given User enters "322968702"
And   User clicks on Filters 
And   User selects "Source" as "Hong Kong AIA Group Limited"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_13
Given User enters "278655402"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_14
Given User enters "277207202"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_15
Given User enters "298772102"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_16
Given User enters "293654602"
And   User clicks on Filters 
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "OECD - Productivity"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_17
Given User enters "MDPIJB"
And   User clicks on Filters 
And   User selects "Source" as "Malaysian Rubber Board"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_18
Given User enters "BRAFAC"
And   User clicks on Filters 
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_19
Given User enters "BRAFAC"
And   User clicks on Filters 
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_20
Given User enters "BRDLAC"
And   User clicks on Filters 
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_21
Given User enters "IDIAAAG"
And   User clicks on Filters 
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_22
Given User enters "CZACKC"
And   User clicks on Filters 
And   User selects "Source" as "China Banking and Insurance Regulatory Commission"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_23
Given User enters "HKIRGAAAUA"
And   User clicks on Filters 
And   User selects "Source" as "Hong Kong AIA Group Limited"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_24
Given User enters "Agar"
And   User clicks on Filters 
And   User selects "Source" as "Morocco Foreign Exchange Office"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_25
Given User enters "IDIAB"
And   User clicks on Filters 
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
When  User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

#Scenario: TC_Filters_Search_26 
#Given User enters "261975301"
#And   User clicks on Filters 
#And   User selects "Source" as "International Monetary Fund - World Economic Outlook"
#And   User has clicked on "Apply filter"
#When  User selected "All databases" as "World Trend Plus"
#Then  User verify Filter search results 

Scenario: TC_Filters_Search_27 
Given User enters "GDP"
And   User clicks on Filters 
And   User selects "Date" as "First observation before"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_28 
Given User enters "GDP"
And   User clicks on Filters 
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_29 
Given User enters "297762801;261968101;179050002;245232002;228912101"
And   User clicks on Filters 
Then  User verify Filter search results 

Scenario: TC_Filters_Search_30
Given User enters "261968101;261967901;261968401"
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_31
Given User enters "228912101;223399201;223398801"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_32
Given User enters "227807102;1086201;1086701"
When  User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_33
Given User enters "1380601;1440601;1440701"
When  User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_34
Given User enters "181692002;194081702;194081802"
When  User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_35
Given User enters "21355201;61149902;61150002"
When  User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_36
Given User enters "245732302;205673602"
When  User selected "All databases" as "Indonesia Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_37
Given User enters "3782201;94664201"
When  User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_38
Given User enters "323022102;323023302;33241901"
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_39
Given User enters "280621302;79238002"
When  User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_40
Given User enters "291714302;277061402"
When  User selected "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_41
Given User enters "294769102;295423302"
When  User selected "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_42
Given User enters "293611402;293607802"
When  User selected "All databases" as "OECD - Productivity"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_43
Given User enters "215439102;9552901"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_44
Given User enters "MDPIJB;VDPACA"
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_45
Given User enters "BRAFAC;BRJAC"
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_46
Given User enters "BRDLAC;BRDLAA;BRDLAB"
When  User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_47
Given User enters "BRJAC;BRJLA;BRJLAA"
When  User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_48
Given User enters "IDIAB;IDIAF;IDIAG"
When  User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_49
Given User enters "DKCBG;DKCBGA"
When  User selected "All databases" as "Indonesia Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_50
Given User enters "CFPAA;CFAPAT"
When  User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_51
Given User enters "NLIRAAAFUL;NLIRAAAFUX;NNRAAAAAA"
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_52
Given User enters "BRDLAC;CABB"
When  User selected "All databases" as "Brazil Premium Database,China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_53
Given User enters "consumer"
When  User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 
 
Scenario: TC_Filters_Search_54
Given User enters "GDP"
And   User clicks on Filters 
When  User selected "All databases" as "Global Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_55
Given User enters "Tirana"
When  User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_56
Given User enters "monetary base"
When  User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_57
Given User enters "household income"
And   User clicks on Filters 
When  User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_58
Given User enters "consumer expenditure"
When  User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_59
Given User enters "Construction"
And   User clicks on Filters 
When  User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_60
Given User enters "automobile"
When  User selected "All databases" as "Global Sector"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_61
Given User enters "Changes"
When  User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_62
Given User enters "formation"
And   User clicks on Filters
When  User selected "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_63
Given User enters "Reference;employment"
And   User clicks on Filters
When  User selected "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_64
Given User enters "Reserve"
And   User clicks on Filters 
When  User selected "All databases" as "Global Database,Daily Database,Russia Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_65
Given User enters "181123202(BRDLAA)"
And   User clicks on Filters
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_66
Given User enters "233138001(CJLAAA)"
And   User clicks on Filters
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_67
Given User enters "Agar"
And   User clicks on Filters
And   User selects "Name only" 
Then  User verify Filter search results

Scenario: TC_Filters_Search_68
Given User enters "297756101"
And   User clicks on Filters
And   User selects "Subscribed only" 
Then  User verify Filter search results 

Scenario: TC_Filters_Search_69
Given User enters "293847801"
And   User clicks on Filters
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed only"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_70
Given User enters "BRJAC"
And   User clicks on Filters
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed only"
When  User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_71
Given User enters "Insurance"
And   User clicks on Filters
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Name only" 
When  User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

Scenario: TC_Filters_Search_72
Given User enters "demand"
And   User clicks on Filters
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed only" 
Then  User verify Filter search results 
 
