#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Table Visual Functionality
  
#Background: 
#	Given User has successful logged in 
	#And Check for prerequesties

@TableVisual
Scenario: TC_TV_01: Verify creating Table visual from View panel by drag and drop 
And  create visual tab
	And drag and drop the table visual
	And verify the Table visual creating from View panel by drag and drop
	
@TableVisual
Scenario: TC_TV_02: Verify creating Table visual from View panel by clicking on Table icon 
	And  create visual tab
	And select the table visual
And verify the Table visual creating from View panel by clicking
	
	@TableVisua
Scenario: TC_TV_03: Verify Table visual creating with function applied series 
	And Select some series to my series tab 
	And Applay function
	And create table for applied function 
 And verify Table visual creating with function applied series
	
	
@TableVisual
Scenario: TC_TV_04: Empty visual - Verify Edit Table button 
	And  create visual tab
	And select the table visual
	And verify Edit Table button is disable
	
	@TableVisual
Scenario: TC_TV_05: Empty visual - Verify Edit series button 
	And  create visual tab
	And select the table visual
	And verify Edit series button 
	
	
@TableVisual
Scenario: TC_TV_06: Empty visual - Verify default tab for Edit series option 
	And  create visual tab
	And select the table visual
	And verify default tab for Edit series option	


	@TableVisual
Scenario: TC_TV_07: Empty visual - Verify description message for empty visual if have series in My series 
	And Select some series to my series tab 
	And  create visual tab
	And verify description message for empty visual if have series in My series 
	
	@TableVisual
Scenario: TC_TV_08: Empty visual -  Verify description message for empty visual if have NO series in My series 
	And  create visual tab
	And verify description message for empty visual if have NO series in My series 

@TableVisual
Scenario: TC_TV_09: Empty visual - Verify Add from my series option
And Select some series to my series tab
	And  create visual tab
	And verify Add from my series option 
	
		@TableVisual
Scenario: TC_TV_10: Empty visual - Verify Table tab when no series added for visual
  And Select some series to my series tab
  And  create visual tab
	And verify Table tab when no series added for visual
	
			@TableVisua
Scenario: TC_TV_11: Empty visual - Verify + Add from My Series option in edit series panel
  And Select some series to my series tab
  And  create visual tab
	And verify + Add from My Series option in edit series panel
	
				@TableVisual
Scenario: TC_TV_12: Empty visual -Verify adding series to empty visual
  And Select some series to my series tab
  And  create visual tab
	And verify Verify adding series to empty visual

				@TableVisual
Scenario: TC_TV_13: Verify default attributes for Table visual
  And Select some series to my series tab
	And verify default attributes for Table visual
	
					@TableVisual
Scenario: TC_TV_14: Verify the attributes rows
  And Select some series to my series tab
	And verify the attributes rows

					@TableVisual
Scenario: TC_TV_15: Verify removing attributes by clicking x icon
  And Select some series to my series tab
	And verify removing attributes by clicking x icon

					@TableVisual
Scenario: TC_TV_16: Verify clicking on series name
  And Select some series to my series tab
	And verify clicking on series name

					  @TableVisual
Scenario: TC_TV_17: Verify Edit series on visual
  And Select some series to my series tab
 And verify Edit series on visual
	
						  @TableVisual
Scenario: TC_TV_18: Verify Rename option from cogwheel icon
  And Select some series to my series tab
  And Select the rename option in tabel visual
  And  verify Rename option from cogwheel icon
  
  						  @TableVisual
Scenario: TC_TV_19: Verify Frequency option from cogwheel icon
  And Select some series to my series tab
  And Select the Frequency option in tabel visual
  And  verify Frequency option from cogwheel icon
  
  
    @TableVisual
Scenario: TC_TV_20: Verify Currency option from cogwheel icon
  And User Select Series ID  as "46224501"
  And Select some series to my series tab
  And Select the Currency option in tabel visual
  And  verify Currency option from cogwheel icon
  
      @TableVisual
Scenario: TC_TV_21:Verify Change option from cogwheel icon
 And User Select Series ID  as "46224501"
  And Select the Change option in tabel visual
  And  verify Change option from cogwheel icon
  
        @TableVisual
Scenario: TC_TV_22:Verify Remove series icon
  And Select some series to my series tab
  And  verify Remove series icon
  
          @TableVisual
Scenario: TC_TV_23:Verify tooltip for series
  And Select some series to my series tab
  And  verify tooltip for series
  
            @TableVisual
Scenario: TC_TV_24:Verify scroll down till end of timepoints
  And User Select Series ID  as "310902301"
  And Select some series to my series tab
  And  verify scroll down till end of timepoints
  
  
              @TableVisual
Scenario: TC_TV_25:Verify Name field when scroll down
  And User Select Series ID  as "310902301"
  And Select some series to my series tab
  And  verify Name field when scroll down
	
             @TableVisual
Scenario: TC_TV_26:Verify double click on title
  And Select some series to my series tab
  And  verify double click on title	
	
	              @TableVisual
Scenario: TC_TV_27:Verify clicking on edit icon for title
  And Select some series to my series tab
  And  verify clicking on edit icon for title
  
  
  	              @TableVisual
Scenario: TC_TV_28:Verify double click on attribute area
  And Select some series to my series tab
  And  verify double click on attribute area
  
   	              @TableVisual
Scenario: TC_TV_29:Verify Attributes popup -select all
  And Select some series to my series tab
  And  verify Attributes popup -select all
  
  
     	              @TableVisual
Scenario: TC_TV_30:Attributes popup - Verify unselect all
  And Select some series to my series tab
  And  verify Attributes popup -unselect all
  
       	              @TableVisual
Scenario: TC_TV_31:Attribute popup - Verify drag and drop attributes to change their order 
  And Select some series to my series tab
  And  verify drag and drop attributes to change their order
  
        	              @TableVisual
Scenario: TC_TV_32:Attributes popup - Statistics - Verify select all 
  And Select some series to my series tab
  And  verify Attributes popup - Statistics
  
          	              @TableVisual
Scenario: TC_TV_33:Attributes popup - Statistics - Verify unselect all 
  And Select some series to my series tab
  And  verify Attributes popup - Statistics unselect all
  
  
     	              @TableVisual
Scenario: TC_TV_34:Statistics Attribute popup - Verify drag and drop attributes to change their order 
  And Select some series to my series tab
  And  verify drag and drop Statistics attributes to change their order
  
                    @TableVisual
Scenario: TC_TV_35:Attribute popup - Statistics - Verify default statistics selection for Table visual
  And Select some series to my series tab
  And  verify default statistics selection for Table visual
  
  
                      @TableVisual
Scenario: TC_TV_36:Attribute popup - Statistics - Verify expand/collapse attribute and statistics sections
   And Select some series to my series tab
  And  verify expand/collapse attribute and statistics sections
  
                        @TableVisual
Scenario: TC_TV_37:Verify double clicking on date field
   And Select some series to my series tab
   And  verify double clicking on date field
   
                           @TableVisual
Scenario: TC_TV_38:Verify double clicking on timepoints
   And Select some series to my series tab
   And  verify double clicking on timepoints
   
                @TableVisual
Scenario: TC_TV_39:Edit series - Verify Edit series option for Table visual
   And Select some series to my series tab
   And  verify Edit series option for Table visual
   
                   @TableVisual
Scenario: TC_TV_40:Edit series - Verify series under Table tab
   And Select some series to my series tab
   And  verify series under Table tab
   
   
                      @TableVisual
Scenario: TC_TV_41:Edit series -  Verify Rename option
   And Select some series to my series tab
   And  verify Rename option  
   
                         @TableVisual
Scenario: TC_TV_42:Edit series -Verify number of selected series in Rename pop up
   And Select more than one series to my series tab
   And  verify number of selected series in Rename pop up
   
                           @TableVisual
Scenario: TC_TV_43:Edit series -Verify number of available itmes in Rename pop Find field
    And Select more than one series to my series tab
   And  verify number of available itmes in Rename pop Find field
   
                           @TableVisual
Scenario: TC_TV_44:Edit series -Verify find field in Rename pop
    And Select more than one series to my series tab
    And  verify find field in Rename pop  
   
                            @TableVisual
Scenario: TC_TV_45:Edit series -Verify number of searched result
    And Select more than one series to my series tab
    And  verify find number of searched result
    
                               @TableVisual
Scenario: TC_TV_46:Edit series -Verify Replace field
    And Select more than one series to my series tab
    And  verify Replace field in Rename pop 
    
                                  @TableVisual
Scenario: TC_TV_47:Edit series -Verify Replace button
    And Select more than one series to my series tab
    And  verify Replace button in Rename pop
    
                                     @TableVisual
Scenario: TC_TV_48:Edit series -Verify Replace All button
    And Select same series to my series tab
    And  verify Replace All button in Rename pop
    
                                         @TableVisual
Scenario: TC_TV_49:Edit series -Verify Replace for selected series
     And Select more than one series to my series tab
    And  verify Replace for selected series in Rename pop
    
                                             @TableVisual
Scenario: TC_TV_50:Edit series -Verify find next button
     And Select more than one series to my series tab
    And  verify find next button in Rename pop
    
                                                 @TableVisual
Scenario: TC_TV_51:Edit series -Verify Replace, Replace All and find next buttons by default
     And Select more than one series to my series tab
    And  verify Replace, Replace All and find next buttons by default
    
    
                                                     @TableVisual
Scenario: TC_TV_52:Edit series -Verify for invalid search
     And Select more than one series to my series tab
    And  verify for invalid search
    
                                                    @TableVisual
Scenario: TC_TV_53:Edit series -Verify Edit series info dropdown
   And Select some series to my series tab
    And  verify Edit series info dropdown
    
                               @TableVisual
Scenario: TC_TV_54:Edit series -Verify default selection for Edit series info dropdown
    And Select some series to my series tab
    And  verify default selection for Edit series info dropdown
   
   
                                @TableVisual
Scenario: TC_TV_55:Rename - Verify Name selection
    And Select some series to my series tab
    And  verify Rename Name selection
    
                                       @TableVisual
Scenario: TC_TV_56:Rename - Verify Function description selection
 	And Select some series to my series tab 
	And Applay function
	And create table for applied function 
  And  verify Rename Function description selection
    
                                        @TableVisual
Scenario: TC_TV_57:Rename - Verify function description selection without function apply
 	And Select some series to my series tab 
  And  verify Rename function description selection without function apply   
    
                                       @TableVisual
Scenario: TC_TV_58:Rename - Verify editing function description
 	And Select some series to my series tab 
 	And Applay function
	And create table for applied function 
  And  verify editing function description   
  
    @TableVisual
Scenario: TC_TV_59:Rename - Verify adding function description
 	And Select some series to my series tab 
  And  verify adding function description
  
    @TableVisual
Scenario: TC_TV_60:Rename -Function discription - Verify apply original title icon
 	And Select some series to my series tab 
  And  verify Function discription apply original title icon
  
  
      @TableVisual
Scenario: TC_TV_61:Rename -Function discription - Verify Apply original title icon behavior
 	And Select some series to my series tab 
  And  verify Function discription Apply original title icon behavior
  
  
        @TableVisual
Scenario: TC_TV_62:Rename -Function discription - Verify Apply original title for all series icon
 	  And Select more than one series to my series tab
  And  verify Function discription  Apply original title for all series icon
  
   @TableVisual
Scenario: TC_TV_63:Rename -Function discription - Verify clicking on series name
 	  	And Select some series to my series tab 
  And  verify Function discription  clicking on series name
  
   @TableVisual
Scenario: TC_TV_64:Rename - Name - Verify Editing series name
 	  	And Select some series to my series tab 
  And  verify Name Editing series name
   
      @TableVisual
Scenario: TC_TV_65:Rename - Name - Verify Apply original title icon
 	  	 And Select some series to my series tab 
       And  verify Apply original title icon
       
       
           @TableVisual
Scenario: TC_TV_66:Rename - Name - Apply original title for all series icon
 	    And Select more than one series to my series tab
       And  verify Apply original title for all series icon
            
                 @TableVisual
Scenario: TC_TV_67:Rename - Verify < icon if no changes in series attributes
 	     And Select more than one series to my series tab
       And  verify < icon if no changes in series attributes
       
       
                       @TableVisual
Scenario: TC_TV_68:Rename - Verify Region selection
 	    And Select some series to my series tab 
       And  verify Region selection
       
                              @TableVisual
Scenario: TC_TV_69:Rename - Region - Verify Editing series region
 	    And Select some series to my series tab 
       And  verify Editing series region
       
                                    @TableVisual
Scenario: TC_TV_70:Rename - Region - Verify Apply original region icon
 	     And Select some series to my series tab 
       And  verify Region Apply original region icon
       
                                     @TableVisual
Scenario: TC_TV_71:Rename - Region - Verify Apply original region for all series icon
 	     And Select more than one series to my series tab
       And  verify Region Apply original region for all series icon    
       
                                           @TableVisual
Scenario: TC_TV_72:Rename - unit - Verify Editing series unit
 	     And Select some series to my series tab 
       And  verify unit Editing series unit  
       
       
                                                @TableVisual
Scenario: TC_TV_73:Rename - unit - Verify Apply original unit icon
 	     And Select some series to my series tab 
       And  verify unit Apply original unit icon
       
       
                                                     @TableVisual
Scenario: TC_TV_74:Rename - unit - Verify Apply original unit for all series icon
 	      And Select more than one series to my series tab
       And  verify unit Apply original unit for all series icon
       
                                                       @TableVisual
Scenario: TC_TV_75:Rename - frequency - Verify Editing series frequency
 	      And Select some series to my series tab 
       And  verify frequency Editing series frequency  
       
       
                                                             @TableVisual
Scenario: TC_TV_76:Rename - frequency - Verify Apply original frequency icon
 	      And Select some series to my series tab 
       And  verify frequency Apply original frequency icon    
       
       
                                              @TableVisual
Scenario: TC_TV_77:Rename - frequency - Verify Apply original frequency for all series icon 
 	      And Select more than one series to my series tab
        And  verify frequency Apply original frequency for all series icon
        
                                @TableVisual
Scenario: TC_TV_78:Rename -  Verify Auto name check box
 	      And Select some series to my series tab 
        And  verify Rename Auto name check box
        
        
                                        @TableVisual
Scenario: TC_TV_79:Rename -Verify attributes dropdown
 	      And Select some series to my series tab 
        And  verify Rename attributes dropdown
        
                                       @TableVisual
Scenario: TC_TV_80:Rename - Verify selection of attributes
 	      And Select some series to my series tab 
        And  verify Rename selection of attributes     
        
                                       @TableVisual
Scenario: TC_TV_81:Rename - selecting multiple attributes for series name
 	      And Select more than one series to my series tab
        And  verify Rename selecting multiple attributes for series name      
        
                                        @TableVisual
Scenario: TC_TV_82:Rename - Veriy series in My series after visual series renamed
 	      And Select some series to my series tab 
        And  verify Rename series in My series after visual series renamed      
        
                                           @TableVisual
Scenario: TC_TV_83:Rename - Verify Apply button
 	      And Select some series to my series tab 
        And  verify Rename Apply button  
    
    
                             @TableVisual
Scenario: TC_TV_84:Rename - Verify OK button
 	      And Select some series to my series tab 
        And  verify Rename OK button   
        
        
                         @TableVisual
Scenario: TC_TV_85:Rename - Verify  Minimize option
 	      And Select some series to my series tab 
        And  verify Rename Minimize option  
        
            
                                 @TableVisual
Scenario: TC_TV_86:Rename - Verify  maximiz option
 	      And Select some series to my series tab 
        And  verify Rename maximiz option  
        
        
                                @TableVisual
Scenario: TC_TV_87:Rename - Verify full screen
 	      And Select some series to my series tab 
        And  verify Rename full screen 
        
            
                                 @TableVisual
Scenario: TC_TV_88:Rename -Verify exit full screen
 	      And Select some series to my series tab 
        And  verify Rename exit full screen
        
                               @TableVisual
Scenario: TC_TV_89:Rename - Cancel/x icon
 	      And Select some series to my series tab 
        And  verify Rename Cancel/x icon
        
                            @TableVisual
Scenario: TC_TV_90:Rename -Verify opening rename popup by keyboard shortcut
 	      And Select some series to my series tab 
        And  verify Rename opening rename popup by keyboard shortcut
            
                   @TableVisual
Scenario: TC_TV_91:Edit series - Verify appling Currency conversation function
 	      #And Select some series to my series tab 
 	       And User Select Series ID  as "46224501"
        And verify Edit series appling Currency conversation function
        
        
                           @TableVisual
Scenario: TC_TV_92:Edit series - Verify appling Calculate change function
 	      #And Select some series to my series tab 
 	        And User Select Series ID  as "46224501"
        And verify Edit series appling Calculate change function
        
                                  @TableVisual
Scenario: TC_TV_93:Edit series - Verify appling Aggregate function
 	      #And Select some series to my series tab 
 	        And User Select Series ID  as "46224501"
        And verify Edit series appling Aggregate function
        
                                  @TableVisual
Scenario: TC_TV_94:Edit series - Verify appling Accumulate function
 	      #And Select some series to my series tab 
 	        And User Select Series ID  as "402529207"
        And verify Edit series appling Accumulate function       
        
                                    @TableVisual
Scenario: TC_TV_95:Edit series - Verify FX more drop down
 	      #And Select some series to my series tab 
 	       And User Select Series ID  as "402529207"
        And verify Edit series FX more drop down     
        
                                      @TableVisual
Scenario: TC_TV_96:Edit series - Verify FX more icon
 	      And Select some series to my series tab 
        And verify Edit series FX more icon       
        
                                       @TableVisual2
Scenario: TC_TV_97:Edit series - Verify appling function by clicking on function icon
 	      And Select some series to my series tab 
        And verify Edit series appling function by clicking on function icon
            
                                              @TableVisual
Scenario: TC_TV_98:Edit series - Verify hiding/showing function toolbar
 	      And Select some series to my series tab 
        And verify Edit series ahiding/showing function toolbar 
        
                                           @TableVisual
Scenario: TC_TV_99:Edit series - Verify Type a function field
 	      And Select some series to my series tab 
        And verify Edit series Type a function field   
        
                                            @TableVisual
Scenario: TC_TV_100:Edit series - Verify FX icon
 	      And Select some series to my series tab 
        And verify Edit series FX icon       
        
                                             @TableVisual
Scenario: TC_TV_101:Edit series - Verify delete series icon
 	      And Select some series to my series tab 
        And verify Edit delete series icon  
        
                                                     @TableVisual
Scenario: TC_TV_102:Edit series - Verify delete all series icon
 	       And Select more than one series to my series tab
        And verify Edit delete all series icon            
                                                     @TableVisual
Scenario: TC_TV_103:Edit series - Verify SSP by clicking on series name
 	       And Select some series to my series tab 
        And verify Edit SSP by clicking on series name  
        
                                     @TableVisual
Scenario: TC_TV_104:Edit series - Verify Rename series icon
 	       And Select some series to my series tab 
        And verify Edit Rename series icon      
        
                                 @TableVisual
Scenario: TC_TV_105:Edit series - Verify edit series icon
 	       And Select some series to my series tab 
        And verify Edit edit series icon        
                    
                                   @TableVisual
Scenario: TC_TV_106:Edit series - Verify Rename option under edit series
 	       And Select some series to my series tab 
        And verify Edit Rename option under edit series 
        
        
                                          @TableVisual
Scenario: TC_TV_107:Edit series -Verify Frequency option under edit series
 	       And User Select Series ID  as "46224501"
 	       And Select some series to my series tab 
        And verify Edit Frequency option under edit series
        
      
                                          @TableVisual
Scenario: TC_TV_108:Edit series - Verify Currency option under edit series
        And User Select Series ID  as "46224501"
 	       And Select some series to my series tab 
        And verify Edit Currency option under edit series
        
                                                  @TableVisual
Scenario: TC_TV_109:Edit series - Verify Change option under edit series
 	       And User Select Series ID  as "46224501"
          And Select some series to my series tab
        And verify Edit Change option under edit series
        
        
                                                @TableVisual
Scenario: TC_TV_110:Edit series - Verify clicking on frequency or dropdown
 	        And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Edit clicking on frequency or dropdown
         
                                                 @TableVisual
Scenario: TC_TV_111:Edit series - Series data conversion -applying frequency
 	        And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Edit Series data conversion -applying frequency
         
                              @TableVisual
Scenario: TC_TV_112:Edit series - Series data conversion -applying Missing values method
 	        And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Edit Series data conversion -applying Missing values method
         
         
                         @TableVisual
Scenario: TC_TV_113:Edit series - Series data conversion -Apply button
 	        And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Edit Series data conversion -Apply button
      
      
              
                                                @TableVisual
Scenario: TC_TV_114:Edit series - Series data Verify Minimize option
 	        And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Series data Minimize
         
         
                 
                                                @TableVisual
Scenario: TC_TV_115:Edit series -Series data Verify maximize
 	       And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify ESeries data Maximize  
             
             
             
                                                             @TableVisual
Scenario: TC_TV_116:Edit series - Series data Verify full screen option
 	       And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Series data full screen
         
         
                 
                                                @TableVisual
Scenario: TC_TV_117:Edit series -Series data Verify exit full screen
 	       And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Series data exit full screen
          
                                                @TableVisual
Scenario: TC_TV_118:Edit series -Series data Verify Cancel/x icon
 	       And User Select Series ID  as "394611277;51276702"
          And Select series to my series tab
         And verify Series data Cancel/x icon
                   
                        @TableVisual
Scenario: TC_TV_119:Edit series -Series data Verify dropdown for frequency in series level
 	       And User Select Series ID  as "394611277"
         And Select series to my series tab
         And verify Series data dropdown for frequency in series level  
         
                         @TableVisual
Scenario: TC_TV_120:Edit series -Series data Verify appling frequency in series level
 	       And User Select Series ID  as "394611277"
         And Select series to my series tab
         And verify Series data appling frequency in series level       
         
                         @TableVisual
Scenario: TC_TV_121:Edit series -Series data Verify appling currency in series level
 	      And User Select Series ID  as "46224501"
        And Select series to my series tab
         And verify Series data appling currency in series level       
                  
         
                          @TableVisual
Scenario: TC_TV_122:Edit series - Verify clicking on type a function field
 	      And Select some series to my series tab
        And verify Edit Series clicking on type a function field           
         
                            @TableVisual
Scenario: TC_TV_123:Edit series - Verify appling function in series level
 	      And Select some series to my series tab
        And verify Edit Series appling function in series level         
         
                              @TableVisual
Scenario: TC_TV_124:Edit series - Verify cancel icon for selected function
 	      And Select some series to my series tab
        And verify Edit Series appling function  cancel icon for selected function      
         
                               @TableVisual
Scenario: TC_TV_125:Edit series - Verify multiple functions apply
 	      And Select some series to my series tab
        And verify Edit Series multiple functions apply
  
                                @TableVisual
Scenario: TC_TV_126:Edit series - Verify search for functions
 	      And Select some series to my series tab
        And verify Edit Series search for functions
  
                                 @TableVisual
Scenario: TC_TV_127:Edit series - Verify removing applied functions
 	      And Select some series to my series tab
        And verify Edit Series removing applied functions
  
                                   @TableVisual
Scenario: TC_TV_128:Edit series - Verify applied funtion in function toolbar
 	      And Select some series to my series tab
        And verify Edit Series applied funtion in function toolbar
  
                                     @TableVisual
Scenario: TC_TV_129:Edit series - Verify appling invalid function for series
 	      And User Select Series ID  as " 394611277"
        And Select series to my series tab
        And verify Edit Series appling invalid function for series

                                       @TableVisual
Scenario: TC_TV_130:Edit series - Verify OK button on The function cannot be applied to selected series popup
 	      And User Select Series ID  as " 394611277"
        And Select series to my series tab
        And verify Edit Series OK button on The function cannot be applied to selected series popup
  
                                         @TableVisual
Scenario: TC_TV_131:Edit series - Verify Region, Unit and Series ID fields
 	        And Select some series to my series tab
        And verify Edit Series Region, Unit and Series ID fields
  
                                          @TableVisual
Scenario: TC_TV_132:Edit series -Verify horizontal scroll bar for series
 	        And Select some series to my series tab
        And verify Edit Series Verify horizontal scroll bar for series
  
                                   @TableVisual
Scenario: TC_TV_133:Edit series -Verify +Add from my series option
 	        And Select some series to my series tab
         And verify Edit Series Verify Verify +Add from my series option
  
                                    @TableVisual
Scenario: TC_TV_134:Edit series -Verify adding series from my series
 	        And Select some series to my series tab
         And verify Edit Series Verify adding series from my series
  
                                     @TableVisual
Scenario: TC_TV_135:Edit series -Verify max series for Table visual
         And verify Edit Series Verify max series for Table visual   
         
                                      @TableVisual
Scenario: TC_TV_136:Edit series -Verify message for selecting more than 100 series
         And verify Edit Series Verify message for selecting more than 100 series       
         
         
                                     @TableVisual
Scenario: TC_TV_137:Edit series -Verify default sort by in add from my series tab
 	        And Select some series to my series tab
         And verify Edit Series default sort by in add from my series tab       
           
                                     @TableVisual
Scenario: TC_TV_138:Edit series -Verify Edit series option on visual if edit series panle is opened
 	        And Select some series to my series tab
         And verify Edit Series Edit series option on visual if edit series panle is opened
         
                                   @TableVisual
Scenario: TC_TV_139:Edit series -Verify edit series panel close
 	        And Select some series to my series tab
         And verify Edit Series edit series panel close      
         
                             @TableVisual
Scenario: TC_TV_140:Verify Edit Table
 	        And Select some series to my series tab
         And verify Edit Table         
         
                                    @TableVisual
Scenario: TC_TV_141:Edit Table-Verify popup of creating template
 	        And Select some series to my series tab
         And verify Edit Table popup of creating template      
         
                                   @TableVisual
Scenario: TC_TV_142:Edit Table-Verify auto naming for template
 	        And Select some series to my series tab
         And verify Edit Table auto naming for template         
         
                                    @TableVisual
Scenario: TC_TV_143:Edit Table-Verify template creating
 	        And Select some series to my series tab
         And verify Edit Table Verify template creating   
               
                                    @TableVisual
Scenario: TC_TV_144:Edit Table- Verify Cancel icon for template popup
 	        And Select some series to my series tab
         And verify Edit Table Cancel icon for template popup  
         
         
																 @TableVisual
Scenario: TC_TV_145:Edit Table- Verify selection of created template
 	       And Select some series to my series tab
         And verify Edit Table selection of created template  
         
         
																 @TableVisual
Scenario: TC_TV_146:Edit Table-Verify dropdown for template
 	       And Select some series to my series tab
         And verify Edit Table dropdown for template         
         
																 @TableVisual
Scenario: TC_TV_147:Edit Table-Verify Set as default for future Table visual is checked
 	       And Select some series to my series tab
         And verify Edit Table Set as default for future Table visual is checked    
         
 															 @TableVisual
Scenario: TC_TV_148:Edit Table-Verify Set as default for future Table visual is Unchecked
 	       And Select some series to my series tab
         And verify Edit Table Set as default for future Table visual is Unchecked            
                 
    															 @TableVisual
Scenario: TC_TV_149:Edit Table-Verify delete template icon
 	       And Select some series to my series tab
         And verify Edit Table delete template icon  
         
     															 @TableVisual
Scenario: TC_TV_150:Edit Table-Verify description for confirmation popup
 	       And Select some series to my series tab
         And verify Edit Table description for confirmation popup          
         
              															 @TableVisual
Scenario: TC_TV_151:Edit Table- Verify OK button on confirmation popup
 	       And Select some series to my series tab
         And verify Edit Table OK button on confirmation popup          
         
         
              															 @TableVisual
Scenario: TC_TV_152:Edit Table- Verify cancel/x icon on confirmation popup
 	       And Select some series to my series tab
         And verify Edit Table cancel/x icon on confirmation popup
         
                        @TableVisual
Scenario: TC_TV_153:Edit Table- Verify cancel/x icon on confirmation popup
 	       And Select some series to my series tab
         And verify Edit Table cancel/x icon on confirmation popup          
         
                  								 @TableVisual
Scenario: TC_TV_154:Edit Table - Border - Verify Table color
 	      And Select some series to my series tab
         And verify Edit Table Border - Verify Table color 
         
                     								 @TableVisual
Scenario: TC_TV_155:Edit Table -  Border - Verify Table width
 	       And Select some series to my series tab
         And verify Edit Table Border - Verify Table width 
               
                       								 @TableVisual
Scenario: TC_TV_156:Edit Table -  Border - Verify Table style
 	       And Select some series to my series tab
         And verify Edit Table Border - Verify Table style       
         
                         								 @TableVisual
Scenario: TC_TV_157:Edit Table -  Border - Verify Table type
 	       And Select some series to my series tab
         And verify Edit Table Border - Verify Table type    
         
                           								 @TableVisual
Scenario: TC_TV_158:Edit Table -Border=NO for visual
 	       And Select some series to my series tab
         And verify Edit Table Border=NO for visual       
         
         
      								@TableVisual
Scenario: TC_TV_159:Edit Table -Border=Yes for visual
 	       And Select some series to my series tab
         And verify Edit Table Border=Yes for visual      
            
           								@TableVisual
Scenario: TC_TV_160:Edit Table -Border visual color
 	       And Select some series to my series tab
         And verify Edit Table Border visual color   
         
             								@TableVisual
Scenario: TC_TV_161:Edit Table -Border visual width
 	       And Select some series to my series tab
         And verify Edit Table Border visual width    
         
                      								@TableVisual
Scenario: TC_TV_162:Edit Table -Border visual Radius
 	       And Select some series to my series tab
         And verify Edit Table Border visual Radius    
         
         
                @TableVisual
Scenario: TC_TV_163:Edit Table -Border visual style
 	       And Select some series to my series tab
         And verify Edit Table Border visual style  

         		@TableVisual
Scenario: TC_TV_164:Edit Table -Border advance settings
 	       And Select some series to my series tab
         And verify Edit Table Border advance settings  
         
         
         	@TableVisual
Scenario: TC_TV_165:Edit Table -Border advance settings cogwheel
 	       And Select some series to my series tab
         And verify Edit Table Border advance settings cogwheel 
         
         
      	@TableVisual
Scenario: TC_TV_166:Edit Table -Border Verify closing of visual popup
 	        And Select some series to my series tab
         And verify Edit Table Border closing of visual popup        
         
      	@TableVisual
Scenario: TC_TV_167:Edit Table -Show - Verify show=Check for attribute
 	        And Select some series to my series tab
         And verify Edit Table Show Check for attribute    
         
        	@TableVisual
Scenario: TC_TV_168:Edit Table -Show - Verify show=Unheck for attribute
 	        And Select some series to my series tab
         And verify Edit Table Show Unheck for attribute        
         
         	@TableVisual
Scenario: TC_TV_169:Edit Table -Show -Verify clicking on open advance settings popup- attribute
 	        And Select some series to my series tab
         And verify Edit Table Show clicking on open advance settings popup 
         
          	@TableVisual
Scenario: TC_TV_170:Edit Table -Verify show=Check for statistics
 	        And Select some series to my series tab
         And verify Edit Table Show Check for statistics 
                   
  	@TableVisual
Scenario: TC_TV_171:Edit Table -Verify show=Unheck for statistics
 	        And Select some series to my series tab
         And verify Edit Table Show Unheck for statistics  
         
         @TableVisual
Scenario: TC_TV_172:Edit Table -Verify show -Verify clicking on open advance settings popup -statistics
 	        And Select some series to my series tab
         And verify Edit Table Show clicking on open advance settings popup- statistics     
         
          @TableVisual
Scenario: TC_TV_173:Edit Table-Title - Verify Title=Yes
 	        And Select some series to my series tab
         And verify Edit Table Title  as Title=Yes       
         
              @TableVisual
Scenario: TC_TV_174:Edit Table-Title - Verify Title=NO
 	        And Select some series to my series tab
         And verify Edit Table Title  as Title=NO     
         
              @TableVisual
Scenario: TC_TV_175:Edit Table-Title - Verify default selection for title
 	        And Select some series to my series tab
         And verify Edit Table Title default selection for title        
                   
               @TableVisual
Scenario: TC_TV_176:Edit Table-Title -Verify Auto title
 	        And Select some series to my series tab
         And verify Edit Table Auto title 
         
               @TableVisual
Scenario: TC_TV_177:Edit Table-Title -Verify renaming title
 	        And Select some series to my series tab
         And verify Edit Table renaming title     
         
                @TableVisual
Scenario: TC_TV_178:Edit Table-Title-Verify sub title=Check
 	        And Select some series to my series tab
         And verify Edit Table sub title=Check 
         
         
                        @TableVisual
Scenario: TC_TV_179:Edit Table-Title-Verify sub title by default
 	        And Select some series to my series tab
         And verify Edit Table sub title by default   

                                 @TableVisual
Scenario: TC_TV_180:Edit Table-Title-Verify sub title=UnCheck
 	        And Select some series to my series tab
          And verify Edit Table sub title=UnCheck
          
                                           @TableVisual
Scenario: TC_TV_181:Edit Table-Title-Verify default title for sub title
 	        And Select some series to my series tab
          And verify Edit Table default title for sub title  
          
                                                     @TableVisual
Scenario: TC_TV_182:Edit Table-Title-Verify advance settings
 	        And Select some series to my series tab
          And verify Edit Table advance settings-title
          
                                              @TableVisual
Scenario: TC_TV_183:Edit Table-Title-Verify advance settings cogwheel icon
 	        And Select some series to my series tab
          And verify Edit Table advance settings cogwheel icon-title
          
          
                                               @TableVisual
Scenario: TC_TV_184:Edit Table-Title-Verify color for visual title
 	         And Select some series to my series tab
          And verify Edit Table color for visual title         
          
          
                                                @TableVisual
Scenario: TC_TV_185:Edit Table-Title-Verify color for visual title background
 	         And Select some series to my series tab
           And verify Edit Table color for  visual title background        
          
                                                   @TableVisual
Scenario: TC_TV_186:Edit Table-Title- Verify font size for visual title
 	         And Select some series to my series tab
           And verify Edit Table font size for visual title 
           
                                                      @TableVisual
Scenario: TC_TV_187:Edit Table-Title- Verify bold style for visual title
 	         And Select some series to my series tab
           And verify Edit Table bold style for visual title         
           
                                                        @TableVisual
Scenario: TC_TV_188:Edit Table-Title- Verify bold style default selection
 	         And Select some series to my series tab
           And verify Edit Table bold style default selection for visual title  

                                                        @TableVisual
Scenario: TC_TV_189:Edit Table-Title- Verify Italic style for visual title
 	         And Select some series to my series tab
           And verify Edit Table Italic style for visual title  


                                                        @TableVisual
Scenario: TC_TV_190:Edit Table-Title- Verify Underline style for visual title
 	         And Select some series to my series tab
           And verify Edit Table Underline style for visual title 

                                                       @TableVisual
Scenario: TC_TV_191:Edit Table-Title- Verify horizontal alignment (left, right, center)
 	         And Select some series to my series tab
           And verify Edit Table horizontal alignment (left, right, center)

                                                       @TableVisual
Scenario: TC_TV_192:Edit Table-Title- Verify color for visual sub title
 	         And Select some series to my series tab
           And verify Edit Table color for visual sub title

                                                       @TableVisual
Scenario: TC_TV_193:Edit Table-Title-Verify color for visual sub title background
 	         And Select some series to my series tab
           And verify Edit Table color for visual sub title background
           
                         @TableVisual
Scenario: TC_TV_194:Edit Table-Title-Verify font size for visual sub title
 	         And Select some series to my series tab
           And verify Edit Table font size for visual sub title
           
           
                            @TableVisual
Scenario: TC_TV_195:Edit Table-Title-Verify bold style for visual sub title
 	         And Select some series to my series tab
           And verify Edit Table bold style for visual sub title       

                               @TableVisual
Scenario: TC_TV_194:Edit Table-Title-Verify Italic style for visual sub title
 	         And Select some series to my series tab
           And verify Edit Table Italic style for visual sub title   
           
           
                                @TableVisual
Scenario: TC_TV_196:Edit Table-Title-Verify Underline style for visual sub title
 	         And Select some series to my series tab
           And verify Edit Table Underline style for visual sub title
           
           
                                 @TableVisual
Scenario: TC_TV_197:Edit Table-Title-Verify horizontal alignment (left, right, center) of sub title
 	         And Select some series to my series tab
           And verify Edit Table horizontal alignment (left, right, center) of sub title                    
           
                                   @TableVisual
Scenario: TC_TV_198:Edit Table-Title-Verify expanding and collapsing the title and subtitle sections
 	         And Select some series to my series tab
           And verify Edit Table expanding and collapsing the title and subtitle sections
           
           
                                    @TableVisual
Scenario: TC_TV_199:Edit Table-Title-Verify closing of Titles popup
 	         And Select some series to my series tab
           And verify Edit Table closing of Titles popup  
           
                                      @TableVisual
Scenario: TC_TV_200:Edit Table-Verify Wrap text=checked
 	         And Select some series to my series tab
           And verify Edit Table Wrap text=checked          
           
                                        @TableVisual
Scenario: TC_TV_201:Edit Table-Verify Wrap text=unchecked
 	         And Select some series to my series tab
           And verify Edit Table Wrap text=unchecked 
          
                                             @TableVisual
Scenario: TC_TV_202:Edit Table-Verify Invert=checked
 	         And Select some series to my series tab
           And verify Edit Table Invert=checked        
                         
                                         @TableVisual
Scenario: TC_TV_203:Edit Table-Verify Invert=unchecked
 	         And Select some series to my series tab
           And verify Edit Table Invert=unchecked    
           
           
                                            @TableVisual
Scenario: TC_TV_204:Edit Table-Verify Zebra=checked
 	         And Select some series to my series tab
           And verify Edit Table Zebra=checked        
    
    
                                         @TableVisual
Scenario: TC_TV_205:Edit Table-Verify Zebra=unchecked
 	         And Select some series to my series tab
           And verify Edit Table Zebra=unchecked   
           
           
                                         @TableVisual
Scenario: TC_TV_206:Edit Table-Verify Alternating color for Rows
 	         And Select some series to my series tab
           And verify Edit Table Alternating color for Rows 
    
                       @TableVisual
Scenario: TC_TV_207:Edit Table-Verify Alternating color for  Column
 	         And Select more than one series to my series tab
           And verify Edit Table Alternating color for  Column       
           
                          @TableVisual
Scenario: TC_TV_208:Edit Table-Verify Header row=checked
 	         And Select some series to my series tab
           And verify Edit Table Header=checked 
           
                           @TableVisual
Scenario: TC_TV_209:Edit Table-Verify Header  row=unchecked
 	         And Select some series to my series tab
           And verify Edit Table Header=unchecked         
           
           
                           @TableVisual
Scenario: TC_TV_210:Edit Table-Verify Header  row font color
 	         And Select some series to my series tab
           And verify Edit Table Header font color          
                   
                              @TableVisual
Scenario: TC_TV_211:Edit Table-Verify Header  row background color
 	         And Select some series to my series tab
           And verify Edit Table Header background color 
           
                               @TableVisual
Scenario: TC_TV_212:Edit Table-Verify Header  row font size
 	         And Select some series to my series tab
           And verify Edit Table Header font size         
                                                    
                               @TableVisual
Scenario: TC_TV_213:Edit Table-Verify Header  row bold style
 	         And Select some series to my series tab
           And verify Edit Table Header bold style         
        
                               @TableVisual
Scenario: TC_TV_214:Edit Table-Verify Header  row Italic style
 	         And Select some series to my series tab
           And verify Edit Table Header Italic style         
        
                              @TableVisual
Scenario: TC_TV_215:Edit Table-Verify Header  row Underline style
 	         And Select some series to my series tab
           And verify Edit Table Header Italic Underline        
        
                               @TableVisual
Scenario: TC_TV_216:Edit Table-Verify Header  row horizontal alignment (left, right, center)
 	         And Select some series to my series tab
           And verify Edit Table Header horizontal alignment (left, right, center)        
        
                                 @TableVisual
Scenario: TC_TV_217:Edit Table-Header column -Verify font color
 	         And Select some series to my series tab
           And verify Edit Table Header column font color   
           
                                  @TableVisual
Scenario: TC_TV_218:Edit Table-Header column -Verify background color
 	         And Select some series to my series tab
           And verify Edit Table Header column background color           
           
                                  @TableVisual
Scenario: TC_TV_219:Edit Table-Header column -Verify  font size
 	         And Select some series to my series tab
           And verify Edit Table Header column  font size          
           
                                    @TableVisual
Scenario: TC_TV_220:Edit Table-Header column -Verify bold style
 	         And Select some series to my series tab
           And verify Edit Table Header column bold style
           
           
                                     @TableVisual
Scenario: TC_TV_221:Edit Table-Header column -Verify Italic style
 	         And Select some series to my series tab
           And verify Edit Table Header column Italic style          
           
                                      @TableVisual
Scenario: TC_TV_222:Edit Table-Header column -Verify underlined. style
 	         And Select some series to my series tab
           And verify Edit Table Header column underlined. style              
           
                                       @TableVisual
Scenario: TC_TV_223:Edit Table-Header column -Verify horizontal alignment (left, right, center)
 	         And Select some series to my series tab
           And verify Edit Table Header column horizontal alignment (left, right, center)         
    
                      
                                          @TableVisual
Scenario: TC_TV_224:Edit Table-Verify Copyright=Check
 	         And Select some series to my series tab
           And verify Edit Table Copyright=Check 
           
                                              @TableVisual
Scenario: TC_TV_225:Edit Table-Verify Copyright=UnCheck
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Copyright=UnCheck        
           
                                               @TableVisual
Scenario: TC_TV_226:Edit Table-Verify Copyright Vertical align 
 	         And Select some series to my series tab
           And verify Edit Table Copyright Vertical align        
           
                                                   @TableVisual
Scenario: TC_TV_227:Edit Table-Verify Copyright Vertical align for middle
 	         And Select some series to my series tab
           And verify Edit Table Copyright Vertical align for middle  
           
                                                   @TableVisual
Scenario: TC_TV_228:Edit Table-Verify Copyright Horizontal align 
 	         And Select some series to my series tab
           And verify Edit Table Copyright Horizontal align 
           
                                                   @TableVisual
Scenario: TC_TV_229:Edit Table-Verify Copyright advance settings
 	         And Select some series to my series tab
           And verify Edit Table Copyright advance settings           
           
                                                          @TableVisual
Scenario: TC_TV_230:Edit Table-Verify Copyright advance settings cogwheel
 	         And Select some series to my series tab
           And verify Edit Table Copyright advance settings cogwheel    
           
                                    @TableVisual
Scenario: TC_TV_231:Edit Table-Verify Copyright-popup-text=check
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup text=check   
           
                @TableVisual
Scenario: TC_TV_232:Edit Table-Verify Copyright-popup-default text for copyright
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup default text for copyright 

               @TableVisual
Scenario: TC_TV_233:Edit Table-Verify Copyright-popup-text change for copyright
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup text change for copyright

              @TableVisual
Scenario: TC_TV_234:Edit Table-Verify Copyright-popup-link for copyright
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link for copyright


              @TableVisual
Scenario: TC_TV_235:Edit Table-Verify Copyright-popup-link color
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link color

             @TableVisual
Scenario: TC_TV_236:Edit Table-Verify Copyright-popup-font size
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link font size

             @TableVisual
Scenario: TC_TV_237:Edit Table-Verify Copyright-popup-bold style
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link bold style
           
                @TableVisual
Scenario: TC_TV_238:Edit Table-Verify Copyright-popup-Italic style
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link Italic style        
           
               @TableVisual
Scenario: TC_TV_239:Edit Table-Verify Copyright-popup-Underline style
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link Underline style 
           
           
                 @TableVisual
Scenario: TC_TV_240:Edit Table-Verify Copyright-popup-horizontal alignment (left, right, center)
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link horizontal alignment (left, right, center)       
           
                 @TableVisual
Scenario: TC_TV_241:Edit Table-Verify Copyright-popup-vertical alignment (Top and bottom)
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup link vertical alignment (Top and bottom)           
           
                @TableVisual
Scenario: TC_TV_242:Edit Table-Verify Copyright-popup- closing 
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup closing             
           
                      @TableVisual
Scenario: TC_TV_243:Edit Table-Verify Copyright-popup-expanding and collapsing the copyright sections
 	         And Select some series to my series tab
           And verify Edit Table Copyright popup expanding and collapsing the copyright sections
           
                       @TableVisual
Scenario: TC_TV_244:Edit Table-Dates-Verify dates
 	         And Select some series to my series tab
           And verify Edit Table dates          
                 
                         @TableVisual
Scenario: TC_TV_245:Edit Table-Dates-Verify the list of date formats
 	         And Select some series to my series tab
           And verify Edit Table the list of date formats      
                   
                           @TableVisual
Scenario: TC_TV_246:Edit Table-Dates-Verify ascending order
 	         And Select some series to my series tab
           And verify Edit Table Dates ascending order         

                             @TableVisual
Scenario: TC_TV_247:Edit Table-Dates-Verify descending order
 	         And Select some series to my series tab
           And verify Edit Table Dates descending order         
                  
                             @TableVisual
Scenario: TC_TV_248:Edit Table-Dates-Verify selection of date format
 	         And Select some series to my series tab
           And verify Edit Table Dates selection of date format 
           
                             @TableVisual
Scenario: TC_TV_249:Edit Table-Dates-Verify search
 	         And Select some series to my series tab
           And verify Edit Table Dates search          
           
                              @TableVisual
Scenario: TC_TV_250:Edit Table-Dates-Verify invalid search
 	         And Select some series to my series tab
           And verify Edit Table Dates invalid search
           
                                @TableVisual
Scenario: TC_TV_251:Edit Table Verify last observation
 	         And Select some series to my series tab
           And verify Edit Table last observation
           
                                    @TableVisual
Scenario: TC_TV_252:Edit Table Verify last observation default=24
 	         And Select some series to my series tab
           And verify Edit Table last observation default=24  
           
                                     @TableVisual
Scenario: TC_TV_253:Edit Table Verify with in date range
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Dates with in date range          
           
                                        @TableVisual
Scenario: TC_TV_254:Edit Table Verify Dates All observations
 	         And Select some series to my series tab
           And verify Edit Table Dates All observations             
                  
    
                                          @TableVisual
Scenario: TC_TV_255:Edit Table Verify the selection of observations
 	         And Select some series to my series tab
           And verify Edit Table the selection of observations  
 
                                       @TableVisual
Scenario: TC_TV_256:Edit Table-Value -Verify font color
 	         And Select some series to my series tab
           And verify Edit Table Value font color   
    
                                        @TableVisual
Scenario: TC_TV_257:Edit Table-Value -Verify font size
 	         And Select some series to my series tab
           And verify Edit Table Value font size   
                     
                                        @TableVisual
Scenario: TC_TV_258:Edit Table-Value -Verify font bold
 	         And Select some series to my series tab
           And verify Edit Table Value font bold
                                                  @TableVisual
Scenario: TC_TV_259:Edit Table-Value -Verify font Italic
 	         And Select some series to my series tab
           And verify Edit Table Value font Italic
                                                  @TableVisual
Scenario: TC_TV_260:Edit Table-Value -Verify font Underline
 	         And Select some series to my series tab
           And verify Edit Table Value font Underline.                    
                     
                                              @TableVisual
Scenario: TC_TV_261:Edit Table-Value -Verify font horizontal alignment (left, right, center)
 	         And Select some series to my series tab
           And verify Edit Table Value font horizontal alignment (left, right, center)   
           
                   
                                               @TableVisual
Scenario: TC_TV_262:Edit Table-Value -Blank observations - Verify default selection
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Value Blank observations -default selection as "Filter out blanks" 
           
                                               @TableVisual
Scenario: TC_TV_263:Edit Table-Value -Blank observations - Verify Filter out blanks
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Value Blank observations -Filter out blanks          
           
                                                  @TableVisual
Scenario: TC_TV_264:Edit Table-Value -Blank observations - Verify Leave as blanks
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Value Blank observations -Leave as blanks       
           
                                                  @TableVisual
Scenario: TC_TV_265:Edit Table-Value -Blank observations - Verify 'Fill with N/A
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Value Blank observations -Fill with N/A           
           
                                                     @TableVisual
Scenario: TC_TV_266:Edit Table-Value -Blank observations - Verify Fill with '.'
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Value Blank observations -Fill with dot
           
                                                            @TableVisual
Scenario: TC_TV_267:Edit Table-Value -Blank observations - Verify Fill with '-'
 	         And User Select Series ID  as "310902301"
           And verify Edit Table Value Blank observations -Fill with hyphen 
           
                                                @TableVisual
Scenario: TC_TV_268:Edit Table-Value -Number format - Verify Decimal places
 	          And Select some series to my series tab
            And verify Edit Table Number format Decimal places           
           
                                                 @TableVisual
Scenario: TC_TV_269:Edit Table-Value -Number format -Verify default Decimal places
 	          And Select some series to my series tab
            And verify Edit Table Number default Decimal places as "2"       
           
                                                 @TableVisual
Scenario: TC_TV_270:Edit Table-Value -Number format -Verify Decimal separator as comma
           And User Select Series ID  as "310902301"
 	          And Select some series to my series tab
            And verify Edit Table Number default Decimal separator as comma           
           
           
                                                @TableVisual
Scenario: TC_TV_271:Edit Table-Value -Number format -Verify Grouping separator
            And User Select Series ID  as "310902301"
 	          And Select some series to my series tab
            And verify Edit Table Number default Decimal Grouping separator  
            
                                                   @TableVisual
Scenario: TC_TV_272:Edit Table-Verify horizontal scroll bar for settings sections
 	          And Select some series to my series tab
            And verify Edit Table horizontal scroll bar for settings sections         
            
            
                                                    @TableVisual
Scenario: TC_TV_273:Edit Table-Verify the changes reflected in edit visual-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table the changes reflected in edit visual         
            
            
                                                      @TableVisual
Scenario: TC_TV_274:Edit Table-Verify title icon on visual-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table title icon on visual        
                       
                                                      @TableVisual
Scenario: TC_TV_275:Edit Table-Verify titles popup open by double click on visual title-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table titles popup open by double click on visual title     
      
                                                           @TableVisual
Scenario: TC_TV_276:Edit Table-Verify double click on attribute area-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table double click on attribute area   
      
                                                             @TableVisual
Scenario: TC_TV_277:Edit Table-Verify double click on date field-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table double click on date field     
      
                                                                @TableVisual
Scenario: TC_TV_278:Edit Table-Verify double click on timepoints-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table double click on timepoints    
         
                                                                 @TableVisual
Scenario: TC_TV_279:Edit Table-Verify removing attributes by clicking x icon-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table removing attributes by clicking x icon        
         
                                                    @TableVisual
Scenario: TC_TV_280:Edit Table-Verify clicking on series name-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table clicking on series name        
         
                                                      @TableVisual
Scenario: TC_TV_281:Edit Table- Verify Edit series on visual-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table series on visuale inside Edit tabel popup       
         
                                                       @TableVisual
Scenario: TC_TV_282:Edit Table- Verify Rename option from cogwheel icon-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table Rename option from cogwheel icon inside Edit tabel popup        
         
         
                                                        @TableVisual
Scenario: TC_TV_283:Edit Table- Verify Frequency option from cogwheel icon-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table Frequency option from cogwheel icon inside Edit tabel popup           
         
                                                        @TableVisual
Scenario: TC_TV_284:Edit Table- Verify Currency option from cogwheel icon-inside Edit tabel popup
 	          And User Select Series ID  as "46224501"
             And Select some series to my series tab
            And verify Edit Table Currency option from cogwheel icon inside Edit tabel popup        
         
                                                           @TableVisual
Scenario: TC_TV_285:Edit Table- Verify Change option from cogwheel icon-inside Edit tabel popup
 	          And User Select Series ID  as "46224501"
             And Select some series to my series tab
            And verify Edit Table Change option from cogwheel icon inside Edit tabel popup       
         
                                                              @TableVisual
Scenario: TC_TV_286:Edit Table- Verify tooltip for series-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table tooltip for series inside Edit tabel popup      
         
                                                                  @TableVisual
Scenario: TC_TV_287:Edit Table- Verify scroll down till end of timepoints-inside Edit tabel popup
 	         And User Select Series ID  as "46224501"
             And Select some series to my series tab
            And verify Edit Table scroll down till end of timepoints inside Edit tabel popup    
            
                                                                   @TableVisual
Scenario: TC_TV_288:Edit Table-Verify horizontal scroll-inside Edit tabel popup
 	         And User Select Series ID  as "46224501"
            And Select some series to my series tab
            And verify Edit Table  horizontal scroll inside Edit tabel popup           
            
            
                                                                 @TableVisual
Scenario: TC_TV_289:Edit Table- Verify selecting another visual from visual panel-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table selecting another visual from visual panel inside Edit tabel popup           
            
                                                                   @TableVisual
Scenario: TC_TV_290:Edit Table- Verify selecting another visual from visual dropdown-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table selecting another visual from visual dropdown inside Edit tabel popup 
            
                                                                      @TableVisual
Scenario: TC_TV_291:Edit Table- Verify delete series icon-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table delete series icon inside Edit tabel popup 
                    
                                                                     @TableVisual
Scenario: TC_TV_292:Edit Table- Verify delete all series icon-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table delete all series icon inside Edit tabel popup            
            
            
                                                          @TableVisual
Scenario: TC_TV_293:Edit Table- Edit series -Verify SSP by clicking on series name-inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table SSP by clicking on series name inside Edit tabel popup          
            
                                            @TableVisual
Scenario: TC_TV_294:Edit Table- Edit series -Verify Rename series icon -inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table Rename series icon inside Edit tabel popup          
            
                                            @TableVisual
Scenario: TC_TV_295:Edit Table- Edit series -Verify edit series icon -inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table edit series icon inside Edit tabel popup
            
                                            @TableVisual
Scenario: TC_TV_296:Edit Table- Edit series -Verify Rename option under edit series -inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table Rename option under edit series  inside Edit tabel popup           
            
                                            @TableVisual
Scenario: TC_TV_297:Edit Table- Edit series -Verify Frequency option under edit series -inside Edit tabel popup
 	           And User Select Series ID  as "46224501"
 	          And Select some series to my series tab
            And verify Edit Table Frequency option under edit series  inside Edit tabel popup            
            
            
                                             @TableVisual
Scenario: TC_TV_298:Edit Table- Edit series -Verify Currency option under edit series -inside Edit tabel popup
 	          And User Select Series ID  as "46224501"
             And Select some series to my series tab
            And verify Edit Table Currency option under edit series  inside Edit tabel popup            
                       
            
                                                @TableVisual
Scenario: TC_TV_299:Edit Table- Edit series -Verify Change option under edit series -inside Edit tabel popup
 	          And User Select Series ID  as "46224501"
             And Select some series to my series tab
            And verify Edit Table Change option under edit series  inside Edit tabel popup   
            
                                                   @TableVisual
Scenario: TC_TV_300:Edit Table- Edit series -Verify clicking on frequency or dropdown -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table clicking on frequency or dropdown inside Edit tabel popup        
         
                                                           @TableVisual
Scenario: TC_TV_301:Edit Table- Edit series -Verify Series data conversion -Applay -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion -Applay inside Edit tabel popup 
             
             
                                                           @TableVisual
Scenario: TC_TV_302:Edit Table- Edit series -Verify Series data conversion applying Missing values method -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion applying Missing values method inside Edit tabel popup            
             
             
                                                           @TableVisual
Scenario: TC_TV_303:Edit Table- Edit series -Verify Series data conversion Apply button -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion Apply button inside Edit tabel popup            
             
                                                              @TableVisual
Scenario: TC_TV_304:Edit Table- Edit series -Verify Series data conversion Minimize option -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion Minimize option inside Edit tabel popup          
                                      
                                                              @TableVisual
Scenario: TC_TV_305:Edit Table- Edit series -Verify Series data conversion maximize option -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion maximize option inside Edit tabel popup        
        
                                                               @TableVisual
Scenario: TC_TV_306:Edit Table- Edit series -Verify Series data conversion full screen option -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion maximize full screen inside Edit tabel popup      
        
        
                                                              @TableVisual
Scenario: TC_TV_307:Edit Table- Edit series -Verify Series data conversion exit full screen option -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion exit full screen option inside Edit tabel popup 
                   
                                                             @TableVisual
Scenario: TC_TV_308:Edit Table- Edit series -Verify Series data conversion Cancel/x icon option -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table Series data conversion Cancel/x icon option inside Edit tabel popup        
        
                                                             @TableVisual
Scenario: TC_TV_309:Edit Table- Edit series -Verify dropdown for frequency in series level -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
              And Select series to my series tab
             And verify Edit Table dropdown for frequency in series level inside Edit tabel popup       
        
                                                               @TableVisual
Scenario: TC_TV_310:Edit Table- Edit series -Verify appling frequency in series level -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
             And Select series to my series tab
             And verify Edit Table appling frequency in series level inside Edit tabel popup 
             
                                                                 @TableVisual
Scenario: TC_TV_311:Edit Table- Edit series -Verify appling currency in series level -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
             And Select series to my series tab
             And verify Edit Table appling currency in series level inside Edit tabel popup           
             
                                                                 @TableVisual
Scenario: TC_TV_312:Edit Table- Edit series -Verify clicking on type a function field -inside Edit tabel popup
 	           And User Select Series ID  as "236397903;236274103"
             And Select series to my series tab
             And verify Edit Table clicking on type a function field inside Edit tabel popup                 
             
                                                                  @TableVisual
Scenario: TC_TV_313:Edit Table- Edit series -Verify appling function in series level -inside Edit tabel popup
 	            And Select some series to my series tab
             And verify Edit Table appling function in series level inside Edit tabel popup                 
                       
                                                                  @TableVisual
Scenario: TC_TV_314:Edit Table- Edit series -Verify cancel icon for selected function -inside Edit tabel popup
 	           And Select some series to my series tab
             And verify Edit Table cancel icon for selected function inside Edit tabel popup  
             
                                                                  @TableVisual
Scenario: TC_TV_315:Edit Table- Edit series -Verify multiple functions apply -inside Edit tabel popup
 	           And Select some series to my series tab
             And verify Edit Table multiple functions apply inside Edit tabel popup             
             
                                                                   @TableVisual
Scenario: TC_TV_316:Edit Table- Edit series -Verify search for functions -inside Edit tabel popup
 	           And Select some series to my series tab
             And verify Edit Table search for functions inside Edit tabel popup            
             
                                                                    @TableVisual
Scenario: TC_TV_317:Edit Table- Edit series -Verify removing applied functions -inside Edit tabel popup
 	           And Select some series to my series tab
             And verify Edit Table removing applied functions inside Edit tabel popup            
            
                                                                      @TableVisual
Scenario: TC_TV_318:Edit Table- Edit series -Verify appling invalid function for series -inside Edit tabel popup
 	           And User Select Series ID  as "394611277"
             And Select series to my series tab
             And verify Edit Table appling invalid function for series inside Edit tabel popup           
            
                                                                      @TableVisual
Scenario: TC_TV_319:Edit Table- Edit series -Verify OK button on The function cannot be applied to selected series popup -inside Edit tabel popup
 	           And User Select Series ID  as "394611277"
             And Select series to my series tab
             And verify Edit Table OK button on The function cannot be applied to selected series popup inside Edit tabel popup            
            
            
                                             @TableVisual
Scenario: TC_TV_320:Edit Table- Edit series -Verify Region, Unit and Series ID fields -inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table Region, Unit and Series ID fields inside Edit tabel popup               
             
                       
                                             @TableVisual
Scenario: TC_TV_321:Edit Table- Edit series -Verify horizontal scroll bar for series -inside Edit tabel popup
 	          And Select some series to my series tab
            And verify Edit Table horizontal scroll bar for series inside Edit tabel popup 
            
                                                @TableVisual
Scenario: TC_TV_322:Edit Table-Verify  feedback option
 	          And Select some series to my series tab
            And verify Edit Table feedback option
            
                                                @TableVisual
Scenario: TC_TV_323:Edit Table-Verify description for popup-feedback
 	          And Select some series to my series tab
            And verify Edit Table description for popup             
            
                                                 @TableVisual
Scenario: TC_TV_324:Edit Table-Verify adding text in the field-feedback
 	          And Select some series to my series tab
            And verify Edit Table adding text in the field          
            
                                                 @TableVisual
Scenario: TC_TV_325:Edit Table-Verify Submit and cancel buttons when description field is empty-feedback
 	          And Select some series to my series tab
            And verify Edit Table Submit and cancel buttons when description field is empty   
            
                                                   @TableVisual
Scenario: TC_TV_326:Edit Table-Verify cancel button-feedback
 	          And Select some series to my series tab
            And verify Edit Table cancel button       
                 
                                             @TableVisual
Scenario: TC_TV_327:Edit Table-Verify Submit button-feedback
 	          And Select some series to my series tab
            And verify Edit Table Submit button            
            
                                                  @TableVisual
Scenario: TC_TV_328:Edit Table-Verify growl message after Submit feedback
 	          And Select some series to my series tab
            And verify Edit growl message after Submit button 
            
            
                                                    @TableVisual
Scenario: TC_TV_329:Edit Table-Verify cancel/x button
 	          And Select some series to my series tab
            And verify Edit Table cancel/x button        
            
                                               @TableVisual
Scenario: TC_TV_330:Edit Table-Verify save button
 	          And Select some series to my series tab
            And verify Edit Table save button                      
                     
                                         @TableVisual
Scenario: TC_TV_331:Verify Add related series option
 	          And Select some series to my series tab
            And verify Add related series option        
            
                                            @TableVisual
Scenario: TC_TV_332:Verify Add related series option when the visual is empty
 	          And  create visual tab
 	          And select the table visual
            And verify Add related option when the visual is empty                           
             
             
                                           @TableVisual
Scenario: TC_TV_333:Verify adding series from Series suggestion manager popup
 	         And User Select Series ID  as "394611277"
            And Select series to my series tab
            And Verify adding series from Series suggestion manager popup              
             
                                             @TableVisual
Scenario: TC_TV_334:Verify add to insight option
 	          And  create visual tab
 	          And select the table visual
            And verify add to insight option            
             
                                              @TableVisual
Scenario: TC_TV_335:Add to insight -Verify Add option under Add to insight
 	          And  create visual tab
 	          And select the table visual
            And verify Add option under Add to insight             
             
                                                @TableVisual
Scenario: TC_TV_336:Add to insight -Verify confirmation message for adding visual to new insight
 	          And  create visual tab
 	          And select the table visual
            And verify confirmation message for adding visual to new insight   
            
                                                  @TableVisual
Scenario: TC_TV_337:Add to insight -Verify Validate the added visual by opening new insight
 	          And  create visual tab
 	          And select the table visual
            And verify Validate the added visual by opening new insight          
            
                                                   @TableVisual
Scenario: TC_TV_338:Add to insight - Verify growl popup auto close
 	          And  create visual tab
 	          And select the table visual
            And verify growl popup auto close            
            
                                                  @TableVisual
Scenario: TC_TV_339:Copy - Verify Copy option
 	         And User Select Series ID  as "394611277"
            And Select series to my series tab
            And verify Copy option             
            
                                                    @TableVisual
Scenario: TC_TV_340:Copy -Verify confirmation message for copy visual
 	        And Select some series to my series tab
            And verify confirmation message for copy visual     
            
                                                     @TableVisual
Scenario: TC_TV_341:Copy -Verify copy here in growl message
 	        And Select some series to my series tab
            And verify copy here in growl message
            
                                       @TableVisual
Scenario: TC_TV_342:Copy-Validate copied visual by pasting with in the insight
 	        And Select some series to my series tab
            And verify copied visual by pasting with in the insight         
   
                                          @TableVisual
Scenario: TC_TV_343:Copy-Validate copied visual by pasting to new insight
 	        And Select some series to my series tab
            And verify copied visual by pasting to new insight              
                                                            
                                                            
                                 @TableVisual
Scenario: TC_TV_344:Copy-Verify the confrimation message for pasting visual in insight
 	        And Select some series to my series tab
            And verify confrimation message for pasting visual in insight
            
            
                                  @TableVisual
Scenario: TC_TV_345:Download - Verify Download option
 	        And Select some series to my series tab
            And verify Download option           
            
            
                                   @TableVisual
Scenario: TC_TV_346:Download - Verify Table visual download with excel format
 	        And Select some series to my series tab
 	         And select XLSX format
            And verify Table visual download with "xlsx" format           
            
     
         
                                      @TableVisual
Scenario: TC_TV_347:Download - Verify Table visual download with PDF format
 	        And Select some series to my series tab
 	        And select PDF format
           And verify Table visual download with "pdf" format       
         
         
         
                                      @TableVisual
Scenario: TC_TV_348:Download - Verify Table visual download with PNG format
 	        And Select some series to my series tab
 	         And select PNG format
            And verify Table visual download with "png" format       
         
         
                                    @TableVisual
Scenario: TC_TV_349:Download - Verify Table visual download with JPG format
 	        And Select some series to my series tab
 	         And select JPG format
            And verify Table visual download with "jpeg" format     
            
            
                                    @TableVisual
Scenario: TC_TV_350:Verify Open option
 	        And Select some series to my series tab
            And verify Open option          
            
            
                                     @TableVisual
Scenario: TC_TV_351:Verify closing of maximized window
 	        And Select some series to my series tab
            And verify closing of maximized window                
            
                                      @TableVisual
Scenario: TC_TV_352:Verify Delete Table
 	        And Select some series to my series tab
            And verify Delete Table           
            
                                        @TableVisual
Scenario: TC_TV_353:Verify Delete description for delete confirmation popup
 	          And Select some series to my series tab
            And verify description for delete confirmation popup             
                   
                                            @TableVisual
Scenario: TC_TV_354:Verify Delete OK button in delete confirmation popup
 	          And Select some series to my series tab
            And verify Delete OK button in delete confirmation popup      
            
            
                                              @TableVisual
Scenario: TC_TV_355:Verify Cancel/x icon in delete confirmation popup
 	          And Select some series to my series tab
            And verify Delete Cancel/x icon in delete confirmation popup           
            
                                               @TableVisual
Scenario: TC_TV_356:Verify right click options
 	          And Select some series to my series tab
            And verify right click options-Table visual       
            
                                                @TableVisual
Scenario: TC_TV_357:Verify Right click -Copy Table
 	          And Select some series to my series tab
            And verify right click options-Copy Table
            
                                                 @TableVisual
Scenario: TC_TV_358:Verify Right click -Validate copied Table
 	          And Select some series to my series tab
            And verify right click Validate copied Table           
                        
                                                   @TableVisual
Scenario: TC_TV_359:Verify Right click -Cut Table
 	          And Select some series to my series tab
            And verify right click options Cut Table
            
                                          @TableVisual
Scenario: TC_TV_360:Verify Right click - Validate Cut Table
 	          And Select some series to my series tab
            And verify right click  Validate Cut Table 
                     
                                            @TableVisual
Scenario: TC_TV_361:Verify Right click -Delete Table 
 	          And Select some series to my series tab
            And verify right click  options Delete Table     
            
                                            @TableVisual
Scenario: TC_TV_362:Verify Right click -insert visual sub dropdown
 	          And Select some series to my series tab
            And verify right click  options insert visual sub dropdown           
            
                                            @TableVisual
Scenario: TC_TV_363:Verify Right click -chart under insert visual
 	          And Select some series to my series tab
            And verify right click  chart under insert visual           
            
                                            @TableVisual
Scenario: TC_TV_364:Verify Right click -Pie under insert visual
 	          And Select some series to my series tab
            And verify right click  Pie under insert visual
                                                       @TableVisual
Scenario: TC_TV_365:Verify Right click -table under insert visual
 	          And Select some series to my series tab
            And verify right click  table under insert visual           
            
                                              @TableVisual
Scenario: TC_TV_366:Verify Right click -map under insert visual
 	          And Select some series to my series tab
            And verify right click  map under insert visual           
            
                                            @TableVisual
Scenario: TC_TV_367:Verify Right click -Heatmap under insert visual
 	          And Select some series to my series tab
            And verify right click  Heatmap under insert visual
                                                       @TableVisual
Scenario: TC_TV_368:Verify Right click -Pyramid under insert visual
 	          And Select some series to my series tab
            And verify right click  Pyramid under insert visual      
            
            
                                                 @TableVisual
Scenario: TC_TV_369:Verify Right click -Commentary under insert visual
 	          And Select some series to my series tab
            And verify right click  Commentary under insert visual           
            
                                            @TableVisual
Scenario: TC_TV_370:Verify Right click -Attachment under insert visual
 	          And Select some series to my series tab
            And verify right click  Attachment under insert visual
                                                       @TableVisual
Scenario: TC_TV_371:Verify Right click -image under insert visual
 	          And Select some series to my series tab
            And verify right click  image under insert visual      
            
                                                                   @TableVisual
Scenario: TC_TV_372:Verify Right click -Filter under insert visual
 	          And Select some series to my series tab
            And verify right click  Filter under insert visual        
  
                                         @TableVisual
Scenario: TC_TV_373:Verify Right click -Paste visual
 	          And Select some series to my series tab
            And verify right click Paste visual                  
                          
                                      @TableVisual
Scenario: TC_TV_374:Verify Right click -View as sub dropdown
 	          And Select some series to my series tab
            And verify right click View as sub dropdown
            
                                      @TableVisual
Scenario: TC_TV_375:Verify Right click -View as Chart
 	          And Select some series to my series tab
            And verify right click View as Chart
            
                                                  @TableVisual
Scenario: TC_TV_376:Verify Right click -View as Map
 	          And Select some series to my series tab
            And verify right click View as Map
            
                                                  @TableVisual
Scenario: TC_TV_377:Verify Right click -View as Histogram
 	          And Select some series to my series tab
            And verify right click View as Histogram
            
                                                  @TableVisual
Scenario: TC_TV_378:Verify Right click -View as Pie
 	          And Select some series to my series tab
            And verify right click View as Pie
            
                                                  @TableVisual
Scenario: TC_TV_379:Verify Right click -View as Heatmap
 	          And Select some series to my series tab
            And verify right click View as Heatmap           
    
                                                      @TableVisual
Scenario: TC_TV_380:Verify Right click -Calculated series sub dropdown
 	          And Select some series to my series tab
            And verify right click Calculated series sub dropdown
            
                              @TableVisual
Scenario: TC_TV_381:Verify Right click -appling function from Calculated series
 	          And Select some series to my series tab
            And verify right click appling function from Calculated series      
            
                               @TableVisual
Scenario: TC_TV_382:Verify Right click - Edit series option
 	          And Select some series to my series tab
            And verify right click  Edit series option             
            
                                @TableVisual
Scenario: TC_TV_383:Verify Right click - Clear contents
 	          And Select some series to my series tab
            And verify right click Clear contents          
            
                                  @TableVisual
Scenario: TC_TV_384:Verify Right click -reset format
 	          And Select some series to my series tab
            And verify right click  reset format           
            
                                  @TableVisual
Scenario: TC_TV_385:Verify Right click -reset format option if have no changes in visual
 	          And Select some series to my series tab
            And verify right click  reset format option if have no changes in visual           
            
                                    @TableVisual
Scenario: TC_TV_386:Verify Right click -download sub dropdown
 	          And Select some series to my series tab
            And verify right click download sub dropdown          
                        
                                               @TableVisual
Scenario: TC_TV_386:Verify Right click -download > Table
 	          And Select some series to my series tab
            And verify right click download > Table
            
                                          @TableVisual
Scenario: TC_TV_386:Verify Right click -download > View
 	          And Select some series to my series tab
            And verify right click download > View
            