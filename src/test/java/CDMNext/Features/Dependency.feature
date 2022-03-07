Feature: Dependency module


 @Dependency1
   Scenario:TC_01:Verify Dependencies tab in seriea suggestion manager window
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     Then Dependencies tab should be seen
    
    
  @Dependency1
     Scenario:TC_02:Verify loading dependencies in dependency tab of suggestion window
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     Then Chart of first dependencies only shown and all below are hidden
     
     
   @Dependency1
     Scenario:TC_03:Verify manage all dropdown for dependency tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on manage all dropdown
     Then Select dependencies & Unselect dependencies options should be present
     
     
 @Dependency1
     Scenario:TC_04:Verify 'Select dependencies' for manage all dropdown in dependencies tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on manage all dropdown
     And select 'Select dependencies'
     Then Add button should get colored by ticking as right with apply button enabled
     
  @Dependency
     Scenario:TC_05:Verify 'Unselect dependencies' for manage all dropdown in dependencies tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on manage all dropdown
     And select 'unselect dependencies'
     Then color turn to white with unticked Add button with disabling apply button
     
     
    @Dependency1
     Scenario:TC_06:Verify 'checking dependencies' available in dependencies tab of suggestion window
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on manage all dropdown
     Then Should be able to check all the series in dependencies
     
 @Dependency1
     Scenario:TC_07:Verify unchecking dependencies available in dependencies tab of suggestion window
     
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on manage all dropdown
      And click on manage all dropdown
    Then Should be able to 'uncheck all the series' in dependencies
     
   @Dependency1
     Scenario:TC_08:Verify adding any of the single dependencies for suggestion
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on any of the series add button
     Then Should be able to check that particular series and added to apply required changes
     
     

     
@Dependency1
     Scenario:TC_09:Verify 'closing chart' for first dependencies series in dependencies tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on 'chart icon' of first dependencies series
     Then 'Chart opened' should be closed
      
     
     
  @Dependency1
     Scenario:TC_10:Verify opening chart for rest of dependencies series in dependencies tab
     
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And  Click on chart icon of rest of the dependencies series except the first one
     Then Should be able to shown chart for dependencies with its legends and as in SSP window
     
     
      @Dependency1
     Scenario:TC_11:Verify 'series tooltip for dependencies' under dependencies suggestion tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And  mouse Hover on any of the series present under dependencies tab
     Then Should be shown with series tooltip

      @Dependency1
     Scenario:TC_12:Verify open SSP for series under dependencies tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on any of the series under dependencies tab
     Then Should be open with SSP window for respective series

    
    @Dependency1
     Scenario:TC_13:Verify manual adding of dependencies in suggestion tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on Add button for dependencies present
     Then Should be able to add series manual and apply button should be enabled
     
     @Dependency1
      
     Scenario:TC_14:Verify 'Cancel button' for selected dependencies in suggestion tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on manage all dropdown
     And Click on Add button for dependencies present
     Then Should be able to close suggestion window without adding any of the dependencies in my series
     
   
     @Dependency1
     Scenario:TC_15:Verify applying dependencies for selected series
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on Add button for dependencies present
     And Click on apply and ok button
     Then Should be able to add dependencies for selected series under dependencies tab
     
     @Dependency
     Scenario:TC_16:Verify dependencies tab switching from any other tabs present in a suggestion window
    
     And User Select Series ID as "454809317;32189801"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And swiching between dependence tab to forecast tab
     And swiching between forecast tab to indicators tab
     
     
     
     
     @Dependency
     Scenario:TC_17:Verify 'click on minimize icon' for dependencies expanded
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on minimize icon for dependencies present in a tab
     #Then dependencies tab should be minimmized
     
     @Dependency
      Scenario:TC_18:Verify 'click on Miximize icon' for dependencies contrasted
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on minimize icon for dependencies present in a tab
     Then click on miximize icon for dependence contrasted
     
    @Dependency1
       Scenario:TC_19:Verify 'minimizing series suggestion tab' with dependencies tab open
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
    And Click on any of the series under dependencies tab
     Then click on the minimizing icon in SSP Window
     
    @Dependency1
      Scenario:TC_20:Verify 'maximizing series suggestion tab' with dependencies tab
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
    And Click on any of the series under dependencies tab
     And click on the minimizing icon in SSP Window
     Then click on the maximizing icon in SSP window
     
     
     
     @Dependency1
     Scenario:TC_21:Verify 'full-screen'for suggestion window with dependencies tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on full-screen icon
     Then Should attain full-screen state with dependencies tab open
     
     
     @Dependency1
      Scenario:TC_22:Verify attaining normal window open state for dependencies tab once it is full screened
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
      And click on full-screen icon
      And Click on double arrow again facing inwards
      Then Window should attain normal/usual open state with dependencies tab open
    
     @Dependency1
     Scenario:TC_23:Verify 'closing series suggestion manager window' with dependencies tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on cross mark(X) button of a suggestion window
     Then Window should be able to be closed
     
     
     
  @Dependency
     Scenario:TC_24:Verify creating visuals with added dependencies in my series tab
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on Add button for dependencies present
     And Click on apply and ok button
     And create visuals of the my series like table
     Then Should be able to create selectedvisuals
    
   @Dependency
     Scenario:TC_25:Verify opening SSP window for dependencies series
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on series name in dependencies series
     Then SSP window for dependencies series should be opened
     
     
   @Dependency
     Scenario:TC_26:Verify closing SSP window for dependencies series
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on series name in dependencies series
     And SSP window for dependencies series should be opened
     And  closing SSP window using cross mark
     Then SSP window for dependencies series should be closed
     
       @Dependency
    Scenario:TC_27: Verify 'disabling series present in a chart of dependencies series'
    And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on legend series cross box option
     #And disabling series present in a chart with legend series cross box option
     Then Series present in a chart should be disabled
     
     
       @Dependency
    Scenario:TC_27: Verify 'enabling series present in a chart of dependencies series'
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And click on legend series cross box option
     And click on legend series cross box option
    # And disabling series present in a chart with legend series cross box option
     Then Series in a chart should be enabled
      
   @Dependency
     Scenario:TC_29:Verify scrollbar for dependencies tab in series suggestion manager window
     
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     Then Scrollbar should be movable (ups/downs)
     
     
      @Dependency
    Scenario:TC_30:Verify timepoints and series info tooltips for legend series in a chart of dependencies tab 
     And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And mouse hover on the legend series
     Then Timepoints & series info has to be shown in its tooltip
     
     

     
   @Dependency
     Scenario:TC_31:Verify 'ok button for clicking on cross mark' of add related series window
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on Add button for dependencies present
     And click on cross mark in add related series window
     And click on OK button
    # Then should be close add related series window
     And click on related series
     And Navigate to dependencies tab
     Then should be able reflect changes made on dependency series in my series tab
     
     
     
     
   @Dependency
     Scenario:TC_32:Verify cancel button for clicking on cross mark of add related series window
      And User Select Series ID as "384240277;454809317"
     And click on datasets
     And add some of series into my series tab
     And click on related series
     And Navigate to dependencies tab
     And Click on Add button for dependencies present
     And click on cross mark in add related series window
     Then should be able reflect changes made on dependency series but should not close add related series window
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     