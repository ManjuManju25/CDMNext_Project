Feature: filters 

Background:
 	Given User has successful logged in
 	
@SourceFilter
Scenario: TC_Filters_Search_01
And   User selects "Source" as "World Bank"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_02  
Given User enters "228912101"
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_03
Given User enters "Agar"
And   User selects "Source" as "India Ministry of Commerce and Industry"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results
 
@SourceFilter
Scenario: TC_Filters_Search_04
Given User enters "Agar"
And   User selects "Source" as "India Ministry of Commerce and Industry;Morocco Foreign Exchange Office"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database,India Premium Database"
Then  User verify Filter search results

@SourceFilter
Scenario: TC_Filters_Search_5
Given User enters "BRJLA"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_06 
Given User enters "228912101"
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_07
Given User enters "19289601"
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_08
Given User enters "1380601"
And   User selects "Source" as "Brazil Ministry of Development, Industry and Trade"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_09
Given User enters "245178303"
And   User selects "Source" as "The Central Bank of the Russian Federation"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_10
Given User enters "213834902"
And   User selects "Source" as "Reserve Bank of India"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_11
Given User enters "146381801"
And   User selects "Source" as "China National Bureau of Statistics"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_12
Given User enters "322968702"
And   User selects "Source" as "Hong Kong AIA Group Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_13
Given User enters "278655402"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_14
Given User enters "277207202"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_15
Given User enters "298772102"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_16
Given User enters "293654602"
And   User selects "Source" as "International Organisation for Economic Co-operation and Development"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Productivity"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_17
Given User enters "MDPIJB"
And   User selects "Source" as "Malaysian Rubber Board"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_18
Given User enters "BRAFAC"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_19
Given User enters "BRAFAC"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_20
Given User enters "BRDLAC"
And   User selects "Source" as "Central Bank of Brazil"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_21
Given User enters "IDIAAAG"
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_22
Given User enters "CZACKC"
And   User selects "Source" as "China Banking and Insurance Regulatory Commission"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_23
Given User enters "HKIRGAAAUA"
And   User selects "Source" as "Hong Kong AIA Group Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_24
Given User enters "Agar"
And   User selects "Source" as "Morocco Foreign Exchange Office"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_25
Given User enters "IDIAB"
And   User selects "Source" as "India Bombay Stock Exchange Limited"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

@SourceFilter
Scenario: TC_Filters_Search_26 
Given User enters "261975301"
And   User selects "Source" as "International Monetary Fund - World Economic Outlook"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@DateFilter
Scenario: TC_Filters_Search_27 
Given User enters "GDP"
And   User selects "Date" as "First observation before"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

@FrequencyFilter
Scenario: TC_Filters_Search_28 
Given User enters "GDP"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_29 
Given User enters "297762801;261968101;179050002;245232002;228912101"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_30
Given User enters "261968101;261967901;261968401"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_31
Given User enters "228912101;223399201;223398801"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_32
Given User enters "227807102;1086201;1086701"
And   User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_33
Given User enters "1380601;1440601;1440701"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_34
Given User enters "181692002;194081702;194081802"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_35
Given User enters "21355201;61149902;61150002"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_36
Given User enters "245732302;205673602"
And   User selected "All databases" as "Indonesia Premium Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_37
Given User enters "3782201;94664201"
And   User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_38
Given User enters "323022102;323023302;33241901"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_39
Given User enters "280621302;79238002"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_40
Given User enters "291714302;277061402"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_41
Given User enters "294769102;295423302"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_42
Given User enters "293611402;293607802"
And   User selected "All databases" as "OECD - Productivity"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_43
Given User enters "215439102;9552901"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_44
Given User enters "MDPIJB;VDPACA"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_45
Given User enters "BRAFAC;BRJAC"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_46
Given User enters "BRDLAC;BRDLAA;BRDLAB"
And   User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_47
Given User enters "BRJAC;BRJLA;BRJLAA"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_48
Given User enters "IDIAB;IDIAF;IDIAG"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_49
Given User enters "DKCBG;DKCBGA"
And   User selected "All databases" as "Indonesia Premium Database"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_50
Given User enters "CFPAA;CFAPAT"
And   User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_51
Given User enters "NLIRAAAFUL;NLIRAAAFUX;NNRAAAAAA"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_52
Given User enters "BRDLAC;CABB"
And   User selected "All databases" as "Brazil Premium Database,China Premium Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_53
Given User enters "consumer"
And   User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 
 
@KeywordSearch
Scenario: TC_Filters_Search_54
Given User enters "GDP"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_55
Given User enters "Tirana"
And   User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_56
Given User enters "monetary base"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_57
Given User enters "household income"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_58
Given User enters "consumer expenditure"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_59
Given User enters "Construction"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@DateFilter
Scenario: TC_Filters_Search_60
Given User enters "Agar"
And   User selects "Date" as "First observation before"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_61
Given User enters "Changes"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_62
Given User enters "formation"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_63
Given User enters "Reference;employment"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_64
Given User enters "Reserve"
And   User selected "All databases" as "Global Database,Daily Database,Russia Premium Database"
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_65
Given User enters "181123202(BRDLAA)"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 
#
@SeriesIDSearch
Scenario: TC_Filters_Search_66
Given User enters "233138001(CJLAAA)"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_67
Given User enters "Agar"
And   User selects "Name only" 
Then  User verify Filter search results

@SeriesIDSearch
Scenario: TC_Filters_Search_68
Given User enters "297756101"
And   User selects "Subscribed only" 
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_69
Given User enters "293847801"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed only"
Then  User verify Filter search results 

@SeriesTagSearch
Scenario: TC_Filters_Search_70
Given User enters "BRJAC"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed only"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_71
Given User enters "Insurance"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Name only" 
And   User selected "All databases" as "China Premium Database"
Then  User verify Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_72
Given User enters "demand"
And   User selects "Status" as "Active"
And   User has clicked on "Apply filter"
And   User selects "Subscribed only" 
Then  User verify Filter search results 

@SeriesIDSearch
Scenario: TC_Filters_Search_73
Given User enters "261968101"
And   User selected "All databases" as "World Trend Plus" 
When  User get the topics as "Aggregate: World"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_74
Given User enters "228912101"
And   User selected "All databases" as "Global Database" 
When  User get the topics as "Albania"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_75
Given User enters "227807102"
And   User selected "All databases" as "Daily Database" 
When  User get the topics as "Lending Rates"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_76
Given User enters "1380601"
And   User selected "All databases" as "Brazil Premium Database" 
When  User get the topics as "Foreign Trade"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_77
Given User enters "181692002"
And   User selected "All databases" as "Russia Premium Database" 
When  User get the topics as "Energy Sector"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_78
Given User enters "21355201"
And   User selected "All databases" as "India Premium Database" 
When  User get the topics as "Investment"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_79
Given User enters "245732302"
And   User selected "All databases" as "Indonesia Premium Database" 
When  User get the topics as "Business and Economic Survey"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_80
Given User enters "3782201"
And   User selected "All databases" as "China Premium Database" 
When  User get the topics as "Financial Market"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_81
Given User enters "279238002"
And   User selected "All databases" as "OECD - Main Economic Indicators" 
When  User get the topics as "Aggregate: 7 Major OECD Countries"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_82
Given User enters "277061402"
And   User selected "All databases" as "OECD - Economic Outlook" 
When  User get the topics as "Aggregate: Non-OECD Countries"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_83
Given User enters "295423302"
And   User selected "All databases" as "OECD - National Accounts" 
When  User get the topics as "Aggregate: North American Free Trade Agreement (NAFTA)"
Then  User verify the results 

@SeriesIDSearch
Scenario: TC_Filters_Search_84
Given User enters "293607802"
And   User selected "All databases" as "OECD - Productivity" 
When  User get the topics as "OECD Members: Austria"
Then  User verify the results 

@SeriesTagSearch
Scenario: TC_Filters_Search_85
Given User enters "brdlac"
And   User selected "All databases" as "Daily Database" 
When  User get the topics as "Lending Rates"
Then  User verify the results 

@SeriesTagSearch
Scenario: TC_Filters_Search_86
Given User enters "brjac"
And   User selected "All databases" as "Brazil Premium Database" 
When  User get the topics as "Foreign Trade"
Then  User verify the results 

@SeriesTagSearch
Scenario: TC_Filters_Search_87
Given User enters "idiab"
And   User selected "All databases" as "India Premium Database" 
When  User get the topics as "Financial Market"
Then  User verify the results 

@SeriesTagSearch
Scenario: TC_Filters_Search_88
Given User enters "DKCBGA"
And   User selected "All databases" as "Indonesia Premium Database" 
When  User get the topics as "Monetary"
Then  User verify the results 

@SeriesTagSearch
Scenario: TC_Filters_Search_89
Given User enters "CZACKC"
And   User selected "All databases" as "China Premium Database" 
When  User get the topics as "Insurance Sector"
Then  User verify the results 

@UnitFilter
Scenario: TC_Filters_Search_90
Given User enters "194081702"
And   User selects "Unit" as "kg"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_91
Given User enters "228912101"
And   User selects "Unit" as "ALL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_92
Given User enters "1086701"
And   User selects "Unit" as "BDT/USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_93
Given User enters "1440701"
And   User selects "Unit" as "BRL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_94
Given User enters "261967901"
And   User selects "Unit" as "%"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_95
Given User enters "189144402"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_96
Given User enters "279238002"
And   User selects "Unit" as "2005=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Main Economic Indicators"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_97
Given User enters "277061402"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Economic Outlook"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_98
Given User enters "295423302"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - National Accounts"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_99
Given User enters "293607802"
And   User selects "Unit" as "ATS"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "OECD - Productivity"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_100
Given User enters "VDPACA"
And   User selects "Unit" as "MN VND/Tael"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_101
Given User enters "BRAFAC"
And   User selects "Unit" as "BRL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_102
Given User enters "WHO001"
And   User selects "Unit" as "Person"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Daily Database"
Then  User verify Filter search results

@UnitFilter
Scenario: TC_Filters_Search_103
Given User enters "BRDLAC"
And   User selects "Unit" as "% pa"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results  

@UnitFilter
Scenario: TC_Filters_Search_104
Given User enters "IZINO"
And   User selects "Unit" as "2005=1000"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "India Premium Database"
Then  User verify Filter search results  

@UnitFilter
Scenario: TC_Filters_Search_105
Given User enters "NLIRCAAAEX"
And   User selects "Unit" as "USD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "World Trend Plus"
Then  User verify Filter search results  

@UnitFilter
Scenario: TC_Filters_Search_106
Given User enters "Agar"
And   User selects "Unit" as "MAD"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_107
Given User enters "228912101"
And   User selects "Unit" as "ALL"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results

@UnitFilter
Scenario: TC_Filters_Search_108
Given User enters "126074608"
And   User selects "Unit" as "Ton"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results

@FrequencyFilter
Scenario: TC_Filters_Search_109
Given User enters "commodity"
And   User selects "Frequency" as "Daily"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_110
Given User enters "estate"
And   User selects "Frequency" as "Weekly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results    

@FrequencyFilter
Scenario: TC_Filters_Search_111
Given User enters "Selenium"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_112
Given User enters "Selenium"
And   User selects "Frequency" as "Quarterly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

@FrequencyFilter
Scenario: TC_Filters_Search_113
Given User enters "capital"
And   User selects "Frequency" as "Semiannually"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_114
Given User enters "Selenium"
And   User selects "Frequency" as "Yearly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_115
Given User enters "Rate"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_116
Given User enters "126074608"
And   User selects "Unit" as "Ton"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@UnitFilter
Scenario: TC_Filters_Search_117
Given User enters "242994803"
And   User selects "Unit" as "RUB"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Russia Premium Database"
Then  User verify Filter search results  

@UnitFilter
Scenario: TC_Filters_Search_118
Given User enters "3782201"
And   User selects "Unit" as "19Dec1990=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "China Premium Database"
Then  User verify Filter search results  

@RegionFilter
Scenario: TC_Filters_Search_119
Given User enters "1055401 (BAEAE)"
And   User selects "Region" as "Asia Pacific"
Then  User should get the search results 
 
@RegionFilter
Scenario: TC_Filters_Search_120
Given User enters "1382601 (BRJAEN)"
And   User selects "Region" as "Americas"
Then  User should get the search results  

@RegionFilter
Scenario: TC_Filters_Search_121
Given User enters "121587008"
And   User selects "Region" as "Europe"
Then  User should get the search results  

@RegionFilter
Scenario: TC_Filters_Search_122
Given User enters "99459607"
And   User selects "Region" as "Middle East"
Then  User should get the search results  

@RegionFilter
Scenario: TC_Filters_Search_123
Given User enters "132330608"
And   User selects "Region" as "Africa"
Then  User should get the search results  

@RegionFilter
Scenario: TC_Filters_Search_124
Given User enters "225939502 (EJGAADH)"
And   User selects "Region" as "G7"
Then  User should get the search results  

@RegionFilter
Scenario: TC_Filters_Search_125
Given User enters "68951101 (BRFGG)"
And   User selects "Region" as "G20"
Then  User should get the search results  

@RegionFilter
Scenario: TC_Filters_Search_126
Given User enters "61540402 (BNAAAAA)"
And   User selects "Region" as "ASEAN"
Then  User should get the search results 

@RegionFilter
Scenario: TC_Filters_Search_127
Given User enters "230792902 (IAPAFABH)"
And   User selects "Region" as "BRIC"
Then  User should get the search results  

@RegionFilter
Scenario: TC_Filters_Search_128
Given User enters "230792902 (IAPAFABH)"
And   User selects "Region" as "BRIC"
Then  User should get the search results 

@FrequencyFilter
Scenario: TC_Filters_Search_129
Given User enters "1380601"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verify Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_130
Given User enters "money"
And   User selects "Subscribed only" 
And   User selects "Frequency" as "Quarterly"
And   User selects "Source" as "International Monetary Fund"
And   User selects "Unit" as "MUR"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 
 
@KeywordSearch
Scenario: TC_Filters_Search_131
Given User enters "money"
And   User selects "Name only" 
And   User selects "Frequency" as "Quarterly"
And   User selects "Unit" as "MUR"
And   User selects "Source" as "International Monetary Fund"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 
 
@KeywordSearch
Scenario: TC_Filters_Search_132
Given User enters "Exchange AND Rate"
Then  User verifies Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_133
Given User enters "Forecast OR Low"
Then  User verifies Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_134
Given User enters "Exchange Rate"
Then  User verify Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_135
Given User enters "Res*"
Then  User verifies Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_136
Given User enters "Seleni*"
And   User selected "All databases" as "India Premium Database"
Then  User verifies Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_137
Given User enters "Se*enium"
Then  User verifies Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_138
Given User enters "aga?"
And   User selects "Name only" 
Then  User verifies Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_139
Given User enters "ag?r"
And   User selects "Name only" 
Then  User verifies Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_140
Given User enters "2137320*"
Then  User verifies Filter search results 

@KeywordSearch
Scenario: TC_Filters_Search_141
Given User enters "1380*1"
And   User selected "All databases" as "Brazil Premium Database"
Then  User verifies Filter search results

@KeywordSearch
Scenario: TC_Filters_Search_142
Given User enters "BRDLA*"
Then  User verifies Filter search results

@KeywordSearch
Scenario: TC_Filters_Search_143
Given User enters "IZI*O"
Then  User verifies Filter search results

@KeywordSearch
Scenario: TC_Filters_Search_144
Given User enters "*ZINO"
Then  User verifies Filter search results

@KeywordSearch
Scenario: TC_Filters_Search_145
Given User enters "2137320?"
Then  User verifies Filter search results

@KeywordSearch
Scenario: TC_Filters_Search_146
Given User enters "?1373201"
And   User selected "All databases" as "India Premium Database"
Then  User verifies Filter search results

@UnitFilter
Scenario: TC_Filters_Search_147
Given User enters "mfg"
And   User selects "Unit" as "2005=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results  

@SourceFilter
Scenario: TC_Filters_Search_148
Given User enters "mfg"
And   User selects "Source" as "Federal Statistics Office Germany"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

@FrequencyFilter
Scenario: TC_Filters_Search_149
Given User enters "mfg"
And   User selects "Frequency" as "Quarterly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@KeywordSearch
Scenario: TC_Filters_Search_150
Given User enters "mfg"
And   User selects "Frequency" as "Monthly"
And   User selects "Source" as "Federal Statistics Office Germany"
And   User selects "Unit" as "2005=100"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 

@FrequencyFilter
Scenario: TC_Filters_Search_151
Given User enters "account"
And   User selects "Frequency" as "Daily"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_152
Given User enters "GDP"
And   User selects "Frequency" as "Monthly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_153
Given User enters "GDP"
And   User selects "Frequency" as "Quarterly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_154
Given User enters "Capital"
And   User selects "Frequency" as "Semiannually"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_155
Given User enters "GDP"
And   User selects "Frequency" as "Yearly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_156
Given User enters "account"
And   User selects "Frequency" as "Daily;Weekly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@FrequencyFilter
Scenario: TC_Filters_Search_157
Given User enters "account"
And   User selects "Frequency" as "Monthly;Quarterly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results 

@FrequencyFilter
Scenario: TC_Filters_Search_158
Given User enters "account"
And   User selects "Frequency" as "Daily;Yearly"
And   User has clicked on "Apply filter"
Then  User verify Filter search results  

@DateFilter
Scenario: TC_Filters_Search_159
Given User enters "money"
And   User selects "Date" as "First observation before,Last observation after"
And   User has clicked on "Apply filter"
And   User selected "All databases" as "Global Database"
Then  User verify Filter search results 
