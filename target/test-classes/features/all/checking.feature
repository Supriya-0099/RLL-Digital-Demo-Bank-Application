Feature: Search by TRN no. on the View Checking Accounts
  
  Background:
    Given I am on the sign in page
    When I enter Username and password
    Then I click on sign in button
    
Scenario: Successful search by TRN no. on the View Checking Accounts
    When I click on Checking
    When Select View Checking
    Then Validate Search box with valid TRN
    And Validate Search box with invalid TRN
    And Validate Search box with empty TRN
    And Validate Search box with TRN search with spaces