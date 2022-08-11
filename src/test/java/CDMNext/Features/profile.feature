Feature: profile feature

  @profile
  Scenario: TC_01: Verify user profile dropdown
    And Open preference dropdown

  @profile
  Scenario: TC_02: Verify user name
    # And Click on user profile icon
    And Open preference dropdown
    And Verifyed first name and last name

  @profile
  Scenario: TC_03: Verify Prefix under user Profile and Verify applied prefix
    And Open preference dropdown
    And click on pencile button
    And select the prefix
    And click on save button

  #  And click on edit profile information icon
  #Then The updated prefix should show under preference
  @profile
  Scenario: TC_04 : Verify 'First name' field
    And Open preference dropdown
    And click on pencile button
    And update first name
    And click on save button

  @profile
  Scenario: TC_05:  Verify 'Last name' field
    And Open preference dropdown
    And click on pencile button
    And update Last name
    And click on save button

  @profile
  Scenario: TC_06: Verify First and last name field with blank and Verify validation message
    And Open preference dropdown
    #And click on pencile icon
    And click on pencile button
    And blank the first name filed
    And blank the last name field
    # And click on save
    And click on save button
    And validations should be display

  @profile
  Scenario: TC_07: Verify adding non-English names in first and last name fields
    And Open preference dropdown
    And click on pencile button
    And User enter First as "sdjhfjksdhfjk" and Last name as "uioerywuierywe"
    And click on save button
    And Open preference dropdown
    And Should allow non english keywords and changes should be saved.

  @profile
  Scenario: TC_08:Verify user first and last name under profile picture
    And Open preference dropdown
    And click on pencile button
    And user enter first name as "Testing"
    And enter last name as "Automation"
    And enter job title
    And click on save button
    And Open preference dropdown
    Then User changes should be reflected under profile picture after saved

  #@test
  #Scenario: TC_07:Verify adding non-English names in first and last name fields
  #And Open preference dropdown
  #And click on pencile button
  #And User enter First as "sdjhfjksdhfjk" and Last name as "uioerywuierywe"
  #And click on save button
  @profile
  Scenario: TC_09: Validate "E-mail" field under Profile
    And Open preference dropdown
    And click on pencile button
    And click on Email filed

  # And E-mail ID should be pre-exist in non editable mode
  @profile
  Scenario: TC_10: Verify Save button
    And Open preference dropdown
    And click on pencile button
    And enter first name as "Testings"
    And click on save button
    And Open preference dropdown
    And The changes in the profile section should be saved.

  @profile
  Scenario: TC_11: Verify Cancel/X buttons
    And Open preference dropdown
    And click on pencile button
    And enter last name as "Automation"
    And click on Cancel button
    And The changes should be canceled

  @profile
  Scenario: TC_12: Validate "Profile picture"
    And Open preference dropdown
    And Click on upload image
    And Click on the Upload button to upload "Image"
    Then The image should upload successfully

  @profile
  Scenario: TC_13: Verify "Profile picture" uploading with max size
    And Open preference dropdown
    And Click on upload image
    And Click on the upload "Large Images"
    Then "Max avatar size is 1Mb" error message should be displayed
    And Open preference dropdown

  @profile
  Scenario: TC_14: Verify different types of files upload
    And Open preference dropdown
    And Click on upload image
    And Click on the upload "Videos"
    Then "Avatar could be .jpg, .jpeg or .png" error message should be displayed
    And Open preference dropdown

  @profile
  Scenario: TC_15: Verify Old password field
    And Open preference dropdown
    And Click on Change password button
    And Enter the old password as "Ceic@123"
    And click on save button

  @profile
  Scenario: TC_16: Verify validation message for old password wrong entered
    And Open preference dropdown
    And Click on Change password button
    And Enter the old password as "Ceic@1234abc"
    And Enter the New password as "Ceic@12345678"
    And Enter the Retype new password as "Ceic@12345678"
    And click on save button
    Then "Incorrect current password" message needs to appear

  @profile
  Scenario: TC_17: Verify New and retype password field
    And Open preference dropdown
    And Click on Change password button
    And Enter the old password as "Ceic@123"
    And Enter the New password as "Ceic@12345678"
    And Enter the Retype new password as "Ceic@12345678"
    And click on save button
    Then "Your password has been successfully changed" message needs to appear

  @profile
  Scenario: TC_18: Verify validation message for password mismatch
    And Open preference dropdown
    And Click on Change password button
    And Enter the old password as "Ceic@123"
    And Enter the New password as "Ceic@12345678"
    And Enter the Retype new password as "Ceic@123456789"
    And click on save button
    Then "Password repeat must be the same as New Password" message needs to appear

  @profile
  Scenario: TC_19: Verify Save button
    And Open preference dropdown
    And Click on Change password button
    And "Change password" popup should appear
    And Enter the password "Old password" as "Ceic@12345678"
    And Enter the password "New password" as "Ceic@123456789"
    And Enter the password "Retype new password" as "Ceic@1234567890"
    And click on save button
    And Open preference dropdown
    And Click on Change password button
    And Close the dialog popup

  @profile
  Scenario: TC_20: Verify Cancel button
    And Open preference dropdown
    And Click on Change password button
    And "Change password" popup should appear
    And Enter the password "Old password" as "Ceic@12345678"
    And Click on X button
    And Open preference dropdown
    And Click on Change password button
    And Close the dialog popup

  @profile
  Scenario: TC_21: Verify swich languages and selected language at first place after applied
    And Open preference dropdown
    And click on select language as "中文"
    Then UI interface shoud be loaded for selected language
    And Open preference dropdown
    And Selected language should be displayed first place
    And click on Language as 'English'

  #@test
  #Scenario:TC_21: Verify the selected language at first place after applied
  #And Open preference dropdown
  #And Selected language should be displayed first place
  #And click on Language as 'English'
  #
  #@test
  #Scenario:TC_21: Verify the selected language at first place after applied
  #And Open preference dropdown
  # And click on select language as "中文"
  # And Open preference dropdown
  #And selected language should be listed at first place
  #And Open preference dropdown
  #And click on select language as "English"
  #And Select "English" as language
  #And Wait for the language to update
  @profile
  Scenario: TC_22: Verify default number formats
    And Open preference dropdown
    And Click on dropdown for number format

  @profile
  Scenario: TC_23: Verify Number separators-Decimal Places
    And Open preference dropdown
    And Click on dropdown for number format
    And change a Decimal place as "5"
    And Refresh page
    And Open preference dropdown
    And Get Value of "Decimal separator" in Number format
    # And Refresh page
    #And click on series Tab
    And search a series id as"238426803"
    And click on series Tab
    And click on series name
    # And Open SSP for the selected series
    #And Click on "Data" tab
    # And Capture the Timepoint value inside "SSP" tab
    #Then Check the data in the insight for "Decimal separator"
    #And SSP popup should be display
    And click on data tab
    And copy the Timepoint value inside data tab
    Then Decimal place and timepoint value should be same

  @profile
  Scenario: TC_24: verify Number formate-Decimal separater
    And Open preference dropdown
    And Click on dropdown for number format
    And click on decimal separator comma
    And Refresh page
    And Open preference dropdown
    And Click on dropdown for number format
    And get the value of Decimal separater
    And Refresh page
    And click on series Tab
    And search a series id as"238426803"
    And click on series name
    And click on data tab
    And copy the timepoints from data tab
    Then demial separater and timepoint value same

  @profile
  Scenario: TC_25: Verify Number format - Grouping separator
    And Open preference dropdown
    And Click on dropdown for number format
    And click on Grouping separator
    And Refresh page
    And Open preference dropdown
    And Click on dropdown for number format
    And get the value the of grouping separator
    # And Refresh page
    And click on series Tab
    And search a series id as "257892603"
    And click on particular series name
    And click on data tab
    And get the timepoints from data tab
    Then Grouping separator and timepoint value same

  @profile
  Scenario: TC_26:Verify default Date format
    And Open preference dropdown
    And Date format "Auto" and "DD/MM/YYYY" formate default display

  @profile
  Scenario: TC_27:Verify Date Format - Auto
    And Open preference dropdown
    And Click on dropdown Auto
    And select date format in Auto dropdown
    And click on series Tab
    And click on series
    # And click on data tab
    And Updated date format display in SSP
    Then Only selected Date format should be displayed in entire CDMNext

  @profile
  Scenario: TC_28:Verify Date Format - Custom
    And Open preference dropdown
    And Click on dropdown Auto
    And checked custom radio button
    And click on series Tab
    And click on series
    And Updated date format display in SSP
    Then Only selected Date format should be displayed in entire CDMNext

  @profile
  Scenario: TC_29:Verify Date Format - Verify invalid format entry in custom field
    And Open preference dropdown
    And Click on dropdown Auto
    And select custom radio button
    # Click "Custom" format date option
    And verified "Invalid date format. Please enter a valid format" message should be displayed in red color

  @profile
  Scenario: TC_30:Verify Date Format - Verify saving with empty date format
    And Open preference dropdown
    And Click on dropdown Auto
    And checked radio custom button
    Then 'Custom date pattern cannot be empty' message displayed in red color.

  @profile
  Scenario: TC_31:Verify Timeframe for last observations
    And Open preference dropdown
    And get the value of Timeframe
    And click on series Tab
    And select any one series
    Then Only selected observations should be displayed for visuals in all insights and also in download popup

  @profile
  Scenario: TC_32: Preferences - Verify 'Ask me to confirm the download settings' - Checked
    And Open preference dropdown
    And checked on "Ask me to confirm the download settings"
    And click on series Tab
    And select some series
    And Click on Download button in header
    And Download popup display
    # And Check for "Download" popup
    Then "Download settings" window should be "appeared" and selected series count display

  @profile
  Scenario: TC_33:Verify 'Ask me to confirm the download settings' - Unchecked.
    And Open preference dropdown
    And unchecked on Ask me to confirm the download settings
    And click on series Tab
    And select some series
    And Click on Download button in header
    And Download settings window should not be displayed and directly download with saved settings.

  @profile
  Scenario: TC_34:Verify the case for Download window appered even download settings unchecked
    And Open preference dropdown
    # And unselect the Ask me to confirm the download settings
    And click on series Tab
    And select some series
    And Right Click on selected series
    And Download popup display
    Then Download settings window should be appeared even unchecked in preference.

  @profile
  Scenario: TC_35:Verify unchecking 'Ask me to confirm the download settings' in download popup
    And Open preference dropdown
    And click on series Tab
    And select some series
    And Click on Download button in header
    And Download popup display
    And Uncheck 'Ask me to confirm the download settings' checkbox
    And click on download button
    And Open preference dropdown
    Then The 'ask me to confirm the download settings' option should be unchecked

  @profile
  Scenario: TC_36:Verify 'Ask me to confirm visual deletion' - Checked
    And Open preference dropdown
    And click on series Tab
    And select some series
    And Right click on and click on 'view as chart'
    And click on delete button in visual insight
    #And Do you want to remove this visual popup should be display
    Then Deletion confirmation message should be dispalyed for visual delete

  @profile
  Scenario: TC_37:Verify 'Ask me to confirm visual deletion' - Unchecked
    And Open preference dropdown
    And uncheck the 'Ask me to confirm visual deletion'
    And click on series Tab
    And select some series
    And Right click on and click on 'view as chart'
    And click on delete button in visual insight
    Then Deletion confirmation message should not be displayed to users while deleting visuals.

  @profile
  Scenario: TC:38:Verify 'Show latest changes in my insight upon opening'- Checked
    And Open preference dropdown
    And click on 'more' button and checked 'With suggestions for rebased/discontinued series'
    And click on series Tab
    And select some series
    And series added into myseries
    And click on 'My Insights'
    And click on 'customize'
    Then Replacement popup should be displayed

  @profile
  Scenario: TC_39:Verify 'Show latest changes in my insight' - Unchecked
    #  And cancel the 'X' button
    And Open preference dropdown
    And uncheck the 'Show latest changes in my insights upon opening'
    And click on 'more' button and checked 'With suggestions for rebased/discontinued series'
    And click on series Tab
    And select some series
    And series added into myseries
    And click on 'My Insights'
    And click on 'customize'
    Then The Replacement popup should not be displayed to user

  # And Open preference dropdown
  #Then check the 'Show latest changes in my insights upon opening'
  @profile
  Scenario: TC_40:Verify Unchecking checkbox in replacement popup
    And Open preference dropdown
    And checked the 'Show latest changes in my insights upon opening'
    And click on 'more' button and checked 'With suggestions for rebased/discontinued series'
    And click on series Tab
    And select some series
    And series added into myseries
    And click on 'My Insights'
    And click on 'customize'
    And Check the checkbox for 'Do not show again' on replacement popup
    And Open preference dropdown
    Then The Replacement popup should not be displayed to user and should be unchecked under preference as well

  @profile
  Scenario: TC_41:Verify 'Preserve search selection after Download/CTC actions' - Checked
    And Open preference dropdown
    And click on series Tab
    And select some series
    And Click on Download button in header
    And click on download button
    Then The Series should be selected in search panel after done download actions

  @profile
  Scenario: TC_42:Verify 'Preserve search selection after Download/CTC actions' - Unchecked
    And Open preference dropdown
    And uncheck the 'Preserve search selection after download/CTC actions'
    And click on series Tab
    And select some series
    And Click on Download button in header
    And click on download button
    Then selected series should be unselected after done download/CTC actions.

  @profile
  Scenario: TC_43:Verify 'Preserve the order of selection when adding/downloading series' - Checked
    And Open preference dropdown
    And click on series Tab
    And Select series in your order
    Then The order of series should not be changed when adding/downloading series.and Add to insight

  @profile
  Scenario: TC_44:Verify 'Preserve the order of selection when adding/downloading series' - Unchecked
    And Open preference dropdown
    And uncheck the Preserve the order of selection when adding/downloading series
    And click on series Tab
    And Select series in your order
    And Series can be changed the order of display series when adding/downloading

  @profile
  Scenario: TC_45:Verify 'Show search result without pagination' - Unchecked
    And Open preference dropdown
    And click on series Tab
    And Series tab should list the series in page view and the data pages should be available as 1,2,3,....next

  @profile
  Scenario: TC_46:Verify 'Show search result without pagination' - Checked
    And Open preference dropdown
    And checked the Show search results without pagination
    And click on series Tab
    And Series should be displayed as list and more series can be viewed by scrolling bar

  @profile
  Scenario: TC_47:Vierify 'Show system suggestion when working with visuals' - Checked
    #And delete series in myseries
    And Open preference dropdown
    And click on series Tab
    # And Remove series in myseries
    # And select some series
    And selected series added into my series
    # And click on "View as Chart"
    Then "Chart suggestion" popup should be appeared

  @profile
  Scenario: TC_48:Vierify 'Show system suggestion when working with visuals' - Unchecked
    And Open preference dropdown
    And unchecked the 'Show system suggestion when working with visuals'
    And click on series Tab
    #And select some series
    And selected series added into my series
    #And selected series added into my insights
    And click on "View as Chart"
    Then "Chart suggestion" popup should not be appeared

  @profile
  Scenario: TC_49:Verify checking checkbox 'Do not show again' on Chart suggestion popup
    And Open preference dropdown
    And checked the 'Show system suggestion when working with visuals'
    And click on series Tab
    And selected series added into my series
    # And selected series added into my insights
    #And click on "View as Chart"
    And checked checkbox 'Do not show again'
    And Open preference dropdown
    Then The 'Show system suggestion…' checkbox should be uncheck under profile

  @profile
  Scenario: TC_50:Copyright -Verify Show copyright=Checked.
    And Open preference dropdown
    And click on Change style sheet
    And show copyright checkbox default checked
    And click on series Tab
    And select some series
    And add to some series into insights
    Then The image copyright should applied to new and existing visuals.

  @profile
  Scenario: TC_51:Copyright - Verify default image copyright
    And Open preference dropdown
    And click on Change style sheet
    # And checked show copyright textbox
    And image default copyright
    And click on series Tab
    And select some series
    And add to some series into insights
    Then image copyright should be applied to new and existing visuals

  @profile
  Scenario: TC_52:Copyright - Verify custom image copyright
    And Open preference dropdown
    And click on Change style sheet
    And click on upload copyright image
    And click on series Tab
    And select some series
    And add to some series into insights
    Then Uploaded image should be displayed as copyright image

  @profile
  Scenario: TC_53:Verify removing custom image copyright
    And Open preference dropdown
    And click on Change style sheet
    # And click on upload copyright image
    Then user uploaded image removed

  @profile
  Scenario: TC_54:Copyright - Verify default link for image copyright
    And Open preference dropdown
    And click on Change style sheet
    And Observe Link field as "https://www.ceicdata.com/en"

  @profile
  Scenario: TC_55:Copyright - Verify position for image copyright
    And Open preference dropdown
    And click on Change style sheet
    And select position for image copyright
    And click on series Tab
    And select some series
    And add to some series into insights
    Then The image copyright should applied to new and existing visuals.

  #Then The image copyright should be displayed to selected position
  @profile
  Scenario: TC_56:Copyright - Verify text copyright
    And Open preference dropdown
    And click on Change style sheet
    And click on "Text" radio button
    And click on series Tab
    And select some series
    And add to some series into insights
    Then Text copyright should be displayed as "Source: CEIC Data"

  @profile
  Scenario: TC_57:Copyright - Verify link for text copyright
    And Open preference dropdown
    And click on Change style sheet
    #And click on "Text" radio button
    And Observe Link field as "https://www.ceicdata.com/en"
    Then The default link should be "https://www.ceicdata.com/en"

  @profile
  Scenario: TC_58:Copyright - Verify text size
    And Open preference dropdown
    And click on Change style sheet
    And change text size
    And click on series Tab
    And select some series
    And add to some series into insights
    Then The text size should apply as selected

  @profile
  Scenario: TC_59:Copyrigh - Verify text style
    And Open preference dropdown
    And click on Change style sheet
    And Change text style- Bold
    And click on series Tab
    And select some series
    And add to some series into insights
    Then The applied style should be reflected on visual for copyright

  @profile
  Scenario: TC_60:Copyright - Verify color for Copyright text
    And Open preference dropdown
    And click on Change style sheet
    And click on color button and select color
    And click on series Tab
    And select some series
    And add to some series into insights
    Then The selected color should be applied to text copyright in visual

  @profile
  Scenario: TC_61:Copyright - Verify text position
    And Open preference dropdown
    And click on Change style sheet
    #And click on "Text" radio button
    And select position for image copyright
    And click on series Tab
    And select some series
    And add to some series into insights
    Then The text copyright should display in selected position

  @profile
  Scenario: TC_62:Copyright - Verify clicking on copyright on visuals
    And Open preference dropdown
    And click on Change style sheet
    And click on Type "image" on radio button
    #And click on "Text" radio button
    # And select position for image copyright
    And click on series Tab
    And select some series
    And add to some series into insights
    Then Should redirected to "https://www.ceicdata.com/en" in new tab

  @profile
  Scenario: TC_63:Copyright -Verify Show copyright=Unchecked
    And Open preference dropdown
    And click on Change style sheet
    And uncheck show copyright
    And click on series Tab
    And select some series
    And add to some series into insights
    Then Copyright should not be displayed for new and existing visuals.

  @profile
  Scenario: TC_64:Verify Keyboard Shortcut ON
    And Open preference dropdown
    And check the keyboard option ON
    And click on series Tab
    And select some series
    And Use Keyboard shortcut for creating visuals
    # And The "Keyboard Shortcut" action should be apply
    Then Should be allowed the keyboard shortcuts to function in CDMNext application

  @profile
  Scenario: TC_65:Verify Keyboard Shortcut OFF
    And Open preference dropdown
    And check the keyboard option OFF
    And click on series Tab
    And select some series
    And Use Keyboard shortcut for creating visuals
    Then The Keyboard shortcut should not work
    And Open preference dropdown
    And click on Keyboard option Default ON

  @profile
  Scenario: TC_66:Verify clicking on keyboard hints option
    And Open preference dropdown
    And click on keyboard hints
    And The keyboard shortcut hints popup should be opened

  @profile
  Scenario: TC_67:Verify excel add-in
    And Open preference dropdown
    And Clicking on "Excel Addin" option under user preference
    Then The "Applications Help" dialog box should open and "Excel Addin" is default

  @profile
  Scenario: TC_68:Verify Ceic API access
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    Then The "CEIC API Access" dialog box should open

  @profile
  Scenario: TC_69:CEIC API Access - Verify description message for API popup
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    Then The "You already have generated an API key. You can verify your API key here, or generate a new one to replace your previous key" message in dialog box should display

  @profile
  Scenario: TC_70: CEIC API Access - Verify the token field
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    Then Paste the token "m67OAcmiKECwT0W5jyMpL96gh16GfbvzR8ZF5JFYKf94MBaEfouKgqjteEuxyVlj82mc6KWxl6ZiYR1v9q52qDI5DdQNj7kVLPtoSihSyS9P5Ibbhode4oTIgNZ05iHe" to "Enable Verify Key" button

  @profile
  Scenario: TC_71:CEIC API Access - Verify the 'Verify key' button if token field is empty
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And dont paste the token as verify key textbox
    Then The Verify key button should be disabled untill enter token in the field

  @profile
  Scenario: TC_72:CEIC API Access - Validate the 'Verify key' button
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    And Copied API key is stored into a string
    And Click on "Verify Key " button from CEIC API access
    Then The "The key is valid" message should come in "#53b582" color

  @profile
  Scenario: TC_73:CEIC API Access - Verify message for invalid token enter
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And paste the invalid token as "m67OAcmiKECwT0W5jyMpL96gh16GfbvzR8ZF5JFYKf94MBaEfouKgqjteEuxyVlj82mc6KWxl6ZiYR1v9q52qDI5DdQNj7kVLPtoSihSyS9P5Ibbhode4oTIgNZ05iHe"
    And Click on "Verify Key " button from CEIC API access
    Then The "The key is invalid" message should come in "#ef5350" color

  @profile
  Scenario: TC_74: CEIC API Access - Verify 'Generate new key' button
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    Then The new token key should be generated

  @profile
  Scenario: TC_75: CEIC API Access - Verify 'Copy' button
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    Then Copied message should display

  @profile
  Scenario: TC_76: CEIC API Access - Validate copied token
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    And Copied API key is stored into a string
    Then Open the link in a new tab and verify

  @profile
  Scenario: TC_77: CEIC API Access - Verify message after copy token
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    And Click on Copy button from CEIC API access
    Then The "API key copied to clipboard" message should be displayed

  @profile
  Scenario: TC_78: CEIC API Access - Verify popup description after generated new token
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on Generate new key button from CEIC API access
    Then The description of CEIC API access popup should be "Your API key has been generated"

  @profile
  Scenario: TC_79: CEIC API Access -  Verify CEIC API Help option
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on "CEIC API Help" help button from CEIC API access
    And CEIC Help dialog box is opened
    Then The default tab should be "API"

  @profile
  Scenario: TC_80: CEIC API Access -  Verify Cancel/x icon
    And Open preference dropdown
    And Clicking on "CEIC API Access" option under user preference
    And The "CEIC API Access" dialog box should be open
    And Click on close button of CEIC API access dialog box
    Then The popup should be cancelled

  @profile
  Scenario: TC_81: Verify closing of Preference dropdown
    And Open preference dropdown
    And Open preference dropdown
    Then Preference dropdown should be closed

  @profile
  Scenario: TC_82:Verify Notification=ON
    And Open preference dropdown
    And click on 'My Insights'
    And click on 'customize'
    And click on file menu
    And click on share
    And Enter a mail into invite textbox
    And click on save
    And Open preference dropdown
    And click on Sign out button

  @profile
  Scenario: TC_82: Preference - Verify Sign out option
    And Select some series to my series tab
    And delete series in myseries
    And Open preference dropdown
    And click on Sign out button
