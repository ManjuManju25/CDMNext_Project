Feature: Verifying Attachments Visual functionality

  @Attachments
  Scenario: TC_Attachments_01:Verify 'Insert Attachments' under View tab
    And Go to View tab
    And Click on Insert Attachments
    Then Attachments should be inserted

  @Attachments
  Scenario: TC_Attachments_02:Verify 'Insert Attachments' creating by drag and drop
    And Go to View tab
    And Drag and drop Attachments visual to the page
    Then Attachments should be inserted

  @Attachments
  Scenario: TC_Attachments_03:Title - Verify Title for Attachments
    And Create a Attachments visual
    And Click on "Title" option on visual header
    Then The "Title" popup should be displayed

  @Attachments
  Scenario: TC_Attachments_04:Verify 'Title' display ON
    And Create a Attachments visual
    And Click on visual title
    And Check the box for the title name
    Then The title name should reflect on the Attachments

  @Attachments
  Scenario: TC_Attachments_05:Verify 'Title' display OFF
    And Create a Attachments visual
    And Click on visual title
    And Uncheck the box for the title name
    Then No title name should display for the Attachments

  @Attachments
  Scenario: TC_Attachments_06:Verify visual title field
    And Create a Attachments visual
    And Click on visual title
    And Check the box and enter the title name as "New Attachments"
    Then The Attachments should update the "title" name to "New Attachments"

  @Attachments
  Scenario: TC_Attachments_07:Verify text color
    And Create a Attachments visual
    And Click on visual title
    And Choose text color is blue
    Then The Attachments should update the "title" text color as blue

  @Attachments
  Scenario: TC_Attachments_08:Verify highlight color
    And Create a Attachments visual
    And Click on visual title
    And Choose highlight color is Orange
    Then The Attachments should update the "title" highlight color as Orange

  @Attachments
  Scenario: TC_Attachments_09:Verify 'font size'
    And Create a Attachments visual
    And Click on visual title
    And Choose "20" from the drop-down for the font size
    Then The Attachments should update the "title" font as "20"

  @Attachments
  Scenario: TC_Attachments_10:Verify title in bold style
    And Create a Attachments visual
    And Click on visual title
    And Click on Bold icon for "title"
    Then The visual "title" should be in bold style

  @Attachments
  Scenario: TC_Attachments_11:Verify title in Italic style
    And Create a Attachments visual
    And Click on visual title
    And Click on Italic under style
    Then The visual "title" should be "italic"

  @Attachments
  Scenario: TC_Attachments_12:Verify title as underlined
    And Create a Attachments visual
    And Click on visual title
    And Click on Underline icon for "title"
    Then The visual "title" should be "underline"

  @Attachments
  Scenario: TC_Attachments_13:Verify horizontal alignment (left, right, center)
    And Create a Attachments visual
    And Click on visual title
    And Click on left,center and right alignment for title
    Then The title should align to "left" , "center" and "right" as user set

  @Attachments
  Scenario: TC_Attachments_14:Subtitle - Verify subtitle by default
    And Create a Attachments visual
    And Click on visual title
    And Expand subtitle
    Then The Subtitle should be disabled by default

  @Attachments
  Scenario: TC_Attachments_15:Attachments subtitle display=YES
    And Create a Attachments visual
    And Click on visual title
    And Check the box for sub-title
    Then The "Sub title" should reflect on the Attachments

  @Attachments
  Scenario: TC_Attachments_16:Attachments subtitle display=NO
    And Create a Attachments visual
    And Click on visual title
    And Uncheck the box for sub-title
    Then No sub-title name should be displayed

  @Attachments
  Scenario: TC_Attachments_17:Sub-title field
    And Create a Attachments visual
    And Click on visual title
    And Check the box and enter the sub-title name as "New subtitle"
    Then The Attachments should update the "sub_title" name to "New subtitle"

  @Attachments
  Scenario: TC_Attachments_18:Verify Sub-title text color
    And Create a Attachments visual
    And Click on visual title
    And Choose text color is blue for subtitle
    Then The Attachments should update the "sub_title" text color as blue

  @Attachments
  Scenario: TC_Attachments_19:Subtitle > Verify highlight color
    And Create a Attachments visual
    And Click on visual title
    And Choose highlight color is Orange for subtitle
    Then The Attachments should update the "sub_title" highlight color as Orange

  @Attachments
  Scenario: TC_Attachments_20:Subtitle > Verify 'font size'
    And Create a Attachments visual
    And Click on visual title
    And Choose "10" from the drop-down for the font size of subtitle
    Then The Attachments should update the "sub_title" font as "10"

  @Attachments
  Scenario: TC_Attachments_21:Verify Subtitle in bold style
    And Create a Attachments visual
    And Click on visual title
    And Click on B under style for sub-title
    Then The visual "sub_title" should be in bold style

  @Attachments
  Scenario: TC_Attachments_22:Verify Subtitle in Italic style
    And Create a Attachments visual
    And Click on visual title
    And Click on Italic under style for sub-title
    Then The visual "sub_title" should be "italic"

  @Attachments
  Scenario: TC_Attachments_23:Verify Subtitle as underlined
    And Create a Attachments visual
    And Click on visual title
    And Click on Underline icon for sub-title
    Then The visual "sub_title" should be "underline"

  @Attachments
  Scenario: TC_Attachments_24:Verify horizontal alignment (left, right, center) of sub_title
    And Create a Attachments visual
    And Click on visual title
    And Click on left,center and right alignment for sub_title
    Then The sub_title should align to "left" , "center" and "right" as user set

  @Attachments
  Scenario: TC_Attachments_25:Verify closing of titles popup
    And Create a Attachments visual
    And Click on visual title
    And Click on X icon to close the popup
    Then The "Title" popup should be closed

  @Attachments
  Scenario: TC_Attachments_26:Verify opening title popup by double click
    And Create a Attachments visual
    And Double click on the visual title/subtitle
    Then The title popup should be appeared

  @Attachments
  Scenario: TC_Attachments_27:Verify edit commentary icon
    And Create a Attachments visual
    And Click on edit commentary icon
    Then The title popup should be appeared

  @Attachments
  Scenario: TC_Attachments_28:Verify Visual option
    And Create a Attachments visual
    And Click on "Visual" option on visual header
    Then The "Visual" popup should be displayed

  @Attachments
  Scenario: TC_Attachments_29:Verify alignment
    And Create a Attachments visual
    And Click on "Visual" option on visual header
    Then By default Horizontal align should be disabled
    And Set "Proportion:" to 70 in visual header
    And Choose Horizontal align of visual to "Left"
    Then The Visual area should be align to "Left"
    And Choose Horizontal align of visual to "Center"
    Then The Visual area should be align to "Center"
    And Choose Horizontal align of visual to "Right"
    Then The Visual area should be align to "Right"

  @Attachments
  Scenario: TC_Attachments_30:Verify proportion
    And Create a Attachments visual
    And Click on "Visual" option on visual header
    Then By default Proportion should be "100"

  @Attachments
  Scenario: TC_Attachments_31:Verify backgroud by default
    And Create a Attachments visual
    And Click on "Visual" option on visual header
    And Check for Background
    Then By default "Background" should be disabled

  @Attachments
  Scenario: TC_Attachments_32:Visual - Verify backgroud color for visual
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Visual" option on visual header
    And Check for Background
    And Select color for visual background
    Then Selected color should be applied to the attachment visual background

  @Attachments
  Scenario: TC_Attachments_33:Verify upload image for visual backgroud
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Visual" option on visual header
    And Check for Background
    And Click on browse > Select image for visual background
    Then Selected image should be uploaded and applied to the attachment visual background

  @Attachments
  Scenario: TC_Attachments_34:Visual - Verify remove icon for uploaded image
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Visual" option on visual header
    And Check for Background
    And Click on browse > Select image for visual background
    And Click on remove icon for uploaded image
    Then Uploaded image should be removed

  @Attachments
  Scenario: TC_Attachments_35:Verify border by default
    And Create a Attachments visual
    And Click on "Visual" option on visual header
    And Check for Border
    Then By default "Border" should be disabled

  @Attachments
  Scenario: TC_Attachments_36:Verify border color
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Visual" option on visual header
    And Check for Border
    And Select color for visual border
    Then The attachment visual border should be changed as per the selection

  @Attachments
  Scenario: TC_Attachments_37:Verify border width
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Visual" option on visual header
    And Check for Border
    And Select border width 5 for visual border
    Then "Width" should be updated to "5"

  @Attachments
  Scenario: TC_Attachments_38:Verify border radius
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Visual" option on visual header
    And Check for Border
    And Tick checkbox for border and choose radius as 10
    Then "Radius" should be updated to "10"

  @Attachments
  Scenario: TC_Attachments_39:Verify visual border type
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Visual" option on visual header
    And Check for Border
    And Tick checkbox for border and choose different border as "Dotted"
    Then The "dotted" border should be applied to the visual

  @Attachments
  Scenario: TC_Attachments_40:Verify closing of visual popup
    And Create a Attachments visual
    And Click on "Visual" option on visual header
    And Click on X icon to close the popup
    Then The "Visual" popup should be closed

  @Attachments
  Scenario: TC_Attachments_41:Verify 'Add to insight' option
    And Create a Attachments visual
    And Click on "Add to insight" option
    Then Drop down should be opened with "Add to new tab" and "Add to new insight"

  @Attachments
  Scenario: TC_Attachments_42:Verify 'Add to new tab' option under Add to insight
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Add to insight" option
    And Click on "Add to new tab"
    Then The attachment visual should be created in new tab on current insight

  @Attachments
  Scenario: TC_Attachments_43:Verify confirmation message for adding visual to new insight
    And Create a Attachments visual
    And Click on "Add to insight" option
    And Click on "Add to new insight"
    Then "New insight with the selected visual created" and "Go to new insight" confirmation message should be displayed

  @Attachments
  Scenario: TC_Attachments_44:Validate the added visual by opening new insight
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "Add to insight" option
    And Click on "Add to new insight"
    And Click on "Go to new insight"
    Then The insight should be opened and added attachment visual should be available in My visual

  @Attachments
  Scenario: TC_Attachments_45:Verify confirmation message for copy visual
    And Create a Attachments visual
    And Click on Copy icon
    Then "Attachments copied." message should be displayed

  @Attachments
  Scenario: TC_Attachments_46:Validate copied visual by pasting with in the insight
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on Copy icon
    And Paste within the insight
    Then The attachments visual should be pasted in the insight

  @Attachments
  Scenario: TC_Attachments_47:Validate copied visual by pasting to new insight
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on Copy icon
    And Paste to new insight
    Then The attachments visual should be pasted to new insight

  @Attachments
  Scenario: TC_Attachments_48:Verify the confrimation message for pasting visual in insight
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on Copy icon
    And Paste within the insight
    Then "Data pasted from clipboard" message should be displayed

  @Attachments
  Scenario: TC_Attachments_49:Verify Open option
    And Create a Attachments visual
    And Click on Open icon
    Then The visual should be displayed in maximized window

  @Attachments
  Scenario: TC_Attachments_50:Verify closing of maximized window
    And Create a Attachments visual
    And Click on Open icon
    And Click on x icon to close
    Then The modal window should be closed

  @Attachments
  Scenario: TC_Attachments_51:Verify Delete attachments
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "delete"
    Then "Confirmation" popup should be dispalyed

  @Attachments
  Scenario: TC_Attachments_52:Verify description for delete confirmation popup
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "delete"
    Then "Do you want to remove this visual?" popup should be dispalyed

  @Attachments
  Scenario: TC_Attachments_53:Verify OK button in delete confirmation popup
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "delete"
    And Click on "Ok"
    Then The Attachments visual should be deleted

  @Attachments
  Scenario: TC_Attachments_54:Verify Cancel/x icon in delete confirmation popup
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on "delete"
    And Click on "Cancel"
    Then The popup should be closed and delete attachments visual process should be declined

  @Attachments
  Scenario: TC_Attachments_55:Links - Verify 'Links' tab
    And Create a Attachments visual
    And Click on "Links" tab
    Then The tab should contain "Link" and "Title" fields

  @Attachments
  Scenario: TC_Attachments_56:Links - Validate the link
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    Then The link should be created above

  @Attachments
  Scenario: TC_Attachments_57:Links - Verify title field without link
    And Create a Attachments visual
    And Type any name in the title field
    Then The OK button should be disabled until enter links for the tilte

  @Attachments
  Scenario: TC_Attachments_58:Links -  Verify OK and Cancel buttons by default
    And Create a Attachments visual
    Then The OK and cancel buttons should be disabled

  @Attachments
  Scenario: TC_Attachments_59:Links - Verify Edit link
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Type any name in the title field
    And Click on Ok
    And Click on edit icon for the link
    Then The link and title should be restored to respective fields to edit

  @Attachments
  Scenario: TC_Attachments_60:Links - Verify delete link
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on delete icon for the link
    Then The link should be deleted

  @Attachments
  Scenario: TC_Attachments_61:Links -  Verify clicking on link
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Click on the link
    Then User should be redirected to the link in new browser tab

  @Attachments
  Scenario: TC_Attachments_62:Links - Verify OK button
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Type any name in the title field
    And Click on Ok
    Then The Link should be saved

  @Attachments
  Scenario: TC_Attachments_63:Links - Verify Cancel button
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Type any name in the title field
    And Click on Cancel
    Then Entered link and title should be removed from the respective fields

  @Attachments
  Scenario: TC_Attachments_64:Uploads - Verify 'Uploads' tab
    And Create a Attachments visual
    And Click on Uploads tab
    And Choose file from system and upload
    Then The file should be uploaded

  @Attachments
  Scenario: TC_Attachments_65:Uploads - Verify 'Remove' file
    And Create a Attachments visual
    And Click on Uploads tab
    And Choose file from system and upload
    And Click on Remove file
    Then The file should be removed

  @Attachments
  Scenario: TC_Attachments_66:Uploads - Verify clicking on file name
    And Create a Attachments visual
    And Click on Uploads tab
    And Choose file from system and upload
    And Click on the file
    Then The file should be downloaded

  @Attachments
  Scenario: TC_Attachments_67:Uploads - Verify multiple files upload
    And Create a Attachments visual
    And Try to upload multiple files in the same visual
    Then Should allow to upload multiple files to the visual

  @Attachments
  Scenario: TC_Attachments_68:Uploads - Verify default tab for attachments visual
    And Create a Attachments visual
    #And Click on Uploads tab
    #And Unselect the visual
    #And Now select the visual
    Then The default tab for attachement is "Uploads"

  @Attachments
  Scenario: TC_Attachments_69:Right click - Verify Copy Attachments
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Right click on visual header
    And Choose "Copy attachments"
    Then Attachments should be copied to clipboard

  @Attachments
  Scenario: TC_Attachments_70:Right click - Validate copied Attachments
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Right click on visual header
    And Choose "Copy attachments"
    And Paste in insight
    Then Attachments visual should be pasted

  @Attachments
  Scenario: TC_Attachments_71:Right click - Verify Cut Attachments
    And Create a Attachments visual
    And Right click on visual header
    And Choose "Cut attachments"
    Then Attachments should be cut

  @Attachments
  Scenario: TC_Attachments_72:Right click - Validate Cut Attachments
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Right click on visual header
    And Choose "Cut attachments"
    And Paste in insight
    Then Attachments visual should be pasted

  @Attachments
  Scenario: TC_Attachments_73:Right click - Verify Delete Attachments
    And Create a Attachments visual
    And Right click on visual header
    And Choose "Delete attachments"
    Then Attachments should be deleted

  @Attachments
  Scenario: TC_Attachments_74:Right click - Verify chart under Add chart
    And Create a Attachments visual
    And Right click on visual header
    And Choose Add chart as "Chart"
    Then "Chart" visual should be created in the same view tab

  @Attachments
  Scenario: TC_Attachments_75:Right click - Verify Map under Add chart
    And Create a Attachments visual
    And Right click on visual header
    And Choose Add chart as "Map"
    Then "Map" visual should be created in the same view tab

  @Attachments
  Scenario: TC_Attachments_76:Right click - Verify Table under Add chart
    And Create a Attachments visual
    And Right click on visual header
    And Choose Add chart as "Table"
    Then "Table" visual should be created in the same view tab

  @Attachments
  Scenario: TC_Attachments_77:Right click - Verify Heat map under Add chart
    And Create a Attachments visual
    And Right click on visual header
    And Choose Add chart as "Heat map"
    Then "Heat map" visual should be created in the same view tab

  @Attachments
  Scenario: TC_Attachments_78:Right click - Verify Histogram under Add chart
    And Create a Attachments visual
    And Right click on visual header
    And Choose Add chart as "Histogram"
    Then "Histogram" visual should be created in the same view tab

  @Attachments
  Scenario: TC_Attachments_79:Right click - Verify Pie under insert visual
    And Create a Attachments visual
    And Right click on visual header
    And Choose Add chart as "Pie"
    Then "Pie" visual should be created in the same view tab

  #@Attachments
  #Scenario: TC_Attachments_80:Right click - Verify commentary under insert visual
    #And Create a Attachments visual
    #And Right click on visual header
    #And Choose Insert visual as "Commentary"
    #Then "Commentary" visual should be created in the same view tab

  #@Attachments
  #Scenario: TC_Attachments_81:Right click - Verify attachments under insert visual
    #And Create a Attachments visual
    #And Right click on visual header
    #And Choose Insert visual as "Attachments"
    #Then Attachments visual should be created in the same view tab

  #@Attachments
  #Scenario: TC_Attachments_82:Right click - Verify image under insert visual
    #And Create a Attachments visual
    #And Right click on visual header
    #And Choose Insert visual as "Image"
    #Then "Image" visual should be created in the same view tab
#
  #@Attachments
  #Scenario: TC_Attachments_83:Right click - Verify Filter under insert visual
    #And Create a Attachments visual
    #And Right click on visual header
    #And Choose Insert visual as "Filter"
    #Then "Filter" visual should be created in the same view tab

  @Attachments
  Scenario: TC_Attachments_84:Right click - Verify Paste visual
    And Create a Attachments visual
    And Right click on visual header
    And Choose "Copy attachments"
    And Again Right click on visual header
    And Choose "Paste visual"
    Then Copied attachments visual should be pasted

  @Attachments
  Scenario: TC_Attachments_85:Right click - Verify 'Clear contents'
    And Create a Attachments visual
    Then Enter "www.google.com" in the link field
    And Click on Ok
    And Right click on visual header
    And Choose "Clear contents"
    Then All the contents should be removed from the attachments visual

  @Attachments
  Scenario: TC_Attachments_86:Right click - Verify Download subdropdown
    And Create a Attachments visual
    And Right click on visual header
    And Choose "Download"
    Then "Attachments , View" options should be displayed

  #@Attachments....removed from exe as per the CR(CVISION-12419)
  #Scenario: TC_Attachments_87:Right click - Download - Verify Attachments
    #And Add some text in the description field
    #And Get the text from the description field
    #And Create attachments visual
    #And Right click on visual header
    #And Choose Download as "View"
    #Then Download popup should be appeared with "Views" tab selection
