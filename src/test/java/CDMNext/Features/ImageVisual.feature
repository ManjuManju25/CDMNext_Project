Feature: Verifying Image visual functionality

  @ImageVisual
  Scenario: Tc_ImageVisual_1 : Verify creating filter visual
    And Go to View tab
    And Click on insert Image visual icon
    Then "Image" visual should be created

  @ImageVisual
  Scenario: Tc_ImageVisual_2 : Verify copy-paste of image visual
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Copy icon
    And Paste to new insight
    Then The image visual should be pasted to new insight

  @ImageVisual
  Scenario: Tc_ImageVisual_3 : Verify content present in the image visual
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    Then Below optins should be displayed
      | Add to insight     |
      | Copy               |
      | Download. Type `d` |
      | Open               |
      | Delete             |

  @ImageVisual
  Scenario: Tc_ImageVisual_4 : Verify content present in the image visual
    And Go to View tab
    And Click on insert Image visual icon
    Then Below optins should be available
      | Upload image      |
      | Insert/edit image |
      | Fit to width      |
      | Align left        |
      | Align center      |
      | Align right       |

  @ImageVisual
  Scenario: Tc_ImageVisual_5 : Add to insight - Verify 'Add to new tab' option under Add to insight
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on + icon on header
    And Click on "Add to new tab"
    Then The image visual should be pasted in vew tab on current insight

  @ImageVisual
  Scenario: Tc_ImageVisual_6 : Verify adding image visual to another insight
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on + icon on header
    And Click on "Add to new insight"
    Then "New insight with the selected visual created" and "Go to new insight" confirmation message should be displayed
    And Click on "Go to new insight"
    Then The image visual should be added to new insight

  @ImageVisual
  Scenario: Tc_ImageVisual_7 : Verify expanding image visual
    And Go to View tab
    And Click on insert Image visual icon
    And Click on Open icon
    Then The visual should be displayed in maximized window

  @ImageVisual
  Scenario: Tc_ImageVisual_8 : Verify closing of maximized window
    And Go to View tab
    And Click on insert Image visual icon
    And Click on Open icon
    And Click on x icon to close
    Then The modal window should be closed

  @ImageVisual
  Scenario: Tc_ImageVisual_9 : Verify copy-paste and add to insight icon working in expanded image visual window
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Open icon
    And Click on + icon on header
    And Click on "Add to new insight"
    And Click on "Go to new insight"
    Then The image visual should be added to new insight

  @ImageVisual
  Scenario: Tc_ImageVisual_10 : should allow to paste in on other view tabs in expanded image visual window
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Open icon
    And Click on Copy icon
    And Paste within the insight
    Then The image visual should be pasted in the other view tab

  @ImageVisual
  Scenario: Tc_ImageVisual_11 : Verify changing title of the image
    And Go to View tab
    And Click on insert Image visual icon
    And Mouse hover on visual title
    And Click on edit icon
    Then The title popup should be appeared
    And Check the box for the title name
    And Edit the title name as "ImageVisual"
    Then The title name should reflect on the Image

  @ImageVisual
  Scenario: Tc_ImageVisual_12 : Verify naming subtitle of the image visual
    And Go to View tab
    And Click on insert Image visual icon
    And Mouse hover on visual title
    And Click on edit icon
    Then The title popup should be appeared
    And Check the box and enter the sub-title name as "New subtitle"
    Then The subtitle should update as "New subtitle"

  @ImageVisual
  Scenario: Tc_ImageVisual_13 : Verify changing title of the image in the Edit Visual Title popup
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
    And Mouse hover on Edit Visual title and click on it
    And Check the box for the title name
    And Edit the title name as "ImageVisual"
    Then The title name should reflect on the Image

  @ImageVisual
  Scenario: Tc_ImageVisual_14 : Verify changing subtitle of the image in the Edit Visual Title popup
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Check the box and enter the sub-title name as "New subtitle"
    Then The subtitle should update as "New subtitle"

  @ImageVisual
  Scenario: Tc_ImageVisual_15 : Verify title text color
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Check the box for the title name
    And Choose text color is blue
    Then The Image visual should update the "title" text color as blue

  @ImageVisual
  Scenario: Tc_ImageVisual_16 : Verify highlight color
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Check the box for the title name
    And Choose highlight color is Orange
    Then The Image visual should update the "title" highlight color as Orange

  @ImageVisual
  Scenario: Tc_ImageVisual_17 : Verify 'font size'
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Check the box for the title name
    And Choose "20" from the drop-down for the font size
    Then The Image visual should update the "title" font as "20"

  @ImageVisual
  Scenario: Tc_ImageVisual_18 : Verify title in bold style
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Click on Bold icon for "title"
    Then The visual "title" should be in bold style

  @ImageVisual
  Scenario: Tc_ImageVisual_19 : Verify title in Italic style
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Check the box for the title name
    And Click on Italic under style
    Then The visual "title" should be "italic"

  @ImageVisual
  Scenario: Tc_ImageVisual_20 : Verify title as underlined
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Check the box for the title name
    And Click on Underline icon for "title"
    Then The visual "title" should be "underline"

  @ImageVisual
  Scenario: Tc_ImageVisual_21 : Verify horizontal alignment (left, right, center)
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Check the box for the title name
    And Click on left,center and right alignment for title
    Then The title should align to "left" , "center" and "right" as user set

  @ImageVisual
  Scenario: Tc_ImageVisual_22 : Verify Sub-title text color
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Choose text color is blue for subtitle
    Then The Image visual should update the "sub_title" text color as blue

  @ImageVisual
  Scenario: Tc_ImageVisual_23 : Subtitle > Verify highlight color
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Choose highlight color is Orange for subtitle
    Then The Image visual should update the "sub_title" highlight color as Orange

  @ImageVisual
  Scenario: Tc_ImageVisual_24 : Subtitle > Verify 'font size'
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Choose "10" from the drop-down for the font size of subtitle
    Then The Image visual should update the "sub_title" font as "10"

  @ImageVisual
  Scenario: Tc_ImageVisual_25 : Verify Subtitle in bold style
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Click on B under style for sub-title
    Then The visual "sub_title" should be in bold style

  @ImageVisual
  Scenario: Tc_ImageVisual_26 : Verify Subtitle in Italic style
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Click on Italic under style for sub-title
    Then The visual "sub_title" should be "italic"

  @ImageVisual
  Scenario: Tc_ImageVisual_27 : Verify Subtitle as underlined
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Click on Underline icon for sub-title
    Then The visual "sub_title" should be "underline"

  @ImageVisual
  Scenario: Tc_ImageVisual_28 : Verify horizontal alignment (left, right, center) of sub_title
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Click on left,center and right alignment for sub_title
    Then The sub_title should align to "left" , "center" and "right" as user set

  @ImageVisual
  Scenario: Tc_ImageVisual_29 : Verify closing of titles popup
    And Go to View tab
    And Click on insert Image visual icon
    #And Click on title dropdown
     And Mouse hover on Edit Visual title and click on it
    And Click on X icon to close the popup
    Then The "Title" popup should be closed

  @ImageVisual
  Scenario: Tc_ImageVisual_30 : Verify Download option
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    Then Download popup should be appeared

  @ImageVisual
  Scenario: Tc_ImageVisual_31 : Verify visual download to xlsx format
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "xlsx" format
    And Click on "Download"
    Then The tab name should be "Image"

  @ImageVisual
  Scenario: Tc_ImageVisual_32 : Verify visual download to PDF format
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "pdf" format
    And Click on "Download"
    Then Image should be downloaded in "pdf" format

  @ImageVisual
  Scenario: Tc_ImageVisual_33 : Verify visual download to PNG format
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "png" format
    And Click on "Download"
    Then Image should be downloaded in "PNG" format

  @ImageVisual
  Scenario: Tc_ImageVisual_34 : Verify image visual download with other visuals to xlsx format
    And Create histogram visual with series
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "Views" tab
    And Select "xlsx" format
    And Click on "Download"
    Then Image should be downloaded in "xlsx" format

  @ImageVisual
  Scenario: Tc_ImageVisual_35 : Verify image visual download with other visuals to pdf format
    And Create histogram visual with series
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "Views" tab
    And Select "pdf" format
    And Click on "Download"
    Then Image should be downloaded in "pdf" format

  @ImageVisual
  Scenario: Tc_ImageVisual_36 : Verify uploading multple image in one image visual
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Try to Upload multiple images
    Then Should allow to add multiple images

  @ImageVisual
  Scenario: Tc_ImageVisual_37 : Verify edit/insert image popup for general tab
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Insert/edit image" icon
    Then Below options should be available in General tab
      | Source      |
      | Image Title |
      | Width       |
      | Height      |

  @ImageVisual
  Scenario: Tc_ImageVisual_38 : Verify edit/insert image popup for upload tab
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Insert/edit image" icon
    And select uplod tab
    Then Below options should be available in Upload tab
      | Browse for an image |
      | Drop an image here  |

  @ImageVisual
  Scenario: Tc_ImageVisual_39 : Verify browsing image in edit/insert image popup
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Insert/edit image" icon
    And select uplod tab
    And Click on "Browse for an image"
    Then Image should be uploaded in view tab

  @ImageVisual
  Scenario: Tc_ImageVisual_40 : Verify cross mark for edit/insert image
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Insert/edit image" icon
    And click on cross mark button
    Then Window should be closed

  @ImageVisual
  Scenario: Tc_ImageVisual_41 : Verify general tab options in edit/insert image popup
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Insert/edit image" icon
    And Enter Source as "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg"
    And Enter Image Title as "ImageVisual"
    And Enter Dimensions as 200 and 200
    Then Image should be uploaded in view tab with given details

  @ImageVisual
  Scenario: Tc_ImageVisual_42 : Verify alignment for image visuals
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on "Align left","Align center" and "Align right" alignment for image visual
    Then The image visual should align to "left" , "center" and "right" as user set

  @ImageVisual
  Scenario: Tc_ImageVisual_43 : Verify download window for image visual with other visuals
    And Go to View tab
    And Create a Chart visual
    And Add a series to the chart visual
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "Views" tab
    And Select timeframe as "Sample"
    And Select Data placement as "Rows"
    And Click on "Download"
    Then Image with visuals should be downloaded with selected timeframe and data placement

  #@ImageVisual1... can't drag and drop in automation
  #Scenario: Tc_ImageVisual_44 : Verify moving image visula inside the view tab
    #And Go to View tab
    #And Create a Chart visual
    #And Add a series to the chart visual
    #And Click on insert Image visual icon
    #And Click on title dropdown
     #And Mouse hover on Edit Visual title and click on it
    #And Check the box for the title name
    #Then Visuals should be interchanged by drag and drop

  @ImageVisual
  Scenario: Tc_ImageVisual_45 : Verify image download as views (insight) pdf
    And Go to View tab
    And Create a Chart visual
    And Add a series to the chart visual
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "Views" tab
    And Select "pdf" format
    And Click on "Download"
    Then Image should be downloaded in "pdf" format

  @ImageVisual
  Scenario: Tc_ImageVisual_46 : Verify visual download to JPG format
    And Go to View tab
    And Click on insert Image visual icon
    And Select "Upload image" icon
    And Upload any image
    And Click on Download icon
    And Select "jpeg" format
    And Click on "Download"
    Then Image should be downloaded in "JPG" format
