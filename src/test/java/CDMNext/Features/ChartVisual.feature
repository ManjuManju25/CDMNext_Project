Feature: Verifying Chart Visual Functionality

Background:
   Given User has successful logged in
   
@ChartVisual
Scenario: TC_Chart_01: Verify Chart option under Views > Visuals tab
    And Check for keeping_insight popup
    And Login as current execution login by taking username rowcount as 1 and cellcount as 0 and for password rowcount as 1 and cellcount as 1
    And Check for keeping_insight popup
    And Resetting the filters
    And Creating an Insight by selecting few series
    And Click to create an empty visual
    Then Should display "Chart" options on the right pane under "Views" > "Visuals" tab
    
@ChartVisual
Scenario: TC_Chart_02: Verify if chart is created for more than 20 series
    And Open preference dropdown
    And Clicking on "Show search results without pagination" option under user preference to be "Check" 
    And Open preference dropdown
    And Select 21 series for chart and click on chart option
    Then Validation message should appear and chart is created only with 20 series
    
@ChartVisual
Scenario: TC_Chart_03: Verify double click on Chart option
    And Click to create an empty visual
    And Hovor on Insert Chart
    And  "DoubleClick" the Insert option
    Then Chart visual should add to view area by "DoubleClick" 
    
@ChartVisual
Scenario: TC_Chart_04: Verify Drag and drop of Chart option
    And Click to create an empty visual
    And Hovor on Insert Chart
    And  "Drag and Drop" the Insert option
    Then Chart visual should add to view area by "DragandDrop" 
        
@ChartVisual
Scenario: TC_Chart_05: Verify Options for Chart Visual
    And Click to create an empty visual
    And Click on the Chart visual
    Then The Chart visual should get highlighted and options should appear at the top
    
@ChartVisual
Scenario: TC_Chart_06: Verify default title
    And Creating an Insight by selecting few series
    And Select 2 series and click on "Chart" option
    Then The Default title for Chart visual is "Chart" 
   
@ChartVisual
Scenario: TC_Chart_07: Verify if 'Default' format is retained for Chart option
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual
   And Select the style title as "Default" 
   And Check the style attribute title
   And Clicking "Save" option
   And Click on "Edit" visual
   Then  "Default" style is applied
    
@ChartVisual
Scenario: TC_Chart_08: Verify if 'Max-Min Observations' format is retained for Chart option
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual
   And Select the style title as "Max-Min Observations" 
   And Check the style attribute title
   And Clicking "Save" option
   And Click on "Edit" visual
   Then  "Max-Min Observations" style is applied
   
@ChartVisual
Scenario: TC_Chart_09: Verify if 'Clean' format is retained for Chart option
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual
   And Select the style title as "Clean" 
   And Check the style attribute title
   And Clicking "Save" option
   And Click on "Edit" visual
   Then  "Clean" style is applied
   
@ChartVisual
Scenario: TC_Chart_10: Verify if 'All values' format is retained for Chart option
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual
   And Select the style title as "All values" 
   And Check the style attribute title
   And Clicking "Save" option
   And Click on "Edit" visual
   Then  "All values" style is applied
   
@ChartVisual
Scenario: TC_Chart_11: Verify if 'Values and legend on top' format is retained for Chart option
   And Select few series
   And Open a "Chart" visual
   And Click on "Edit" visual
   And Select the style title as "Values and legend on top" 
   And Check the style attribute title
   And Clicking "Save" option
   And Click on "Edit" visual
   Then  "Values and legend on top" style is applied
   
@ChartVisual
Scenario: TC_Chart_12: Check default style applied for chart data
   And Search for the series with SID "398155157;398155397"
   And Click to create an empty visual
   And Perform DragDrop operation in "Line" Chart
   And Click on "Edit" visual
   Then Check the "Border:" attribute
   
@ChartVisual
Scenario: TC_Chart_13: Verify if the templates retain the custom settings upon logout
   And Search for the series with SID "305183101;305188001"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup
   And Click on "Edit" visual
   And Click on the "Border:" Container
   And  "Select" the "Chart" Checkbox  
   And Clicking "Save" option
   And  "Save" the new insight
   And Open preference dropdown
   And Click on "Sign out" from the application
   And Login to application
   And Click on "My insights" option from layout
   Then The border line is retained upon login for next time
   
@ChartVisual
Scenario: TC_Chart_14: Verify chart title display 'ON'
   And Search for the series with SID "63929901;63928901"
   And  Click on more actions to create "View as Chart" 
   And Close the popup
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Title:" Container
   And  "Select" the "Title" Checkbox  
   And Enter "Title" for chart visual as "Shravas" 
   And Clicking "Save" option
   And Refresh page
   And Click on "Continue" in Keep insight option
   Then Entered title appears in Views panel for title display "ON" 
   
@ChartVisual
Scenario: TC_Chart_15: Verify chart title display 'OFF'
   And Search for the series with SID "63929901;63928901"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup
   And Click on "Edit" visual
   And Click on the "Title:" Container
   And  "Unselect" the "Title" Checkbox  
   And Clicking "Save" option
   And Refresh page
   And Click on "Continue" in Keep insight option
   Then Entered title appears in Views panel for title display "OFF" 
   
@ChartVisual
Scenario: TC_Chart_16: Verify chart title value
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Title:" Container
   And  "Select" the "Title" Checkbox  
   And Enter "Title" for chart visual as "New chart" 
   And Clicking "Save" option
   Then The chart should update the title name to "New chart" 
   
@ChartVisual
Scenario: TC_Chart_17: Verify color - 'text and highlight'
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Double click on highcharts "title" 
   And Click "color" option from "title" popup 
   And Select "#2b60d0" color from list
   And Double click on highcharts "title" 
   And Click "highlight" option from "title" popup 
   And Select "#fda546" highlight color from list
   Then The chart should update the "Color" and "Highlight color" selected for "title" 
   
@ChartVisual
Scenario: TC_Chart_18: Verify chart title font size
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Double click on highcharts "title" 
   And Click "font_size" option from title popup 
   And Enter font size of 20 in the list for "title" 
   Then The chart should update the font size value to 20 for chart "title" 
   
@ChartVisual
Scenario: TC_Chart_19: Verify style - 'bold, italic, underline'
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Double click on highcharts "title" 
   And Select the "Style" for "title" 
   Then The chart should update the "Style" selected for "title" 
   
@ChartVisual123
Scenario: TC_Chart_20: Verify style - 'horizontal alignment' (left, right, center)
   And Search for the series with SID "181804102;116315408"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Double click on highcharts "title" 
   And Click on "left" alignment  
   And Capture Screenshot
   Then The chart should update the "left" alignment
   And Click on "center" alignment  
   And Capture Screenshot
   Then The chart should update the "center" alignment
   And Click on "right" alignment  
   And Capture Screenshot
   Then The chart should update the "right" alignment
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_21: Verify Chart subtitle display = 'YES'
   And Search for the series with SID "63929901;63928901"
   And  Click on more actions to create "View as Chart"
   And Click on Apply in Series Harmonization popup except for "63929901;63928901" 
   And Click on "Edit" visual
   And Click on the Visual "Title:" Container
   And Click on the "Sub title" checkbox to be "Checked" 
   And Clicking "Save" option
   Then The subtitle name "should" reflect on the chart
   
@ChartVisual
Scenario: TC_Chart_22: Verify Chart subtitle display = 'NO'
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart"
   And Click on "Edit" visual
   And Click on the Visual "Title:" Container
   And Click on the "Sub title" checkbox to be "UnChecked" 
   And Clicking "Save" option
   Then The subtitle name "should not" reflect on the chart
   
@ChartVisual
Scenario: TC_Chart_23: Verify Sub-title value
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart"
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the Visual "Title:" Container
   And Click on the "Sub title" checkbox to be "Checked" 
   And Enter "Sub title" for chart visual as "New Subtitle"
   And Clicking "Save" option
   Then The chart should update the subtitle name to "New Subtitle" 
   
@ChartVisual
Scenario: TC_Chart_24: Verify Sub-title Color - 'text and highlight'
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart"
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the Visual "Title:" Container
   And Click on the "Sub title" checkbox to be "Checked"
   And Clicking "Save" option
   And Double click on highcharts "sub_title" 
   And Click "color" option from "sub_title" popup
   And Select "#ff5b4d" color from list
   And Double click on highcharts "sub_title" 
   And Click "highlight" option from "sub_title" popup 
   And Select "#fda546" highlight color from list
   Then The chart should update the "Color" and "Highlight color" selected for "sub_title" 
  
@ChartVisual
Scenario: TC_Chart_25: Verify chart sub-title font size
   And Search for the series with SID "181804102;116315408"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the Visual "Title:" Container
   And Click on the "Sub title" checkbox to be "Checked"
   And Clicking "Save" option
   And Double click on highcharts "sub_title" 
   And Click "font_size" option from "sub_title" popup 
   And Enter font size of 10 in the list for "sub_title" 
   Then The chart should update the font size value to 10 for chart "sub_title" 
   
@ChartVisual
Scenario: TC_Chart_26: Verify style - 'bold, italic, underline'
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the Visual "Title:" Container
   And Click on the "Sub title" checkbox to be "Checked"
   And Clicking "Save" option
   And Double click on highcharts "sub_title" 
   And Select the "Style" for "sub_title" 
   Then The chart should update the "Style" selected for "sub_title" 
   
@ChartVisual
Scenario: TC_Chart_27: Verify visual area 'Horizontal alignment'(left, right, center)
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container
   And Click on "Chart position" option in Edit visual
   And Click on "Proportion:" option in Edit visual to 80
   And Click on Horizontal align of visual to "Left" 
   Then The Visual area should align to "Left" 
   And Click on Horizontal align of visual to "Center" 
   Then The Visual area should align to "Center"
   And Click on Horizontal align of visual to "Right" 
   Then The Visual area should align to "Right"
   And Click on "Proportion:" option in Edit visual to 100
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_30: Check for Image proportion percentage change horizontally
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container
   And Click on "Chart position" option in Edit visual
   And Click on "Proportion:" option in Edit visual to 80
   And Clicking "Save" option
   Then The Image Size should reduce to 80% horizontally
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container
   And Click on "Chart position" option in Edit visual
   And Click on "Proportion:" option in Edit visual to 100
   And Resetting back the width to original
   
#@ChartVisual
#Scenario: TC_Chart_32: Verify chart area background color
   #And Search for the series with SID "1355101;353749717"
   #And  Click on more actions to create "View as Chart" 
   #And Click on "Edit" visual
   #And Click on the Visual "Border:" Container
   #And Click on the "Chart" checkbox to be "Checked"
   #And Select any "color" for chart visual
   #And Select "#2b60d0" color from list
   #Then The color of background should be updated
   
@ChartVisualImage
Scenario: TC_Chart_33: Verify chart area background image
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the Visual "Background:" Container
   And Click on the "Chart" checkbox to be "Checked"
   And Select any "image" for chart visual
   And Clicking "Save" option
   Then The background image should be updated
   #And Click on the Visual "Background:" Container
   And Click on "Edit" visual
   And Click on the Visual "Background:" Container
   And Click on the "Chart" checkbox to be "Checked"
   And Removing the background image option
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_35: Verify chart area border color
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container for "Chart" 
   And Click on the "Chart" checkbox to be "Checked" 
   And Select any "color" for chart visual
   And Select "#2b60d0" color from list
   And Clicking "Save" option
   Then The color of border should be updated
   
@ChartVisual
Scenario: TC_Chart_36: Verify chart area border width
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container for "Chart" 
   And Click on the "Chart" checkbox to be "Checked" 
   And Click on "Chart width" option in Edit visual to 5
   And Clicking "Save" option
   Then The border "width" should be updated
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container for "Chart" 
   And Click on the "Chart" checkbox to be "Checked" 
   And Click on "Chart width" option in Edit visual to 1
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_37: Verify chart area border radius
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container for "Chart" 
   And Click on the "Chart" checkbox to be "Checked" 
   And Click on "Chart radius" option in Edit visual to 10
   And Clicking "Save" option
   Then The border "radius" should be updated
   And Click on "Edit" visual
   And Click on the Visual "Border:" Container for "Chart" 
   And Click on the "Chart" checkbox to be "Checked" 
   And Click on "Chart radius" option in Edit visual to 0
   And Resetting back the width to original
   
#@ChartVisual1
#Scenario: TC_Chart_38: Verify chart area border type
   #And Search for the series with SID "1355101;353749717"
   #And  Click on more actions to create "View as Chart" 
   #And Click on "Edit" visual
   #And Click on the Visual "Border:" Container 
   #And Click on "Chart position" option in Edit visual
   #And Click on the "Visual border" checkbox to "Check" 
   #And Select Visual "Border Type" from dropdown
   
@ChartVisualScreenshot
Scenario: TC_Chart_39: Verify different line charts
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Line" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Line" type
   And Click on the "Line" chart type
   And Select "Spline" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Spline" type
   And Click on the "Line" chart type
   And Select "Step line" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Step line" type
   And Click on the "Line" chart type
   And Select "Dotted line" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Dotted line" type
   And Resetting back the width to original
   
@ChartVisualScreenshot
Scenario: TC_Chart_40: Verify different column type charts
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Column" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Column" type
   And Click on the "Line" chart type
   And Select "Stacked column" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Stacked column" type
   And Resetting back the width to original
   
@ChartVisualScreenshot
Scenario: TC_Chart_41: Verify different Bar type charts
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Bar" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Bar" type
   And Click on the "Line" chart type
   And Select "Stacked bar" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Stacked bar" type
   And Resetting back the width to original
   
@ChartVisualScreenshot
Scenario: TC_Chart_42: Verify different Area type charts
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Area" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Area" type
   And Click on the "Line" chart type
   And Select "Stacked area" option from line chart 
   And Capture Screenshot
   Then The Chart should update the selected "Stacked area" type
   And Resetting back the width to original
   
@ChartVisual123
Scenario: TC_Chart_43: Check if the default axis is 'left'
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   
@ChartVisual
Scenario: TC_Chart_45_01: Verify reverse direction values on left axis
   And Search for the series with SID "51287302;383440717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Left Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Left Axis" 
   And Uncheck the checkbox for "Reversed direction" sections 
   And Observe the value order "before" selecting "Reversed direction" for "Left Axis" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Left Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Left Axis" 
   And Check the checkbox for "Reversed direction" sections 
   And Observe the value order "after" selecting "Reversed direction" for "Left Axis" 
   
@ChartVisual
Scenario: TC_Chart_45_02: Verify logarithmic values on left axis
   And Search for the series with SID "1355101;353749717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Left Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Left Axis" 
   And Uncheck the checkbox for "Logarithmic" sections 
   And Observe the value order "before" selecting "Logarithmic" for "Left Axis" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Left Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Left Axis" 
   And Check the checkbox for "Logarithmic" sections 
   And Observe the value order "after" selecting "Logarithmic" for "Left Axis" 

@ChartVisual
Scenario: TC_Chart_46_01: Verify reverse direction values on right axis
   And Search for the series with SID "51287302;383440717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Right Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Right Axis" 
   And Uncheck the checkbox for "Reversed direction" sections of Right Axis 
   And Observe the value order "before" selecting "Reversed direction" for "Right Axis" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Right Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Right Axis" 
   And Check the checkbox for "Reversed direction" sections of Right Axis 
   And Observe the value order "after" selecting "Reversed direction" for "Right Axis"  
   
@ChartVisual
Scenario: TC_Chart_46_02: Verify logarithmic values on right axis
   And Search for the series with SID "51287302;383440717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Right Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Right Axis" 
   And Uncheck the checkbox for "Logarithmic" sections 
   And Observe the value order "before" selecting "Logarithmic" for "Right Axis" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Right Axis" header
   And Expanding "Axis Setup" section from "Values Axis" popup of "Right Axis" 
   And Check the checkbox for "Logarithmic" sections of Right Axis
   And Observe the value order "after" selecting "Logarithmic" for "Right Axis" 
   
@ChartVisual
Scenario: TC_Chart_47: Verify title name, color, hightlight, size in left axis
   And Search for the series with SID "51287302;383440717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Left Axis" header
   And Expand "Title" section from "Values Axis" popup 
   And Check the checkbox for "Title" section 
   And Enter the text "Shravas" for axis title 
   And Select any "Axis Title Color" for chart visual
   And Select the "#2b60d0" y axis color from list
   And Select any "Axis Title Background Color" for chart visual
   And Select the "#fda546" y axis bgcolor from list
   And Select "Y axis font size" for chart visual to 18
   Then Verify the changes are reflecting in Chart visual for "Left Axis" 
   
@ChartVisual
Scenario: TC_Chart_48: Verify title name, color, hightlight, size in right axis
   And Search for the series with SID "51287302;383440717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Right Axis" header
   And Expanding "Title" section from "Values Axis" popup of "Right Axis"
   And Check the checkbox for "Title" section for Right axis
   And Enter the text "Shravas" for right axis title 
   And Select any "Axis Title Right Color" for chart visual
   And Select the "#2b60d0" y axis right color from list
   And Select any "Axis Title Right Background Color" for chart visual
   And Select the "#fda546" y axis right bgcolor from list
   And Select "Y axis Right font size" for chart visual to 18
   Then Verify the changes are reflecting in Chart visual for "Right Axis" 
   
@ChartVisual
Scenario: TC_Chart_49: Verify title style on left axis
   And Search for the series with SID "51287302;383440717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Left Axis" header
   And Expand "Title" section from "Values Axis" popup 
   And Check the checkbox for "Title" section 
   And Enter the text "Shravas" for axis title 
   And Select any "Y Axis Style" for chart visual
   Then Verify the Style is applied for "Left Axis" 
   
@ChartVisual
Scenario: TC_Chart_50: Verify title style on right axis
   And Search for the series with SID "51287302;383440717"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Activate the "Right Axis" header
   And Expanding "Title" section from "Values Axis" popup of "Right Axis"
   And Check the checkbox for "Title" section for Right axis
   And Enter the text "Shravas" for right axis title 
   And Select any "Y Axis Style Right" for chart visual
   Then Verify the Style is applied for "Right Axis" 
   
@ChartVisualScreenshot
Scenario: TC_Chart_51: Verify title alignment for x and y axis
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Title" section from "Values Axis" popup
   And Check the checkbox for "Title" section
   And Click on "low" align in Title section
   And Capture Screenshot
   Then The Title alignment for x and y axis is "low" 
   And Click on "middle" align in Title section
   And Capture Screenshot
   Then The Title alignment for x and y axis is "middle" 
   And Click on "high" align in Title section
   And Capture Screenshot
   Then The Title alignment for x and y axis is "high" 
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_52: Verify title axis intervals for 'x' and 'y' axis
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Title" section from "Values Axis" popup
   And Check the checkbox for "Title" section
   And Expand "Labels" section from "Values Axis" popup
   And Check the checkbox for "Labels" section
   And Expand "Interval" section from "Values Axis" popup
   And Enter Min/Max value between 300 to 400
   And Click on "Axis multiplier" option from Values Axis popup
   And Get the text of Axis multipler dropdown value
   Then Verify that Intervals should update as per inputs
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_53: Values labels color
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Labels" section from "Values Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Values Axis_Label Color" for chart visual
   And Select "#ff5b4d" color from list
   And Click on the "Values axis" checkbox to "Check" 
   #And Click on Labels checkbox
   And Expand "Labels" section from "Values Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Values Axis_Label Line Color" for chart visual
   And Select the "#2b60d0" color from list
   And Clicking "Save" option
   Then  "Color" and "Axis color" should reflect on the chart
   
@ChartVisual
Scenario: TC_Chart_54: Values labels size
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Labels" section from "Values Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Value_label_size" for chart visual
   And Clicking "Save" option
   Then The "Size" changes should reflect on the chart 
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_55: Values labels style
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Labels" section from "Values Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Value_label_style" for chart visual
   And Clicking "Save" option
   Then The Changes should update on the chart
   
@ChartVisual
Scenario: TC_Chart_56: Values labels rotation
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Labels" section from "Values Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Value_label_rotation" for chart visual
   And Clicking "Save" option
   Then The "rotation" changes should reflect on the chart
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Labels" section from "Values Axis" popup
   And Check the checkbox for "Labels" section
   And Revert the "Value_label_rotation" for chart visual to 0
   And Resetting back the width to original
   
@ChartVisual
Scenario Outline: TC_Chart_57: Values number format
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Number format" section from "Values Axis" popup
   And Click on "Number format" dropdown under "Values Axis" popup
   And Click on "Decimal places" in format and enter value as 3
   And Enter <decimal> and <grouping> separator for Value axis
   And Get Text on "Decimal places" in Chart visual
   And Get Value of "Decimal separator" in Preference
   And Get Value of "Grouping separator" in Preference
   And Get the updated Chart visual value
   Then  "Decimal places" , "Decimal Separator" , "Grouping Separator" values has been updated
Examples:
   | decimal |  grouping |
   | "," 		 | "," 			 |
   | "." 		 | "." 	     | 
   | ","     | "."			 |
   | ","     | "Space" 	 |
   | "," 		 | "'" 			 |
   | "," 		 | "-" 	     |
   | ","     | "None"		 |
   | "."     | ","			 |
   | "."     | "Space" 	 |
   | "." 		 | "'" 			 |
   | "." 		 | "-" 	     |
   | "."     | "None"		 |
   
@ChartVisual
Scenario: TC_Chart_58: Verify Values line - color
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Lines" section from "Values Axis" popup
   And Check the checkbox for "Lines" section
   And Select any "Values Axis Lines color" for chart visual
   And Select the "#2b60d0" value line color from list
   And Clicking "Save" option
   Then  "Value Axis color" should reflect on the chart
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Lines" section from "Values Axis" popup
   And Uncheck the checkbox for "Lines" section
   And Verify the "color" field is disabled
   
@ChartVisual
Scenario: TC_Chart_59: Verify Values line - width
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Lines" section from "Values Axis" popup
   And Check the checkbox for "Lines" section
   And Select "Values Axis Lines width" for chart visual to 3
   And Clicking "Save" option
   Then  "Values Axis Lines width" should reflect on the chart
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Lines" section from "Values Axis" popup
   And Select "Values Axis Lines width" for chart visual to 1
   And Uncheck the checkbox for "Lines" section
   And Verify the "width" field is disabled
   
@ChartVisual12
Scenario: TC_Chart_60: Values line - Opacity
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Values axis" checkbox to "Check" 
   And Expand "Lines" section from "Values Axis" popup
   And Check the checkbox for "Lines" section
   And Select "Values Axis Lines width" for chart visual to 3
   Then  "Values Axis Lines width" should reflect on the chart
   And Select "Values Axis Lines width" for chart visual to 1
   And Uncheck the checkbox for "Lines" section
   And Verify the "width" field is disabled
   
@ChartVisual
Scenario: TC_Chart_62: Verify Time - Title color
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Title" section from "Time Axis" popup
   And Check the checkbox for "Title" section
   And Select any "Time Axis Title Color" for chart visual
   And Select the "#2b60d0" title axis color from list
   And Select any "Time Axis Title Background Color" for chart visual
   And Select the "#fda546" title axis bgcolor from list
   And Clicking "Save" option
   Then  "Time Axis Title Color" should reflect on the chart
   
@ChartVisual
Scenario: TC_Chart_63: Verify Time - Title size
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Title" section from "Time Axis" popup
   And Check the checkbox for "Title" section
   And Click on "Title_value" option in Edit visual to 15
   And Clicking "Save" option
   Then  "Time Axis Title font size" should reflect on the chart visual
   
@ChartVisual
Scenario: TC_Chart_64: Verify Time - Title style
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Title" section from "Time Axis" popup
   And Check the checkbox for "Title" section
   And Select any "Time_axis_title_label_style" for chart visual
   And Clicking "Save" option
   Then  "Style" should reflect on the chart visual
   
@ChartVisual
Scenario: TC_Chart_66: Verify Time - Timeframe last x observations
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual  
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Timeframe" section from "Time Axis" popup
   And Check the timeframe checkbox for "Last observations" section
   And Set the Last observations start value to 0 
   And  "Incorrect Start Date" should display
   And Set the Last observations end value to 1001
   And  "Incorrect End Date" should display
   And Set the Last observations value to 18
   And Clicking "Save" option
   And  "Correct Observations" should displayed
   
@ChartVisual
Scenario: TC_Chart_67: Verify Time - Timeframe range
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual 
   And Get the series "First date" and "Last date" 
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Timeframe" section from "Time Axis" popup
   And Check the timeframe checkbox for "Within" section
   And Set the timeframe range as "2003/09/04" to "2014/10/21" 
   And Clicking "Save" option
   Then Entered timeframe date should update in chart
   
@ChartVisual
Scenario: TC_Chart_68: Verify Time - Timeframe All observations
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Get the series "First date" and "Last date" 
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Timeframe" section from "Time Axis" popup
   And Check the timeframe checkbox for "All observations" section
   And Clicking "Save" option
   Then Entered timeframe date should update in chart for "All observations" 
   
@ChartVisual
Scenario: TC_Chart_69: Verify Time - Axis setup
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Get the series "First date" and "Last date" 
   And Click on the "Time axis" checkbox to "Check" 
   And Check the checkbox for "Reversed direction" sections
   And Clicking "Save" option
   Then Entered timeframe date should update in chart for "Time Axis"
   
@ChartVisual
Scenario: TC_Chart_70: Verify Time- Labels color
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Labels" section from "Time Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Time Axis Title Label Color" for chart visual
   And Select the "#2b60d0" title label color from list
   And Select any "Time Axis Title Label Line Color" for chart visual
   And Select the "#fda546" title label line color from list
   And Clicking "Save" option
   Then  "Time Axis Label Color" should reflect on the chart
   
@ChartVisual
Scenario: TC_Chart_71: Verify Time- Labels size
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart"
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Labels" section from "Time Axis" popup
   And Check the checkbox for "Labels" section
   And Click on "Title_Label_value" option in Edit visual to 15
   And Clicking "Save" option
   Then  "Time Axis Title Label font size" should reflect on the chart visual
   
@ChartVisual
Scenario: TC_Chart_72: Verify Time- Labels style
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart"
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Labels" section from "Time Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Time Axis_label_style" for chart visual
   And Clicking "Save" option
   Then  "Time Axis Label Style" should reflect on the chart visual
   
@ChartVisual
Scenario: TC_Chart_73: Values time rotation
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Labels" section from "Time Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Time_Axis_label_rotation" for chart visual
   And Clicking "Save" option
   Then The "Time axis rotation" changes should reflect on the chart
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check"
   And Expand "Labels" section from "Time Axis" popup
   And Check the checkbox for "Labels" section
   And Revert the "Time_Axis_label_rotation" for chart visual to 0
   And Resetting back the width to original
   
@ChartVisual
Scenario: TC_Chart_74: Values time - Date format
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Date format" section from "Time Axis" popup
   And Click on the "Format" Container
   And Click on the "Custom" checkbox to "Check" 
   And Select any "Time_Axis_label_date_format" for chart visual
   And Clicking "Save" option
   Then The "Time axis Date format" changes should reflect on the chart
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Date format" section from "Time Axis" popup
   And Click on the "Format" Container
   And Click on the "Custom" checkbox to "Check" 
   And Select any "Time_Axis_label_date_format_changed" for chart visual
   And Clicking "Save" option
   Then The "Time axis Date format new" changes should reflect on the chart
   
@ChartVisual
Scenario: TC_Chart_75: Verify Time lines - color
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Lines" section from "Time Axis" popup
   And Check the checkbox for "Lines" section
   And Select any "Time Axis Lines color" for chart visual
   And Select the "#2b60d0" time line color from list
   And Clicking "Save" option
   Then  "Time Axis color" should reflect on the chart
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check"  
   And Expand "Lines" section from "Time Axis" popup
   And Uncheck the checkbox for "Lines" section
   And Verify the "color" field is disabled
   
@ChartVisual
Scenario: TC_Chart_76: Verify Time lines - Width
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart"  
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Lines" section from "Time Axis" popup
   And Check the checkbox for "Lines" section
   And Select "Time Axis Lines width" for chart visual to 3
   And Clicking "Save" option
   Then  "Time Axis Lines width" should reflect on the chart
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Lines" section from "Time Axis" popup
   And Select "Time Axis Lines width" for chart visual to 1
   And Uncheck the checkbox for "Lines" section
   And Verify the "width" field is disabled
   
@ChartVisual
Scenario: TC_Chart_79: Verify Inverting of chart
   And Search for the series with SID "360937287"
   And  Click on more actions to create "View as Chart"  
   And Fetch the color of axis line right "Before" Invert
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Labels" section from "Time Axis" popup
   And Check the checkbox for "Labels" section
   And Select any "Time Axis Title Label Line Color" for chart visual
   And Select the "#792d82" label line color from list
   And  "Select" the "Invert" Checkbox  
   And Clicking "Save" option
   And Fetch the color of axis line right "After" Invert
   And Checking the chart "Inversion" 
   And Click on "Edit" visual
   And  "Unselect" the "Invert" Checkbox
   And Clicking "Save" option
   Then Checking the chart "Original View" 
   
@ChartVisual
Scenario: TC_Chart_80: Verify Tooltips - Show
   #And Search for the series with SID "299442804"
   And Search for the series with SID "384226487"  
   And  Click on more actions to create "View as Chart"  
   And Click on "Edit" visual
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Click on the "Show tooltips" checkbox to "Check" 
   And Clicking "Save" option
   Then Tooltips "Should" be visible in dashboard page
   And Click on "Edit" visual
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Click on the "Show tooltips" checkbox to "UnChecked Checkbox" 
   And Clicking "Save" option
   Then Tooltips "Should not" be visible in dashboard page
   
@ChartVisual
Scenario: TC_Chart_81: Verify Tooltips - Display for all series at once
   And Search for the series with SID "68941402;68945002" 
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Click on the "Display for all series at once" checkbox to "Check" 
   And Clicking "Save" option
   Then Tooltips for multiple series "Should" be visible in dashboard page
   And Click on "Edit" visual
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Click on the "Display for all series at once" checkbox to "UnChecked Checkbox" 
   And Clicking "Save" option
   Then Tooltips for multiple series "Should not" be visible in dashboard page
   
@ChartVisual
Scenario: TC_Chart_82: Verify Tooltips - Items
   And Search for the series with SID "299442804" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Get the "Name" for the series
   And Get the "Region" region for the series
   And Get the "Frequency" frequency for the series
   And Get the "Unit" unit for the series
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Expand "Items" section from "Tooltip" popup
   And Click on "Add" Attribute button to add attributes
   And Clicking "Save" option
   Then Selected "Item" should display
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Items" section from "Tooltip" popup
   And Click on "Remove" Attribute button to add attributes
   And Clicking "Save" option
   And Closing the chart visual
   
@ChartVisual
Scenario: TC_Chart_83: Verify Tooltips - color
   And Search for the series with SID "299442804" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Expand "Items" section from "Tooltip" popup
   And Enter "color" for Tooltip
   And Select the "#2b60d0" Tooltip color from list
   And Clicking "Save" option
   Then Selected "Color" should display
   
@ChartVisual
Scenario: TC_Chart_84: Verify Tooltips - size
   And Search for the series with SID "299442804" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Expand "Items" section from "Tooltip" popup
   And Enter font size of 15 in the list for "tooltip" 
   And Clicking "Save" option
   Then Selected "Font size" should display
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Items" section from "Tooltip" popup
   And Enter font size of 12 in the list for "tooltip" 
   And Clicking "Save" option
   And Closing the chart visual
   
@ChartVisual
Scenario: TC_Chart_85: Verify Tooltips - style
   And Search for the series with SID "299442804" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" checkbox to "Check" 
   And Click on the "Tooltips:" Container
   And Expand "Items" section from "Tooltip" popup
   And Select any "Timepoints Style" for chart visual
   And Clicking "Save" option
   Then Selected "Font Style" should display
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Items" section from "Tooltip" popup
   And Revert the "Timepoints Style" for chart visual
   And Clicking "Save" option
   And Closing the chart visual
   
@ChartVisual
Scenario: TC_Chart_86: Verify Tooltips - Read tooltips data from Excel (Negative timepoints)
   And Check for keeping_insight popup
   And Resetting the filters
   And Setting values in preference
   And Read the "Timepoints" and "Date" from excel file "TC_Chart86.xlsx" 
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Timeframe" section from "Time Axis" popup
   And Check the timeframe checkbox for "All observations" section
   And Clicking "Save" option
   Then Excel data is compared with application data
  
@ChartVisual
Scenario: TC_Chart_87: Verify Tooltips - Read tooltips data from Excel (Positive timepoints)
   And Refresh page
   And Check for keeping_insight popup
   And Read the "Timepoints" and "Date" from excel file "TC_Chart_87.xlsx" 
   And Search for the series with SID "369035327" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Timeframe" section from "Time Axis" popup
   And Check the timeframe checkbox for "All observations" section
   And Clicking "Save" option
   Then Excel data is compared with application data
   
@ChartVisual
Scenario: TC_Chart_88: Verify Tooltips - Get timepoint values from application (negative timepoints)
   And Refresh page
   And Check for keeping_insight popup
   And Open SSP for the series "357534787" 
   And Click on "Data" tab
   And Observe the entire list of "Timepoints" 
   And Observe the entire list of "Date" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Timeframe" section from "Time Axis" popup
   And Check the timeframe checkbox for "All observations" section
   And Clicking "Save" option
   Then The SSP timepoints inside series are compared with timepoints reflecting in visual
   And Resetting the filters
   
@ChartVisual
Scenario: TC_Chart_89: Verify Tooltips - Get timepoint values from application (positive timepoints)
   And Refresh page
   And Check for keeping_insight popup
   And Open SSP for the series "369035327" 
   And Click on "Data" tab
   And Observe the entire list of "Timepoints" 
   And Observe the entire list of "Date" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Time axis" checkbox to "Check" 
   And Expand "Timeframe" section from "Time Axis" popup
   And Check the timeframe checkbox for "All observations" section
   And Clicking "Save" option
   Then The SSP timepoints inside series are compared with timepoints reflecting in visual
   And Refresh page
   #And Check for keeping_insight popup
   And Check for keeping_insight popup
   And Resetting the filters
   
@ChartVisual
Scenario Outline: TC_Chart_90: Verify Tooltips - number format
   And Resetting the filters
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Number format" section from "Tooltip" popup
   And Select <number> and <decimal> separator from dropdown
   Then The Selected "Number seperator" and "Decimal seperator" should update with selected input
   
   Examples:
   |number   |decimal    |
   | "."     | "."			 |
   | "Space" | "." 			 |
   | "'" 		 | "." 			 |
   | "-" 		 | "." 			 |
   | "None"  | "."			 |
   | "," 		 | ","			 |
   | "." 		 | ","			 |
   | "Space" | ","			 |
   | "'"  	 | ","			 |
   | "-" 		 | ","			 |
   | "None"  | ","  		 |
   | "," 		 | "."			 |
   
@ChartVisual
Scenario: TC_Chart_91: Verify Tooltips - date format
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Number format" section from "Tooltip" popup
   And Select "4" separator from "Decimal places" dropdown
   And Clicking "Save" option
   Then The Selected "Decimal Places" should update with selected input
   
@ChartVisual
Scenario: TC_Chart_92: Verify Tooltips - border color
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Border" section from "Tooltip" popup
   And Check the checkbox for "Border" section
   And Select any "Tooltip Border Color" for chart visual
   And Select the "#fda546" tooltip border color from list
   And Clicking "Save" option
   Then The Selected "Tooltip Border Color" should update with selected input
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Border" section from "Tooltip" popup
   And Uncheck the checkbox for "Border" section
   And Verify the "Tooltip border color" field is disabled
   
@ChartVisual
Scenario: TC_Chart_93: Verify Tooltips - border width
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Border" section from "Tooltip" popup
   And Check the checkbox for "Border" section
   And Select "Tooltip Border Width" for chart visual to 3
   And Clicking "Save" option
   Then The Selected "Tooltip Border Width" should update with selected input
   And Click on "Edit" visual
   And Click on the "Tooltips:" Container
   And Expand "Border" section from "Tooltip" popup
   And Select "Tooltip Border Width" for chart visual to 1
   And Uncheck the checkbox for "Border" section
   And Verify the "Tooltip border width" field is disabled
   
@ChartVisual
Scenario: TC_Chart_96: Verify Labels - color
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Data labels:" checkbox to "Check" 
   And Click on the "Data labels:" Container
   And Expand "Labels" section from "Labels" popup
   And Click on the "Labels" checkbox to "Check" 
   And Select data label "color" from the list
   And Select the "#2b60d0" data label color from list
   And Select data label "highlight" from the list
   And Select the "#fda546" data label highlight color from list
   And Clicking "Save" option
   Then The Selected "Color and Highlight color" should update with selected input
   
@ChartVisual
Scenario: TC_Chart_97: Verify Labels - size
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Data labels:" checkbox to "Check" 
   And Click on the "Data labels:" Container
   And Expand "Labels" section from "Labels" popup
   And Click on the "Labels" checkbox to "Check" 
   And Select "Data Labels font size" for chart visual to 18
   And Clicking "Save" option
   Then The Selected "Font size" should update with selected input
   And Click on "Edit" visual
   And Click on the "Data labels:" checkbox to "Check" 
   And Click on the "Data labels:" Container
   And Expand "Labels" section from "Labels" popup
   And Click on the "Labels" checkbox to "Check" 
   And Select "Data Labels font size" for chart visual to 10
   And Clicking "Save" option
   And Closing the chart visual
   
@ChartVisual
Scenario: TC_Chart_98: Verify Labels - style
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Data labels:" checkbox to "Check" 
   And Click on the "Data labels:" Container
   And Expand "Labels" section from "Labels" popup
   And Click on the "Labels" checkbox to "Check" 
   And Select any "Data Labels Style" for chart visual
   And Clicking "Save" option
   Then The Selected "Font Style" should update with selected input
   
@ChartVisual
Scenario Outline: TC_Chart_99: Verify Labels - Number seperator and decimal value
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Data labels:" checkbox to "Check" 
   And Click on the "Data labels:" Container
   And Expand "Format" section from "Labels" popup
   And Select any "Data Labels Format" for chart visual
   And Select <decimal> and <group> separator from dropdown list
   Then The Selected "Decimal seperator" and "Grouping seperator" should update with selected input
   Examples:
   | decimal | group   |
   | "," 		 | "." 	   |
   | ","		 | "Space" |
   | ","		 | "'"     |
   | ","		 | "-"		 |
   | ","		 | "None"	 |
   | "."		 | ","     |
   | "."		 | "Space" |
   | "."		 | "'"     |
   | "."		 | "-"		 |
   | "."		 | "None"	 |
      
@ChartVisual
Scenario: TC_Chart_100: Verify Labels - Decimal places
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Data labels:" checkbox to "Check" 
   And Click on the "Data labels:" Container
   And Expand "Format" section from "Labels" popup
   And Select any "Data Labels Format" for chart visual
   And Set the Data format "-1" as decimal start value 
   And  "Incorrect Start" Decimal places should display
   And Set the Data format decimal end value to 9
   And  "Incorrect End" Decimal places should display
   And Resetting back the width to original
   
@ChartVisual
Scenario Outline: TC_Chart_101: Verify Labels - Point markers and radius
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Data labels:" checkbox to "Check" 
   And Click on the "Data labels:" Container
   And Expand "Point markers" section from "Labels" popup
   And Check the checkbox for "Point markers" section
   And Select <data_label> data label of "Point markers" 
   Then The selected "Point marker" value should reflect in chart
   Examples:
   | data_label |
   | "Auto"			|
   | "Circle"   |
   | "Square"   |
   | "Diamond"  |
   | "Triangle" |
   | "Triangle down" |
   
@ChartVisual
Scenario Outline: TC_Chart_102: Verify Legend
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And Expand <Legend_expand> from "Legend" popup
   And Collapse <Legend_collapse> from "Legend" popup
   Examples:
   | Legend_expand| Legend_collapse |
   | "Common" 		| "Common"        |
   | "Items" 			| "Items" 			  |
   | "Size"   		| "Size"          |
   | "Title"  		| "Title" 				|
   | "Background" | "Background"    |
   | "Border"     | "Border"        |
   
@ChartVisual
Scenario: TC_Chart_103: Verify Legend - Common section
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Common" section from Legand popup should expand
   Then  "Show legend" and "Float on plot area" is displayed and by default Show Legend is checked
   
@ChartVisual
Scenario: TC_Chart_104: Verify Legend - Show Legend option
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Common" section from Legand popup should expand
   And  "Show legend" checkbox is clicked
   Then  "Legend" is displayed at bottom of the chart
   
@ChartVisual123
Scenario: TC_Chart_105: Verify Legend - Float on plot area option
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Common" section from Legand popup should expand
   And  "Float on plot area" checkbox is clicked
   Then  "Legend" is displayed at bottom of the chart

@ChartVisual
Scenario: TC_Chart_106: Verify Legend - Color axes section
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Items" section from Legand popup should expand
   And Select any "legend_item_color" for chart visual
   And Select "#2b60d0" legend color from list
   And Clicking "Save" option
   Then The Selected "Color" should reflect in the chart visual legand
   
@ChartVisual
Scenario: TC_Chart_114: Verify Legend - Title
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Title" section from Legand popup should expand
   And Check the checkbox for "Title" section
   And Enter the text "Shravas" for legend title 
   And Clicking "Save" option
   Then The Selected "Title" should reflect in the chart visual legand
   
@ChartVisual
Scenario: TC_Chart_115: Verify Legend - Font size
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Title" section from Legand popup should expand
   And Check the checkbox for "Title" section
   And Enter the text "Shravas" for legend title 
   And Select "Legend Title font size" for chart visual to 16
   Then The Selected "Font size" should reflect in the chart visual legand
   And Uncheck the checkbox for "Title" section
   And Verify the "Legend Title" field is disabled
   
@ChartVisual
Scenario: TC_Chart_116: Verify Legend - Font style
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Title" section from Legand popup should expand
   And Check the checkbox for "Title" section
   And Enter the text "Shravas" for legend title 
   And Select any "Legends Style" for chart visual
   Then The Selected "Font style" should reflect in the chart visual legand
   And Uncheck the checkbox for "Title" section
   And Verify the "Legend Title" field is disabled
   
@ChartVisual
Scenario: TC_Chart_118: Verify Legend - Background color
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Background" section from Legand popup should expand
   And Check the checkbox for "Background" section
   And Select any "legend_background_color" for chart visual
   And Select "#2b60d0" legend bgcolor from list 
   Then The Selected "Background color" should reflect in the chart visual legand
   And Uncheck the checkbox for "Background" section
   And Verify the "Legend Background" field is disabled
  
@ChartVisual
Scenario: TC_Chart_119: Verify Legend - Border color
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Border" section from Legand popup should expand
   And Check the checkbox for "Border" section
   And Select any "legend_border_color" for chart visual
   And Select "#2b60d0" legend border color from list 
   Then The Selected "Border color" should reflect in the chart visual legand
   And Uncheck the checkbox for "Border" section
   And Verify the "Legend Border Color" field is disabled 
  
@ChartVisual
Scenario: TC_Chart_120: Verify Legend - Border width
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Border" section from Legand popup should expand
   And Check the checkbox for "Border" section
   And Select "Legend Title Border Width" for chart visual to 3 
   Then The Selected "Border width" should reflect in the chart visual legand
   And Uncheck the checkbox for "Border" section
   And Verify the "Legend Border Width" field is disabled 
   
@ChartVisual
Scenario: TC_Chart_121: Verify Legend - Border radius
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Legend:" checkbox to "Check" 
   And Click on the "Legend:" Container
   And  "Legend" popup should appeared
   And  "Border" section from Legand popup should expand
   And Check the checkbox for "Border" section
   And Select "Legend Title Border Radius" for chart visual to 8 
   Then The Selected "Border radius" should reflect in the chart visual legand
   And Select "Legend Title Border Radius" for chart visual to 0 
   And Uncheck the checkbox for "Border" section
   And Verify the "Legend Border Radius" field is disabled 
   
@ChartVisual
Scenario: TC_Chart_123: Verify Source Copyright
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And  "Copyright" popup should appeared
   Then The title of the popup should be "Copyright" 
   
@ChartVisual
Scenario: TC_Chart_124: Verify Source Copyright title checkbox
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Text" checkbox in copyright
   And  "Copyright" popup should appeared
   And Enter the text "Shravas Technologies" for Copyright title
   Then The Selected "Copyright" should reflect in the chart visual legand
   And Uncheck the checkbox for "Show copyright" section
   And Verify the "Copyright Text" field is disabled
   
@ChartVisual
Scenario: TC_Chart_125: Verify Source Copyright title text link
   And Check for keeping_insight popup
   And Disable the Chat bubble
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Text" checkbox in copyright
   And  "Copyright" popup should appeared
   And Enter the text "https://shravas.com/" for Copyright title link
   Then The Selected "Copyright link" should reflect in the chart visual legand
   And Uncheck the checkbox for "Show copyright" section
   And Verify the "Copyright Text link" field is disabled
   
@ChartVisual
Scenario: TC_Chart_127: Verify Copyright - Font size
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Text" checkbox in copyright
   And  "Copyright" popup should appeared
   And Select "Copyright font size" for chart visual to 16
   Then The Selected "Copyright font size" should reflect in the chart visual legand
   And Uncheck the checkbox for "Show copyright" section
   And Verify the "Copyright font size" field is disabled  
   
@ChartVisual
Scenario: TC_Chart_128: Verify Copyright - Font style
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Text" checkbox in copyright
   And  "Copyright" popup should appeared
   And Select any "Copyright Style" for chart visual
   Then The Selected "Copyright font style" should reflect in the chart visual legand
   And Uncheck the checkbox for "Show copyright" section
   And Verify the "Copyright font style" field is disabled
   
@ChartVisual
Scenario: TC_Chart_129: Verify Copyright - Text color
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Text" checkbox in copyright
   And  "Copyright" popup should appeared
   And Select any "copyright_color" for chart visual
   And Select "#2b60d0" copyright color from list 
   Then The Selected "Copyright color" should reflect in the chart visual legand
   And Uncheck the checkbox for "Show copyright" section
   And Verify the "Copyright color" field is disabled
   
@ChartVisual
Scenario: TC_Chart_129_1: Verify Copyright - Image
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Image" checkbox in copyright
   And  "Copyright" popup should appeared
   Then The Selected "Copyright Image" should reflect in the chart visual legand
   
@ChartVisual
Scenario: TC_Chart_129_2: Verify Source Copyright Image text link
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Image" checkbox in copyright
   And  "Copyright" popup should appeared
   And Enter the text "https://shravas.com/" for Copyright title link
   Then The Selected "Copyright Image link" should reflect in the chart visual legand
   And Uncheck the checkbox for "Show copyright" section
   And Verify the "Copyright Text link" field is disabled
   
@ChartVisual
Scenario Outline: <TC_ID>: Verify Source Copyright Image position
  And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Image" checkbox in copyright
   And  "Copyright" popup should appeared
   And Select the <data_value> position
   Then The Selected data_value should reflect in the chart visual legand
   And Uncheck the checkbox for "Show copyright" section
   And Verify the "Copyright align" field is disabled
Examples:
     |         TC_ID         | data_value |
     |     TC_Chart_129_2    |   "left"   |
     |     TC_Chart_129_3    |   "center" |
     |     TC_Chart_129_4    |   "right"  |
     
@ChartVisual
Scenario: TC_Chart_129_5: Verify Source Copyright Image
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the "Copyright:" checkbox to "Check" 
   And Click on the "Copyright:" Container
   And Click on the "Image" checkbox in copyright
   And  "Copyright" popup should appeared
   And Click on upload Image button
   Then The Uploaded image should reflect in the chart visual legand
   And Enable the Chat bubble
   
@ChartVisual
Scenario: TC_Chart_130: Verify Show controls of Zoom - Check/Uncheck
   And Check for keeping_insight popup
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Check the "Zoom" checkbox by default
   And Check the Zoom checkbox in Visual
   And Click on "Edit" visual
   Then Uncheck the "Zoom" checkbox in Visual and verify the results
  
@ChartVisual
Scenario: TC_Chart_131: Verify Service
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Right Click the "Chart" visual
   And  Click on "View as" to check the type of visual
   Then 5 type of visuals should present
   
@ChartVisual
Scenario: TC_Chart_132: Verify Converting to Map option
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Right Click the "Chart" visual
   And Click on "View as" to check the type of visual
   And Click on "map" visual from the list
   Then Verify the top panel should change to "Edit Map" 
   
@ChartVisual
Scenario: TC_Chart_133: Verify Converting to Table option
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Right Click the "Chart" visual
   And Click on "View as" to check the type of visual
   And Click on "table" visual from the list
   Then Verify the top panel should change to "Edit Table" 
   
@ChartVisual
Scenario: TC_Chart_134: Verify Edit Series option
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Get the series title
   And Click on "Edit Series" Visual option
   And Get the text of Edit series option
   Then Verify texts
   
@ChartVisual
Scenario: TC_Chart_135: Verify Related Series option
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Click on "Add related series" Visual option
   Then  "Add related series" popup shoud display
   
@ChartVisual
Scenario: TC_Chart_137: Verify Chart visual options
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   Then  "Add to insight" , "Copy", "Download" , "Open" , "Delete" icons should appear
   
@ChartVisual
Scenario: TC_Chart_138: Verify Add to insight options
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Count the list of views "Before" clicking the New option
   And Copy the insight title
   And Click on "Add to insight" option from Visual
   And Click on "Add" option from Visual
   And Count the list of views "After" clicking the New option
   Then Verify the Changes on clicking New button
   And Click on "Add to insight" option from Visual
   And Click on "Add to new insight" option from Visual
   Then Clicking on the insight name should open the insight with the series
   
@ChartVisual
Scenario: TC_Chart_139: Verify Copy icon
   And Select few series
   And Open a "Chart" visual
   And Click on "Copy" option from Visual
   And Growl popup is displaying
   And Copy the data after clicking Copy button
   And Write the copied data into a text file
   Then Verify the contents in text file
   
@ChartVisual
Scenario: TC_Chart_140: Verify Copy to excel icon
   And Select few series
   And Open a "Chart" visual
   And Click on "Download. Type `d`" option from Visual
   And Click on "Copy to Clipboard" option inside visual
   And Growl popup is displaying
   And Copy the data after clicking Copy button
   And Write the copied data into a text file
   Then Verify the contents in text file
   
@ChartVisual
Scenario: TC_Chart_141: Verify Download icon
   And Select few series
   And Open a "Chart" visual
   And Click on "Download. Type `d`" option from Visual
   Then Verify the download popup appears and the title should be "Download:" 

@ChartVisual
Scenario: TC_Chart_142: Verify Open icon
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Copy the insight title
   And Click on "Delete" option from Visual
   Then Check for the movable popup to appear
      
@ChartVisual
Scenario: TC_Chart_143: Verify Delete icon
   And Resetting the filters
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Copy the insight title
   And Click on "Delete" option from Visual
   And Click on confirmation popup
   Then The "Chart" visual has been deleted from the right panel
   
@ChartVisual
Scenario: TC_Chart_146: Chart context menu
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Right Click the "Chart" visual
   And Get the text of options available
   And Get the text of sub dropdowns available
   Then The text and sub text options are present in context click
   
@ChartVisual
Scenario: TC_Chart_147: Verify Insert visual - context menu
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Right Click the "Chart" visual
   And Get the text of options available
   And Get the text of sub dropdowns available
   Then The "Insert visual" options have been verified
   
@ChartVisual
Scenario: TC_Chart_148: Verify View as - context menu
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart"
   And Right Click the "Chart" visual
   And Get the text of options available
   And Get the text of sub dropdowns available
   Then The "View as" options have been verified
   
@ChartVisual
Scenario: TC_Chart_149: Verify Edit series - context menu
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Right Click the "Chart" visual
   And Click on "Edit series" inside the visual
   Then The "Edit series" options have been verified
   
@ChartVisual
Scenario: TC_Chart_150: Verify Clear contents - context menu
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Right Click the "Chart" visual
   And Click on "Edit series" inside the visual
   And Click on "Add more from My Series" option in the visual
   And Right Click the "Chart" visual
   And Click on "Clear contents" inside the visual
   Then The "Clear contents" options have been verified
 
@ChartVisual
Scenario: TC_Chart_154: Verify Undo-Redo
   And Search for the series with SID "357534787" 
   And  Click on more actions to create "View as Chart" 
   And Copy the insight title
   And Double click on highcharts "title" 
   And Enter "Title" for chart visual as "Shravas" 
   And Closing the popup
   And Perform "Undo" Operation
   Then The Action is performed on doing "Undo" operation
   And Perform "Redo" Operation
   Then The Action is performed on doing "Redo" operation
   
@ChartVisual
Scenario: TC_Chart_155: Verify per series chart type - Column
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Column" option from line chart
   And Clicking "Save" option
   Then The chart is changed to "column" type 
   
@ChartVisual
Scenario: TC_Chart_156: Verify per series chart type - Area
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Area" option from line chart
   And Clicking "Save" option
   Then The chart is changed to "area" type
   
@ChartVisual
Scenario: TC_Chart_157: Verify per series chart type - Bar
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Bar" option from line chart
   And Clicking "Save" option
   Then The chart is changed to "bar" type
   
@ChartVisual
Scenario: TC_Chart_158: Verify per series chart type - Line
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Line" option from line chart
   And Clicking "Save" option
   Then The chart is changed to "line" type
   
@ChartVisual
Scenario: TC_Chart_159: Verify per series chart type - Default
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Default" option from line chart
   And Clicking "Save" option
   Then The chart is changed to "line" type
   
@ChartVisual
Scenario: TC_Chart_160: Verify per series chart type - style color
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Line" option from line chart
   And Click on the "Color" option
   And Select "#a7a5a3" color from list
   And Clicking "Save" option
   Then The Series is changed to the "Color" specified
   
@ChartVisual
Scenario: TC_Chart_161: Verify per series chart type - style size
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Click on the "Line" chart type
   And Select "Line" option from line chart
   And Click on the "Change the chart stroke" option
   And Select "Series stroke size" for chart visual to 4
   And Clicking "Save" option
   Then The Series is changed to the "Stroke Width" specified
   
@ChartVisual
Scenario: TC_Chart_162: Verify per series style type
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Click on "Edit" visual
   And Hovor on to i icon without click
   And Click on the "Move to right" option
   And Clicking "Save" option
   Then The Series is changed to the "Move to right" specified
   
@ChartVisual
Scenario: TC_Chart_164: Verify delete series option
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801" 
   And Count the number of series before delete
   And Click on "Edit" visual
   And Click on the "Delete series" option for delete
   And Clicking "Save" option
   Then The Series is changed to the "Deleted" specified
   
@ChartVisual
Scenario: TC_Chart_165: Verify percentage change over a year function to single series in chart visual
   And Search for the series with SID "377148287" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click the Functions input box
   And Enter the function
   And Click on "Apply function" in functions box
   And Clicking "Save" option
   And Copy the insight title
   And Clicking Download button from "Page Header" 
   And Verify the functions appeared in excel
   
@ChartVisual
Scenario: TC_Chart_166: Verify difference over a year function to single series in chart visual
   And Search for the series with SID "236248103" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click the Functions input box
   And Enter the function
   And Click on "Apply function" in functions box
   And Clicking "Save" option
   And Copy the insight title
   And Clicking Download button from "Page Header" 
   And Verify the functions appeared in excel
   
@ChartVisual
Scenario: TC_Chart_167: Verify difference over a year function to single series in chart visual
   And Search for the series with SID "235955202" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click on the Currency button
   And Enter the Currency as "USD" 
   And Click on Currency in functions box
   And Clicking "Save" option
   And Copy the insight title
   And Clicking Download button from "Page Header" 
   And Verify the functions appeared in excel
   
@ChartVisual
Scenario: TC_Chart_168: Verify Aggregate(Sum) function to single series in chart visual.
   And Search for the series with SID "389772587" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click the Functions input box
   And Enter the function in function field
   And Click on "Apply function" in functions box
   And Clicking "Save" option
   And Copy the insight title
   And Clicking Download button from "Page Header"
   And Verify the functions appeared in excel
   
@ChartVisual
Scenario: TC_Chart_169: Verify Disaggregate(Distribute) function to single series in chart visual
   And Search for the series with SID "389772587" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click the Functions input box
   And Enter the function in function fields
   And Click on "Apply function" in functions box
   And Clicking "Save" option
   And Copy the insight title
   And Clicking Download button from "Page Header"
   And Verify the functions appeared in excel
   
@ChartVisual
Scenario: TC_Chart_170: Verify Fill gaps(Previous values) function to single series in chart visual
   And Search for the series with SID "235955202" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click the Functions input box
   And Enter function in function fields of Chart 
   And Click on "Apply function" in functions box
   And Clicking "Save" option
   And Copy the insight title
   And Clicking Download button from "Page Header"
   And Verify the functions appeared in excel
   
@ChartVisual
Scenario: TC_Chart_171: Verify Smoothing-Single function to single series in chart visual.
   And Search for the series with SID "235955202" 
   And  Click on more actions to create "View as Chart" 
   And Click on "Edit" visual
   And Click the Functions input box
   And Enter the function in function fields of Chart 
   And Click on "Apply function" in functions box
   And Clicking "Save" option
   And Copy the insight title
   And Clicking Download button from "Page Header"
   And Verify the functions appeared in excel
   
@ChartVisual
Scenario: TC_Chart_173: Verify unselect all option to clear all series in chart visual.
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801"
   And Click on Edit series visual
   And Click on Add from My Series visual
   And Click on More actions button in myseries
   And Click on Unselect all button in myseries
   Then The "Unselect" action is performed successfully
    
@ChartVisual
Scenario: TC_Chart_174: Verify copy and insert copy options in chart visual
   And Add few series to myseries
   And Count the series in myseries
   And Highlight any one series
   And Click on More actions button in myseries
   And Click on "Copy" button in myseries
   And Highlight any one series
   And Click on More actions button in myseries
   And Click on "Insert Copied" button in myseries
   Then The "Copy and Paste" action is performed successfully
   
@ChartVisual
Scenario: TC_Chart_175: Verify for the copy to excel in chart visual
   And Add few series to myseries
   And Copy the myseries title
   And Highlight any one series
   And Click on More actions button in myseries
   And Click on "Copy" button in myseries
   And Verify the Copied message from myseries
   And Copy the data after clicking Copy button
   Then The "Copy and Paste into Excel" action is performed successfully
  
@ChartVisual
Scenario: TC_Chart_176: Verify for series deletion from chart visual
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801"
   And Click on Edit series visual
   And Click on Add from My Series visual
   And Click on More actions button in myseries
   And Click on Delete button in myseries
   Then The "Delete" action is performed successfully
   
@ChartVisual
Scenario: TC_Chart_177: Check for renaming single series in chart visual
   And Add few series to myseries
   And  Click on more actions to create "View as Chart" 
   And Click on Edit series visual
   And Hover over to "Delete series" Option
   And Click on "Rename series" button in myseries
   And Enter the Series name as "Shravas" 
   Then The "Rename" action is performed successfully
   
@ChartVisual
Scenario: TC_Chart_178: Check for preview of multiple series in chart visual
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Click on Apply in Series Harmonization popup except for "9380901;9380801"
   And Click on Edit series visual
   And Click the Functions input box
   And Enter the function in function field
   And Click on "Apply function" in functions box
   And Click on Add from My Series visual
   And Click on More actions button in myseries
   And Click on "Preview" button in myseries
   Then The "Preview" action is performed successfully
   
@ChartVisual
Scenario: TC_Chart_179: Verify view as chart from selection context menu
   And Add few series to myseries
   And Highlight any one series
   And Click on More actions button in myseries
   And Click on "View as Chart" button in myseries
   Then Verify the top panel should change to "Edit Chart" 
   
@ChartVisual
Scenario: TC_Chart_180: Verify downloading chart series to excel from selection context menu
   And Add few series to myseries
   And Copy the myseries title
   And Highlight any one series
   And Click on "Apply Function" button in myseries
   And Click on "SUM" function from myseries
   And Get the function text from myseries
   And Highlight any one series
   And Click on More actions button in myseries
   And Click on "Download" button in myseries
   And Clicking Download button from "Context Menu" 
   Then Verify that the Functions applied is reflecting in excel data
 
@ChartVisual
Scenario: TC_Chart_181: Verify zoom timeframe reflects on chart
   And Search for the series "210337202" 
   And  Click on more actions to create "View as Chart"
   And Select "YTD" , "1y" , "3y" , "5y" , "All" tabs 
   Then Last 1 year, 3 year, 5 year, "All" data to be plotted in chart visual
   And Closing the chart visual
   
@ChartVisual
Scenario: TC_Chart_182: Verify timeframe option for chart
   And Search for the series "1053401" 
   And  Click on more actions to create "View as Chart"
   And In Chart tab click on timeframe date field and change date
   And Click on "Save period" visual
   Then Should display chart for timepoints within that timeframe range
   And Closing the chart visual
   
@ChartVisual
Scenario: TC_Chart_183: Verify series rename from legend
   And Search for the series "205424302" 
   And  Click on more actions to create "View as Chart"
   And Copy the insight title
   And Hover over the legend
   And Click on "Edit series" button in myseries
   And Click on "Rename" button in myseries
   And Enter the Series name as "Shravas" 
   Then The "Rename" should reflect in Chart
   
@ChartVisual
Scenario: TC_Chart_184: Verify 'Move to right' settings from legend
   And Search for the series "205424302" 
   And  Click on more actions to create "View as Chart"
   And Hover over the legend
   And Click on "Move to right" button in myseries  
   Then The "Move to right" should reflect in Chart
   
@ChartVisual
Scenario: TC_Chart_185: Verify changing series color from legend
   And Search for the series "205424302" 
   And  Click on more actions to create "View as Chart"
   And Hover over the legend
   And Click on "Edit series" button in myseries
   And Click on "Color" button in myseries  
   And Select "#2b60d0" series chart color from list
   And Hover over the legend
   Then The "Color" should reflect in Chart
   
@ChartVisual
Scenario: TC_Chart_187: Verify the frequency is applied for aggregate functions
   And Search for the series "242518103" 
   And  Click on more actions to create "View as Chart"
   And Hover over the legend
   And Click on "Edit series" button in myseries
   And Click on "Frequency" button in myseries
   And Click on "Yearly (Sum)" button in myseries
   And Hover over the legend title
   Then The "Frequency" should reflect in Chart
   
@ChartVisual
Scenario Outline: TC_Chart_188: Verify the frequency is applied for disaggregate functions
   And Search for the series "242518103" 
   And  Click on more actions to create "View as Chart"
   And Hover over the legend
   And Click on "Edit series" button in myseries
   And Click on "Frequency" button in myseries
   And Click on <frequency> button from myseries
   And Hover over the legend title
   Then The "Frequency for Weekly and Monthly" should reflect in Chart
Examples:
     |      frequency			    |
     | "Monthly (Distribute)" |
     | "Weekly (Distribute)"  |
   
@ChartVisual
Scenario Outline: TC_Chart_189: Verify the currency conversion is applied for chart visual
   And Search for the series "101451007" 
   And  Click on more actions to create "View as Chart"
   And Hover over the legend
   And Click on "Edit series" button in myseries
   And Click on "Currency" button in myseries
   And Click on <currency> button in myseries list
   And Hover over the legend title
   Then The "Currency" should reflect in Chart
Examples:
		| currency |
		| "USD" |
		| "RMB" |
		| "GBP" |
		| "EUR" |
		| "JPY" |
		| "MYR" |
		| "RUB" |
		
@ChartVisual
Scenario Outline: TC_Chart_190: Verify if changes function is applied for chart visual
   And Search for the series "205424302" 
   And  Click on more actions to create "View as Chart"
   And Hover over the legend
   And Click on "Edit series" button in myseries
   And Click on "Change" button in myseries
   And Click on <change> button from myseries list
   And Hover over the legend title
   Then The "Change" should reflect in Chart
Examples:
		| change |
		| "Difference Year-over-Year (YoY)" |
		| "% Year-over-Year (%YoY)" |
		| "Difference Period-over-Period (PoP)" |
		| "% Period-over-Period Annualized (%PoP)" |

@ChartVisual
Scenario: TC_Chart_192: Verify if changes function is applied for chart visual
   And Search for the series with SID "447238447;447238437"
   And  Click on more actions to create "View as Chart"
   And Click on "Edit" visual
   And Click on the "Slider" checkbox to "Check"
   Then The Slider option has been "Checked" 
   Then The Slider option has been "Unchecked" 
   
@ChartVisual
Scenario: TC_Chart_197: Verify download of native charts from views tab
   And Search for the series with SID "447238447;447238437"
   And  Click on more actions to create "View as Chart"
   And Search for the series with SID "9380901;9380801"
   And  Click on more actions to create "View as Chart" 
   And Search for the series "205424302" 
   And  Click on more actions to create "View as Chart"
   And Count the list of views
   And Clicking Download button from "Page Header of Views Tab" 
   Then Verify the Chart with link appeared in excel
   
@ChartVisual
Scenario: TC_Chart_198: Verify CEIC logo for chart visual
   And Disable the Chat bubble
   And Search for the series with SID "205424302" and click on "C" option
   And Click credits image
   Then The URL should navigate to "https://www.ceicdata.com/en" 
   And Enable the Chat bubble
   And Login back to default execution login
   