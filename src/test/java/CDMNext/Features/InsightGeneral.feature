Feature:  verifying Footnote Functionality

Background:
   Given User has successful logged in
@InsightGeneral
Scenario: Tc_InsightGeneral_01:Verify CEIC logo
          And Verify CEIC logo
@InsightGeneral
Scenario: Tc_InsightGeneral_02:Verify clicking on CEIC logo
          And Create new insight
          Then Click on CEIC logo to verify
@InsightGeneral
Scenario: Tc_InsightGeneral_03:Verify insight title
          And Verify insight title
@InsightGeneral
Scenario: Tc_InsightGeneral_04:Verify insight title change
          And Click  insight title
          And Verify insight title change
@InsightGeneral
Scenario: Tc_InsightGeneral_05:Verify insight URL after changed insight title
          And Create new insight
          And Change insight title and verify insight URL after changed insight title
@InsightGeneral
Scenario: Tc_InsightGeneral_06:Verify insight URL after changed insight title with existing insight title
          And Verify insight URL after changed insight title with existing insight title
@InsightGeneral
Scenario: Tc_InsightGeneral_07:Verify tooltip for insight title
          And Verify tooltip for insight title
@InsightGeneral
Scenario: Tc_InsightGeneral_08:Verify tooltip for favorite icon
		  And Create new insight
          And Verify tooltip for favorite icon
@InsightGeneral
Scenario: Tc_InsightGeneral_09:Verify tag icon
		 And Create new insight
          And Click on tag icon 
          And Verify tag popup is displayed
@InsightGeneral
Scenario: Tc_InsightGeneral_10:Verify tags field
		  And Create new insight
          And Click on tag icon and enter the tags
          And Verify tag in insight explorer
@InsightGeneral
Scenario: Tc_InsightGeneral_11:Verify Cancel/Dismiss(X) options for tag popup.
		   And Create new insight
          And Click on tag icon
          And Verify Cancel option in tag popup
@InsightGeneral
Scenario: Tc_InsightGeneral_12:Verify Share icon.
 		   And Create new insight
		   And Click on Share icon
           And Verify share popup is shown
@InsightGeneral
Scenario: Tc_InsightGeneral_13:Verify 'Save as' button for untitled insight.
		  And Click on Save as,Verify 'Save as' button for untitled insight.
@InsightGeneral
Scenario: Tc_InsightGeneral_14:Verify Share for untitled insight.
		  And Click on Share icon for untitled insight
		  And Verify Share for untitled insight.
@InsightGeneral
Scenario: Tc_InsightGeneral_15:Verify Share pop shown for  untitled insight.
		  And Click on Share icon for untitled insight
		  And Update the untitled insight name
		  And Verify Share pop up is shown
@InsightGeneral
Scenario: Tc_InsightGeneral_16:Verify the the insight   saved with updated title
		 And Verify the the insight  saved with updated title.
@InsightGeneral
Scenario: Tc_InsightGeneral_17:Verify insight url updated after insight title changed
		 And Click on Share icon for untitled insight
		 And Verify insight url updated after insight title changed
@InsightGeneral
Scenario: Tc_InsightGeneral_18:Verify edit icon for insight URL.
		 And Click on Share icon for untitled insight
		 And Click on Edit icon on insight URL field and Verify 
@InsightGeneral
Scenario: Tc_InsightGeneral_19:Verify the alert message while click on edit icon for insight URL change.
		 And Click on Share icon for untitled insight
		 And Verify the alert message while click on edit icon for insight URL change
@InsightGeneral
Scenario: Tc_InsightGeneral_20:Verify 'Copy' permanent link' option.
		 And Click on Share icon for untitled insight
		 And Verify 'Copy' permanent link' option.
@InsightGeneral
Scenario: Tc_InsightGeneral_21:Verify the tooltip for Copy permanent link.
		 And Click on Share icon for untitled insight
		 And Verify the tooltip for Copy permanent link.
@InsightGeneral
Scenario: Tc_InsightGeneral_22:Verify disabled save button.
		 And Click on Share icon for untitled insight
		 And Verify disabled save button.
@InsightGeneral
Scenario: Tc_InsightGeneral_23:Verify Cancel/Dismiss(X) options for 'Name Insight' popup
		 And Click on Share icon for untitled insight
		 And Verify Cancel/Dismiss(X) options for 'Name Insight' popup
@InsightGeneral
Scenario: Tc_InsightGeneral_24:Verify 'File' menu.
		  And Create new insight
		  And Click on File menu and Verify
@InsightGeneral
Scenario: Tc_InsightGeneral_25:Verify icons for file menu 
		   And Click on File menu
#		   And Verify icons for file menu 
@InsightGeneral
Scenario: Tc_InsightGeneral_26:Verify View option
		  And Create new insight	
		  And Click on File menu
		  And Click on View option and Verify
@InsightGeneral
Scenario: Tc_InsightGeneral_27:Verify 'Favorite' icon.
		  And Create new insight	
		  And Click on File menu
		  And Click on Add to favorite option and Verify
@InsightGeneral
Scenario: Tc_InsightGeneral_28:Verify 'Open' option in insight preview.
		  And Create new insight	
		  And Click on File menu
		  And Click on View option 
		  And Verify 'Open' option in insight preview
@InsightGeneral
Scenario: Tc_InsightGeneral_29:Verify 'Copy' option in insight preview.
		  And Create new insight	
		  And Click on File menu
		  And Click on View option
		  And Click on Copy button
		  And Verify 'Copy' option in insight preview.
@InsightGeneral
Scenario: Tc_InsightGeneral_30:Verify default insight title while coping insight.
		  And Create insight	
		  And Click on File menu
		  And Click on View option
		  And Click on Copy button
		  And Verify default insight title while coping insight.
@InsightGeneral
Scenario: Tc_InsightGeneral_31:Verify 'Cancel' button for 'Copy the insight' popup.
		  And Create insight	
		  And Click on File menu
		  And Click on View option
		  And Click on Copy button
		  And Verify 'Cancel' button for 'Copy the insight' popup.
@InsightGeneral
Scenario: Tc_InsightGeneral_32:Verify 'Download' option in insight preview without visual
		  And Create insight	
		  And Click on File menu
		  And Click on View option
		 And Verify 'Download' option in insight preview without visual
@InsightGeneral
Scenario: Tc_InsightGeneral_33:Verify 'Download' option in insight preview with visual
		  And Create insight
		  And Create Visual	
		  And Click on View
		  And Click on Download
		  And Verify 'Download' option in insight preview with visual
@InsightGeneral
Scenario: Tc_InsightGeneral_34:Verify 'Maximize' option in insight preview
		  And Create insight
		  And Click on View	
		  And Click on Maximize button
		  And Verify 'Maximize' option in insight preview
@InsightGeneral
Scenario: Tc_InsightGeneral_35:Verify 'Restore down' option in insight preview.
		  And Create insight
		  And Click on View	
		  And Click on Maximize button
		  And Verify 'Restore down' option in insight preview.  
@InsightGeneral
Scenario: Tc_InsightGeneral_36:Verify Cancel option for insight preview popup.
		  And Create insight
		  And Click on View	
		  And Verify Cancel option for insight preview popup.  
@InsightGeneral
Scenario: Tc_InsightGeneral_37:Verify "Related Insights" in insight preview.
		  And Create insight
		  And Click on View	
		  And Click on Related Insights
		  And Verify Related Insights in insight preview. 
@InsightGeneral
Scenario: Tc_InsightGeneral_38:Verify New option.
		  And Click on File menu
		  And Click on New
		  And Verify New option.
@InsightGeneral
Scenario: Tc_InsightGeneral_39:Verify auto title for Create insight..
		  And Click on File menu
		  And Click on New
		  And Verify auto title for Create insight.		  
@InsightGeneral
Scenario: Tc_InsightGeneral_40:Verify 'Create insight' button.
		  And Click on File menu
		  And Click on New
		  And Verify 'Create insight' button.
@InsightGeneral
Scenario: Tc_InsightGeneral_41:Verify 'Cancel' button for new insight popup.
		  And Click on File menu
		  And Click on New
		  And Verify 'Cancel' button for new insight popup.  
@InsightGeneral
Scenario: Tc_InsightGeneral_42:Verify 'Open' option.
		  And Create insight
		  And Click on File menu
		  And Click on Open
		  And Verify 'Open' option. 
@InsightGeneral
Scenario: Tc_InsightGeneral_43:Verify default tab for open.
		  And Create insight
		  And Click on File menu
		  And Click on Open
		  And Click on My insights tab and close
		  And Click on File menu
		  And Click on Open
		  And Verify default tab for open.
@InsightGeneral
Scenario: Tc_InsightGeneral_44:Verify Dismiss button for insight explorer modal popup.
		  And Create insight
		  And Click on File menu
		  And Click on Open
		  And Verify Dismiss button for insight explorer modal popup.	
@InsightGeneral
Scenario: Tc_InsightGeneral_45:Verify 'Save' option.
		  And Click on File menu
		  And Click on Save
		  And Verify 'Save' option. 
@InsightGeneral
Scenario: Tc_InsightGeneral_46:Verify Delete option.
		  And Click on File menu
		  And Click on Delete
		  And Verify Delete option.
@InsightGeneral
Scenario: Tc_InsightGeneral_47:Verify Popup header for delete.
		  And Click on File menu
		  And Click on Delete
		  And Verify Popup header for delete.	
@InsightGeneral
Scenario: Tc_InsightGeneral_48:Verify description for delete confirmation popup.
		  And Click on File menu
		  And Click on Delete
		  And Verify description for delete confirmation popup.
@InsightGeneral
Scenario: Tc_InsightGeneral_49:Verify Delete forever button.
		  And Verify Delete forever button. 
@InsightGeneral
Scenario: Tc_InsightGeneral_50:Verify 'Save as' option.
		  And Click on File menu
		  And Click on 'Save as' 	
@InsightGeneral
Scenario: Tc_InsightGeneral_51:Verify default insight title while coping insight.
		  And Click on 'Save as' and Verify default insight title while coping insight 
@InsightGeneral
Scenario: Tc_InsightGeneral_52:Verify 'Cancel/X' button for 'Copy the insight' popup.
		  And Click on File menu
		  And Click on Save As
		  And Verify 'Cancel/X' button for 'Copy the insight' popup.
@InsightGeneral
Scenario: Tc_InsightGeneral_53:Verify Refresh option.
		  And Click on Add views
		  And Click on File menu
		  And Click on Refresh
		  And Verify Refresh option.		
@InsightGeneral
Scenario: Tc_InsightGeneral_54:Verify Settings option.
		  And Click on File menu
		  And Click on Settings
		  And Verify Settings option.	
@InsightGeneral
Scenario: Tc_InsightGeneral_55:Verify the available tabs in the settings popup.
		  And Create insight
		  And Click on File menu
		  And Click on Settings
		  And Verify the available tabs in the settings popup.
@InsightGeneral
Scenario: Tc_InsightGeneral_56:Verify Name field in General tab.
		  And Click on Settings and Verify the available tabs in the settings popup
@InsightGeneral
Scenario: Tc_InsightGeneral_57:Verify changing of insight name in General tab.
		  And Update the name under Settings and Verify   
@InsightGeneral
Scenario: Tc_InsightGeneral_58:Verify insight URL after insight title change.
		 And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Verify insight URL after insight title change.	
@InsightGeneral
Scenario: Tc_InsightGeneral_59:Verify the alert message while changing insight URL.
		 And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Verify insight URL after insight title change.	
@InsightGeneral
Scenario: Tc_InsightGeneral_60:Change insight URL with existing insight name.
		 And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Verify Change insight URL with existing insight name
@InsightGeneral
Scenario: Tc_InsightGeneral_61:Validate the copied link.
		 And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Validate the copied link.
@InsightGeneral
Scenario: Tc_InsightGeneral_62:Verify Category field.
		 And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Verify Category field.
@InsightGeneral
Scenario: Tc_InsightGeneral_63:Verify applied category for the insight.
		 And Verify applied category for the insight.
@InsightGeneral
Scenario: Tc_InsightGeneral_64:Verify added description under insight explorer.
         And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Verify added description under insight explorer.
@InsightGeneral
Scenario: Tc_InsightGeneral_65:Verify Save and Apply buttons when settings opened.
         And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Verify Save and Apply buttons disabled
		 And Verify Save and Apply buttons enabled
@InsightGeneral
Scenario: Tc_InsightGeneral_66:Verify Apply button.
         And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Verify Apply button.
@InsightGeneral
Scenario: Tc_InsightGeneral_67:Verify confirmation message after click on Apply.
         And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Enter Description and Click Apply button
		 And Verify confirmation message after click on Apply.
@InsightGeneral
Scenario: Tc_InsightGeneral_68:Verify Apply and Save buttons when redirect to next tabs with changes.
         And Create insight
		 And Click on File menu
		 And Click on Settings
		 And Click on Info Tab
		 And Verify Apply and Save buttons when redirect to next tabs with changes. 
@InsightGeneral
Scenario: Tc_InsightGeneral_69:Verify Cancel/X buttons. 
         And Click on File menu
		 And Click on Settings
		 And Verify Cancel/X buttons. 
@InsightGeneral
Scenario: Tc_InsightGeneral_70:Verify Created field under Information tab.
		 And Verify Created field under Information tab.
@InsightGeneral
Scenario: Tc_InsightGeneral_71:Verify Last editor field.
		 And Verify Last editor field.	
@InsightGeneral
Scenario: Tc_InsightGeneral_72:Verify sharing settings field.
         And Create insight
         And Click on File menu
         And Click on Settings
		 And Check sharing settings field.
		 And Share insight and Check the sharing settings field	 
@InsightGeneral
Scenario: Tc_InsightGeneral_73:Verify 'Change' option for sharing settings.
         And Create insight
         And Click on File menu
         And Click on Settings
		 And Verify 'Change' option for sharing settings.
@InsightGeneral
Scenario: Tc_InsightGeneral_74:Verify number of the view/s for the insight.
         And Add Views
         And Verify number of the view/s for the insight. 
@InsightGeneral
Scenario: Tc_InsightGeneral_75:Verify Data series.
         And Add series to myseries
         And Verify Data series under info tab in settings
@InsightGeneral
Scenario: Tc_InsightGeneral_76:Verify Permission tabs description.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Permissions tab
         And Verify Permission tabs description.   
@InsightGeneral
Scenario: Tc_InsightGeneral_77:Verify default selection for permission tab.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Permissions tab
         And Verify default selection for permission tab.	
@InsightGeneral
Scenario: Tc_InsightGeneral_78:Verify Select service code field.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify Select service code field.  
@InsightGeneral
Scenario: Tc_InsightGeneral_79:Verify search for service code.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify search for service code. 
@InsightGeneral
Scenario: Tc_InsightGeneral_80:Verify message for invalid search.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify message for invalid search.
@InsightGeneral
Scenario: Tc_InsightGeneral_81:Verify Subscription tabs description.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify Subscription tabs description.     
@InsightGeneral
Scenario: Tc_InsightGeneral_82:Verify remove icon for service code field.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify remove icon for service code field.    
@InsightGeneral
Scenario: Tc_InsightGeneral_83:Verify service code selection.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify service code selection. 
@InsightGeneral
Scenario: Tc_InsightGeneral_84:Verify remove icon for selected service code.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify remove icon for selected service code.
@InsightGeneral
Scenario: Tc_InsightGeneral_85:Verify product code field.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify product code field.        
@InsightGeneral
Scenario: Tc_InsightGeneral_86:Verify default selection for product code field.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify default selection for product code field.
@InsightGeneral
Scenario: Tc_InsightGeneral_87:Verify remove icon for selected product codes.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Subscription tab
         And Verify remove icon for selected product codes.  
@InsightGeneral
Scenario: Tc_InsightGeneral_88:Verify keywords for the insights.
         And Create insight
		 And Click on File menu
         And Click on Settings
         And Click on Keywords tab
         And Verify keywords for the insights. 
@InsightGeneral
Scenario: Tc_InsightGeneral_89:Verify the insight for added keywords in insight explorer.
          And Create insight
          And Click on File menu
          And Click on Settings
          And Click on Keywords tab
          And Add Keywords
		  And Verify the insight for added keywords in insight explorer.
@InsightGeneral
Scenario: Tc_InsightGeneral_90:Verify adding multiple keywords.
		  And Create insight
          And Click on File menu
          And Click on Settings
          And Click on Keywords tab
          And Add Multiple Keywords and Verify
@InsightGeneral
Scenario: Tc_InsightGeneral_91:Verify remove icon for keywords. 
	       And Click on File menu
	       And Click on Settings
	       And Click on Keywords tab
	       And Remove keywords and Verify
@InsightGeneral
Scenario: Tc_InsightGeneral_92:Verify Protect option.
		   And Create insight
		   And Click on File menu
		   And Click on Protect
		   And Verify Protect option.  
@InsightGeneral
Scenario: Tc_InsightGeneral_93:Verify Download option for new insight.
		   And Create insight
		   And Click on File menu
		   And Verify Download option for new insight.
@InsightGeneral
Scenario: Tc_InsightGeneral_94:Verify download option when series selected in search panel.
		   And Create insight
		   And Add series to my series panel
		   And Click on File menu   
		   And Verify download option when series selected in search panel.
@InsightGeneral
Scenario: Tc_InsightGeneral_95:Verify "Insights" menu.
		   And Click on Insights on menu header.
		   And Verify "Insights" dropdown is shown
@InsightGeneral
Scenario: Tc_InsightGeneral_96:Verify 'Favorite' on Insight menu.
		   And Click on Insights on menu header.
		   And Click on Favorites
		   And Verify 'Favorite' on Insight menu.  
@InsightGeneral
Scenario: Tc_InsightGeneral_97:Verify 'My Insights' on Insight menu
		   And Click on My Insights
		   And Verify Insight explorer pop up is shown
@InsightGeneral
Scenario: Tc_InsightGeneral_98:Verify 'Analytics' on Insight menu.
		   And Click on Analytics
		   And Verify  CEIC Gallery tab is Open 	
@InsightGeneral
Scenario: Tc_InsightGeneral_99:Verify 'Shared insights' on Insight menu.
		   And Click on Shared insights
		   And Verify 'Shared insights' tab is open	  
@InsightGeneral
Scenario: Tc_InsightGeneral_100:Verify Recent insights.
		   And Create a new insight
		   And Verify Recent insights
@InsightGeneral
Scenario: Tc_InsightGeneral_101:Verify displayed insights count for Recent insights.
           And Verify displayed insights count for Recent insights.
@InsightGeneral
Scenario: Tc_InsightGeneral_102:Verify open recent insight.
		  And Create a new insight
 	      And Click on recent insight
 	      And Verify insight open in preview mode
#@InsightGeneral
#Scenario: Tc_InsightGeneral_103:Verify 'Latest CEIC Insights'
#		   And Verify 'Latest CEIC Insights'
#   	      	   