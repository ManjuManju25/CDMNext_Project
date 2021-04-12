Feature: Verifying Pie Visual Functionality
 
@PieVisual
Scenario: TC_Pie_01: Verify Pie option under Views > Visuals tab
   And Open preference dropdown
   And Clicking on "Keyboard shortcuts" option under user preference be "ON" 
   And Open preference dropdown
   And Creating an Insight by selecting few series
   And Click to create an empty visual
   Then Should display "Pie" options on the right pane under "Views" > "Visuals" tab
    
@PieVisual
Scenario: TC_Pie_02: Verify creating Pie visual with random series present in a search pane of an insight
   And Select different frequency series "399294877;399295497" and click on "Pie" icon 
   Then Pie visual should be created with frequency conversion window popped up
   
@PieVisual
Scenario: TC_Pie_03: Verify Drag and drop of Pie option
    And Click to create an empty visual
    And Hovor on Insert Pie
    And  "Drag and Drop" the Insert pie option
    Then Pie visual should add to view area by "DragandDrop" 
    
@PieVisual
Scenario: TC_Pie_04: Verify any of the frequencied series to weekly series to visualize pie
    And Search for the series with SID "403700407;355221497"
    And Search for the series with SID "236248103;359237987"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then Frequency conversion window should be popped for selecting other than weekly frequency in same window
    
@PieVisual
Scenario: TC_Pie_05: Verify click on cancel in currency conversion popup
    And Search for the series with SID "34709201;280072003"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then The Data conversion window should get closed
    
@PieVisual
Scenario: TC_Pie_06: Verify changing data into US dollars in currency conversion popup with keep as reported
    And Search for the series with SID "34709201;280072003"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    And Make the changes in series harmonization popup
    Then US currency should be applicable for series in visual pie
    
@PieVisual
Scenario: TC_Pie_07: Verify maxmizing currency data conversion popup
    And Search for the series with SID "34709201;280072003"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    And Make the changes in the series harmonization popup
    Then The Window should be maximized
    
@PieVisual
Scenario: TC_Pie_08: Verify viewing fullscreen of data currency conversion popup
    And Search for the series with SID "34709201;280072003"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    And Make the changes in the series harmonization popup
    Then Verify viewing "Full-screen" of data currency conversion popup
    
@PieVisual
Scenario: TC_Pie_09: Verify viewing fullscreen of data currency conversion popup
    And Search for the series with SID "34709201;280072003"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    And Make the changes in the series harmonization popup
    Then Verify viewing "Exit full-screen" of data currency conversion popup
    
@PieVisual
Scenario: TC_Pie_10: Verify Closing data currency conversion popup
    And Search for the series with SID "34709201;280072003"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    And Make the changes in the series harmonization popup
    Then Verify viewing "Closing" of data currency conversion popup
    
@PieVisual
Scenario: TC_Pie_11: Verify default value for field Missing values method in frequency conversion popup window
    And Search for the series with SID "34709201;280072003"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then Verify default values of data currency conversion popup
    
@PieVisual
Scenario: TC_Pie_13: Verify functions applies in frequency conversion 
    And Search for the series with SID "365384367;239796903"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then Verify the function applied in frequency conversion popup
    
@PieVisual
Scenario: TC_Pie_14: Verify End dropdown for functions dropdown in frequency conversion popup
    And Search for the series with SID "365384367;239796903"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then The number of days should able to select in a functions End dropdown
    
@PieVisual
Scenario: TC_Pie_15: Verify series having negative timepoints in pie chart
    And Search for the series with SID "5190701"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then The message should appear
    
@PieVisual
Scenario: TC_Pie_16: Verify tooltip for different frequency series in pie
    And Search for the series with SID "365384367;239796903"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then Should be able to open frequency conversion popup with all the available options present
    
@PieVisual
Scenario: TC_Pie_17: Edit series - Verify Edit series option for Pie visual
    And Search for the series with SID "365384367;239796903"
    And Click on more actions
    And Choose "View as ..." > "Pie" 
    Then The Edit series panel should be opened with "Pie" tab