Feature: verifying My Series Tab Functionality 

Background: 
	Given User has successful logged in 
	And  User Refersh the page 
	
@MySeries1 
Scenario: TC_MS_01: Verify Expand view 
	And Select the Expand Icon 
	And Verify View panel which should be Expanded 
	
@MySeries1 
Scenario: TC_MS_02: Verify series options if "NO" series under "My series" tab 
	And Verify for "NO" series functionality under "My series" tab 
	
@MySeries1 
Scenario: TC_MS_03: Verify Related series option 
	And Select some series to my series tab 
	And Select all series 
	And select the Related series option 
	And Verify the Series suggestion manager popup 
	
@MySeries1 
Scenario: TC_MS_04: Verify Rename option 
	And Select some series to my series tab 
	And Select all series 
	And select the Rename series option 
	And Verify the Rename popup 
	
@MySeries1 
Scenario: TC_MS_05: Verify Rename option if no series selected 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify the Rename option if no series selected 
	
@MySeries1 
Scenario: TC_MS_07: Verify Rename series order in Rename popup 
	And Select some series to my series tab 
	And get the series name 
	And select the Rename series option 
	And Verify the series order in Rename popup 
	
@MySeries1 
Scenario: TC_MS_08:Verify Rename option if series selected 
	And Select some series to my series tab 
	And get the series name 
	And Select first series 
	And select the Rename series option 
	And Verify the Rename option if series selected 
	
@MySeries1 
Scenario: TC_MS_09:verify Rename option for number of available itmes 
	And Select some series to my series tab 
	And Select all series 
	And select the Rename series option 
	And Verify the Rename option for number of available itmes 
	
@MySeries1 
Scenario: TC_MS_10:verify Rename find field 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And Verify the Rename find field 
	
@MySeries1 
Scenario: TC_MS_11:verify number of searched result in rename 
	And Select random series to my series tab 
	And select the Rename series option 
	And Verify the number of searched result 
	
@MySeries1 
Scenario: TC_MS_13:verify Replace field in rename 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And select the series to be replace 
	And Verify the Replace field 
	
@MySeries1 
Scenario: TC_MS_14:verify Replace All field in rename 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And select the series to be replace 
	And Verify the Replace All field 
	
@MySeries1 
Scenario: TC_MS_15:verify Replace for selected series 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And select the series to be replace 
	And Verify the Replace for selected series 
	
	
@MySeries1 
Scenario: TC_MS_16:verify Rename Find next button 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And rename the series name as "TEST" 
	And Verify Rename Find next button 
	
@MySeries1 
Scenario: TC_MS_17:Verify Rename for find next button if search result is only one 
	And Select some series to my series tab 
	And get the series name 
	And select the Rename series option 
	And send series name to find and replace field 
	And Verify Rename Find next button is disable 
	
@MySeries1 
Scenario: TC_MS_18:Verify Rename- Replace, Replace All and Find next buttons by default 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify Rename- Replace, Replace All and Find next buttons 
	
@MySeries1 
Scenario: TC_MS_19:Verify Rename- for invalid search 
	And Select some series to my series tab 
	And select the Rename series option 
	And Send invalid keyword 
	And Verify Rename- for invalid search 
	
@MySeries1 
Scenario: TC_MS_20:Verify Rename- Edit series info dropdown. 
	And Select some series to my series tab 
	And select the Rename series option 
	And select edit series dropdown 
	And Verify edit series dropdown 
	
@MySeries1 
Scenario: TC_MS_21:Verify Rename -default selection for Edit series info dropdown. 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify default selection for Edit series info dropdown 
	
@MySeries1 
Scenario: TC_MS_22:Verify  Rename-Name selection. 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And Verify  Rename-Name selection 
	
@MySeries1 
Scenario: TC_MS_23:Verify Function Description-Name selection. 
	And Select some series to my series tab 
	And Applay Function as "Change" 
	And get the Applayied function series name 
	And select the Rename series option 
	And Verify  Function Description-Name selection 
	
	
@MySeries1 
Scenario: TC_MS_24: Verify Rename function description selection without function apply. 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify Function Description selection without function apply 
	
@MySeries1 
Scenario: TC_MS_25: Verify Rename Function description if series applied functions in My series. 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And Verify Function description if series applied functions in My series 
	
@MySeries1 
Scenario: TC_MS_26: Verify Rename - editing function description. 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And rename the function applied series "TEST" 
	And Verify Function description editing 
	
@MySeries1 
Scenario: TC_MS_28: Verify Rename - Function discription - apply original title icon. 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And Verify Function description apply original title icon 
	
	
@MySeries1 
Scenario: TC_MS_30: Verify Rename - Function discription - apply original title icon for more tha one series. 
	And Select random series to my series tab 
	And Applay Function as "Change" 
	And select the Rename series option 
	And Verify Function description apply original title icon for more tha one series 
	
@MySeries1 
Scenario: TC_MS_31: Verify Rename - Function discription -clicking on series name 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And Verify Rename Function discription clicking on series name 
	
@MySeries1 
Scenario: TC_MS_32: Verify Rename - Name- Editing series name 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name as "TESTINGSERIES" 
	And Verify Rename Name Editing series name 
	
@MySeries1 
Scenario: TC_MS_33: Verify Rename - Name - Series -Apply original title icon 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Name Series apply original title icon 
	
@MySeries1 
Scenario: TC_MS_34: Verify Rename - Name - Series for more than one -Apply original title icon 
	And Select random series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Name Series apply original title icon  for more than one series 
	
@MySeries1 
Scenario: TC_MS_35: Verify > icon if no changes in series name and description 
	And Select random series to my series tab 
	And select the Rename series option 
	And Verify > icon if no changes in series name and description 
	
@MySeries1 
Scenario: TC_MS_36: Verify Rename scroll bar if have more series in the popup 
	And Select Maximum series to my series tab 
	And select the Rename series option 
	And Verify Rename scroll bar for more series in the popup 
	
	
@MySeries1 
Scenario: TC_MS_37: Verify Rename - Apply button 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Verify Rename Apply button 
	
@MySeries1 
Scenario: TC_MS_38: Verify Rename - OK button 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Verify Rename OK button 
	
@MySeries1 
Scenario: TC_MS_39: Verify Rename - Maximize option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Maximize option 
	And Verify the Maximize option 
	
@MySeries1 
Scenario: TC_MS_40: Verify Rename - Minimize option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Minimize option 
	And Verify the Minimize option 
	
	
@MySeries1 
Scenario: TC_MS_41: Verify Rename - Fullscreen option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Fullscreen option 
	And Verify the Fullscreen option 
	
@MySeries1 
Scenario: TC_MS_42: Verify Rename - Exit Fullscreen option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the ExitFullscreen option 
	And Verify the ExitFullscreen option 
	
@MySeries1 
Scenario: TC_MS_43: Verify Rename - Cancel option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Cancel option 
	And Verify the Cancel option 
	
	
@MySeries1 
Scenario: TC_MS_44: Verify Preview series 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview pop up 
	
	
@MySeries1 
Scenario: TC_MS_45: Verify Preview-chart tab 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview-chart tab 
	
	
@MySeries1 
Scenario: TC_MS_46: Verify Preview-chart chart legend 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview chart legend 
	
@MySeries1 
Scenario: TC_MS_48: Verify Preview - hiding all series from chart 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview iding all series from chart 
	
@MySeries1 
Scenario: TC_MS_49: Verify Preview -chart - Source 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview chart Source 
	
@MySeries1 
Scenario: TC_MS_50: Verify Preview -Table tab 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview -Table tab 
	
	
@MySeries1 
Scenario: TC_MS_51: Verify Preview -Table tab-clicking on series name 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview -Table tab on clicking series name 
	
	
@MySeries1 
Scenario: TC_MS_52: Verify Preview table - Source 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview table Source 
	
	
@MySeries1 
Scenario: TC_MS_53: Verify Preview table - Statistics tab 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview Statistics tab 
	
@MySeries1 
Scenario: TC_MS_54: Verify Preview - Series statistics -clicking on series name 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview Statistics tab clicking on series name 
	
@MySeries1 
Scenario: TC_MS_55: Verify Preview - Series statistics -Source 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview Statistics tab Source 
	
@MySeries1 
Scenario: TC_MS_56: Verify Preview - Refresh 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Add some series 
	And Verify the Preview refresh icon 
	
	
@MySeries1 
Scenario: TC_MS_57: Verify Preview - Close icon 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview Close icon 
	
@MySeries1 
Scenario: TC_MS_58: Verify Preview option is disable for "21" series 
	And Select "21" series to my series tab 
	And Verify 'Preview option' is disable for "21" series 
	
@MySeries1 
Scenario: TC_MS_59: Verify "20" Maximum series for 'Preview' 
	And Select 20 series to my series tab 
	And Verify for "20" Maximum series for 'Preview option' 
	
@MySeries1 
Scenario: TC_MS_60: Verify Validation message for more than "20" series added to preview window 
	And Select "21" series to my series tab 
	And Select preview option 
	And Verify Validation message for more than 20 series added to preview window. 
	
	
@MySeries1 
Scenario: TC_MS_72: Verify "Delete confirmation" message having Series 
	And Select some series to my series tab 
	And Select the Delete option 
	And Verify Delete option functionality for Series 
	
@MySeries1 
Scenario: TC_MS_73: Verify Delete button if no series selected 
	And Verify Delete option functionality for Series 
	
	
@MySeries1 
Scenario: TC_MS_74: Verify "Delete confirmation" for pop head title message having Visuals 
	And Create visuals as Chart 
	And Select to myseries button and select the delete option 
	And Verify Delete option functionality having pop head title 
	
@MySeries1 
Scenario: TC_MS_75: Verify "Delete confirmation" for ok button in Visuals 
	And Create visuals as Chart 
	And Select to myseries button and select the delete option 
	And Verify Delete option functionality having ok button 
	
	
	
	
	# @MySeries
	#Scenario: TC_MS_03: Verify for "Preview series"
	#    And Select some series to my series tab
	#    And To right panel
	#    And Verify for "Preview series" in "Chart" "Table" "Series Staitics"
	# 
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
	# @MySeries
	#Scenario: TC_MS_09: Verify "Clear All" option.
	#   And Select some series to my series tab
	#    And Verify Clear All option for "Ok" "Cancel" "Dismiss" functionality.
	
	
	
	# @MySeries
	#Scenario: TC_MS_11: Verify "Delete confirmation" message having Visuals.
	#   And Create visuals as Chart
	#    And Select to myseries button and select the delete option
	#    And Verify Delete option functionality having "pop head title" "Message" "Ok" "Cancel" "Dismiss" for Visuals
	#    
	#    
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
	#             @MySeries
	#Scenario: TC_MS_17: Verify Cut Option.
	#          And Select some series to my series tab 
	#          And Select Cut option
	#          And verify the Cut option
	#
	#             @MySeries
	#Scenario: TC_MS_18: Verify Copy Option.
	#          And Select some series to my series tab 
	#          And Select Copy option
	#          And verify the Copy option
	#          
	#           @MySeries
	#Scenario: TC_MS_19: Verify Paste Option. 
	#          And Select Paste option
	#          And verify the Paste option
	#
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
	#          @MySeries
	#Scenario: TC_MS_24: Verify FX drop down. 
	#         And User Select Series ID  as "402529207"
	#          And Select FX drop down
	#          And verify the Function applied in FX drop down
	#          
	#          @MySeries
	#Scenario: TC_MS_25: Verify FX Icon. 
	#          And Select some series to my series tab
	#          And Select FX Icon
	#          And verify the FX Icon
	#
	#          @MySeries
	#Scenario: TC_MS_26: Verify Type a function field. 
	#         And Select some series to my series tab
	#          And Select Type a function field
	#          And verify Type a function field
	#
	#         @MySeries
	#Scenario: TC_MS_27: Verify Checkbox for select all Series. 
	#          And Select 20 series to my series tab
	#          And Select Checkbox field
	#          And verify Checkbox for select all Series
	#          
	#               @MySeries
	#Scenario: TC_MS_28: Verify Checkbox for Unselect all Series. 
	#           And Select 20 series to my series tab
	#          And UnSelect Checkbox field
	#          And verify Checkbox for Unselect all Series
	#              
	#           @MySeries
	#Scenario: TC_MS_29: Verify Search field. 
	#           And Select any five series to my series tab
	#          And Search with series name or with series attribute 
	#          And Verify the Searched field functionality
	#          
	#             @MySeries
	#Scenario: TC_MS_30: Check for series count under My series. 
	#           And Select any five series to my series tab
	#          And Verify the series count under My series
	#          
	#           @MySeries
	#Scenario: TC_MS_31: Check for Selected series count under My series. 
	#           And Select any five series to my series tab
	#            And Select Checkbox field
	#           And Verify the Selected series count under My series
	#          
	#           @MySeries
	#Scenario: TC_MS_32: Verify Series in List Mode. 
	#           And Select any five series to my series tab
	#           And Verify the Selected series in List Mode
	#
	#         @MySeries
	#Scenario: TC_MS_33: Verify Related series option.
	#         And Select any five series to my series tab
	#         And  Selected the related series
	#          And verify Related series option
	#          
	#          @MySeries
	#Scenario: TC_MS_34: Verify Rename option. 
	#         And Select any five series to my series tab
	#         And  Selected the related option.
	#          And verify Rename option
	#
	#          @MySeries
	#Scenario: TC_MS_35: Verify Rename option if no series selected. 
	#          And Select some series to my series tab
	#          And verify Rename option if no series selected
	#
	#         @MySeries
	#Scenario: TC_MS_36: Rename - Verify series order in Rename popup. 
	#          And Select some series to my series tab
	#          And verify eries order in Rename popup
	#          
	#               @MySeries
	#Scenario: TC_MS_37: Rename - verify number of selected series. 
	#           And Select some series to my series tab
	#          And verify number of selected series
	#              
	#           @MySeries
	#Scenario: TC_MS_38:Rename - verify number of available itmes. 
	#           And Select some series to my series tab
	#          And Verify the number of available itmes
	#          
	#                            @MySeries
	#Scenario: TC_MS_39: Rename - verify find field. 
	#          And Select some series to my series tab
	#            And Select Rename field
	#            And Search for the Series
	#           And Verify Result should be loaded for searched keyword
	#          
	#           @MySeries
	#Scenario: TC_MS_40: Rename - verify Replace field. 
	#           And Select any five series to my series tab
	#           And Search for the series you want to rename
	#           And Enter keyword you want to replace with
	#           And Verify the Replace field
	#
	#         @MySeries
	#Scenario: TC_MS_41:Rename - verify Replace button. 
	#         And Select any five series to my series tab
	#           And Search for the series you want to rename
	#           And Enter keyword you want to replace with
	#          And Verify the Replace field
	#          
	#          @MySeries
	#Scenario: TC_MS_42: Rename - verify Replace All button. 
	#          And Select any five series to my series tab
	#           And Search for the series you want to rename
	#           And Enter keyword you want to replace with
	#          And Verify the Replace All field
	#
	#          @MySeries
	#Scenario: TC_MS_43: Rename - verify replace for selected series. 
	#         And Select any five series to my series tab
	#           And Search for the series you want to rename
	#           And Enter keyword you want to replace with
	#          And Verify the Replace for selected field
	#
	#         @MySeries
	#Scenario: TC_MS_44: Rename - Verify Find next button. 
	#           And Select any five series to my series tab
	#           And Search for the series you want to rename
	#           And Enter keyword you want to replace with
	#           And click on replace
	#            And Verify the Find next button
	
	
 