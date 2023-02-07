@sprint5.5
Feature: verify sprint5.5 test scenaraios/functionality

  Scenario: TC_01_21528_01: Verify preselecting 'Alternative data' checkbox
    And Click on "Alternative Data" dropdown
    Then The "Alternative Data" checkbox should be checked by default

  Scenario: TC_02_21132_01: Veirfy Alternative data display position in the dropdown
    And Click on "Alternative Data" dropdown
    Then The "Alternative Data" should be displayed on the top always

  Scenario: TC_03_21132_02: Verify the button name for Alternative data dropdown
    Then The button name should be "Alternative Data"

  
  Scenario: TC_04_21132_04: Verify the 'Alt' tag in front of series
    And Click on "Alternative Data" dropdown
    And The "Alternative Data" checkbox should be checked by default
    And Click on "Apply filter"
    Then The "Alt" tag should be displayed for all series.

 
  Scenario: TC_05_21446_01: Verify series effect in Table view.
    And Add series to the my series tab
    And Switch on "Table mode"
    And Mouse hover on series
    Then The series should be "underline"

  Scenario: TC_06_21433_01: Verify toolbar in my series when no series selected.
    And Add series to the my series tab
    Then Check toolbar and the toolbar should be greyed out instead of hiding

  Scenario: TC_07_21425_01: Verify Paste option in series right click under my series.
    And Add series to the my series tab
    And Right-click on the series
    And Select "Copy"
    And Select "Paste" in series right click under my series
    And The Paste option should be present and work

  Scenario: TC_08_21337_01: Verify the Vertical table visual under Add chart popup.
    And Add series to the my series tab
    And Right-click on the series
    And Add chart > Check the placement for vertical visual under Table
    Then The Vertical visual should be displayed in first place under Table

  Scenario: TC_09_21295_02: Verify prefix to the list of sources.
    #And Open copyright under preference
    #And Click on "Change" option
    And Click on "Theme" button
    And Select "Source"
    And Click on "Apply" button
    And Create any visual
    Then "Sources: CEIC," should be displayed as prefix

 
  Scenario: TC_10_21295_01:Verify new copyright type 'Series sources'
    #And Open copyright under preference
    #And Click on "Change" option
    And Click on "Theme" button
    And Select "Source"
    And Click on "Apply" button
    And Create a pie visual with series id's "369703417;5958801"
    Then The list of series sources should be displayed

  Scenario: TC_11_21295_03:Verify translation for 'Source' label in non English UI.
    #And Open copyright under preference
    #And Click on "Change" option
    #And Select "Series sources"
    And Click on "Theme" button
    And Select "Source"
    And Click on "Apply" button
    And Create a pie visual with series id's "369703417"
    And Change the UI language
    Then The "Sources" label should be translated

  Scenario: TC_12_21264_01:Verify creating visuals in the same/current view.
    And Create a view in right panel
    And Create 3 visuals from search panel
    Then The visuals should be created in same focused view

   Scenario: TC_13_21253_01:Verify the title for Image visual
    And Go to View tab
    And Click on insert Image visual icon
    Then The "Title" should be disabled by default

  Scenario: TC_14_21264_03:Verify creating visuals when right panel is in My series.
    And Create a view in right panel
    And Create 3 visuals from search panel
    And Open My series panel in right panel
    And Create a Visual from search panel
    Then Should create a visual in the last available view

  Scenario: TC_15_20624_01:Verify 'Add Chart' option in search panel and My insight.
    And Select series and right click on any series
    And Add chart > select any visual
    Then The selected visual should be created

  Scenario: TC_16_21296_01:Verify saving no. of steps & colors as part of style template for Map
    And Create a map visual with series id's "272965603"
    And Click on "Edit Map"
    And Select Solid color
    And Click on color steps dropdown
    And Select color steps as 3
    And Click on below color steps created and change color as you wish for each step
    And Click on "Save"
    Then Should be able to Save template with selected no of steps & colors

  Scenario: TC_17_21296_02:Verify saving no. of steps & colors as part of style template for Heatmap
    And Select series and right click on any series
    And Add chart > Heat map
    And Click on "Edit Heat map"
    And Select Solid color
    And Click on color steps dropdown
    And Select color steps as 3
    And Click on below color steps created and change color as you wish for each step
    And Click on "Save"
    Then Should be able to Save template with selected no of steps & colors

    Scenario: TC_18_21248_01:Verify enabled 'Fit to Width' by default for Image visual
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Select the image
    Then The "Fit to width" option should be selected/enabled

 
  Scenario: TC_19_20967_01:Verify default download format for Analysis insights.
    And Navigate to "Analysis" insights
    And Click on download for any insight
    Then The PDF format should be selected to download the insight

  Scenario: TC_20_21310_07:Verify Bi-driectional update check box when series selected in Search panel.
    And Select some series
    And Click on "Download" button
    Then Bi-directional update checkbox should be hidden

  Scenario: TC_21_21216_01:Verify support for default map type detection based on the series
    And Create a map visual with some country level series (excluding Hong Kong , Macau and Taiwan)
    Then Should create World Map

  Scenario: TC_22_21216_02:Verify support for default map type detection based on the series
    And Select some series that has subnational data & create a Map
    Then Should create Map based on the country

   Scenario: TC_23_21216_03:Verify support for default map type detection based on the series
    And Select some series that has mixed subnational data (eg.China, Russia & India) & create a Map
    Then Should create a subnational map based on the 1st detected country

  Scenario: TC_24_15658:Verify include unit to the Map's legend
    And Click on "More" filter
    And User selects "Unit" as "kg"
    And User has clicked on "Apply filter"
    And Select some series which series has same unit & create a Map
    Then Should show unit in legend for Map visual,if all series are of same unit

  Scenario: TC_25_20968_01:Verify behaviour in subnational tabs of the  region filter for China Regional Data -Search existing County
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    And In search field , type existing county as "Huaining"
    Then Should display results for respective  province,prefecture & county tabs

  Scenario: TC_26_20968_02:Verify behaviour in subnational tabs of the  region filter for China Regional Data -Search existing Prefecture
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    And In search field , type existing prefecture as "Hefei"
    Then Should display results for respective  province,prefecture & county tabs

  Scenario: TC_27_20968_03:Verify behaviour in subnational tabs of the  region filter for China Regional Data - Search existing Province
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    And In search field , type existing province as "Tibet"
    Then Should display results for respective  province,prefecture & county tabs

  Scenario: TC_28_21064_01:Verify new subnational group in the region filter for China Regional data tab
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    Then Should show "Region" filter in Subnational group
    Then By default, should display all groups as collapsed in Sub national groups tab

  Scenario: TC_29_21254_01:Verify displaying Select All in the header of 2nd & 3rd sunbational levels
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    And Type 2 or more letters as keyword in the search field (eg. gui)
    Then Should display Select All in the header

  #it works only on internal account
  Scenario: TC_30_21259_01:Verify special format "EMIS report" which will allow applying special formatting for the PDF download
    And Create histogram visual with series
    And Click on Insight cogwheel icon
    And Select settings,opens insights settings
    Then Should show switch/checkbox for EMIS Report

  Scenario: TC_31_21254_02:Verify displaying Select All in the header of 2nd & 3rd sunbational levels
    And Click on "All Regions" dropdown
    And Select subnational as "China"
    And Type some keyword in search field "xi" for below 1000 results
    Then Should display Select All in the header if a number of values is smaller than 1000
    And Type some keyword in search field "an" for above 1000 results
    Then Should not display Select All in the header if a number of values is greater than 1000
