Feature: Verifying SeriesTab functionality

  @SeriesTab
  Scenario: TC_SeriesTab_01:Verify indicator filter  for series tab
    And Select indicator "Production" as "Steel Production"
    And Select indicator "Tourism Sector" as "Tourism Revenue"
    When Click on "Apply filter"
    Then Result should be displayed as per selection
 

  #@SeriesTab...functionality has been removed
  #Scenario: TC_SeriesTab_02:Verify "All Insights" option
  #	When Click on "All insights"
  #	Then The "Insight Explorer" popup should be appeared
  @SeriesTab
  Scenario: TC_SeriesTab_02:Verify Reset option  for series tab
    Given User enters "GDP"
    And User selects "Source" as "World Bank"
    And User has clicked on "Apply filter"
    When Click on "Reset"
    Then Selected options should be reset to default

  @SeriesTab
  Scenario: TC_SeriesTab_03:Verifying "Unselect all" option for series level
    Given User enters seriesID "146381801;1380601;245178303"
    When User right click on any series
    Then User can able to see "Unselect all" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_04:Verify series count f or search
    Given User enters keyword "gdp"
    Then Series count should be matched with displayed result

  @SeriesTab
    Scenario: TC_SeriesTab_05:Verifying "Copy" option for series level
    Given User enters seriesID "1380601;245178303"
    When User right click on any series
    Then User can able to see "Copy" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_06:Verifying "Copy data" option for series level
    Given User enters seriesID "146381801;228912101"
    When User right click on any series
    Then User can able to see "Copy data" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_07:Verifying "Series Info" option for series level
    Given User enters seriesID "261975301;237211603"
    When User right click on any series
    Then User can able to see "Series Info" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_08:Verifying "View as Chart" option for series level
    Given User enters seriesID "357567097;357567537"
    When User right click on any series
    Then User can able to see "View as Chart" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_09:Verifying "View as Map" option for series level
    Given User enters seriesID "7872901;7874601"
    When User right click on any series
    Then User can able to see "View as Map" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_10:Verifying "View as Table" option for series level
    Given User enters seriesID "7872901;7874601"
    When User right click on any series
    Then User can able to see "View as Table" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_11:Verifying "Download" option for series level
    Given User enters seriesID "268193601;69326701"
    When User right click on any series
    Then User can able to see "Download" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_12:Verifying "Footnotes" option for series level
    Given User enters seriesID "354673701;354674001"
    When User right click on any series
    Then User can able to see "Footnotes" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_13:Verifying "Add to Watchlist" option for series level
    Given User enters seriesID "3640701"
    When User right click on any series
    Then User can able to see "Add to Watchlist" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_14:Verifying "Copy selected links" option for series level
    Given User enters seriesID "322968702;213834902"
    When User right click on any series
    Then User can able to see "Copy selected links" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_15:Verifying "Show Dataset" option for series level
    Given User enters seriesID "258074801;406097377"
    When User right click on any series
    Then User can able to see "Show Dataset" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_16:Verifying "See in Database" option for series level
    Given User enters seriesID "5823601;5793201(CIUA)"
    When User right click on any series
    Then User can able to see "See in Database" option from dropdown menu

  #@SeriesTab....functionality has been removed
  #Scenario: TC_SeriesTab_17:Verifying SSP for series
    #Given User enters "GDP"
    #When Click on Show Series Info icon
    #Then SSP window should be displayed

  @SeriesTab
  Scenario: TC_SeriesTab_18:Verifying "key only" filter for series tab
    Given User enters "GCF"
    And User has selects "More" as "Key only"
    When Click on "Apply filter"
    Then "Key series" should be displayed

  @SeriesTab
  Scenario: TC_SeriesTab_19:Verifying "with release schedule" filter for series tab
    Given User enters "FDI"
    And User has selects "More" as "With release schedule"
    When Click on "Apply filter"
    Then User verify corresponding results for selected filter

  @SeriesTab
  Scenario: TC_SeriesTab_20:Verifying "with suggestions for rebased/discontinued series " filter for series tab
    Given User enters "PSI"
    And User has selects "More" as "With suggestions for rebased/discontinued series"
    When Click on "Apply filter"
    Then User verify corresponding results for selected filter

  @SeriesTab
  Scenario: TC_SeriesTab_21:Verifying "Forecast" filter for series tab
    Given Open "Series" tab
    And User has selects "More" as "Forecast"
    When Click on "Apply filter"
    And Choose "Popularity" under "Sort By" option
    Then User verify corresponding results for selected filter

  @SeriesTab
  Scenario: TC_SeriesTab_22:Verify 'Mouse over' icons for series level
    Given User enters "5724301"
    When User Mouse hover on "See in Database" icon
    Then User can selects "Global Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_23:Verify 'Mouse over' icons for series level
    Given User enters "262498601"
    When User Mouse hover on "See in Database" icon
    Then User can selects "Global Key Series Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_24:Verify 'Mouse over' icons for series level
    Given User enters "5190001"
    When User Mouse hover on "See in Database" icon
    Then User can selects "China Premium Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_25:Verify 'Mouse over' icons for series level
    Given User enters "5823501"
    When User Mouse hover on "See in Database" icon
    Then User can selects "Global Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_26:Verify 'Mouse over' icons for series level
    Given User enters "1025401"
    When User Mouse hover on "See in Database" icon
    Then User can selects "Daily Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_27:Verify 'Mouse over' icons for series level
    Given User enters "376239567"
    When User Mouse hover on "See in Database" icon
    Then User can selects "Brazil Premium Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_28:Verify 'Mouse over' icons for series level
    Given User enters "389489677"
    When User Mouse hover on "See in Database" icon
    Then User can selects "Russia Premium Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_29:Verify 'Mouse over' icons for series level
    Given User enters "360724907"
    When User Mouse hover on "See in Database" icon
    Then User can selects "India Premium Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_30:Verify 'Mouse over' icons for series level
    Given User enters "324350701"
    When User Mouse hover on "See in Database" icon
    Then User can selects "Indonesia Premium Database"
    Then User can see the selected database in Databases tab

  @SeriesTab
  Scenario: TC_SeriesTab_31:Verify 'Mouse over' icons for series level
    Given User enters "400841827"
    When User Mouse hover on "See in Database" icon
    Then User can see the selected database in Databases tab

  #@SeriesTab....functionality has been removed
  #Scenario: TC_SeriesTab_32:Verify 'Mouse over' icons for series level
  #Given User enters "122834404"
  #When User Mouse hover on "See in Database" icon
  #Then User can see the selected database in Databases tab
  #
  #@SeriesTab... functionality has been removed
  #Scenario: TC_SeriesTab_33:Verify 'Mouse over' icons for series level
  #Given User enters "377030917"
  #When User Mouse hover on "See in Database" icon
  #Then User can see the selected database in Databases tab
  #@SeriesTab....skipped as there is no OECD productivity db
  #Scenario: TC_SeriesTab_34:Verify 'Mouse over' icons for series level
  #Given User enters "5724301"
  #When User Mouse hover on "See in Database" icon
  #Then User can see the selected database in Databases tab
  @SeriesTab
  Scenario: TC_SeriesTab_35:Verify 'Mouse over' icons for series level
    Given User enters seriesID "5190101"
    When User Mouse hover on "View as Chart. Type `c`" icon
    Then User can see the Chart Visual in the right pannel

  @SeriesTab
  Scenario: TC_SeriesTab_36:Verify 'Add and replace' from dropdown
    Given User enters seriesID "5724301;5958801"
    And Create any visual
    And Click on drop down icon next to +
    And Click on "Add and replace"
    Then Highlighted visual series should be replaced new series

  @SeriesTab
  Scenario: TC_SeriesTab_37:Verify 'Mouse over' icons for series level
    Given User enters seriesID "368921927"
    When User Mouse hover on "Open footnote" icon
    Then Footnotes window should be open

  @SeriesTab
  Scenario: TC_SeriesTab_38:Verify selected 'series count' under series tab.
    Given User enters seriesID "146381801;1380601;245178303"
    Then Verify the selected series count

  @SeriesTab
  Scenario: TC_SeriesTab_39:Verify "Add series" by click on '+'
    Given User enters seriesID "7872901;7874601"
    When Click on + icon on series
    Then The series should be added to Data tab

  @SeriesTab
  Scenario: TC_SeriesTab_40:Verify Pin/unpin filters
    And Click on any filter
    And Select "Pin to left"
    Then filter should be pined/unpined the filter to left panel

  @SeriesTab
  Scenario: TC_SeriesTab_41:Verify 'Add' series from dropdown
    Given User enters seriesID "368921927;371376337"
    And Click on drop down icon next to +
    And Click on "Add"
    Then The series should be added to Data tab

  @SeriesTab
  Scenario: TC_SeriesTab_42:Verify 'Add to recent insight' in dropdown
    Given User enters seriesID "368921927;371376337"
    And Click on drop down icon next to +
    And Click on "Add to recent insight"
    And Select any recent insight from the dropdown
    And Click on Apply
    Then The series should be added to selected insight

  @SeriesTab
  Scenario: TC_SeriesTab_43:Verify 'Add to new insight' in dropdown
    Given User enters seriesID "53211802;386600807"
    And Click on drop down icon next to +
    And Click on "Add to new insight"
    Then New insight should be created and the series should be added to the insight

  @SeriesTab
  Scenario: TC_SeriesTab_44:Verify 'Add and group' from dropdown
    Given User enters seriesID "368921927;371376337"
    And Click on drop down icon next to +
    And Click on "Add and group"
    Then Selected series should be added as group in My series

  @SeriesTab
  Scenario: TC_SeriesTab_45:Check 'N' symbol for new only series filter
    And Open "Series" tab
    And User has selects "More" as "New only"
    When Click on "Apply filter"
    Then "NEW" symbol to be displayed for "New only"

  @SeriesTab
  Scenario: TC_SeriesTab_46:Check 'k' symbol for kew only filter
    And Open "Series" tab
    And User has selects "More" as "Key only"
    When Click on "Apply filter"
    Then "k" symbol to be displayed for "Key only"

  @SeriesTab
  Scenario: TC_SeriesTab_47:Check 'F' symbol for forecast series filter
    And Open "Series" tab
    And User has selects "More" as "Forecast"
    When Click on "Apply filter"
    Then "f" symbol to be displayed for "Forecast series only"

  @SeriesTab
  Scenario: TC_SeriesTab_48:Verify 'S' symbol for series suggestions filter
    And Open "Series" tab
    And User has selects "More" as "With suggestions for rebased/discontinued series"
    When Click on "Apply filter"
    Then "s" symbol to be displayed for "replacement suggestions series"

  @SeriesTab
  Scenario: TC_SeriesTab_49:Verifying "New only" filter for series tab
    And Open "Series" tab
    And User has selects "More" as "New only"
    When Click on "Apply filter"
    Then "new series" should be displayed

  @SeriesTab
  Scenario: TC_SeriesTab_50:Verify results by World trend plus database
    And User enters "GDP"
    And Click on "More" filter
    And User selected "Database" as "World Trend Plus"
    And Click on "Apply filter"
    Then Search results should include series only from world trend plus DB

  #@SeriesTab ...functionality has been removed
  #Scenario: TC_SeriesTab_52:Verify click of open icon of 'All insights'
  #And Open "Series" tab
  #And Click on open icon of All insight
  #Then The "Insight Explorer" popup should be appeared
  #
  #@SeriesTab...functionality has been removed
  #Scenario: TC_SeriesTab_53:Verify tabs to display
  #And Click on cogwheel
  #Then "Select tabs to display" popup should be display
  #
  #@SeriesTab....functionality has been removed
  #Scenario: TC_SeriesTab_54:Verify hyperlink of matched insights
  #And Enter keyword "GDP"
  #And Click on x Matched Insights hyperlink
  #Then Insights explorer modal window should open with x number of insights listed
  @SeriesTab
  Scenario: TC_SeriesTab_51:Verifying "View as Pie" option for series level
    Given User enters seriesID "7872901;7874601"
    When User right click on any series
    Then User can able to see "View as Pie" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_52:Verifying "View as Heat map" option for series level
    Given User enters seriesID "230798301;7027801"
    When User right click on any series
    Then User can able to see "View as Heat map" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_53:Verifying "View as Histogram" option for series level
    Given User enters seriesID "230798301"
    When User right click on any series
    Then User can able to see "View as Histogram" option from dropdown menu

  @SeriesTab
  Scenario: TC_SeriesTab_54:Verifying "Download" option for selected series
    Given User enters seriesID "7872901;7874601"
    And Select series
    When Click on "Download"
    Then "Download" window should be appeared for selected series

  @SeriesTab
  Scenario: TC_SeriesTab_55:Verify "View as Chart" from More actions
    Given User enters seriesID "239796903;69851501"
    And Select series and Click on More actions
    And Select "View as Chart"
    Then Visual should be created with "Edit Chart"

  @SeriesTab
  Scenario: TC_SeriesTab_56:Verify "View as Map" from More actions
    Given User enters seriesID "7027801;292514701"
    And Select series and Click on More actions
    And Select "View as Map" as "China"
    Then Visual should be created with "Edit Map"

  @SeriesTab
  Scenario: TC_SeriesTab_57:Verify "Unselect all" from More actions
    Given User enters seriesID "356530077;2121301"
    And Select series and Click on More actions
    And Click on "Unselect all"
    Then The selected series should be unselected

  @SeriesTab
  Scenario: TC_SeriesTab_58:Verify Download option for selected series from More actions
    Given User enters seriesID "7027601;6273401"
    And Select series and Click on More actions
    And Select "Download"
    Then Download window should be appeared with selected series count

  @SeriesTab
  Scenario: TC_SeriesTab_59:Verify Footnotes option for series from right pane from More actions
    Given User enters seriesID "7876001;6231201"
    And Select series and Click on More actions
    And Select "Footnotes"
    Then Footnotes should be opened for selected series

  @SeriesTab
  Scenario: TC_SeriesTab_60:Verify "View as Pie" for series from More actions
    Given User enters seriesID "261975301;237211603"
    And Select series and Click on More actions
    And Select "Pie"
    Then Visual should be created with "Edit Pie"

  @SeriesTab
  Scenario: TC_SeriesTab_61:Verify "View as Heat map" for series from More actions
    Given User enters seriesID "108107001;213834902"
    And Select series and Click on More actions
    And Select "Heat map"
    Then Visual should be created with "Edit Heat map"

  @SeriesTab
  Scenario: TC_SeriesTab_62:Verify "View as Histogram" for series from More actions
    Given User enters seriesID "6249001"
    And Select series and Click on More actions
    And Select "Histogram"
    Then Visual should be created with "Edit Histogram"

  @SeriesTab
  Scenario: TC_SeriesTab_63:Verify 'Copy data' from More actions
    Given User enters seriesID "261975301;237211603"
    And Select series and Click on More actions
    And Select "Copy data"
    Then The download popup should be opened

  @SeriesTab
  Scenario: TC_SeriesTab_64:Verify "View as Table" for series level from More actions
    Given User enters seriesID "239796903;69851501"
    And Select series and Click on More actions
    And Select "View as Table"
    Then Visual should be created with "Edit Table"

  @SeriesTab
  Scenario: TC_SeriesTab_65:Verify Download option for series level from More actions
    Given User enters seriesID "1380601;245178303"
    And Select series and Click on More actions
    And Select "Download"
    Then Download window should be appeared with selected series count

  @SeriesTab
  Scenario: TC_SeriesTab_66:Verify ' Show Dataset' option from More actions
    Given User enters seriesID "239796903;69851501"
    And Select series and Click on More actions
    And Select "Show Dataset"
    And Click on Back button
    Then Should redirect to database tab

  @SeriesTab
  Scenario: TC_SeriesTab_67:Verify 'See in Database' option from More actions
    Given User enters seriesID "1380601;245178303"
    And Select series and Click on More actions
    And Select "See in Database"
    Then Navigate to the series from db tab

  @SeriesTab
  Scenario: TC_SeriesTab_68:Verify 'Copy' option from More actions
    Given User enters seriesID "261975301;237211603"
    And Select series and Click on More actions
    And Click on "Copy"
    Then The message should be in growl popup as "Selected series copied."
    Then Series should be pasted in excel as refreshable links

  @SeriesTab
  Scenario: TC_SeriesTab_69:Verify showing results per page
    And Scroll down and set showing results as "50" per page
    Then "50" results should display in a page

  #@SeriesTab...Removed from execution
  #Scenario: TC_SeriesTab_70:Verify show related data dropdown
    #And User enters seriesID "5958801"
    #And Click on Series tab
    #And Click on "Show related data"
    #Then "Active,Read More" and "DATASETS" should be available
#
  #@SeriesTab
  #Scenario: TC_SeriesTab_71:Check if the status is correctly displayed
    #And User enters seriesID "5958801"
    #And Click on Series tab
    #And Click on "Show related data"
    #Then Status has to be "Active"
#
  #@SeriesTab
  #Scenario: TC_SeriesTab_72:Check if the 'Read more' is correctly displayed
    #And User enters seriesID "5958801"
    #And Click on Series tab
    #And Click on "Show related data"
    #And Click on "Read More"
    #Then Read more should open footnotes of the respective series
#
  #@SeriesTab
  #Scenario: TC_SeriesTab_73:Check if the data sets are correctly displayed
    #And User enters seriesID "5958801"
    #And Click on Series tab
    #And Click on "Show related data"
    #Then Respective dataset to be opened when click on each datasets link
#
  #@SeriesTab
  #Scenario: TC_SeriesTab_74:Verify hide related data
    #And User enters seriesID "5958801"
    #And Click on Series tab
    #And Click on "Show related data"
    #And Click on "Hide related data"
    #Then The related data dropdown should be collapsed

  @SeriesTab
  Scenario: TC_SeriesTab_75:Verify selected Region results
    And User selects "All Regions" as "Albania;Japan"
    When Click on "Apply filter"
    Then User verify the search results

  @SeriesTab
  Scenario: TC_SeriesTab_76:Verify selected frequency results
    And User selects "Frequency" as "Monthly;Semiannually"
    When Click on "Apply filter"
    Then User verify the search results

  @SeriesTab
  Scenario: TC_SeriesTab_77:Verify selected unit results
    And Click on "More" filter
    And User selects "Unit" as "IDR;kg"
    When Click on "Apply filter"
    Then User verify the search results

  @SeriesTab
  Scenario: TC_SeriesTab_78:Verify selected First obs before and Last ob after results
    And Click on "More" filter
    And User selects "Date" as "First observation before;Last observation after"
    And User has clicked on "Apply filter"
    Then User verify the search results

  @SeriesTab
  Scenario: TC_SeriesTab_79:Verify selected status results
    And User selects "Status" as "Rebased"
    When Click on "Apply filter"
    Then Should display the rebased series

  @SeriesTab
  Scenario: TC_SeriesTab_80: Verify keyword search
    Given User enters keyword "gdp"
    Then User verify keyword search results

  @SeriesTab
  Scenario: TC_SeriesTab_81: Verify series id search
    Given User enters "2113401"
    Then User verify the search results

  @SeriesTab
  Scenario: TC_SeriesTab_82: Verify SR code search
    Given User enters "SR495594"
    Then Verify the search results

  @SeriesTab
  Scenario: TC_SeriesTab_83: Verify mnemonic search
    Given User enters "CN.GDP.NM.YTD-RMB-BN-Q"
    Then Verify the search results

  @SeriesTab
  Scenario: TC_SeriesTab_84:Verify 'Series info' option from More actions
    Given User enters seriesID "146381801;228912101"
    And Select series and Click on More actions
    And Select "Series Info"
    Then The SSP window should be opened

  @SeriesTab
  Scenario: TC_SeriesTab_85:Verify tabs to display
    And Click on three dots
    Then "Select tabs to display" popup should be display
