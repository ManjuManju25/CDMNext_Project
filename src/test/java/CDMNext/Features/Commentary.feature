Feature: Verifying Commentary Visual functionality 

Background: 
	Given User has successful logged in 
	
@Commentary	
Scenario: TC_Commentary_01:Verify 'Insert Commentary' creating by drag and drop 
	And   Go to View tab 
	And   Drag and drop commentary visual to the page 
	Then  Commentary should be inserted 
	
@Commentary 
Scenario: TC_Commentary_02:Verify Title for Commentary 
	And Click on Title option on visual header 
	Then The Title popup should be displayed 
	
@Commentary 
Scenario: TC_Commentary_03:Verify adding description for commentary
 	And Add some text in the description field
 	Then Should able to add text in the description field 
 	
@Commentary
Scenario: TC_Commentary_04:Verify 'Title' display ON
 	And  Click on visual title
 	And Check the box for the title name
 	Then The title name should reflect on the Commentary
 	
@Commentary
Scenario: TC_Commentary_05:Verify 'Title' display OFF
 	And  Click on visual title
 	And Uncheck the box for the title name
 	Then No title name should display for the Commentary
 	
@Commentary
Scenario: TC_Commentary_06:Verify visual title field
 	And  Click on visual title
 	And Check the box and enter the title name as "New commentary"
 	Then The commentary should update the title name to "New commentary"
 	
@Commentary
Scenario: TC_Commentary_07:Verify text color
 	And  Click on visual title
 	And  Choose text color is blue
 	Then The commentary should update the title text color as blue
 	
@Commentary
Scenario: TC_Commentary_08:Verify highlight color
 	And  Click on visual title
 	And  Choose highlight color is Orange
 	Then The commentary should update the title highlight color as Orange
 	
@Commentary
Scenario: TC_Commentary_09:Verify 'font size'
 	And  Click on visual title
 	And  Choose "20" from the drop-down for the font size
 	Then The commentary should update the title font as "20"
 	
@Commentary
Scenario: TC_Commentary_10:Verify title in bold style
 	And  Click on visual title
 	And   Click on B under style
 	Then The visual title should be in bold style
 	
 @Commentary
Scenario: TC_Commentary_11:Verify title in Italic style
 	And  Click on visual title
 	And   Click on Italic under style
 	Then The visual title should be in "italic" style
 	
@Commentary
Scenario: TC_Commentary_12:Verify title as underlined
 	And  Click on visual title
 	And   Click on Underlined(U) under style
 	Then The visual title should be "underline"
 	
@Commentary
Scenario: TC_Commentary_13:Verify horizontal alignment (left, right, center)
 	And  Click on visual title 
	And  Click on left,center and right alignment for title 
	Then The title should align to "left" , "center" and "right" as user set 
 
@Commentary
Scenario: TC_Commentary_14:Commentary subtitle display=YES
 	And  Click on visual title
 	And  Check the box for sub-title
 	Then The "Sub title" should reflect on the Commentary
 	
@Commentary
Scenario: TC_Commentary_15:Commentary subtitle display=NO
 	And  Click on visual title
 	And   Uncheck the box for sub-title
 	Then No sub-title name should be displayed
 
 	
	