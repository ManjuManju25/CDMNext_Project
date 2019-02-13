Feature:  verifying My Series Tab Functionality

Background:
   Given User has successful logged in
   
 @MySeries
Scenario: TC_MS_01: Verify Expand view
    And Select the Expand Icon
    And Verify View panel which should be Expanded
    
@MySeries
Scenario: TC_MS_02: Verify series options if "NO" series under "My series" tab
    And Verify for "NO" series functionality under "My series" tab
    
 @MySeries
Scenario: TC_MS_03: Verify for "Preview series"
    And Select some series to my series tab
    And To right panel
    And Verify for "Preview series" in "Chart" "Table" "Series Staitics"
 
  @MySeries
Scenario: TC_MS_04: Verify "20" Maximum series for 'Preview'
    And Select 20 series to my series tab
    And Verify for "20" Maximum series for 'Preview option'   
    
#     @MySeries
#Scenario: TC_MS_05: Verify Preview option is disable for "21" series
#    And Select "21" series to my series tab
#    And Verify 'Preview option' is disable for "21" series  
    
# @MySeries
#Scenario: TC_MS_06: Verify Validation message for more than "20" series added to preview window.
#   And Select "21" series to my series tab
#    And Select preview option
#    And Verify Validation message for more than 20 series added to preview window.
#    
#  @MySeries
#Scenario: TC_MS_07: Verify "Select all" option.
#   And Select some series to my series tab
#    And Select the select all option
#    And Verify "Select all" option functionality.
#    
#     @MySeries
#Scenario: TC_MS_08: Verify "UnSelect all" option.
#   And Select some series to my series tab
#    And Select the Unselect all option
#    And Verify UnSelect all option functionality.
#    
#  
 @MySeries
Scenario: TC_MS_09: Verify "Clear All" option.
   And Select some series to my series tab
    And Verify Clear All option for "Ok" "Cancel" "Dismiss" functionality.
#    
#    @MySeries
#Scenario: TC_MS_10: Verify "Delete confirmation" message having Series.
#   And Select some series to my series tab
#    And Select the Delete option
#    And Verify Delete option functionality for Series
#    
 @MySeries
Scenario: TC_MS_11: Verify "Delete confirmation" message having Visuals.
   And Create visuals as Chart
    And Select to myseries button and select the delete option
    And Verify Delete option functionality having "pop head title" "Message" "Ok" "Cancel" "Dismiss" for Visuals
    
    
    @MySeries
Scenario: TC_MS_12: Verify "Grouping" Functionality.
    And Select some series to my series tab
    And Select the grouping function
     And Verify "Grouping" functionality for Series
     
        @MySeries
Scenario: TC_MS_13: Verify "Group Rename POP Up" Functionality.
    And Select the Group Rename option
     And Verify "Group" Rename functionality for Series
     
            @MySeries
Scenario: TC_MS_14: Verify "Ungroup" Functionality.
    And Select the UnGroup option
     And Verify UnGroup functionality for Series
     
            @MySeries
Scenario: TC_MS_15: Verify "Ungroup" option disabled status.
     And Verify UnGroup functionality disabled status when their is no Group  
     
             @MySeries
Scenario: TC_MS_16: Verify Seperator Functionality.
          And Select the Seperator option 
          And Verify Seperator functionality for Series

             @MySeries
Scenario: TC_MS_17: Verify Cut Option.
          And Select some series to my series tab 
          And Select Cut option
          And verify the Cut option

             @MySeries
Scenario: TC_MS_18: Verify Copy Option.
          And Select some series to my series tab 
          And Select Copy option
          And verify the Copy option
          
           @MySeries
Scenario: TC_MS_19: Verify Paste Option. 
          And Select Paste option
          And verify the Paste option

#          @MySeries
#Scenario: TC_MS_20: Verify Currency Conversion. 
#         And User Select Series ID  as "402529207"
#          And Select Currency Conversion
#          And verify the Currency Conversion is applied for a series
#                
#          @MySeries
#Scenario: TC_MS_21: Verify Calculate Change. 
#         And User Select Series ID  as "402529207"
#          And Select Calculate Change
#          And verify the Calculate Change is applied for a series
#          
#          @MySeries
#Scenario: TC_MS_22: Verify Aggregate. 
#         And User Select Series ID  as "402529207"
#          And Select Aggregate
#          And verify the Aggregate is applied for a series
#      
#           @MySeries
#Scenario: TC_MS_23: Verify Accumulate. 
#         And User Select Series ID  as "402529207"
#          And Select Accumulate
#          And verify the Accumulate is applied for a series
#          
          @MySeries
Scenario: TC_MS_24: Verify FX drop down. 
         And User Select Series ID  as "402529207"
          And Select FX drop down
          And verify the Function applied in FX drop down
          
          @MySeries
Scenario: TC_MS_25: Verify FX Icon. 
          And Select some series to my series tab
          And Select FX Icon
          And verify the FX Icon
#
#          @MySeries
#Scenario: TC_MS_26: Verify Type a function field. 
#         And Select some series to my series tab
#          And Select Type a function field
#          And verify Type a function field
#
         @MySeries
Scenario: TC_MS_27: Verify Checkbox for select all Series. 
          And Select 20 series to my series tab
          And Select Checkbox field
          And verify Checkbox for select all Series
          
               @MySeries
Scenario: TC_MS_28: Verify Checkbox for Unselect all Series. 
           And Select 20 series to my series tab
          And UnSelect Checkbox field
          And verify Checkbox for Unselect all Series
              
           @MySeries
Scenario: TC_MS_29: Verify Search field. 
           And Select any five series to my series tab
          And Search with series name or with series attribute 
          And Verify the Searched field functionality
          
             @MySeries
Scenario: TC_MS_30: Check for series count under My series. 
           And Select any five series to my series tab
          And Verify the series count under My series
          
           @MySeries
Scenario: TC_MS_31: Check for Selected series count under My series. 
           And Select any five series to my series tab
            And Select Checkbox field
           And Verify the Selected series count under My series
          
           @MySeries
Scenario: TC_MS_32: Verify Series in List Mode. 
           And Select any five series to my series tab
           And Verify the Selected series in List Mode