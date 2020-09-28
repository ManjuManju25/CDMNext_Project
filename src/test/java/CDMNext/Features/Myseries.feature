Feature: verifying My Series Tab Functionality 

#Background: 
#	Given User has successful logged in 
	#And Check for popup
	#And Check for prerequesties
	#And  User Refersh the page
	#And Check for the Start new pop up
	#And clear the selected series and seriesID 
	
@MySeries
Scenario: TC_MS_01: Verify Expand view 
	And Select the Expand Icon 
	And Verify View panel which should be Expanded 
	
@MySeries
Scenario: TC_MS_02: Verify series options if "NO" series under "My series" tab 
	And Verify for "NO" series functionality under "My series" tab 
	
@MySeries
Scenario: TC_MS_03: Verify Related series option 
	And Select some series to my series tab 
	And Select all series 
	And select the Related series option 
	And Verify the Series suggestion manager popup 
	
@MySeries
Scenario: TC_MS_04: Verify Rename option 
	And Select some series to my series tab 
	And Select all series 
	And select the Rename series option 
	And Verify the Rename popup 
	
@MySeries
Scenario: TC_MS_05: Verify Rename option if no series selected 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify the Rename option if no series selected 
	
@MySeries
Scenario: TC_MS_07: Verify Rename series order in Rename popup 
	And Select some series to my series tab 
	And get the series name 
	And select the Rename series option 
	And Verify the series order in Rename popup 
	
@MySeries
Scenario: TC_MS_08:Verify Rename option if series selected 
	And Select some series to my series tab 
	And get the series name 
	And Select first series 
	And select the Rename series option 
	And Verify the Rename option if series selected 
	
@MySeries
Scenario: TC_MS_09:verify Rename option for number of available itmes 
	And Select some series to my series tab 
	And Select all series 
	And select the Rename series option 
	And Verify the Rename option for number of available itmes 
	
@MySeries
Scenario: TC_MS_10:verify Rename find field 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And Verify the Rename find field 
	
@MySeries
Scenario: TC_MS_11:verify number of searched result in rename 
	And Select random series to my series tab 
	And select the Rename series option 
	And Verify the number of searched result 
	
@MySeries 
Scenario: TC_MS_13:verify Replace field in rename 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And select the series to be replace 
	And Verify the Replace field 
	
@MySeries 
Scenario: TC_MS_14:verify Replace All field in rename 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And select the series to be replace 
	And Verify the Replace All field 
	
@MySeries
Scenario: TC_MS_15:verify Replace for selected series 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And select the series to be replace 
	And Verify the Replace for selected series 
	
	
@MySeries
Scenario: TC_MS_16:verify Rename Find next button 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And rename the series name as "TEST" 
	And Verify Rename Find next button 
	
@MySeries
Scenario: TC_MS_17:Verify Rename for find next button if search result is only one 
	And Select some series to my series tab 
	And get the series name 
	And select the Rename series option 
	And send series name to find and replace field 
	And Verify Rename Find next button is disable 
	
@MySeries
Scenario: TC_MS_18:Verify Rename- Replace, Replace All and Find next buttons by default 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify Rename- Replace, Replace All and Find next buttons 
	
@MySeries
Scenario: TC_MS_19:Verify Rename- for invalid search 
	And Select some series to my series tab 
	And select the Rename series option 
	And Send invalid keyword 
	And Verify Rename- for invalid search 
	
@MySeries
Scenario: TC_MS_20:Verify Rename- Edit series info dropdown. 
	And Select some series to my series tab 
	And select the Rename series option 
	And select edit series dropdown 
	And Verify edit series dropdown 
	
@MySeries 
Scenario: TC_MS_21:Verify Rename -default selection for Edit series info dropdown. 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify default selection for Edit series info dropdown 
	
@MySeries
Scenario: TC_MS_22:Verify  Rename-Name selection. 
	And Select random series to my series tab 
	And get the series name 
	And select the Rename series option 
	And Verify  Rename-Name selection 
	
@MySeries 
Scenario: TC_MS_23:Verify Function Description-Name selection. 
	And Select some series to my series tab 
	And Applay Function as "Change" 
	And get the Applayied function series name 
	And select the Rename series option 
	And Verify  Function Description-Name selection 
	
	
@MySeries
Scenario: TC_MS_24: Verify Rename function description selection without function apply. 
	And Select some series to my series tab 
	And select the Rename series option 
	And Verify Function Description selection without function apply 
	
@MySeries
Scenario: TC_MS_25: Verify Rename Function description if series applied functions in My series. 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And Verify Function description if series applied functions in My series 
	
@MySeries
Scenario: TC_MS_26: Verify Rename - editing function description. 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And rename the function applied series "TEST" 
	And Verify Function description editing 
	
@MySeries
Scenario: TC_MS_28: Verify Rename - Function discription - apply original title icon. 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And Verify Function description apply original title icon 
	
	
@MySeries12345
Scenario: TC_MS_30: Verify Rename - Function discription - apply original title icon for more tha one series. 
	#And Select random series to my series tab 
	 And User Select Series ID  as "402529207"
	And Applay Function as "Change" 
	And select the Rename series option 
	And Verify Function description apply original title icon for more tha one series 
	
@MySeries
Scenario: TC_MS_31: Verify Rename - Function discription -clicking on series name 
	And Select some series to my series tab 
	And select any series to applay function 
	And select the Rename series option 
	And Verify Rename Function discription clicking on series name 
	
@MySeries
Scenario: TC_MS_32: Verify Rename - Name- Editing series name 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name as "TESTINGSERIES" 
	And Verify Rename Name Editing series name 
	
@MySeries
Scenario: TC_MS_33: Verify Rename - Name - Series -Apply original title icon 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Name Series apply original title icon 
	
@MySeries
Scenario: TC_MS_34: Verify Rename - Name - Series for more than one -Apply original title icon 
	And Select random series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Name Series apply original title icon  for more than one series 
	
@MySeries
Scenario: TC_MS_35: Verify > icon if no changes in series name and description 
	And Select random series to my series tab 
	And select the Rename series option 
	And Verify > icon if no changes in series name and description 
	
@MySeries
Scenario: TC_MS_36: Verify Rename scroll bar if have more series in the popup 
	And Select Maximum series to my series tab 
	And select the Rename series option 
	And Verify Rename scroll bar for more series in the popup 
	
	
@MySeries
Scenario: TC_MS_37: Verify Rename - Apply button 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Verify Rename Apply button 
	
@MySeries
Scenario: TC_MS_38: Verify Rename - OK button 
	And Select some series to my series tab 
	And select the Rename series option 
	And Change the series name 
	And Verify Rename OK button 
	
@MySeries
Scenario: TC_MS_39: Verify Rename - Maximize option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Maximize option 
	And Verify the Maximize option 
	
@MySeries
Scenario: TC_MS_40: Verify Rename - Minimize option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Minimize option 
	And Verify the Minimize option 
	
	
@MySeries
Scenario: TC_MS_41: Verify Rename - Fullscreen option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Fullscreen option 
	And Verify the Fullscreen option 
	
@MySeries
Scenario: TC_MS_42: Verify Rename - Exit Fullscreen option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the ExitFullscreen option 
	And Verify the ExitFullscreen option 
	
@MySeries
Scenario: TC_MS_43: Verify Rename - Cancel option 
	And Select some series to my series tab 
	And select the Rename series option 
	And select the Cancel option 
	And Verify the Cancel option 
	
	
@MySeries
Scenario: TC_MS_44: Verify Preview series 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview pop up 
	
	
@MySeries
Scenario: TC_MS_45: Verify Preview-chart tab 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview-chart tab 
	
	
@MySeries
Scenario: TC_MS_46: Verify Preview-chart chart legend 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview chart legend 
	
@MySeries
Scenario: TC_MS_48: Verify Preview - hiding all series from chart 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview iding all series from chart 
	
@MySeries
Scenario: TC_MS_49: Verify Preview -chart - Source 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview chart Source 
	
@MySeries 
Scenario: TC_MS_50: Verify Preview -Table tab 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview -Table tab 
	
	
@MySeries
Scenario: TC_MS_51: Verify Preview -Table tab-clicking on series name 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview -Table tab on clicking series name 
	
	
@MySeries
Scenario: TC_MS_52: Verify Preview table - Source 
 And search for the Series ID  as "310902301" 
	And Select all series 
	And select the preview option 
	And Verify the Preview table Source 
	
	
@MySeries
Scenario: TC_MS_53: Verify Preview table - Statistics tab 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview Statistics tab 
	
@MySeries
Scenario: TC_MS_54: Verify Preview - Series statistics -clicking on series name 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview Statistics tab clicking on series name 
	
@MySeries
Scenario: TC_MS_55: Verify Preview - Series statistics -Source 
	 And search for the Series ID  as "310902301" 
	And Select all series 
	And select the preview option 
	And Verify the Preview Statistics tab Source 
	
@MySeries
Scenario: TC_MS_56: Verify Preview - Refresh 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Add some series 
	And Verify the Preview refresh icon 
	
	
@MySeries
Scenario: TC_MS_57: Verify Preview - Close icon 
	And Select some series to my series tab 
	And Select all series 
	And select the preview option 
	And Verify the Preview Close icon 
	
@MySeries
Scenario: TC_MS_58: Verify Preview option is disable for "21" series 
	And Select "21" series to my series tab 
	And Verify 'Preview option' is disable for "21" series 
	
@MySeries
Scenario: TC_MS_59: Verify "20" Maximum series for 'Preview' 
	And Select 20 series to my series tab 
	And Verify for "20" Maximum series for 'Preview option' 
	
@MySeries
Scenario: TC_MS_60: Verify Validation message for more than "20" series added to preview window 
	And Select "21" series to my series tab 
	And Select preview option 
	And Verify Validation message for more than 20 series added to preview window. 
	
	
@MySeries
Scenario: TC_MS_72: Verify "Delete confirmation" message having Series 
	And Select some series to my series tab 
	And Select the Delete option 
	And Verify Delete option functionality for Series 
	
@MySeries
Scenario: TC_MS_73: Verify Delete button if no series selected 
	And Verify Delete option functionality for Series 
	
	
@MySeries
Scenario: TC_MS_74: Verify "Delete confirmation" for pop head title message having Visuals 
	And Create visuals as Chart 
	And Select to myseries button and select the delete option 
	And Verify Delete option functionality having pop head title 
	
@MySeries
Scenario: TC_MS_75: Verify "Delete confirmation" for ok button in Visuals 
	And Create visuals as Chart 
	And Select to myseries button and select the delete option 
	And Verify Delete option functionality having ok button 
	
@MySeries
Scenario: TC_MS_76: Verify "Delete confirmation" associated visuals after deleted series 
	And Create visuals as Chart 
	And Select to myseries button and select the delete option 
	And Verify Delete option associated visuals after deleted series	
		
	@MySeries
Scenario: TC_MS_77: Verify Delete Cancel/x icon for the popup
	And Create visuals as Chart 
	And Select to myseries button and select the delete option 
	And Verify Delete Cancel/x icon for the popup
	
	
	    @MySeries
	Scenario: TC_MS_78: Verify "Grouping" Functionality
	    And Select some series to my series tab
	    And Select the grouping function
	     And Verify "Grouping" functionality for Series
	
	   @MySeries
	Scenario: TC_MS_79: Verify dropdown for grouping 
	    And Select some series to my series tab
	    And Select the grouping dropdown
	     And Verify Grouping dropdown
	
	  @MySeries
	Scenario: TC_MS_80: Verify grouping Functionality by selecting icon  
	    And Select some series to my series tab
	    And Select the grouping icon
	      And Verify "Grouping" functionality for Series
	
	  @MySeries
	Scenario: TC_MS_81:Verify Group rename popup  
	    And Select some series to my series tab
	    And Select the grouping icon
	      And Verify Group rename popup
	
	        @MySeries
	Scenario: TC_MS_82: Verify "Group Rename POP Up" Functionality
	      And Select some series to my series tab
	    And Select the grouping icon
	     And Verify "Group" Rename functionality for Series
	
	        @MySeries
	Scenario: TC_MS_83:Verify Cancel icon for group rename popup
	      And Select some series to my series tab
	    And Select the grouping icon
	     And Verify Cancel icon for group rename popup
	
	
	      @MySeries
	Scenario: TC_MS_84: Verify "Ungroup" Functionality
	    And Select some series to my series tab
	    And Select the grouping icon
	    And Select the UnGroup option
	     And Verify UnGroup functionality for Series
	
	
	      @MySeries
	Scenario: TC_MS_85: Verify Ungroup option disabled status
	 And Select some series to my series tab
	And Select all series 
	And Verify UnGroup functionality disabled status when their is no Group 
	
	
	             @MySeries
	Scenario: TC_MS_86: Verify Seperator Functionality
	       And Select random series to my series tab 
	          And Select all series 
	          And Select the Seperator option 
	          And Verify Seperator functionality for Series
	
	             @MySeries
	Scenario: TC_MS_87: Verify Move Up option
	       And Select random series to my series tab 
	       And Select all series 
	          And get the text of the first series
	          And Select the Move Up option 
	          And get the text of the next first series
	          And Verify Move Up option
	
	             @MySeries
	Scenario: TC_MS_88: Verify Move down option
	       And Select random series to my series tab 
	       And Select all series 
	          And get the text of the first series
	          And Select the Move down option 
	          And get the text of the next first series
	          And Verify Move down option
	
		             @MySeries
	Scenario: TC_MS_89: Verify Move top option
	       And Select random series to my series tab 
	       And Select all series 
	         And get the text of the first series
	          And Select the Move top option 
	          And get the text of the next first series
	          And Verify Move top option
	
		             @MySeries
	Scenario: TC_MS_90: Verify Move bottom option
	       And Select random series to my series tab 
	       And Select all series 
	          And get the text of the first series
	          And Select the Move bottom option 
	          And get the text of the next first series
	          And Verify Move bottom option
	          
	                      @MySeries
	Scenario: TC_MS_91: Verify Cut Option
	          And Select some series to my series tab 
	          And Select Cut option
	          And verify the Cut option
	          
	               @MySeries
	Scenario: TC_MS_92: Validate Cut series by pasting
	          And Select some series to my series tab 
	          And get the text of the first series
	          And Select Cut option
	          And create a new insight
	          And Select paste option
	          And verify the paste option  
	          
	          
	             @MySeries
	Scenario: TC_MS_93: Verify the confirmation message for Cut action
	          And Select some series to my series tab 
	          And Select Cut option
	          And verify the confirmation message for Cut action   
	          
	                 @MySeries
	Scenario: TC_MS_94: Verify the confirmation message for paste action
	          And Select some series to my series tab 
	          And Select Cut option
	           And create a new insight
	          And Select paste option            
	          And verify the confirmation message for paste action
	          
	             @MySeries
	Scenario: TC_MS_95: Verify closing of growl popup
	          And Select some series to my series tab 
	          And Select Cut option       
	          And verify the closing of growl popup       
	          
	           @MySeries
	Scenario: TC_MS_96: Verify Copy option
	          And Select some series to my series tab 
	          And Select Copy option
	          And verify the Copy option 
	          
	          
	             @MySeries
	Scenario: TC_MS_97: Verify the confirmation message for Copy action
	          And Select some series to my series tab 
	          And Select Copy option         
	          And verify the confirmation message for Copy action       
	          
	                      @MySeries
	Scenario: TC_MS_98: Verify Paste option
	          And Select some series to my series tab 
	          And Select Copy option   
	          And Select Paste option         
	          And verify the Paste option           
	          
	                  @MySeries
	Scenario: TC_MS_99: Verify Currency Conversion 
	         And User Select Series ID  as "402529207"
	          And Select Currency Conversion
	          And verify the Currency Conversion is applied for a series  
	          
	          
	             @MySeries
	Scenario: TC_MS_100: Verify Calculate Change
	         And User Select Series ID  as "402529207"
	          And Select Calculate Change
	          And verify the Calculate Change is applied for a series       
	          
	              
	          @MySeries
	Scenario: TC_MS_101: Verify Aggregate 
	         And User Select Series ID  as "402529207"
	          And Select Aggregate
	          And verify the Aggregate is applied for a series     
	          
	           @MySeries
	Scenario: TC_MS_102: Verify Accumulate 
	         And User Select Series ID  as "402529207"
	          And Select Accumulate
	          And verify the Accumulate is applied for a series         
	          
	          
	                  @MySeries
	Scenario: TC_MS_103: Verify FX drop down 
	         And User Select Series ID  as "402529207"
	          And Select FX drop down
	          And verify the Function applied in FX drop down  
	          
	               
	          @MySeries
	Scenario: TC_MS_104: Verify FX Icon 
	          And Select some series to my series tab
	          And Select FX Icon
	          And verify the FX Icon     
	          
	            @MySeries
	Scenario: TC_MS_105: Verify appling function by clicking on function icon 
	          And Select some series to my series tab
	          And Select FX Icon
	          And Applay "Change" function
	          And verify appling function by clicking on function icon       
	     
	             @MySeries
	Scenario: TC_MS_106: Verify hiding function toolbar 
	          And Select some series to my series tab
	          And Select all series 
	          And Select hiding toolbar
	          And verify hiding function toolbar     
	     
	     	     @MySeries
	Scenario: TC_MS_107: Verify Expanding the fuction toolbar 
	          And Select some series to my series tab
	          And Select all series 
	          And Select Expanding toolbar
	          And verify Expanding function toolbar 
	          
	          
	             @MySeries
	Scenario: TC_MS_108: Verify function field 
	          And Select some series to my series tab
	          And Select all series 
	          And Select function field
	          And verify function field   
	          
	                 
	           @MySeries
	Scenario: TC_MS_109: Verify Checkbox for select all/unselect all 
	          And Select some series to my series tab
	          And Select all series 
	          And verify Checkbox for select all
	           And UnSelect all series 
	          And verify Checkbox for unselect all
	          
	            @MySeries
	Scenario: TC_MS_110: Verify total number of series in my series 
	        And Select random series to my series tab 
	           And get the count of the series in my series panel
	          And verify total number of series in my series         
	          
	                @MySeries
	Scenario: TC_MS_111: Verify number of selected series 
	          And Select random series to my series tab 
	          And Select all series 
	          And verify the number of selected series        
	          
	                 @MySeries
	Scenario: TC_MS_112: Verify remove icon for selected series 
	          And Select random series to my series tab 
	          And Select all series 
	          And Select the X icon
	          And verify remove icon for selected series          
	          
	          
	                     @MySeries
	Scenario: TC_MS_113: Verify Search field in my series panel
	          And Select random series to my series tab 
	          And search for the serie as "Population Projection"
	          And verify serie "Population Projection" appeared       
	          
	                     @MySeries
	Scenario: TC_MS_115: Verify Addition highlight in My series
	          And Select some series to my series tab 
	          And verify Addition highlight in My series            
	          
	            @MySeries
	Scenario: TC_MS_116:Verify List/Table mode
	          And Select random series to my series tab   
	          And Select the List mode
	           And verify the List mode
	          And Select the Table mode
	          And verify the Table mode
	           
	          
	             @MySeries
	Scenario: TC_MS_117:Verify Customize your selection option
	          And Select random series to my series tab   
	          And Select the Customize option
	           And verify the Customize option
	          
	
	             @MySeries
	Scenario: TC_MS_118:Customize- Verify show selection in -> Table mode 
	          And Select random series to my series tab   
	          And Select the Customize option
	            And Select the Table mode in Customize window
	          And Verify show selection in Table mode 
	
	             @MySeries
	Scenario: TC_MS_119:Customize- Verify show selection in -> List mode 
	          And Select random series to my series tab   
	          And Select the Customize option
	            And Select the List mode in Customize window
	          And Verify show selection in List mode 
	
	
	             @MySeries
	Scenario: TC_MS_120:Customize - Verify show selection in -> Table mode selection 
	          And Select random series to my series tab   
	          And Select the Customize option
	          And Select the Table mode in Customize window for show in
	          And Verify hidden show selection in Table mode
	
	             @MySeries
	Scenario: TC_MS_121:Customize - Verify show selection in -> List mode -> 2 row  
	          And Select random series to my series tab   
	          And Select the Customize option
	          And Select the List mode in Customize window for show in
	          And select the required attribute
	          And Verify show selection in List mode of 2 row
	
	
	             @MySeries
	Scenario: TC_MS_122:Customize - Verify Show series in list -> 1 row  
	          And Select random series to my series tab   
	          And Select the Customize option
	          And Select the List mode in Customize window for show in
	          And select the Show series in list as 1 row
	          And Verify show selection in List mode of one row
	
	             @MySeries
	Scenario: TC_MS_125:Customize - Verify Table columns for table mode  
	          And Select random series to my series tab   
	          And Select the Customize option
	          And Select the Table mode in Customize window for show in
	          And select the required attribute for table mode
	          And Verify Table columns for table mode
	
	
	             @MySeries
	Scenario: TC_MS_126:Customize - Verify Sort series by  
	          And Select random series to my series tab 
	          And Select the second series  
	          And Select the Customize option
	          And select the Sort series by option 
	          And Verify the Sort series by option 
	
	             @MySeries
	Scenario: TC_MS_127:Customize - Verify Reset option
	          And Select random series to my series tab 
	          And Select the Customize option
	          And Select the Table mode in Customize window for show in
	           And select the required attribute for table mode
	          And Verify the Reset option
	
	             @MySeries
	Scenario: TC_MS_128:Customize - Verify Save option
	          And Select random series to my series tab   
	          And Select the Customize option
	          And Select the Table mode in Customize window for show in
	          And select the required attribute for table mode
	          And Verify Save option
	
	             @MySeries
	Scenario: TC_MS_129:Customize - Verify Cancel/X  
	          And Select random series to my series tab   
	          And Select the Customize option
	          And Select the Cancel/X option
	          And Verify the Cancel/X option
	
	             @MySeries
	Scenario: TC_MS_131:Verify suggested indicator
	          And Select series to my series tab of different country 
	          And Select all series   
	         And select the Related series option 
	          And Verify suggested indicator
	
	
	             @MySeries
	Scenario: TC_MS_133:Verify Suggested indicators -(i) icon
	           And Select random series to my series tab 
	          And Select all series   
	         And select the Related series option 
	        And select the (i) icon
	          And Verify Suggested indicators (i) icon
	
	             @MySeries
	Scenario: TC_MS_134:Verify Suggested indicators -(i) icon tootltip
	           And Select random series to my series tab 
	          And Select all series   
	         And select the Related series option 
	         #And mover the (i) icon
	          And Verify Suggested indicators tooltip for (i) icon
	          
	             @MySeries
	Scenario: TC_MS_135:Verify Suggested indicators -contries tab
	           And Select random series to my series tab 
	          And Select all series   
	         And select the Related series option 
	          And Verify contries tab under suggested indicator
	
	
	             @MySeries
	Scenario: TC_MS_136:Verify Suggested indicators -max contires display
	          And Select random six different series to my series tab 
	          And Select all series   
	          And select the Related series option 
	          And Verify max contires display
	

             @MySeries
	Scenario: TC_MS_137:Verify Suggested indicators -click on indicators
	           And Select random series to my series tab 
	          And Select all series   
	          And select the Related series option 
	          And select any one of the indicators
	          And Verify Suggested indicators on clicking indicators
	
	
	        @MySeries
	Scenario: TC_MS_138:Verify Suggested indicators -greyed out indicators
	           And Select random series to my series tab 
	          And Select all series   
	          And select the Related series option 
	          And Verify Suggested indicators greyed out indicators
	
	        @MySeries
	Scenario: TC_MS_139:Verify Suggested indicators -+ icon click
	           And Select random series to my series tab 
	          And Select all series  
	          And select the Related series option 
	          And select the + icon option 
	          And Verify Suggested indicators + icon
	
	
	
		        @MySeries
	Scenario: TC_MS_140:Verify Suggested indicators -Select a countries dropdown
	           And Select random series to my series tab 
	           And Select all series  
	           And select the Related series option 
	          And select the countries dropdown
	          And Verify Suggested indicators countries dropdown
	
	
			        @MySeries
	Scenario: TC_MS_141:Verify Suggested indicators - Select a Region
	           And Select random series to my series tab 
	           And Select all series  
	           And select the Related series option 
	          And select the countries dropdown
	           And select any one country
	          And Verify Suggested indicators Select a Region
	
			        @MySeries
	Scenario: TC_MS_142:Verify Suggested indicators -search for a Region
	           And Select random series to my series tab 
	           And Select all series  
	           And select the Related series option 
	          And select the countries dropdown
	           And search for a Region
	          And Verify Suggested indicators search for a Region
	
	
			        @MySeries
	Scenario: TC_MS_143:Verify Suggested indicators- minimize and maximizeoption
	           And Select random series to my series tab 
	           And Select all series  
	           And select the Related series option 
	          And select the minimize option
	          And Verify Suggested indicators min and max option
	
			        @MySeries
	Scenario: TC_MS_145:Verify Suggested indicators - resize window
	           And Select random series to my series tab 
	           And Select all series  
	           And select the Related series option 
	          And select the expand option
	          And Verify Suggested indicators expand option

	
			        @MySeries
	Scenario: TC_MS_146:Verify Suggested indicators - window move
	           And Select random series to my series tab 
	           And Select all series  
	           And select the Related series option 
	          And try to drag window
	          And Verify Suggested indicators window move
	
			        @MySeries
	Scenario: TC_MS_147:Verify Suggested indicators - close button(x)
	           And Select random series to my series tab 
	           And Select all series  
	           And select the Related series option 
	          And select close button
	          And Verify Suggested indicators close button

	
	
			        @MySeries
	Scenario: TC_MS_148:Verify sort by dropdown
	           And Select random series to my series tab 
	           And Select all series  
	           And select the sort by dropdown
	          And Verify sort by dropdown
	
	
	
			        @MySeries
	Scenario: TC_MS_149:Verify sort by dropdown-checked
	           And Select random series to my series tab 
	            And check any one of the series
	           And select the sort by dropdown
	          And select checked option
	          And Verify sort by dropdown checked
	
		        @MySeries
	Scenario: TC_MS_150:Verify sort by dropdown- Recently updated
	           And Select random series to my series tab 
	           And select the sort by dropdown
	          And select "Recently Updated" option
	          And Verify sort by Recently updated
	
		        @MySeries
	Scenario: TC_MS_151:Verify sort by dropdown- % Change
	           And search for the Series ID  as "296500404;205545302;51297401"
	           And select the sort by dropdown
	          And select "% Change" option
	          And Verify sort by % Change
	
		        @MySeries
	Scenario: TC_MS_152:Verify sort by dropdown- Last value
	           And search for the Series ID  as "217579502;205428302;51297401"
	           And select the sort by dropdown
	          And select "Last Value" option
	          And Verify sort by Last Value
	
		        @MySeries
	Scenario: TC_MS_153:Verify sort by dropdown-  Status
	           And search for the Series ID  as "205424302;369827607;282464801"
	           And select the sort by dropdown
	          #And select "Status" option
	          And Verify sort by Status
	
			        @MySeries
	Scenario: TC_MS_154:Verify sort by dropdown-  Name
	           And search for the Series ID  as "296500404;205545302;51297401"
	           And select the sort by dropdown
	          And select "Name" option
	          And Verify sort by Name
	
			        @MySeries
	Scenario: TC_MS_155:Verify sort by dropdown-  Region
	          And search for the Series ID  as "296500404;205545302;51297401" 
	          And select the sort by dropdown
	          And select "Region" option
	          And Verify sort by Region
	
			        @MySeries
	Scenario: TC_MS_156:Verify sort by dropdown-  Subnational
	          And search for the Series ID  as "241551701;241551801;241551901" 
	          And select subnational option in customize setting
	           And select the sort by dropdown
	           And select "Subnational" option
	          And Verify sort by Subnational
	
		        @MySeries
	Scenario: TC_MS_157:Verify sort by dropdown-  Frequency
	          And search for the Series ID  as "205441502;96258607;205441502" 
	          And select the sort by dropdown
	           #And select "Frequency" option
	          And Verify sort by Frequency	
	
	 @MySeries
	Scenario: TC_MS_158:Verify sort by dropdown-  Unit
	         And search for the Series ID  as "205441502;213168202;7027701" 
	          And select the sort by dropdown
	           And select "Unit" option
	          And Verify sort by Unit	
	
	
	 @MySeries
	Scenario: TC_MS_159:Verify sort by dropdown-  Source
	         And search for the Series ID  as "327841302;81382901;389679387" 
	             And select Source option in customize setting
	          And select the sort by dropdown
	          # And select "Source" option
	          And Verify sort by Source	
	
	 @MySeries
	Scenario: TC_MS_160:Verify sort by dropdown-  Mnemonics
	         And search for the Series ID  as "384162137;383779087;237938503" 
	           And select Mnemonic option in customize setting
	          And select the sort by dropdown
	           And select "Mnemonic" option
	          And Verify sort by Mnemonic	
	
	
	 @MySeries
	Scenario: TC_MS_161:Verify sort by dropdown - Function Descreption
	         And search for the Series ID  as "205424302;205441502;205428302" 
	         And applay function for the series
	          And select the sort by dropdown
	           And select "Function Description" option
	          And Verify sort by Function Description	
	
	
	 @MySeries
	Scenario: TC_MS_162:Verify sort by dropdown - Obs. Number
	         And search for the Series ID  as "205424302;205441502;205428302" 
	        And select  Observation option in customize setting
	          And select the sort by dropdown
	           And select "Obs. Number" option
	          And Verify sort by Obs. Number	
	
	 @MySeries
	Scenario: TC_MS_163:Verify sort by dropdown -  First date
	         And search for the Series ID  as "205424302;205441502;205428302" 
	          And select the sort by dropdown
	           And select "First Date" option
	          And Verify sort by First date
	
	 @MySeries
	Scenario: TC_MS_164:Verify sort by dropdown - Last date
	         And search for the Series ID  as "205424302;205441502;205428302" 
	          And select the sort by dropdown
	           And select "Last Date" option
	          And Verify sort by Last date
	
	
	 @MySeries
	Scenario: TC_MS_165:Verify series selection by using Shift key
	          And Select random series to my series tab   
              And Select the first series
              And Select shift key and select last series
	          And Verify series selection by using Shift key
	          
	 @MySeries
	Scenario: TC_MS_166:Verify placing series by drag and drop
	          And Select series and darg and drop   
	          And Verify placing series by drag and drop
	
	 @MySeries
	Scenario: TC_MS_167:Verify Mouse hover icons on series
	         And Select some series to my series tab 
              And Mouse hover the first series
	          And Verify Mouse hover icons on series
	
	@MySeries
	Scenario: TC_MS_168:Verify Show Series info (i)
	         And Select some series to my series tab 
              And Mouse hover the first series
              And Select Show Series info
	          And Verify Show Series info
	
	
	@MySeries
	Scenario: TC_MS_169:Verify series tooltip in my series
	         And Select some series to my series tab 
              And Mouse hover the first series
	          And Verify series tooltip in my series
	
	@MySeries
	Scenario: TC_MS_170:Verify Edit series option
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
	          And Verify Edit series option
	
	@MySeries
	Scenario: TC_MS_171:Verify Edit series option -rename
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
               And Select the rename option
	          And Verify Edit series option -rename
	
	@MySeries
	Scenario: TC_MS_172:Verify Edit series Rename - by default 
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
               And Select the rename option
	          And Verify Edit series Rename - by default 
	
	
	@MySeries
	Scenario: TC_MS_173:Verify Edit series Rename -clicking on OK button
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
               And Select the rename option
               And change series name
	          And Verify Edit series Rename - clicking on OK button
	
	@MySeries
	Scenario: TC_MS_174:Verify Edit series Rename -Cancel icon
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
               And Select the rename option
	          And Verify Edit series Rename -Cancel icon
	

	@MySeries
	Scenario: TC_MS_175:Verify Edit series Rename -More option
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
               And Select the rename option
	          And Verify Edit series Rename -More option
	
	
	@MySeries
	Scenario: TC_MS_176:Verify Frequency in edit series
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
               And Select the frequency option
	          And Verify Edit series Rename -Frequency
	
	@MySeries
	Scenario: TC_MS_178:Verify As change in edit series
	         And Select some series to my series tab 
              And Mouse hover the first series
               And Select the Edit series option
               And Select the change option
	          And Verify Edit series Rename change
	
	
	  @MySeries
		Scenario: TC_MS_179:Verify Remove series if no visuals created from the series
		       And Select random series to my series tab   
	              And Mouse hover the first series
	               And Select the Remove option
		          And Verify Remove series if no visuals created from the series
	
	 @MySeries
		Scenario: TC_MS_180:Verify Remove series if visuals created from the series
		      And Create visuals as Chart    
	            And Select to myseries button 
	               And Select the Remove option
		          And Verify Remove series if  visuals created from the series
	
	@MySeries
		Scenario: TC_MS_181:Verify Remove series -discription for delete series popup
		      And Create visuals as Chart    
	            And Select to myseries button 
	               And Select the Remove option
		          And Verify Remove series discription for delete series popup
	
	
	@MySeries
		Scenario: TC_MS_182:Verify Remove series -OK button for delete series popup
		      And Create visuals as Chart    
	            And Select to myseries button 
	               And Select the Remove option
		          And Verify Remove series OK button for delete series popup
	
	@MySeries
		Scenario: TC_MS_183:Verify Remove series -the associated visuals after removed series
		      And Create visuals as Chart    
	            And Select to myseries button 
	               And Select the Remove option
		          And Verify Remove series the associated visuals after removed series
	
	@MySeries
		Scenario: TC_MS_184:Verify Remove series -Cancel/x icon for the popup
		      And Create visuals as Chart    
	            And Select to myseries button 
	               And Select the Remove option
		          And Verify Remove series Cancel/x icon for the popup
	
	@MySeries
		Scenario: TC_MS_185:Verify Fx on series mouse hovering
		      And Select some series to my series tab 
	           And Mouse hover the first series
	               And Select the Fx option
		          And Verify Fx on series mouse hovering
	
	@MySeries
		Scenario: TC_MS_186:Verify Footnotes on series mouse hovering
		       And Select some series to my series tab 
	           And Mouse hover the first series
	               And Select the Footnotes option
		          And Verify Footnotes on series mouse hovering
	
	@MySeries
		Scenario: TC_MS_187:Verify More actions option
		       And Select some series to my series tab 
	           And Mouse hover the first series
	               And Select the More option
		          And Verify More option on series mouse hovering
	
	@MySeries
		Scenario: TC_MS_188:Verify More actions -Unselect all
		       And Select random series to my series tab   
		        And Select all series 
	           #And Mouse hover the first series
	               And Select the More option
	               And Select the "Unselect all" option
		          And Verify More Unselect all
	
	
	@MySeries
		Scenario: TC_MS_189:Verify More actions -View as Chart
		    And Select some series to my series tab 
	           #And Mouse hover the first series
	               And Select the More option
	               And Select the "View as Chart" option
		          And Verify More View as Chart all
	
	
	@MySeries2
		Scenario: TC_MS_190:Verify More actions -View as Map
		    And Select some series to my series tab 
	           #And Mouse hover the first series
	               And Select the More option
	               #And Select the "View as Map" option
		          And Verify More View as Map
	
	
	
	@MySeries
		Scenario: TC_MS_191:Verify More actions -View as Table
		    And Select some series to my series tab 
	           #And Mouse hover the first series
	               And Select the More option
	               And Select the "View as Table" option
		          And Verify More View as Table
	
	
	@MySeries
		Scenario: TC_MS_192:Verify More actions -View as 
		    And Select some series to my series tab 
	           #And Mouse hover the first series
	               And Select the More option
	               And Select the "View as ..." option
		          And Verify More View as "Pie" "Heat map" "Histogram"
	
	
	@MySeries
		Scenario: TC_MS_193:Verify More actions -View as pie
		    And Select some series to my series tab 
	          # And Mouse hover the first series
	               And Select the More option
	               And Select the "View as ..." option
		          And Verify More View as Pie
	
	@MySeries
		Scenario: TC_MS_194:Verify More actions -View as Heatmap
		    And Select some series to my series tab 
	          #And Mouse hover the first series
	               And Select the More option
	               And Select the "View as ..." option
		           And Verify More View as Heatmap
	
	
	@MySeries
		Scenario: TC_MS_196:Verify More actions -View as Histogram
		    And Select some series to my series tab 
	          #And Mouse hover the first series
	               And Select the More option
	               And Select the "View as ..." option
		         And Verify More View as Histogram
	
	
	@MySeries
		Scenario: TC_MS_197: Verify creating visual with more than max seires selection
		  And Select "21" series to my series tab 
	           And Select all series  
	          And Mouse hover the last series
	              And Select the More option on last series
	             And Select the "View as Chart" option
		         And Verify creating visual with more than max seires selection

	
	@MySeries
		Scenario: TC_MS_198: Verify More actions -Download option
		  And Select some series to my series tab 
	         # And Mouse hover the first series
	            And Select the More option
	             And Select the "Download" option
		         And Verify More View on Download option
	
	@MySeries
		Scenario: TC_MS_199: Verify More actions Copy option
		  And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy" option
		         And Verify More Copy option
	
	@MySeries
		Scenario: TC_MS_200: Verify More actions the confirmation message for Copy action
		  And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy" option
		         And Verify More actions the confirmation message for Copy action
	
	
	@MySeries
		Scenario: TC_MS_201: Verify More actions closing of growl popup for Copy
		  And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy" option
		         And Verify More actions closing of growl popup for Copy
	
	@MySeries
		Scenario: TC_MS_202: Verify More actions Copy data
		  And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy data" option
		         And Verify More actions Copy data
		         
	
	@MySeries
		Scenario: TC_MS_203: Verify More actions Copy data when Always ask me about the export settings is unchecked in download window
		  And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy data" option
	             And uncheck the checkbox in Always ask me about the export settings
		         And Verify More actions in Always ask me about the export settings
	
	@MySeries
		Scenario: TC_MS_204: Verify More actions Copy link(s) for series 
		  And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy link(s)" option
		         And Verify More actions Copy link(s) for series 
	
	
	@MySeries
		Scenario: TC_MS_205: Verify More actions copy link behavior for single series 
		  And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy link(s)" option
		         And Verify More actions Copy link behavior for single series 
	
	@MySeries
		Scenario: TC_MS_206: Verify More actions copy link confirmation message  
		 And Select some series to my series tab 
	          #And Mouse hover the first series
	            And Select the More option
	             And Select the "Copy link(s)" option
		         And Verify More actions Copy link confirmation message  
	
	@MySeries
		Scenario: TC_MS_208: Verify More actions copy link confirmation message for multiple series
		 And Select some series to my series tab 
		  And Select all series 
	         # And Mouse hover the first series
	           And Select the More option
	             And Select the "Copy link(s)" option
		         And Verify More actions Copy link confirmation message for multiple series
	
	
	@MySeries
		Scenario: TC_MS_209: Verify More actions copy link closing of growl popup 
		 And Select some series to my series tab 
		  And Select all series 
	         # And Mouse hover the first series
	           And Select the More option
	             And Select the "Copy link(s)" option
		         And Verify More actions Copy link closing of growl popup 
	
	
	@MySeries
		Scenario: TC_MS_210:  Verify  More actions insert copied option if not data in clipboard 
		 And Select some series to my series tab 
		  And Select all series 
	        # And Mouse hover the first series
	           And Select the More option
	            # And Mouse hover the "Insert Copied" option
		         And Verify More actions insert copied option if not data in clipboard  
	
	
	@MySeries
		Scenario: TC_MS_211:  Verify More actions insert copied option  
		 And Select some series to my series tab
		 And Select all series
		   And Select Copy option
	         #And Mouse hover the first series
	           And Select the More option
	             And Select the "Insert Copied" option
		         And Verify More actions insert copied option 
	
	
	
	@MySeries
		Scenario: TC_MS_212:  Verify More actions insert copied growl message 
		 And Select some series to my series tab
		 And Select all series
		   And Select Copy option
	         #And Mouse hover the first series
	           And Select the More option
	             And Select the "Insert Copied" option
		         And Verify More actions insert growl message 
	
	
	
	@MySeries
		Scenario: TC_MS_213:  Verify More actions Delete option
		 And Select some series to my series tab
		 And Select all series
	         #And Mouse hover the first series
	           And Select the More option
	             And Select the "Delete" option
		         And Verify More actions Delete
	
	@MySeries
		Scenario: TC_MS_214:  Verify More actions Delete description for delete series popup
		And Create visuals as Chart 
		 And Navigate to Series tab
	        # And Mouse hover the first series
	          And Select the More option
	             And Select the "Delete" option
		         And Verify More actions Delete description for delete series popup
	
	
	@MySeries
		Scenario: TC_MS_215:  Verify More actions Delete ok button for delete series popup
		And Create visuals as Chart 
		 And Navigate to Series tab
	         #And Mouse hover the first series
	          And Select the More option
	             And Select the "Delete" option
		         And Verify More actions Delete ok button for delete series popup
	
	
	
	@MySeries
		Scenario: TC_MS_216:  Verify More actions Delete the associated visuals after deleted series
		And Create visuals as Chart 
		 And Navigate to Series tab
	        # And Mouse hover the first series
	          And Select the More option
	             And Select the "Delete" option
		         And Verify More actions Delete the associated visuals after deleted series
	
	
	
	@MySeries
		Scenario: TC_MS_217:  Verify More actions Delete Cancel/x icon for the popup
		And Create visuals as Chart 
		 And Navigate to Series tab
	         #And Mouse hover the first series
	          And Select the More option
	             And Select the "Delete" option
		         And Verify More actions Delete Cancel/x icon for the popup
	
	
	@MySeries
		Scenario: TC_MS_218:  Verify More actions Group
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
		       And Verify More actions Group
		       
	
	@MySeries
		Scenario: TC_MS_219:  Verify More actions auto title for group
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
		       And Verify More actions auto title for group
	
	
	@MySeries
		Scenario: TC_MS_220: Verify More actions OK icon by default
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
		       And Verify More actions OK icon by default
	
	@MySeries
		Scenario: TC_MS_221: Verify More actions clicking on OK icon
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
	             And change series name
		       And Verify More actions clicking on OK icon
	
	@MySeries
		Scenario: TC_MS_222: Verify More actions clicking on X icon
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
		       And Verify More actions clicking clicking on X icon
	
	
@MySeries
		Scenario: TC_MS_223: Verify More actions adding series to existing group
	          And Select some series to my series tab
	         # And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
	          # And Add select one more series
		       And Verify More actions Group if already have a group in my series
	
	
	@MySeries
		Scenario: TC_MS_224: Verify More actions search field for existing group
	          And Select some series to my series tab
	         # And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
	          # And Add another series and create another group
		       And Verify More actions search field for existing group

	
	@MySeries
		Scenario: TC_MS_225: Verify More actions sub dropdown should be opened with existing groups
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
	             #And Add select one more series
	            #And Add another series and create another group
		       And Verify More actions sub dropdown should be opened with existing groups
	
	
	@MySeries
		Scenario: TC_MS_226: Verify More actions create new group option
	          And Select some series to my series tab
	          And Mouse hover the first series
	           And Select the More option
	           And Select the "Group" option
	           # And Add select one more series
	         #And Add another series and create another group 
		       And Verify More actions create new group option
	
	
	
	@MySeries
		Scenario: TC_MS_227: Verify More actions Preview
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Preview" option
		       And Verify More actions Preview
	
	@MySeries
		Scenario: TC_MS_228: Verify More actions Series Info
	          And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Series Info" option
		       And Verify More actions Series Info
	
	@MySeries
		Scenario: TC_MS_229: Verify More actions Footnotes
	         And Select some series to my series tab
	          #And Mouse hover the first series
	           And Select the More option
	           And Select the "Footnotes" option
		       And Verify More actions Footnotes.
	
	
	@MySeries
		Scenario: TC_MS_230: Verify More actions Footnotes if the series linked to multiple Database
	         And Select some series to my series tab
	        #And Mouse hover the first series
	           And Select the More option
		       And Verify More actions Footnotesif the series linked to multiple Database
	
	@MySeries
		Scenario: TC_MS_231: Verify More actions Show dataset
	         And Select some series to my series tab
	         #And Mouse hover the first series
	           And Select the More option
	             And Select the "Show Dataset" option
		       And Verify More actions Show dataset
	
	
	@MySeries
		Scenario: TC_MS_232: Verify More actions Show Database
	         And Select some series to my series tab
	        # And Mouse hover the first series
	         And Select the More option
	          And Select the "Show Database" option
		      And Verify More actions Show Show Database
	
	@MySeries
		Scenario: TC_MS_233:Verify Right click option
		       And Select some series to my series tab 
	             # And Mouse hover the first series
	           And Right click on the first series
		          And Verify Right click option on series 
	
	@MySeries
		Scenario: TC_MS_234:Verify Right click option Unselect all
		       And Select some series to my series tab 
		        And Select all series 
	            #  And Mouse hover the first series
	           And Right click on the first series
	            And Select the "Unselect all" option
		          And Verify Right click option Unselect all
	
	@MySeries
	Scenario: TC_MS_235:Verify Right click option-View as Chart
		    And Select some series to my series tab 
	          # And Mouse hover the first series
	                And Right click on the first series
	               And Select the "View as Chart" option
		          And Verify Right click View as Chart all
	
	
	@MySeries
		Scenario: TC_MS_236:Verify Right click option -View as Map
		    And Select some series to my series tab 
	          # And Mouse hover the first series
	                And Right click on the first series
	               #And Select the "View as Map" option
		          And Verify Right click View as Map
	
	@MySeries
		Scenario: TC_MS_237:Verify Right click option -View as Table
		    And Select some series to my series tab 
	          # And Mouse hover the first series
	                And Right click on the first series
	            And Select the "View as Table" option
		          And Verify Right click View as Table
	
	
	@MySeries
		Scenario: TC_MS_238:Verify Right click option -View as 
		    And Select some series to my series tab 
	        #   And Mouse hover the first series
	             And Right click on the first series
	              And Select the "View as ..." option
		          And Verify Right click View as "Pie" "Heat map" "Histogram"
	
	
	@MySeries
		Scenario: TC_MS_239:Verify Right click option -View as pie
		    And Select some series to my series tab 
	         #  And Mouse hover the first series
	               And Right click on the first series
	               And Select the "View as ..." option
		          And Verify Right click View as Pie
	
	
	@MySeries
		Scenario: TC_MS_240:Verify Right click option -View as Heatmap
		    And Select some series to my series tab 
	       #   And Mouse hover the first series
	              And Right click on the first series
	               And Select the "View as ..." option
		           And Verify Right click View as Heatmap
	
	
	@MySeries
		Scenario: TC_MS_242:Verify Right click option -View as Histogram
		    And Select some series to my series tab 
	      #   And Mouse hover the first series
	               And Right click on the first series
	               And Select the "View as ..." option
		         And Verify Right click View as Histogram
	

	
	@MySeries
		Scenario: TC_MS_243: Verify Right click function for creating visual with more than max seires selection
		  And Select "21" series to my series tab 
	           And Select all series  
	        #  And Mouse hover the last series
	              And Select the More option on last series
	             And Select the "View as Chart" option
		         And Verify Right click creating visual with more than max seires selection
	
	
	@MySeries
		Scenario: TC_MS_244: Verify Right click -Download option
		  And Select some series to my series tab 
	       #  And Mouse hover the first series
	            And Right click on the first series
	             And Select the "Download" option
		         And Verify Right click View on Download option
	
	@MySeries
		Scenario: TC_MS_245: Verify Right click Copy option
		  And Select some series to my series tab 
	        #  And Mouse hover the first series
	             And Right click on the first series
	             And Select the "Copy" option
		         And Verify Right click Copy option
	
	@MySeries
		Scenario: TC_MS_246: Verify Right click the confirmation message for Copy action
		  And Select some series to my series tab 
	        #  And Mouse hover the first series
	            And Right click on the first series
	             And Select the "Copy" option
		         And Verify Right click the confirmation message for Copy action
	
	
	@MySeries
		Scenario: TC_MS_247: Verify Right click closing of growl popup for Copy
		  And Select some series to my series tab 
	       #   And Mouse hover the first series
	              And Right click on the first series
	             And Select the "Copy" option
		         And Verify Right click closing of growl popup for Copy
	
	@MySeries
		Scenario: TC_MS_248: Verify Right click Copy data
		  And Select some series to my series tab 
	      #    And Mouse hover the first series
	             And Right click on the first series
	             And Select the "Copy data" option
		         And Verify Right click Copy data
	
	
	@MySeries
		Scenario: TC_MS_249: Verify Right click Copy data when Always ask me about the export settings is unchecked in download window
		  And Select some series to my series tab 
	       #  And Mouse hover the first series
	           And Right click on the first series
	            And Select the "Copy data" option
	             And uncheck the checkbox in Always ask me about the export settings
		         And Verify Right click in Always ask me about the export settings
	
	@MySeries
		Scenario: TC_MS_250: Verify Right click Copy link(s) for series 
		  And Select some series to my series tab 
	      #    And Mouse hover the first series
	           And Right click on the first series
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link(s) for series 
	
	
	@MySeries
		Scenario: TC_MS_251: Verify Right click copy link behavior for single series 
		  And Select some series to my series tab 
	       #   And Mouse hover the first series
	            And Right click on the first series
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link behavior for single series 
	
	@MySeries
		Scenario: TC_MS_252: Verify Right click copy link confirmation message  
		 And Select some series to my series tab 
	       #   And Mouse hover the first series
	             And Right click on the first series
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link confirmation message  
	
	@MySeries
		Scenario: TC_MS_254: Verify Right click copy link confirmation message for multiple series
	   And Select some series to my series tab 
		  And Select all series 
	        #  And Mouse hover the first series
	           And Right click on the first series
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link confirmation message for multiple series

	@MySeries
		Scenario: TC_MS_255: Verify Right click copy link closing of growl popup 
		 And Select some series to my series tab 
		  And Select all series 
	       #   And Mouse hover the first series
	           And Right click on the first series
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link closing of growl popup 
	
	
	@MySeries
		Scenario: TC_MS_256:  Verify  Right click insert copied option if not data in clipboard 
		 And Select some series to my series tab 
		  And Select all series 
	      #   And Mouse hover the first series
	          And Right click on the first series
	             And Mouse hover the "Insert Copied" option
		         And Verify Right click insert copied option if not data in clipboard  
	
	
	@MySeries
		Scenario: TC_MS_257:  Verify Right click insert copied option  
		 And Select some series to my series tab
		 And Select all series
		   And Select Copy option
	    #     And Mouse hover the first series
	           And Right click on the first series
	             And Select the "Insert Copied" option
		         And Verify Right click insert copied option 
		
	@MySeries
		Scenario: TC_MS_258:  Verify Right click insert copied growl message 
		 And Select some series to my series tab
		 And Select all series
		   And Select Copy option
	     #    And Mouse hover the first series
	           And Right click on the first series
	             And Select the "Insert Copied" option
		         And Verify Right click insert growl message 
	
	@MySeries
		Scenario: TC_MS_259:  Verify Right click Delete option
		 And Select some series to my series tab
		 And Select all series
	         #And Mouse hover the first series
	             And Right click on the first series
	             And Select the "Delete" option
		         And Verify Right click Delete
	
	
	
	@MySeries
		Scenario: TC_MS_260: Verify Right click Delete description for delete series popup
		And Create visuals as Chart 
		 And Navigate to Series tab
	         #And Mouse hover the first series
	            And Right click on the first series
	             And Select the "Delete" option
		         And Verify Right click Delete description for delete series popup
	
	
	@MySeries
		Scenario: TC_MS_261: Verify Right click Delete ok button for delete series popup
		And Create visuals as Chart 
		 And Navigate to Series tab
	        # And Mouse hover the first series
	           And Right click on the first series
	             And Select the "Delete" option
		         And Verify Right click Delete ok button for delete series popup
	
	
	
	@MySeries
		Scenario: TC_MS_262:VerifyRight click Delete the associated visuals after deleted series
		And Create visuals as Chart 
		 And Navigate to Series tab
	       #  And Mouse hover the first series
	        And Right click on the first series
	             And Select the "Delete" option
		         And Verify Right click Delete the associated visuals after deleted series
	
	
	
	@MySeries
		Scenario: TC_MS_263:Verify Right click Delete Cancel/x icon for the popup
		And Create visuals as Chart 
		 And Navigate to Series tab
	       #  And Mouse hover the first series
	         And Right click on the first series
	             And Select the "Delete" option
		         And Verify Right click Delete Cancel/x icon for the popup
	
	
	
	
	@MySeries
		Scenario: TC_MS_264:Verify Right click Group
	          And Select some series to my series tab
	       #   And Mouse hover the first series
	       And Right click on the first series
	           And Select the "Group" option
		       And Verify Right click Group
		       
	
	@MySeries
		Scenario: TC_MS_265:Verify Right click auto title for group
	          And Select some series to my series tab
	         # And Mouse hover the first series
	           And Right click on the first series
	           And Select the "Group" option
		       And Verify Right click auto title for group
	
	
	@MySeries
		Scenario: TC_MS_266:Verify More actions OK icon by default
	          And Select some series to my series tab
	        #  And Mouse hover the first series
	          And Right click on the first series
	           And Select the "Group" option
		       And Verify Right click OK icon by default
	
	@MySeries
		Scenario: TC_MS_267: Verify Right click clicking on OK icon
	          And Select some series to my series tab
	         # And Mouse hover the first series
	          And Right click on the first series
	           And Select the "Group" option
	             And change series name
		       And Verify Right click clicking on OK icon
	
	@MySeries
		Scenario: TC_MS_268: Verify Right click clicking on X icon
	          And Select some series to my series tab
	         # And Mouse hover the first series
	          And Right click on the first series
	           And Select the "Group" option
		       And Verify Right click clicking clicking on X icon
	
	
	@MySeries
		Scenario: TC_MS_269: Verify Right click adding series to existing group
	          And Select some series to my series tab
	        #  And Mouse hover the first series
	       And Right click on the first series
	           And Select the "Group" option
	           And Add select one more series
		       And Verify Right click Group if already have a group in my series
	
	
	@MySeries
		Scenario: TC_MS_270: Verify Right click search field for existing group
	          And Select some series to my series tab
	          #And Mouse hover the first series
	          And Right click on the first series
	           And Select the "Group" option
		       And Verify Right click search field for existing group
	
	
	@MySeries
		Scenario: TC_MS_271: Verify Right click sub dropdown should be opened with existing groups
	          And Select some series to my series tab
	       #   And Mouse hover the first series
	         And Right click on the first series
	           And Select the "Group" option
	             #And Add select one more series
		       And Verify Right click sub dropdown should be opened with existing groups
	
	
	@MySeries
		Scenario: TC_MS_272: Verify Right click create new group option
	          And Select some series to my series tab
	         # And Mouse hover the first series
	         And Right click on the first series
	           And Select the "Group" option
	           # And Add select one more series
		       And Verify Right click create new group option
	
	@MySeries
		Scenario: TC_MS_273: Verify Right click Preview
	          And Select some series to my series tab
	         # And Mouse hover the first series
	            And Right click on the first series
	           And Select the "Preview" option
		       And Verify Right click Preview
	
	@MySeries
		Scenario: TC_MS_274: Verify Right click Series Info
	          And Select some series to my series tab
	         # And Mouse hover the first series
	           And Right click on the first series
	           And Select the "Series Info" option
		       And Verify Right click Series Info
	
@MySeries
		Scenario: TC_MS_275: Verify Right click Footnotes
	         And Select some series to my series tab
	       #   And Mouse hover the first series
	          And Right click on the first series
	           And Select the "Footnotes" option
		       And Verify Right click Footnotes.
	
	
	@MySeries
		Scenario: TC_MS_276: Verify Right click Footnotes if the series linked to multiple Database
	         And Select some series to my series tab
	      #  And Mouse hover the first series
	         And Right click on the first series
		       And Verify Right click Footnotesif the series linked to multiple Database
	
	@MySeries
		Scenario: TC_MS_277: Verify Right click Show dataset
	         And Select some series to my series tab
	       #  And Mouse hover the first series
	           And Right click on the first series
	             And Select the "Show Dataset" option
		       And Verify Right click Show dataset
	
	
	@MySeries
		Scenario: TC_MS_278: Verify Right click Show Database
	         And Select some series to my series tab
	       #  And Mouse hover the first series
	         And Right click on the first series
	          And Select the "Show Database" option
		      And Verify Right click Show Show Database
	
	
	@MySeries
		Scenario: TC_MS_280: Verify Search for name field-table mode
	     And Select random series to my series tab 
	      And Select the Table mode
	         And Mouse hover the first series and get the name in table mode
	         And search in a search name field
	         And verify Search for name field in table mode
	
	
	@MySeries
		Scenario: TC_MS_281: Verify Search for function description field-table mode
	   And search for the Series ID  as "205424302;205441502;205428302" 
	     And select the second series and applay function
	      And Select the Table mode
	        And search in a function field
	         And verify function field in table mode
	
	@MySeries
		Scenario: TC_MS_282: Verify Search for Series ID field-table mode
	       And search for the Series ID  as "296500404;205545302;51297401" 
          And get series name and ID
	      And Select the Table mode
	        And search in a Series ID field
	         And verify Series ID in table mode
	         	
	@MySeries
		Scenario: TC_MS_283: Verify Search for Mnemonics field-table mode
	     And search for the Series ID  as "384162137;383779087;237938503" 
          And get series name and ID of mnemonics
	      And Select the Table mode
	        And search in a Mnemonics field
	         And verify Mnemonics field in table mode
	
	
	@MySeries
		Scenario: TC_MS_284: Verify Regions dropdown-table mode
	   And search for the Series ID  as "296500404;205545302;51297401"  
	      And Select the Table mode
	        And search Regions dropdown
	         And verify Regions dropdown in table mode
	
	@MySeries
		Scenario: TC_MS_286: Verify Subnational dropdown-table mode
	   And search for the Series ID  as "241551701;241551801;241551901"  
	      And Select the Table mode
	        And search Subnational dropdown
	         And verify Subnational dropdown in table mode
	
	@MySeries
		Scenario: TC_MS_287: Verify Frequency dropdown-table mode
	        And search for the Series ID  as "205441502;96258607;205441502" 
	        And Select the Table mode
	        And search Frequency dropdown
	         And verify Frequency dropdown in table mode
	         
	@MySeries
		Scenario: TC_MS_288: Verify last updated-table mode 
	        And search for the Series ID  as "297631204;202916302;218914002" 
	         And get series name and last update value
	        And select the required for  last updated in table coloumn 
	        And Select the Table mode
	        And search last updated 
           And verify  last updated in table mode
	
	@MySeries
		Scenario: TC_MS_289: Verify unit dropdown-table mode
	        And search for the Series ID  as "205441502;213168202;7027701" 
	        And select the required table coloumn 
	        And Select the Table mode
	        And search unit dropdown
         And verify unit dropdown in table mode
	
	@MySeries
		Scenario: TC_MS_290: Verify First_date-table mode 
	        And search for the Series ID  as "297631204;202916302;218914002" 
	         And get series name and First date value
	        And select the required for First date in table coloumn 
	        And Select the Table mode
	        And search First date
           And verify First date in table mode
	
	@MySeries
		Scenario: TC_MS_291: Verify Last_date-table mode 
	        And search for the Series ID  as "297631204;202916302;218914002" 
	         And get series name and last date value
	        And select the required for lastdate in table coloumn 
	        And Select the Table mode
	        And search last date
           And verify last date in table mode
	
	@MySeries
		Scenario: TC_MS_292: Verify latest value-table mode 
	        And search for the Series ID  as "297631204;202916302;218914002" 
	         And get series name and latest value value
	        And select the required for latest value in table coloumn 
	        And Select the Table mode
	        And search latest value
           And verify latest value in table mode
	
	
	@MySeries
		Scenario: TC_MS_293: Verify Number of obs-table mode 
	        And search for the Series ID  as "384162137;383779087;237938503" 
	         And get series name and Number of obs value
	        And select the required for Number of obs in table coloumn 
	        And Select the Table mode
	        And search Number of obs
           And verify Number of obs in table mode
	
	
	@MySeries
		Scenario: TC_MS_294: Verify status dropdown-table mode
	        And search for the Series ID  as "205424302;369827607;282464801" 
	        And select the required for status in table coloumn 
	        And Select the Table mode
	        And search status dropdown
         And verify status dropdown in table mode
	

	@MySeries
		Scenario: TC_MS_296: Verify selected series in list mode-table mode
	     And Select random series to my series tab 
	          And Select the Table mode
	        And select any series in table coloumn 
	        And Select the List mode
         And verify selected series in list mode of table mode
	
	
	@MySeries
		Scenario: TC_MS_297: Verify Mouse hover icons on series-table mode
	     And Select random series to my series tab 
	          And Select the Table mode
	          And Mouse hover the first series in table mode
              And verify Mouse hover icons on series in table mode
	
		@MySeries
		Scenario: TC_MS_298: Verify Show Series info-table mode
	          And Select random series to my series tab 
	          And Select the Table mode
	          And Mouse hover the first series in table mode
	          And Select SSP icon
              And verify Show Series info in table mode
	
	     @MySeries
		Scenario: TC_MS_299: Verify series tooltip-table mode
	          And Select random series to my series tab 
	          And Select the Table mode
	          And Mouse hover the first series in table mode
              And verify series tooltip in table mode
	
	  @MySeries
		Scenario: TC_MS_300: Verify Edit series-table mode
	          And Select random series to my series tab 
	          And Select the Table mode
              And verify Edit series in table mode
	
	@MySeries
		Scenario: TC_MS_301: Verify Edit series-Rename-table mode
	          And Select random series to my series tab 
	          And Select the Table mode
              And verify Edit series Rename in table mode
	
	
	@MySeries
	Scenario: TC_MS_302:Verify Frequency in edit series-table mode
	         And Select some series to my series tab 
               And Select the Table mode
	          And Verify Edit series Rename -Frequency-table mode
	
	
	
	@MySeries
	Scenario: TC_MS_303:Verify Currency in edit series-table mode
	         And search for the Series ID  as "218914002" 
               And Select the Table mode
	          And Verify Edit series Rename -Currency-table mode
	
	
	@MySeries
	Scenario: TC_MS_304:Verify As change in edit series-table mode
	         And Select some series to my series tab 
                And Select the Table mode
	          And Verify Edit series Rename change-table mode
	

	 @MySeries
		Scenario: TC_MS_305:Verify Remove series if no visuals created from the series-table mode
		       And Select random series to my series tab   
	              And Select the Table mode
		          And Verify Remove series if no visuals created from the series-table mode
	
	 @MySeries
		Scenario: TC_MS_306:Verify Remove series if visuals created from the series-table mode
		      And Create visuals as Chart    
	           And Select to myseries button 
	              And Select the Table mode
		          And Verify Remove series if  visuals created from the series-table mode
	
	@MySeries
		Scenario: TC_MS_307:Verify Right click option-table mode
		       And Select some series to my series tab 
	                And Select the Table mode
	                   And Mouse hover the first series in table mode
	             And Right click on the first series in table mode
		          And Verify Right click option on series-table mode 
	
	@MySeries
		Scenario: TC_MS_308:Verify Right click option Unselect all-table mode
		       And Select some series to my series tab 
	        And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	            And Select the "Unselect all" option
		          And Verify Right click option Unselect all in table mode
	
	@MySeries
	Scenario: TC_MS_309:Verify Right click option-View as Chart-table mode
		      And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	               And Select the "View as Chart" option
		          And Verify Right click View as Chart all in table mode
	
	
	@MySeries
		Scenario: TC_MS_310:Verify Right click option -View as Map-table mode
		  And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	               And Select the "View as Map" option
		          And Verify Right click View as Map in table mode
	
	@MySeries
		Scenario: TC_MS_311:Verify Right click option -View as Table-table mode
		   		  And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	            And Select the "View as Table" option
		          And Verify Right click View as Table in table mode
	
	@MySeries
		Scenario: TC_MS_312:Verify Right click option -View as-table mode 
		    And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	              And Select the "View as ..." option
		          And Verify Right click View as "Pie" "Heat map" "Histogram" in table mode
	
	@MySeries
		Scenario: TC_MS_313:Verify Right click option -View as pie-table mode
		    And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	               And Select the "View as ..." option
		          And Verify Right click View as Pie in table mode
	
	
	@MySeries
		Scenario: TC_MS_314:Verify Right click option -View as Heatmap-table mode
		     And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	               And Select the "View as ..." option
		           And Verify Right click View as Heatmap in table mode
	
	
	@MySeries
		Scenario: TC_MS_316:Verify Right click option -View as Histogram-table mode
		     And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	               And Select the "View as ..." option
		         And Verify Right click View as Histogram in table mode
	
	@MySeries
		Scenario: TC_MS_317: Verify Right click function for creating visual with more than max seires selection-table mode
		  And Select "21" series to my series tab 
	           And Select all series  
	          And Mouse hover the last series
	              And Select the More option on last series
	             And Select the "View as Chart" option
		         And Verify creating visual with more than max seires selection
	
	@MySeries
		Scenario: TC_MS_318: Verify Right click option -Download option-in table mode
		    And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Download" option
		         And Verify More View on Download option table mode

	@MySeries
		Scenario: TC_MS_319: Verify Right click option Copy option-in table mode
		 And Select some series to my series tab 
		    And Select all series 
		   And get the series name 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Copy" option
		         And Verify More Copy option table mode
	
	@MySeries
		Scenario: TC_MS_344: Verify Right click option the confirmation message for Copy action-in table mode
		And Select some series to my series tab 
		    And Select all series 
		    And get the series name 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Copy" option
		         And Verify More actions the confirmation message for Copy action table mode
	
	
	@MySeries
		Scenario: TC_MS_343: Verify Right click option closing of growl popup for Copy-in table mode
		 And Select some series to my series tab 
		    And Select all series 
		    And get the series name 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Copy" option
		         And Verify More actions closing of growl popup for Copy table mode
	
	@MySeries
		Scenario: TC_MS_320: Verify Right click option Copy data-in table mode
		  And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Copy data" option
		         And Verify More actions Copy data in table mode
	
	
	@MySeries
		Scenario: TC_MS_321: Verify Right click Copy link(s) for series-in table mode 
		 And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link(s) for series in table mode  
	
	
	@MySeries
		Scenario: TC_MS_322: Verify Right click copy link behavior for single series-in table mode 
		  And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link behavior for single series in table mode  
	
	@MySeries
		Scenario: TC_MS_323: Verify Right click copy link confirmation message-in table mode  
		 And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Copy link(s)" option
		         And Verify Right click Copy link confirmation message in table mode   
	
	@MySeries
		Scenario: TC_MS_324:  Verify  Right click insert copied option if not data in clipboard-in table mode 
		And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Mouse hover the "Insert Copied" option
		         And Verify Right click insert copied option if not data in clipboard in table mode   
	
	
	@MySeries
		Scenario: TC_MS_325:  Verify Right click insert copied option-in table mode  
		 And Select some series to my series tab
		 And Select all series
		   And Select Copy option
	         And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Insert Copied" option
		         And Verify Right click insert copied option in table mode  
		
	@MySeries
		Scenario: TC_MS_342:  Verify Right click insert copied growl message-in table mode 
			And Select some series to my series tab 
		    And Select all series 
		       And Select Copy option
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
		         And Verify Right click insert growl message in table mode  
	
	@MySeries
		Scenario: TC_MS_326:  Verify Right click Delete option-in table mode 
		 	And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	             And Select the "Delete" option
		         And Verify Right click Delete in table mode 
	
	@MySeries
		Scenario: TC_MS_327:  Verify Right click Group-in table mode 
	        And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	           And Select the "Group" option
		       And Verify More actions Group in table mode 
		       
	
	@MySeries
		Scenario: TC_MS_328:  Verify Right click auto title for group-in table mode 
	        And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	           And Select the "Group" option
		       And Verify More actions auto title for group in table mode
	
	@MySeries
		Scenario: TC_MS_329: Verify Right click OK icon by default-in table mode 
	      And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	           And Select the "Group" option
		       And Verify More actions OK icon by default in table mode 
	
	@MySeries
		Scenario: TC_MS_330: Verify Right click sub dropdown should be opened with existing groups-in table mode 
	          And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	           And Select the "Group" option
	             And Add select one more series in table more
	         And Mouse hover the second series in table mode
		       And Verify Right click sub dropdown should be opened with existing groups in table mode 
	
	@MySeries
		Scenario: TC_MS_331: Verify Right click adding series to existing group-in table mode 
	         And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	           And Select the "Group" option
	            And Add select one more series in table more
	           And Mouse hover the second series in table mode
		       And Verify Right click Group if already have a group in my series in table mode  
	
	
	@MySeries
		Scenario: TC_MS_332: Verify Right click search field for existing group-in table mode 
	         And Select some series to my series tab 
		    And Select all series 
		           And Select the Table mode
	              And Mouse hover the first series in table mode
	           And Right click on the first series in table mode
	           And Select the "Group" option
	           And Add another series and create another group in tabel mode
		       And Verify Right click search field for existing group in table mode  
	
	
		@MySeries
		Scenario: TC_MS_333: Verify Right click create new group option-in table mode 
	         And Select some series to my series tab 
		    And Select all series 
		     And Select the Table mode
	         And Mouse hover the first series in table mode
	          And Right click on the first series in table mode
	          And Select the "Group" option
	           And Add select one more series in table more
	           And Mouse hover the second series in table mode
		       And Verify Right click create new group option-in table mode 
	
	@MySeries
		Scenario: TC_MS_334: Verify Right click Preview-in table mode
	         And Select some series to my series tab 
		    And Select all series 
		     And Select the Table mode
	         And Mouse hover the first series in table mode
	          And Right click on the first series in table mode
	           And Select the "Preview" option
		       And Verify Right click Preview in table mode
	
	@MySeries
		Scenario: TC_MS_335: Verify Right click Series Info-in table mode
	         And Select some series to my series tab 
		    And Select all series 
		     And Select the Table mode
	         And Mouse hover the first series in table mode
	          And Right click on the first series in table mode
	           And Select the "Series Info" option
		       And Verify Right click Series Info in table mode
	
	@MySeries
		Scenario: TC_MS_336: Verify Right click Footnotes-in table mode
	          And Select some series to my series tab 
		    And Select all series 
		     And Select the Table mode
	         And Mouse hover the first series in table mode
	          And Right click on the first series in table mode
	           And Select the "Footnotes" option
		       And Verify Right click Footnotes in table mode
	
	@MySeries
		Scenario: TC_MS_337: Verify Right click Footnotes if the series linked to multiple Database-in table mode
	          And Select some series to my series tab 
		    And Select all series 
		     And Select the Table mode
	         And Mouse hover the first series in table mode
	          And Right click on the first series in table mode
		       And Verify Right click Footnotesif the series linked to multiple Database in table mode
	
	@MySeries
		Scenario: TC_MS_338: Verify Right click Show dataset-in table mode
	         And Select some series to my series tab 
		    And Select all series 
		     And Select the Table mode
	         And Mouse hover the first series in table mode
	          And Right click on the first series in table mode
	             And Select the "Show Dataset" option
		       And Verify Right click Show dataset in table mode
	
	
	@MySeries
		Scenario: TC_MS_339: Verify Right click Show Database-in table mode
	          And Select some series to my series tab 
		    And Select all series 
		     And Select the Table mode
	         And Mouse hover the first series in table mode
	          And Right click on the first series in table mode
	          And Select the "Show Database" option
		      And Verify Right click Show Show Database in table mode
	
	
	
	@MySeries
		Scenario: TC_MS_340: Verify undo option for making changes in my series tab
	          And Select some series to my series tab 
		    And Select undo option 
		      And Verify undo option for making changes in my series tab
	
	
	@MySeries
		Scenario: TC_MS_341: Verify undo option for making changes in my series tab
	          And Select some series to my series tab 
	          And Select undo option 
		    And Select redo option 
		      And Verify redo option for making changes in my series tab
	
	
	
	
	
	
	
#131	
	
	
	
	
	#345
	
	
 