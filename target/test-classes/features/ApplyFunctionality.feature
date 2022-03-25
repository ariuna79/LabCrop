@labCorpTest

  Feature: Verify fuction and data on careers tab

  
  Scenario: Verify information and title on careers tab
  
  
    Given A user navigates to careers tab
    When A user is able to search any position and verify the title
    And A user successfully verify description responsibilities requirements
    And A user successfully apply for the position
    Then A user successfully verify a job title match the previous page
  