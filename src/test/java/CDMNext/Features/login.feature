Feature: Login into account 

@Login 
Scenario Outline: Login Success and Failure 
 Given User navigates to the CDMNext appliction 
 And   Enters username <username>       
 And   Enters password <password>                
 When  User clicks on "login"    
 Then  Application login should be <status>     
  
 Examples: 
	
		| username | password | status |
		| "nadiya.maduru@shravas.com" | "Thulasi@1988" | successful |  
		| "nadiyap@shravas.com" | "thulasi1988" | unsuccessful-WS |  
		| "nadiya.maduru@shravas.com" | "thulasi1988" | unsuccessful-WS | 
		| "nadiyap@shravas.com" | "Thulasi@1988" | unsuccessful-WS |
		| " nadiya.maduru@shravas.com" | "Thulasi@1988" | successful |
		| "nadiya.maduru@shravas.com " | "Thulasi@1988" | successful |
		| "nadiya.maduru@shravas.com" | " Thulasi@1988" | unsuccessful-WS |
		| "nadiya.maduru@shravas.com" | "Thulasi@1988 " | unsuccessful-WS | 
		| "" | "" | unsuccessful-UI |
		| "" | "Thulasi@1988" | unsuccessful-UI |
		|  "nadiya.maduru@shravas.com" | "" | unsuccessful-UI |
		
 
 