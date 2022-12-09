
Feature: validation of User visibity cases 
 

  @UserVisibilityCases
  Scenario:TC_UV_01: Verify switching tabs on header.
    Given user clicks on Data/Analysis/comparables/Releases/Watchlist
    And should be able to switch to respective tabs.
      
@UserVisibilityCases
  Scenario:TC_UV_02: Verify switching tabs under Data tabs.
    Given user clicks on Data Tab
    And switch to Database/Series/Datasets/User data
    
 @UserVisibilityCases
  Scenario:TC_UV_03: Verify Open and close functionality for data briefings.
    Given user clicks on open and close icon for Databriefings Panel
    And Databriefings Panel should be open and closed.
    
    @UserVisibilityCases
  Scenario:TC_UV_04: Verify Expand and resize for search panel.
    Given user clicks on expand icon for search panel
    And clicks on expand views.
    
     @UserVisibilityCases
  Scenario:TC_UV_05: Verify Expand and resize for search panel.
    Given user clicks on expand icon(<<) for view  panel
    And clicks on expand search(>>).
  #-------functionality removed--------#  
    # @UserVisibilityCases1
  #Scenario: TC_UV_10: Verify adding separator along with series to My series.
   # Given User Selects a Separator and series
    #And add series into My series
    
     #@UserVisibilityCases	
     
  #Scenario: TC_UV_11: Verify adding separator along with series to visual.
   # Given User Selects a Separator and series=>Create any Visual
    #And seperator should be skipped.
    #-------functionality removed--------#
    
     @UserVisibilityCases
  Scenario:TC_UV_07: Verify opening any filter popup and click on anywhere in the application.
    Given user clicks on any filter popup
    And click on it somewhere in the application
    Then filter popup should be closed with applying selected functions.  
    
     @UserVisibilityCases
  Scenario: TC_UV_08: Verify 'TOP' option functionality.
    Given User opens series tab
    And scroll down for series
    And click on TOP option next to search feild
     
     @UserVisibilityCases
  Scenario:TC_UV_09: Verify dragging live chat icon
    Given user Drag and Drop on Chat icon anywhere in the screen
     
    
      @UserVisibilityCases
  Scenario: TC_UV_12: Verify the search is active after re-login to application.
    Given user enters search with keyword "GDP".
    And user logout and relogins the application.
    And check the search status.
   
   
    
   
    
     @UserVisibilityCases
  Scenario: TC_UV_13: Verify table opened status once switch to different tab and come back to previous tab.
    Given User Expands DataTable in database/My series
    And switch to next tab
    And comeback to Database/My Series
   
    
    
      	
     @UserVisibilityCases	
  Scenario: TC_UV_14: Verify the possibilities of download for recent download when the main download option is grayed out.
    Given User clicks on recent download=>Next to download button
    And click on redownload.
    
  
    
    