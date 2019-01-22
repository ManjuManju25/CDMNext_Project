Feature: Filters 

Background:
 	Given User has successful logged in
 	
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
@FilterSearch
=======
@Filter
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_01
Given User enters "GDP"
And   User selects "Source" as "World Bank"
And   User has clicked on "Apply filter"
Then  User verify the search results 

<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
@FilterSearch
=======
@Filter
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_02  
Given User enters "228912101"
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
Scenario: TC_Filters_Search_03
Given User enters "Agar"
And   User selects "Source" as "India Ministry of Commerce and Industry"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results
 
@FilterSearch
Scenario: TC_Filters_Search_04
Given User enters "Agar"
And   User selects "Source" as "India Ministry of Commerce and Industry;Morocco Foreign Exchange Office"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database,India Premium Database"
Then  User verify the search results

@FilterSearch
Scenario: TC_Filters_Search_5
Given User enters "BRJLA"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_06 
Given User enters "228912101"
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
Scenario: TC_Filters_Search_07
=======
Scenario: TC_Filters_Search_06
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "19289601"
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_08
=======
Scenario: TC_Filters_Search_07
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1380601"
And   User selects "Source" as "Brazil Ministry of Development, Industry and Trade"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_09
=======
Scenario: TC_Filters_Search_08
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "245178303"
And   User selects "Source" as "The Central Bank of the Russian Federation"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_10
=======
Scenario: TC_Filters_Search_09
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "213834902"
And   User selects "Source" as "Reserve Bank of India"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_11
=======
Scenario: TC_Filters_Search_10
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "146381801"
And   User selects "Source" as "National Bureau of Statistics"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "China Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_12
Given User enters "322968702"
And   User selects "Source" as "Hong Kong AIA Group Limited"
=======
Scenario: TC_Filters_Search_11
Given User enters "322968702"
And   User selects "Source" as "Hong Kong SAR AIA Group Limited"
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_13
=======
Scenario: TC_Filters_Search_12
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "278655402"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_14
=======
Scenario: TC_Filters_Search_13
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "277207202"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_15
=======
Scenario: TC_Filters_Search_14
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "298772102"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_16
=======
Scenario: TC_Filters_Search_15
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "293654602"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Productivity"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_17
=======
Scenario: TC_Filters_Search_16
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "MDPIJB"
And   User selects "Source" as "Malaysian Rubber Board"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_18
Given User enters "BRAFAC"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
Scenario: TC_Filters_Search_19
=======
Scenario: TC_Filters_Search_17
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRAFAC"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_20
=======
Scenario: TC_Filters_Search_18
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRDLAC"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_21
=======
Scenario: TC_Filters_Search_19
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "IDIAAAG"
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_22
=======
Scenario: TC_Filters_Search_20
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "CZACKC"
And   User selects "Source" as "China Banking and Insurance Regulatory Commission"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "China Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_23
Given User enters "HKIRGAAAUA"
And   User selects "Source" as "Hong Kong AIA Group Limited"
=======
Scenario: TC_Filters_Search_21
Given User enters "HKIRGAAAUA"
And   User selects "Source" as "Hong Kong SAR AIA Group Limited"
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_24
=======
Scenario: TC_Filters_Search_22
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Agar"
And   User selects "Source" as "Morocco Foreign Exchange Office"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_25
=======
Scenario: TC_Filters_Search_23
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "IDIAB"
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_26 
=======
Scenario: TC_Filters_Search_24 
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "261975301"
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_27 
=======
Scenario: TC_Filters_Search_25 
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "GDP"
And   User selects "Date" as "First observation before"
And   User has clicked on "Apply filter"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_28 
=======
Scenario: TC_Filters_Search_26 
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "GDP"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_29 
=======
Scenario: TC_Filters_Search_27 
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "297762801;261968101;179050002;245232002;228912101"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_30
=======
Scenario: TC_Filters_Search_28
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "261968101;261967901;261968401"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_31
=======
Scenario: TC_Filters_Search_29
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "228912101;223399201;223398801"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_32
=======
Scenario: TC_Filters_Search_30
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "227807102;1086201;1086701"
And   User selected "All databases" as "Daily Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_33
=======
Scenario: TC_Filters_Search_31
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1380601;1440601;1440701"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_34
=======
Scenario: TC_Filters_Search_32
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "181692002;194081702;194081802"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_35
=======
Scenario: TC_Filters_Search_33
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "21355201;61149902;61150002"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_36
=======
Scenario: TC_Filters_Search_34
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "245732302;205673602"
And   User selected "All databases" as "Indonesia Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_37
=======
Scenario: TC_Filters_Search_35
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "3782201;94664201"
And   User selected "All databases" as "China Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_38
=======
Scenario: TC_Filters_Search_36
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "323022102;323023302;33241901"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_39
=======
Scenario: TC_Filters_Search_37
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "280621302;79238002"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_40
=======
Scenario: TC_Filters_Search_38
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "291714302;277061402"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_41
=======
Scenario: TC_Filters_Search_39
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "294769102;295423302"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_42
=======
Scenario: TC_Filters_Search_40
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "293611402;293607802"
And   User selected "All databases" as "OECD - Productivity"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_43
=======
Scenario: TC_Filters_Search_41
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "215439102;9552901"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_44
=======
Scenario: TC_Filters_Search_42
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "MDPIJB;VDPACA"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_45
=======
Scenario: TC_Filters_Search_43
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRAFAC;BRJAC"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_46
=======
Scenario: TC_Filters_Search_44
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRDLAC;BRDLAA;BRDLAB"
And   User selected "All databases" as "Daily Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_47
=======
Scenario: TC_Filters_Search_45
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRJAC;BRJLA;BRJLAA"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_48
=======
Scenario: TC_Filters_Search_46
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "IDIAB;IDIAF;IDIAG"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_49
=======
Scenario: TC_Filters_Search_47
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "DKCBG;DKCBGA"
And   User selected "All databases" as "Indonesia Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_50
=======
Scenario: TC_Filters_Search_48
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "CFPAA;CFAPAT"
And   User selected "All databases" as "China Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_51
=======
Scenario: TC_Filters_Search_49
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "NLIRAAAFUL;NLIRAAAFUX;NNRAAAAAA"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_52
=======
Scenario: TC_Filters_Search_50
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRDLAC;CABB"
And   User selected "All databases" as "Brazil Premium Database,China Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_53
=======
Scenario: TC_Filters_Search_51
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "consumer"
And   User selected "All databases" as "China Premium Database"
Then  User verify the search results 
 
@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_54
=======
Scenario: TC_Filters_Search_52
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "GDP"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_55
=======
Scenario: TC_Filters_Search_53
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Tirana"
And   User selected "All databases" as "Daily Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_56
=======
Scenario: TC_Filters_Search_54
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "monetary base"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_57
=======
Scenario: TC_Filters_Search_55
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "household income"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_58
=======
Scenario: TC_Filters_Search_56
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "consumer expenditure"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_59
=======
Scenario: TC_Filters_Search_57
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Construction"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_60
=======
Scenario: TC_Filters_Search_58
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Agar"
And   User selects "Date" as "First observation before"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_61
=======
Scenario: TC_Filters_Search_59
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Changes"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_62
=======
Scenario: TC_Filters_Search_60
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "formation"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_63
=======
Scenario: TC_Filters_Search_61
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Reference;employment"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_64
=======
Scenario: TC_Filters_Search_62
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Reserve"
And   User selected "All databases" as "Global Database,Daily Database,Russia Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_65
=======
Scenario: TC_Filters_Search_63
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "181123202(BRDLAA)"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_66
=======
Scenario: TC_Filters_Search_64
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "233138001(CJLAAA)"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_67
=======
Scenario: TC_Filters_Search_65
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Agar"
And   User selects "Name only" 
Then  User verify the search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_68
=======
Scenario: TC_Filters_Search_66
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "297756101"
And   User selects "Subscribed series only" 
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_69
=======
Scenario: TC_Filters_Search_67
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "293847801"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed series only"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_70
=======
Scenario: TC_Filters_Search_68
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRJAC"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed series only"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_71
=======
Scenario: TC_Filters_Search_69
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Insurance"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Name only" 
And   User selected "All databases" as "China Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_72
=======
Scenario: TC_Filters_Search_70
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "demand"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed series only" 
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_73
=======
Scenario: TC_Filters_Search_71
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "261968101"
And   User selected "All databases" as "World Trend Plus" 
When  User get the topics as "Aggregate: World"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_74
=======
Scenario: TC_Filters_Search_72
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "228912101"
And   User selected "All databases" as "Global Database" 
When  User get the topics as "Albania"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_75
=======
Scenario: TC_Filters_Search_73
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "227807102"
And   User selected "All databases" as "Daily Database" 
When  User get the topics as "Lending Rates"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_76
=======
Scenario: TC_Filters_Search_74
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1380601"
And   User selected "All databases" as "Brazil Premium Database" 
When  User get the topics as "Foreign Trade"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_77
=======
Scenario: TC_Filters_Search_75
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "181692002"
And   User selected "All databases" as "Russia Premium Database" 
When  User get the topics as "Energy Sector"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_78
=======
Scenario: TC_Filters_Search_76
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "21355201"
And   User selected "All databases" as "India Premium Database" 
When  User get the topics as "Investment"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_79
=======
Scenario: TC_Filters_Search_77
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "245732302"
And   User selected "All databases" as "Indonesia Premium Database" 
When  User get the topics as "Business and Economic Survey"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_80
=======
Scenario: TC_Filters_Search_78
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "3782201"
And   User selected "All databases" as "China Premium Database" 
When  User get the topics as "Financial Market"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_81
=======
Scenario: TC_Filters_Search_79
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "279238002"
And   User selected "All databases" as "OECD - Main Economic Indicators" 
When  User get the topics as "Aggregate: 7 Major OECD Countries"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_82
=======
Scenario: TC_Filters_Search_80
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "277061402"
And   User selected "All databases" as "OECD - Economic Outlook" 
When  User get the topics as "Aggregate: Non-OECD Countries"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_83
=======
Scenario: TC_Filters_Search_81
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "295423302"
And   User selected "All databases" as "OECD - National Accounts" 
When  User get the topics as "Aggregate: North American Free Trade Agreement (NAFTA)"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_84
=======
Scenario: TC_Filters_Search_82
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "293607802"
And   User selected "All databases" as "OECD - Productivity" 
When  User get the topics as "OECD Members: Austria"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_85
=======
Scenario: TC_Filters_Search_83
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "brdlac"
And   User selected "All databases" as "Daily Database" 
When  User get the topics as "Lending Rates"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_86
=======
Scenario: TC_Filters_Search_84
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "brjac"
And   User selected "All databases" as "Brazil Premium Database" 
When  User get the topics as "Foreign Trade"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_87
=======
Scenario: TC_Filters_Search_85
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "idiab"
And   User selected "All databases" as "India Premium Database" 
When  User get the topics as "Financial Market"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_88
=======
Scenario: TC_Filters_Search_86
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "DKCBGA"
And   User selected "All databases" as "Indonesia Premium Database" 
When  User get the topics as "Monetary"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_89
=======
Scenario: TC_Filters_Search_87
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "CZACKC"
And   User selected "All databases" as "China Premium Database" 
When  User get the topics as "Insurance Sector"
Then  User verify the results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_90
=======
Scenario: TC_Filters_Search_88
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "194081702"
And   User selects "Unit" as "kg"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_91
=======
Scenario: TC_Filters_Search_89
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "228912101"
And   User selects "Unit" as "ALL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_92
=======
Scenario: TC_Filters_Search_90
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1086701"
And   User selects "Unit" as "BDT/USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_93
=======
Scenario: TC_Filters_Search_91
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1440701"
And   User selects "Unit" as "BRL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_94
=======
Scenario: TC_Filters_Search_92
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "261967901"
And   User selects "Unit" as "%"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_95
=======
Scenario: TC_Filters_Search_93
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "189144402"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_96
=======
Scenario: TC_Filters_Search_94
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "279238002"
And   User selects "Unit" as "2005=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_97
=======
Scenario: TC_Filters_Search_95
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "277061402"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_98
=======
Scenario: TC_Filters_Search_96
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "295423302"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_99
=======
Scenario: TC_Filters_Search_97
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "293607802"
And   User selects "Unit" as "ATS"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Productivity"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_100
=======
Scenario: TC_Filters_Search_98
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "VDPACA"
And   User selects "Unit" as "MN VND/Tael"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_101
=======
Scenario: TC_Filters_Search_99
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRAFAC"
And   User selects "Unit" as "BRL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_102
=======
Scenario: TC_Filters_Search_100
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "WHO001"
And   User selects "Unit" as "Person"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify the search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_103
=======
Scenario: TC_Filters_Search_101
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRDLAC"
And   User selects "Unit" as "% pa"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_104
=======
Scenario: TC_Filters_Search_102
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "IZINO"
And   User selects "Unit" as "2005=1000"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_105
=======
Scenario: TC_Filters_Search_103
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "NLIRCAAAEX"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_106
=======
Scenario: TC_Filters_Search_104
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Agar"
And   User selects "Unit" as "MAD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_107
=======
Scenario: TC_Filters_Search_105
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "228912101"
And   User selects "Unit" as "ALL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_108
=======
Scenario: TC_Filters_Search_106
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "126074608"
And   User selects "Unit" as "Ton"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_109
=======
Scenario: TC_Filters_Search_107
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "commodity"
And   User selects "Frequency" as "Daily"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_110
=======
Scenario: TC_Filters_Search_108
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "estate"
And   User selects "Frequency" as "Weekly"
And   User has clicked on "Apply filter"
Then  User verify the search results    

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_111
=======
Scenario: TC_Filters_Search_109
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Selenium"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_112
=======
Scenario: TC_Filters_Search_110
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Selenium"
And   User selects "Frequency" as "Quarterly"
And   User has clicked on "Apply filter"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_113
=======
Scenario: TC_Filters_Search_111
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "capital"
And   User selects "Frequency" as "Semiannually"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_114
=======
Scenario: TC_Filters_Search_112
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Selenium"
And   User selects "Frequency" as "Yearly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_115
=======
Scenario: TC_Filters_Search_113
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Rate"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_116
=======
Scenario: TC_Filters_Search_114
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "126074608"
And   User selects "Unit" as "Ton"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_117
=======
Scenario: TC_Filters_Search_115
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "242994803"
And   User selects "Unit" as "RUB"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_118
=======
Scenario: TC_Filters_Search_116
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "3782201"
And   User selects "Unit" as "19Dec1990=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "China Premium Database"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_119
=======
Scenario: TC_Filters_Search_117
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1055401 (BAEAE)"
And   User selects "Region" as "Asia Pacific"
Then  User should get the search results 
 
@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_120
=======
Scenario: TC_Filters_Search_118
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1382601 (BRJAEN)"
And   User selects "Region" as "Americas"
Then  User should get the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_121
=======
Scenario: TC_Filters_Search_119
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "121587008"
And   User selects "Region" as "Europe"
Then  User should get the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_122
=======
Scenario: TC_Filters_Search_120
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "99459607"
And   User selects "Region" as "Middle East"
Then  User should get the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_123
=======
Scenario: TC_Filters_Search_121
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "132330608"
And   User selects "Region" as "Africa"
Then  User should get the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_124
=======
Scenario: TC_Filters_Search_122
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "225939502 (EJGAADH)"
And   User selects "Region" as "G7"
Then  User should get the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_125
=======
Scenario: TC_Filters_Search_123
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "68951101 (BRFGG)"
And   User selects "Region" as "G20"
Then  User should get the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_126
=======
Scenario: TC_Filters_Search_124
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "61540402 (BNAAAAA)"
And   User selects "Region" as "ASEAN"
Then  User should get the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_127
=======
Scenario: TC_Filters_Search_125
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "230792902 (IAPAFABH)"
And   User selects "Region" as "BRIC"
Then  User should get the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_128
Given User enters "230792902 (IAPAFABH)"
And   User selects "Region" as "BRIC"
Then  User should get the search results 

@FilterSearch
Scenario: TC_Filters_Search_129
=======
Scenario: TC_Filters_Search_126
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1380601"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_130
=======
Scenario: TC_Filters_Search_127
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "money"
And   User selects "Subscribed series only" 
And   User selects "Frequency" as "Quarterly"
And   User selects "Source" as "International Monetary Fund"
And   User selects "Unit" as "MUR"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 
 
@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_131
=======
Scenario: TC_Filters_Search_128
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "money"
And   User selects "Name only" 
And   User selects "Frequency" as "Quarterly"
And   User selects "Unit" as "MUR"
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 
 
@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_132
=======
Scenario: TC_Filters_Search_129
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Exchange AND Rate"
Then  User verifies Filter search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_133
=======
Scenario: TC_Filters_Search_130
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Forecast OR Low"
Then  User verifies Filter search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_134
=======
Scenario: TC_Filters_Search_131
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Exchange Rate"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_135
=======
Scenario: TC_Filters_Search_132
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Res*"
Then  User verifies Filter search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_136
=======
Scenario: TC_Filters_Search_133
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Seleni*"
And   User selected "All databases" as "India Premium Database"
Then  User verifies Filter search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_137
=======
Scenario: TC_Filters_Search_134
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Se*enium"
Then  User verifies Filter search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_138
=======
Scenario: TC_Filters_Search_135
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "aga?"
Then  User verifies Filter search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_139
=======
Scenario: TC_Filters_Search_136
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "ag?r"
Then  User verifies Filter search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_140
=======
Scenario: TC_Filters_Search_137
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "2137320*"
Then  User verifies Filter search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_141
=======
Scenario: TC_Filters_Search_138
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "1380*1"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verifies Filter search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_142
=======
Scenario: TC_Filters_Search_139
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "BRDLA*"
Then  User verifies Filter search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_143
=======
Scenario: TC_Filters_Search_140
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "IZI*O"
Then  User verifies Filter search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_144
=======
Scenario: TC_Filters_Search_141
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "*ZINO"
Then  User verifies Filter search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_145
=======
Scenario: TC_Filters_Search_142
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "2137320?"
Then  User verifies Filter search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_146
=======
Scenario: TC_Filters_Search_143
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "?1373201"
And   User selected "All databases" as "India Premium Database"
Then  User verifies Filter search results

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_147
=======
Scenario: TC_Filters_Search_144
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "mfg"
And   User selects "Unit" as "2005=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_148
=======
Scenario: TC_Filters_Search_145
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "mfg"
And   User selects "Source" as "Federal Statistics Office Germany"
And   User has clicked on "Apply filter"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_149
=======
Scenario: TC_Filters_Search_146
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "mfg"
And   User selects "Frequency" as "Quarterly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_150
=======
Scenario: TC_Filters_Search_147
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "mfg"
And   User selects "Frequency" as "Monthly"
And   User selects "Source" as "Federal Statistics Office Germany"
And   User selects "Unit" as "2005=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_151
Given User enters "account"
And   User selects "Frequency" as "Daily"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
Scenario: TC_Filters_Search_152
=======
Scenario: TC_Filters_Search_148
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "GDP"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_153
=======
Scenario: TC_Filters_Search_149
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "GDP"
And   User selects "Frequency" as "Quarterly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_154
=======
Scenario: TC_Filters_Search_150
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "Capital"
And   User selects "Frequency" as "Semiannually"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_155
=======
Scenario: TC_Filters_Search_151
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "GDP"
And   User selects "Frequency" as "Yearly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_156
=======
Scenario: TC_Filters_Search_152
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "account"
And   User selects "Frequency" as "Daily;Weekly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_157
=======
Scenario: TC_Filters_Search_153
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "account"
And   User selects "Frequency" as "Monthly;Quarterly"
And   User has clicked on "Apply filter"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_158
=======
Scenario: TC_Filters_Search_154
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "account"
And   User selects "Frequency" as "Daily;Yearly"
And   User has clicked on "Apply filter"
Then  User verify the search results  

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_159
=======
Scenario: TC_Filters_Search_155
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "money"
And   User selects "Date" as "First observation before;Last observation after"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_160
=======
Scenario: TC_Filters_Search_156
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "money"
And   User selects "Subscribed series only" 
Then  User verify the search results 

@FilterSearch
<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
Scenario: TC_Filters_Search_161
=======
Scenario: TC_Filters_Search_157
>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
Given User enters "money"
And   User selects "New only" 
Then  User verify the search results

<<<<<<< HEAD:src/test/java/CDMNext/Features/FiltersModule.feature
=======

>>>>>>> search:src/test/java/CDMNext/Features/FiltersModule.feature
