Feature: Sprint_5.4

  @Sprint_5.4
  Scenario: TC_15342:Verify if the dates on the Chart preview are overlapped in 'series info' popup
    Given Create new insight
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

  @Sprint_5.4
  Scenario: TC_21030:Verify the cross mark icon in Edit series
    Given Select any 2 series and create chart visual
    And Clik in Edit series
    Then Check if the cross mark icon column is fixed

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

  @Sprint_5.4
  Scenario: TC_20884_03:Verify remove series icon for other than creator
    And Login from User2 account
    And Hover the mouse of the imported series by User1
    Then Check the remove series icon from User2

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
