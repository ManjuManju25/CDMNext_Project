Feature:  verifying Footnote Functionality

Background:
   Given User has successful logged in
@Footnote
Scenario: Tc_Footnotes_01: Verify opening of footnotes from insight explorer window 
    And Set the Preference to insight explorer 
    And Find the Footnote option in menu bar 
     And Click Open to verify the footnotes
@Footnote
Scenario: Tc_Footnotes_02: Verify opening of footnotes from new insight
     And Set the Preference to new insight
     And Find the Footnote option in menu bar  
     And Click Open to verify the footnotes
@Footnote
Scenario: Tc_Footnotes_03: Verify footnotes open in current tab
     And Find the Footnote option in menu bar  
	 And Click Open to verify the footnotes
@Footnote
Scenario: Tc_Footnotes_04: Verify footnotes open in new tab
          And Find the Footnote option in menu bar 
          And Click 'Open in a new tab' to verify footnotes
@Footnote
Scenario: Tc_Footnotes_05: Verify minimizing the footnote window
 		   And Find the Footnote option in menu bar 
	       And Select '-' icon to minimize  
		   And Verify minimizing the footnote window
@Footnote
Scenario: Tc_Footnotes_06: Verify maximizing the footnote window
          And  select '-' icon to maximize
          And Verify maximizing the footnote window
@Footnote
Scenario: Tc_Footnotes_07: Verify opening footnotes in new tab from footnote window
           And Find the Footnote option in menu bar 
           And Click on Open icon to verify footnotes open in new tab
@Footnote
Scenario: Tc_Footnotes_08: Verify opening of footnotes as full screen
            And Find the Footnote option in menu bar 
            And Click on cross arrow marks to verify footnotes as full screen
@Footnote
Scenario: Tc_Footnotes_09: Verify exit of Footnotes from full screen 
          And Find the Footnote option in menu bar 
          And Click on cross arrow marks to verify footnotes exit full screen
@Footnote
Scenario: Tc_Footnotes_10: Verify download option in footnotes when Db's are not selected
          And Find the Footnote option in menu bar 
          And Verify the download option is disabled    
@Footnote
Scenario: Tc_Footnotes_11: Verify download option in footnotes enabled when Db's are  selected
			 And Find the Footnote option in menu bar 
            And Verify the download option in footnotes is enabled 
@Footnote
Scenario: Tc_Footnotes_12: Verify tooltips for footnotes
		   And Click on Footnotes tab and select database	
           And Verify mouse hover on Open in new tab option 
           And Verify mouse hover on download option 
           And Verify mouse hover on minimize option 
           And Verify mouse hover on Full-screen option 
           And Verify mouse hover on Close option 
@Footnote
Scenario: Tc_Footnotes_13: Verify crossbutton in footnotes window
           And Click on Close button to verify footnotes window is closed
@Footnote
Scenario: Tc_Footnotes_14: Verify opening of footnotes in new tab from maximized
         And Click on Footnotes tab
         And Click on Open in new tab icon to verify footnotes open in new tab
@Footnote
Scenario: Tc_Footnotes_16: Verify footnotes open from series search tab
		 And Create an insight
		 And Goto Series Search tab
        And Click on hat option to Verify footnotes open from series search tab
@Footnote
Scenario: Tc_Footnotes_17: Verify footnotes open from dataset search tab
		 And Create an insight
		 And Goto Dataset Search tab
         And Select record click on hat option to verify footnotes 
@Footnote
Scenario: Tc_Footnotes_18: Verify footnotes open from database search tab
		 And Create an insight
		 And Goto Database Search tab 
        And Expand the database 
        And Verify the footnotes at each level from database search
@Footnote
Scenario: Tc_Footnotes_19: Verify footnotes open from comparables search tab
		 And Create an insight
		 And Goto comparables search tab
        And  Try to expand the database till the single table series
        And  Verify the footnotes at each level              
@Footnote
Scenario: Tc_Footnotes_20:Verify 'Translate' option in footnotes
		 And Goto Database Search tab 
		 And Expand the database
		 And right click , select Footnotes
        And Verify 'Translate' option in footnotes              
@Footnote
Scenario: Tc_Footnotes_21:Verify Translate dropdown options
		  And right click , select Footnotes  
		  And click on Translate dropdown, verify the options      
@Footnote
Scenario: Tc_Footnotes_22:Verify Country > geo_province > geo_city > geo_county fluctuations in footnotes
		  And Goto Database Search tab  
		  And Expand the database
		  And Open Footnotes to verify provinces
@Footnote
Scenario: Tc_Footnotes_23:Verify menu bar options 
		  And Hover on menu bar options and verify
@Footnote
Scenario: Tc_Footnotes_24:Verify view comments, view notifications, view and edit profile 
		  And click on Open in new tab 
		  And Verify view comments, view notifications, view and edit profile dropdowns are shown
@Footnote1
Scenario: Tc_Footnotes_25:Verify redirection to Country specific information in world trend db
		  And Goto Database Search tab
		  And Expand the Section
		  And Verify redirection to Country specific information 
@Footnote
Scenario: Tc_Footnotes_26:Verify open footnotes from SSP window
		  And Goto Series Search tab
		  And Add series to My series 
		  And Click on i con in SSP window 
		  And Click on Read more to Verify open footnotes
@Footnote
Scenario: Tc_Footnotes_27:Verify refreshing footnotes window tab with refresh option
		  And Click on Footnotes menu bar , click Open
		  And Click on File , select Refresh
		  And Verify the footnotes window is retained
@Footnote
Scenario: Tc_Footnotes_28:Verify refreshing footnotes window tab with f5 key on keyboard
		  And Click on Footnotes menu bar , click Open
		  And Refresh the page,Verify the footnotes window disappear
@Footnote
Scenario: Tc_Footnotes_29:Verify refreshing footnotes in new tab with f5 when opened through menu bar of an insight
		  And Goto Footnotes menu bar , click Open new tab
		  And expand the tree , refresh the page
		  And Verify the tree is collapsed
@Footnote
Scenario: Tc_Footnotes_30:Verify refreshing footnotes in new tab with f5 when opened through menu bar of an insight
		 And Goto Db Search tab 
		 And Expand the database
		 And right click , select Footnotes
		 And Click on Open button and verify refreshing footnotes in new tab
@Footnote
Scenario: Tc_Footnotes_31:Verify translation for footnotes opened in window
		  And Goto Database Search tab 
          And Expand the database
          And verify language translation db_level
          And verify language translation Country_level
          And verify language translation Topic_level
          And verify language translation Section_level
          And verify language translation Table_level
          And verify language translation Series_level
@Footnote
Scenario: Tc_Footnotes_32:Verify translation for footnotes opened in new tab
		   And Goto Database Search tab 
		   And Expand the database
		   And verify language translation db_level in new tab
		   And verify language translation Country_level in new tab
           And verify language translation Topic_level in new tab
          And verify language translation Section_level in new tab
          And verify language translation Table_level in new tab
          And verify language translation Series_level in new tab
@Footnote
Scenario: Tc_Footnotes_33:Verify show original option in footnotes
		 And Goto Db Search tab 
		 And Expand the database
		 And Open Footnotes for table level
		 And select language
		 And Verify Show Original option 
@Footnote
Scenario: Tc_Footnotes_34:Verify click on show original option 
		  And Click on  Show Original option 
		  And Verify the text changed to English
@Footnote
Scenario: Tc_Footnotes_35:Verify download option in translated footnotes
		 And Goto Db Search tab 
		 And Expand the database
		 And Select language Japanese and verify download option
@Footnote
Scenario: Tc_Footnotes_37:Verify back button in footnotes in new tab
		   And Set the Preference to insight explorer
		   And Click on CEIC logo
		   And Goto Footnotes menu bar , click Open new tab
          And verify Back button
@Footnote
Scenario: Tc_Footnotes_38:Verify back button in footnotes in new tab
		     And Click on Footnotes tab Open new tab
            And Expand the tree change the language ,verify the Back button
            And Set the Preference to new insight 
				
@Footnote1
Scenario: Tc_Footnotes_39:Verify click on back in the table opened footnote
		   And Set the Preference to new insight 
		   And Goto Database Search tab
		   And Expand the Section
          And Check the navigation onclick Back button
@Footnote1
Scenario: Tc_Footnotes_40:Verify click on back in table opened translated footnote
		  And Goto Database Search tab
		  And Expand the Section
         And check the page navigates to translated footnote page  
@Footnote1
Scenario: Tc_Footnotes_41:Verify country specific information  in new window of footnotes opened
		  And Goto Database Search tab
		  And Expand the Section
          And Open footnotes in new tab
          And check the country specific information
@Footnote1
Scenario: Tc_Footnotes_42:Verify Back button  in new window of footnotes opened
		  And Goto Database Search tab
		   And Expand the Section
          And Open footnotes in new tab
          And check the Back button navigates to Footnotes page
 @Footnote1
Scenario: Tc_Footnotes_43:Verify Back button  in new window of translated footnotes opened
		  And Goto Database Search tab
		  And Expand the Section
          And Open footnotes in new tab
          And check the Back button navigates to translated Footnotes page
@Footnote
Scenario: Tc_Footnotes_44:Verify 'Ask Question' in footnotes
		  And Goto Db Search tab 
		  And Expand the database
		  And verify Ask Question option
@Footnote
Scenario: Tc_Footnotes_45:Verify 'Ask Question' in footnotes new tab
		  And Goto Db Search tab 
		  And Expand the database
		  And verify Ask Question option in new tab
@Footnote
Scenario: Tc_Footnotes_46:Verify ask question window for submitting the message/question in window tab
		  And Goto Db Search tab 
		  And Expand the database
		  And verify submitting message in Ask Question window
@Footnote
Scenario: Tc_Footnotes_47:Verify ask question window for submitting the message/question in new tab
		  And verify submit message in new tab
@Footnote
Scenario: Tc_Footnotes_48:Verify cancel button in ask question window of window tab
		  And Goto Db Search tab 
		  And Expand the database
          And Verify cancel button in ask question window
@Footnote
Scenario: Tc_Footnotes_49:Verify cancel button in ask question window in new tab
		   And verify cancel button ask question window in new tab
@Footnote
Scenario: Tc_Footnotes_50:Verify crossmark in ask question window of window tab
		   And Verify crossmark option in ask question window
@Footnote
Scenario: Tc_Footnotes_51:Verify crossmark in ask question window in new tab
		   And Verify crossmark option in Ask Question window in new tab
@Footnote
Scenario: Tc_Footnotes_52:Verify guest mode from footnotes
			And Goto Db Search tab 
		    And Expand the database
		    And Click on guestmode option, verify the page
@Footnote
Scenario: Tc_Footnotes_54:Verify opening footnotes from dropdown in series tab
			And Goto Series Search tab
		    And Click on the down arrow present 
		    And Click on the  'readmore' option, verify Footnotes
@Footnote
Scenario: Tc_Footnotes_55:Verify footnotes open in suggested indicators
			  And Goto Db Search tab 
			 
		      And Select series then click on Related series
		      And Click on i icon to verify footnotes
@Footnote
Scenario: Tc_Footnotes_56:Verify chinese translated footnotes for any of the global db table
			 And Goto Db Search tab 
			 And Expand the global database
             And Open footnotes for table level
             And Download chinese language footnote file
@Footnote
Scenario: Tc_Footnotes_57:Verify Korean translated footnotes for any of the global series
			And Goto Db Search tab 
            And Expand the global database
            And Open footnotes for series level
            And Download japanese language footnote file
@Footnote
Scenario: Tc_Footnotes_58:Verify Korean translated footnotes for any of the global db table
			 And Goto Db Search tab 
            And Expand the global database
            And Open footnotes for table level
            And Download Korean language footnote file
@Footnote
Scenario: Tc_Footnotes_59:Verify Russian translated footnotes for any of the russian db series
			 And Goto Db Search tab 
            And Expand the russian database
            And Open footnotes for russian series level
            And Download Russian language footnote file
@Footnote
Scenario: Tc_Footnotes_60:Verify Indonesian translated footnotes for any of the indonesian db series
			 And Goto Db Search tab 
            And Expand the indonesian database
            And Open footnotes for indonesian series level
            And Download Indonesian language footnote file
@Footnote
Scenario: Tc_Footnotes_62:Footnotes: 'Ask question' should include the selected table name
			 And Goto Db Search tab 
			 And Expand the global database
			 And Open footnotes for table level
			 And Click 'Ask a question' verify the table name
@Footnote
Scenario: Tc_Footnotes_63:Footnotes: Verify Shortcut 'd' for footnotes download
			 And Goto Db Search tab 
			 And Expand the global database
			 And Open footnotes for table level
			 And Press 'd' to verify footnote download
@Footnote
Scenario: Tc_Footnotes_64:Footnotes: Verify Footnotes download message
			 And Goto Db Search tab 
			 And Expand the global database
			 And Open footnotes for table level
			 And Verify footnote download message	
@Footnote
Scenario: Tc_Footnotes_66: Verify if Hyperlinks from market purchasing managers' index are redirectable
			  And Goto Db Search tab 
              And Expand the Markit database
              And Open footnotes for section level
              And Access links verify hyperlinks are redirectable
@Footnote
Scenario: Tc_Footnotes_67:	'Ask question' option is  available for translated footnotes
			And Goto Db Search tab 
			And Expand the global database
			And Open footnotes for table level
			And select language
			And Verify 'Ask question' is available for translated footnotes
@Footnote
Scenario: Tc_Footnotes_68: Verify display of 'Please see Table of Contents to select a Footnote ' message 
			And Goto Db Search tab
			And Expand Daily Database
			And Open footnote for table
			And Verify the message 'Please see Table of Contents to select a Footnote '  
@Footnote
Scenario: Tc_Footnotes_69:	Verify if Footnotes loads for transformed series	
			  And Goto Db Search tab 
		      And Expand the database
		      And Add series to my series
		      And Apply function
		      And Verify footnotes for transformed series
@Footnote
Scenario: Tc_Footnotes_70:	Verify the action of  'Back' button
			 And Goto Footnotes menu bar , click Open new tab
			 And Set the Preference to insight
			 And Close the new tab
			 And Goto Footnotes menu bar , click Open new tab
			 And Expand the database then translate to japanese and verify Back button
@Footnote
Scenario: Tc_Footnotes_71:Check footnotes access for Investment Table in World trend plus DB 		
			And Goto Db Search tab 
			And Expand the database upto section
			And Goto table Table:Investment: % of Nominal GDP: Asia open footnotes
			And Translate to Japanese
			And Verify translated page should appear once after the click on 'Back'
#@Footnote
#Scenario: Tc_Footnotes_72:Translated Footnotes should retain the selected language when opened in new tab
#			And Goto Db Search tab 
#			And Expand the database
#			And Open footnotes for tablelevel
#			And Translate to Japanese
#			And Click on Open icon to open footnotes in new tab
#			And Verify footnotes opened in new tab retain the japanese language
@Footnote1
Scenario: Tc_Footnotes_61:Check the translation of Glossary link page of Footnotes
			 And Goto Db Search tab 
            And Expand the Markit database
            And Open footnotes for section level, change to Japanese
            And Click on PMI glossary link,Verify the glossary     
                                                     
#@Footnote1
#Scenario: Tc_Footnotes_15: Verify opening of footnotes in new tab from minimized form
#         And Click on Footnotes tab
#         And Click on minimize icon
#         And Click on Open in new tab icon to verify footnotes open in new tab  
#
#@Footnote1
#Scenario: Tc_Footnotes_65:Footnotes:Verify if Footnotes in minimized state displays tooltip while downloading
#			And Goto Db Search tab 
#			And Expand the global database
#			And Open footnotes for table level
#			And Select '-' icon to minimize   
#			And Click on Download button
#			And Verify footnote download message	
#@Footnote1
#Scenario: Tc_Footnotes_36:Verify back button in footnotes
#			And Create an insight
#		    And Goto Footnotes menu bar , click Open new tab
#            And click on CEIC logo,verify Back button   
#@Footnote1
#Scenario: Tc_Footnotes_53:Verify our support team link  from footnotes
#			And Goto Db Search tab 
#		    And Expand the database
#		    And Click on link - our support team,verify     
     
#
#		  