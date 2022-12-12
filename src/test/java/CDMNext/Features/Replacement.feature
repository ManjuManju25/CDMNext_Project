Feature:  verifying replacement series  Functionality

Background:
   Given User has successful logged in
   
@replacement
Scenario: TC_RS_01:Verify to open series suggestion manager window for series replacements in my_series 
          And Verify window
					And Add rebased series to My series
					Then Verify Series suggestion manager window is open
@replacement
Scenario: TC_ReplaceSeries_02:Verify manage all drop down 
					
					And Add rebased series to My series "355610147 160747301"
					Then Verify manage all drop down
@replacement
Scenario: TC_RS_03:Verify add suggestions to series 
					
					And Add rebased series to My series "355610147 160747301"
					Then Add suggestions for all series and Verify
					And Add rebased series to My series "355610147 160747301"
					Then Add suggestion for single series and Verify
@replacement
Scenario: TC_RS_04:Verify full-screen for SS window
					
					And Add rebased series to My series
					And Open Series Suggestion window
					And Verify full-screen for SS window
@replacement
Scenario: TC_RS_05:Verify cross mark for SS window
					
					And Add rebased series to My series
					And Open Series Suggestion window
					And Verify Verify cross mark for SS window
@replacement
Scenario: TC_RS_06:Verify SSP window from series suggestions manager
					And Add rebased series to My series
					And Verify Verify SSP window from series suggestions manager
@replacement
Scenario: TC_RS_07:Verify read more in SS window
					And Add rebased series to My series
					And Verify read more in SS window
@replacement
Scenario: TC_RS_08:Verify keep inactive series 
					And Add rebased series to My series
					And Verify keep inactive series
@replacement
Scenario: TC_RS_09: Verify replace inactive series
					And Add rebased series to My series
					And Verify replace inactive series
@replacement
Scenario: TC_RS_10:Verify delete inactive series
					And Add rebased series to My series
					And Verify delete inactive series
@replacement
Scenario: TC_RS_11:Verify preserve option in SS window
					And Add rebased series to My series
					And Verify preserve option for formula in SS window
					And Add rebased series to My series
					And Verify preserve option for name  in SS window
@replacement
Scenario: TC_RS_12:Verify chart icon in SS window
					And Add rebased series to My series
					And Verify chart icon in SS window
@replacement
Scenario: TC_RS_13:Verify refresh for insight having inactive eries
					And Add rebased series to My series "355610147"
					And Verify refresh for insight having inactive series		
@replacement
Scenario: TC_RS_14:Verify cancel button
					And Add rebased series to My series "355610147"
					And Verify cancel button			
@replacement
Scenario: TC_RS_15:Verify apply function in SS window 
					And Add rebased series to My series "355610147"
					And Verify apply function in SS window 			
@replacement
Scenario: TC_RS_16:Verify opening SS window from series search tab 
					And Add rebased series to My series "355610147"
					And Verify opening SS window from series search tab 		
@replacement
Scenario: TC_RS_17:Verify Manage suggestions button
					And Add rebased series to My series "355610147"
					And Verify Manage suggestions button		
@replacement
Scenario: TC_RS_18:Verify dropdown at replacement suggestions
					And Add rebased series to My series "355610147"
					And Verify dropdown at replacement suggestions		
@replacement
Scenario: TC_RS_19:Verify adding on splice function on replacement series
					And Add rebased series to My series "211171402"		
					Then Verify adding on splice function on replacement series		
@replacement
Scenario: TC_RS_20:Verify replacing of inactive series with splice functions
					And Add rebased series to My series "211171402"		
					Then Verify replacing of inactive series with splice functions	
@replacement
Scenario: TC_RS_21:Verify last changes window popup for replacement series
					And Add rebased series to My series "355610147"		
					Then Verify last changes window popup for replacement series	
@replacement
Scenario: TC_RS_22:Verify 's' icon for replacement series
					And Add rebased series to My series "355610147"		
					Then Verify 's' icon for replacement series			
@replacement
Scenario: TC_RS_23:Verify for ssp window for series in replacement window
					And Add rebased series to My series "355610147"		
					Then Click on the series name in the chart. 
					Then Verify for ssp window for series in replacement window																					