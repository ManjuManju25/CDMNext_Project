Feature: Verify C icon for continous series.

  @Sprint6_0
  Scenario: Tc_Conti_01 : Verify C icon for continous series
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    Then Series with tag C  should be displayed infront of series.
   
     @Sprint6_0
   Scenario: Tc_Conti_03 : Verify tooltip for continuous series.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And clicks on any continuos series.
    Then hover mouse on question mark of show continuos series.
    
    @Sprint6_0
   Scenario: Tc_Conti_04 : Verify continuous chart in ssp.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And clicks on any continuos series.
    And continuos series must be showm with time Period "All".
    
     @Sprint6_0
   Scenario: Tc_Conti_05 : Verify continuous series in my series when add as continuous.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    #And User has clicked on "Apply filter"
    And select continuos checkbox.
    And clicks on any continuos series.
    And Open Add in SSP->click on Add as continuos series.
    
     @Sprint6_0
   Scenario: Tc_Conti_06 : Verify continuous tag for continuous series.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
   # And select continuos checkbox.	
   
    And add as continuos series.
    And Continuous series must be shown with continuous tag.
    
     #@Sprint6_0	
     
   #Scenario: Tc_Conti_02 : Verify Global key series/Forecasting service db for continuous series
    #Given User selects More dropdown
    #And clicks on Keys only series icon.
    #And clicks on Apply filter button.
    #And seleceted Db doesn't show with continuos series.
    
     @Sprint6_0
   Scenario: Tc_Conti_20 :Verify Favorite function on continuous series
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
   # And select continuos checkbox.
    And add as continuos series.
    And make series as Favourite.
    
     @Sprint6_0
  Scenario: Tc_Conti_09 :Verify additiional function on continuous series
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
   # And select continuos checkbox.
    And add as continuos series.
    And apply other function.
    
     @Sprint6_0
  Scenario: Tc_Conti_12: Verify continuous tab for continuous series
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And clicks on add icon.
    And select series=>click related series
    And check for continuos tab.
   
    @Sprint6_0
  Scenario: Tc_Conti_13: Verify continuous tab for continuous series
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And clicks on add icon.
    And select series=>refresh Insight.
    And check for continuos tab in insight.
    
     @Sprint6_0
  Scenario: Tc_Conti_19: Verify Preserve name check box for continuous tab
     Given User selects More dropdown
     And clicks on continuos series icon.
     And clicks on Apply filter button.
     And select some series into series tab.
     And click on related tab.
     #And clicks on add icon.
     #And select series=>click related series
    # And check for continuos tab.
     And check for preserve Name.
     
      @Sprint6_0
  Scenario: Tc_Conti_02: Verify Global key series/Forecasting service db for continuous series.
  Given User enters Series Id in Search bar as :"408940397".
  And hovered mouse on series=>See in Database=>Select Global Key Series Database.
  Then selected DB should not be shown in continuos series.
  
    @Sprint6_0
  Scenario: Tc_Conti_10 :Verify remove pre function in my series
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And add as continuos series.
    And apply other function.
    And remove Pre-Applied function.
    
     @Sprint6_0
  Scenario: Tc_Conti_15:Verify continuous tab add continous series
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And select some series into series tab.
    And click on related tab.
    And click on Manage all dropdown=>Add continuos series=>Apply ok
    Then all continuos series should be added into my series.
    
    @Sprint6_0
  Scenario: Tc_Conti_16:Verify continuous tab add contributed series.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And select some series into series tab.
    And click on related tab.
    And click on Manage all dropdown=>Add contributed series=>Apply ok
    Then all contributed series should be added into my series.
    
     @Sprint6_0
  Scenario: Tc_Conti_17:Verify coninuous tab replace selected series.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And select some series into series tab.
    And click on related tab.
    And click on Manage all dropdown=>Add replace selected series=>Apply ok
    Then selected series will be replaced by continuos series
     
    @Sprint6_0
  Scenario: Tc_Conti_18:Verify continuous tab delete continuous series.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And select some series into series tab.
    And click on related tab.
    And click on Manage all dropdown=>Add delete selected series=>Apply ok
    Then selected series will be deleted from my series
    
    @Sprint6_0
  Scenario: Tc_Conti_14: Verify  continuous tab manage all.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And select some series into series tab.
    And click on related tab.
    And click on Manage all dropdown.
    
     @Sprint6_0
  Scenario: Tc_Conti_07: Verify download continuous series.
    Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And add as continuos series.
    And click on download button=>Download to excel.
    Then validate the "Name your insight" Sheet and read the '11' '1' row and column and verify the Preapplied-function
    
    
    @Sprint6_0
   Scenario: Tc_Conti_21: Verify other favorited function on continuous series.
   Given User selects More dropdown
    And clicks on continuos series icon.
    And clicks on Apply filter button.
    And add as continuos series.
    And select favorite function on continuos series
    Then favourite function should be applied with pre-applied function
   
    
    
    
    
    
   
  
    
    
    
    	
    		
    		