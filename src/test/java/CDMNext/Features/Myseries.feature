Feature:  verifying My Series Tab Functionality

Background:
   Given User has successful logged in
   
   
 @MySeries
Scenario: TC_MS_01: Verify Expand view
    And Select the Expand Icon
    And Verify View panel which should be Expanded
    
@MySeries
Scenario: TC_MS_02: Verify series options if "NO" series under "My series" tab
    And deselect the series if the Series is present
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
    
     @MySeries
Scenario: TC_MS_05: Verify Preview option is disable for "21" series
    And Select "21" series to my series tab
    And Verify 'Preview option' is disable for "21" series  
    
 @MySeries
Scenario: TC_MS_06: Verify Validation message for more than "20" series added to preview window.
   And Select "21" series to my series tab
    And Select preview option
    And Verify Validation message for more than 20 series added to preview window.
    
#  @MySeries
#Scenario: TC_MS_07: Verify "Select all" option.
#   And Select some series to my series tab
#    And Select the select all option
#    And Verify "Select all" option functionality.
    
#     @MySeries
#Scenario: TC_MS_08: Verify "UnSelect all" option.
#   And Select some series to my series tab
#    And Select the Unselect all option
#    And Verify UnSelect all option functionality.
#    
    
# @MySeries
#Scenario: TC_MS_09: Verify "Clear All" option.
#   And Select some series to my series tab
#    And Select the Clear All  option
#    And Verify Clear All option for "Ok" "Cancel" "Dismiss" functionality.
    
#    @MySeries
#Scenario: TC_MS_10: Verify "Delete confirmation" message having Series.
#   And Select some series to my series tab
#    And Select the Delete option
#    And Verify Delete option functionality for Series
    
# @MySeries
#Scenario: TC_MS_11: Verify "Delete confirmation" message having Visuals.
#   And Create visuals as Chart
#    And Select to myseries button and select the delete option
#    And Verify Delete option functionality having "pop head title" "Message" "Ok" "Cancel" "Dismiss" for Visuals
    
    
#    @MySeries
#Scenario: TC_MS_12: Verify "Grouping" Functionality.
#    And Select some series to my series tab
#    And Select the grouping function
#     And Verify "Grouping" functionality for Series
#     
#        @MySeries
#Scenario: TC_MS_13: Verify "Group Rename POP Up" Functionality.
#    And Select the Group Rename option
#     And Verify "Group" Rename functionality for Series
#     
#            @MySeries
#Scenario: TC_MS_14: Verify "Ungroup" Functionality.
#    And Select the UnGroup option
#     And Verify UnGroup functionality for Series
#     
#            @MySeries
#Scenario: TC_MS_15: Verify "Ungroup" option disabled status.
#     And Verify UnGroup functionality disabled status when their is no Group  
#     
#             @MySeries
#Scenario: TC_MS_16: Verify Seperator Functionality.
#          And Select the Seperator option 
#          And Verify Seperator functionality for Series
#      