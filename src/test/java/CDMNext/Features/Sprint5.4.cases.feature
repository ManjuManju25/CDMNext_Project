Feature: Verify title for commentary visual by default.

  #-----------------------1-50 shankar -------------------------------------#
  @Sprint5_4
  Scenario: TC_20623_01 : Verify title for commentary visual by default.
    Given user creates a commentary visual.
    And check for visual title.

  @Sprint5_4
  Scenario: TC_21004_01 : Verify  PUT, PATCH, DELETE fields in Status page.
    Given user Navigates to status page "https://stage.ceicdata.com/status".
    And check HTTP Methods PUT, PATCH, DELETE.

  # Then  Status should be available and the status should be success always.
  @Sprint5_4
  Scenario: TC_20540_01 : Verify the 'Featured' tag in the table mode under analysis insights.
    Given user Navigates to Analysis insights
    And switch to table mode.
    Then check featured insights are displayed on top of the list.

  @Sprint5_4
  Scenario: TC_20910_01 :Verify search with SR code on Analysis insight.
    Given user Navigates to Analysis Tab.
    And Open any Insight having series
    And copy SR code=>Search Insight with SR code

  @Sprint5_4
  Scenario: TC_20575_01 : Verify the field for dynamic series selection for table visual in Invert mode.
    Given user creates a table visual with 10 series
    And change the table visual to invert mode from edit visual.
    And series selector is displayed=>select 4 series.
    Then only top 4 selected  series should be visible on the table visual.

  @Sprint5_4
  Scenario: TC_20575_02 : Verify the the series selector with adding/removing value.
    Given user creates a table visual with 10 series
    And change the table visual to invert mode from edit visual.
    And series selector is displayed.
    And select 3 series.
    Then The number of series entere in the series field should be displayed on the table visual.

  @Sprint5_4
  Scenario: TC_20575_03 : Verify default value for the series selection field.
    Given user creates a table visual with 10 series
    And change the table visual to invert mode from edit visual.
    And series selector is displayed with default value.

  @Sprint5_4
  Scenario: TC_20575_04 : Verify the series sorting when series selection is applied.
    Given user creates a table visual with 10 series
    And change the table visual to invert mode from edit visual.
    And series selector is displayed.
    And select 3 series.
    And click on Date Header.
    Then Calendar should be opened.

  @Sprint5_4
  Scenario: TC_20942_01 : Verify 'Full screen' on commentary visual.
    Given user creates a commentary visual.
    And type something.
    Then click on Full Screen.

  @Sprint5_4
  Scenario: TC_20942_02 : Verify removing the full screen for commentary visual.
    Given user creates a commentary visual.
    And type something.
    And remove full screen.

  @Sprint5_4
  Scenario: TC_20938_01 : Verify the link icon under commentary.
    Given user creates a commentary visual.
    And click on more icon.
    And click on Insert/Edit link icon.
    Then The Insert/Edit link popup should be opened.

  @Sprint5_4
  Scenario: TC_20938_02 : Verify the special character popup.
    Given user creates a commentary visual.
    And click on more icon.
    And click on Special character symbol.
    Then the special character popup should be opened.

  @Sprint5_4
  Scenario: TC_20938_03 : Verify search for a special character.
    Given user creates a commentary visual.
    And click on more icon.
    And click on Special character symbol.
    And search for a Special Character as $.
    Then searched special character should display.

  @Sprint5_4
  Scenario: TC_20938_04 : Verify the close button and icon in the special character popup.
    Given user creates a commentary visual.
    And click on more icon.
    And click on Special character symbol.
    And Popup is opened > Click on Close button/icon.

  @Sprint5_4
  Scenario: TC_20938_05 : Verify Blockquote symbol.
    Given user creates a commentary visual.
    And click on more icon.
    And click on BlockQuote icon=>Type something
    Then the blockquote should be applied.

  @Sprint5_4
  Scenario: TC_20946_01 : Verify opening rename popup by double clicking on View.
    Given user double clicks on view Tab
    And rename popup should be displayed for view.

  @Sprint5_4
  Scenario: TC_20617_01 : Verify default attributes for table visual.
    Given user creates a Table visual.
    #And check the default attributes.
    And check the  default attributes  'Name, Region, Unit, Series ID, Frequency' should be present.

  @Sprint5_4
  Scenario: TC_20873_01 : Verify save the selection state for sort by under My series.
    Given user Adds some series into my series
    And sort by any option.
    And switch to any tab and select myseries again.
    Then the user saved status should saved even refresh the insight.

  @Sprint5_4
  Scenario: TC_20618_02: Verify date pickers.
    Given user creates a Histogram visual
    And clicks on Date Picker.
    Then Calendar should be opened.

  @Sprint5_4
  Scenario: TC_20618_03: Select date from the date picker.
    Given user creates a Histogram visual
    And clicks on Date Picker.
    Then selected period should be applied to histogram visual.

  @Sprint5_4
  Scenario: TC_20670_01: Verify the full path to the indicator selection.
    Given user clicks on Open Indicator filter.
    And select Real GDP=>Apply
    And hover the mouse on the selected indicator=>full path should display.

  @Sprint5_4
  Scenario: TC_20670_02: Verify the full path to the Region selection.
    Given user clicks on Open Region filter.
    And select Subnational=>Banglore as a city
    And hover the mouse on the selected Region=>full path should display.

  @Sprint5_4
  Scenario: TC_20731_01 : Verify tooltip for Help menu.
    Given user Hovers the mouse on Help Icon.

  @Sprint5_4
  Scenario: TC_20919_01 : Verify description for import series popup.
    Given user clicks on open import series popup
    Then check Description.

  @Sprint5_4
  Scenario: TC_20839_01: Verify 'On Demand' status on series.
    And Login back to internal user with user "svenkatraju" and password "z0lfdt?Dkjlm"
    And Search for on demand series '377135117'
    And Open SSP window.
    Then On Demand status should be available for such series.

  @Sprint5_4
  Scenario: TC_20587_01 : Verify spell checker for Commentary visual.
    Given user creates a commentary visual.
    And type some lines with incorrect words.
    Then the  spell checker should be detect incorrect words in the Commentary visual.

  @Sprint5_4
  Scenario: TC_17894_01 : Verify Move visual when the visual title is removed.
    Given user creates multiple visuals in single views.
    Then should be able to move the visual.

  #@Sprint5_4
  #Scenario: TC_20501_01 : Verify series drag and drop in Edit series panel.
  #Given user creates a visual with some series.
  #And open edit Series
  #And Drag and Drop Series.
  #Then series should be placed where drag and droped.
  #@Sprint5_4
  #Scenario: TC_20501_02 : Verify series drag and drop in Edit visual > Edit series panel
  #Given user creates a visual with some series.
  #And open edit visual=>EditSeries Panel.
  #And Drag and Drop Series.
  #Then series should be placed where drag and droped.
  @Sprint5_4
  Scenario: TC_20534_01 : Verify preserve state when switching between My series/Views.
    Given user Add some series and Table to My Series
    And Expand Table
    Then switch to view and come back to my series=>changes shouuld be preserved.

  @Sprint5_4
  Scenario: TC_20875_01: Verify case-insensitive search by User series ID and Category.
    Given user import a UDD series.
    #And check the imported series is displayed on the top of all UDD series.
    And search UDD Series with attributes like UserId and Category.

  @Sprint5_4
  Scenario: TC_21006_01: Verify Download for User data template.
    Given user clicks on open import series popup
    And click on Hyperlink CEIC Data Template.

  @Sprint5_4
  Scenario: TC_20956_01: Verify the latest uploaded UDD series on top of the list.
    Given user import a UDD series.
    And check the imported series is displayed on the top of all UDD series.

  @Sprint5_4
  Scenario: TC_20848_01: Verify UDD attributes for Download/CTC.
    Given user import a UDD series.
    And Download attributes to excel

  @Sprint5_4
  Scenario: TC_21006_02: Verify importing series with all attributes from CDMNext template.
    Given user import a UDD series.
    And The series should be imported successfully and should available under Imported tab.

  @Sprint5_4
  Scenario: TC_21006_03: Verify uploading already imported CDMNext template.
    Given user import a UDD series.
    And Import from CDM Next and Import File again.

  @Sprint5_4
  Scenario: TC_20884_03: Verify remove series icon for other than creator.
    Given user import a UDD series.
    And The series should be imported successfully and should available under Imported tab.
    And to other account  with user "shankar@gmail.com" and password "Ceic@123"
    And hover the mouse on imported series from user1

  @Sprint5_4
  Scenario: TC_20856_01: Verify confirmation growl when user data file is imported
    Given user import a UDD series.
    And The growl popup should display as series imported.

  @Sprint5_4
  Scenario: TC_20919_02 : Verify Note in the Import series popup.
    Given user clicks on open import series popup
    Then check Note  Description.

  @Sprint5_4
  Scenario: TC_20921_01: Verify the disable filters when Imported tab is selected.
    Given user selects imported tab
    And check whether filters are disabled.

  @Sprint5_4
  Scenario: TC_20921_02: Verify the enabled filters when the Imported tab is selected.
    Given user selects imported tab
    And check whether filters are enabled.

  @Sprint5_4
  Scenario: TC_21030: Verify the cross mark icon in Edit series
    Given user selects any series and create a chart visual
    And click on Edit series.
    Then cross mark icon should be fixed.

  @Sprint5_4
  Scenario: TC_18462_02:Verify the aggregate function with 'Apply avg for incomplete period' function for average method
    Given user Add this series into right pane: 3675901
    And download series base and transformed to excel

  @Sprint5_4
  Scenario: TC_18462_03: Verify the help section of aggregate function with 'Apply avg for incomplete period'.
    Given user opens fx window.
    And Navigate to Aggregate function
    Then verify the content.

  @Sprint5_4
  Scenario: TC_20839_03: Verify On Demand status when download series.
    And Login back to internal user with user "svenkatraju" and password "z0lfdt?Dkjlm"
    And Search for on demand series '377135117'
    And Download series to excel
    Then On Demand status should be shown on the Excel.

  @Sprint5_4
  Scenario: TC_20839_02: Verify On Demand status on visuals.
    And Login back to internal user with user "svenkatraju" and password "z0lfdt?Dkjlm"
    And Search for on demand series '377135117'
    And create a visual .
    Then check for On Demand Status.

  #-----------------------51-100 by Theju downwards -------------------------------------#
  @Sprint_5.4
  Scenario: TC_15342:Verify if the dates on the Chart preview are overlapped in 'series info' popup
    #Given Create new insight
    And Search for series with id "177985802"
    And Click on More actions and Series Info
    Then Click on Statistics tab

  @Sprint_5.4
  Scenario: TC_17927:Verify the Chart limit is 30 series
    Given Select 31 series id
    And Right click and click on View as Chart

  @Sprint_5.4
  Scenario: TC_20763:Verify if the 'Aggregate' is reword to 'Frequency Transformation' in function wizard
    Given Select any series id "177985802"
    And Add to My series
    Then Check the series id and click on Open Function editior

  @Sprint_5.4
  Scenario: TC_20574:Verify if "unit multiplier" is present in Quick functions
    Given Select any series id "5823501"
    And Add to My series
    And Check the series id checkbox and click on the fx icon in toolbar
    Then select any unit multiplier "H"

  @Sprint_5.4
  Scenario: TC_20535:Verify %pop function in quick functions
    Given Add any series to My series "177985802"
    And Click on fx icon from the toolbar
    And Hover on the %PoP function
    Then it should display as follows

  @Sprint_5.4
  Scenario: TC_20903:Verify if only 1 view is selected  in Edit view
    Given Select any two series id "5823501;177985802" and create Chart
    Given Select any two series id "5724301;5958801" and create Chart
    And Click on view1
    Then Click on Edit Views

  # @Sprint_5.4
  #Scenario: TC_21030:Verify the cross mark icon in Edit series
  # Given Select any 2 series and create chart visual
  #And Clik in Edit series
  #Then Check if the cross mark icon column is fixed
  @Sprint_5.4
  Scenario: TC_20780:Verify the drag and drop in Edit view
    Given Select any two series id "5823501;177985802" and create Chart
    Given Select any two series id "5724301;5958801" and create Chart
    Then Click on Edit Views
    Then Drag the view2 and drop in view1

  @Sprint_5.4
  Scenario: TC_20619:Verify if the Legend area is clickable
    Given Select any two series id "5823501;177985802" and create Chart
    And Double click on the legend
    Then The configuration menu should be displayed

  @Sprint_5.4
  Scenario: TC_20773:Verify if the auxillary parameter are hidden from function description
    Given Open the function editor window "177985802"
    Then Check if the following function description are same as follows:"%CHANGE;AGGREGATE;CROSSSEC;DIFF;DISAGGREGATE;FILLGAP;GROWTHCONTSUM;GROWTHRATE;GROWTHCONTVAL;SPLICE;TRAMOSEATS;UPDATE;X13ARIMA","%CHANGE (period);AGGREGATE (frequency, end, method);CROSSSEC (method);DIFF (period);DISAGGREGATE (frequency, end, method);FILLGAP (type);GROWTHCONTSUM (period);GROWTHRATE (period);GROWTHCONTVAL (period, value);SPLICE (value);TRAMOSEATS (output);UPDATE (value);X13ARIMA (output)""

  @Sprint_5.4
  Scenario: TC_21146_01:Verify if both continuous and replacement series are displayed together in search
    Given Select any series id "24020701;7892501;356503002"
    Given Select 3 series id
    Then Check if the icons C and S are displayed infront of the series

  @Sprint_5.4
  Scenario: TC_21146_02:Verify if both continuous and replacement series are displayed together in SSP
    Given Select any series id "24020701;7892501;356503002"
    Given Select 3 series id
    And Click on any 1 series
    Then Both continuous and replacement checkboxes,Manage tab should be displayed in SSP

  @Sprint_5.4
  Scenario: TC_21146_03:Verify if both continuous and replacement series are displayed together in Insight summary popup
    Given Select any series id "24020701;7892501;356503002"
    Given Select 3 series id
    And Refresh the page
    Then The continuous tab and replacements tab both should be present

  @Sprint_5.4
  Scenario: TC_13174:Verify  the left axis configuration for Chart
    Given Select any two series id "5823501;177985802" and create Chart
    And Click on Edit Chart
    And Check if Under left axis Step option is present
    And Check if the Number format is at the first place
    Then Check if the Min/MAX value tab has only input No up and down arrows

  @Sprint_5.4
  Scenario: TC_20015_01:Verify the region is by default in Chart Tooltip
    Given Select any two series id "5823501;177985802" and create Chart
    And Click on Edit Chart
    And In Tooltip open Advanced setting popup
    And Expand Items
    Then Check if the Name and Region are displayed by default

  @Sprint_5.4
  Scenario: TC_20015_02:Verify the display of selected items in tooltip
    Given Select any two series id "5823501;177985802" and create Chart
    And Click on Edit Chart
    And In tooltip click on dropdown beside Date
    And Select Frequency Checkbox
    And Hover on the tooltips on the chart visual
    Then Check if the Frequency is displayed on the new line

  @Sprint_5.4
  Scenario: TC_20883:Verify the user data tab(Imported ) if user does not have any imported series
    Then Check the user data tab or imported option on search panel

  @Sprint_5.4
  Scenario: TC_20807_02:Verify to import a user data file from uplaoding under import series option
    Click on Import series button
    2. Download the CEIC defined template from popup
    3. Select the attributes and add the data 
    4. save the file 
    5. Import the file by uploading it from location where saved it in the system


  @Sprint_5.4
  Scenario: TC_20822:Verify the FAQ and Ask Question button from SSP for user data
    Given Select any udd series
    Then Open SSP

  @Sprint_5.4
  Scenario: TC_20807_03:Verify the confirmaton message to import  user data file again
    Then Try to import  same imported file again

  @Sprint_5.4
  Scenario: TC_20846_02:Verify the sorting of user defined series
    Given Click on the imported tab
    And Click on the sort dropdown
    And Select the "SERIES_NAME" options

  @Sprint_5.4
  Scenario: TC_20846_02:Verify the sorting of user defined series
    Given Click on the imported tab
    And Click on the sort dropdown
    And Select the "SERIESCOUNTRY" options

  @Sprint_5.4
  Scenario: TC_20846_02:Verify the sorting of user defined series
    Given Click on the imported tab
    And Click on the sort dropdown
    And Select the "FREQUENCY" options

  @Sprint_5.4
  Scenario: TC_20846_02:Verify the sorting of user defined series
    Given Click on the imported tab
    And Click on the sort dropdown
    Then Select the "SOURCENAME" options

  @Sprint_5.4
  Scenario: TC_20846_01:Verify the sorting of user defined series
    Given In Search tab enter any "UD24070" and click on search icon
    Then The results should be displayed

  @Sprint_5.4
  Scenario: TC_20846_01:Verify the sorting of user defined series
    Given In Search tab enter any "India" and click on search icon
    Then The results should be displayed

  @Sprint_5.4
  Scenario: TC_20846_01:Verify the sorting of user defined series
    Given In Search tab enter any "Suresh" and click on search icon
    Then The results should be displayed

  @Sprint_5.4
  Scenario: TC_21206_01:Verify Edit Series button is disabled in the Imported tab
    Given Click on Imported tab available under Data on left of the Window
    Then Dont select any series from imported tab

  @Sprint_5.4
  Scenario: TC_21206_02:Verify downloaded file from Edit Series button in the Imported tab
    Given Click on Imported tab available under Data on left of the Window
    And Select some series from imported tab
    And Click on Edit series in Excel button
    Then Download the Excel file with settings as below "Region;Frequency;Unit;Source;Series ID;SR Code;First Obs. Date;Last Obs. Date;Last Update Time;Category;User Series ID"

  @Sprint_5.4
  Scenario: TC_21206_03:Verify location of downloaded file from Edit series button in the Imported tab
    Given Click on Imported tab available under Data on left of the Window
    And Select some series from imported tab
    And Click on Edit series in Excel button
    Then The downloaded file should reflect under recent downloads

  @Sprint_5.4
  Scenario: TC_20944_01:Verify a possibility to dnd a visual to an empty view
    Given Select any two series id "5823501;177985802" and create Chart
    And Create empty Views
    Then DND Visual from View1 to Empty View2

  @Sprint_5.4
  Scenario: TC_20903_02:Verify the background selection color of a series in edit series
    Given Select any two series id "24020701;7892501;356503002" and create Chart
    And Click on edit series on view tab
    And Hover the mouse on the series name
    Then Check the background selection color of a series

  @Sprint_5.4
  Scenario: TC_20884_01:Verify the confirmaton message to delete  imported
    Given Click on the imported tab
    And Hover the mouse on the imported series name
    Then Click on the cross icon besides the series name

  @Sprint_5.4
  Scenario: TC_20884_02:Verify delete imported series
    Given Click on the imported tab
    And Hover the mouse on the imported series name
    And Click on the cross icon
    Then select "Delete forever" opti

  # @Sprint_5.4
  #Scenario: TC_20884_03:Verify remove series icon for other than creator
  # And Login from User2 account
  #And Hover the mouse of the imported series by User1
  #Then Check the remove series icon from User2
  @Sprint_5.4
  Scenario: TC_20771:Verify the tooltip of indicator path(all levels) in ssp window
    Given Create new insight
    Given Select any series id "5724301"
    Then Open ssp windows

  @Sprint_5.4
  Scenario: TC_20426:Verify  the validation message when currency conversion fails if  one of the series in selection is non currency unit
    Given Select any series id "370045687;238290003"
    And Add these series into my series panel
    Then Apply currency conversion function on above series

  @Sprint_5.4
  Scenario: TC_18462_01:Verify the aggregate function with 'Apply avg for incomplete period' function for sum method
    Given Select any series id "3675901"
    And Add these series into my series panel
    And Apply Aggregate Sum,yearly,december
    Then Download base and transformed series into excel

  @Sprint_5.4
  Scenario: TC_20932_01:Verify the footnotes language
    Given Verify the footnotes of series "3675901"
    Then Check for the characters language

  @Sprint_5.41
  Scenario: TC_20932_02:Verify the footnotes language
    Given Verify the footnotes of series "3675901"
    Then Check for the characters language
