Feature: FilterSearch

  @FilterSearch
  Scenario: TC_Filters_Search_01
    Given User enters "GDP"
    And User selects "Source" as "World Bank"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_02
    Given User enters "228912101"
    And User selects "Source" as "International Monetary Fund"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_03
    Given User enters "Agar"
    And User selects "Source" as "Ministry of Commerce and Industry, India"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_04
    Given User enters "Agar"
    And User selects "Source" as "Ministry of Commerce and Industry;Foreign Exchange Office"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Global Database,India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_05
    Given User enters "BRJLA"
    And User selects "Source" as "Special Secretariat for Foreign Trade and International Affairs"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
   Scenario: TC_Filters_Search_06
    Given User enters "19289601"
    And User selects "Source" as "BSE Limited"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "High Frequency Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_07
    Given User enters "1380601"
    And User selects "Source" as "Special Secretariat for Foreign Trade and International Affairs"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_08
    Given User enters "245178303"
    And User selects "Source" as "Bank of Russia"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Russia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_09
    Given User enters "213834902"
    And User selects "Source" as "Reserve Bank of India"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_10
    Given User enters "146381801"
    And User selects "Source" as "National Bureau of Statistics"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_11
    Given User enters "322968702"
    And User selects "Source" as "AIA Group Limited"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  #@FilterSearch
  #Scenario: TC_Filters_Search_12
    #Given User enters "278655402"
    #And User selects "Source" as "International Organisation for Economic Co-operation and Development"
    #And User has clicked on "Apply filter"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Main Economic Indicators"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_13
    #Given User enters "277207202"
    #And User selects "Source" as "International Organisation for Economic Co-operation and Development"
    #And User has clicked on "Apply filter"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Economic Outlook"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_14
    #Given User enters "298772102"
    #And User selects "Source" as "International Organisation for Economic Co-operation and Development"
    #And User has clicked on "Apply filter"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - National Accounts"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_15
    #Given User enters "293654602"
    #And User selects "Source" as "International Organisation for Economic Co-operation and Development"
    #And User has clicked on "Apply filter"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Productivity"
    #And User has clicked on "Apply filter"
    #Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_16
    Given User enters "MDPIJB"
    And User selects "Source" as "Malaysian Rubber Board"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_17
    Given User enters "BRAFAC"
    And User selects "Source" as "Central Bank of Brazil"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_18
    Given User enters "BRDLAC"
    And User selects "Source" as "Central Bank of Brazil"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "High Frequency Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_19
    Given User enters "IDIAAAG"
    And User selects "Source" as "BSE Limited"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_20
    Given User enters "CZACKC"
    And User selects "Source" as "China Banking and Insurance Regulatory Commission"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_21
    Given User enters "HKIRGAAAUA"
    And User selects "Source" as "AIA Group Limited"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_22
    Given User enters "Agar"
    And User selects "Source" as "Foreign Exchange Office"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_23
    Given User enters "IDIAB"
    And User selects "Source" as "BSE Limited"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_24
    Given User enters "261975301"
    And User selects "Source" as "International Monetary Fund"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_25
    Given User enters "GDP"
    And Click on "More" filter
    And User selects "Date" as "First observation before"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_26
    Given User enters "GDP"
    And User selects "Frequency" as "Monthly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_27
    Given User enters "297762801;261968101;179050002;245232002;228912101"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_28
    Given User enters "261968101;261967901;261968401"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_29
    Given User enters "228912101;223399201;223398801"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_30
    Given User enters "227807102;1086201;1086701"
    And Click on "More" filter
    And User selected "Database" as "High Frequency Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_31
    Given User enters "1380601;1440601;1440701"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_32
    Given User enters "181692002;194081702;194081802"
    And Click on "More" filter
    And User selected "Database" as "Russia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_33
    Given User enters "21355201;61149902;61150002"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_34
    Given User enters "245732302;205673602"
    And Click on "More" filter
    And User selected "Database" as "Indonesia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_35
    Given User enters "3782201;94664201"
    And Click on "More" filter
    And User selected "Database" as "China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_36
    Given User enters "323022102;323023302;33241901"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_37
    #Given User enters "280621302"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Main Economic Indicators"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_38
    #Given User enters "291714302;277061402"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Economic Outlook"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_39
    #Given User enters "294769102;295423302"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - National Accounts"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_40
    #Given User enters "293611402;293607802"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Productivity"
    #And User has clicked on "Apply filter"
    #Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_41
    Given User enters "215439102;9552901"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_42
    Given User enters "MDPIJB;VDPACA"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_43
    Given User enters "BRAFAC;BRJAC"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_44
    Given User enters "BRDLAC;BRDLAA;BRDLAB"
    And Click on "More" filter
    And User selected "Database" as "High Frequency Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_45
    Given User enters "BRJAC;BRJLA;BRJLAA"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_46
    Given User enters "IDIAB;IDIAF;IDIAG"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_47
    Given User enters "DKCBG;DKCBGA"
    And Click on "More" filter
    And User selected "Database" as "Indonesia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_48
    Given User enters "CFPAA;CFAPAT"
    And Click on "More" filter
    And User selected "Database" as "China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_49
    Given User enters "NLIRAAAFUL;NLIRAAAFUX;NNRAAAAAA"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_50
    Given User enters "BRDLAC;CABB"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database,China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_51
    Given User enters "consumer"
    And Click on "More" filter
    And User selected "Database" as "China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_52
    Given User enters "GDP"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_53
    Given User enters "Tirana"
    And Click on "More" filter
    And User selected "Database" as "High Frequency Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_54
    Given User enters "monetary base"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_55
    Given User enters "household income"
    And Click on "More" filter
    And User selected "Database" as "Russia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_56
    Given User enters "consumer expenditure"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_57
    Given User enters "Construction"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_58
    Given User enters "Agar"
    And Click on "More" filter
    And User selects "Date" as "First observation before"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  #@FilterSearch
  #Scenario: TC_Filters_Search_59
    #Given User enters "Changes"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Main Economic Indicators"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_60
    #Given User enters "formation"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Economic Outlook"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_61
    #Given User enters "Reference;employment"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - National Accounts"
    #And User has clicked on "Apply filter"
    #Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_62
    Given User enters "Reserve"
    And Click on "More" filter
    And User selected "Database" as "Global Database,High Frequency Database,Russia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_63
    Given User enters "181123202(BRDLAA)"
    And User selects "Status" as "Active"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_64
    Given User enters "233138001(CJLAAA)"
    And User selects "Status" as "Active"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_65
    Given User enters "Agar"
    And Click on "More" filter
    And User selects "Name only"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_66
    Given User enters "2126801"
    And Click on "More" filter
    And User selects "Subscribed series only"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_67
    Given User enters "2126801"
    And User selects "Status" as "Active"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selects "Subscribed series only"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_68
    Given User enters "BRJAC"
    And User selects "Status" as "Active"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selects "Subscribed series only"
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_69
    Given User enters "Insurance"
    And User selects "Status" as "Active"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selects "Name only"
    And User selected "Database" as "China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_70
    Given User enters "demand"
    And User selects "Status" as "Active"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selects "Subscribed series only"
    And User has clicked on "Apply filter"
    Then User verify the search results

  #@FilterSearch
  #Scenario: TC_Filters_Search_71
    #Given User enters "261968101"
    #And Click on "More" filter
    #And User selected "Database" as "World Trend Plus"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Aggregate: World"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_72
    #Given User enters "228912101"
    #And Click on "More" filter
    #And User selected "Database" as "Global Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Albania"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_73
    #Given User enters "227807102"
    #And Click on "More" filter
    #And User selected "Database" as "High Frequency Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Lending Rates"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_74
    #Given User enters "1380601"
    #And Click on "More" filter
    #And User selected "Database" as "Brazil Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Foreign Trade"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_75
    #Given User enters "181692002"
    #And Click on "More" filter
    #And User selected "Database" as "Russia Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Energy Sector"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_76
    #Given User enters "21355201"
    #And Click on "More" filter
    #And User selected "Database" as "India Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Investment"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_77
    #Given User enters "245732302"
    #And Click on "More" filter
    #And User selected "Database" as "Indonesia Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Business and Economic Survey"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_78
    #Given User enters "3782201"
    #And Click on "More" filter
    #And User selected "Database" as "China Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Financial Market"
    #Then User verify the results

  #@FilterSearch
  #Scenario: TC_Filters_Search_79
    #Given User enters "279238002"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Main Economic Indicators"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Aggregate: 7 Major OECD Countries"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_80
    #Given User enters "277061402"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Economic Outlook"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Aggregate: Non-OECD Countries"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_81
    #Given User enters "295423302"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - National Accounts"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Aggregate: North American Free Trade Agreement (NAFTA)"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_82
    #Given User enters "293607802"
    #And Click on "More" filter
    #And User selected "Database" as "OECD - Productivity"
    #And User has clicked on "Apply filter"
    #When User get the topics as "OECD Members: Austria"
    #Then User verify the results

  #@FilterSearch
  #Scenario: TC_Filters_Search_83
    #Given User enters "brdlac"
    #And Click on "More" filter
    #And User selected "Database" as "Daily Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Lending Rates"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_84
    #Given User enters "brjac"
    #And Click on "More" filter
    #And User selected "Database" as "Brazil Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Foreign Trade"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_85
    #Given User enters "idiab"
    #And Click on "More" filter
    #And User selected "Database" as "India Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Financial Market"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_86
    #Given User enters "DKCBGA"
    #And Click on "More" filter
    #And User selected "Database" as "Indonesia Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Monetary"
    #Then User verify the results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_87
    #Given User enters "CZACKC"
    #And Click on "More" filter
    #And User selected "Database" as "China Premium Database"
    #And User has clicked on "Apply filter"
    #When User get the topics as "Insurance Sector"
    #Then User verify the results

  @FilterSearch
  Scenario: TC_Filters_Search_88
    Given User enters "194081702"
    And Click on "More" filter
    And User selects "Unit" as "kg"
    And User selected "Database" as "Russia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_89
    Given User enters "228912101"
    And Click on "More" filter
    And User selects "Unit" as "ALL"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_90
    Given User enters "1086701"
    And Click on "More" filter
    And User selects "Unit" as "BDT/USD"
    And User selected "Database" as "High Frequency Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_91
    Given User enters "1440701"
    And Click on "More" filter
    And User selects "Unit" as "BRL"
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_92
    Given User enters "261967901"
    And Click on "More" filter
    And User selects "Unit" as "%"
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_93
    Given User enters "189144402"
    And Click on "More" filter
    And User selects "Unit" as "USD"
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  #@FilterSearch
  #Scenario: TC_Filters_Search_94
    #Given User enters "279238002"
    #And Click on "More" filter
    #And User selects "Unit" as "2005=100"
    #And User selected "Database" as "OECD - Main Economic Indicators"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_95
    #Given User enters "277061402"
    #And Click on "More" filter
    #And User selects "Unit" as "USD"
    #And User selected "Database" as "OECD - Economic Outlook"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_96
    #Given User enters "295423302"
    #And Click on "More" filter
    #And User selects "Unit" as "USD"
    #And User selected "Database" as "OECD - National Accounts"
    #And User has clicked on "Apply filter"
    #Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_97
    #Given User enters "293607802"
    #And Click on "More" filter
    #And User selects "Unit" as "ATS"
    #And User selected "Database" as "OECD - Productivity"
    #And User has clicked on "Apply filter"
    #Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_98
    Given User enters "VDPACA"
    And Click on "More" filter
    And User selects "Unit" as "MN VND/Tael"
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_99
    Given User enters "BRAFAC"
    And Click on "More" filter
    And User selects "Unit" as "BRL"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_100
    Given User enters "WHO001"
    And Click on "More" filter
    And User selects "Unit" as "Person"
    And User selected "Database" as "High Frequency Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_101
    Given User enters "BRDLAC"
    And Click on "More" filter
    And User selects "Unit" as "% pa"
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_102
    Given User enters "IZINO"
    And Click on "More" filter
    And User selects "Unit" as "2005=1000"
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_103
    Given User enters "NLIRCAAAEX"
    And Click on "More" filter
    And User selects "Unit" as "USD"
    And User selected "Database" as "World Trend Plus"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_104
    Given User enters "Agar"
    And Click on "More" filter
    And User selects "Unit" as "MAD"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_105
    Given User enters "228912101"
    And Click on "More" filter
    And User selects "Unit" as "ALL"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_106
    Given User enters "126074608"
    And Click on "More" filter
    And User selects "Unit" as "Ton"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_107
    Given User enters "commodity"
    And User selects "Frequency" as "Daily"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_108
    Given User enters "estate"
    And User selects "Frequency" as "Weekly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_109
    Given User enters "Selenium"
    And User selects "Frequency" as "Monthly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_110
    Given User enters "Selenium"
    And User selects "Frequency" as "Quarterly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_111
    Given User enters "capital"
    And User selects "Frequency" as "Semiannually"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_112
    Given User enters "Selenium"
    And User selects "Frequency" as "Yearly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_113
    Given User enters "Rate"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_114
    Given User enters "126074608"
    And Click on "More" filter
    And User selects "Unit" as "Ton"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_115
    Given User enters "242994803"
    And Click on "More" filter
    And User selects "Unit" as "RUB"
    And User selected "Database" as "Russia Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_116
    Given User enters "3782201"
    And Click on "More" filter
    And User selects "Unit" as "19Dec1990=100"
    And User selected "Database" as "China Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results
#
  #@FilterSearch
  #Scenario: TC_Filters_Search_117
  #	Given User enters "1055401 (BAEAE)"
  #	And   User selects "All Regions" as "Asia Pacific"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_118
  #	Given User enters "1382601 (BRJAEN)"
  #	And   User selects "All Regions" as "Americas"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_119
  #	Given User enters "121587008"
  #	And   User selects "All Regions" as "Europe"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_120
  #	Given User enters "99459607"
  #	And   User selects "All Regions" as "Middle East"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_121
  #	Given User enters "132330608"
  #	And   User selects "All Regions" as "Africa"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_122
  #	Given User enters "225939502 (EJGAADH)"
  #	And   User selects "All Regions" as "G7"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_123
  #	Given User enters "68951101 (BRFGG)"
  #	And   User selects "All Regions" as "G20"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_124
  #	Given User enters "61540402 (BNAAAAA)"
  #	And   User selects "All Regions" as "ASEAN"
  #	Then  User should get the search results
  #
  #@FilterSearch
  #Scenario: TC_Filters_Search_125
  #	Given User enters "230792902 (IAPAFABH)"
  #	And   User selects "All Regions" as "BRIC"
  #	Then  User should get the search results
  
  @FilterSearch
  Scenario: TC_Filters_Search_117
    Given User enters "1380601"
    And User selects "Frequency" as "Monthly"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_118
    Given User enters "money"
    And Click on "More" filter
    And User selects "Subscribed series only"
    And User has clicked on "Apply filter"
    And User selects "Frequency" as "Quarterly"
    And User has clicked on "Apply filter"
    And User selects "Source" as "International Monetary Fund"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selects "Unit" as "MUR"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_119
    Given User enters "money"
    And Click on "More" filter
    And User selects "Name only"
    And User has clicked on "Apply filter"
    And User selects "Frequency" as "Quarterly"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selects "Unit" as "MUR"
    And User has clicked on "Apply filter"
    And User selects "Source" as "International Monetary Fund"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_120
    Given User enters "Exchange AND Rate"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_121
    Given User enters "Forecast OR Low"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_122
    Given User enters "Exchange Rate"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_123
    Given User enters "Res*"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_124
    Given User enters "Seleni*"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_125
    Given User enters "Se*enium"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_126
    Given User enters "aga?"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_127
    Given User enters "ag?r"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_128
    Given User enters "2137320*"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_129
    Given User enters "1380*1"
    And Click on "More" filter
    And User selected "Database" as "Brazil Premium Database"
    And User has clicked on "Apply filter"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_130
    Given User enters "BRDLA*"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_131
    Given User enters "IZI*O"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_132
    Given User enters "*ZINO"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_133
    Given User enters "2137320?"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_134
    Given User enters "?1373201"
    And Click on "More" filter
    And User selected "Database" as "India Premium Database"
    And User has clicked on "Apply filter"
    Then User verifies Filter search results

  @FilterSearch
  Scenario: TC_Filters_Search_135
    Given User enters "mfg"
    And Click on "More" filter
    And User selects "Unit" as "2005=100"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_136
    Given User enters "mfg"
    And User selects "Source" as "The Bank of Korea"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_137
    Given User enters "mfg"
    And User selects "Frequency" as "Quarterly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_138
    Given User enters "mfg"
    And User selects "Frequency" as "Monthly"
    And User has clicked on "Apply filter"
    And User selects "Source" as "The Bank of Korea"
    And User has clicked on "Apply filter"
    And Click on "More" filter
    And User selects "Unit" as "2005=100"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_139
    Given User enters "GDP"
    And User selects "Frequency" as "Monthly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_140
    Given User enters "GDP"
    And User selects "Frequency" as "Quarterly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_141
    Given User enters "Capital"
    And User selects "Frequency" as "Semiannually"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_142
    Given User enters "GDP"
    And User selects "Frequency" as "Yearly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_143
    Given User enters "account"
    And User selects "Frequency" as "Daily;Weekly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_144
    Given User enters "account"
    And User selects "Frequency" as "Monthly;Quarterly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_145
    Given User enters "account"
    And User selects "Frequency" as "Daily;Yearly"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_146
    Given User enters "money"
    And Click on "More" filter
    And User selects "Date" as "First observation before;Last observation after"
    And User selected "Database" as "Global Database"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @FilterSearch
  Scenario: TC_Filters_Search_147
    Given User enters "money"
    And Click on "More" filter
    And User selects "Subscribed series only"
    And User has clicked on "Apply filter"
    Then User check for the scubscribed series

  @FilterSearch
  Scenario: TC_Filters_Search_148
    Given User enters "money"
    And Click on "More" filter
    And User selects "New only"
    And User has clicked on "Apply filter"
    Then User verify the search results
#
  ##
  ##@FilterSearch
  ##Scenario: TC_Filters_Search_158
  ##	And   Select "New only" from "More" filter
  ##	And   User has clicked on "Apply filter"
  ##	Then  User verify the series count
  ##
  ##@FilterSearch
  ##Scenario: TC_Filters_Search_159
  ##	And   Select "Key only" from "More" filter
  ##	And   User has clicked on "Apply filter"
  ##	Then  User verify the series count
  ##
  ##@FilterSearch
  ##Scenario: TC_Filters_Search_160
  ##	And   Select "Forecast" from "More" filter
  ##	And   User has clicked on "Apply filter"
  ##	Then  User verify the series count
  ##
  ##@FilterSearch
  ##Scenario: TC_Filters_Search_161
  ##	And   Select "With release schedule" from "More" filter
  ##	And   User has clicked on "Apply filter"
  ##	Then  User verify the series count
  ##
  ##@FilterSearch
  ##Scenario: TC_Filters_Search_162
  ##	And   Select "With suggestions for rebased/discontinued series" from "More" filter
  ##	And   User has clicked on "Apply filter"
  ##	Then  User verify the series count
  ##
  ##
  #@IndicatorSearch
  #Scenario: TC_IndicatorSearch_1
    #Given User enters "Tax  revenue: % of GDP"
    #And Click on "More" filter
    #And User selected "Database" as "Economic Monitor"
    #And User has clicked on "Apply filter"
    #And Select "Matches only"
    #And Click on "All Region"
    #And Select "Select All"
    #And User has clicked on "Apply filter"
    #Then Should get list of series
