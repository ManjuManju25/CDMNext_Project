Feature: Comparing Data in Two Exel sheet 
#Background:
   #Given User has successful logged in
   
@UI
Scenario: TC_01:Verifying Date drop down for available options
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select Date drop down
    Then Automatic and Custom Date drop down should be available

@UI   
Scenario: TC_02:Verifying default decimal place
    And User Select Series ID  as "310902301"
    And Select Download button
    Then default decimal place to be as 3

@UI    
Scenario: TC_03:Verifying available range of decimal places
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select Decimal drop down
    Then decimal range should be as 0-8

@UI     
Scenario: TC_04:Verifying Adjust column and wrap text option
    And User Select Series ID  as "310902301"
    And Select Download button
    Then  Adjust column and wrap text option should be present

@UI
Scenario: TC_05:Verifying Create a chart with series is available
    And User Select Series ID  as "310902301"
    And Select Download button
    Then  Create a chart with series is available

@UI 
Scenario: TC_07:Verifying Date order option is available
    And User Select Series ID  as "310902301"
    And Select Download button
   Then  Ascending and  Descending date order radio buttons should be present

@UI    
 Scenario: TC_08:Verifying orientation option option is available
    And User Select Series ID  as "310902301"
    And Select Download button
    Then  Columns and Rows radio buttons should be present

@UI        
 Scenario: TC_10:Verifying ADD function option is available
    And User Select Series ID  as "310902301"
    And Select Download button 
    Then ADD function  button should be present

@UI 
 Scenario: TC_11:Verifying Blank Observations options is available
    And User Select Series ID  as "310902301"
    And Select Download button 
    Then Blank Observations  with THREE options should be present

@UI 
Scenario: TC_12:Verifying Ask me about Export settings options is available
    And User Select Series ID  as "310902301"
    And Select Download button 
    Then Ask me about Export settings options should be present

##@UI   
##Scenario: TC_13:Verifying confirmation messge while downloading in progress
##    #And User Select Series ID  as "310902301"
##     And User Add 3000 Series into Right panel
##    And Select Download button 
##    Then A pop message with message as The excel file is being generated.your download will start in a few seconds" should appear each time as default.

@UI 
Scenario: TC_14:Verifying default selection of attributes
    And User Select Series ID  as "310902301"
    And Select Download button 
    Then All attributes are selected and show date column is also selected by default

@UI     
Scenario: TC_15:Verifying Timeframe options 
    And User Select Series ID  as "310902301"
    And Select Download button
    Then ALL Timeframe options should be present

@UI    
 Scenario: TC_16:Verifying  default timeframe selection as 10
    And User Select Series ID  as "310902301"
    And Select Download button
   Then Sample=10 should be the default timeframe option
 
@ExelDatacomparision
Scenario: TC_19:Verifying Date format as Automic date format
      And User Select Series ID  as "310902301"
      And Select Download button	
      And Select Automic button
       #And User1 Select pop up Download button
       And Compare "TC_19" exel sheet with Actual data


#######Scenario: TC_20:Verifying Date format as Custom date format
#######     And User1 Select Series ID  as "310902301"
#######     And User1 Select Download button
########     And User1 Select Custom button	
########     And User1 Compare "TC_02" exel sheet with Actual data   
####

@ExelDatacomparision        
  Scenario Outline: TC_20:Verifying Date format as Custom date format
     And User Select Series ID  as "310902301" 
     And Select Download button
     And Select Custom button
      And  Select format input	<formatinput>
     And Compare <TC_No> exel sheet with Actual data
   
        Examples:
     
        | formatinput                    | TC_No            |  
        |"DD-MM-YY"                      | "TC_20"          | 
        |"ddd,MMM DD,YYYY"               | "TC_21"          | 
        |"D-MMM-YYYY"                    | "TC_22"          | 
         |"MM/YYYY"                       | "TC_23"          | 
        |"YYYY"                          | "TC_24"          | 
      
 @ExelDatacomparision
Scenario: TC_25:Verifying Decimal place option as 0
     And User Select Series ID  as "310902301"
     And Select Download button
    And Select Decimal input as "0"     
     And Compare "TC_25" exel sheet with Actual data

 @ExelDatacomparision      
   Scenario: TC_26:Verifying Decimal place option as 8
      And User Select Series ID  as "310902301"
      And Select Download button
      And Select Decimal input as "8"
      And Compare "TC_26" exel sheet with Actual data

@ExelDatacomparision  
Scenario: TC_27: Verifying Data order Series in column as Ascending 
      And User Select Series ID  as "310902301"
     And Select Download button
     And Select Orientation as  column
     And Select Data order as  Ascending 
     And Select the  Adjust columns as wrap text     
     And Compare "TC_27" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_28:Verifying Data order Series in Rows as Descending
       And User Select Series ID  as "310902301"
     And Select Download button
     And Select Orientation as  Rows
     And Select Data order as  Descending  
     And Compare "TC_28" exel sheet with Actual data

@ExelDatacomparision
Scenario: TC_29:Verifying Start Date and End Date
     And User Select Series ID  as "310902301"
     And get the Series name
    And Select Download button
     And Select on Range
    And Select the Start Date as "2000-01-01" and End Date "2001-01-01"
     And Compare "TC_29" exel sheet with Actual data

@ExelDatacomparision
Scenario: TC_30: Verifying Series Attributes as None
     And User Select Series ID  as "310902301"
     And Select Download button
     And deSelect Series Attributes
     And Compare "TC_30" exel sheet with Actual data

@ExelDatacomparision
Scenario: TC_31: Verifying ALL Series Attributes 
     And User Select Series ID  as "310902301"
     And Select Download button
     And Compare "TC_31" exel sheet with Actual data
     
@ExelDatacomparision
Scenario: TC_32: Verifying Output series details with Filter out dates with no observations with Selected Attributes
     And User Select Series ID  as "310902301"
     And Select Download button
     And Select Filter out dates with no observations
     And Select the Selected Attributes    
    And Compare "TC_32" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_33:Verifying Output series details with Leave as Blank with Selected Attributes
     And User Select Series ID  as "310902301"
    And Select Download button
      And Select All button
     And Select Leave as Blank
      And Select the Selected Attributes
     And Compare "TC_33" exel sheet with Actual data

@ExelDatacomparision 
    Scenario: TC_34: Verifying Output series details with  Fill with NA
     And User Select Series ID  as "310902301"
    And Select Download button
      And Select All button
     And Select Fill with NA
      And Select the Selected Attributes
     And Compare "TC_34" exel sheet with Actual data

@ExelDatacomparision 
    Scenario: TC_35: Verifying Output series details with  Fill with NA
     And User Select Series ID  as "310902301"
    And Select Download button
      And Select All button
     And Select Fill with NA
     And Compare "TC_35" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_36:Verifying Download with Automatic date format + Series in Columns + Ascending + All Attributes + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
     And Select All button
   And Select Fill with NA
   And Compare "TC_36" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_37: Verifying Download with Automatic date format + Series in Columns + Descending + All Attributes + Filter Blanks with no observation
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button	
    And Select Data order as  Descending
    And Select Filter out dates with no observations
    And Compare "TC_37" exel sheet with Actual data
    
@ExelDatacomparision    
Scenario: TC_38: Verifying Download with Automatic date format + Series in Columns + Descending + All Attributes + Filter Blanks with Leave as Blank
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
    And Select Orientation as  column
     And Select Data order as  Descending
    And Select Leave as Blank
   And Compare "TC_38" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_39:Verifying Download with Automatic date format + Series in Columns + Descending + No Attributes + Filter Blanks with no observation
     And User Select Series ID  as "310902301"
     And Select Download button
    And Select Orientation as  column
    And Select Data order as  Descending
    And Select Filter out dates with no observations
     And deSelect Series Attributes
    And Compare "TC_39" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_40:Verifying Download with Automatic date format + Series in Columns + Descending + No Attributes + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
     And Select All button
      And Select Data order as  Descending
       And deSelect Series Attributes
   And Select Fill with NA
    And Compare "TC_40" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_41:Verifying Download with Automatic date format + Series in Rows + Ascending + All Attributes +Filter Blanks with no observation
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select Orientation as  Rows
    And Select Filter out dates with no observations
    And Compare "TC_41" exel sheet with Actual data

@ExelDatacomparision 
 Scenario: TC_42:Verifying Download with Automatic date format + Series in Rows + Ascending +All Attributes + Filter Blanks with Leave as Blank
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
    And Select Orientation as  Rows
    And Select Leave as Blank
    And Compare "TC_42" exel sheet with Actual data

@ExelDatacomparision 
Scenario:  TC_43:Verifying Download with Automatic date format + Series in Rows + Ascending + All Attributes + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
    And Select Orientation as  Rows
   And Select Fill with NA
    And Compare "TC_43" exel sheet with Actual data

@ExelDatacomparision     
Scenario: TC_44: Verifying Download with Automatic date format + Series in Rows + Ascending + Selected Attributes + Filter Blanks with with no observations
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select Orientation as  Rows
    And Select Data order as  Ascending
    And Select the Selected Attributes
    And Compare "TC_44" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_45:Verifying Download with Automatic date format + Series in Rows + Descending + All Attributes + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
     And Select All button
     And Select Orientation as  Rows
     And Select Data order as  Descending
     And Select Fill with NA
    And Compare "TC_45" exel sheet with Actual data

@ExelDatacomparision     
Scenario: TC_46:Verifying Download with Automatic date format +  Series in Rows + Descending + No Attributes + Leave as Blank
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
    And Select Orientation as  Rows
    And Select Data order as  Descending
    And Select Leave as Blank
    And deSelect Series Attributes 
    And Compare "TC_46" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_47:Verifying Download with Automatic date format + Series in Rows + Descending + No Attributes + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
     And Select All button
     And Select Orientation as  Rows
     And Select Data order as  Descending
    And Select Fill with NA
    And deSelect Series Attributes   
    And Compare "TC_47" exel sheet with Actual data

@ExelDatacomparision    
 Scenario: TC_48:Verifying Download with Custom date format + Series in Columns + Ascending + All Attributes + Leave as Blank
    And User Select Series ID  as "310902301"
    And Select Download button
   And Select All button
     And Select Custom button
     And Select Custom date input as "MM-YYYY"
    And Select Leave as Blank 
    And Compare "TC_48" exel sheet with Actual data

@ExelDatacomparision     
Scenario: TC_49:Verifying Download with Custom date format + Series in Columns + Ascending + All Attributes + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
     And Select Custom button
     And Select Custom date input as "MM-YYYY"
    And Select Fill with NA
    And Compare "TC_49" exel sheet with Actual data

@ExelDatacomparision     
   Scenario: TC_50:Verifying Download with Custom date format + Series in Columns + Ascending + No Attributes + Leave as Blank 
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
     And Select Custom button
     And Select Custom date input as "MM-YYYY"
    And Select Leave as Blank
    And deSelect Series Attributes 
    And Compare "TC_50" exel sheet with Actual data

@ExelDatacomparision         
Scenario: TC_51:Verifying Download with Custom date format + Series in Columns + Ascending + Selected Attributes  + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
    And Select Custom button
    And Select Custom date input as "MM,YYYY"
    And Select Fill with NA
    And Select the Selected Attributes 
    And Compare "TC_51" exel sheet with Actual data


@ExelDatacomparision 
    Scenario: TC_52: Verifying Download with Custom date format + Series in Columns + Ascending + Selected Attributes + Leave as Blank
    And User Select Series ID  as "310902301"
     And Select Download button
     And Select All button
     And Select Custom button
     And Select Custom date input as "MM,YYYY"
     And Select Leave as Blank
     And Select the Selected Attributes
     And Compare "TC_52" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_53:Verifying Download with Custom date format + Series in Columns + Ascending + No Attributes + Fill with NA
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select All button
     And Select Custom button
     And Select Custom date input as "MM,YYYY"
    And Select Fill with NA
     And deSelect Series Attributes
    And Compare "TC_53" exel sheet with Actual data


@ExelDatacomparision
  Scenario: TC_54:Verifying the function CurrencyConversion using an unsupported currency.
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select the Function as "Convertcur" 
    And Select the Applay button
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And Select the Selected Attributes
    And Compare "TC_54" exel sheet with Actual data

@ExelDatacomparision     
Scenario: TC_55:Verifying the function Disaggregate.
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select the Function as "Disaggregate"
    And Select the Parameters
    And Select the Applay button
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And Select the Selected Attributes
    And Compare "TC_55" exel sheet with Actual data

@ExelDatacomparision    
  Scenario: TC_56: Verifying the function Natural log.
     And User Select Series ID  as "310902301"
     And Select Download button
     And Select the Function as "LOG" 
     And Select the Applay button
     And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
     And Select the Selected Attributes
     And Compare "TC_56" exel sheet with Actual data

@ExelDatacomparision 
 Scenario: TC_57:Verifying the function YTD.
     And User Select Series ID  as "310919001"
     And Select Download button
     And Select the Function as "YTD" 
     And Select the Applay button
     And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
     And Select the Selected Attributes
     And Compare "TC_57" exel sheet with Actual data

@ExelDatacomparision   
 Scenario: TC_58:Verifying the function SUM.
     And User Select Series ID  as "310902301"
     #And add Series
     And Select Download button
     And Select the Function as "SUM" 
     And Select the Applay button
     And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
     And Select the Selected Attributes
     And Compare "TC_58" exel sheet with Actual data

@ExelDatacomparision      
Scenario: TC_59: Verifying Download with no end date with Leave as Blank
     And User Select Series ID  as "310902301"
      And Select Download button
    And Select the Start Date as "01-03-2000" and End Date "No end date"
     And Select Leave as Blank
     And Select the Selected Attributes
     And Compare "TC_59" exel sheet with Actual data
    
@ExelDatacomparision
Scenario: TC_62:Verifying the Data download with wrap text format.
     And User Select Series ID  as "310902301"
     And Select Download button
     And Select the Start Date as "2000-01-01" and End Date "2004-01-01"
     And Select the  Adjust columns as wrap text
     And Select the Selected Attributes
     And Compare "TC_62" exel sheet with Actual data

@ExelDatacomparision 
Scenario: TC_63:Verifying Download Series in Columns by Selecting only Series Name 
     And User Select Series ID  as "310902301"
     And Select Download button
     And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
     And Select the Series name
     And uncheck the Date column
     And Compare "TC_63" exel sheet with Actual data

@ExelDatacomparision     
Scenario: TC_64:Verifying Download with observation 10 by Selecting only Series Name 
     And User Select Series ID  as "310902301"
     And Select Download button
     And Select the Series name
     And uncheck the Date column
     And Compare "TC_64" exel sheet with Actual data

@ExelDatacomparision    
Scenario: TC_65:Verifying Download Series in Rows with Selecting only Series name with Time frame 
     And User Select Series ID  as "310902301"
     And Select Download button
     And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
     And deSelect Series Attributes  
     And uncheck the Date column
     And Compare "TC_65" exel sheet with Actual data

@ExelDatacomparision    
Scenario: TC_66:Verifying Download Series in Rows with No End date  
     And User Select Series ID  as "310902301"
     And Select Download button
     And Select the Range 
     And Select Orientation as  Rows
     And uncheck the Date column
     And deSelect Series Attributes
     And Compare "TC_66" exel sheet with Actual data

@ExelDatacomparision    
  Scenario: TC_67:Verifying Download with applied function along with Series Name in row wise  
     And User Select Series ID  as "310907701"
     And Select Download button
     And Select Orientation as  Rows
     And Select the Function as "Accumulate" 
     And Select the Applay button
     And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
     And uncheck the Date column
     And Select the Selected Attributes
     And Compare "TC_67" exel sheet with Actual data
 
@ExelDatacomparision 
 Scenario: TC_68:Verifying Download Series in Columns- with Decimal points =4
       And User Select Series ID  as "310907701"
       And Select Download button
       And Select Decimal input-4
       And Compare "TC_68" exel sheet with Actual data
 
@ExelDatacomparision
Scenario: TC_69:Verifying Download Series in Columns- with Decimal points =4 with Date coloumn Select with No attribute
    And User Select Series ID  as "310907701"
    And Select Download button
     And Select Decimal input-4
     And deSelect Series Attributes
     And Compare "TC_69" exel sheet with Actual data
 
@ExelDatacomparision      
 Scenario: TC_70:Verifying Download by Selecting Wrap Text with Series Name in Column wise along No attribute
    And User Select Series ID  as "310907701"
    And Select Download button
    And Select the  Adjust columns as wrap text
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And Select the Series name
    And uncheck the Date column
    And Compare "TC_70" exel sheet with Actual data 
    
@ExelDatacomparision      
   Scenario: TC_71:Verifying Download by Selecting Wrap Text- with Date Column in Column wise
    And User Select Series ID  as "310907701"
    And Select Download button
    And Select the  Adjust columns as wrap text
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And Select the Series name 
    And Compare "TC_71" exel sheet with Actual data
     
@ExelDatacomparision     
   Scenario: TC_72:Verifying Download by Selecting Wrap Text without Series Name and Date Column in Row wise
    And User Select Series ID  as "310907701"
    And Select Download button
    And Select Orientation as  Rows
    And Select the  Adjust columns as wrap text
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And deSelect Series Attributes
    And uncheck the Date column
    And Compare "TC_72" exel sheet with Actual data
   
@ExelDatacomparision        
 Scenario: TC_73:Verifying Download by Selecting Only Time Points without Series Name and Date Column in Column wise - descending order
    And User Select Series ID  as "310907701"
    And Select Download button
    And Select Orientation as  Rows
    And Select Data order as  Descending
    And Select the  Adjust columns as wrap text
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And deSelect Series Attributes
    And uncheck the Date column
    And Compare "TC_73" exel sheet with Actual data
   
@ExelDatacomparision             
  Scenario: TC_74:Verifying Download by Selecting Only Time Points without Date Stamp
    And User Select Series ID  as "310907701"
    And Select Download button
    And Select Orientation as  Rows
    And Select Data order as  Descending
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And Select the Series name
    And uncheck the Date column
    And Compare "TC_74" exel sheet with Actual data
  
@ExelDatacomparision    
 Scenario: TC_75:Verifying Download by Selecting Only Time Points without Series Name and Date Stamp
    And User Select Series ID  as "310907701"
    And Select Download button
    And Select Orientation as  Rows
    And Select Data order as  Descending
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
    And deSelect Series Attributes
    And uncheck the Date column
    And Compare "TC_75" exel sheet with Actual data
   
@ExelDatacomparision     
 Scenario: TC_76:Verifying Download by Selecting Only Time Points without Series Name and Date Stamp with Fill Blank OBS with NA
    And User Select Series ID  as "310902301"
    And Select Download button
    And Select Orientation as  Rows
    And Select Data order as  Descending
    And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
     And Select Fill with NA
    And deSelect Series Attributes
    And uncheck the Date column 
    And Compare "TC_76" exel sheet with Actual data

@ExelDatacomparision     
 Scenario: TC_77:Verifying Download by Selecting Only Time Points with Series Name,Series Statistics and no Date Column in Row wise
      And User Select Series ID  as "310902301"
      And Select Download button
      And Select Orientation as  Rows
      And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
      And Select Fill with NA
     And Select Series Name and Series Statistics
     And uncheck the Date column
     And Compare "TC_77" exel sheet with Actual data
  
@ExelDatacomparision     
Scenario: TC_78:Verifying Download by Selecting Selected Attributes
      And User Select Series ID  as "310902301"
      And Select Download button
      And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
      And Select the Selected Attributes along with Series Statistics
      And uncheck the Date column
      And Compare "TC_78" exel sheet with Actual data
      
@FormatVerification  
Scenario: TC_79:Downloading data in CSV Format from Selection
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Add to Right panel
      And Select Download button
      And select the "csv" format
      Then download should be Sucess
   
@FormatVerification
 Scenario: TC_80:Downloading Table created from view tab into Excel format
       And User Select  Multiple Series ID  as "310901701;310901801;310902601"
       And Create a Table 
       And Select Download Button
       And select the "xlsx" format 
       Then Tabel download should be Sucess

@FormatVerification
 Scenario: TC_81:Downloading Map created from view tab into Excel format
       And User Select  Multiple Series ID  as "310901701;310901801;310902601"
       And Create a Map 
       And Select Download Button
       And select the "xlsx" format 
       Then Map download should be Sucess
   
@FormatVerification 
   Scenario: TC_82:Downloading Chart created from view tab into Excel format.
        And User Select  Multiple Series ID  as "310901701;310901801;310902601"
        And Create a Chart
        And Select Download Button
        And select the "xlsx" format   
        Then Chart download should be Sucess
#   
#   @FormatVerification   
# Scenario: TC_83:Downloading HeatMap created from view tab into Excel format
#       And User Select  Multiple Series ID  as "310901701;310901801;310902601"
#       And Create a HeatMap 
#       And Select Download Button
#       And select the "xlsx" format 
#       Then HeatMap download should be Sucess
   
@FormatVerification     
    Scenario: TC_84:Downloading Table created from view tab in format = "JPEG".
        And User Select  Multiple Series ID  as "310901701;310901801;310902601"
        And Create a Table
        And Select Download Button
        And select the "jpeg" format   
        Then Tabel download should be Sucess
   
@FormatVerification  
   Scenario: TC_85:Downloading Table created from view tab in format = "PNG".
       And User Select  Multiple Series ID  as "310901701;310901801;310902601"
       And Create a Table
       And Select Download Button
       And select the "png" format   
       Then Tabel download should be Sucess 
   
@FormatVerification  
    Scenario: TC_86:Downloading Chart created from view tab in format = "JPEG".
       And User Select  Multiple Series ID  as "310901701;310901801;310902601"
       And Create a Chart
       And Select Download Button
       And select the "jpeg" format   
      Then Chart download should be Sucess

@FormatVerification     
      Scenario: TC_87:Downloading Chart created from view tab in format = "PNG".
        And User Select  Multiple Series ID  as "310901701;310901801;310902601"
        And Create a Chart
        And Select Download Button
        And select the "png" format   
       Then Chart download should be Sucess
   
   
 @ExelDatacomparision      
      Scenario: TC_88:Verifying Download with specific download settings to have different date format than default.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Add to Right panel
      And Select Download button
      And Select Custom button
      And Select Custom date input as "YYYY"
      And Compare "TC_88" exel sheet with Actual data
  
  @ExelDatacomparision      
      Scenario: TC_89:Verifying Download with specific series attributes.
      And User Select  Multiple Series ID  as "310901701;310902601;310901801"
      And Add to Right panel
      And Select Download button
      And Select the Selected Attributes
      And Compare "TC_89" exel sheet with Actual data  
    
 
  @ExelDatacomparision
      Scenario: TC_90:Verifying Download with specific download settings: Date order - Descending,Orientation- rows, Show - only date column, Blank observation - Leave as blank.
      And User Select  Multiple Series ID  as "310901701;310902601;310901801"
      And Add to Right panel
      And Select Download button
      And Select Orientation as  Rows
      And Select Data order as  Descending
      And Select Leave as Blank  
     And Compare "TC_90" exel sheet with Actual data    
     
     @ExelDatacomparision     
      Scenario: TC_91:Verifying Download with Series Statistics.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
       And Add to Right panel
      And Select Download button
      And Select Orientation as  Rows
      And Select Data order as  Descending
      And Select Leave as Blank
      And Select Series Name and Series Statistics
      And Compare "TC_91" exel sheet with Actual data   

@ExelDatacomparision      
      Scenario: TC_92:Verifying Download data into excel with timeframe ALL observation.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Add to Right panel
      And Select Download button
      And Select All button
      And Compare "TC_92" exel sheet with Actual data    
      
@ExelDatacomparision   
      Scenario: TC_93:Verifying Download data into excel with timeframe Specific period.
        And User Select Series ID  as "310902301"
        And Select Download button
        And Select on Range
       And Select the Start Date as "01-03-2003" and End Date "2011-03-01"
      And Compare "TC_93" exel sheet with Actual data   
      
 @ExelDatacomparision    
      Scenario: TC_94:Verifying Download data into excel with timeframe Specific Sample as No of observation = 10.
        And User Select Series ID  as "310902301"
        And Select Download button
        And Compare "TC_94" exel sheet with Actual data   
      
      
##  @ExelDatacomparision       
##      Scenario: TC_96:Verifying Download with maximum no of series.
##        And User Add 3000 Series into Right panel
##        And Select Download button
#      #And User1 Select pop up Download button 
#        # And Compares "TC_96" exel sheet with Actual data   
       

    @UI    
      Scenario: TC_97:Verifying Reset button of download settings window.
        And User Select Series ID  as "310902301"
        And Select Download button
        And Select Orientation as  Rows
        And Select the  Adjust columns as wrap text   
        And Select on Range
        And Select the Start Date as "01-01-1997" and End Date "2006-12-31"
        And uncheck the Date column
        And deSelect Series Attributes
        And Reset button should Successfully work 
  
     
     @ExelDatacomparision
      Scenario: TC_98:Verifying Download by selecting separator.
        And User Select  Multiple Series ID  as "310901701;310901801;310902601"
        And Add to Right panel
        And select the "Separator"
      And Select Download button
     And Compare "TC_98" exel sheet with Actual data 
  

   @UI      
      Scenario: TC_99:Verifying Cancel button in the Download Window.
        And User Select Series ID  as "310902301"
       And Select Download button  
       And Sucessfully verify the Cancel button
   
  @UI    
      Scenario: TC_100:Verify Attributes Srcode exist or not.
        And User Select Series ID  as "310902301"
       And Select Download button  
       And Sucessfully verify the Srcode exist or not
         
            
@ExelDatacomparision     
       Scenario: TC_101:Apply function through the function tab Present on the My series panel.
          And User Select  Multiple Series ID  as "310901701;310901801;310902601"
         And Add to Right panel
        And Select Function button on my series panel
          And Apply Function as "Accumulate"
         And Select Download button 
      And Compare "TC_101" exel sheet with Actual data  
    
           
@ExelDatacomparision      
     Scenario: TC_102: Applay function through the function tab Present on the  download settings window.
          And User Select  Multiple Series ID  as "310901701;310901801;310902601"
         And Add to Right panel
         And Select Download button    
         And Select the Function as "Accumulate"     
         And select the Replace selected series option 
         And Select the Applay button  
       And Compare "TC_102" exel sheet with Actual data  
          
 @UI1      
     Scenario: TC_103: Verifying order of series selection to download when series selected from both search and myseries.
        And User Select Series ID  as "310902301"
        And Select series from Series and myseries
         And Select Download button    
         And series selection W.R.T both search and myseries must be Successfull
   
###@ExelDatacomparision      
###     Scenario: TC_104: Verify label for different frequency series from SSP, Tooltips, Tables, Preview and My Series.
###        And User Select Series ID  as "219555502"
###        And Verify label for different frequency series from "SSP" "Tooltips" "Tables" "Preview" and "My Series"
###         #And Select Download button    
#
            
     @UI1      
     Scenario: TC_105: verify state of download button when there are no series in myseries/no views.
        And User verify state of download button when there are no series in myseries/no views


@FormatVerification 
     Scenario: TC_110: Verify the formats available for visual download.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
        And Create a Table 
        And Select Download Button    
       And  verify the available formats 
         
 @FormatVerification      
     Scenario: TC_111: Verify the Download table visual to Excel Format.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
        And Create a Table 
        And Select Download Button
        And select the "xlsx" format 
        Then Tabel download should be Sucess   

        
 @FormatVerification  
     Scenario: TC_112: Verify the Download table visual to PNG Format.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Create a Table 
      And Select Download Button
     And select the "png" format 
     Then Tabel download should be Sucess    
  
   
   @FormatVerification       
    Scenario: TC_113: Verify the Download table visual to JPG Format.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Create a Table 
      And Select Download Button
     And select the "jpeg" format 
      Then Tabel download should be Sucess       

@FormatVerification   
     Scenario: TC_114: Verify the formats available for views download.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Create a Table 
      And Select Download Button
     And verify the formats available for views download 
     
  @FormatVerification       
     Scenario: TC_115: Verify the Download table visual to Excel Format.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Create a Table 
      And Select Download Button
     Then Tabel download should be Sucess     
    
     @FormatVerification   
   Scenario: TC_116: Verify the Download table visual to PDF Format.
      And User Select  Multiple Series ID  as "310901701;310901801;310902601"
      And Create a Table 
      And Select Download Button
      And select the "pdf" format 
     Then Tabel download should be Sucess  

     @UI  
   Scenario: TC_124: Verify whether Data referesh option is checked by deault.
      And User Select Series ID  as "310911001"
      And Select Download Button
      And Verify Data referesh option is checked by deault


    @ExelDatacomparision
   Scenario: TC_125: verify download option in right click context menu from search database tree.
      And User Search for Series ID  as "310919001"
      And Expand the database tree 
      And select the download by right click option from database tree
      And Compare "TC_125" exel sheet with Actual data

   @ExelDatacomparision
   Scenario: TC_126: verify download option in right click context menu from series tab .
      And User Select Series ID  as "310918701"
      And select the download by right click option from series tab
      And Compare "TC_126" exel sheet with Actual data  

 @ExelDatacomparision  
   Scenario: TC_127: verify download option in right click option under more option.
     And User Select Series ID  as "310918701"
      And select the download by right click option from under more option
        And Compare "TC_127" exel sheet with Actual data  
 
 
 @ExelDatacomparision
   Scenario: TC_128: verify download option in right click option under file menu option.
     And User Select Series ID  as "310918701"
      And select the download present in the File menu option
      And Compare "TC_128" exel sheet with Actual data  
     
     @ExelDatacomparision
   Scenario: TC_129: verify download option from SSP window.
     And User Select Series ID  as "310918701"
      And select the download present from SSP window
       And Compare "TC_129" exel sheet of SSP window with Actual data 

     @ExelDatacomparision
   Scenario: TC_130: verify download option from Footnotes window.
     And User Select Series ID  as "1355101"
      And select the download present from Footnotes window 
       Then Download option from Footnotes window should be Sucess   


      @ExelDatacomparision
   Scenario: TC_131: verify download option in right click context menu from Myseries Panal.
     And User Select Series ID  as "310918701"
      And select the download by right click option from Myseries Panal
      And Compare "TC_131" exel sheet with Actual data  
     
  @ExelDatacomparision
   Scenario: TC_132: verify download option in right click context menu from Myseries Panal under more option.
     And User Select Series ID  as "310918701"
      And select the download by right click option from Myseries Panal under more option
      And Compare "TC_132" exel sheet with Actual data  
     
      
   @ExelDatacomparision  
   Scenario: TC_133: verify download option in right click context menu from Myseries Panal under file menu option.
     And User Select Series ID  as "310918701"
      And select the download by right click option from Myseries Panal under under file menu option
      And Compare "TC_133" exel sheet with Actual data  
    
     @ExelDatacomparision
   Scenario: TC_134: verify download option in from SSP window under Myseries Panal.
     And User Select Series ID  as "310918701"
      And select the download from SSP window from Myseries Panal
      And Compare "TC_134" exel sheet of SSP window with Actual data 
      
      
     @ExelDatacomparision
   Scenario: TC_135:  Verify 'N ' no of obs results on different combination of multiple frequency series.(Y,S,Q,M).
         And User Select  Multiple Series ID  as "310901701;310905901;310911001;310908401"
         And Add to Right panel
        And Select Download button
         And Select with timeframe no of obs end date = "10"
      And Compare "TC_135" exel sheet with Actual data
     
    @ExelDatacomparision  
   Scenario: TC_136:  Verify 'N ' no of obs results on different combination of multiple frequency series.(Y,Q,M,W).
         And User Select  Multiple Series ID  as "310901701;310911001;310908401;310913301"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "12" 
         And Compare "TC_136" exel sheet with Actual data   
     
   @ExelDatacomparision
   Scenario: TC_137:  Verify 'N ' no of obs results on different combination of multiple frequency series.(S,Q,W,D).
         And User Select  Multiple Series ID  as "310905901;310911001;310913301;310905801"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "12"
        And Compare "TC_137" exel sheet with Actual data        
      
  @ExelDatacomparision 
   Scenario: TC_138:  Verify 'N ' no of obs results on different combination of multiple frequency series.(S,Q,M,D).
         And User Select  Multiple Series ID  as "310905901;310911001;310913301;310905801"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "14"
        And Compare "TC_138" exel sheet with Actual data    
      
   @ExelDatacomparision 
   Scenario: TC_139:  Verify 'N ' no of obs results on different combination of multiple frequency series.(Q,W,D).
         And User Select  Multiple Series ID  as "310911001;310913301;310905801"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "7"
        And Compare "TC_139" exel sheet with Actual data     
      
   @ExelDatacomparision 
   Scenario: TC_140:  Verify 'N ' no of obs results on different combination of multiple frequency series.(Q,M,W).
         And User Select  Multiple Series ID  as "310911001;310908401;310913501"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "15"
        And Compare "TC_140" exel sheet with Actual data        
    
   @ExelDatacomparision  
   Scenario: TC_141:  Verify N of obs results on different combination of multiple frequency series.(M,W,D).
         And User Select  Multiple Series ID  as "310908401;310913301;310905701"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "15"
        And Compare "TC_141" exel sheet with Actual data   
       
 @ExelDatacomparision 
   Scenario: TC_142: Verify 'N ' no of obs results on different combination of multiple frequency series.(M,D).
         And User Select  Multiple Series ID  as "310908401;310905701"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "15"
         And Compare "TC_142" exel sheet with Actual data    
       
       
@ExelDatacomparision
   Scenario: TC_143: Verify 'N ' no of obs results on different combination of multiple frequency series.(W,D).
         And User Select  Multiple Series ID  as "310913301;310905701"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "90"
       And Compare "TC_143" exel sheet with Actual data  
    
    
 @ExelDatacomparision
   Scenario: TC_144: Verify 'N ' no of obs results on  multiple different frequency series.
         And User Select  Multiple Series ID  as "310901701;310901801;310902601;310905801;310905701"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "10"
         And Compare "TC_144" exel sheet with Actual data     

@ExelDatacomparision
   Scenario: TC_145: Verify 'N ' no of obs results on  multiple same frequency series
         And User Select  Multiple Series ID  as "310901701;310901801;310902601"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "10"
         And Compare "TC_145" exel sheet with Actual data     

@ExelDatacomparision
   Scenario: TC_146: Verify 'N ' no of obs results on  multiple same frequency series
         And User Select  Multiple Series ID  as "310905801;310905701"
         And Add to Right panel
         And Select Download button
         And Select with timeframe no of obs end date = "10"
         And Compare "TC_146" exel sheet with Actual data     

 
           


         