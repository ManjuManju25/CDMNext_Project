
Feature: Verifying Sprint cases Functionality.
 

  @Sprint5_3
  Scenario: TC_20210_03 :Replacement icon is missing for series having both continuous and replacements.
  Given user clicks on More Dropdown.
  And searches with series S under More Dropdown.
  And searches with series C under More Dropdown.
  Then Searches with S and c under More dropdown.
   
   @Sprint5_3
    Scenario Outline: TC_14654_01: Verify set values & labels for color stops for Map.
    Given user selects some series.
    And Mouse hover on series selects View as Map option.
    And clicks on Edit Map.
    And select gradient color with steps : "<Gradsize>"
    And select solid color with steps : "<Solidsize>".
    
    Examples:
   |Gradsize   |Solidsize|
   | 5         | 7       |      
   
    @Sprint5_3
    Scenario Outline: TC_14654_02: Verify set values & labels for color stops for HeatMap.
     Given user selects some series.
      And Mouse hover on series selects View as HeatMap option.
      And clicks on Edit HeatMap.
      And select gradient color with steps : "<Gradsize>"
      And select solid color with steps : "<Solidsize>".
    
    Examples:	
    
   |Gradsize   |Solidsize|
   | 5         | 7       |  
      
      @Sprint5_3
    Scenario Outline: TC_14654_05: Verify values for solid color for HeatMap /Maps.
     Given user selects some series.
     And Mouse hover on series selects View as HeatMap option.
      And clicks on Edit HeatMap.
      And select gradient color with steps : "<Gradsize>"
      And Validate maximum value for solid color : "<Solidsize>".
     
       
       Examples:
   |Gradsize   |Solidsize|
   | 5         | 7       |  
      
    @Sprint5_3
   Scenario: TC_20210_03 : Verify if the dates on the legend area in chart in SSP tab are displayed correctly. 
   Given user enters series Id in search bar as : "177985802"
   And clicks on open SSP Window.
   And verify whether dates displayed in legend area are displayed correctly.
   
   
    @Sprint5_3
   Scenario: TC_15342_02 :Verify if the dates on the legend area in chart in visual are displayed correctly.
   Given user enters series Id in search bar as : "177985802"
   And user selects View as Histogram.
   And verify whether dates displayed in legend area of Histogram are displayed correctly.
   
   @Sprint5_3
   Scenario: TC_19799_01 :Verify whether it filter outs blank observations from HeatMap
   Given user enters series Id in search bar as : "409645507;409650937"  
    And Select some series  View as HeatMap option.
    And should not show blank observations for HeatMap.
    
     @Sprint5_3
   Scenario: TC_19368_01 : Verify selecting 30 series for HeatMap
      Given User selects Thirty series
      And selects view as a HeatMap.
      And should generate HeatMap with Thirty series.
      
      
       @Sprint5_3
     Scenario Outline: TC_14654_03 : Verify set values & labels for color stops for Map 
     et values & labels for color stops for Map 
       Given user selects some series.
       And Mouse hover on series selects View as Map option.
       And Double click on the legend bar below visual
       And select gradient color with steps : "<Gradsize>"
       And select solid color with steps : "<Solidsize>".
       
       Examples:	
      |Gradsize   |Solidsize|
      | 5         | 7       |  
   
    
     @Sprint5_3
     Scenario Outline: TC_14654_04 : Verify set values & labels for color stops for HeatMap 
       Given user selects some series.
       And Mouse hover on series selects View as HeatMap option.
       And Double click on the legend bar below visual
       And select gradient color with steps : "<Gradsize>"
       And select solid color with steps : "<Solidsize>".
       
       Examples:	
      |Gradsize   |Solidsize|
      | 5         | 7       |  
   
    
      @Sprint5_3
      
       Scenario: TC_11579_01 : Verify if the Chart is dispalying upto 4 axes in visuals.
        Given user selects any four series.
        And Mouse hover on series selects View as Chart option.
        And Right Click on series below chart.
        And click on to Move to axis Option.
        
       
        @Sprint5_3
       Scenario: TC_19271_06 :Add tooltips to dots used in search ( internal series, see in tree, the node contains matches)
       Given user clicks on releases Tab 
       And hovers on green dot
       And click on series tab 
       And hover on any series=>See in database to find purple dot.
       And user enters Series Id as : "352861347" to view orange dot.
       
       
        @Sprint5_3 
       Scenario: TC_20571_01: Verify UK not shown in EU(Europe Union) Map 
       Given user clicks on all regions at left corner.
       And selects some Europe countries.
       And selects some series.
       And click View as Map=>and click on EU
       Then verify UK should not show in EU Map.
       
       @Sprint5_3
      Scenario: TC_20589_01 : Verify the Economic classifications display in series tooltip.
       Given user clicks on indicator dropdown.
       And click on All indicator tab 
       And click on apply filter
       And hover the mouse on series
       Then click on More should expand with All chains of classifications.
       
       @Sprint5_3
      Scenario: TC_11579_01 : Verify if the Chart is dispalying upto 4 axes in Edit chart
      Given user selects any four series.
      And Mouse hover on series selects View as Chart option.
      And click on Edit Chart option.
      And Click on the axis dropdown of series and choose the axis options.
      
      
       @Sprint5_3
      Scenario: TC_19798_01 : Verify Filled option for Country level Maps 
      Given user selects any Tab from China,India and Russian Federation.
      And selects some states=>Districts=>cities under them.
      And clicks on Apply filter.
      And select some series .
      And view on View on China/India/Russian Federation Map.
      
        @Sprint5_3
      Scenario: TC_19798_01: Make the Series name a mandatory attribute for users with Add-in v4 and above.
       Given user selects any four series.
       And Add into My series.
       And clicks on download button.
       And validate series Name.
       
       
      
         @Sprint5_3
      Scenario: TC_17927_01 : Verify if the chart is created for more than 30 series
       Given user selects more than 30 series 
       And click on view as a chart option.
       Then validation message should display.
       
         @Sprint5_3
      Scenario: TC_15044_08 : Verify Whether Other series are also displayed when sorted as 'New Series' along with New series.
       Given user searches for new series under more/sort with Dropdown.
       And should be able to fetch new tagged series in results.
       
       
       @Sprint5_3
      Scenario: TC_19531_05 : Support countries groups from EDGE
       Given user clicks on All regions dropdown at left corner.
       And click on All Tab
       
        @Sprint5_3
       Scenario: TC_19531_05 : Support countries groups from EDGE 
       Given user enters series Id in search bar as : "409645507;409650937"  
       And Select some series  View as HeatMap option.
       And click on download Option.
       And should not show blank observations for Heat Map.
       
       
       
       
       	
       	
       
    	
    	
   
   

   
  
