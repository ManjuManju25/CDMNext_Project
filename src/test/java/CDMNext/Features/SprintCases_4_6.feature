Feature: SprintCases_4.6 feature

  @sprint_4.6
  Scenario: TC_18480_01: Verify dynamic loading for the tables in the tree
    And Expand data table having more series

  # And Scroll down and verify auto loading series
  @sprint_4.6
  Scenario: TC_18466_01: Verify clicking on 'Customer service team' hyper link on notification
    And Open preference dropdown1
    And Share any insight to another user
    And delete insight
    And Open preference dropdown1
    And Login to User 2 account and click on notification panel
    And Click on 'Customer service team'
    Then "https://www.ceicdata.com/en/contact_us.htm" should be loaded in new browser tab

  @sprint_4.6
  Scenario: TC_190711: Verify if date is removed for FAQ of footnotes
    And Select series1
    And click on footnotes
    Then verify the title of the footnotes

  @sprint_4.6
  Scenario: TC_17657 :Copy Url
    And In database tab expand tree up section level where we multiple Tables present
    And Select any two Tables 2
    Then Click on copy link icon and select Copy selected links
