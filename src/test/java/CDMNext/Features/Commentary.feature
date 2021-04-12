Feature: Verifying Commentary Visual functionality

  @Commentary
  Scenario: TC_Commentary_01:Verify 'Insert Commentary' under View tab
    And Go to View tab
    And Click on "Insert Commentary"
    Then Commentary should be inserted

  @Commentary
  Scenario: TC_Commentary_02:Verify 'Insert Commentary' creating by drag and drop
    And Go to View tab
    And Drag and drop commentary visual to the page
    Then Commentary should be inserted

  @Commentary
  Scenario: TC_Commentary_03:Verify Title for Commentary
    And Create Commentary visual
    And Click on "Title" option on visual header
    Then The "Title" popup should be displayed

  @Commentary
  Scenario: TC_Commentary_04:Verify adding description for commentary
    And Add some text in the description field
    Then Should able to add text in the description field

  @Commentary
  Scenario: TC_Commentary_05:Verify 'Title' display ON
    And Create Commentary visual
    And Click on visual title
    And Check the box for the title name
    Then The title name should reflect on the Commentary

  @Commentary
  Scenario: TC_Commentary_06:Verify 'Title' display OFF
    And Create Commentary visual
    And Click on visual title
    And Uncheck the box for the title name
    Then No title name should display for the Commentary

  @Commentary
  Scenario: TC_Commentary_07:Verify visual title field
    And Create Commentary visual
    And Click on visual title
    And Check the box and enter the title name as "New commentary"
    Then The commentary should update the "title" name to "New commentary"

  @Commentary
  Scenario: TC_Commentary_08:Verify text color
    And Create Commentary visual
    And Click on visual title
    And Choose text color is blue
    Then The commentary should update the "title" text color as blue

  @Commentary
  Scenario: TC_Commentary_09:Verify highlight color
    And Create Commentary visual
    And Click on visual title
    And Choose highlight color is Orange
    Then The commentary should update the "title" highlight color as Orange

  @Commentary
  Scenario: TC_Commentary_10:Verify 'font size'
    And Create Commentary visual
    And Click on visual title
    And Choose "20" from the drop-down for the font size
    Then The commentary should update the "title" font as "20"

  @Commentary
  Scenario: TC_Commentary_11:Verify title in bold style
    And Create Commentary visual
    And Click on visual title
    And Click on Bold icon for "title"
    Then The visual "title" should be in bold style

  @Commentary
  Scenario: TC_Commentary_12:Verify title in Italic style
    And Create Commentary visual
    And Click on visual title
    And Click on Italic under style
    Then The visual "title" should be "italic"

  @Commentary
  Scenario: TC_Commentary_13:Verify title as underlined
    And Create Commentary visual
    And Click on visual title
    And Click on Underline icon for "title"
    Then The visual "title" should be "underline"

  @Commentary
  Scenario: TC_Commentary_14:Verify horizontal alignment (left, right, center)
    And Create Commentary visual
    And Click on visual title
    And Click on left,center and right alignment for title
    Then The title should align to "left" , "center" and "right" as user set

  @Commentary
  Scenario: TC_Commentary_15:Subtitle - Verify subtitle by default
    And Create Commentary visual
    And Click on visual title
    And Expand subtitle
    Then The Subtitle should be disabled by default

  @Commentary
  Scenario: TC_Commentary_16:Commentary subtitle display=YES
    And Create Commentary visual
    And Click on visual title
    And Check the box for sub-title
    Then The "Sub title" should reflect on the Commentary

  @Commentary
  Scenario: TC_Commentary_17:Commentary subtitle display=NO
    And Create Commentary visual
    And Click on visual title
    And Uncheck the box for sub-title
    Then No sub-title name should be displayed

  @Commentary
  Scenario: TC_Commentary_18:Sub-title field
    And Create Commentary visual
    And Click on visual title
    And Check the box and enter the sub-title name as "New subtitle"
    Then The commentary should update the "sub_title" name to "New subtitle"

  @Commentary
  Scenario: TC_Commentary_19:Verify Sub-title text color
    And Create Commentary visual
    And Click on visual title
    And Choose text color is blue for subtitle
    Then The commentary should update the "sub_title" text color as blue

  @Commentary
  Scenario: TC_Commentary_20:Subtitle > Verify highlight color
    And Create Commentary visual
    And Click on visual title
    And Choose highlight color is Orange for subtitle
    Then The commentary should update the "sub_title" highlight color as Orange

  @Commentary
  Scenario: TC_Commentary_21:Subtitle > Verify 'font size'
    And Create Commentary visual
    And Click on visual title
    And Choose "10" from the drop-down for the font size of subtitle
    Then The commentary should update the "sub_title" font as "10"

  @Commentary
  Scenario: TC_Commentary_22:Verify Subtitle in bold style
    And Create Commentary visual
    And Click on visual title
    And Click on B under style for sub-title
    Then The visual "sub_title" should be in bold style

  @Commentary
  Scenario: TC_Commentary_23:Verify Subtitle in Italic style
    And Create Commentary visual
    And Click on visual title
    And Click on Italic under style for sub-title
    Then The visual "sub_title" should be "italic"

  @Commentary
  Scenario: TC_Commentary_24:Verify Subtitle as underlined
    And Create Commentary visual
    And Click on visual title
    And Click on Underline icon for sub-title
    Then The visual "sub_title" should be "underline"

  @Commentary
  Scenario: TC_Commentary_25:Verify horizontal alignment (left, right, center) of sub_title
    And Create Commentary visual
    And Click on visual title
    And Click on left,center and right alignment for sub_title
    Then The sub_title should align to "left" , "center" and "right" as user set

  @Commentary
  Scenario: TC_Commentary_26:Verify closing of titles popup
    And Create Commentary visual
    And Click on visual title
    And Click on X icon to close the popup
    Then The "Title" popup should be closed

  @Commentary
  Scenario: TC_Commentary_27:Verify opening title popup by double click
    And Create Commentary visual
    And Double click on the visual title/subtitle
    Then The title popup should be appeared

  @Commentary
  Scenario: TC_Commentary_28:Verify edit commentary icon
    And Create Commentary visual
    And Click on edit commentary icon
    Then The title popup should be appeared

  @Commentary
  Scenario: TC_Commentary_29:Verify Visual option
    And Create Commentary visual
    And Click on "Visual" option on visual header
    Then The "Visual" popup should be displayed

  @Commentary1
  Scenario: TC_Commentary_30:Verify alignment
    And Create Commentary visual
    And Click on "Visual" option on visual header
    Then By default Horizontal align should be disabled
    And Click on "Proportion:" option in visual header to 70
    And Select Horizontal align of visual to "Left"
    Then The Visual area should be align to "Left"
    And Select Horizontal align of visual to "Center"
    Then The Visual area should be align to "Center"
    And Select Horizontal align of visual to "Right"
    Then The Visual area should be align to "Right"

  @Commentary
  Scenario: TC_Commentary_31:Verify proportion
    And Create Commentary visual
    And Click on "Visual" option on visual header
    Then By default Proportion should be "100"

  @Commentary
  Scenario: TC_Commentary_32:Verify backgroud by default
    And Create Commentary visual
    And Click on "Visual" option on visual header
    And Check for Background
    Then By default "Background" should be disabled

  @Commentary
  Scenario: TC_Commentary_33:Verify backgroud color for visual
    And Create Commentary visual
    And Click on "Visual" option on visual header
    And Enter some data to description field
    And Check for Background
    And Select color for visual background
    Then Selected color should be applied to the visual background

  @Commentary
  Scenario: TC_Commentary_34:Verify upload image for visual backgroud
    And Enter some data to description field
    And Check for Background
    And Click on browse > Select image for visual background
    Then Selected image should be uploaded and applied to the visual background

  @Commentary
  Scenario: TC_Commentary_35:Visual - Verify remove icon for uploaded image
    And Enter some data to description field
    And Check for Background
    And Click on browse > Select image for visual background
    And Click on remove icon for uploaded image
    Then The uploaded image should be removed

  @Commentary
  Scenario: TC_Commentary_36:Verify border by default
    And Create Commentary visual
    And Click on "Visual" option on visual header
    And Check for Border
    Then By default "Border" should be disabled

  @Commentary
  Scenario: TC_Commentary_37:Verify border color
    And Enter some data to description field
    And Check for Border
    And Select color for visual border
    Then The visual border should be changed as per the selection

  @Commentary
  Scenario: TC_Commentary_38:Verify border width
    And Enter some data to description field
    And Check for Border
    And Select border width 5 for visual border
    Then "Width" should be updated to "5"

  @Commentary
  Scenario: TC_Commentary_39:Verify border radius
    And Enter some data to description field
    And Check for Border
    And Tick checkbox for border and choose radius as 10
    Then "Radius" should be updated to "10"

  @Commentary
  Scenario: TC_Commentary_40:Verify visual border type
    And Enter some data to description field
    And Check for Border
    And Tick checkbox for border and choose different border as "Dotted"
    Then The "dotted" border should be applied to the visual

  @Commentary
  Scenario: TC_Commentary_41:Verify closing of visual popup
    And Create Commentary visual
    And Click on "Visual" option on visual header
    And Click on X icon to close the popup
    Then The "Visual" popup should be closed

  @Commentary
  Scenario: TC_Commentary_42:Verify confirmation message for copy visual
    And Create Commentary visual
    And Add some text in the description field
    And Click on Copy icon
    Then "Commentary copied." message should be displayed

  @Commentary
  Scenario: TC_Commentary_43:Validate copied visual by pasting with in the insight
    And Add some text in the description field
    And Click on Copy icon
    And Paste within the insight
    Then The visual should be pasted in the insight

  @Commentary
  Scenario: TC_Commentary_44:Validate copied visual by pasting to new insight
    And Add some text in the description field
    And Click on Copy icon
    And Paste to new insight
    Then The visual should be pasted to new insight

  @Commentary
  Scenario: TC_Commentary_45:Verify the confrimation message for pasting visual in insight
    And Add some text in the description field
    And Click on Copy icon
    And Paste within the insight
    Then "Data pasted from clipboard" message should be displayed

  #@Commentary1
  #Scenario: TC_Commentary_46:Validate copied visual by pasting to excel
    #And Add some text in the description field
    #And Click on Copy icon
    #Then Paste in Excel and the text should be pasted to excel

  @Commentary
  Scenario: TC_Commentary_47:Validate copied visual by pasting to word
    And Add some text in the description field
    And Click on Copy icon
    Then Paste in word and the text should be pasted in word file

  @Commentary
  Scenario: TC_Commentary_48:Validate copied visual by pasting to power point
    And Add some text in the description field
    And Click on Copy icon
    Then Paste in ppt and the text should be pasted PPT

  @Commentary
  Scenario: TC_Commentary_49:Verify Download option
    And Add some text in the description field
    And Click on Download icon
    Then Download popup should be appeared

  @Commentary
  Scenario: TC_Commentary_50:Download - Verify the tab name in excel for download
    And Add some text in the description field
    And Click on Download icon
    And Select "xlsx" format
    And Click on "Download"
    Then The tab name should be "Commentary"

  @Commentary
  Scenario: TC_Commentary_51:Download - Verify visual download to PNG format
    And Add some text in the description field
    And Click on Download icon
    And Select "png" format
    And Click on "Download"
    Then Commentary should be downloaded in "PNG" format

  @Commentary
  Scenario: TC_Commentary_52:Verify 'Add to insight' option
    And Add some text in the description field
    And Click on "Add to insight" option
    Then Drop down should be opened with "Add" and "Add to new insight"

  @Commentary
  Scenario: TC_Commentary_53:Verify 'Add' option under Add to insight
    And Add some text in the description field
    And Click on "Add to insight" option
    And Click on "Add"
    Then The Visual should be created in new tab on current insight

  @Commentary
  Scenario: TC_Commentary_54:Verify confirmation message for adding visual to new insight
    And Add some text in the description field
    And Click on "Add to insight" option
    And Click on "Add to new insight"
    Then "New insight with the selected visual created" and "Go to new insight" confirmation message should be displayed

  @Commentary
  Scenario: TC_Commentary_55:Validate the added visual by opening new insight
    And Add some text in the description field
    And Click on "Add to insight" option
    And Click on "Add to new insight"
    And Click on "Go to new insight"
    Then The insight should be opened and added visual should be available in My visual

  @Commentary
  Scenario: TC_Commentary_56:Verify Open option
    And Create Commentary visual
    And Click on Open icon
    Then The visual should be displayed in maximized window

  @Commentary
  Scenario: TC_Commentary_57:Verify closing of maximized window
    And Create Commentary visual
    And Click on Open icon
    And Click on x icon to close
    Then The modal window should be closed

  @Commentary
  Scenario: TC_Commentary_58:Verify Delete commentary
    And Add some text in the description field
    And Click on "delete"
    Then "Confirmation" popup should be dispalyed

  @Commentary
  Scenario: TC_Commentary_59:Verify description for delete confirmation popup
    And Add some text in the description field
    And Click on "delete"
    Then "Do you want to remove this visual?" popup should be dispalyed

  @Commentary
  Scenario: TC_Commentary_60:Verify 'Table' drop down
    And Create Commentary visual
    And Click on "Table" drop down
    Then "Table,Table properties,Delete Table,Cell,Row,Column" table options should be available

  @Commentary
  Scenario: TC_Commentary_61:Table - Verify insert table
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    Then Table should be created as per the selection

  @Commentary
  Scenario: TC_Commentary_62:Table - Verify Table properties
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    Then The "Table properties" popup should be displayed

  @Commentary
  Scenario: TC_Commentary_63:Table - properties - verify width field for table
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    And Set "width" for table "50px"
    Then The table "width" should be displayed as "50px"

  @Commentary
  Scenario: TC_Commentary_64:Table - properties - verify hight field for table
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    And Set "height" for table "50px"
    Then The table "height" should be displayed as "50px"

  @Commentary
  Scenario: TC_Commentary_65:Table - properties - verify cell spacing field for table
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    And Set "cell spacing" for table "30"
    Then The table "cell spacing" should be displayed as "30"

  @Commentary
  Scenario: TC_Commentary_66:Table - properties - verify cell padding field for table
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    And Set "cell padding" for table "40"
    Then The table "cell padding" should be displayed as "40"

  @Commentary
  Scenario: TC_Commentary_67:Table - properties - verify caption field for table
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    And Check Caption for table
    Then Caption should be added to the table

  @Commentary
  Scenario: TC_Commentary_68:Table - properties - verify removing caption by unchecking the field.
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    And Uncheck caption for table
    Then Caption shoud be removed

  @Commentary
  Scenario: TC_Commentary_69:Table - properties - verify cancel/x icon
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Table properties"
    And Click on Cancel
    Then The table properties popup should be closed

  @Commentary
  Scenario: TC_Commentary_70:Table - Delete table
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Delete table"
    Then The table should be deleted from the visual

  @Commentary
  Scenario: TC_Commentary_71:Table - Verify Cell proprites
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Click on "Table" drop down
    And Click on "Cell"
    And Click on "Cell properties"
    Then The Cell properties popup should be displayed

  @Commentary
  Scenario: TC_Commentary_72:Table - Merge cells
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Select cells to merge
    And Click on "Table" drop down
    And Click on "Cell"
    And Click on "Merge cells"
    Then The selected cells should be merged

  @Commentary
  Scenario: TC_Commentary_73:Table - Split cell
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Select cells to merge
    And Click on "Table" drop down
    And Click on "Cell"
    And Click on "Merge cells"
    And Click on "Table" drop down
    And Click on "Cell"
    And Click on "Split cell"
    Then The cell should be split the cell

  @Commentary
  Scenario: TC_Commentary_74:Table - Row - verify insert row before
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify row count
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Insert row before"
    Then The row should be insertd before the selected table

  @Commentary
  Scenario: TC_Commentary_75:Table - Row - verify insert row after
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify row count
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Insert row after"
    Then The row should be insertd after selected the table

  @Commentary
  Scenario: TC_Commentary_76:Table - Row - verify Delete row
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify row count
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Delete row"
    Then The selected row should be deleted

  @Commentary
  Scenario: TC_Commentary_77:Table - Row - Verify Row proprities
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Enter text in a cell
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Row properties"
    Then "Row properties" should be displayed
    And Apply "Row type" as "Footer"
    And Apply "Alignment" as "Right"
    And Apply "Height" as "50px"
    Then Applied properties should be display

  @Commentary
  Scenario: TC_Commentary_78:Table - Row - verify cut row
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify row count
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Cut row"
    Then The selected row should be cut

  @Commentary
  Scenario: TC_Commentary_79:Table - Row - Verify Paste row before
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify row count
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Copy row"
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Paste row before"
    Then The row should be insertd before the selected table

  @Commentary
  Scenario: TC_Commentary_80:Table - Row - Verify paste row after
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify row count
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Copy row"
    And Click on "Table" drop down
    And Click on "Row"
    And Select "Paste row before"
    Then The row should be insertd after selected the table

  @Commentary
  Scenario: TC_Commentary_81:Table - Column - Verify Insert column before
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify column count
    And Click on "Table" drop down
    And Click on "Column"
    And Select "Insert column before"
    Then The column should be inserted before selected column

  @Commentary
  Scenario: TC_Commentary_82:Table - Column - Verify Insert column after
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify column count
    And Click on "Table" drop down
    And Click on "Column"
    And Select "Insert column after"
    Then The column should be inserted after selected column

  @Commentary
  Scenario: TC_Commentary_83:Table - Column - Verify Delete column
    And Create Commentary visual
    And Click on "Table" drop down
    And Create table
    And Verify column count
    And Click on "Table" drop down
    And Click on "Column"
    And Select "Delete column"
    Then The column should be deleted

  @Commentary
  Scenario: TC_Commentary_84:Verify 'font size'
    And Add some text in the description field
    And Click on "Font Sizes" drop down
    And Choose font size as "12px"
    Then Text should be changed to "12px" size

  @Commentary
  Scenario: TC_Commentary_85:Verify 'Text color'
    And Add some text in the description field
    And Click on "Text color" drop down
    And Choose text color as "Red"
    Then The Text should be changed to "Red"

  @Commentary
  Scenario: TC_Commentary_86:Verify 'Background color'
    And Add some text in the description field
    And Click on "Background color" drop down
    And Choose background color as "Red"
    Then The Text should be changed to "Red"

  @Commentary
  Scenario: TC_Commentary_87:Verify Horizontal alignment (left, right, center)
    And Add some text in the description field
    And Choose alignment as "Align left"
    Then Title should align to "left"
    And Choose alignment as "Align right"
    Then Title should align to "right"
    And Choose alignment as "Align center"
    Then Title should align to "center"

  @Commentary
  Scenario: TC_Commentary_88:Verify Bullet list
    And Create Commentary visual
    And Enter data to description field
    And Click on "Bullet list"
    Then Choosed list should be displayed

  @Commentary
  Scenario: TC_Commentary_89:Verify Number list
    And Create Commentary visual
    And Enter data to description field
    And Click on "Numbered list"
    Then Choosed list should be displayed

  @Commentary
  Scenario: TC_Commentary_90:Verify Increase indent
    And Add some text in the description field
    And Click on "Increase indent"
    Then Selected text should be moved as per the selection

  @Commentary
  Scenario: TC_Commentary_91:Verify Bold format
    And Add some text in the description field
    And Click on "Bold"
    Then The text should be changed to "Bold"

  @Commentary
  Scenario: TC_Commentary_92:Verify Italic format
    And Add some text in the description field
    And Click on "Italic"
    Then The text should be changed to "Italic"

  @Commentary
  Scenario: TC_Commentary_93:Verify upload image
    And Create Commentary visual
    And Click on "Upload image"
    And Select image
    Then Selected image should be uploaded

  @Commentary
  Scenario: TC_Commentary_94:Right click - Verify Copy commentary
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Copy commentary"
    Then Commentary should be copied to clipboard

  @Commentary
  Scenario: TC_Commentary_95:Right click - Validate copied commentary
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Copy commentary"
    And Paste in insight
    Then Commentary visual should be pasted

  @Commentary
  Scenario: TC_Commentary_96:Right click - Verify Cut commentary
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Cut commentary"
    Then Commentary should be cut

  @Commentary
  Scenario: TC_Commentary_97:Right click - Validate Cut commentary
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Cut commentary"
    And Paste in insight
    Then Commentary visual should be pasted

  @Commentary
  Scenario: TC_Commentary_98:Right click - Verify Delete commentary
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Delete commentary"
    Then Commentary should be deleted

  @Commentary
  Scenario: TC_Commentary_99:Right click - Verify chart under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Chart"
    Then "Chart" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_100:Right click - Verify map under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Map"
    Then "Map" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_101:Right click - Verify table under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Table"
    Then "Table" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_102:Right click - Verify pie under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Pie"
    Then "Pie" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_103:Right click - Verify Heat map under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Heat map"
    Then "Heat map" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_104:Right click - Verify Histogram under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Histogram"
    Then "Histogram" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_105:Right click - Verify Attachments under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Attachments"
    Then "Attachments" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_106:Right click - Verify Commentary under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Commentary"
    Then The commentary visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_107:Right click - Verify image under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Image"
    Then "Image" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_108:Right click - Verify Filter under insert visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Insert visual as "Filter"
    Then "Filter" visual should be created in the same view tab

  @Commentary
  Scenario: TC_Commentary_109:Right click - Verify Paste visual
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Copy commentary"
    And Again Right click on visual header
    And Choose "Paste visual"
    Then Copied visual should be pasted

  @Commentary
  Scenario: TC_Commentary_110:Right click - Verify 'Clear contents'
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Clear contents"
    Then All the contents should be removed from the visual

  @Commentary
  Scenario: TC_Commentary_111:Right click - Verify Download subdropdown
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose "Download"
    Then "Commentary , View" options should be displayed

  @Commentary
  Scenario: TC_Commentary_112:Right click - Download - Verify commentary
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Download as "Commentary"
    Then Download popup should be appeared with "Commentary" tab selection

  @Commentary
  Scenario: TC_Commentary_113:Right click - Download - Verify View
    And Add some text in the description field
    And Get the text from the description field
    And Right click on visual header
    And Choose Download as "View"
    Then Download popup should be appeared with "Views" tab selection

  @Commentary
  Scenario: TC_Commentary_114:Verify OK button in delete confirmation popup
    And Add some text in the description field
    And Click on "delete"
    And Click on "Ok"
    Then The visual should be deleted

  @Commentary
  Scenario: TC_Commentary_115:Verify Cancel/x icon in delete confirmation popup
    And Add some text in the description field
    And Click on "delete"
    And Click on "Cancel"
    Then The popup should be closed and delete visual process should be declined

  @Commentary
  Scenario: TC_Commentary_116:Verify 'Save as' OR Copy for an insight having all type of visuals
    And Create all visuals in an insight
    And Perform "Save as"
    Then The insight should be copied successfully

  @Commentary
  Scenario: TC_Commentary_117:Verify 'Share' for insight having all type of visuals
    And Create all visuals in an insight
    And Perform Share
    Then Share popup should be opened

  @Commentary
  Scenario: TC_Commentary_118:Verify Download insight having all type of visuals
    And Create all visuals in an insight
    And Perform download to excel with all views
    Then All visuals should be downloaded successfully

  @Commentary
  Scenario: TC_Commentary_119:Verify 'Delete' insight having all type of visuals
    And Delete the created insight with all visuals
    Then The insight should be deleted successfully
