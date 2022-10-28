Feature: Verifying KBS functionality

  @KBS
  Scenario: TC_KBS_01 : Verify 'Delete' KBS
    And Select series from My Seris tab
    And Press "Delete" on KB
    Then The selected series should be deleted

  @KBS
  Scenario: TC_KBS_02 : Verify KBS for 'Download'
    And Select Visual
    And Press "D" on KB
    Then Download popup should be appeared

  @KBS
  Scenario: TC_KBS_03 : Verify KBS for 'Cut'
    And Select series from My Seris tab
    And Press "Ctrl+X" on KB
    Then The selected series should be cut

  @KBS
  Scenario: TC_KBS_04 : Verify KBS for 'Copy
    And Select series from My Seris tab
    And Press "Ctrl+C" on KB
    Then The selected series should be copied to  clipboard

  @KBS
  Scenario: TC_KBS_05 : Verify KBS for 'Paste'
    And Select series from My Seris tab
    And Press "Ctrl+V" on KB
    Then The data should be pasted

  @KBS
  Scenario: TC_KBS_06 : Verify KBS for 'Undo'
    And Select series from My Seris tab
    And Delete the selected series
    And Press "Ctrl+Z" on KB
    Then The deleted series should be displayed

  @KBS
  Scenario: TC_KBS_07 : Verify KBS for 'Redo'
    And Add series to the Data tab
    And Press "Ctrl+Z" on KB
    Then The added series should not be displayed
    And Press "Ctrl+Y" on KB
    Then The deleted series should be displayed

  @KBS
  Scenario: TC_KBS_08 : Verify KBS for 'Find and Rename'
    And Add series to the Data tab
    And Press "Ctrl+H" on KB
    Then The Find and Replace popup should be displayed

  @KBS
  Scenario: TC_KBS_09 : Verify KBS for 'Esc'
    And Select Visual
    And Press "D" on KB
    Then Download popup should be appeared
    And Press "Esc" on KB
    Then Download should be closed

  @KBS
  Scenario: TC_KBS_10 : Verify KBS for 'View series as Chart'
    And Select the series
    And Press "C" on KB
    Then Visual should be created with "Edit Chart"

  @KBS
  Scenario: TC_KBS_11 : Verify KBS for 'View series as Map'
    And Select the series
    And Press "M" on KB
    Then Visual should be created with "Edit Map"

  @KBS
  Scenario: TC_KBS_12 : Verify KBS for 'View series as Table'
    And Select the series
    And Press "T" on KB
    Then Visual should be created with "Edit Table"

  @KBS
  Scenario: TC_KBS_13 : Verify KBS for 'Expand/Collapse search panel'
    And Press "S" on KB
    Then The search panel should be expaned/collapsed

  @KBS
  Scenario: TC_KBS_14 : Verify KBS for 'Expand/Collapse View panel'
    And Press "V" on KB
    Then The View panel should be expaned/collapsed

  @KBS
  Scenario: TC_KBS_15 : Verify KBS for 'Collpase tree node'
    #And Expand any databse
    And Select Global database
    And Expand till series level
    Then "Collapse all" should be displayed
    And Press left arrow key on KB
    Then The data trees should be collapsed

  @KBS
  Scenario: TC_KBS_16 : Verify KBS for 'Expand tree node'
    And Go to any database
    And Press right arrow key on KB
    Then "Collapse all" should be displayed

  @KBS
  Scenario: TC_KBS_17 : Verify KBS for 'Select all series'
    And Add some series to the Data tab
    And Press "Ctrl+a" for select all series
    Then All the series in data tab should be selected

  @KBS
  Scenario: TC_KBS_18 : Verify KBS to add a separator
    And Add some series to the Data tab
    And Select any series from Data tab
    And Press "Spacebar" on KB
    Then The separator should be added in next to the selected series

  @KBS
  Scenario: TC_KBS_19 : Verify KBS for add a series to insight
    And Select some series
    And Press "A" on KB
    Then The selected series should be added to Data tab

  @KBS
  Scenario: TC_KBS_20 : Verify KBS for 'Add and replace series'
    And Go to View tab
    And Create a Chart visual
    And Add a series to the chart visual
    And Select any series from the series tab
    And Press "R" on KB
    Then The visual should be replaced the series with selected series

  @KBS
  Scenario: TC_KBS_21 : Verify KBS for 'Open functon editor'
    And Add series to the Data tab
    And Select any series from Data tab
    And Press "F" on KB
    Then The function editor should be poped up

  @KBS
  Scenario: TC_KBS_22 : Verify KBS for 'Swich between list and table mode'
    And Add series to the Data tab
    And Press "L" on KB
    Then The Data tab should be Swich to list/table mode

  @KBS
  Scenario: TC_KBS_23 : Verify KBS to open 'Keyboard shortcut panel'
    And Press "Shift+?" on KB
    Then The "Keyboard Shortcuts" panel should be opened

  @KBS
  Scenario: TC_KBS_24 : Verify KBS for 'Add a new visual
    And Select some series
    And Press "Shift+A" on KB
    Then New visual should be created
