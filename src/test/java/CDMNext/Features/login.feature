	
	Feature: Login to the application under test

  @Login
  Scenario Outline: Login functionality for Success and Failure TC'S
    Given User navigates to the CDMNext appliction
    And Enters username <username>
    And Enters password <password>
    When User clicks on "login"
    Then Application login should be <status>

    Examples: 
      | username                     | password        | status          |
      | "ceicsuresh@gmail.com"  		 | "Ceic@123"      | successful      |
      | "nadiyap@shravas.com"        | "thulasi1988"   | unsuccessful-WS |
      | "ceicsuresh@gmail.com"  		 | "ceic123"       | unsuccessful-WS |
      | "ceicsuresh1@gmail.com"      | "Ceic@123"      | unsuccessful-WS |
      | " ceicsuresh@gmail.com"      | "Ceic@123"      | successful      |
      | "ceicsuresh@gmail.com "      | "Ceic@123"      | successful      |
      | "ceicsuresh@gmail.com"  		 | " Ceic@123"     | unsuccessful-WS |
      | "ceicsuresh@gmail.com"  		 | "Ceic@123 "     | unsuccessful-WS |
      | ""                           | ""              | unsuccessful-UI |
      | ""                           | "Ceic@123"      | unsuccessful-UI |
      | "ceicsuresh@gmail.com"       | ""              | unsuccessful-UI |
