Feature:  verifying Insight Explorer Functionality

Background:
   Given User has successful logged in

@LandingPage
Scenario: TC_IE_01: Verify All Tabs in Landing page
   And Successfully Verify the Tabs present in Landing page
  
  @LandingPage
Scenario: TC_IE_02: Verify New insight button to create new insight
   And  Select the New insight option in Landing page
   Then verify the New insight has been created 
      
   @LandingPage
Scenario: TC_IE_88: Verify insights under My insights tab.
   And  Select the New insight option in Landing page
   Then verify the New insight under My insights tab

   @LandingPage
Scenario: TC_IE_89: Verify Mouse over on inisight title in Table mode.
   And  Select the New insight option in Landing page
   And get insight name and add  any five series to my series tab
   And  Mouse over on inisight title in Table mode.
   Then verify the insight name and number of series 
   
    @LandingPage
Scenario: TC_IE_66: Verify insights under Shared with me tab.
   And  Select the Shared option in Landing page
   Then verify the insights under Shared with me tab       
    
 @LandingPage
Scenario: TC_IE_102: Verify All tags drop down for no tags in insights.
   And Select the All tag dropdown
   And Verify the Meassgae for the All tags drop down for no tags in insights
         
@LandingPage
Scenario: TC_IE_03: Verify All tags drop down.
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights 
 
  @LandingPage
Scenario: TC_IE_103: Verify Tag filter for all other tabs when tags applied in current tab
	  And Add tags for insight
	  And Select the All tag dropdown
	  And Verify that tag should be applied for all other tab
  

  @LandingPage
Scenario: TC_IE_04: Verify Categories dropdown.
   And Successfully Verify Categories dropdown  
  
   @LandingPage
Scenario: TC_IE_05: Verify categories selection for Hot Topics.
   And Select the Hot topics option
   And verify the Hot topics category is available in the insight
  
    @LandingPage
Scenario: TC_IE_06: Verify categories selection for World Economy
   And Select the World Economy option
   And verify the World Economy category is available in the insight
  
    @LandingPage
Scenario: TC_IE_07: Verify categories selection for Emerging Markets
   And Select the Emerging Markets option
   And verify the Emerging Markets category is available in the insight
  
  
     @LandingPage
Scenario: TC_IE_08: Verify categories selection for Thematic Analysis
   And Select the Thematic Analysis option
   And verify the Thematic Analysis category is available in the insight
  
   @LandingPage
Scenario: TC_IE_09: Verify categories selection for  Markets
   And Select the  Markets option
   And verify the  Markets category is available in the insight  
 
   @LandingPage
Scenario: TC_IE_10: Verify categories selection for  New Datasets
   And Select the  New Datasets option
   And verify the  New Datasets category is available in the insight   
  
 @LandingPage
Scenario: TC_IE_11: Verfify Remove icon for filters.
   And Select all category option
   And Successfully Verify Remove icon for filters
    
  @LandingPage
Scenario: TC_IE_12: Verify View as a grid option.
   And Successfully Verify View as a grid option
    
 @LandingPage
Scenario: TC_IE_13: Verify View as a table option.
   And Successfully Verify View as a table option    
      
 @LandingPage
Scenario: TC_IE_14: Verify View insight.
   And Select an insight
   And Successfully Verify View insight 
  
 @LandingPage
Scenario: TC_IE_15: Verify CEIC logo.
   And Verify the landing page in left hand side
   
@LandingPage
Scenario: TC_IE_16: Verify Alert option.
   And Select Alert option  
   And Alert dropdown should have See all notification option.
   
@LandingPage
Scenario: TC_IE_17: Verify See all Notification.
   And Select Alert option  
   And Select See all Notification option.
   And Successfully redirect to Notification page

@LandingPage
Scenario: TC_IE_18: Verify Product on landing page.
   And Select Product option  
   And Successfully Verify Product Dropdown 
   
   @LandingPage
Scenario: TC_IE_19: Verify Glboal databases under Product.
   And Select Product option  
   And Successfully Verify All databases like "ExploreData" "SeeFootnotes" "Watchvideo" under Product 
   
    @LandingPage
Scenario: TC_IE_20: Verify World Trend Plus databases under Product.
   And Select Product option  
   And Successfully Verify World Trend Plus databases like "ExploreData" "SeeFootnotes" under Product   

    @LandingPage
Scenario: TC_IE_26: Verify China Premium databases under Product.
   And Select Product option  
   And Successfully Verify China Premium databases like "ExploreData" "SeeFootnotes" "Watchvideo" under Product   
   
     @LandingPage
Scenario: TC_IE_27 Verify Brazil Premium databases under Product.
   And Select Product option  
   And Successfully Verify Brazil Premium databases like "ExploreData" "SeeFootnotes" "Watchvideo" under Product    
   
 @LandingPage
Scenario: TC_IE_28 Verify India Premium databases under Product.
   And Select Product option  
   And Successfully Verify India Premium databases like "ExploreData" "SeeFootnotes" "Watchvideo" under Product    
     
   @LandingPage
Scenario: TC_IE_29 Verify Russia Premium databases under Product.
   And Select Product option  
   And Successfully Verify Russia Premium databases like "ExploreData" "SeeFootnotes" "Watchvideo" under Product  
   
    @LandingPage
Scenario: TC_IE_30 Verify Indonesia Premium databases under Product.
   And Select Product option  
   And Successfully Verify Indonesia Premium databases like "ExploreData" "SeeFootnotes" "Watchvideo" under Product 
   
  @LandingPage
Scenario: TC_IE_21: Verify What's New option under Product.
   And Select Product option  
   And Successfully verify the What's New option under Product   

####  @LandingPage
####Scenario: TC_IE_22: Verify Take the servey under what's new.
####   And Select Product option  
####   And Select the What's New and Take the servey option 
####    And Successfully verify the Take the servey option under what's new   
   
   @LandingPage
Scenario: TC_IE_23: Verify Help menu.
   And Select Help option  
   And Successfully verify the Help option as "Contact Us" "Email Us" "Knowledge Base" "Diagnostics" "Report a problem" "Live Chat" "Video Tutorials" "Tours" "Quick Start Guide" "Search Help" "Keyboard Shortcuts" "Excel Add-in" "API" "R" "EViews"     

##   
###    @LandingPage
###Scenario: TC_IE_24: Verifying latest data byte under what's new.
###   And Select Product option  
###   And Select the What's New option 
###    And Successfully verify the latest data option under what's new   
##   
####    @LandingPage
####Scenario: TC_IE_25: Verify Product Newsletters.
####   And Select Product option  
####   And Select the What's New option 
####    And Successfully Verify Product Newsletters


    @LandingPage
Scenario: TC_IE_31: Verify Footnotes dropdown.
   And Select Footnotes option  
    And Successfully Verify Footnotes dropdown

   @LandingPage
Scenario: TC_IE_32: Verify Insight title change.
   And Select any Insight
    And Successfully Verify Insight title change as "TC_IE_32"
    
      @LandingPage
Scenario: TC_IE_33:  Verify favorite icon behavior. 
   And Select the Star icon
   And Successfully Verify favorite icon behavior 
    
   @LandingPage
Scenario: TC_IE_34: Verify insights in Favorites tab. 
   And Select the Star icon
   And Successfully Verify favorite icon behavior for insight "TC_IE_32"

 @LandingPage
Scenario: TC_IE_35: Verify insights under My insights tab. 
    And  Select the New insight option
   And create a insight as "My Insight"
   And Successfully Verify insights under My insights tab as "My Insight"
   
   
   @LandingPage
Scenario: TC_IE_36: Verify insights in Recent tab. 
   And  Select the New insight option
   And create a Insight as "Recent insight"
   And Successfully Verify Insights under   tab as "Recent insight"
   
     @LandingPage
Scenario: TC_IE_37: Verify View Comments. 
   And  Select the View Comments option
   And Successfully Verify Comments option is working
  
        @LandingPage
Scenario: TC_IE_38: Verify Notification icon. 
   And  Select the Notification  option
   And Successfully Verify Notification option is working
   
        @LandingPage
Scenario: TC_IE_39: Verify profile dropdown. 
   And  Select the profile dropdown
   And Successfully Verify profile dropdown as "User name" "Language" "Profile" "Change password" "Preferences" "Regional formats" "Keyboard shortcuts" "Excel Add-in" "CEIC API access" "Sign out"
   
 @LandingPage
Scenario: TC_IE_40: Verify Back button. 
   And  Select Preferences option 
   And Successfully Verify Back button is working
   
   @LandingPage
Scenario: TC_IE_41: Verify Folders. 
   And  Select Folder panel option 
   And Select Migrated Insight 
   And Successfully Verify Folders having Insights 
 
    @LandingPage
Scenario: TC_IE_42:Verify New folder. 
   And  Select Folder panel option 
   And  Select New Folder option 
   And Successfully Verify New Folders is created As "TC_IE_41"

  @LandingPage
Scenario: TC_IE_43:Verify Empty folder. 
   And Successfully Verify Empty folder 
  
     @LandingPage
Scenario: TC_IE_44:Verify Right click options for folder. 
   And  Select Right click options on folder 
   And Successfully Verify  Right click options as "Rename" "Newfolder" "Newinsight" "Share" "Addtag" "Deletefolder" on folder  
   
   @LandingPage
Scenario: TC_IE_45: Verfify folder rename.  
   And  Select Rename option
   And  Rename folder name as "TC_IE_45" 
   And Successfully Verify Rename folder name as "TC_IE_45" 
      
      @LandingPage
Scenario: TC_IE_46:Verify new folder in right click. 
    And  Select Right click options on folder 
   And  Select New Folder option in right click
   And Successfully Verify New Folders is created under Existing Folder As "TC_IE_46" 


      @LandingPage
Scenario: TC_IE_47:Verify new insights under folder right click. 
    And  Select Right click options on folder 
   And  Select New Insights option in right click
   And Successfully Verify New Insights is created As "TC_IE_47" 

 @LandingPage
Scenario: TC_IE_67:Verify share option in folder right click
    And  Select share option in right click
   And Successfully Verify share option is working


 @LandingPage
Scenario: TC_IE_48: Verify Add tags. 
    And  Select Right click options on folder 
   And  Select Add tags option in right click
   And Successfully Verify Add tags option is working 
   
   @LandingPage
Scenario: TC_IE_49: Verify Delete folder. 
   And  Select Delete folder option in right click
   And Successfully Verify Delete folder option is working 

    @LandingPage
Scenario: TC_IE_50:Verify Right click options for Insight. 
   And  Select Right click options on Insight 
   And Successfully Verify  Right click options as "View" "Open" "Open in new tab" "copy" "Share" "Move to" "Add tag" "Deleate"

   @LandingPage
Scenario: TC_IE_51: Verify View Option in Right click menu on Insight. 
  And  Select Right click options on Insight 
  And  Select View options
  And Successfully Verify View insight option is working 
  
    @LandingPage
Scenario: TC_IE_52: Verify Open Option in Right click menu on Insight. 
  And  Select Right click options on Insight 
  And  Select Open options
  And Successfully Verify Open insight option is working 
  
   @LandingPage
Scenario: TC_IE_53: Verify Open in new tab Option in Right click menu on Insight. 
  And  Select Right click options on Insight 
  And  Select Open in new tab options
  And Successfully Verify Open in new tab insight option is working 
 
    @LandingPage
Scenario: TC_IE_54: Verify Copy Option in Right click menu on Insight. 
   And  Select Right click options on Insight 
  And  Select Copy options
  And Successfully Verify Copy insight option is working 

    @LandingPage
Scenario: TC_IE_55: Verify Add Tag(POP_UP_Window) Option in Right click menu on Insight. 
   And  Select Right click options on Insight 
  And  Select Add Tag options
  And Successfully Verify Add Tag pop is displayed 

  @LandingPage
Scenario: TC_IE_56: Verify Add Tag Option in Right click menu on Insight. 
   And  Select Right click options on Insight 
  And  Select Add Tag options
  And Successfully Verify Add Tag option is working for insight


 @LandingPage
Scenario: TC_IE_57: Verify Delete Option in Right click menu on Insight. 
   And  Select Right click options on Insight 
  And  Select Delete options
  And Successfully Verify Delete option is working for insight
  
  
  @LandingPage
Scenario: TC_IE_58: Verify add tags for multiple insights at once. 
   And  Select two or more Insights 
   And  Select Add tag options
  And Successfully Verify Add Tag option is working for Multiple insight
  
  
    @LandingPage
Scenario: TC_IE_59: Verify selected insights count in add tags window. 
   And  Select two or more Insights 
  And Successfully Verify Add Tag count in the pop up window

    @LandingPage
Scenario: TC_IE_60: Verify Sort by drop down 
   And  Select Sort down option
   And Successfully Verify  Sort down option 
   
  
       @LandingPage
Scenario: TC_IE_61: Sort by - Verify Last Opened
   And  Select Some insigt to Verify Last Opened option
   And Successfully Verify  Last Opened Insights
  
      @LandingPage
Scenario: TC_IE_62:  Verify Move to option to existing Folder in right click 
    And  Select Folder panel option and  create a New Folder 
     And  Insights should be moved to existing folder
 
 
       @LandingPage
Scenario: TC_IE_63:  Verify Move to option by creating Folder in right click 
    And  Select the Insigt and create Folder 
     And  Insights should be moved to created folder
    And Successfully Verify  Insights moved to created folder
  
          @LandingPage
Scenario: TC_IE_64:  Verify Share option in right click 
   And  Select Right click options on Insight 
  And  Select Share options
  And Successfully Verify Share insight option is working 
  
 @LandingPage
Scenario: TC_IE_65:  Verify share for multiple insights 
   And  Select two or more Insights
  And  Selects Share options
  And Successfully Verify Share insight count is working 
  
   @LandingPage
Scenario: TC_IE_68:Verify Insights Counts for each tabs
    And  Select Insights Counts for each tabs
   And Successfully Verify Insights Counts equal to ALl tab
  
   @LandingPage
Scenario: TC_IE_69:Verify insights in All Available tab
   And  Select the New insight option in Landing page
   And create a Insight as "All insight"
   Then verify the New insight under All tab as "All insight"
  
@LandingPage
Scenario: TC_IE_70: Verify All tags drop down for Analytics Tab.
   And Select the Analytics Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights

     @LandingPage
Scenario: TC_IE_71: Verify All tags drop down for Analytics-China Premium Tab.
   And Select the China Premium  Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights    
   
       @LandingPage
Scenario: TC_IE_72: Verify All tags drop down for Analytics-Focus Tab.
   And Select the Analytics-Focus Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights    
   
       @LandingPage
Scenario: TC_IE_73: Verify All tags drop down for Analytics-Sentix Tab.
   And Select the Analytics-Sentix Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights   
   
         @LandingPage
Scenario: TC_IE_74: Verify All tags drop down for Analytics-EMIS Tab.
   And Select the Analytics-EMIS Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights 
  
   @LandingPage
Scenario: TC_IE_75: Verify All tags drop down for Shared Tab.
   And Select the Shared Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights 
  
   @LandingPage
Scenario: TC_IE_76: Verify All tags drop down for Recent Tab.
   And Select the Recent Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights 
   
     @LandingPage
Scenario: TC_IE_77: Verify All tags drop down for All Tab.
   And Select the All Tab
   And Add tags for insight
   And Select the All tag dropdown
   And Added tags should be available in dropdown and should display related insights 
   
   @LandingPage
Scenario: TC_IE_78:  Verify categories selection for Hot Topics with All available Tabs.
    And Select the categories as Hot Topics for the insight 
    And Select the categories option as Hot topics option
   And verify the Hot topics category in "Analytics Tab" "Shared Tab" "Recent Tab" "All Tab"    
   
   @LandingPage
Scenario: TC_IE_79:  Verify categories selection for World Economy with All available Tabs.
    And Select the categories as World Economy for the insight 
    And Select the categories option as World Economy option
   And verify the World Economy category in "Analytics Tab" "Shared Tab" "Recent Tab" "All Tab"    
   
      @LandingPage
Scenario: TC_IE_80: Verify categories selection for Emerging Markets with All available Tabs.
   And Select the categories as Emerging Markets for the insight 
  And Select the categories option as Emerging Markets option
   And verify the Emerging Markets category in "Analytics Tab" "Shared Tab" "Recent Tab" "All Tab" 
   
    @LandingPage
Scenario: TC_IE_81: Verify categories selection for Thematic Analysis with All available Tabs.
      And Select the categories as Thematic Analysis for the insight 
     And Select the categories option as Thematic Analysis option
   And verify the Thematic Analysis category in "Analytics Tab" "Shared Tab" "Recent Tab" "All Tab" 
   
     @LandingPage
Scenario: TC_IE_82: Verify categories selection for Markets with All available Tabs.
  And Select the categories as Markets for the insight 
  And Select the categories option as Markets option
   And verify the  Markets category in "Analytics Tab" "Shared Tab" "Recent Tab" "All Tab" 
    
    @LandingPage
Scenario: TC_IE_83: Verify categories selection for New Datasets with All available Tabs.
     And Select the categories as New Datasets for the insight 
  And Select the categories option as New Datasets
   And verify the New Datasets category in "Analytics Tab" "Shared Tab" "Recent Tab" "All Tab" 
  
    @LandingPage
Scenario: TC_IE_84: Verify CopyLink option in right click.
    And  Select Right click options on Insight 
   And  Select CopyLink options
   And Successfully Verify CopyLink insight option is working 

 @LandingPage
Scenario: TC_IE_85: Verify search in landing page.
   And Add tags for insight
   And  Search with tag name as "AddedTag"
    And Verify the search with tag name as "AddedTag"
    
    @LandingPage
Scenario: TC_IE_86: Verify Search in landing page by all content with Series ID.
   And  Select the New insight option
   And Change the insight name as "TC_IE_86"
   And Search for the ID "284748804"
   And Verify the insight name as "TC_IE_86" for Successful landing page search with Series ID as "284748804"
   
       @LandingPage
Scenario: TC_IE_87: Verify Search in landing page by Name.
   And Select the insight to be search
   And Change the insight name as "TC_IE_87" in IE page
   And Select search by name drop down
   And Search for the insight name as  "TC_IE_87"
   And Verify the insight name as "TC_IE_87" for Successful landing page search by Name
    
         @LandingPage
Scenario: TC_IE_90: Verify Search as Series ID in landing page by Selecting Name category dropdown.
   And  Select the New insight option
   And Change the insight name as "TC_IE_90"
    And Search for the ID "284748804"
   And Select search by name drop down
   And Search for the insight name as  "284748804"
   And Verify that insight should not display for Series ID when search by Name is selected 

     @LandingPage
Scenario: TC_IE_91: Verify Search by all content - Insight attributes.
   And  Select the New insight option
   And Change the insight name as "TC_IE_91"
   And Gives a Description as "Testing Insight attributes"
   And Select Insight attributes drop down
   And Search with Description as "Testing Insight attributes" for search by all content - Insight attributes
   And Verify the insight as "TC_IE_91" with Description "Testing Insight attributes" for search by all content - Insight attributes
  
     @LandingPage
Scenario: TC_IE_92: Verify Search by all content - Series attributes.
   And  Select the New insight option
   And Change the insight name as "TC_IE_92"
   And Take a copy of the series ID 
   And Select Insight attributes drop down as Series attributes
   And Search for the Series ID in IE Page as "369703417"
   And Verify the insight as "TC_IE_92" with Series ID as "369703417" for search as by all content - Series attributes
      
        @LandingPage
Scenario: TC_IE_93: Verify search by all content with all checkboxes unselected.
   And  Select the New insight option
   And Change the insight name as "TC_IE_93"
   And Search for the ID "284748804"
   And unSelect Insight attributes drop down
   And Search for the Series ID in IE Page as "284748804"
    And Verify that insight should not display for Series ID when all checkboxes unselected
    
              @LandingPage
Scenario: TC_IE_94: Verify search with Invalid keyword.
     And Search for the insight name as  "InvalidKeyword"
     And Verify that insight should not display for Invalid keyword
     
     
            @LandingPage
Scenario: TC_IE_95:  Verify Create insight pop up appear when invalid keyword is searched.
     And Search for the insight name as  "InvalidKeyword"
     And Select the Create insight button
     And Verify that Create insight pop up Appear    
     
                @LandingPage
Scenario: TC_IE_96: Verify Create insight Functionality for the insight pop up appear when invalid keyword is searched
     And Search for the insight name as  "InvalidKeyword"
     And Select the Create insight button
     And Create a insight name as "TC_IE_96"
     And Verify that Create insight Functionality is working by creating Insight 
     
             @LandingPage
Scenario: TC_IE_97: Verify Search by all content options when Search by name is selected..
     And Select the Search Dropdown
     And Select Search by name
     And Verify that Insight attributes and Series attributes in search drop down is disabled     
    
                 @LandingPage
Scenario: TC_IE_98: Verify search when any filter applied.
     And  Select the New insight option
    And Change the insight name as "TC_IE_98_A"
     And Search for the ID "134784208"
     And  Select the New insight option
      And Change the insight name as "TC_IE_98_B"
     And Search for the ID "134784208"
      And Applay Tag for the insight "TC_IE_98_A"
      And Search for the Series ID in IE Page as "134784208"
      And Verify the search with in available insights and work with respect to the applied filters. 
     
      @LandingPage
Scenario: TC_IE_99: Verify message for no insights search in Other tab than Myinsight
     And  Select the New insight option
     And Change the Insight name as "TC_IE_99"
     And navigate to Analytics tab
     And Search for the Series ID in IE Page as "TC_IE_99"
     And Verify message for no insights search in current tab 
     
     @LandingPage
Scenario: TC_IE_100:  Verify All available hyperlink for no insights search in Other tab than Myinsight.
     And  Select the New insight option
     And Change the Insight name as "TC_IE_100"
     And navigate to Analytics tab
     And Search for the Series ID in IE Page as "TC_IE_100"
     And Verify All available hyperlink functionality is working 
   
     
     @LandingPage
Scenario: TC_IE_101:  Verify the number of insight count with search.
     And  Select the New insight option
     And Change the Insight name as "TC_IE_101_A"
      And  Select the New insight option
     And Change the Insight name as "TC_IE_101_B"
     And Search for the Series ID in IE Page as "TC_IE_101"
     And Verify the number of insight count with search   